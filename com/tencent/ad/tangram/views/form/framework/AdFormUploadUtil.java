package com.tencent.ad.tangram.views.form.framework;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSONArrayUtil;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdFormUploadUtil {
    private static final String TAG = "GdtFormUploadUtil";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Params extends AdHttp.Params {
        public static final int RETURN_CODE_ERROR_DUPLICATE = 4;
        public static final int RETURN_CODE_ERROR_INVALID_FORM = 1;
        public static final int RETURN_CODE_ERROR_INVALID_PARAM = 3;
        public static final int RETURN_CODE_ERROR_TOKEN = 2;
        public static final int RETURN_CODE_SUCCESS = 0;
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

    AdFormUploadUtil() {
    }

    @Nullable
    private static byte[] getRequestData(@Nullable AdFormData adFormData) {
        String str;
        JSONArray json = toJson(adFormData);
        if (adFormData != null && adFormData.isValid() && !AdJSONArrayUtil.isEmpty(json)) {
            if (TextUtils.isEmpty(adFormData.tokenForUpload)) {
                str = "";
            } else {
                str = adFormData.tokenForUpload;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
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
    private static Params getRequestParams(byte[] bArr) {
        Params params = new Params();
        params.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
        params.method = "POST";
        params.contentType = "application/json";
        params.connectTimeoutMillis = 5000;
        params.readTimeoutMillis = 5000;
        params.requestData = bArr;
        return params;
    }

    @Nullable
    private static AdFormError parseResponse(@Nullable AdFormData adFormData, @Nullable Params params) {
        if (adFormData != null && adFormData.isValid() && params != null && params.isSuccess()) {
            try {
                JSONObject jSONObject = new JSONObject(new String(params.responseData, "UTF-8"));
                params.returnCode = jSONObject.getInt("code");
                AdLog.i(TAG, "parseResponse code:" + params.returnCode + " message:" + jSONObject.optString("message"));
                int i3 = params.returnCode;
                if (i3 == 0) {
                    return new AdFormError(1, -1, null);
                }
                if (i3 == 1) {
                    AdFormError adFormError = new AdFormError(4, -1, null);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (AdJSONUtil.isJSONObjectNull(jSONObject2)) {
                        AdLog.e(TAG, "parseResponse error");
                    } else {
                        JSONArray jSONArray = jSONObject2.getJSONArray("items");
                        if (jSONArray.length() != adFormData.table.getSize()) {
                            AdLog.e(TAG, "parseResponse error");
                        } else {
                            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                AdFormItemData item = adFormData.table.getItem(i16);
                                if (item != null && item.isValid()) {
                                    JSONObject jSONObject3 = jSONArray.getJSONObject(i16);
                                    if (AdJSONUtil.isJSONObjectNull(jSONObject3)) {
                                        AdLog.e(TAG, "parseResponse error");
                                        return new AdFormError(4, i16, item.title.text);
                                    }
                                    int i17 = jSONObject3.getInt("errorCode");
                                    if (i17 != 0) {
                                        if (i17 == 1) {
                                            return new AdFormError(5, i16, item.title.text);
                                        }
                                        if (i17 == 2) {
                                            return new AdFormError(6, i16, item.title.text);
                                        }
                                        AdLog.e(TAG, "parseResponse error");
                                        return new AdFormError(4, i16, item.title.text);
                                    }
                                }
                                AdLog.e(TAG, "parseResponse error");
                                return new AdFormError(4, -1, null);
                            }
                        }
                    }
                    return adFormError;
                }
                if (i3 == 3) {
                    return new AdFormError(4, -1, null);
                }
                if (i3 == 4) {
                    return new AdFormError(7, -1, null);
                }
                return new AdFormError(4, -1, null);
            } catch (UnsupportedEncodingException e16) {
                AdLog.e(TAG, "parseResponse", e16);
                return new AdFormError(4, -1, null);
            } catch (JSONException e17) {
                AdLog.e(TAG, "parseResponse", e17);
                return new AdFormError(4, -1, null);
            }
        }
        AdLog.e(TAG, "commit error");
        return new AdFormError(4, -1, null);
    }

    @Nullable
    public static JSONArray toJson(@Nullable AdFormData adFormData) {
        if (adFormData != null && adFormData.isValid()) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < adFormData.table.getSize(); i3++) {
                AdFormItemData item = adFormData.table.getItem(i3);
                if (item != null && item.isValid()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", item.title.text);
                        jSONObject.put("require", item.required);
                        if (item instanceof AdFormItemTextBoxData) {
                            AdFormItemTextBoxData adFormItemTextBoxData = (AdFormItemTextBoxData) AdFormItemTextBoxData.class.cast(item);
                            jSONObject.put("regexType", adFormItemTextBoxData.regexType);
                            jSONObject.put("value", adFormItemTextBoxData.getResult());
                        }
                        jSONArray.put(i3, jSONObject);
                    } catch (JSONException e16) {
                        AdLog.e(TAG, "toJson", e16);
                    }
                } else {
                    AdLog.e(TAG, "toJson error");
                }
            }
            return jSONArray;
        }
        AdLog.e(TAG, "toJson error");
        return null;
    }

    @Nullable
    public static AdFormError upload(AdFormData adFormData) {
        Params requestParams;
        byte[] requestData = getRequestData(adFormData);
        if (requestData != null && requestData.length > 0) {
            AdFormError adFormError = new AdFormError(4, -1, null);
            for (int i3 = 0; i3 < 3 && (requestParams = getRequestParams(requestData)) != null; i3++) {
                AdHttp.send(requestParams);
                if (requestParams.isSuccess()) {
                    adFormError = parseResponse(adFormData, requestParams);
                }
                int i16 = requestParams.returnCode;
                if (i16 == 0 || i16 == 1 || i16 == 2 || i16 == 4) {
                    return adFormError;
                }
            }
            AdLog.e(TAG, "upload error");
            return adFormError;
        }
        AdLog.e(TAG, "upload error");
        return new AdFormError(4, -1, null);
    }
}
