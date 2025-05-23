package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFriendFooterViewEvent extends SimpleBaseEvent {
    public boolean mIsFinished;
    public boolean mIsPulling;

    public QFSFriendFooterViewEvent(boolean z16, boolean z17) {
        this.mIsPulling = z16;
        this.mIsFinished = z17;
    }
}
