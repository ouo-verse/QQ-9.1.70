package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleResetCommentBlockEvent extends SimpleBaseEvent {
    public final String feedId;

    public QCircleResetCommentBlockEvent(String str) {
        this.feedId = str;
    }
}
