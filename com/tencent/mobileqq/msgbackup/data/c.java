package com.tencent.mobileqq.msgbackup.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends EntityManagerFactory {
    static IPatchRedirector $redirector_;

    public c(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    @SuppressLint({"Range"})
    public Entity a(Class<? extends Entity> cls, String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Entity) iPatchRedirector.redirect((short) 16, this, cls, str, cursor, noColumnErrorHandler);
        }
        if (cursor.isBeforeFirst()) {
            cursor.moveToFirst();
        }
        long j3 = -1;
        try {
            if (cursor.getColumnIndex("_id") >= 0) {
                j3 = cursor.getLong(cursor.getColumnIndex("_id"));
            }
        } catch (Exception unused) {
        }
        long j16 = j3;
        try {
            Entity newInstance = cls.newInstance();
            c(str, cursor, noColumnErrorHandler, j16, newInstance);
            return newInstance;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(e16));
            return null;
        } catch (OutOfMemoryError e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(e17));
            return null;
        }
    }

    protected List<? extends Entity> b(Class<? extends Entity> cls, String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, this, cls, str, cursor, noColumnErrorHandler);
        }
        ArrayList arrayList = null;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    int count = cursor.getCount();
                    do {
                        Entity a16 = a(cls, str, cursor, noColumnErrorHandler);
                        if (a16 != null) {
                            if (arrayList == null) {
                                try {
                                    arrayList = new ArrayList(count);
                                } catch (Throwable unused) {
                                }
                            }
                            arrayList.add(a16);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(e16));
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SQLiteOpenHelper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (this.mInnerDbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, str, 1);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
            createDatabase(this.mInnerDbHelper.getWritableDatabase());
        }
        return this.dbHelper;
    }

    protected void c(String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler, long j3, Entity entity) throws IllegalAccessException {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, cursor, noColumnErrorHandler, Long.valueOf(j3), entity);
            return;
        }
        if (entity != null) {
            entity.setId(j3);
            List<Field> validField = TableBuilder.getValidField(entity);
            int size = validField.size();
            for (int i3 = 0; i3 < size; i3++) {
                Field field = validField.get(i3);
                Class<?> type = field.getType();
                String name = field.getName();
                int columnIndex = cursor.getColumnIndex(name);
                if (columnIndex != -1) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (type == Long.TYPE) {
                        field.set(entity, Long.valueOf(cursor.getLong(columnIndex)));
                    } else if (type == Integer.TYPE) {
                        field.set(entity, Integer.valueOf(cursor.getInt(columnIndex)));
                    } else if (type == String.class) {
                        field.set(entity, cursor.getString(columnIndex));
                    } else if (type == Byte.TYPE) {
                        field.set(entity, Byte.valueOf((byte) cursor.getShort(columnIndex)));
                    } else if (type == byte[].class) {
                        field.set(entity, cursor.getBlob(columnIndex));
                    } else if (type == Short.TYPE) {
                        field.set(entity, Short.valueOf(cursor.getShort(columnIndex)));
                    } else if (type == Boolean.TYPE) {
                        if (cursor.getInt(columnIndex) != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        field.set(entity, Boolean.valueOf(z16));
                    } else if (type == Float.TYPE) {
                        field.set(entity, Float.valueOf(cursor.getFloat(columnIndex)));
                    } else if (type == Double.TYPE) {
                        field.set(entity, Double.valueOf(cursor.getDouble(columnIndex)));
                    }
                } else if (noColumnErrorHandler != null) {
                    noColumnErrorHandler.handleNoColumnError(new NoColumnError(name, type));
                }
            }
            if (j3 != -1 && str != null) {
                entity.setStatus(1001);
            } else {
                entity.setStatus(1002);
            }
            if (entity instanceof MsgBackupMsgEntity) {
                ((MsgBackupMsgEntity) entity).postRead();
            } else if (entity instanceof MsgBackupResEntity) {
                ((MsgBackupResEntity) entity).postRead();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sQLiteDatabase);
        } else {
            if (sQLiteDatabase == null) {
                com.tencent.mobileqq.msgbackup.util.f.B("MsgBackup_db", "db create is null", new Object[0]);
                return;
            }
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupMsgEntity()));
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupResEntity()));
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupExtraEntity()));
        }
    }

    public void d(List<MsgBackupExtraEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            ContentValues contentValues = new ContentValues();
            SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (MsgBackupExtraEntity msgBackupExtraEntity : list) {
                contentValues.put("name", msgBackupExtraEntity.name);
                contentValues.put("value", msgBackupExtraEntity.value);
                writableDatabase.insert(MsgBackupExtraEntity.TABLE_NAME, null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        }
    }

    public void e(List<MsgBackupMsgEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            ContentValues contentValues = new ContentValues();
            SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
            if (writableDatabase == null) {
                com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup_db", "insertMsgToDB db is null ...103", new Object[0]);
                return;
            }
            writableDatabase.beginTransaction();
            for (MsgBackupMsgEntity msgBackupMsgEntity : list) {
                msgBackupMsgEntity.prewrite();
                contentValues.put("chatUin", msgBackupMsgEntity.chatUin);
                contentValues.put("chatType", Integer.valueOf(msgBackupMsgEntity.chatType));
                contentValues.put(QQBrowserActivity.KEY_MSG_TYPE, Integer.valueOf(msgBackupMsgEntity.msgType));
                contentValues.put("msgTime", Long.valueOf(msgBackupMsgEntity.msgTime));
                contentValues.put("msgSeq", Long.valueOf(msgBackupMsgEntity.msgSeq));
                contentValues.put("msgRandom", Long.valueOf(msgBackupMsgEntity.msgRandom));
                contentValues.put("extensionData", msgBackupMsgEntity.extensionData);
                contentValues.put(WadlProxyConsts.EXTRA_DATA, msgBackupMsgEntity.extraData);
                writableDatabase.insert("msg", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        }
    }

    public void f(List<MsgBackupResEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            ContentValues contentValues = new ContentValues();
            SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (MsgBackupResEntity msgBackupResEntity : list) {
                msgBackupResEntity.prewrite();
                contentValues.put("msgSeq", Long.valueOf(msgBackupResEntity.msgSeq));
                contentValues.put("msgRandom", Long.valueOf(msgBackupResEntity.msgRandom));
                contentValues.put(QQBrowserActivity.KEY_MSG_TYPE, Integer.valueOf(msgBackupResEntity.msgType));
                contentValues.put("msgSubType", Integer.valueOf(msgBackupResEntity.msgSubType));
                contentValues.put("filePath", msgBackupResEntity.filePath);
                contentValues.put("fileSize", Long.valueOf(msgBackupResEntity.fileSize));
                contentValues.put(WadlProxyConsts.EXTRA_DATA, msgBackupResEntity.extraData);
                writableDatabase.insert("res", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        }
    }

    public List<MsgBackupExtraEntity> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String format = String.format("select * from %s", MsgBackupExtraEntity.TABLE_NAME);
        SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
        if (writableDatabase == null) {
            com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup_db", "db is null queryExtraInfo ...", new Object[0]);
            return new ArrayList();
        }
        Cursor rawQuery = writableDatabase.rawQuery(format, null);
        List b16 = b(MsgBackupExtraEntity.class, MsgBackupExtraEntity.TABLE_NAME, rawQuery, null);
        rawQuery.close();
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return getClass().getPackage().getName();
    }

    public List<MsgBackupMsgEntity> h(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
        String format = String.format("select * from %s where _id>=%d limit %d", "msg", Long.valueOf(j3), Integer.valueOf(i3));
        SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
        if (writableDatabase == null) {
            com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup_db", "db is null queryMsg ..125.", new Object[0]);
            return new ArrayList();
        }
        Cursor rawQuery = writableDatabase.rawQuery(format, null);
        List b16 = b(MsgBackupMsgEntity.class, "msg", rawQuery, null);
        rawQuery.close();
        return b16;
    }

    public int i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).intValue();
        }
        SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
        int i3 = 0;
        if (writableDatabase == null) {
            com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup_db", "db is null queryMsgTotalCount ...", new Object[0]);
            return 0;
        }
        try {
            Cursor rawQuery = writableDatabase.rawQuery("select count() from " + str, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        i3 = rawQuery.getInt(0);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d("MsgBackup_db", 1, "queryResTotalCount outer error:" + e16);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public boolean isNeedEncrypt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return false;
    }

    public List<MsgBackupResEntity> j(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
        String format = String.format("select * from %s where _id>=%d limit %d", "res", Long.valueOf(j3), Integer.valueOf(i3));
        SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
        if (writableDatabase == null) {
            com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup_db", "db is null queryRes ...135", new Object[0]);
            return new ArrayList();
        }
        Cursor rawQuery = writableDatabase.rawQuery(format, null);
        List b16 = b(MsgBackupResEntity.class, "res", rawQuery, null);
        rawQuery.close();
        return b16;
    }

    public List<MsgBackupResEntity> k(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Long.valueOf(j16));
        }
        String format = String.format("select * from %s where msgSeq = %d and msgRandom = %d", "res", Long.valueOf(j3), Long.valueOf(j16));
        SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
        if (writableDatabase == null) {
            com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup_db", "db is null queryRes ...", new Object[0]);
            return new ArrayList();
        }
        Cursor rawQuery = writableDatabase.rawQuery(format, null);
        List b16 = b(MsgBackupResEntity.class, "res", rawQuery, null);
        rawQuery.close();
        return b16;
    }

    public int l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).intValue();
        }
        SQLiteDatabase writableDatabase = this.mInnerDbHelper.getWritableDatabase();
        int i3 = 0;
        if (writableDatabase == null) {
            com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup_db", "db is null queryResTotalCount ...", new Object[0]);
            return 0;
        }
        try {
            Cursor rawQuery = writableDatabase.rawQuery("select count() from " + str, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        i3 = rawQuery.getInt(0);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d("MsgBackup_db", 1, "queryResTotalCount outer:" + e16);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
