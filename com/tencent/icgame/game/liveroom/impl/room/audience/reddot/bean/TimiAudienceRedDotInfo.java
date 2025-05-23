package com.tencent.icgame.game.liveroom.impl.room.audience.reddot.bean;

import com.tencent.icgame.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "roomId")
/* loaded from: classes7.dex */
public class TimiAudienceRedDotInfo extends BaseTimiGameEntity {
    public String content;
    public long roomId;
}
