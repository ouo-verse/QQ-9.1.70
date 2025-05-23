package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import tvideo.Video;
import tvideo.VideoPlot;
import tvideo.VideoPlotDetails;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoEpisodeClickEvent extends SimpleBaseEvent {
    private int pos;
    private Video videoFeed;
    private VideoPlot videoPlot;
    private VideoPlotDetails videoPlotDetails;

    public int getPos() {
        return this.pos;
    }

    public Video getVideoFeed() {
        return this.videoFeed;
    }

    public VideoPlot getVideoPlot() {
        return this.videoPlot;
    }

    public VideoPlotDetails getVideoPlotDetails() {
        return this.videoPlotDetails;
    }

    public void setPos(int i3) {
        this.pos = i3;
    }

    public void setVideoFeed(Video video) {
        this.videoFeed = video;
    }

    public void setVideoPlot(VideoPlot videoPlot) {
        this.videoPlot = videoPlot;
    }

    public void setVideoPlotDetails(VideoPlotDetails videoPlotDetails) {
        this.videoPlotDetails = videoPlotDetails;
    }
}
