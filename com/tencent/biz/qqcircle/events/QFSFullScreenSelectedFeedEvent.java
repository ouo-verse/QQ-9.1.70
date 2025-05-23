package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenSelectedFeedEvent extends SimpleBaseEvent {
    private b mSelectedData;

    public QFSFullScreenSelectedFeedEvent(b bVar) {
        this.mSelectedData = bVar;
    }

    public b getSelectedData() {
        return this.mSelectedData;
    }
}
