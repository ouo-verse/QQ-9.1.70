package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

/* loaded from: classes16.dex */
public class PersistTransaction implements BaseTransaction {
    private final Entity mEntity;

    public PersistTransaction(Entity entity) {
        this.mEntity = entity;
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public void doDBOperate(EntityManager entityManager) {
        entityManager.persist(this.mEntity);
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public Object getResult() {
        return null;
    }
}
