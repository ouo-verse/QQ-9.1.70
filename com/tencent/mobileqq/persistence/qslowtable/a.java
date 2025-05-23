package com.tencent.mobileqq.persistence.qslowtable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.persistence.l;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.util.DBBuildUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends QQEntityManagerFactory {
    public a(String str) {
        super(str, 1);
        initBuilder(DBBuildUtil.getDefaultEntityManagerFactoryBuilder(str));
        this.tag = "QSlowTableEntityManagerFactory";
    }

    private void a(String str, SQLiteDatabase sQLiteDatabase) {
        Class cls;
        System.currentTimeMillis();
        Cursor rawQuery = sQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                String decode = SecurityUtile.decode(rawQuery.getString(0));
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[]{"table", decode});
                if (rawQuery2 != null) {
                    try {
                        if (decode.startsWith("mr_slow_")) {
                            cls = MessageRecord.class;
                        } else {
                            cls = Class.forName(str + "." + decode);
                        }
                        OGEntityManager.extractedStatementByReflect(arrayList, decode, rawQuery2, cls);
                    } catch (ClassNotFoundException unused) {
                    }
                    rawQuery2.close();
                }
            }
            rawQuery.close();
        }
        com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
        sQLiteDatabase.beginTransaction();
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL((String) it.next());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        }
    }

    public EntityManager b() {
        return l.b(this);
    }

    @Override // com.tencent.mobileqq.data.QQEntityManagerFactory, com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "slowtable_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX, 1);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.QQEntityManagerFactory, com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Ability()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.QQEntityManagerFactory, com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return getClass().getPackage().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.QQEntityManagerFactory, com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        a(getPackageName(), sQLiteDatabase);
    }
}
