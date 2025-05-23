package com.tencent.luggage.wxa.rj;

import java.util.Objects;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n implements o {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f139813a;

    public n(com.tencent.luggage.wxa.ic.g gVar) {
        Objects.requireNonNull(gVar);
        this.f139813a = gVar;
    }

    @Override // com.tencent.luggage.wxa.rj.o
    public b a() {
        return (b) this.f139813a.a(b.class, false);
    }

    @Override // com.tencent.luggage.wxa.rj.o
    public com.tencent.luggage.wxa.sj.b b() {
        return (com.tencent.luggage.wxa.sj.b) this.f139813a.a(com.tencent.luggage.wxa.sj.b.class, false);
    }

    @Override // com.tencent.luggage.wxa.rj.o
    public com.tencent.luggage.wxa.rc.q c() {
        com.tencent.luggage.wxa.rc.q qVar = (com.tencent.luggage.wxa.rc.q) this.f139813a.f(com.tencent.luggage.wxa.rc.q.class);
        Objects.requireNonNull(qVar);
        return qVar;
    }

    @Override // com.tencent.luggage.wxa.rj.o
    public com.tencent.luggage.wxa.qc.b d() {
        return this.f139813a.c0().b();
    }

    @Override // com.tencent.luggage.wxa.rj.o
    public d e() {
        return (d) this.f139813a.a(d.class, false);
    }

    @Override // com.tencent.luggage.wxa.rj.o
    public boolean f() {
        return this.f139813a.c0().a();
    }

    @Override // com.tencent.luggage.wxa.rj.o
    public void a(String str, JSONObject jSONObject) {
        if (this.f139813a.h0() != null) {
            this.f139813a.h0().a(str, jSONObject.toString());
        }
    }
}
