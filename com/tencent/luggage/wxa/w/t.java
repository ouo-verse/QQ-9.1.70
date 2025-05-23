package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t implements q {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.n0.s f143946a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143947b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143948c;

    @Override // com.tencent.luggage.wxa.w.q
    public void a(com.tencent.luggage.wxa.n0.s sVar, com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        this.f143946a = sVar;
        dVar.a();
        com.tencent.luggage.wxa.q.l a16 = fVar.a(dVar.c(), 4);
        this.f143947b = a16;
        a16.a(com.tencent.luggage.wxa.m.j.a(dVar.b(), "application/x-scte35", (String) null, -1, (com.tencent.luggage.wxa.p.a) null));
    }

    @Override // com.tencent.luggage.wxa.w.q
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        if (!this.f143948c) {
            if (this.f143946a.c() == -9223372036854775807L) {
                return;
            }
            this.f143947b.a(com.tencent.luggage.wxa.m.j.a((String) null, "application/x-scte35", this.f143946a.c()));
            this.f143948c = true;
        }
        int a16 = lVar.a();
        this.f143947b.a(lVar, a16);
        this.f143947b.a(this.f143946a.b(), 1, a16, 0, null);
    }
}
