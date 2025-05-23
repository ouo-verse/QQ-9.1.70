package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FollowUpdateEvent extends SimpleBaseEvent {
    public int followStatus;
    public String useId;

    public FollowUpdateEvent(int i3, String str) {
        this.followStatus = i3;
        this.useId = str;
    }
}
