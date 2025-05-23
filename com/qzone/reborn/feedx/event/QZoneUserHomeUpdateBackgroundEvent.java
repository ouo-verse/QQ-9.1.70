package com.qzone.reborn.feedx.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneUserHomeUpdateBackgroundEvent extends SimpleBaseEvent {
    public boolean hasStrangerDecorate;

    public QZoneUserHomeUpdateBackgroundEvent(boolean z16) {
        this.hasStrangerDecorate = z16;
    }
}
