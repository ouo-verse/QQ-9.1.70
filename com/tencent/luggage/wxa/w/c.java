package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements com.tencent.luggage.wxa.q.d {

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.q.g f143750e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static final int f143751f = com.tencent.luggage.wxa.n0.v.b("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final long f143752a;

    /* renamed from: b, reason: collision with root package name */
    public final d f143753b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143754c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f143755d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.q.g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new c()};
        }
    }

    public c() {
        this(0L);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(10);
        com.tencent.luggage.wxa.n0.k kVar = new com.tencent.luggage.wxa.n0.k(lVar.f135088a);
        int i3 = 0;
        while (true) {
            eVar.b(lVar.f135088a, 0, 10);
            lVar.e(0);
            if (lVar.t() != f143751f) {
                break;
            }
            lVar.f(3);
            int p16 = lVar.p();
            i3 += p16 + 10;
            eVar.a(p16);
        }
        eVar.a();
        eVar.a(i3);
        int i16 = 0;
        int i17 = 0;
        int i18 = i3;
        while (true) {
            eVar.b(lVar.f135088a, 0, 2);
            lVar.e(0);
            if ((lVar.w() & 65526) != 65520) {
                eVar.a();
                i18++;
                if (i18 - i3 >= 8192) {
                    return false;
                }
                eVar.a(i18);
                i16 = 0;
                i17 = 0;
            } else {
                i16++;
                if (i16 >= 4 && i17 > 188) {
                    return true;
                }
                eVar.b(lVar.f135088a, 0, 4);
                kVar.b(14);
                int a16 = kVar.a(13);
                if (a16 <= 6) {
                    return false;
                }
                eVar.a(a16 - 6);
                i17 += a16;
            }
        }
    }

    public c(long j3) {
        this.f143752a = j3;
        this.f143753b = new d(true);
        this.f143754c = new com.tencent.luggage.wxa.n0.l(200);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.f143753b.a(fVar, new v.d(0, 1));
        fVar.e();
        fVar.a(new k.a(-9223372036854775807L));
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.f143755d = false;
        this.f143753b.a();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        int read = eVar.read(this.f143754c.f135088a, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.f143754c.e(0);
        this.f143754c.d(read);
        if (!this.f143755d) {
            this.f143753b.a(this.f143752a, true);
            this.f143755d = true;
        }
        this.f143753b.a(this.f143754c);
        return 0;
    }
}
