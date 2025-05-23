package com.tencent.luggage.wxa.n0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f135057a;

    /* renamed from: b, reason: collision with root package name */
    public final int f135058b;

    /* renamed from: c, reason: collision with root package name */
    public final int f135059c;

    /* renamed from: d, reason: collision with root package name */
    public final int f135060d;

    /* renamed from: e, reason: collision with root package name */
    public final int f135061e;

    /* renamed from: f, reason: collision with root package name */
    public final int f135062f;

    /* renamed from: g, reason: collision with root package name */
    public final int f135063g;

    /* renamed from: h, reason: collision with root package name */
    public final long f135064h;

    public f(byte[] bArr, int i3) {
        k kVar = new k(bArr);
        kVar.b(i3 * 8);
        this.f135057a = kVar.a(16);
        this.f135058b = kVar.a(16);
        this.f135059c = kVar.a(24);
        this.f135060d = kVar.a(24);
        this.f135061e = kVar.a(20);
        this.f135062f = kVar.a(3) + 1;
        this.f135063g = kVar.a(5) + 1;
        this.f135064h = ((kVar.a(4) & 15) << 32) | (kVar.a(32) & 4294967295L);
    }

    public int a() {
        return this.f135063g * this.f135061e;
    }

    public long b() {
        return (this.f135064h * 1000000) / this.f135061e;
    }
}
