package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends am {
    public static b a(String str) throws JSONException {
        return new b().a(new JSONObject(str));
    }

    protected b a(JSONObject jSONObject) {
        this.f37306a = jSONObject.optString("appId", null);
        this.f37307b = jSONObject.optString("packageName", null);
        this.f37308c = jSONObject.optLong("hmsSdkVersion");
        this.f37309d = jSONObject.optString("subAppId", null);
        return this;
    }
}
