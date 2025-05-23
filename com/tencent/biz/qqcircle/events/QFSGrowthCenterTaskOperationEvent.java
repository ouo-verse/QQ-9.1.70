package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGrowthCenterTaskOperationEvent extends SimpleBaseEvent {
    public boolean isAllTaskFinish;

    public QFSGrowthCenterTaskOperationEvent(boolean z16) {
        this.isAllTaskFinish = z16;
    }
}
