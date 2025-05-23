package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSVideoOnPlayEvent extends SimpleBaseEvent {
    private final int mHashCode;
    private final String mPlayFeedId;

    public QFSVideoOnPlayEvent(String str, int i3) {
        this.mPlayFeedId = str;
        this.mHashCode = i3;
    }

    public String getFeedId() {
        return this.mPlayFeedId;
    }

    public int getPlayHashCode() {
        return this.mHashCode;
    }
}
