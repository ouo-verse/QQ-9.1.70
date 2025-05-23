package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gu implements hq<gu, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public String f24774a;

    /* renamed from: d, reason: collision with root package name */
    public String f389193d;

    /* renamed from: e, reason: collision with root package name */
    private static final hs f389185e = new hs("Target");

    /* renamed from: f, reason: collision with root package name */
    private static final ga f389186f = new ga("", (byte) 10, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389187h = new ga("", (byte) 11, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389188i = new ga("", (byte) 11, 3);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389189m = new ga("", (byte) 11, 4);
    private static final ga C = new ga("", (byte) 2, 5);
    private static final ga D = new ga("", (byte) 11, 7);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24775a = new BitSet(2);

    /* renamed from: a, reason: collision with root package name */
    public long f389190a = 5;

    /* renamed from: b, reason: collision with root package name */
    public String f389191b = "xiaomi.com";

    /* renamed from: c, reason: collision with root package name */
    public String f389192c = "";

    /* renamed from: a, reason: collision with other field name */
    public boolean f24776a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m352a() {
        return this.f24775a.get(0);
    }

    public boolean b() {
        return this.f24774a != null;
    }

    public boolean c() {
        if (this.f389191b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f389192c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f24775a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gu)) {
            return false;
        }
        return m353a((gu) obj);
    }

    public boolean f() {
        if (this.f389193d != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("Target(");
        sb5.append("channelId:");
        sb5.append(this.f389190a);
        sb5.append(", ");
        sb5.append("userId:");
        String str = this.f24774a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(str);
        }
        if (c()) {
            sb5.append(", ");
            sb5.append("server:");
            String str2 = this.f389191b;
            if (str2 == null) {
                sb5.append("null");
            } else {
                sb5.append(str2);
            }
        }
        if (d()) {
            sb5.append(", ");
            sb5.append("resource:");
            String str3 = this.f389192c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("isPreview:");
            sb5.append(this.f24776a);
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("token:");
            String str4 = this.f389193d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public void a(boolean z16) {
        this.f24775a.set(0, z16);
    }

    public void b(boolean z16) {
        this.f24775a.set(1, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m353a(gu guVar) {
        if (guVar == null || this.f389190a != guVar.f389190a) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = guVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24774a.equals(guVar.f24774a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = guVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f389191b.equals(guVar.f389191b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = guVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389192c.equals(guVar.f389192c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = guVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f24776a == guVar.f24776a)) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = guVar.f();
        if (f16 || f17) {
            return f16 && f17 && this.f389193d.equals(guVar.f389193d);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f389185e);
        hnVar.q(f389186f);
        hnVar.p(this.f389190a);
        hnVar.z();
        if (this.f24774a != null) {
            hnVar.q(f389187h);
            hnVar.u(this.f24774a);
            hnVar.z();
        }
        if (this.f389191b != null && c()) {
            hnVar.q(f389188i);
            hnVar.u(this.f389191b);
            hnVar.z();
        }
        if (this.f389192c != null && d()) {
            hnVar.q(f389189m);
            hnVar.u(this.f389192c);
            hnVar.z();
        }
        if (e()) {
            hnVar.q(C);
            hnVar.x(this.f24776a);
            hnVar.z();
        }
        if (this.f389193d != null && f()) {
            hnVar.q(D);
            hnVar.u(this.f389193d);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gu guVar) {
        int e16;
        int k3;
        int e17;
        int e18;
        int e19;
        int c16;
        if (!getClass().equals(guVar.getClass())) {
            return getClass().getName().compareTo(guVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m352a()).compareTo(Boolean.valueOf(guVar.m352a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m352a() && (c16 = fw.c(this.f389190a, guVar.f389190a)) != 0) {
            return c16;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(guVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (e19 = fw.e(this.f24774a, guVar.f24774a)) != 0) {
            return e19;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(guVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e18 = fw.e(this.f389191b, guVar.f389191b)) != 0) {
            return e18;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(guVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e17 = fw.e(this.f389192c, guVar.f389192c)) != 0) {
            return e17;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(guVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (k3 = fw.k(this.f24776a, guVar.f24776a)) != 0) {
            return k3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(guVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (e16 = fw.e(this.f389193d, guVar.f389193d)) == 0) {
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
                break;
            }
            short s16 = e16.f388942c;
            if (s16 != 1) {
                if (s16 != 2) {
                    if (s16 != 3) {
                        if (s16 != 4) {
                            if (s16 != 5) {
                                if (s16 != 7) {
                                    hp.a(hnVar, b16);
                                } else if (b16 == 11) {
                                    this.f389193d = hnVar.j();
                                } else {
                                    hp.a(hnVar, b16);
                                }
                            } else if (b16 == 2) {
                                this.f24776a = hnVar.y();
                                b(true);
                            } else {
                                hp.a(hnVar, b16);
                            }
                        } else if (b16 == 11) {
                            this.f389192c = hnVar.j();
                        } else {
                            hp.a(hnVar, b16);
                        }
                    } else if (b16 == 11) {
                        this.f389191b = hnVar.j();
                    } else {
                        hp.a(hnVar, b16);
                    }
                } else if (b16 == 11) {
                    this.f24774a = hnVar.j();
                } else {
                    hp.a(hnVar, b16);
                }
            } else if (b16 == 10) {
                this.f389190a = hnVar.d();
                a(true);
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
        hnVar.D();
        if (m352a()) {
            a();
            return;
        }
        throw new ib("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a() {
        if (this.f24774a != null) {
            return;
        }
        throw new ib("Required field 'userId' was not present! Struct: " + toString());
    }
}
