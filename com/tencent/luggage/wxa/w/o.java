package com.tencent.luggage.wxa.w;

import android.util.Log;
import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o implements v {

    /* renamed from: a, reason: collision with root package name */
    public final h f143910a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.k f143911b = new com.tencent.luggage.wxa.n0.k(new byte[10]);

    /* renamed from: c, reason: collision with root package name */
    public int f143912c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f143913d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.n0.s f143914e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f143915f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f143916g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f143917h;

    /* renamed from: i, reason: collision with root package name */
    public int f143918i;

    /* renamed from: j, reason: collision with root package name */
    public int f143919j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f143920k;

    /* renamed from: l, reason: collision with root package name */
    public long f143921l;

    public o(h hVar) {
        this.f143910a = hVar;
    }

    @Override // com.tencent.luggage.wxa.w.v
    public void a(com.tencent.luggage.wxa.n0.s sVar, com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        this.f143914e = sVar;
        this.f143910a.a(fVar, dVar);
    }

    public final boolean b() {
        this.f143911b.b(0);
        int a16 = this.f143911b.a(24);
        if (a16 != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + a16);
            this.f143919j = -1;
            return false;
        }
        this.f143911b.c(8);
        int a17 = this.f143911b.a(16);
        this.f143911b.c(5);
        this.f143920k = this.f143911b.c();
        this.f143911b.c(2);
        this.f143915f = this.f143911b.c();
        this.f143916g = this.f143911b.c();
        this.f143911b.c(6);
        int a18 = this.f143911b.a(8);
        this.f143918i = a18;
        if (a17 == 0) {
            this.f143919j = -1;
        } else {
            this.f143919j = ((a17 + 6) - 9) - a18;
        }
        return true;
    }

    public final void c() {
        this.f143911b.b(0);
        this.f143921l = -9223372036854775807L;
        if (this.f143915f) {
            this.f143911b.c(4);
            this.f143911b.c(1);
            this.f143911b.c(1);
            long a16 = (this.f143911b.a(3) << 30) | (this.f143911b.a(15) << 15) | this.f143911b.a(15);
            this.f143911b.c(1);
            if (!this.f143917h && this.f143916g) {
                this.f143911b.c(4);
                this.f143911b.c(1);
                this.f143911b.c(1);
                this.f143911b.c(1);
                this.f143914e.b((this.f143911b.a(3) << 30) | (this.f143911b.a(15) << 15) | this.f143911b.a(15));
                this.f143917h = true;
            }
            this.f143921l = this.f143914e.b(a16);
        }
    }

    @Override // com.tencent.luggage.wxa.w.v
    public final void a() {
        this.f143912c = 0;
        this.f143913d = 0;
        this.f143917h = false;
        this.f143910a.a();
    }

    @Override // com.tencent.luggage.wxa.w.v
    public final void a(com.tencent.luggage.wxa.n0.l lVar, boolean z16) {
        if (z16) {
            int i3 = this.f143912c;
            if (i3 == 2) {
                Log.w("PesReader", "Unexpected start indicator reading extended header");
            } else if (i3 == 3) {
                if (this.f143919j != -1) {
                    Log.w("PesReader", "Unexpected start indicator: expected " + this.f143919j + " more bytes");
                }
                this.f143910a.b();
            }
            a(1);
        }
        while (lVar.a() > 0) {
            int i16 = this.f143912c;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        if (a(lVar, this.f143911b.f135084a, Math.min(10, this.f143918i)) && a(lVar, (byte[]) null, this.f143918i)) {
                            c();
                            this.f143910a.a(this.f143921l, this.f143920k);
                            a(3);
                        }
                    } else if (i16 == 3) {
                        int a16 = lVar.a();
                        int i17 = this.f143919j;
                        int i18 = i17 != -1 ? a16 - i17 : 0;
                        if (i18 > 0) {
                            a16 -= i18;
                            lVar.d(lVar.c() + a16);
                        }
                        this.f143910a.a(lVar);
                        int i19 = this.f143919j;
                        if (i19 != -1) {
                            int i26 = i19 - a16;
                            this.f143919j = i26;
                            if (i26 == 0) {
                                this.f143910a.b();
                                a(1);
                            }
                        }
                    }
                } else if (a(lVar, this.f143911b.f135084a, 9)) {
                    a(b() ? 2 : 0);
                }
            } else {
                lVar.f(lVar.a());
            }
        }
    }

    public final void a(int i3) {
        this.f143912c = i3;
        this.f143913d = 0;
    }

    public final boolean a(com.tencent.luggage.wxa.n0.l lVar, byte[] bArr, int i3) {
        int min = Math.min(lVar.a(), i3 - this.f143913d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.f(min);
        } else {
            lVar.a(bArr, this.f143913d, min);
        }
        int i16 = this.f143913d + min;
        this.f143913d = i16;
        return i16 == i3;
    }
}
