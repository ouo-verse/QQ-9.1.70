package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.base.f;
import com.google.common.base.o;
import com.google.common.base.q;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: q, reason: collision with root package name */
    static final o<? extends com.google.common.cache.b> f34716q = Suppliers.b(new a());

    /* renamed from: r, reason: collision with root package name */
    static final d f34717r = new d(0, 0, 0, 0, 0, 0);

    /* renamed from: s, reason: collision with root package name */
    static final o<com.google.common.cache.b> f34718s = new b();

    /* renamed from: t, reason: collision with root package name */
    static final q f34719t = new c();

    /* renamed from: u, reason: collision with root package name */
    private static final Logger f34720u = Logger.getLogger(CacheBuilder.class.getName());

    /* renamed from: f, reason: collision with root package name */
    @MonotonicNonNullDecl
    k<? super K, ? super V> f34726f;

    /* renamed from: g, reason: collision with root package name */
    @MonotonicNonNullDecl
    LocalCache.Strength f34727g;

    /* renamed from: h, reason: collision with root package name */
    @MonotonicNonNullDecl
    LocalCache.Strength f34728h;

    /* renamed from: l, reason: collision with root package name */
    @MonotonicNonNullDecl
    Equivalence<Object> f34732l;

    /* renamed from: m, reason: collision with root package name */
    @MonotonicNonNullDecl
    Equivalence<Object> f34733m;

    /* renamed from: n, reason: collision with root package name */
    @MonotonicNonNullDecl
    i<? super K, ? super V> f34734n;

    /* renamed from: o, reason: collision with root package name */
    @MonotonicNonNullDecl
    q f34735o;

    /* renamed from: a, reason: collision with root package name */
    boolean f34721a = true;

    /* renamed from: b, reason: collision with root package name */
    int f34722b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f34723c = -1;

    /* renamed from: d, reason: collision with root package name */
    long f34724d = -1;

    /* renamed from: e, reason: collision with root package name */
    long f34725e = -1;

    /* renamed from: i, reason: collision with root package name */
    long f34729i = -1;

    /* renamed from: j, reason: collision with root package name */
    long f34730j = -1;

    /* renamed from: k, reason: collision with root package name */
    long f34731k = -1;

    /* renamed from: p, reason: collision with root package name */
    o<? extends com.google.common.cache.b> f34736p = f34716q;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum OneWeigher implements k<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.k
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b implements o<com.google.common.cache.b> {
        b() {
        }

        @Override // com.google.common.base.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.b get() {
            return new com.google.common.cache.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class c extends q {
        c() {
        }

        @Override // com.google.common.base.q
        public long a() {
            return 0L;
        }
    }

    CacheBuilder() {
    }

    private void c() {
        boolean z16;
        if (this.f34731k == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.t(z16, "refreshAfterWrite requires a LoadingCache");
    }

    private void d() {
        boolean z16 = true;
        if (this.f34726f == null) {
            if (this.f34725e != -1) {
                z16 = false;
            }
            com.google.common.base.j.t(z16, "maximumWeight requires weigher");
        } else if (this.f34721a) {
            if (this.f34725e == -1) {
                z16 = false;
            }
            com.google.common.base.j.t(z16, "weigher requires maximumWeight");
        } else if (this.f34725e == -1) {
            f34720u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public static CacheBuilder<Object, Object> y() {
        return new CacheBuilder<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> A(LocalCache.Strength strength) {
        boolean z16;
        LocalCache.Strength strength2 = this.f34727g;
        if (strength2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.w(z16, "Key strength was already set to %s", strength2);
        this.f34727g = (LocalCache.Strength) com.google.common.base.j.m(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> B(LocalCache.Strength strength) {
        boolean z16;
        LocalCache.Strength strength2 = this.f34728h;
        if (strength2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.w(z16, "Value strength was already set to %s", strength2);
        this.f34728h = (LocalCache.Strength) com.google.common.base.j.m(strength);
        return this;
    }

    public CacheBuilder<K, V> C(q qVar) {
        boolean z16;
        if (this.f34735o == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.s(z16);
        this.f34735o = (q) com.google.common.base.j.m(qVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> D(Equivalence<Object> equivalence) {
        boolean z16;
        Equivalence<Object> equivalence2 = this.f34733m;
        if (equivalence2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.w(z16, "value equivalence was already set to %s", equivalence2);
        this.f34733m = (Equivalence) com.google.common.base.j.m(equivalence);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> E(k<? super K1, ? super V1> kVar) {
        boolean z16;
        boolean z17 = true;
        if (this.f34726f == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.s(z16);
        if (this.f34721a) {
            long j3 = this.f34724d;
            if (j3 != -1) {
                z17 = false;
            }
            com.google.common.base.j.v(z17, "weigher can not be combined with maximum size", j3);
        }
        this.f34726f = (k) com.google.common.base.j.m(kVar);
        return this;
    }

    public <K1 extends K, V1 extends V> com.google.common.cache.c<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> f<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> e(int i3) {
        boolean z16;
        int i16 = this.f34723c;
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
        this.f34723c = i3;
        return this;
    }

    public CacheBuilder<K, V> f(long j3, TimeUnit timeUnit) {
        boolean z16;
        long j16 = this.f34730j;
        boolean z17 = true;
        if (j16 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.v(z16, "expireAfterAccess was already set to %s ns", j16);
        if (j3 < 0) {
            z17 = false;
        }
        com.google.common.base.j.h(z17, "duration cannot be negative: %s %s", j3, timeUnit);
        this.f34730j = timeUnit.toNanos(j3);
        return this;
    }

    public CacheBuilder<K, V> g(long j3, TimeUnit timeUnit) {
        boolean z16;
        long j16 = this.f34729i;
        boolean z17 = true;
        if (j16 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.v(z16, "expireAfterWrite was already set to %s ns", j16);
        if (j3 < 0) {
            z17 = false;
        }
        com.google.common.base.j.h(z17, "duration cannot be negative: %s %s", j3, timeUnit);
        this.f34729i = timeUnit.toNanos(j3);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        int i3 = this.f34723c;
        if (i3 == -1) {
            return 4;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        long j3 = this.f34730j;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j() {
        long j3 = this.f34729i;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        int i3 = this.f34722b;
        if (i3 == -1) {
            return 16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> l() {
        return (Equivalence) com.google.common.base.f.a(this.f34732l, m().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength m() {
        return (LocalCache.Strength) com.google.common.base.f.a(this.f34727g, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long n() {
        if (this.f34729i == 0 || this.f34730j == 0) {
            return 0L;
        }
        if (this.f34726f == null) {
            return this.f34724d;
        }
        return this.f34725e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long o() {
        long j3 = this.f34731k;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> i<K1, V1> p() {
        return (i) com.google.common.base.f.a(this.f34734n, NullListener.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<? extends com.google.common.cache.b> q() {
        return this.f34736p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q r(boolean z16) {
        q qVar = this.f34735o;
        if (qVar != null) {
            return qVar;
        }
        if (z16) {
            return q.b();
        }
        return f34719t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> s() {
        return (Equivalence) com.google.common.base.f.a(this.f34733m, t().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength t() {
        return (LocalCache.Strength) com.google.common.base.f.a(this.f34728h, LocalCache.Strength.STRONG);
    }

    public String toString() {
        f.b b16 = com.google.common.base.f.b(this);
        int i3 = this.f34722b;
        if (i3 != -1) {
            b16.a("initialCapacity", i3);
        }
        int i16 = this.f34723c;
        if (i16 != -1) {
            b16.a("concurrencyLevel", i16);
        }
        long j3 = this.f34724d;
        if (j3 != -1) {
            b16.b("maximumSize", j3);
        }
        long j16 = this.f34725e;
        if (j16 != -1) {
            b16.b("maximumWeight", j16);
        }
        if (this.f34729i != -1) {
            b16.c("expireAfterWrite", this.f34729i + "ns");
        }
        if (this.f34730j != -1) {
            b16.c("expireAfterAccess", this.f34730j + "ns");
        }
        LocalCache.Strength strength = this.f34727g;
        if (strength != null) {
            b16.c("keyStrength", com.google.common.base.a.b(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f34728h;
        if (strength2 != null) {
            b16.c("valueStrength", com.google.common.base.a.b(strength2.toString()));
        }
        if (this.f34732l != null) {
            b16.g("keyEquivalence");
        }
        if (this.f34733m != null) {
            b16.g("valueEquivalence");
        }
        if (this.f34734n != null) {
            b16.g("removalListener");
        }
        return b16.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> k<K1, V1> u() {
        return (k) com.google.common.base.f.a(this.f34726f, OneWeigher.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> v(Equivalence<Object> equivalence) {
        boolean z16;
        Equivalence<Object> equivalence2 = this.f34732l;
        if (equivalence2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.w(z16, "key equivalence was already set to %s", equivalence2);
        this.f34732l = (Equivalence) com.google.common.base.j.m(equivalence);
        return this;
    }

    public CacheBuilder<K, V> w(long j3) {
        boolean z16;
        boolean z17;
        boolean z18;
        long j16 = this.f34724d;
        boolean z19 = true;
        if (j16 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.v(z16, "maximum size was already set to %s", j16);
        long j17 = this.f34725e;
        if (j17 == -1) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.google.common.base.j.v(z17, "maximum weight was already set to %s", j17);
        if (this.f34726f == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        com.google.common.base.j.t(z18, "maximum size can not be combined with weigher");
        if (j3 < 0) {
            z19 = false;
        }
        com.google.common.base.j.e(z19, "maximum size must not be negative");
        this.f34724d = j3;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> x(long j3) {
        boolean z16;
        boolean z17;
        long j16 = this.f34725e;
        boolean z18 = true;
        if (j16 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.v(z16, "maximum weight was already set to %s", j16);
        long j17 = this.f34724d;
        if (j17 == -1) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.google.common.base.j.v(z17, "maximum size was already set to %s", j17);
        this.f34725e = j3;
        if (j3 < 0) {
            z18 = false;
        }
        com.google.common.base.j.e(z18, "maximum weight must not be negative");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> z(i<? super K1, ? super V1> iVar) {
        boolean z16;
        if (this.f34734n == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.s(z16);
        this.f34734n = (i) com.google.common.base.j.m(iVar);
        return this;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a implements com.google.common.cache.b {
        a() {
        }

        @Override // com.google.common.cache.b
        public d e() {
            return CacheBuilder.f34717r;
        }

        @Override // com.google.common.cache.b
        public void b() {
        }

        @Override // com.google.common.cache.b
        public void a(int i3) {
        }

        @Override // com.google.common.cache.b
        public void c(long j3) {
        }

        @Override // com.google.common.cache.b
        public void d(int i3) {
        }

        @Override // com.google.common.cache.b
        public void f(long j3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum NullListener implements i<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.i
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }
}
