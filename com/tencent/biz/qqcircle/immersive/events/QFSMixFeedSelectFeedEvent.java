package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedSelectFeedEvent extends SimpleBaseEvent {
    private final int mSelectedPos;

    public QFSMixFeedSelectFeedEvent(int i3) {
        this.mSelectedPos = i3;
    }

    public int getPos() {
        return this.mSelectedPos;
    }
}
