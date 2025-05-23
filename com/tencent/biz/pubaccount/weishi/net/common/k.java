package com.tencent.biz.pubaccount.weishi.net.common;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final String f80948a;

    /* renamed from: b, reason: collision with root package name */
    private long f80949b;

    /* renamed from: c, reason: collision with root package name */
    private long f80950c;

    /* renamed from: d, reason: collision with root package name */
    private long f80951d;

    /* renamed from: e, reason: collision with root package name */
    private long f80952e;

    /* renamed from: f, reason: collision with root package name */
    private long f80953f;

    /* renamed from: g, reason: collision with root package name */
    private long f80954g;

    /* renamed from: h, reason: collision with root package name */
    private long f80955h;

    /* renamed from: i, reason: collision with root package name */
    private long f80956i;

    /* renamed from: j, reason: collision with root package name */
    private long f80957j;

    /* renamed from: k, reason: collision with root package name */
    private long f80958k;

    /* renamed from: l, reason: collision with root package name */
    private long f80959l;

    /* renamed from: m, reason: collision with root package name */
    private long f80960m;

    /* renamed from: n, reason: collision with root package name */
    private long f80961n;

    public k(String str) {
        this.f80948a = str;
    }

    public long a() {
        return this.f80953f - this.f80952e;
    }

    public long b() {
        return this.f80961n - this.f80949b;
    }

    public long c() {
        return this.f80955h - this.f80954g;
    }

    public long d() {
        return this.f80956i - this.f80955h;
    }

    public long e() {
        long j3 = this.f80957j;
        if (j3 != 0 && this.f80958k != 0) {
            return this.f80959l - j3;
        }
        return this.f80959l - this.f80956i;
    }

    public long f() {
        return this.f80954g - this.f80953f;
    }

    public long g() {
        long j3 = this.f80958k;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f80957j;
    }

    public long h() {
        long j3 = this.f80957j;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f80956i;
    }

    public long i() {
        return this.f80959l - this.f80950c;
    }

    public long j() {
        return this.f80951d - this.f80950c;
    }

    public long k() {
        return this.f80961n - this.f80960m;
    }

    public long l() {
        return this.f80960m - this.f80959l;
    }

    public void m() {
        this.f80955h = SystemClock.uptimeMillis();
    }

    public void n() {
        this.f80956i = SystemClock.uptimeMillis();
    }

    public void o() {
        this.f80959l = SystemClock.uptimeMillis();
    }

    public void p() {
        this.f80954g = SystemClock.uptimeMillis();
    }

    public void q() {
        this.f80958k = SystemClock.uptimeMillis();
    }

    public void r() {
        this.f80957j = SystemClock.uptimeMillis();
    }

    public void s() {
        this.f80950c = SystemClock.uptimeMillis();
    }

    public void t() {
        this.f80949b = SystemClock.uptimeMillis();
    }

    public void u() {
        this.f80951d = SystemClock.uptimeMillis();
    }

    public void v() {
        this.f80952e = SystemClock.uptimeMillis();
    }

    public void w() {
        this.f80953f = SystemClock.uptimeMillis();
    }

    public void x() {
        this.f80961n = SystemClock.uptimeMillis();
    }

    public void y() {
        this.f80960m = SystemClock.uptimeMillis();
    }
}
