package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedDetailRspInfo extends SimpleBaseEvent {
    public List<b> feeds;

    public QCircleFeedDetailRspInfo(List<b> list) {
        this.feeds = list;
    }

    public String toString() {
        return "QCircleReplaceSimpleFeedEvent{, feeds=" + this.feeds + '}';
    }
}
