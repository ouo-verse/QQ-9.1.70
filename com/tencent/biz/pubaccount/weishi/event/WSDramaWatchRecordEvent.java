package com.tencent.biz.pubaccount.weishi.event;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSDramaWatchRecordEvent extends WSSimpleBaseEvent {
    private String dramaId;
    private int episodeNum;
    private String feedId;

    public WSDramaWatchRecordEvent(String str, String str2, int i3) {
        this.dramaId = str;
        this.feedId = str2;
        this.episodeNum = i3;
    }

    public String getDramaId() {
        return this.dramaId;
    }

    public int getEpisodeNum() {
        return this.episodeNum;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public void setDramaId(String str) {
        this.dramaId = str;
    }

    public void setEpisodeNum(int i3) {
        this.episodeNum = i3;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }
}
