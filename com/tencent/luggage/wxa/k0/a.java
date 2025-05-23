package com.tencent.luggage.wxa.k0;

import android.os.SystemClock;
import com.tencent.luggage.wxa.d0.n;
import com.tencent.luggage.wxa.m.j;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final n f131369a;

    /* renamed from: b, reason: collision with root package name */
    public final int f131370b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f131371c;

    /* renamed from: d, reason: collision with root package name */
    public final j[] f131372d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f131373e;

    /* renamed from: f, reason: collision with root package name */
    public int f131374f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(j jVar, j jVar2) {
            return jVar2.f133892b - jVar.f133892b;
        }
    }

    public a(n nVar, int... iArr) {
        boolean z16;
        int i3 = 0;
        if (iArr.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        this.f131369a = (n) com.tencent.luggage.wxa.n0.a.a(nVar);
        int length = iArr.length;
        this.f131370b = length;
        this.f131372d = new j[length];
        for (int i16 = 0; i16 < iArr.length; i16++) {
            this.f131372d[i16] = nVar.a(iArr[i16]);
        }
        Arrays.sort(this.f131372d, new b());
        this.f131371c = new int[this.f131370b];
        while (true) {
            int i17 = this.f131370b;
            if (i3 < i17) {
                this.f131371c[i3] = nVar.a(this.f131372d[i3]);
                i3++;
            } else {
                this.f131373e = new long[i17];
                return;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final j a(int i3) {
        return this.f131372d[i3];
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final int b(int i3) {
        return this.f131371c[i3];
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final n c() {
        return this.f131369a;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final int d() {
        return this.f131371c[a()];
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final j e() {
        return this.f131372d[a()];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f131369a == aVar.f131369a && Arrays.equals(this.f131371c, aVar.f131371c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f131374f == 0) {
            this.f131374f = (System.identityHashCode(this.f131369a) * 31) + Arrays.hashCode(this.f131371c);
        }
        return this.f131374f;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final int length() {
        return this.f131371c.length;
    }

    public final int a(j jVar) {
        for (int i3 = 0; i3 < this.f131370b; i3++) {
            if (this.f131372d[i3] == jVar) {
                return i3;
            }
        }
        return -1;
    }

    public final boolean b(int i3, long j3) {
        return this.f131373e[i3] > j3;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final int c(int i3) {
        for (int i16 = 0; i16 < this.f131370b; i16++) {
            if (this.f131371c[i16] == i3) {
                return i16;
            }
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public final boolean a(int i3, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b16 = b(i3, elapsedRealtime);
        int i16 = 0;
        while (i16 < this.f131370b && !b16) {
            b16 = (i16 == i3 || b(i16, elapsedRealtime)) ? false : true;
            i16++;
        }
        if (!b16) {
            return false;
        }
        long[] jArr = this.f131373e;
        jArr[i3] = Math.max(jArr[i3], elapsedRealtime + j3);
        return true;
    }
}
