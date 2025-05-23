package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "fromTinyId,toTinyId")
/* loaded from: classes12.dex */
public class UinToTinyId extends Entity {
    private static final String TABLE_NAME = "friendUin_tinyId";
    public String extString;
    public String friendUin;
    public String fromTinyId;
    public String tinyId;
    public String toTinyId;

    public static String getTinyTableName() {
        return TABLE_NAME;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return TABLE_NAME;
    }
}
