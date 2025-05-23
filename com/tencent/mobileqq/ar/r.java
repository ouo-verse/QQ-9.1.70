package com.tencent.mobileqq.ar;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes11.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Long> f198554a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private int f198555b;

    /* renamed from: c, reason: collision with root package name */
    private int f198556c;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f198557a;

        /* renamed from: b, reason: collision with root package name */
        public long f198558b;

        /* renamed from: c, reason: collision with root package name */
        public long f198559c;

        /* renamed from: d, reason: collision with root package name */
        public long f198560d;

        /* renamed from: e, reason: collision with root package name */
        public long f198561e;

        /* renamed from: f, reason: collision with root package name */
        public long f198562f;

        /* renamed from: g, reason: collision with root package name */
        public long[] f198563g;

        /* renamed from: h, reason: collision with root package name */
        public int f198564h;

        public a(long j3, long j16, long j17, long j18, long j19, double d16, long[] jArr, int i3) {
            this.f198557a = j3;
            this.f198558b = j16;
            this.f198559c = j17;
            this.f198560d = j18;
            this.f198561e = j19;
            this.f198562f = (long) (d16 + 0.9d);
            this.f198564h = i3;
            this.f198563g = jArr;
        }

        public String toString() {
            return "70% :  " + this.f198559c + " --------- 80% : " + this.f198558b + " --------- 90% : " + this.f198557a + " --------- min : " + this.f198560d + " --------- max : " + this.f198561e + " --------- num : " + this.f198564h + "--------arr" + this.f198563g;
        }
    }

    public r(int i3) {
        this.f198555b = i3;
    }

    private int a(float f16) {
        if (f16 <= 1.0f && f16 > 0.0f) {
            int size = (int) ((f16 * this.f198554a.size()) - 1.0f);
            if (size < 0) {
                return 0;
            }
            return size;
        }
        throw new IndexOutOfBoundsException("the percent out of index");
    }

    public a b() {
        synchronized (this.f198554a) {
            if (this.f198554a.size() <= 0) {
                return new a(-1L, -1L, -1L, -1L, -1L, -1.0d, null, 0);
            }
            int size = this.f198554a.size();
            long[] jArr = new long[size];
            int i3 = 0;
            for (int i16 = 0; i16 < this.f198554a.size(); i16++) {
                jArr[i16] = this.f198554a.get(i16).longValue();
            }
            Arrays.sort(jArr);
            long j3 = jArr[a(0.9f)];
            long j16 = jArr[a(0.8f)];
            long j17 = jArr[a(0.7f)];
            long j18 = jArr[0];
            long j19 = jArr[size - 1];
            double d16 = 0.0d;
            while (i3 < size) {
                d16 += jArr[i3];
                i3++;
                j19 = j19;
            }
            return new a(j3, j16, j17, j18, j19, d16 / size, jArr, this.f198556c);
        }
    }

    public int c() {
        return this.f198554a.size();
    }
}
