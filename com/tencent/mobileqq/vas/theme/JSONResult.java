package com.tencent.mobileqq.vas.theme;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class JSONResult {
    private JSONObject data;

    /* renamed from: msg, reason: collision with root package name */
    public String f310875msg;
    public int result;

    public JSONResult(int i3, String str) {
        this.result = i3;
        this.f310875msg = str;
    }

    public void setData(JSONObject jSONObject) {
        this.data = jSONObject;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", this.result);
            jSONObject.put("message", this.f310875msg);
            jSONObject.put("data", this.data);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }
}
