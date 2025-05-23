package com.tencent.qqlive.tvkplayer.tools.config;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKTabConfigRequester implements ITVKConfigRequester {
    private static final String HTTP_REQUEST_TAG = "TVKTabConfigRequester";
    private static final String LOG_TAG = "TVKPlayer[TVKTabConfigRequester]";
    private static final int OK = 100;
    private static final String TAB_CONFIG_CONFIG_TABLE_NAME = "tvk_config";
    private static final String TAB_CONFIG_JSON_KEY_APP_ID = "app_id";
    private static final String TAB_CONFIG_JSON_KEY_APP_KEY = "app_key";
    private static final String TAB_CONFIG_JSON_KEY_CONFIGS_KEYS = "config_keys";
    private static final String TAB_CONFIG_JSON_KEY_GUID = "guid";
    private static final String TAB_CONFIG_JSON_KEY_PROFILES = "profiles";
    private static final String TAB_CONFIG_PROFILE_KEY_MODEL = "tvk_sdk_model";
    private static final String TAB_CONFIG_PROFILE_KEY_PLATFORM = "tvk_sdk_platform";
    private static final String TAB_CONFIG_PROFILE_KEY_SDK_VERSION = "tvk_sdk_version";
    private static final String TAB_CONFIG_PROFILE_KEY_SYS_API_VER = "tvk_sdk_sys_api_level";
    private static final String TAB_CONFIG_REQUEST_KEY_APP_ID = "tabRequestAppId";
    private static final String TAB_CONFIG_REQUEST_KEY_APP_KEY = "tabRequestAppKey";
    private static final String TAB_RESPONSE_JSON_KEY_DATA = "data";
    private static final String TAB_RESPONSE_JSON_KEY_EXP_DATA = "exp_data";
    private static final String TAB_RESPONSE_JSON_KEY_EXP_DATA_PARAMS = "params";
    private static final String TAB_RESPONSE_JSON_KEY_EXP_NAME = "expName";
    private static final String TAB_RESPONSE_JSON_KEY_POLICY_ID = "sGrayPolicyId";
    private static final String TAB_RESPONSE_JSON_KEY_STATUS = "status";
    private static final int UNKNOWN_FAILURE = -1;
    private ITVKConfigRequester.ConfigRequestListener mConfRequestListener;

    @NonNull
    private RequesterState mState = RequesterState.REQUESTER_STATE_IDLE;

    @NonNull
    private Map<String, String> mRequestHttpHeaders = Collections.emptyMap();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    enum RequesterState {
        REQUESTER_STATE_IDLE,
        REQUESTER_STATE_REQUESTED,
        REQUESTER_STATE_CANCELED
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private final class TabHttpCallback implements ITVKHttpProcessor.ITVKHttpCallback {
        private final ITVKConfigRequester.ConfigRequestListener mConfRequestListener;

        public TabHttpCallback(ITVKConfigRequester.ConfigRequestListener configRequestListener) {
            this.mConfRequestListener = configRequestListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(IOException iOException) {
            String str;
            ITVKConfigRequester.ConfigRequestListener configRequestListener = this.mConfRequestListener;
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
            TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKTabConfigRequester.TabHttpCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    ITVKConfigRequester.ConfigRequestListener configRequestListener = TabHttpCallback.this.mConfRequestListener;
                    if (configRequestListener == null) {
                        return;
                    }
                    ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse2 = tVKHttpResponse;
                    if (tVKHttpResponse2 != null && tVKHttpResponse2.getData() != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(tVKHttpResponse.getData(), StandardCharsets.UTF_8));
                            TVKLogUtil.i(TVKTabConfigRequester.LOG_TAG, "tab response original content:" + jSONObject);
                            if (!TVKTabConfigRequester.isValidConfig(jSONObject)) {
                                configRequestListener.onError(new TVKConfigRequestException("config content error"));
                                return;
                            }
                            HashMap<String, String> hashMap = new HashMap<>();
                            HashMap<String, String> hashMap2 = new HashMap<>();
                            JSONObject extractExpDataJsonObj = TVKTabConfigRequester.this.extractExpDataJsonObj(jSONObject);
                            if (extractExpDataJsonObj != null) {
                                String extractPolicyId = TVKTabConfigRequester.this.extractPolicyId(extractExpDataJsonObj);
                                if (!TextUtils.isEmpty(extractPolicyId)) {
                                    hashMap.put("sGrayPolicyId", extractPolicyId);
                                }
                                String extractExpName = TVKTabConfigRequester.this.extractExpName(extractExpDataJsonObj);
                                if (!TextUtils.isEmpty(extractExpName)) {
                                    hashMap.put("expName", extractExpName);
                                }
                                HashMap<String, String> extractPlayerConfigToMap = TVKTabConfigRequester.this.extractPlayerConfigToMap(extractExpDataJsonObj);
                                if (extractPlayerConfigToMap != null) {
                                    hashMap2 = extractPlayerConfigToMap;
                                }
                                configRequestListener.onFetched(hashMap2, hashMap);
                                return;
                            }
                            configRequestListener.onFetched(hashMap2, hashMap);
                            return;
                        } catch (JSONException e16) {
                            configRequestListener.onError(new TVKConfigRequestException(e16.getMessage()));
                            return;
                        }
                    }
                    configRequestListener.onError(new TVKConfigRequestException("http unknown error"));
                }
            });
        }
    }

    @Nullable
    private String buildTabConfigHttpRequestPostBody() {
        HashMap hashMap = new HashMap();
        hashMap.put(TAB_CONFIG_PROFILE_KEY_SDK_VERSION, TVKVersion.getPlayerVersion());
        hashMap.put(TAB_CONFIG_PROFILE_KEY_PLATFORM, TVKVersion.getPlatform());
        hashMap.put(TAB_CONFIG_PROFILE_KEY_SYS_API_VER, String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put(TAB_CONFIG_PROFILE_KEY_MODEL, TVKVcSystemInfo.getDeviceModel());
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(TAB_CONFIG_CONFIG_TABLE_NAME);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", TAB_CONFIG_REQUEST_KEY_APP_ID).put("app_key", TAB_CONFIG_REQUEST_KEY_APP_KEY).put("guid", TVKCommParams.getAbUserId()).put(TAB_CONFIG_JSON_KEY_PROFILES, new JSONObject(hashMap)).put(TAB_CONFIG_JSON_KEY_CONFIGS_KEYS, jSONArray);
            return jSONObject.toString();
        } catch (JSONException e16) {
            TVKLogUtil.e(LOG_TAG, e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public JSONObject extractExpDataJsonObj(@NonNull JSONObject jSONObject) {
        try {
            return new JSONObject(new JSONObject(new JSONObject(jSONObject.getString("data")).getString(TAB_CONFIG_CONFIG_TABLE_NAME)).getString(TAB_RESPONSE_JSON_KEY_EXP_DATA));
        } catch (JSONException e16) {
            TVKLogUtil.w(LOG_TAG, e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String extractExpName(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("expName");
        } catch (JSONException e16) {
            TVKLogUtil.w(LOG_TAG, e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public HashMap<String, String> extractPlayerConfigToMap(@NonNull JSONObject jSONObject) {
        try {
            return TVKJsonUtils.convertJsonObjectToHashMap(new JSONObject(new JSONObject(jSONObject.getString("params")).getString(TAB_CONFIG_CONFIG_TABLE_NAME)));
        } catch (JSONException e16) {
            TVKLogUtil.e(LOG_TAG, e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String extractPolicyId(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("sGrayPolicyId");
        } catch (JSONException e16) {
            TVKLogUtil.w(LOG_TAG, e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidConfig(@NonNull JSONObject jSONObject) {
        if (jSONObject.has("status") && jSONObject.has("data")) {
            int optInt = jSONObject.optInt("status", -1);
            if (optInt != 100) {
                TVKLogUtil.e(LOG_TAG, "[isValidConfig] Invalid config: abnormal code: " + optInt);
                return false;
            }
            return true;
        }
        TVKLogUtil.e(LOG_TAG, "[isValidConfig] Invalid config: missing compulsory key(s).");
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester
    public synchronized void cancel() {
        this.mConfRequestListener = null;
        this.mState = RequesterState.REQUESTER_STATE_CANCELED;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester
    public synchronized void executeRequest() throws TVKConfigRequestException {
        if (this.mState == RequesterState.REQUESTER_STATE_IDLE) {
            String buildTabConfigHttpRequestPostBody = buildTabConfigHttpRequestPostBody();
            if (!TextUtils.isEmpty(buildTabConfigHttpRequestPostBody)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.putAll(this.mRequestHttpHeaders);
                TVKLogUtil.i(LOG_TAG, "tab request, http post body:" + buildTabConfigHttpRequestPostBody);
                TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.POST, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_TAB_CONFIG_CGI_HOST)).reqTag(HTTP_REQUEST_TAG).headers(hashMap).body(buildTabConfigHttpRequestPostBody.getBytes(StandardCharsets.UTF_8)).callTimeoutMs((long) TVKMediaPlayerConfig.PlayerConfig.fetch_remote_config_timeout_ms).build(), new TabHttpCallback(this.mConfRequestListener));
                this.mState = RequesterState.REQUESTER_STATE_REQUESTED;
            } else {
                throw new TVKConfigRequestException("buildTabConfigHttpRequestPostBody error");
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
