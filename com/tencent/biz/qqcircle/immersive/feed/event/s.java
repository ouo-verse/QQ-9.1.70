package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends h {

    /* renamed from: a, reason: collision with root package name */
    private final FeedCloudMeta$StFeed f86180a;

    /* renamed from: b, reason: collision with root package name */
    private RFWPlayerOptions f86181b;

    /* renamed from: c, reason: collision with root package name */
    private int f86182c;

    /* renamed from: d, reason: collision with root package name */
    private int f86183d;

    /* renamed from: e, reason: collision with root package name */
    private int f86184e;

    /* renamed from: f, reason: collision with root package name */
    private String f86185f;

    public s(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f86181b = rFWPlayerOptions;
        this.f86182c = i3;
        this.f86183d = i16;
        this.f86184e = i17;
        this.f86185f = str;
        this.f86180a = feedCloudMeta$StFeed;
    }

    public int a() {
        return this.f86184e;
    }

    public int b() {
        return this.f86183d;
    }

    public String c() {
        return this.f86185f;
    }

    public FeedCloudMeta$StFeed d() {
        return this.f86180a;
    }

    public int e() {
        return this.f86182c;
    }

    public RFWPlayerOptions f() {
        return this.f86181b;
    }
}
