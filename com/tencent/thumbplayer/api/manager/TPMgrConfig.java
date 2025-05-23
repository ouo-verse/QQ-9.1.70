package com.tencent.thumbplayer.api.manager;

import com.tencent.thumbplayer.common.annotation.TPOptionalParamValueAnnotation;

/* loaded from: classes26.dex */
public class TPMgrConfig {

    @TPOptionalParamValueAnnotation(intValue = 0, type = int.class)
    public static final String TP_MGR_CONFIG_KEY_BEFORE_INT_PLATFORM = "tp_mgr_config_key_before_int_platform";

    @TPOptionalParamValueAnnotation(stringValue = "", type = String.class)
    public static final String TP_MGR_CONFIG_KEY_BEFORE_STRING_DEVICE_NAME = "tp_mgr_config_key_before_string_device_name";

    @TPOptionalParamValueAnnotation(stringValue = "", type = String.class)
    public static final String TP_MGR_CONFIG_KEY_BEFORE_STRING_GUID = "tp_mgr_config_key_before_string_guid";

    @TPOptionalParamValueAnnotation(stringValue = "", type = String.class)
    public static final String TP_MGR_CONFIG_KEY_BEFORE_STRING_HOSTS = "tp_mgr_config_key_before_string_hosts";

    @TPOptionalParamValueAnnotation(booleanValue = false, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_DEMUXER_READ_PACKET_ERROR_CHECK_AVIO_EOF = "tp_mgr_config_key_global_bool_enable_demuxer_read_packet_error_check_avio_eof";

    @TPOptionalParamValueAnnotation(booleanValue = true, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_FFMPEG_LOG_PTHREAD_LOCAL_STORAGE = "tp_mgr_config_key_global_bool_enable_ffmpeg_log_pthread_local_storage";

    @TPOptionalParamValueAnnotation(booleanValue = true, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_HARD_DYNAMIC_MAPPING = "tp_mgr_config_key_global_bool_enable_hdrvivid_hard_dynamic_mapping";

    @TPOptionalParamValueAnnotation(booleanValue = false, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_SOFT_DYNAMIC_MAPPING = "tp_mgr_config_key_global_bool_enable_hdrvivid_soft_dynamic_mapping";

    @TPOptionalParamValueAnnotation(booleanValue = false, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_SOFT_OES_TEXTURE_RENDER = "tp_mgr_config_key_global_bool_enable_hdrvivid_soft_oes_texture_render";

    @TPOptionalParamValueAnnotation(booleanValue = false, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_SOFT_SDR_DYNAMIC_MAPPING = "tp_mgr_config_key_global_bool_enable_hdrvivid_soft_sdr_dynamic_mapping";

    @TPOptionalParamValueAnnotation(booleanValue = true, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDR_DOWNWARD_COMPATIBILITY = "tp_mgr_config_key_global_bool_enable_hdr_downward_compatibility";

    @TPOptionalParamValueAnnotation(booleanValue = false, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_MEDIACODEC_INSTANCE_COUNT_LIMIT = "tp_mgr_config_key_global_bool_enable_mediacodec_instance_count_limit";

    @TPOptionalParamValueAnnotation(booleanValue = true, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_CAPABILITY_MODEL = "tp_mgr_config_key_global_bool_enable_new_capability_model";

    @TPOptionalParamValueAnnotation(booleanValue = false, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_LOOPBACK = "tp_mgr_config_key_global_bool_enable_new_loopback";

    @TPOptionalParamValueAnnotation(booleanValue = false, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_PLAYING_QUALITY_REPORT = "tp_mgr_config_key_global_bool_enable_new_playing_quality_report";

    @TPOptionalParamValueAnnotation(booleanValue = true, type = boolean.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_PLAYING_QUALITY_REPORT = "tp_mgr_config_key_global_bool_enable_playing_quality_report";

    @TPOptionalParamValueAnnotation(intValue = 2, type = int.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_INT_MEDIACODEC_STUCK_MAX_CNT = "tp_mgr_config_key_global_int_mediacodec_stuck_max_cnt";

    @TPOptionalParamValueAnnotation(intValue = 0, type = int.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_INT_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT = "tp_mgr_config_key_global_int_video_mediacodec_co_exist_max_cnt";

    @TPOptionalParamValueAnnotation(longValue = 500, type = long.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_LONG_SYNC_API_WAIT_TIMEOUT_MS = "tp_mgr_config_key_global_long_sync_api_wait_timeout_ms";

    @TPOptionalParamValueAnnotation(longValue = -1, type = long.class)
    public static final String TP_MGR_CONFIG_KEY_GLOBAL_LONG_VIDEO_MEDIACODEC_STUCK_TIMEOUT_MS = "tp_mgr_config_key_global_long_mediacodec_stuck_timeout_ms";
}
