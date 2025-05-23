package com.tencent.biz.qqcircle.immersive.personal.bean;

import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private int f88507a;

    /* renamed from: b, reason: collision with root package name */
    private List<FeedCloudMeta$StFeed> f88508b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudFavoritessvr$FavoritesInfo f88509c;

    public r(int i3) {
        this.f88507a = i3;
    }

    public FeedCloudFavoritessvr$FavoritesInfo a() {
        return this.f88509c;
    }

    public List<FeedCloudMeta$StFeed> b() {
        return this.f88508b;
    }

    public int c() {
        return this.f88507a;
    }

    public void d(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        this.f88509c = feedCloudFavoritessvr$FavoritesInfo;
    }

    public void e(List<FeedCloudMeta$StFeed> list) {
        this.f88508b = list;
    }

    public String toString() {
        return "QFSPersonalSelectCollectBoxInfo{mType=" + this.f88507a + ", mFeedList=" + this.f88508b + ", mFavoritesInfo=" + this.f88509c + '}';
    }
}
