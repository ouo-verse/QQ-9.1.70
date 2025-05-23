package com.tencent.mobileqq.nearby;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyEntityManagerFactory extends EntityManagerFactory {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Class<?>> f252510a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class VerifyEntity extends Entity {
        public String flags = "nearby_verify_entity";
        public String name = "";
    }

    public NearbyEntityManagerFactory(String str) {
        super(str);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        boolean z16;
        int i3;
        boolean z17;
        Cursor rawQuery = sQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                String decode = SecurityUtile.decode(rawQuery.getString(0));
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[]{"table", decode});
                Class<?> cls = f252510a.get(decode.trim());
                if (rawQuery2 != null && cls != null) {
                    List<Field> validField = TableBuilder.getValidField((Class<? extends Entity>) cls);
                    if (rawQuery2.moveToFirst()) {
                        String[] split = SecurityUtile.decode(rawQuery2.getString(0)).split(",");
                        for (Field field : validField) {
                            int i16 = 1;
                            while (true) {
                                if (i16 >= split.length) {
                                    z16 = false;
                                    break;
                                } else {
                                    if (field.getName().equals(split[i16].trim().split(" ")[0])) {
                                        z16 = true;
                                        break;
                                    }
                                    i16++;
                                }
                            }
                            if (!z16) {
                                if (field.isAnnotationPresent(defaultzero.class)) {
                                    i3 = 0;
                                } else if (field.isAnnotationPresent(defaultValue.class)) {
                                    i3 = ((defaultValue) field.getAnnotation(defaultValue.class)).defaultInteger();
                                } else {
                                    i3 = 0;
                                    z17 = false;
                                    arrayList.add(TableBuilder.addColumn(decode, field.getName(), TableBuilder.TYPES.get(field.getType()), z17, i3));
                                }
                                z17 = true;
                                arrayList.add(TableBuilder.addColumn(decode, field.getName(), TableBuilder.TYPES.get(field.getType()), z17, i3));
                            }
                        }
                    }
                }
                if (rawQuery2 != null) {
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
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "nearby_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX, 1);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
            this.name = "nearby_" + str;
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return getClass().getPackage().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        a(sQLiteDatabase);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public boolean verifyAuthentication() {
        if (!this.name.matches("^nearby_[0-9]*$")) {
            return true;
        }
        EntityManager createEntityManager = createEntityManager();
        VerifyEntity verifyEntity = (VerifyEntity) DBMethodProxy.find(createEntityManager, VerifyEntity.class, "flags=?", new String[]{"nearby_verify_entity"});
        if (verifyEntity == null) {
            VerifyEntity verifyEntity2 = new VerifyEntity();
            verifyEntity2.name = this.name;
            verifyEntity2.flags = "nearby_verify_entity";
            createEntityManager.persistOrReplace(verifyEntity2);
            return true;
        }
        if (verifyEntity.flags.equals("nearby_verify_entity") && verifyEntity.name.equals(this.name)) {
            return true;
        }
        this.mInnerDbHelper.dropAllTable();
        VerifyEntity verifyEntity3 = new VerifyEntity();
        verifyEntity3.name = this.name;
        createEntityManager.persistOrReplace(verifyEntity3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
    }
}
