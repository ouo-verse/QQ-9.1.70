package com.tencent.biz.pubaccount.weishi.event;

import UserGrowth.stSimpleMetaFeed;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSFriendFeedExposureEvent extends WSSimpleBaseEvent {
    public int currentPosition;
    public stSimpleMetaFeed video;

    public WSFriendFeedExposureEvent() {
    }

    public WSFriendFeedExposureEvent(stSimpleMetaFeed stsimplemetafeed, int i3) {
        this.video = stsimplemetafeed;
        this.currentPosition = i3;
    }
}
