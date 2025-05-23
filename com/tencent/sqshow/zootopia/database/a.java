package com.tencent.sqshow.zootopia.database;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import t84.b;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a extends EntityManagerFactory {
    public a(String str) {
        super(str);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "zplan_" + str + "_" + v84.a.a() + DBBackupServiceImpl.DB_FILE_SUFFIX, 2);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        ConcurrentHashMap<Class, b> g16 = ZplanDataBaseHelper.g();
        v84.a.e("ZplanEntityManagerFactory", "createDatabase - entityMap.size = " + g16.size());
        Iterator<Map.Entry<Class, b>> it = g16.entrySet().iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(it.next().getValue().f435600a));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return getClass().getPackage().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        ConcurrentHashMap<Class, b> g16 = ZplanDataBaseHelper.g();
        v84.a.e("ZplanEntityManagerFactory", "upgradeDatabase --  oldVersion: " + i3 + "; newVersion : " + i16 + ", entityMap.size = " + g16.size());
        for (Map.Entry<Class, b> entry : g16.entrySet()) {
            t84.a aVar = entry.getValue().f435601b;
            if (aVar != null) {
                aVar.a(sQLiteDatabase, entry.getValue().f435600a.getTableName(), i3, i16);
            }
        }
        createDatabase(sQLiteDatabase);
    }
}
