package com.tencent.qqlive.tvkplayer.tools.config;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKJsonUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDVMARequester {
    private static final String CHARSET_UTF8 = "UTF-8";
    private static final int CONNECTION_TIME_OUT_MS = 10000;
    private static final String HTTP_REQUEST_TAG = "TVKDVMARequester";
    private static final TVKDVMARequester INSTANCE = new TVKDVMARequester();
    private static final int OK = 0;
    private static final String TAG = "TVKPlayer[TVKDVMARequester]";
    private static final int UNKNOWN_FAILURE = -1;
    private static final char URL_KEY_VALUE_PAIR_JOINT_CHAR = '&';
    private static final char URL_KEY_WITH_VALUE_JOINT_CHAR = '=';
    private static final int VERSION_STRING_OFFSET = 1;
    private static final String WUJI_JSON_CONFIG_KEY_DATA = "data";
    private static final String WUJI_JSON_CONFIG_KEY_ERROR_CODE = "code";
    private static final String WUJI_JSON_CONFIG_KEY_ID = "id";
    private static final String WUJI_REQUEST_PLATFORM = "aphone";
    private static final String WUJI_REQUEST_URL_KEY_DEV = "dev";
    private static final String WUJI_REQUEST_URL_KEY_GUID = "guid";
    private static final String WUJI_REQUEST_URL_KEY_NAME = "name";
    private static final String WUJI_REQUEST_URL_KEY_PLATFORM = "platform";
    private static final String WUJI_REQUEST_URL_KEY_QQ = "qq";
    private static final String WUJI_REQUEST_URL_KEY_RANDOM = "random";
    private static final String WUJI_REQUEST_URL_KEY_SUB_VER = "subver";
    private static final String WUJI_REQUEST_URL_KEY_SUB_VER_TWO = "subver_two";
    private static final String WUJI_REQUEST_VERSION_PREFIX = "V_";
    private volatile boolean mIsDvmaConfigFetching = false;
    private final ITVKHttpProcessor.ITVKHttpCallback mHttpCallback = new ITVKHttpProcessor.ITVKHttpCallback() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKDVMARequester.1
        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(IOException iOException) {
            TVKDVMARequester.this.mIsDvmaConfigFetching = false;
            TVKLogUtil.e(TVKDVMARequester.TAG, "(dvma) Fails to fetch online config: " + iOException);
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(final ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKDVMARequester.1.1
                @Override // java.lang.Runnable
                public void run() {
                    TVKDVMARequester.this.saveConfig(TVKDVMARequester.parseWujiResponseToMap(new String(tVKHttpResponse.getData())));
                    TVKDVMARequester.this.mOnlineConfigChangedListener.onConfigChanged();
                    TVKDVMARequester.this.mIsDvmaConfigFetching = false;
                }
            });
        }
    };
    private ITVKConfigChangedListener mOnlineConfigChangedListener = new ITVKConfigChangedListener() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKDVMARequester.2
        @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigChangedListener
        public void onConfigChanged() {
        }
    };

    TVKDVMARequester() {
    }

    @NonNull
    private static String buildRequestUrlWithServiceName(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(WUJI_REQUEST_URL_KEY_SUB_VER, WUJI_REQUEST_VERSION_PREFIX + TVKVersion.getPlayerVersion().substring(1));
        hashMap.put(WUJI_REQUEST_URL_KEY_SUB_VER_TWO, WUJI_REQUEST_VERSION_PREFIX + Build.VERSION.SDK_INT);
        hashMap.put("platform", "aphone");
        hashMap.put("qq", TVKCommParams.getQQ());
        hashMap.put("dev", TVKVcSystemInfo.getDeviceModel());
        hashMap.put("guid", TVKCommParams.getStaGuid());
        hashMap.put("name", TVKVersion.getChannelId());
        hashMap.put("random", String.valueOf(Math.random()));
        try {
            return TVKUrlConfig.getServiceUrl(str) + jointParams(hashMap);
        } catch (UnsupportedEncodingException e16) {
            TVKLogUtil.e(TAG, "buildRequestUrlWithServiceName failed. Encoding scheme UTF-8 not supported. " + e16);
            return "";
        }
    }

    public static TVKDVMARequester getInstance() {
        return INSTANCE;
    }

    private static boolean isValidConfig(@NonNull JSONObject jSONObject) {
        if (jSONObject.has("id") && jSONObject.has("code") && jSONObject.has("data")) {
            int optInt = jSONObject.optInt("code", -1);
            if (optInt != 0) {
                TVKLogUtil.e(TAG, "[isValidConfig] Invalid config: abnormal code: " + optInt);
                return false;
            }
            return true;
        }
        TVKLogUtil.e(TAG, "[isValidConfig] Invalid config: missing compulsory key(s).");
        return false;
    }

    @NonNull
    private static String jointParams(@NonNull HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb5.append('&');
            sb5.append(URLEncoder.encode(key, "UTF-8"));
            sb5.append(URL_KEY_WITH_VALUE_JOINT_CHAR);
            if (value == null) {
                value = "";
            }
            sb5.append(URLEncoder.encode(value, "UTF-8"));
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static HashMap<String, String> parseWujiResponseToMap(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!isValidConfig(jSONObject)) {
                TVKLogUtil.e(TAG, "parseWujiResponseToMap, invalid config");
                return new HashMap<>();
            }
            try {
                return TVKJsonUtils.convertJsonObjectToHashMap(new JSONObject(jSONObject.getString("data")));
            } catch (JSONException e16) {
                TVKLogUtil.e(TAG, "[extractConfig] Extracts data failed: illegal config JSON object. " + e16);
                return new HashMap<>();
            }
        } catch (JSONException e17) {
            TVKLogUtil.e(TAG, "parseWujiResponseToMap, illegal config JSON object, json exception:" + e17);
            return new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestOnlineConfig(@NonNull ITVKConfigChangedListener iTVKConfigChangedListener) {
        String buildRequestUrlWithServiceName = buildRequestUrlWithServiceName(TVKUrlConfig.SERVICE_NAME_DVMA_CONFIG_CGI_HOST);
        TVKLogUtil.i(TAG, "(dvma) Fetching config from [" + buildRequestUrlWithServiceName + "]");
        if (TextUtils.isEmpty(buildRequestUrlWithServiceName)) {
            return;
        }
        this.mOnlineConfigChangedListener = iTVKConfigChangedListener;
        TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET, buildRequestUrlWithServiceName).reqTag(HTTP_REQUEST_TAG).callTimeoutMs(TVKMediaPlayerConfig.PlayerConfig.fetch_remote_config_timeout_ms).build(), this.mHttpCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveConfig(@NonNull HashMap<String, String> hashMap) {
        TVKDVMAConfig.saveAndApplyConfig(hashMap);
    }

    public void requestOnlineConfigAsync(@NonNull final ITVKConfigChangedListener iTVKConfigChangedListener) {
        boolean isConfigFetched = TVKDVMAConfig.isConfigFetched();
        long elapsedRealtime = SystemClock.elapsedRealtime() - TVKDVMAConfig.getPreRequestTimeMs();
        long j3 = TVKMediaPlayerConfig.PlayerConfig.request_dvma_config_interval_sec * 1000;
        if (!this.mIsDvmaConfigFetching && (!isConfigFetched || elapsedRealtime >= j3 || elapsedRealtime <= 0)) {
            this.mIsDvmaConfigFetching = true;
            TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKDVMARequester.3
                @Override // java.lang.Runnable
                public void run() {
                    TVKDVMARequester.this.requestOnlineConfig(iTVKConfigChangedListener);
                }
            });
            return;
        }
        TVKLogUtil.i(TAG, "(dvma) no fetch. diff:" + elapsedRealtime + ",interval:" + j3 + ",isFetched:" + isConfigFetched + ",isFetching:" + this.mIsDvmaConfigFetching);
    }
}
