package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QCircleUndoPushUpdateEvent extends SimpleBaseEvent {
    public String mTargetFeedId;

    public QCircleUndoPushUpdateEvent(String str) {
        this.mTargetFeedId = str;
    }
}
