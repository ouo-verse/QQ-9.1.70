package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RevokeAccessResult extends Result {
    private static final String TAG = "[HUAWEIIDSDK]RevokeAccessResult";

    @Packed
    private Integer errorCode;

    @Packed
    private String errorMsg;

    public RevokeAccessResult() {
    }

    private void jsonToSuper(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("status");
        if (optJSONObject != null) {
            setStatus(new Status(optJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT), optJSONObject.optString("statusMessage", null)));
        }
    }

    public RevokeAccessResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        jsonToSuper(new JSONObject(str));
        return this;
    }

    public RevokeAccessResult getBeanFromJsonStr(String str) {
        Integer num;
        as.b(TAG, "getBeanFromJsonStr begin.", true);
        if (TextUtils.isEmpty(str)) {
            return new RevokeAccessResult(2003, "body is empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errorCode")) {
                num = Integer.valueOf(jSONObject.getInt("errorCode"));
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                return new RevokeAccessResult();
            }
            return new RevokeAccessResult(num, jSONObject.optString("errorMsg"));
        } catch (JSONException unused) {
            as.d(TAG, "JSONException", true);
            return new RevokeAccessResult(2003, "JSONException");
        }
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public RevokeAccessResult(Integer num, String str) {
        this.errorCode = num;
        this.errorMsg = str;
    }

    public RevokeAccessResult(Status status) {
        setStatus(status);
    }
}
