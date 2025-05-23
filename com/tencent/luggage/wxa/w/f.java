package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143776a;

    /* renamed from: b, reason: collision with root package name */
    public final String f143777b;

    /* renamed from: c, reason: collision with root package name */
    public String f143778c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143779d;

    /* renamed from: e, reason: collision with root package name */
    public int f143780e;

    /* renamed from: f, reason: collision with root package name */
    public int f143781f;

    /* renamed from: g, reason: collision with root package name */
    public int f143782g;

    /* renamed from: h, reason: collision with root package name */
    public long f143783h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.j f143784i;

    /* renamed from: j, reason: collision with root package name */
    public int f143785j;

    /* renamed from: k, reason: collision with root package name */
    public long f143786k;

    public f(String str) {
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(new byte[15]);
        this.f143776a = lVar;
        byte[] bArr = lVar.f135088a;
        bArr[0] = Byte.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = Byte.MIN_VALUE;
        bArr[3] = 1;
        this.f143780e = 0;
        this.f143777b = str;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        this.f143780e = 0;
        this.f143781f = 0;
        this.f143782g = 0;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
    }

    public final void c() {
        byte[] bArr = this.f143776a.f135088a;
        if (this.f143784i == null) {
            com.tencent.luggage.wxa.m.j a16 = com.tencent.luggage.wxa.n.h.a(bArr, this.f143778c, this.f143777b, null);
            this.f143784i = a16;
            this.f143779d.a(a16);
        }
        this.f143785j = com.tencent.luggage.wxa.n.h.a(bArr);
        this.f143783h = (int) ((com.tencent.luggage.wxa.n.h.b(bArr) * 1000000) / this.f143784i.H);
    }

    public final boolean b(com.tencent.luggage.wxa.n0.l lVar) {
        while (lVar.a() > 0) {
            int i3 = this.f143782g << 8;
            this.f143782g = i3;
            int q16 = i3 | lVar.q();
            this.f143782g = q16;
            if (q16 == 2147385345) {
                this.f143782g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        this.f143778c = dVar.b();
        this.f143779d = fVar.a(dVar.c(), 1);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        this.f143786k = j3;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        while (lVar.a() > 0) {
            int i3 = this.f143780e;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int min = Math.min(lVar.a(), this.f143785j - this.f143781f);
                        this.f143779d.a(lVar, min);
                        int i16 = this.f143781f + min;
                        this.f143781f = i16;
                        int i17 = this.f143785j;
                        if (i16 == i17) {
                            this.f143779d.a(this.f143786k, 1, i17, 0, null);
                            this.f143786k += this.f143783h;
                            this.f143780e = 0;
                        }
                    }
                } else if (a(lVar, this.f143776a.f135088a, 15)) {
                    c();
                    this.f143776a.e(0);
                    this.f143779d.a(this.f143776a, 15);
                    this.f143780e = 2;
                }
            } else if (b(lVar)) {
                this.f143781f = 4;
                this.f143780e = 1;
            }
        }
    }

    public final boolean a(com.tencent.luggage.wxa.n0.l lVar, byte[] bArr, int i3) {
        int min = Math.min(lVar.a(), i3 - this.f143781f);
        lVar.a(bArr, this.f143781f, min);
        int i16 = this.f143781f + min;
        this.f143781f = i16;
        return i16 == i3;
    }
}
