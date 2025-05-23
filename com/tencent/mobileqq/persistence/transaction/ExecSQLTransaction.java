package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExecSQLTransaction implements BaseTransaction<Boolean> {
    private boolean mResult;
    private final String mSQL;

    public ExecSQLTransaction(String str) {
        this.mSQL = str;
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public void doDBOperate(EntityManager entityManager) {
        this.mResult = DBMethodProxy.execSQL(entityManager, this.mSQL);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public Boolean getResult() {
        return Boolean.valueOf(this.mResult);
    }
}
