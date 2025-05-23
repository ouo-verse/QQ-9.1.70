package com.tencent.mtt.hippy.adapter.storage;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IHippySQLiteHelper {
    public static final String COLUMN_KEY = "key";
    public static final String COLUMN_VALUE = "value";

    SQLiteDatabase getDatabase();

    String getTableName();

    void onDestroy();
}
