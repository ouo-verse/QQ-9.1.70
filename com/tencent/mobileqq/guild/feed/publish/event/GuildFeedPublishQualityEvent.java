package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;

/* loaded from: classes13.dex */
public class GuildFeedPublishQualityEvent extends SimpleBaseEvent {
    private QCirclePublishQualityDataBuilder mBuilder;

    public GuildFeedPublishQualityEvent(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        this.mBuilder = qCirclePublishQualityDataBuilder;
    }

    public QCirclePublishQualityDataBuilder getBuilder() {
        return this.mBuilder;
    }

    public void setBuilder(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        this.mBuilder = qCirclePublishQualityDataBuilder;
    }

    public String toString() {
        return "GuildFeedPublishQualityEvent{mBuilder=" + this.mBuilder + "} " + super.toString();
    }
}
