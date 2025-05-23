package com.qq.e.comm.plugin.ipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.SparseArray;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ipc.IPCBinderEntity;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class IPCModuleManager {
    private static final String TAG = "_IPCModuleManager";
    private static Handler sHandler;
    public IPCBinderEntity mBinderEntity;
    public Context mContext;
    public volatile IPCModuleFactory ipcModuleFactory = null;
    public final ConcurrentHashMap<String, IPCModule> mModuleMap = new ConcurrentHashMap<>();
    public final SparseArray<IPCResultCallback> mCallbackMap = new SparseArray<>();
    public final AtomicInteger mCallbackId = new AtomicInteger(1000);

    public IPCModuleManager(Context context) {
        this.mContext = context;
        setModuleFactory(new IPCModuleFactory() { // from class: com.qq.e.comm.plugin.ipc.IPCModuleManager.1
            @Override // com.qq.e.comm.plugin.ipc.IPCModuleFactory
            public IPCModule createModule(String str) {
                return IPCModuleManager.this.getModuleByReflection(str);
            }
        });
        this.mBinderEntity = new IPCBinderEntity.Stub() { // from class: com.qq.e.comm.plugin.ipc.IPCModuleManager.2
            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public IPCResult async(String str, final String str2, final Bundle bundle, int i3, int i16) throws RemoteException {
                final IPCModule iPCModule = IPCModuleManager.this.mModuleMap.get(str);
                if (iPCModule != null) {
                    IPCModuleManager.excuteOnAsyncThread(new Runnable() { // from class: com.qq.e.comm.plugin.ipc.IPCModuleManager.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iPCModule.onCall(str2, bundle);
                        }
                    });
                    return null;
                }
                if (IPCModuleManager.this.ipcModuleFactory != null) {
                    iPCModule = IPCModuleManager.this.ipcModuleFactory.createModule(str);
                }
                if (iPCModule != null) {
                    IPCModuleManager.this.register(iPCModule);
                    IPCModuleManager.excuteOnAsyncThread(new Runnable() { // from class: com.qq.e.comm.plugin.ipc.IPCModuleManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iPCModule.onCall(str2, bundle);
                        }
                    });
                    return null;
                }
                GDTLogger.d("callModule no found," + str + "," + str2);
                return null;
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public void callback(int i3, IPCResult iPCResult) throws RemoteException {
                synchronized (IPCModuleManager.this.mCallbackMap) {
                    IPCResultCallback iPCResultCallback = IPCModuleManager.this.mCallbackMap.get(i3);
                    GDTLogger.d("_IPCModuleManagercallback callbackId," + i3 + "," + iPCResultCallback + ", " + this + GDTADManager.getInstance().getProcessName());
                    if (iPCResultCallback != null) {
                        iPCResultCallback.onCallback(iPCResult);
                    }
                    IPCModuleManager.this.mCallbackMap.remove(i3);
                }
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public String getProcName() throws RemoteException {
                return GDTADManager.getInstance().getProcessName();
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public int setClient(String str, int i3, IPCBinderEntity iPCBinderEntity) throws RemoteException {
                return IPCModuleManager.this.setClient(str, i3, iPCBinderEntity);
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public IPCResult sync(String str, String str2, Bundle bundle, int i3) throws RemoteException {
                IPCModule iPCModule = IPCModuleManager.this.mModuleMap.get(str);
                if (iPCModule == null) {
                    if (IPCModuleManager.this.ipcModuleFactory != null) {
                        iPCModule = IPCModuleManager.this.ipcModuleFactory.createModule(str);
                    }
                    if (iPCModule != null) {
                        IPCModuleManager.this.register(iPCModule);
                        return iPCModule.onCall(str2, bundle);
                    }
                    GDTLogger.d("callModule no found," + str + "," + str2);
                    return null;
                }
                return iPCModule.onCall(str2, bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void excuteOnAsyncThread(Runnable runnable) {
        getAsyncHandler().post(runnable);
    }

    private static synchronized Handler getAsyncHandler() {
        Handler handler;
        synchronized (IPCModuleManager.class) {
            if (sHandler == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AMS-IPCModuleManagerOncall", 10);
                baseHandlerThread.start();
                sHandler = new Handler(baseHandlerThread.getLooper());
            }
            handler = sHandler;
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPCModule getModuleByReflection(String str) {
        try {
            ClassLoader pluginClassLoader = GDTADManager.getInstance().getPM().getPluginClassLoader();
            if (pluginClassLoader != null) {
                return ((IPCModuleFactory) pluginClassLoader.loadClass("com.qq.e.comm.plugin.ipc.IPCModuleFactoryImpl").newInstance()).createModule(str);
            }
            return null;
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return null;
        } catch (InstantiationException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public abstract void callbackResult(int i3, IPCResult iPCResult);

    public void register(IPCModule iPCModule) {
        if (iPCModule == null) {
            return;
        }
        iPCModule.mIPCModuleManager = this;
        if (!this.mModuleMap.contains(iPCModule)) {
            this.mModuleMap.put(iPCModule.moduleName, iPCModule);
            return;
        }
        throw new RuntimeException("Module duplicated, " + iPCModule.moduleName);
    }

    public int registerCallback(IPCResultCallback iPCResultCallback) {
        int addAndGet = this.mCallbackId.addAndGet(1);
        synchronized (this.mCallbackMap) {
            if (iPCResultCallback != null) {
                this.mCallbackMap.put(addAndGet, iPCResultCallback);
            }
        }
        return addAndGet;
    }

    public int setClient(String str, int i3, IPCBinderEntity iPCBinderEntity) throws RemoteException {
        return 0;
    }

    public void setModuleFactory(IPCModuleFactory iPCModuleFactory) {
        this.ipcModuleFactory = iPCModuleFactory;
    }

    public void unRegister(IPCModule iPCModule) {
        if (iPCModule == null) {
            return;
        }
        this.mModuleMap.remove(iPCModule.moduleName);
    }
}
