package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ho implements hq<ho, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389366a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24859a;

    /* renamed from: a, reason: collision with other field name */
    public String f24860a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24861a = new BitSet(1);

    /* renamed from: b, reason: collision with root package name */
    public String f389367b;

    /* renamed from: c, reason: collision with root package name */
    public String f389368c;

    /* renamed from: d, reason: collision with root package name */
    public String f389369d;

    /* renamed from: e, reason: collision with root package name */
    public String f389370e;

    /* renamed from: f, reason: collision with root package name */
    public String f389371f;

    /* renamed from: g, reason: collision with root package name */
    public String f389372g;

    /* renamed from: h, reason: collision with root package name */
    private static final hs f389363h = new hs("XmPushActionUnSubscriptionResult");

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389364i = new ga("", (byte) 11, 1);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389365m = new ga("", (byte) 12, 2);
    private static final ga C = new ga("", (byte) 11, 3);
    private static final ga D = new ga("", (byte) 11, 4);
    private static final ga E = new ga("", (byte) 10, 6);
    private static final ga F = new ga("", (byte) 11, 7);
    private static final ga G = new ga("", (byte) 11, 8);
    private static final ga H = new ga("", (byte) 11, 9);
    private static final ga I = new ga("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m436a() {
        return this.f24860a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m438b() {
        return this.f24859a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m439c() {
        return this.f389367b != null;
    }

    public boolean d() {
        if (this.f389368c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f24861a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ho)) {
            return false;
        }
        return m437a((ho) obj);
    }

    public boolean f() {
        if (this.f389369d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389370e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f389371f != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389372g != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z17 = false;
        if (m436a()) {
            sb5.append("debug:");
            String str = this.f24860a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m438b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24859a;
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
        String str2 = this.f389367b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        if (d()) {
            sb5.append(", ");
            sb5.append("appId:");
            String str3 = this.f389368c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("errorCode:");
            sb5.append(this.f389366a);
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("reason:");
            String str4 = this.f389369d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("topic:");
            String str5 = this.f389370e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str6 = this.f389371f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("category:");
            String str7 = this.f389372g;
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
        return this.f389367b;
    }

    public String b() {
        return this.f389370e;
    }

    public String c() {
        return this.f389372g;
    }

    public void a(boolean z16) {
        this.f24861a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m435a();
        hnVar.t(f389363h);
        if (this.f24860a != null && m436a()) {
            hnVar.q(f389364i);
            hnVar.u(this.f24860a);
            hnVar.z();
        }
        if (this.f24859a != null && m438b()) {
            hnVar.q(f389365m);
            this.f24859a.b(hnVar);
            hnVar.z();
        }
        if (this.f389367b != null) {
            hnVar.q(C);
            hnVar.u(this.f389367b);
            hnVar.z();
        }
        if (this.f389368c != null && d()) {
            hnVar.q(D);
            hnVar.u(this.f389368c);
            hnVar.z();
        }
        if (e()) {
            hnVar.q(E);
            hnVar.p(this.f389366a);
            hnVar.z();
        }
        if (this.f389369d != null && f()) {
            hnVar.q(F);
            hnVar.u(this.f389369d);
            hnVar.z();
        }
        if (this.f389370e != null && g()) {
            hnVar.q(G);
            hnVar.u(this.f389370e);
            hnVar.z();
        }
        if (this.f389371f != null && h()) {
            hnVar.q(H);
            hnVar.u(this.f389371f);
            hnVar.z();
        }
        if (this.f389372g != null && i()) {
            hnVar.q(I);
            hnVar.u(this.f389372g);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m437a(ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean m436a = m436a();
        boolean m436a2 = hoVar.m436a();
        if ((m436a || m436a2) && !(m436a && m436a2 && this.f24860a.equals(hoVar.f24860a))) {
            return false;
        }
        boolean m438b = m438b();
        boolean m438b2 = hoVar.m438b();
        if ((m438b || m438b2) && !(m438b && m438b2 && this.f24859a.m353a(hoVar.f24859a))) {
            return false;
        }
        boolean m439c = m439c();
        boolean m439c2 = hoVar.m439c();
        if ((m439c || m439c2) && !(m439c && m439c2 && this.f389367b.equals(hoVar.f389367b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hoVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389368c.equals(hoVar.f389368c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = hoVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389366a == hoVar.f389366a)) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hoVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389369d.equals(hoVar.f389369d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hoVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389370e.equals(hoVar.f389370e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hoVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389371f.equals(hoVar.f389371f))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hoVar.i();
        if (i3 || i16) {
            return i3 && i16 && this.f389372g.equals(hoVar.f389372g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ho hoVar) {
        int e16;
        int e17;
        int e18;
        int e19;
        int c16;
        int e26;
        int e27;
        int d16;
        int e28;
        if (!getClass().equals(hoVar.getClass())) {
            return getClass().getName().compareTo(hoVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m436a()).compareTo(Boolean.valueOf(hoVar.m436a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m436a() && (e28 = fw.e(this.f24860a, hoVar.f24860a)) != 0) {
            return e28;
        }
        int compareTo2 = Boolean.valueOf(m438b()).compareTo(Boolean.valueOf(hoVar.m438b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m438b() && (d16 = fw.d(this.f24859a, hoVar.f24859a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(m439c()).compareTo(Boolean.valueOf(hoVar.m439c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m439c() && (e27 = fw.e(this.f389367b, hoVar.f389367b)) != 0) {
            return e27;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hoVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e26 = fw.e(this.f389368c, hoVar.f389368c)) != 0) {
            return e26;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hoVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c16 = fw.c(this.f389366a, hoVar.f389366a)) != 0) {
            return c16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hoVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e19 = fw.e(this.f389369d, hoVar.f389369d)) != 0) {
            return e19;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hoVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e18 = fw.e(this.f389370e, hoVar.f389370e)) != 0) {
            return e18;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hoVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e17 = fw.e(this.f389371f, hoVar.f389371f)) != 0) {
            return e17;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hoVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (e16 = fw.e(this.f389372g, hoVar.f389372g)) == 0) {
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
                m435a();
                return;
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24860a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24859a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389367b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389368c = hnVar.j();
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
                        this.f389366a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389369d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389370e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389371f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389372g = hnVar.j();
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
    public void m435a() {
        if (this.f389367b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
