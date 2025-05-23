package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSSearchOpenCommentPanelEvent extends SimpleBaseEvent {
    private QFSCommentInfo mCommentInfo;
    private int mContextHashCode;
    private boolean mShowInput;

    public QFSSearchOpenCommentPanelEvent(QFSCommentInfo qFSCommentInfo, boolean z16, int i3) {
        this.mCommentInfo = qFSCommentInfo;
        this.mShowInput = z16;
        this.mContextHashCode = i3;
    }

    public QFSCommentInfo getCommentInfo() {
        return this.mCommentInfo;
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public boolean getShowInput() {
        return this.mShowInput;
    }
}
