package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "usrMessage,recommendType")
/* loaded from: classes10.dex */
public class StickerRecommendEntity extends Entity {
    public long cachedTime;
    public String recList;
    public int recommendType;
    public String usrMessage;
}
