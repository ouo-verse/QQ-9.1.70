package com.tencent.mobileqq.persistence.transaction;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class UpdateTransaction implements BaseTransaction<Boolean> {
    private Object[] mArgs;
    private Entity mEntity;
    private boolean mResult;
    private String mSQL;
    private String mTableName;
    private ContentValues mValues;
    private String[] mWhereArgs;
    private String mWhereClause;

    public UpdateTransaction(String str) {
        this.mSQL = str;
    }

    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public void doDBOperate(EntityManager entityManager) {
        this.mResult = false;
        String str = this.mSQL;
        if (str != null && this.mArgs == null) {
            this.mResult = entityManager.update(str);
            return;
        }
        Object[] objArr = this.mArgs;
        if (objArr != null) {
            this.mResult = entityManager.update(str, objArr);
            return;
        }
        Entity entity = this.mEntity;
        if (entity != null) {
            this.mResult = entityManager.update(entity);
            return;
        }
        String str2 = this.mTableName;
        if (str2 != null) {
            this.mResult = entityManager.update(str2, this.mValues, this.mWhereClause, this.mWhereArgs);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.persistence.transaction.BaseTransaction
    public Boolean getResult() {
        return Boolean.valueOf(this.mResult);
    }

    public UpdateTransaction(Entity entity) {
        this.mEntity = entity;
    }

    public UpdateTransaction(String str, Object[] objArr) {
        this.mSQL = str;
        this.mArgs = objArr;
    }

    public UpdateTransaction(String str, ContentValues contentValues, String str2, String[] strArr) {
        this.mTableName = str;
        this.mValues = contentValues;
        this.mWhereClause = str2;
        this.mWhereArgs = strArr;
    }
}
