package com.tencent.mtt.hippy.modules;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.bridge.HippyCallNativeParams;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModuleInvocationHandler;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyModuleManagerImpl implements Handler.Callback, HippyModuleManager {
    private static final int MSG_CODE_CALL_NATIVES = 1;
    private static final int MSG_CODE_DESTROY_MODULE = 2;
    private volatile Handler mBridgeThreadHandler;
    private final HippyEngineContext mContext;
    private volatile Handler mDomThreadHandler;
    private volatile Handler mUIThreadHandler;
    private boolean isDestroyed = false;
    private final ConcurrentHashMap<String, HippyNativeModuleInfo> mNativeModuleInfo = new ConcurrentHashMap<>();
    private final HashMap<Class<? extends HippyJavaScriptModule>, HippyJavaScriptModule> mJsModules = new HashMap<>();

    public HippyModuleManagerImpl(HippyEngineContext hippyEngineContext, List<HippyAPIProvider> list) {
        this.mContext = hippyEngineContext;
        addModules(list);
    }

    private Handler getBridgeThreadHandler() {
        if (this.mBridgeThreadHandler == null) {
            synchronized (HippyModuleManagerImpl.class) {
                if (this.mBridgeThreadHandler == null) {
                    this.mBridgeThreadHandler = new Handler(this.mContext.getThreadExecutor().getJsBridgeThread().getLooper(), this);
                }
            }
        }
        return this.mBridgeThreadHandler;
    }

    private Handler getDomThreadHandler() {
        if (this.mDomThreadHandler == null) {
            synchronized (HippyModuleManagerImpl.class) {
                if (this.mDomThreadHandler == null) {
                    this.mDomThreadHandler = new Handler(this.mContext.getThreadExecutor().getDomThread().getLooper(), this);
                }
            }
        }
        return this.mDomThreadHandler;
    }

    private String getJavaScriptModuleName(Class cls) {
        String simpleName = cls.getSimpleName();
        int lastIndexOf = simpleName.lastIndexOf(36);
        if (lastIndexOf != -1) {
            return simpleName.substring(lastIndexOf + 1);
        }
        return simpleName;
    }

    private Handler getUIThreadHandler() {
        if (this.mUIThreadHandler == null) {
            synchronized (HippyModuleManagerImpl.class) {
                if (this.mUIThreadHandler == null) {
                    this.mUIThreadHandler = new Handler(Looper.getMainLooper(), this);
                }
            }
        }
        return this.mUIThreadHandler;
    }

    private void onCallNativeFinished(@Nullable HippyCallNativeParams hippyCallNativeParams) {
        HippyEngineMonitorAdapter engineMonitorAdapter = this.mContext.getGlobalConfigs().getEngineMonitorAdapter();
        if (engineMonitorAdapter != null && hippyCallNativeParams != null) {
            engineMonitorAdapter.onCallNativeFinished(this.mContext.getComponentName(), hippyCallNativeParams);
        }
    }

    private boolean onInterceptCallNative(@Nullable HippyCallNativeParams hippyCallNativeParams) {
        HippyEngineMonitorAdapter engineMonitorAdapter = this.mContext.getGlobalConfigs().getEngineMonitorAdapter();
        if (engineMonitorAdapter != null && hippyCallNativeParams != null) {
            return engineMonitorAdapter.onInterceptCallNative(this.mContext.getComponentName(), hippyCallNativeParams);
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.modules.HippyModuleManager
    public synchronized void addModules(List<HippyAPIProvider> list) {
        if (list == null) {
            return;
        }
        for (HippyAPIProvider hippyAPIProvider : list) {
            Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> nativeModules = hippyAPIProvider.getNativeModules(this.mContext);
            if (nativeModules != null && nativeModules.size() > 0) {
                for (Class<? extends HippyNativeModuleBase> cls : nativeModules.keySet()) {
                    addNativeModule(cls, nativeModules.get(cls));
                }
            }
            List<Class<? extends HippyJavaScriptModule>> javaScriptModules = hippyAPIProvider.getJavaScriptModules();
            if (javaScriptModules != null && javaScriptModules.size() > 0) {
                for (Class<? extends HippyJavaScriptModule> cls2 : javaScriptModules) {
                    String javaScriptModuleName = getJavaScriptModuleName(cls2);
                    if (!this.mJsModules.containsKey(javaScriptModuleName)) {
                        this.mJsModules.put(cls2, null);
                    } else {
                        throw new RuntimeException("There is already a javascript module named : " + javaScriptModuleName);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mtt.hippy.modules.HippyModuleManager
    public synchronized <T extends HippyNativeModuleBase> void addNativeModule(Class<T> cls, Provider<T> provider) {
        if (provider == null) {
            return;
        }
        HippyNativeModuleInfo hippyNativeModuleInfo = new HippyNativeModuleInfo(cls, provider);
        String[] names = hippyNativeModuleInfo.getNames();
        if (names != null && names.length > 0) {
            for (String str : names) {
                if (!this.mNativeModuleInfo.containsKey(str)) {
                    this.mNativeModuleInfo.put(str, hippyNativeModuleInfo);
                }
            }
        }
        if (!this.mNativeModuleInfo.containsKey(hippyNativeModuleInfo.getName())) {
            this.mNativeModuleInfo.put(hippyNativeModuleInfo.getName(), hippyNativeModuleInfo);
        }
    }

    @Override // com.tencent.mtt.hippy.modules.HippyModuleManager
    public void callNatives(HippyCallNativeParams hippyCallNativeParams) {
        Handler bridgeThreadHandler;
        if (this.isDestroyed) {
            return;
        }
        HippyNativeModuleInfo hippyNativeModuleInfo = this.mNativeModuleInfo.get(hippyCallNativeParams.moduleName);
        if (hippyNativeModuleInfo == null) {
            new PromiseImpl(this.mContext, hippyCallNativeParams.moduleName, hippyCallNativeParams.moduleFunc, hippyCallNativeParams.callId).doCallback(1, "module can not be found");
            return;
        }
        if (hippyNativeModuleInfo.getThread() == HippyNativeModule.Thread.DOM) {
            bridgeThreadHandler = getDomThreadHandler();
        } else if (hippyNativeModuleInfo.getThread() == HippyNativeModule.Thread.MAIN) {
            bridgeThreadHandler = getUIThreadHandler();
        } else {
            bridgeThreadHandler = getBridgeThreadHandler();
        }
        bridgeThreadHandler.sendMessage(bridgeThreadHandler.obtainMessage(1, hippyCallNativeParams));
    }

    @Override // com.tencent.mtt.hippy.modules.HippyModuleManager
    public void destroy() {
        HippyNativeModuleInfo value;
        Message obtainMessage;
        Handler handler;
        if (this.mBridgeThreadHandler != null) {
            this.mBridgeThreadHandler.removeMessages(1);
        }
        if (this.mDomThreadHandler != null) {
            this.mDomThreadHandler.removeMessages(1);
        }
        if (this.mUIThreadHandler != null) {
            this.mUIThreadHandler.removeMessages(1);
        }
        this.isDestroyed = true;
        for (Map.Entry<String, HippyNativeModuleInfo> entry : this.mNativeModuleInfo.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.shouldDestroy()) {
                value.onDestroy();
                if (value.getThread() == HippyNativeModule.Thread.DOM) {
                    if (this.mDomThreadHandler != null) {
                        obtainMessage = this.mDomThreadHandler.obtainMessage(2, value);
                        handler = this.mDomThreadHandler;
                        handler.sendMessage(obtainMessage);
                    }
                } else if (value.getThread() == HippyNativeModule.Thread.MAIN) {
                    if (this.mUIThreadHandler != null) {
                        obtainMessage = this.mUIThreadHandler.obtainMessage(2, value);
                        handler = this.mUIThreadHandler;
                        handler.sendMessage(obtainMessage);
                    }
                } else if (this.mBridgeThreadHandler != null) {
                    obtainMessage = this.mBridgeThreadHandler.obtainMessage(2, value);
                    handler = this.mBridgeThreadHandler;
                    handler.sendMessage(obtainMessage);
                }
            }
        }
        this.mNativeModuleInfo.clear();
    }

    void doCallNatives(@NonNull HippyCallNativeParams hippyCallNativeParams) {
        PromiseImpl promiseImpl = new PromiseImpl(this.mContext, hippyCallNativeParams.moduleName, hippyCallNativeParams.moduleFunc, hippyCallNativeParams.callId);
        try {
            HippyNativeModuleInfo hippyNativeModuleInfo = this.mNativeModuleInfo.get(hippyCallNativeParams.moduleName);
            if (hippyNativeModuleInfo == null) {
                promiseImpl.doCallback(1, "module can not be found");
                return;
            }
            hippyNativeModuleInfo.initialize();
            HippyNativeModuleInfo.HippyNativeMethod findMethod = hippyNativeModuleInfo.findMethod(hippyCallNativeParams.moduleFunc);
            if (findMethod != null && !findMethod.isSync()) {
                findMethod.invoke(hippyNativeModuleInfo.getInstance(), hippyCallNativeParams.params, promiseImpl);
                return;
            }
            promiseImpl.doCallback(1, "module function can not be found");
        } catch (Throwable th5) {
            promiseImpl.doCallback(1, th5.getMessage());
            this.mContext.getGlobalConfigs().getExceptionHandler().handleNativeException(new RuntimeException(th5), true);
        }
    }

    @Override // com.tencent.mtt.hippy.modules.HippyModuleManager
    public synchronized <T extends HippyJavaScriptModule> T getJavaScriptModule(Class<T> cls) {
        T t16 = (T) this.mJsModules.get(cls);
        if (t16 != null) {
            return t16;
        }
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return null;
        }
        T t17 = (T) Proxy.newProxyInstance(classLoader, new Class[]{cls}, new HippyJavaScriptModuleInvocationHandler(this.mContext, getJavaScriptModuleName(cls)));
        this.mJsModules.remove(cls);
        this.mJsModules.put(cls, t17);
        return t17;
    }

    @Override // com.tencent.mtt.hippy.modules.HippyModuleManager
    @Nullable
    public HippyNativeModuleInfo getModuleInfo(@NonNull String str) {
        return this.mNativeModuleInfo.get(str);
    }

    @Override // com.tencent.mtt.hippy.modules.HippyModuleManager
    public synchronized <T extends HippyNativeModuleBase> T getNativeModule(Class<T> cls) {
        HippyNativeModule hippyNativeModule = (HippyNativeModule) cls.getAnnotation(HippyNativeModule.class);
        if (hippyNativeModule != null) {
            HippyNativeModuleInfo hippyNativeModuleInfo = this.mNativeModuleInfo.get(hippyNativeModule.name());
            if (hippyNativeModuleInfo != null) {
                return (T) hippyNativeModuleInfo.getInstance();
            }
        }
        return null;
    }

    public ConcurrentHashMap<String, HippyNativeModuleInfo> getNativeModuleInfo() {
        return this.mNativeModuleInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        return true;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        Throwable th5;
        HippyCallNativeParams hippyCallNativeParams;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            try {
                ((HippyNativeModuleInfo) message.obj).destroy();
            } catch (Throwable th6) {
                LogUtils.d("HippyModuleManagerImpl", "handleMessage: " + th6.getMessage());
            }
            return true;
        }
        try {
            hippyCallNativeParams = (HippyCallNativeParams) message.obj;
        } catch (Throwable th7) {
            th5 = th7;
            hippyCallNativeParams = null;
        }
        try {
            if (!onInterceptCallNative(hippyCallNativeParams)) {
                doCallNatives(hippyCallNativeParams);
            }
            onCallNativeFinished(hippyCallNativeParams);
        } catch (Throwable th8) {
            th5 = th8;
            try {
                th5.printStackTrace();
            } finally {
                onCallNativeFinished(hippyCallNativeParams);
                if (hippyCallNativeParams != null) {
                    hippyCallNativeParams.onDispose();
                }
            }
        }
    }
}
