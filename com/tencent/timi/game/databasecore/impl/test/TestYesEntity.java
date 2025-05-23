package com.tencent.timi.game.databasecore.impl.test;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uid,openid")
/* loaded from: classes26.dex */
public class TestYesEntity extends BaseTimiGameEntity {
    public byte[] data;
    public String openid;
    public int testValue;
    public String uid;

    public String toString() {
        return "TestYesEntity{uid='" + this.uid + "', openid=" + this.openid + ", testValue='" + this.testValue + "', data=" + Arrays.toString(this.data) + '}';
    }
}
