package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class QFSTVideoOnPlayEvent extends SimpleBaseEvent {
    private final int mHashCode;
    private final String mPlayFeedId;

    public QFSTVideoOnPlayEvent(String str, int i3) {
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
