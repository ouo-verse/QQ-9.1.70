package com.tencent.ams.dsdk.core.hippy;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.bridge.DKAPIProvider;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.ams.dsdk.fodder.VendorBundleManager;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKHippyEngine extends DKEngine<DKEngine.OnCreateEngineListener> {
    protected static final String CREATE_VIEW_PARAM_KEY_AD_TYPE = "adType";
    protected static final String CREATE_VIEW_PARAM_KEY_DEBUG_MODE = "debugMode";
    protected static final String CREATE_VIEW_PARAM_KEY_ENGINE_GROUP_ID = "engineGroupId";
    protected static final String CREATE_VIEW_PARAM_KEY_ENGINE_ID = "engineId";
    private static final String CREATE_VIEW_PARAM_KEY_ENGINE_PRE_WARM = "enginePreWarm";
    protected static final String CREATE_VIEW_PARAM_KEY_MODULE_ID = "moduleId";
    private static final String TAG = "DKHippyEngine";
    private HippyEngine mHippyEngine;
    private ViewGroup mHippyView;
    private HippyEngine.EngineInitParams mInitParams;
    private boolean mIsEnginePreWarmed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface CreateHippyViewListener {
        void onFirstViewAdded();

        void onJsException(HippyJsException hippyJsException);

        void onLoadCompleted(HippyEngine.ModuleLoadStatus moduleLoadStatus, String str);
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    protected int checkDependsVendor(List<String> list, Map<String, String> map) {
        if (list != null && !list.isEmpty()) {
            this.mVendorInfo = ModuleConfigCache.getModuleInfo(list.get(0));
            String vendorBundleFilePath = VendorBundleManager.getInstance().getVendorBundleFilePath(this.mVendorInfo, false, 0L);
            if (TextUtils.isEmpty(vendorBundleFilePath)) {
                return 1;
            }
            map.put(DKEngine.PARAM_KEY_JS_FILE_PATH, vendorBundleFilePath);
        }
        return 0;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public int getEngineGroupId() {
        HippyEngine hippyEngine = getHippyEngine();
        if (hippyEngine == null) {
            return -1;
        }
        return hippyEngine.getGroupId();
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public int getEngineId() {
        return DKHippyEngineHelper.getEngineId(getHippyEngine());
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public DKEventCenter.EngineType getEngineType() {
        return DKEventCenter.EngineType.HIPPY;
    }

    public HippyEngine getHippyEngine() {
        return this.mHippyEngine;
    }

    public HippyEngineContext getHippyEngineContext() {
        HippyEngine hippyEngine = getHippyEngine();
        if (hippyEngine != null) {
            return hippyEngine.getEngineContext();
        }
        return null;
    }

    public HippyEngine.EngineInitParams getInitParams() {
        return this.mInitParams;
    }

    public ViewGroup getRootView() {
        return this.mHippyView;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void handleCreateEngine(Context context, Map<String, String> map, final DKEngine.OnCreateEngineListener onCreateEngineListener) {
        DKEventCenter dKEventCenter = this.eventCenter;
        if (dKEventCenter != null) {
            dKEventCenter.fireEngineInitParams();
        }
        HippyEngine.EngineInitParams engineInitParams = new HippyEngine.EngineInitParams();
        this.mInitParams = engineInitParams;
        engineInitParams.context = context;
        engineInitParams.exceptionHandler = new HippyExceptionHandlerAdapter() { // from class: com.tencent.ams.dsdk.core.hippy.DKHippyEngine.1
            @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
            public void handleBackgroundTracing(String str) {
                DLog.e(DKHippyEngine.TAG, "handleBackgroundTracing, details: " + str);
            }

            @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
            public void handleJsException(HippyJsException hippyJsException) {
                DLog.e(DKHippyEngine.TAG, "handleJsException:");
                if (hippyJsException != null) {
                    DLog.e(DKHippyEngine.TAG, "handleJsException", hippyJsException);
                    DynamicReporter.reportHippyJsException(hippyJsException.getMessage());
                }
            }

            @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
            public void handleNativeException(Exception exc, boolean z16) {
                DLog.e(DKHippyEngine.TAG, "handleNativeException, haveCaught: " + z16);
                if (exc != null) {
                    DLog.e(DKHippyEngine.TAG, "handleNativeException", exc);
                    DynamicReporter.reportHippyNativeException(exc.getMessage());
                }
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DKAPIProvider(DKEngine.sGlobalParams, map, this.mMethodDispatcher, new WeakReference(this)));
        HippyEngine.EngineInitParams engineInitParams2 = this.mInitParams;
        engineInitParams2.providers = arrayList;
        DKHippyEngineHelper.mergeInitParams(engineInitParams2, DKEngine.sGlobalInitParams);
        if (onCreateEngineListener != null) {
            onCreateEngineListener.onWillCreateEngine();
        }
        this.mInitParams.coreJSFilePath = map.get(DKEngine.PARAM_KEY_JS_FILE_PATH);
        boolean z16 = this.mIsDebugMode;
        if (z16) {
            this.mInitParams.debugMode = z16;
        }
        if (!z16 && TextUtils.isEmpty(this.mInitParams.coreJSFilePath) && TextUtils.isEmpty(this.mInitParams.coreJSAssetsPath)) {
            DLog.w(TAG, "coreJSFilePath and coreJSAssetsPath both empty.");
            DKEventCenter dKEventCenter2 = this.eventCenter;
            if (dKEventCenter2 != null) {
                dKEventCenter2.fireEngineCreateFail(1);
            }
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitializeError(1);
                return;
            }
            return;
        }
        try {
            this.mHippyEngine = HippyEngine.create(this.mInitParams);
            this.mEngineId = getEngineId();
            DKEventCenter dKEventCenter3 = this.eventCenter;
            if (dKEventCenter3 != null) {
                dKEventCenter3.fireEngineCreated();
            }
            try {
                this.mHippyEngine.initEngine(new HippyEngine.EngineListener() { // from class: com.tencent.ams.dsdk.core.hippy.DKHippyEngine.2
                    @Override // com.tencent.mtt.hippy.HippyEngine.EngineListener
                    public void onInitialized(HippyEngine.EngineInitStatus engineInitStatus, String str) {
                        if (engineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK) {
                            if (((DKEngine) DKHippyEngine.this).eventCenter != null) {
                                ((DKEngine) DKHippyEngine.this).eventCenter.fireEngineInitFail(engineInitStatus.value());
                            }
                            DKEngine.OnCreateEngineListener onCreateEngineListener2 = onCreateEngineListener;
                            if (onCreateEngineListener2 != null) {
                                onCreateEngineListener2.onEngineInitializeError(engineInitStatus.value());
                                return;
                            }
                            return;
                        }
                        if (((DKEngine) DKHippyEngine.this).eventCenter != null) {
                            ((DKEngine) DKHippyEngine.this).eventCenter.fireEngineInitSuccess();
                        }
                        DKEngine.OnCreateEngineListener onCreateEngineListener3 = onCreateEngineListener;
                        if (onCreateEngineListener3 != null) {
                            onCreateEngineListener3.onEngineInitialized();
                        }
                        DKEngineInstanceManager.addEngine(DKHippyEngine.this);
                    }
                });
                DKEventCenter dKEventCenter4 = this.eventCenter;
                if (dKEventCenter4 != null) {
                    dKEventCenter4.fireEngineInit();
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "init engine error.", th5);
                if (onCreateEngineListener != null) {
                    onCreateEngineListener.onEngineInitializeError(HippyEngine.EngineInitStatus.STATUS_INIT_EXCEPTION.value());
                }
                DKEventCenter dKEventCenter5 = this.eventCenter;
                if (dKEventCenter5 != null) {
                    dKEventCenter5.fireEngineInitFail(HippyEngine.EngineInitStatus.STATUS_INIT_EXCEPTION.value());
                }
            }
        } catch (Throwable th6) {
            DLog.e(TAG, "create engine error.", th6);
            DKEventCenter dKEventCenter6 = this.eventCenter;
            if (dKEventCenter6 != null) {
                dKEventCenter6.fireEngineCreateFail(2);
            }
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitializeError(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void handleViewCreate(DKEngine.CreateViewInfo createViewInfo) {
        String str;
        String str2;
        String str3;
        ModuleInfo moduleInfo;
        String str4;
        ModuleInfo moduleInfo2;
        if (createViewInfo == null) {
            return;
        }
        Context context = createViewInfo.context;
        Map<String, String> map = createViewInfo.params;
        final DKEngine.OnViewCreateListener onViewCreateListener = createViewInfo.onViewCreateListener;
        if (onViewCreateListener == null) {
            DLog.w(TAG, "createView, onViewCreateListener is null.");
            return;
        }
        if (map == null) {
            str = null;
        } else {
            str = map.get(DKEngine.PARAM_KEY_AD_TYPE);
        }
        if (map == null) {
            str2 = null;
        } else {
            str2 = map.get(DKEngine.PARAM_KEY_APP_NAME);
        }
        if (!TextUtils.isEmpty(str2) && (moduleInfo2 = ModuleConfigCache.getModuleInfo(str2)) != null) {
            str3 = moduleInfo2.getName();
        } else {
            str3 = null;
        }
        DKEventCenter dKEventCenter = this.eventCenter;
        if (dKEventCenter != null) {
            dKEventCenter.fireCreateView(str, str3);
        }
        if (context != null && map != null) {
            if (this.mHippyEngine == null) {
                onViewCreateListener.onViewCreate(null, 9002);
                DKEventCenter dKEventCenter2 = this.eventCenter;
                if (dKEventCenter2 != null) {
                    dKEventCenter2.fireViewCreateFail(9002, str);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                onViewCreateListener.onViewCreate(null, 9003);
                DKEventCenter dKEventCenter3 = this.eventCenter;
                if (dKEventCenter3 != null) {
                    dKEventCenter3.fireViewCreateFail(9003, str);
                    return;
                }
                return;
            }
            String str5 = map.get(DKEngine.PARAM_KEY_JS_FILE_PATH);
            String str6 = map.get(DKEngine.PARAM_KEY_JS_ASSETS_PATH);
            String str7 = map.get(DKEngine.PARAM_KEY_JS_PARAMS);
            if (TextUtils.isEmpty(str2)) {
                onViewCreateListener.onViewCreate(null, 9005);
                DKEventCenter dKEventCenter4 = this.eventCenter;
                if (dKEventCenter4 != null) {
                    dKEventCenter4.fireViewCreateFail(9005, str);
                    return;
                }
                return;
            }
            if (!this.mHippyEngine.isDebugMode() && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5)) {
                DLog.w(TAG, "jsAssetsPath and jsFilePath both empty.");
                onViewCreateListener.onViewCreate(null, 9006);
                DKEventCenter dKEventCenter5 = this.eventCenter;
                if (dKEventCenter5 != null) {
                    dKEventCenter5.fireViewCreateFail(9006, str);
                    return;
                }
                return;
            }
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt(CREATE_VIEW_PARAM_KEY_ENGINE_ID, getEngineId());
            hippyMap.pushInt(CREATE_VIEW_PARAM_KEY_ENGINE_GROUP_ID, getEngineGroupId());
            hippyMap.pushString(CREATE_VIEW_PARAM_KEY_MODULE_ID, str2);
            hippyMap.pushBoolean(CREATE_VIEW_PARAM_KEY_DEBUG_MODE, this.mIsDebugMode);
            hippyMap.pushBoolean(CREATE_VIEW_PARAM_KEY_ENGINE_PRE_WARM, this.mIsEnginePreWarmed);
            hippyMap.pushString("adType", str);
            if (!TextUtils.isEmpty(str7)) {
                try {
                    hippyMap.pushJSONObject(new JSONObject(str7));
                } catch (Throwable th5) {
                    DLog.e(TAG, "createView error.", th5);
                }
            }
            HippyEngine.ModuleLoadParams moduleLoadParams = new HippyEngine.ModuleLoadParams();
            moduleLoadParams.context = context;
            moduleLoadParams.componentName = str2;
            moduleLoadParams.jsAssetsPath = str6;
            moduleLoadParams.jsFilePath = str5;
            moduleLoadParams.jsParams = hippyMap;
            final long uptimeMillis = SystemClock.uptimeMillis();
            final ModuleInfo moduleInfo3 = ModuleConfigCache.getModuleInfo(str2);
            try {
                DynamicReporter.reportDynamicRenderStart(moduleInfo3, "hippy");
                final String str8 = str;
                str4 = "hippy";
                moduleInfo = moduleInfo3;
                try {
                    ViewGroup loadModule = DKHippyEngineHelper.loadModule(this.mHippyEngine, moduleLoadParams, new CreateHippyViewListener() { // from class: com.tencent.ams.dsdk.core.hippy.DKHippyEngine.3
                        @Override // com.tencent.ams.dsdk.core.hippy.DKHippyEngine.CreateHippyViewListener
                        public void onFirstViewAdded() {
                            if (((DKEngine) DKHippyEngine.this).eventCenter != null) {
                                ((DKEngine) DKHippyEngine.this).eventCenter.fireViewLoadComplete(str8);
                            }
                            onViewCreateListener.onViewLoadComplete();
                        }

                        @Override // com.tencent.ams.dsdk.core.hippy.DKHippyEngine.CreateHippyViewListener
                        public void onJsException(HippyJsException hippyJsException) {
                            DLog.e(DKHippyEngine.TAG, "onJsException, ", hippyJsException);
                        }

                        @Override // com.tencent.ams.dsdk.core.hippy.DKHippyEngine.CreateHippyViewListener
                        public void onLoadCompleted(HippyEngine.ModuleLoadStatus moduleLoadStatus, String str9) {
                            if (((DKEngine) DKHippyEngine.this).eventCenter != null) {
                                ((DKEngine) DKHippyEngine.this).eventCenter.fireJsBundleLoadComplete(str8, moduleLoadStatus.value());
                            }
                            if (moduleLoadStatus != HippyEngine.ModuleLoadStatus.STATUS_OK) {
                                onViewCreateListener.onViewInitializeError(moduleLoadStatus.value());
                                DynamicReporter.reportDynamicRenderEnd(uptimeMillis, TagValue.INITIAL_ERROR, moduleInfo3, "hippy");
                            } else {
                                onViewCreateListener.onViewInitialized();
                                DynamicReporter.reportDynamicRenderEnd(uptimeMillis, "none", moduleInfo3, "hippy");
                            }
                        }
                    });
                    this.mHippyView = loadModule;
                    onViewCreateListener.onViewCreate(loadModule, 9000);
                    DKEventCenter dKEventCenter6 = this.eventCenter;
                    if (dKEventCenter6 != null) {
                        dKEventCenter6.fireViewCreated(str);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    DLog.e(TAG, "hippy load module error.", th);
                    onViewCreateListener.onViewCreate(null, 9007);
                    DKEventCenter dKEventCenter7 = this.eventCenter;
                    if (dKEventCenter7 != null) {
                        dKEventCenter7.fireViewCreateFail(9007, str);
                    }
                    DynamicReporter.reportDynamicRenderEnd(uptimeMillis, TagValue.LOAD_EXCEPTION, moduleInfo, str4);
                }
            } catch (Throwable th7) {
                th = th7;
                moduleInfo = moduleInfo3;
                str4 = "hippy";
            }
        } else {
            onViewCreateListener.onViewCreate(null, 9004);
            DKEventCenter dKEventCenter8 = this.eventCenter;
            if (dKEventCenter8 != null) {
                dKEventCenter8.fireViewCreateFail(9004, str);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public boolean isEnginePreWarmed() {
        return this.mIsEnginePreWarmed;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public boolean onBackPressed(final DKEngine.BackPressHandler backPressHandler) {
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            return hippyEngine.onBackPressed(new HippyEngine.BackPressHandler() { // from class: com.tencent.ams.dsdk.core.hippy.DKHippyEngine.4
                @Override // com.tencent.mtt.hippy.HippyEngine.BackPressHandler
                public void handleBackPress() {
                    DKEngine.BackPressHandler backPressHandler2 = backPressHandler;
                    if (backPressHandler2 != null) {
                        backPressHandler2.onBackPressed();
                    }
                }
            });
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onDestroy() {
        DKHippyEngineHelper.destroyEngine(this, this.mHippyView);
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onResume() {
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.onEngineResume();
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onStop() {
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.onEnginePause();
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void sendEvent(String str, Object obj) {
        if (obj instanceof JSONObject) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushJSONObject((JSONObject) obj);
            obj = hippyMap;
        }
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.sendEvent(str, obj);
        }
    }

    public void setEnginePreWarmed(boolean z16) {
        this.mIsEnginePreWarmed = z16;
    }
}
