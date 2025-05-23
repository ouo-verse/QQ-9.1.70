package com.tencent.qqlive.tvkplayer.tools.config;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
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
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKWujiConfigRequester implements ITVKConfigRequester {
    private static final String CHARSET_UTF8 = "UTF-8";
    private static final String HTTP_REQUEST_TAG = "TVKWujiConfigRequester";
    private static final int OK = 0;
    private static final String TAG = "[TVKPlayer]TVKWujiConfigRequester";
    private static final int UNKNOWN_FAILURE = -1;
    private static final char URL_KEY_VALUE_PAIR_JOINT_CHAR = '&';
    private static final char URL_KEY_WITH_VALUE_JOINT_CHAR = '=';
    private static final int VERSION_STRING_OFFSET = 1;
    private static final String WUJI_JSON_CONFIG_KEY_DATA = "data";
    private static final String WUJI_JSON_CONFIG_KEY_ERROR_CODE = "code";
    private static final String WUJI_JSON_CONFIG_KEY_ID = "id";
    private static final String WUJI_JSON_CONFIG_KEY_PLAYER_CONFIG = "player_config";
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
    private ITVKConfigRequester.ConfigRequestListener mConfRequestListener;

    @NonNull
    private RequesterState mState = RequesterState.REQUESTER_STATE_IDLE;

    @NonNull
    private Map<String, String> mRequestHttpHeaders = Collections.emptyMap();
    private final ITVKHttpProcessor.ITVKHttpCallback mHttpCallback = new ITVKHttpProcessor.ITVKHttpCallback() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKWujiConfigRequester.1
        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(IOException iOException) {
            String str;
            ITVKConfigRequester.ConfigRequestListener configRequestListener = TVKWujiConfigRequester.this.mConfRequestListener;
            if (configRequestListener != null) {
                if (iOException != null) {
                    str = iOException.getMessage();
                } else {
                    str = "onFailure";
                }
                configRequestListener.onError(new TVKConfigRequestException(str));
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(final ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKWujiConfigRequester.1.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    ITVKConfigRequester.ConfigRequestListener configRequestListener = TVKWujiConfigRequester.this.mConfRequestListener;
                    if (configRequestListener == null) {
                        return;
                    }
                    ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse2 = tVKHttpResponse;
                    if (tVKHttpResponse2 == null) {
                        TVKLogUtil.e(TVKWujiConfigRequester.TAG, "http response is null");
                        configRequestListener.onFetched(new HashMap<>(), null);
                    } else {
                        if (tVKHttpResponse2.getData() != null) {
                            str = new String(tVKHttpResponse.getData(), StandardCharsets.UTF_8);
                        } else {
                            str = "";
                        }
                        configRequestListener.onFetched(TVKWujiConfigRequester.parseWujiResponseToMap(str), null);
                    }
                }
            });
        }
    };

    /* compiled from: P */
    /* loaded from: classes23.dex */
    enum RequesterState {
        REQUESTER_STATE_IDLE,
        REQUESTER_STATE_REQUESTED,
        REQUESTER_STATE_CANCELED
    }

    @NonNull
    private static String buildRequestUrl() {
        TVKLogUtil.i(TAG, "[buildRequestUrl] Building request URL.");
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
            return TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_PLAYER_CONFIG_CGI_HOST) + jointParams(hashMap);
        } catch (UnsupportedEncodingException e16) {
            TVKLogUtil.e(TAG, "[buildRequestUrl] Build URL failed. Encoding scheme UTF-8 not supported. " + e16);
            return "";
        }
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
                return TVKJsonUtils.convertJsonObjectToHashMap(new JSONObject(new JSONObject(jSONObject.getString("data")).getString(WUJI_JSON_CONFIG_KEY_PLAYER_CONFIG)));
            } catch (JSONException e16) {
                TVKLogUtil.e(TAG, "[extractConfig] Extracts data failed: illegal config JSON object. " + e16);
                return new HashMap<>();
            }
        } catch (JSONException e17) {
            TVKLogUtil.e(TAG, "parseWujiResponseToMap, illegal config JSON object, json exception:" + e17);
            return new HashMap<>();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester
    public synchronized void cancel() {
        this.mConfRequestListener = null;
        this.mState = RequesterState.REQUESTER_STATE_CANCELED;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester
    public synchronized void executeRequest() throws TVKConfigRequestException {
        if (this.mState == RequesterState.REQUESTER_STATE_IDLE) {
            String buildRequestUrl = buildRequestUrl();
            if (!TextUtils.isEmpty(buildRequestUrl)) {
                TVKLogUtil.i(TAG, "Fetching online config from:" + buildRequestUrl);
                TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET, buildRequestUrl).reqTag(HTTP_REQUEST_TAG).headers(this.mRequestHttpHeaders).callTimeoutMs((long) TVKMediaPlayerConfig.PlayerConfig.fetch_remote_config_timeout_ms).build(), this.mHttpCallback);
                this.mState = RequesterState.REQUESTER_STATE_REQUESTED;
            } else {
                throw new TVKConfigRequestException("buildRequestUrl error");
            }
        } else {
            throw new TVKConfigRequestException("unmatched state:" + this.mState.name());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester
    public void setRequestHttpHeaders(@NonNull Map<String, String> map) {
        this.mRequestHttpHeaders = map;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester
    public void setRequestListener(ITVKConfigRequester.ConfigRequestListener configRequestListener) {
        this.mConfRequestListener = configRequestListener;
    }
}
