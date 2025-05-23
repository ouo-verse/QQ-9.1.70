package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBatchGetFeedDetailRsp {
    public GProStCommonExt extInfo = new GProStCommonExt();
    public ArrayList<GProFeedInfo> feeds = new ArrayList<>();
    public GProStUser loginUser = new GProStUser();

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProFeedInfo> getFeeds() {
        return this.feeds;
    }

    public GProStUser getLoginUser() {
        return this.loginUser;
    }

    public String toString() {
        return "GProBatchGetFeedDetailRsp{extInfo=" + this.extInfo + ",feeds=" + this.feeds + ",loginUser=" + this.loginUser + ",}";
    }
}
