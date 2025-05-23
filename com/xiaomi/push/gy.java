package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gy implements hq<gy, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389222d = new hs("XmPushActionCollectData");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389223e = new ga("", RegisterType.DOUBLE_HI, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<gn> f389224a;

    public gy a(List<gn> list) {
        this.f389224a = list;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f389222d);
        if (this.f389224a != null) {
            hnVar.q(f389223e);
            hnVar.r(new gc((byte) 12, this.f389224a.size()));
            Iterator<gn> it = this.f389224a.iterator();
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
        if (obj == null || !(obj instanceof gy)) {
            return false;
        }
        return m364a((gy) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("XmPushActionCollectData(");
        sb5.append("dataCollectionItems:");
        List<gn> list = this.f389224a;
        if (list == null) {
            sb5.append("null");
        } else {
            sb5.append(list);
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m363a() {
        return this.f389224a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m364a(gy gyVar) {
        if (gyVar == null) {
            return false;
        }
        boolean m363a = m363a();
        boolean m363a2 = gyVar.m363a();
        if (m363a || m363a2) {
            return m363a && m363a2 && this.f389224a.equals(gyVar.f389224a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gy gyVar) {
        int g16;
        if (!getClass().equals(gyVar.getClass())) {
            return getClass().getName().compareTo(gyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m363a()).compareTo(Boolean.valueOf(gyVar.m363a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m363a() || (g16 = fw.g(this.f389224a, gyVar.f389224a)) == 0) {
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
            if (e16.f388942c != 1) {
                hp.a(hnVar, b16);
            } else if (b16 == 15) {
                gc f16 = hnVar.f();
                this.f389224a = new ArrayList(f16.f388947b);
                for (int i3 = 0; i3 < f16.f388947b; i3++) {
                    gn gnVar = new gn();
                    gnVar.a(hnVar);
                    this.f389224a.add(gnVar);
                }
                hnVar.G();
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
    }

    public void a() {
        if (this.f389224a != null) {
            return;
        }
        throw new ib("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }
}
