package com.tencent.mobileqq.persistence.bridge;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements IAfterDBUpgradeListener {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener
    public void afterDBUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        com.tencent.mobileqq.activity.aio.b.b();
    }
}
