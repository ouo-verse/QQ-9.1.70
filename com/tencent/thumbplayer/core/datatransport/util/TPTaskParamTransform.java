package com.tencent.thumbplayer.core.datatransport.util;

import android.text.TextUtils;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes26.dex */
public class TPTaskParamTransform {
    public static final int NON_STRING_KEY_VALUE_BOOLEAN = 2;
    public static final int NON_STRING_KEY_VALUE_INT = 0;
    public static final int NON_STRING_KEY_VALUE_LONG = 1;
    public static final Map<String, Integer> sTaskParamNonStringKey;

    static {
        HashMap hashMap = new HashMap();
        sTaskParamNonStringKey = hashMap;
        hashMap.put("task_file_type", 0);
        hashMap.put("task_biz_id", 0);
        hashMap.put("dl_param_url_expire_time", 0);
        hashMap.put("dl_param_play_clip_count", 0);
        hashMap.put("dl_param_play_clip_no", 0);
        hashMap.put("dl_param_file_size", 1);
        hashMap.put("dl_param_file_duration", 1);
        hashMap.put("dl_param_is_offline", 2);
        hashMap.put("dl_param_current_formatid", 0);
        hashMap.put("dl_param_max_bitrate", 0);
        hashMap.put("dl_param_band_width_level", 0);
        hashMap.put("dl_param_source_is_charge", 2);
        hashMap.put("dl_param_cache_need_encrypt", 2);
        hashMap.put("dl_param_preload_size", 1);
        hashMap.put("dl_param_preload_duration", 1);
        hashMap.put("dl_param_safe_play_time", 0);
        hashMap.put("dl_param_emergency_time", 0);
        hashMap.put("dl_param_buffer_size", 1);
        hashMap.put("dl_param_play_start_time", 0);
        hashMap.put("dl_param_vinfo_request_platform", 0);
        hashMap.put("dl_param_play_end_time", 0);
        hashMap.put("dl_param_vinfo_tm", 1);
        hashMap.put("dl_param_vinfo_fp2p", 0);
        hashMap.put("dl_param_vinfo_testid", 0);
        hashMap.put("dl_param_enable_expand_download_url", 2);
        hashMap.put("dl_param_adaptive_type", 0);
        hashMap.put("dl_param_data_transfer_mode", 0);
        hashMap.put("dl_param_expect_delay_time", 0);
        hashMap.put("dl_param_quic_enable_mode", 0);
        hashMap.put("dl_param_quic_congestion_type", 0);
        hashMap.put("dl_param_is_enable_quic_plaintext", 2);
        hashMap.put("dl_param_is_enable_quic_connection_migration", 2);
        hashMap.put("dl_param_adv_remain_time", 0);
        hashMap.put("dl_param_multi_network", 0);
        hashMap.put("dl_param_first_clip", 2);
        hashMap.put("dl_param_vinfo_cdn_origin", 0);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_INT_PLAY_EXPERIENCE_LEVEL, 0);
        hashMap.put("dl_param_offline_schedule_level", 0);
        hashMap.put("dl_param_dns_cache_first", 2);
        hashMap.put("dl_param_http_proxy_port", 0);
        hashMap.put("dl_param_cache_copy_first", 2);
        hashMap.put("dl_param_need_flow_control", 2);
        hashMap.put("dl_param_need_cache", 2);
        hashMap.put("dl_param_prepare_http_start_time", 1);
        hashMap.put("dl_param_prepare_running_timeout", 1);
        hashMap.put("dl_param_attach_persistent_property", 2);
        hashMap.put("dl_param_download_data_reusable", 2);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_INT_VINFO_FROM_TYPE, 0);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_IS_PREVIEW, 2);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_INT_CGI_REQUEST_NETWORK_TYPE_PRIORITY, 0);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_INT_CGI_REQUEST_LINK_METHOD, 0);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_INT_CGI_TIMEOUT_MS, 0);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_BOOLEAN_LOW_DEFN_START, 2);
        hashMap.put(TPDataTransportTaskParam.TASK_PARAM_INT_PREDOWN_SPEED_LEVEL, 0);
    }

    public static TPDownloadParam convert(TPDataTransportTaskParam tPDataTransportTaskParam) {
        int taskParamIntValue = getTaskParamIntValue(tPDataTransportTaskParam.getExtraTaskParam(), "task_file_type", 0);
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : tPDataTransportTaskParam.getExtraTaskParam().entrySet()) {
            Map<String, Integer> map = sTaskParamNonStringKey;
            if (map.containsKey(entry.getKey())) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    if (Objects.equals(map.get(entry.getKey()), 0)) {
                        hashMap.put(entry.getKey(), Integer.valueOf(TPDLProxyUtils.stringToInt(entry.getValue(), 0)));
                    } else if (Objects.equals(map.get(entry.getKey()), 1)) {
                        hashMap.put(entry.getKey(), Long.valueOf(TPDLProxyUtils.stringToLong(entry.getValue(), 0L)));
                    } else if (Objects.equals(map.get(entry.getKey()), 2)) {
                        hashMap.put(entry.getKey(), Boolean.valueOf(Boolean.parseBoolean(entry.getValue())));
                    } else {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new TPDownloadParam(tPDataTransportTaskParam.getUrlList(), taskParamIntValue, hashMap);
    }

    public static int getTaskParamIntValue(Map<String, String> map, String str, int i3) {
        if (map != null && !map.isEmpty() && map.containsKey(str)) {
            try {
                return Integer.parseInt(map.get(str), 10);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return i3;
    }

    public static String getTaskParamStringValue(Map<String, String> map, String str, String str2) {
        if (map != null && !map.isEmpty() && map.containsKey(str)) {
            return map.get(str);
        }
        return str2;
    }

    public static boolean getTaskParamIntValue(Map<String, String> map, String str, boolean z16) {
        return (map == null || map.isEmpty()) ? z16 : Boolean.parseBoolean(map.get(str));
    }

    public static long getTaskParamIntValue(Map<String, String> map, String str, long j3) {
        if (map != null && !map.isEmpty() && map.containsKey(str)) {
            try {
                return Long.parseLong(map.get(str), 10);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return j3;
    }
}
