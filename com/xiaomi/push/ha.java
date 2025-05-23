package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ha implements hq<ha, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389237a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24797a;

    /* renamed from: a, reason: collision with other field name */
    public String f24798a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f24800a;

    /* renamed from: b, reason: collision with root package name */
    public String f389238b;

    /* renamed from: c, reason: collision with root package name */
    public String f389239c;

    /* renamed from: d, reason: collision with root package name */
    public String f389240d;

    /* renamed from: e, reason: collision with root package name */
    public String f389241e;

    /* renamed from: f, reason: collision with root package name */
    public String f389242f;

    /* renamed from: h, reason: collision with root package name */
    private static final hs f389234h = new hs("XmPushActionCommandResult");

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389235i = new ga("", (byte) 12, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389236m = new ga("", (byte) 11, 3);
    private static final ga C = new ga("", (byte) 11, 4);
    private static final ga D = new ga("", (byte) 11, 5);
    private static final ga E = new ga("", (byte) 10, 7);
    private static final ga F = new ga("", (byte) 11, 8);
    private static final ga G = new ga("", (byte) 11, 9);
    private static final ga H = new ga("", RegisterType.DOUBLE_HI, 10);
    private static final ga I = new ga("", (byte) 11, 12);
    private static final ga J = new ga("", (byte) 2, 13);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24799a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24801a = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m371a() {
        return this.f24797a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m373b() {
        return this.f24798a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m374c() {
        return this.f389238b != null;
    }

    public boolean d() {
        if (this.f389239c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f24799a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ha)) {
            return false;
        }
        return m372a((ha) obj);
    }

    public boolean f() {
        if (this.f389240d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389241e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f24800a != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389242f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        return this.f24799a.get(1);
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionCommandResult(");
        if (m371a()) {
            sb5.append("target:");
            gu guVar = this.f24797a;
            if (guVar == null) {
                sb5.append("null");
            } else {
                sb5.append(guVar);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            sb5.append(", ");
        }
        sb5.append("id:");
        String str = this.f24798a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(str);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str2 = this.f389238b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("cmdName:");
        String str3 = this.f389239c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        sb5.append(", ");
        sb5.append("errorCode:");
        sb5.append(this.f389237a);
        if (f()) {
            sb5.append(", ");
            sb5.append("reason:");
            String str4 = this.f389240d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str5 = this.f389241e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("cmdArgs:");
            List<String> list = this.f24800a;
            if (list == null) {
                sb5.append("null");
            } else {
                sb5.append(list);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("category:");
            String str6 = this.f389242f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("response2Client:");
            sb5.append(this.f24801a);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public String a() {
        return this.f24798a;
    }

    public String b() {
        return this.f389239c;
    }

    public String c() {
        return this.f389242f;
    }

    public void a(boolean z16) {
        this.f24799a.set(0, z16);
    }

    public void b(boolean z16) {
        this.f24799a.set(1, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m369a() {
        return this.f24800a;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m370a();
        hnVar.t(f389234h);
        if (this.f24797a != null && m371a()) {
            hnVar.q(f389235i);
            this.f24797a.b(hnVar);
            hnVar.z();
        }
        if (this.f24798a != null) {
            hnVar.q(f389236m);
            hnVar.u(this.f24798a);
            hnVar.z();
        }
        if (this.f389238b != null) {
            hnVar.q(C);
            hnVar.u(this.f389238b);
            hnVar.z();
        }
        if (this.f389239c != null) {
            hnVar.q(D);
            hnVar.u(this.f389239c);
            hnVar.z();
        }
        hnVar.q(E);
        hnVar.p(this.f389237a);
        hnVar.z();
        if (this.f389240d != null && f()) {
            hnVar.q(F);
            hnVar.u(this.f389240d);
            hnVar.z();
        }
        if (this.f389241e != null && g()) {
            hnVar.q(G);
            hnVar.u(this.f389241e);
            hnVar.z();
        }
        if (this.f24800a != null && h()) {
            hnVar.q(H);
            hnVar.r(new gc((byte) 11, this.f24800a.size()));
            Iterator<String> it = this.f24800a.iterator();
            while (it.hasNext()) {
                hnVar.u(it.next());
            }
            hnVar.C();
            hnVar.z();
        }
        if (this.f389242f != null && i()) {
            hnVar.q(I);
            hnVar.u(this.f389242f);
            hnVar.z();
        }
        if (j()) {
            hnVar.q(J);
            hnVar.x(this.f24801a);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m372a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean m371a = m371a();
        boolean m371a2 = haVar.m371a();
        if ((m371a || m371a2) && !(m371a && m371a2 && this.f24797a.m353a(haVar.f24797a))) {
            return false;
        }
        boolean m373b = m373b();
        boolean m373b2 = haVar.m373b();
        if ((m373b || m373b2) && !(m373b && m373b2 && this.f24798a.equals(haVar.f24798a))) {
            return false;
        }
        boolean m374c = m374c();
        boolean m374c2 = haVar.m374c();
        if ((m374c || m374c2) && !(m374c && m374c2 && this.f389238b.equals(haVar.f389238b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = haVar.d();
        if (((d16 || d17) && !(d16 && d17 && this.f389239c.equals(haVar.f389239c))) || this.f389237a != haVar.f389237a) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = haVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389240d.equals(haVar.f389240d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = haVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389241e.equals(haVar.f389241e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = haVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f24800a.equals(haVar.f24800a))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = haVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389242f.equals(haVar.f389242f))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = haVar.j();
        if (j3 || j16) {
            return j3 && j16 && this.f24801a == haVar.f24801a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ha haVar) {
        int k3;
        int e16;
        int g16;
        int e17;
        int e18;
        int c16;
        int e19;
        int e26;
        int e27;
        int d16;
        if (!getClass().equals(haVar.getClass())) {
            return getClass().getName().compareTo(haVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m371a()).compareTo(Boolean.valueOf(haVar.m371a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m371a() && (d16 = fw.d(this.f24797a, haVar.f24797a)) != 0) {
            return d16;
        }
        int compareTo2 = Boolean.valueOf(m373b()).compareTo(Boolean.valueOf(haVar.m373b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m373b() && (e27 = fw.e(this.f24798a, haVar.f24798a)) != 0) {
            return e27;
        }
        int compareTo3 = Boolean.valueOf(m374c()).compareTo(Boolean.valueOf(haVar.m374c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m374c() && (e26 = fw.e(this.f389238b, haVar.f389238b)) != 0) {
            return e26;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e19 = fw.e(this.f389239c, haVar.f389239c)) != 0) {
            return e19;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c16 = fw.c(this.f389237a, haVar.f389237a)) != 0) {
            return c16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e18 = fw.e(this.f389240d, haVar.f389240d)) != 0) {
            return e18;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e17 = fw.e(this.f389241e, haVar.f389241e)) != 0) {
            return e17;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (g16 = fw.g(this.f24800a, haVar.f24800a)) != 0) {
            return g16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e16 = fw.e(this.f389242f, haVar.f389242f)) != 0) {
            return e16;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (k3 = fw.k(this.f24801a, haVar.f24801a)) == 0) {
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
                if (e()) {
                    m370a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24797a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f24798a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389238b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389239c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                case 11:
                default:
                    hp.a(hnVar, b16);
                    break;
                case 7:
                    if (b16 == 10) {
                        this.f389237a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389240d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389241e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 15) {
                        gc f16 = hnVar.f();
                        this.f24800a = new ArrayList(f16.f388947b);
                        for (int i3 = 0; i3 < f16.f388947b; i3++) {
                            this.f24800a.add(hnVar.j());
                        }
                        hnVar.G();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 11) {
                        this.f389242f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 13:
                    if (b16 == 2) {
                        this.f24801a = hnVar.y();
                        b(true);
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
    public void m370a() {
        if (this.f24798a != null) {
            if (this.f389238b != null) {
                if (this.f389239c != null) {
                    return;
                }
                throw new ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
