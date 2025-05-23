package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hc implements hq<hc, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389251d = new hs("XmPushActionCustomConfig");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389252e = new ga("", RegisterType.DOUBLE_HI, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<gq> f389253a;

    public List<gq> a() {
        return this.f389253a;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m384a();
        hnVar.t(f389251d);
        if (this.f389253a != null) {
            hnVar.q(f389252e);
            hnVar.r(new gc((byte) 12, this.f389253a.size()));
            Iterator<gq> it = this.f389253a.iterator();
            while (it.hasNext()) {
                it.next().b(hnVar);
            }
            hnVar.C();
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hc)) {
            return false;
        }
        return m386a((hc) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("XmPushActionCustomConfig(");
        sb5.append("customConfigs:");
        List<gq> list = this.f389253a;
        if (list == null) {
            sb5.append("null");
        } else {
            sb5.append(list);
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m385a() {
        return this.f389253a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m386a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean m385a = m385a();
        boolean m385a2 = hcVar.m385a();
        if (m385a || m385a2) {
            return m385a && m385a2 && this.f389253a.equals(hcVar.f389253a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hc hcVar) {
        int g16;
        if (!getClass().equals(hcVar.getClass())) {
            return getClass().getName().compareTo(hcVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m385a()).compareTo(Boolean.valueOf(hcVar.m385a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m385a() || (g16 = fw.g(this.f389253a, hcVar.f389253a)) == 0) {
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
                m384a();
                return;
            }
            if (e16.f388942c != 1) {
                hp.a(hnVar, b16);
            } else if (b16 == 15) {
                gc f16 = hnVar.f();
                this.f389253a = new ArrayList(f16.f388947b);
                for (int i3 = 0; i3 < f16.f388947b; i3++) {
                    gq gqVar = new gq();
                    gqVar.a(hnVar);
                    this.f389253a.add(gqVar);
                }
                hnVar.G();
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m384a() {
        if (this.f389253a != null) {
            return;
        }
        throw new ib("Required field 'customConfigs' was not present! Struct: " + toString());
    }
}
