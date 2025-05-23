package com.tencent.luggage.wxa.f0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i implements com.tencent.luggage.wxa.d0.k {

    /* renamed from: a, reason: collision with root package name */
    public final int f125164a;

    /* renamed from: b, reason: collision with root package name */
    public final j f125165b;

    public i(j jVar, int i3) {
        this.f125165b = jVar;
        this.f125164a = i3;
    }

    @Override // com.tencent.luggage.wxa.d0.k
    public void a() {
        this.f125165b.l();
    }

    @Override // com.tencent.luggage.wxa.d0.k
    public boolean isReady() {
        return this.f125165b.a(this.f125164a);
    }

    @Override // com.tencent.luggage.wxa.d0.k
    public int a(com.tencent.luggage.wxa.m.k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16) {
        return this.f125165b.a(this.f125164a, kVar, dVar, z16);
    }

    @Override // com.tencent.luggage.wxa.d0.k
    public void a(long j3) {
        this.f125165b.a(this.f125164a, j3);
    }
}
