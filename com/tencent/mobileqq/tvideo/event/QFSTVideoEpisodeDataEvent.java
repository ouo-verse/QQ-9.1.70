package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import tvideo.VideoPlotDetails;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoEpisodeDataEvent extends SimpleBaseEvent {
    private final VideoPlotDetails videoPlotDetails;

    public QFSTVideoEpisodeDataEvent(VideoPlotDetails videoPlotDetails) {
        this.videoPlotDetails = videoPlotDetails;
    }

    public VideoPlotDetails getVideoPlotDetails() {
        return this.videoPlotDetails;
    }
}
