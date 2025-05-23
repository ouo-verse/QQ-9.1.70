package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RawQueryTransaction {
    private Class<? extends Entity> mClass;
    private String mSQL;
    private String mSelection;
    private String[] mSelectionArgs;
    private String mTableName;

    public RawQueryTransaction(Class<? extends Entity> cls, String str, String str2, String str3, String[] strArr) {
        this.mClass = cls;
        this.mSQL = str;
        this.mTableName = str2;
        this.mSelection = str3;
        this.mSelectionArgs = strArr;
    }

    public List<? extends Entity> doRawQueryOperate(EntityManager entityManager) {
        if (!BaseTransaction.DEFAULT_STRING.equals(this.mTableName) && !BaseTransaction.DEFAULT_STRING.equals(this.mSelection)) {
            return DBMethodProxy.rawQuery(entityManager, this.mClass, this.mSQL, this.mTableName, this.mSelection, this.mSelectionArgs);
        }
        return DBMethodProxy.rawQuery(entityManager, this.mClass, this.mSQL, this.mSelectionArgs);
    }

    public RawQueryTransaction(Class<? extends Entity> cls, String str, String[] strArr) {
        this.mTableName = BaseTransaction.DEFAULT_STRING;
        this.mSelection = BaseTransaction.DEFAULT_STRING;
        this.mClass = cls;
        this.mSQL = str;
        this.mSelectionArgs = strArr;
    }
}
