package com.tencent.ad.tangram.statistics.form;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.statistics.xijing.AdDMPReporterHelper;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.form.framework.AdFormItemData;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class AdReporterForDMPWithForm {
    private static final String TAG = "AdReporterForDMPWithForm";

    @Nullable
    private static JSONObject getActionParamsForUpload(Context context, @Nullable Ad ad5, @Nullable AdFormData adFormData) {
        if (ad5 != null && ad5.isValid() && adFormData != null && adFormData.isValid()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < adFormData.getSize(); i3++) {
                    AdFormItemData item = adFormData.getItem(i3);
                    if (item != null && item.isValid()) {
                        jSONObject.put(item.title.text, item.getResult());
                    }
                    AdLog.e(TAG, "getActionParamsForUpload error");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("component_id", adFormData.formId);
                jSONObject2.put("component_type", 1);
                jSONObject2.put("bundle", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("form_info", jSONObject.toString());
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("custom_info", jSONObject3.toString());
                jSONObject4.put("leads_standard_form_info", jSONObject2.toString());
                return jSONObject4;
            } catch (JSONException e16) {
                AdLog.e(TAG, "getActionParamsForUpload", e16);
                return null;
            }
        }
        AdLog.e(TAG, "getActionParamsForUpload error");
        return null;
    }

    @Nullable
    public static AdFormError reportUpload(Context context, Ad ad5, AdFormData adFormData) {
        AdHttp.Params requestParams;
        JSONObject actionParamsForUpload = getActionParamsForUpload(context, ad5, adFormData);
        byte[] requestData = AdDMPReporterHelper.getRequestData(AdDMPReporterHelper.getRequestJson(ad5, actionParamsForUpload, "RESERVATION", null, AdDMPReporterHelper.DEST_URL));
        if (!AdJSONUtil.isJSONObjectNull(actionParamsForUpload) && requestData != null && requestData.length > 0) {
            for (int i3 = 0; i3 < 3 && (requestParams = AdDMPReporterHelper.getRequestParams(requestData)) != null; i3++) {
                AdHttp.send(requestParams);
                if (requestParams.isSuccess()) {
                    return new AdFormError(1, -1, null);
                }
            }
            AdLog.e(TAG, "reportUpload error");
            return new AdFormError(4, -1, null);
        }
        AdLog.e(TAG, "reportUpload error");
        return new AdFormError(4, -1, null);
    }
}
