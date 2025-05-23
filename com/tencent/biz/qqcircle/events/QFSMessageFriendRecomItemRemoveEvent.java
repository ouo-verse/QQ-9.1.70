package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageFriendRecomItemRemoveEvent extends SimpleBaseEvent {
    private final int mRemovePos;

    public QFSMessageFriendRecomItemRemoveEvent(int i3) {
        this.mRemovePos = i3;
    }

    public int getRemovePos() {
        return this.mRemovePos;
    }
}
