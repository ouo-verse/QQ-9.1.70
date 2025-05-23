package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gz implements hq<gz, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389229a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24791a;

    /* renamed from: a, reason: collision with other field name */
    public String f24792a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f24794a;

    /* renamed from: b, reason: collision with root package name */
    public String f389230b;

    /* renamed from: c, reason: collision with root package name */
    public String f389231c;

    /* renamed from: d, reason: collision with root package name */
    public String f389232d;

    /* renamed from: e, reason: collision with root package name */
    public String f389233e;

    /* renamed from: f, reason: collision with root package name */
    private static final hs f389225f = new hs("XmPushActionCommand");

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389226h = new ga("", (byte) 12, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389227i = new ga("", (byte) 11, 3);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389228m = new ga("", (byte) 11, 4);
    private static final ga C = new ga("", (byte) 11, 5);
    private static final ga D = new ga("", RegisterType.DOUBLE_HI, 6);
    private static final ga E = new ga("", (byte) 11, 7);
    private static final ga F = new ga("", (byte) 11, 9);
    private static final ga G = new ga("", (byte) 2, 10);
    private static final ga H = new ga("", (byte) 2, 11);
    private static final ga I = new ga("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24793a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24795a = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f24796b = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m367a() {
        return this.f24791a != null;
    }

    public boolean b() {
        return this.f24792a != null;
    }

    public boolean c() {
        return this.f389230b != null;
    }

    public boolean d() {
        return this.f389231c != null;
    }

    public boolean e() {
        return this.f24794a != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gz)) {
            return false;
        }
        return m368a((gz) obj);
    }

    public boolean f() {
        if (this.f389232d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389233e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.f24793a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f24793a.get(1);
    }

    public boolean j() {
        return this.f24793a.get(2);
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionCommand(");
        if (m367a()) {
            sb5.append("target:");
            gu guVar = this.f24791a;
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
        String str = this.f24792a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(str);
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str2 = this.f389230b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        sb5.append(", ");
        sb5.append("cmdName:");
        String str3 = this.f389231c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("cmdArgs:");
            List<String> list = this.f24794a;
            if (list == null) {
                sb5.append("null");
            } else {
                sb5.append(list);
            }
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str4 = this.f389232d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("category:");
            String str5 = this.f389233e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("updateCache:");
            sb5.append(this.f24795a);
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("response2Client:");
            sb5.append(this.f24796b);
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("createdTs:");
            sb5.append(this.f389229a);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public gz a(String str) {
        this.f24792a = str;
        return this;
    }

    public gz b(String str) {
        this.f389230b = str;
        return this;
    }

    public gz c(String str) {
        this.f389231c = str;
        return this;
    }

    public gz d(String str) {
        this.f389232d = str;
        return this;
    }

    public gz e(String str) {
        this.f389233e = str;
        return this;
    }

    public String a() {
        return this.f389231c;
    }

    public void b(boolean z16) {
        this.f24793a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24793a.set(2, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m366a(String str) {
        if (this.f24794a == null) {
            this.f24794a = new ArrayList();
        }
        this.f24794a.add(str);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m365a();
        hnVar.t(f389225f);
        if (this.f24791a != null && m367a()) {
            hnVar.q(f389226h);
            this.f24791a.b(hnVar);
            hnVar.z();
        }
        if (this.f24792a != null) {
            hnVar.q(f389227i);
            hnVar.u(this.f24792a);
            hnVar.z();
        }
        if (this.f389230b != null) {
            hnVar.q(f389228m);
            hnVar.u(this.f389230b);
            hnVar.z();
        }
        if (this.f389231c != null) {
            hnVar.q(C);
            hnVar.u(this.f389231c);
            hnVar.z();
        }
        if (this.f24794a != null && e()) {
            hnVar.q(D);
            hnVar.r(new gc((byte) 11, this.f24794a.size()));
            Iterator<String> it = this.f24794a.iterator();
            while (it.hasNext()) {
                hnVar.u(it.next());
            }
            hnVar.C();
            hnVar.z();
        }
        if (this.f389232d != null && f()) {
            hnVar.q(E);
            hnVar.u(this.f389232d);
            hnVar.z();
        }
        if (this.f389233e != null && g()) {
            hnVar.q(F);
            hnVar.u(this.f389233e);
            hnVar.z();
        }
        if (h()) {
            hnVar.q(G);
            hnVar.x(this.f24795a);
            hnVar.z();
        }
        if (i()) {
            hnVar.q(H);
            hnVar.x(this.f24796b);
            hnVar.z();
        }
        if (j()) {
            hnVar.q(I);
            hnVar.p(this.f389229a);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public void a(boolean z16) {
        this.f24793a.set(0, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m368a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean m367a = m367a();
        boolean m367a2 = gzVar.m367a();
        if ((m367a || m367a2) && !(m367a && m367a2 && this.f24791a.m353a(gzVar.f24791a))) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = gzVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24792a.equals(gzVar.f24792a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = gzVar.c();
        if ((c16 || c17) && !(c16 && c17 && this.f389230b.equals(gzVar.f389230b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = gzVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f389231c.equals(gzVar.f389231c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = gzVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f24794a.equals(gzVar.f24794a))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = gzVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389232d.equals(gzVar.f389232d))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = gzVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389233e.equals(gzVar.f389233e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = gzVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f24795a == gzVar.f24795a)) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = gzVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f24796b == gzVar.f24796b)) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = gzVar.j();
        if (j3 || j16) {
            return j3 && j16 && this.f389229a == gzVar.f389229a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gz gzVar) {
        int c16;
        int k3;
        int k16;
        int e16;
        int e17;
        int g16;
        int e18;
        int e19;
        int e26;
        int d16;
        if (!getClass().equals(gzVar.getClass())) {
            return getClass().getName().compareTo(gzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m367a()).compareTo(Boolean.valueOf(gzVar.m367a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m367a() && (d16 = fw.d(this.f24791a, gzVar.f24791a)) != 0) {
            return d16;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gzVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (e26 = fw.e(this.f24792a, gzVar.f24792a)) != 0) {
            return e26;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gzVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e19 = fw.e(this.f389230b, gzVar.f389230b)) != 0) {
            return e19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gzVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e18 = fw.e(this.f389231c, gzVar.f389231c)) != 0) {
            return e18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gzVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (g16 = fw.g(this.f24794a, gzVar.f24794a)) != 0) {
            return g16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gzVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e17 = fw.e(this.f389232d, gzVar.f389232d)) != 0) {
            return e17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gzVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e16 = fw.e(this.f389233e, gzVar.f389233e)) != 0) {
            return e16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gzVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (k16 = fw.k(this.f24795a, gzVar.f24795a)) != 0) {
            return k16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gzVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (k3 = fw.k(this.f24796b, gzVar.f24796b)) != 0) {
            return k3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gzVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (c16 = fw.c(this.f389229a, gzVar.f389229a)) == 0) {
            return 0;
        }
        return c16;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                hnVar.D();
                m365a();
                return;
            }
            switch (e16.f388942c) {
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24791a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f24792a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389230b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389231c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 15) {
                        gc f16 = hnVar.f();
                        this.f24794a = new ArrayList(f16.f388947b);
                        for (int i3 = 0; i3 < f16.f388947b; i3++) {
                            this.f24794a.add(hnVar.j());
                        }
                        hnVar.G();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389232d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                default:
                    hp.a(hnVar, b16);
                    break;
                case 9:
                    if (b16 == 11) {
                        this.f389233e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 2) {
                        this.f24795a = hnVar.y();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 2) {
                        this.f24796b = hnVar.y();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 10) {
                        this.f389229a = hnVar.d();
                        c(true);
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
    public void m365a() {
        if (this.f24792a != null) {
            if (this.f389230b != null) {
                if (this.f389231c != null) {
                    return;
                }
                throw new ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
