package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchVideoSelectFeedEvent extends SimpleBaseEvent {
    public final int parentHash;
    public final int position;

    public QFSSearchVideoSelectFeedEvent(int i3, int i16) {
        this.position = i3;
        this.parentHash = i16;
    }
}
