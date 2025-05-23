package eipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCClientModuleCore;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import eipc.EIPCChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes28.dex */
public abstract class EIPCModuleManager {
    public static final int INTERVAL = 1000000;
    static final String MODULE_EVENT = "__event_module";
    public static final int MSG_CALL_MODULE_AYSNC = 1;
    static Handler sHandler;
    int callbackIdStart;
    public EIPCChannel channel;
    public Context mContext;
    HashSet<EIPCOnGetConnectionListener> mListeners = new HashSet<>();
    private final SparseArray<ArrayList<WeakReference<EIPCModule>>> mCareMessageModule = new SparseArray<>();
    public SparseArray<EIPCChannel> mProcMap = new SparseArray<>();
    public final SparseArray<EIPCResultCallback> mCallbackMap = new SparseArray<>();
    public final AtomicInteger mCallbackId = new AtomicInteger(1000);
    public EIPCModuleFactory ipcModuleFactory = null;
    final ConcurrentHashMap<String, EIPCModule> mModuleMap = new ConcurrentHashMap<>();

    public EIPCModuleManager(Context context) {
        final HighFreqLogUtil highFreqLogUtil = new HighFreqLogUtil(1);
        this.mContext = context;
        this.channel = new EIPCChannel.Stub() { // from class: eipc.EIPCModuleManager.1
            private EIPCModule getEipcModule(String str) {
                EIPCModule eIPCModule;
                EIPCModuleFactory eIPCModuleFactory;
                synchronized (EIPCModuleManager.this.mModuleMap) {
                    eIPCModule = EIPCModuleManager.this.mModuleMap.get(str);
                    if (eIPCModule == null && (eIPCModuleFactory = EIPCModuleManager.this.ipcModuleFactory) != null && (eIPCModule = eIPCModuleFactory.onCreateModule(str)) != null) {
                        EIPCModuleManager.this.registerModule(eIPCModule);
                    }
                }
                return eIPCModule;
            }

            @Override // eipc.EIPCChannel
            public void async(String str, final String str2, final Bundle bundle, int i3, int i16) {
                if (QLog.isColorLevel()) {
                    QLog.d(EIPCConst.TAG, 2, "callModuleAsync ," + str + "," + str2 + "," + i3 + ", " + i16);
                }
                final int i17 = (i16 * 1000000) + i3;
                final EIPCModule eipcModule = getEipcModule(str);
                if (eipcModule != null) {
                    EIPCModuleManager.excuteOnAsyncThread(new Runnable() { // from class: eipc.EIPCModuleManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            eipcModule.onCall(str2, bundle, i17);
                        }
                    });
                    return;
                }
                if (QLog.isColorLevel()) {
                    highFreqLogUtil.w(EIPCConst.TAG, 2, "callModuleAsync not found, " + str + ", " + str2);
                }
            }

            @Override // eipc.EIPCChannel
            public void callback(int i3, EIPCResult eIPCResult) {
                synchronized (EIPCModuleManager.this.mCallbackMap) {
                    EIPCResultCallback eIPCResultCallback = EIPCModuleManager.this.mCallbackMap.get(i3);
                    if (QLog.isColorLevel()) {
                        QLog.d(EIPCConst.TAG, 2, "callback callbackId=", Integer.valueOf(i3), ", ", eIPCResultCallback, ", ", MobileQQ.processName);
                    }
                    if (eIPCResultCallback != null) {
                        eIPCResultCallback.onCallback(eIPCResult);
                    }
                    EIPCModuleManager.this.mCallbackMap.remove(i3);
                }
            }

            @Override // eipc.EIPCChannel
            public String getProcName() {
                return MobileQQ.processName;
            }

            @Override // eipc.EIPCChannel
            public int setClient(String str, int i3, EIPCChannel eIPCChannel, int i16) throws RemoteException {
                return EIPCModuleManager.this.setClient(str, i3, eIPCChannel, i16);
            }

            @Override // eipc.EIPCChannel
            public IBinder setStubBinder(int i3, IBinder iBinder) {
                return EIPCModuleManager.this.onSetStubBinder(i3, iBinder);
            }

            @Override // eipc.EIPCChannel
            public EIPCResult sync(String str, String str2, Bundle bundle, int i3) {
                if (QLog.isColorLevel() && !str.equalsIgnoreCase(QIPCClientModuleCore.NAME)) {
                    QLog.d(EIPCConst.TAG, 2, "callModule ," + str + "," + str2);
                }
                if (TextUtils.equals(EIPCModuleManager.MODULE_EVENT, str)) {
                    EIPCModuleManager.this.dispatchMsgToModule(i3, bundle);
                    return null;
                }
                EIPCModule eipcModule = getEipcModule(str);
                if (eipcModule != null) {
                    return eipcModule.onCall(str2, bundle, -1);
                }
                if (QLog.isColorLevel()) {
                    QLog.w(EIPCConst.TAG, 2, "callModule not found, " + str + ", " + str2);
                }
                return null;
            }
        };
        QLog.d(EIPCConst.TAG, 2, "getHandle: ", getAsyncHandler());
    }

    public static void excuteOnAsyncThread(Runnable runnable) {
        EIPCThreadEngine eIPCThreadEngine = QIPCClientHelper.sThreadEngine;
        if (eIPCThreadEngine != null) {
            eIPCThreadEngine.excute(runnable);
        } else {
            getAsyncHandler().post(runnable);
        }
    }

    public static synchronized Handler getAsyncHandler() {
        Handler handler;
        synchronized (EIPCModuleManager.class) {
            if (sHandler == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ipc", 10);
                baseHandlerThread.start();
                sHandler = new Handler(baseHandlerThread.getLooper());
            }
            handler = sHandler;
        }
        return handler;
    }

    @Deprecated
    public void addListener(EIPCOnGetConnectionListener eIPCOnGetConnectionListener) {
        this.mListeners.add(eIPCOnGetConnectionListener);
    }

    public abstract void callbackResult(int i3, EIPCResult eIPCResult);

    public void destroy() {
        this.mModuleMap.clear();
    }

    void dispatchMsgToModule(int i3, Bundle bundle) {
        synchronized (this.mCareMessageModule) {
            ArrayList<WeakReference<EIPCModule>> arrayList = this.mCareMessageModule.get(i3);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                EIPCModule eIPCModule = arrayList.get(size).get();
                if (eIPCModule != null) {
                    eIPCModule.onReceiveMsg(i3, bundle);
                } else {
                    arrayList.remove(size);
                }
            }
        }
    }

    public void notifyBind(EIPCConnection eIPCConnection) {
        if (QLog.isColorLevel()) {
            QLog.i(EIPCConst.TAG, 2, "connection b, " + eIPCConnection);
        }
        Iterator it = ((HashSet) this.mListeners.clone()).iterator();
        while (it.hasNext()) {
            ((EIPCOnGetConnectionListener) it.next()).onConnectBind(eIPCConnection);
        }
    }

    public void notifyUnbind(EIPCConnection eIPCConnection) {
        if (QLog.isColorLevel()) {
            QLog.i(EIPCConst.TAG, 2, "connection unbind, " + eIPCConnection);
        }
        Iterator it = ((HashSet) this.mListeners.clone()).iterator();
        while (it.hasNext()) {
            ((EIPCOnGetConnectionListener) it.next()).onConnectUnbind(eIPCConnection);
        }
    }

    public IBinder onSetStubBinder(int i3, IBinder iBinder) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int registerCallback(EIPCResultCallback eIPCResultCallback) {
        int addAndGet = this.mCallbackId.addAndGet(1);
        synchronized (this.mCallbackMap) {
            if (eIPCResultCallback != null) {
                this.mCallbackMap.put(addAndGet, eIPCResultCallback);
            }
        }
        return addAndGet;
    }

    public void registerModule(EIPCModule eIPCModule) {
        eIPCModule.mgr = this;
        synchronized (this.mModuleMap) {
            if (!this.mModuleMap.containsKey(eIPCModule.name)) {
                for (int i3 : eIPCModule.listenMessages) {
                    ArrayList<WeakReference<EIPCModule>> arrayList = this.mCareMessageModule.get(i3);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        this.mCareMessageModule.put(i3, arrayList);
                    }
                    arrayList.add(new WeakReference<>(eIPCModule));
                }
                this.mModuleMap.put(eIPCModule.name, eIPCModule);
            } else {
                throw new RuntimeException("Module duplicated, " + eIPCModule.name);
            }
        }
    }

    public void removeCallback(EIPCResultCallback eIPCResultCallback) {
        synchronized (this.mCallbackMap) {
            for (int size = this.mCallbackMap.size() - 1; size >= 0; size--) {
                if (this.mCallbackMap.valueAt(size) == eIPCResultCallback) {
                    this.mCallbackMap.removeAt(size);
                }
            }
        }
    }

    @Deprecated
    public void removeListener(EIPCOnGetConnectionListener eIPCOnGetConnectionListener) {
        this.mListeners.remove(eIPCOnGetConnectionListener);
    }

    public void sendMsgToLocalModule(int i3, Bundle bundle) {
        dispatchMsgToModule(i3, bundle);
    }

    public int setClient(String str, int i3, EIPCChannel eIPCChannel, int i16) throws RemoteException {
        return 1;
    }

    public void setModuleFactory(EIPCModuleFactory eIPCModuleFactory) {
        if (QLog.isColorLevel()) {
            QLog.d(EIPCConst.TAG, 2, "initEnvironment");
        }
        this.ipcModuleFactory = eIPCModuleFactory;
    }

    public void unRegisterModule(EIPCModule eIPCModule) {
        synchronized (this.mModuleMap) {
            this.mModuleMap.remove(eIPCModule.name);
        }
    }
}
