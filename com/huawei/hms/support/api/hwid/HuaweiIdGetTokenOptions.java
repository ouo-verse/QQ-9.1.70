package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuaweiIdGetTokenOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f37555a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37556b;

    public HuaweiIdGetTokenOptions(String str, boolean z16) {
        this.f37555a = str;
        this.f37556b = z16;
    }

    public static HuaweiIdGetTokenOptions fromJsonObject(JSONObject jSONObject) throws JSONException {
        return new HuaweiIdGetTokenOptions(jSONObject.optString(VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME), Boolean.getBoolean(jSONObject.optString("fromGetToken")));
    }

    public String getAccountName() {
        return this.f37555a;
    }

    public boolean isFromGetToken() {
        return this.f37556b;
    }

    public void setAccountName(String str) {
        this.f37555a = str;
    }

    public void setFromGetToken(boolean z16) {
        this.f37556b = z16;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f37555a)) {
            jSONObject.put(VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME, this.f37555a);
        }
        jSONObject.put("fromGetToken", this.f37556b);
        return jSONObject;
    }
}
