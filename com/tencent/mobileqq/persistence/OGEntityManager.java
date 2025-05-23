package com.tencent.mobileqq.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OGEntityManager extends EntityManager {
    private static final String FROM_UIN = "fromUin";
    private static final String SQL = "EntityManager";
    private static final String TROOP_FILE_DATA = "TroopFileData";

    public OGEntityManager(SQLiteOpenHelper sQLiteOpenHelper, String str) {
        super(sQLiteOpenHelper, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void extractedStatementByReflect(List<String> list, String str, Cursor cursor, Class cls) {
        boolean z16;
        int i3;
        boolean z17;
        String str2;
        List<Field> validField = TableBuilder.getValidField((Class<? extends Entity>) cls);
        if (cursor.moveToFirst()) {
            String[] split = SecurityUtile.decode(cursor.getString(0)).split(",");
            int size = validField.size();
            for (int i16 = 0; i16 < size; i16++) {
                Field field = validField.get(i16);
                for (int i17 = 1; i17 < split.length; i17++) {
                    String str3 = split[i17].trim().split(" ")[0];
                    if (str.equalsIgnoreCase(TROOP_FILE_DATA) && str3.equalsIgnoreCase(FROM_UIN) && field.getName().equalsIgnoreCase(str3)) {
                        QLog.e(SQL, 1, "find FromUin from TroopFileData~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    } else if (!field.getName().equals(str3)) {
                    }
                    z16 = true;
                }
                z16 = false;
                if (!z16) {
                    if (field.isAnnotationPresent(defaultzero.class)) {
                        i3 = 0;
                    } else if (field.isAnnotationPresent(defaultValue.class)) {
                        i3 = ((defaultValue) field.getAnnotation(defaultValue.class)).defaultInteger();
                    } else {
                        i3 = 0;
                        z17 = false;
                        str2 = TableBuilder.TYPES.get(field.getType());
                        if (str2 == null) {
                            list.add(TableBuilder.addColumn(str, field.getName(), str2, z17, i3));
                        } else {
                            QLog.e(SQL, 1, "invalid field type, field name:" + field.getName() + ", table: " + str);
                        }
                    }
                    z17 = true;
                    str2 = TableBuilder.TYPES.get(field.getType());
                    if (str2 == null) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManager
    public ContentValues createContentValue(Entity entity) throws IllegalArgumentException, IllegalAccessException {
        if (!ORMConfig.ENABLE_WRITE_OPT) {
            return super.createContentValue(entity);
        }
        System.nanoTime();
        OGAbstractDao entityDao = OGEntityDaoManagerProxy.getEntityDao(entity.getClass());
        if (entityDao != null) {
            ContentValues contentValues = new ContentValues(entityDao.columnLen);
            entityDao.entity2ContentValues(entity, contentValues);
            return contentValues;
        }
        return super.createContentValue(entity);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: Exception -> 0x004d, TryCatch #0 {Exception -> 0x004d, blocks: (B:12:0x0024, B:14:0x002c, B:16:0x0034, B:20:0x0040, B:21:0x0049, B:25:0x0045), top: B:11:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.persistence.EntityManager
    @SuppressLint({"Range"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Entity cursor2Entity(Class<? extends Entity> cls, String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler) {
        long j3;
        Entity newInstance;
        OGAbstractDao entityDao = OGEntityDaoManagerProxy.getEntityDao(cls);
        if (entityDao != null) {
            if (cursor.isBeforeFirst()) {
                cursor.moveToFirst();
            }
            try {
                if (cursor.getColumnIndex("_id") >= 0) {
                    j3 = cursor.getLong(cursor.getColumnIndex("_id"));
                    newInstance = cls.newInstance();
                    if (newInstance == null) {
                        newInstance._id = j3;
                        if (!newInstance.entityByCursor(cursor)) {
                            newInstance = entityDao.cursor2Entity(newInstance, cursor, entityDao.useIndex, noColumnErrorHandler);
                        }
                        if (j3 != -1 && str != null) {
                            newInstance._status = 1001;
                        } else {
                            newInstance._status = 1002;
                        }
                        newInstance.postRead();
                        return newInstance;
                    }
                    return newInstance;
                }
                newInstance = cls.newInstance();
                if (newInstance == null) {
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(SQL, 2, MsfSdkUtils.getStackTraceString(e16));
                }
                return null;
            }
            j3 = -1;
        } else {
            return super.cursor2Entity(cls, str, cursor, noColumnErrorHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManager
    public void insertOrReplace(Entity entity, boolean z16) {
        super.insertOrReplace(entity, z16);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManager
    public Cursor query(boolean z16, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return super.query(z16, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManager
    public boolean update(Entity entity) {
        return super.update(entity);
    }
}
