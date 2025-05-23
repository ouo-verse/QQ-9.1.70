package com.tencent.mobileqq.mini.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniReportManager {
    private static final Map<String, List<String>> APPID_JS_ERROR_MAP;
    public static final String APP_TYPE_MINI_APP = "0";
    public static final String APP_TYPE_MINI_GAME = "1";
    private static final String TAG = "MiniReportManager";
    public static HashMap<String, MiniAppLaunchState> launchStateMap;
    static final int MAX_TIME_COST = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_max_time_cost", 120000);
    static final String REPORT_EVENT_CONFIG = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_REPORT_EVENT_CONFIG, "");
    private static SparseArray<String> eventNameSparseArray = new SparseArray<>();
    private static ArrayList<Integer> eventNeedRecordTime = new ArrayList<>();
    private static SparseArray<CostTimeRecord> eventCostTimeSparseArray = new SparseArray<>();
    private static ArrayList<String> eventNameToDC5332 = new ArrayList<>();
    private static ArrayList<String> eventNameNotToDC4266 = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class CostTimeRecord {
        public String eventName;
        public int eventStart;

        public CostTimeRecord(String str, int i3) {
            this.eventName = str;
            this.eventStart = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class EventId {
        public static final int APKG_DOWNLOAD_PIPELINE_END = 125;
        public static final int APKG_DOWNLOAD_PIPELINE_START = 124;
        public static final int APP_CREATE = 24;
        public static final int APP_DOWNLOAD_END = 620;
        public static final int APP_DOWNLOAD_START = 619;
        public static final int APP_EMBEDDED_LIVE_PLAYER = 710;
        public static final int APP_EMBEDDED_LIVE_PLAYER_RESULT = 711;
        public static final int APP_EMBEDDED_VIDEO = 700;
        public static final int APP_EMBEDDED_VIDEO_RESULT = 701;
        public static final int APP_ERR_WHITE_SCREEN = 150;
        public static final int APP_EXIT = 22;
        public static final int APP_FIRST_NEWPAGE_RESULT = 638;
        public static final int APP_FIRST_RENDER_RESULT = 636;
        public static final int APP_FIRST_RE_RENDER_RESULT = 637;
        public static final int APP_FIRST_STORAGE_USAGE = 639;
        public static final int APP_LOAD_END = 105;
        public static final int APP_LOAD_FAIL = 609;
        public static final int APP_LOAD_START = 104;
        public static final int APP_LOAD_SUCC = 608;
        public static final int APP_LOAD_TIMEOUT = 610;
        public static final int APP_ROUTE_DONE = 121;
        public static final int APP_STAY_DURATION = 644;
        public static final int APP_UNZIP_END = 622;
        public static final int APP_UNZIP_START = 621;
        public static final int BASE_JS_DOWNLOAD_END = 5;
        public static final int BASE_JS_DOWNLOAD_FAILED = 617;
        public static final int BASE_JS_DOWNLOAD_START = 4;
        public static final int BASE_JS_LOAD_END = 17;
        public static final int BASE_JS_LOAD_START = 16;
        public static final int BASE_JS_READ_END = 9;
        public static final int BASE_JS_READ_START = 8;
        public static final int BASE_JS_UNZIP_END = 7;
        public static final int BASE_JS_UNZIP_FAILED = 618;
        public static final int BASE_JS_UNZIP_START = 6;
        public static final int CAPSULE_BUTTON_CLOSE_CLICK = 1025;
        public static final int CPU_PERFORMANCE = 629;
        public static final int DOM_READY = 611;
        public static final int FPS_PERFORMANCE = 630;
        public static final int FPS_VARIANCE = 642;
        public static final int GET_APKG_INFO_END = 13;
        public static final int GET_APKG_INFO_START = 12;
        public static final int HIDE = 20;
        public static final int HTTP_DOWNLOAD = 640;
        public static final int HTTP_REQUEST_RESULT = 628;
        public static final int HTTP_UPLOAD = 641;
        public static final int JS_ERROR = 23;
        public static final int LAUNCH_END = 2;
        public static final int LAUNCH_START = 1;
        public static final int LOADING_PAGE_CLOSE_CLICK = 1026;
        public static final int MEMORY_GROWTH = 643;
        public static final int MEMORY_PERFORMANCE = 631;
        public static final int MINI_APP_DOWNLOAD_WITH_CACHE = 1044;
        public static final int MINI_APP_START_BY_CACHE = 1028;
        public static final int MINI_GAME_BASE_LIB_INSTALL_SKIP = 1012;
        public static final int MINI_GAME_BASE_LIB_LOAD_JAR = 1003;
        public static final int MINI_GAME_BASE_LIB_LOAD_JAR_END = 1004;
        public static final int MINI_GAME_BASE_LIB_LOAD_JS = 1005;
        public static final int MINI_GAME_BASE_LIB_LOAD_JS_END = 1006;
        public static final int MINI_GAME_BASE_LIB_LOAD_SO = 1001;
        public static final int MINI_GAME_BASE_LIB_LOAD_SO_END = 1002;
        public static final int MINI_GAME_BLACK_SCREEN = 1018;
        public static final int MINI_GAME_ENTER_LOADING_PAGE = 1013;
        public static final int MINI_GAME_ERROR_DIALOG = 1024;
        public static final int MINI_GAME_FIRST_LAUNCH = 1022;
        public static final int MINI_GAME_FIRST_STAY_DURATION = 1020;
        public static final int MINI_GAME_IMAGE_DOWNLOAD = 1027;
        public static final int MINI_GAME_LOADSUBPACKAGE_IMPOSSIBLE = 1029;
        public static final int MINI_GAME_LOAD_BASE_LIB = 1014;
        public static final int MINI_GAME_LOAD_BASE_LIB_END = 1015;
        public static final int MINI_GAME_LOAD_MAIN_PKG = 1007;
        public static final int MINI_GAME_LOAD_MAIN_PKG_END = 1008;
        public static final int MINI_GAME_LOAD_SO_EXCEPTION = 1050;
        public static final int MINI_GAME_LOAD_SUB_PKG = 1009;
        public static final int MINI_GAME_LOAD_SUB_PKG_END = 1010;
        public static final int MINI_GAME_NO_REFRESH = 1019;
        public static final int MINI_GAME_ON_FIRST_HIDE = 1016;
        public static final int MINI_GAME_PROGRESS_ERROR = 1011;
        public static final int MINI_GAME_STAY_DURATION = 1021;
        public static final int MINI_GAME_SURVIVAL = 1017;
        public static final int MINI_GAME_TWICE_LAUNCH = 1023;
        public static final int MINI_SEARCH_DF_LAUNCH = 1060;
        public static final int MINI_SEARCH_DF_LOAD_END = 1063;
        public static final int MINI_SEARCH_DF_LOAD_START = 1062;
        public static final int MINI_SEARCH_DF_RESULT = 1061;
        public static final int PAGE_CLICK = 612;
        public static final int PAGE_FRAME_LOAD_END = 624;
        public static final int PAGE_FRAME_LOAD_START = 623;
        public static final int PAGE_HIDE = 607;
        public static final int PAGE_JS_LOAD_END = 123;
        public static final int PAGE_JS_LOAD_START = 122;
        public static final int PAGE_LOAD_END = 645;
        public static final int PAGE_LOAD_RESULT = 646;
        public static final int PAGE_SHOW = 606;
        public static final int PRELOAD_PROCESS = 605;
        public static final int PRELOAD_PROCESS_END = 627;
        public static final int PRELOAD_PROCESS_START = 626;
        public static final int SERVICE_APP_END = 105;
        public static final int SERVICE_APP_START = 104;
        public static final int SERVICE_CREATE_END = 101;
        public static final int SERVICE_CREATE_START = 100;
        public static final int SERVICE_JS_LOAD_END = 15;
        public static final int SERVICE_JS_LOAD_START = 14;
        public static final int SERVICE_JS_READ_END = 11;
        public static final int SERVICE_JS_READ_START = 10;
        public static final int SHOW = 21;
        public static final int SSO_CMD_END = 601;
        public static final int SSO_CMD_RESULT = 599;
        public static final int SSO_CMD_START = 600;
        public static final int STEP_CREATE_SURFACEVIEW = 1039;
        public static final int STEP_FIRST_FRAME_FROM_CREATE = 1043;
        public static final int STEP_FIRST_FRAME_FROM_GAME_LAUNCHED = 1042;
        public static final int STEP_INIT_DATA_MUST_ONRESUME = 1032;
        public static final int STEP_INIT_JS_PLUGINLIST = 1034;
        public static final int STEP_INIT_JS_PLUGIN_ENGINE = 1038;
        public static final int STEP_INIT_RUNTIME = 1037;
        public static final int STEP_LAUNCH_GAME = 1040;
        public static final int STEP_LOAD_BASELIB = 1033;
        public static final int STEP_LOAD_GPKG = 1036;
        public static final int STEP_ONCREATE = 1031;
        public static final int STEP_ONRESUME = 1035;
        public static final int STEP_START_ACTIVITY = 1030;
        public static final int SUB_PACKAGE_DOWNLOAD_END = 614;
        public static final int SUB_PACKAGE_DOWNLOAD_START = 613;
        public static final int SUB_PACKAGE_UNPACK_END = 616;
        public static final int SUB_PACKAGE_UNPACK_START = 615;
        public static final int WEBVIEW_APP_END = 107;
        public static final int WEBVIEW_APP_START = 106;
        public static final int WEBVIEW_CREATE_END = 103;
        public static final int WEBVIEW_CREATE_START = 102;
        public static final int WEBVIEW_INIT = 625;
        public static final int WEBVIEW_JS_LOAD_END = 19;
        public static final int WEBVIEW_JS_LOAD_START = 18;
        public static final int WEB_SOCKET_CLOSE = 633;
        public static final int WEB_SOCKET_FAILURE = 634;
        public static final int WEB_SOCKET_OPEN = 632;
        public static final int X5_INSTALL_FAIL = 603;
        public static final int X5_INSTALL_SUCCESS = 602;
        public static final int X5_INSTALL_TIMEOUT = 604;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class EventName {
        public static final String APKG_DOWNLOAD_PIPELINE_END = "apkg_download_pipeline_end";
        public static final String APKG_DOWNLOAD_PIPELINE_RESULT = "apkg_download_pipeline_result";
        public static final String APKG_DOWNLOAD_PIPELINE_START = "apkg_download_pipeline_start";
        public static final String APP_CREATE = "appcreate";
        public static final String APP_DOWNLOAD_END = "appdownloadend";
        public static final String APP_DOWNLOAD_RESULT = "app_download_result";
        public static final String APP_DOWNLOAD_START = "appdownloadstart";
        public static final String APP_EMBEDDED_LIVE = "miniappembeddedlive";
        public static final String APP_EMBEDDED_LIVE_RESULT = "miniappembeddedliveresult";
        public static final String APP_EMBEDDED_VIDEO = "miniappembeddedvideo";
        public static final String APP_EMBEDDED_VIDEO_RESULT = "miniappembeddedvideoresult";
        public static final String APP_ERR_WHITE_SCREEN = "app_err_white_screen";
        public static final String APP_EXIT = "apponunload";
        public static final String APP_FIRST_NEWPAGE_RESULT = "newpage_result";
        public static final String APP_FIRST_RENDER_RESULT = "first_render_result";
        public static final String APP_FIRST_RE_RENDER_RESULT = "re_render_result";
        public static final String APP_FIRST_STORAGE_USAGE = "storage_usage";
        public static final String APP_LOAD_END = "app_load_end";
        public static final String APP_LOAD_FAIL = "onlaunchfail";
        public static final String APP_LOAD_START = "app_load_start";
        public static final String APP_LOAD_SUCC = "onlaunchsucc";
        public static final String APP_LOAD_TIMEOUT = "onlaunchtimeout";
        public static final String APP_ROUTE_DONE = "app_route_done";
        public static final String APP_STAY_DURATION = "miniappstaytime";
        public static final String APP_UNZIP_END = "appunzipend";
        public static final String APP_UNZIP_RESULT = "app_unzip_result";
        public static final String APP_UNZIP_START = "appunzipstart";
        public static final String BASEJS_DOWNLOAD_RESULT = "basejs_download_result";
        public static final String BASEJS_UNZIP_RESULT = "basejs_unzip_result";
        public static final String BASE_JS_DOWNLOAD_END = "basejsdownloadend";
        public static final String BASE_JS_DOWNLOAD_FAILED = "basejsdownloadfailed";
        public static final String BASE_JS_DOWNLOAD_START = "basejsdownloadstart";
        public static final String BASE_JS_LOAD_END = "basejsready";
        public static final String BASE_JS_LOAD_START = "basejsstart";
        public static final String BASE_JS_READ_END = "basejsreadend";
        public static final String BASE_JS_READ_START = "basejsreadstart";
        public static final String BASE_JS_UNZIP_END = "basejsunzipend";
        public static final String BASE_JS_UNZIP_FAILED = "basejsunzipfailed";
        public static final String BASE_JS_UNZIP_START = "basejsunzipstart";
        public static final String CAPSULE_BUTTON_CLOSE_CLICK = "capsulebuttoncloseclick";
        public static final String CPU_PERFORMANCE = "cpuPerformance";
        public static final String DOM_READY = "domready";
        public static final String FPS_PERFORMANCE = "fpsPerformance";
        public static final String FPS_VARIANCE = "fpsVariance";
        public static final String GAME_AFTER_LAUNCH_TIME_COST = "game_after_launch_time_cost";
        public static final String GAME_FIRST_LAUNCH_RESULT = "game_first_launch_result";
        public static final String GAME_TWICE_LAUNCH_RESULT = "game_twice_launch_result";
        public static final String GET_APKG_INFO_END = "appconfigreadend";
        public static final String GET_APKG_INFO_START = "appconfigreadstart";
        public static final String HIDE = "apponhide";
        public static final String HTTP_DOWNLOAD = "http_download";
        public static final String HTTP_REQUEST_RESULT = "http_request_result";
        public static final String HTTP_UPLOAD = "http_upload";
        public static final String JS_ERROR = "jsonerror";
        public static final String LAUNCH_END = "apponloaded";
        public static final String LAUNCH_RESULT = "launch_result";
        public static final String LAUNCH_START = "onlaunch";
        public static final String LOADING_PAGE_CLOSE_CLICK = "loadingpagecloseclick";
        public static final String MEMORY_GROWTH = "memoryGrowth";
        public static final String MEMORY_PERFORMANCE = "memoryPerformance";
        public static final String MINI_APP_DOWNLOAD_WITH_CACHE = "download_with_cache";
        public static final String MINI_APP_START_BY_CACHE = "miniappstartbycache";
        public static final String MINI_GAME_BASE_LIB_INSTALL_SKIP = "minigamebaselibinstallskip";
        public static final String MINI_GAME_BASE_LIB_LOAD_JAR = "minigamebaselibloadjar";
        public static final String MINI_GAME_BASE_LIB_LOAD_JAR_END = "minigamebaselibloadjarend";
        public static final String MINI_GAME_BASE_LIB_LOAD_JS = "minigamebaselibloadjs";
        public static final String MINI_GAME_BASE_LIB_LOAD_JS_END = "minigamebaselibloadjsend";
        public static final String MINI_GAME_BASE_LIB_LOAD_SO = "minigamebaselibloadso";
        public static final String MINI_GAME_BASE_LIB_LOAD_SO_END = "minigamebaselibloadsoend";
        public static final String MINI_GAME_BLACK_SCREEN = "minigameblackscreen";
        public static final String MINI_GAME_ENTER_LOADING_PAGE = "minigameenterloadingpage";
        public static final String MINI_GAME_ERROR_DIALOG = "minigameerrordialog";
        public static final String MINI_GAME_FIRST_LAUNCH = "minigamefirstlaunch";
        public static final String MINI_GAME_FIRST_STAY_DURATION = "minigamefirststaytime";
        public static final String MINI_GAME_IMAGE_DOWNLOAD = "minigameimagedownload";
        public static final String MINI_GAME_LOADSUBPACKAGE_IMPOSSIBLE = "minigameloadsubpack_impossible";
        public static final String MINI_GAME_LOAD_BASE_LIB = "minigameloadbaselib";
        public static final String MINI_GAME_LOAD_BASE_LIB_END = "minigameloadbaselibend";
        public static final String MINI_GAME_LOAD_MAIN_PKG = "minigameloadmainpkg";
        public static final String MINI_GAME_LOAD_MAIN_PKG_END = "minigameloadmainpkgend";
        public static final String MINI_GAME_LOAD_SO_EXCEPTION = "game_load_so_exception";
        public static final String MINI_GAME_LOAD_SUB_PKG = "minigameloadsubpkg";
        public static final String MINI_GAME_LOAD_SUB_PKG_END = "minigameloadsubpkgend";
        public static final String MINI_GAME_NO_REFRESH = "minigamenorefresh";
        public static final String MINI_GAME_ON_FIRST_HIDE = "minigamefirsthide";
        public static final String MINI_GAME_PROGRESS_ERROR = "minigameprogresserror";
        public static final String MINI_GAME_STAY_DURATION = "minigamestaytime";
        public static final String MINI_GAME_SURVIVAL = "minigamesurvival";
        public static final String MINI_GAME_TWICE_LAUNCH = "minigametwicelaunch";
        public static final String MINI_SEARCH_DF_LAUNCH = "mini_search_df_launch";
        public static final String MINI_SEARCH_DF_LOAD_END = "mini_search_df_load_end";
        public static final String MINI_SEARCH_DF_LOAD_RESULT = "mini_search_df_load_result";
        public static final String MINI_SEARCH_DF_LOAD_START = "mini_search_df_load_start";
        public static final String MINI_SEARCH_DF_RESULT = "mini_search_df_result";
        public static final String PAGE_CLICK = "pageclick";
        public static final String PAGE_FRAME_LOAD_END = "pageframeloadend";
        public static final String PAGE_FRAME_LOAD_START = "pageframeloadstart";
        public static final String PAGE_HIDE = "pagehide";
        public static final String PAGE_JS_END = "page_js_end";
        public static final String PAGE_JS_START = "page_js_start";
        public static final String PAGE_LOAD_END = "pageloadend";
        public static final String PAGE_LOAD_RESULT = "page_load_result";
        public static final String PAGE_SHOW = "pageshow";
        public static final String PRELOAD_PROCESS = "preloadprocess";
        public static final String PRELOAD_PROCESS_END = "preload_process_end";
        public static final String PRELOAD_PROCESS_START = "preload_process_start";
        public static final String PRELOAD_RESULT = "preload_result";
        public static final String SERVICE_APP_END = "service_app_end";
        public static final String SERVICE_APP_START = "service_app_start";
        public static final String SERVICE_END = "service_end";
        public static final String SERVICE_JS_LOAD_END = "servicejsend";
        public static final String SERVICE_JS_LOAD_START = "servicejsstart";
        public static final String SERVICE_START = "service_start";
        public static final String SHOW = "apponshow";
        public static final String SSO_CMD_END = "ssocmdend";
        public static final String SSO_CMD_RESULT = "ssocmdresult";
        public static final String SSO_CMD_START = "ssocmdstart";
        public static final String STEP_CREATE_SURFACEVIEW = "stepcreatesurfaceview";
        public static final String STEP_FIRST_FRAME_FROM_CREATE = "stepfirstframefromcreate";
        public static final String STEP_FIRST_FRAME_FROM_GAME_LAUNCHED = "stepfirstframefromgamelaunched";
        public static final String STEP_INIT_DATA_MUST_ONRESUME = "stepinitdatamustonresume";
        public static final String STEP_INIT_JS_PLUGINLIST = "stepinitjspluginlist";
        public static final String STEP_INIT_JS_PLUGIN_ENGINE = "stepinitjspluginengine";
        public static final String STEP_INIT_RUNTIME = "stepinitruntime";
        public static final String STEP_LAUNCH_GAME = "steplaunchgame";
        public static final String STEP_LOAD_BASELIB = "steploadbaselibtimecost";
        public static final String STEP_LOAD_GPKG = "steploadgpkg";
        public static final String STEP_ONCREATE = "steponcreate";
        public static final String STEP_ONRESUME = "steponresume";
        public static final String STEP_START_ACTIVITY = "stepstartactivity";
        public static final String SUB_DOWNLOAD_RESULT = "sub_download_result";
        public static final String SUB_PACKAGE_DOWNLOAD_END = "subpkgdownloadend";
        public static final String SUB_PACKAGE_DOWNLOAD_START = "subpkgdownloadstart";
        public static final String SUB_PACKAGE_UNPACK_END = "subpkgunpackend";
        public static final String SUB_PACKAGE_UNPACK_START = "subpkgunpackstart";
        public static final String WEBVIEW_APP_END = "webview_app_end";
        public static final String WEBVIEW_APP_START = "webview_app_start";
        public static final String WEBVIEW_CREATE_END = "webview_end";
        public static final String WEBVIEW_JS_LOAD_END = "webviewjsready";
        public static final String WEBVIEW_JS_LOAD_START = "webviewjsstart";
        public static final String WEBVIEW_START = "webview_start";
        public static final String WEB_SOCKET_CLOSE = "web_socket_close";
        public static final String WEB_SOCKET_FAILURE = "web_socket_failure";
        public static final String WEB_SOCKET_OPEN = "web_socket_open";
        public static final String X5_INSTALL_FAIL = "x5installfail";
        public static final String X5_INSTALL_SUCCESS = "x5installsuccess";
        public static final String X5_INSTALL_TIMEOUT = "x5installtimeout";
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MiniAppLaunchState {
        public String appId;
        public String launchId;
        public String launchId_first;
        public Map<Integer, Long> eventTime = new HashMap();
        public Map<Integer, Long> eventTime_first = new HashMap();
        public Map<Integer, String> attachInfo = new HashMap();
        public boolean hasOnloaded = false;
        public boolean firstRender = false;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class RESERVES4 {
        public static final String COLD_START = "cold_start";
        public static final String HOT_START = "hot_start";
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Value {
        public static final String MINI_APP_START_BY_ID_CACHE = "id_cache";
        public static final String MINI_APP_START_BY_ID_INFO_CACHE = "idinfo_cache";
        public static final String MINI_APP_START_BY_LINK_CACHE = "link_cache";
        public static final String MINI_APP_START_BY_LINK_INFO_CACHE = "linkinfo_cache";
        public static final String MINI_APP_START_BY_SHOW_CACHE = "show_cache";
        public static final String MINI_APP_START_IN_MAIN_LOADING = "main_loading";
        public static final String MINI_SEARCH_DF_LAUNCH_DF = "launch_df";
        public static final String MINI_SEARCH_DF_LAUNCH_NORMAL = "launch_normal";
        public static final String MINI_SEARCH_DF_RESULT_DEX_FAIL = "dex_fail";
        public static final String MINI_SEARCH_DF_RESULT_DEX_SUC = "dex_suc";
        public static final String MINI_SEARCH_DF_RESULT_MMCL_FAIL = "mmcl_fail";
        public static final String MINI_SEARCH_DF_RESULT_MMCL_SUC = "mmcl_suc";
        public static final String PKG_DOWNLOAD = "1";
        public static final String PKG_NO_DOWNLOAD = "0";
    }

    static {
        eventNameSparseArray.put(1, "onlaunch");
        eventNameSparseArray.put(4, "basejsdownloadstart");
        eventNameSparseArray.put(5, "basejsdownloadend");
        eventNameSparseArray.put(6, "basejsunzipstart");
        eventNameSparseArray.put(7, "basejsunzipend");
        eventNameSparseArray.put(8, "basejsreadstart");
        eventNameSparseArray.put(9, "basejsreadend");
        eventNameSparseArray.put(10, "basejsreadstart");
        eventNameSparseArray.put(11, "basejsreadend");
        eventNameSparseArray.put(12, "appconfigreadstart");
        eventNameSparseArray.put(13, "appconfigreadend");
        eventNameSparseArray.put(14, "servicejsstart");
        eventNameSparseArray.put(15, "servicejsend");
        eventNameSparseArray.put(121, "app_route_done");
        eventNameSparseArray.put(150, "app_err_white_screen");
        eventNameSparseArray.put(122, "page_js_start");
        eventNameSparseArray.put(123, "page_js_end");
        eventNameSparseArray.put(124, "apkg_download_pipeline_start");
        eventNameSparseArray.put(125, "apkg_download_pipeline_end");
        eventNameSparseArray.put(16, "basejsstart");
        eventNameSparseArray.put(17, "basejsready");
        eventNameSparseArray.put(18, "webviewjsstart");
        eventNameSparseArray.put(19, "webviewjsready");
        eventNameSparseArray.put(2, "apponloaded");
        eventNameSparseArray.put(20, "apponhide");
        eventNameSparseArray.put(21, "apponshow");
        eventNameSparseArray.put(22, "apponunload");
        eventNameSparseArray.put(23, "jsonerror");
        eventNameSparseArray.put(24, "appcreate");
        eventNameSparseArray.put(100, "service_start");
        eventNameSparseArray.put(101, "service_end");
        eventNameSparseArray.put(102, "webview_start");
        eventNameSparseArray.put(103, "webview_end");
        eventNameSparseArray.put(104, "app_load_start");
        eventNameSparseArray.put(105, "app_load_end");
        eventNameSparseArray.put(104, "service_app_start");
        eventNameSparseArray.put(105, "service_app_end");
        eventNameSparseArray.put(106, "webview_app_start");
        eventNameSparseArray.put(107, "webview_app_end");
        eventNameSparseArray.put(599, EventName.SSO_CMD_RESULT);
        eventNameSparseArray.put(600, "ssocmdstart");
        eventNameSparseArray.put(601, "ssocmdend");
        eventNameSparseArray.put(602, "x5installsuccess");
        eventNameSparseArray.put(603, "x5installfail");
        eventNameSparseArray.put(604, "x5installtimeout");
        eventNameSparseArray.put(605, "preloadprocess");
        eventNameSparseArray.put(606, "pageshow");
        eventNameSparseArray.put(607, "pagehide");
        eventNameSparseArray.put(EventId.PAGE_LOAD_END, EventName.PAGE_LOAD_END);
        eventNameSparseArray.put(612, "pageclick");
        eventNameSparseArray.put(608, "onlaunchsucc");
        eventNameSparseArray.put(609, "onlaunchfail");
        eventNameSparseArray.put(610, "onlaunchtimeout");
        eventNameSparseArray.put(619, "appdownloadstart");
        eventNameSparseArray.put(620, "appdownloadend");
        eventNameSparseArray.put(621, "appunzipstart");
        eventNameSparseArray.put(622, "appunzipend");
        eventNameSparseArray.put(611, "domready");
        eventNameSparseArray.put(613, "subpkgdownloadstart");
        eventNameSparseArray.put(614, "subpkgdownloadend");
        eventNameSparseArray.put(615, "subpkgunpackstart");
        eventNameSparseArray.put(616, "subpkgunpackend");
        eventNameSparseArray.put(617, "basejsdownloadfailed");
        eventNameSparseArray.put(618, "basejsunzipfailed");
        eventNameSparseArray.put(623, "pageframeloadstart");
        eventNameSparseArray.put(624, "pageframeloadend");
        eventNameSparseArray.put(626, "preload_process_start");
        eventNameSparseArray.put(627, "preload_process_end");
        eventNameSparseArray.put(628, "http_request_result");
        eventNameSparseArray.put(629, "cpuPerformance");
        eventNameSparseArray.put(630, "fpsPerformance");
        eventNameSparseArray.put(631, "memoryPerformance");
        eventNameSparseArray.put(632, "web_socket_open");
        eventNameSparseArray.put(633, "web_socket_close");
        eventNameSparseArray.put(634, "web_socket_failure");
        eventNameSparseArray.put(642, "fpsVariance");
        eventNameSparseArray.put(643, "memoryGrowth");
        eventNameSparseArray.put(644, "miniappstaytime");
        eventNameSparseArray.put(700, "miniappembeddedvideo");
        eventNameSparseArray.put(701, EventName.APP_EMBEDDED_VIDEO_RESULT);
        eventNameSparseArray.put(710, EventName.APP_EMBEDDED_LIVE);
        eventNameSparseArray.put(711, EventName.APP_EMBEDDED_LIVE_RESULT);
        eventNameSparseArray.put(636, "first_render_result");
        eventNameSparseArray.put(637, "re_render_result");
        eventNameSparseArray.put(638, "newpage_result");
        eventNameSparseArray.put(639, "storage_usage");
        eventNameSparseArray.put(640, "http_download");
        eventNameSparseArray.put(641, "http_upload");
        eventNameSparseArray.put(1001, "minigamebaselibloadso");
        eventNameSparseArray.put(1002, "minigamebaselibloadsoend");
        eventNameSparseArray.put(1003, "minigamebaselibloadjar");
        eventNameSparseArray.put(1004, "minigamebaselibloadjarend");
        eventNameSparseArray.put(1005, "minigamebaselibloadjs");
        eventNameSparseArray.put(1006, "minigamebaselibloadjsend");
        eventNameSparseArray.put(1007, "minigameloadmainpkg");
        eventNameSparseArray.put(1008, "minigameloadmainpkgend");
        eventNameSparseArray.put(1009, "minigameloadsubpkg");
        eventNameSparseArray.put(1010, "minigameloadsubpkgend");
        eventNameSparseArray.put(1011, "minigameprogresserror");
        eventNameSparseArray.put(1012, "minigamebaselibinstallskip");
        eventNameSparseArray.put(1013, "minigameenterloadingpage");
        eventNameSparseArray.put(1014, "minigameloadbaselib");
        eventNameSparseArray.put(1015, "minigameloadbaselibend");
        eventNameSparseArray.put(1016, "minigamefirsthide");
        eventNameSparseArray.put(1017, "minigamesurvival");
        eventNameSparseArray.put(1018, "minigameblackscreen");
        eventNameSparseArray.put(1019, "minigamenorefresh");
        eventNameSparseArray.put(1020, "minigamefirststaytime");
        eventNameSparseArray.put(1021, "minigamestaytime");
        eventNameSparseArray.put(1022, "minigamefirstlaunch");
        eventNameSparseArray.put(1023, "minigametwicelaunch");
        eventNameSparseArray.put(1024, "minigameerrordialog");
        eventNameSparseArray.put(1025, "capsulebuttoncloseclick");
        eventNameSparseArray.put(1026, "loadingpagecloseclick");
        eventNameSparseArray.put(1027, "minigameimagedownload");
        eventNameSparseArray.put(1029, "minigameloadsubpack_impossible");
        eventNameSparseArray.put(1028, "miniappstartbycache");
        eventNameSparseArray.put(1030, "stepstartactivity");
        eventNameSparseArray.put(1031, "steponcreate");
        eventNameSparseArray.put(1032, "stepinitdatamustonresume");
        eventNameSparseArray.put(1033, "steploadbaselibtimecost");
        eventNameSparseArray.put(1034, "stepinitjspluginlist");
        eventNameSparseArray.put(1035, "steponresume");
        eventNameSparseArray.put(1036, "steploadgpkg");
        eventNameSparseArray.put(1037, "stepinitruntime");
        eventNameSparseArray.put(1038, "stepinitjspluginengine");
        eventNameSparseArray.put(1039, "stepcreatesurfaceview");
        eventNameSparseArray.put(1040, "steplaunchgame");
        eventNameSparseArray.put(1042, "stepfirstframefromgamelaunched");
        eventNameSparseArray.put(1043, "stepfirstframefromcreate");
        eventNameSparseArray.put(1044, "download_with_cache");
        eventNameSparseArray.put(1050, EventName.MINI_GAME_LOAD_SO_EXCEPTION);
        eventNameSparseArray.put(1060, EventName.MINI_SEARCH_DF_LAUNCH);
        eventNameSparseArray.put(1061, EventName.MINI_SEARCH_DF_RESULT);
        eventNameSparseArray.put(1062, EventName.MINI_SEARCH_DF_LOAD_START);
        eventNameSparseArray.put(1063, EventName.MINI_SEARCH_DF_LOAD_END);
        eventNeedRecordTime.add(1);
        eventNeedRecordTime.add(4);
        eventNeedRecordTime.add(6);
        eventNeedRecordTime.add(619);
        eventNeedRecordTime.add(613);
        eventNeedRecordTime.add(621);
        eventNeedRecordTime.add(626);
        eventNeedRecordTime.add(100);
        eventNeedRecordTime.add(101);
        eventNeedRecordTime.add(102);
        eventNeedRecordTime.add(103);
        eventNeedRecordTime.add(619);
        eventNeedRecordTime.add(620);
        eventNeedRecordTime.add(4);
        eventNeedRecordTime.add(5);
        eventNeedRecordTime.add(14);
        eventNeedRecordTime.add(15);
        eventNeedRecordTime.add(18);
        eventNeedRecordTime.add(19);
        eventNeedRecordTime.add(104);
        eventNeedRecordTime.add(105);
        eventNeedRecordTime.add(106);
        eventNeedRecordTime.add(107);
        eventNeedRecordTime.add(122);
        eventNeedRecordTime.add(123);
        eventNeedRecordTime.add(124);
        eventNeedRecordTime.add(125);
        eventNeedRecordTime.add(606);
        eventNeedRecordTime.add(Integer.valueOf(EventId.PAGE_LOAD_END));
        eventNeedRecordTime.add(1062);
        eventNeedRecordTime.add(1063);
        eventNeedRecordTime.add(2);
        eventNeedRecordTime.add(5);
        eventNeedRecordTime.add(617);
        eventNeedRecordTime.add(7);
        eventNeedRecordTime.add(618);
        eventNeedRecordTime.add(620);
        eventNeedRecordTime.add(614);
        eventNeedRecordTime.add(622);
        eventNeedRecordTime.add(627);
        eventNeedRecordTime.add(1022);
        eventNeedRecordTime.add(1023);
        eventCostTimeSparseArray.put(2, new CostTimeRecord("launch_result", 1));
        eventCostTimeSparseArray.put(EventId.PAGE_LOAD_END, new CostTimeRecord(EventName.PAGE_LOAD_RESULT, 606));
        eventCostTimeSparseArray.put(5, new CostTimeRecord("basejs_download_result", 4));
        eventCostTimeSparseArray.put(617, new CostTimeRecord("basejs_download_result", 4));
        eventCostTimeSparseArray.put(7, new CostTimeRecord("basejs_unzip_result", 6));
        eventCostTimeSparseArray.put(618, new CostTimeRecord("basejs_unzip_result", 6));
        eventCostTimeSparseArray.put(620, new CostTimeRecord("app_download_result", 619));
        eventCostTimeSparseArray.put(614, new CostTimeRecord("sub_download_result", 613));
        eventCostTimeSparseArray.put(622, new CostTimeRecord("app_unzip_result", 621));
        eventCostTimeSparseArray.put(627, new CostTimeRecord("preload_result", 626));
        eventCostTimeSparseArray.put(1022, new CostTimeRecord("game_first_launch_result", 1));
        eventCostTimeSparseArray.put(1023, new CostTimeRecord("game_twice_launch_result", 1));
        eventCostTimeSparseArray.put(1008, new CostTimeRecord("game_after_launch_time_cost", 1));
        eventCostTimeSparseArray.put(125, new CostTimeRecord("apkg_download_pipeline_result", 124));
        eventCostTimeSparseArray.put(1063, new CostTimeRecord(EventName.MINI_SEARCH_DF_LOAD_RESULT, 1062));
        eventNameToDC5332.add("launch_result");
        eventNameToDC5332.add("app_download_result");
        eventNameToDC5332.add("stepstartactivity");
        eventNameToDC5332.add("steponcreate");
        eventNameToDC5332.add("stepinitdatamustonresume");
        eventNameToDC5332.add("steploadbaselibtimecost");
        eventNameToDC5332.add("stepinitjspluginlist");
        eventNameToDC5332.add("steponresume");
        eventNameToDC5332.add("steploadgpkg");
        eventNameToDC5332.add("stepinitruntime");
        eventNameToDC5332.add("stepinitjspluginengine");
        eventNameToDC5332.add("stepcreatesurfaceview");
        eventNameToDC5332.add("stepfirstframefromgamelaunched");
        eventNameToDC5332.add("stepfirstframefromcreate");
        eventNameToDC5332.add("steplaunchgame");
        eventNameNotToDC4266.add("ssocmdstart");
        eventNameNotToDC4266.add("ssocmdend");
        eventNameNotToDC4266.add("preloadprocess");
        eventNameNotToDC4266.add("preload_process_end");
        eventNameNotToDC4266.add("preload_process_start");
        eventNameNotToDC4266.add("preload_result");
        eventNameNotToDC4266.add("basejsstart");
        eventNameNotToDC4266.add("basejsready");
        eventNameNotToDC4266.add("minigamebaselibloadjs");
        eventNameNotToDC4266.add("minigamebaselibloadjsend");
        eventNameNotToDC4266.add("minigameloadbaselib");
        eventNameNotToDC4266.add("minigameloadbaselibend");
        eventNameNotToDC4266.add("minigamebaselibloadso");
        eventNameNotToDC4266.add("minigamebaselibloadsoend");
        eventNameNotToDC4266.add("minigamebaselibloadso");
        eventNameNotToDC4266.add("minigamebaselibloadsoend");
        launchStateMap = new HashMap<>();
        APPID_JS_ERROR_MAP = new HashMap();
    }

    public static String getAppType(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null || !miniAppConfig.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    public static String getEventName(int i3) {
        return eventNameSparseArray.get(i3);
    }

    public static MiniAppConfig getFakeAppConfigForReport(String str) {
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        miniAppInfo.appId = str;
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        LaunchParam launchParam = new LaunchParam();
        miniAppConfig.launchParam = launchParam;
        launchParam.miniAppId = str;
        return miniAppConfig;
    }

    public static JSONArray getLaunchPerformance(String str) {
        String str2;
        String str3;
        String str4;
        MiniAppLaunchState launchState = getLaunchState(str);
        JSONArray jSONArray = new JSONArray();
        try {
            if (launchState.eventTime_first.size() <= 0) {
                str2 = TAG;
                str4 = "viewEnd";
            } else {
                JSONObject jSONObject = new JSONObject();
                Map<Integer, Long> map = launchState.eventTime_first;
                str2 = TAG;
                try {
                    jSONObject.put("navigationStart", map.get(1));
                    jSONObject.put("serviceStart", launchState.eventTime_first.get(100));
                    jSONObject.put("serviceEnd", launchState.eventTime_first.get(101));
                    jSONObject.put("viewStart", launchState.eventTime_first.get(102));
                    jSONObject.put("viewEnd", launchState.eventTime_first.get(103));
                    str4 = "viewEnd";
                    jSONObject.put("fetchPkgStart", launchState.eventTime_first.get(619));
                    jSONObject.put("fetchPkgEnd", launchState.eventTime_first.get(620));
                    jSONObject.put("fetchSdkStart", launchState.eventTime_first.get(4));
                    jSONObject.put("fetchSdkEnd", launchState.eventTime_first.get(5));
                    jSONObject.put("loadSdkServiceStart", launchState.eventTime_first.get(14));
                    jSONObject.put("loadSdkServiceEnd", launchState.eventTime_first.get(15));
                    jSONObject.put("loadSdkViewStart", launchState.eventTime_first.get(18));
                    jSONObject.put("loadSdkViewEnd", launchState.eventTime_first.get(19));
                    jSONObject.put("loadAppServiceStart", launchState.eventTime_first.get(104));
                    jSONObject.put("loadAppServiceEnd", launchState.eventTime_first.get(105));
                    jSONObject.put("loadAppViewStart", launchState.eventTime_first.get(106));
                    jSONObject.put("loadAppViewEnd", launchState.eventTime_first.get(107));
                    jSONObject.put("launchId", launchState.launchId_first);
                    jSONArray.mo162put(jSONObject);
                } catch (Exception e16) {
                    e = e16;
                    str3 = str2;
                    QLog.e(str3, 1, "create performance result failed", e);
                    QLog.e(str3, 2, " getformance: " + jSONArray.toString());
                    return jSONArray;
                }
            }
            if (launchState.eventTime.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("navigationStart", launchState.eventTime.get(1));
                jSONObject2.put("serviceStart", launchState.eventTime.get(100));
                jSONObject2.put("serviceEnd", launchState.eventTime.get(101));
                jSONObject2.put("viewStart", launchState.eventTime.get(102));
                jSONObject2.put(str4, launchState.eventTime.get(103));
                jSONObject2.put("fetchPkgStart", launchState.eventTime.get(619));
                jSONObject2.put("fetchPkgEnd", launchState.eventTime.get(620));
                jSONObject2.put("fetchSdkStart", launchState.eventTime.get(4));
                jSONObject2.put("fetchSdkEnd", launchState.eventTime.get(5));
                jSONObject2.put("loadSdkServiceStart", launchState.eventTime.get(14));
                jSONObject2.put("loadSdkServiceEnd", launchState.eventTime.get(15));
                jSONObject2.put("loadSdkViewStart", launchState.eventTime.get(18));
                jSONObject2.put("loadSdkViewEnd", launchState.eventTime.get(19));
                jSONObject2.put("loadAppServiceStart", launchState.eventTime.get(104));
                jSONObject2.put("loadAppServiceEnd", launchState.eventTime.get(105));
                jSONObject2.put("loadAppViewStart", launchState.eventTime.get(106));
                jSONObject2.put("loadAppViewEnd", launchState.eventTime.get(107));
                jSONObject2.put("launchId", launchState.launchId);
                jSONArray.mo162put(jSONObject2);
            }
            str3 = str2;
        } catch (Exception e17) {
            e = e17;
            str2 = TAG;
        }
        QLog.e(str3, 2, " getformance: " + jSONArray.toString());
        return jSONArray;
    }

    public static long getLaunchStartTime(String str) {
        Long l3;
        MiniAppLaunchState launchState = getLaunchState(str);
        if (launchState.eventTime.size() <= 0 || (l3 = launchState.eventTime.get(1)) == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public static MiniAppLaunchState getLaunchState(String str) {
        MiniAppLaunchState miniAppLaunchState = launchStateMap.get(str);
        if (miniAppLaunchState != null) {
            return miniAppLaunchState;
        }
        MiniAppLaunchState miniAppLaunchState2 = new MiniAppLaunchState();
        miniAppLaunchState2.appId = str;
        launchStateMap.put(str, miniAppLaunchState2);
        return miniAppLaunchState2;
    }

    public static boolean needReportToDC4266(String str) {
        return REPORT_EVENT_CONFIG.contains(str) || !eventNameNotToDC4266.contains(str);
    }

    public static boolean needReportToDC5332(String str, String str2, String str3) {
        if (!"1".equals(str) || "hot_start".equals(str3)) {
            return false;
        }
        return eventNameToDC5332.contains(str2);
    }

    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str) {
        reportEventType(miniAppConfig, i3, null, null, null, 0, str, 0L, null, "", "", "", "");
    }

    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str, String str2, String str3, String str4, String str5) {
        reportEventType(miniAppConfig, i3, null, null, null, 0, str, 0L, null, str2, str3, str4, str5);
    }

    public static void addCostTimeEventAttachInfo(MiniAppConfig miniAppConfig, int i3, String str) {
        String str2;
        MiniAppInfo miniAppInfo;
        if (miniAppConfig != null && (miniAppInfo = miniAppConfig.config) != null) {
            str2 = miniAppInfo.appId;
        } else {
            str2 = "0000000000";
        }
        getLaunchState(str2).attachInfo.put(Integer.valueOf(i3), str);
        QLog.d(TAG, 2, "addCostTimeEventAttachInfo:  mileStoneEventKey:" + i3 + "   attachInfo:" + str);
    }

    private static void appendJsErrorToReportedList(MiniAppConfig miniAppConfig, String str) {
        MiniAppInfo miniAppInfo;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || TextUtils.isEmpty(miniAppInfo.appId) || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, List<String>> map = APPID_JS_ERROR_MAP;
        if (map.get(miniAppConfig.config.appId) == null) {
            map.put(miniAppConfig.config.appId, new ArrayList());
        }
        map.get(miniAppConfig.config.appId).add(str);
    }

    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str, String str2) {
        reportEventType(miniAppConfig, i3, null, str, null, 0, str2, 0L, null, "", "", "", "");
    }

    private static boolean isJsErrorReported(MiniAppConfig miniAppConfig, String str) {
        if (miniAppConfig == null || miniAppConfig.config == null || TextUtils.isEmpty(str)) {
            return true;
        }
        List<String> list = APPID_JS_ERROR_MAP.get(miniAppConfig.config.appId);
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str, String str2, String str3, int i16, String str4, String str5, String str6, String str7) {
        reportEventType(miniAppConfig, i3, str, str2, str3, i16, "0", 0L, null, str4, str5, str6, str7);
    }

    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str, String str2, String str3, int i16) {
        reportEventType(miniAppConfig, i3, str, str2, str3, i16, "0", 0L, null);
    }

    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str, String str2, String str3, int i16, String str4, long j3, String str5) {
        reportEventType(miniAppConfig, i3, str, str2, str3, i16, str4, j3, str5, "", "", "", "");
    }

    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str, String str2, String str3, int i16, String str4, long j3, String str5, String str6, String str7, String str8, String str9) {
        reportEventType(miniAppConfig, i3, str, str2, str3, i16, str4, j3, System.currentTimeMillis(), str5, str6, str7, str8, str9);
    }

    private static void detectWhiteScreen(MiniAppConfig miniAppConfig, int i3, String str, String str2, String str3, long j3, MiniAppLaunchState miniAppLaunchState) {
        if (i3 == 20 && !miniAppLaunchState.hasOnloaded && miniAppLaunchState.eventTime.containsKey(121)) {
            long longValue = miniAppLaunchState.eventTime.get(121).longValue();
            miniAppLaunchState.eventTime.remove(121);
            long j16 = j3 - longValue;
            int config = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_white_screen_check", 5000);
            if (longValue <= 0 || j16 <= config) {
                return;
            }
            QLog.e(TAG, 1, "detect white_screen. after routedone time:" + j16);
            MiniProgramLpReportDC04266.report(miniAppConfig, 150, str, str2, "", 0, str3, 0L, "", j3, "route_done", String.valueOf(j16), "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportEventType(MiniAppConfig miniAppConfig, int i3, String str, String str2, String str3, int i16, String str4, long j3, long j16, String str5, String str6, String str7, String str8, String str9) {
        long j17;
        long j18;
        long j19;
        long j26;
        LaunchParam launchParam;
        MiniAppInfo miniAppInfo;
        String str10 = (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) ? "0000000000" : miniAppInfo.appId;
        MiniAppLaunchState launchState = getLaunchState(str10);
        if (i3 == 1) {
            QLog.d(TAG, 1, "launch start  uptimeMillis:" + SystemClock.uptimeMillis() + "  currentTimeMillis :" + j16);
            MiniAppStartState.reset(str10);
            if (miniAppConfig != null && (launchParam = miniAppConfig.launchParam) != null) {
                j26 = launchParam.launchClickTimeMillis;
                if (j26 != 0) {
                    QLog.d(TAG, 2, "reportEventType: fix onlaunch timestamp to " + miniAppConfig.launchParam.launchClickTimeMillis);
                    j17 = 0;
                    miniAppConfig.launchParam.launchClickTimeMillis = 0L;
                    launchState.hasOnloaded = false;
                    if (launchState.firstRender) {
                        MiniAppLaunchState launchState2 = getLaunchState("0000000000");
                        if (launchState2 != null && launchState2.eventTime.size() > 0) {
                            launchState.eventTime.putAll(launchState2.eventTime);
                            launchState2.eventTime.clear();
                        }
                    } else if (launchState.eventTime_first.size() == 0) {
                        launchState.eventTime_first.putAll(launchState.eventTime);
                        launchState.launchId_first = launchState.launchId;
                        launchState.launchId = "";
                    }
                    j18 = j26;
                }
            }
            j17 = 0;
            j26 = j16;
            launchState.hasOnloaded = false;
            if (launchState.firstRender) {
            }
            j18 = j26;
        } else {
            j17 = 0;
            j18 = j16;
        }
        int i17 = (i3 != 611 || launchState.hasOnloaded) ? i3 : 2;
        if (i17 == 2) {
            QLog.d(TAG, 1, "launch end  uptimeMillis:" + SystemClock.uptimeMillis() + "  currentTimeMillis :" + j16);
            if (launchState.hasOnloaded) {
                QLog.d(TAG, 1, "has report apponloaded. ignore apponloaed ");
                return;
            } else {
                launchState.hasOnloaded = true;
                launchState.firstRender = true;
                launchState.launchId = MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppConfig);
            }
        }
        detectWhiteScreen(miniAppConfig, i17, str, str2, str4, j18, launchState);
        if (eventNeedRecordTime.contains(Integer.valueOf(i17))) {
            launchState.eventTime.put(Integer.valueOf(i17), Long.valueOf(j18));
        }
        int i18 = i17;
        long j27 = j17;
        MiniProgramLpReportDC04266.report(miniAppConfig, i17, str, str2, str3, i16, str4, j3, str5, j18, str6, str7, str8, str9);
        CostTimeRecord costTimeRecord = eventCostTimeSparseArray.get(i18);
        if (costTimeRecord != null) {
            Long l3 = launchState.eventTime.get(Integer.valueOf(costTimeRecord.eventStart));
            long longValue = l3 != null ? l3.longValue() : j27;
            if (longValue > j27) {
                long j28 = j18 - longValue;
                String str11 = costTimeRecord.eventName;
                String str12 = launchState.attachInfo.get(Integer.valueOf(i18));
                if (j28 >= j27) {
                    int i19 = MAX_TIME_COST;
                    if (j28 > i19) {
                        QLog.d(TAG, 1, "EventType: " + i18 + " real costTime : " + j28);
                        j19 = (long) i19;
                    } else {
                        j19 = j28;
                    }
                    MiniProgramLpReportDC04266.reportCostTimeEvent(miniAppConfig, str11, str, str12, i16, j19, j18, str6, str7, str8, str9);
                } else {
                    QLog.e(TAG, 1, "costTime < 0 " + j28);
                }
            }
        }
        if (i18 == 2 && "0".equals(str4)) {
            MiniProgramLpReportDC04266.report(miniAppConfig, 630, str, String.valueOf(TaskMonitorManager.g().getCurrentFps()), null, 0, "0", 0L, null, j18, "", "", "", "");
        }
    }
}
