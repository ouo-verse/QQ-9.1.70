package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoEpisodeExpandEvent extends SimpleBaseEvent {
    private boolean isClickEpisodeItem;
    private boolean isExpand;

    public QFSTVideoEpisodeExpandEvent(boolean z16) {
        this(z16, false);
    }

    public boolean isClickEpisodeItem() {
        return this.isClickEpisodeItem;
    }

    public boolean isExpand() {
        return this.isExpand;
    }

    public void setExpand(boolean z16) {
        this.isExpand = z16;
    }

    public QFSTVideoEpisodeExpandEvent(boolean z16, boolean z17) {
        this.isExpand = z16;
        this.isClickEpisodeItem = z17;
    }
}
