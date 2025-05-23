package com.tencent.luggage.wxa.d0;

import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.q.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: i, reason: collision with root package name */
    public int f124006i;

    /* renamed from: j, reason: collision with root package name */
    public int f124007j;

    /* renamed from: k, reason: collision with root package name */
    public int f124008k;

    /* renamed from: l, reason: collision with root package name */
    public int f124009l;

    /* renamed from: q, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.j f124014q;

    /* renamed from: r, reason: collision with root package name */
    public int f124015r;

    /* renamed from: a, reason: collision with root package name */
    public int f123998a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public int[] f123999b = new int[1000];

    /* renamed from: c, reason: collision with root package name */
    public long[] f124000c = new long[1000];

    /* renamed from: f, reason: collision with root package name */
    public long[] f124003f = new long[1000];

    /* renamed from: e, reason: collision with root package name */
    public int[] f124002e = new int[1000];

    /* renamed from: d, reason: collision with root package name */
    public int[] f124001d = new int[1000];

    /* renamed from: g, reason: collision with root package name */
    public l.a[] f124004g = new l.a[1000];

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.j[] f124005h = new com.tencent.luggage.wxa.m.j[1000];

    /* renamed from: m, reason: collision with root package name */
    public long f124010m = Long.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public long f124011n = Long.MIN_VALUE;

    /* renamed from: p, reason: collision with root package name */
    public boolean f124013p = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f124012o = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f124016a;

        /* renamed from: b, reason: collision with root package name */
        public long f124017b;

        /* renamed from: c, reason: collision with root package name */
        public l.a f124018c;
    }

    public void a(boolean z16) {
        this.f124006i = 0;
        this.f124007j = 0;
        this.f124008k = 0;
        this.f124009l = 0;
        this.f124012o = true;
        this.f124010m = Long.MIN_VALUE;
        this.f124011n = Long.MIN_VALUE;
        if (z16) {
            this.f124014q = null;
            this.f124013p = true;
        }
    }

    public long b(int i3) {
        int g16 = g() - i3;
        com.tencent.luggage.wxa.n0.a.a(g16 >= 0 && g16 <= this.f124006i - this.f124009l);
        int i16 = this.f124006i - g16;
        this.f124006i = i16;
        this.f124011n = Math.max(this.f124010m, c(i16));
        int i17 = this.f124006i;
        if (i17 == 0) {
            return 0L;
        }
        return this.f124000c[d(i17 - 1)] + this.f124001d[r6];
    }

    public synchronized long c() {
        int i3 = this.f124009l;
        if (i3 == 0) {
            return -1L;
        }
        return a(i3);
    }

    public synchronized long d() {
        return this.f124011n;
    }

    public void e(int i3) {
        this.f124015r = i3;
    }

    public synchronized com.tencent.luggage.wxa.m.j f() {
        com.tencent.luggage.wxa.m.j jVar;
        if (this.f124013p) {
            jVar = null;
        } else {
            jVar = this.f124014q;
        }
        return jVar;
    }

    public int g() {
        return this.f124007j + this.f124006i;
    }

    public synchronized boolean h() {
        boolean z16;
        if (this.f124009l != this.f124006i) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public int i() {
        int d16 = d(this.f124009l);
        if (h()) {
            return this.f123999b[d16];
        }
        return this.f124015r;
    }

    public synchronized void j() {
        this.f124009l = 0;
    }

    public final int d(int i3) {
        int i16 = this.f124008k + i3;
        int i17 = this.f123998a;
        return i16 < i17 ? i16 : i16 - i17;
    }

    public int e() {
        return this.f124007j + this.f124009l;
    }

    public final long c(int i3) {
        long j3 = Long.MIN_VALUE;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int d16 = d(i3 - 1);
        for (int i16 = 0; i16 < i3; i16++) {
            j3 = Math.max(j3, this.f124003f[d16]);
            if ((this.f124002e[d16] & 1) != 0) {
                break;
            }
            d16--;
            if (d16 == -1) {
                d16 = this.f123998a - 1;
            }
        }
        return j3;
    }

    public synchronized long b(long j3, boolean z16, boolean z17) {
        int i3;
        int i16 = this.f124006i;
        if (i16 != 0) {
            long[] jArr = this.f124003f;
            int i17 = this.f124008k;
            if (j3 >= jArr[i17]) {
                if (z17 && (i3 = this.f124009l) != i16) {
                    i16 = i3 + 1;
                }
                int a16 = a(i17, i16, j3, z16);
                if (a16 == -1) {
                    return -1L;
                }
                return a(a16);
            }
        }
        return -1L;
    }

    public synchronized int a(com.tencent.luggage.wxa.m.k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16, boolean z17, com.tencent.luggage.wxa.m.j jVar, a aVar) {
        if (!h()) {
            if (z17) {
                dVar.c(4);
                return -4;
            }
            com.tencent.luggage.wxa.m.j jVar2 = this.f124014q;
            if (jVar2 == null || (!z16 && jVar2 == jVar)) {
                return -3;
            }
            kVar.f133904a = jVar2;
            return -5;
        }
        int d16 = d(this.f124009l);
        if (!z16 && this.f124005h[d16] == jVar) {
            if (dVar.g()) {
                return -3;
            }
            dVar.f135957d = this.f124003f[d16];
            dVar.c(this.f124002e[d16]);
            aVar.f124016a = this.f124001d[d16];
            aVar.f124017b = this.f124000c[d16];
            aVar.f124018c = this.f124004g[d16];
            this.f124009l++;
            return -4;
        }
        kVar.f133904a = this.f124005h[d16];
        return -5;
    }

    public synchronized long b() {
        int i3 = this.f124006i;
        if (i3 == 0) {
            return -1L;
        }
        return a(i3);
    }

    public synchronized void b(long j3) {
        this.f124011n = Math.max(this.f124011n, j3);
    }

    public synchronized boolean a(long j3, boolean z16, boolean z17) {
        int d16 = d(this.f124009l);
        if (h() && j3 >= this.f124003f[d16] && (j3 <= this.f124011n || z17)) {
            int a16 = a(d16, this.f124006i - this.f124009l, j3, z16);
            if (a16 == -1) {
                return false;
            }
            this.f124009l += a16;
            return true;
        }
        return false;
    }

    public synchronized void a() {
        if (h()) {
            this.f124009l = this.f124006i;
        }
    }

    public synchronized boolean a(com.tencent.luggage.wxa.m.j jVar) {
        if (jVar == null) {
            this.f124013p = true;
            return false;
        }
        this.f124013p = false;
        if (v.a(jVar, this.f124014q)) {
            return false;
        }
        this.f124014q = jVar;
        return true;
    }

    public synchronized void a(long j3, int i3, long j16, int i16, l.a aVar) {
        if (this.f124012o) {
            if ((i3 & 1) == 0) {
                return;
            } else {
                this.f124012o = false;
            }
        }
        com.tencent.luggage.wxa.n0.a.b(!this.f124013p);
        b(j3);
        int d16 = d(this.f124006i);
        this.f124003f[d16] = j3;
        long[] jArr = this.f124000c;
        jArr[d16] = j16;
        this.f124001d[d16] = i16;
        this.f124002e[d16] = i3;
        this.f124004g[d16] = aVar;
        this.f124005h[d16] = this.f124014q;
        this.f123999b[d16] = this.f124015r;
        int i17 = this.f124006i + 1;
        this.f124006i = i17;
        int i18 = this.f123998a;
        if (i17 == i18) {
            int i19 = i18 + 1000;
            int[] iArr = new int[i19];
            long[] jArr2 = new long[i19];
            long[] jArr3 = new long[i19];
            int[] iArr2 = new int[i19];
            int[] iArr3 = new int[i19];
            l.a[] aVarArr = new l.a[i19];
            com.tencent.luggage.wxa.m.j[] jVarArr = new com.tencent.luggage.wxa.m.j[i19];
            int i26 = this.f124008k;
            int i27 = i18 - i26;
            System.arraycopy(jArr, i26, jArr2, 0, i27);
            System.arraycopy(this.f124003f, this.f124008k, jArr3, 0, i27);
            System.arraycopy(this.f124002e, this.f124008k, iArr2, 0, i27);
            System.arraycopy(this.f124001d, this.f124008k, iArr3, 0, i27);
            System.arraycopy(this.f124004g, this.f124008k, aVarArr, 0, i27);
            System.arraycopy(this.f124005h, this.f124008k, jVarArr, 0, i27);
            System.arraycopy(this.f123999b, this.f124008k, iArr, 0, i27);
            int i28 = this.f124008k;
            System.arraycopy(this.f124000c, 0, jArr2, i27, i28);
            System.arraycopy(this.f124003f, 0, jArr3, i27, i28);
            System.arraycopy(this.f124002e, 0, iArr2, i27, i28);
            System.arraycopy(this.f124001d, 0, iArr3, i27, i28);
            System.arraycopy(this.f124004g, 0, aVarArr, i27, i28);
            System.arraycopy(this.f124005h, 0, jVarArr, i27, i28);
            System.arraycopy(this.f123999b, 0, iArr, i27, i28);
            this.f124000c = jArr2;
            this.f124003f = jArr3;
            this.f124002e = iArr2;
            this.f124001d = iArr3;
            this.f124004g = aVarArr;
            this.f124005h = jVarArr;
            this.f123999b = iArr;
            this.f124008k = 0;
            this.f124006i = this.f123998a;
            this.f123998a = i19;
        }
    }

    public synchronized boolean a(long j3) {
        if (this.f124006i == 0) {
            return j3 > this.f124010m;
        }
        if (Math.max(this.f124010m, c(this.f124009l)) >= j3) {
            return false;
        }
        int i3 = this.f124006i;
        int d16 = d(i3 - 1);
        while (i3 > this.f124009l && this.f124003f[d16] >= j3) {
            i3--;
            d16--;
            if (d16 == -1) {
                d16 = this.f123998a - 1;
            }
        }
        b(this.f124007j + i3);
        return true;
    }

    public final int a(int i3, int i16, long j3, boolean z16) {
        int i17 = -1;
        for (int i18 = 0; i18 < i16 && this.f124003f[i3] <= j3; i18++) {
            if (!z16 || (this.f124002e[i3] & 1) != 0) {
                i17 = i18;
            }
            i3++;
            if (i3 == this.f123998a) {
                i3 = 0;
            }
        }
        return i17;
    }

    public final long a(int i3) {
        this.f124010m = Math.max(this.f124010m, c(i3));
        int i16 = this.f124006i - i3;
        this.f124006i = i16;
        this.f124007j += i3;
        int i17 = this.f124008k + i3;
        this.f124008k = i17;
        int i18 = this.f123998a;
        if (i17 >= i18) {
            this.f124008k = i17 - i18;
        }
        int i19 = this.f124009l - i3;
        this.f124009l = i19;
        if (i19 < 0) {
            this.f124009l = 0;
        }
        if (i16 == 0) {
            int i26 = this.f124008k;
            if (i26 != 0) {
                i18 = i26;
            }
            return this.f124000c[i18 - 1] + this.f124001d[r2];
        }
        return this.f124000c[this.f124008k];
    }
}
