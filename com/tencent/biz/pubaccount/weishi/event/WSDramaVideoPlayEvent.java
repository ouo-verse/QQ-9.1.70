package com.tencent.biz.pubaccount.weishi.event;

import UserGrowth.stDrama;

/* loaded from: classes32.dex */
public class WSDramaVideoPlayEvent extends WSSimpleBaseEvent {
    private String dramaId;
    private stDrama dramaInfo;
    private String episodeId;
    private int episodeNum;
    private boolean isDramaPreviewPage;

    public String getDramaId() {
        return this.dramaId;
    }

    public stDrama getDramaInfo() {
        return this.dramaInfo;
    }

    public String getEpisodeId() {
        return this.episodeId;
    }

    public int getEpisodeNum() {
        return this.episodeNum;
    }

    public boolean isDramaPreviewPage() {
        return this.isDramaPreviewPage;
    }

    public void setDramaId(String str) {
        this.dramaId = str;
    }

    public void setDramaInfo(stDrama stdrama) {
        this.dramaInfo = stdrama;
    }

    public void setDramaPreviewPage(boolean z16) {
        this.isDramaPreviewPage = z16;
    }

    public void setEpisodeId(String str) {
        this.episodeId = str;
    }

    public void setEpisodeNum(int i3) {
        this.episodeNum = i3;
    }

    public String toString() {
        return "WSDramaVideoPlayEvent{episodeNum=" + this.episodeNum + ", dramaId='" + this.dramaId + "', episodeId='" + this.episodeId + "'}";
    }
}
