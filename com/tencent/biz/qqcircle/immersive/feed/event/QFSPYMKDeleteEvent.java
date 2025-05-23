package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes4.dex */
public class QFSPYMKDeleteEvent extends SimpleBaseEvent {
    private QQCircleDitto$StItemInfo mItemInfo;
    private int mPos;

    public QFSPYMKDeleteEvent(int i3, QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        this.mPos = i3;
        this.mItemInfo = qQCircleDitto$StItemInfo;
    }

    public QQCircleDitto$StItemInfo getInfo() {
        return this.mItemInfo;
    }

    public int getPos() {
        return this.mPos;
    }
}
