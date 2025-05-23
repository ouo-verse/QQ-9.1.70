package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;
import java.util.List;

/* loaded from: classes4.dex */
public class QCircleTabPageFeedUpdateEvent extends SimpleBaseEvent {
    private List<b> mFeedList;

    public QCircleTabPageFeedUpdateEvent(List<b> list) {
        this.mFeedList = list;
    }

    public List<b> getFeedList() {
        return this.mFeedList;
    }
}
