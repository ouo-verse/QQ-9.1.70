package com.tencent.ad.tangram.views.form.framework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.json.AdJSONArrayUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.views.form.AdFormData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class AdFormPrefetchTokenUtil {
    private static final String TAG = "AdFormPrefetchTokenUtil";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Params extends AdHttp.Params {
        public int returnCode;

        Params() {
            this.returnCode = Integer.MIN_VALUE;
        }

        @Override // com.tencent.ad.tangram.net.AdHttp.Params
        public boolean isSuccess() {
            if (super.isSuccess() && this.responseData != null) {
                return true;
            }
            return false;
        }
    }

    AdFormPrefetchTokenUtil() {
    }

    @Nullable
    private static byte[] getRequestData(Context context, @NonNull Ad ad5, @NonNull AdFormData adFormData) {
        JSONArray json = AdFormUploadUtil.toJson(adFormData);
        if (isValid(ad5, adFormData) && !AdJSONArrayUtil.isEmpty(json)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("traceId", ad5.getTraceId());
                jSONObject.put("formId", adFormData.formId);
                jSONObject.put("formValue", json.toString());
                return jSONObject.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                AdLog.e(TAG, "getRequestData", e16);
                return null;
            } catch (JSONException e17) {
                AdLog.e(TAG, "getRequestData", e17);
                return null;
            }
        }
        AdLog.e(TAG, "getRequestData error");
        return null;
    }

    @NonNull
    private static Params getRequestParams(Context context, @NonNull Ad ad5, @NonNull AdFormData adFormData) {
        Params params = new Params();
        params.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
        params.method = "POST";
        params.contentType = "application/json";
        params.connectTimeoutMillis = 5000;
        params.readTimeoutMillis = 5000;
        params.requestData = getRequestData(context, ad5, adFormData);
        return params;
    }

    private static boolean isValid(@Nullable Ad ad5, @Nullable AdFormData adFormData) {
        if (ad5 != null && ad5.isValid() && !TextUtils.isEmpty(ad5.getTraceId()) && adFormData != null && adFormData.isValid() && !TextUtils.isEmpty(ad5.getTraceId())) {
            return true;
        }
        return false;
    }

    private static void parseResponse(Ad ad5, @NonNull AdFormData adFormData, @Nullable Params params) {
        if (params != null && params.isSuccess() && isValid(ad5, adFormData)) {
            try {
                JSONObject jSONObject = new JSONObject(new String(params.responseData, "UTF-8"));
                params.returnCode = jSONObject.getInt("code");
                AdLog.i(TAG, "onResponse code:" + params.returnCode + " message:" + jSONObject.optString("message"));
                if (params.returnCode == 0) {
                    adFormData.tokenForUpload = jSONObject.getJSONObject("data").getString("token");
                } else {
                    AdLog.e(TAG, "onResponse error");
                }
                return;
            } catch (UnsupportedEncodingException e16) {
                AdLog.e(TAG, "onResponse", e16);
                return;
            } catch (JSONException e17) {
                AdLog.e(TAG, "onResponse", e17);
                return;
            }
        }
        AdLog.e(TAG, "onResponse error");
    }

    public static void prefetch(Context context, @NonNull Ad ad5, @NonNull AdFormData adFormData) {
        if (!isValid(ad5, adFormData)) {
            AdLog.e(TAG, "prefetch error");
            return;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            if (!isValid(ad5, adFormData)) {
                AdLog.e(TAG, "prefetch error");
                return;
            }
            Params requestParams = getRequestParams(context, ad5, adFormData);
            if (requestParams == null) {
                break;
            }
            AdHttp.send(requestParams);
            parseResponse(ad5, adFormData, requestParams);
            if (requestParams.isSuccess() && requestParams.returnCode == 0) {
                return;
            }
        }
        AdLog.e(TAG, "prefetch error");
    }
}
