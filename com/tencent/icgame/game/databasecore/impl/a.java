package com.tencent.icgame.game.databasecore.impl;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.timi.game.env.ServerEnv;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ou0.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends EntityManagerFactory {
    public a(String str) {
        super(str);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "icgame_yes_" + str + "_" + ServerEnv.b() + DBBackupServiceImpl.DB_FILE_SUFFIX, 2);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        ConcurrentHashMap<Class, b> d16 = YesDataBaseHelper.d();
        g.h("ICGameYesEntityManagerFactory", "createDatabase - entityMap.size = " + d16.size());
        Iterator<Map.Entry<Class, b>> it = d16.entrySet().iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(it.next().getValue().f424087a));
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
        g.h("ICGameYesEntityManagerFactory", "upgradeDatabase --  oldVersion: " + i3 + "; newVersion : " + i16 + ", entityMap.size = " + d16.size());
        for (Map.Entry<Class, b> entry : d16.entrySet()) {
            ou0.a aVar = entry.getValue().f424088b;
            if (aVar != null) {
                aVar.a(sQLiteDatabase, entry.getValue().f424087a.getTableName(), i3, i16);
            }
        }
        createDatabase(sQLiteDatabase);
    }
}
