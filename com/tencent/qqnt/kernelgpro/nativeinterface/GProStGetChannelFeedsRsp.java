package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStGetChannelFeedsRsp {
    public int isFinish;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public ArrayList<GProStFeed> vecFeedList = new ArrayList<>();
    public GProStUser user = new GProStUser();
    public String feedAttchInfo = "";
    public GProRefreshToast refreshToast = new GProRefreshToast();
    public GProStFeedListHeaderInfo headInfo = new GProStFeedListHeaderInfo();
    public ArrayList<GProTopFeed> topFeeds = new ArrayList<>();
    public GProCapsule capsule = new GProCapsule();
    public String traceId = "";
    public ArrayList<GProSimpleChannelInfo> channels = new ArrayList<>();

    public GProCapsule getCapsule() {
        return this.capsule;
    }

    public ArrayList<GProSimpleChannelInfo> getChannels() {
        return this.channels;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public String getFeedAttchInfo() {
        return this.feedAttchInfo;
    }

    public GProStFeedListHeaderInfo getHeadInfo() {
        return this.headInfo;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public GProRefreshToast getRefreshToast() {
        return this.refreshToast;
    }

    public ArrayList<GProTopFeed> getTopFeeds() {
        return this.topFeeds;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public GProStUser getUser() {
        return this.user;
    }

    public ArrayList<GProStFeed> getVecFeedList() {
        return this.vecFeedList;
    }

    public String toString() {
        return "GProStGetChannelFeedsRsp{extInfo=" + this.extInfo + ",vecFeedList=" + this.vecFeedList + ",isFinish=" + this.isFinish + ",user=" + this.user + ",feedAttchInfo=" + this.feedAttchInfo + ",refreshToast=" + this.refreshToast + ",headInfo=" + this.headInfo + ",topFeeds=" + this.topFeeds + ",capsule=" + this.capsule + ",traceId=" + this.traceId + ",channels=" + this.channels + ",}";
    }
}
