package com.tencent.icgame.game.liveroom.impl.room.audience.record;

import com.tencent.icgame.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "enterRoomTime")
/* loaded from: classes7.dex */
public class TGLiveRecordEntity extends BaseTimiGameEntity {
    public long enterRoomTime;
    public long leaveRoomTime;
    public long roomId;
    public int roomType;

    public long duration() {
        return this.leaveRoomTime - this.enterRoomTime;
    }
}
