package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hk implements hq<hk, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389336a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24847a;

    /* renamed from: a, reason: collision with other field name */
    public String f24848a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24849a = new BitSet(1);

    /* renamed from: b, reason: collision with root package name */
    public String f389337b;

    /* renamed from: c, reason: collision with root package name */
    public String f389338c;

    /* renamed from: d, reason: collision with root package name */
    public String f389339d;

    /* renamed from: e, reason: collision with root package name */
    public String f389340e;

    /* renamed from: f, reason: collision with root package name */
    public String f389341f;

    /* renamed from: g, reason: collision with root package name */
    public String f389342g;

    /* renamed from: h, reason: collision with root package name */
    private static final hs f389333h = new hs("XmPushActionSubscriptionResult");

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389334i = new ga("", (byte) 11, 1);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389335m = new ga("", (byte) 12, 2);
    private static final ga C = new ga("", (byte) 11, 3);
    private static final ga D = new ga("", (byte) 11, 4);
    private static final ga E = new ga("", (byte) 10, 6);
    private static final ga F = new ga("", (byte) 11, 7);
    private static final ga G = new ga("", (byte) 11, 8);
    private static final ga H = new ga("", (byte) 11, 9);
    private static final ga I = new ga("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m426a() {
        return this.f24848a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m428b() {
        return this.f24847a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m429c() {
        return this.f389337b != null;
    }

    public boolean d() {
        if (this.f389338c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f24849a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hk)) {
            return false;
        }
        return m427a((hk) obj);
    }

    public boolean f() {
        if (this.f389339d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389340e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f389341f != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389342g != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z17 = false;
        if (m426a()) {
            sb5.append("debug:");
            String str = this.f24848a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m428b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24847a;
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
        String str2 = this.f389337b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        if (d()) {
            sb5.append(", ");
            sb5.append("appId:");
            String str3 = this.f389338c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("errorCode:");
            sb5.append(this.f389336a);
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("reason:");
            String str4 = this.f389339d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("topic:");
            String str5 = this.f389340e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str6 = this.f389341f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("category:");
            String str7 = this.f389342g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public String a() {
        return this.f389337b;
    }

    public String b() {
        return this.f389340e;
    }

    public String c() {
        return this.f389342g;
    }

    public void a(boolean z16) {
        this.f24849a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m425a();
        hnVar.t(f389333h);
        if (this.f24848a != null && m426a()) {
            hnVar.q(f389334i);
            hnVar.u(this.f24848a);
            hnVar.z();
        }
        if (this.f24847a != null && m428b()) {
            hnVar.q(f389335m);
            this.f24847a.b(hnVar);
            hnVar.z();
        }
        if (this.f389337b != null) {
            hnVar.q(C);
            hnVar.u(this.f389337b);
            hnVar.z();
        }
        if (this.f389338c != null && d()) {
            hnVar.q(D);
            hnVar.u(this.f389338c);
            hnVar.z();
        }
        if (e()) {
            hnVar.q(E);
            hnVar.p(this.f389336a);
            hnVar.z();
        }
        if (this.f389339d != null && f()) {
            hnVar.q(F);
            hnVar.u(this.f389339d);
            hnVar.z();
        }
        if (this.f389340e != null && g()) {
            hnVar.q(G);
            hnVar.u(this.f389340e);
            hnVar.z();
        }
        if (this.f389341f != null && h()) {
            hnVar.q(H);
            hnVar.u(this.f389341f);
            hnVar.z();
        }
        if (this.f389342g != null && i()) {
            hnVar.q(I);
            hnVar.u(this.f389342g);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m427a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m426a = m426a();
        boolean m426a2 = hkVar.m426a();
        if ((m426a || m426a2) && !(m426a && m426a2 && this.f24848a.equals(hkVar.f24848a))) {
            return false;
        }
        boolean m428b = m428b();
        boolean m428b2 = hkVar.m428b();
        if ((m428b || m428b2) && !(m428b && m428b2 && this.f24847a.m353a(hkVar.f24847a))) {
            return false;
        }
        boolean m429c = m429c();
        boolean m429c2 = hkVar.m429c();
        if ((m429c || m429c2) && !(m429c && m429c2 && this.f389337b.equals(hkVar.f389337b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hkVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389338c.equals(hkVar.f389338c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = hkVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389336a == hkVar.f389336a)) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hkVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389339d.equals(hkVar.f389339d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hkVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389340e.equals(hkVar.f389340e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hkVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389341f.equals(hkVar.f389341f))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hkVar.i();
        if (i3 || i16) {
            return i3 && i16 && this.f389342g.equals(hkVar.f389342g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hk hkVar) {
        int e16;
        int e17;
        int e18;
        int e19;
        int c16;
        int e26;
        int e27;
        int d16;
        int e28;
        if (!getClass().equals(hkVar.getClass())) {
            return getClass().getName().compareTo(hkVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m426a()).compareTo(Boolean.valueOf(hkVar.m426a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m426a() && (e28 = fw.e(this.f24848a, hkVar.f24848a)) != 0) {
            return e28;
        }
        int compareTo2 = Boolean.valueOf(m428b()).compareTo(Boolean.valueOf(hkVar.m428b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m428b() && (d16 = fw.d(this.f24847a, hkVar.f24847a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(m429c()).compareTo(Boolean.valueOf(hkVar.m429c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m429c() && (e27 = fw.e(this.f389337b, hkVar.f389337b)) != 0) {
            return e27;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e26 = fw.e(this.f389338c, hkVar.f389338c)) != 0) {
            return e26;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c16 = fw.c(this.f389336a, hkVar.f389336a)) != 0) {
            return c16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e19 = fw.e(this.f389339d, hkVar.f389339d)) != 0) {
            return e19;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e18 = fw.e(this.f389340e, hkVar.f389340e)) != 0) {
            return e18;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e17 = fw.e(this.f389341f, hkVar.f389341f)) != 0) {
            return e17;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (e16 = fw.e(this.f389342g, hkVar.f389342g)) == 0) {
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
                m425a();
                return;
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24848a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24847a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389337b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389338c = hnVar.j();
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
                        this.f389336a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389339d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389340e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389341f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389342g = hnVar.j();
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
    public void m425a() {
        if (this.f389337b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
