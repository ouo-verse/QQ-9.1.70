package com.tencent.qqlive.tvkplayer.tools.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.config.TVKServiceDefaultUrl;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKJsonUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUrlConfig {
    private static final String HOST_CONFIG_JSON_KEY_PLAYER_HOST_CONFIG = "player_host_config";
    public static final String SERVICE_NAME_AD_CONFIG_CGI_HOST = "ad_config_cgi_host";
    public static final String SERVICE_NAME_BATCH_VINFO_CGI_HOST = "batch_vinfo_cgi_host";
    public static final String SERVICE_NAME_BATCH_VINFO_CGI_HOST_BK = "batch_vinfo_cgi_host_bk";
    public static final String SERVICE_NAME_BATCH_VINFO_DUALSTACK_CGI_HOST = "batch_vinfo_dualstack_cgi_host";
    public static final String SERVICE_NAME_DVMA_CONFIG_CGI_HOST = "dvma_config_cgi_host";
    public static final String SERVICE_NAME_LIVE_DUALSTACK_CGI_HOST = "live_dualstack_cgi_host";
    public static final String SERVICE_NAME_LIVE_IPV4_CGI_HOST = "live_ipv4_cgi_host";
    public static final String SERVICE_NAME_LIVE_IPV4_CGI_HOST_BK = "live_ipv4_cgi_host_bk";
    public static final String SERVICE_NAME_MONET_COMM_RESOURCE_INFO_HOST = "monet_comm_resource_info_host";
    public static final String SERVICE_NAME_OPEN_VINFO_CGI_HOST = "open_vinfo_cgi_host";
    public static final String SERVICE_NAME_PLAYER_CONFIG_CGI_HOST = "player_config_cgi_host";
    public static final String SERVICE_NAME_RICH_MEDIA_CGI_HOST = "rich_media_cgi_host";
    public static final String SERVICE_NAME_SIMULATED_LIVE_PREVIEW_COUNT_DEDUCTION = "simulated_live_preview_count_deduction";
    public static final String SERVICE_NAME_SUPER_RESOLUTION_LIBRARY_INFO_HOST = "super_resolution_library_info_host";
    public static final String SERVICE_NAME_SUPER_RESOLUTION_MODEL_INFO_HOST = "super_resolution_model_info_host";
    public static final String SERVICE_NAME_TAB_CONFIG_CGI_HOST = "tab_config_cgi_host";
    public static final String SERVICE_NAME_TIME_CGI_HIGH_RAIL_HOST = "time_cgi_high_rail_host";
    public static final String SERVICE_NAME_TIME_CGI_HIGH_RAIL_HOST_DEBUG = "time_cgi_high_rail_host_debug";
    public static final String SERVICE_NAME_TIME_CGI_HOST = "time_cgi_host";
    public static final String SERVICE_NAME_TIME_CGI_HOST_BK = "time_cgi_host_bk";
    public static final String SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST = "vinfo_cgi_dualstack_host";
    public static final String SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST_BK = "vinfo_cgi_dualstack_host_bk";
    public static final String SERVICE_NAME_VINFO_CGI_V4ONLY_HOST = "vinfo_cgi_v4only_host";
    public static final String SERVICE_NAME_VINFO_HIGH_RAIL_HOST = "vinfo_high_rail_host";
    public static final String SERVICE_NAME_VINFO_HIGH_RAIL_HOST_DEBUG = "vinfo_high_rail_host_debug";
    private static final String TAG = "TVKPlayer[TVKUrlConfig]";
    private static final HashMap<String, String> SERVICE_URL = new HashMap<>();
    private static final List<TVKServiceDefaultUrl> DEFAULT_URL = new ArrayList();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface ServiceName {
    }

    static {
        initDefaultUrl();
        setCurrentEnv(1);
    }

    public static void applyUrlConfig(@Nullable String str) {
        TVKLogUtil.i(TAG, "[applyUrlConfig].");
        HashMap<String, String> parseHostJsonData = parseHostJsonData(str);
        if (parseHostJsonData == null) {
            TVKLogUtil.w(TAG, "[applyUrlConfig], empty json string.");
        } else {
            setUrlConfig(parseHostJsonData);
        }
    }

    public static String getServiceUrl(String str) {
        String str2 = SERVICE_URL.get(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    private static void initDefaultUrl() {
        TVKServiceDefaultUrl.Builder builder = new TVKServiceDefaultUrl.Builder();
        List<TVKServiceDefaultUrl> list = DEFAULT_URL;
        list.add(builder.reset().setServiceName(SERVICE_NAME_OPEN_VINFO_CGI_HOST).setReleaseUrl("https://graph.qq.com/v3/video/get_v_info").setDeveloperUrl("https://graph.qq.com/v3/video/get_v_info").setPreReleaseUrl("https://graph.qq.com/v3/video/get_v_info").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_VINFO_CGI_V4ONLY_HOST).setReleaseUrl("https://vv.video.qq.com/getvinfo").setDeveloperUrl("https://testvv.video.qq.com/getvinfo").setPreReleaseUrl("https://prevv.video.qq.com/getvinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST_BK).setReleaseUrl("https://bkvv6.video.qq.com/getvinfo").setDeveloperUrl("https://testvv.video.qq.com/getvinfo").setPreReleaseUrl("https://bkvv6.video.qq.com/getvinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_VINFO_HIGH_RAIL_HOST).setReleaseUrl("https://vtrain.video.qq.com/tencent_video/videos").setDeveloperUrl("https://vtrain.video.qq.com/tencent_video/videos").setPreReleaseUrl("https://vtrain.video.qq.com/tencent_video/videos").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_VINFO_HIGH_RAIL_HOST_DEBUG).setReleaseUrl("https://183.3.225.11/tencent_video/videos").setDeveloperUrl("https://183.3.225.11/tencent_video/videos").setPreReleaseUrl("https://183.3.225.11/tencent_video/videos").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST).setReleaseUrl("https://vv6.video.qq.com/getvinfo").setDeveloperUrl("https://testvv.video.qq.com/getvinfo").setPreReleaseUrl("https://vv6.video.qq.com/getvinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_TIME_CGI_HOST).setReleaseUrl("https://vv.video.qq.com/checktime").setDeveloperUrl("https://testvv.video.qq.com/checktime").setPreReleaseUrl("https://prevv.video.qq.com/checktime").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_TIME_CGI_HOST_BK).setReleaseUrl("https://bkvv6.video.qq.com/checktime").setDeveloperUrl("https://testvv.video.qq.com/checktime").setPreReleaseUrl("https://bkvv6.video.qq.com/checktime").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_TIME_CGI_HIGH_RAIL_HOST).setReleaseUrl("https://vtrain.video.qq.com/tencent_video/checktime").setDeveloperUrl("https://vtrain.video.qq.com/tencent_video/checktime").setPreReleaseUrl("https://vtrain.video.qq.com/tencent_video/checktime").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_TIME_CGI_HIGH_RAIL_HOST_DEBUG).setReleaseUrl("https://183.3.225.11/tencent_video/checktime").setDeveloperUrl("https://183.3.225.11/tencent_video/checktime").setPreReleaseUrl("https://183.3.225.11/tencent_video/checktime").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_AD_CONFIG_CGI_HOST).setReleaseUrl("https://commdata.v.qq.com/commdatav2").setDeveloperUrl("https://commdata.v.qq.com/commdatav2").setPreReleaseUrl("https://commdata.v.qq.com/commdatav2").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_PLAYER_CONFIG_CGI_HOST).setReleaseUrl("https://appcfg.v.qq.com/getconf?cmd=tvk_sdk_config").setDeveloperUrl("https://appcfg.v.qq.com/getconf?cmd=tvk_sdk_config").setPreReleaseUrl("https://appcfg.v.qq.com/getconf?cmd=tvk_sdk_config").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_LIVE_DUALSTACK_CGI_HOST).setReleaseUrl("https://infozb6.video.qq.com/cgi-bin/getliveinfo").setDeveloperUrl("https://test.zb.video.qq.com/cgi-bin/getliveinfo").setPreReleaseUrl("https://infozb6.video.qq.com/cgi-bin/getliveinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_LIVE_IPV4_CGI_HOST).setReleaseUrl("https://info.zb.video.qq.com/cgi-bin/getliveinfo").setDeveloperUrl("https://test.zb.video.qq.com/cgi-bin/getliveinfo").setPreReleaseUrl("https://info.zb.video.qq.com/cgi-bin/getliveinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_LIVE_IPV4_CGI_HOST_BK).setReleaseUrl("https://bkinfozb6.video.qq.com/cgi-bin/getliveinfo").setDeveloperUrl("https://test.zb.video.qq.com/cgi-bin/getliveinfo").setPreReleaseUrl("https://bkinfozb6.video.qq.com/cgi-bin/getliveinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_RICH_MEDIA_CGI_HOST).setReleaseUrl("https://access.video.qq.com/fcgi/video-frame-analysis?raw=1&vappid=13626845&vsecret=e410cb8e28b9c30a6fc1267583807640d7b97c15d92ec3c0").setDeveloperUrl("https://debugaccess.video.qq.com/test/get-video-frame-star?raw=1&vappid=13626845&vsecret=e410cb8e28b9c30a6fc1267583807640d7b97c15d92ec3c0").setPreReleaseUrl("https://debugaccess.video.qq.com/test/get-video-frame-star?raw=1&vappid=13626845&vsecret=e410cb8e28b9c30a6fc1267583807640d7b97c15d92ec3c0").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_DVMA_CONFIG_CGI_HOST).setReleaseUrl("https://appcfg.v.qq.com/getconf?cmd=tvk_sdk_config_dolby_vision").setDeveloperUrl("https://appcfg.v.qq.com/getconf?cmd=tvk_sdk_config_dolby_vision").setPreReleaseUrl("https://appcfg.v.qq.com/getconf?cmd=tvk_sdk_config_dolby_vision").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_TAB_CONFIG_CGI_HOST).setReleaseUrl("https://tab.video.qq.com/tab/GetTabRemoteConfig").setDeveloperUrl("https://tab.video.qq.com/tab/GetTabRemoteConfig").setPreReleaseUrl("https://tab.video.qq.com/tab/GetTabRemoteConfig").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_SUPER_RESOLUTION_LIBRARY_INFO_HOST).setReleaseUrl("https://playproxy.video.qq.com/monet/ai_lib/get").setDeveloperUrl("https://testvv.video.qq.com/monet/ai_lib/get").setPreReleaseUrl("https://playproxy.video.qq.com/monet/ai_lib/get").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_SUPER_RESOLUTION_MODEL_INFO_HOST).setReleaseUrl("https://playproxy.video.qq.com/monet/tvm_sr_model/get").setDeveloperUrl("https://testvv.video.qq.com/monet/tvm_sr_model/get").setPreReleaseUrl("https://playproxy.video.qq.com/monet/tvm_sr_model/get").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_MONET_COMM_RESOURCE_INFO_HOST).setReleaseUrl("https://playproxy.video.qq.com/monet/comm_resource/get").setDeveloperUrl("https://testvv.video.qq.com/monet/comm_resource/get").setPreReleaseUrl("https://playproxy.video.qq.com/monet/comm_resource/get").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_BATCH_VINFO_CGI_HOST).setReleaseUrl("https://vv.video.qq.com/batchvinfo").setDeveloperUrl("https://testvv.video.qq.com/batchvinfo").setPreReleaseUrl("https://vv.video.qq.com/batchvinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_BATCH_VINFO_CGI_HOST_BK).setReleaseUrl("https://bkvv6.video.qq.com/batchvinfo").setDeveloperUrl("https://testvv.video.qq.com/batchvinfo").setPreReleaseUrl("https://bkvv6.video.qq.com/batchvinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_BATCH_VINFO_DUALSTACK_CGI_HOST).setReleaseUrl("https://vv6.video.qq.com/batchvinfo").setDeveloperUrl("https://testvv.video.qq.com/batchvinfo").setPreReleaseUrl("https://vv6.video.qq.com/batchvinfo").build());
        list.add(builder.reset().setServiceName(SERVICE_NAME_SIMULATED_LIVE_PREVIEW_COUNT_DEDUCTION).setReleaseUrl("https://api.ilive.qq.com/tvk_rotation").setDeveloperUrl("https://testtxycdnauth.ilive.qq.com/tvk_rotation").setPreReleaseUrl("https://api.ilive.qq.com/tvk_rotation").build());
    }

    @Nullable
    private static HashMap<String, String> parseHostJsonData(String str) {
        TVKLogUtil.i(TAG, "[parseJsonData] Parsing JSON data:" + str);
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.e(TAG, "[parseJsonData] Parses JSON data failed: empty or null JSON string.");
            return null;
        }
        try {
            return TVKJsonUtils.convertJsonObjectToHashMap(new JSONObject(str).getJSONObject(HOST_CONFIG_JSON_KEY_PLAYER_HOST_CONFIG));
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, "[extractConfig] Extracts config failed: illegal config JSON object. " + e16);
            return null;
        }
    }

    public static void setCurrentEnv(int i3) {
        TVKLogUtil.i(TAG, "[setCurrentEnv] Setting current environment: " + i3);
        for (TVKServiceDefaultUrl tVKServiceDefaultUrl : DEFAULT_URL) {
            SERVICE_URL.put(tVKServiceDefaultUrl.getServiceName(), tVKServiceDefaultUrl.getUrl(i3));
        }
    }

    private static void setUrlConfig(@NonNull HashMap<String, String> hashMap) {
        TVKLogUtil.i(TAG, "[setUrlConfig] Applying URL config: " + hashMap);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            HashMap<String, String> hashMap2 = SERVICE_URL;
            if (hashMap2.containsKey(key)) {
                hashMap2.put(key, value);
            }
        }
    }
}
