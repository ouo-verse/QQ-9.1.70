package com.tencent.biz.pubaccount.weishi.event;

import UserGrowth.stSimpleMetaFeed;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSItemExposeEvent extends WSSimpleBaseEvent {
    public stSimpleMetaFeed video;

    public WSItemExposeEvent() {
    }

    public WSItemExposeEvent(stSimpleMetaFeed stsimplemetafeed) {
        this.video = stsimplemetafeed;
    }
}
