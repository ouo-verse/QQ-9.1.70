package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class QFSAdSpaceDisplayedEvent extends SimpleBaseEvent {
    private GdtAd mAd;

    public QFSAdSpaceDisplayedEvent(GdtAd gdtAd) {
        this.mAd = gdtAd;
    }

    public GdtAd getAd() {
        return this.mAd;
    }
}
