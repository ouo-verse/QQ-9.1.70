package com.tencent.gamecenter.wadl.biz.entity;

/* loaded from: classes6.dex */
public class WadlProxyConsts {
    public static final String ACTION_FROM = "actionFrom";
    public static final String ACTION_GAME_CENTER_ACTION = "com.tencent.gamecenter.action";
    public static final String ACTION_GAME_CENTER_CUSTOM_INSTALL_ACTION = "com.tencent.gamecenter.custom.install.action";
    public static final String ACTION_GAME_CENTER_DYNAMIC_ACTION = "com.tencent.gamecenter.dynamic.action";
    public static final String ACTION_GAME_CENTER_MAIN_PROCESS_ACTION = "com.tencent.gamecenter.main.process_action";
    public static final String ACTION_GAME_CENTER_SERVICE_EXIT_ACTION = "com.tencent.gamecenter.service.exit";
    public static final int ACTION_TYPE_INSTALL = 0;
    public static final int ACTION_TYPE_JUMP = 1;
    public static final String ACTION_VM_ACTION = "com.tencent.vm.action";
    public static final String ADTAG = "adtag";
    public static final String APKSIGN = "apkSign";
    public static final String APPID = "appid";
    public static final String APPIDS = "appids";
    public static final String APP_CHANNEL_GAMECENTER = "10000144";
    public static final String APP_ID = "appId";
    public static final String BANNER_TYPE = "bannerType";
    public static final int BUSINESS_ID_ALL = Integer.MAX_VALUE;
    public static final int BUSINESS_ID_BEGIN = 1;
    public static final String BUSINESS_ID_DOWNLOAD = "81720";
    public static final int BUSINESS_ID_END = 3;
    public static final String BUSINESS_ID_GAMECENTER = "4";
    public static final int BUSINESS_ID_GAME_CENTER = 1;
    public static final int BUSINESS_ID_TGPA = 2;
    public static final int BUSINESS_ID_VM = 3;
    public static final String CHANNEL = "channel";
    public static final String CMD_CHECK_ADD_FRIEND_LIMIT = "/v1/1648";
    public static final String CMD_CHECK_INSTALL_CHANNEL = "/v1/1784";
    public static final String CMD_CHECK_INSTALL_MODEL = "/v1/1006";
    public static final String CMD_GAME_AUTO_DOWNLOAD = "/v1/448";
    public static final String CMD_GAME_DYE_USER = "/v1/551";
    public static final String CMD_GAME_PA_ADINFO = "/v1/64";
    public static final String CMD_GAME_SUBSCRIBE = "/v1/71";
    public static final String CMD_GAME_SUBSCRIBE_NEW_VERSION = "/v1/1540";
    public static final String CMD_GET_APK_DOWNLOAD_INFO = "13169";
    public static final String CMD_GET_GAME_LIST = "/v1/1003";
    public static final String CMD_PRELOAD_GAME = "12820";
    public static final String CMD_QUERY_GAME_DISTRIBUTE = "/v1/1565";
    public static final String CMD_QUERY_SUBSCRIBE_STATUS = "/v1/238";
    public static final String CMD_REPORT_ADD_FRIEND = "/v1/1649";
    public static final String CMD_REPORT_INSTALL_CHANNEL = "/v1/1903";
    public static final String CMD_REPORT_REAL_DOWNLOAD_SPEED = "/v1/1902";
    public static final String CMD_REQUEST_RED_POINT = "13325";
    public static final String CMD_SET_AUTO_DOWNLOAD = "13032";
    public static final String CMD_TRPC_ATTA_NEW_REPORT = "/v1/773";
    public static final String CMD_TRPC_ATTA_REPORT = "/v1/11";
    public static final String CMD_TRPC_CHECK_DOWNLOAD = "trpc.down.check_download.CheckDownload.SsoCheckURL";
    public static final String CMD_TRPC_CHECK_DOWNLOAD_JOINT = "trpc.down.joint_operation_game_intercept.JointOperationGameIntercept.SsoCheck";
    public static final String CMD_TRPC_CHECK_DOWNLOAD_SSOINSTALLTIP = "trpc.down.check_download.CheckDownload.SsoInstallTip";
    public static final String CMD_TRPC_CHECK_DOWNLOAD_START_APK = "trpc.down.check_download.CheckDownload.SsoStartApk";
    public static final String CMD_TRPC_CHECK_INDEPENDENT_DOWNLOAD = "trpc.down.check_download.CheckDownload.SsoCheckCustomAPK";
    public static final String CMD_TRPC_CHECK_PRE_DOWNLOAD = "trpc.down.check_download.CheckDownload.SsoCheckEnv";
    public static final String CMD_TRPC_DC_REPORT = "trpc.down.report.Report.DcReport";
    public static final String CMD_TRPC_GAME_NOTIFYUPDATEREQ = "/v1/9";
    public static final String CMD_TRPC_GAME_QUERRYGROUPINFO = "/v1/3";
    public static final String CMD_TRPC_GAME_QUERRYUSERINFO = "/v1/4";
    public static final String CMD_TRPC_GAME_QUERY_CARDINFO = "/v1/953";
    public static final String CMD_TRPC_GAME_QUERY_GAME_INFO_QUICK_AUTH = "/v1/1626";
    public static final String CMD_TRPC_GAME_QUERY_GAME_INFO_USER_SWITCH = "/v1/1622";
    public static final String CMD_TRPC_GAME_QUERY_METADREAM_MEMBER_INFO = "/v1/1448";
    public static final String CMD_TRPC_GAME_QUERY_METADREAM_TROOP_INFO = "/v1/1447";
    public static final String CMD_TRPC_GAME_QUERY_METADREAM_USER_SWITCH = "/v1/1445";
    public static final String CMD_TRPC_GAME_SET_GAME_INFO_USER_SWITCH = "/v1/1623";
    public static final String CMD_TRPC_GAME_SET_METADREAM_USER_SWITCH = "/v1/1446";
    public static final String CMD_TRPC_GET_DOWNLOAD_CONFIG = "trpc.down.game_switch.GameSwitch.SsoGetDownloadConfig";
    public static final String CMD_TRPC_GET_DOWNLOAD_TIPS = "trpc.down.intercept.Intercept.SsoGetDownloadTips";
    public static final String CMD_TRPC_GET_FLOAT_WINDOWS_INFO = "trpc.down.game_switch.GameSwitch.SsoGetFloatingWindow";
    public static final String CMD_TRPC_GET_GAME_REGISTER = "trpc.down.game_switch.GameSwitch.SsoGetGameRegistered";
    public static final String CMD_TRPC_GET_INTERRUPT_FILE = "trpc.down.intercept.Intercept.SsoGetInterceptFile";
    public static final String CMD_TRPC_GET_JOINT_CONFIG = "trpc.down.joint_operation_game_intercept.JointOperationGameIntercept.SsoQueryConfig";
    public static final String CMD_TRPC_GET_PREUPDATE = "trpc.down.pre_update.PreUpdate.SsoGetPreUpdate";
    public static final String CMD_TRPC_GET_PREUPDATE_CIRCLE = "trpc.down.pre_update.PreUpdate.SsoGetPreCircle";
    public static final String CMD_TRPC_GET_REMIND_FULLSCREEN = "trpc.gamecenter.full_screen_remind.FullScreenRemind.SsoShow";
    public static final String CMD_TRPC_INTERRUPT_GAME_INFO = "trpc.down.intercept.Intercept.SsoGetLgameInfo";
    public static final String CMD_TRPC_INTERRUPT_REGEX_FILE = "trpc.down.intercept.Intercept.SsoGetLgameFile";
    public static final String CMD_TRPC_QUERY_SWITCH = "trpc.gamecenter.switch_svr.SwitchSvr.SsoQuerySwitch";
    public static final String CMD_TRPC_REQUEST_PRE_UPDATE = "trpc.gamecenter.game_update_svr.GameUpdateSvr.SsoGetGameUpdates";
    public static final String CMD_TRPC_REQUEST_PRE_UPDATE_REPORT = "trpc.gamecenter.game_update_svr.GameUpdateSvr.SsoReportGameUpdates";
    public static final String CMD_TRPC_SET_ORDER_GAME = "trpc.down.pre_update.PreUpdate.SsoSetOrderGame";
    public static final String CMD_TRPC_SET_SWITCH = "trpc.gamecenter.switch_svr.SwitchSvr.SsoSetSwitch";
    public static final String CMD_TRPC_TIANJI_REPORT = "/v1/2";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CREATE_TIME = "createTime";
    public static final String DATA = "data";
    public static final String DB_NAME = "WADLTASK.db";
    public static final int DB_VERSION = 36;
    public static final String DEFAULT_MGR_SCHEME = "mqqapi://hippy/open?src_type=web&version=1&bundleName=QQGameCenterDownloadPure&url=%3Fp_collections%3D%2526adtag%253Dadtag&isAnimated=true&isStatusBarDarkFont=true&via=interruptJoint";
    public static final String DEFAULT_MGR_URL = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
    public static final int DEFAULT_REPORT_SAMPLE = 10;
    public static final String DELETE_FROM_APP_INSTALLED = "appInstalled";
    public static final String DELETE_FROM_CMD_DELETE_ACTION = "cmdDeleteAction";
    public static final String DELETE_FROM_CMD_DELETE_ALL_ACTION = "cmdDeleteAllAction";
    public static final String DELETE_FROM_HANDLE_DOWNLOAD = "handleDownload";
    public static final String DELETE_FROM_INSTALL_APPBYSIGN = "installAppBySign";
    public static final String DOWNLOAD_TYPE = "downloadType";
    public static final String DOWNLOAD_URL = "downloadUrl";
    public static final int EVENT_DOWNLOAD_COMPLETED = 1008;
    public static final int EVENT_DOWNLOAD_DELETED = 1007;
    public static final int EVENT_DOWNLOAD_DETECTED = 1002;
    public static final int EVENT_DOWNLOAD_FAIL = 1005;
    public static final int EVENT_DOWNLOAD_PAUSED = 1006;
    public static final int EVENT_DOWNLOAD_RUNNING = 1004;
    public static final int EVENT_DOWNLOAD_START = 1003;
    public static final int EVENT_ID_FULL_SCREEN_NOTICE = 4;
    public static final int EVENT_ID_INSTALL_APK = 3;
    public static final int EVENT_ID_SCHEME_INSTALL_APK = 2;
    public static final int EVENT_ID_SCHEME_INSTALL_DEFAULT = 0;
    public static final int EVENT_ID_SCHEME_JUMP_SCHEME = 3;
    public static final int EVENT_ID_SCHEME_RESUME_ALL = 1;
    public static final int EVENT_ID_TASK_PAUSE_APK = 5;
    public static final int EVENT_ID_TASK_RESUME_APK = 1;
    public static final int EVENT_ID_TASK_RESUME_RES = 2;
    public static final int EVENT_ID_USE_REMOVE_NOTICE = 7;
    public static final int EVENT_ID_VM_APP_START = 6;
    public static final int EVENT_INSTALL_START = 1010;
    public static final int EVENT_INSTALL_SUCCESS = 2002;
    public static final int EVENT_INSTALL_VERIFY_FAIL = 2000;
    public static final int EVENT_INSTALL_VERIFY_SUCCESS = 2001;
    public static final int EVENT_QUERY_TASK = 4000;
    public static final int EVENT_RES_DOWNLOAD_COMPLETED = 5008;
    public static final int EVENT_RES_DOWNLOAD_DELETED = 5007;
    public static final int EVENT_RES_DOWNLOAD_DETECTED = 5002;
    public static final int EVENT_RES_DOWNLOAD_FAIL = 5005;
    public static final int EVENT_RES_DOWNLOAD_PAUSED = 5006;
    public static final int EVENT_RES_DOWNLOAD_RUNNING = 5004;
    public static final int EVENT_RES_DOWNLOAD_START = 5003;
    public static final int EVENT_UPDATE_DATA = 1009;

