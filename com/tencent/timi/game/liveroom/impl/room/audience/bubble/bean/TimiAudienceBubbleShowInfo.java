package com.tencent.timi.game.liveroom.impl.room.audience.bubble.bean;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "roomId")
/* loaded from: classes26.dex */
public class TimiAudienceBubbleShowInfo extends BaseTimiGameEntity {
    public String content;
    public long roomId;
}
