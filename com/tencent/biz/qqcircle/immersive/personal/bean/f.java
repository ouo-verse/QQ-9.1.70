package com.tencent.biz.qqcircle.immersive.personal.bean;

import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f88466a;

    /* renamed from: b, reason: collision with root package name */
    private List<FeedCloudMeta$StFeed> f88467b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudFavoritessvr$FavoritesInfo f88468c;

    public f(int i3) {
        this.f88466a = i3;
    }

    public FeedCloudFavoritessvr$FavoritesInfo a() {
        return this.f88468c;
    }

    public int b() {
        return this.f88466a;
    }

    public void c(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        this.f88468c = feedCloudFavoritessvr$FavoritesInfo;
    }

    public String toString() {
        return "QFSPersonalCollectBoxAddFeedInfo{mType=" + this.f88466a + ", mFeedList=" + this.f88467b + ", mFavoritesInfo=" + this.f88468c + '}';
    }
}
