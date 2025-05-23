package com.tencent.richframework.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes25.dex */
public class RFWLayerVideoPlayEvent extends SimpleBaseEvent {
    public boolean isPlay;
    public String videoId;

    public RFWLayerVideoPlayEvent(String str, boolean z16) {
        this.videoId = str;
        this.isPlay = z16;
    }
}
