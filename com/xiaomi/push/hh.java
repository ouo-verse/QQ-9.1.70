package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hh implements hq<hh, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389309a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24837a;

    /* renamed from: a, reason: collision with other field name */
    public String f24838a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24839a = new BitSet(1);

    /* renamed from: b, reason: collision with root package name */
    public String f389310b;

    /* renamed from: c, reason: collision with root package name */
    public String f389311c;

    /* renamed from: d, reason: collision with root package name */
    public String f389312d;

    /* renamed from: e, reason: collision with root package name */
    public String f389313e;

    /* renamed from: f, reason: collision with root package name */
    private static final hs f389305f = new hs("XmPushActionSendFeedbackResult");

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389306h = new ga("", (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389307i = new ga("", (byte) 12, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389308m = new ga("", (byte) 11, 3);
    private static final ga C = new ga("", (byte) 11, 4);
    private static final ga D = new ga("", (byte) 10, 6);
    private static final ga E = new ga("", (byte) 11, 7);
    private static final ga F = new ga("", (byte) 11, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m412a() {
        return this.f24838a != null;
    }

    public boolean b() {
        return this.f24837a != null;
    }

    public boolean c() {
        if (this.f389310b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f389311c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f24839a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hh)) {
            return false;
        }
        return m413a((hh) obj);
    }

    public boolean f() {
        if (this.f389312d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389313e != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z17 = false;
        if (m412a()) {
            sb5.append("debug:");
            String str = this.f24838a;
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
            gu guVar = this.f24837a;
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
        String str2 = this.f389310b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f389311c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        sb5.append(", ");
        sb5.append("errorCode:");
        sb5.append(this.f389309a);
        if (f()) {
            sb5.append(", ");
            sb5.append("reason:");
            String str4 = this.f389312d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("category:");
            String str5 = this.f389313e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public void a(boolean z16) {
        this.f24839a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f389305f);
        if (this.f24838a != null && m412a()) {
            hnVar.q(f389306h);
            hnVar.u(this.f24838a);
            hnVar.z();
        }
        if (this.f24837a != null && b()) {
            hnVar.q(f389307i);
            this.f24837a.b(hnVar);
            hnVar.z();
        }
        if (this.f389310b != null) {
            hnVar.q(f389308m);
            hnVar.u(this.f389310b);
            hnVar.z();
        }
        if (this.f389311c != null) {
            hnVar.q(C);
            hnVar.u(this.f389311c);
            hnVar.z();
        }
        hnVar.q(D);
        hnVar.p(this.f389309a);
        hnVar.z();
        if (this.f389312d != null && f()) {
            hnVar.q(E);
            hnVar.u(this.f389312d);
            hnVar.z();
        }
        if (this.f389313e != null && g()) {
            hnVar.q(F);
            hnVar.u(this.f389313e);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m413a(hh hhVar) {
        if (hhVar == null) {
            return false;
        }
        boolean m412a = m412a();
        boolean m412a2 = hhVar.m412a();
        if ((m412a || m412a2) && !(m412a && m412a2 && this.f24838a.equals(hhVar.f24838a))) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = hhVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24837a.m353a(hhVar.f24837a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = hhVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f389310b.equals(hhVar.f389310b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hhVar.d();
        if (((d16 || d17) && !(d16 && d17 && this.f389311c.equals(hhVar.f389311c))) || this.f389309a != hhVar.f389309a) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hhVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389312d.equals(hhVar.f389312d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hhVar.g();
        if (g16 || g17) {
            return g16 && g17 && this.f389313e.equals(hhVar.f389313e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hh hhVar) {
        int e16;
        int e17;
        int c16;
        int e18;
        int e19;
        int d16;
        int e26;
        if (!getClass().equals(hhVar.getClass())) {
            return getClass().getName().compareTo(hhVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m412a()).compareTo(Boolean.valueOf(hhVar.m412a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m412a() && (e26 = fw.e(this.f24838a, hhVar.f24838a)) != 0) {
            return e26;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hhVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d16 = fw.d(this.f24837a, hhVar.f24837a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hhVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e19 = fw.e(this.f389310b, hhVar.f389310b)) != 0) {
            return e19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hhVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e18 = fw.e(this.f389311c, hhVar.f389311c)) != 0) {
            return e18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hhVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c16 = fw.c(this.f389309a, hhVar.f389309a)) != 0) {
            return c16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hhVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e17 = fw.e(this.f389312d, hhVar.f389312d)) != 0) {
            return e17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hhVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (e16 = fw.e(this.f389313e, hhVar.f389313e)) == 0) {
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
                if (e()) {
                    a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24838a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24837a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389310b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389311c = hnVar.j();
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
                        this.f389309a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389312d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389313e = hnVar.j();
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
        if (this.f389310b != null) {
            if (this.f389311c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
