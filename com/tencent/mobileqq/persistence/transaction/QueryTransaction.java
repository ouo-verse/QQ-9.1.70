package com.tencent.mobileqq.persistence.transaction;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QueryTransaction {
    private Class<? extends Entity> mClass;
    private String[] mColumns;
    private boolean mDistinct;
    private String mGroupBy;
    private String mHaving;
    private String mLimit;
    private String mOrderBy;
    private String mSelection;
    private String[] mSelectionArgs;
    private String mTableName;

    public QueryTransaction(boolean z16, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        this.mDistinct = z16;
        this.mTableName = str;
        this.mColumns = strArr;
        this.mSelection = str2;
        this.mSelectionArgs = strArr2;
        this.mGroupBy = str3;
        this.mHaving = str4;
        this.mOrderBy = str5;
        this.mLimit = str6;
    }

    public Cursor doQueryCursorOperate(EntityManager entityManager) {
        if (this.mClass != null) {
            return null;
        }
        return entityManager.query(this.mDistinct, this.mTableName, this.mColumns, this.mSelection, this.mSelectionArgs, this.mGroupBy, this.mHaving, this.mOrderBy, this.mLimit);
    }

    public List<? extends Entity> doQueryEntityListOperate(EntityManager entityManager) {
        if (this.mClass == null) {
            return null;
        }
        if (BaseTransaction.DEFAULT_STRING.equals(this.mTableName)) {
            return entityManager.query(this.mClass);
        }
        String str = this.mTableName;
        if (str == null) {
            return entityManager.query(this.mClass, this.mDistinct, this.mSelection, this.mSelectionArgs, this.mGroupBy, this.mHaving, this.mOrderBy, this.mLimit);
        }
        return entityManager.query(this.mClass, str, this.mDistinct, this.mSelection, this.mSelectionArgs, this.mGroupBy, this.mHaving, this.mOrderBy, this.mLimit);
    }

    public QueryTransaction(Class<? extends Entity> cls, String str, boolean z16, String str2, String[] strArr, String str3, String str4, String str5, String str6) {
        this.mClass = cls;
        this.mDistinct = z16;
        this.mTableName = str;
        this.mSelection = str2;
        this.mSelectionArgs = strArr;
        this.mGroupBy = str3;
        this.mHaving = str4;
        this.mOrderBy = str5;
        this.mLimit = str6;
    }

    public QueryTransaction(Class<? extends Entity> cls) {
        this.mTableName = BaseTransaction.DEFAULT_STRING;
        this.mClass = cls;
    }
}
