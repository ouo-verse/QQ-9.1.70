package com.huawei.hms.hihealth.result;

import android.text.TextUtils;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthKitAuthResult extends Result {
    private AuthAccount aab;

    public HealthKitAuthResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject optJSONObject = jSONObject.optJSONObject("status");
        if (optJSONObject != null) {
            setStatus(new Status(optJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT), optJSONObject.optString("statusMessage", "")));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("HuaweiId");
        if (optJSONObject2 != null) {
            this.aab = AuthAccount.fromJson(optJSONObject2);
        }
        return this;
    }

    public AuthAccount getAuthAccount() {
        return this.aab;
    }

    public int getErrorCode() {
        if (getStatus() != null) {
            return getStatus().getStatusCode();
        }
        return 0;
    }

    public boolean isSuccess() {
        if (getStatus() != null) {
            return getStatus().isSuccess();
        }
        return true;
    }

    public void setAuthAccount(AuthAccount authAccount) {
        this.aab = authAccount;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (getStatus() != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, getStatus().getStatusCode());
            if (getStatus().getStatusMessage() != null) {
                jSONObject2.put("statusMessage", getStatus().getStatusMessage());
            }
            jSONObject.put("status", jSONObject2);
        }
        AuthAccount authAccount = this.aab;
        if (authAccount != null) {
            jSONObject.put("HuaweiId", authAccount.toJsonObject());
        }
        return jSONObject.toString();
    }
}
