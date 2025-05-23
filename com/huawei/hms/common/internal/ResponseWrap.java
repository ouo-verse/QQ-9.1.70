package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import cooperation.qzone.remote.ServiceConst;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResponseWrap {

    /* renamed from: a, reason: collision with root package name */
    private String f36883a;

    /* renamed from: b, reason: collision with root package name */
    private ResponseHeader f36884b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f36884b = responseHeader;
    }

    public boolean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f36884b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f36884b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f36884b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f36884b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f36884b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f36884b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f36884b.setPkgName(JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.f36884b.setSessionId(JsonUtil.getStringValue(jSONObject, ServiceConst.PARA_SESSION_ID));
            this.f36884b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.f36884b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.f36883a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e16) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e16.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f36883a)) {
            this.f36883a = new JSONObject().toString();
        }
        return this.f36883a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f36884b;
    }

    public void setBody(String str) {
        this.f36883a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f36884b = responseHeader;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f36884b.getStatusCode());
            jSONObject.put("error_code", this.f36884b.getErrorCode());
            jSONObject.put("error_reason", this.f36884b.getErrorReason());
            jSONObject.put("srv_name", this.f36884b.getSrvName());
            jSONObject.put("api_name", this.f36884b.getApiName());
            jSONObject.put("app_id", this.f36884b.getAppID());
            jSONObject.put("pkg_name", this.f36884b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.f36884b.getTransactionId());
            jSONObject.put("resolution", this.f36884b.getResolution());
            String sessionId = this.f36884b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put(ServiceConst.PARA_SESSION_ID, sessionId);
            }
            if (!TextUtils.isEmpty(this.f36883a)) {
                jSONObject.put("body", this.f36883a);
            }
        } catch (JSONException e16) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e16.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f36883a + "', responseHeader=" + this.f36884b + '}';
    }
}
