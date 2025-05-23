package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class OGAbstractDao {
    public int columnLen;
    public boolean useIndex;

    public abstract Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler);

    public abstract void entity2ContentValues(Entity entity, ContentValues contentValues);

    public abstract String getCreateTableSql(String str);
}
