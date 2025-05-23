package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSSelectedPageEvent extends SimpleBaseEvent {
    private int mSelectedIndex;

    public QFSSelectedPageEvent(int i3) {
        this.mSelectedIndex = i3;
    }

    public int getSelectedIndex() {
        return this.mSelectedIndex;
    }
}
