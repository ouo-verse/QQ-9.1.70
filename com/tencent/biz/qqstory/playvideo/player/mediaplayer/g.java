package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

/* compiled from: P */
/* loaded from: classes5.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private long f94207a;

    /* renamed from: b, reason: collision with root package name */
    private double f94208b = 1.0d;

    public g() {
        e();
    }

    private long d() {
        return (long) ((System.nanoTime() / 1000) * this.f94208b);
    }

    public long a() {
        return d() - this.f94207a;
    }

    public long b(long j3) {
        return j3 - a();
    }

    public double c() {
        return this.f94208b;
    }

    public void e() {
        f(0L);
    }

    public void f(long j3) {
        this.f94207a = d() - j3;
    }
}
