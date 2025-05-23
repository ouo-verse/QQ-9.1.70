package com.tencent.timi.game.userinfo.impl.db;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "testkey1,testkey2")
/* loaded from: classes26.dex */
public class TestUserInfoEntity extends BaseTimiGameEntity {
    public byte[] data;
    public String testkey1;
    public String testkey2;

    public String toString() {
        return "TestUserInfoEnrity{testkey1='" + this.testkey1 + "', testkey2=" + this.testkey2 + ", data=" + Arrays.toString(this.data) + '}';
    }
}
