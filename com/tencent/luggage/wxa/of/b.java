package com.tencent.luggage.wxa.of;

import com.tencent.luggage.wxa.yi.b;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.nf.b {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    /* renamed from: b, reason: collision with root package name */
    public final a f136457b;

    public b(b.d dVar) {
        this.f136457b = a(dVar);
    }

    public a a(b.d dVar) {
        return new a(dVar, e());
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return this.f136457b.b();
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return this.f136457b.d();
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        this.f136457b.a(dVar, jSONObject, str);
    }
}
