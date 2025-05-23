package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gv implements hq<gv, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f389195a;

    /* renamed from: a, reason: collision with other field name */
    public long f24777a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24778a;

    /* renamed from: a, reason: collision with other field name */
    public hi f24779a;

    /* renamed from: a, reason: collision with other field name */
    public String f24780a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f24782a;

    /* renamed from: a, reason: collision with other field name */
    public short f24783a;

    /* renamed from: b, reason: collision with root package name */
    public String f389196b;

    /* renamed from: b, reason: collision with other field name */
    public short f24785b;

    /* renamed from: c, reason: collision with root package name */
    public String f389197c;

    /* renamed from: d, reason: collision with root package name */
    public String f389198d;

    /* renamed from: e, reason: collision with root package name */
    public String f389199e;

    /* renamed from: f, reason: collision with root package name */
    public String f389200f;

    /* renamed from: g, reason: collision with root package name */
    public String f389201g;

    /* renamed from: h, reason: collision with root package name */
    public String f389202h;

    /* renamed from: i, reason: collision with root package name */
    public String f389203i;

    /* renamed from: j, reason: collision with root package name */
    public String f389204j;

    /* renamed from: k, reason: collision with root package name */
    public String f389205k;

    /* renamed from: l, reason: collision with root package name */
    public String f389206l;

    /* renamed from: m, reason: collision with root package name */
    private static final hs f389194m = new hs("XmPushActionAckMessage");
    private static final ga C = new ga("", (byte) 11, 1);
    private static final ga D = new ga("", (byte) 12, 2);
    private static final ga E = new ga("", (byte) 11, 3);
    private static final ga F = new ga("", (byte) 11, 4);
    private static final ga G = new ga("", (byte) 10, 5);
    private static final ga H = new ga("", (byte) 11, 6);
    private static final ga I = new ga("", (byte) 11, 7);
    private static final ga J = new ga("", (byte) 12, 8);
    private static final ga K = new ga("", (byte) 11, 9);
    private static final ga L = new ga("", (byte) 11, 10);
    private static final ga M = new ga("", (byte) 2, 11);
    private static final ga N = new ga("", (byte) 11, 12);
    private static final ga P = new ga("", (byte) 11, 13);
    private static final ga Q = new ga("", (byte) 11, 14);
    private static final ga R = new ga("", (byte) 6, 15);
    private static final ga S = new ga("", (byte) 6, 16);
    private static final ga T = new ga("", (byte) 11, 20);
    private static final ga U = new ga("", (byte) 11, 21);
    private static final ga V = new ga("", (byte) 8, 22);
    private static final ga W = new ga("", (byte) 13, 23);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24781a = new BitSet(5);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24784a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m354a() {
        return this.f24780a != null;
    }

    public boolean b() {
        return this.f24778a != null;
    }

    public boolean c() {
        return this.f389196b != null;
    }

    public boolean d() {
        return this.f389197c != null;
    }

    public boolean e() {
        return this.f24781a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gv)) {
            return false;
        }
        return m355a((gv) obj);
    }

    public boolean f() {
        if (this.f389198d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389199e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f24779a != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389200f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f389201g != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return this.f24781a.get(1);
    }

    public boolean l() {
        if (this.f389202h != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f389203i != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.f389204j != null) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return this.f24781a.get(2);
    }

    public boolean p() {
        return this.f24781a.get(3);
    }

    public boolean q() {
        if (this.f389205k != null) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.f389206l != null) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f24781a.get(4);
    }

    public boolean t() {
        if (this.f24782a != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionAckMessage(");
        boolean z17 = false;
        if (m354a()) {
            sb5.append("debug:");
            String str = this.f24780a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24778a;
            if (guVar == null) {
                sb5.append("null");
            } else {
                sb5.append(guVar);
            }
        } else {
            z17 = z16;
        }
        if (!z17) {
            sb5.append(", ");
        }
        sb5.append("id:");
        String str2 = this.f389196b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f389197c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        sb5.append(", ");
        sb5.append("messageTs:");
        sb5.append(this.f24777a);
        if (f()) {
            sb5.append(", ");
            sb5.append("topic:");
            String str4 = this.f389198d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("aliasName:");
            String str5 = this.f389199e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("request:");
            hi hiVar = this.f24779a;
            if (hiVar == null) {
                sb5.append("null");
            } else {
                sb5.append(hiVar);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str6 = this.f389200f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("category:");
            String str7 = this.f389201g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("isOnline:");
            sb5.append(this.f24784a);
        }
        if (l()) {
            sb5.append(", ");
            sb5.append("regId:");
            String str8 = this.f389202h;
            if (str8 == null) {
                sb5.append("null");
            } else {
                sb5.append(str8);
            }
        }
        if (m()) {
            sb5.append(", ");
            sb5.append("callbackUrl:");
            String str9 = this.f389203i;
            if (str9 == null) {
                sb5.append("null");
            } else {
                sb5.append(str9);
            }
        }
        if (n()) {
            sb5.append(", ");
            sb5.append("userAccount:");
            String str10 = this.f389204j;
            if (str10 == null) {
                sb5.append("null");
            } else {
                sb5.append(str10);
            }
        }
        if (o()) {
            sb5.append(", ");
            sb5.append("deviceStatus:");
            sb5.append((int) this.f24783a);
        }
        if (p()) {
            sb5.append(", ");
            sb5.append("geoMsgStatus:");
            sb5.append((int) this.f24785b);
        }
        if (q()) {
            sb5.append(", ");
            sb5.append("imeiMd5:");
            String str11 = this.f389205k;
            if (str11 == null) {
                sb5.append("null");
            } else {
                sb5.append(str11);
            }
        }
        if (r()) {
            sb5.append(", ");
            sb5.append("deviceId:");
            String str12 = this.f389206l;
            if (str12 == null) {
                sb5.append("null");
            } else {
                sb5.append(str12);
            }
        }
        if (s()) {
            sb5.append(", ");
            sb5.append("passThrough:");
            sb5.append(this.f389195a);
        }
        if (t()) {
            sb5.append(", ");
            sb5.append("extra:");
            Map<String, String> map = this.f24782a;
            if (map == null) {
                sb5.append("null");
            } else {
                sb5.append(map);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public gv a(String str) {
        this.f389196b = str;
        return this;
    }

    public gv b(String str) {
        this.f389197c = str;
        return this;
    }

    public gv c(String str) {
        this.f389198d = str;
        return this;
    }

    public gv d(String str) {
        this.f389199e = str;
        return this;
    }

    public void e(boolean z16) {
        this.f24781a.set(4, z16);
    }

    public gv a(long j3) {
        this.f24777a = j3;
        a(true);
        return this;
    }

    public void b(boolean z16) {
        this.f24781a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24781a.set(2, z16);
    }

    public void d(boolean z16) {
        this.f24781a.set(3, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f389194m);
        if (this.f24780a != null && m354a()) {
            hnVar.q(C);
            hnVar.u(this.f24780a);
            hnVar.z();
        }
        if (this.f24778a != null && b()) {
            hnVar.q(D);
            this.f24778a.b(hnVar);
            hnVar.z();
        }
        if (this.f389196b != null) {
            hnVar.q(E);
            hnVar.u(this.f389196b);
            hnVar.z();
        }
        if (this.f389197c != null) {
            hnVar.q(F);
            hnVar.u(this.f389197c);
            hnVar.z();
        }
        hnVar.q(G);
        hnVar.p(this.f24777a);
        hnVar.z();
        if (this.f389198d != null && f()) {
            hnVar.q(H);
            hnVar.u(this.f389198d);
            hnVar.z();
        }
        if (this.f389199e != null && g()) {
            hnVar.q(I);
            hnVar.u(this.f389199e);
            hnVar.z();
        }
        if (this.f24779a != null && h()) {
            hnVar.q(J);
            this.f24779a.b(hnVar);
            hnVar.z();
        }
        if (this.f389200f != null && i()) {
            hnVar.q(K);
            hnVar.u(this.f389200f);
            hnVar.z();
        }
        if (this.f389201g != null && j()) {
            hnVar.q(L);
            hnVar.u(this.f389201g);
            hnVar.z();
        }
        if (k()) {
            hnVar.q(M);
            hnVar.x(this.f24784a);
            hnVar.z();
        }
        if (this.f389202h != null && l()) {
            hnVar.q(N);
            hnVar.u(this.f389202h);
            hnVar.z();
        }
        if (this.f389203i != null && m()) {
            hnVar.q(P);
            hnVar.u(this.f389203i);
            hnVar.z();
        }
        if (this.f389204j != null && n()) {
            hnVar.q(Q);
            hnVar.u(this.f389204j);
            hnVar.z();
        }
        if (o()) {
            hnVar.q(R);
            hnVar.w(this.f24783a);
            hnVar.z();
        }
        if (p()) {
            hnVar.q(S);
            hnVar.w(this.f24785b);
            hnVar.z();
        }
        if (this.f389205k != null && q()) {
            hnVar.q(T);
            hnVar.u(this.f389205k);
            hnVar.z();
        }
        if (this.f389206l != null && r()) {
            hnVar.q(U);
            hnVar.u(this.f389206l);
            hnVar.z();
        }
        if (s()) {
            hnVar.q(V);
            hnVar.o(this.f389195a);
            hnVar.z();
        }
        if (this.f24782a != null && t()) {
            hnVar.q(W);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24782a.size()));
            for (Map.Entry<String, String> entry : this.f24782a.entrySet()) {
                hnVar.u(entry.getKey());
                hnVar.u(entry.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public void a(boolean z16) {
        this.f24781a.set(0, z16);
    }

    public gv a(short s16) {
        this.f24783a = s16;
        c(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m355a(gv gvVar) {
        if (gvVar == null) {
            return false;
        }
        boolean m354a = m354a();
        boolean m354a2 = gvVar.m354a();
        if ((m354a || m354a2) && !(m354a && m354a2 && this.f24780a.equals(gvVar.f24780a))) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = gvVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24778a.m353a(gvVar.f24778a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = gvVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f389196b.equals(gvVar.f389196b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = gvVar.d();
        if (((d16 || d17) && !(d16 && d17 && this.f389197c.equals(gvVar.f389197c))) || this.f24777a != gvVar.f24777a) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = gvVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389198d.equals(gvVar.f389198d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = gvVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389199e.equals(gvVar.f389199e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = gvVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f24779a.m417a(gvVar.f24779a))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = gvVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389200f.equals(gvVar.f389200f))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = gvVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f389201g.equals(gvVar.f389201g))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = gvVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f24784a == gvVar.f24784a)) {
            return false;
        }
        boolean l3 = l();
        boolean l16 = gvVar.l();
        if ((l3 || l16) && !(l3 && l16 && this.f389202h.equals(gvVar.f389202h))) {
            return false;
        }
        boolean m3 = m();
        boolean m16 = gvVar.m();
        if ((m3 || m16) && !(m3 && m16 && this.f389203i.equals(gvVar.f389203i))) {
            return false;
        }
        boolean n3 = n();
        boolean n16 = gvVar.n();
        if ((n3 || n16) && !(n3 && n16 && this.f389204j.equals(gvVar.f389204j))) {
            return false;
        }
        boolean o16 = o();
        boolean o17 = gvVar.o();
        if ((o16 || o17) && !(o16 && o17 && this.f24783a == gvVar.f24783a)) {
            return false;
        }
        boolean p16 = p();
        boolean p17 = gvVar.p();
        if ((p16 || p17) && !(p16 && p17 && this.f24785b == gvVar.f24785b)) {
            return false;
        }
        boolean q16 = q();
        boolean q17 = gvVar.q();
        if ((q16 || q17) && !(q16 && q17 && this.f389205k.equals(gvVar.f389205k))) {
            return false;
        }
        boolean r16 = r();
        boolean r17 = gvVar.r();
        if ((r16 || r17) && !(r16 && r17 && this.f389206l.equals(gvVar.f389206l))) {
            return false;
        }
        boolean s16 = s();
        boolean s17 = gvVar.s();
        if ((s16 || s17) && !(s16 && s17 && this.f389195a == gvVar.f389195a)) {
            return false;
        }
        boolean t16 = t();
        boolean t17 = gvVar.t();
        if (t16 || t17) {
            return t16 && t17 && this.f24782a.equals(gvVar.f24782a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gv gvVar) {
        int h16;
        int b16;
        int e16;
        int e17;
        int j3;
        int j16;
        int e18;
        int e19;
        int e26;
        int k3;
        int e27;
        int e28;
        int d16;
        int e29;
        int e36;
        int c16;
        int e37;
        int e38;
        int d17;
        int e39;
        if (!getClass().equals(gvVar.getClass())) {
            return getClass().getName().compareTo(gvVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m354a()).compareTo(Boolean.valueOf(gvVar.m354a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m354a() && (e39 = fw.e(this.f24780a, gvVar.f24780a)) != 0) {
            return e39;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gvVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d17 = fw.d(this.f24778a, gvVar.f24778a)) != 0) {
            return d17;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e38 = fw.e(this.f389196b, gvVar.f389196b)) != 0) {
            return e38;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gvVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e37 = fw.e(this.f389197c, gvVar.f389197c)) != 0) {
            return e37;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c16 = fw.c(this.f24777a, gvVar.f24777a)) != 0) {
            return c16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gvVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e36 = fw.e(this.f389198d, gvVar.f389198d)) != 0) {
            return e36;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gvVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e29 = fw.e(this.f389199e, gvVar.f389199e)) != 0) {
            return e29;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gvVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (d16 = fw.d(this.f24779a, gvVar.f24779a)) != 0) {
            return d16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gvVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e28 = fw.e(this.f389200f, gvVar.f389200f)) != 0) {
            return e28;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gvVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e27 = fw.e(this.f389201g, gvVar.f389201g)) != 0) {
            return e27;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gvVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (k3 = fw.k(this.f24784a, gvVar.f24784a)) != 0) {
            return k3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gvVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e26 = fw.e(this.f389202h, gvVar.f389202h)) != 0) {
            return e26;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gvVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (e19 = fw.e(this.f389203i, gvVar.f389203i)) != 0) {
            return e19;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gvVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (e18 = fw.e(this.f389204j, gvVar.f389204j)) != 0) {
            return e18;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gvVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (j16 = fw.j(this.f24783a, gvVar.f24783a)) != 0) {
            return j16;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gvVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (j3 = fw.j(this.f24785b, gvVar.f24785b)) != 0) {
            return j3;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gvVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (e17 = fw.e(this.f389205k, gvVar.f389205k)) != 0) {
            return e17;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gvVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (e16 = fw.e(this.f389206l, gvVar.f389206l)) != 0) {
            return e16;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(gvVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (b16 = fw.b(this.f389195a, gvVar.f389195a)) != 0) {
            return b16;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gvVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (h16 = fw.h(this.f24782a, gvVar.f24782a)) == 0) {
            return 0;
        }
        return h16;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                hnVar.D();
                if (e()) {
                    a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24780a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24778a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389196b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389197c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 10) {
                        this.f24777a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 11) {
                        this.f389198d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389199e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 12) {
                        hi hiVar = new hi();
                        this.f24779a = hiVar;
                        hiVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389200f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389201g = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 2) {
                        this.f24784a = hnVar.y();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 11) {
                        this.f389202h = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 13:
                    if (b16 == 11) {
                        this.f389203i = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 14:
                    if (b16 == 11) {
                        this.f389204j = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 15:
                    if (b16 == 6) {
                        this.f24783a = hnVar.l();
                        c(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 16:
                    if (b16 == 6) {
                        this.f24785b = hnVar.l();
                        d(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    hp.a(hnVar, b16);
                    break;
                case 20:
                    if (b16 == 11) {
                        this.f389205k = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 21:
                    if (b16 == 11) {
                        this.f389206l = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 22:
                    if (b16 == 8) {
                        this.f389195a = hnVar.c();
                        e(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 23:
                    if (b16 == 13) {
                        gd g16 = hnVar.g();
                        this.f24782a = new HashMap(g16.f388950c * 2);
                        for (int i3 = 0; i3 < g16.f388950c; i3++) {
                            this.f24782a.put(hnVar.j(), hnVar.j());
                        }
                        hnVar.F();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
            }
            hnVar.E();
        }
    }

    public void a() {
        if (this.f389196b != null) {
            if (this.f389197c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
