package com.tencent.luggage.wxa.m;

import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.k f133810a;

    /* renamed from: b, reason: collision with root package name */
    public final long f133811b;

    /* renamed from: c, reason: collision with root package name */
    public final long f133812c;

    /* renamed from: d, reason: collision with root package name */
    public final long f133813d;

    /* renamed from: e, reason: collision with root package name */
    public final long f133814e;

    /* renamed from: f, reason: collision with root package name */
    public int f133815f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f133816g;

    public c(com.tencent.luggage.wxa.l0.k kVar, int i3, int i16, long j3, long j16) {
        this(kVar, i3, i16, j3, j16, null);
    }

    @Override // com.tencent.luggage.wxa.m.m
    public void a() {
        a(false);
    }

    @Override // com.tencent.luggage.wxa.m.m
    public com.tencent.luggage.wxa.l0.b b() {
        return this.f133810a;
    }

    @Override // com.tencent.luggage.wxa.m.m
    public void c() {
        a(true);
    }

    @Override // com.tencent.luggage.wxa.m.m
    public void d() {
        a(true);
    }

    public c(com.tencent.luggage.wxa.l0.k kVar, int i3, int i16, long j3, long j16, com.tencent.luggage.wxa.n0.o oVar) {
        this.f133810a = kVar;
        this.f133811b = i3 * 1000;
        this.f133812c = i16 * 1000;
        this.f133813d = j3 * 1000;
        this.f133814e = j16 * 1000;
    }

    @Override // com.tencent.luggage.wxa.m.m
    public void a(r[] rVarArr, com.tencent.luggage.wxa.d0.o oVar, com.tencent.luggage.wxa.k0.g gVar) {
        this.f133815f = 0;
        for (int i3 = 0; i3 < rVarArr.length; i3++) {
            if (gVar.a(i3) != null) {
                this.f133815f += v.a(rVarArr[i3].a());
            }
        }
        this.f133810a.a(this.f133815f);
    }

    public final int b(long j3) {
        if (j3 > this.f133812c) {
            return 0;
        }
        return j3 < this.f133811b ? 2 : 1;
    }

    @Override // com.tencent.luggage.wxa.m.m
    public boolean a(long j3, boolean z16) {
        long j16 = z16 ? this.f133814e : this.f133813d;
        return j16 <= 0 || j3 >= j16;
    }

    @Override // com.tencent.luggage.wxa.m.m
    public boolean a(long j3) {
        int b16 = b(j3);
        boolean z16 = false;
        boolean z17 = this.f133810a.d() >= this.f133815f;
        boolean z18 = this.f133816g;
        if (b16 == 2 || (b16 == 1 && z18 && !z17)) {
            z16 = true;
        }
        this.f133816g = z16;
        return z16;
    }

    public final void a(boolean z16) {
        this.f133815f = 0;
        this.f133816g = false;
        if (z16) {
            this.f133810a.e();
        }
    }
}
