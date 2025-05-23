package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSDoublePraiseEvent extends SimpleBaseEvent {
    private String mFeedId;

    public QFSDoublePraiseEvent(String str) {
        this.mFeedId = str;
    }

    public String getFeedId() {
        return this.mFeedId;
    }
}
