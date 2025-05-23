package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ForegroundInnerHeader {

    /* renamed from: a, reason: collision with root package name */
    private int f36633a;

    /* renamed from: b, reason: collision with root package name */
    private String f36634b;

    /* renamed from: c, reason: collision with root package name */
    private String f36635c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f36633a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f36634b = JsonUtil.getStringValue(jSONObject, "action");
            this.f36635c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e16) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e16.getMessage());
        }
    }

    public String getAction() {
        return this.f36634b;
    }

    public int getApkVersion() {
        return this.f36633a;
    }

    public String getResponseCallbackKey() {
        return this.f36635c;
    }

    public void setAction(String str) {
        this.f36634b = str;
    }

    public void setApkVersion(int i3) {
        this.f36633a = i3;
    }

    public void setResponseCallbackKey(String str) {
        this.f36635c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f36633a);
            jSONObject.put("action", this.f36634b);
            jSONObject.put("responseCallbackKey", this.f36635c);
        } catch (JSONException e16) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e16.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f36633a + ", action:" + this.f36634b + ", responseCallbackKey:" + this.f36635c;
    }
}
