package com.tencent.luggage.wxa.m;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements r, s {

    /* renamed from: a, reason: collision with root package name */
    public final int f133797a;

    /* renamed from: b, reason: collision with root package name */
    public t f133798b;

    /* renamed from: c, reason: collision with root package name */
    public int f133799c;

    /* renamed from: d, reason: collision with root package name */
    public int f133800d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.d0.k f133801e;

    /* renamed from: f, reason: collision with root package name */
    public long f133802f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f133803g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f133804h;

    public a(int i3) {
        this.f133797a = i3;
    }

    @Override // com.tencent.luggage.wxa.m.e.b
    public void a(int i3, Object obj) {
    }

    public abstract void a(long j3, boolean z16);

    public abstract void a(boolean z16);

    public void b(long j3) {
        this.f133801e.a(j3 - this.f133802f);
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final boolean c() {
        return this.f133803g;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void d() {
        this.f133804h = true;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void e() {
        boolean z16 = true;
        if (this.f133800d != 1) {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        this.f133800d = 0;
        this.f133801e = null;
        this.f133804h = false;
        q();
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void f() {
        this.f133801e.a();
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final boolean g() {
        return this.f133804h;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final int getState() {
        return this.f133800d;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final com.tencent.luggage.wxa.d0.k l() {
        return this.f133801e;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public com.tencent.luggage.wxa.n0.h m() {
        return null;
    }

    public final t n() {
        return this.f133798b;
    }

    public final int o() {
        return this.f133799c;
    }

    public final boolean p() {
        if (this.f133803g) {
            return this.f133804h;
        }
        return this.f133801e.isReady();
    }

    public abstract void q();

    public abstract void r();

    public abstract void s();

    @Override // com.tencent.luggage.wxa.m.r
    public final void start() {
        boolean z16 = true;
        if (this.f133800d != 1) {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        this.f133800d = 2;
        r();
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void stop() {
        boolean z16;
        if (this.f133800d == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        this.f133800d = 1;
        s();
    }

    public void a(j[] jVarArr, long j3) {
    }

    @Override // com.tencent.luggage.wxa.m.r, com.tencent.luggage.wxa.m.s
    public final int a() {
        return this.f133797a;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void a(int i3) {
        this.f133799c = i3;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void a(t tVar, j[] jVarArr, com.tencent.luggage.wxa.d0.k kVar, long j3, boolean z16, long j16) {
        com.tencent.luggage.wxa.n0.a.b(this.f133800d == 0);
        this.f133798b = tVar;
        this.f133800d = 1;
        a(z16);
        a(jVarArr, kVar, j16);
        a(j3, z16);
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void a(j[] jVarArr, com.tencent.luggage.wxa.d0.k kVar, long j3) {
        com.tencent.luggage.wxa.n0.a.b(!this.f133804h);
        this.f133801e = kVar;
        this.f133803g = false;
        this.f133802f = j3;
        a(jVarArr, j3);
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final void a(long j3) {
        this.f133804h = false;
        this.f133803g = false;
        a(j3, false);
    }

    public final int a(k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16) {
        int a16 = this.f133801e.a(kVar, dVar, z16);
        if (a16 == -4) {
            if (dVar.c()) {
                this.f133803g = true;
                return this.f133804h ? -4 : -3;
            }
            dVar.f135957d += this.f133802f;
        } else if (a16 == -5) {
            j jVar = kVar.f133904a;
            long j3 = jVar.L;
            if (j3 != Long.MAX_VALUE) {
                kVar.f133904a = jVar.a(j3 + this.f133802f);
            }
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public final s i() {
        return this;
    }
}
