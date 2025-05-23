package com.tencent.mobileqq.shortvideo.hwcodec;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private long f288030a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f288031b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f288032c = 0;

    /* renamed from: d, reason: collision with root package name */
    private float f288033d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f288034e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f288035f = 0.0f;

    public long a(float f16) {
        long j3 = this.f288031b + (f16 * 1000.0f);
        this.f288031b = j3;
        return j3;
    }

    public long b(long j3) {
        if (this.f288030a == 0) {
            long j16 = j3 * 1000;
            this.f288030a = j16;
            this.f288031b = j16;
            this.f288032c = j3;
        }
        return j3 * 1000;
    }

    public void c() {
        this.f288030a = 0L;
        this.f288031b = 0L;
        this.f288032c = 0L;
        this.f288033d = 0.0f;
        this.f288034e = 0.0f;
        this.f288035f = 0.0f;
    }

    public void d(float f16) {
        float f17 = (float) (1000.0d / f16);
        this.f288033d = f17;
        this.f288034e = 0.3f + f17;
        this.f288035f = f17 - 0.7f;
    }
}
