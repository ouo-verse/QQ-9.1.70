package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommentListShowStateEvent extends SimpleBaseEvent {
    public boolean shown;

    public CommentListShowStateEvent(boolean z16) {
        this.shown = z16;
    }
}
