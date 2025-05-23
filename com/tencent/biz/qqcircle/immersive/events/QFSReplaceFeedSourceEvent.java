package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSReplaceFeedSourceEvent extends SimpleBaseEvent {
    private List<b> mOriginFeedSource;
    private List<b> mReplaceFeedSource;

    public QFSReplaceFeedSourceEvent(List<b> list, List<b> list2) {
        this.mOriginFeedSource = list;
        this.mReplaceFeedSource = list2;
    }

    public List<b> getOriginFeedSource() {
        return this.mOriginFeedSource;
    }

    public List<b> getReplaceFeedSource() {
        return this.mReplaceFeedSource;
    }
}
