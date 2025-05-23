package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gq implements hq<gq, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f389157a;

    /* renamed from: a, reason: collision with other field name */
    public long f24751a;

    /* renamed from: a, reason: collision with other field name */
    public String f24752a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24753a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24754a;

    /* renamed from: b, reason: collision with root package name */
    public int f389158b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f24755b;

    /* renamed from: c, reason: collision with root package name */
    public int f389159c;

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389151d = new hs("OnlineConfigItem");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389152e = new ga("", (byte) 8, 1);

    /* renamed from: f, reason: collision with root package name */
    private static final ga f389153f = new ga("", (byte) 8, 2);

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389154h = new ga("", (byte) 2, 3);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389155i = new ga("", (byte) 8, 4);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389156m = new ga("", (byte) 10, 5);
    private static final ga C = new ga("", (byte) 11, 6);
    private static final ga D = new ga("", (byte) 2, 7);

    /* renamed from: a, reason: collision with other method in class */
    public void m328a() {
    }

    public int b() {
        return this.f389158b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m332c() {
        return this.f24753a.get(2);
    }

    public boolean d() {
        return this.f24753a.get(3);
    }

    public boolean e() {
        return this.f24753a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gq)) {
            return false;
        }
        return m330a((gq) obj);
    }

    public boolean f() {
        return this.f24752a != null;
    }

    public boolean g() {
        return this.f24755b;
    }

    public boolean h() {
        return this.f24753a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("OnlineConfigItem(");
        boolean z17 = false;
        if (m329a()) {
            sb5.append("key:");
            sb5.append(this.f389157a);
            z16 = false;
        } else {
            z16 = true;
        }
        if (m331b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("type:");
            sb5.append(this.f389158b);
            z16 = false;
        }
        if (m332c()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("clear:");
            sb5.append(this.f24754a);
            z16 = false;
        }
        if (d()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("intValue:");
            sb5.append(this.f389159c);
            z16 = false;
        }
        if (e()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("longValue:");
            sb5.append(this.f24751a);
            z16 = false;
        }
        if (f()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("stringValue:");
            String str = this.f24752a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
        } else {
            z17 = z16;
        }
        if (h()) {
            if (!z17) {
                sb5.append(", ");
            }
            sb5.append("boolValue:");
            sb5.append(this.f24755b);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public int a() {
        return this.f389157a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m331b() {
        return this.f24753a.get(1);
    }

    public void c(boolean z16) {
        this.f24753a.set(2, z16);
    }

    public void d(boolean z16) {
        this.f24753a.set(3, z16);
    }

    public void e(boolean z16) {
        this.f24753a.set(4, z16);
    }

    public void f(boolean z16) {
        this.f24753a.set(5, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m329a() {
        return this.f24753a.get(0);
    }

    public void b(boolean z16) {
        this.f24753a.set(1, z16);
    }

    public int c() {
        return this.f389159c;
    }

    public void a(boolean z16) {
        this.f24753a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m328a();
        hnVar.t(f389151d);
        if (m329a()) {
            hnVar.q(f389152e);
            hnVar.o(this.f389157a);
            hnVar.z();
        }
        if (m331b()) {
            hnVar.q(f389153f);
            hnVar.o(this.f389158b);
            hnVar.z();
        }
        if (m332c()) {
            hnVar.q(f389154h);
            hnVar.x(this.f24754a);
            hnVar.z();
        }
        if (d()) {
            hnVar.q(f389155i);
            hnVar.o(this.f389159c);
            hnVar.z();
        }
        if (e()) {
            hnVar.q(f389156m);
            hnVar.p(this.f24751a);
            hnVar.z();
        }
        if (this.f24752a != null && f()) {
            hnVar.q(C);
            hnVar.u(this.f24752a);
            hnVar.z();
        }
        if (h()) {
            hnVar.q(D);
            hnVar.x(this.f24755b);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m326a() {
        return this.f24751a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m327a() {
        return this.f24752a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m330a(gq gqVar) {
        if (gqVar == null) {
            return false;
        }
        boolean m329a = m329a();
        boolean m329a2 = gqVar.m329a();
        if ((m329a || m329a2) && !(m329a && m329a2 && this.f389157a == gqVar.f389157a)) {
            return false;
        }
        boolean m331b = m331b();
        boolean m331b2 = gqVar.m331b();
        if ((m331b || m331b2) && !(m331b && m331b2 && this.f389158b == gqVar.f389158b)) {
            return false;
        }
        boolean m332c = m332c();
        boolean m332c2 = gqVar.m332c();
        if ((m332c || m332c2) && !(m332c && m332c2 && this.f24754a == gqVar.f24754a)) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = gqVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389159c == gqVar.f389159c)) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = gqVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f24751a == gqVar.f24751a)) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = gqVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f24752a.equals(gqVar.f24752a))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = gqVar.h();
        if (h16 || h17) {
            return h16 && h17 && this.f24755b == gqVar.f24755b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gq gqVar) {
        int k3;
        int e16;
        int c16;
        int b16;
        int k16;
        int b17;
        int b18;
        if (!getClass().equals(gqVar.getClass())) {
            return getClass().getName().compareTo(gqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m329a()).compareTo(Boolean.valueOf(gqVar.m329a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m329a() && (b18 = fw.b(this.f389157a, gqVar.f389157a)) != 0) {
            return b18;
        }
        int compareTo2 = Boolean.valueOf(m331b()).compareTo(Boolean.valueOf(gqVar.m331b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m331b() && (b17 = fw.b(this.f389158b, gqVar.f389158b)) != 0) {
            return b17;
        }
        int compareTo3 = Boolean.valueOf(m332c()).compareTo(Boolean.valueOf(gqVar.m332c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m332c() && (k16 = fw.k(this.f24754a, gqVar.f24754a)) != 0) {
            return k16;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gqVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (b16 = fw.b(this.f389159c, gqVar.f389159c)) != 0) {
            return b16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gqVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c16 = fw.c(this.f24751a, gqVar.f24751a)) != 0) {
            return c16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gqVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e16 = fw.e(this.f24752a, gqVar.f24752a)) != 0) {
            return e16;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gqVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!h() || (k3 = fw.k(this.f24755b, gqVar.f24755b)) == 0) {
            return 0;
        }
        return k3;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                hnVar.D();
                m328a();
                return;
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 8) {
                        this.f389157a = hnVar.c();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 8) {
                        this.f389158b = hnVar.c();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 2) {
                        this.f24754a = hnVar.y();
                        c(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 8) {
                        this.f389159c = hnVar.c();
                        d(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 10) {
                        this.f24751a = hnVar.d();
                        e(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 11) {
                        this.f24752a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 2) {
                        this.f24755b = hnVar.y();
                        f(true);
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
