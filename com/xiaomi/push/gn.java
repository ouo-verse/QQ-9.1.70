package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gn implements hq<gn, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final hs f389106d = new hs("DataCollectionItem");

    /* renamed from: e, reason: collision with root package name */
    private static final ga f389107e = new ga("", (byte) 10, 1);

    /* renamed from: f, reason: collision with root package name */
    private static final ga f389108f = new ga("", (byte) 8, 2);

    /* renamed from: h, reason: collision with root package name */
    private static final ga f389109h = new ga("", (byte) 11, 3);

    /* renamed from: a, reason: collision with root package name */
    public long f389110a;

    /* renamed from: a, reason: collision with other field name */
    public gh f24743a;

    /* renamed from: a, reason: collision with other field name */
    public String f24744a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f24745a = new BitSet(1);

    public gn a(long j3) {
        this.f389110a = j3;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f24743a != null;
    }

    public boolean c() {
        if (this.f24744a != null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gn)) {
            return false;
        }
        return m321a((gn) obj);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("DataCollectionItem(");
        sb5.append("collectedAt:");
        sb5.append(this.f389110a);
        sb5.append(", ");
        sb5.append("collectionType:");
        gh ghVar = this.f24743a;
        if (ghVar == null) {
            sb5.append("null");
        } else {
            sb5.append(ghVar);
        }
        sb5.append(", ");
        sb5.append("content:");
        String str = this.f24744a;
        if (str == null) {
            sb5.append("null");
        } else {
            sb5.append(str);
        }
        sb5.append(")");
        return sb5.toString();
    }

    @Override // com.xiaomi.push.hq
    public void b(hn hnVar) {
        m319a();
        hnVar.t(f389106d);
        hnVar.q(f389107e);
        hnVar.p(this.f389110a);
        hnVar.z();
        if (this.f24743a != null) {
            hnVar.q(f389108f);
            hnVar.o(this.f24743a.a());
            hnVar.z();
        }
        if (this.f24744a != null) {
            hnVar.q(f389109h);
            hnVar.u(this.f24744a);
            hnVar.z();
        }
        hnVar.A();
        hnVar.m();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m320a() {
        return this.f24745a.get(0);
    }

    public void a(boolean z16) {
        this.f24745a.set(0, z16);
    }

    public gn a(gh ghVar) {
        this.f24743a = ghVar;
        return this;
    }

    public String a() {
        return this.f24744a;
    }

    public gn a(String str) {
        this.f24744a = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m321a(gn gnVar) {
        if (gnVar == null || this.f389110a != gnVar.f389110a) {
            return false;
        }
        boolean b16 = b();
        boolean b17 = gnVar.b();
        if ((b16 || b17) && !(b16 && b17 && this.f24743a.equals(gnVar.f24743a))) {
            return false;
        }
        boolean c16 = c();
        boolean c17 = gnVar.c();
        if (c16 || c17) {
            return c16 && c17 && this.f24744a.equals(gnVar.f24744a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gn gnVar) {
        int e16;
        int d16;
        int c16;
        if (!getClass().equals(gnVar.getClass())) {
            return getClass().getName().compareTo(gnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m320a()).compareTo(Boolean.valueOf(gnVar.m320a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m320a() && (c16 = fw.c(this.f389110a, gnVar.f389110a)) != 0) {
            return c16;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d16 = fw.d(this.f24743a, gnVar.f24743a)) != 0) {
            return d16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gnVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (e16 = fw.e(this.f24744a, gnVar.f24744a)) == 0) {
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
                break;
            }
            short s16 = e16.f388942c;
            if (s16 != 1) {
                if (s16 != 2) {
                    if (s16 != 3) {
                        hp.a(hnVar, b16);
                    } else if (b16 == 11) {
                        this.f24744a = hnVar.j();
                    } else {
                        hp.a(hnVar, b16);
                    }
                } else if (b16 == 8) {
                    this.f24743a = gh.a(hnVar.c());
                } else {
                    hp.a(hnVar, b16);
                }
            } else if (b16 == 10) {
                this.f389110a = hnVar.d();
                a(true);
            } else {
                hp.a(hnVar, b16);
            }
            hnVar.E();
        }
        hnVar.D();
        if (m320a()) {
            m319a();
            return;
        }
        throw new ib("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m319a() {
        if (this.f24743a != null) {
            if (this.f24744a != null) {
                return;
            }
            throw new ib("Required field 'content' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'collectionType' was not present! Struct: " + toString());
    }
}
