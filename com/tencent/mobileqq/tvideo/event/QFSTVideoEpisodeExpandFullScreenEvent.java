package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoEpisodeExpandFullScreenEvent extends SimpleBaseEvent {
    private boolean isExpand;

    public QFSTVideoEpisodeExpandFullScreenEvent(boolean z16) {
        this.isExpand = z16;
    }

    public boolean isExpand() {
        return this.isExpand;
    }

    public void setExpand(boolean z16) {
        this.isExpand = z16;
    }
}
