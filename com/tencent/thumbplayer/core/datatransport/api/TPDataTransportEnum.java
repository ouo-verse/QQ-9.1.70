package com.tencent.thumbplayer.core.datatransport.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPDataTransportEnum {
    public static final int APP_STATE_BACKGROUND = 1;
    public static final int APP_STATE_FOREGROUND = 0;
    public static final int APP_STATE_MAIN_PROCESS = 4;
    public static final int APP_STATE_SCREEN_OFF = 2;
    public static final int APP_STATE_SCREEN_ON = 3;
    public static final int APP_STATE_SUB_PROCESS = 5;
    public static final int APP_STATE_SUB_PROCESS_AND_MAIN_PROCESS_EXIST = 6;
    public static final String BIZ_OPTIONAL_CONFIG_PARAM_DATA_DIR = "data_dir";
    public static final String BIZ_OPTIONAL_CONFIG_PARAM_LONG_MAX_CACHE_SIZE_MB = "max_cache_size_mb";
    public static final int CACHE_FILE_FORMAT_FILE = 4;
    public static final int CACHE_FILE_FORMAT_HLS = 3;
    public static final int CACHE_FILE_FORMAT_MP4 = 1;
    public static final int CACHE_FILE_FORMAT_MULTI_CLIP_MP4 = 2;
    public static final int CGI_REQUEST_LINK_METHOD_HTTP = 0;
    public static final int CGI_REQUEST_LINK_METHOD_HTTPS = 1;
    public static final int CGI_REQUEST_LINK_METHOD_QUIC = 2;
    public static final int CGI_REQUEST_NETWORK_TYPE_PRIORITY_CELLUAR = 2;
    public static final int CGI_REQUEST_NETWORK_TYPE_PRIORITY_NONE = 0;
    public static final int CGI_REQUEST_NETWORK_TYPE_PRIORITY_WIFI = 1;
    public static final int CGI_RESPONSE_NETWORK_TYPE_CELLUAR = 1;
    public static final int CGI_RESPONSE_NETWORK_TYPE_WIFI = 0;
    public static final int CLEAR_CACHE_MODE_ALL_ONLINE_STORAGE = 8;
    public static final int CLEAR_CACHE_MODE_MEMORY_STORAGE = 4;
    public static final int CLEAR_CACHE_MODE_OFFLINE_PROPERTY = 2;
    public static final int CLEAR_CACHE_MODE_STORAGE = 1;
    public static final int DATA_TRANSFER_MODE_AV = 1;
    public static final int DATA_TRANSFER_MODE_DEFAULT = 0;
    public static final int DATA_TRANSFER_MODE_FMP4_TO_TS = 2;
    public static final int DEFINITION_SELECTION_STATE_NOT_SELECTED = 0;
    public static final int DEFINITION_SELECTION_STATE_SELECTED = 1;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_ADAPTIVE_STRATEGY_BANDWIDTH_FIRST = 6;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_ADAPTIVE_STRATEGY_QOS_FIRST = 7;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_CELLULAR_FLOW_BYTES = 2;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_FLOW_BYTES = 3;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_MEMORY_BYTES = 5;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_SELF_ENCRYPTION_KEY = 10;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_SELF_ENCRYPTION_PARAM_CAPACITY_LEVEL = 8;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_SELF_ENCRYPTION_VINFO_LEVEL = 9;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_SUGGEST_BITRATE = 0;
    public static final int GLOBAL_ACCESSIBLE_NATIVE_INFO_TYPE_SUGGEST_DEFN = 1;
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_ADAPTIVE_ABS_INFO = "adaptive_abs_info";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_APP_TAB_TEST_ID = "app_test_id";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_APP_VERSION = "app_version_name";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_BSSID = "bssid";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_CELLULAR_INTERFACE_ID = "cellular_interface_id";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_CELLULAR_INTERFACE_NAME = "cellular_interface_name";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_DEVICE_MODEL = "device_model";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_DNS_SERVERS = "dns_servers";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_EXTERNAL_NETWORK_IP = "external_network_ip";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_GUID = "guid";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_HTTP_PROXY_HOST = "http_proxy_host";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_APP_STATE = "app_state";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_DEFINITION_SELECTION_STATE = "definition_selection_state";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_DEVICE_MAX_USE_MEMORY_MB = "max_use_memory";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_HTTP_PROXY_PORT = "http_proxy_port";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_IS_VIP = "qq_is_vip";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_MAX_PREPUSH_HTTP_DOWNLOAD_SPEED_KB = "max_prepush_http_download_speed_kb";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_MAX_UPLOAD_SPEED_KB = "upload_speed_kb";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE = "network_state";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_OFFLINE_ACCELERATE_STATE = "offline_accelerate_state";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_P2P_UPLOAD_STATE = "enable_p2p_upload";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_PREPUSH_STATE = "enable_prepush";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_RECEIVE_MEMORY_WARNING = "receive_memory_warning";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_SYSTEM_RESERVE_MEMORY_MB = "system_reserve_memory";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_TAB_CALLBACK_ACK = "tab_callback_ack";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_TRIM_MEMORY_LEVEL = "trim_memory_level";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_UPC_STATE = "carrier_pesudo_state";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_INT_USE_MULTI_NETWORK = "use_multi_network";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_LIMIT_MODE = "limit_mode";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_LOSS_PACKAGE_INFO = "lose_package_check_info";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_OFFLINE_CHECK_FAILED = "offline_check_failed";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_OS_VERSION = "os_version";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_PCDN_BIZ_ID = "pcdn_biz_id";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_PLATFORM = "platform";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_PROXY_CONFIG = "proxy_config";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_TAB_ABUSERID = "abuserid";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_UPC = "carrier_pesudo_code";
    public static final String GLOBAL_OPTIONAL_CONFIG_PARAM_VUID = "vuid";
    public static final int NETWORK_STATE_MOBILE = 2;
    public static final int NETWORK_STATE_OFF = 0;
    public static final int NETWORK_STATE_WIFI = 1;
    public static final int OFFLINE_SCHEDULE_LEVEL_ALL = 0;
    public static final int OFFLINE_SCHEDULE_LEVEL_HIGH_BITRATE = 2;
    public static final int OFFLINE_SCHEDULE_LEVEL_LOW_BITRATE = 1;
    public static final int OFFLINE_SCHEDULE_LEVEL_UNSUPPORTED = 3;
    public static final int P2P_UPLOAD_STATE_DISABLE = 0;
    public static final int P2P_UPLOAD_STATE_ENABLE = 1;
    public static final int P2P_UPLOAD_STATE_PRIVACY_DISABLE = 2;
    public static final int P2P_UPLOAD_STATE_PRIVACY_ENABLE = 3;
    public static final int PREDOWN_SPEED_LEVEL_FULL = 2;
    public static final int PREDOWN_SPEED_LEVEL_NORMAL = 0;
    public static final int PREDOWN_SPEED_LEVEL_PEAK = 1;
    public static final int PREPUSH_STATE_DISABLE = 0;
    public static final int PREPUSH_STATE_ENABLE = 1;
    public static final int QUIC_CONGESTION_TYPE_BBR = 2;
    public static final int QUIC_CONGESTION_TYPE_CUBIC_BYTES = 0;
    public static final int QUIC_CONGESTION_TYPE_GOOGCC = 4;
    public static final int QUIC_CONGESTION_TYPE_PCC = 3;
    public static final int QUIC_CONGESTION_TYPE_RENO_BYTES = 1;
    public static final int QUIC_ENABLE_MODE_DEPEND_ON_PROBE = 1;
    public static final int QUIC_ENABLE_MODE_DISABLE = 0;
    public static final int QUIC_ENABLE_MODE_FORCE_ENABLE = 2;
    public static final int TASK_FILE_TYPE_AUTO = 0;
    public static final int TASK_FILE_TYPE_CAPTION_SRT = 14;
    public static final int TASK_FILE_TYPE_CAPTION_WEBVTT = 15;
    public static final int TASK_FILE_TYPE_CGI = 24;
    public static final int TASK_FILE_TYPE_CLIP_MP4_VOD = 2;
    public static final int TASK_FILE_TYPE_DASH = 19;
    public static final int TASK_FILE_TYPE_FILE_DOWNLOAD = 10;
    public static final int TASK_FILE_TYPE_FILE_VOD_PROXY_LOAD = 11;
    public static final int TASK_FILE_TYPE_FLV_LIVE = 12;
    public static final int TASK_FILE_TYPE_HLS_ADV = 7;
    public static final int TASK_FILE_TYPE_HLS_ADV_LOOP = 8;
    public static final int TASK_FILE_TYPE_HLS_AUDIO_VOD = 13;
    public static final int TASK_FILE_TYPE_HLS_BATCH = 22;
    public static final int TASK_FILE_TYPE_HLS_LIVE = 5;
    public static final int TASK_FILE_TYPE_HLS_VOD = 3;
    public static final int TASK_FILE_TYPE_HLS_VOD_LOOP = 4;
    public static final int TASK_FILE_TYPE_HLS_VOD_PROXY_LOAD = 18;
    public static final int TASK_FILE_TYPE_HTTP_FLV_LIVE = 16;
    public static final int TASK_FILE_TYPE_HTTP_PRELOAD_FLV_LIVE = 17;
    public static final int TASK_FILE_TYPE_LAN = 9;
    public static final int TASK_FILE_TYPE_MP4_ADV = 6;
    public static final int TASK_FILE_TYPE_MP4_BATCH = 20;
    public static final int TASK_FILE_TYPE_MP4_CLIP_BATCH = 21;
    public static final int TASK_FILE_TYPE_MP4_VOD = 1;
    public static final int TASK_FILE_TYPE_P2P_FLV_LIVE = 23;
    public static final String TASK_OPTIONAL_CONFIG_PARAM_FLOAT_SPEED_RATIO = "taskinfo_speed_ratio";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INNER_INT_ADAPTIVE_DYNAMIC_SWITCH = "taskinfo_adaptive_dynamic_switch";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INNER_LONG_MAX_BITRATE = "taskinfo_max_bitrate";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_CONTROL_STRATEGY = "taskinfo_adaptive_control_strategy";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_DYNAMIC_SWITCH = "optional_id_global_int_enable_adaptive_switch_def";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_MODE = "taskinfo_adaptive_mode";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_EVENT = "task_player_event";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_STATE = "task_player_state";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_INT_RUNNING_STATE = "task_running_state";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_LONG_MAX_BITRATE = "optional_id_global_long_adaptive_limit_bitrate_range_max";
    public static final String TASK_OPTIONAL_CONFIG_PARAM_LONG_PLAY_OFFSET_BYTE = "taskinfo_play_offset";
    public static final String TASK_OPTIONAL_SlEF_EMERGENCY_SAFE_TIME = "taskinfo_self_emergency_safe_time_s";
    public static final int TASK_PLAYER_EVENT_SECONDARY_BUFFERING_END = 3;
    public static final int TASK_PLAYER_EVENT_SECONDARY_BUFFERING_START = 2;
    public static final int TASK_PLAYER_EVENT_SEEK_COMPLETE = 1;
    public static final int TASK_PLAYER_EVENT_SEEK_START = 0;
    public static final int TASK_PLAYER_STATE_ON_PAUSE = 2;
    public static final int TASK_PLAYER_STATE_ON_PLAYING = 0;
    public static final int TASK_PLAYER_STATE_ON_PLAY_ERROR = 1;
    public static final int TASK_PLAYER_STATE_ON_PREPARE = 3;
    public static final int TASK_PROXY_URL_TYPE_LOCAL_ABSOLUTE_URL_PRIORITY = 0;
    public static final int TASK_PROXY_URL_TYPE_LOCAL_PROXY_URL_CREATE_TASK = 2;
    public static final int TASK_PROXY_URL_TYPE_LOCAL_PROXY_URL_ONLY = 1;
    public static final int TASK_RUNNING_STATE_ON_PRE_PLAY = 0;
    public static final int TASK_RUNNING_STATE_ON_REAL_PLAY = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface AppState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface BizAccessibleNativeInfo {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface BizOptionalConfigParam {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface CacheFileFormat {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface CgiRequestLinkMethod {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface CgiRequestNeworkTypePriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface CgiResponseNetworkType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface ClearCacheMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface DataTransferMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface DefinitionSelectionState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface GlobalAccessibleNativeInfo {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface GlobalOptionalConfigParam {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface NetworkState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface OfflineScheduleLevel {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface P2PUploadState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface PredownSpeedLevel {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface PrepushState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface QuicCongestionType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface QuicEnableMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskAccessibleNativeInfo {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskFileType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskOptionalConfigParam {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskPlayerEvent {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskPlayerState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskProxyUrlType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskRunningState {
    }
}
