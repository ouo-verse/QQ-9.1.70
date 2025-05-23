package com.tencent.biz.pubaccount.persistence.manager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class PublicAccountEntityManagerFactory extends EntityManagerFactory {

    /* loaded from: classes4.dex */
    public static class VerifyEntity extends Entity {
        public String flags = "public_account_database_verify_entity";
        public String name = "";
    }

    public PublicAccountEntityManagerFactory(String str) {
        super(str);
        this.tag = "PublicAccountEntityManagerFactory";
    }

    public static void a(String str, SQLiteDatabase sQLiteDatabase) {
        Class cls;
        Cursor rawQuery = sQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                String decode = SecurityUtile.decode(rawQuery.getString(0));
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[]{"table", decode});
                if (rawQuery2 != null) {
                    try {
                        if (decode.equals(PAAdPreloadTask.TABLE_NAME)) {
                            cls = PAAdPreloadTask.class;
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

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "public_account_database_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX, 1);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PAAdPreloadTask()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return "com.tencent.biz.pubaccount.persistence.manager";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QLog.i(this.tag, 1, "[DB]|upgrade. oldVer=" + i3 + ", newVer=" + i16);
        a(getPackageName(), sQLiteDatabase);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public boolean verifyAuthentication() {
        if (this.name.matches("^[0-9]*$")) {
            EntityManager createEntityManager = createEntityManager();
            VerifyEntity verifyEntity = (VerifyEntity) DBMethodProxy.find(createEntityManager, VerifyEntity.class, "flags=?", new String[]{"public_account_database_verify_entity"});
            if (verifyEntity == null) {
                VerifyEntity verifyEntity2 = new VerifyEntity();
                verifyEntity2.name = this.name;
                createEntityManager.persistOrReplace(verifyEntity2);
            } else if (!verifyEntity.flags.equals("public_account_database_verify_entity") || !verifyEntity.name.equals(this.name)) {
                this.mInnerDbHelper.dropAllTable();
                VerifyEntity verifyEntity3 = new VerifyEntity();
                verifyEntity3.name = this.name;
                createEntityManager.persistOrReplace(verifyEntity3);
                return false;
            }
        }
        return true;
    }
}
