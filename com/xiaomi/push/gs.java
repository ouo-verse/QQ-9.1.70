package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gs implements hq<gs, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f389177a;

    /* renamed from: a, reason: collision with other field name */
    public long f24763a;

    /* renamed from: a, reason: collision with other field name */
    public String f24764a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24765a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f24766a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f24767a;

    /* renamed from: b, reason: collision with root package name */
    public int f389178b;

    /* renamed from: b, reason: collision with other field name */
    public String f24768b;

    /* renamed from: b, reason: collision with other field name */
    public Map<String, String> f24769b;

    /* renamed from: c, reason: collision with root package name */
    public int f389179c;

    /* renamed from: c, reason: collision with other field name */
    public String f24770c;

    /* renamed from: c, reason: collision with other field name */
    public Map<String, String> f24771c;

    /* renamed from: d, reason: collision with root package name */
    public String f389180d;

    /* renamed from: e, reason: collision with root package name */
    public String f389181e;

    /* renamed from: f, reason: collision with root package name */
    private static final hs f389173f = new hs("PushMetaInfo");

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389174h = new ga("", (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389175i = new ga("", (byte) 10, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389176m = new ga("", (byte) 11, 3);
    private static final ga C = new ga("", (byte) 11, 4);
    private static final ga D = new ga("", (byte) 11, 5);
    private static final ga E = new ga("", (byte) 8, 6);
    private static final ga F = new ga("", (byte) 11, 7);
    private static final ga G = new ga("", (byte) 8, 8);
    private static final ga H = new ga("", (byte) 8, 9);
    private static final ga I = new ga("", (byte) 13, 10);
    private static final ga J = new ga("", (byte) 13, 11);
    private static final ga K = new ga("", (byte) 2, 12);
    private static final ga L = new ga("", (byte) 13, 13);

    public gs() {
        this.f24765a = new BitSet(5);
        this.f24767a = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gs m340a() {
        return new gs(this);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m348b() {
        return this.f24765a.get(0);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m350c() {
        return this.f24768b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m351d() {
        return this.f24770c != null;
    }

    public boolean e() {
        return this.f389180d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gs)) {
            return false;
        }
        return m345a((gs) obj);
    }

    public boolean f() {
        return this.f24765a.get(1);
    }

    public boolean g() {
        if (this.f389181e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.f24765a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f24765a.get(3);
    }

    public boolean j() {
        if (this.f24766a != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f24769b != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return this.f24767a;
    }

    public boolean m() {
        return this.f24765a.get(4);
    }

    public boolean n() {
        if (this.f24771c != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("PushMetaInfo(");
        sb5.append("id:");
        String str = this.f24764a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(com.xiaomi.push.service.m.b(str));
        }
        sb5.append(", ");
        sb5.append("messageTs:");
        sb5.append(this.f24763a);
        if (m350c()) {
            sb5.append(", ");
            sb5.append("topic:");
            String str2 = this.f24768b;
            if (str2 == null) {
                sb5.append("null");
            } else {
                sb5.append(str2);
            }
        }
        if (m351d()) {
            sb5.append(", ");
            sb5.append("title:");
            String str3 = this.f24770c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("description:");
            String str4 = this.f389180d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("notifyType:");
            sb5.append(this.f389177a);
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("url:");
            String str5 = this.f389181e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("passThrough:");
            sb5.append(this.f389178b);
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("notifyId:");
            sb5.append(this.f389179c);
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("extra:");
            Map<String, String> map = this.f24766a;
            if (map == null) {
                sb5.append("null");
            } else {
                sb5.append(map);
            }
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("internal:");
            Map<String, String> map2 = this.f24769b;
            if (map2 == null) {
                sb5.append("null");
            } else {
                sb5.append(map2);
            }
        }
        if (m()) {
            sb5.append(", ");
            sb5.append("ignoreRegInfo:");
            sb5.append(this.f24767a);
        }
        if (n()) {
            sb5.append(", ");
            sb5.append("apsProperFields:");
            Map<String, String> map3 = this.f24771c;
            if (map3 == null) {
                sb5.append("null");
            } else {
                sb5.append(map3);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m341a() {
        return this.f24764a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m346b() {
        return this.f24768b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m349c() {
        return this.f24770c;
    }

    public String d() {
        return this.f389180d;
    }

    public void e(boolean z16) {
        this.f24765a.set(4, z16);
    }

    public gs a(String str) {
        this.f24764a = str;
        return this;
    }

    public gs b(String str) {
        this.f24768b = str;
        return this;
    }

    public gs c(String str) {
        this.f24770c = str;
        return this;
    }

    public gs d(String str) {
        this.f389180d = str;
        return this;
    }

    public gs(gs gsVar) {
        BitSet bitSet = new BitSet(5);
        this.f24765a = bitSet;
        bitSet.clear();
        this.f24765a.or(gsVar.f24765a);
        if (gsVar.m344a()) {
            this.f24764a = gsVar.f24764a;
        }
        this.f24763a = gsVar.f24763a;
        if (gsVar.m350c()) {
            this.f24768b = gsVar.f24768b;
        }
        if (gsVar.m351d()) {
            this.f24770c = gsVar.f24770c;
        }
        if (gsVar.e()) {
            this.f389180d = gsVar.f389180d;
        }
        this.f389177a = gsVar.f389177a;
        if (gsVar.g()) {
            this.f389181e = gsVar.f389181e;
        }
        this.f389178b = gsVar.f389178b;
        this.f389179c = gsVar.f389179c;
        if (gsVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : gsVar.f24766a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f24766a = hashMap;
        }
        if (gsVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : gsVar.f24769b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f24769b = hashMap2;
        }
        this.f24767a = gsVar.f24767a;
        if (gsVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : gsVar.f24771c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f24771c = hashMap3;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m344a() {
        return this.f24764a != null;
    }

    public void b(boolean z16) {
        this.f24765a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24765a.set(2, z16);
    }

    public void d(boolean z16) {
        this.f24765a.set(3, z16);
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m339a() {
        return this.f24763a;
    }

    public int b() {
        return this.f389178b;
    }

    public int c() {
        return this.f389179c;
    }

    public void a(boolean z16) {
        this.f24765a.set(0, z16);
    }

    public gs b(int i3) {
        this.f389178b = i3;
        c(true);
        return this;
    }

    public gs c(int i3) {
        this.f389179c = i3;
        d(true);
        return this;
    }

    public int a() {
        return this.f389177a;
    }

    public gs a(int i3) {
        this.f389177a = i3;
        b(true);
        return this;
    }

    public void b(String str, String str2) {
        if (this.f24769b == null) {
            this.f24769b = new HashMap();
        }
        this.f24769b.put(str, str2);
    }

    public void a(String str, String str2) {
        if (this.f24766a == null) {
            this.f24766a = new HashMap();
        }
        this.f24766a.put(str, str2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public Map<String, String> m347b() {
        return this.f24769b;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m343a();
        hnVar.t(f389173f);
        if (this.f24764a != null) {
            hnVar.q(f389174h);
            hnVar.u(this.f24764a);
            hnVar.z();
        }
        hnVar.q(f389175i);
        hnVar.p(this.f24763a);
        hnVar.z();
        if (this.f24768b != null && m350c()) {
            hnVar.q(f389176m);
            hnVar.u(this.f24768b);
            hnVar.z();
        }
        if (this.f24770c != null && m351d()) {
            hnVar.q(C);
            hnVar.u(this.f24770c);
            hnVar.z();
        }
        if (this.f389180d != null && e()) {
            hnVar.q(D);
            hnVar.u(this.f389180d);
            hnVar.z();
        }
        if (f()) {
            hnVar.q(E);
            hnVar.o(this.f389177a);
            hnVar.z();
        }
        if (this.f389181e != null && g()) {
            hnVar.q(F);
            hnVar.u(this.f389181e);
            hnVar.z();
        }
        if (h()) {
            hnVar.q(G);
            hnVar.o(this.f389178b);
            hnVar.z();
        }
        if (i()) {
            hnVar.q(H);
            hnVar.o(this.f389179c);
            hnVar.z();
        }
        if (this.f24766a != null && j()) {
            hnVar.q(I);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24766a.size()));
            for (Map.Entry<String, String> entry : this.f24766a.entrySet()) {
                hnVar.u(entry.getKey());
                hnVar.u(entry.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        if (this.f24769b != null && k()) {
            hnVar.q(J);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24769b.size()));
            for (Map.Entry<String, String> entry2 : this.f24769b.entrySet()) {
                hnVar.u(entry2.getKey());
                hnVar.u(entry2.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        if (m()) {
            hnVar.q(K);
            hnVar.x(this.f24767a);
            hnVar.z();
        }
        if (this.f24771c != null && n()) {
            hnVar.q(L);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24771c.size()));
            for (Map.Entry<String, String> entry3 : this.f24771c.entrySet()) {
                hnVar.u(entry3.getKey());
                hnVar.u(entry3.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m342a() {
        return this.f24766a;
    }

    public gs a(Map<String, String> map) {
        this.f24766a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m345a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        boolean m344a = m344a();
        boolean m344a2 = gsVar.m344a();
        if (((m344a || m344a2) && !(m344a && m344a2 && this.f24764a.equals(gsVar.f24764a))) || this.f24763a != gsVar.f24763a) {
            return false;
        }
        boolean m350c = m350c();
        boolean m350c2 = gsVar.m350c();
        if ((m350c || m350c2) && !(m350c && m350c2 && this.f24768b.equals(gsVar.f24768b))) {
            return false;
        }
        boolean m351d = m351d();
        boolean m351d2 = gsVar.m351d();
        if ((m351d || m351d2) && !(m351d && m351d2 && this.f24770c.equals(gsVar.f24770c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = gsVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389180d.equals(gsVar.f389180d))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = gsVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389177a == gsVar.f389177a)) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = gsVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389181e.equals(gsVar.f389181e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = gsVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389178b == gsVar.f389178b)) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = gsVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389179c == gsVar.f389179c)) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = gsVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f24766a.equals(gsVar.f24766a))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = gsVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f24769b.equals(gsVar.f24769b))) {
            return false;
        }
        boolean m3 = m();
        boolean m16 = gsVar.m();
        if ((m3 || m16) && !(m3 && m16 && this.f24767a == gsVar.f24767a)) {
            return false;
        }
        boolean n3 = n();
        boolean n16 = gsVar.n();
        if (n3 || n16) {
            return n3 && n16 && this.f24771c.equals(gsVar.f24771c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gs gsVar) {
        int h16;
        int k3;
        int h17;
        int h18;
        int b16;
        int b17;
        int e16;
        int b18;
        int e17;
        int e18;
        int e19;
        int c16;
        int e26;
        if (!getClass().equals(gsVar.getClass())) {
            return getClass().getName().compareTo(gsVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m344a()).compareTo(Boolean.valueOf(gsVar.m344a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m344a() && (e26 = fw.e(this.f24764a, gsVar.f24764a)) != 0) {
            return e26;
        }
        int compareTo2 = Boolean.valueOf(m348b()).compareTo(Boolean.valueOf(gsVar.m348b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m348b() && (c16 = fw.c(this.f24763a, gsVar.f24763a)) != 0) {
            return c16;
        }
        int compareTo3 = Boolean.valueOf(m350c()).compareTo(Boolean.valueOf(gsVar.m350c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m350c() && (e19 = fw.e(this.f24768b, gsVar.f24768b)) != 0) {
            return e19;
        }
        int compareTo4 = Boolean.valueOf(m351d()).compareTo(Boolean.valueOf(gsVar.m351d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m351d() && (e18 = fw.e(this.f24770c, gsVar.f24770c)) != 0) {
            return e18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gsVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e17 = fw.e(this.f389180d, gsVar.f389180d)) != 0) {
            return e17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gsVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (b18 = fw.b(this.f389177a, gsVar.f389177a)) != 0) {
            return b18;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gsVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e16 = fw.e(this.f389181e, gsVar.f389181e)) != 0) {
            return e16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gsVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (b17 = fw.b(this.f389178b, gsVar.f389178b)) != 0) {
            return b17;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gsVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (b16 = fw.b(this.f389179c, gsVar.f389179c)) != 0) {
            return b16;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gsVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (h18 = fw.h(this.f24766a, gsVar.f24766a)) != 0) {
            return h18;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gsVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (h17 = fw.h(this.f24769b, gsVar.f24769b)) != 0) {
            return h17;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gsVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (k3 = fw.k(this.f24767a, gsVar.f24767a)) != 0) {
            return k3;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gsVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!n() || (h16 = fw.h(this.f24771c, gsVar.f24771c)) == 0) {
            return 0;
        }
        return h16;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                hnVar.D();
                if (m348b()) {
                    m343a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i3 = 0;
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24764a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 10) {
                        this.f24763a = hnVar.d();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f24768b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f24770c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389180d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 8) {
                        this.f389177a = hnVar.c();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389181e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 8) {
                        this.f389178b = hnVar.c();
                        c(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 8) {
                        this.f389179c = hnVar.c();
                        d(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 13) {
                        gd g16 = hnVar.g();
                        this.f24766a = new HashMap(g16.f388950c * 2);
                        while (i3 < g16.f388950c) {
                            this.f24766a.put(hnVar.j(), hnVar.j());
                            i3++;
                        }
                        hnVar.F();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 13) {
                        gd g17 = hnVar.g();
                        this.f24769b = new HashMap(g17.f388950c * 2);
                        while (i3 < g17.f388950c) {
                            this.f24769b.put(hnVar.j(), hnVar.j());
                            i3++;
                        }
                        hnVar.F();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 2) {
                        this.f24767a = hnVar.y();
                        e(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 13:
                    if (b16 == 13) {
                        gd g18 = hnVar.g();
                        this.f24771c = new HashMap(g18.f388950c * 2);
                        while (i3 < g18.f388950c) {
                            this.f24771c.put(hnVar.j(), hnVar.j());
                            i3++;
                        }
                        hnVar.F();
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

    /* renamed from: a, reason: collision with other method in class */
    public void m343a() {
        if (this.f24764a != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
