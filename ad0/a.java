package ad0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import hd0.c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends EntityManagerFactory {
    public a(String str) {
        super(str);
    }

    public static void a(String str, SQLiteDatabase sQLiteDatabase) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = sQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                String decode = SecurityUtile.decode(rawQuery.getString(0));
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[]{"table", decode});
                if (rawQuery2 != null) {
                    try {
                        if (decode.startsWith(PublishVideoEntry.class.getSimpleName())) {
                            cls = PublishVideoEntry.class;
                        } else {
                            cls = Class.forName(str + "." + decode);
                        }
                        OGEntityManager.extractedStatementByReflect(arrayList, decode, rawQuery2, cls);
                    } catch (ClassNotFoundException e16) {
                        c.u("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange", e16);
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
            sQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            c.b("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange take time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th5) {
            sQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            throw th5;
        }
    }

    protected void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(PublishVideoEntry.class.getSimpleName()));
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "qqstory_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX, 180);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PublishVideoEntry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return getClass().getPackage().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 > i16) {
            b(sQLiteDatabase);
            createDatabase(sQLiteDatabase);
            c.v("Q.qqstory.QQStoryEntityManagerFactory", "Version %d turn to %d ,clear all data", Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (i3 < 29) {
                sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(PublishVideoEntry.class.getSimpleName()));
                sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PublishVideoEntry()));
            }
            a("com.tencent.biz.qqstory.database", sQLiteDatabase);
        }
    }
}
