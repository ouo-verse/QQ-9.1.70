package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ek implements hq<ek, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f388731d = new hs("StatsEvents");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f388732e = new ga("", (byte) 11, 1);

    /* renamed from: f, reason: collision with root package name */
    private static final ga f388733f = new ga("", (byte) 11, 2);

    /* renamed from: h, reason: collision with root package name */
    private static final ga f388734h = new ga("", RegisterType.DOUBLE_HI, 3);

    /* renamed from: a, reason: collision with root package name */
    public String f388735a;

    /* renamed from: a, reason: collision with other field name */
    public List<ej> f24719a;

    /* renamed from: b, reason: collision with root package name */
    public String f388736b;

    public ek() {
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m304a() {
        return this.f388735a != null;
    }

    public boolean b() {
        return this.f388736b != null;
    }

    public boolean c() {
        if (this.f24719a != null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ek)) {
            return false;
        }
        return m305a((ek) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("StatsEvents(");
        sb5.append("uuid:");
        String str = this.f388735a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(str);
        }
        if (b()) {
            sb5.append(", ");
            sb5.append("operator:");
            String str2 = this.f388736b;
            if (str2 == null) {
                sb5.append("null");
            } else {
                sb5.append(str2);
            }
        }
        sb5.append(", ");
        sb5.append("events:");
        List<ej> list = this.f24719a;
        if (list == null) {
            sb5.append("null");
        } else {
            sb5.append(list);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public ek(String str, List<ej> list) {
        this();
        this.f388735a = str;
        this.f24719a = list;
    }

    public ek a(String str) {
        this.f388736b = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f388731d);
        if (this.f388735a != null) {
            hnVar.q(f388732e);
            hnVar.u(this.f388735a);
            hnVar.z();
        }
        if (this.f388736b != null && b()) {
            hnVar.q(f388733f);
            hnVar.u(this.f388736b);
            hnVar.z();
        }
        if (this.f24719a != null) {
            hnVar.q(f388734h);
            hnVar.r(new gc((byte) 12, this.f24719a.size()));
            Iterator<ej> it = this.f24719a.iterator();
            while (it.hasNext()) {
                it.next().b(hnVar);
            }
            hnVar.C();
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m305a(ek ekVar) {
        if (ekVar == null) {
            return false;
        }
        boolean m304a = m304a();
        boolean m304a2 = ekVar.m304a();
        if ((m304a || m304a2) && !(m304a && m304a2 && this.f388735a.equals(ekVar.f388735a))) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = ekVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f388736b.equals(ekVar.f388736b))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = ekVar.c();
        if (c16 || c17) {
            return c16 && c17 && this.f24719a.equals(ekVar.f24719a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ek ekVar) {
        int g16;
        int e16;
        int e17;
        if (!getClass().equals(ekVar.getClass())) {
            return getClass().getName().compareTo(ekVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m304a()).compareTo(Boolean.valueOf(ekVar.m304a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m304a() && (e17 = fw.e(this.f388735a, ekVar.f388735a)) != 0) {
            return e17;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ekVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (e16 = fw.e(this.f388736b, ekVar.f388736b)) != 0) {
            return e16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ekVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (g16 = fw.g(this.f24719a, ekVar.f24719a)) == 0) {
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
            short s16 = e16.f388942c;
            if (s16 != 1) {
                if (s16 != 2) {
                    if (s16 != 3) {
                        hp.a(hnVar, b16);
                    } else if (b16 == 15) {
                        gc f16 = hnVar.f();
                        this.f24719a = new ArrayList(f16.f388947b);
                        for (int i3 = 0; i3 < f16.f388947b; i3++) {
                            ej ejVar = new ej();
                            ejVar.a(hnVar);
                            this.f24719a.add(ejVar);
                        }
                        hnVar.G();
                    } else {
                        hp.a(hnVar, b16);
                    }
                } else if (b16 == 11) {
                    this.f388736b = hnVar.j();
                } else {
                    hp.a(hnVar, b16);
                }
            } else if (b16 == 11) {
                this.f388735a = hnVar.j();
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
    }

    public void a() {
        if (this.f388735a != null) {
            if (this.f24719a != null) {
                return;
            }
            throw new ib("Required field 'events' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'uuid' was not present! Struct: " + toString());
    }
}
