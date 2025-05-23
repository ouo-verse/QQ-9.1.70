package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPageSelectEvent extends SimpleBaseEvent {
    public int mSelectPosition;
    public QCircleTabInfo mSelectTabInfo;
    public int mSelectTabType;

    public QFSPageSelectEvent(int i3) {
        this.mSelectPosition = i3;
    }
}
