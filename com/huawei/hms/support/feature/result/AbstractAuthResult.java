package com.huawei.hms.support.feature.result;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AbstractAuthResult extends Result {
    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jsonToSuper(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("status");
        if (optJSONObject != null) {
            setStatus(new Status(optJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT), optJSONObject.optString("statusMessage", null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject superToJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (getStatus() != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, getStatus().getStatusCode());
            if (getStatus().getStatusMessage() != null) {
                jSONObject2.put("statusMessage", getStatus().getStatusMessage());
            }
            jSONObject.put("status", jSONObject2);
        }
        return jSONObject;
    }
}
