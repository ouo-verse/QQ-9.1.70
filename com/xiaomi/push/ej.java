package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ej implements hq<ej, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public byte f388726a;

    /* renamed from: a, reason: collision with other field name */
    public int f24713a;

    /* renamed from: a, reason: collision with other field name */
    public String f24714a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24715a = new BitSet(6);

    /* renamed from: b, reason: collision with root package name */
    public int f388727b;

    /* renamed from: b, reason: collision with other field name */
    public String f24716b;

    /* renamed from: c, reason: collision with root package name */
    public int f388728c;

    /* renamed from: c, reason: collision with other field name */
    public String f24717c;

    /* renamed from: d, reason: collision with root package name */
    public int f388729d;

    /* renamed from: d, reason: collision with other field name */
    public String f24718d;

    /* renamed from: e, reason: collision with root package name */
    public int f388730e;

    /* renamed from: f, reason: collision with root package name */
    private static final hs f388722f = new hs("StatsEvent");

    /* renamed from: h, reason: collision with root package name */
    private static final ga f388723h = new ga("", (byte) 3, 1);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f388724i = new ga("", (byte) 8, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f388725m = new ga("", (byte) 8, 3);
    private static final ga C = new ga("", (byte) 11, 4);
    private static final ga D = new ga("", (byte) 11, 5);
    private static final ga E = new ga("", (byte) 8, 6);
    private static final ga F = new ga("", (byte) 11, 7);
    private static final ga G = new ga("", (byte) 11, 8);
    private static final ga H = new ga("", (byte) 8, 9);
    private static final ga I = new ga("", (byte) 8, 10);

    public ej a(byte b16) {
        this.f388726a = b16;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f24715a.get(1);
    }

    public boolean c() {
        return this.f24715a.get(2);
    }

    public boolean d() {
        return this.f24714a != null;
    }

    public boolean e() {
        return this.f24716b != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ej)) {
            return false;
        }
        return m303a((ej) obj);
    }

    public boolean f() {
        return this.f24715a.get(3);
    }

    public boolean g() {
        if (this.f24717c != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f24718d != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f24715a.get(4);
    }

    public boolean j() {
        return this.f24715a.get(5);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("StatsEvent(");
        sb5.append("chid:");
        sb5.append((int) this.f388726a);
        sb5.append(", ");
        sb5.append("type:");
        sb5.append(this.f24713a);
        sb5.append(", ");
        sb5.append("value:");
        sb5.append(this.f388727b);
        sb5.append(", ");
        sb5.append("connpt:");
        String str = this.f24714a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(str);
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("host:");
            String str2 = this.f24716b;
            if (str2 == null) {
                sb5.append("null");
            } else {
                sb5.append(str2);
            }
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("subvalue:");
            sb5.append(this.f388728c);
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("annotation:");
            String str3 = this.f24717c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("user:");
            String str4 = this.f24718d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("time:");
            sb5.append(this.f388729d);
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("clientIp:");
            sb5.append(this.f388730e);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public void b(boolean z16) {
        this.f24715a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24715a.set(2, z16);
    }

    public void d(boolean z16) {
        this.f24715a.set(3, z16);
    }

    public void e(boolean z16) {
        this.f24715a.set(4, z16);
    }

    public void f(boolean z16) {
        this.f24715a.set(5, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m302a() {
        return this.f24715a.get(0);
    }

    public ej b(int i3) {
        this.f388727b = i3;
        c(true);
        return this;
    }

    public ej c(int i3) {
        this.f388728c = i3;
        d(true);
        return this;
    }

    public ej d(String str) {
        this.f24718d = str;
        return this;
    }

    public void a(boolean z16) {
        this.f24715a.set(0, z16);
    }

    public ej d(int i3) {
        this.f388729d = i3;
        e(true);
        return this;
    }

    public ej a(int i3) {
        this.f24713a = i3;
        b(true);
        return this;
    }

    public ej b(String str) {
        this.f24716b = str;
        return this;
    }

    public ej c(String str) {
        this.f24717c = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f388722f);
        hnVar.q(f388723h);
        hnVar.n(this.f388726a);
        hnVar.z();
        hnVar.q(f388724i);
        hnVar.o(this.f24713a);
        hnVar.z();
        hnVar.q(f388725m);
        hnVar.o(this.f388727b);
        hnVar.z();
        if (this.f24714a != null) {
            hnVar.q(C);
            hnVar.u(this.f24714a);
            hnVar.z();
        }
        if (this.f24716b != null && e()) {
            hnVar.q(D);
            hnVar.u(this.f24716b);
            hnVar.z();
        }
        if (f()) {
            hnVar.q(E);
            hnVar.o(this.f388728c);
            hnVar.z();
        }
        if (this.f24717c != null && g()) {
            hnVar.q(F);
            hnVar.u(this.f24717c);
            hnVar.z();
        }
        if (this.f24718d != null && h()) {
            hnVar.q(G);
            hnVar.u(this.f24718d);
            hnVar.z();
        }
        if (i()) {
            hnVar.q(H);
            hnVar.o(this.f388729d);
            hnVar.z();
        }
        if (j()) {
            hnVar.q(I);
            hnVar.o(this.f388730e);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public ej a(String str) {
        this.f24714a = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m303a(ej ejVar) {
        if (ejVar == null || this.f388726a != ejVar.f388726a || this.f24713a != ejVar.f24713a || this.f388727b != ejVar.f388727b) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = ejVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f24714a.equals(ejVar.f24714a))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = ejVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f24716b.equals(ejVar.f24716b))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = ejVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f388728c == ejVar.f388728c)) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = ejVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f24717c.equals(ejVar.f24717c))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = ejVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f24718d.equals(ejVar.f24718d))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = ejVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f388729d == ejVar.f388729d)) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = ejVar.j();
        if (j3 || j16) {
            return j3 && j16 && this.f388730e == ejVar.f388730e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ej ejVar) {
        int b16;
        int b17;
        int e16;
        int e17;
        int b18;
        int e18;
        int e19;
        int b19;
        int b26;
        int a16;
        if (!getClass().equals(ejVar.getClass())) {
            return getClass().getName().compareTo(ejVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m302a()).compareTo(Boolean.valueOf(ejVar.m302a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m302a() && (a16 = fw.a(this.f388726a, ejVar.f388726a)) != 0) {
            return a16;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ejVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (b26 = fw.b(this.f24713a, ejVar.f24713a)) != 0) {
            return b26;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ejVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (b19 = fw.b(this.f388727b, ejVar.f388727b)) != 0) {
            return b19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ejVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e19 = fw.e(this.f24714a, ejVar.f24714a)) != 0) {
            return e19;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ejVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e18 = fw.e(this.f24716b, ejVar.f24716b)) != 0) {
            return e18;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ejVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (b18 = fw.b(this.f388728c, ejVar.f388728c)) != 0) {
            return b18;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ejVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e17 = fw.e(this.f24717c, ejVar.f24717c)) != 0) {
            return e17;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ejVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e16 = fw.e(this.f24718d, ejVar.f24718d)) != 0) {
            return e16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ejVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (b17 = fw.b(this.f388729d, ejVar.f388729d)) != 0) {
            return b17;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ejVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (b16 = fw.b(this.f388730e, ejVar.f388730e)) == 0) {
            return 0;
        }
        return b16;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                hnVar.D();
                if (m302a()) {
                    if (b()) {
                        if (c()) {
                            a();
                            return;
                        }
                        throw new ib("Required field 'value' was not found in serialized data! Struct: " + toString());
                    }
                    throw new ib("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                throw new ib("Required field 'chid' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 3) {
                        this.f388726a = hnVar.a();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 8) {
                        this.f24713a = hnVar.c();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 8) {
                        this.f388727b = hnVar.c();
                        c(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f24714a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f24716b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 8) {
                        this.f388728c = hnVar.c();
                        d(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f24717c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f24718d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 8) {
                        this.f388729d = hnVar.c();
                        e(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 8) {
                        this.f388730e = hnVar.c();
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

    public void a() {
        if (this.f24714a != null) {
            return;
        }
        throw new ib("Required field 'connpt' was not present! Struct: " + toString());
    }
}
