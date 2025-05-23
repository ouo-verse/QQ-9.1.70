package com.tencent.luggage.wxa.x;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f144432a;

    /* renamed from: b, reason: collision with root package name */
    public final int f144433b;

    /* renamed from: c, reason: collision with root package name */
    public final int f144434c;

    /* renamed from: d, reason: collision with root package name */
    public final int f144435d;

    /* renamed from: e, reason: collision with root package name */
    public final int f144436e;

    /* renamed from: f, reason: collision with root package name */
    public final int f144437f;

    /* renamed from: g, reason: collision with root package name */
    public long f144438g;

    /* renamed from: h, reason: collision with root package name */
    public long f144439h;

    public b(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.f144432a = i3;
        this.f144433b = i16;
        this.f144434c = i17;
        this.f144435d = i18;
        this.f144436e = i19;
        this.f144437f = i26;
    }

    public int a() {
        return this.f144433b * this.f144436e * this.f144432a;
    }

    public int b() {
        return this.f144435d;
    }

    public long c() {
        return ((this.f144439h / this.f144435d) * 1000000) / this.f144433b;
    }

    public int d() {
        return this.f144437f;
    }

    public int e() {
        return this.f144432a;
    }

    public int f() {
        return this.f144433b;
    }

    public boolean g() {
        if (this.f144438g != 0 && this.f144439h != 0) {
            return true;
        }
        return false;
    }

    public long a(long j3) {
        long j16 = (j3 * this.f144434c) / 1000000;
        long j17 = this.f144435d;
        return Math.min((j16 / j17) * j17, this.f144439h - j17) + this.f144438g;
    }

    public long b(long j3) {
        return (j3 * 1000000) / this.f144434c;
    }

    public void a(long j3, long j16) {
        this.f144438g = j3;
        this.f144439h = j16;
    }
}
