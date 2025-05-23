package com.tencent.biz.pubaccount.weishi.net.common;

import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private long f80938a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f80939b = -1;

    /* renamed from: c, reason: collision with root package name */
    private float f80940c = -1.0f;

    public long a() {
        return this.f80938a;
    }

    public long b() {
        return this.f80939b;
    }

    public float c() {
        return this.f80940c;
    }

    public void d(long j3) {
        this.f80938a = j3;
        x.j("[WSService][GzipCompressInfo]", "[WSGzipCompressInfo.java][setCompressSize] compressSize:" + j3);
    }

    public void e(long j3) {
        this.f80939b = j3;
        x.j("[WSService][GzipCompressInfo]", "[WSGzipCompressInfo.java][decompressSize] decompressSize:" + j3);
    }

    public void f(float f16) {
        this.f80940c = f16;
        x.j("[WSService][GzipCompressInfo]", "[WSGzipCompressInfo.java][setRadio] radio:" + f16);
    }
}
