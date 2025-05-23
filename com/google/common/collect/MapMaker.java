package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.f;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class MapMaker {

    /* renamed from: a, reason: collision with root package name */
    boolean f34936a;

    /* renamed from: b, reason: collision with root package name */
    int f34937b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f34938c = -1;

    /* renamed from: d, reason: collision with root package name */
    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength f34939d;

    /* renamed from: e, reason: collision with root package name */
    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength f34940e;

    /* renamed from: f, reason: collision with root package name */
    @MonotonicNonNullDecl
    Equivalence<Object> f34941f;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum Dummy {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker a(int i3) {
        boolean z16;
        int i16 = this.f34938c;
        boolean z17 = true;
        if (i16 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.u(z16, "concurrency level was already set to %s", i16);
        if (i3 <= 0) {
            z17 = false;
        }
        com.google.common.base.j.d(z17);
        this.f34938c = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i3 = this.f34938c;
        if (i3 == -1) {
            return 4;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        int i3 = this.f34937b;
        if (i3 == -1) {
            return 16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> d() {
        return (Equivalence) com.google.common.base.f.a(this.f34941f, e().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.common.base.f.a(this.f34939d, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.common.base.f.a(this.f34940e, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker g(int i3) {
        boolean z16;
        int i16 = this.f34937b;
        boolean z17 = true;
        if (i16 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.u(z16, "initial capacity was already set to %s", i16);
        if (i3 < 0) {
            z17 = false;
        }
        com.google.common.base.j.d(z17);
        this.f34937b = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker h(Equivalence<Object> equivalence) {
        boolean z16;
        Equivalence<Object> equivalence2 = this.f34941f;
        if (equivalence2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.w(z16, "key equivalence was already set to %s", equivalence2);
        this.f34941f = (Equivalence) com.google.common.base.j.m(equivalence);
        this.f34936a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.f34936a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker j(MapMakerInternalMap.Strength strength) {
        boolean z16;
        MapMakerInternalMap.Strength strength2 = this.f34939d;
        if (strength2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.w(z16, "Key strength was already set to %s", strength2);
        this.f34939d = (MapMakerInternalMap.Strength) com.google.common.base.j.m(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f34936a = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker k(MapMakerInternalMap.Strength strength) {
        boolean z16;
        MapMakerInternalMap.Strength strength2 = this.f34940e;
        if (strength2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.w(z16, "Value strength was already set to %s", strength2);
        this.f34940e = (MapMakerInternalMap.Strength) com.google.common.base.j.m(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f34936a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        f.b b16 = com.google.common.base.f.b(this);
        int i3 = this.f34937b;
        if (i3 != -1) {
            b16.a("initialCapacity", i3);
        }
        int i16 = this.f34938c;
        if (i16 != -1) {
            b16.a("concurrencyLevel", i16);
        }
        MapMakerInternalMap.Strength strength = this.f34939d;
        if (strength != null) {
            b16.c("keyStrength", com.google.common.base.a.b(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f34940e;
        if (strength2 != null) {
            b16.c("valueStrength", com.google.common.base.a.b(strength2.toString()));
        }
        if (this.f34941f != null) {
            b16.g("keyEquivalence");
        }
        return b16.toString();
    }
}
