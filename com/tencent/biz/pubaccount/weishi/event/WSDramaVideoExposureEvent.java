package com.tencent.biz.pubaccount.weishi.event;

import UserGrowth.stSimpleMetaFeed;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSDramaVideoExposureEvent extends WSSimpleBaseEvent {
    private int currentEpisodeNum;
    private stSimpleMetaFeed feedInfo;

    public int getCurrentEpisodeNum() {
        return this.currentEpisodeNum;
    }

    public stSimpleMetaFeed getFeedInfo() {
        return this.feedInfo;
    }

    public void setCurrentEpisodeNum(int i3) {
        this.currentEpisodeNum = i3;
    }

    public void setFeedInfo(stSimpleMetaFeed stsimplemetafeed) {
        this.feedInfo = stsimplemetafeed;
    }

    public String toString() {
        return "WSDramaVideoExposureEvent{currentEpisodeNum=" + this.currentEpisodeNum + ", feedInfo=" + this.feedInfo + '}';
    }
}
