package com.huawei.hms.support.api.account;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AccountGetTokenOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f37529a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37530b;

    public AccountGetTokenOptions(String str, boolean z16) {
        this.f37529a = str;
        this.f37530b = z16;
    }

    public static AccountGetTokenOptions fromJsonObject(JSONObject jSONObject) throws JSONException {
        return new AccountGetTokenOptions(jSONObject.optString(VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME), Boolean.getBoolean(jSONObject.optString("fromGetToken")));
    }

    public String getAccountName() {
        return this.f37529a;
    }

    public boolean isFromGetToken() {
        return this.f37530b;
    }

    public void setAccountName(String str) {
        this.f37529a = str;
    }

    public void setFromGetToken(boolean z16) {
        this.f37530b = z16;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f37529a)) {
            jSONObject.put(VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME, this.f37529a);
        }
        jSONObject.put("fromGetToken", this.f37530b);
        return jSONObject;
    }
}
