package com.tencent.luggage.wxa.pf;

import com.tencent.luggage.wxa.yi.d;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.nf.b {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";

    /* renamed from: b, reason: collision with root package name */
    public final a f137514b;

    public b(int i3, d.f fVar) {
        this.f137514b = new a(i3, fVar, e());
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        this.f137514b.a(dVar, jSONObject, str);
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return this.f137514b.b();
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return this.f137514b.d();
    }
}
