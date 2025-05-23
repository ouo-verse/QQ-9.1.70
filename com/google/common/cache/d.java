package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final long f34824a;

    /* renamed from: b, reason: collision with root package name */
    private final long f34825b;

    /* renamed from: c, reason: collision with root package name */
    private final long f34826c;

    /* renamed from: d, reason: collision with root package name */
    private final long f34827d;

    /* renamed from: e, reason: collision with root package name */
    private final long f34828e;

    /* renamed from: f, reason: collision with root package name */
    private final long f34829f;

    public d(long j3, long j16, long j17, long j18, long j19, long j26) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.d(z16);
        if (j16 >= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.google.common.base.j.d(z17);
        if (j17 >= 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        com.google.common.base.j.d(z18);
        if (j18 >= 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        com.google.common.base.j.d(z19);
        if (j19 >= 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        com.google.common.base.j.d(z26);
        com.google.common.base.j.d(j26 >= 0);
        this.f34824a = j3;
        this.f34825b = j16;
        this.f34826c = j17;
        this.f34827d = j18;
        this.f34828e = j19;
        this.f34829f = j26;
    }

    public long a() {
        return this.f34829f;
    }

    public long b() {
        return this.f34824a;
    }

    public long c() {
        return this.f34827d;
    }

    public long d() {
        return this.f34826c;
    }

    public long e() {
        return this.f34825b;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f34824a != dVar.f34824a || this.f34825b != dVar.f34825b || this.f34826c != dVar.f34826c || this.f34827d != dVar.f34827d || this.f34828e != dVar.f34828e || this.f34829f != dVar.f34829f) {
            return false;
        }
        return true;
    }

    public long f() {
        return this.f34828e;
    }

    public int hashCode() {
        return com.google.common.base.g.b(Long.valueOf(this.f34824a), Long.valueOf(this.f34825b), Long.valueOf(this.f34826c), Long.valueOf(this.f34827d), Long.valueOf(this.f34828e), Long.valueOf(this.f34829f));
    }

    public String toString() {
        return com.google.common.base.f.b(this).b("hitCount", this.f34824a).b("missCount", this.f34825b).b("loadSuccessCount", this.f34826c).b("loadExceptionCount", this.f34827d).b("totalLoadTime", this.f34828e).b("evictionCount", this.f34829f).toString();
    }
}
