package com.huawei.hms.support.api.entity.account;

import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AccountStartAssistLoginRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f37535a;

    public AccountStartAssistLoginRequest() {
    }

    public static AccountStartAssistLoginRequest fromJson(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        return new AccountStartAssistLoginRequest().objectFromJson(new JSONObject(str));
    }

    protected AccountStartAssistLoginRequest objectFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.f37535a = jSONObject.getString(CommonConstant.KEY_ASSIST_TOKEN);
        }
        return this;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f37535a;
        if (str != null) {
            jSONObject.put(CommonConstant.KEY_ASSIST_TOKEN, str);
        }
        return jSONObject.toString();
    }

    public AccountStartAssistLoginRequest(String str) {
        this.f37535a = str;
    }
}
