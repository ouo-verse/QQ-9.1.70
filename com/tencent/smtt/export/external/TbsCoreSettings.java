package com.tencent.smtt.export.external;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TbsCoreSettings {
    public static final String EXTRA_BIND_TO_CALLER = "org.chromium.base.process_launcher.extra.bind_to_caller";
    public static final String EXTRA_COMMAND_LINE = "org.chromium.base.process_launcher.extra.command_line";
    public static final String EXTRA_CPU_COUNT = "com.google.android.apps.chrome.extra.cpu_count";
    public static final String EXTRA_CPU_FEATURES = "com.google.android.apps.chrome.extra.cpu_features";
    public static final String EXTRA_FILES = "org.chromium.base.process_launcher.extra.extraFiles";
    public static final String EXTRA_FILE_FDS = "com.google.android.apps.chrome.extra.extraFileFds";
    public static final String EXTRA_FILE_FDS_OF_LIBRARIES = "com.google.android.apps.chrome.extra.extraFileFdsOfLibrary";
    public static final String EXTRA_FILE_IDS = "com.google.android.apps.chrome.extra.extraFileIds";
    public static final String EXTRA_FILE_OFFSETS = "com.google.android.apps.chrome.extra.extraFileOffsets";
    public static final String EXTRA_FILE_SIZES = "com.google.android.apps.chrome.extra.extraFileSizes";
    public static final String ID_NWINFO_GETEXTRAINFO = "NetworkInfo_getExtraInfo";
    public static final String ID_OPERATE_PROHIBIT = "prohibit";
    public static final String ID_TELE_GETNETWORKOPERATOR = "TelephonyManager_getNetworkOperator";
    public static final String LAZY_LOAD_LIBRARY_FDS = "lazy_load_library_fds";
    public static final String LAZY_LOAD_LIBRARY_NAMES = "lazy_load_library_names";
    public static final String MULTI_PROCESS_AUTO_RECOVERY = "multi_process_auto_recovery_default";
    public static final String MULTI_PROCESS_ENABLE = "multi_process_type_default";
    public static final String MULTI_PROCESS_FALLBACK_SERVICE = "multi_process_fallback_service_default";
    public static final String MULTI_PROCESS_NO_SANDBOX = "multi_process_no_sandbox_default";
    public static final String NO_SENSITIVE_API = "no_sensitive_api";
    public static final String TBS_APP_VERSION_NAME_CUSTOMIZED = "app_version_name_customized";
    public static final String TBS_BUSINESS_LICENSE_KEY = "lck";
    public static final String TBS_SANDBOX_CRASH_RECORD_FILE0 = "sandbox_crash_record0";
    public static final String TBS_SANDBOX_CRASH_RECORD_FILE1 = "sandbox_crash_record1";
    public static final String TBS_SETTINGS_APP_KEY = "AppKey";
    public static final String TBS_SETTINGS_APP_SCENE_ID = "app_scene_id";
    public static final String TBS_SETTINGS_APP_USE_SCENE = "app_use_scene";
    public static final String TBS_SETTINGS_CHECK_TBS_VALIDITY = "check_tbs_validity";
    public static final String TBS_SETTINGS_CLOASE_CLIPBOARD_ON_KERNEL_STARTUP = "close_clipboard_on_kernel_startup";
    public static final String TBS_SETTINGS_DISABLE_IPC_FLOODING_PROTECTION = "disable-ipc-flooding-protection";
    public static final String TBS_SETTINGS_ENABLE_LOCATION_PROVIDER_ANDROID = "enable_location_provider_android";
    public static final String TBS_SETTINGS_FORCE_TBSMMKV = "force_tbs_mmkv";
    public static final String TBS_SETTINGS_IS_LOWEND_DEVICES = "sandbox_isLowEndDevice";

    @Deprecated
    public static final String TBS_SETTINGS_PRAVITE_MTT_CLASSES = "use_mtt_classes";
    public static final String TBS_SETTINGS_PRIVATE_CLASS_LIST = "private_class_list";
    public static final String TBS_SETTINGS_SANDBOX_BUILDINFO = "sandbox_buildinfo";
    public static final String TBS_SETTINGS_USE_DEXLOADER_SERVICE = "use_dexloader_service";
    public static final String TBS_SETTINGS_USE_PRIVATE_CLASSLOADER = "use_private_classloader";
    public static final String TBS_SETTINGS_USE_SANDBOX = "use_sandbox";
    public static final String TBS_SETTINGS_USE_SPEEDY_CLASSLOADER = "use_speedy_classloader";
    public static final String TBS_SETTINGS_WEAPP_ID_KEY = "weapp_id";
    public static final String TBS_SETTINGS_WEAPP_NAME_KEY = "weapp_name";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Render {
        public static final int MULTI_PROCESS_CLOSE = 0;
        public static final int MULTI_PROCESS_OPEN = 1;
        public static final int MULTI_PROCESS_OPEN_SANDBOX = 3;
    }
}
