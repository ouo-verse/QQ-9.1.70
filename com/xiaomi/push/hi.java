package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hi implements hq<hi, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public gr f389316a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24840a;

    /* renamed from: a, reason: collision with other field name */
    public String f24841a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f24843a;

    /* renamed from: b, reason: collision with root package name */
    public String f389317b;

    /* renamed from: c, reason: collision with root package name */
    public String f389318c;

    /* renamed from: d, reason: collision with root package name */
    public String f389319d;

    /* renamed from: e, reason: collision with root package name */
    public String f389320e;

    /* renamed from: f, reason: collision with root package name */
    public String f389321f;

    /* renamed from: g, reason: collision with root package name */
    public String f389322g;

    /* renamed from: h, reason: collision with root package name */
    public String f389323h;

    /* renamed from: i, reason: collision with root package name */
    private static final hs f389314i = new hs("XmPushActionSendMessage");

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389315m = new ga("", (byte) 11, 1);
    private static final ga C = new ga("", (byte) 12, 2);
    private static final ga D = new ga("", (byte) 11, 3);
    private static final ga E = new ga("", (byte) 11, 4);
    private static final ga F = new ga("", (byte) 11, 5);
    private static final ga G = new ga("", (byte) 11, 6);
    private static final ga H = new ga("", (byte) 11, 7);
    private static final ga I = new ga("", (byte) 12, 8);
    private static final ga J = new ga("", (byte) 2, 9);
    private static final ga K = new ga("", (byte) 13, 10);
    private static final ga L = new ga("", (byte) 11, 11);
    private static final ga M = new ga("", (byte) 11, 12);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24842a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24844a = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m416a() {
        return this.f24841a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m418b() {
        return this.f24840a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m419c() {
        return this.f389317b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m420d() {
        return this.f389318c != null;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m421e() {
        return this.f389319d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hi)) {
            return false;
        }
        return m417a((hi) obj);
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m422f() {
        return this.f389320e != null;
    }

    public boolean g() {
        if (this.f389321f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f389316a != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f24842a.get(0);
    }

    public boolean j() {
        if (this.f24843a != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f389322g != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f389323h != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionSendMessage(");
        boolean z17 = false;
        if (m416a()) {
            sb5.append("debug:");
            String str = this.f24841a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m418b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24840a;
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
        String str2 = this.f389317b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f389318c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        if (m421e()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str4 = this.f389319d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (m422f()) {
            sb5.append(", ");
            sb5.append("topic:");
            String str5 = this.f389320e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("aliasName:");
            String str6 = this.f389321f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("message:");
            gr grVar = this.f389316a;
            if (grVar == null) {
                sb5.append("null");
            } else {
                sb5.append(grVar);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("needAck:");
            sb5.append(this.f24844a);
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("params:");
            Map<String, String> map = this.f24843a;
            if (map == null) {
                sb5.append("null");
            } else {
                sb5.append(map);
            }
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("category:");
            String str7 = this.f389322g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        if (l()) {
            sb5.append(", ");
            sb5.append("userAccount:");
            String str8 = this.f389323h;
            if (str8 == null) {
                sb5.append("null");
            } else {
                sb5.append(str8);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m414a() {
        return this.f389317b;
    }

    public String b() {
        return this.f389318c;
    }

    public String c() {
        return this.f389320e;
    }

    public String d() {
        return this.f389321f;
    }

    public String e() {
        return this.f389322g;
    }

    public String f() {
        return this.f389323h;
    }

    public gr a() {
        return this.f389316a;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m415a();
        hnVar.t(f389314i);
        if (this.f24841a != null && m416a()) {
            hnVar.q(f389315m);
            hnVar.u(this.f24841a);
            hnVar.z();
        }
        if (this.f24840a != null && m418b()) {
            hnVar.q(C);
            this.f24840a.b(hnVar);
            hnVar.z();
        }
        if (this.f389317b != null) {
            hnVar.q(D);
            hnVar.u(this.f389317b);
            hnVar.z();
        }
        if (this.f389318c != null) {
            hnVar.q(E);
            hnVar.u(this.f389318c);
            hnVar.z();
        }
        if (this.f389319d != null && m421e()) {
            hnVar.q(F);
            hnVar.u(this.f389319d);
            hnVar.z();
        }
        if (this.f389320e != null && m422f()) {
            hnVar.q(G);
            hnVar.u(this.f389320e);
            hnVar.z();
        }
        if (this.f389321f != null && g()) {
            hnVar.q(H);
            hnVar.u(this.f389321f);
            hnVar.z();
        }
        if (this.f389316a != null && h()) {
            hnVar.q(I);
            this.f389316a.b(hnVar);
            hnVar.z();
        }
        if (i()) {
            hnVar.q(J);
            hnVar.x(this.f24844a);
            hnVar.z();
        }
        if (this.f24843a != null && j()) {
            hnVar.q(K);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24843a.size()));
            for (Map.Entry<String, String> entry : this.f24843a.entrySet()) {
                hnVar.u(entry.getKey());
                hnVar.u(entry.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        if (this.f389322g != null && k()) {
            hnVar.q(L);
            hnVar.u(this.f389322g);
            hnVar.z();
        }
        if (this.f389323h != null && l()) {
            hnVar.q(M);
            hnVar.u(this.f389323h);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public void a(boolean z16) {
        this.f24842a.set(0, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m417a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean m416a = m416a();
        boolean m416a2 = hiVar.m416a();
        if ((m416a || m416a2) && !(m416a && m416a2 && this.f24841a.equals(hiVar.f24841a))) {
            return false;
        }
        boolean m418b = m418b();
        boolean m418b2 = hiVar.m418b();
        if ((m418b || m418b2) && !(m418b && m418b2 && this.f24840a.m353a(hiVar.f24840a))) {
            return false;
        }
        boolean m419c = m419c();
        boolean m419c2 = hiVar.m419c();
        if ((m419c || m419c2) && !(m419c && m419c2 && this.f389317b.equals(hiVar.f389317b))) {
            return false;
        }
        boolean m420d = m420d();
        boolean m420d2 = hiVar.m420d();
        if ((m420d || m420d2) && !(m420d && m420d2 && this.f389318c.equals(hiVar.f389318c))) {
            return false;
        }
        boolean m421e = m421e();
        boolean m421e2 = hiVar.m421e();
        if ((m421e || m421e2) && !(m421e && m421e2 && this.f389319d.equals(hiVar.f389319d))) {
            return false;
        }
        boolean m422f = m422f();
        boolean m422f2 = hiVar.m422f();
        if ((m422f || m422f2) && !(m422f && m422f2 && this.f389320e.equals(hiVar.f389320e))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hiVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389321f.equals(hiVar.f389321f))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hiVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389316a.m336a(hiVar.f389316a))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hiVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f24844a == hiVar.f24844a)) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = hiVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f24843a.equals(hiVar.f24843a))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = hiVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f389322g.equals(hiVar.f389322g))) {
            return false;
        }
        boolean l3 = l();
        boolean l16 = hiVar.l();
        if (l3 || l16) {
            return l3 && l16 && this.f389323h.equals(hiVar.f389323h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hi hiVar) {
        int e16;
        int e17;
        int h16;
        int k3;
        int d16;
        int e18;
        int e19;
        int e26;
        int e27;
        int e28;
        int d17;
        int e29;
        if (!getClass().equals(hiVar.getClass())) {
            return getClass().getName().compareTo(hiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m416a()).compareTo(Boolean.valueOf(hiVar.m416a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m416a() && (e29 = fw.e(this.f24841a, hiVar.f24841a)) != 0) {
            return e29;
        }
        int compareTo2 = Boolean.valueOf(m418b()).compareTo(Boolean.valueOf(hiVar.m418b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m418b() && (d17 = fw.d(this.f24840a, hiVar.f24840a)) != 0) {
            return d17;
        }
        int compareTo3 = Boolean.valueOf(m419c()).compareTo(Boolean.valueOf(hiVar.m419c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m419c() && (e28 = fw.e(this.f389317b, hiVar.f389317b)) != 0) {
            return e28;
        }
        int compareTo4 = Boolean.valueOf(m420d()).compareTo(Boolean.valueOf(hiVar.m420d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m420d() && (e27 = fw.e(this.f389318c, hiVar.f389318c)) != 0) {
            return e27;
        }
        int compareTo5 = Boolean.valueOf(m421e()).compareTo(Boolean.valueOf(hiVar.m421e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m421e() && (e26 = fw.e(this.f389319d, hiVar.f389319d)) != 0) {
            return e26;
        }
        int compareTo6 = Boolean.valueOf(m422f()).compareTo(Boolean.valueOf(hiVar.m422f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m422f() && (e19 = fw.e(this.f389320e, hiVar.f389320e)) != 0) {
            return e19;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e18 = fw.e(this.f389321f, hiVar.f389321f)) != 0) {
            return e18;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hiVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (d16 = fw.d(this.f389316a, hiVar.f389316a)) != 0) {
            return d16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hiVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (k3 = fw.k(this.f24844a, hiVar.f24844a)) != 0) {
            return k3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hiVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (h16 = fw.h(this.f24843a, hiVar.f24843a)) != 0) {
            return h16;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hiVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e17 = fw.e(this.f389322g, hiVar.f389322g)) != 0) {
            return e17;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hiVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (e16 = fw.e(this.f389323h, hiVar.f389323h)) == 0) {
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
                m415a();
                return;
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24841a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24840a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389317b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389318c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389319d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 11) {
                        this.f389320e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389321f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 12) {
                        gr grVar = new gr();
                        this.f389316a = grVar;
                        grVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 2) {
                        this.f24844a = hnVar.y();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 13) {
                        gd g16 = hnVar.g();
                        this.f24843a = new HashMap(g16.f388950c * 2);
                        for (int i3 = 0; i3 < g16.f388950c; i3++) {
                            this.f24843a.put(hnVar.j(), hnVar.j());
                        }
                        hnVar.F();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 11) {
                        this.f389322g = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 11) {
                        this.f389323h = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                default:
                    hp.a(hnVar, b16);
                    break;
            }
            hnVar.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m415a() {
        if (this.f389317b != null) {
            if (this.f389318c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
