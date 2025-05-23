package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.q.f;
import com.tencent.luggage.wxa.q.g;
import com.tencent.luggage.wxa.q.j;
import com.tencent.luggage.wxa.q.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements com.tencent.luggage.wxa.q.d, k {

    /* renamed from: n, reason: collision with root package name */
    public static final g f139026n = new a();

    /* renamed from: o, reason: collision with root package name */
    public static final int f139027o = v.b("FLV");

    /* renamed from: e, reason: collision with root package name */
    public f f139032e;

    /* renamed from: g, reason: collision with root package name */
    public int f139034g;

    /* renamed from: h, reason: collision with root package name */
    public int f139035h;

    /* renamed from: i, reason: collision with root package name */
    public int f139036i;

    /* renamed from: j, reason: collision with root package name */
    public long f139037j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.r.a f139038k;

    /* renamed from: l, reason: collision with root package name */
    public e f139039l;

    /* renamed from: m, reason: collision with root package name */
    public c f139040m;

    /* renamed from: a, reason: collision with root package name */
    public final l f139028a = new l(4);

    /* renamed from: b, reason: collision with root package name */
    public final l f139029b = new l(9);

    /* renamed from: c, reason: collision with root package name */
    public final l f139030c = new l(11);

    /* renamed from: d, reason: collision with root package name */
    public final l f139031d = new l();

    /* renamed from: f, reason: collision with root package name */
    public int f139033f = 1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new b()};
        }
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long a(long j3) {
        return 0L;
    }

    public final l b(com.tencent.luggage.wxa.q.e eVar) {
        if (this.f139036i > this.f139031d.b()) {
            l lVar = this.f139031d;
            lVar.a(new byte[Math.max(lVar.b() * 2, this.f139036i)], 0);
        } else {
            this.f139031d.e(0);
        }
        this.f139031d.d(this.f139036i);
        eVar.a(this.f139031d.f135088a, 0, this.f139036i);
        return this.f139031d;
    }

    public final boolean c(com.tencent.luggage.wxa.q.e eVar) {
        if (!eVar.b(this.f139029b.f135088a, 0, 9, true)) {
            return false;
        }
        this.f139029b.e(0);
        this.f139029b.f(4);
        int q16 = this.f139029b.q();
        boolean z16 = (q16 & 4) != 0;
        boolean z17 = (q16 & 1) != 0;
        if (z16 && this.f139038k == null) {
            this.f139038k = new com.tencent.luggage.wxa.r.a(this.f139032e.a(8, 1));
        }
        if (z17 && this.f139039l == null) {
            this.f139039l = new e(this.f139032e.a(9, 2));
        }
        if (this.f139040m == null) {
            this.f139040m = new c(null);
        }
        this.f139032e.e();
        this.f139032e.a(this);
        this.f139034g = (this.f139029b.f() - 9) + 4;
        this.f139033f = 2;
        return true;
    }

    public final boolean d(com.tencent.luggage.wxa.q.e eVar) {
        boolean z16;
        c cVar;
        e eVar2;
        com.tencent.luggage.wxa.r.a aVar;
        int i3 = this.f139035h;
        if (i3 == 8 && (aVar = this.f139038k) != null) {
            aVar.a(b(eVar), this.f139037j);
        } else if (i3 == 9 && (eVar2 = this.f139039l) != null) {
            eVar2.a(b(eVar), this.f139037j);
        } else if (i3 == 18 && (cVar = this.f139040m) != null) {
            cVar.a(b(eVar), this.f139037j);
        } else {
            eVar.c(this.f139036i);
            z16 = false;
            this.f139034g = 4;
            this.f139033f = 2;
            return z16;
        }
        z16 = true;
        this.f139034g = 4;
        this.f139033f = 2;
        return z16;
    }

    public final boolean e(com.tencent.luggage.wxa.q.e eVar) {
        if (!eVar.b(this.f139030c.f135088a, 0, 11, true)) {
            return false;
        }
        this.f139030c.e(0);
        this.f139035h = this.f139030c.q();
        this.f139036i = this.f139030c.t();
        this.f139037j = this.f139030c.t();
        this.f139037j = ((this.f139030c.q() << 24) | this.f139037j) * 1000;
        this.f139030c.f(3);
        this.f139033f = 4;
        return true;
    }

    public final void f(com.tencent.luggage.wxa.q.e eVar) {
        eVar.c(this.f139034g);
        this.f139034g = 0;
        this.f139033f = 3;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        eVar.b(this.f139028a.f135088a, 0, 3);
        this.f139028a.e(0);
        if (this.f139028a.t() != f139027o) {
            return false;
        }
        eVar.b(this.f139028a.f135088a, 0, 2);
        this.f139028a.e(0);
        if ((this.f139028a.w() & 250) != 0) {
            return false;
        }
        eVar.b(this.f139028a.f135088a, 0, 4);
        this.f139028a.e(0);
        int f16 = this.f139028a.f();
        eVar.a();
        eVar.a(f16);
        eVar.b(this.f139028a.f135088a, 0, 4);
        this.f139028a.e(0);
        return this.f139028a.f() == 0;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(f fVar) {
        this.f139032e = fVar;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long c() {
        return this.f139040m.a();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.f139033f = 1;
        this.f139034g = 0;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, j jVar) {
        while (true) {
            int i3 = this.f139033f;
            if (i3 != 1) {
                if (i3 == 2) {
                    f(eVar);
                } else if (i3 != 3) {
                    if (i3 == 4 && d(eVar)) {
                        return 0;
                    }
                } else if (!e(eVar)) {
                    return -1;
                }
            } else if (!c(eVar)) {
                return -1;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }
}
