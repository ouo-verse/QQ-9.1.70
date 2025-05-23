package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private FeedCloudMeta$StFeed f87305a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$StBarrage f87306b;

    /* renamed from: c, reason: collision with root package name */
    private String f87307c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f87308d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f87309e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f87310f;

    public c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        this.f87305a = feedCloudMeta$StFeed;
        this.f87306b = feedCloudMeta$StBarrage;
    }

    public FeedCloudMeta$StBarrage a() {
        return this.f87306b;
    }

    public FeedCloudMeta$StFeed b() {
        return this.f87305a;
    }

    public String c() {
        return this.f87307c;
    }

    public boolean d() {
        return this.f87308d;
    }

    public boolean e() {
        return this.f87309e;
    }

    public long f() {
        return this.f87310f;
    }

    public void g(boolean z16) {
        this.f87308d = z16;
    }

    public void h(boolean z16) {
        this.f87309e = z16;
    }

    public void i(long j3) {
        this.f87310f = j3;
    }
}
