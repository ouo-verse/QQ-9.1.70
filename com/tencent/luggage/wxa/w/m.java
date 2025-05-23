package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m implements h {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143893a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.q.i f143894b;

    /* renamed from: c, reason: collision with root package name */
    public final String f143895c;

    /* renamed from: d, reason: collision with root package name */
    public String f143896d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143897e;

    /* renamed from: f, reason: collision with root package name */
    public int f143898f;

    /* renamed from: g, reason: collision with root package name */
    public int f143899g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f143900h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f143901i;

    /* renamed from: j, reason: collision with root package name */
    public long f143902j;

    /* renamed from: k, reason: collision with root package name */
    public int f143903k;

    /* renamed from: l, reason: collision with root package name */
    public long f143904l;

    public m() {
        this(null);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        this.f143898f = 0;
        this.f143899g = 0;
        this.f143901i = false;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
    }

    public final void c(com.tencent.luggage.wxa.n0.l lVar) {
        int min = Math.min(lVar.a(), this.f143903k - this.f143899g);
        this.f143897e.a(lVar, min);
        int i3 = this.f143899g + min;
        this.f143899g = i3;
        int i16 = this.f143903k;
        if (i3 < i16) {
            return;
        }
        this.f143897e.a(this.f143904l, 1, i16, 0, null);
        this.f143904l += this.f143902j;
        this.f143899g = 0;
        this.f143898f = 0;
    }

    public final void d(com.tencent.luggage.wxa.n0.l lVar) {
        int min = Math.min(lVar.a(), 4 - this.f143899g);
        lVar.a(this.f143893a.f135088a, this.f143899g, min);
        int i3 = this.f143899g + min;
        this.f143899g = i3;
        if (i3 < 4) {
            return;
        }
        this.f143893a.e(0);
        if (!com.tencent.luggage.wxa.q.i.a(this.f143893a.f(), this.f143894b)) {
            this.f143899g = 0;
            this.f143898f = 1;
            return;
        }
        com.tencent.luggage.wxa.q.i iVar = this.f143894b;
        this.f143903k = iVar.f137764c;
        if (!this.f143900h) {
            int i16 = iVar.f137765d;
            this.f143902j = (iVar.f137768g * 1000000) / i16;
            this.f143897e.a(com.tencent.luggage.wxa.m.j.a(this.f143896d, iVar.f137763b, null, -1, 4096, iVar.f137766e, i16, null, null, 0, this.f143895c));
            this.f143900h = true;
        }
        this.f143893a.e(0);
        this.f143897e.a(this.f143893a, 4);
        this.f143898f = 2;
    }

    public m(String str) {
        this.f143898f = 0;
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(4);
        this.f143893a = lVar;
        lVar.f135088a[0] = -1;
        this.f143894b = new com.tencent.luggage.wxa.q.i();
        this.f143895c = str;
    }

    public final void b(com.tencent.luggage.wxa.n0.l lVar) {
        byte[] bArr = lVar.f135088a;
        int d16 = lVar.d();
        for (int c16 = lVar.c(); c16 < d16; c16++) {
            byte b16 = bArr[c16];
            boolean z16 = (b16 & 255) == 255;
            boolean z17 = this.f143901i && (b16 & 224) == 224;
            this.f143901i = z16;
            if (z17) {
                lVar.e(c16 + 1);
                this.f143901i = false;
                this.f143893a.f135088a[1] = bArr[c16];
                this.f143899g = 2;
                this.f143898f = 1;
                return;
            }
        }
        lVar.e(d16);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        this.f143896d = dVar.b();
        this.f143897e = fVar.a(dVar.c(), 1);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        this.f143904l = j3;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        while (lVar.a() > 0) {
            int i3 = this.f143898f;
            if (i3 == 0) {
                b(lVar);
            } else if (i3 == 1) {
                d(lVar);
            } else if (i3 == 2) {
                c(lVar);
            }
        }
    }
}
