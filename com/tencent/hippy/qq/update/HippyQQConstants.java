package com.tencent.hippy.qq.update;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQConstants {
    public static final String APP_KEY = "mqq";
    public static final String APP_SECRET = "jV7Y5YGCkMY7lJt9B%@RkCDiXP8EjaFOjbQ4uytoy@JA3UNrV5YOoUFCdOz5cVLG";
    public static final String ARM64_V8A = "arm64-v8a";
    public static final String ARMEABI = "armeabi";
    public static final String CDN_UPDATE_FLAG = "cdnUpdate";
    public static final String COMPONENT_NAME = "Demo";
    public static final int CORE_JS_MISSING = -10;
    public static final int FRAGMENT_DESTROYED = -11;
    public static final String HIPPY_BID = "1011";
    public static final String HIPPY_CHANNEL = "10001";
    public static final String HIPPY_DEBUG_CORE_JS_DIR = "corejs/";
    public static final String HIPPY_DEBUG_SO_ARM64_DIR = "libs/arm64-v8a/";
    public static final String HIPPY_DEBUG_SO_ARMEABI_DIR = "libs/armeabi/";
    public static final String HIPPY_DEBUG_SO_DIR = "debugso";
    public static final String HIPPY_DEBUG_SO_DOWNLOAD_FILE_NAME = "hippyDebugSo.zip";
    public static final String HIPPY_DEBUG_SO_URL = "https://static.gamecenter.qq.com/xgame-hippy/dist/demo/android/hippy_debug_so_v2.15.21.zip";
    public static final int HIPPY_IS_PRELOADING = 3;
    public static final String HIPPY_LIBRARY_CDN = "https://static.res.qq.com/hippy/Library/HippyLibs.zip?v_bid=1011";
    public static final String HIPPY_LIB_ALL_IN_ONE = "hippy";
    public static final String HIPPY_LIB_BRIDGE = "hippy_qq_021306";
    public static final String HIPPY_LIB_FLEXBOX = "flexbox";
    public static final String HIPPY_LIB_FLEXBOX_DEBUG_SO = "libflexbox.so";
    public static final String HIPPY_LIB_HIPPY97V8 = "hippy97v8";
    public static final String HIPPY_LIB_HIPPY_DEBUG_SO = "libhippy.so";
    public static final String HIPPY_LIB_V8 = "v8_shared";
    public static final String HIPPY_PAGE_PARAM = "param";
    public static final String HIPPY_REACT = "react";
    public static final String HIPPY_ROOT_DIR = "hippy";
    public static final String HIPPY_SDK_TAG = "Hippy-sdk";
    public static final String HIPPY_SDK_VERSION = "3.0";
    public static final String HIPPY_TAG = "Hippy";
    public static final String HIPPY_VUE = "vue";
    public static final int JS_BUNDLE_NOT_EXIST = -13;
    public static final int JS_BUNDLE_TOO_OLD = -12;
    public static final String KEY_BUNDLE_NAME = "bundleName";
    public static final String KEY_BUNDLE_VERSION = "bundleVersion";
    public static final String KEY_RENDER_TAG = "renderTag";
    public static final int LIBRARY_DOWNLOAD_FAILED = -8;
    public static final int LIBRARY_LOAD_EXCEPTION = -9;
    public static final int LIBRARY_UNZIP_EXCEPTION = -7;
    public static final String MAIN_BUNDLE_NAME = "index.android.jsbundle";
    public static final String MODULE = "Demo";
    public static final String PARAMS_PAGE_HEIGHT = "hippy_page_height";
    public static final String REACT_CORE_BUNDLE_NAME = "react.android.js";
    public static final String SERVER = "https://hippy.html5.qq.com/update";
    public static final String STEP_NAME_ENTRANCE_SHOW = "entranceShow";
    public static final String STEP_NAME_INIT_ENGINE_END = "initEngineEnd";
    public static final String STEP_NAME_LOAD_HIPPY_START = "loadHippyStart";
    public static final String STEP_NAME_LOAD_LIBRARY_END = "loadLibEnd";
    public static final String STEP_NAME_LOAD_LIBRARY_START = "loadLibStart";
    public static final String STEP_NAME_LOAD_MODULE_END = "loadModuleEnd";
    public static final String STEP_NAME_LOAD_MODULE_START = "loadModuleStart";
    public static final String STEP_NAME_LOAD_SNAPSHOT_END = "loadSnapshotEnd";
    public static final String STEP_NAME_OPEN_PAGE_START = "openPageStart";
    public static final String STEP_NAME_PAGE_CREATE_START = "pageCreateStart";
    public static final String TEST_SERVER = "https://hippy.sparta.html5.qq.com/update";
    public static final int UPDATE_ERROR_CHECK_INFO = -5;
    public static final int UPDATE_ERROR_DOWNLOAD = -4;
    public static final int UPDATE_ERROR_DO_POST = -6;
    public static final int UPDATE_ERROR_FLOW_CONTROL = -14;
    public static final int UPDATE_ERROR_MD5 = -3;
    public static final int UPDATE_ERROR_PATCH = -2;
    public static final int UPDATE_ERROR_TIME_OUT = -15;
    public static final int UPDATE_ERROR_ZIP = -1;
    public static final int UPDATE_JS_BUNDLE_EXISTS = 101;
    public static final int UPDATE_OK = 0;
    public static final int UPDATE_PENDING_CHECK_INFO = 1;
    public static final int UPDATE_PRELOAD_NOT_ALLOWED = 2;
    public static final int UPDATE_UNKNOWN = 201;
    public static final String URL_COMPONENT_NAME = "component";
    public static final String URL_QUERY_PARAMETER_JS_TYPE = "framework";
    public static final String VUE_CORE_BUNDLE_NAME = "vue.android.js";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface EventNames {
        public static final String EVENT_THEME_MODE_CHANGED = "themeModeChanged";
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface GlobalVariables {
        public static final String BUNDLE_NAME = "bundleName";
        public static final String PSKEY = "p_skey";
        public static final String SKEY = "skey";
        public static final String SSR_BUNDLE_DATA = "ssrBundleData";
        public static final String SSR_BUNDLE_URL = "ssrBundleUrl";
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ModuleName {
        public static final String QQ_BIG_CLUB = "qqdhy";
        public static final String QQ_BOODO_COMIC = "QQBoodoComic";
        public static final String QQ_CM_GAME_PANEL = "minigameEntry";
        public static final String QQ_ERMAO_MALL = "QQGameCenterSingleMall";
        public static final String QQ_GAMECENTER_STRATEGYQA = "QQGameCenterStrategyQa";
        public static final String QQ_GAME_CENTER = "QQGameCenter";
        public static final String QQ_GAME_CENTER_DEBUG_TOOL = "QQGameCenterDebugTool";
        public static final String QQ_GAME_CENTER_MESSAGE = "QQGameCenterMessage";
        public static final String QQ_GAME_MIE = "MieActivity";
        public static final String QQ_GAME_PUBLICACCOUNT = "SGameOfficial";
        public static final String QQ_GAME_PUBLICACCOUNTV2 = "SGameOfficialV2";
        public static final String QQ_GAME_PUBLICACCOUNTV3 = "SGameOfficialV3";
        public static final String QQ_GAME_ZONE = "QQGameZone";
        public static final String QQ_GUILD = "QQGroupGameRank";
        public static final String QQ_GXH_AIO_DRESS_PAGE = "qqgxhaioDressPage";
        public static final String QQ_GXH_NUDGE_MALL = "qqgxhnudgeMall";
        public static final String QQ_GXH_WIDTH_DRAW_MSG = "qqgxhwithdrawMessage";
        public static final String QQ_LIVE_HALL = "QQLiveHall";
        public static final String QQ_META_DREAM = "QQGameCenterMetaDreamV2";
        public static final String QQ_MINI_BOX = "miniBox";
        public static final String QQ_MINI_GAME_CENTER = "miniGameCenter";
        public static final String QQ_MINI_GAME_PUBLICACCOUNT = "qqMiniGame";
        public static final String QQ_MINI_GAME_VIRTUAL = "miniGameVirtual";
        public static final String QQ_NEARBY = "QQNearby";
        public static final String QQ_NEARBY_GAME = "QQNearbyGameGroup";
        public static final String QQ_NEWS_PUBLICACCOUNT = "newsQqPlugin";
        public static final String QQ_PERSONALITY = "qqgxh";
        public static final String QQ_SHOP = "qqshop";
        public static final String QQ_SPORT = "qqSport";
        public static final String QQ_VAS_GUIDE_MODULE = "VasGuideQqgxhRecall";
        public static final String QQ_VAS_SQUARE = "QQSmallHouse";
        public static final String QQ_VIP = "QQVip";
        public static final String QQ_VIP_PAY = "QQVipPay";
        public static final String QQ_VIP_READER = "QQVipReader";
        public static final String QQ_VIP_SSR = "QQVipSSR";
        public static final String QQ_VIP_V2 = "QQVipV2";
        public static final String QQ_WEATHER = "qqWeather";
        public static final String QQ_YELLOW_VIP = "qqYellowDiamond";
        public static final String QQ_ZPLAN_PARADISE = "ZPlanHippyModule";
        public static final String QQ_ZPLAN_VAS_SMALL_HOME = "QQSmallHousePortal";
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface UpdateJsBundleResultCodes {
        public static final int UPDATE_RESULT_CODE_ERROR = -1;
        public static final int UPDATE_RESULT_CODE_NO_NEW_VERSION = 0;
        public static final int UPDATE_RESULT_CODE_OK = 1;
    }
}
