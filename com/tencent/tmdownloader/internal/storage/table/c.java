package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements com.tencent.tmassistant.common.a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f380750a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f380750a = new Object();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3.moveToFirst() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r1.add(com.tencent.tmdownloader.internal.downloadservice.c.a(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (r3.moveToNext() != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> a() {
        ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> arrayList;
        synchronized (f380750a) {
            arrayList = new ArrayList<>();
            SQLiteDatabase readableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getReadableDatabase();
            if (readableDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = readableDatabase.rawQuery("select * from downloadInfo", null);
                        if (cursor != null) {
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e16) {
                        r.a("DownloadInfoTable", "exception: ", e16);
                        e16.printStackTrace();
                        return arrayList;
                    }
                } finally {
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r7 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        if (r7 == null) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055 A[Catch: all -> 0x0059, TryCatch #3 {all -> 0x0059, blocks: (B:9:0x0006, B:11:0x000c, B:23:0x002f, B:24:0x0032, B:18:0x004e, B:33:0x0055, B:34:0x0058, B:5:0x005b), top: B:8:0x0006 }] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.tencent.tmdownloader.internal.downloadservice.c b(String str) {
        SQLiteDatabase readableDatabase;
        Throwable th5;
        Cursor cursor;
        synchronized (f380750a) {
            if (str != 0) {
                try {
                    if (str.length() > 0 && (readableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getReadableDatabase()) != null) {
                        try {
                            try {
                                cursor = readableDatabase.rawQuery("select * from downloadInfo where taskUrl = ?", new String[]{str});
                                if (cursor != null) {
                                    try {
                                        if (cursor.moveToFirst()) {
                                            com.tencent.tmdownloader.internal.downloadservice.c a16 = com.tencent.tmdownloader.internal.downloadservice.c.a(cursor);
                                            cursor.close();
                                            return a16;
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        r.a("DownloadInfoTable", "exception: ", e);
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Exception e17) {
                                e = e17;
                                cursor = null;
                            } catch (Throwable th6) {
                                th5 = th6;
                                str = 0;
                                if (str != 0) {
                                }
                                throw th5;
                            }
                        } catch (Throwable th7) {
                            th5 = th7;
                            if (str != 0) {
                                str.close();
                            }
                            throw th5;
                        }
                    }
                } catch (Throwable th8) {
                    throw th8;
                }
            }
            return null;
        }
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String createTableSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, bakUrl TEXT,finalUrl TEXT, fileName TEXT, contentType TEXT, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER, netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT,appId INTEGER,taskPakcageName TEXT,taskVersioncode TEXT,startTime INTEGER,endTime INTEGER,downloadType INTEGER,uin INTEGER,uintype TEXT,via TEXT,channelId TEXT,traceId TEXT,extraData TEXT,iconUrl TEXT,appName TEXT,isAutoInstallBySDK INTEGER,fileSize INTEGER);";
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String[] getAlterSQL(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 == 1 && i16 == 2) {
            return new String[]{"alter table downloadInfo add column headerParams TEXT;"};
        }
        if (i3 == 2 && i16 == 3) {
            return new String[]{"alter table downloadInfo add column appId INTEGER;", "alter table downloadInfo add column taskPakcageName TEXT;", "alter table downloadInfo add column taskVersioncode TEXT;", "alter table downloadInfo add column startTime INTEGER;", "alter table downloadInfo add column endTime INTEGER;", "alter table downloadInfo add column downloadType INTEGER;", "alter table downloadInfo add column uin INTEGER;", "alter table downloadInfo add column uintype TEXT;", "alter table downloadInfo add column via TEXT;", "alter table downloadInfo add column channelId TEXT;", "alter table downloadInfo add column traceId TEXT;", "alter table downloadInfo add column extraData TEXT;"};
        }
        if (i3 == 3 && i16 == 4) {
            return new String[]{"alter table downloadInfo add column iconUrl TEXT;", "alter table downloadInfo add column appName TEXT;"};
        }
        if (i3 == 4 && i16 == 5) {
            return new String[]{"alter table downloadInfo add column isAutoInstallBySDK INTEGER;"};
        }
        if (i3 == 5 && i16 == 6) {
            return new String[]{"alter table downloadInfo add column fileSize INTEGER;"};
        }
        return new String[]{"alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;"};
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String tableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "downloadInfo";
    }

    public static void a(ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> arrayList) {
        synchronized (f380750a) {
            if (arrayList != null) {
                try {
                    SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
                    if (writableDatabase != null) {
                        try {
                            try {
                                writableDatabase.beginTransaction();
                                Iterator<com.tencent.tmdownloader.internal.downloadservice.c> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    com.tencent.tmdownloader.internal.downloadservice.c next = it.next();
                                    if (a(next, writableDatabase) <= 0) {
                                        ContentValues contentValues = new ContentValues();
                                        com.tencent.tmdownloader.internal.downloadservice.c.a(contentValues, next);
                                        writableDatabase.insert("downloadInfo", null, contentValues);
                                    }
                                }
                                writableDatabase.setTransactionSuccessful();
                            } catch (Exception e16) {
                                r.a("DownloadInfoTable", "exception: ", e16);
                                e16.printStackTrace();
                            }
                            writableDatabase.endTransaction();
                        } catch (Throwable th5) {
                            writableDatabase.endTransaction();
                            throw th5;
                        }
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3.moveToFirst() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r2 = r3.getString(r3.getColumnIndex("clientId"));
        r4 = r3.getString(r3.getColumnIndex("taskUrl"));
        r5 = r3.getInt(r3.getColumnIndex("status"));
        r6 = new com.tencent.tmdownloader.internal.downloadservice.g.b(r2, r4);
        r6.f380717c = r5;
        r1.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        if (r3.moveToNext() != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<com.tencent.tmdownloader.internal.downloadservice.g.b> b() {
        ArrayList<com.tencent.tmdownloader.internal.downloadservice.g.b> arrayList;
        synchronized (f380750a) {
            arrayList = new ArrayList<>();
            SQLiteDatabase readableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getReadableDatabase();
            if (readableDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = readableDatabase.rawQuery("select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)", null);
                        if (cursor != null) {
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (Exception e16) {
                    r.a("DownloadInfoTable", "exception: ", e16);
                    e16.printStackTrace();
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static void a(com.tencent.tmdownloader.internal.downloadservice.c cVar) {
        synchronized (f380750a) {
            if (cVar != null) {
                try {
                    SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
                    if (writableDatabase != null && a(cVar, writableDatabase) <= 0) {
                        ContentValues contentValues = new ContentValues();
                        com.tencent.tmdownloader.internal.downloadservice.c.a(contentValues, cVar);
                        writableDatabase.insert("downloadInfo", null, contentValues);
                    }
                } catch (Exception e16) {
                    r.a("DownloadInfoTable", "exception: ", e16);
                    e16.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("downloadInfo", "taskUrl = ?", new String[]{str});
            }
        } catch (Exception e16) {
            r.a("DownloadInfoTable", "exception: ", e16);
            e16.printStackTrace();
        }
    }

    private static int a(com.tencent.tmdownloader.internal.downloadservice.c cVar, SQLiteDatabase sQLiteDatabase) {
        if (cVar == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            com.tencent.tmdownloader.internal.downloadservice.c.a(contentValues, cVar);
            int update = sQLiteDatabase.update("downloadInfo", contentValues, "taskUrl = ?", new String[]{cVar.f380681b});
            if (update > 0) {
                return update;
            }
            return 0;
        } catch (Exception e16) {
            r.a("DownloadInfoTable", "exception: ", e16);
            e16.printStackTrace();
            return -2;
        }
    }
}
