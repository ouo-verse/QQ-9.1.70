package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPDataTransportTaskParam implements Parcelable {
    public static final Parcelable.Creator<TPDataTransportTaskParam> CREATOR = new Parcelable.Creator<TPDataTransportTaskParam>() { // from class: com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportTaskParam createFromParcel(Parcel parcel) {
            return new TPDataTransportTaskParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportTaskParam[] newArray(int i3) {
            return new TPDataTransportTaskParam[i3];
        }
    };
    public static final String TASK_PARAM_APP_TEST_ID = "dl_param_app_testid";
    public static final String TASK_PARAM_BOOLEAN_CACHE_COPY_FIRST = "dl_param_cache_copy_first";
    public static final String TASK_PARAM_BOOLEAN_CACHE_NEED_ENCRYPT = "dl_param_cache_need_encrypt";
    public static final String TASK_PARAM_BOOLEAN_DNS_CACHE_FIRST = "dl_param_dns_cache_first";
    public static final String TASK_PARAM_BOOLEAN_DOWNLOAD_DATA_REUSABLE = "dl_param_download_data_reusable";
    public static final String TASK_PARAM_BOOLEAN_DOWNLOAD_FIRST_CLIP = "dl_param_first_clip";
    public static final String TASK_PARAM_BOOLEAN_ENABLE_EXPAND_DOWNLOAD_URL = "dl_param_enable_expand_download_url";
    public static final String TASK_PARAM_BOOLEAN_ENABLE_QUIC_CONNECTION_MIGRATION = "dl_param_is_enable_quic_connection_migration";
    public static final String TASK_PARAM_BOOLEAN_ENABLE_QUIC_PLAINTEXT = "dl_param_is_enable_quic_plaintext";
    public static final String TASK_PARAM_BOOLEAN_IS_OFFLINE = "dl_param_is_offline";
    public static final String TASK_PARAM_BOOLEAN_LOW_DEFN_START = "dl_param_low_defn_start";
    public static final String TASK_PARAM_BOOLEAN_NEED_CACHE = "dl_param_need_cache";
    public static final String TASK_PARAM_BOOLEAN_NEED_FLOW_CONTROL = "dl_param_need_flow_control";
    public static final String TASK_PARAM_BOOLEAN_PREPARE_ATTACH_PERSISTENT_PROPERTY = "dl_param_attach_persistent_property";
    public static final String TASK_PARAM_BOOLEAN_SOURCE_IS_CHARGE = "dl_param_source_is_charge";
    public static final String TASK_PARAM_CHECK_AUTHENTICATION_TOKEN_KEY = "dl_param_authentication_token_key";
    public static final String TASK_PARAM_CHECK_ENCRYPT_TOKEN_KEY = "dl_param_authentication_encrypt_key";
    public static final String TASK_PARAM_CLIP_FILE_ID = "dl_param_play_clip_keyid";
    public static final String TASK_PARAM_CURRENT_FORMAT = "dl_param_current_format";
    public static final String TASK_PARAM_ENABLE_TEG_PCDN = "dl_param_enable_teg_pcdn";
    public static final String TASK_PARAM_ENCRYPT_STREAM_KEY = "dl_param_encrypt_stream_key";
    public static final String TASK_PARAM_ENCRYPT_STREAM_RANDOMS = "dl_param_encrypt_stream_randoms";
    public static final String TASK_PARAM_FILE_ID = "dl_param_play_keyid";
    public static final String TASK_PARAM_FILE_MD5 = "dl_param_file_md5";
    public static final String TASK_PARAM_FORMAT_NODES_KEY_BITRATE_PBS = "dl_param_bitrate";
    public static final String TASK_PARAM_FORMAT_NODES_KEY_NAME = "dl_param_name";
    public static final String TASK_PARAM_HTTP_PROXY_HOST = "dl_param_http_proxy_host";
    public static final String TASK_PARAM_INT_ADAPTIVE_TYPE = "dl_param_adaptive_type";
    public static final String TASK_PARAM_INT_BAND_WIDTH_LEVEL = "dl_param_band_width_level";
    public static final String TASK_PARAM_INT_BIZ_ID = "task_biz_id";
    public static final String TASK_PARAM_INT_CGI_REQUEST_LINK_METHOD = "dl_param_cgi_link_method";
    public static final String TASK_PARAM_INT_CGI_REQUEST_NETWORK_TYPE_PRIORITY = "dl_param_cgi_network_priority";
    public static final String TASK_PARAM_INT_CGI_TIMEOUT_MS = "dl_param_cgi_timeout_ms";
    public static final String TASK_PARAM_INT_CURRENT_FORMAT_ID = "dl_param_current_formatid";
    public static final String TASK_PARAM_INT_DATA_TRANSFER_MODE = "dl_param_data_transfer_mode";
    public static final String TASK_PARAM_INT_EMERGENCY_TIME_SEC = "dl_param_emergency_time";
    public static final String TASK_PARAM_INT_ENABLE_MULTI_NETWORK = "dl_param_multi_network";
    public static final String TASK_PARAM_INT_FILE_TYPE = "task_file_type";
    public static final String TASK_PARAM_INT_HTTP_PROXY_PORT = "dl_param_http_proxy_port";
    public static final String TASK_PARAM_INT_LIVE_EXPECT_DELAY_TIME_MS = "dl_param_expect_delay_time";
    public static final String TASK_PARAM_INT_MAX_BITRATE = "dl_param_max_bitrate";
    public static final String TASK_PARAM_INT_OFFLINE_SCHEDULER_LEVEL = "dl_param_offline_schedule_level";
    public static final String TASK_PARAM_INT_PLAY_CLIP_COUNT = "dl_param_play_clip_count";
    public static final String TASK_PARAM_INT_PLAY_CLIP_NO = "dl_param_play_clip_no";
    public static final String TASK_PARAM_INT_PLAY_END_TIME_MS = "dl_param_play_end_time";
    public static final String TASK_PARAM_INT_PLAY_EXPERIENCE_LEVEL = "dl_param_vinfo_play_experience_level";
    public static final String TASK_PARAM_INT_PLAY_START_TIME_MS = "dl_param_play_start_time";
    public static final String TASK_PARAM_INT_PREDOWN_SPEED_LEVEL = "dl_param_predown_speed_level";
    public static final String TASK_PARAM_INT_QUIC_CONGESTION_TYPE = "dl_param_quic_congestion_type";
    public static final String TASK_PARAM_INT_QUIC_ENABLE_MODE = "dl_param_quic_enable_mode";
    public static final String TASK_PARAM_INT_REMAIN_DURATION_BEFORE_REAL_PLAY_SEC = "dl_param_adv_remain_time";
    public static final String TASK_PARAM_INT_SAFE_PLAY_TIME_SEC = "dl_param_safe_play_time";
    public static final String TASK_PARAM_INT_URL_EXPIRE_DURATION_SEC = "dl_param_url_expire_time";
    public static final String TASK_PARAM_INT_VINFO_CDN_ORIGIN = "dl_param_vinfo_cdn_origin";
    public static final String TASK_PARAM_INT_VINFO_FP2P = "dl_param_vinfo_fp2p";
    public static final String TASK_PARAM_INT_VINFO_FROM_TYPE = "dl_param_vinfo_from_type";
    public static final String TASK_PARAM_INT_VINFO_TEST_ID = "dl_param_vinfo_testid";
    public static final String TASK_PARAM_IS_PREVIEW = "dl_param_is_preview";
    public static final String TASK_PARAM_JSON_FORMAT_NODES = "dl_param_format_nodes";
    public static final String TASK_PARAM_JSON_SECONDARY_M3U8_CONTENT = "dl_param_vinfo_secondary_m3u8";
    public static final String TASK_PARAM_JSON_URL_HEADER = "dl_param_url_header";
    public static final String TASK_PARAM_LONG_BUFFER_SIZE_BYTE = "dl_param_buffer_size";
    public static final String TASK_PARAM_LONG_FILE_DURATION_MS = "dl_param_file_duration";
    public static final String TASK_PARAM_LONG_FILE_SIZE_BYTE = "dl_param_file_size";
    public static final String TASK_PARAM_LONG_PRELOAD_DURATION_MS = "dl_param_preload_duration";
    public static final String TASK_PARAM_LONG_PRELOAD_SIZE_BYTE = "dl_param_preload_size";
    public static final String TASK_PARAM_LONG_PREPARE_HTTP_START_TIME_MS = "dl_param_prepare_http_start_time";
    public static final String TASK_PARAM_LONG_PREPARE_RUNNING_TIMEOUT_MS = "dl_param_prepare_running_timeout";
    public static final String TASK_PARAM_LONG_VINFO_TM = "dl_param_vinfo_tm";
    public static final String TASK_PARAM_MASTER_M3U8_CONTENT = "dl_param_vinfo_m3u8";
    public static final String TASK_PARAM_MULTI_NET_URL = "dl_param_multi_net_url";
    public static final String TASK_PARAM_NONCE = "dl_param_nonce";
    public static final String TASK_PARAM_OFFLINE_PLAY_EXTRA_INFO = "dl_param_play_extra_info";
    public static final String TASK_PARAM_PACKAGE_NAME = "package";
    public static final String TASK_PARAM_PCDN_CHARGE_ID = "dl_param_pcdn_charge_id";
    public static final String TASK_PARAM_PCDN_URLS = "dl_param_pcdn_urls";
    public static final String TASK_PARAM_PCDN_VTS = "dl_param_pcdn_vts";
    public static final String TASK_PARAM_PLAY_DEFINITION = "dl_param_play_definition";
    public static final String TASK_PARAM_PLAY_FLOW_ID = "dl_param_play_flowid";
    public static final String TASK_PARAM_SAVE_PATH = "dl_param_save_path";
    public static final String TASK_PARAM_SCENE_ID = "dl_param_scene_id";
    public static final String TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID = "keyid";
    public static final String TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8 = "m3u8";
    public static final String TASK_PARAM_URL_METHOD = "dl_param_url_method";
    public static final String TASK_PARAM_URL_POST_BODY = "dl_param_url_post_body";
    public static final String TASK_PARAM_USER_FORMAT = "dl_param_user_format";
    public static final String TASK_PARAM_VINFO_BASE = "dl_param_vinfo_base";
    public static final String TASK_PARAM_VINFO_CID = "dl_param_cid";
    public static final String TASK_PARAM_VINFO_LINK_VID = "dl_param_vinfo_link_vid";
    public static final String TASK_PARAM_VINFO_REQUEST_APP_VER = "dl_param_vinfo_request_app_ver";
    public static final String TASK_PARAM_VINFO_REQUEST_PLATFORM = "dl_param_vinfo_request_platform";
    public static final String TASK_PARAM_VINFO_SELF_CDN_PARAM = "dl_param_vinfo_self_cdn_param";
    public static final String TASK_PARAM_VINFO_SELF_ENCRYPTION_CIPHERTEXT = "dl_param_vinfo_data_processor_text";
    public static final String TASK_PARAM_VINFO_TS_REPORT_SEQUENCE_LIST = "dl_param_vinfo_ts_report_sequence_list";
    public static final String TASK_PARAM_VINFO_VID = "dl_param_vid";
    public static final String TASK_PARAM_XP2P_ID = "xp2p_id";
    public static final String TASK_PARAM_XP2P_KEY = "xp2p_key";
    public static final String TASK_PARAM_XP2P_SECRET_KEY = "xp2p_secretKey";
    private HashMap<String, String> mExtraTaskParam;
    private ArrayList<String> mUrlList;

    public TPDataTransportTaskParam(@NonNull ArrayList<String> arrayList) {
        this.mUrlList = new ArrayList<>();
        this.mExtraTaskParam = new HashMap<>();
        this.mUrlList = arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getExtraTaskParam() {
        return this.mExtraTaskParam;
    }

    public ArrayList<String> getUrlList() {
        return this.mUrlList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringList(this.mUrlList);
        parcel.writeMap(this.mExtraTaskParam);
    }

    public TPDataTransportTaskParam(@NonNull ArrayList<String> arrayList, Map<String, String> map) {
        this.mUrlList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        this.mExtraTaskParam = hashMap;
        this.mUrlList = arrayList;
        hashMap.putAll(map);
    }

    protected TPDataTransportTaskParam(Parcel parcel) {
        this.mUrlList = new ArrayList<>();
        this.mExtraTaskParam = new HashMap<>();
        try {
            this.mUrlList = parcel.createStringArrayList();
            parcel.readMap(this.mExtraTaskParam, getClass().getClassLoader());
        } catch (Throwable unused) {
            this.mUrlList = new ArrayList<>();
            this.mExtraTaskParam = new HashMap<>();
        }
    }
}
