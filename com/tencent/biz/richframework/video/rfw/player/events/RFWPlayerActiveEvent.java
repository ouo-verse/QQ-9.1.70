package com.tencent.biz.richframework.video.rfw.player.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes5.dex */
public class RFWPlayerActiveEvent extends SimpleBaseEvent {
    public final String mFileId;

    public RFWPlayerActiveEvent(String str) {
        this.mFileId = str;
    }
}
