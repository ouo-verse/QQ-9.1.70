package com.tencent.ams.dsdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine;
import com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKEngineManager {
    static IPatchRedirector $redirector_ = null;
    private static final long DEFAULT_DELAY = 1000;
    private static final String TAG = "DKEngineManager";
    private static final ConcurrentHashMap<String, DKEnginWrapper> sEngineCache;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DKEnginWrapper {
        static IPatchRedirector $redirector_;
        public DKEngine engine;
        public int errorCode;
        public EngineParams params;
        public int status;

        public DKEnginWrapper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.status = 0;
            }
        }

        public DKEnginWrapper copy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DKEnginWrapper) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            DKEnginWrapper dKEnginWrapper = new DKEnginWrapper();
            dKEnginWrapper.engine = this.engine;
            dKEnginWrapper.params = this.params;
            dKEnginWrapper.status = this.status;
            dKEnginWrapper.errorCode = this.errorCode;
            return dKEnginWrapper;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface EngineCreateListener {
        void onEngineCreateFailed(int i3);

        void onEngineCreated(DKEngine dKEngine);

        void onWillCreateEngine(DKEngine dKEngine);
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface EngineInitState {
        public static final int STATE_IDLE = 0;
        public static final int STATE_INIT_FAIL = 2;
        public static final int STATE_INIT_RUNNING = 1;
        public static final int STATE_INIT_SUCCESS = 3;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class EngineParams {
        static IPatchRedirector $redirector_;

        @DKEngine.DKAdType
        public String adType;
        public Context context;
        public String debugServer;
        public String dependsVersion;
        public EngineCreateListener engineCreateListener;
        public DKEventCenter.EngineType engineType;
        public Map<String, String> extra;
        public boolean isDebugMode;

        @DKEngine.DKModuleID
        public String moduleId;
        public String orderInfo;
        public String templateId;

        public EngineParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "EngineParams{moduleId='" + this.moduleId + "', orderInfo='" + this.orderInfo + "', engineType=" + this.engineType + ", templateId='" + this.templateId + "', dependsVersion='" + this.dependsVersion + "', adType='" + this.adType + "', extra=" + this.extra + ", context=" + this.context + ", isDebugMode=" + this.isDebugMode + ", debugServer='" + this.debugServer + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
        public static final int BUNDLE_ERROR = 4;
        public static final int BUNDLE_NOT_EXITS = 3;
        public static final int INIT_RUNNING = 5;
        public static final int NOT_SUPPORT = 1;
        public static final int OK = 0;
        public static final int OTHER = 6;
        public static final int UNKNOWN = -1;
        public static final int VENDOR_NOT_EXITS = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    @interface Status {
        public static final int IDLE = 0;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sEngineCache = new ConcurrentHashMap<>();
        }
    }

    public DKEngineManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void createEngine(EngineParams engineParams) {
        DKEventCenter.EngineType engineType = engineParams.engineType;
        if (engineType == DKEventCenter.EngineType.HIPPY) {
            createHippyEngine(engineParams);
            return;
        }
        if (engineType == DKEventCenter.EngineType.WORMHOLE) {
            createWormholeEngine(engineParams);
            return;
        }
        if (engineType == DKEventCenter.EngineType.MOSAIC) {
            createMosaicEngine(engineParams);
            return;
        }
        DLog.w(TAG, "unsupported engine type: " + engineParams.engineType);
    }

    private static void createHippyEngine(EngineParams engineParams) {
        String str;
        DLog.i(TAG, "createHippyEngine");
        String str2 = engineParams.moduleId;
        DKHippyEngine dKHippyEngine = new DKHippyEngine();
        HashMap hashMap = new HashMap();
        Map<String, String> map = engineParams.extra;
        if (map != null) {
            hashMap.putAll(map);
        }
        if (engineParams.isDebugMode) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(DKEngine.PARAM_KEY_IS_DEBUG_MODE, str);
        hashMap.put(DKEngine.PARAM_KEY_APP_NAME, str2);
        hashMap.put(DKEngine.PARAM_KEY_AD_TYPE, engineParams.adType);
        dKHippyEngine.createEngine(engineParams.context, hashMap, new DKEngine.OnCreateEngineListener(dKHippyEngine) { // from class: com.tencent.ams.dsdk.core.DKEngineManager.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ DKHippyEngine val$engine;

            {
                this.val$engine = dKHippyEngine;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EngineCreateListener.this, (Object) dKHippyEngine);
                }
            }

            @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
            public void onEngineInitializeError(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    return;
                }
                EngineCreateListener engineCreateListener = EngineCreateListener.this;
                if (engineCreateListener != null) {
                    engineCreateListener.onEngineCreateFailed(i3);
                }
            }

            @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
            public void onEngineInitialized() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                EngineCreateListener engineCreateListener = EngineCreateListener.this;
                if (engineCreateListener != null) {
                    engineCreateListener.onEngineCreated(this.val$engine);
                }
            }

            @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
            public void onWillCreateEngine() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                EngineCreateListener engineCreateListener = EngineCreateListener.this;
                if (engineCreateListener != null) {
                    engineCreateListener.onWillCreateEngine(this.val$engine);
                }
            }
        });
    }

    private static void createMosaicEngine(EngineParams engineParams) {
        DKMosaicEngine dKMosaicEngine;
        String str;
        DLog.i(TAG, "createMosaicEngine");
        if (engineParams == null) {
            DLog.w(TAG, "params is null.");
            return;
        }
        String str2 = engineParams.moduleId;
        EngineCreateListener engineCreateListener = engineParams.engineCreateListener;
        try {
            dKMosaicEngine = new DKMosaicEngine();
        } catch (Throwable th5) {
            DLog.e(TAG, "create DKMosaicEngine error, not support mosaic.", th5);
            if (engineCreateListener != null) {
                engineCreateListener.onEngineCreateFailed(12);
            }
            dKMosaicEngine = null;
        }
        if (dKMosaicEngine != null) {
            HashMap hashMap = new HashMap();
            Map<String, String> map = engineParams.extra;
            if (map != null) {
                hashMap.putAll(map);
            }
            if (engineParams.isDebugMode) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put(DKEngine.PARAM_KEY_IS_DEBUG_MODE, str);
            hashMap.put(DKEngine.PARAM_KEY_APP_NAME, str2);
            hashMap.put(DKEngine.PARAM_KEY_AD_TYPE, engineParams.adType);
            hashMap.put(DKEngine.PARAM_KEY_TEMPLATE_ID, engineParams.templateId);
            dKMosaicEngine.createEngine(engineParams.context, (Map<String, String>) hashMap, (HashMap) new OnCreateMosaicEngineListener(dKMosaicEngine) { // from class: com.tencent.ams.dsdk.core.DKEngineManager.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ DKEngine val$tempEngine;

                {
                    this.val$tempEngine = dKMosaicEngine;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) EngineCreateListener.this, (Object) dKMosaicEngine);
                    }
                }

                @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
                public void onEngineInitializeError(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, (Object) this, i3);
                        return;
                    }
                    EngineCreateListener engineCreateListener2 = EngineCreateListener.this;
                    if (engineCreateListener2 != null) {
                        engineCreateListener2.onEngineCreateFailed(i3);
                    }
                }

                @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
                public void onEngineInitialized() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        iPatchRedirector.redirect((short) 7, (Object) this);
                        return;
                    }
                    EngineCreateListener engineCreateListener2 = EngineCreateListener.this;
                    if (engineCreateListener2 != null) {
                        engineCreateListener2.onEngineCreated(this.val$tempEngine);
                    }
                }

                @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
                public void onSoLoadFailed(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, i3);
                        return;
                    }
                    DLog.i(DKEngineManager.TAG, "onSoLoadFailed, failReason: " + i3);
                }

                @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
                public void onSoLoadStart() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        DLog.i(DKEngineManager.TAG, "onSoLoadStart");
                    }
                }

                @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
                public void onSoLoadSuccess(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3);
                        return;
                    }
                    DLog.i(DKEngineManager.TAG, "onSoLoadSuccess, loadSoState: " + i3);
                }

                @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
                public void onWillCreateEngine() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                        return;
                    }
                    EngineCreateListener engineCreateListener2 = EngineCreateListener.this;
                    if (engineCreateListener2 != null) {
                        engineCreateListener2.onWillCreateEngine(this.val$tempEngine);
                    }
                }
            });
        }
    }

    private static void createWormholeEngine(EngineParams engineParams) {
        DLog.i(TAG, "createWormholeEngine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doWarmUpEngine(EngineParams engineParams) {
        ModuleInfo moduleInfo;
        synchronized (DKEngineManager.class) {
            DLog.i(TAG, "doWarmUpEngine, params: " + engineParams);
            if (!DKConfiguration.isEnableEnginePreWarm()) {
                DLog.w(TAG, "disable warmup engine.");
                return;
            }
            if (engineParams == null) {
                DLog.w(TAG, "warmUpEngine params is null");
                return;
            }
            if (TextUtils.isEmpty(engineParams.moduleId)) {
                DLog.w(TAG, "moduleId is empty.");
                return;
            }
            if (engineParams.engineType == null) {
                DLog.w(TAG, "engineType is null.");
                return;
            }
            if (engineParams.context == null) {
                DLog.w(TAG, "context is null.");
                return;
            }
            String str = null;
            if (!TextUtils.isEmpty(engineParams.dependsVersion) && ((moduleInfo = ModuleConfigCache.getModuleInfo(engineParams.moduleId)) == null || DynamicUtils.compareVersion(moduleInfo.getVersion(), engineParams.dependsVersion) < 0)) {
                if (moduleInfo != null) {
                    str = moduleInfo.getVersion();
                }
                DLog.w(TAG, "bundle version too low. local version: " + str + ", depends version: " + engineParams.dependsVersion);
                return;
            }
            int engineStatus = getEngineStatus(engineParams.moduleId);
            DLog.i(TAG, "engine status: " + engineStatus);
            if (engineStatus == 1) {
                DLog.w(TAG, "engine is warmup ing.");
            } else if (engineStatus == 3) {
                DLog.w(TAG, "engine is warmuped.");
            } else {
                updateEngineStatus(engineParams.moduleId, 1, null, engineParams, -1);
                createEngine(engineParams);
            }
        }
    }

    private static synchronized int getEngineStatus(@DKEngine.DKModuleID String str) {
        synchronized (DKEngineManager.class) {
            if (str == null) {
                return 0;
            }
            DKEnginWrapper dKEnginWrapper = sEngineCache.get(str);
            if (dKEnginWrapper == null) {
                return 0;
            }
            return dKEnginWrapper.status;
        }
    }

    public static synchronized DKEnginWrapper getWarmUpEngine(String str) {
        DKEnginWrapper warmUpEngine;
        synchronized (DKEngineManager.class) {
            warmUpEngine = getWarmUpEngine(str, true);
        }
        return warmUpEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void updateEngineStatus(@DKEngine.DKModuleID String str, int i3, DKEngine dKEngine, EngineParams engineParams, int i16) {
        synchronized (DKEngineManager.class) {
            DLog.i(TAG, "updateEngineStatus, moduleId: " + str + ", params: " + engineParams + ", status: " + i3 + ", error: " + i16 + ", engine: " + dKEngine);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ConcurrentHashMap<String, DKEnginWrapper> concurrentHashMap = sEngineCache;
            DKEnginWrapper dKEnginWrapper = concurrentHashMap.get(str);
            if (dKEnginWrapper == null) {
                dKEnginWrapper = new DKEnginWrapper();
                concurrentHashMap.put(str, dKEnginWrapper);
            }
            dKEnginWrapper.status = i3;
            dKEnginWrapper.engine = dKEngine;
            dKEnginWrapper.params = engineParams;
            dKEnginWrapper.errorCode = i16;
        }
    }

    public static void warmUpEngine(EngineParams engineParams) {
        DLog.i(TAG, "warmUpEngine, params: " + engineParams);
        if (engineParams == null) {
            DLog.w(TAG, "warmUpEngine params is null");
            return;
        }
        String str = engineParams.moduleId;
        if (TextUtils.isEmpty(str)) {
            DLog.w(TAG, "moduleId is empty.");
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable(str) { // from class: com.tencent.ams.dsdk.core.DKEngineManager.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$moduleId;

                {
                    this.val$moduleId = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) EngineParams.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    EngineParams engineParams2 = EngineParams.this;
                    engineParams2.engineCreateListener = new EngineCreateListener(engineParams2.engineCreateListener) { // from class: com.tencent.ams.dsdk.core.DKEngineManager.1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ EngineCreateListener val$listener;

                        {
                            this.val$listener = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                            }
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngineManager.EngineCreateListener
                        public void onEngineCreateFailed(int i3) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            DKEngineManager.updateEngineStatus(anonymousClass1.val$moduleId, 2, null, EngineParams.this, i3);
                            EngineCreateListener engineCreateListener = this.val$listener;
                            if (engineCreateListener != null) {
                                engineCreateListener.onEngineCreateFailed(i3);
                            }
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngineManager.EngineCreateListener
                        public void onEngineCreated(DKEngine dKEngine) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                                iPatchRedirector2.redirect((short) 4, (Object) this, (Object) dKEngine);
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            DKEngineManager.updateEngineStatus(anonymousClass1.val$moduleId, 3, dKEngine, EngineParams.this, 0);
                            EngineCreateListener engineCreateListener = this.val$listener;
                            if (engineCreateListener != null) {
                                engineCreateListener.onEngineCreated(dKEngine);
                            }
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngineManager.EngineCreateListener
                        public void onWillCreateEngine(DKEngine dKEngine) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dKEngine);
                                return;
                            }
                            EngineCreateListener engineCreateListener = this.val$listener;
                            if (engineCreateListener != null) {
                                engineCreateListener.onWillCreateEngine(dKEngine);
                            }
                        }
                    };
                    DKEngineManager.doWarmUpEngine(EngineParams.this);
                }
            });
        }
    }

    public static synchronized DKEnginWrapper getWarmUpEngine(String str, boolean z16) {
        synchronized (DKEngineManager.class) {
            DLog.i(TAG, "getWarmUpEngine, moduleId: " + str + ", enableWarmUpNext: " + z16);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ConcurrentHashMap<String, DKEnginWrapper> concurrentHashMap = sEngineCache;
            DKEnginWrapper dKEnginWrapper = concurrentHashMap.get(str);
            if (dKEnginWrapper == null) {
                DLog.w(TAG, "not warmup engine.");
                return null;
            }
            int i3 = dKEnginWrapper.status;
            if (2 != i3 && 3 != i3) {
                DLog.i(TAG, "warmUp engine is running.");
                return dKEnginWrapper.copy();
            }
            DLog.i(TAG, "warmUp engine is fail or success.");
            concurrentHashMap.remove(str);
            if (z16) {
                WorkThreadManager.getInstance().schedule(new Runnable() { // from class: com.tencent.ams.dsdk.core.DKEngineManager.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKEnginWrapper.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            DLog.i(DKEngineManager.TAG, "rewarmUp engine.");
                            DKEngineManager.doWarmUpEngine(DKEnginWrapper.this.params);
                        }
                    }
                }, 1000L);
            }
            return dKEnginWrapper;
        }
    }
}
