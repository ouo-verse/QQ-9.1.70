package com.tencent.sqshow.zootopia.database.test;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.sqshow.zootopia.database.base.BaseZplanEntity;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uid,openid")
/* loaded from: classes34.dex */
public class TestZplanEntity extends BaseZplanEntity {
    public byte[] data;
    public String openid;
    public int testValue;
    public String uid;

    public String toString() {
        return "TestZplanEntity{uid='" + this.uid + "', openid=" + this.openid + ", testValue='" + this.testValue + "', data=" + Arrays.toString(this.data) + '}';
    }
}
