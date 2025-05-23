package com.qzone.reborn.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxLayerScrollToQFSEvent extends SimpleBaseEvent {
    public boolean isScrollToQFS;
    public String videoId;

    public QZoneFeedxLayerScrollToQFSEvent(boolean z16, String str) {
        this.isScrollToQFS = z16;
        this.videoId = str;
    }
}
