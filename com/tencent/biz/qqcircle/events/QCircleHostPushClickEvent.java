package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QCircleHostPushClickEvent extends SimpleBaseEvent {
    public boolean isPush;
    public String mTargetFeedId;

    public QCircleHostPushClickEvent(String str, boolean z16, int i3) {
        this.mTargetFeedId = str;
        this.isPush = z16;
        this.mHashCode = i3;
    }
}
