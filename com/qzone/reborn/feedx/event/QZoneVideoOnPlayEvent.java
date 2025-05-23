package com.qzone.reborn.feedx.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes37.dex */
public class QZoneVideoOnPlayEvent extends SimpleBaseEvent {
    private final int mHashCode;
    private final String mPlayFeedId;

    public QZoneVideoOnPlayEvent(String str, int i3) {
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
