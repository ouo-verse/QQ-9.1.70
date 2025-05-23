package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDeleteBtnShowEvent extends SimpleBaseEvent {
    public boolean mIsShow;

    public QFSDeleteBtnShowEvent(boolean z16) {
        this.mIsShow = z16;
    }
}
