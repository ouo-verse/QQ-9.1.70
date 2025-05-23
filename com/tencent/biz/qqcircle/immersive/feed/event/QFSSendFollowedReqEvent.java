package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSendFollowedReqEvent extends SimpleBaseEvent {
    private String feedId;

    public QFSSendFollowedReqEvent(String str) {
        this.feedId = str;
    }

    public String getFeedId() {
        return this.feedId;
    }
}
