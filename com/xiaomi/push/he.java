package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class he implements hq<he, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f389258a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24809a;

    /* renamed from: a, reason: collision with other field name */
    public String f24810a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f24811a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24812a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f24813a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f24814a;

    /* renamed from: b, reason: collision with root package name */
    public String f389259b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f24815b;

    /* renamed from: c, reason: collision with root package name */
    public String f389260c;

    /* renamed from: d, reason: collision with root package name */
    public String f389261d;

    /* renamed from: e, reason: collision with root package name */
    public String f389262e;

    /* renamed from: f, reason: collision with root package name */
    public String f389263f;

    /* renamed from: g, reason: collision with root package name */
    public String f389264g;

    /* renamed from: h, reason: collision with root package name */
    public String f389265h;

    /* renamed from: i, reason: collision with root package name */
    public String f389266i;

    /* renamed from: m, reason: collision with root package name */
    private static final hs f389257m = new hs("XmPushActionNotification");
    private static final ga C = new ga("", (byte) 11, 1);
    private static final ga D = new ga("", (byte) 12, 2);
    private static final ga E = new ga("", (byte) 11, 3);
    private static final ga F = new ga("", (byte) 11, 4);
    private static final ga G = new ga("", (byte) 11, 5);
    private static final ga H = new ga("", (byte) 2, 6);
    private static final ga I = new ga("", (byte) 11, 7);
    private static final ga J = new ga("", (byte) 13, 8);
    private static final ga K = new ga("", (byte) 11, 9);
    private static final ga L = new ga("", (byte) 11, 10);
    private static final ga M = new ga("", (byte) 11, 12);
    private static final ga N = new ga("", (byte) 11, 13);
    private static final ga P = new ga("", (byte) 11, 14);
    private static final ga Q = new ga("", (byte) 10, 15);
    private static final ga R = new ga("", (byte) 2, 20);

    public he() {
        this.f24812a = new BitSet(3);
        this.f24814a = true;
        this.f24815b = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m394a() {
        return this.f24810a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m397b() {
        return this.f24809a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m398c() {
        return this.f389259b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m399d() {
        return this.f389260c != null;
    }

    public boolean e() {
        if (this.f389261d != null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof he)) {
            return false;
        }
        return m395a((he) obj);
    }

    public boolean f() {
        return this.f24812a.get(0);
    }

    public boolean g() {
        if (this.f389262e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f24813a != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f389263f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f389264g != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f389265h != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f389266i != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f24811a != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.f24812a.get(1);
    }

    public boolean o() {
        return this.f24812a.get(2);
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionNotification(");
        boolean z17 = false;
        if (m394a()) {
            sb5.append("debug:");
            String str = this.f24810a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m397b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24809a;
            if (guVar == null) {
                sb5.append("null");
            } else {
                sb5.append(guVar);
            }
        } else {
            z17 = z16;
        }
        if (!z17) {
            sb5.append(", ");
        }
        sb5.append("id:");
        String str2 = this.f389259b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(str2);
        }
        if (m399d()) {
            sb5.append(", ");
            sb5.append("appId:");
            String str3 = this.f389260c;
            if (str3 == null) {
                sb5.append("null");
            } else {
                sb5.append(str3);
            }
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("type:");
            String str4 = this.f389261d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        sb5.append(", ");
        sb5.append("requireAck:");
        sb5.append(this.f24814a);
        if (g()) {
            sb5.append(", ");
            sb5.append("payload:");
            String str5 = this.f389262e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("extra:");
            Map<String, String> map = this.f24813a;
            if (map == null) {
                sb5.append("null");
            } else {
                sb5.append(map);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str6 = this.f389263f;
            if (str6 == null) {
                sb5.append("null");
            } else {
                sb5.append(str6);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("category:");
            String str7 = this.f389264g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("regId:");
            String str8 = this.f389265h;
            if (str8 == null) {
                sb5.append("null");
            } else {
                sb5.append(str8);
            }
        }
        if (l()) {
            sb5.append(", ");
            sb5.append("aliasName:");
            String str9 = this.f389266i;
            if (str9 == null) {
                sb5.append("null");
            } else {
                sb5.append(str9);
            }
        }
        if (m()) {
            sb5.append(", ");
            sb5.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f24811a;
            if (byteBuffer == null) {
                sb5.append("null");
            } else {
                fw.o(byteBuffer, sb5);
            }
        }
        if (n()) {
            sb5.append(", ");
            sb5.append("createdTs:");
            sb5.append(this.f389258a);
        }
        if (o()) {
            sb5.append(", ");
            sb5.append("alreadyLogClickInXmq:");
            sb5.append(this.f24815b);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public gu a() {
        return this.f24809a;
    }

    public String b() {
        return this.f389260c;
    }

    public String c() {
        return this.f389261d;
    }

    public String d() {
        return this.f389263f;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m390a() {
        return this.f389259b;
    }

    public he b(String str) {
        this.f389260c = str;
        return this;
    }

    public he c(String str) {
        this.f389261d = str;
        return this;
    }

    public he d(String str) {
        this.f389263f = str;
        return this;
    }

    public he a(String str) {
        this.f389259b = str;
        return this;
    }

    public void b(boolean z16) {
        this.f24812a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24812a.set(2, z16);
    }

    public he(String str, boolean z16) {
        this();
        this.f389259b = str;
        this.f24814a = z16;
        m393a(true);
    }

    public he a(boolean z16) {
        this.f24814a = z16;
        m393a(true);
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m392a();
        hnVar.t(f389257m);
        if (this.f24810a != null && m394a()) {
            hnVar.q(C);
            hnVar.u(this.f24810a);
            hnVar.z();
        }
        if (this.f24809a != null && m397b()) {
            hnVar.q(D);
            this.f24809a.b(hnVar);
            hnVar.z();
        }
        if (this.f389259b != null) {
            hnVar.q(E);
            hnVar.u(this.f389259b);
            hnVar.z();
        }
        if (this.f389260c != null && m399d()) {
            hnVar.q(F);
            hnVar.u(this.f389260c);
            hnVar.z();
        }
        if (this.f389261d != null && e()) {
            hnVar.q(G);
            hnVar.u(this.f389261d);
            hnVar.z();
        }
        hnVar.q(H);
        hnVar.x(this.f24814a);
        hnVar.z();
        if (this.f389262e != null && g()) {
            hnVar.q(I);
            hnVar.u(this.f389262e);
            hnVar.z();
        }
        if (this.f24813a != null && h()) {
            hnVar.q(J);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24813a.size()));
            for (Map.Entry<String, String> entry : this.f24813a.entrySet()) {
                hnVar.u(entry.getKey());
                hnVar.u(entry.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        if (this.f389263f != null && i()) {
            hnVar.q(K);
            hnVar.u(this.f389263f);
            hnVar.z();
        }
        if (this.f389264g != null && j()) {
            hnVar.q(L);
            hnVar.u(this.f389264g);
            hnVar.z();
        }
        if (this.f389265h != null && k()) {
            hnVar.q(M);
            hnVar.u(this.f389265h);
            hnVar.z();
        }
        if (this.f389266i != null && l()) {
            hnVar.q(N);
            hnVar.u(this.f389266i);
            hnVar.z();
        }
        if (this.f24811a != null && m()) {
            hnVar.q(P);
            hnVar.v(this.f24811a);
            hnVar.z();
        }
        if (n()) {
            hnVar.q(Q);
            hnVar.p(this.f389258a);
            hnVar.z();
        }
        if (o()) {
            hnVar.q(R);
            hnVar.x(this.f24815b);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m393a(boolean z16) {
        this.f24812a.set(0, z16);
    }

    public void a(String str, String str2) {
        if (this.f24813a == null) {
            this.f24813a = new HashMap();
        }
        this.f24813a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m391a() {
        return this.f24813a;
    }

    public he a(Map<String, String> map) {
        this.f24813a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m396a() {
        a(fw.n(this.f24811a));
        return this.f24811a.array();
    }

    public he a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public he a(ByteBuffer byteBuffer) {
        this.f24811a = byteBuffer;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m395a(he heVar) {
        if (heVar == null) {
            return false;
        }
        boolean m394a = m394a();
        boolean m394a2 = heVar.m394a();
        if ((m394a || m394a2) && !(m394a && m394a2 && this.f24810a.equals(heVar.f24810a))) {
            return false;
        }
        boolean m397b = m397b();
        boolean m397b2 = heVar.m397b();
        if ((m397b || m397b2) && !(m397b && m397b2 && this.f24809a.m353a(heVar.f24809a))) {
            return false;
        }
        boolean m398c = m398c();
        boolean m398c2 = heVar.m398c();
        if ((m398c || m398c2) && !(m398c && m398c2 && this.f389259b.equals(heVar.f389259b))) {
            return false;
        }
        boolean m399d = m399d();
        boolean m399d2 = heVar.m399d();
        if ((m399d || m399d2) && !(m399d && m399d2 && this.f389260c.equals(heVar.f389260c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = heVar.e();
        if (((e16 || e17) && !(e16 && e17 && this.f389261d.equals(heVar.f389261d))) || this.f24814a != heVar.f24814a) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = heVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389262e.equals(heVar.f389262e))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = heVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f24813a.equals(heVar.f24813a))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = heVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389263f.equals(heVar.f389263f))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = heVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f389264g.equals(heVar.f389264g))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = heVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f389265h.equals(heVar.f389265h))) {
            return false;
        }
        boolean l3 = l();
        boolean l16 = heVar.l();
        if ((l3 || l16) && !(l3 && l16 && this.f389266i.equals(heVar.f389266i))) {
            return false;
        }
        boolean m3 = m();
        boolean m16 = heVar.m();
        if ((m3 || m16) && !(m3 && m16 && this.f24811a.equals(heVar.f24811a))) {
            return false;
        }
        boolean n3 = n();
        boolean n16 = heVar.n();
        if ((n3 || n16) && !(n3 && n16 && this.f389258a == heVar.f389258a)) {
            return false;
        }
        boolean o16 = o();
        boolean o17 = heVar.o();
        if (o16 || o17) {
            return o16 && o17 && this.f24815b == heVar.f24815b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(he heVar) {
        int k3;
        int c16;
        int d16;
        int e16;
        int e17;
        int e18;
        int e19;
        int h16;
        int e26;
        int k16;
        int e27;
        int e28;
        int e29;
        int d17;
        int e36;
        if (!getClass().equals(heVar.getClass())) {
            return getClass().getName().compareTo(heVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m394a()).compareTo(Boolean.valueOf(heVar.m394a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m394a() && (e36 = fw.e(this.f24810a, heVar.f24810a)) != 0) {
            return e36;
        }
        int compareTo2 = Boolean.valueOf(m397b()).compareTo(Boolean.valueOf(heVar.m397b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m397b() && (d17 = fw.d(this.f24809a, heVar.f24809a)) != 0) {
            return d17;
        }
        int compareTo3 = Boolean.valueOf(m398c()).compareTo(Boolean.valueOf(heVar.m398c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m398c() && (e29 = fw.e(this.f389259b, heVar.f389259b)) != 0) {
            return e29;
        }
        int compareTo4 = Boolean.valueOf(m399d()).compareTo(Boolean.valueOf(heVar.m399d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m399d() && (e28 = fw.e(this.f389260c, heVar.f389260c)) != 0) {
            return e28;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(heVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e27 = fw.e(this.f389261d, heVar.f389261d)) != 0) {
            return e27;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(heVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (k16 = fw.k(this.f24814a, heVar.f24814a)) != 0) {
            return k16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(heVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e26 = fw.e(this.f389262e, heVar.f389262e)) != 0) {
            return e26;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(heVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (h16 = fw.h(this.f24813a, heVar.f24813a)) != 0) {
            return h16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(heVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e19 = fw.e(this.f389263f, heVar.f389263f)) != 0) {
            return e19;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(heVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e18 = fw.e(this.f389264g, heVar.f389264g)) != 0) {
            return e18;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(heVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e17 = fw.e(this.f389265h, heVar.f389265h)) != 0) {
            return e17;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(heVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e16 = fw.e(this.f389266i, heVar.f389266i)) != 0) {
            return e16;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(heVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (d16 = fw.d(this.f24811a, heVar.f24811a)) != 0) {
            return d16;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(heVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (c16 = fw.c(this.f389258a, heVar.f389258a)) != 0) {
            return c16;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(heVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!o() || (k3 = fw.k(this.f24815b, heVar.f24815b)) == 0) {
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
                if (f()) {
                    m392a();
                    return;
                }
                throw new ib("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 11) {
                        this.f24810a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24809a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f389259b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f389260c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389261d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 2) {
                        this.f24814a = hnVar.y();
                        m393a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389262e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 13) {
                        gd g16 = hnVar.g();
                        this.f24813a = new HashMap(g16.f388950c * 2);
                        for (int i3 = 0; i3 < g16.f388950c; i3++) {
                            this.f24813a.put(hnVar.j(), hnVar.j());
                        }
                        hnVar.F();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389263f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389264g = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    hp.a(hnVar, b16);
                    break;
                case 12:
                    if (b16 == 11) {
                        this.f389265h = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 13:
                    if (b16 == 11) {
                        this.f389266i = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 14:
                    if (b16 == 11) {
                        this.f24811a = hnVar.k();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 15:
                    if (b16 == 10) {
                        this.f389258a = hnVar.d();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 20:
                    if (b16 == 2) {
                        this.f24815b = hnVar.y();
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
    public void m392a() {
        if (this.f389259b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
