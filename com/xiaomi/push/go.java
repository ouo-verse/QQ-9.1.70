package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class go implements hq<go, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389111d = new hs("NormalConfig");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389112e = new ga("", (byte) 8, 1);

    /* renamed from: f, reason: collision with root package name */
    private static final ga f389113f = new ga("", RegisterType.DOUBLE_HI, 2);

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389114h = new ga("", (byte) 8, 3);

    /* renamed from: a, reason: collision with root package name */
    public int f389115a;

    /* renamed from: a, reason: collision with other field name */
    public gl f24746a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24747a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public List<gq> f24748a;

    public int a() {
        return this.f389115a;
    }

    public boolean b() {
        return this.f24748a != null;
    }

    public boolean c() {
        if (this.f24746a != null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof go)) {
            return false;
        }
        return m325a((go) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("NormalConfig(");
        sb5.append("version:");
        sb5.append(this.f389115a);
        sb5.append(", ");
        sb5.append("configItems:");
        List<gq> list = this.f24748a;
        if (list == null) {
            sb5.append("null");
        } else {
            sb5.append(list);
        }
        if (c()) {
            sb5.append(", ");
            sb5.append("type:");
            gl glVar = this.f24746a;
            if (glVar == null) {
                sb5.append("null");
            } else {
                sb5.append(glVar);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m324a() {
        return this.f24747a.get(0);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m323a();
        hnVar.t(f389111d);
        hnVar.q(f389112e);
        hnVar.o(this.f389115a);
        hnVar.z();
        if (this.f24748a != null) {
            hnVar.q(f389113f);
            hnVar.r(new gc((byte) 12, this.f24748a.size()));
            Iterator<gq> it = this.f24748a.iterator();
            while (it.hasNext()) {
                it.next().b(hnVar);
            }
            hnVar.C();
            hnVar.z();
        }
        if (this.f24746a != null && c()) {
            hnVar.q(f389114h);
            hnVar.o(this.f24746a.a());
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public void a(boolean z16) {
        this.f24747a.set(0, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public gl m322a() {
        return this.f24746a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m325a(go goVar) {
        if (goVar == null || this.f389115a != goVar.f389115a) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = goVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24748a.equals(goVar.f24748a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = goVar.c();
        if (c16 || c17) {
            return c16 && c17 && this.f24746a.equals(goVar.f24746a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(go goVar) {
        int d16;
        int g16;
        int b16;
        if (!getClass().equals(goVar.getClass())) {
            return getClass().getName().compareTo(goVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m324a()).compareTo(Boolean.valueOf(goVar.m324a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m324a() && (b16 = fw.b(this.f389115a, goVar.f389115a)) != 0) {
            return b16;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(goVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (g16 = fw.g(this.f24748a, goVar.f24748a)) != 0) {
            return g16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(goVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (d16 = fw.d(this.f24746a, goVar.f24746a)) == 0) {
            return 0;
        }
        return d16;
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
                        hp.a(hnVar, b16);
                    } else if (b16 == 8) {
                        this.f24746a = gl.a(hnVar.c());
                    } else {
                        hp.a(hnVar, b16);
                    }
                } else if (b16 == 15) {
                    gc f16 = hnVar.f();
                    this.f24748a = new ArrayList(f16.f388947b);
                    for (int i3 = 0; i3 < f16.f388947b; i3++) {
                        gq gqVar = new gq();
                        gqVar.a(hnVar);
                        this.f24748a.add(gqVar);
                    }
                    hnVar.G();
                } else {
                    hp.a(hnVar, b16);
                }
            } else if (b16 == 8) {
                this.f389115a = hnVar.c();
                a(true);
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
        hnVar.D();
        if (m324a()) {
            m323a();
            return;
        }
        throw new ib("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m323a() {
        if (this.f24748a != null) {
            return;
        }
        throw new ib("Required field 'configItems' was not present! Struct: " + toString());
    }
}
