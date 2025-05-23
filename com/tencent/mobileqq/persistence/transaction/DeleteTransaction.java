package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DeleteTransaction implements BaseTransaction<Integer> {
    private int mResult;
    private final String mTableName;
    private final String[] mWhereArgs;
    private final String mWhereClause;

    public DeleteTransaction(String str, String str2, String[] strArr) {
        this.mTableName = str;
        this.mWhereClause = str2;
        this.mWhereArgs = strArr;
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public void doDBOperate(EntityManager entityManager) {
        this.mResult = entityManager.delete(this.mTableName, this.mWhereClause, this.mWhereArgs);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public Integer getResult() {
        return Integer.valueOf(this.mResult);
    }
}
