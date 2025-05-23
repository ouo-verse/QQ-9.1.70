package com.tencent.luggage.wxa.m;

import android.util.Pair;
import com.tencent.luggage.wxa.d0.h;
import com.tencent.luggage.wxa.m.h;
import com.tencent.luggage.wxa.m.u;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final u.b f133908a = new u.b();

    /* renamed from: b, reason: collision with root package name */
    public final u.c f133909b = new u.c();

    /* renamed from: c, reason: collision with root package name */
    public u f133910c;

    /* renamed from: d, reason: collision with root package name */
    public int f133911d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final h.b f133912a;

        /* renamed from: b, reason: collision with root package name */
        public final long f133913b;

        /* renamed from: c, reason: collision with root package name */
        public final long f133914c;

        /* renamed from: d, reason: collision with root package name */
        public final long f133915d;

        /* renamed from: e, reason: collision with root package name */
        public final long f133916e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f133917f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f133918g;

        public b a(int i3) {
            return new b(this.f133912a.a(i3), this.f133913b, this.f133914c, this.f133915d, this.f133916e, this.f133917f, this.f133918g);
        }

        public b(h.b bVar, long j3, long j16, long j17, long j18, boolean z16, boolean z17) {
            this.f133912a = bVar;
            this.f133913b = j3;
            this.f133914c = j16;
            this.f133915d = j17;
            this.f133916e = j18;
            this.f133917f = z16;
            this.f133918g = z17;
        }

        public b a(long j3) {
            return new b(this.f133912a, j3, this.f133914c, this.f133915d, this.f133916e, this.f133917f, this.f133918g);
        }
    }

    public void a(u uVar) {
        this.f133910c = uVar;
    }

    public void a(int i3) {
        this.f133911d = i3;
    }

    public b a(h.b bVar) {
        return a(bVar.f133877a, bVar.f133879c, bVar.f133878b);
    }

    public b a(b bVar, long j3, long j16) {
        if (bVar.f133917f) {
            int a16 = this.f133910c.a(bVar.f133912a.f123995a, this.f133908a, this.f133909b, this.f133911d);
            if (a16 == -1) {
                return null;
            }
            int i3 = this.f133910c.a(a16, this.f133908a).f133928c;
            long j17 = 0;
            if (this.f133910c.a(i3, this.f133909b).f133942f == a16) {
                Pair a17 = this.f133910c.a(this.f133909b, this.f133908a, i3, -9223372036854775807L, Math.max(0L, (j3 + bVar.f133916e) - j16));
                if (a17 == null) {
                    return null;
                }
                a16 = ((Integer) a17.first).intValue();
                j17 = ((Long) a17.second).longValue();
            }
            return a(a(a16, j17), j17, j17);
        }
        h.b bVar2 = bVar.f133912a;
        if (bVar2.a()) {
            int i16 = bVar2.f123996b;
            this.f133910c.a(bVar2.f123995a, this.f133908a);
            int a18 = this.f133908a.a(i16);
            if (a18 == -1) {
                return null;
            }
            int i17 = bVar2.f123997c + 1;
            if (i17 < a18) {
                if (this.f133908a.b(i16, i17)) {
                    return a(bVar2.f123995a, i16, i17, bVar.f133915d);
                }
                return null;
            }
            int a19 = this.f133908a.a(bVar.f133915d);
            return a(bVar2.f123995a, bVar.f133915d, a19 == -1 ? Long.MIN_VALUE : this.f133908a.b(a19));
        }
        long j18 = bVar.f133914c;
        if (j18 != Long.MIN_VALUE) {
            int b16 = this.f133908a.b(j18);
            if (this.f133908a.b(b16, 0)) {
                return a(bVar2.f123995a, b16, 0, bVar.f133914c);
            }
            return null;
        }
        int a26 = this.f133908a.a();
        if (a26 != 0) {
            int i18 = a26 - 1;
            if (this.f133908a.b(i18) == Long.MIN_VALUE && !this.f133908a.d(i18) && this.f133908a.b(i18, 0)) {
                return a(bVar2.f123995a, i18, 0, this.f133908a.d());
            }
        }
        return null;
    }

    public h.b a(int i3, long j3) {
        this.f133910c.a(i3, this.f133908a);
        int b16 = this.f133908a.b(j3);
        if (b16 == -1) {
            return new h.b(i3);
        }
        return new h.b(i3, b16, this.f133908a.c(b16));
    }

    public b a(b bVar) {
        return a(bVar, bVar.f133912a);
    }

    public b a(b bVar, int i3) {
        return a(bVar, bVar.f133912a.a(i3));
    }

    public final b a(b bVar, h.b bVar2) {
        long j3;
        long d16;
        long j16 = bVar.f133913b;
        long j17 = bVar.f133914c;
        boolean a16 = a(bVar2, j17);
        boolean a17 = a(bVar2, a16);
        this.f133910c.a(bVar2.f123995a, this.f133908a);
        if (bVar2.a()) {
            d16 = this.f133908a.a(bVar2.f123996b, bVar2.f123997c);
        } else if (j17 == Long.MIN_VALUE) {
            d16 = this.f133908a.d();
        } else {
            j3 = j17;
            return new b(bVar2, j16, j17, bVar.f133915d, j3, a16, a17);
        }
        j3 = d16;
        return new b(bVar2, j16, j17, bVar.f133915d, j3, a16, a17);
    }

    public final b a(h.b bVar, long j3, long j16) {
        this.f133910c.a(bVar.f123995a, this.f133908a);
        if (bVar.a()) {
            if (this.f133908a.b(bVar.f123996b, bVar.f123997c)) {
                return a(bVar.f123995a, bVar.f123996b, bVar.f123997c, j3);
            }
            return null;
        }
        int a16 = this.f133908a.a(j16);
        return a(bVar.f123995a, j16, a16 == -1 ? Long.MIN_VALUE : this.f133908a.b(a16));
    }

    public final b a(int i3, int i16, int i17, long j3) {
        h.b bVar = new h.b(i3, i16, i17);
        boolean a16 = a(bVar, Long.MIN_VALUE);
        boolean a17 = a(bVar, a16);
        return new b(bVar, i17 == this.f133908a.c(i16) ? this.f133908a.b() : 0L, Long.MIN_VALUE, j3, this.f133910c.a(bVar.f123995a, this.f133908a).a(bVar.f123996b, bVar.f123997c), a16, a17);
    }

    public final b a(int i3, long j3, long j16) {
        h.b bVar = new h.b(i3);
        boolean a16 = a(bVar, j16);
        boolean a17 = a(bVar, a16);
        this.f133910c.a(bVar.f123995a, this.f133908a);
        return new b(bVar, j3, j16, -9223372036854775807L, j16 == Long.MIN_VALUE ? this.f133908a.d() : j16, a16, a17);
    }

    public final boolean a(h.b bVar, long j3) {
        int a16 = this.f133910c.a(bVar.f123995a, this.f133908a).a();
        if (a16 == 0) {
            return true;
        }
        int i3 = a16 - 1;
        boolean a17 = bVar.a();
        if (this.f133908a.b(i3) != Long.MIN_VALUE) {
            return !a17 && j3 == Long.MIN_VALUE;
        }
        int a18 = this.f133908a.a(i3);
        if (a18 == -1) {
            return false;
        }
        if (a17 && bVar.f123996b == i3 && bVar.f123997c == a18 + (-1)) {
            return true;
        }
        return !a17 && this.f133908a.c(i3) == a18;
    }

    public final boolean a(h.b bVar, boolean z16) {
        return !this.f133910c.a(this.f133910c.a(bVar.f123995a, this.f133908a).f133928c, this.f133909b).f133941e && this.f133910c.b(bVar.f123995a, this.f133908a, this.f133909b, this.f133911d) && z16;
    }
}
