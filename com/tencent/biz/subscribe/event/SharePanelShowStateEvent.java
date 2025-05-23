package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes5.dex */
public class SharePanelShowStateEvent extends SimpleBaseEvent {
    public boolean shown;

    public SharePanelShowStateEvent(boolean z16) {
        this.shown = z16;
    }
}
