package com.tencent.biz.qqcircle.immersive.personal.bean;

import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private int f88497a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudFavoritessvr$FavoritesInfo f88498b;

    /* renamed from: c, reason: collision with root package name */
    private List<FeedCloudMeta$StFeed> f88499c;

    public n(int i3) {
        this.f88497a = i3;
    }

    public FeedCloudFavoritessvr$FavoritesInfo a() {
        return this.f88498b;
    }

    public List<FeedCloudMeta$StFeed> b() {
        return this.f88499c;
    }

    public int c() {
        return this.f88497a;
    }

    public void d(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        this.f88498b = feedCloudFavoritessvr$FavoritesInfo;
    }

    public void e(List<FeedCloudMeta$StFeed> list) {
        this.f88499c = list;
    }

    public String toString() {
        return "QFSPersonalNewCollectBoxInfo{mType=" + this.f88497a + ", mFavoritesInfo=" + this.f88498b + ", mFeedList=" + this.f88499c + '}';
    }
}
