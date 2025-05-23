package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c2, code lost:
    
        if (r2.isOpen() == false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(String str, List<String> list) {
        synchronized (a.class) {
            r.b("CacheTableDao", "<saveReportItemToDB> process:" + l.a() + ", type = " + str + ", list = " + list);
            int size = list.size();
            if (!TextUtils.isEmpty(str) && size != 0 && com.tencent.tmdownloader.f.b.d.a.c() != null) {
                if (size > 20) {
                    size = 20;
                }
                SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                if (writableDatabase.isDbLockedByOtherThreads() || writableDatabase.isDbLockedByCurrentThread()) {
                    try {
                        LockMethodProxy.sleep(10L);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                try {
                    writableDatabase.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i3 = 0; i3 < size; i3++) {
                        String str2 = list.get(i3);
                        if (str2 != null) {
                            contentValues.put("key", "report");
                            contentValues.put("type", str);
                            contentValues.put("blob", str2.getBytes("UTF-8"));
                            writableDatabase.insert(CacheTable.TABLE_NAME, null, contentValues);
                        }
                        contentValues.clear();
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (Exception unused) {
                } catch (Throwable th5) {
                    if (writableDatabase.isOpen()) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th5;
                }
                if (writableDatabase.isOpen()) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused3) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (r2.moveToFirst() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        r3 = java.lang.Integer.valueOf(r2.getString(r2.getColumnIndex("type"))).intValue();
        r4 = new java.lang.String(r2.getBlob(r2.getColumnIndex("blob")), "UTF-8");
        r5 = (java.util.List) r1.get(java.lang.Integer.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (r5 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
    
        r5 = new java.util.ArrayList();
        r1.put(java.lang.Integer.valueOf(r3), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
    
        r5.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
    
        if (r2.moveToNext() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
    
        if (r2 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized Map<Integer, List<String>> b() {
        synchronized (a.class) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            if (com.tencent.tmdownloader.f.b.d.a.c() == null) {
                return concurrentHashMap;
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase().query(CacheTable.TABLE_NAME, new String[]{"type", "blob"}, "key = ?", new String[]{"report"}, null, null, null);
                    if (cursor != null) {
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } catch (Throwable th5) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th5;
            }
        }
    }

    public static synchronized Map<Integer, List<String>> c() {
        Map<Integer, List<String>> b16;
        synchronized (a.class) {
            b16 = b();
            a();
        }
        return b16;
    }

    public static synchronized void a() {
        synchronized (a.class) {
            if (com.tencent.tmdownloader.f.b.d.a.c() == null) {
                return;
            }
            SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.delete(CacheTable.TABLE_NAME, "key = ?", new String[]{"report"});
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
