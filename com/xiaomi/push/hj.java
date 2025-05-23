package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hj implements hq<hj, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public gu f389327a;

    /* renamed from: a, reason: collision with other field name */
    public String f24845a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f24846a;

    /* renamed from: b, reason: collision with root package name */
    public String f389328b;

    /* renamed from: c, reason: collision with root package name */
    public String f389329c;

    /* renamed from: d, reason: collision with root package name */
    public String f389330d;

    /* renamed from: e, reason: collision with root package name */
    public String f389331e;

    /* renamed from: f, reason: collision with root package name */
    public String f389332f;

    /* renamed from: h, reason: collision with root package name */
    private static final hs f389324h = new hs("XmPushActionSubscription");

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389325i = new ga("", (byte) 11, 1);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389326m = new ga("", (byte) 12, 2);
    private static final ga C = new ga("", (byte) 11, 3);
    private static final ga D = new ga("", (byte) 11, 4);
    private static final ga E = new ga("", (byte) 11, 5);
    private static final ga F = new ga("", (byte) 11, 6);
    private static final ga G = new ga("", (byte) 11, 7);
    private static final ga H = new ga("", RegisterType.DOUBLE_HI, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m423a() {
        return this.f24845a != null;
    }

    public boolean b() {
        return this.f389327a != null;
    }

    public boolean c() {
        return this.f389328b != null;
    }

    public boolean d() {
        return this.f389329c != null;
    }

    public boolean e() {
        return this.f389330d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hj)) {
            return false;
        }
        return m424a((hj) obj);
    }

    public boolean f() {
        if (this.f389331e != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389332f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f24846a != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionSubscription(");
        boolean z17 = false;
        if (m423a()) {
            sb5.append("debug:");
            String str = this.f24845a;
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
            gu guVar = this.f389327a;
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
        String str2 = this.f389328b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f389329c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        sb5.append(", ");
        sb5.append("topic:");
        String str4 = this.f389330d;
        if (str4 == null) {
            sb5.append("null");
        } else {
            sb5.append(str4);
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str5 = this.f389331e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("category:");
            String str6 = this.f389332f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("aliases:");
            List<String> list = this.f24846a;
            if (list == null) {
                sb5.append("null");
            } else {
                sb5.append(list);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public hj a(String str) {
        this.f389328b = str;
        return this;
    }

    public hj b(String str) {
        this.f389329c = str;
        return this;
    }

    public hj c(String str) {
        this.f389330d = str;
        return this;
    }

    public hj d(String str) {
        this.f389331e = str;
        return this;
    }

    public hj e(String str) {
        this.f389332f = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m424a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m423a = m423a();
        boolean m423a2 = hjVar.m423a();
        if ((m423a || m423a2) && !(m423a && m423a2 && this.f24845a.equals(hjVar.f24845a))) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = hjVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f389327a.m353a(hjVar.f389327a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = hjVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f389328b.equals(hjVar.f389328b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hjVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389329c.equals(hjVar.f389329c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = hjVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389330d.equals(hjVar.f389330d))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hjVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389331e.equals(hjVar.f389331e))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hjVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389332f.equals(hjVar.f389332f))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hjVar.h();
        if (h16 || h17) {
            return h16 && h17 && this.f24846a.equals(hjVar.f24846a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f389324h);
        if (this.f24845a != null && m423a()) {
            hnVar.q(f389325i);
            hnVar.u(this.f24845a);
            hnVar.z();
        }
        if (this.f389327a != null && b()) {
            hnVar.q(f389326m);
            this.f389327a.b(hnVar);
            hnVar.z();
        }
        if (this.f389328b != null) {
            hnVar.q(C);
            hnVar.u(this.f389328b);
            hnVar.z();
        }
        if (this.f389329c != null) {
            hnVar.q(D);
            hnVar.u(this.f389329c);
            hnVar.z();
        }
        if (this.f389330d != null) {
            hnVar.q(E);
            hnVar.u(this.f389330d);
            hnVar.z();
        }
        if (this.f389331e != null && f()) {
            hnVar.q(F);
            hnVar.u(this.f389331e);
            hnVar.z();
        }
        if (this.f389332f != null && g()) {
            hnVar.q(G);
            hnVar.u(this.f389332f);
            hnVar.z();
        }
        if (this.f24846a != null && h()) {
            hnVar.q(H);
            hnVar.r(new gc((byte) 11, this.f24846a.size()));
            Iterator<String> it = this.f24846a.iterator();
            while (it.hasNext()) {
                hnVar.u(it.next());
            }
            hnVar.C();
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hj hjVar) {
        int g16;
        int e16;
        int e17;
        int e18;
        int e19;
        int e26;
        int d16;
        int e27;
        if (!getClass().equals(hjVar.getClass())) {
            return getClass().getName().compareTo(hjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m423a()).compareTo(Boolean.valueOf(hjVar.m423a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m423a() && (e27 = fw.e(this.f24845a, hjVar.f24845a)) != 0) {
            return e27;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hjVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d16 = fw.d(this.f389327a, hjVar.f389327a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hjVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e26 = fw.e(this.f389328b, hjVar.f389328b)) != 0) {
            return e26;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hjVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e19 = fw.e(this.f389329c, hjVar.f389329c)) != 0) {
            return e19;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hjVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e18 = fw.e(this.f389330d, hjVar.f389330d)) != 0) {
            return e18;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e17 = fw.e(this.f389331e, hjVar.f389331e)) != 0) {
            return e17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e16 = fw.e(this.f389332f, hjVar.f389332f)) != 0) {
            return e16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (g16 = fw.g(this.f24846a, hjVar.f24846a)) == 0) {
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
                a();
                return;
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24845a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f389327a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389328b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389329c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389330d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 11) {
                        this.f389331e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389332f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 15) {
                        gc f16 = hnVar.f();
                        this.f24846a = new ArrayList(f16.f388947b);
                        for (int i3 = 0; i3 < f16.f388947b; i3++) {
                            this.f24846a.add(hnVar.j());
                        }
                        hnVar.G();
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

    public void a() {
        if (this.f389328b != null) {
            if (this.f389329c != null) {
                if (this.f389330d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
