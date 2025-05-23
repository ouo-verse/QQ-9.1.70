package com.tencent.mtt.hippy;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.DefaultLogAdapter;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.mtt.hippy.adapter.device.DefaultDeviceAdapter;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.exception.DefaultExceptionHandler;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.executor.DefaultExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.font.DefaultFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.DefaultEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.sharedpreferences.DefaultSharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.sharedpreferences.HippySharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.soloader.DefaultSoLoaderAdapter;
import com.tencent.mtt.hippy.adapter.soloader.HippySoLoaderAdapter;
import com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.a.a;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.c;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.v8.V8;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class HippyEngine {
    private static final AtomicInteger sIdCounter = new AtomicInteger();
    private static HippyLogAdapter sLogAdapter = null;
    protected int mGroupId;
    ModuleListener mModuleListener;
    final CopyOnWriteArrayList<EngineListener> mEventListeners = new CopyOnWriteArrayList<>();
    volatile EngineState mCurrentState = EngineState.UNINIT;
    private final int mID = sIdCounter.getAndIncrement();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface BackPressHandler {
        void handleBackPress();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum BridgeTransferType {
        BRIDGE_TRANSFER_TYPE_NORMAL(0),
        BRIDGE_TRANSFER_TYPE_NIO(1);

        private final int iValue;

        BridgeTransferType(int i3) {
            this.iValue = i3;
        }

        public int value() {
            return this.iValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class EngineInitParams {
        public Context context;
        public String coreJSAssetsPath;
        public String coreJSFilePath;
        public HippyDeviceAdapter deviceAdapter;
        public IDomOperate domOperateInterceptor;
        public boolean enableTurbo;
        public HippyEngineMonitorAdapter engineMonitor;
        public HippyExceptionHandlerAdapter exceptionHandler;
        public HippyExecutorSupplierAdapter executorSupplier;
        public HippyFontScaleAdapter fontScaleAdapter;
        public HippyHttpAdapter httpAdapter;
        public HippyImageLoader imageLoader;
        public HippyBundleLoader jsPreloadAssetsPath;
        public HippyBundleLoader jsPreloadFilePath;
        public HippyLogAdapter logAdapter;
        public List<HippyAPIProvider> providers;
        public boolean runningOnTVPlatform;
        public HippySharedPreferencesAdapter sharedPreferencesAdapter;
        public HippySoLoaderAdapter soLoader;
        public HippyStorageAdapter storageAdapter;
        public HippyThirdPartyAdapter thirdPartyAdapter;
        public V8InitParams v8InitParams;
        public boolean debugMode = false;
        public String debugBundleName = "index.bundle";
        public String debugServerHost = "localhost:38989";
        public String debugComponentName = "";
        public String remoteServerUrl = "";
        public boolean enableV8Serialization = true;
        public boolean enableLog = false;
        public String codeCacheTag = "";
        public int groupId = -1;

        /* JADX INFO: Access modifiers changed from: protected */
        public void check() {
            Context context = this.context;
            if (context != null) {
                if (this.imageLoader != null) {
                    if (this.sharedPreferencesAdapter == null) {
                        this.sharedPreferencesAdapter = new DefaultSharedPreferencesAdapter(context.getApplicationContext());
                    }
                    if (this.exceptionHandler == null) {
                        this.exceptionHandler = new DefaultExceptionHandler();
                    }
                    if (this.httpAdapter == null) {
                        this.httpAdapter = new DefaultHttpAdapter();
                    }
                    if (this.executorSupplier == null) {
                        this.executorSupplier = new DefaultExecutorSupplierAdapter();
                    }
                    if (this.storageAdapter == null) {
                        this.storageAdapter = new DefaultStorageAdapter(this.context.getApplicationContext(), this.executorSupplier.getDBExecutor());
                    }
                    if (this.engineMonitor == null) {
                        this.engineMonitor = new DefaultEngineMonitorAdapter();
                    }
                    if (this.fontScaleAdapter == null) {
                        this.fontScaleAdapter = new DefaultFontScaleAdapter();
                    }
                    if (this.soLoader == null) {
                        this.soLoader = new DefaultSoLoaderAdapter();
                    }
                    if (this.deviceAdapter == null) {
                        this.deviceAdapter = new DefaultDeviceAdapter();
                    }
                    if (this.logAdapter == null) {
                        this.logAdapter = new DefaultLogAdapter();
                    }
                    if (this.providers == null) {
                        this.providers = new ArrayList();
                    }
                    this.providers.add(0, new c());
                    if (!this.debugMode && TextUtils.isEmpty(this.coreJSAssetsPath) && TextUtils.isEmpty(this.coreJSFilePath)) {
                        throw new RuntimeException("Hippy: debugMode=true, initParams.coreJSAssetsPath and coreJSFilePath both null!");
                    }
                    return;
                }
                throw new IllegalArgumentException(EngineInitParams.class.getName() + " imageLoader must not be null!");
            }
            throw new IllegalArgumentException(EngineInitParams.class.getName() + " context must not be null!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum EngineInitStatus {
        STATUS_OK(0),
        STATUS_ERR_BRIDGE(-101),
        STATUS_ERR_DEVSERVER(-102),
        STATUS_WRONG_STATE(-103),
        STATUS_INIT_EXCEPTION(-104);

        private final int iValue;

        EngineInitStatus(int i3) {
            this.iValue = i3;
        }

        public int value() {
            return this.iValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface EngineListener {
        void onInitialized(EngineInitStatus engineInitStatus, String str);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum EngineState {
        UNINIT,
        INITING,
        ONRESTART,
        INITERRORED,
        INITED,
        DESTROYED
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface ModuleListener {
        boolean onJsException(HippyJsException hippyJsException);

        void onLoadCompleted(ModuleLoadStatus moduleLoadStatus, String str, HippyRootView hippyRootView);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ModuleLoadParams {

        @Deprecated
        public HippyBundleLoader bundleLoader;
        public String codeCacheTag;
        public String componentName;
        public Context context;
        public HippyInstanceContext hippyContext;
        public String jsAssetsPath;
        public String jsFilePath;
        public HippyMap jsParams;
        public Map<String, Object> nativeParams;

        public ModuleLoadParams() {
            this.codeCacheTag = "";
        }

        public ModuleLoadParams(ModuleLoadParams moduleLoadParams) {
            this.codeCacheTag = "";
            this.context = moduleLoadParams.context;
            this.jsAssetsPath = moduleLoadParams.jsAssetsPath;
            this.jsFilePath = moduleLoadParams.jsFilePath;
            this.componentName = moduleLoadParams.componentName;
            this.jsParams = moduleLoadParams.jsParams;
            this.nativeParams = moduleLoadParams.nativeParams;
            this.hippyContext = moduleLoadParams.hippyContext;
            this.codeCacheTag = moduleLoadParams.codeCacheTag;
            this.bundleLoader = moduleLoadParams.bundleLoader;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum ModuleLoadStatus {
        STATUS_OK(0),
        STATUS_ENGINE_UNINIT(-201),
        STATUS_VARIABLE_NULL(-202),
        STATUS_ERR_RUN_BUNDLE(-203),
        STATUS_REPEAT_LOAD(-204);

        private final int iValue;

        ModuleLoadStatus(int i3) {
            this.iValue = i3;
        }

        public int value() {
            return this.iValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class V8InitParams {
        public long initialHeapSize;
        public long maximumHeapSize;
    }

    public static HippyEngine create(EngineInitParams engineInitParams) {
        HippyLogAdapter hippyLogAdapter;
        if (engineInitParams != null) {
            a.a(engineInitParams.soLoader);
            if (sLogAdapter == null && (hippyLogAdapter = engineInitParams.logAdapter) != null) {
                setNativeLogHandler(hippyLogAdapter);
            }
            ContextHolder.initAppContext(engineInitParams.context);
            engineInitParams.check();
            LogUtils.enableDebugLog(engineInitParams.enableLog);
            if (engineInitParams.groupId == -1) {
                return new HippyNormalEngineManager(engineInitParams, null);
            }
            return new HippySingleThreadEngineManager(engineInitParams, null);
        }
        throw new RuntimeException("Hippy: initParams must no be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listenInUIThread(EngineListener engineListener) {
        EngineInitStatus engineInitStatus;
        String str;
        if (this.mCurrentState == EngineState.INITED) {
            engineInitStatus = EngineInitStatus.STATUS_OK;
            str = null;
        } else {
            if (this.mCurrentState != EngineState.INITERRORED && this.mCurrentState != EngineState.DESTROYED) {
                this.mEventListeners.add(engineListener);
                return;
            }
            engineInitStatus = EngineInitStatus.STATUS_WRONG_STATE;
            str = "engine state=" + this.mCurrentState;
        }
        engineListener.onInitialized(engineInitStatus, str);
    }

    private static native void setNativeLogHandler(HippyLogAdapter hippyLogAdapter);

    public abstract void destroyEngine();

    public abstract void destroyInstanceState(HippyRootView hippyRootView);

    public abstract void destroyModule(HippyRootView hippyRootView);

    public abstract HippyEngineContext getEngineContext();

    public EngineState getEngineState() {
        return this.mCurrentState;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public int getId() {
        return this.mID;
    }

    public abstract V8 getV8();

    public abstract void initEngine(EngineListener engineListener);

    public abstract boolean isDebugMode();

    /* JADX INFO: Access modifiers changed from: protected */
    public void listen(final EngineListener engineListener) {
        if (UIThreadUtils.isOnUiThread()) {
            listenInUIThread(engineListener);
        } else {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    HippyEngine.this.listenInUIThread(engineListener);
                }
            });
        }
    }

    public abstract HippyRootView loadModule(ModuleLoadParams moduleLoadParams);

    public abstract HippyRootView loadModule(ModuleLoadParams moduleLoadParams, ModuleListener moduleListener);

    public abstract HippyRootView loadModule(ModuleLoadParams moduleLoadParams, ModuleListener moduleListener, HippyRootView.OnLoadCompleteListener onLoadCompleteListener);

    public abstract boolean onBackPressed(BackPressHandler backPressHandler);

    public abstract void onEnginePause();

    public abstract void onEngineResume();

    public abstract void onFontChanged(int i3);

    public abstract void preloadModule(HippyBundleLoader hippyBundleLoader);

    public abstract HippyRootView restoreInstanceState(ArrayList<DomNodeRecord> arrayList, ModuleLoadParams moduleLoadParams, boolean z16);

    public abstract void runScript(@NonNull String str);

    public abstract void saveInstanceState();

    public abstract void saveInstanceState(Object obj);

    public abstract void sendEvent(String str, Object obj);

    public abstract void sendEvent(String str, Object obj, BridgeTransferType bridgeTransferType);
}
