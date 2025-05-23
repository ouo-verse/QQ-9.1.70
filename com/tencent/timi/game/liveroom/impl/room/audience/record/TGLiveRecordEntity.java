package com.tencent.timi.game.liveroom.impl.room.audience.record;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "enterRoomTime")
/* loaded from: classes26.dex */
public class TGLiveRecordEntity extends BaseTimiGameEntity {
    public long enterRoomTime;
    public long leaveRoomTime;
    public long roomId;
    public int roomType;

    public long duration() {
        return this.leaveRoomTime - this.enterRoomTime;
    }
}
