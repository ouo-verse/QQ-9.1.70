package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f90667a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$StUser f90668b;

    /* renamed from: c, reason: collision with root package name */
    private List<FeedCloudMeta$StUser> f90669c;

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StFeed f90670d;

    /* renamed from: e, reason: collision with root package name */
    private e30.b f90671e;

    /* renamed from: f, reason: collision with root package name */
    private int f90672f;

    public FeedCloudMeta$StFeed a() {
        return this.f90670d;
    }

    public int b() {
        return this.f90667a;
    }

    public e30.b c() {
        return this.f90671e;
    }

    public int d() {
        return this.f90672f;
    }

    public FeedCloudMeta$StUser e() {
        return this.f90668b;
    }

    public List<FeedCloudMeta$StUser> f() {
        return this.f90669c;
    }

    public void g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f90670d = feedCloudMeta$StFeed;
    }

    public void h(int i3) {
        this.f90667a = i3;
    }

    public void i(e30.b bVar) {
        this.f90671e = bVar;
    }

    public void j(int i3) {
        this.f90672f = i3;
    }

    public void k(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f90668b = feedCloudMeta$StUser;
    }

    public void l(List<FeedCloudMeta$StUser> list) {
        this.f90669c = list;
    }

    public String toString() {
        return "QFSBottomConfigGuideFollowItemInfo{mType=" + this.f90672f + ", mItemType=" + this.f90667a + ", mUser=" + this.f90668b + ", mUserList=" + this.f90669c + ", mFeed=" + this.f90670d + ", mSourceFeedBlockData=" + this.f90671e + '}';
    }
}
