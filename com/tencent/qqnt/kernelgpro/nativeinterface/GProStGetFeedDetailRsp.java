package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStGetFeedDetailRsp {
    public int disablePolyLike;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStFeed feed = new GProStFeed();
    public GProStUser loginUser = new GProStUser();

    public int getDisablePolyLike() {
        return this.disablePolyLike;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStFeed getFeed() {
        return this.feed;
    }

    public GProStUser getLoginUser() {
        return this.loginUser;
    }

    public String toString() {
        return "GProStGetFeedDetailRsp{extInfo=" + this.extInfo + ",feed=" + this.feed + ",loginUser=" + this.loginUser + ",disablePolyLike=" + this.disablePolyLike + ",}";
    }
}
