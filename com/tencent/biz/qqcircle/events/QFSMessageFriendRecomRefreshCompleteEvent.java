package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageFriendRecomRefreshCompleteEvent extends SimpleBaseEvent {
    public boolean mBlockIsEmpty;

    public QFSMessageFriendRecomRefreshCompleteEvent(boolean z16) {
        this.mBlockIsEmpty = z16;
    }
}
