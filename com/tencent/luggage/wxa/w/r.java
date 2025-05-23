package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r implements v {

    /* renamed from: a, reason: collision with root package name */
    public final q f143938a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143939b = new com.tencent.luggage.wxa.n0.l(32);

    /* renamed from: c, reason: collision with root package name */
    public int f143940c;

    /* renamed from: d, reason: collision with root package name */
    public int f143941d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f143942e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f143943f;

    public r(q qVar) {
        this.f143938a = qVar;
    }

    @Override // com.tencent.luggage.wxa.w.v
    public void a(com.tencent.luggage.wxa.n0.s sVar, com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        this.f143938a.a(sVar, fVar, dVar);
        this.f143943f = true;
    }

    @Override // com.tencent.luggage.wxa.w.v
    public void a() {
        this.f143943f = true;
    }

    @Override // com.tencent.luggage.wxa.w.v
    public void a(com.tencent.luggage.wxa.n0.l lVar, boolean z16) {
        int c16 = z16 ? lVar.c() + lVar.q() : -1;
        if (this.f143943f) {
            if (!z16) {
                return;
            }
            this.f143943f = false;
            lVar.e(c16);
            this.f143941d = 0;
        }
        while (lVar.a() > 0) {
            int i3 = this.f143941d;
            if (i3 < 3) {
                if (i3 == 0) {
                    int q16 = lVar.q();
                    lVar.e(lVar.c() - 1);
                    if (q16 == 255) {
                        this.f143943f = true;
                        return;
                    }
                }
                int min = Math.min(lVar.a(), 3 - this.f143941d);
                lVar.a(this.f143939b.f135088a, this.f143941d, min);
                int i16 = this.f143941d + min;
                this.f143941d = i16;
                if (i16 == 3) {
                    this.f143939b.c(3);
                    this.f143939b.f(1);
                    int q17 = this.f143939b.q();
                    int q18 = this.f143939b.q();
                    this.f143942e = (q17 & 128) != 0;
                    this.f143940c = (((q17 & 15) << 8) | q18) + 3;
                    int b16 = this.f143939b.b();
                    int i17 = this.f143940c;
                    if (b16 < i17) {
                        com.tencent.luggage.wxa.n0.l lVar2 = this.f143939b;
                        byte[] bArr = lVar2.f135088a;
                        lVar2.c(Math.min(4098, Math.max(i17, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f143939b.f135088a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.a(), this.f143940c - this.f143941d);
                lVar.a(this.f143939b.f135088a, this.f143941d, min2);
                int i18 = this.f143941d + min2;
                this.f143941d = i18;
                int i19 = this.f143940c;
                if (i18 != i19) {
                    continue;
                } else {
                    if (this.f143942e) {
                        if (com.tencent.luggage.wxa.n0.v.a(this.f143939b.f135088a, 0, i19, -1) != 0) {
                            this.f143943f = true;
                            return;
                        }
                        this.f143939b.c(this.f143940c - 4);
                    } else {
                        this.f143939b.c(i19);
                    }
                    this.f143938a.a(this.f143939b);
                    this.f143941d = 0;
                }
            }
        }
    }
}
