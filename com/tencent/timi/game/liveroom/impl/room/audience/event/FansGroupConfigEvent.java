package com.tencent.timi.game.liveroom.impl.room.audience.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FansGroupConfigEvent extends SimpleBaseEvent {
    private long roomId;

    public FansGroupConfigEvent(long j3) {
        this.roomId = j3;
    }

    public long getRoomId() {
        return this.roomId;
    }
}
