package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hb implements hq<hb, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public gf f389249a;

    /* renamed from: a, reason: collision with other field name */
    public gs f24802a;

    /* renamed from: a, reason: collision with other field name */
    public gu f24803a;

    /* renamed from: a, reason: collision with other field name */
    public String f24804a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f24805a;

    /* renamed from: b, reason: collision with root package name */
    public String f389250b;

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389243d = new hs("XmPushActionContainer");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389244e = new ga("", (byte) 8, 1);

    /* renamed from: f, reason: collision with root package name */
    private static final ga f389245f = new ga("", (byte) 2, 2);

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389246h = new ga("", (byte) 2, 3);

    /* renamed from: i, reason: collision with root package name */
    private static final ga f389247i = new ga("", (byte) 11, 4);

    /* renamed from: m, reason: collision with root package name */
    private static final ga f389248m = new ga("", (byte) 11, 5);
    private static final ga C = new ga("", (byte) 11, 6);
    private static final ga D = new ga("", (byte) 12, 7);
    private static final ga E = new ga("", (byte) 12, 8);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24806a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f24807a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f24808b = true;

    public gf a() {
        return this.f389249a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m383b() {
        return this.f24807a;
    }

    public boolean c() {
        return this.f24806a.get(0);
    }

    public boolean d() {
        return this.f24806a.get(1);
    }

    public boolean e() {
        if (this.f24805a != null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hb)) {
            return false;
        }
        return m380a((hb) obj);
    }

    public boolean f() {
        if (this.f24804a != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f389250b != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f24803a != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        if (this.f24802a != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("XmPushActionContainer(");
        sb5.append("action:");
        gf gfVar = this.f389249a;
        if (gfVar == null) {
            sb5.append("null");
        } else {
            sb5.append(gfVar);
        }
        sb5.append(", ");
        sb5.append("encryptAction:");
        sb5.append(this.f24807a);
        sb5.append(", ");
        sb5.append("isRequest:");
        sb5.append(this.f24808b);
        if (f()) {
            sb5.append(", ");
            sb5.append("appid:");
            String str = this.f24804a;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
        }
        if (g()) {
            sb5.append(", ");
            sb5.append("packageName:");
            String str2 = this.f389250b;
            if (str2 == null) {
                sb5.append("null");
            } else {
                sb5.append(str2);
            }
        }
        sb5.append(", ");
        sb5.append("target:");
        gu guVar = this.f24803a;
        if (guVar == null) {
            sb5.append("null");
        } else {
            sb5.append(guVar);
        }
        if (i()) {
            sb5.append(", ");
            sb5.append("metaInfo:");
            gs gsVar = this.f24802a;
            if (gsVar == null) {
                sb5.append("null");
            } else {
                sb5.append(gsVar);
            }
        }
        sb5.append(")");
        return sb5.toString();
    }

    public hb a(gf gfVar) {
        this.f389249a = gfVar;
        return this;
    }

    public hb b(boolean z16) {
        this.f24808b = z16;
        m382b(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m379a() {
        return this.f389249a != null;
    }

    public hb a(boolean z16) {
        this.f24807a = z16;
        m378a(true);
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m382b(boolean z16) {
        this.f24806a.set(1, z16);
    }

    public String b() {
        return this.f389250b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m378a(boolean z16) {
        this.f24806a.set(0, z16);
    }

    public hb b(String str) {
        this.f389250b = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m381a() {
        a(fw.n(this.f24805a));
        return this.f24805a.array();
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m377a();
        hnVar.t(f389243d);
        if (this.f389249a != null) {
            hnVar.q(f389244e);
            hnVar.o(this.f389249a.a());
            hnVar.z();
        }
        hnVar.q(f389245f);
        hnVar.x(this.f24807a);
        hnVar.z();
        hnVar.q(f389246h);
        hnVar.x(this.f24808b);
        hnVar.z();
        if (this.f24805a != null) {
            hnVar.q(f389247i);
            hnVar.v(this.f24805a);
            hnVar.z();
        }
        if (this.f24804a != null && f()) {
            hnVar.q(f389248m);
            hnVar.u(this.f24804a);
            hnVar.z();
        }
        if (this.f389250b != null && g()) {
            hnVar.q(C);
            hnVar.u(this.f389250b);
            hnVar.z();
        }
        if (this.f24803a != null) {
            hnVar.q(D);
            this.f24803a.b(hnVar);
            hnVar.z();
        }
        if (this.f24802a != null && i()) {
            hnVar.q(E);
            this.f24802a.b(hnVar);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    public hb a(ByteBuffer byteBuffer) {
        this.f24805a = byteBuffer;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m376a() {
        return this.f24804a;
    }

    public hb a(String str) {
        this.f24804a = str;
        return this;
    }

    public hb a(gu guVar) {
        this.f24803a = guVar;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gs m375a() {
        return this.f24802a;
    }

    public hb a(gs gsVar) {
        this.f24802a = gsVar;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m380a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean m379a = m379a();
        boolean m379a2 = hbVar.m379a();
        if (((m379a || m379a2) && (!m379a || !m379a2 || !this.f389249a.equals(hbVar.f389249a))) || this.f24807a != hbVar.f24807a || this.f24808b != hbVar.f24808b) {
            return false;
        }
        boolean e16 = e();
        boolean e17 = hbVar.e();
        if ((e16 || e17) && !(e16 && e17 && this.f24805a.equals(hbVar.f24805a))) {
            return false;
        }
        boolean f16 = f();
        boolean f17 = hbVar.f();
        if ((f16 || f17) && !(f16 && f17 && this.f24804a.equals(hbVar.f24804a))) {
            return false;
        }
        boolean g16 = g();
        boolean g17 = hbVar.g();
        if ((g16 || g17) && !(g16 && g17 && this.f389250b.equals(hbVar.f389250b))) {
            return false;
        }
        boolean h16 = h();
        boolean h17 = hbVar.h();
        if ((h16 || h17) && !(h16 && h17 && this.f24803a.m353a(hbVar.f24803a))) {
            return false;
        }
        boolean i3 = i();
        boolean i16 = hbVar.i();
        if (i3 || i16) {
            return i3 && i16 && this.f24802a.m345a(hbVar.f24802a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hb hbVar) {
        int d16;
        int d17;
        int e16;
        int e17;
        int d18;
        int k3;
        int k16;
        int d19;
        if (!getClass().equals(hbVar.getClass())) {
            return getClass().getName().compareTo(hbVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m379a()).compareTo(Boolean.valueOf(hbVar.m379a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m379a() && (d19 = fw.d(this.f389249a, hbVar.f389249a)) != 0) {
            return d19;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hbVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (k16 = fw.k(this.f24807a, hbVar.f24807a)) != 0) {
            return k16;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hbVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (k3 = fw.k(this.f24808b, hbVar.f24808b)) != 0) {
            return k3;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hbVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (d18 = fw.d(this.f24805a, hbVar.f24805a)) != 0) {
            return d18;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hbVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (e17 = fw.e(this.f24804a, hbVar.f24804a)) != 0) {
            return e17;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hbVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (e16 = fw.e(this.f389250b, hbVar.f389250b)) != 0) {
            return e16;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hbVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (d17 = fw.d(this.f24803a, hbVar.f24803a)) != 0) {
            return d17;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hbVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!i() || (d16 = fw.d(this.f24802a, hbVar.f24802a)) == 0) {
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
                hnVar.D();
                if (c()) {
                    if (d()) {
                        m377a();
                        return;
                    }
                    throw new ib("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new ib("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (e16.f388942c) {
                case 1:
                    if (b16 == 8) {
                        this.f389249a = gf.a(hnVar.c());
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 2:
                    if (b16 == 2) {
                        this.f24807a = hnVar.y();
                        m378a(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 3:
                    if (b16 == 2) {
                        this.f24808b = hnVar.y();
                        m382b(true);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 4:
                    if (b16 == 11) {
                        this.f24805a = hnVar.k();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 5:
                    if (b16 == 11) {
                        this.f24804a = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 6:
                    if (b16 == 11) {
                        this.f389250b = hnVar.j();
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 7:
                    if (b16 == 12) {
                        gu guVar = new gu();
                        this.f24803a = guVar;
                        guVar.a(hnVar);
                        break;
                    } else {
                        hp.a(hnVar, b16);
                        break;
                    }
                case 8:
                    if (b16 == 12) {
                        gs gsVar = new gs();
                        this.f24802a = gsVar;
                        gsVar.a(hnVar);
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
    public void m377a() {
        if (this.f389249a != null) {
            if (this.f24805a != null) {
                if (this.f24803a != null) {
                    return;
                }
                throw new ib("Required field 'target' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'action' was not present! Struct: " + toString());
    }
}
