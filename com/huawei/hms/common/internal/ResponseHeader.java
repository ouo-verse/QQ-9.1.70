package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import cooperation.qzone.remote.ServiceConst;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResponseHeader implements IMessageEntity, ResponseErrorCode {
    private static final String TAG = "ResponseHeader";

    @Packed
    private String api_name;

    @Packed
    private String app_id = "";

    @Packed
    private int error_code;

    @Packed
    private String error_reason;
    private Parcelable parcelable;

    @Packed
    private String pkg_name;

    @Packed
    private String resolution;

    @Packed
    private String session_id;

    @Packed
    private String srv_name;

    @Packed
    private int status_code;

    @Packed
    private String transaction_id;

    public ResponseHeader() {
    }

    public boolean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.status_code = JsonUtil.getIntValue(jSONObject, "status_code");
            this.error_code = JsonUtil.getIntValue(jSONObject, "error_code");
            this.error_reason = JsonUtil.getStringValue(jSONObject, "error_reason");
            this.srv_name = JsonUtil.getStringValue(jSONObject, "srv_name");
            this.api_name = JsonUtil.getStringValue(jSONObject, "api_name");
            this.app_id = JsonUtil.getStringValue(jSONObject, "app_id");
            this.pkg_name = JsonUtil.getStringValue(jSONObject, "pkg_name");
            this.session_id = JsonUtil.getStringValue(jSONObject, ServiceConst.PARA_SESSION_ID);
            this.transaction_id = JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID);
            this.resolution = JsonUtil.getStringValue(jSONObject, "resolution");
            return true;
        } catch (JSONException e16) {
            HMSLog.e(TAG, "fromJson failed: " + e16.getMessage());
            return false;
        }
    }

    public String getActualAppID() {
        if (TextUtils.isEmpty(this.app_id)) {
            return "";
        }
        String[] split = this.app_id.split("\\|");
        if (split.length == 0) {
            return "";
        }
        if (split.length == 1) {
            return split[0];
        }
        return split[1];
    }

    public String getApiName() {
        return this.api_name;
    }

    public String getAppID() {
        return this.app_id;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getErrorCode() {
        return this.error_code;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getErrorReason() {
        return this.error_reason;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getPkgName() {
        return this.pkg_name;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getResolution() {
        return this.resolution;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public String getSrvName() {
        return this.srv_name;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getStatusCode() {
        return this.status_code;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getTransactionId() {
        return this.transaction_id;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public boolean hasResolution() {
        if (this.parcelable != null) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (this.status_code == 0) {
            return true;
        }
        return false;
    }

    public void setApiName(String str) {
        this.api_name = str;
    }

    public void setAppID(String str) {
        this.app_id = str;
    }

    public void setErrorCode(int i3) {
        this.error_code = i3;
    }

    public void setErrorReason(String str) {
        this.error_reason = str;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setPkgName(String str) {
        this.pkg_name = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setSessionId(String str) {
        this.session_id = str;
    }

    public void setSrvName(String str) {
        this.srv_name = str;
    }

    public void setStatusCode(int i3) {
        this.status_code = i3;
    }

    public void setTransactionId(String str) {
        this.transaction_id = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.status_code);
            jSONObject.put("error_code", this.error_code);
            jSONObject.put("error_reason", this.error_reason);
            jSONObject.put("srv_name", this.srv_name);
            jSONObject.put("api_name", this.api_name);
            jSONObject.put("app_id", this.app_id);
            jSONObject.put("pkg_name", this.pkg_name);
            if (!TextUtils.isEmpty(this.session_id)) {
                jSONObject.put(ServiceConst.PARA_SESSION_ID, this.session_id);
            }
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);
            jSONObject.put("resolution", this.resolution);
        } catch (JSONException e16) {
            HMSLog.e(TAG, "toJson failed: " + e16.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "status_code:" + this.status_code + ", error_code:" + this.error_code + ", api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", session_id:*, transaction_id:" + this.transaction_id + ", resolution:" + this.resolution;
    }

    public ResponseHeader(int i3, int i16, String str) {
        this.status_code = i3;
        this.error_code = i16;
        this.error_reason = str;
    }
}
