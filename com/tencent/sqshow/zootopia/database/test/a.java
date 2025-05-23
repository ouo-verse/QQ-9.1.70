package com.tencent.sqshow.zootopia.database.test;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a implements t84.a {
    @Override // t84.a
    public boolean a(SQLiteDatabase sQLiteDatabase, String str, int i3, int i16) {
        v84.a.e("BaseZplanDatabaseTableHandler", "TestZplanTableHandler#onDatabaseUpgrade oldVersion=" + i3 + ", newVersion=" + i16);
        return false;
    }
}
