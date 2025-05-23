package com.tencent.qqmini.v8rt.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.v8rt.anno.CallByNative;
import com.tencent.qqmini.v8rt.anno.NotNull;
import com.tencent.qqmini.v8rt.debug.WebSocketServerInspectAgent;
import com.tencent.qqmini.v8rt.engine.IInspectorAgent;
import com.tencent.qqmini.v8rt.engine.V8TimerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Engine {
    public static final String ENGINE_ASSETS = "tv8rt";
    public static final int ENG_INIT_ERR = 100;
    public static final int ENG_INIT_ERR_LOAD_SO = 101;
    public static final int ENG_INIT_STATUS_OK = 0;
    public static final int ENG_INIT_STATUS_RELEASED = 1;
    public static final int ENG_INIT_STATUS_UNKNOWN = -1;
    public static final int ENG_NDK_INIT = 102;
    public static final String TAG = "TV8ENG";
    static InspectorBridge sInspectorBridge;
    private static Engine sInstance;
    private static Executor sIoExecutor;
    private V8JsRuntime mDefaultJsRuntime;
    private LibLoader mLibLoader;
    private V8TimerThread mV8TimerThread;
    public int mInitStatus = -1;
    public Context mContext = null;
    public EnginePathProvider mEnginePathProvider = null;
    private Map<Integer, V8JsRuntime> mV8RuntimeMap = new ConcurrentHashMap();
    public boolean mIsEnableCodeCache = true;
    private boolean isEnableDebugger = false;
    private boolean isWaitForDebugger = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static final class InspectorBridge {

        @CallByNative
        private final boolean isWaitForDebugger;
        private final IInspectorAgent mProxy;

        @CallByNative
        private final long nativeInstance;

        private native long nativeCreate();

        private void sendMessageToDebugger(@NotNull String str) {
            try {
                this.mProxy.sendMessageToDebugger(str);
            } catch (Throwable th5) {
                Logger.e(Engine.TAG, "sendMessageToDebugger", th5);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static native void sendMessageToEngine(long j3, String str);

        public IInspectorAgent getInspectorAgent() {
            return this.mProxy;
        }

        InspectorBridge(IInspectorAgent iInspectorAgent) {
            this.mProxy = iInspectorAgent;
            this.nativeInstance = nativeCreate();
            this.isWaitForDebugger = iInspectorAgent.isWaitForDebugger();
            iInspectorAgent.setOnDebuggerMessageListener(new IInspectorAgent.IDebuggerMessageListener() { // from class: com.tencent.qqmini.v8rt.engine.Engine.InspectorBridge.1
                @Override // com.tencent.qqmini.v8rt.engine.IInspectorAgent.IDebuggerMessageListener
                public void sendMessageToEngine(@NotNull String str) {
                    InspectorBridge.sendMessageToEngine(InspectorBridge.this.nativeInstance, str);
                }
            });
        }
    }

    private void createApp() {
        long uptimeMillis = SystemClock.g().uptimeMillis();
        nativeInit(2500);
        this.mEnginePathProvider.copyEngineAssets("tv8rt", true);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        V8TimerThread v8TimerThread = new V8TimerThread(new V8TimerThread.IListener() { // from class: com.tencent.qqmini.v8rt.engine.Engine.1
            @Override // com.tencent.qqmini.v8rt.engine.V8TimerThread.IListener
            public boolean onPrepare() {
                countDownLatch.countDown();
                return false;
            }

            @Override // com.tencent.qqmini.v8rt.engine.V8TimerThread.IListener
            public void onExit() {
            }
        });
        this.mV8TimerThread = v8TimerThread;
        v8TimerThread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        Logger.i(TAG, "injectJS BaseLib cost time:" + (SystemClock.g().uptimeMillis() - uptimeMillis) + "ms");
    }

    @CallByNative
    public static String getEngineJsPath(String str) {
        Logger.i(TAG, "getEngineJsPath " + str);
        return getInstance().mEnginePathProvider.getEngineJSDir() + File.separator + str;
    }

    public static Engine getInstance() {
        if (sInstance == null) {
            synchronized (Engine.class) {
                if (sInstance == null) {
                    sInstance = new Engine();
                }
            }
        }
        return sInstance;
    }

    public static Executor getIoExecutor() {
        if (sIoExecutor == null) {
            sIoExecutor = ProxyExecutors.newSingleThreadExecutor();
        }
        return sIoExecutor;
    }

    @CallByNative
    public static void handleJavaScriptException(byte[] bArr) {
        if (bArr != null) {
            Logger.e("Log", "js exception:\n" + new String(bArr));
        }
    }

    public static int loadScriptPathWithCodeCache(int i3, int i16, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return nativeLoadScriptPathWithCodeCache(i3, i16, str, str2, str3);
        }
        throw new IllegalStateException("all parameter must not be null or empty");
    }

    public static int loadScriptStringWithCodeCache(int i3, int i16, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return nativeLoadScriptStringWithCodeCache(i3, i16, str, str2, str3);
        }
        throw new IllegalStateException("all parameter must not be null or empty");
    }

    public static native int nativeCreateScriptEngine(InspectorBridge inspectorBridge);

    public static native void nativeDispose();

    public static native boolean nativeEnvInit();

    public static native void nativeFinalize();

    public static native String nativeGetVersion();

    public static native void nativeInit(int i3);

    public static native boolean nativeInjectConsole(int i3, int i16);

    public static native boolean nativeInjectJsBridge(int i3, int i16);

    public static native boolean nativeInjectJsWorker(int i3, int i16);

    public static native boolean nativeInjectNativeBuffer(int i3, int i16);

    public static native boolean nativeInjectTimer(int i3, int i16);

    public static native int nativeLoadScriptPathWithCodeCache(int i3, int i16, @NotNull String str, @NotNull String str2, @NotNull String str3);

    public static native int nativeLoadScriptStringWithCodeCache(int i3, int i16, @NotNull String str, @NotNull String str2, @NotNull String str3);

    public static native long nativeOnVSync(long j3);

    public static native void nativeSaveScriptCodeCache();

    @CallByNative
    public static String onScriptCall(byte[] bArr, byte[] bArr2, int i3, int i16) {
        return V8JsBridge.onScriptCall(new String(bArr), new String(bArr2), i3, i16);
    }

    @CallByNative
    public static String onScriptPublish(byte[] bArr, byte[] bArr2, byte[] bArr3, int i3) {
        return V8JsBridge.onScriptPublish(new String(bArr), new String(bArr2), new String(bArr3), i3);
    }

    @CallByNative
    public static int onWorkerCreate(byte[] bArr, int i3) {
        String str = new String(bArr);
        Logger.d(TAG, "onWorkerCreate :" + str);
        return V8JsBridge.onWorkerCreate(str, i3);
    }

    @CallByNative
    public static void onWorkerPostMsgToAppService(byte[] bArr, int i3) {
        String str = new String(bArr);
        Logger.d(TAG, "onWorkerPostMsgToAppService :" + str);
        V8JsBridge.onWorkerPostMsgToAppService(str, i3);
    }

    @CallByNative
    public static void onWorkerPostMsgToWorker(int i3, byte[] bArr, int i16) {
        String str = new String(bArr);
        Logger.d(TAG, "onWorkerPostMsgToWorker :" + str);
        V8JsBridge.onWorkerPostMsgToWorker(i3, str, i16);
    }

    @CallByNative
    public static void onWorkerTerminate(int i3, int i16) {
        Logger.d(TAG, "onWorkerTerminate :" + i3);
        V8JsBridge.onWorkerTerminate(i3, i16);
    }

    public static native boolean runLoop();

    public static void setIoExecutor(Executor executor) {
        if (sIoExecutor != null) {
            Logger.i(TAG, "setIoExecutor " + executor);
        }
        sIoExecutor = executor;
    }

    public static native void stopLoop();

    public synchronized V8JsRuntime createJsRuntime() {
        IInspectorAgent iInspectorAgent = null;
        byte b16 = 0;
        if (this.mInitStatus != 0) {
            Logger.e(TAG, "createJsRuntime failed!" + this.mInitStatus);
            return null;
        }
        if (this.isEnableDebugger && sInspectorBridge == null) {
            sInspectorBridge = new InspectorBridge(new WebSocketServerInspectAgent(this.isWaitForDebugger));
        }
        Logger.i(TAG, "debuggerOption:" + this.isEnableDebugger + "," + this.isWaitForDebugger);
        int nativeCreateScriptEngine = nativeCreateScriptEngine(sInspectorBridge);
        InspectorBridge inspectorBridge = sInspectorBridge;
        if (inspectorBridge != null) {
            iInspectorAgent = inspectorBridge.getInspectorAgent();
        }
        V8JsRuntime v8JsRuntime = new V8JsRuntime(nativeCreateScriptEngine, iInspectorAgent);
        JsRuntimeLoader.initDefaultContext(this.mEnginePathProvider, v8JsRuntime.getDefaultContext());
        this.mV8RuntimeMap.put(Integer.valueOf(nativeCreateScriptEngine), v8JsRuntime);
        return v8JsRuntime;
    }

    public synchronized V8JsRuntime getJsRuntime() {
        if (this.mDefaultJsRuntime == null) {
            this.mDefaultJsRuntime = createJsRuntime();
        }
        return this.mDefaultJsRuntime;
    }

    public int getStatus() {
        return this.mInitStatus;
    }

    public Engine initEngine(Context context) {
        boolean z16;
        synchronized (this) {
            if (this.mInitStatus == 0) {
                return this;
            }
            this.mContext = context;
            this.mEnginePathProvider = new EnginePathProvider(context);
            if (this.mLibLoader != null) {
                Logger.e(TAG, "initEngine using libLoader " + this.mLibLoader);
                z16 = this.mLibLoader.loadSo();
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.e(TAG, "loadso by default loader ");
                DefaultSoLoader defaultSoLoader = new DefaultSoLoader();
                this.mLibLoader = defaultSoLoader;
                z16 = defaultSoLoader.loadSo();
            }
            if (!z16) {
                Logger.e(TAG, "initEngine loadSo fail!");
                this.mInitStatus = 101;
                return this;
            }
            Logger.i(TAG, "initEngine version : " + nativeGetVersion());
            if (!nativeEnvInit()) {
                Logger.e(TAG, "initEngine nativeEnvInit fail!");
                this.mInitStatus = 102;
                return this;
            }
            createApp();
            this.mInitStatus = 0;
            return this;
        }
    }

    public void release() {
        this.mInitStatus = 1;
    }

    public void removeJsRuntime(V8JsRuntime v8JsRuntime) {
        this.mV8RuntimeMap.remove(Integer.valueOf(v8JsRuntime.getId()));
    }

    public void saveScriptCodeCache() {
        if (this.mIsEnableCodeCache) {
            getIoExecutor().execute(new Runnable() { // from class: com.tencent.qqmini.v8rt.engine.Engine.2
                @Override // java.lang.Runnable
                public void run() {
                    Engine.nativeSaveScriptCodeCache();
                }
            });
        }
    }

    public void setDebuggerOption(boolean z16, boolean z17) {
        this.isEnableDebugger = z16;
        this.isWaitForDebugger = z17;
        Logger.i(TAG, "setDebuggerOption:" + z16 + "," + z17);
    }

    public void setLibLoader(LibLoader libLoader) {
        this.mLibLoader = libLoader;
    }

    public V8JsRuntime getJsRuntime(int i3) {
        return this.mV8RuntimeMap.get(Integer.valueOf(i3));
    }
}
