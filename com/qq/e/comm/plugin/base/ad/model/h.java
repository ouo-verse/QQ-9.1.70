package com.qq.e.comm.plugin.base.ad.model;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    int f39042a;

    /* renamed from: b, reason: collision with root package name */
    String f39043b;

    /* renamed from: c, reason: collision with root package name */
    String f39044c;

    /* renamed from: d, reason: collision with root package name */
    String f39045d;

    /* renamed from: e, reason: collision with root package name */
    String f39046e;

    public h(JSONObject jSONObject) {
        this.f39042a = jSONObject.optInt("type");
        this.f39043b = jSONObject.optString("cta_txt");
        this.f39044c = jSONObject.optString("form_url");
        this.f39045d = jSONObject.optString("consult_url");
        this.f39046e = jSONObject.optString("tel");
    }

    public String a() {
        return this.f39043b;
    }
}
