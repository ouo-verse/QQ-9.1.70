package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class s extends am {
    public static s a(String str) throws JSONException {
        return new s().a(new JSONObject(str));
    }

    protected s a(JSONObject jSONObject) {
        this.f37306a = jSONObject.optString("appId", null);
        this.f37307b = jSONObject.optString("packageName", null);
        this.f37308c = jSONObject.optLong("hmsSdkVersion");
        this.f37309d = jSONObject.optString("subAppId", null);
        return this;
    }
}
