package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gj implements hq<gj, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389016a;

    /* renamed from: a, reason: collision with other field name */
    public String f24732a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24733a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f24734a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f24735a;

    /* renamed from: b, reason: collision with root package name */
    public long f389017b;

    /* renamed from: b, reason: collision with other field name */
    public String f24736b;

    /* renamed from: c, reason: collision with root package name */
    public String f389018c;

    /* renamed from: d, reason: collision with root package name */
    public String f389019d;

    /* renamed from: e, reason: collision with root package name */
    public String f389020e;

    /* renamed from: f, reason: collision with root package name */
    public String f389021f;

    /* renamed from: g, reason: collision with root package name */
    public String f389022g;

    /* renamed from: h, reason: collision with root package name */
    private static final hs f389013h = new hs("ClientUploadDataItem");

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389014i = new ga("", (byte) 11, 1);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389015m = new ga("", (byte) 11, 2);
    private static final ga C = new ga("", (byte) 11, 3);
    private static final ga D = new ga("", (byte) 10, 4);
    private static final ga E = new ga("", (byte) 10, 5);
    private static final ga F = new ga("", (byte) 2, 6);
    private static final ga G = new ga("", (byte) 11, 7);
    private static final ga H = new ga("", (byte) 11, 8);
    private static final ga I = new ga("", (byte) 11, 9);
    private static final ga J = new ga("", (byte) 13, 10);
    private static final ga K = new ga("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other method in class */
    public void m311a() {
    }

    public gj b(String str) {
        this.f24736b = str;
        return this;
    }

    public gj c(String str) {
        this.f389018c = str;
        return this;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m317d() {
        return this.f24733a.get(0);
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m318e() {
        return this.f24733a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gj)) {
            return false;
        }
        return m314a((gj) obj);
    }

    public boolean f() {
        return this.f24733a.get(2);
    }

    public boolean g() {
        return this.f389019d != null;
    }

    public boolean h() {
        if (this.f389020e != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389021f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f24734a != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f389022g != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("ClientUploadDataItem(");
        boolean z17 = false;
        if (m313a()) {
            sb5.append("channel:");
            String str = this.f24732a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m315b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("data:");
            String str2 = this.f24736b;
            if (str2 == null) {
                sb5.append("null");
            } else {
                sb5.append(str2);
            }
            z16 = false;
        }
        if (m316c()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("name:");
            String str3 = this.f389018c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
            z16 = false;
        }
        if (m317d()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("counter:");
            sb5.append(this.f389016a);
            z16 = false;
        }
        if (m318e()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("timestamp:");
            sb5.append(this.f389017b);
            z16 = false;
        }
        if (f()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("fromSdk:");
            sb5.append(this.f24735a);
            z16 = false;
        }
        if (g()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("category:");
            String str4 = this.f389019d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
            z16 = false;
        }
        if (h()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("sourcePackage:");
            String str5 = this.f389020e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
            z16 = false;
        }
        if (i()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("id:");
            String str6 = this.f389021f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
            z16 = false;
        }
        if (j()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("extra:");
            Map<String, String> map = this.f24734a;
            if (map == null) {
                sb5.append("null");
            } else {
                sb5.append(map);
            }
        } else {
            z17 = z16;
        }
        if (k()) {
            if (!z17) {
                sb5.append(", ");
            }
            sb5.append("pkgName:");
            String str7 = this.f389022g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m309a() {
        return this.f24732a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m315b() {
        return this.f24736b != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m316c() {
        return this.f389018c != null;
    }

    public gj d(String str) {
        this.f389019d = str;
        return this;
    }

    public gj e(String str) {
        this.f389020e = str;
        return this;
    }

    public gj f(String str) {
        this.f389021f = str;
        return this;
    }

    public gj g(String str) {
        this.f389022g = str;
        return this;
    }

    public gj a(String str) {
        this.f24732a = str;
        return this;
    }

    public String b() {
        return this.f389018c;
    }

    public void c(boolean z16) {
        this.f24733a.set(2, z16);
    }

    public String d() {
        return this.f389021f;
    }

    public String e() {
        return this.f389022g;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m313a() {
        return this.f24732a != null;
    }

    public gj b(long j3) {
        this.f389017b = j3;
        b(true);
        return this;
    }

    public String c() {
        return this.f389020e;
    }

    public gj a(long j3) {
        this.f389016a = j3;
        m312a(true);
        return this;
    }

    public void b(boolean z16) {
        this.f24733a.set(1, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m312a(boolean z16) {
        this.f24733a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m311a();
        hnVar.t(f389013h);
        if (this.f24732a != null && m313a()) {
            hnVar.q(f389014i);
            hnVar.u(this.f24732a);
            hnVar.z();
        }
        if (this.f24736b != null && m315b()) {
            hnVar.q(f389015m);
            hnVar.u(this.f24736b);
            hnVar.z();
        }
        if (this.f389018c != null && m316c()) {
            hnVar.q(C);
            hnVar.u(this.f389018c);
            hnVar.z();
        }
        if (m317d()) {
            hnVar.q(D);
            hnVar.p(this.f389016a);
            hnVar.z();
        }
        if (m318e()) {
            hnVar.q(E);
            hnVar.p(this.f389017b);
            hnVar.z();
        }
        if (f()) {
            hnVar.q(F);
            hnVar.x(this.f24735a);
            hnVar.z();
        }
        if (this.f389019d != null && g()) {
            hnVar.q(G);
            hnVar.u(this.f389019d);
            hnVar.z();
        }
        if (this.f389020e != null && h()) {
            hnVar.q(H);
            hnVar.u(this.f389020e);
            hnVar.z();
        }
        if (this.f389021f != null && i()) {
            hnVar.q(I);
            hnVar.u(this.f389021f);
            hnVar.z();
        }
        if (this.f24734a != null && j()) {
            hnVar.q(J);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24734a.size()));
            for (Map.Entry<String, String> entry : this.f24734a.entrySet()) {
                hnVar.u(entry.getKey());
                hnVar.u(entry.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        if (this.f389022g != null && k()) {
            hnVar.q(K);
            hnVar.u(this.f389022g);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public long a() {
        return this.f389017b;
    }

    public gj a(boolean z16) {
        this.f24735a = z16;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f24734a == null) {
            this.f24734a = new HashMap();
        }
        this.f24734a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m310a() {
        return this.f24734a;
    }

    public gj a(Map<String, String> map) {
        this.f24734a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m314a(gj gjVar) {
        if (gjVar == null) {
            return false;
        }
        boolean m313a = m313a();
        boolean m313a2 = gjVar.m313a();
        if ((m313a || m313a2) && !(m313a && m313a2 && this.f24732a.equals(gjVar.f24732a))) {
            return false;
        }
        boolean m315b = m315b();
        boolean m315b2 = gjVar.m315b();
        if ((m315b || m315b2) && !(m315b && m315b2 && this.f24736b.equals(gjVar.f24736b))) {
            return false;
        }
        boolean m316c = m316c();
        boolean m316c2 = gjVar.m316c();
        if ((m316c || m316c2) && !(m316c && m316c2 && this.f389018c.equals(gjVar.f389018c))) {
            return false;
        }
        boolean m317d = m317d();
        boolean m317d2 = gjVar.m317d();
        if ((m317d || m317d2) && !(m317d && m317d2 && this.f389016a == gjVar.f389016a)) {
            return false;
        }
        boolean m318e = m318e();
        boolean m318e2 = gjVar.m318e();
        if ((m318e || m318e2) && !(m318e && m318e2 && this.f389017b == gjVar.f389017b)) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = gjVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f24735a == gjVar.f24735a)) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = gjVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389019d.equals(gjVar.f389019d))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = gjVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389020e.equals(gjVar.f389020e))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = gjVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389021f.equals(gjVar.f389021f))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = gjVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f24734a.equals(gjVar.f24734a))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = gjVar.k();
        if (k3 || k16) {
            return k3 && k16 && this.f389022g.equals(gjVar.f389022g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gj gjVar) {
        int e16;
        int h16;
        int e17;
        int e18;
        int e19;
        int k3;
        int c16;
        int c17;
        int e26;
        int e27;
        int e28;
        if (!getClass().equals(gjVar.getClass())) {
            return getClass().getName().compareTo(gjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m313a()).compareTo(Boolean.valueOf(gjVar.m313a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m313a() && (e28 = fw.e(this.f24732a, gjVar.f24732a)) != 0) {
            return e28;
        }
        int compareTo2 = Boolean.valueOf(m315b()).compareTo(Boolean.valueOf(gjVar.m315b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m315b() && (e27 = fw.e(this.f24736b, gjVar.f24736b)) != 0) {
            return e27;
        }
        int compareTo3 = Boolean.valueOf(m316c()).compareTo(Boolean.valueOf(gjVar.m316c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m316c() && (e26 = fw.e(this.f389018c, gjVar.f389018c)) != 0) {
            return e26;
        }
        int compareTo4 = Boolean.valueOf(m317d()).compareTo(Boolean.valueOf(gjVar.m317d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m317d() && (c17 = fw.c(this.f389016a, gjVar.f389016a)) != 0) {
            return c17;
        }
        int compareTo5 = Boolean.valueOf(m318e()).compareTo(Boolean.valueOf(gjVar.m318e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m318e() && (c16 = fw.c(this.f389017b, gjVar.f389017b)) != 0) {
            return c16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gjVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (k3 = fw.k(this.f24735a, gjVar.f24735a)) != 0) {
            return k3;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gjVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e19 = fw.e(this.f389019d, gjVar.f389019d)) != 0) {
            return e19;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gjVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e18 = fw.e(this.f389020e, gjVar.f389020e)) != 0) {
            return e18;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gjVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e17 = fw.e(this.f389021f, gjVar.f389021f)) != 0) {
            return e17;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gjVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (h16 = fw.h(this.f24734a, gjVar.f24734a)) != 0) {
            return h16;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gjVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!k() || (e16 = fw.e(this.f389022g, gjVar.f389022g)) == 0) {
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
                m311a();
                return;
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24732a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 11) {
                        this.f24736b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389018c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 10) {
                        this.f389016a = hnVar.d();
                        m312a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 10) {
                        this.f389017b = hnVar.d();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 2) {
                        this.f24735a = hnVar.y();
                        c(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389019d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389020e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389021f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 13) {
                        gd g16 = hnVar.g();
                        this.f24734a = new HashMap(g16.f388950c * 2);
                        for (int i3 = 0; i3 < g16.f388950c; i3++) {
                            this.f24734a.put(hnVar.j(), hnVar.j());
                        }
                        hnVar.F();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 11) {
                        this.f389022g = hnVar.j();
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
}
