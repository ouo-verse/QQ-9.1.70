package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

/* loaded from: classes16.dex */
public class PersistOrReplaceTransaction implements BaseTransaction {
    private final Entity mEntity;

    public PersistOrReplaceTransaction(Entity entity) {
        this.mEntity = entity;
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public void doDBOperate(EntityManager entityManager) {
        entityManager.persistOrReplace(this.mEntity);
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public Object getResult() {
        return null;
    }
}
