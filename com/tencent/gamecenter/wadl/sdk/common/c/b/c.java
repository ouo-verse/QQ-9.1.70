package com.tencent.gamecenter.wadl.sdk.common.c.b;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    long f107075a;

    /* renamed from: b, reason: collision with root package name */
    long f107076b;

    /* renamed from: c, reason: collision with root package name */
    long f107077c;

    /* renamed from: d, reason: collision with root package name */
    long f107078d;

    /* renamed from: e, reason: collision with root package name */
    long f107079e;

    /* renamed from: f, reason: collision with root package name */
    long f107080f;

    /* renamed from: g, reason: collision with root package name */
    long f107081g = -1;

    /* renamed from: h, reason: collision with root package name */
    long f107082h = -1;

    /* renamed from: i, reason: collision with root package name */
    long f107083i = -1;

    /* renamed from: j, reason: collision with root package name */
    long f107084j = -1;

    /* renamed from: k, reason: collision with root package name */
    long f107085k = -1;

    protected long a(long j3) {
        if (j3 >= 0) {
            return j3;
        }
        return -1L;
    }

    public String toString() {
        return "Stat{startToTryConnect=" + this.f107081g + ", connectCost=" + this.f107082h + ", connectToPost=" + this.f107083i + ", postToRsp=" + this.f107084j + ", rspToRead=" + this.f107085k + '}';
    }

    public void a() {
        long j3 = this.f107076b;
        long j16 = j3 - this.f107075a;
        this.f107081g = j16;
        long j17 = this.f107077c;
        this.f107082h = j17 - j3;
        long j18 = this.f107078d;
        this.f107083i = j18 - j17;
        long j19 = this.f107079e;
        this.f107084j = j19 - j18;
        this.f107085k = this.f107080f - j19;
        this.f107081g = a(j16);
        this.f107082h = a(this.f107082h);
        this.f107083i = a(this.f107083i);
        this.f107084j = a(this.f107084j);
        this.f107085k = a(this.f107085k);
    }
}
