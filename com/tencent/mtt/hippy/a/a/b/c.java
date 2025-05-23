package com.tencent.mtt.hippy.a.a.b;

import com.tencent.mtt.hippy.utils.LogUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f336925a;

    /* renamed from: b, reason: collision with root package name */
    private final JSONObject f336926b;

    public c(String str, JSONObject jSONObject) {
        this.f336925a = str;
        this.f336926b = jSONObject;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", this.f336925a);
            jSONObject.put("params", this.f336926b);
            return jSONObject.toString();
        } catch (Exception e16) {
            LogUtils.e("InspectEvent", "toJson, exception:", e16);
            return null;
        }
    }
}
