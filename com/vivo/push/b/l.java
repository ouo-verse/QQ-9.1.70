package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class l extends s {

    /* renamed from: a, reason: collision with root package name */
    private int f387581a;

    /* renamed from: b, reason: collision with root package name */
    private int f387582b;

    public l() {
        super(2016);
        this.f387581a = -1;
        this.f387582b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("key_dispatch_environment", this.f387581a);
        dVar.a("key_dispatch_area", this.f387582b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387581a = dVar.b("key_dispatch_environment", 1);
        this.f387582b = dVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.f387582b;
    }

    public final int d() {
        return this.f387581a;
    }
}
