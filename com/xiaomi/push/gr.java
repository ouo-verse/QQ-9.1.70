package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gr implements hq<gr, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389161a;

    /* renamed from: a, reason: collision with other field name */
    public gs f24756a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24757a;

    /* renamed from: a, reason: collision with other field name */
    public String f24758a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24759a = new BitSet(4);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24760a = false;

    /* renamed from: b, reason: collision with root package name */
    public long f389162b;

    /* renamed from: b, reason: collision with other field name */
    public String f24761b;

    /* renamed from: c, reason: collision with root package name */
    public long f389163c;

    /* renamed from: c, reason: collision with other field name */
    public String f24762c;

    /* renamed from: d, reason: collision with root package name */
    public String f389164d;

    /* renamed from: e, reason: collision with root package name */
    public String f389165e;

    /* renamed from: f, reason: collision with root package name */
    public String f389166f;

    /* renamed from: g, reason: collision with root package name */
    public String f389167g;

    /* renamed from: h, reason: collision with root package name */
    public String f389168h;

    /* renamed from: i, reason: collision with root package name */
    public String f389169i;

    /* renamed from: j, reason: collision with root package name */
    public String f389170j;

    /* renamed from: k, reason: collision with root package name */
    public String f389171k;

    /* renamed from: l, reason: collision with root package name */
    public String f389172l;

    /* renamed from: m, reason: collision with root package name */
    private static final hs f389160m = new hs("PushMessage");
    private static final ga C = new ga("", (byte) 12, 1);
    private static final ga D = new ga("", (byte) 11, 2);
    private static final ga E = new ga("", (byte) 11, 3);
    private static final ga F = new ga("", (byte) 11, 4);
    private static final ga G = new ga("", (byte) 10, 5);
    private static final ga H = new ga("", (byte) 10, 6);
    private static final ga I = new ga("", (byte) 11, 7);
    private static final ga J = new ga("", (byte) 11, 8);
    private static final ga K = new ga("", (byte) 11, 9);
    private static final ga L = new ga("", (byte) 11, 10);
    private static final ga M = new ga("", (byte) 11, 11);
    private static final ga N = new ga("", (byte) 12, 12);
    private static final ga P = new ga("", (byte) 11, 13);
    private static final ga Q = new ga("", (byte) 2, 14);
    private static final ga R = new ga("", (byte) 11, 15);
    private static final ga S = new ga("", (byte) 10, 16);
    private static final ga T = new ga("", (byte) 11, 20);
    private static final ga U = new ga("", (byte) 11, 21);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m335a() {
        return this.f24757a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m337b() {
        return this.f24758a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m338c() {
        return this.f24761b != null;
    }

    public boolean d() {
        return this.f24762c != null;
    }

    public boolean e() {
        return this.f24759a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gr)) {
            return false;
        }
        return m336a((gr) obj);
    }

    public boolean f() {
        return this.f24759a.get(1);
    }

    public boolean g() {
        if (this.f389164d != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f389165e != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389166f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f389167g != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f389168h != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f24756a != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f389169i != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.f24759a.get(2);
    }

    public boolean o() {
        if (this.f389170j != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.f24759a.get(3);
    }

    public boolean q() {
        if (this.f389171k != null) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.f389172l != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("PushMessage(");
        if (m335a()) {
            sb5.append("to:");
            gu guVar = this.f24757a;
            if (guVar == null) {
                sb5.append("null");
            } else {
                sb5.append(guVar);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            sb5.append(", ");
        }
        sb5.append("id:");
        String str = this.f24758a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(str);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str2 = this.f24761b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("payload:");
        String str3 = this.f24762c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("createAt:");
            sb5.append(this.f389161a);
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("ttl:");
            sb5.append(this.f389162b);
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("collapseKey:");
            String str4 = this.f389164d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str5 = this.f389165e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("regId:");
            String str6 = this.f389166f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("category:");
            String str7 = this.f389167g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("topic:");
            String str8 = this.f389168h;
            if (str8 == null) {
                sb5.append("null");
            } else {
                sb5.append(str8);
            }
        }
        if (l()) {
            sb5.append(", ");
            sb5.append("metaInfo:");
            gs gsVar = this.f24756a;
            if (gsVar == null) {
                sb5.append("null");
            } else {
                sb5.append(gsVar);
            }
        }
        if (m()) {
            sb5.append(", ");
            sb5.append("aliasName:");
            String str9 = this.f389169i;
            if (str9 == null) {
                sb5.append("null");
            } else {
                sb5.append(str9);
            }
        }
        if (n()) {
            sb5.append(", ");
            sb5.append("isOnline:");
            sb5.append(this.f24760a);
        }
        if (o()) {
            sb5.append(", ");
            sb5.append("userAccount:");
            String str10 = this.f389170j;
            if (str10 == null) {
                sb5.append("null");
            } else {
                sb5.append(str10);
            }
        }
        if (p()) {
            sb5.append(", ");
            sb5.append("miid:");
            sb5.append(this.f389163c);
        }
        if (q()) {
            sb5.append(", ");
            sb5.append("imeiMd5:");
            String str11 = this.f389171k;
            if (str11 == null) {
                sb5.append("null");
            } else {
                sb5.append(str11);
            }
        }
        if (r()) {
            sb5.append(", ");
            sb5.append("deviceId:");
            String str12 = this.f389172l;
            if (str12 == null) {
                sb5.append("null");
            } else {
                sb5.append(str12);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m333a() {
        return this.f24758a;
    }

    public String b() {
        return this.f24761b;
    }

    public String c() {
        return this.f24762c;
    }

    public void d(boolean z16) {
        this.f24759a.set(3, z16);
    }

    public long a() {
        return this.f389161a;
    }

    public void b(boolean z16) {
        this.f24759a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24759a.set(2, z16);
    }

    public void a(boolean z16) {
        this.f24759a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m334a();
        hnVar.t(f389160m);
        if (this.f24757a != null && m335a()) {
            hnVar.q(C);
            this.f24757a.b(hnVar);
            hnVar.z();
        }
        if (this.f24758a != null) {
            hnVar.q(D);
            hnVar.u(this.f24758a);
            hnVar.z();
        }
        if (this.f24761b != null) {
            hnVar.q(E);
            hnVar.u(this.f24761b);
            hnVar.z();
        }
        if (this.f24762c != null) {
            hnVar.q(F);
            hnVar.u(this.f24762c);
            hnVar.z();
        }
        if (e()) {
            hnVar.q(G);
            hnVar.p(this.f389161a);
            hnVar.z();
        }
        if (f()) {
            hnVar.q(H);
            hnVar.p(this.f389162b);
            hnVar.z();
        }
        if (this.f389164d != null && g()) {
            hnVar.q(I);
            hnVar.u(this.f389164d);
            hnVar.z();
        }
        if (this.f389165e != null && h()) {
            hnVar.q(J);
            hnVar.u(this.f389165e);
            hnVar.z();
        }
        if (this.f389166f != null && i()) {
            hnVar.q(K);
            hnVar.u(this.f389166f);
            hnVar.z();
        }
        if (this.f389167g != null && j()) {
            hnVar.q(L);
            hnVar.u(this.f389167g);
            hnVar.z();
        }
        if (this.f389168h != null && k()) {
            hnVar.q(M);
            hnVar.u(this.f389168h);
            hnVar.z();
        }
        if (this.f24756a != null && l()) {
            hnVar.q(N);
            this.f24756a.b(hnVar);
            hnVar.z();
        }
        if (this.f389169i != null && m()) {
            hnVar.q(P);
            hnVar.u(this.f389169i);
            hnVar.z();
        }
        if (n()) {
            hnVar.q(Q);
            hnVar.x(this.f24760a);
            hnVar.z();
        }
        if (this.f389170j != null && o()) {
            hnVar.q(R);
            hnVar.u(this.f389170j);
            hnVar.z();
        }
        if (p()) {
            hnVar.q(S);
            hnVar.p(this.f389163c);
            hnVar.z();
        }
        if (this.f389171k != null && q()) {
            hnVar.q(T);
            hnVar.u(this.f389171k);
            hnVar.z();
        }
        if (this.f389172l != null && r()) {
            hnVar.q(U);
            hnVar.u(this.f389172l);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m336a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        boolean m335a = m335a();
        boolean m335a2 = grVar.m335a();
        if ((m335a || m335a2) && !(m335a && m335a2 && this.f24757a.m353a(grVar.f24757a))) {
            return false;
        }
        boolean m337b = m337b();
        boolean m337b2 = grVar.m337b();
        if ((m337b || m337b2) && !(m337b && m337b2 && this.f24758a.equals(grVar.f24758a))) {
            return false;
        }
        boolean m338c = m338c();
        boolean m338c2 = grVar.m338c();
        if ((m338c || m338c2) && !(m338c && m338c2 && this.f24761b.equals(grVar.f24761b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = grVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f24762c.equals(grVar.f24762c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = grVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389161a == grVar.f389161a)) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = grVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389162b == grVar.f389162b)) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = grVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389164d.equals(grVar.f389164d))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = grVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389165e.equals(grVar.f389165e))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = grVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389166f.equals(grVar.f389166f))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = grVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f389167g.equals(grVar.f389167g))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = grVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f389168h.equals(grVar.f389168h))) {
            return false;
        }
        boolean l3 = l();
        boolean l16 = grVar.l();
        if ((l3 || l16) && !(l3 && l16 && this.f24756a.m345a(grVar.f24756a))) {
            return false;
        }
        boolean m3 = m();
        boolean m16 = grVar.m();
        if ((m3 || m16) && !(m3 && m16 && this.f389169i.equals(grVar.f389169i))) {
            return false;
        }
        boolean n3 = n();
        boolean n16 = grVar.n();
        if ((n3 || n16) && !(n3 && n16 && this.f24760a == grVar.f24760a)) {
            return false;
        }
        boolean o16 = o();
        boolean o17 = grVar.o();
        if ((o16 || o17) && !(o16 && o17 && this.f389170j.equals(grVar.f389170j))) {
            return false;
        }
        boolean p16 = p();
        boolean p17 = grVar.p();
        if ((p16 || p17) && !(p16 && p17 && this.f389163c == grVar.f389163c)) {
            return false;
        }
        boolean q16 = q();
        boolean q17 = grVar.q();
        if ((q16 || q17) && !(q16 && q17 && this.f389171k.equals(grVar.f389171k))) {
            return false;
        }
        boolean r16 = r();
        boolean r17 = grVar.r();
        if (r16 || r17) {
            return r16 && r17 && this.f389172l.equals(grVar.f389172l);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gr grVar) {
        int e16;
        int e17;
        int c16;
        int e18;
        int k3;
        int e19;
        int d16;
        int e26;
        int e27;
        int e28;
        int e29;
        int e36;
        int c17;
        int c18;
        int e37;
        int e38;
        int e39;
        int d17;
        if (!getClass().equals(grVar.getClass())) {
            return getClass().getName().compareTo(grVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m335a()).compareTo(Boolean.valueOf(grVar.m335a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m335a() && (d17 = fw.d(this.f24757a, grVar.f24757a)) != 0) {
            return d17;
        }
        int compareTo2 = Boolean.valueOf(m337b()).compareTo(Boolean.valueOf(grVar.m337b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m337b() && (e39 = fw.e(this.f24758a, grVar.f24758a)) != 0) {
            return e39;
        }
        int compareTo3 = Boolean.valueOf(m338c()).compareTo(Boolean.valueOf(grVar.m338c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m338c() && (e38 = fw.e(this.f24761b, grVar.f24761b)) != 0) {
            return e38;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(grVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e37 = fw.e(this.f24762c, grVar.f24762c)) != 0) {
            return e37;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c18 = fw.c(this.f389161a, grVar.f389161a)) != 0) {
            return c18;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(grVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (c17 = fw.c(this.f389162b, grVar.f389162b)) != 0) {
            return c17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(grVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e36 = fw.e(this.f389164d, grVar.f389164d)) != 0) {
            return e36;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(grVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e29 = fw.e(this.f389165e, grVar.f389165e)) != 0) {
            return e29;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(grVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e28 = fw.e(this.f389166f, grVar.f389166f)) != 0) {
            return e28;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(grVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e27 = fw.e(this.f389167g, grVar.f389167g)) != 0) {
            return e27;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(grVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e26 = fw.e(this.f389168h, grVar.f389168h)) != 0) {
            return e26;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(grVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (d16 = fw.d(this.f24756a, grVar.f24756a)) != 0) {
            return d16;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(grVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (e19 = fw.e(this.f389169i, grVar.f389169i)) != 0) {
            return e19;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(grVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (k3 = fw.k(this.f24760a, grVar.f24760a)) != 0) {
            return k3;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(grVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (e18 = fw.e(this.f389170j, grVar.f389170j)) != 0) {
            return e18;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(grVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (c16 = fw.c(this.f389163c, grVar.f389163c)) != 0) {
            return c16;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(grVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (e17 = fw.e(this.f389171k, grVar.f389171k)) != 0) {
            return e17;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(grVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (e16 = fw.e(this.f389172l, grVar.f389172l)) == 0) {
            return 0;
        }
        return e16;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                hnVar.D();
                m334a();
                return;
            }
            short s16 = e16.f388942c;
            if (s16 != 20) {
                if (s16 != 21) {
                    switch (s16) {
                        case 1:
                            if (b16 == 12) {
                                gu guVar = new gu();
                                this.f24757a = guVar;
                                guVar.a(hnVar);
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 2:
                            if (b16 == 11) {
                                this.f24758a = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 3:
                            if (b16 == 11) {
                                this.f24761b = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 4:
                            if (b16 == 11) {
                                this.f24762c = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 5:
                            if (b16 == 10) {
                                this.f389161a = hnVar.d();
                                a(true);
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 6:
                            if (b16 == 10) {
                                this.f389162b = hnVar.d();
                                b(true);
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 7:
                            if (b16 == 11) {
                                this.f389164d = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 8:
                            if (b16 == 11) {
                                this.f389165e = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 9:
                            if (b16 == 11) {
                                this.f389166f = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 10:
                            if (b16 == 11) {
                                this.f389167g = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 11:
                            if (b16 == 11) {
                                this.f389168h = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 12:
                            if (b16 == 12) {
                                gs gsVar = new gs();
                                this.f24756a = gsVar;
                                gsVar.a(hnVar);
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 13:
                            if (b16 == 11) {
                                this.f389169i = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 14:
                            if (b16 == 2) {
                                this.f24760a = hnVar.y();
                                c(true);
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 15:
                            if (b16 == 11) {
                                this.f389170j = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 16:
                            if (b16 == 10) {
                                this.f389163c = hnVar.d();
                                d(true);
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        default:
                            hp.a(hnVar, b16);
                            break;
                    }
                } else if (b16 == 11) {
                    this.f389172l = hnVar.j();
                } else {
                    hp.a(hnVar, b16);
                }
            } else if (b16 == 11) {
                this.f389171k = hnVar.j();
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m334a() {
        if (this.f24758a != null) {
            if (this.f24761b != null) {
                if (this.f24762c != null) {
                    return;
                }
                throw new ib("Required field 'payload' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