    @Deprecated
    public static final String EXP_QQ_QQGAME_BACK_START = "exp_qq_qqgame_back_start";
    public static final String EXP_QQ_QQGAME_CUSTOM_INSTALL = "exp_qq_qqgame_custom_install";
    public static final String EXP_QQ_QQGAME_NOTIFICATION = "exp_qq_qqgame_notification";

    @Deprecated
    public static final String EXP_QQ_QQGAME_PERMISSION = "exp_qq_qqgame_permission";
    public static final String EXP_QQ_QQGAME_TIPS = "exp_qq_qqgame_tips";
    public static final String EXTRA_CMD = "extra_cmd";
    public static final String EXTRA_DATA = "extraData";
    public static final String EXTRA_RESULT_CODE = "extra_result_code";
    public static final String EXT_JSON = "extJson";
    public static final String FILE_SIZE_DOWNLOAD = "downloadSize";
    public static final String FILE_SIZE_TOTAL = "totalSize";
    public static final String FLAGS = "flags";
    public static final String FLAG_OFF = "0";
    public static final String FLAG_ON = "1";
    public static final String FROM_CUSTOM_INSTALLER = "custom_installer";
    public static final String FROM_URL = "fromUrl";
    public static final String GAMECENTER_TABLE_FIELDS = "appId TEXT NOT NULL, downloadUrl TEXT NOT NULL, via TEXT, name TEXT, iconUrl TEXT, packageName TEXT, versionCode INTEGER, totalSize INTEGER, downloadSize INTEGER, status INTEGER ,savePath TEXT,fromUrl TEXT,adtag TEXT, apkSign TEXT, createTime INTEGER, channel TEXT, flags INTEGER, actionFrom INTEGER, extraData TEXT, noticeCount INTEGER,mieActId LONG,downloadType INTEGER, extJson TEXT, ";
    public static final String GAME_CENTER_TRPC = "GDCTrpcProxy.service";
    public static final String GAME_CENTER_WEB_SSO = "QQVacCommSvc.web_sso";
    public static final String GAME_DETAIL_PAGE_TEMPLATE = "https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1";
    public static final String HIPPY_OPEN_SCHEME = "mqqapi://hippy/open";
    public static final String ICON_URL = "iconUrl";
    public static final int INSTALL_FROM_ANDROID_P_DEF = 1;
    public static final int INSTALL_FROM_ANDROID_P_FLOAT = 2;
    public static final int INSTALL_FROM_CHECK = 9;
    public static final int INSTALL_FROM_DEFAULT = 0;
    public static final int INSTALL_FROM_MINI = 10;
    public static final long INTERRUPT_CONFIG_INVALID_TIME = 86400000;
    public static final String IS_FOREGROUND = "isForeground";
    public static final String IS_QUIC = "is-quic";
    public static final String KEY_ACTION_FROM = "actionFrom";
    public static final String KEY_ACTION_TYPE = "actionType";
    public static final String KEY_APPID = "appid";
    public static final String KEY_DOWNLOAD_TYPE = "downloadType";
    public static final String KEY_EVENT_ID = "key_event_id";
    public static final String KEY_FLOAT_WND_TOGGLE = "key_float_wnd_toggle";
    public static final String KEY_HARD_CODE_SWITCH = "hard_code_sp_key";
    public static final String KEY_JUMP_URL = "jumpUrl";
    public static final String KEY_LOCAL_APK_PATH = "localAPKPath";
    public static final String KEY_MATERIAL = "material";
    public static final String KEY_PKG_INFO_PRE = "KEY_PKG_INFO_PRE_";
    public static final String KEY_PROGRESS = "progress";
    public static final String KEY_PULL_AUTODOWNLOAD_SWITCH = "pull_autodownload_switch_sp_key";
    public static final String KEY_REMOTE_CMD = "REMOTE_CMD";
    public static final String KEY_RESID = "resId";
    public static final String KEY_SCHEDULE_INFO = "schedule_info_sp_key";
    public static final String KEY_SOURCE_ID = "sourceId";
    public static final String KEY_SSO_TYPE = "wadl_sso_type";
    public static final String KEY_TASK_NUM = "task_num_sp_key";
    public static final String KEY_THREAD_NUM = "thread_num_sp_key";
    public static final String KEY_TIPS = "tips";
    public static final String KEY_TYPE = "type";
    public static final String KUIKLY_DOWNLOAD_ADMIN_SCHEME = "mqqapi://kuikly/open?src_type=web&version=1&url=%25253FFFROMSCHEMA%25253D%252526adtag%25253DQQNotification%252526channel_id%25253D10000144&page_name=QQGameCenterDownloadAdmin&bundle_name=gamecenter_download_admin";
    public static final String LAST_UPDATE_TIME = "lastUpdateTime";
    public static final String LOAD_CONFIG_FROM_INSTANCE = "instance";
    public static final String LOAD_CONFIG_FROM_UPDATE = "update";
    public static final String LOCATION = "location";
    public static final long MATCH_SLEEP_TIME = 500;
    public static final String MIE_ACT_ID = "mieActId";
    public static final String MODULE_TYPE_DOWNLOAD = "1";
    public static final String MOUDLE_TYPE_GAMECENTER = "55801";
    public static final String NAME = "name";
    public static final String NOTICE_COUNT = "noticeCount";
    public static final String NOTICE_TABLE_FIELDS = "appId TEXT NOT NULL, packageName TEXT, versionCode INTEGER, channel TEXT, name TEXT, savePath TEXT,bannerType INTEGER, createTime LONG, actionFrom INTEGER, lastUpdateTime LONG, iconUrl TEXT, ";
    public static final String NOTICE_TAG = "gamecenter";
    public static final String OPER_ID_AUTO_DOWNLOAD_REASON = "203701";
    public static final String OPER_ID_CLICK_NOTICE = "209875";
    public static final String OPER_ID_CUSTOM_INSTALL = "203713";
    public static final String OPER_ID_CUSTOM_INSTALL_CANCEL = "914129";
    public static final String OPER_ID_CUSTOM_INSTALL_NOTICE = "914130";
    public static final String OPER_ID_CUSTOM_INSTALL_SHOW = "914126";
    public static final String OPER_ID_DEFAULT_DOWNLOAD = "202469";
    public static final String OPER_ID_DELAY_DOWNLOAD = "202470";
    public static final String OPER_ID_DEL_DOWNLOAD = "202476";
    public static final String OPER_ID_DOWNLOAD_FAIL = "202479";
    public static final String OPER_ID_DOWNLOAD_FLOW = "202139";
    public static final String OPER_ID_DOWNLOAD_SUCC = "202480";
    public static final String OPER_ID_FLOAT_PERMISSION = "202473";
    public static final String OPER_ID_FROM_NOTICE_INSTALL = "202487";
    public static final String OPER_ID_FROM_NOTICE_RESUME = "202474";
    public static final String OPER_ID_FROM_OTHER_INSTALL = "202488";
    public static final String OPER_ID_FROM_OTHER_RESUME = "202486";
    public static final String OPER_ID_H5_CLICK_DOWNLOAD = "205906";
    public static final String OPER_ID_INSTALL_APP = "202483";
    public static final String OPER_ID_INSTALL_FAIL = "203645";
    public static final String OPER_ID_INSTALL_MSG_TIPS = "205431";
    public static final String OPER_ID_INSTALL_MSG_TIPS_CLICK = "205432";
    public static final String OPER_ID_INSTALL_MSG_TIPS_CLOSE = "205435";
    public static final String OPER_ID_INSTALL_REQUEST = "204686";
    public static final String OPER_ID_INTERRUPT_MATCH = "915192";
    public static final String OPER_ID_INTERRUPT_UNMATCH = "205925";
    public static final String OPER_ID_MSG_TIPS_CLICK = "914844";
    public static final String OPER_ID_MSG_TIPS_SHOW = "914843";
    public static final String OPER_ID_NOTIFICATION_CLICK = "914842";
    public static final String OPER_ID_NOTIFICATION_SHOW = "914841";
    public static final String OPER_ID_PAUSE_DOWNLOAD = "202472";
    public static final String OPER_ID_PAUSE_MSG_TIPS = "908026";
    public static final String OPER_ID_PAUSE_MSG_TIPS_CLICK = "908027";
    public static final String OPER_ID_PAUSE_MSG_TIPS_CLOSE = "908028";
    public static final String OPER_ID_PERMISSION = "203646";
    public static final String OPER_ID_PREDOWNLOAD_INSTALLED = "202142";
    public static final String OPER_ID_PREUPDATE_NOT_INSTALL = "206679";
    public static final String OPER_ID_PRE_DOWNLOAD = "202471";
    public static final String OPER_ID_PROCESS_MONITOR = "204685";
    public static final String OPER_ID_REG_MSG_TIPS = "205433";
    public static final String OPER_ID_REG_MSG_TIPS_CLICK = "205434";
    public static final String OPER_ID_REG_MSG_TIPS_CLOSE = "205436";
    public static final String OPER_ID_SERVICE_START_FAIL = "204684";
    public static final String OPER_ID_SHOW_NOTICE = "209874";
    public static final String OPER_ID_SHOW_NOTICE_TIPS = "912388";
    public static final String OPER_ID_STEP_REPORT = "204650";
    public static final String OPER_ID_UNINSTALL_APP = "202482";
    public static final String OPER_ID_UPDATE_DOWNLOAD = "202528";
    public static final String OPER_ID_URL_CHANGE = "205753";
    public static final String OPER_ID_URL_EMPTY = "202982";
    public static final String OPER_ID_URL_INTERRUPT = "205758";
    public static final String OPER_MODULE_DOWNLOAD = "817";
    public static final String OPER_MODULE_GAMECENTER = "558";
    public static final String OPER_TYPE_APK_INSTALL = "26";
    public static final String OPER_TYPE_APK_REPLACED = "25";
    public static final String OPER_TYPE_APK_SIGN = "33";
    public static final String OPER_TYPE_APK_UNINSTALL = "24";
    public static final String OPER_TYPE_CLICK = "20";
    public static final String OPER_TYPE_DOWNLOAD_BREAK = "29";
    public static final String OPER_TYPE_DOWNLOAD_DELAY = "32";
    public static final String OPER_TYPE_DOWNLOAD_DELETE = "31";
    public static final String OPER_TYPE_DOWNLOAD_FAIL = "28";
    public static final String OPER_TYPE_DOWNLOAD_INSTALL = "22";
    public static final String OPER_TYPE_DOWNLOAD_PAUSE = "30";
    public static final String OPER_TYPE_DOWNLOAD_RESUME = "23";
    public static final String OPER_TYPE_DOWNLOAD_START = "21";
    public static final String OPER_TYPE_DOWNLOAD_SUCCESS = "27";
    public static final String OPER_TYPE_MONITOR = "34";
    public static final String OPER_TYPE_SHOW = "8";
    public static final String OPER_TYPE_STATISTICS = "35";
    public static final String OPER_TYPE_STEP_REPORT = "35";
    public static final String PACKAGE_NAME = "packageName";
    public static final String PAGE_ID_DOWNLOAD = "145";
    public static final String PAGE_ID_GAMECENTER = "430";
    public static final String PARAMS_QUERY_RESULT = "query_result";
    public static final String PARAM_ACTION_FROM = "actionFrom";
    public static final String PARAM_ACTION_TYPE = "actionType";
    public static final String PARAM_APK_FILE_SIZE = "apkFileSize";
    public static final String PARAM_APPID = "appId";
    public static final String PARAM_APPID_LIS = "appIdLis";
    public static final String PARAM_APPNAME = "appName";
    public static final String PARAM_BUSINESS_ID = "businessId";
    public static final String PARAM_DOWNLOAD_INFO = "download_wadl_params";
    public static final String PARAM_DOWNLOAD_RESULT = "download_result";
    public static final String PARAM_FILENAME = "fileName";
    public static final String PARAM_HAS_INSTALL_PERMISSION = "hasInstallPermission";
    public static final String PARAM_IS_FOREGROUND = "isForground";
    public static final String PARAM_IS_PRELOAD = "isPreLoad";
    public static final String PARAM_LOCAL_APK_PATH = "localApkPath";
    public static final String PARAM_NOTICE_INFO = "notice_info";
    public static final String PARAM_PACKAGENAME = "packageName";
    public static final String PARAM_REQ_JSON = "webssoReqJson";
    public static final String PARAM_RESID = "resId";
    public static final String PARAM_SPEED_BUFFER = "speedBuffer";
    public static final String PARAM_TIME_OUT = "timeOut";
    public static final String PARAM_TRPCSSO_CMD_IDS = "trpcssoCmdIds";
    public static final String PARAM_URL = "url";
    public static final String PARAM_VIA = "via";
    public static final String PARAM_WADL_PARAMS_JSON_STR = "wadlParamsJsonStr";
    public static final String PARAM_WEBSSO_CMD_ID = "webssoCmdId";
    public static final String PARAM_WEBSSO_IS_WITHOUT_LOGIN = "webssIsWithoutLogin";
    public static final String PARAM_WEBSSO_REQ = "webssoReq";
    public static final String PARAM_WEBSSO_RSP = "webssoRsp";
    public static final String PLUGINS_PROCESS_NAME = "com.tencent.mobileqq:plugins";
    public static final String QIPC_ACTION_CHANGE_WND_TOGGLE = "action.change.wnd.toggle";
    public static final String QIPC_ACTION_CHECK_FOREGROUND = "action.check,foreground";
    public static final String QIPC_ACTION_CHECK_INSTALL_MODEL = "action.checkInstallModel";
    public static final String QIPC_ACTION_CHECK_INSTALL_YUNGAME_STATUS = "action.checkInstallYunGameStatus";
    public static final String QIPC_ACTION_CHECK_TOP_FRAGMENT = "action.check.top.fragment";
    public static final String QIPC_ACTION_GETUIN = "action.getUin";
    public static final String QIPC_ACTION_INSTALL_APK = "action.install.apk";
    public static final String QIPC_ACTION_REPORT = "action.report";
    public static final String QIPC_ACTION_REPORT_V2 = "action.report_v2";
    public static final String QUIC_TRUE = "yes";
    public static final String REMOTE_CMD_APP_DELETE_ACTION = "doDeleteAction";
    public static final String REMOTE_CMD_APP_DELETE_ALL_ACTION = "doDeleteAllAction";
    public static final String REMOTE_CMD_APP_DOWNLOAD_ACTION = "doDownloadAction";
    public static final String REMOTE_CMD_APP_INSTALLED = "doInstallAppCompleted";
    public static final String REMOTE_CMD_APP_INSTALL_ACTION = "doInstallAction";
    public static final String REMOTE_CMD_APP_PAUSE_ACTION = "doPauseAction";
    public static final String REMOTE_CMD_APP_QUERY_ID_ACTION = "doQueryActionById";
    public static final String REMOTE_CMD_APP_QUERY_VIA_ACTION = "doQueryActionByVia";
    public static final String REMOTE_CMD_APP_REPLACED = "doAppReplaced";
    public static final String REMOTE_CMD_APP_RESUME_ACTION = "doResumeAction";
    public static final String REMOTE_CMD_APP_UNINSTALLED = "doUninstallAppCompleted";
    public static final String REMOTE_CMD_QUERY_TASK = "doQueryAllTask";
    public static final String REMOTE_CMD_REPORT_INSTALL_REQUEST = "reportInstallRequest";
    public static final String REMOTE_CMD_SET_SPEED_BUFFER = "setSpeedBuffer";
    public static final String REMOTE_CMD_SYNC_TASK_DATA = "syncTaskData";
    public static final String REMOTE_REVERSE_ONQUERY_ALL_TASK = "Wadl_Reverse_onQureyAllTask";
    public static final String REMOTE_REVERSE_ONQUERY_RESULT = "Wadl_Reverse_onQureyResult";
    public static final String REMOTE_REVERSE_ONQUERY_VIA_RESULT = "Wadl_Reverse_onQureyResultVia";
    public static final String REMOTE_REVERSE_ON_INSTALL_START = "Wadl_Reverse_onInstallStart";
    public static final String REMOTE_REVERSE_ON_NOTICE_ADD = "Wadl_Reverse_onNoticeAdd";
    public static final String REMOTE_REVERSE_ON_NOTICE_DELETE = "Wadl_Reverse_onNoticeDelete";
    public static final String REMOTE_REVERSE_START_SERVICE = "Wadl_Reverse_StartWadlService";
    public static final String REMOTE_REVERSE_STATE_CHANGED = "Wadl_Reverse_onWadlTaskStatusChanged";
    public static final String REPORTDATA = "reportData";
    public static final String REQ = "req";
    public static final byte REQUEST_CODE_INSTALL_PERMISSION = 34;
    public static final String RES_ID = "resId";
    public static final String RES_INDEX = "resIndex";
    public static final String RES_MD5 = "resMd5";
    public static final String RES_NAME = "resName";
    public static final String RES_TABLE_FIELDS = "resId TEXT NOT NULL, downloadUrl TEXT NOT NULL, via TEXT, name TEXT, packageName TEXT, versionCode INTEGER, totalSize INTEGER, downloadSize INTEGER, status INTEGER ,savePath TEXT,fromUrl TEXT,adtag TEXT, apkSign TEXT, createTime INTEGER, channel TEXT, flags INTEGER, actionFrom INTEGER, extraData TEXT, resType INTEGER, resIndex INTEGER, resMd5 TEXT, resName TEXT, resUrl TEXT, resVersionName TEXT, lastUpdateTime LONG, appId TEXT NOT NULL,";
    public static final String RES_TYPE = "resType";
    public static final int RES_TYPE_DEF = 0;
    public static final int RES_TYPE_NEW_APK = 4;
    public static final String RES_URL = "resUrl";
    public static final String RES_VERSION_NAME = "resVersionName";
    public static final String REVERSE_ACTION_CMD = "WADL.REVERSE_ACTION_CMD";
    public static final String REVERSE_ACTION_CMD_NAME = "WADL.REVERSE_ACTION_CMD_NAME";
    public static final String REVERSE_HEART_CMD = "WADL.REVERSE_HEART_CMD";
    public static final String REVERSE_START_MONITOR_CMD = "WADL.REVERSE_START_MONITOR_CMD";
    public static final String REVERSE_STOP_MONITOR_CMD = "WADL.REVERSE_STOP_MONITOR_CMD";
    public static final String RSP = "rsp";
    public static final String SAVE_PATH = "savePath";
    public static final String SCENE_ID = "sceneId";
    public static final String SCENE_ID_AUTO = "4";
    public static final String SCENE_ID_BUTTON = "3";
    public static final String SCENE_ID_FLOAT_BALL = "2";
    public static final String SCENE_ID_NOTICE = "1";
    public static final String SKEY = "skey";
    public static final String SPRING_TRPC = "trpc.gamecenter.trpcproxy_spring.sso";
    public static final int SSO_TYPE_TRPC = 1;
    public static final int SSO_TYPE_TRPC_NO_PROXY = 2;
    public static final int SSO_TYPE_TRPC_SPRING = 3;
    public static final int SSO_TYPE_WEBSSO = 0;
    public static final String STATUS = "status";
    public static final String SUFFIX_APK = ".apk";
    public static final String SUFFIX_TEMP = ".t";
    public static final String TABLE_NAME_NOTICE = "WADL_NOTICE";
    public static final String TABLE_NAME_TASKS_PRE = "TASKS_";
    public static final String TAG_ATTA_05076 = "08a00036462";
    public static final String TAG_ATTA_157 = "0e500018157";
    public static final String TAG_ATTA_NOTICE = "08b00075433";
    public static final String TAG_DC_00087 = "dc00087";
    public static final String TOP_FRAGMENT_NAME = "topFragmentName";
    public static final int TYPE_INSTALL = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_PAUSE = 3;
    public static final int TYPE_REGISTER = 2;
    public static final String UIN = "uin";
    public static final String VERSION_CODE = "versionCode";
    public static final String VIA = "via";
    public static final String VIA_AUTO_DOWNLOAD = "auto_download";
    public static final String VIA_AUTO_TGPA = "auto_tgpa";
    public static final String VIA_AUTO_UPDATE = "auto_update";
    public static final String VIA_INTERRUPT_BY_JOINT = "interruptByJoint";
    public static final String VIA_INTERRUPT_BY_REGEX = "interruptByRegex";
    public static final String VIA_INTERRUPT_JOINT = "interruptJoint";
    public static final String VIA_MINI_APP = "via_miniapp";
    public static final String VM_TABLE_FIELDS = "packageName TEXT NOT NULL, downloadUrl TEXT NOT NULL, via TEXT, name TEXT, iconUrl TEXT, appId TEXT, versionCode INTEGER, totalSize INTEGER, downloadSize INTEGER, status INTEGER ,savePath TEXT,fromUrl TEXT,adtag TEXT, apkSign TEXT, createTime INTEGER, channel TEXT, flags INTEGER, actionFrom INTEGER, extraData TEXT, noticeCount INTEGER,";
    public static final String WADL_INSTALL_REQUEST = "wadl_install_request";
    public static final String WADL_PROCESS_PRELOAD_ENTRY = "gamecenter_entry";
    public static final String WADL_REQUEST = "wadl_request";
    public static final int WADL_TASK_STATUS_DOWNLOAD_COMPLETED_FAIL = 7;
    public static final int WADL_TASK_STATUS_DOWNLOAD_COMPLETED_SUCCESS = 6;
    public static final int WADL_TASK_STATUS_DOWNLOAD_DELETED = 12;
    public static final int WADL_TASK_STATUS_DOWNLOAD_IDLE = 0;
    public static final int WADL_TASK_STATUS_DOWNLOAD_PAUSED = 5;
    public static final int WADL_TASK_STATUS_DOWNLOAD_RUNNING = 4;
    public static final int WADL_TASK_STATUS_DOWNLOAD_START = 2;
    public static final int WADL_TASK_STATUS_DOWNLOAD_STATUS_DETECTED = 13;
    public static final int WADL_TASK_STATUS_INSTALL_COMPLETED_SUCCESS = 9;
    public static final int WADL_TASK_STATUS_INSTALL_FAIL = 14;
    public static final int WADL_TASK_STATUS_INSTALL_REPLACE_SUCCESS = 10;
    public static final int WADL_TASK_STATUS_UNINSTALL_COMPLETED_SUCESS = 11;
    public static final int WADL_TASK_TEMP_STATUS_UPDATE = 100;
}
