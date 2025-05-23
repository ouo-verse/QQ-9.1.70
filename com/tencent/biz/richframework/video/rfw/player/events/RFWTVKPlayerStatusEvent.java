package com.tencent.biz.richframework.video.rfw.player.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes5.dex */
public class RFWTVKPlayerStatusEvent extends SimpleBaseEvent {
    public int playerStatus;

    public RFWTVKPlayerStatusEvent(int i3) {
        this.playerStatus = i3;
    }

    public int getPlayerStatus() {
        return this.playerStatus;
    }
}
