package com.qzone.reborn.feedx.event.ad;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QZoneAdClickEvent extends SimpleBaseEvent {
    private GdtAd mAd;
    private int mAreaId;

    public QZoneAdClickEvent(GdtAd gdtAd, int i3) {
        this.mAd = gdtAd;
        this.mAreaId = i3;
    }

    public GdtAd getAd() {
        return this.mAd;
    }

    public int getAreaId() {
        return this.mAreaId;
    }
}
