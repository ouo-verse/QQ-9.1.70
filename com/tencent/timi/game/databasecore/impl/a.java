package com.tencent.timi.game.databasecore.impl;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.utils.l;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rg4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends EntityManagerFactory {
    public a(String str) {
        super(str);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "timiyes_" + str + "_" + ServerEnv.b() + DBBackupServiceImpl.DB_FILE_SUFFIX, 2);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        ConcurrentHashMap<Class, b> d16 = YesDataBaseHelper.d();
        l.i("YesEntityManagerFactory", "createDatabase - entityMap.size = " + d16.size());
        Iterator<Map.Entry<Class, b>> it = d16.entrySet().iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(it.next().getValue().f431442a));
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
        ConcurrentHashMap<Class, b> d16 = YesDataBaseHelper.d();
        l.i("YesEntityManagerFactory", "upgradeDatabase --  oldVersion: " + i3 + "; newVersion : " + i16 + ", entityMap.size = " + d16.size());
        for (Map.Entry<Class, b> entry : d16.entrySet()) {
            rg4.a aVar = entry.getValue().f431443b;
            if (aVar != null) {
                aVar.a(sQLiteDatabase, entry.getValue().f431442a.getTableName(), i3, i16);
            }
        }
        createDatabase(sQLiteDatabase);
    }
}
