package com.tencent.icgame.game.liveroom.impl.room.audience.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RoomCloseEvent extends SimpleBaseEvent {
    private long roomId;

    public RoomCloseEvent(long j3) {
        this.roomId = j3;
    }

    public long getRoomId() {
        return this.roomId;
    }
}
