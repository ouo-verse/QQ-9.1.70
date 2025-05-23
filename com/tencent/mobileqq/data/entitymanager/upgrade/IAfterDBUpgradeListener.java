package com.tencent.mobileqq.data.entitymanager.upgrade;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface IAfterDBUpgradeListener {
    void afterDBUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16);
}
