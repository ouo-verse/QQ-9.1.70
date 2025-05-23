package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WnsConfig {
    public static final String DEFAULT_DOMAIN_WHITE_LIST = ".qlogo.cn;.tcb.qcloud.la;open.mp.qq.com;api-report.q.qq.com;rpt.gdt.qq.com;.gtimg.cn";
    public static final String DEFAULT_ENABLE_UPDATE_EMBEDDED_APP_LIST = "1108711239;1108735743;1110465521";
    public static final int DEFAULT_ENABLE_UPDATE_FOR_EMBEDDED_WIDGET = 1;
    public static final int DEFAULT_MINI_APP_ENABLE_SHOW_CLEAN_CHECK_X5 = 1;
    public static final int DEFAULT_MINI_APP_ENABLE_SHOW_CLEAN_DELAY_TIME = 5000;
    public static final int DEFAULT_MINI_APP_ENABLE_SHOW_CLEAN_DETECT_WHITESCREEN = 0;
    public static final int DEFAULT_MINI_APP_ENABLE_SHOW_CLEAN_MAX_COUNT = 3;
    public static final int DEFAULT_MINI_APP_ENABLE_SHOW_CLEAN_ROUTEDONE = 1;
    public static final int DEFAULT_MINI_APP_ENABLE_SHOW_X5_DIALOG_ONROUTEDONE = 0;
    public static final int DEFAULT_MINI_APP_ENABLE_V8_SERVICE = 1;
    public static final int DEFAULT_MINI_APP_ENABLE_V8_SERVICE_DEBUG = 0;
    public static final int DEFAULT_MINI_APP_REPORT_WHITE_SCREEN_ENABLE_CLEAR_APKG_CACHE = 0;
    public static final int DEFAULT_MINI_APP_SHOW_X5_DIALOG_DELAY_TIME = 2000;
    public static final String DEFAULT_MINI_APP_V8RT_URL = "{ \"url\":\"https://downv6.qq.com/miniapp/v8_108/libtv8rt-230807-armeabi.so\",\"size\":403212,\"md5\":\"208c9c5d13b5b2d5269d804871500740\", \"url64\":\"https://downv6.qq.com/miniapp/v8_108/libtv8rt-230807-arm64.so\",\"size64\":526760,\"md564\":\"07429b46d55627c6588c78cd79c0d7e7\"}";
    public static final int DEFAULT_MINI_APP_XPROF_API_REPORT = 0;
    public static final String DEFAULT_MINI_GAME_BASELIB = "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20200323171054_1567/lib_1.13.0.00014.zip\",\"key2\":\"\",\"key3\":\"1.4.8\",\"key4\": {\"file_length\": 5591276},\"key5\":2}";
    public static final String DEFAULT_OPENDATA_DOMAIN_WHITE_LIST = ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la";
    public static final String DEFAULT_OPENURL_DOMAIN_WHITELIST = "tucao.qq.com,mobile.qzone.qq.com";
    public static final String DEFAULT_OPENURL_FILTER = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb|http://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb";
    public static final String DEFAULT_PRELAUNCH_WHITE_LIST = "1108291530,1109896843";
    public static final String DEFAULT_SET_COOKIIE_HOST = "https://open.mp.qq.com";
    public static final String MAIN_KEY_MINIAPP = "qqminiapp";
    public static final String MAIN_KEY_MINIAPP_QQ = "qqminiapp";
    public static final String MAIN_KEY_MINIGAME = "qqtriton";
    public static final String MAIN_KEY_QZONE_SETTING = "QZoneSetting";
    public static final String MAIN_KEY_QZONE_TEXT_SETTING = "QZoneTextSetting";
    public static final String MINI_APP_CAPSULE_CLOSE_DARK_URL = "closebuttondark";
    public static final String MINI_APP_CAPSULE_CLOSE_URL = "closebutton";
    public static final String MINI_APP_CHOOSE_ADDRESS_DEFAULT_URL = "https://i.qianbao.qq.com/profile/address/choose.html";
    public static final String MINI_APP_DOWNLOAD_HTTP_CONNECT_LIVE_TIME = "mini_app_download_http_connect_live_time";
    public static final String MINI_APP_DOWNLOAD_HTTP_THREADPOOL_SIZE = "mini_app_download_http_tp_size";
    public static final String MINI_APP_ENABLE_DB_CACHE = "mini_app_enable_db_cache";
    public static final String MINI_APP_ENABLE_JSERROR_TIP = "mini_app_jserror_tip_enable";
    public static final String MINI_APP_ENABLE_WHITE_SCREEN_CHECK_AFTER_DOMREADY = "mini_app_enable_white_screen_check_after_domready";
    public static final String MINI_APP_GOOGLE_PLAY_AD_SWITCH = "mini_app_google_play_ad_switch";
    public static final String MINI_APP_GOOGLE_PLAY_DOWNLOAD_SWITCH = "mini_app_google_play_download_switch";
    public static final String MINI_APP_GOOGLE_PLAY_LOAD_SO_SWITCH = "mini_app_google_play_load_so_switch";
    public static final String MINI_APP_GOOGLE_PLAY_PAY_SWITCH = "mini_app_google_play_pay_switch";
    public static final String MINI_APP_INNER_BASELIB_RETRY_COUNT = "mini_app_inner_baselib_retry_count";
    public static final String MINI_APP_KIINGCARD_DARK_LOTTIE = "kingcardGuideDarkLottie";
    public static final String MINI_APP_KIINGCARD_GUIDE_ICON = "kingcardGuideIcon";
    public static final String MINI_APP_KIINGCARD_GUIDE_TEXT = "kingcardGuideText";
    public static final String MINI_APP_KIINGCARD_LOTTIE = "kingcardGuideLottie";
    public static final String MINI_APP_NAVIGATE_BACK_BY_APPINFO = "mini_app_navigate_back_by_appinfo";
    public static final String MINI_APP_PRECACHE_PERIOD_MILLIS = "mini_app_precache_period_millis";
    public static final long MINI_APP_PRECACHE_PERIOD_MILLIS_DEFAULT = 43200000;
    public static final String MINI_APP_PRECACHE_RESOURCE_MAX_COUNT = "mini_app_precache_resource_maxsize";
    public static final int MINI_APP_PRECACHE_RESOURCE_MAX_COUNT_DEFAULT = 3;
    public static final String MINI_APP_PRECACHE_SIZE_LIMIT = "mini_app_precache_size_limit";
    public static final int MINI_APP_PRECACHE_SIZE_LIMIT_DEFAULT = 262144;
    public static final String MINI_APP_REPORT_COUNT_THRESHOLD = "mini_app_report_count_threshold";
    public static final String MINI_APP_REPORT_FIRST_FRAME_FLUSH = "mini_app_report_first_frame_flush";
    public static final String MINI_APP_REPORT_MAX_TIME_COST = "mini_app_report_max_time_cost";
    public static final String MINI_APP_REPORT_TIME_THRESHOLD = "mini_app_report_time_threshold";
    public static final String MINI_APP_REPORT_WHITE_SCREEN_ENABLE_CLEAR_APKG_CACHE = "mini_app_report_white_screen_enable_clear_apkg_cache";
    public static final String MINI_APP_REPORT_WHITE_SCREEN_TIME_CHECK = "mini_app_report_white_screen_check";
    public static final String MINI_APP_SCREEN_DETECT = "mini_app_screen_detect";
    public static final int MINI_APP_SCREEN_DETECT_DEFAULT = 1;
    public static final String MINI_APP_SHARE_TO_GUILD_BLACKLIST = "mini_app_share_to_guild_blacklist";
    public static final String MINI_APP_SHARE_TO_WX_SWITCHER = "mini_app_share_to_wx_switcher";
    public static final String MINI_APP_UPGRADE_URL = "mini_app_upgrade_url";
    public static final String MINI_APP_USE_DOWNLOAD_OPTIMIZE = "mini_app_use_download_optimize";
    public static final String MINI_APP_WHITE_SCREEN_SHOT_MAX_HEIGHT = "mini_app_white_screen_shot_max_height";
    public static final String MINI_APP_WHITE_SCREEN_SHOT_MAX_WIDTH = "mini_app_white_screen_shot_max_width";
    public static final String MINI_GAME_CAPSULE_RESTART_FREE_CACHE = "mini_game_capsule_restart_free_cache";
    public static final String MINI_GAME_CAPSULE_SHOW_RESTART_BTN = "mini_game_capsule_show_restart_btn";
    public static final String MINI_GAME_EXIT_CONFIRM_ANIMATION_EXPOSURE_TIMES_THRESHOLD = "mini_game_exit_confirm_animation_expoure_times_threshold";
    public static final String MINI_GAME_EXIT_CONFIRM_ANIMATION_IMAGE_URL = "mini_game_exit_confirm_animation_image_url";
    public static final String MINI_GAME_EXIT_CONFIRM_ANIMATION_SCENE_BLACK_LIST = "mini_game_exit_confirm_animation_scene_black_list";
    public static final String MINI_GAME_JANK_TRACE_SAMPLING_RATE = "mini_game_jank_trace_sampling_rate";
    public static final int MINI_GAME_JANK_TRACE_SAMPLING_RATE_DEFAULT = 100;
    public static final String MINI_GAME_MULTI_INSTANCE = "mini_game_multi_instance";
    public static final int MINI_GAME_MULTI_INSTANCE_DEFAULT = 1;
    public static final String MINI_GAME_PROCESS_REUSE = "mini_game_process_reuse";
    public static final String MINI_GAME_PROCESS_REUSE_BLACKLIST = "mini_game_process_reuse_blacklist";
    public static final int MINI_GAME_PROCESS_REUSE_DEFAULT = 1;
    public static final boolean MINI_HARD_CODER_ENABLED_DEFAULT = true;
    public static final int MINI_HARD_CODER_TIMEOUT_DEFAULT = 10000;
    public static final boolean MINI_LOW_LEVEL_DEVICE_FLUTTER_ENABLED_DEFAULT = false;
    public static final int MINI_LOW_LEVEL_DEVICE_THREAD_COUNT_DEFAULT = 2;
    public static final String SECONDARY_COMMENT_MAX_INPUT_CNT = "CommentMaxInputCnt";
    public static final String SECONDARY_KEY_MINIGAME_SHARE_RATE = "MiniGameShareRate";
    public static final String SECONDARY_KEY_MINIPROGRAM_VIDEO_CONTENTTYPE = "MiniProgramVideoContentType";
    public static final String SECONDARY_KEY_MINI_APP_AD_USE_TRANSCODING = "miniappadusetranscoding";
    public static final String SECONDARY_KEY_MINI_APP_CHOOSE_ADDRESS_URL = "miniappChooseAddressUrl";
    public static final String SECONDARY_KEY_MINI_APP_ENABLE_SHOW_CLEAN_ROUTEDONE = "mini_app_enable_show_clean_routedone";
    public static final String SECONDARY_KEY_MINI_APP_ENABLE_SHOW_X5_DIALOG_ONROUTEDONE = "mini_app_enable_show_x5_dialog_onroutedone";
    public static final String SECONDARY_KEY_MINI_APP_ENABLE_V8_SERVICE = "mini_app_enable_v8_service";
    public static final String SECONDARY_KEY_MINI_APP_ENABLE_V8_SERVICE_DEBUG = "mini_app_enable_v8_service_debug";
    public static final String SECONDARY_KEY_MINI_APP_SEARCH_APPID = "miniappsearchappid";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_CLEAN_CHECK_X5 = "mini_app_enable_show_clean_check_x5";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_CLEAN_DELAY_TIME = "mini_app_enable_show_clean_time_limit";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_CLEAN_DETECT_WHITESCREEN = "mini_app_enable_show_clean_detect_whitescreen";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_CLEAN_MAX_COUNT = "mini_app_enable_show_clean_max_count";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_FULL_SCREEN = "miniappshowfullscreen";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_X5_DIALOG_DELAY_TIME = "mini_app_enable_show_x5_dialog_time_limit";
    public static final String SECONDARY_KEY_MINI_APP_TOP_MAX_NUM = "miniappfullscreenminedatamaxnum";
    public static final String SECONDARY_KEY_MINI_APP_V8RT_URL = "mini_app_v8_rt_url";
    public static final String SECONDARY_KEY_MINI_APP_XPROF_API_REPORT = "xprof_api_report";
    public static final String SECONDARY_KEY_MINI_GAME_SDK_ENABLE_DOWNLOADER = "minigamesdkenabledownloader";
    public static final String SECONDARY_KEY_MINI_LOADING_AD_UNSUPPORT_VIA_LIST = "launch_adv_unsupport_via_list";
    public static final String SECONDARY_KEY_PRELAUNCH_WHITE_LIST = "prelaunch_white_list";
    public static final String SECONDARY_LOVESPACE_AIOGRAYTIPSLINKJUMPURL = "LoverBonusAIOGrayTipsLinkURL";
    public static final String SECONDARY_LOVESPACE_AIOGRAYTIPSLINKTEXT = "LoverBonusAIOGrayTipsLinkText";
    public static final String SECONDARY_LOVESPACE_AIOGRAYTIPSMAINTEXT = "LoverBonusAIOGrayTipsMainText";
    public static final String SECONDARY_MINI_APP_AD_GAME_START_LIMIT = "MiniAppGameStartLimit";
    public static final String SECONDARY_MINI_APP_AD_LAST_SHOW_LIMIT = "MiniAppLastShowLimit";
    public static final String SECONDARY_MINI_APP_AUTH_WHITELIST = "MiniAppAuthWhiteList";
    public static final String SECONDARY_MINI_APP_COOKIE_WHITE_APPID_LIST = "MiniAppCookieWhiteAppIdList";
    public static final String SECONDARY_MINI_APP_COOKIIE_WHITE_HOST_LIST = "MiniAppCookieWhiteHostList";
    public static final String SECONDARY_MINI_APP_COVER_TEXTVIEW_PADDING = "miniappcovertextviewpadding";
    public static final String SECONDARY_MINI_APP_DOMAIN_WHITE_LIST = "defaultAllowedHostList";
    public static final String SECONDARY_MINI_APP_ENABLE_INSTRUCTIONS = "MiniAppEnableInstructions";
    public static final String SECONDARY_MINI_APP_ENABLE_SCHEME_DEBUG = "enableSchemeDebug";
    public static final String SECONDARY_MINI_APP_FILE_STR = "MiniAppFileString";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_DOMAIN_BLACK_LIST = "ipv6_domain_black_list";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_DOMAIN_WHITE_LIST = "ipv6_domain_white_list";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_REFERER = "MiniAppIPv6OnlyForwardingReferer";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_URL = "ipv6_http_proxy_url";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_WNSCONFIG = "ipv6_proxy_enable";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_WSS_URL = "ipv6_websocket_proxy_url";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_PHOTO_AND_VIDEO_COUNT = "MiniAppMoodMaxPhotoAndVideoCount";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_PHOTO_SIZE = "MiniAppMoodMaxSinglePhotoSize";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_VIDEO_DURATION = "MiniAppMoodMaxSingleVideoDuration";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_VIDEO_SIZE = "MiniAppMoodMaxSingleVideoSize";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_TEXT_COUNT = "MiniAppMoodMaxTextCount";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_VIDEO_COUNT = "MiniAppMoodMaxVideoCount";
    public static final String SECONDARY_MINI_APP_OPENURL_DOMAIN_WHITELIST = "domainWhiteList";
    public static final String SECONDARY_MINI_APP_OPENURL_FILTER = "MiniAppOpenUrlFilter";
    public static final String SECONDARY_MINI_APP_RDM_DOMAIN_WHITE_LIST = "MiniAppRMDDomainWhiteList";
    public static final String SECONDARY_MINI_APP_RUNTIME_CACHE_MAX = "MiniAppRuntimeCacheMax";
    public static final int SECONDARY_MINI_APP_RUNTIME_CACHE_MAX_DEFAULT = 3;
    public static final String SECONDARY_MINI_APP_RUNTIME_RECYCLE_TIME = "mini_app_runtime_recycle_time";
    public static final long SECONDARY_MINI_APP_RUNTIME_RECYCLE_TIME_DEFAULT = 900000;
    public static final String SECONDARY_MINI_APP_WEBVIEWCCOMPONENT_ERRORPAGE = "https://m.q.qq.com/webview/error?url={url}&appid={appid}";
    public static final String SECONDARY_MINI_APP_WIKI_SCENE_CONFIG_MAP = "configSceneMap";
    public static final String SECONDARY_MINI_ENABLE_HOT_RELOAD = "MiniEnableHotReload";
    public static final String SECONDARY_MINI_ENABLE_UPDATE_EMBEDDED_APP_LIST = "enableUpdateEmbeddedAppList";
    public static final String SECONDARY_MINI_ENABLE_UPDATE_FOR_EMBEDDED_WIDGET = "enableUpdateForEmbeddedWidget";
    public static final String SECONDARY_MINI_GAME_APILOG_BLACKLIST = "MiniGameAPILogBlackList";
    public static final String SECONDARY_MINI_GAME_APILOG_WHITELIST = "MiniGameAPILogWhiteList";
    public static final String SECONDARY_MINI_GAME_BACK_PRESS_HINT = "MiniGameBackPressHint";
    public static final String SECONDARY_MINI_GAME_BACK_PRESS_HINT_LIST = "MiniGameBackPressHintList";
    public static final String SECONDARY_MINI_GAME_BANNER_AD_MIN_WIDTH = "MiniGameBannerAdMinWidth";
    public static final String SECONDARY_MINI_GAME_BASELIB = "MiniGameBaseLib";
    public static final String SECONDARY_MINI_GAME_BLACK_DETECT_INTERVAL = "MiniGameBlackDetectInterval";
    public static final String SECONDARY_MINI_GAME_BLACK_LIST = "MiniGameBlackList";
    public static final String SECONDARY_MINI_GAME_CACHE_FREE_DIALOG_CONTENT = "MiniGameCacheFreeDialogContent";
    public static final String SECONDARY_MINI_GAME_CODE_CACHE_ENABLE = "MiniGameCodeCacheEnable";
    public static final String SECONDARY_MINI_GAME_DEFAULT_PAY_SHARE_IMG = "MiniGameDefaultPayShareImg";
    public static final String SECONDARY_MINI_GAME_DEFAULT_PAY_SHARE_TITLE = "MiniGameDefaultPayShareTitle";
    public static final String SECONDARY_MINI_GAME_DEFAULT_SHARE_IMG = "MiniGameDefaultShareImg";
    public static final String SECONDARY_MINI_GAME_DEX_ENABLE = "MiniGameDexEnable";
    public static final String SECONDARY_MINI_GAME_DISABLE_HINT = "MiniGameDisableHint";
    public static final String SECONDARY_MINI_GAME_DOMAIN_NEED_CHECK_PORT = "MiniGameDomainNeedCheckPort";
    public static final String SECONDARY_MINI_GAME_DOMAIN_WHITELIST = "MiniGameDomainWhiteList";
    public static final String SECONDARY_MINI_GAME_ENABLE_OPENGLES3 = "enableOpengles3";
    public static final String SECONDARY_MINI_GAME_ENGINE_VERSION = "MiniGameEngineVersion";
    public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_BLACK = "MiniGameErrorDialogBlack";
    public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_CONTENT = "MiniGameErrorDialogContent";
    public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_ENABLE = "MiniGameErrorDialogEnable";
    public static final String SECONDARY_MINI_GAME_FAKE_FIRSTFRAME_URL = "MiniGameFakeFirstFrameUrl";
    public static final String SECONDARY_MINI_GAME_FRAME_NO_CHANGE_LIMIT = "MiniGameFrameNoChangeLimit";
    public static final String SECONDARY_MINI_GAME_GARY_RANGE = "MiniGameGaryRange";
    public static final String SECONDARY_MINI_GAME_JS_ERROR_DETECT_INTERVAL = "MiniGameJsErrorDetectInterval";
    public static final String SECONDARY_MINI_GAME_KILL_ALL_GAMES_WHEN_DESTROY = "MiniGameKillAllGamesWhenDestroy";
    public static final String SECONDARY_MINI_GAME_KILL_ALL_GAMES_WHEN_REUSE = "MiniGameKillAllGamesWhenReuse";
    public static final String SECONDARY_MINI_GAME_KILL_OTHER_GAMES_ON_START = "MiniGameKillOtherGamesOnStart";
    public static final String SECONDARY_MINI_GAME_LAUNCH_FAIL_DIALOG_CONTENT = "MiniGameLaunchFailDialogContent";
    public static final String SECONDARY_MINI_GAME_LOG_ENABLE = "MiniGameLogEnable";
    public static final String SECONDARY_MINI_GAME_MIN_SYS_VERSION = "MiniGameMinSysVersion";
    public static final String SECONDARY_MINI_GAME_NO_PRESENT_DURATION_LIMIT = "MiniGameNoPresentDurationLimit";
    public static final String SECONDARY_MINI_GAME_NO_PRESENT_TOUCH_LIMIT = "MiniGameNoPresentTouchLimit";
    public static final String SECONDARY_MINI_GAME_ONSHOW_REPORT_INTERVAL = "MiniGameOnShowReportInterval";
    public static final String SECONDARY_MINI_GAME_PAY_BY_H5 = "mini_game_pay_by_h5";
    public static final String SECONDARY_MINI_GAME_PAY_BY_H5_URL = "mini_game_pay_by_h5_url";
    public static final String SECONDARY_MINI_GAME_PAY_BY_H5_URL_LANDSCAPE = "mini_game_pay_by_h5_url_landscape";
    public static final String SECONDARY_MINI_GAME_PERSISTENT_DEBUG_VERSION_ENABLE = "MiniGamePersistentDebugVersionEnable";
    public static final String SECONDARY_MINI_GAME_PRELOAD_BASELIB_ENABLE = "MiniGamePreloadBaseLibEnable";
    public static final String SECONDARY_MINI_GAME_PRESENT_DETECT_INTERVAL = "MiniGamePresentDetectInterval";
    public static final String SECONDARY_MINI_GAME_STORAGE_EXCEED_DIALOG_ENABLE = "MiniGameStorageExceedDialogEnable";
    public static final String SECONDARY_MINI_GAME_STORAGE_EXCEED_LIMIT = "MiniGameStorageExceedLimit";
    public static final String SECONDARY_MINI_GAME_SUBPACK_RETRY_ON_COMPILE_COUNT = "MiniGameSubPackRetryOnCompileCount";
    public static final String SECONDARY_MINI_HARD_CODER_ENABLED = "mini_app_hard_coder_enabled";
    public static final String SECONDARY_MINI_HARD_CODER_TIMEOUT = "mini_app_hard_coder_timeout";
    public static final String SECONDARY_MINI_LOADING_AD_APP_AUTO_DOWNLOAD = "launch_adv_app_auto_download";
    public static final String SECONDARY_MINI_LOADING_AD_DURATION_TIME = "launch_adv_duration";
    public static final String SECONDARY_MINI_LOADING_AD_EXTRA_PRELOAD_INTERVAL = "launch_adv_app_preload_interval";
    public static final String SECONDARY_MINI_LOADING_AD_PRELOAD_LIMIT = "launch_adv_app_preload_limit";
    public static final String SECONDARY_MINI_LOADING_AD_PRELOAD_LIMIT_FOR_UIN = "launch_adv_user_preload_limit";
    public static final String SECONDARY_MINI_LOADING_AD_SELECT_LIMIT = "launch_adv_app_select_limit";
    public static final String SECONDARY_MINI_LOADING_AD_SELECT_LIMIT_FOR_UIN = "launch_adv_user_select_limit";
    public static final String SECONDARY_MINI_LOADING_AD_SKIP_TIME = "launch_adv_skip_time";
    public static final String SECONDARY_MINI_LOW_LEVEL_DEVICE_FLUTTER_ENABLED = "mini_app_low_level_device_flutter_enabled";
    public static final String SECONDARY_MINI_LOW_LEVEL_DEVICE_THREAD_COUNT = "mini_app_low_level_device_thread_count";
    public static final String SECONDARY_MINI_NEW_SCREEN_INFO = "MiniGameScreenInfo";
    public static final String SECONDARY_MINI_NEW_TEXT_PARSER = "MiniGameTextParser";
    public static final String SECONDARY_MINI_OPENDATA_DOMAIN_WHITE_LIST = "opendatahosts";
    public static final String SECONDARY_MINI_RECORD_DURATION_INTERVAL = "MiniRecordDurationInterval";
    public static final String SECONDARY_MINI_REPORT_DELAY_CHECK_DB = "MiniReportDelayCheckDB";
    public static final String SECONDARY_MINI_REPORT_DELAY_WAITING = "MiniReportDelayWaiting";
    public static final String SECONDARY_MINI_SHOW_TIMEOUT = "MiniShowTimeout";
    public static final String SECONDARY_MINI_STROE_SCENE_WHITELIST = "miniStoreSceneWhiteList";
    public static final String SECONDARY_SOUND_EFFECT_SWITCH = "FeedsSoundEffectSwitch";
    public static final String UNITY_SANDBOX_WHITELIST = "unity_sandbox_whitelist";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class DefaultValue {
        public static final boolean DEFAULT_COVER_TEXTVIEW_PADDING = true;
        public static final boolean DEFAULT_ENABLE_DB_CACHE = true;
        public static final String DEFAULT_MINIAPP_AUTH_LIST = "1108292102";
        public static final String DEFAULT_MINIAPP_COOKIE_LIST = "1108164955,1108291530,1109544007,1108338344,1108961705,1110426672,1110468841";
        public static final String DEFAULT_MINIAPP_FILE_STR = "wxfile://";
        public static final String DEFAULT_MINIAPP_RMD_DOMAIN_WHITE_LIST = "https://www.urlshare.cn/";
        public static final String DEFAULT_MINIAPP_WIKI_SCENE_CONFIG_MAP = "{}";
        public static final String DEFAULT_MINIGAME_DOMAIN_LIST = "\\S*\\.qq\\.com,thirdqq\\.qlogo\\.cn,c\\d{4}\\.myh5\\.90wmoyu\\.com,\\S*\\.gtimg\\.cn";
        public static final int DEFAULT_MINIGAME_DOMAIN_NEED_CHECK_PORT = 0;
        public static final int DEFAULT_MINIGAME_KILL_ALL_GAMES_WHEN_DESTROY = 0;
        public static final int DEFAULT_MINIGAME_KILL_ALL_GAMES_WHEN_REUSE = 0;
        public static final int DEFAULT_MINIGAME_KILL_OTHER_GAMES_ON_START = 0;
        public static final int DEFAULT_MINIGAME_SHARE_RATE = 53;
        public static final String DEFAULT_MINIPROGRAM_VIDEO_CONTENT_TYPE = "application/octet-stream; charset=utf-8";
        public static final int DEFAULT_MINI_APP_ENABLE_INSTRUCTIONS = 0;
        public static final String DEFAULT_MINI_APP_IPV6ONLY_DOMAIN_BLACK_LIST = ".idqqimg.com,.qq.com";
        public static final String DEFAULT_MINI_APP_IPV6ONLY_DOMAIN_WHITE_LIST = ".huanle.qq.com";
        public static final String DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_REFERER = "https://appservice.qq.com";
        public static final String DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_URL = "https://proxy.gtimg.cn/tx_tls_gate=";
        public static final int DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_WNSCONFIG_ENABLE = 0;
        public static final String DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_WSS_URL = "wss://proxy.gtimg.cn/tx_tls_gate=";
        public static final String DEFAULT_MINI_APP_SEARCH_APPID = "1109875297";
        public static final int DEFAULT_MINI_APP_SHOW_FULL_SCREEN = 1;
        public static final int DEFAULT_MINI_APP_SHOW_OLD_LAYOUT = 0;
        public static final int DEFAULT_MINI_APP_TOP_MAX_NUM = 50;
        public static final boolean DEFAULT_MINI_ENABLE_DEX = true;
        public static final int DEFAULT_MINI_ENABLE_HOT_RELOAD = 1;
        public static final boolean DEFAULT_MINI_ENABLE_LOG = true;
        public static final int DEFAULT_MINI_ENABLE_OPENGLES3 = 1;
        public static final String DEFAULT_MINI_GAME_BACK_PRESS_HINT = "\u518d\u6309\u4e00\u6b21\u8fd4\u56de\u952e\u9000\u51fa\u8be5\u7a0b\u5e8f";
        public static final String DEFAULT_MINI_GAME_BACK_PRESS_HINT_LIST = "1108292102";
        public static final int DEFAULT_MINI_GAME_BANNER_AD_MIN_WIDTH = 300;
        public static final int DEFAULT_MINI_GAME_BLACK_DETECT_INTERVAL = 3000;
        public static final String DEFAULT_MINI_GAME_BLACK_LIST = "[GT-I9502]";
        public static final String DEFAULT_MINI_GAME_CACHE_FREE_DIALOG_CONTENT = "\u6e38\u620f\u5b58\u50a8\u5f02\u5e38,\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f";
        public static final boolean DEFAULT_MINI_GAME_CODE_CACHE_ENABLE = true;
        public static final String DEFAULT_MINI_GAME_DISABLE_HINT = "\u8be5\u5c0f\u6e38\u620f\u6b63\u5728\u5347\u7ea7\u4e2d\uff0c\u5148\u53bb\u73a9\u73a9\u5176\u4ed6\u5c0f\u6e38\u620f\u5427";
        public static final String DEFAULT_MINI_GAME_ERROR_DIALOG_BLACK = "";
        public static final String DEFAULT_MINI_GAME_ERROR_DIALOG_CONTENT = "\u6e38\u620f\u5f02\u5e38\u505c\u6b62, \u662f\u5426\u9700\u8981\u91cd\u542f\u6e38\u620f?";
        public static final int DEFAULT_MINI_GAME_ERROR_DIALOG_ENABLE = 1;
        public static final int DEFAULT_MINI_GAME_FRAME_NO_CHANGE_LIMIT = 5;
        public static final String DEFAULT_MINI_GAME_GARY_RANGE = "0-100";
        public static final int DEFAULT_MINI_GAME_JS_ERROR_DETECT_INTERVAL = 5000;
        public static final String DEFAULT_MINI_GAME_LAUNCH_FAIL_DIALOG_CONTENT = "\u6e38\u620f\u52a0\u8f7d\u5f02\u5e38\uff0c\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f";
        public static final int DEFAULT_MINI_GAME_MINI_SYS_VERSION = 18;
        public static final int DEFAULT_MINI_GAME_NO_PRESENT_DURATION_LIMIT = 5000;
        public static final int DEFAULT_MINI_GAME_NO_PRESENT_TOUCH_LIMIT = 3;
        public static final long DEFAULT_MINI_GAME_ONSHOW_REPORT_INTERVAL = 2000;
        public static final int DEFAULT_MINI_GAME_PAY_BY_H5 = 0;
        public static final String DEFAULT_MINI_GAME_PAY_BY_H5_URL = "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&aid={aid}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17301504&_wwv=1";
        public static final String DEFAULT_MINI_GAME_PAY_BY_H5_URL_LANDSCAPE = "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&aid={aid}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17303552&_wwv=1";
        public static final int DEFAULT_MINI_GAME_PAY_BY_NATIVE = 1;
        public static final String DEFAULT_MINI_GAME_PAY_SHARE_IMG = "https://sola.gtimg.cn/aoi/sola/20200615194538_YYA1zqPM8t.png";
        public static final String DEFAULT_MINI_GAME_PAY_SHARE_TITLE = "\u4eb2\u7231\u7684\uff0c\u62dc\u6258\u4f60\u5e2e\u6211\u4ee3\u4ed8\u4e00\u7b14\u8ba2\u5355\uff5e";
        public static final int DEFAULT_MINI_GAME_PERSISTENT_DEBUG_VERSION_ENABLE = 1;
        public static final int DEFAULT_MINI_GAME_PRELOAD_BASELIB_ENABLE = 1;
        public static final int DEFAULT_MINI_GAME_PRESENT_DETECT_INTERVAL = 1000;
        public static final int DEFAULT_MINI_GAME_SDK_ENABLE_DOWNLOADER = 1;
        public static final String DEFAULT_MINI_GAME_SHARE_IMG = "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png";
        public static final int DEFAULT_MINI_GAME_STORAGE_EXCEED_DIALOG_ENABLE = 0;
        public static final int DEFAULT_MINI_GAME_STORAGE_EXCEED_LIMIT = 3;
        public static final int DEFAULT_MINI_GAME_SUBPACK_RETRY_ON_COMPILE_COUNT = 1;
        public static final long DEFAULT_MINI_RECORD_DURATION_INTERVAL = 5000;
        public static final long DEFAULT_MINI_REPORT_DELAY_CHECK_DB = 1000;
        public static final long DEFAULT_MINI_REPORT_DELAY_WAITING = 2000;
        public static final long DEFAULT_MINI_SHOW_TIMEOUT = 45000;
        public static final String DEFAULT_MINI_STROE_SCENE_WHITELIST = "1001,2050,2009,3002,3003";
        public static final int DEFAULT_NAVIGATE_BACK_BY_APPINFO = 1;

        public DefaultValue() {
        }
    }

    public static final String getConfig(String str, String str2) {
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy == null) {
            return null;
        }
        return wnsConfigProxy.getConfig(str, str2);
    }

    public static final String getConfig(String str, String str2, String str3) {
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy == null) {
            return str3;
        }
        String config = wnsConfigProxy.getConfig(str, str2);
        return TextUtils.isEmpty(config) ? str3 : config;
    }

    public static int getConfig(String str, String str2, int i3) {
        String config;
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy == null || (config = wnsConfigProxy.getConfig(str, str2)) == null) {
            return i3;
        }
        try {
            return Integer.parseInt(config);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static long getConfig(String str, String str2, long j3) {
        String config;
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy == null || (config = wnsConfigProxy.getConfig(str, str2)) == null) {
            return j3;
        }
        try {
            return Long.valueOf(config).longValue();
        } catch (Exception unused) {
            return j3;
        }
    }

    public static float getConfig(String str, String str2, float f16) {
        String config;
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy == null || (config = wnsConfigProxy.getConfig(str, str2)) == null) {
            return f16;
        }
        try {
            return Float.valueOf(config).floatValue();
        } catch (Exception unused) {
            return f16;
        }
    }

    public static boolean getConfig(String str, String str2, boolean z16) {
        String config;
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy == null || (config = wnsConfigProxy.getConfig(str, str2)) == null) {
            return z16;
        }
        try {
            return Boolean.parseBoolean(config);
        } catch (Exception unused) {
            return z16;
        }
    }
}
