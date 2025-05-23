package com.tencent.ad.tangram.statistics.xijing;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class AdDMPReporterHelper {
    public static final String DEST_URL = "https://fv.gdt.qq.com";
    private static final String DMP_REQUEST_CGI = "https://h5.gdt.qq.com/player/actionset/report?type=XJ_CANVAS";
    public static final int RETRY_TIMES_MAX = 3;
    private static final String TAG = "AdDMPReporterHelper";

    @Nullable
    public static byte[] getRequestData(@NonNull JSONObject jSONObject) {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            return null;
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            AdLog.e(TAG, "getRequestData", e16);
            return null;
        }
    }

    @Nullable
    public static JSONObject getRequestJson(@Nullable Ad ad5, JSONObject jSONObject, String str, String str2, String str3) {
        if (ad5 != null && ad5.isValid() && !TextUtils.isEmpty(ad5.getTraceId())) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_id", ad5.getTraceId());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("action_time", currentTimeMillis / 1000);
                jSONObject3.put("action_type", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject3.put("custom_action", str2);
                }
                if (!AdJSONUtil.isJSONObjectNull(jSONObject)) {
                    jSONObject3.put("action_param", jSONObject);
                }
                jSONObject3.put("url", str3);
                jSONObject3.put("trace", jSONObject2);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(0, jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("actions", jSONArray);
                jSONObject4.put("signature", ad5.getTraceId() + currentTimeMillis);
                return jSONObject4;
            } catch (JSONException e16) {
                AdLog.e(TAG, "getRequestData", e16);
                return null;
            }
        }
        AdLog.e(TAG, "getRequestData error");
        return null;
    }

    @NonNull
    public static AdHttp.Params getRequestParams(byte[] bArr) {
        AdHttp.Params params = new AdHttp.Params();
        params.setUrl(DMP_REQUEST_CGI);
        params.method = "POST";
        params.contentType = "application/json";
        params.referer = DEST_URL;
        params.connectTimeoutMillis = 5000;
        params.readTimeoutMillis = 5000;
        params.requestData = bArr;
        return params;
    }
}
