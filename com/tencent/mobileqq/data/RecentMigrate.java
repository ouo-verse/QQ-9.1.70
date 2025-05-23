package com.tencent.mobileqq.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentMigrate {
    private static byte[] convertBlob(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return SecurityUtile.encode(bArr);
        }
        return bArr;
    }

    private static String convertStr(Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.length() > 0) {
            return SecurityUtile.encode(obj2);
        }
        return obj2;
    }

    private static ContentValues createContentValue(Entity entity) throws IllegalArgumentException, IllegalAccessException {
        List<Field> validField = TableBuilder.getValidField((Class<? extends Entity>) entity.getClass());
        int size = validField.size();
        ContentValues contentValues = new ContentValues(size);
        for (int i3 = 0; i3 < size; i3++) {
            Field field = validField.get(i3);
            String name = field.getName();
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj = field.get(entity);
            if (obj instanceof Integer) {
                contentValues.put(name, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(name, (Long) obj);
            } else if (obj instanceof String) {
                contentValues.put(name, convertStr((String) obj));
            } else if (obj instanceof byte[]) {
                contentValues.put(name, convertBlob((byte[]) obj));
            } else if (obj instanceof Short) {
                contentValues.put(name, (Short) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put(name, (Boolean) obj);
            } else if (obj instanceof Double) {
                contentValues.put(name, (Double) obj);
            } else if (obj instanceof Float) {
                contentValues.put(name, (Float) obj);
            } else if (obj instanceof Byte) {
                contentValues.put(name, (Byte) obj);
            }
        }
        return contentValues;
    }

    private static void doMigrate(SQLiteDatabase sQLiteDatabase, Entity entity) {
        Cursor rawQuery;
        QLog.d("RecentMigrate", 1, "doMigrate");
        sQLiteDatabase.execSQL("ALTER TABLE recent RENAME to recent_old");
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(entity));
        Cursor cursor = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("select * from recent_old", null);
        } catch (Throwable th5) {
            th = th5;
        }
        if (rawQuery != null) {
            try {
                if (!rawQuery.moveToFirst()) {
                }
                do {
                    Entity recentUserEntity = getRecentUserEntity();
                    if (recentUserEntity != null) {
                        recentUserEntity.setId(getEntityId(rawQuery));
                        Method declaredMethod = recentUserEntity.getClass().getDeclaredMethod("entityByCursor", Cursor.class);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(recentUserEntity, rawQuery);
                        recentUserEntity.setStatus(1001);
                        Method declaredMethod2 = Entity.class.getDeclaredMethod("postRead", new Class[0]);
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(recentUserEntity, new Object[0]);
                        Method declaredMethod3 = Entity.class.getDeclaredMethod("prewrite", new Class[0]);
                        declaredMethod3.setAccessible(true);
                        declaredMethod3.invoke(recentUserEntity, new Object[0]);
                        sQLiteDatabase.insert(entity.getTableName(), null, createContentValue(recentUserEntity));
                    }
                } while (rawQuery.moveToNext());
                if (!rawQuery.isClosed()) {
                    rawQuery.close();
                }
            } catch (Throwable th6) {
                th = th6;
                cursor = rawQuery;
                try {
                    QLog.d("RecentMigrate", 1, th, new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE recent_old");
                    return;
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            sQLiteDatabase.execSQL("DROP TABLE recent_old");
            return;
        }
        if (rawQuery != null && !rawQuery.isClosed()) {
            rawQuery.close();
        }
    }

    public static void doMigrateRecentTable(SQLiteDatabase sQLiteDatabase, int i3) {
        if (i3 > 395) {
            QLog.d("RecentMigrate", 1, "db version over 395");
            return;
        }
        Entity recentUserEntity = getRecentUserEntity();
        if (recentUserEntity == null) {
            QLog.d("RecentMigrate", 1, "recentUserEntity null");
            return;
        }
        if (!isUidExist(sQLiteDatabase, recentUserEntity.getTableName())) {
            QLog.d("RecentMigrate", 1, "uid not exist");
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            doMigrate(sQLiteDatabase, recentUserEntity);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private static long getEntityId(Cursor cursor) {
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex < 0) {
                return -1L;
            }
            return cursor.getLong(columnIndex);
        } catch (Exception e16) {
            QLog.d("RecentMigrate", 1, e16, new Object[0]);
            return -1L;
        }
    }

    private static Entity getRecentUserEntity() {
        try {
            Object newInstance = RecentUser.class.newInstance();
            if (newInstance instanceof Entity) {
                return (Entity) newInstance;
            }
            return null;
        } catch (Throwable th5) {
            QLog.d("RecentMigrate", 1, th5, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r2.moveToFirst() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isUidExist(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z16 = true;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE name = ?  AND sql like ?", new String[]{str, "%uid%"});
            if (cursor != null) {
            }
            z16 = false;
            return z16;
        } catch (Throwable th5) {
            try {
                QLog.d("RecentMigrate", 1, th5, new Object[0]);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return false;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
    }
}
