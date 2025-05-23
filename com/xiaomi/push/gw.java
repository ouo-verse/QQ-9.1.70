package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gw implements hq<gw, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gu f24786a;

    /* renamed from: a, reason: collision with other field name */
    public String f24787a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f24789a;

    /* renamed from: b, reason: collision with root package name */
    public String f389211b;

    /* renamed from: c, reason: collision with root package name */
    public String f389212c;

    /* renamed from: d, reason: collision with root package name */
    public String f389213d;

    /* renamed from: e, reason: collision with root package name */
    public String f389214e;

    /* renamed from: f, reason: collision with root package name */
    public String f389215f;

    /* renamed from: g, reason: collision with root package name */
    public String f389216g;

    /* renamed from: h, reason: collision with root package name */
    private static final hs f389207h = new hs("XmPushActionAckNotification");

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389208i = new ga("", (byte) 11, 1);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389209m = new ga("", (byte) 12, 2);
    private static final ga C = new ga("", (byte) 11, 3);
    private static final ga D = new ga("", (byte) 11, 4);
    private static final ga E = new ga("", (byte) 11, 5);
    private static final ga F = new ga("", (byte) 10, 7);
    private static final ga G = new ga("", (byte) 11, 8);
    private static final ga H = new ga("", (byte) 13, 9);
    private static final ga I = new ga("", (byte) 11, 10);
    private static final ga J = new ga("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24788a = new BitSet(1);

    /* renamed from: a, reason: collision with root package name */
    public long f389210a = 0;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m358a() {
        return this.f24787a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m360b() {
        return this.f24786a != null;
    }

    public boolean c() {
        return this.f389211b != null;
    }

    public boolean d() {
        return this.f389212c != null;
    }

    public boolean e() {
        return this.f389213d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gw)) {
            return false;
        }
        return m359a((gw) obj);
    }

    public boolean f() {
        return this.f24788a.get(0);
    }

    public boolean g() {
        if (this.f389214e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f24789a != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389215f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f389216g != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionAckNotification(");
        boolean z17 = false;
        if (m358a()) {
            sb5.append("debug:");
            String str = this.f24787a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m360b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24786a;
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
        String str2 = this.f389211b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        if (d()) {
            sb5.append(", ");
            sb5.append("appId:");
            String str3 = this.f389212c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("type:");
            String str4 = this.f389213d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("errorCode:");
            sb5.append(this.f389210a);
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("reason:");
            String str5 = this.f389214e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("extra:");
            Map<String, String> map = this.f24789a;
            if (map == null) {
                sb5.append("null");
            } else {
                sb5.append(map);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str6 = this.f389215f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("category:");
            String str7 = this.f389216g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public gw a(gu guVar) {
        this.f24786a = guVar;
        return this;
    }

    public gw b(String str) {
        this.f389212c = str;
        return this;
    }

    public gw c(String str) {
        this.f389213d = str;
        return this;
    }

    public gw d(String str) {
        this.f389214e = str;
        return this;
    }

    public gw e(String str) {
        this.f389215f = str;
        return this;
    }

    public String a() {
        return this.f389211b;
    }

    public String b() {
        return this.f389213d;
    }

    public gw a(String str) {
        this.f389211b = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m357a();
        hnVar.t(f389207h);
        if (this.f24787a != null && m358a()) {
            hnVar.q(f389208i);
            hnVar.u(this.f24787a);
            hnVar.z();
        }
        if (this.f24786a != null && m360b()) {
            hnVar.q(f389209m);
            this.f24786a.b(hnVar);
            hnVar.z();
        }
        if (this.f389211b != null) {
            hnVar.q(C);
            hnVar.u(this.f389211b);
            hnVar.z();
        }
        if (this.f389212c != null && d()) {
            hnVar.q(D);
            hnVar.u(this.f389212c);
            hnVar.z();
        }
        if (this.f389213d != null && e()) {
            hnVar.q(E);
            hnVar.u(this.f389213d);
            hnVar.z();
        }
        if (f()) {
            hnVar.q(F);
            hnVar.p(this.f389210a);
            hnVar.z();
        }
        if (this.f389214e != null && g()) {
            hnVar.q(G);
            hnVar.u(this.f389214e);
            hnVar.z();
        }
        if (this.f24789a != null && h()) {
            hnVar.q(H);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24789a.size()));
            for (Map.Entry<String, String> entry : this.f24789a.entrySet()) {
                hnVar.u(entry.getKey());
                hnVar.u(entry.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        if (this.f389215f != null && i()) {
            hnVar.q(I);
            hnVar.u(this.f389215f);
            hnVar.z();
        }
        if (this.f389216g != null && j()) {
            hnVar.q(J);
            hnVar.u(this.f389216g);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public gw a(long j3) {
        this.f389210a = j3;
        a(true);
        return this;
    }

    public void a(boolean z16) {
        this.f24788a.set(0, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m356a() {
        return this.f24789a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m359a(gw gwVar) {
        if (gwVar == null) {
            return false;
        }
        boolean m358a = m358a();
        boolean m358a2 = gwVar.m358a();
        if ((m358a || m358a2) && !(m358a && m358a2 && this.f24787a.equals(gwVar.f24787a))) {
            return false;
        }
        boolean m360b = m360b();
        boolean m360b2 = gwVar.m360b();
        if ((m360b || m360b2) && !(m360b && m360b2 && this.f24786a.m353a(gwVar.f24786a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = gwVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f389211b.equals(gwVar.f389211b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = gwVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389212c.equals(gwVar.f389212c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = gwVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389213d.equals(gwVar.f389213d))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = gwVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389210a == gwVar.f389210a)) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = gwVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389214e.equals(gwVar.f389214e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = gwVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f24789a.equals(gwVar.f24789a))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = gwVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389215f.equals(gwVar.f389215f))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = gwVar.j();
        if (j3 || j16) {
            return j3 && j16 && this.f389216g.equals(gwVar.f389216g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gw gwVar) {
        int e16;
        int e17;
        int h16;
        int e18;
        int c16;
        int e19;
        int e26;
        int e27;
        int d16;
        int e28;
        if (!getClass().equals(gwVar.getClass())) {
            return getClass().getName().compareTo(gwVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m358a()).compareTo(Boolean.valueOf(gwVar.m358a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m358a() && (e28 = fw.e(this.f24787a, gwVar.f24787a)) != 0) {
            return e28;
        }
        int compareTo2 = Boolean.valueOf(m360b()).compareTo(Boolean.valueOf(gwVar.m360b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m360b() && (d16 = fw.d(this.f24786a, gwVar.f24786a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gwVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e27 = fw.e(this.f389211b, gwVar.f389211b)) != 0) {
            return e27;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gwVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e26 = fw.e(this.f389212c, gwVar.f389212c)) != 0) {
            return e26;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gwVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e19 = fw.e(this.f389213d, gwVar.f389213d)) != 0) {
            return e19;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gwVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (c16 = fw.c(this.f389210a, gwVar.f389210a)) != 0) {
            return c16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gwVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e18 = fw.e(this.f389214e, gwVar.f389214e)) != 0) {
            return e18;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gwVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (h16 = fw.h(this.f24789a, gwVar.f24789a)) != 0) {
            return h16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gwVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e17 = fw.e(this.f389215f, gwVar.f389215f)) != 0) {
            return e17;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gwVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (e16 = fw.e(this.f389216g, gwVar.f389216g)) == 0) {
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
                m357a();
                return;
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24787a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24786a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389211b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389212c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389213d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                default:
                    hp.a(hnVar, b16);
                    break;
                case 7:
                    if (b16 == 10) {
                        this.f389210a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389214e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 13) {
                        gd g16 = hnVar.g();
                        this.f24789a = new HashMap(g16.f388950c * 2);
                        for (int i3 = 0; i3 < g16.f388950c; i3++) {
                            this.f24789a.put(hnVar.j(), hnVar.j());
                        }
                        hnVar.F();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389215f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 11) {
                        this.f389216g = hnVar.j();
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
    public void m357a() {
        if (this.f389211b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
