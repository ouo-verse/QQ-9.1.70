package com.tencent.rmonitor.metrics.looper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private long f365777b;

    /* renamed from: c, reason: collision with root package name */
    private final long[] f365778c = new long[120];

    /* renamed from: d, reason: collision with root package name */
    private final long[] f365779d = new long[120];

    /* renamed from: a, reason: collision with root package name */
    private int f365776a = 0;

    public g() {
        for (int i3 = 0; i3 < 120; i3++) {
            this.f365778c[i3] = 0;
            this.f365779d[i3] = 0;
        }
    }

    public void a(long j3, long j16, long j17) {
        this.f365777b = j3;
        int i3 = this.f365776a;
        if (i3 >= 0 && i3 < 120) {
            this.f365778c[i3] = j16;
            this.f365779d[i3] = j17;
        }
        this.f365776a = (i3 + 1) % 120;
    }

    public float b() {
        long j3 = 0;
        long j16 = 0;
        for (int i3 = 0; i3 < 120; i3++) {
            long j17 = this.f365778c[i3];
            if (j17 != 0) {
                j3 += j17;
                j16 += this.f365779d[i3];
            }
        }
        if (j3 > 0) {
            return (((float) (j3 - j16)) / ((float) j3)) * 60.0f;
        }
        return 0.0f;
    }

    public long c() {
        return this.f365777b;
    }
}
