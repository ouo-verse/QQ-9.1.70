package com.tencent.qqlive.tvkplayer.vinfo.vod;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodBatchVinfoRequestBuilder {
    private static final String REQUEST_PARAM_ERROR_RESPONSE_INCLUDED = "no_filter_err";
    private static final String REQUEST_PARAM_REQUESTS = "requests";
    private static final String TAG = "TVKVodBatchVinfoRequestBuilder";
    private final JSONObject mBatchVinfoRequestsJson = new JSONObject();
    private boolean mIsErrorResponseIncluded = false;

    public void addRequest(@NonNull String str, Map<String, String> map) {
        try {
            this.mBatchVinfoRequestsJson.put(str, TVKHttpUtils.encodeParamsToStringForUrlEncoding(map, "UTF-8"));
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, "[addRequest] honestly make no sense: " + e16);
        }
    }

    public String build() {
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mIsErrorResponseIncluded) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put(REQUEST_PARAM_ERROR_RESPONSE_INCLUDED, i3);
            jSONObject.put(REQUEST_PARAM_REQUESTS, this.mBatchVinfoRequestsJson);
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, "[build] honestly make no sense: " + e16);
        }
        return jSONObject.toString();
    }

    public void includeErrorResponse(boolean z16) {
        this.mIsErrorResponseIncluded = z16;
    }
}
