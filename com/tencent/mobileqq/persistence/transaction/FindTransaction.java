package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FindTransaction {
    private final Class<? extends Entity> mClass;
    private Long mID;
    private String mSelection;
    private String[] mSelectionArgs;
    private String mUnique;
    private String[] mUniqueArgs;

    public FindTransaction(Class<? extends Entity> cls, String str) {
        this.mSelection = BaseTransaction.DEFAULT_STRING;
        this.mClass = cls;
        this.mUnique = str;
    }

    public Entity doFindOperate(EntityManager entityManager) {
        if (!BaseTransaction.DEFAULT_STRING.equals(this.mUnique)) {
            return DBMethodProxy.find(entityManager, this.mClass, this.mUnique);
        }
        if (!BaseTransaction.DEFAULT_STRING.equals(this.mSelection)) {
            return DBMethodProxy.find(entityManager, this.mClass, this.mSelection, this.mSelectionArgs);
        }
        Long l3 = this.mID;
        if (l3 != null) {
            return DBMethodProxy.find(entityManager, this.mClass, l3.longValue());
        }
        return DBMethodProxy.find(entityManager, this.mClass, this.mUniqueArgs);
    }

    public FindTransaction(Class<? extends Entity> cls, String... strArr) {
        this.mUnique = BaseTransaction.DEFAULT_STRING;
        this.mSelection = BaseTransaction.DEFAULT_STRING;
        this.mClass = cls;
        this.mUniqueArgs = strArr;
    }

    public FindTransaction(Class<? extends Entity> cls, long j3) {
        this.mUnique = BaseTransaction.DEFAULT_STRING;
        this.mSelection = BaseTransaction.DEFAULT_STRING;
        this.mClass = cls;
        this.mID = Long.valueOf(j3);
    }

    public FindTransaction(Class<? extends Entity> cls, String str, String[] strArr) {
        this.mUnique = BaseTransaction.DEFAULT_STRING;
        this.mClass = cls;
        this.mSelection = str;
        this.mSelectionArgs = strArr;
    }
}
