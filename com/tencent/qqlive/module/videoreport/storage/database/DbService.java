package com.tencent.qqlive.module.videoreport.storage.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Coder;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import com.tencent.qqlive.module.videoreport.storage.util.GsonObjectCoder;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class DbService implements IDbOperation {
    private static final String EQUAL = "` = '";
    private static volatile DbService sInstance;
    private DbOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDb;
    private Coder mCoder = new GsonObjectCoder();
    private AnnotationProcessor mAnnotationProcessor = AnnotationProcessor.getInstance();

    DbService(Context context) {
        this.mDatabaseHelper = new DbOpenHelper(context);
    }

    private SQLiteDatabase db() {
        if (this.mDb == null) {
            synchronized (this) {
                if (this.mDb == null) {
                    this.mDb = this.mDatabaseHelper.getWritableDatabase();
                }
            }
        }
        return this.mDb;
    }

    private void executeInTransaction(Runnable runnable) {
        db().beginTransaction();
        try {
            runnable.run();
            db().setTransactionSuccessful();
        } finally {
            db().endTransaction();
        }
    }

    private static String generateEquation(String str, String str2) {
        return "`" + str + EQUAL + str2 + "'";
    }

    private <T> String generateReplaceValue(T t16, String str) {
        return "('" + this.mAnnotationProcessor.getClassId(t16.getClass()) + "', '" + str + "', '" + this.mCoder.encode(t16) + "')";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DbService getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DbService.class) {
                if (sInstance == null) {
                    sInstance = new DbService(context);
                }
            }
        }
        return sInstance;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public void clearTable() {
        db().delete("datong_storage", null, null);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public void close() {
        db().close();
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> boolean containsObject(Class<T> cls, String str) {
        boolean z16;
        Cursor query = db().query("datong_storage", null, generateEquation(DbConst.CLASS_ID, this.mAnnotationProcessor.getClassId(cls)) + " and " + generateEquation(DbConst.OBJECT_ID, str), null, null, null, null, null);
        if (query.getCount() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        query.close();
        return z16;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> void deleteAllObjects(Class<T> cls) {
        db().delete("datong_storage", generateEquation(DbConst.CLASS_ID, this.mAnnotationProcessor.getClassId(cls)), null);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> void deleteObject(Class<T> cls, String str) {
        db().delete("datong_storage", generateEquation(DbConst.CLASS_ID, this.mAnnotationProcessor.getClassId(cls)) + " and " + generateEquation(DbConst.OBJECT_ID, str), null);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> void deleteObjects(Class<T> cls, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(generateEquation(DbConst.CLASS_ID, this.mAnnotationProcessor.getClassId(cls)) + " and `" + DbConst.OBJECT_ID + "` in ('" + list.get(0) + "'");
        int size = list.size();
        for (int i3 = 1; i3 < size; i3++) {
            sb5.append(" ,'");
            sb5.append(list.get(i3));
            sb5.append("'");
        }
        sb5.append(")");
        db().delete("datong_storage", sb5.toString(), null);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> List<Pair<String, T>> getAllObjects(Class<T> cls) {
        LinkedList linkedList = new LinkedList();
        Cursor query = db().query("datong_storage", null, generateEquation(DbConst.CLASS_ID, this.mAnnotationProcessor.getClassId(cls)), null, null, null, null);
        while (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex(DbConst.OBJECT_DATA));
            String string2 = query.getString(query.getColumnIndex(DbConst.OBJECT_ID));
            Object decode = this.mCoder.decode(string, cls);
            if (decode != null) {
                linkedList.add(new Pair(string2, decode));
            }
        }
        query.close();
        return linkedList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> T getObject(Class<T> cls, String str) {
        T t16;
        Cursor query = db().query("datong_storage", null, generateEquation(DbConst.CLASS_ID, this.mAnnotationProcessor.getClassId(cls)) + " and " + generateEquation(DbConst.OBJECT_ID, str), null, null, null, null);
        if (query.moveToNext()) {
            t16 = (T) this.mCoder.decode(query.getString(query.getColumnIndex(DbConst.OBJECT_DATA)), cls);
        } else {
            t16 = null;
        }
        query.close();
        return t16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> List<Pair<String, T>> getObjects(Class<T> cls, Condition<T> condition) {
        LinkedList linkedList = new LinkedList();
        Cursor query = db().query("datong_storage", null, generateEquation(DbConst.CLASS_ID, this.mAnnotationProcessor.getClassId(cls)), null, null, null, null);
        while (query.moveToNext()) {
            Object decode = this.mCoder.decode(query.getString(query.getColumnIndex(DbConst.OBJECT_DATA)), cls);
            if (decode != null && (condition == 0 || condition.satisfy(decode))) {
                linkedList.add(new Pair(query.getString(query.getColumnIndex(DbConst.OBJECT_ID)), decode));
            }
        }
        query.close();
        return linkedList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> void insertObject(T t16, String str) {
        this.mDb.execSQL(DbConst.REPLACE_COMMAND + generateReplaceValue(t16, str) + ";");
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.database.IDbOperation
    public <T> void insertObjects(final List<T> list, final List<String> list2) {
        if (list.isEmpty()) {
            return;
        }
        executeInTransaction(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.storage.database.DbService.1
            @Override // java.lang.Runnable
            public void run() {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    DbService.this.insertObject(list.get(i3), (String) list2.get(i3));
                }
            }
        });
    }
}
