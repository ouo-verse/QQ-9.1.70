package com.tencent.timi.game.liveroom.impl.room.audience.reddot.bean;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "roomId")
/* loaded from: classes26.dex */
public class TimiAudienceRedDotInfo extends BaseTimiGameEntity {
    public String content;
    public long roomId;
}
