package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hd implements hq<hd, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389254d = new hs("XmPushActionNormalConfig");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389255e = new ga("", RegisterType.DOUBLE_HI, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<go> f389256a;

    public List<go> a() {
        return this.f389256a;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m387a();
        hnVar.t(f389254d);
        if (this.f389256a != null) {
            hnVar.q(f389255e);
            hnVar.r(new gc((byte) 12, this.f389256a.size()));
            Iterator<go> it = this.f389256a.iterator();
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
        if (obj == null || !(obj instanceof hd)) {
            return false;
        }
        return m389a((hd) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("XmPushActionNormalConfig(");
        sb5.append("normalConfigs:");
        List<go> list = this.f389256a;
        if (list == null) {
            sb5.append("null");
        } else {
            sb5.append(list);
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m388a() {
        return this.f389256a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m389a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean m388a = m388a();
        boolean m388a2 = hdVar.m388a();
        if (m388a || m388a2) {
            return m388a && m388a2 && this.f389256a.equals(hdVar.f389256a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hd hdVar) {
        int g16;
        if (!getClass().equals(hdVar.getClass())) {
            return getClass().getName().compareTo(hdVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m388a()).compareTo(Boolean.valueOf(hdVar.m388a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m388a() || (g16 = fw.g(this.f389256a, hdVar.f389256a)) == 0) {
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
                m387a();
                return;
            }
            if (e16.f388942c != 1) {
                hp.a(hnVar, b16);
            } else if (b16 == 15) {
                gc f16 = hnVar.f();
                this.f389256a = new ArrayList(f16.f388947b);
                for (int i3 = 0; i3 < f16.f388947b; i3++) {
                    go goVar = new go();
                    goVar.a(hnVar);
                    this.f389256a.add(goVar);
                }
                hnVar.G();
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m387a() {
        if (this.f389256a != null) {
            return;
        }
        throw new ib("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
}
