package com.tencent.luggage.wxa.m;

import android.util.Pair;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f133925a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends u {
        @Override // com.tencent.luggage.wxa.m.u
        public int a() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.m.u
        public int b() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.m.u
        public int a(Object obj) {
            return -1;
        }

        @Override // com.tencent.luggage.wxa.m.u
        public c a(int i3, c cVar, boolean z16, long j3) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.tencent.luggage.wxa.m.u
        public b a(int i3, b bVar, boolean z16) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Object f133926a;

        /* renamed from: b, reason: collision with root package name */
        public Object f133927b;

        /* renamed from: c, reason: collision with root package name */
        public int f133928c;

        /* renamed from: d, reason: collision with root package name */
        public long f133929d;

        /* renamed from: e, reason: collision with root package name */
        public long f133930e;

        /* renamed from: f, reason: collision with root package name */
        public long[] f133931f;

        /* renamed from: g, reason: collision with root package name */
        public int[] f133932g;

        /* renamed from: h, reason: collision with root package name */
        public int[] f133933h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f133934i;

        /* renamed from: j, reason: collision with root package name */
        public long[][] f133935j;

        /* renamed from: k, reason: collision with root package name */
        public long f133936k;

        public b a(Object obj, Object obj2, int i3, long j3, long j16) {
            return a(obj, obj2, i3, j3, j16, null, null, null, null, null, -9223372036854775807L);
        }

        public long b(int i3) {
            return this.f133931f[i3];
        }

        public long c() {
            return com.tencent.luggage.wxa.m.b.b(this.f133929d);
        }

        public long d() {
            return this.f133929d;
        }

        public long e() {
            return com.tencent.luggage.wxa.m.b.b(this.f133930e);
        }

        public b a(Object obj, Object obj2, int i3, long j3, long j16, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j17) {
            this.f133926a = obj;
            this.f133927b = obj2;
            this.f133928c = i3;
            this.f133929d = j3;
            this.f133930e = j16;
            this.f133931f = jArr;
            this.f133932g = iArr;
            this.f133933h = iArr2;
            this.f133934i = iArr3;
            this.f133935j = jArr2;
            this.f133936k = j17;
            return this;
        }

        public int b(long j3) {
            long[] jArr = this.f133931f;
            if (jArr == null) {
                return -1;
            }
            int length = jArr.length - 1;
            while (length >= 0) {
                long j16 = this.f133931f[length];
                if (j16 != Long.MIN_VALUE && j16 <= j3) {
                    break;
                }
                length--;
            }
            if (length < 0 || d(length)) {
                return -1;
            }
            return length;
        }

        public int c(int i3) {
            return this.f133934i[i3];
        }

        public boolean d(int i3) {
            int i16 = this.f133932g[i3];
            return i16 != -1 && this.f133934i[i3] == i16;
        }

        public boolean b(int i3, int i16) {
            return i16 < this.f133933h[i3];
        }

        public long b() {
            return this.f133936k;
        }

        public int a() {
            long[] jArr = this.f133931f;
            if (jArr == null) {
                return 0;
            }
            return jArr.length;
        }

        public int a(long j3) {
            if (this.f133931f == null) {
                return -1;
            }
            int i3 = 0;
            while (true) {
                long[] jArr = this.f133931f;
                if (i3 >= jArr.length) {
                    break;
                }
                long j16 = jArr[i3];
                if (j16 == Long.MIN_VALUE || (j3 < j16 && !d(i3))) {
                    break;
                }
                i3++;
            }
            if (i3 < this.f133931f.length) {
                return i3;
            }
            return -1;
        }

        public int a(int i3) {
            return this.f133932g[i3];
        }

        public long a(int i3, int i16) {
            long[] jArr = this.f133935j[i3];
            if (i16 >= jArr.length) {
                return -9223372036854775807L;
            }
            return jArr[i16];
        }
    }

    public abstract int a();

    public int a(int i3, int i16) {
        if (i16 == 0) {
            if (i3 == b() - 1) {
                return -1;
            }
            return i3 + 1;
        }
        if (i16 == 1) {
            return i3;
        }
        if (i16 == 2) {
            if (i3 == b() - 1) {
                return 0;
            }
            return i3 + 1;
        }
        throw new IllegalStateException();
    }

    public abstract int a(Object obj);

    public abstract b a(int i3, b bVar, boolean z16);

    public abstract c a(int i3, c cVar, boolean z16, long j3);

    public abstract int b();

    public final boolean b(int i3, b bVar, c cVar, int i16) {
        if (a(i3, bVar, cVar, i16) == -1) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        if (b() == 0) {
            return true;
        }
        return false;
    }

    public final c a(int i3, c cVar) {
        return a(i3, cVar, false);
    }

    public c a(int i3, c cVar, boolean z16) {
        return a(i3, cVar, z16, 0L);
    }

    public final int a(int i3, b bVar, c cVar, int i16) {
        int i17 = a(i3, bVar).f133928c;
        if (a(i17, cVar).f133943g != i3) {
            return i3 + 1;
        }
        int a16 = a(i17, i16);
        if (a16 == -1) {
            return -1;
        }
        return a(a16, cVar).f133942f;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public Object f133937a;

        /* renamed from: b, reason: collision with root package name */
        public long f133938b;

        /* renamed from: c, reason: collision with root package name */
        public long f133939c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f133940d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f133941e;

        /* renamed from: f, reason: collision with root package name */
        public int f133942f;

        /* renamed from: g, reason: collision with root package name */
        public int f133943g;

        /* renamed from: h, reason: collision with root package name */
        public long f133944h;

        /* renamed from: i, reason: collision with root package name */
        public long f133945i;

        /* renamed from: j, reason: collision with root package name */
        public long f133946j;

        public c a(Object obj, long j3, long j16, boolean z16, boolean z17, long j17, long j18, int i3, int i16, long j19) {
            this.f133937a = obj;
            this.f133938b = j3;
            this.f133939c = j16;
            this.f133940d = z16;
            this.f133941e = z17;
            this.f133944h = j17;
            this.f133945i = j18;
            this.f133942f = i3;
            this.f133943g = i16;
            this.f133946j = j19;
            return this;
        }

        public long b() {
            return com.tencent.luggage.wxa.m.b.b(this.f133945i);
        }

        public long c() {
            return this.f133946j;
        }

        public long a() {
            return this.f133944h;
        }
    }

    public final b a(int i3, b bVar) {
        return a(i3, bVar, false);
    }

    public final Pair a(c cVar, b bVar, int i3, long j3) {
        return a(cVar, bVar, i3, j3, 0L);
    }

    public final Pair a(c cVar, b bVar, int i3, long j3, long j16) {
        com.tencent.luggage.wxa.n0.a.a(i3, 0, b());
        a(i3, cVar, false, j16);
        if (j3 == -9223372036854775807L) {
            j3 = cVar.a();
            if (j3 == -9223372036854775807L) {
                return null;
            }
        }
        int i16 = cVar.f133942f;
        long c16 = cVar.c() + j3;
        long d16 = a(i16, bVar).d();
        while (d16 != -9223372036854775807L && c16 >= d16 && i16 < cVar.f133943g) {
            c16 -= d16;
            i16++;
            d16 = a(i16, bVar).d();
        }
        return Pair.create(Integer.valueOf(i16), Long.valueOf(c16));
    }
}
