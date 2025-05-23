package com.tencent.luggage.wxa.w;

import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.wxa.w.v;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements h {

    /* renamed from: r, reason: collision with root package name */
    public static final byte[] f143756r = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f143757a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.k f143758b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143759c;

    /* renamed from: d, reason: collision with root package name */
    public final String f143760d;

    /* renamed from: e, reason: collision with root package name */
    public String f143761e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143762f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143763g;

    /* renamed from: h, reason: collision with root package name */
    public int f143764h;

    /* renamed from: i, reason: collision with root package name */
    public int f143765i;

    /* renamed from: j, reason: collision with root package name */
    public int f143766j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f143767k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f143768l;

    /* renamed from: m, reason: collision with root package name */
    public long f143769m;

    /* renamed from: n, reason: collision with root package name */
    public int f143770n;

    /* renamed from: o, reason: collision with root package name */
    public long f143771o;

    /* renamed from: p, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143772p;

    /* renamed from: q, reason: collision with root package name */
    public long f143773q;

    public d(boolean z16) {
        this(z16, null);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        e();
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
    }

    public final void c() {
        this.f143758b.b(0);
        if (!this.f143768l) {
            int a16 = this.f143758b.a(2) + 1;
            if (a16 != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + a16 + ", but assuming AAC LC.");
                a16 = 2;
            }
            int a17 = this.f143758b.a(4);
            this.f143758b.c(1);
            byte[] a18 = com.tencent.luggage.wxa.n0.d.a(a16, a17, this.f143758b.a(3));
            Pair a19 = com.tencent.luggage.wxa.n0.d.a(a18);
            com.tencent.luggage.wxa.m.j a26 = com.tencent.luggage.wxa.m.j.a(this.f143761e, "audio/mp4a-latm", null, -1, -1, ((Integer) a19.second).intValue(), ((Integer) a19.first).intValue(), Collections.singletonList(a18), null, 0, this.f143760d);
            this.f143769m = 1024000000 / a26.H;
            this.f143762f.a(a26);
            this.f143768l = true;
        } else {
            this.f143758b.c(10);
        }
        this.f143758b.c(4);
        int a27 = (this.f143758b.a(13) - 2) - 5;
        if (this.f143767k) {
            a27 -= 2;
        }
        a(this.f143762f, this.f143769m, 0, a27);
    }

    public final void d() {
        this.f143763g.a(this.f143759c, 10);
        this.f143759c.e(6);
        a(this.f143763g, 0L, 10, this.f143759c.p() + 10);
    }

    public final void e() {
        this.f143764h = 0;
        this.f143765i = 0;
        this.f143766j = 256;
    }

    public final void f() {
        this.f143764h = 2;
        this.f143765i = 0;
    }

    public final void g() {
        this.f143764h = 1;
        this.f143765i = f143756r.length;
        this.f143770n = 0;
        this.f143759c.e(0);
    }

    public d(boolean z16, String str) {
        this.f143758b = new com.tencent.luggage.wxa.n0.k(new byte[7]);
        this.f143759c = new com.tencent.luggage.wxa.n0.l(Arrays.copyOf(f143756r, 10));
        e();
        this.f143757a = z16;
        this.f143760d = str;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        this.f143761e = dVar.b();
        this.f143762f = fVar.a(dVar.c(), 1);
        if (this.f143757a) {
            dVar.a();
            com.tencent.luggage.wxa.q.l a16 = fVar.a(dVar.c(), 4);
            this.f143763g = a16;
            a16.a(com.tencent.luggage.wxa.m.j.a(dVar.b(), "application/id3", (String) null, -1, (com.tencent.luggage.wxa.p.a) null));
            return;
        }
        this.f143763g = new com.tencent.luggage.wxa.q.c();
    }

    public final void b(com.tencent.luggage.wxa.n0.l lVar) {
        byte[] bArr = lVar.f135088a;
        int c16 = lVar.c();
        int d16 = lVar.d();
        while (c16 < d16) {
            int i3 = c16 + 1;
            int i16 = bArr[c16] & 255;
            int i17 = this.f143766j;
            if (i17 == 512 && i16 >= 240 && i16 != 255) {
                this.f143767k = (i16 & 1) == 0;
                f();
                lVar.e(i3);
                return;
            }
            int i18 = i16 | i17;
            if (i18 == 329) {
                this.f143766j = 768;
            } else if (i18 == 511) {
                this.f143766j = 512;
            } else if (i18 == 836) {
                this.f143766j = 1024;
            } else if (i18 == 1075) {
                g();
                lVar.e(i3);
                return;
            } else if (i17 != 256) {
                this.f143766j = 256;
                c16 = i3 - 1;
            }
            c16 = i3;
        }
        lVar.e(c16);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        this.f143771o = j3;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        while (lVar.a() > 0) {
            int i3 = this.f143764h;
            if (i3 == 0) {
                b(lVar);
            } else if (i3 != 1) {
                if (i3 == 2) {
                    if (a(lVar, this.f143758b.f135084a, this.f143767k ? 7 : 5)) {
                        c();
                    }
                } else if (i3 == 3) {
                    c(lVar);
                }
            } else if (a(lVar, this.f143759c.f135088a, 10)) {
                d();
            }
        }
    }

    public final boolean a(com.tencent.luggage.wxa.n0.l lVar, byte[] bArr, int i3) {
        int min = Math.min(lVar.a(), i3 - this.f143765i);
        lVar.a(bArr, this.f143765i, min);
        int i16 = this.f143765i + min;
        this.f143765i = i16;
        return i16 == i3;
    }

    public final void c(com.tencent.luggage.wxa.n0.l lVar) {
        int min = Math.min(lVar.a(), this.f143770n - this.f143765i);
        this.f143772p.a(lVar, min);
        int i3 = this.f143765i + min;
        this.f143765i = i3;
        int i16 = this.f143770n;
        if (i3 == i16) {
            this.f143772p.a(this.f143771o, 1, i16, 0, null);
            this.f143771o += this.f143773q;
            e();
        }
    }

    public final void a(com.tencent.luggage.wxa.q.l lVar, long j3, int i3, int i16) {
        this.f143764h = 3;
        this.f143765i = i3;
        this.f143772p = lVar;
        this.f143773q = j3;
        this.f143770n = i16;
    }
}
