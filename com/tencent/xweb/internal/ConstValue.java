package com.tencent.xweb.internal;

import com.tencent.xweb.CalledByApi;

/* compiled from: P */
@CalledByApi
/* loaded from: classes27.dex */
public class ConstValue {
    public static final String APP_INFO_EMBED_XWEB = "EMBED_XWEB";
    public static final String APP_INFO_GP_USER = "GP_USER";
    public static final String APP_INFO_MP_DEVELOPER = "MP_DEVELOPER";
    public static final String APP_INFO_WXDK_USER = "WXDK_USER";
    public static final int APP_SET_APPBRAND_ID = 90001;
    public static final int APP_SET_LOCAL_STG_SUFFIX = 90002;
    public static final String CATEGORY_FRAME_COST = "xprofile.frameCost";
    public static final String CATEGORY_FRAME_COST_DISABLE = "xprofile.frameCost_Disable_FromClient";
    public static final String EXTEND_CONFIG_CUSTOM_DENSITY = "customDensity";
    public static final String EXTEND_CONFIG_KEY_HAS_LOGIN = "hasLogin";
    public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
    public static final String EXTENSION_AUTO_CHECK_UPDATE = "autoCheckUpdate";
    public static final String EXTENSION_GET_HOST_NAME_FROM_HTTP = "getHostByNameFromHttp";
    public static final String EXTENSION_GET_HOST_NAME_FROM_NEW = "getHostByName";
    public static final String INIT_CONFIG_KEY_CLIENT_VERSION = "clientVersion";
    public static final String INIT_CONFIG_KEY_DEVICE_MODEL = "deviceModel";
    public static final String INIT_CONFIG_KEY_IS64ABI = "is64bitAbi";
    public static final String INIT_CONFIG_KEY_ISGPVERSION = "isGPVersion";
    public static final String INIT_CONFIG_KEY_PACKAGE_NAME = "packageName";
    public static final String INIT_CONFIG_KEY_PROCESSNAME = "processName";
    public static final int INVOKE_CHANNEL_FUNC_ID_LOG = 30002;
    public static final int INVOKE_CHANNEL_FUNC_ID_NATIVE_TRANS = 30003;
    public static final int INVOKE_NOTIFY_FUNCTION_ID_IDKEY = 50001;
    public static final int INVOKE_NOTIFY_FUNCTION_ID_KVSTAT = 50002;
    public static final int INVOKE_RUNTIME_ID_ASYC_MEMORY_DUMP = 80021;
    public static final int INVOKE_RUNTIME_ID_CLEAR_PROXY_OVERRIDE = 80027;
    public static final int INVOKE_RUNTIME_ID_CONTEXT_CHANGED = 80001;
    public static final int INVOKE_RUNTIME_ID_DELETE_ORIGIN = 80006;
    public static final int INVOKE_RUNTIME_ID_ENABLE_CHECK_CERTIFICATE = 80022;
    public static final int INVOKE_RUNTIME_ID_FORCE_KILL_CHILD_PROCESS = 80034;
    public static final int INVOKE_RUNTIME_ID_FORCE_KILL_GPU_PROCESS = 80025;
    public static final int INVOKE_RUNTIME_ID_FORCE_KILL_RENDER_PROCESS = 80024;
    public static final int INVOKE_RUNTIME_ID_GET_RENDER_SANDBOX_PROCESS_MEMORY = 80023;
    public static final int INVOKE_RUNTIME_ID_HAS_FEATURE = 80003;
    public static final int INVOKE_RUNTIME_ID_MEMORY_DUMP = 80018;
    public static final int INVOKE_RUNTIME_ID_NEW_LOCATION = 80030;
    public static final int INVOKE_RUNTIME_ID_PRE_INIT_GPU_PROCESS = 80020;
    public static final int INVOKE_RUNTIME_ID_PRE_INIT_RENDER_PROCESS = 80019;
    public static final int INVOKE_RUNTIME_ID_PROXY_OVERRIDE_REVERSE_BYPASS = 80028;
    public static final int INVOKE_RUNTIME_ID_SET_INTERCEPT_DISPATCH_KEY_HANDLER = 80015;
    public static final int INVOKE_RUNTIME_ID_SET_PROXY_OVERRIDE = 80026;
    public static final int INVOKE_RUNTIME_ID_SET_RUNTIME_CONFIG = 80031;
    public static final int INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL = 80005;
    public static final int INVOKE_RUNTIME_ID_START_REMOTE_DEBUG = 80033;
    public static final int INVOKE_RUNTIME_ID_STOP_REMOTE_DEBUG = 80032;
    public static final int INVOKE_RUNTIME_ID_SUPPORT_TRANLATE_WEB = 80011;
    public static final int INVOKE_RUNTIME_ID_USE_LOCATION_PROXY = 80029;
    public static final int INVOKE_RUNTIME_ID_XPROFILE_ENABLE_ALL_KINDS_FPS = 80017;
    public static final int INVOKE_RUNTIME_ID_XPROFILE_FORCE_FLUSH = 80016;
    public static final int INVOKE_RUNTIME_ID_XPROFILE_NEED_FORWARD_TO_SDK = 80013;
    public static final int INVOKE_RUNTIME_ID_XPROFILE_SET = 80012;
    public static final String PACKAGE_NAME_WECHAT = "com.tencent.mm";
    public static final String XWEB_UPDATER_START_CHECK_TYPE = "UpdaterCheckType";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_AUTO = "7";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_CONFIG_ONLY = "5";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_EMBEDINSTALL = "4";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_FORCE_CHECK = "2";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_FORCE_DOWNLOAD = "3";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_NOTIFY = "1";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_NOTIFY_ONLY_INSTALL_EMBED_PLUGIN = "6";
    public static final String XWEB_UPDATER_START_CHECK_TYPE_TIMER = "0";

    /* compiled from: P */
    @CalledByApi
    /* loaded from: classes27.dex */
    public enum UpdateHttpDns {
        ADD,
        DELETE,
        DELETE_ALL
    }
}
