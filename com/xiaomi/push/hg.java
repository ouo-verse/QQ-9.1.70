package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hg implements hq<hg, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f389293a;

    /* renamed from: a, reason: collision with other field name */
    public long f24828a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24829a;

    /* renamed from: a, reason: collision with other field name */
    public String f24830a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f24832a;

    /* renamed from: b, reason: collision with root package name */
    public int f389294b;

    /* renamed from: b, reason: collision with other field name */
    public long f24834b;

    /* renamed from: b, reason: collision with other field name */
    public String f24835b;

    /* renamed from: c, reason: collision with root package name */
    public long f389295c;

    /* renamed from: c, reason: collision with other field name */
    public String f24836c;

    /* renamed from: d, reason: collision with root package name */
    public String f389296d;

    /* renamed from: e, reason: collision with root package name */
    public String f389297e;

    /* renamed from: f, reason: collision with root package name */
    public String f389298f;

    /* renamed from: g, reason: collision with root package name */
    public String f389299g;

    /* renamed from: h, reason: collision with root package name */
    public String f389300h;

    /* renamed from: i, reason: collision with root package name */
    public String f389301i;

    /* renamed from: j, reason: collision with root package name */
    public String f389302j;

    /* renamed from: k, reason: collision with root package name */
    public String f389303k;

    /* renamed from: l, reason: collision with root package name */
    public String f389304l;

    /* renamed from: m, reason: collision with root package name */
    private static final hs f389292m = new hs("XmPushActionRegistrationResult");
    private static final ga C = new ga("", (byte) 11, 1);
    private static final ga D = new ga("", (byte) 12, 2);
    private static final ga E = new ga("", (byte) 11, 3);
    private static final ga F = new ga("", (byte) 11, 4);
    private static final ga G = new ga("", (byte) 10, 6);
    private static final ga H = new ga("", (byte) 11, 7);
    private static final ga I = new ga("", (byte) 11, 8);
    private static final ga J = new ga("", (byte) 11, 9);
    private static final ga K = new ga("", (byte) 11, 10);
    private static final ga L = new ga("", (byte) 10, 11);
    private static final ga M = new ga("", (byte) 11, 12);
    private static final ga N = new ga("", (byte) 11, 13);
    private static final ga P = new ga("", (byte) 10, 14);
    private static final ga Q = new ga("", (byte) 11, 15);
    private static final ga R = new ga("", (byte) 8, 16);
    private static final ga S = new ga("", (byte) 11, 17);
    private static final ga T = new ga("", (byte) 8, 18);
    private static final ga U = new ga("", (byte) 11, 19);
    private static final ga V = new ga("", (byte) 2, 20);
    private static final ga W = new ga("", RegisterType.DOUBLE_HI, 21);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24831a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24833a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m408a() {
        return this.f24830a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m410b() {
        return this.f24829a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m411c() {
        return this.f24835b != null;
    }

    public boolean d() {
        return this.f24836c != null;
    }

    public boolean e() {
        return this.f24831a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hg)) {
            return false;
        }
        return m409a((hg) obj);
    }

    public boolean f() {
        return this.f389296d != null;
    }

    public boolean g() {
        if (this.f389297e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f389298f != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389299g != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        return this.f24831a.get(1);
    }

    public boolean k() {
        if (this.f389300h != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f389301i != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.f24831a.get(2);
    }

    public boolean n() {
        if (this.f389302j != null) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return this.f24831a.get(3);
    }

    public boolean p() {
        if (this.f389303k != null) {
            return true;
        }
        return false;
    }

    public boolean q() {
        return this.f24831a.get(4);
    }

    public boolean r() {
        if (this.f389304l != null) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f24831a.get(5);
    }

    public boolean t() {
        if (this.f24832a != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z17 = false;
        if (m408a()) {
            sb5.append("debug:");
            String str = this.f24830a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m410b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24829a;
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
        String str2 = this.f24835b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(com.xiaomi.push.service.m.b(str2));
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f24836c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        sb5.append(", ");
        sb5.append("errorCode:");
        sb5.append(this.f24828a);
        if (f()) {
            sb5.append(", ");
            sb5.append("reason:");
            String str4 = this.f389296d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("regId:");
            String str5 = this.f389297e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str6 = this.f389299g;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("registeredAt:");
            sb5.append(this.f24834b);
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("aliasName:");
            String str7 = this.f389300h;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        if (l()) {
            sb5.append(", ");
            sb5.append("clientId:");
            String str8 = this.f389301i;
            if (str8 == null) {
                sb5.append("null");
            } else {
                sb5.append(str8);
            }
        }
        if (m()) {
            sb5.append(", ");
            sb5.append("costTime:");
            sb5.append(this.f389295c);
        }
        if (n()) {
            sb5.append(", ");
            sb5.append("appVersion:");
            String str9 = this.f389302j;
            if (str9 == null) {
                sb5.append("null");
            } else {
                sb5.append(str9);
            }
        }
        if (o()) {
            sb5.append(", ");
            sb5.append("pushSdkVersionCode:");
            sb5.append(this.f389293a);
        }
        if (p()) {
            sb5.append(", ");
            sb5.append("hybridPushEndpoint:");
            String str10 = this.f389303k;
            if (str10 == null) {
                sb5.append("null");
            } else {
                sb5.append(str10);
            }
        }
        if (q()) {
            sb5.append(", ");
            sb5.append("appVersionCode:");
            sb5.append(this.f389294b);
        }
        if (r()) {
            sb5.append(", ");
            sb5.append("region:");
            String str11 = this.f389304l;
            if (str11 == null) {
                sb5.append("null");
            } else {
                sb5.append(str11);
            }
        }
        if (s()) {
            sb5.append(", ");
            sb5.append("isHybridFrame:");
            sb5.append(this.f24833a);
        }
        if (t()) {
            sb5.append(", ");
            sb5.append("autoMarkPkgs:");
            List<String> list = this.f24832a;
            if (list == null) {
                sb5.append("null");
            } else {
                sb5.append(list);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m405a() {
        return this.f24835b;
    }

    public String b() {
        return this.f389298f;
    }

    public String c() {
        return this.f389299g;
    }

    public void d(boolean z16) {
        this.f24831a.set(3, z16);
    }

    public void e(boolean z16) {
        this.f24831a.set(4, z16);
    }

    public void f(boolean z16) {
        this.f24831a.set(5, z16);
    }

    public long a() {
        return this.f24828a;
    }

    public void b(boolean z16) {
        this.f24831a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24831a.set(2, z16);
    }

    public void a(boolean z16) {
        this.f24831a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m407a();
        hnVar.t(f389292m);
        if (this.f24830a != null && m408a()) {
            hnVar.q(C);
            hnVar.u(this.f24830a);
            hnVar.z();
        }
        if (this.f24829a != null && m410b()) {
            hnVar.q(D);
            this.f24829a.b(hnVar);
            hnVar.z();
        }
        if (this.f24835b != null) {
            hnVar.q(E);
            hnVar.u(this.f24835b);
            hnVar.z();
        }
        if (this.f24836c != null) {
            hnVar.q(F);
            hnVar.u(this.f24836c);
            hnVar.z();
        }
        hnVar.q(G);
        hnVar.p(this.f24828a);
        hnVar.z();
        if (this.f389296d != null && f()) {
            hnVar.q(H);
            hnVar.u(this.f389296d);
            hnVar.z();
        }
        if (this.f389297e != null && g()) {
            hnVar.q(I);
            hnVar.u(this.f389297e);
            hnVar.z();
        }
        if (this.f389298f != null && h()) {
            hnVar.q(J);
            hnVar.u(this.f389298f);
            hnVar.z();
        }
        if (this.f389299g != null && i()) {
            hnVar.q(K);
            hnVar.u(this.f389299g);
            hnVar.z();
        }
        if (j()) {
            hnVar.q(L);
            hnVar.p(this.f24834b);
            hnVar.z();
        }
        if (this.f389300h != null && k()) {
            hnVar.q(M);
            hnVar.u(this.f389300h);
            hnVar.z();
        }
        if (this.f389301i != null && l()) {
            hnVar.q(N);
            hnVar.u(this.f389301i);
            hnVar.z();
        }
        if (m()) {
            hnVar.q(P);
            hnVar.p(this.f389295c);
            hnVar.z();
        }
        if (this.f389302j != null && n()) {
            hnVar.q(Q);
            hnVar.u(this.f389302j);
            hnVar.z();
        }
        if (o()) {
            hnVar.q(R);
            hnVar.o(this.f389293a);
            hnVar.z();
        }
        if (this.f389303k != null && p()) {
            hnVar.q(S);
            hnVar.u(this.f389303k);
            hnVar.z();
        }
        if (q()) {
            hnVar.q(T);
            hnVar.o(this.f389294b);
            hnVar.z();
        }
        if (this.f389304l != null && r()) {
            hnVar.q(U);
            hnVar.u(this.f389304l);
            hnVar.z();
        }
        if (s()) {
            hnVar.q(V);
            hnVar.x(this.f24833a);
            hnVar.z();
        }
        if (this.f24832a != null && t()) {
            hnVar.q(W);
            hnVar.r(new gc((byte) 11, this.f24832a.size()));
            Iterator<String> it = this.f24832a.iterator();
            while (it.hasNext()) {
                hnVar.u(it.next());
            }
            hnVar.C();
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m406a() {
        return this.f24832a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m409a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean m408a = m408a();
        boolean m408a2 = hgVar.m408a();
        if ((m408a || m408a2) && !(m408a && m408a2 && this.f24830a.equals(hgVar.f24830a))) {
            return false;
        }
        boolean m410b = m410b();
        boolean m410b2 = hgVar.m410b();
        if ((m410b || m410b2) && !(m410b && m410b2 && this.f24829a.m353a(hgVar.f24829a))) {
            return false;
        }
        boolean m411c = m411c();
        boolean m411c2 = hgVar.m411c();
        if ((m411c || m411c2) && !(m411c && m411c2 && this.f24835b.equals(hgVar.f24835b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hgVar.d();
        if (((d16 || d17) && !(d16 && d17 && this.f24836c.equals(hgVar.f24836c))) || this.f24828a != hgVar.f24828a) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hgVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389296d.equals(hgVar.f389296d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hgVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389297e.equals(hgVar.f389297e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hgVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389298f.equals(hgVar.f389298f))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hgVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389299g.equals(hgVar.f389299g))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = hgVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f24834b == hgVar.f24834b)) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = hgVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f389300h.equals(hgVar.f389300h))) {
            return false;
        }
        boolean l3 = l();
        boolean l16 = hgVar.l();
        if ((l3 || l16) && !(l3 && l16 && this.f389301i.equals(hgVar.f389301i))) {
            return false;
        }
        boolean m3 = m();
        boolean m16 = hgVar.m();
        if ((m3 || m16) && !(m3 && m16 && this.f389295c == hgVar.f389295c)) {
            return false;
        }
        boolean n3 = n();
        boolean n16 = hgVar.n();
        if ((n3 || n16) && !(n3 && n16 && this.f389302j.equals(hgVar.f389302j))) {
            return false;
        }
        boolean o16 = o();
        boolean o17 = hgVar.o();
        if ((o16 || o17) && !(o16 && o17 && this.f389293a == hgVar.f389293a)) {
            return false;
        }
        boolean p16 = p();
        boolean p17 = hgVar.p();
        if ((p16 || p17) && !(p16 && p17 && this.f389303k.equals(hgVar.f389303k))) {
            return false;
        }
        boolean q16 = q();
        boolean q17 = hgVar.q();
        if ((q16 || q17) && !(q16 && q17 && this.f389294b == hgVar.f389294b)) {
            return false;
        }
        boolean r16 = r();
        boolean r17 = hgVar.r();
        if ((r16 || r17) && !(r16 && r17 && this.f389304l.equals(hgVar.f389304l))) {
            return false;
        }
        boolean s16 = s();
        boolean s17 = hgVar.s();
        if ((s16 || s17) && !(s16 && s17 && this.f24833a == hgVar.f24833a)) {
            return false;
        }
        boolean t16 = t();
        boolean t17 = hgVar.t();
        if (t16 || t17) {
            return t16 && t17 && this.f24832a.equals(hgVar.f24832a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hg hgVar) {
        int g16;
        int k3;
        int e16;
        int b16;
        int e17;
        int b17;
        int e18;
        int c16;
        int e19;
        int e26;
        int c17;
        int e27;
        int e28;
        int e29;
        int e36;
        int c18;
        int e37;
        int e38;
        int d16;
        int e39;
        if (!getClass().equals(hgVar.getClass())) {
            return getClass().getName().compareTo(hgVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m408a()).compareTo(Boolean.valueOf(hgVar.m408a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m408a() && (e39 = fw.e(this.f24830a, hgVar.f24830a)) != 0) {
            return e39;
        }
        int compareTo2 = Boolean.valueOf(m410b()).compareTo(Boolean.valueOf(hgVar.m410b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m410b() && (d16 = fw.d(this.f24829a, hgVar.f24829a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(m411c()).compareTo(Boolean.valueOf(hgVar.m411c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m411c() && (e38 = fw.e(this.f24835b, hgVar.f24835b)) != 0) {
            return e38;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hgVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e37 = fw.e(this.f24836c, hgVar.f24836c)) != 0) {
            return e37;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hgVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c18 = fw.c(this.f24828a, hgVar.f24828a)) != 0) {
            return c18;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e36 = fw.e(this.f389296d, hgVar.f389296d)) != 0) {
            return e36;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e29 = fw.e(this.f389297e, hgVar.f389297e)) != 0) {
            return e29;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hgVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e28 = fw.e(this.f389298f, hgVar.f389298f)) != 0) {
            return e28;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hgVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e27 = fw.e(this.f389299g, hgVar.f389299g)) != 0) {
            return e27;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hgVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (c17 = fw.c(this.f24834b, hgVar.f24834b)) != 0) {
            return c17;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hgVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e26 = fw.e(this.f389300h, hgVar.f389300h)) != 0) {
            return e26;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hgVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e19 = fw.e(this.f389301i, hgVar.f389301i)) != 0) {
            return e19;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hgVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (c16 = fw.c(this.f389295c, hgVar.f389295c)) != 0) {
            return c16;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hgVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (e18 = fw.e(this.f389302j, hgVar.f389302j)) != 0) {
            return e18;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hgVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (b17 = fw.b(this.f389293a, hgVar.f389293a)) != 0) {
            return b17;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hgVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (e17 = fw.e(this.f389303k, hgVar.f389303k)) != 0) {
            return e17;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hgVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (b16 = fw.b(this.f389294b, hgVar.f389294b)) != 0) {
            return b16;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hgVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (e16 = fw.e(this.f389304l, hgVar.f389304l)) != 0) {
            return e16;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hgVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (k3 = fw.k(this.f24833a, hgVar.f24833a)) != 0) {
            return k3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hgVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (g16 = fw.g(this.f24832a, hgVar.f24832a)) == 0) {
            return 0;
        }
        return g16;
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
                    m407a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24830a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24829a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f24835b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f24836c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                default:
                    hp.a(hnVar, b16);
                    break;
                case 6:
                    if (b16 == 10) {
                        this.f24828a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389296d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389297e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389298f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389299g = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 10) {
                        this.f24834b = hnVar.d();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 11) {
                        this.f389300h = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 13:
                    if (b16 == 11) {
                        this.f389301i = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 14:
                    if (b16 == 10) {
                        this.f389295c = hnVar.d();
                        c(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 15:
                    if (b16 == 11) {
                        this.f389302j = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 16:
                    if (b16 == 8) {
                        this.f389293a = hnVar.c();
                        d(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 17:
                    if (b16 == 11) {
                        this.f389303k = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 18:
                    if (b16 == 8) {
                        this.f389294b = hnVar.c();
                        e(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 19:
                    if (b16 == 11) {
                        this.f389304l = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 20:
                    if (b16 == 2) {
                        this.f24833a = hnVar.y();
                        f(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 21:
                    if (b16 == 15) {
                        gc f16 = hnVar.f();
                        this.f24832a = new ArrayList(f16.f388947b);
                        for (int i3 = 0; i3 < f16.f388947b; i3++) {
                            this.f24832a.add(hnVar.j());
                        }
                        hnVar.G();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
            }
            hnVar.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m407a() {
        if (this.f24835b != null) {
            if (this.f24836c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
