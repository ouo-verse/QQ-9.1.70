package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gx implements hq<gx, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389217d = new hs("XmPushActionCheckClientInfo");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389218e = new ga("", (byte) 8, 1);

    /* renamed from: f, reason: collision with root package name */
    private static final ga f389219f = new ga("", (byte) 8, 2);

    /* renamed from: a, reason: collision with root package name */
    public int f389220a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24790a = new BitSet(2);

    /* renamed from: b, reason: collision with root package name */
    public int f389221b;

    public void a() {
    }

    public gx b(int i3) {
        this.f389221b = i3;
        b(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gx)) {
            return false;
        }
        return m362a((gx) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f389220a + ", pluginConfigVersion:" + this.f389221b + ")";
    }

    public gx a(int i3) {
        this.f389220a = i3;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f24790a.get(1);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m361a() {
        return this.f24790a.get(0);
    }

    public void b(boolean z16) {
        this.f24790a.set(1, z16);
    }

    public void a(boolean z16) {
        this.f24790a.set(0, z16);
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        a();
        hnVar.t(f389217d);
        hnVar.q(f389218e);
        hnVar.o(this.f389220a);
        hnVar.z();
        hnVar.q(f389219f);
        hnVar.o(this.f389221b);
        hnVar.z();
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m362a(gx gxVar) {
        return gxVar != null && this.f389220a == gxVar.f389220a && this.f389221b == gxVar.f389221b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gx gxVar) {
        int b16;
        int b17;
        if (!getClass().equals(gxVar.getClass())) {
            return getClass().getName().compareTo(gxVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m361a()).compareTo(Boolean.valueOf(gxVar.m361a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m361a() && (b17 = fw.b(this.f389220a, gxVar.f389220a)) != 0) {
            return b17;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gxVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (b16 = fw.b(this.f389221b, gxVar.f389221b)) == 0) {
            return 0;
        }
        return b16;
    }

    @Override // com.xiaomi.push.hq
    public void a(hn hnVar) {
        hnVar.i();
        while (true) {
            ga e16 = hnVar.e();
            byte b16 = e16.f388941b;
            if (b16 == 0) {
                break;
            }
            short s16 = e16.f388942c;
            if (s16 != 1) {
                if (s16 != 2) {
                    hp.a(hnVar, b16);
                } else if (b16 == 8) {
                    this.f389221b = hnVar.c();
                    b(true);
                } else {
                    hp.a(hnVar, b16);
                }
            } else if (b16 == 8) {
                this.f389220a = hnVar.c();
                a(true);
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
        hnVar.D();
        if (m361a()) {
            if (b()) {
                a();
                return;
            }
            throw new ib("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        throw new ib("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }
}
