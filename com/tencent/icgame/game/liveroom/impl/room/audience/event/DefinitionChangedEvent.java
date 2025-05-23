package com.tencent.icgame.game.liveroom.impl.room.audience.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DefinitionChangedEvent extends SimpleBaseEvent {
    private EnterRoomInfo.VideoDefinition definition;
    private long roomId;

    public DefinitionChangedEvent(long j3, EnterRoomInfo.VideoDefinition videoDefinition) {
        this.roomId = j3;
        this.definition = videoDefinition;
    }

    public EnterRoomInfo.VideoDefinition getDefinition() {
        return this.definition;
    }

    public long getRoomId() {
        return this.roomId;
    }
}
