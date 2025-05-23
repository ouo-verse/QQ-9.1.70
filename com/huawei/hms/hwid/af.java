package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private String f37303a;

    public af() {
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.f37303a);
            return jSONObject.toString();
        } catch (JSONException unused) {
            as.d("ReadSmsInputBean", "toJson failed", true);
            return null;
        }
    }

    public af(String str) {
        this.f37303a = str;
    }
}
