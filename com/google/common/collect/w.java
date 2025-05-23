package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Multisets;
import com.google.common.collect.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public class w<K> {

    /* renamed from: a, reason: collision with root package name */
    transient Object[] f35063a;

    /* renamed from: b, reason: collision with root package name */
    transient int[] f35064b;

    /* renamed from: c, reason: collision with root package name */
    transient int f35065c;

    /* renamed from: d, reason: collision with root package name */
    transient int f35066d;

    /* renamed from: e, reason: collision with root package name */
    private transient int[] f35067e;

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    transient long[] f35068f;

    /* renamed from: g, reason: collision with root package name */
    private transient float f35069g;

    /* renamed from: h, reason: collision with root package name */
    private transient int f35070h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends Multisets.a<K> {

        /* renamed from: d, reason: collision with root package name */
        @NullableDecl
        final K f35071d;

        /* renamed from: e, reason: collision with root package name */
        int f35072e;

        a(int i3) {
            this.f35071d = (K) w.this.f35063a[i3];
            this.f35072e = i3;
        }

        void a() {
            int i3 = this.f35072e;
            if (i3 == -1 || i3 >= w.this.C() || !com.google.common.base.g.a(this.f35071d, w.this.f35063a[this.f35072e])) {
                this.f35072e = w.this.m(this.f35071d);
            }
        }

        @Override // com.google.common.collect.u.a
        public int getCount() {
            a();
            int i3 = this.f35072e;
            if (i3 == -1) {
                return 0;
            }
            return w.this.f35064b[i3];
        }

        @Override // com.google.common.collect.u.a
        public K getElement() {
            return this.f35071d;
        }
    }

    w() {
        n(3, 1.0f);
    }

    private void A(int i3) {
        if (this.f35067e.length >= 1073741824) {
            this.f35070h = Integer.MAX_VALUE;
            return;
        }
        int i16 = ((int) (i3 * this.f35069g)) + 1;
        int[] r16 = r(i3);
        long[] jArr = this.f35068f;
        int length = r16.length - 1;
        for (int i17 = 0; i17 < this.f35065c; i17++) {
            int h16 = h(jArr[i17]);
            int i18 = h16 & length;
            int i19 = r16[i18];
            r16[i18] = i17;
            jArr[i17] = (h16 << 32) | (i19 & 4294967295L);
        }
        this.f35070h = i16;
        this.f35067e = r16;
    }

    private static long D(long j3, int i3) {
        return (j3 & (-4294967296L)) | (4294967295L & i3);
    }

    public static <K> w<K> b() {
        return new w<>();
    }

    public static <K> w<K> c(int i3) {
        return new w<>(i3);
    }

    private static int h(long j3) {
        return (int) (j3 >>> 32);
    }

    private static int j(long j3) {
        return (int) j3;
    }

    private int l() {
        return this.f35067e.length - 1;
    }

    private static long[] q(int i3) {
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] r(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int w(@NullableDecl Object obj, int i3) {
        int l3 = l() & i3;
        int i16 = this.f35067e[l3];
        if (i16 == -1) {
            return 0;
        }
        int i17 = -1;
        while (true) {
            if (h(this.f35068f[i16]) == i3 && com.google.common.base.g.a(obj, this.f35063a[i16])) {
                int i18 = this.f35064b[i16];
                if (i17 == -1) {
                    this.f35067e[l3] = j(this.f35068f[i16]);
                } else {
                    long[] jArr = this.f35068f;
                    jArr[i17] = D(jArr[i17], j(jArr[i16]));
                }
                p(i16);
                this.f35065c--;
                this.f35066d++;
                return i18;
            }
            int j3 = j(this.f35068f[i16]);
            if (j3 == -1) {
                return 0;
            }
            i17 = i16;
            i16 = j3;
        }
    }

    private void z(int i3) {
        int length = this.f35068f.length;
        if (i3 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i3, int i16) {
        com.google.common.base.j.k(i3, this.f35065c);
        this.f35064b[i3] = i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.f35065c;
    }

    public void a() {
        this.f35066d++;
        Arrays.fill(this.f35063a, 0, this.f35065c, (Object) null);
        Arrays.fill(this.f35064b, 0, this.f35065c, 0);
        Arrays.fill(this.f35067e, -1);
        Arrays.fill(this.f35068f, -1L);
        this.f35065c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i3) {
        if (i3 > this.f35068f.length) {
            y(i3);
        }
        if (i3 >= this.f35070h) {
            A(Math.max(2, Integer.highestOneBit(i3 - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        if (this.f35065c == 0) {
            return -1;
        }
        return 0;
    }

    public int f(@NullableDecl Object obj) {
        int m3 = m(obj);
        if (m3 == -1) {
            return 0;
        }
        return this.f35064b[m3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u.a<K> g(int i3) {
        com.google.common.base.j.k(i3, this.f35065c);
        return new a(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public K i(int i3) {
        com.google.common.base.j.k(i3, this.f35065c);
        return (K) this.f35063a[i3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(int i3) {
        com.google.common.base.j.k(i3, this.f35065c);
        return this.f35064b[i3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(@NullableDecl Object obj) {
        int c16 = p.c(obj);
        int i3 = this.f35067e[l() & c16];
        while (i3 != -1) {
            long j3 = this.f35068f[i3];
            if (h(j3) == c16 && com.google.common.base.g.a(obj, this.f35063a[i3])) {
                return i3;
            }
            i3 = j(j3);
        }
        return -1;
    }

    void n(int i3, float f16) {
        boolean z16;
        boolean z17 = false;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.e(z16, "Initial capacity must be non-negative");
        if (f16 > 0.0f) {
            z17 = true;
        }
        com.google.common.base.j.e(z17, "Illegal load factor");
        int a16 = p.a(i3, f16);
        this.f35067e = r(a16);
        this.f35069g = f16;
        this.f35063a = new Object[i3];
        this.f35064b = new int[i3];
        this.f35068f = q(i3);
        this.f35070h = Math.max(1, (int) (a16 * f16));
    }

    void o(int i3, @NullableDecl K k3, int i16, int i17) {
        this.f35068f[i3] = (i17 << 32) | 4294967295L;
        this.f35063a[i3] = k3;
        this.f35064b[i3] = i16;
    }

    void p(int i3) {
        int C = C() - 1;
        if (i3 < C) {
            Object[] objArr = this.f35063a;
            objArr[i3] = objArr[C];
            int[] iArr = this.f35064b;
            iArr[i3] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f35068f;
            long j3 = jArr[C];
            jArr[i3] = j3;
            jArr[C] = -1;
            int h16 = h(j3) & l();
            int[] iArr2 = this.f35067e;
            int i16 = iArr2[h16];
            if (i16 == C) {
                iArr2[h16] = i3;
                return;
            }
            while (true) {
                long j16 = this.f35068f[i16];
                int j17 = j(j16);
                if (j17 == C) {
                    this.f35068f[i16] = D(j16, i3);
                    return;
                }
                i16 = j17;
            }
        } else {
            this.f35063a[i3] = null;
            this.f35064b[i3] = 0;
            this.f35068f[i3] = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(int i3) {
        int i16 = i3 + 1;
        if (i16 >= this.f35065c) {
            return -1;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i3, int i16) {
        return i3 - 1;
    }

    @CanIgnoreReturnValue
    public int u(@NullableDecl K k3, int i3) {
        h.c(i3, "count");
        long[] jArr = this.f35068f;
        Object[] objArr = this.f35063a;
        int[] iArr = this.f35064b;
        int c16 = p.c(k3);
        int l3 = l() & c16;
        int i16 = this.f35065c;
        int[] iArr2 = this.f35067e;
        int i17 = iArr2[l3];
        if (i17 == -1) {
            iArr2[l3] = i16;
        } else {
            while (true) {
                long j3 = jArr[i17];
                if (h(j3) == c16 && com.google.common.base.g.a(k3, objArr[i17])) {
                    int i18 = iArr[i17];
                    iArr[i17] = i3;
                    return i18;
                }
                int j16 = j(j3);
                if (j16 == -1) {
                    jArr[i17] = D(j3, i16);
                    break;
                }
                i17 = j16;
            }
        }
        if (i16 != Integer.MAX_VALUE) {
            int i19 = i16 + 1;
            z(i19);
            o(i16, k3, i3, c16);
            this.f35065c = i19;
            if (i16 >= this.f35070h) {
                A(this.f35067e.length * 2);
            }
            this.f35066d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @CanIgnoreReturnValue
    public int v(@NullableDecl Object obj) {
        return w(obj, p.c(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int x(int i3) {
        return w(this.f35063a[i3], h(this.f35068f[i3]));
    }

    void y(int i3) {
        this.f35063a = Arrays.copyOf(this.f35063a, i3);
        this.f35064b = Arrays.copyOf(this.f35064b, i3);
        long[] jArr = this.f35068f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(copyOf, length, i3, -1L);
        }
        this.f35068f = copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(w<? extends K> wVar) {
        n(wVar.C(), 1.0f);
        int e16 = wVar.e();
        while (e16 != -1) {
            u(wVar.i(e16), wVar.k(e16));
            e16 = wVar.s(e16);
        }
    }

    w(int i3) {
        this(i3, 1.0f);
    }

    w(int i3, float f16) {
        n(i3, f16);
    }
}
