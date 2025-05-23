package com.tencent.thumbplayer.common;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.common.config.TPConfig;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPHost {
    private static final String KEY_BEACON_LOG_HOST = "beacon_log_host";
    private static final String KEY_BEACON_POLICY_HOST = "beacon_policy_host";
    private static final String KEY_PLAYER_HOST = "player_host_config";
    private static final String KEY_PROXY_HOST = "httpproxy_config";
    private static final String TAG = "TPHost";
    private static String sBeaconLogHost = "";
    private static String sBeaconPolicyHost = "";
    private static String sDownloadProxyHost = "";
    private static String sHost = "";

    @NonNull
    public static synchronized String getBeaconLogHost() {
        String str;
        synchronized (TPHost.class) {
            parseHostConfig();
            str = sBeaconLogHost;
        }
        return str;
    }

    @NonNull
    public static synchronized String getBeaconPolicyHost() {
        String str;
        synchronized (TPHost.class) {
            parseHostConfig();
            str = sBeaconPolicyHost;
        }
        return str;
    }

    @NonNull
    public static synchronized String getDownloadProxyHost() {
        String str;
        synchronized (TPHost.class) {
            parseHostConfig();
            str = sDownloadProxyHost;
        }
        return str;
    }

    private static void parseBeaconHost(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.has(KEY_PLAYER_HOST)) {
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(KEY_PLAYER_HOST);
        if (jSONObject2.has(KEY_BEACON_POLICY_HOST)) {
            sBeaconPolicyHost = jSONObject2.getString(KEY_BEACON_POLICY_HOST);
        }
        if (jSONObject2.has(KEY_BEACON_LOG_HOST)) {
            sBeaconLogHost = jSONObject2.getString(KEY_BEACON_LOG_HOST);
        }
    }

    private static void parseHostConfig() {
        String str = (String) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_STRING_HOSTS, "");
        if (sHost.equals(str)) {
            return;
        }
        try {
            sHost = str;
            parseBeaconHost(str);
            parseProxyHost(sHost);
        } catch (JSONException e16) {
            TPLogUtil.e(TAG, "host parse failed, exception: " + e16);
        }
    }

    private static void parseProxyHost(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.has(KEY_PROXY_HOST)) {
            return;
        }
        sDownloadProxyHost = jSONObject.getString(KEY_PROXY_HOST);
    }
}
