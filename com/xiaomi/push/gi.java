package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gi implements hq<gi, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389010d = new hs("ClientUploadData");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389011e = new ga("", RegisterType.DOUBLE_HI, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<gj> f389012a;

    public int a() {
        List<gj> list = this.f389012a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m306a();
        hnVar.t(f389010d);
        if (this.f389012a != null) {
            hnVar.q(f389011e);
            hnVar.r(new gc((byte) 12, this.f389012a.size()));
            Iterator<gj> it = this.f389012a.iterator();
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
        if (obj == null || !(obj instanceof gi)) {
            return false;
        }
        return m308a((gi) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("ClientUploadData(");
        sb5.append("uploadDataItems:");
        List<gj> list = this.f389012a;
        if (list == null) {
            sb5.append("null");
        } else {
            sb5.append(list);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public void a(gj gjVar) {
        if (this.f389012a == null) {
            this.f389012a = new ArrayList();
        }
        this.f389012a.add(gjVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m307a() {
        return this.f389012a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m308a(gi giVar) {
        if (giVar == null) {
            return false;
        }
        boolean m307a = m307a();
        boolean m307a2 = giVar.m307a();
        if (m307a || m307a2) {
            return m307a && m307a2 && this.f389012a.equals(giVar.f389012a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gi giVar) {
        int g16;
        if (!getClass().equals(giVar.getClass())) {
            return getClass().getName().compareTo(giVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m307a()).compareTo(Boolean.valueOf(giVar.m307a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m307a() || (g16 = fw.g(this.f389012a, giVar.f389012a)) == 0) {
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
                m306a();
                return;
            }
            if (e16.f388942c != 1) {
                hp.a(hnVar, b16);
            } else if (b16 == 15) {
                gc f16 = hnVar.f();
                this.f389012a = new ArrayList(f16.f388947b);
                for (int i3 = 0; i3 < f16.f388947b; i3++) {
                    gj gjVar = new gj();
                    gjVar.a(hnVar);
                    this.f389012a.add(gjVar);
                }
                hnVar.G();
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m306a() {
        if (this.f389012a != null) {
            return;
        }
        throw new ib("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
}
