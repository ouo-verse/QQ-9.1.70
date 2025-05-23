package com.tencent.mobileqq.persistence.bridge;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements IOnDBUpgradeListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean f258316a = false;

    public boolean a() {
        return this.f258316a;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener
    public void onDBUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 < 36) {
            this.f258316a = true;
        }
    }
}
