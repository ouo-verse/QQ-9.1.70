package com.huawei.hms.support.api.entity.account;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GetAssistTokenRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f37536a;

    /* renamed from: b, reason: collision with root package name */
    private String f37537b;

    /* renamed from: c, reason: collision with root package name */
    private String f37538c;

    public GetAssistTokenRequest(String str) {
        this.f37536a = str;
    }

    public String getSessionId() {
        return this.f37538c;
    }

    public String getUserIdentify() {
        return this.f37537b;
    }

    public void setSessionId(String str) {
        this.f37538c = str;
    }

    public void setUserIdentify(String str) {
        this.f37537b = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f37536a)) {
            jSONObject.putOpt(CommonConstant.KEY_ACCESS_TOKEN, this.f37536a);
        }
        if (!TextUtils.isEmpty(this.f37537b)) {
            jSONObject.putOpt(CommonConstant.KEY_USER_IDENTIFY, this.f37537b);
        }
        if (!TextUtils.isEmpty(this.f37538c)) {
            jSONObject.putOpt("sessionId", this.f37538c);
        }
        return jSONObject.toString();
    }
}
