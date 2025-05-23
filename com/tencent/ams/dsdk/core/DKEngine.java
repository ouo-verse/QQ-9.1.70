package com.tencent.ams.dsdk.core;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.cache.TemplateConfigCache;
import com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener;
import com.tencent.ams.dsdk.core.DKEngineManager;
import com.tencent.ams.dsdk.core.hippy.DKEngineInstanceManager;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.data.TemplateInfo;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.ams.dsdk.event.DKEventHandler;
import com.tencent.ams.dsdk.event.DKMethodDispatcher;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.fodder.SoConfigManager;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.ams.dsdk.fodder.VendorBundleManager;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.dsdk.view.video.VideoLoader;
import com.tencent.ams.dsdk.view.video.glvideo.DKGLVideoPlayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.HippyEngine;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class DKEngine<L extends OnCreateEngineListener> {
    static IPatchRedirector $redirector_ = null;
    public static final String PARAM_KEY_AD_TYPE = "PKAT";
    public static final String PARAM_KEY_APP_NAME = "PKAN";
    public static final String PARAM_KEY_DEPEND_VERSION = "PKDV";
    public static final String PARAM_KEY_DISABLE_CHECK_DEPEND_VERSION = "PK_DISABLE_CHECK_DEPEND_VERSION";
    public static final String PARAM_KEY_IS_DEBUG_MODE = "PKIDM";
    public static final String PARAM_KEY_JS_ASSETS_PATH = "PKJAP";
    public static final String PARAM_KEY_JS_DEBUG_FILE_PATH = "PKJDFP";
    public static final String PARAM_KEY_JS_FILE_PATH = "PKJFP";
    public static final String PARAM_KEY_JS_PARAMS = "PKJP";
    public static final String PARAM_KEY_ROOT_VIEW_HEIGHT = "PK_ROOT_HEIGHT";
    public static final String PARAM_KEY_ROOT_VIEW_WIDTH = "PK_ROOT_WIDTH";
    public static final String PARAM_KEY_SCENE = "PKSCENE";
    public static final String PARAM_KEY_TEMPLATE_ID = "PKTID";
    private static final String TAG = "DKEngine";
    private static Context mContext;
    private static DeviceInfoGetter sDeviceInfoGetter;
    protected static DKEventHandler sEventHandler;
    protected static Map<String, String> sExtParams;
    protected static final AtomicInteger sGlobalIdCount;

    @Deprecated
    protected static HippyEngine.EngineInitParams sGlobalInitParams;
    protected static Map<String, String> sGlobalParams;
    protected DKEventCenter eventCenter;
    protected ModuleInfo mBundleInfo;
    private DKCustomAbilityProvider mCustomAbilityProvider;
    protected int mEngineId;
    protected boolean mIsDebugMode;
    protected DKMethodDispatcher mMethodDispatcher;
    protected String mModuleId;
    protected ModuleInfo mVendorInfo;
    private VideoLoader mVideoLoader;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface BackPressHandler {
        void onBackPressed();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class CreateViewInfo {
        static IPatchRedirector $redirector_;
        public View container;
        public Context context;
        public long createTimeOut;
        public OnViewCreateExtraEventListener onViewCreateExtraEventListener;
        public OnViewCreateListener onViewCreateListener;
        public Map<String, String> params;

        public CreateViewInfo() {
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
            return "CreateViewInfo{context=" + this.context + ", container=" + this.container + ", params=" + this.params + ", onViewCreateListener=" + this.onViewCreateListener + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface DKAdType {
        public static final String OTT_DUAL_STREAM = "4";
        public static final String OTT_IMMERSIVE = "7";
        public static final String OTT_NETMOVIE = "6";
        public static final String OTT_PAUSE = "5";
        public static final String OTT_REWARD_CENTER = "10";
        public static final String OTT_VIDEOAD = "9";
        public static final String REWARDEDAD = "1";
        public static final String SPLASH = "3";
        public static final String STREAM_CELL = "2";
        public static final String UNIFIED_NATVIE = "8";
        public static final String XIJING = "0";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface DKApp {

        /* renamed from: MQQ, reason: collision with root package name */
        public static final int f70101MQQ = 8;
        public static final int MUSIC = 1;
        public static final int NEWS = 2;
        public static final int OTT = 7;
        public static final int PDD = 4;
        public static final int SPORTS = 3;
        public static final int VIDEO = 0;
        public static final int WESEE = 5;
        public static final int XQ = 6;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface DKModuleID {
        public static final String LANDING_PAGE = "landing-page-mosaic";
        public static final String NEWS_STREAM_MOSAIC = "qqnews-stream-mosaic";
        public static final String OTT_DUAL_STREAM_MOSAIC = "ott-stream-mosaic";
        public static final String OTT_IMMERSIVE_MOSAIC = "ott-immersive-mosaic";
        public static final String OTT_NETMOVIE_MOSAIC = "ott-netmovie-mosaic";
        public static final String OTT_PAUSE_MOSAIC = "ott-pause-mosaic";
        public static final String OTT_REWARD_CENTER_MOSAIC = "ott-reward-center-mosaic";
        public static final String OTT_VIDEOAD_MOSAIC = "ott-videoad-mosaic";
        public static final String PCAD_REWARD = "pcad-reward";
        public static final String PDD_WORMHOLE = "pdd-wormhole";
        public static final String REWARD_AD = "reward-ad";
        public static final String REWARD_AD_HIPPY3 = "reward-ad-hippy3";
        public static final String REWARD_WORMHOLE = "reward-wormhole";
        public static final String SPLASH_MOSAIC = "splash-mosaic";
        public static final String UNIFIED_NATIVE_AD = "pcad-native";
        public static final String XIJING_VIEWER = "xijing-viewer";
        public static final String XJ_PAGE = "ad-dynamic-canvas";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface DKPlatform {
        public static final String ANDROID = "android";
        public static final String APAD = "aPad";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DeviceInfoGetter {
        String getGuid();

        String getOaid();

        String getQimei36();

        String getTaid();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface EngineCreateStatus {
        public static final int DEPENDS_VENDOR_EMPTY = 11;
        public static final int MODULE_ID_EMPTY = 9;
        public static final int MODULE_NOT_EXISTS = 10;
        public static final int MOSAIC_CONFIG_CLOSE = 7;
        public static final int MOSAIC_JS_ENGINE_ERROR = 6;
        public static final int MOSAIC_JS_ENGINE_SO_LOAD_FAIL = 5;
        public static final int NOT_SUPPORT_HIPPY = 13;
        public static final int NOT_SUPPORT_MOSAIC = 12;
        public static final int OK = 0;
        public static final int OTHER = 2;
        public static final int PARAMS_ERROR = 8;
        public static final int VENDOR_NULL = 1;
        public static final int WORMHOLE_ENV_NOT_SUPPORT = 4;
        public static final int WORMHOLE_ERROR = 3;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ExtraEvent {
        public static final String EXTRA_EVENT_CHECK_PARAMS_FAIL = "checkParamsFail";
        public static final String EXTRA_EVENT_ON_VIEW_BEFORE_INTERCEPTED = "beforeIntercepted";
        public static final String EXTRA_EVENT_ON_VIEW_CREATED = "onViewCreated";
        public static final String EXTRA_EVENT_ON_VIEW_CREATE_FAIL = "onViewCreateFail";
        public static final String EXTRA_EVENT_ON_VIEW_CREATE_START = "onViewCreateStart";
        public static final String EXTRA_EVENT_ON_VIEW_NOT_NULL = "onViewNotNull";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface GlobalKey {
        public static final String AD_SDK_VERSION = "ad_sdk_version";
        public static final String APK_DOWNLOAD_PATH = "apkDownloadPath";
        public static final String APP_NAME = "appName";
        public static final String APP_PACKAGE_NAME = "appPackageName";
        public static final String APP_VERSION = "appVersion";
        public static final String CHID = "chid";
        public static final String DEVICE_MODEL = "deviceModel";
        public static final String GUID = "guid";
        public static final String NET_WORK_TYPE = "networkType";
        public static final String OAID = "oaid";
        public static final String OS_NAME = "osName";
        public static final String OS_VERSION = "osVersion";
        public static final String PLATFORM = "platform";
        public static final String QIMEI36 = "qimei36";
        public static final String SDK_VERSION = "sdkVersion";
        public static final String TAID = "taid";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnCreateEngineListener {
        void onEngineInitializeError(int i3);

        void onEngineInitialized();

        void onWillCreateEngine();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnViewCreateExtraEventListener {
        void onViewCreateExtraEvent(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnViewCreateListener {
        boolean onInterceptViewCreate(View view, int i3, Runnable runnable);

        void onViewCreate(View view, int i3);

        void onViewCreateStart();

        void onViewInitializeError(int i3);

        void onViewInitialized();

        void onViewLoadComplete();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface SceneType {
        public static final String LANDING_PAGE = "landing-page-mosaic";
        public static final String XIJING_PAGE = "xijing-mosaic";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ViewCreateError {
        public static final int CONTAINER_INVALID = 9009;
        public static final int CREATE_TIME_OUT = 9013;
        public static final int ENV_NOT_SUPPORT = 9008;
        public static final int LOAD_EXCEPTION = 9007;
        public static final int LOAD_PARAMS_ERROR = 9004;
        public static final int MODULE_ID_ERROR = 9014;
        public static final int NO_AD_TYPE = 9003;
        public static final int NO_APP_NAME = 9005;
        public static final int NO_BUNDLE = 9006;
        public static final int NO_ENGINE = 9002;
        public static final int NO_TEMPLATE = 9010;
        public static final int NO_TEMPLATE_CONFIG = 9015;
        public static final int NO_VIEW_CREATED = 9001;
        public static final int OK = 9000;
        public static final int VENDOR_MISMATCH = 9012;
        public static final int VERSION_TOO_LOW = 9011;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            sGlobalIdCount = new AtomicInteger(2000);
        }
    }

    public DKEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mMethodDispatcher = null;
        this.mEngineId = -1;
        this.eventCenter = new DKEventCenter(getEngineType());
        this.mMethodDispatcher = new DKMethodDispatcher(this);
        DKEventHandler dKEventHandler = sEventHandler;
        if (dKEventHandler != null) {
            this.eventCenter.addEventHandler(dKEventHandler);
        }
        this.mEngineId = sGlobalIdCount.getAndIncrement();
    }

    private static void checkGlobalParams(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (TextUtils.isEmpty(map.get("chid"))) {
                DLog.e(TAG, "chid is empty, please set chid");
            }
            if (TextUtils.isEmpty(map.get("deviceModel"))) {
                DLog.e(TAG, "device model is empty, please set device model");
            }
            if (TextUtils.isEmpty(map.get("osVersion"))) {
                DLog.e(TAG, "os version is empty, please set os version");
            }
            if (TextUtils.isEmpty(map.get("appVersion"))) {
                DLog.e(TAG, "app version is empty, please set app version");
                return;
            }
            return;
        }
        DLog.e(TAG, "global params is null");
    }

    public static Map<Integer, DKEngine> getAllEngines() {
        return DKEngineInstanceManager.getEngines();
    }

    public static Context getApplicationContext() {
        return mContext;
    }

    public static String getBundlePath(String str) {
        return DKBundleManager.getInstance().getModuleBundleFilePath(str, false, 0L);
    }

    public static String getBundlePathRealTime(String str, long j3) {
        return DKBundleManager.getInstance().getModuleBundleFilePath(str, true, j3);
    }

    public static DeviceInfoGetter getDeviceInfoGetter() {
        return sDeviceInfoGetter;
    }

    public static DKEngine getEngineInstanceById(int i3) {
        return DKEngineInstanceManager.getEngine(i3);
    }

    public static DKEngine getEnginePreWarmed(String str) {
        DKEngineManager.DKEnginWrapper warmUpEngine = DKEngineManager.getWarmUpEngine(str);
        if (warmUpEngine != null) {
            return warmUpEngine.engine;
        }
        return null;
    }

    public static Map<String, String> getExtParams() {
        return sExtParams;
    }

    public static Map<String, String> getGlobalParams() {
        return sGlobalParams;
    }

    public static String getTemplatePath(String str) {
        return getTemplatePath(str, null);
    }

    public static String getTemplatePathRealTime(String str, long j3) {
        return getTemplatePathRealTime(str, j3, null);
    }

    public static String getVendorPath() {
        return DKBundleManager.getInstance().getVendorBundleFilePath(false, 0L);
    }

    public static String getVendorPathRealTime(long j3) {
        return DKBundleManager.getInstance().getVendorBundleFilePath(true, j3);
    }

    private void onViewCreateFail(OnViewCreateListener onViewCreateListener, int i3, String str) {
        DLog.w(TAG, "createView fail errorCode: " + i3 + ", adType: " + str);
        if (onViewCreateListener != null) {
            onViewCreateListener.onViewInitializeError(i3);
        }
        DKEventCenter dKEventCenter = this.eventCenter;
        if (dKEventCenter != null) {
            dKEventCenter.fireViewCreateFail(i3, str);
        }
    }

    public static void preloadFrontEndSrc() {
        DKBundleManager.getInstance().preloadBundles();
        TemplateManager.getInstance().updateTemplate();
        SoConfigManager.getInstance().updateSoConfig();
    }

    public static void setBundleExpireTime(long j3) {
        DKConfiguration.setBundleExpireTime(j3);
    }

    public static void setBundleMaxSize(long j3) {
        DKConfiguration.setBundleMaxSize(j3);
    }

    public static void setDebug(boolean z16) {
        DLog.setDebugEnabled(z16);
    }

    public static void setDeviceInfoGetter(DeviceInfoGetter deviceInfoGetter) {
        sDeviceInfoGetter = deviceInfoGetter;
    }

    public static void setEnableEnginePreWarm(boolean z16) {
        DKConfiguration.setEnableEnginePreWarm(z16);
    }

    public static void setEnableResourcePreload(boolean z16) {
        DKConfiguration.setEnableResourcePreload(z16);
    }

    public static void setEngineInstanceLimit(int i3) {
        DKConfiguration.setEngineInstanceLimit(i3);
    }

    public static void setEventHandler(DKEventHandler dKEventHandler) {
        sEventHandler = dKEventHandler;
    }

    public static void setExtParams(Map<String, String> map) {
        sExtParams = map;
    }

    public static void setGLPlayerClass(Class<? extends DKGLVideoPlayer> cls) {
        DKConfiguration.setGLPlayerClass(cls);
    }

    @Deprecated
    public static void setGlobalInitParams(HippyEngine.EngineInitParams engineInitParams) {
        sGlobalInitParams = engineInitParams;
    }

    public static void setGlobalParams(Context context, Map<String, String> map) {
        Context applicationContext;
        if (context == null) {
            applicationContext = null;
        } else {
            applicationContext = context.getApplicationContext();
        }
        mContext = applicationContext;
        checkGlobalParams(map);
        Map<String, String> genGlobalParams = DynamicUtils.genGlobalParams();
        sGlobalParams = genGlobalParams;
        if (map != null) {
            genGlobalParams.putAll(map);
        }
    }

    public static void setPlayerClass(Class<? extends DKVideoPlayer> cls) {
        DKConfiguration.setPlayerClass(cls);
    }

    public static void setPreloadExpireTime(long j3) {
        DKConfiguration.setPreloadExpireTIme(j3);
    }

    public static void setPreloadMaxSize(long j3) {
        DKConfiguration.setPreloadMaxSize(j3);
    }

    public static void startEnginePreWarm(DKEngineManager.EngineParams engineParams) {
        DKEngineManager.warmUpEngine(engineParams);
    }

    public void addEventHandler(DKEventHandler dKEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dKEventHandler);
            return;
        }
        DKEventCenter dKEventCenter = this.eventCenter;
        if (dKEventCenter != null) {
            dKEventCenter.addEventHandler(dKEventHandler);
        }
    }

    protected int checkDependsVendor(List<String> list, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) map)).intValue();
        }
        DLog.i(TAG, "checkDependsVendor, depends: " + list + ", params: " + map);
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(list.get(0))) {
            this.mVendorInfo = ModuleConfigCache.getModuleInfo(list.get(0));
            String vendorBundleFilePath = VendorBundleManager.getInstance().getVendorBundleFilePath(this.mVendorInfo, false, 0L);
            if (TextUtils.isEmpty(vendorBundleFilePath)) {
                DLog.w(TAG, "depend vendor not exists.");
                return 1;
            }
            map.put(PARAM_KEY_JS_FILE_PATH, vendorBundleFilePath);
            return 0;
        }
        DLog.w(TAG, "depends is empty.");
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkParams(CreateViewInfo createViewInfo) {
        OnViewCreateListener onViewCreateListener;
        TemplateInfo templateInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) createViewInfo)).booleanValue();
        }
        if (createViewInfo != null && (onViewCreateListener = createViewInfo.onViewCreateListener) != null) {
            Map<String, String> map = createViewInfo.params;
            String str = null;
            if (map != null && createViewInfo.context != null) {
                String str2 = map.get(PARAM_KEY_AD_TYPE);
                String str3 = map.get(PARAM_KEY_APP_NAME);
                String str4 = map.get(PARAM_KEY_SCENE);
                ModuleInfo moduleInfo = this.mBundleInfo;
                if (moduleInfo == null) {
                    onViewCreateFail(onViewCreateListener, 9002, str2);
                    return false;
                }
                String name = moduleInfo.getName();
                DKEventCenter dKEventCenter = this.eventCenter;
                if (dKEventCenter != null) {
                    dKEventCenter.fireCreateView(str2, name);
                }
                if (TextUtils.isEmpty(str2)) {
                    onViewCreateFail(onViewCreateListener, 9003, null);
                    return false;
                }
                if (TextUtils.isEmpty(str3)) {
                    onViewCreateFail(onViewCreateListener, 9005, str2);
                    return false;
                }
                if (!str3.equals(moduleInfo.getId())) {
                    onViewCreateFail(onViewCreateListener, 9014, str2);
                    return false;
                }
                String moduleBundleFilePath = DKBundleManager.getInstance().getModuleBundleFilePath(this.mBundleInfo);
                if (TextUtils.isEmpty(moduleBundleFilePath)) {
                    onViewCreateFail(onViewCreateListener, 9006, str2);
                    return false;
                }
                if (!"1".equals(map.get(PARAM_KEY_DISABLE_CHECK_DEPEND_VERSION))) {
                    String str5 = map.get(PARAM_KEY_TEMPLATE_ID);
                    if (!TextUtils.isEmpty(str5) && (templateInfo = TemplateConfigCache.getInstance().getTemplateInfo(str5, str4)) != null) {
                        str = templateInfo.getMinModuleVersion();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = map.get(PARAM_KEY_DEPEND_VERSION);
                    }
                    if (!TextUtils.isEmpty(str) && DynamicUtils.compareVersion(moduleInfo.getVersion(), str) < 0) {
                        onViewCreateFail(onViewCreateListener, 9011, str2);
                        return false;
                    }
                }
                if (!isMatchVendor(moduleInfo.getDependencies())) {
                    onViewCreateFail(onViewCreateListener, 9012, str2);
                    return false;
                }
                map.put(PARAM_KEY_JS_FILE_PATH, moduleBundleFilePath);
                return true;
            }
            onViewCreateFail(onViewCreateListener, 9004, null);
            return false;
        }
        DLog.w(TAG, "create view info or listener is null.");
        return false;
    }

    public void createEngine(Context context, Map<String, String> map, L l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, map, l3);
            return;
        }
        DLog.i(TAG, "createEngine, params: " + map);
        if (map == null) {
            DLog.w(TAG, "params is null.");
            if (l3 != null) {
                l3.onEngineInitializeError(8);
                return;
            }
            return;
        }
        this.mIsDebugMode = "1".equals(map.get(PARAM_KEY_IS_DEBUG_MODE));
        String str = map.get(PARAM_KEY_APP_NAME);
        this.mModuleId = str;
        if (TextUtils.isEmpty(str) && !this.mIsDebugMode) {
            DLog.w(TAG, "module id is empty.");
            if (l3 != null) {
                l3.onEngineInitializeError(9);
                return;
            }
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DynamicReporter.reportDynamicRenderGetBundleStart();
        ModuleInfo moduleInfo = ModuleConfigCache.getModuleInfo(this.mModuleId);
        this.mBundleInfo = moduleInfo;
        if (moduleInfo == null && !this.mIsDebugMode) {
            DLog.w(TAG, "module info not exists.");
            if (l3 != null) {
                l3.onEngineInitializeError(10);
            }
            DynamicReporter.reportDynamicRenderGetBundleEnd(uptimeMillis, TagValue.MODULE_NOT_EXIST);
            return;
        }
        if (this.mIsDebugMode) {
            handleCreateEngine(context, map, l3);
            DynamicReporter.reportDynamicRenderGetBundleEnd(uptimeMillis, "none");
            return;
        }
        int checkDependsVendor = checkDependsVendor(moduleInfo.getDependencies(), map);
        if (checkDependsVendor != 0) {
            DLog.w(TAG, "depends error. status: " + checkDependsVendor);
            if (l3 != null) {
                l3.onEngineInitializeError(checkDependsVendor);
            }
            DynamicReporter.reportDynamicRenderGetBundleEnd(uptimeMillis, TagValue.DEPENDS_NOT_EXIST);
            return;
        }
        DynamicReporter.reportDynamicRenderGetBundleEnd(uptimeMillis, "none");
        handleCreateEngine(context, map, l3);
    }

    public void createView(CreateViewInfo createViewInfo) {
        OnViewCreateExtraEventListener onViewCreateExtraEventListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) createViewInfo);
            return;
        }
        if (!this.mIsDebugMode && !checkParams(createViewInfo)) {
            if (createViewInfo != null && (onViewCreateExtraEventListener = createViewInfo.onViewCreateExtraEventListener) != null) {
                onViewCreateExtraEventListener.onViewCreateExtraEvent(ExtraEvent.EXTRA_EVENT_CHECK_PARAMS_FAIL, null);
            }
            DLog.w(TAG, "check params fail.");
            return;
        }
        handleViewCreate(createViewInfo);
    }

    public String getBundleVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ModuleInfo moduleInfo = this.mBundleInfo;
        if (moduleInfo == null) {
            return null;
        }
        return moduleInfo.getVersion();
    }

    public DKCustomAbilityProvider getCustomAbilityProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (DKCustomAbilityProvider) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mCustomAbilityProvider;
    }

    public abstract int getEngineGroupId();

    public int getEngineId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mEngineId;
    }

    public abstract DKEventCenter.EngineType getEngineType();

    public VideoLoader getVideoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (VideoLoader) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mVideoLoader;
    }

    protected abstract void handleCreateEngine(Context context, Map<String, String> map, L l3);

    protected abstract void handleViewCreate(CreateViewInfo createViewInfo);

    public abstract boolean isEnginePreWarmed();

    protected boolean isMatchVendor(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list)).booleanValue();
        }
        if (this.mVendorInfo == null && (list == null || list.isEmpty())) {
            return true;
        }
        if (this.mVendorInfo != null && (list == null || list.isEmpty())) {
            return false;
        }
        ModuleInfo moduleInfo = this.mVendorInfo;
        if ((moduleInfo == null || TextUtils.isEmpty(moduleInfo.getId())) && !list.isEmpty()) {
            return false;
        }
        return list.contains(this.mVendorInfo.getId());
    }

    public abstract boolean onBackPressed(BackPressHandler backPressHandler);

    public abstract void onDestroy();

    public abstract void onResume();

    public abstract void onStop();

    public boolean registerMethodHandler(DKMethodHandler dKMethodHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dKMethodHandler)).booleanValue();
        }
        return this.mMethodDispatcher.register(dKMethodHandler);
    }

    public abstract void sendEvent(String str, Object obj);

    public void setCustomAbilityProvider(DKCustomAbilityProvider dKCustomAbilityProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) dKCustomAbilityProvider);
        } else {
            this.mCustomAbilityProvider = dKCustomAbilityProvider;
        }
    }

    public void setVideoLoader(VideoLoader videoLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) videoLoader);
        } else {
            this.mVideoLoader = videoLoader;
        }
    }

    public boolean unregisterMethodHandler(DKMethodHandler dKMethodHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) dKMethodHandler)).booleanValue();
        }
        return this.mMethodDispatcher.unregister(dKMethodHandler);
    }

    public static String getTemplatePath(String str, String str2) {
        return TemplateManager.getInstance().getTemplatePath(str, false, 0L, str2);
    }

    public static String getTemplatePathRealTime(String str, long j3, String str2) {
        return TemplateManager.getInstance().getTemplatePath(str, true, j3, str2);
    }

    public void createView(Context context, Map<String, String> map, OnViewCreateListener onViewCreateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, map, onViewCreateListener);
            return;
        }
        CreateViewInfo createViewInfo = new CreateViewInfo();
        createViewInfo.context = context;
        createViewInfo.onViewCreateListener = onViewCreateListener;
        createViewInfo.params = map;
        createView(createViewInfo);
    }
}
