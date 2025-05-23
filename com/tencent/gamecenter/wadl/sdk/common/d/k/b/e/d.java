package com.tencent.gamecenter.wadl.sdk.common.d.k.b.e;

import com.tencent.ams.dsdk.core.DKConfiguration;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f107217a;

    /* renamed from: b, reason: collision with root package name */
    public int f107218b;

    /* renamed from: c, reason: collision with root package name */
    public long f107219c;

    public Object a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appid", com.tencent.gamecenter.wadl.sdk.common.a.c());
            jSONObject2.put("url", this.f107217a);
            jSONObject2.put("needFeature", this.f107218b);
            jSONObject2.put("size", this.f107219c);
            jSONArray.mo162put(jSONObject2);
            jSONObject.put(DKConfiguration.Directory.RESOURCES, jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
