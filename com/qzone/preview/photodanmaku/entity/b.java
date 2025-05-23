package com.qzone.preview.photodanmaku.entity;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f49973a;

    /* renamed from: b, reason: collision with root package name */
    private long f49974b;

    public long a() {
        return this.f49973a;
    }

    public long b() {
        return this.f49974b;
    }

    public long c(long j3) {
        long j16 = j3 - this.f49973a;
        this.f49974b = j16;
        this.f49973a = j3;
        return j16;
    }
}
