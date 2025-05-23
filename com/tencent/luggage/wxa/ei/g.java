package com.tencent.luggage.wxa.ei;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends e {

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.d f124902c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.t f124903d;

    /* renamed from: e, reason: collision with root package name */
    public final int f124904e;

    public g(com.tencent.luggage.wxa.b9.t tVar, int i3) {
        this.f124902c = tVar.h();
        this.f124903d = tVar;
        this.f124904e = i3;
    }

    @Override // com.tencent.luggage.wxa.ei.e
    public com.tencent.luggage.wxa.b9.t C() {
        return this.f124903d;
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.u
    public void a() {
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public boolean n() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.u
    public void pause() {
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public int q() {
        return this.f124904e;
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(i iVar) {
        C().a(q(), iVar);
    }

    @Override // com.tencent.luggage.wxa.ei.e
    public com.tencent.luggage.wxa.b9.d u() {
        return this.f124902c;
    }
}
