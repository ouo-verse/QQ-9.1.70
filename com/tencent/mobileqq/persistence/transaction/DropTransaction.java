package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DropTransaction implements BaseTransaction<Boolean> {
    private Class<? extends Entity> mClass;
    private boolean mResult;
    private String mTableName;

    public DropTransaction(String str) {
        this.mTableName = str;
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public void doDBOperate(EntityManager entityManager) {
        this.mResult = false;
        String str = this.mTableName;
        if (str != null) {
            this.mResult = entityManager.drop(str);
            return;
        }
        Class<? extends Entity> cls = this.mClass;
        if (cls != null) {
            this.mResult = entityManager.drop(cls);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public Boolean getResult() {
        return Boolean.valueOf(this.mResult);
    }

    public DropTransaction(Class<? extends Entity> cls) {
        this.mClass = cls;
    }
}
