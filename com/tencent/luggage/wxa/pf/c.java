package com.tencent.luggage.wxa.pf;

import com.tencent.luggage.wxa.yi.d;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.nf.c {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTaskAsync";

    /* renamed from: b, reason: collision with root package name */
    public final a f137515b;

    public c(int i3, d.f fVar) {
        this.f137515b = new a(i3, fVar, e());
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        this.f137515b.a(dVar, jSONObject, str);
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return this.f137515b.b();
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return this.f137515b.d();
    }
}
