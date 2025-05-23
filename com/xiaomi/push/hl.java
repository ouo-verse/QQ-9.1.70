package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hl implements hq<hl, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389344a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24850a;

    /* renamed from: a, reason: collision with other field name */
    public String f24851a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24852a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24853a = true;

    /* renamed from: b, reason: collision with root package name */
    public String f389345b;

    /* renamed from: c, reason: collision with root package name */
    public String f389346c;

    /* renamed from: d, reason: collision with root package name */
    public String f389347d;

    /* renamed from: e, reason: collision with root package name */
    public String f389348e;

    /* renamed from: f, reason: collision with root package name */
    public String f389349f;

    /* renamed from: g, reason: collision with root package name */
    public String f389350g;

    /* renamed from: h, reason: collision with root package name */
    public String f389351h;

    /* renamed from: i, reason: collision with root package name */
    public String f389352i;

    /* renamed from: m, reason: collision with root package name */
    private static final hs f389343m = new hs("XmPushActionUnRegistration");
    private static final ga C = new ga("", (byte) 11, 1);
    private static final ga D = new ga("", (byte) 12, 2);
    private static final ga E = new ga("", (byte) 11, 3);
    private static final ga F = new ga("", (byte) 11, 4);
    private static final ga G = new ga("", (byte) 11, 5);
    private static final ga H = new ga("", (byte) 11, 6);
    private static final ga I = new ga("", (byte) 11, 7);
    private static final ga J = new ga("", (byte) 11, 8);
    private static final ga K = new ga("", (byte) 11, 9);
    private static final ga L = new ga("", (byte) 11, 10);
    private static final ga M = new ga("", (byte) 2, 11);
    private static final ga N = new ga("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m430a() {
        return this.f24851a != null;
    }

    public boolean b() {
        return this.f24850a != null;
    }

    public boolean c() {
        return this.f389345b != null;
    }

    public boolean d() {
        return this.f389346c != null;
    }

    public boolean e() {
        return this.f389347d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hl)) {
            return false;
        }
        return m431a((hl) obj);
    }

    public boolean f() {
        if (this.f389348e != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389349f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f389350g != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389351h != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f389352i != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return this.f24852a.get(0);
    }

    public boolean l() {
        return this.f24852a.get(1);
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionUnRegistration(");
        boolean z17 = false;
        if (m430a()) {
            sb5.append("debug:");
            String str = this.f24851a;
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
            gu guVar = this.f24850a;
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
        String str2 = this.f389345b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f389346c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("regId:");
            String str4 = this.f389347d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("appVersion:");
            String str5 = this.f389348e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str6 = this.f389349f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("token:");
            String str7 = this.f389350g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("deviceId:");
            String str8 = this.f389351h;
            if (str8 == null) {
                sb5.append("null");
            } else {
                sb5.append(str8);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("aliasName:");
            String str9 = this.f389352i;
            if (str9 == null) {
                sb5.append("null");
            } else {
                sb5.append(str9);
            }
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("needAck:");
            sb5.append(this.f24853a);
        }
        if (l()) {
            sb5.append(", ");
            sb5.append("createdTs:");
            sb5.append(this.f389344a);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public hl a(String str) {
        this.f389345b = str;
        return this;
    }

    public hl b(String str) {
        this.f389346c = str;
        return this;
    }

    public hl c(String str) {
        this.f389347d = str;
        return this;
    }

    public hl d(String str) {
        this.f389349f = str;
        return this;
    }

    public hl e(String str) {
        this.f389350g = str;
        return this;
    }

    public void a(boolean z16) {
        this.f24852a.set(0, z16);
    }

    public void b(boolean z16) {
        this.f24852a.set(1, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m431a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean m430a = m430a();
        boolean m430a2 = hlVar.m430a();
        if ((m430a || m430a2) && !(m430a && m430a2 && this.f24851a.equals(hlVar.f24851a))) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = hlVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24850a.m353a(hlVar.f24850a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = hlVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f389345b.equals(hlVar.f389345b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hlVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389346c.equals(hlVar.f389346c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = hlVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389347d.equals(hlVar.f389347d))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hlVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389348e.equals(hlVar.f389348e))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hlVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389349f.equals(hlVar.f389349f))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hlVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389350g.equals(hlVar.f389350g))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hlVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389351h.equals(hlVar.f389351h))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = hlVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f389352i.equals(hlVar.f389352i))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = hlVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f24853a == hlVar.f24853a)) {
            return false;
        }
        boolean l3 = l();
        boolean l16 = hlVar.l();
        if (l3 || l16) {
            return l3 && l16 && this.f389344a == hlVar.f389344a;
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f389343m);
        if (this.f24851a != null && m430a()) {
            hnVar.q(C);
            hnVar.u(this.f24851a);
            hnVar.z();
        }
        if (this.f24850a != null && b()) {
            hnVar.q(D);
            this.f24850a.b(hnVar);
            hnVar.z();
        }
        if (this.f389345b != null) {
            hnVar.q(E);
            hnVar.u(this.f389345b);
            hnVar.z();
        }
        if (this.f389346c != null) {
            hnVar.q(F);
            hnVar.u(this.f389346c);
            hnVar.z();
        }
        if (this.f389347d != null && e()) {
            hnVar.q(G);
            hnVar.u(this.f389347d);
            hnVar.z();
        }
        if (this.f389348e != null && f()) {
            hnVar.q(H);
            hnVar.u(this.f389348e);
            hnVar.z();
        }
        if (this.f389349f != null && g()) {
            hnVar.q(I);
            hnVar.u(this.f389349f);
            hnVar.z();
        }
        if (this.f389350g != null && h()) {
            hnVar.q(J);
            hnVar.u(this.f389350g);
            hnVar.z();
        }
        if (this.f389351h != null && i()) {
            hnVar.q(K);
            hnVar.u(this.f389351h);
            hnVar.z();
        }
        if (this.f389352i != null && j()) {
            hnVar.q(L);
            hnVar.u(this.f389352i);
            hnVar.z();
        }
        if (k()) {
            hnVar.q(M);
            hnVar.x(this.f24853a);
            hnVar.z();
        }
        if (l()) {
            hnVar.q(N);
            hnVar.p(this.f389344a);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hl hlVar) {
        int c16;
        int k3;
        int e16;
        int e17;
        int e18;
        int e19;
        int e26;
        int e27;
        int e28;
        int e29;
        int d16;
        int e36;
        if (!getClass().equals(hlVar.getClass())) {
            return getClass().getName().compareTo(hlVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m430a()).compareTo(Boolean.valueOf(hlVar.m430a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m430a() && (e36 = fw.e(this.f24851a, hlVar.f24851a)) != 0) {
            return e36;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d16 = fw.d(this.f24850a, hlVar.f24850a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e29 = fw.e(this.f389345b, hlVar.f389345b)) != 0) {
            return e29;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e28 = fw.e(this.f389346c, hlVar.f389346c)) != 0) {
            return e28;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e27 = fw.e(this.f389347d, hlVar.f389347d)) != 0) {
            return e27;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e26 = fw.e(this.f389348e, hlVar.f389348e)) != 0) {
            return e26;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e19 = fw.e(this.f389349f, hlVar.f389349f)) != 0) {
            return e19;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e18 = fw.e(this.f389350g, hlVar.f389350g)) != 0) {
            return e18;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e17 = fw.e(this.f389351h, hlVar.f389351h)) != 0) {
            return e17;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hlVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e16 = fw.e(this.f389352i, hlVar.f389352i)) != 0) {
            return e16;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hlVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (k3 = fw.k(this.f24853a, hlVar.f24853a)) != 0) {
            return k3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hlVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (c16 = fw.c(this.f389344a, hlVar.f389344a)) == 0) {
            return 0;
        }
        return c16;
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
                        this.f24851a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24850a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389345b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389346c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389347d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 11) {
                        this.f389348e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389349f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389350g = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389351h = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389352i = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 2) {
                        this.f24853a = hnVar.y();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 10) {
                        this.f389344a = hnVar.d();
                        b(true);
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
        if (this.f389345b != null) {
            if (this.f389346c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
