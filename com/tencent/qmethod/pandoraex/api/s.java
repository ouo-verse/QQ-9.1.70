package com.tencent.qmethod.pandoraex.api;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public String f343958a;

    /* renamed from: b, reason: collision with root package name */
    public int f343959b;

    /* renamed from: c, reason: collision with root package name */
    public long f343960c;

    public s(String str, long j3) {
        this.f343958a = str;
        this.f343960c = j3;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f343958a);
            jSONObject.put("time", this.f343960c);
            jSONObject.put("type", this.f343959b);
        } catch (JSONException e16) {
            com.tencent.qmethod.pandoraex.core.o.d("RecentScene", "ParseError," + e16.getMessage(), e16);
        }
        return jSONObject;
    }

    public String toString() {
        return "RecentScene{name='" + this.f343958a + "', type=" + this.f343959b + ", entryTime=" + this.f343960c + '}';
    }

    public s(String str, int i3, long j3) {
        this.f343958a = str;
        this.f343959b = i3;
        this.f343960c = j3;
    }
}
