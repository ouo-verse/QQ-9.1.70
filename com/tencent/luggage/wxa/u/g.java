package com.tencent.luggage.wxa.u;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.u.a;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements com.tencent.luggage.wxa.q.d, com.tencent.luggage.wxa.q.k {

    /* renamed from: q, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.q.g f141944q = new a();

    /* renamed from: r, reason: collision with root package name */
    public static final int f141945r = v.b("qt  ");

    /* renamed from: a, reason: collision with root package name */
    public final int f141946a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141947b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141948c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141949d;

    /* renamed from: e, reason: collision with root package name */
    public final Stack f141950e;

    /* renamed from: f, reason: collision with root package name */
    public int f141951f;

    /* renamed from: g, reason: collision with root package name */
    public int f141952g;

    /* renamed from: h, reason: collision with root package name */
    public long f141953h;

    /* renamed from: i, reason: collision with root package name */
    public int f141954i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.n0.l f141955j;

    /* renamed from: k, reason: collision with root package name */
    public int f141956k;

    /* renamed from: l, reason: collision with root package name */
    public int f141957l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.f f141958m;

    /* renamed from: n, reason: collision with root package name */
    public b[] f141959n;

    /* renamed from: o, reason: collision with root package name */
    public long f141960o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f141961p;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.q.g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new g()};
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final j f141962a;

        /* renamed from: b, reason: collision with root package name */
        public final m f141963b;

        /* renamed from: c, reason: collision with root package name */
        public final com.tencent.luggage.wxa.q.l f141964c;

        /* renamed from: d, reason: collision with root package name */
        public int f141965d;

        public b(j jVar, m mVar, com.tencent.luggage.wxa.q.l lVar) {
            this.f141962a = jVar;
            this.f141963b = mVar;
            this.f141964c = lVar;
        }
    }

    public g() {
        this(0);
    }

    @Override // com.tencent.luggage.wxa.q.k
    public boolean a() {
        return true;
    }

    public final void b() {
        this.f141951f = 0;
        this.f141954i = 0;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long c() {
        return this.f141960o;
    }

    public final int d() {
        int i3 = -1;
        long j3 = Long.MAX_VALUE;
        int i16 = 0;
        while (true) {
            b[] bVarArr = this.f141959n;
            if (i16 >= bVarArr.length) {
                return i3;
            }
            b bVar = bVarArr[i16];
            int i17 = bVar.f141965d;
            m mVar = bVar.f141963b;
            if (i17 != mVar.f142002a) {
                long j16 = mVar.f142003b[i17];
                if (j16 < j3) {
                    i3 = i16;
                    j3 = j16;
                }
            }
            i16++;
        }
    }

    public g(int i3) {
        this.f141946a = i3;
        this.f141949d = new com.tencent.luggage.wxa.n0.l(16);
        this.f141950e = new Stack();
        this.f141947b = new com.tencent.luggage.wxa.n0.l(com.tencent.luggage.wxa.n0.j.f135067a);
        this.f141948c = new com.tencent.luggage.wxa.n0.l(4);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        return i.b(eVar);
    }

    public final void c(long j3) {
        while (!this.f141950e.isEmpty() && ((a.C6775a) this.f141950e.peek()).Q0 == j3) {
            a.C6775a c6775a = (a.C6775a) this.f141950e.pop();
            if (c6775a.f141841a == com.tencent.luggage.wxa.u.a.C) {
                a(c6775a);
                this.f141950e.clear();
                this.f141951f = 2;
            } else if (!this.f141950e.isEmpty()) {
                ((a.C6775a) this.f141950e.peek()).a(c6775a);
            }
        }
        if (this.f141951f != 2) {
            b();
        }
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.f141958m = fVar;
    }

    public final boolean b(com.tencent.luggage.wxa.q.e eVar) {
        if (this.f141954i == 0) {
            if (!eVar.b(this.f141949d.f135088a, 0, 8, true)) {
                return false;
            }
            this.f141954i = 8;
            this.f141949d.e(0);
            this.f141953h = this.f141949d.s();
            this.f141952g = this.f141949d.f();
        }
        long j3 = this.f141953h;
        if (j3 == 1) {
            eVar.a(this.f141949d.f135088a, 8, 8);
            this.f141954i += 8;
            this.f141953h = this.f141949d.v();
        } else if (j3 == 0) {
            long length = eVar.getLength();
            if (length == -1 && !this.f141950e.isEmpty()) {
                length = ((a.C6775a) this.f141950e.peek()).Q0;
            }
            if (length != -1) {
                this.f141953h = (length - eVar.getPosition()) + this.f141954i;
            }
        }
        if (this.f141953h >= this.f141954i) {
            if (a(this.f141952g)) {
                long position = (eVar.getPosition() + this.f141953h) - this.f141954i;
                this.f141950e.add(new a.C6775a(this.f141952g, position));
                if (this.f141953h == this.f141954i) {
                    c(position);
                } else {
                    b();
                }
            } else if (b(this.f141952g)) {
                com.tencent.luggage.wxa.n0.a.b(this.f141954i == 8);
                com.tencent.luggage.wxa.n0.a.b(this.f141953h <= TTL.MAX_VALUE);
                com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l((int) this.f141953h);
                this.f141955j = lVar;
                System.arraycopy(this.f141949d.f135088a, 0, lVar.f135088a, 0, 8);
                this.f141951f = 1;
            } else {
                this.f141955j = null;
                this.f141951f = 1;
            }
            return true;
        }
        throw new o("Atom size less than header length (unsupported).");
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.f141950e.clear();
        this.f141954i = 0;
        this.f141956k = 0;
        this.f141957l = 0;
        if (j3 == 0) {
            b();
        } else if (this.f141959n != null) {
            d(j16);
        }
    }

    public final void d(long j3) {
        for (b bVar : this.f141959n) {
            m mVar = bVar.f141963b;
            int a16 = mVar.a(j3);
            if (a16 == -1) {
                a16 = mVar.b(j3);
            }
            bVar.f141965d = a16;
        }
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        while (true) {
            int i3 = this.f141951f;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return c(eVar, jVar);
                    }
                    throw new IllegalStateException();
                }
                if (b(eVar, jVar)) {
                    return 1;
                }
            } else if (!b(eVar)) {
                return -1;
            }
        }
    }

    public final int c(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        int d16 = d();
        if (d16 == -1) {
            return -1;
        }
        b bVar = this.f141959n[d16];
        com.tencent.luggage.wxa.q.l lVar = bVar.f141964c;
        int i3 = bVar.f141965d;
        m mVar = bVar.f141963b;
        long j3 = mVar.f142003b[i3];
        int i16 = mVar.f142004c[i3];
        if (bVar.f141962a.f141973g == 1) {
            j3 += 8;
            i16 -= 8;
        }
        long position = (j3 - eVar.getPosition()) + this.f141956k;
        if (position >= 0 && position < 262144) {
            eVar.c((int) position);
            int i17 = bVar.f141962a.f141976j;
            if (i17 == 0) {
                while (true) {
                    int i18 = this.f141956k;
                    if (i18 >= i16) {
                        break;
                    }
                    int a16 = lVar.a(eVar, i16 - i18, false);
                    this.f141956k += a16;
                    this.f141957l -= a16;
                }
            } else {
                byte[] bArr = this.f141948c.f135088a;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i19 = 4 - i17;
                while (this.f141956k < i16) {
                    int i26 = this.f141957l;
                    if (i26 == 0) {
                        eVar.a(this.f141948c.f135088a, i19, i17);
                        this.f141948c.e(0);
                        this.f141957l = this.f141948c.u();
                        this.f141947b.e(0);
                        lVar.a(this.f141947b, 4);
                        this.f141956k += 4;
                        i16 += i19;
                    } else {
                        int a17 = lVar.a(eVar, i26, false);
                        this.f141956k += a17;
                        this.f141957l -= a17;
                    }
                }
            }
            m mVar2 = bVar.f141963b;
            lVar.a(mVar2.f142006e[i3], mVar2.f142007f[i3], i16, 0, null);
            bVar.f141965d++;
            this.f141956k = 0;
            this.f141957l = 0;
            return 0;
        }
        jVar.f137769a = j3;
        return 1;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long a(long j3) {
        long j16 = Long.MAX_VALUE;
        for (b bVar : this.f141959n) {
            m mVar = bVar.f141963b;
            int a16 = mVar.a(j3);
            if (a16 == -1) {
                a16 = mVar.b(j3);
            }
            long j17 = mVar.f142003b[a16];
            if (j17 < j16) {
                j16 = j17;
            }
        }
        return j16;
    }

    public static boolean a(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.e(8);
        if (lVar.f() == f141945r) {
            return true;
        }
        lVar.f(4);
        while (lVar.a() > 0) {
            if (lVar.f() == f141945r) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }

    public final void a(a.C6775a c6775a) {
        com.tencent.luggage.wxa.a0.a aVar;
        ArrayList arrayList = new ArrayList();
        com.tencent.luggage.wxa.q.h hVar = new com.tencent.luggage.wxa.q.h();
        a.b e16 = c6775a.e(com.tencent.luggage.wxa.u.a.B0);
        if (e16 != null) {
            aVar = com.tencent.luggage.wxa.u.b.a(e16, this.f141961p);
            if (aVar != null) {
                hVar.a(aVar);
            }
        } else {
            aVar = null;
        }
        long j3 = -9223372036854775807L;
        long j16 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < c6775a.S0.size(); i3++) {
            a.C6775a c6775a2 = (a.C6775a) c6775a.S0.get(i3);
            if (c6775a2.f141841a == com.tencent.luggage.wxa.u.a.E) {
                j a16 = com.tencent.luggage.wxa.u.b.a(c6775a2, c6775a.e(com.tencent.luggage.wxa.u.a.D), -9223372036854775807L, (com.tencent.luggage.wxa.p.a) null, (this.f141946a & 1) != 0, this.f141961p);
                if (a16 != null) {
                    m a17 = com.tencent.luggage.wxa.u.b.a(a16, c6775a2.d(com.tencent.luggage.wxa.u.a.F).d(com.tencent.luggage.wxa.u.a.G).d(com.tencent.luggage.wxa.u.a.H), hVar);
                    if (a17.f142002a != 0) {
                        b bVar = new b(a16, a17, this.f141958m.a(i3, a16.f141968b));
                        com.tencent.luggage.wxa.m.j a18 = a16.f141972f.a(a17.f142005d + 30);
                        if (a16.f141968b == 1) {
                            if (hVar.a()) {
                                a18 = a18.a(hVar.f137753a, hVar.f137754b);
                            }
                            if (aVar != null) {
                                a18 = a18.a(aVar);
                            }
                        }
                        bVar.f141964c.a(a18);
                        long max = Math.max(j3, a16.f141971e);
                        arrayList.add(bVar);
                        long j17 = a17.f142003b[0];
                        if (j17 < j16) {
                            j3 = max;
                            j16 = j17;
                        } else {
                            j3 = max;
                        }
                    }
                }
            }
        }
        this.f141960o = j3;
        this.f141959n = (b[]) arrayList.toArray(new b[arrayList.size()]);
        this.f141958m.e();
        this.f141958m.a(this);
    }

    public final boolean b(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        boolean z16;
        long j3 = this.f141953h - this.f141954i;
        long position = eVar.getPosition() + j3;
        com.tencent.luggage.wxa.n0.l lVar = this.f141955j;
        if (lVar != null) {
            eVar.a(lVar.f135088a, this.f141954i, (int) j3);
            if (this.f141952g == com.tencent.luggage.wxa.u.a.f141791b) {
                this.f141961p = a(this.f141955j);
            } else if (!this.f141950e.isEmpty()) {
                ((a.C6775a) this.f141950e.peek()).a(new a.b(this.f141952g, this.f141955j));
            }
        } else if (j3 < 262144) {
            eVar.c((int) j3);
        } else {
            jVar.f137769a = eVar.getPosition() + j3;
            z16 = true;
            c(position);
            return (z16 || this.f141951f == 2) ? false : true;
        }
        z16 = false;
        c(position);
        if (z16) {
        }
    }

    public static boolean b(int i3) {
        return i3 == com.tencent.luggage.wxa.u.a.S || i3 == com.tencent.luggage.wxa.u.a.D || i3 == com.tencent.luggage.wxa.u.a.T || i3 == com.tencent.luggage.wxa.u.a.U || i3 == com.tencent.luggage.wxa.u.a.f141816n0 || i3 == com.tencent.luggage.wxa.u.a.f141818o0 || i3 == com.tencent.luggage.wxa.u.a.f141820p0 || i3 == com.tencent.luggage.wxa.u.a.R || i3 == com.tencent.luggage.wxa.u.a.f141822q0 || i3 == com.tencent.luggage.wxa.u.a.f141824r0 || i3 == com.tencent.luggage.wxa.u.a.f141826s0 || i3 == com.tencent.luggage.wxa.u.a.f141828t0 || i3 == com.tencent.luggage.wxa.u.a.f141830u0 || i3 == com.tencent.luggage.wxa.u.a.P || i3 == com.tencent.luggage.wxa.u.a.f141791b || i3 == com.tencent.luggage.wxa.u.a.B0;
    }

    public static boolean a(int i3) {
        return i3 == com.tencent.luggage.wxa.u.a.C || i3 == com.tencent.luggage.wxa.u.a.E || i3 == com.tencent.luggage.wxa.u.a.F || i3 == com.tencent.luggage.wxa.u.a.G || i3 == com.tencent.luggage.wxa.u.a.H || i3 == com.tencent.luggage.wxa.u.a.Q;
    }
}
