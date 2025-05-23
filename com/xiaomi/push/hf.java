package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hf implements hq<hf, Object>, Serializable, Cloneable {
    private static final hs C = new hs("XmPushActionRegistration");
    private static final ga D = new ga("", (byte) 11, 1);
    private static final ga E = new ga("", (byte) 12, 2);
    private static final ga F = new ga("", (byte) 11, 3);
    private static final ga G = new ga("", (byte) 11, 4);
    private static final ga H = new ga("", (byte) 11, 5);
    private static final ga I = new ga("", (byte) 11, 6);
    private static final ga J = new ga("", (byte) 11, 7);
    private static final ga K = new ga("", (byte) 11, 8);
    private static final ga L = new ga("", (byte) 11, 9);
    private static final ga M = new ga("", (byte) 11, 10);
    private static final ga N = new ga("", (byte) 11, 11);
    private static final ga P = new ga("", (byte) 11, 12);
    private static final ga Q = new ga("", (byte) 8, 13);
    private static final ga R = new ga("", (byte) 8, 14);
    private static final ga S = new ga("", (byte) 11, 15);
    private static final ga T = new ga("", (byte) 11, 16);
    private static final ga U = new ga("", (byte) 11, 17);
    private static final ga V = new ga("", (byte) 11, 18);
    private static final ga W = new ga("", (byte) 8, 19);
    private static final ga X = new ga("", (byte) 8, 20);
    private static final ga Y = new ga("", (byte) 2, 21);
    private static final ga Z = new ga("", (byte) 10, 22);

    /* renamed from: a0, reason: collision with root package name */
    private static final ga f389267a0 = new ga("", (byte) 10, 23);

    /* renamed from: b0, reason: collision with root package name */
    private static final ga f389268b0 = new ga("", (byte) 11, 24);

    /* renamed from: c0, reason: collision with root package name */
    private static final ga f389269c0 = new ga("", (byte) 11, 25);

    /* renamed from: d0, reason: collision with root package name */
    private static final ga f389270d0 = new ga("", (byte) 2, 26);

    /* renamed from: e0, reason: collision with root package name */
    private static final ga f389271e0 = new ga("", (byte) 13, 100);

    /* renamed from: f0, reason: collision with root package name */
    private static final ga f389272f0 = new ga("", (byte) 2, 101);

    /* renamed from: g0, reason: collision with root package name */
    private static final ga f389273g0 = new ga("", (byte) 11, 102);

    /* renamed from: a, reason: collision with root package name */
    public int f389274a;

    /* renamed from: a, reason: collision with other field name */
    public long f24816a;

    /* renamed from: a, reason: collision with other field name */
    public gt f24817a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24818a;

    /* renamed from: a, reason: collision with other field name */
    public String f24819a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f24821a;

    /* renamed from: b, reason: collision with root package name */
    public int f389275b;

    /* renamed from: b, reason: collision with other field name */
    public long f24823b;

    /* renamed from: b, reason: collision with other field name */
    public String f24824b;

    /* renamed from: c, reason: collision with root package name */
    public int f389276c;

    /* renamed from: c, reason: collision with other field name */
    public String f24826c;

    /* renamed from: d, reason: collision with root package name */
    public String f389277d;

    /* renamed from: e, reason: collision with root package name */
    public String f389278e;

    /* renamed from: f, reason: collision with root package name */
    public String f389279f;

    /* renamed from: g, reason: collision with root package name */
    public String f389280g;

    /* renamed from: h, reason: collision with root package name */
    public String f389281h;

    /* renamed from: i, reason: collision with root package name */
    public String f389282i;

    /* renamed from: j, reason: collision with root package name */
    public String f389283j;

    /* renamed from: k, reason: collision with root package name */
    public String f389284k;

    /* renamed from: l, reason: collision with root package name */
    public String f389285l;

    /* renamed from: m, reason: collision with root package name */
    public String f389286m;

    /* renamed from: n, reason: collision with root package name */
    public String f389287n;

    /* renamed from: o, reason: collision with root package name */
    public String f389288o;

    /* renamed from: p, reason: collision with root package name */
    public String f389289p;

    /* renamed from: q, reason: collision with root package name */
    public String f389290q;

    /* renamed from: r, reason: collision with root package name */
    public String f389291r;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24820a = new BitSet(8);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24822a = true;

    /* renamed from: c, reason: collision with other field name */
    public boolean f24827c = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f24825b = false;

    public boolean A() {
        if (this.f24821a != null) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return this.f24820a.get(7);
    }

    public boolean C() {
        if (this.f389291r != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m401a() {
        return this.f24819a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m403b() {
        return this.f24818a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m404c() {
        return this.f24824b != null;
    }

    public boolean d() {
        return this.f24826c != null;
    }

    public boolean e() {
        return this.f389277d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hf)) {
            return false;
        }
        return m402a((hf) obj);
    }

    public boolean f() {
        return this.f389278e != null;
    }

    public boolean g() {
        return this.f389279f != null;
    }

    public boolean h() {
        return this.f389280g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f389281h != null;
    }

    public boolean j() {
        if (this.f389282i != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f389283j != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f389284k != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.f24820a.get(0);
    }

    public boolean n() {
        return this.f24820a.get(1);
    }

    public boolean o() {
        if (this.f389285l != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.f389286m != null) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (this.f389287n != null) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.f389288o != null) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f24820a.get(2);
    }

    public boolean t() {
        if (this.f24817a != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("XmPushActionRegistration(");
        boolean z17 = false;
        if (m401a()) {
            sb5.append("debug:");
            String str = this.f24819a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (m403b()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append("target:");
            gu guVar = this.f24818a;
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
        String str2 = this.f24824b;
        if (str2 == null) {
            sb5.append("null");
        } else {
            sb5.append(com.xiaomi.push.service.m.b(str2));
        }
        sb5.append(", ");
        sb5.append("appId:");
        String str3 = this.f24826c;
        if (str3 == null) {
            sb5.append("null");
        } else {
            sb5.append(str3);
        }
        if (e()) {
            sb5.append(", ");
            sb5.append("appVersion:");
            String str4 = this.f389277d;
            if (str4 == null) {
                sb5.append("null");
            } else {
                sb5.append(str4);
            }
        }
        if (f()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str5 = this.f389278e;
            if (str5 == null) {
                sb5.append("null");
            } else {
                sb5.append(str5);
            }
        }
        sb5.append(", ");
        sb5.append("token:");
        String str6 = this.f389279f;
        if (str6 == null) {
            sb5.append("null");
        } else {
            sb5.append(str6);
        }
        if (h()) {
            sb5.append(", ");
            sb5.append("deviceId:");
            String str7 = this.f389280g;
            if (str7 == null) {
                sb5.append("null");
            } else {
                sb5.append(str7);
            }
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("aliasName:");
            String str8 = this.f389281h;
            if (str8 == null) {
                sb5.append("null");
            } else {
                sb5.append(str8);
            }
        }
        if (j()) {
            sb5.append(", ");
            sb5.append("sdkVersion:");
            String str9 = this.f389282i;
            if (str9 == null) {
                sb5.append("null");
            } else {
                sb5.append(str9);
            }
        }
        if (k()) {
            sb5.append(", ");
            sb5.append("regId:");
            String str10 = this.f389283j;
            if (str10 == null) {
                sb5.append("null");
            } else {
                sb5.append(str10);
            }
        }
        if (l()) {
            sb5.append(", ");
            sb5.append("pushSdkVersionName:");
            String str11 = this.f389284k;
            if (str11 == null) {
                sb5.append("null");
            } else {
                sb5.append(str11);
            }
        }
        if (m()) {
            sb5.append(", ");
            sb5.append("pushSdkVersionCode:");
            sb5.append(this.f389274a);
        }
        if (n()) {
            sb5.append(", ");
            sb5.append("appVersionCode:");
            sb5.append(this.f389275b);
        }
        if (o()) {
            sb5.append(", ");
            sb5.append("androidId:");
            String str12 = this.f389285l;
            if (str12 == null) {
                sb5.append("null");
            } else {
                sb5.append(str12);
            }
        }
        if (p()) {
            sb5.append(", ");
            sb5.append("imei:");
            String str13 = this.f389286m;
            if (str13 == null) {
                sb5.append("null");
            } else {
                sb5.append(str13);
            }
        }
        if (q()) {
            sb5.append(", ");
            sb5.append("serial:");
            String str14 = this.f389287n;
            if (str14 == null) {
                sb5.append("null");
            } else {
                sb5.append(str14);
            }
        }
        if (r()) {
            sb5.append(", ");
            sb5.append("imeiMd5:");
            String str15 = this.f389288o;
            if (str15 == null) {
                sb5.append("null");
            } else {
                sb5.append(str15);
            }
        }
        if (s()) {
            sb5.append(", ");
            sb5.append("spaceId:");
            sb5.append(this.f389276c);
        }
        if (t()) {
            sb5.append(", ");
            sb5.append("reason:");
            gt gtVar = this.f24817a;
            if (gtVar == null) {
                sb5.append("null");
            } else {
                sb5.append(gtVar);
            }
        }
        if (u()) {
            sb5.append(", ");
            sb5.append("validateToken:");
            sb5.append(this.f24822a);
        }
        if (v()) {
            sb5.append(", ");
            sb5.append("miid:");
            sb5.append(this.f24816a);
        }
        if (w()) {
            sb5.append(", ");
            sb5.append("createdTs:");
            sb5.append(this.f24823b);
        }
        if (x()) {
            sb5.append(", ");
            sb5.append("subImei:");
            String str16 = this.f389289p;
            if (str16 == null) {
                sb5.append("null");
            } else {
                sb5.append(str16);
            }
        }
        if (y()) {
            sb5.append(", ");
            sb5.append("subImeiMd5:");
            String str17 = this.f389290q;
            if (str17 == null) {
                sb5.append("null");
            } else {
                sb5.append(str17);
            }
        }
        if (z()) {
            sb5.append(", ");
            sb5.append("isHybridFrame:");
            sb5.append(this.f24825b);
        }
        if (A()) {
            sb5.append(", ");
            sb5.append("connectionAttrs:");
            Map<String, String> map = this.f24821a;
            if (map == null) {
                sb5.append("null");
            } else {
                sb5.append(map);
            }
        }
        if (B()) {
            sb5.append(", ");
            sb5.append("cleanOldRegInfo:");
            sb5.append(this.f24827c);
        }
        if (C()) {
            sb5.append(", ");
            sb5.append("oldRegId:");
            String str18 = this.f389291r;
            if (str18 == null) {
                sb5.append("null");
            } else {
                sb5.append(str18);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public boolean u() {
        return this.f24820a.get(3);
    }

    public boolean v() {
        return this.f24820a.get(4);
    }

    public boolean w() {
        return this.f24820a.get(5);
    }

    public boolean x() {
        if (this.f389289p != null) {
            return true;
        }
        return false;
    }

    public boolean y() {
        if (this.f389290q != null) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return this.f24820a.get(6);
    }

    public String a() {
        return this.f24824b;
    }

    public String b() {
        return this.f24826c;
    }

    public hf c(String str) {
        this.f389277d = str;
        return this;
    }

    public hf d(String str) {
        this.f389278e = str;
        return this;
    }

    public hf e(String str) {
        this.f389279f = str;
        return this;
    }

    public hf f(String str) {
        this.f389280g = str;
        return this;
    }

    public hf g(String str) {
        this.f389281h = str;
        return this;
    }

    public hf h(String str) {
        this.f389284k = str;
        return this;
    }

    public hf i(String str) {
        this.f389288o = str;
        return this;
    }

    public hf a(String str) {
        this.f24824b = str;
        return this;
    }

    public hf b(String str) {
        this.f24826c = str;
        return this;
    }

    public String c() {
        return this.f389279f;
    }

    public void d(boolean z16) {
        this.f24820a.set(3, z16);
    }

    public void e(boolean z16) {
        this.f24820a.set(4, z16);
    }

    public void f(boolean z16) {
        this.f24820a.set(5, z16);
    }

    public void g(boolean z16) {
        this.f24820a.set(6, z16);
    }

    public void h(boolean z16) {
        this.f24820a.set(7, z16);
    }

    public hf a(int i3) {
        this.f389274a = i3;
        a(true);
        return this;
    }

    public hf b(int i3) {
        this.f389275b = i3;
        b(true);
        return this;
    }

    public hf c(int i3) {
        this.f389276c = i3;
        c(true);
        return this;
    }

    public void a(boolean z16) {
        this.f24820a.set(0, z16);
    }

    public void b(boolean z16) {
        this.f24820a.set(1, z16);
    }

    public void c(boolean z16) {
        this.f24820a.set(2, z16);
    }

    public hf a(gt gtVar) {
        this.f24817a = gtVar;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m400a();
        hnVar.t(C);
        if (this.f24819a != null && m401a()) {
            hnVar.q(D);
            hnVar.u(this.f24819a);
            hnVar.z();
        }
        if (this.f24818a != null && m403b()) {
            hnVar.q(E);
            this.f24818a.b(hnVar);
            hnVar.z();
        }
        if (this.f24824b != null) {
            hnVar.q(F);
            hnVar.u(this.f24824b);
            hnVar.z();
        }
        if (this.f24826c != null) {
            hnVar.q(G);
            hnVar.u(this.f24826c);
            hnVar.z();
        }
        if (this.f389277d != null && e()) {
            hnVar.q(H);
            hnVar.u(this.f389277d);
            hnVar.z();
        }
        if (this.f389278e != null && f()) {
            hnVar.q(I);
            hnVar.u(this.f389278e);
            hnVar.z();
        }
        if (this.f389279f != null) {
            hnVar.q(J);
            hnVar.u(this.f389279f);
            hnVar.z();
        }
        if (this.f389280g != null && h()) {
            hnVar.q(K);
            hnVar.u(this.f389280g);
            hnVar.z();
        }
        if (this.f389281h != null && i()) {
            hnVar.q(L);
            hnVar.u(this.f389281h);
            hnVar.z();
        }
        if (this.f389282i != null && j()) {
            hnVar.q(M);
            hnVar.u(this.f389282i);
            hnVar.z();
        }
        if (this.f389283j != null && k()) {
            hnVar.q(N);
            hnVar.u(this.f389283j);
            hnVar.z();
        }
        if (this.f389284k != null && l()) {
            hnVar.q(P);
            hnVar.u(this.f389284k);
            hnVar.z();
        }
        if (m()) {
            hnVar.q(Q);
            hnVar.o(this.f389274a);
            hnVar.z();
        }
        if (n()) {
            hnVar.q(R);
            hnVar.o(this.f389275b);
            hnVar.z();
        }
        if (this.f389285l != null && o()) {
            hnVar.q(S);
            hnVar.u(this.f389285l);
            hnVar.z();
        }
        if (this.f389286m != null && p()) {
            hnVar.q(T);
            hnVar.u(this.f389286m);
            hnVar.z();
        }
        if (this.f389287n != null && q()) {
            hnVar.q(U);
            hnVar.u(this.f389287n);
            hnVar.z();
        }
        if (this.f389288o != null && r()) {
            hnVar.q(V);
            hnVar.u(this.f389288o);
            hnVar.z();
        }
        if (s()) {
            hnVar.q(W);
            hnVar.o(this.f389276c);
            hnVar.z();
        }
        if (this.f24817a != null && t()) {
            hnVar.q(X);
            hnVar.o(this.f24817a.a());
            hnVar.z();
        }
        if (u()) {
            hnVar.q(Y);
            hnVar.x(this.f24822a);
            hnVar.z();
        }
        if (v()) {
            hnVar.q(Z);
            hnVar.p(this.f24816a);
            hnVar.z();
        }
        if (w()) {
            hnVar.q(f389267a0);
            hnVar.p(this.f24823b);
            hnVar.z();
        }
        if (this.f389289p != null && x()) {
            hnVar.q(f389268b0);
            hnVar.u(this.f389289p);
            hnVar.z();
        }
        if (this.f389290q != null && y()) {
            hnVar.q(f389269c0);
            hnVar.u(this.f389290q);
            hnVar.z();
        }
        if (z()) {
            hnVar.q(f389270d0);
            hnVar.x(this.f24825b);
            hnVar.z();
        }
        if (this.f24821a != null && A()) {
            hnVar.q(f389271e0);
            hnVar.s(new gd((byte) 11, (byte) 11, this.f24821a.size()));
            for (Map.Entry<String, String> entry : this.f24821a.entrySet()) {
                hnVar.u(entry.getKey());
                hnVar.u(entry.getValue());
            }
            hnVar.B();
            hnVar.z();
        }
        if (B()) {
            hnVar.q(f389272f0);
            hnVar.x(this.f24827c);
            hnVar.z();
        }
        if (this.f389291r != null && C()) {
            hnVar.q(f389273g0);
            hnVar.u(this.f389291r);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m402a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean m401a = m401a();
        boolean m401a2 = hfVar.m401a();
        if ((m401a || m401a2) && !(m401a && m401a2 && this.f24819a.equals(hfVar.f24819a))) {
            return false;
        }
        boolean m403b = m403b();
        boolean m403b2 = hfVar.m403b();
        if ((m403b || m403b2) && !(m403b && m403b2 && this.f24818a.m353a(hfVar.f24818a))) {
            return false;
        }
        boolean m404c = m404c();
        boolean m404c2 = hfVar.m404c();
        if ((m404c || m404c2) && !(m404c && m404c2 && this.f24824b.equals(hfVar.f24824b))) {
            return false;
        }
        boolean d16 = d();
        boolean d17 = hfVar.d();
        if ((d16 || d17) && !(d16 && d17 && this.f24826c.equals(hfVar.f24826c))) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = hfVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f389277d.equals(hfVar.f389277d))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hfVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f389278e.equals(hfVar.f389278e))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hfVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389279f.equals(hfVar.f389279f))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hfVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f389280g.equals(hfVar.f389280g))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hfVar.i();
        if ((i3 || i16) && !(i3 && i16 && this.f389281h.equals(hfVar.f389281h))) {
            return false;
        }
        boolean j3 = j();
        boolean j16 = hfVar.j();
        if ((j3 || j16) && !(j3 && j16 && this.f389282i.equals(hfVar.f389282i))) {
            return false;
        }
        boolean k3 = k();
        boolean k16 = hfVar.k();
        if ((k3 || k16) && !(k3 && k16 && this.f389283j.equals(hfVar.f389283j))) {
            return false;
        }
        boolean l3 = l();
        boolean l16 = hfVar.l();
        if ((l3 || l16) && !(l3 && l16 && this.f389284k.equals(hfVar.f389284k))) {
            return false;
        }
        boolean m3 = m();
        boolean m16 = hfVar.m();
        if ((m3 || m16) && !(m3 && m16 && this.f389274a == hfVar.f389274a)) {
            return false;
        }
        boolean n3 = n();
        boolean n16 = hfVar.n();
        if ((n3 || n16) && !(n3 && n16 && this.f389275b == hfVar.f389275b)) {
            return false;
        }
        boolean o16 = o();
        boolean o17 = hfVar.o();
        if ((o16 || o17) && !(o16 && o17 && this.f389285l.equals(hfVar.f389285l))) {
            return false;
        }
        boolean p16 = p();
        boolean p17 = hfVar.p();
        if ((p16 || p17) && !(p16 && p17 && this.f389286m.equals(hfVar.f389286m))) {
            return false;
        }
        boolean q16 = q();
        boolean q17 = hfVar.q();
        if ((q16 || q17) && !(q16 && q17 && this.f389287n.equals(hfVar.f389287n))) {
            return false;
        }
        boolean r16 = r();
        boolean r17 = hfVar.r();
        if ((r16 || r17) && !(r16 && r17 && this.f389288o.equals(hfVar.f389288o))) {
            return false;
        }
        boolean s16 = s();
        boolean s17 = hfVar.s();
        if ((s16 || s17) && !(s16 && s17 && this.f389276c == hfVar.f389276c)) {
            return false;
        }
        boolean t16 = t();
        boolean t17 = hfVar.t();
        if ((t16 || t17) && !(t16 && t17 && this.f24817a.equals(hfVar.f24817a))) {
            return false;
        }
        boolean u16 = u();
        boolean u17 = hfVar.u();
        if ((u16 || u17) && !(u16 && u17 && this.f24822a == hfVar.f24822a)) {
            return false;
        }
        boolean v3 = v();
        boolean v16 = hfVar.v();
        if ((v3 || v16) && !(v3 && v16 && this.f24816a == hfVar.f24816a)) {
            return false;
        }
        boolean w3 = w();
        boolean w16 = hfVar.w();
        if ((w3 || w16) && !(w3 && w16 && this.f24823b == hfVar.f24823b)) {
            return false;
        }
        boolean x16 = x();
        boolean x17 = hfVar.x();
        if ((x16 || x17) && !(x16 && x17 && this.f389289p.equals(hfVar.f389289p))) {
            return false;
        }
        boolean y16 = y();
        boolean y17 = hfVar.y();
        if ((y16 || y17) && !(y16 && y17 && this.f389290q.equals(hfVar.f389290q))) {
            return false;
        }
        boolean z16 = z();
        boolean z17 = hfVar.z();
        if ((z16 || z17) && !(z16 && z17 && this.f24825b == hfVar.f24825b)) {
            return false;
        }
        boolean A = A();
        boolean A2 = hfVar.A();
        if ((A || A2) && !(A && A2 && this.f24821a.equals(hfVar.f24821a))) {
            return false;
        }
        boolean B = B();
        boolean B2 = hfVar.B();
        if ((B || B2) && !(B && B2 && this.f24827c == hfVar.f24827c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = hfVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f389291r.equals(hfVar.f389291r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hf hfVar) {
        int e16;
        int k3;
        int h16;
        int k16;
        int e17;
        int e18;
        int c16;
        int c17;
        int k17;
        int d16;
        int b16;
        int e19;
        int e26;
        int e27;
        int e28;
        int b17;
        int b18;
        int e29;
        int e36;
        int e37;
        int e38;
        int e39;
        int e46;
        int e47;
        int e48;
        int e49;
        int e56;
        int d17;
        int e57;
        if (!getClass().equals(hfVar.getClass())) {
            return getClass().getName().compareTo(hfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m401a()).compareTo(Boolean.valueOf(hfVar.m401a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m401a() && (e57 = fw.e(this.f24819a, hfVar.f24819a)) != 0) {
            return e57;
        }
        int compareTo2 = Boolean.valueOf(m403b()).compareTo(Boolean.valueOf(hfVar.m403b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m403b() && (d17 = fw.d(this.f24818a, hfVar.f24818a)) != 0) {
            return d17;
        }
        int compareTo3 = Boolean.valueOf(m404c()).compareTo(Boolean.valueOf(hfVar.m404c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m404c() && (e56 = fw.e(this.f24824b, hfVar.f24824b)) != 0) {
            return e56;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e49 = fw.e(this.f24826c, hfVar.f24826c)) != 0) {
            return e49;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e48 = fw.e(this.f389277d, hfVar.f389277d)) != 0) {
            return e48;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e47 = fw.e(this.f389278e, hfVar.f389278e)) != 0) {
            return e47;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e46 = fw.e(this.f389279f, hfVar.f389279f)) != 0) {
            return e46;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hfVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e39 = fw.e(this.f389280g, hfVar.f389280g)) != 0) {
            return e39;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e38 = fw.e(this.f389281h, hfVar.f389281h)) != 0) {
            return e38;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hfVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e37 = fw.e(this.f389282i, hfVar.f389282i)) != 0) {
            return e37;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e36 = fw.e(this.f389283j, hfVar.f389283j)) != 0) {
            return e36;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e29 = fw.e(this.f389284k, hfVar.f389284k)) != 0) {
            return e29;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hfVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (b18 = fw.b(this.f389274a, hfVar.f389274a)) != 0) {
            return b18;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (b17 = fw.b(this.f389275b, hfVar.f389275b)) != 0) {
            return b17;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hfVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (e28 = fw.e(this.f389285l, hfVar.f389285l)) != 0) {
            return e28;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hfVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (e27 = fw.e(this.f389286m, hfVar.f389286m)) != 0) {
            return e27;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hfVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (e26 = fw.e(this.f389287n, hfVar.f389287n)) != 0) {
            return e26;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hfVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (e19 = fw.e(this.f389288o, hfVar.f389288o)) != 0) {
            return e19;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hfVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (b16 = fw.b(this.f389276c, hfVar.f389276c)) != 0) {
            return b16;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hfVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (d16 = fw.d(this.f24817a, hfVar.f24817a)) != 0) {
            return d16;
        }
        int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hfVar.u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (u() && (k17 = fw.k(this.f24822a, hfVar.f24822a)) != 0) {
            return k17;
        }
        int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hfVar.v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (v() && (c17 = fw.c(this.f24816a, hfVar.f24816a)) != 0) {
            return c17;
        }
        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hfVar.w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (w() && (c16 = fw.c(this.f24823b, hfVar.f24823b)) != 0) {
            return c16;
        }
        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hfVar.x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (x() && (e18 = fw.e(this.f389289p, hfVar.f389289p)) != 0) {
            return e18;
        }
        int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hfVar.y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (y() && (e17 = fw.e(this.f389290q, hfVar.f389290q)) != 0) {
            return e17;
        }
        int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(hfVar.z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (z() && (k16 = fw.k(this.f24825b, hfVar.f24825b)) != 0) {
            return k16;
        }
        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(hfVar.A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (A() && (h16 = fw.h(this.f24821a, hfVar.f24821a)) != 0) {
            return h16;
        }
        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(hfVar.B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (B() && (k3 = fw.k(this.f24827c, hfVar.f24827c)) != 0) {
            return k3;
        }
        int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(hfVar.C()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (!C() || (e16 = fw.e(this.f389291r, hfVar.f389291r)) == 0) {
            return 0;
        }
        return e16;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                hnVar.D();
                m400a();
                return;
            }
            short s16 = e16.f388942c;
            switch (s16) {
                case 1:
                    if (b16 == 11) {
                        this.f24819a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24818a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 11) {
                        this.f24824b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f24826c = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f389277d = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 11) {
                        this.f389278e = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 11) {
                        this.f389279f = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 11) {
                        this.f389280g = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 9:
                    if (b16 == 11) {
                        this.f389281h = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 10:
                    if (b16 == 11) {
                        this.f389282i = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 11:
                    if (b16 == 11) {
                        this.f389283j = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 12:
                    if (b16 == 11) {
                        this.f389284k = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 13:
                    if (b16 == 8) {
                        this.f389274a = hnVar.c();
                        a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 14:
                    if (b16 == 8) {
                        this.f389275b = hnVar.c();
                        b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 15:
                    if (b16 == 11) {
                        this.f389285l = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 16:
                    if (b16 == 11) {
                        this.f389286m = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 17:
                    if (b16 == 11) {
                        this.f389287n = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 18:
                    if (b16 == 11) {
                        this.f389288o = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 19:
                    if (b16 == 8) {
                        this.f389276c = hnVar.c();
                        c(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 20:
                    if (b16 == 8) {
                        this.f24817a = gt.a(hnVar.c());
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 21:
                    if (b16 == 2) {
                        this.f24822a = hnVar.y();
                        d(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 22:
                    if (b16 == 10) {
                        this.f24816a = hnVar.d();
                        e(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 23:
                    if (b16 == 10) {
                        this.f24823b = hnVar.d();
                        f(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 24:
                    if (b16 == 11) {
                        this.f389289p = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 25:
                    if (b16 == 11) {
                        this.f389290q = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 26:
                    if (b16 == 2) {
                        this.f24825b = hnVar.y();
                        g(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                default:
                    switch (s16) {
                        case 100:
                            if (b16 == 13) {
                                gd g16 = hnVar.g();
                                this.f24821a = new HashMap(g16.f388950c * 2);
                                for (int i3 = 0; i3 < g16.f388950c; i3++) {
                                    this.f24821a.put(hnVar.j(), hnVar.j());
                                }
                                hnVar.F();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 101:
                            if (b16 == 2) {
                                this.f24827c = hnVar.y();
                                h(true);
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        case 102:
                            if (b16 == 11) {
                                this.f389291r = hnVar.j();
                                break;
                            } else {
                                hp.a(hnVar, b16);
                                break;
                            }
                        default:
                            hp.a(hnVar, b16);
                            break;
                    }
            }
            hnVar.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m400a() {
        if (this.f24824b != null) {
            if (this.f24826c != null) {
                if (this.f389279f != null) {
                    return;
                }
                throw new ib("Required field 'token' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
