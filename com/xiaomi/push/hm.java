package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hm implements hq<hm, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389357a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24854a;

    /* renamed from: a, reason: collision with other field name */
    public String f24855a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24856a = new BitSet(3);

    /* renamed from: b, reason: collision with root package name */
    public long f389358b;

    /* renamed from: b, reason: collision with other field name */
    public String f24857b;

    /* renamed from: c, reason: collision with root package name */
    public long f389359c;

    /* renamed from: c, reason: collision with other field name */
    public String f24858c;

    /* renamed from: d, reason: collision with root package name */
    public String f389360d;

    /* renamed from: e, reason: collision with root package name */
    public String f389361e;

    /* renamed from: f, reason: collision with root package name */
    private static final hs f389353f = new hs("XmPushActionUnRegistrationResult");

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389354h = new ga("", (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389355i = new ga("", (byte) 12, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389356m = new ga("", (byte) 11, 3);
    private static final ga C = new ga("", (byte) 11, 4);
    private static final ga D = new ga("", (byte) 10, 6);
    private static final ga E = new ga("", (byte) 11, 7);
    private static final ga F = new ga("", (byte) 11, 8);
    private static final ga G = new ga("", (byte) 10, 9);
    private static final ga H = new ga("", (byte) 10, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m433a() {
        return this.f24855a != null;
    }

    public boolean b() {
        return this.f24854a != null;
    }

    public boolean c() {
        return this.f24857b != null;
    }

    public boolean d() {
        if (this.f24858c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f24856a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hm)) {
            return false;
        }
        return m434a((hm) obj);
    }

    public boolean f() {
        if (this.f389360d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389361e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.f24856a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f24856a.get(2);
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z17 = false;
        if (m433a()) {
            sb5.append("debug:");
            String str = this.f24855a;
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
            gu guVar = this.f24854a;
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
        String str2 = this.f24857b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f24858c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        sb5.append(", ");
        sb5.append("errorCode:");
        sb5.append(this.f389357a);
        if (f()) {
            sb5.append(", ");
            sb5.append("reason:");
            String str4 = this.f389360d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str5 = this.f389361e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("unRegisteredAt:");
            sb5.append(this.f389358b);
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("costTime:");
            sb5.append(this.f389359c);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public void a(boolean z16) {
        this.f24856a.set(0, z16);
    }

    public void b(boolean z16) {
        this.f24856a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24856a.set(2, z16);
    }

    public String a() {
        return this.f389361e;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m432a();
        hnVar.t(f389353f);
        if (this.f24855a != null && m433a()) {
            hnVar.q(f389354h);
            hnVar.u(this.f24855a);
            hnVar.z();
        }
        if (this.f24854a != null && b()) {
            hnVar.q(f389355i);
            this.f24854a.b(hnVar);
            hnVar.z();
        }
        if (this.f24857b != null) {
            hnVar.q(f389356m);
            hnVar.u(this.f24857b);
            hnVar.z();
        }
        if (this.f24858c != null) {
            hnVar.q(C);
            hnVar.u(this.f24858c);
            hnVar.z();
        }
        hnVar.q(D);
        hnVar.p(this.f389357a);
        hnVar.z();
        if (this.f389360d != null && f()) {
            hnVar.q(E);
            hnVar.u(this.f389360d);
            hnVar.z();
        }
        if (this.f389361e != null && g()) {
            hnVar.q(F);
            hnVar.u(this.f389361e);
            hnVar.z();
        }
        if (h()) {
            hnVar.q(G);
            hnVar.p(this.f389358b);
            hnVar.z();
        }
        if (i()) {
            hnVar.q(H);
            hnVar.p(this.f389359c);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m434a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean m433a = m433a();
        boolean m433a2 = hmVar.m433a();
        if ((m433a || m433a2) && !(m433a && m433a2 && this.f24855a.equals(hmVar.f24855a))) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = hmVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24854a.m353a(hmVar.f24854a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = hmVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f24857b.equals(hmVar.f24857b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hmVar.d();
        if (((d16 || d17) && !(d16 && d17 && this.f24858c.equals(hmVar.f24858c))) || this.f389357a != hmVar.f389357a) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hmVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389360d.equals(hmVar.f389360d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hmVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389361e.equals(hmVar.f389361e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hmVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389358b == hmVar.f389358b)) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hmVar.i();
        if (i3 || i16) {
            return i3 && i16 && this.f389359c == hmVar.f389359c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hm hmVar) {
        int c16;
        int c17;
        int e16;
        int e17;
        int c18;
        int e18;
        int e19;
        int d16;
        int e26;
        if (!getClass().equals(hmVar.getClass())) {
            return getClass().getName().compareTo(hmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m433a()).compareTo(Boolean.valueOf(hmVar.m433a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m433a() && (e26 = fw.e(this.f24855a, hmVar.f24855a)) != 0) {
            return e26;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d16 = fw.d(this.f24854a, hmVar.f24854a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e19 = fw.e(this.f24857b, hmVar.f24857b)) != 0) {
            return e19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e18 = fw.e(this.f24858c, hmVar.f24858c)) != 0) {
            return e18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hmVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c18 = fw.c(this.f389357a, hmVar.f389357a)) != 0) {
            return c18;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e17 = fw.e(this.f389360d, hmVar.f389360d)) != 0) {
            return e17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e16 = fw.e(this.f389361e, hmVar.f389361e)) != 0) {
            return e16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (c17 = fw.c(this.f389358b, hmVar.f389358b)) != 0) {
            return c17;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (c16 = fw.c(this.f389359c, hmVar.f389359c)) == 0) {
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
                if (e()) {
                    m432a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24855a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24854a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f24857b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f24858c = hnVar.j();
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
                        this.f389357a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389360d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389361e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 10) {
                        this.f389358b = hnVar.d();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 10) {
                        this.f389359c = hnVar.d();
                        c(true);
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
    public void m432a() {
        if (this.f24857b != null) {
            if (this.f24858c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
