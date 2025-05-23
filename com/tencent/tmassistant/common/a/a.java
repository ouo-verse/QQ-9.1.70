package com.tencent.tmassistant.common.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a implements b {

    /* compiled from: P */
    /* renamed from: com.tencent.tmassistant.common.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9992a {

        /* renamed from: a, reason: collision with root package name */
        public List<Long> f380375a;

        /* renamed from: b, reason: collision with root package name */
        public List<byte[]> f380376b;
    }

    protected abstract String a();

    public boolean a(byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("logData", bArr);
        return b().getWritableDatabase().insert(d(), null, contentValues) > 0;
    }

    protected abstract String[] a(int i3);

    public boolean b(List<byte[]> list) {
        SQLiteDatabase writableDatabase = b().getWritableDatabase();
        try {
            if (writableDatabase != null) {
                try {
                    writableDatabase.beginTransaction();
                    SQLiteStatement compileStatement = writableDatabase.compileStatement(c());
                    Iterator<byte[]> it = list.iterator();
                    while (it.hasNext()) {
                        compileStatement.bindBlob(1, it.next());
                        compileStatement.executeInsert();
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    r.a("BaseLogTable", "exception: ", e16);
                    writableDatabase.endTransaction();
                    return false;
                }
            }
            return true;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    protected abstract String c();

    @Override // com.tencent.tmassistant.common.a.b
    public String createTableSQL() {
        return a();
    }

    protected abstract String d();

    @Override // com.tencent.tmassistant.common.a.b
    public String[] getAlterSQL(int i3, int i16) {
        return a(i16);
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String tableName() {
        return d();
    }

    public boolean a(List<Long> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer("(");
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append(")");
        SQLiteDatabase writableDatabase = b().getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete(d(), "_id in " + ((Object) stringBuffer), null);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r12.moveToFirst() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        r0.f380375a.add(java.lang.Long.valueOf(r12.getLong(r12.getColumnIndex("_id"))));
        r0.f380376b.add(r12.getBlob(r12.getColumnIndex("logData")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        if (r12.moveToNext() != false) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C9992a b(int i3) {
        String str;
        Cursor cursor;
        C9992a c9992a = new C9992a();
        c9992a.f380375a = new ArrayList();
        c9992a.f380376b = new ArrayList();
        ?? r16 = 0;
        if (i3 > 0) {
            str = "0," + i3;
        } else {
            str = null;
        }
        c b16 = b();
        SQLiteDatabase readableDatabase = b16.getReadableDatabase();
        try {
            if (readableDatabase != null) {
                try {
                    cursor = readableDatabase.query(d(), null, null, null, null, null, "_id asc", str);
                    if (cursor != null) {
                        try {
                        } catch (Exception e16) {
                            e = e16;
                            r.a("BaseLogTable", "exception: ", e);
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e17) {
                    e = e17;
                    cursor = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (r16 != 0) {
                        r16.close();
                    }
                    throw th;
                }
            }
            return c9992a;
        } catch (Throwable th6) {
            th = th6;
            r16 = b16;
        }
    }

    public c b() {
        return com.tencent.tmdownloader.f.b.d.a.c();
    }
}
