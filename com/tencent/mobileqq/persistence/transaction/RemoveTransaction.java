package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RemoveTransaction implements BaseTransaction<Boolean> {
    private final Entity mEntity;
    private boolean mResult;
    private String[] mWhereArgs;
    private String mWhereClause;

    public RemoveTransaction(Entity entity) {
        this.mWhereClause = BaseTransaction.DEFAULT_STRING;
        this.mEntity = entity;
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public void doDBOperate(EntityManager entityManager) {
        if (!BaseTransaction.DEFAULT_STRING.equals(this.mWhereClause)) {
            this.mResult = entityManager.remove(this.mEntity, this.mWhereClause, this.mWhereArgs);
        } else {
            this.mResult = entityManager.remove(this.mEntity);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public Boolean getResult() {
        return Boolean.valueOf(this.mResult);
    }

    public RemoveTransaction(Entity entity, String str, String[] strArr) {
        this.mEntity = entity;
        this.mWhereClause = str;
        this.mWhereArgs = strArr;
    }
}
