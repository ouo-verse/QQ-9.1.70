package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPublicListInnerBlockRegisterEvent extends SimpleBaseEvent {
    private boolean mFriendRecomBlockEmpty;
    private final int mLaunchTo;
    private final boolean mNeedRegister;

    public QFSPublicListInnerBlockRegisterEvent(boolean z16, int i3) {
        this.mNeedRegister = z16;
        this.mLaunchTo = i3;
    }

    public int getLaunchTo() {
        return this.mLaunchTo;
    }

    public boolean isFriendRecomBlockEmpty() {
        return this.mFriendRecomBlockEmpty;
    }

    public boolean needRegister() {
        return this.mNeedRegister;
    }

    public QFSPublicListInnerBlockRegisterEvent(boolean z16, int i3, boolean z17) {
        this(z16, i3);
        this.mFriendRecomBlockEmpty = z17;
    }
}
