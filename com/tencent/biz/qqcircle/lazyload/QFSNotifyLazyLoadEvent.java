package com.tencent.biz.qqcircle.lazyload;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNotifyLazyLoadEvent extends SimpleBaseEvent {
    private final int mNotifyId;

    public QFSNotifyLazyLoadEvent(int i3) {
        this.mNotifyId = i3;
    }

    public int getNotifyId() {
        return this.mNotifyId;
    }
}
