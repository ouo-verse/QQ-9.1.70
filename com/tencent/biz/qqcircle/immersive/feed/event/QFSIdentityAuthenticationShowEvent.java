package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSIdentityAuthenticationShowEvent extends SimpleBaseEvent {
    public static final int TYPE_COMMENT_PANEL = 1;
    private boolean mIsIdentityAuthenticationFragmentShow;
    private int mType;

    public QFSIdentityAuthenticationShowEvent(boolean z16, int i3) {
        this.mIsIdentityAuthenticationFragmentShow = z16;
        this.mType = i3;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isIdentityAuthenticationFragmentShow() {
        return this.mIsIdentityAuthenticationFragmentShow;
    }
}
