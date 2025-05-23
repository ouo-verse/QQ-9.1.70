package com.tencent.luggage.wxa.v;

import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.q.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public final d f142887a = new d();

    /* renamed from: b, reason: collision with root package name */
    public l f142888b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.f f142889c;

    /* renamed from: d, reason: collision with root package name */
    public f f142890d;

    /* renamed from: e, reason: collision with root package name */
    public long f142891e;

    /* renamed from: f, reason: collision with root package name */
    public long f142892f;

    /* renamed from: g, reason: collision with root package name */
    public long f142893g;

    /* renamed from: h, reason: collision with root package name */
    public int f142894h;

    /* renamed from: i, reason: collision with root package name */
    public int f142895i;

    /* renamed from: j, reason: collision with root package name */
    public b f142896j;

    /* renamed from: k, reason: collision with root package name */
    public long f142897k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f142898l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f142899m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.m.j f142900a;

        /* renamed from: b, reason: collision with root package name */
        public f f142901b;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements f {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.v.f
        public long a(com.tencent.luggage.wxa.q.e eVar) {
            return -1L;
        }

        @Override // com.tencent.luggage.wxa.v.f
        public com.tencent.luggage.wxa.q.k b() {
            return new k.a(-9223372036854775807L);
        }

        @Override // com.tencent.luggage.wxa.v.f
        public long c(long j3) {
            return 0L;
        }
    }

    public abstract long a(com.tencent.luggage.wxa.n0.l lVar);

    public void a(com.tencent.luggage.wxa.q.f fVar, l lVar) {
        this.f142889c = fVar;
        this.f142888b = lVar;
        a(true);
    }

    public abstract boolean a(com.tencent.luggage.wxa.n0.l lVar, long j3, b bVar);

    public final int b(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        long a16 = this.f142890d.a(eVar);
        if (a16 >= 0) {
            jVar.f137769a = a16;
            return 1;
        }
        if (a16 < -1) {
            c(-(a16 + 2));
        }
        if (!this.f142898l) {
            this.f142889c.a(this.f142890d.b());
            this.f142898l = true;
        }
        if (this.f142897k <= 0 && !this.f142887a.a(eVar)) {
            this.f142894h = 3;
            return -1;
        }
        this.f142897k = 0L;
        com.tencent.luggage.wxa.n0.l b16 = this.f142887a.b();
        long a17 = a(b16);
        if (a17 >= 0) {
            long j3 = this.f142893g;
            if (j3 + a17 >= this.f142891e) {
                long a18 = a(j3);
                this.f142888b.a(b16, b16.d());
                this.f142888b.a(a18, 1, b16.d(), 0, null);
                this.f142891e = -1L;
            }
        }
        this.f142893g += a17;
        return 0;
    }

    public void c(long j3) {
        this.f142893g = j3;
    }

    public void a(boolean z16) {
        if (z16) {
            this.f142896j = new b();
            this.f142892f = 0L;
            this.f142894h = 0;
        } else {
            this.f142894h = 1;
        }
        this.f142891e = -1L;
        this.f142893g = 0L;
    }

    public final void a(long j3, long j16) {
        this.f142887a.c();
        if (j3 == 0) {
            a(!this.f142898l);
        } else if (this.f142894h != 0) {
            this.f142891e = this.f142890d.c(j16);
            this.f142894h = 2;
        }
    }

    public final int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        int i3 = this.f142894h;
        if (i3 == 0) {
            return a(eVar);
        }
        if (i3 != 1) {
            if (i3 == 2) {
                return b(eVar, jVar);
            }
            throw new IllegalStateException();
        }
        eVar.c((int) this.f142892f);
        this.f142894h = 2;
        return 0;
    }

    public long b(long j3) {
        return (this.f142895i * j3) / 1000000;
    }

    public final int a(com.tencent.luggage.wxa.q.e eVar) {
        boolean z16 = true;
        while (z16) {
            if (!this.f142887a.a(eVar)) {
                this.f142894h = 3;
                return -1;
            }
            this.f142897k = eVar.getPosition() - this.f142892f;
            z16 = a(this.f142887a.b(), this.f142892f, this.f142896j);
            if (z16) {
                this.f142892f = eVar.getPosition();
            }
        }
        com.tencent.luggage.wxa.m.j jVar = this.f142896j.f142900a;
        this.f142895i = jVar.H;
        if (!this.f142899m) {
            this.f142888b.a(jVar);
            this.f142899m = true;
        }
        f fVar = this.f142896j.f142901b;
        if (fVar != null) {
            this.f142890d = fVar;
        } else if (eVar.getLength() == -1) {
            this.f142890d = new c();
        } else {
            e a16 = this.f142887a.a();
            this.f142890d = new com.tencent.luggage.wxa.v.a(this.f142892f, eVar.getLength(), this, a16.f142880h + a16.f142881i, a16.f142875c);
        }
        this.f142896j = null;
        this.f142894h = 2;
        this.f142887a.d();
        return 0;
    }

    public long a(long j3) {
        return (j3 * 1000000) / this.f142895i;
    }
}
