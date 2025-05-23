package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullClearEvent extends SimpleBaseEvent {
    private boolean isClear;
    private String mFeedId;

    public QFSFullClearEvent(String str, boolean z16) {
        this.mFeedId = str;
        this.isClear = z16;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean isClear() {
        return this.isClear;
    }
}
