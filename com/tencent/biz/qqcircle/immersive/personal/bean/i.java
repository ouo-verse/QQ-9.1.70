package com.tencent.biz.qqcircle.immersive.personal.bean;

import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends k {

    /* renamed from: q, reason: collision with root package name */
    private long f88471q;

    /* renamed from: r, reason: collision with root package name */
    private String f88472r;

    /* renamed from: s, reason: collision with root package name */
    private int f88473s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f88474t;

    /* renamed from: u, reason: collision with root package name */
    private String f88475u;

    /* renamed from: v, reason: collision with root package name */
    private String f88476v;

    /* renamed from: w, reason: collision with root package name */
    private int f88477w;

    public i(String str, e30.b bVar, int i3, int i16) {
        super(str, bVar, i3, i16);
        this.f88473s = -1;
        E();
    }

    private void E() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f88483f;
        if (feedCloudMeta$StFeed != null) {
            this.f88484g = feedCloudMeta$StFeed.feedType.get();
        }
    }

    public void A(String str) {
        this.f88475u = str;
    }

    public void B(int i3) {
        this.f88477w = i3;
    }

    public void C(String str) {
        this.f88476v = str;
    }

    public void D(boolean z16) {
        this.f88474t = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.bean.k
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f88483f != null && this.f88485h.equals(iVar.f88485h)) {
            return true;
        }
        return false;
    }

    public int t() {
        return this.f88473s;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.bean.k
    public String toString() {
        return "QFSPersonalDittoFeedGuildInfo{mGuildId=" + this.f88471q + ", mGuildName='" + this.f88472r + "', mGuildType=" + this.f88473s + ", isShowVoiceWave=" + this.f88474t + ", liveUserCount='" + this.f88475u + "', scheme='" + this.f88476v + "', mMemberNum=" + this.f88477w + ", ownerUin='" + this.f88482e + "', feedId='" + this.f88485h + "', coverUrl='" + this.f88463b + "'}";
    }

    public String u() {
        return this.f88475u;
    }

    public int v() {
        return this.f88477w;
    }

    public String w() {
        return this.f88476v;
    }

    public void x(long j3) {
        this.f88471q = j3;
    }

    public void y(String str) {
        this.f88472r = str;
    }

    public void z(int i3) {
        this.f88473s = i3;
    }
}
