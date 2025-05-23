package com.tencent.open.downloadnew.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: e, reason: collision with root package name */
    protected static final String f341476e = "com.tencent.open.downloadnew.common.b";

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f341477f = {"appid", "download_url", "package", "push_title", "sendtime_col", "uin_col", "triggertime_col", "via_col", "patch_url", "update_type", "myappid_col", "apkid_col", "version_col", "downloadtype_col", "filepath_col", "source_col", "last_download_size", "is_apk", "myapp_download_from", "icon_url", "is_show_notification", "apk_writecode_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "ext_param_id", "notification_style"};

    /* renamed from: h, reason: collision with root package name */
    protected static final byte[] f341478h = new byte[1];

    /* renamed from: i, reason: collision with root package name */
    protected static volatile b f341479i;

    /* renamed from: d, reason: collision with root package name */
    protected long f341480d;

    protected b(Context context) {
        super(context, "app_plugin_download.db", (SQLiteDatabase.CursorFactory) null, 19);
        this.f341480d = 0L;
    }

    public static synchronized b g() {
        b bVar;
        synchronized (b.class) {
            if (f341479i == null) {
                f341479i = new b(com.tencent.open.adapter.a.f().e());
            }
            if (f341479i.f341480d == 0) {
                f341479i.f341480d = com.tencent.open.adapter.a.f().l();
                if (f341479i.f341480d == 0) {
                    f341479i.f341480d = com.tencent.open.adapter.a.f().m();
                }
            }
            bVar = f341479i;
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.String] */
    public void a(DownloadInfo downloadInfo) {
        String str;
        String str2;
        SQLiteDatabase writableDatabase;
        int i3;
        int i16;
        synchronized (f341478h) {
            SQLiteDatabase sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            SQLiteDatabase sQLiteDatabase3 = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appid", downloadInfo.f341184e);
                        contentValues.put("download_url", downloadInfo.f341186f);
                        contentValues.put("package", downloadInfo.f341189h);
                        contentValues.put("push_title", downloadInfo.f341191i);
                        contentValues.put("sendtime_col", downloadInfo.f341196m);
                        contentValues.put("uin_col", h());
                        contentValues.put("triggertime_col", Long.valueOf(downloadInfo.D));
                        contentValues.put("via_col", downloadInfo.C);
                        contentValues.put("patch_url", downloadInfo.F);
                        contentValues.put("update_type", Integer.valueOf(downloadInfo.E));
                        contentValues.put("myappid_col", downloadInfo.G);
                        contentValues.put("apkid_col", downloadInfo.H);
                        contentValues.put("version_col", Integer.valueOf(downloadInfo.I));
                        contentValues.put("downloadtype_col", Integer.valueOf(downloadInfo.J));
                        contentValues.put("filepath_col", downloadInfo.L);
                        contentValues.put("source_col", downloadInfo.M);
                        contentValues.put("last_download_size", Long.valueOf(downloadInfo.V));
                        if (downloadInfo.X) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        contentValues.put("is_apk", Integer.valueOf(i3));
                        contentValues.put("myapp_download_from", Integer.valueOf(downloadInfo.W));
                        contentValues.put("icon_url", downloadInfo.Y);
                        contentValues.put("is_show_notification", Integer.valueOf(downloadInfo.Z));
                        int i17 = downloadInfo.f341179a0;
                        if (i17 == 0) {
                            i17 = 1;
                        }
                        contentValues.put("apk_writecode_state", Integer.valueOf(i17));
                        contentValues.put("extra_info", downloadInfo.f341181c0);
                        if (downloadInfo.f341183d0) {
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        contentValues.put("is_autoInstall_by_sdk", Integer.valueOf(i16));
                        contentValues.put("download_file_md5", downloadInfo.f341185e0);
                        contentValues.put("download_file_size", Long.valueOf(downloadInfo.f341187f0));
                        contentValues.put("ext_param_id", downloadInfo.f341201q0);
                        contentValues.put("notification_style", Integer.valueOf(downloadInfo.N));
                        int update = writableDatabase.update("download_info", contentValues, "appid = ?", new String[]{downloadInfo.f341184e});
                        String str3 = f341476e;
                        f.h(str3, "addDownloadInfo>>>update affected rowNum=" + update);
                        if (update == 0) {
                            f.h(str3, "addDownloadInfo>>>insert rowID = " + writableDatabase.insert("download_info", null, contentValues));
                            sQLiteDatabase2 = "addDownloadInfo>>>insert rowID = ";
                        }
                        writableDatabase.setTransactionSuccessful();
                    } catch (Exception e16) {
                        e = e16;
                        sQLiteDatabase3 = writableDatabase;
                        f.d(f341476e, "addDownloadExceptionInfo>>>", e);
                        sQLiteDatabase = sQLiteDatabase3;
                        if (sQLiteDatabase3 != null) {
                            try {
                                sQLiteDatabase3.endTransaction();
                                sQLiteDatabase3.close();
                                sQLiteDatabase = sQLiteDatabase3;
                            } catch (Exception e17) {
                                e = e17;
                                str = f341476e;
                                str2 = "addDownloadExceptionInfo>>>";
                                f.d(str, str2, e);
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteDatabase = writableDatabase;
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                                sQLiteDatabase.close();
                            } catch (Exception e18) {
                                f.d(f341476e, "addDownloadExceptionInfo>>>", e18);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                try {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                    sQLiteDatabase = sQLiteDatabase2;
                } catch (Exception e26) {
                    e = e26;
                    str = f341476e;
                    str2 = "addDownloadExceptionInfo>>>";
                    f.d(str, str2, e);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    protected DownloadInfo b(Cursor cursor) {
        boolean z16;
        int i3;
        boolean z17;
        DownloadInfo downloadInfo;
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        String string3 = cursor.getString(2);
        String string4 = cursor.getString(3);
        String string5 = cursor.getString(4);
        long j3 = cursor.getLong(6);
        String string6 = cursor.getString(7);
        String string7 = cursor.getString(8);
        int i16 = cursor.getInt(9);
        String string8 = cursor.getString(10);
        String string9 = cursor.getString(11);
        int i17 = cursor.getInt(12);
        int i18 = cursor.getInt(13);
        String string10 = cursor.getString(14);
        String string11 = cursor.getString(15);
        long j16 = cursor.getLong(16);
        if (cursor.getInt(17) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i19 = cursor.getInt(18);
        String string12 = cursor.getString(19);
        int i26 = cursor.getInt(20);
        if (cursor.getInt(21) == 1) {
            i3 = 0;
        } else {
            i3 = cursor.getInt(21);
        }
        String string13 = cursor.getString(22);
        if (cursor.getInt(23) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        DownloadInfo downloadInfo2 = new DownloadInfo(string, string2, string3, string4, string5, j3, string6, string7, i16, string8, string9, i17, i18, string10, string11, j16, z16, i19, string12, i26, i3, string13, z17, cursor.getString(24), cursor.getLong(25));
        int columnIndex = cursor.getColumnIndex("ext_param_id");
        if (columnIndex >= 0) {
            downloadInfo = downloadInfo2;
            downloadInfo.f341201q0 = cursor.getString(columnIndex);
        } else {
            downloadInfo = downloadInfo2;
        }
        int columnIndex2 = cursor.getColumnIndex("notification_style");
        if (columnIndex2 >= 0) {
            downloadInfo.N = cursor.getInt(columnIndex2);
        }
        return downloadInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str) {
        synchronized (f341478h) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    f.a(f341476e, "deleteInfoByAppId:appid = ?" + Arrays.toString(new String[]{str}));
                    sQLiteDatabase.delete("download_info", "appid = ?", new String[]{str});
                } catch (Exception e16) {
                    f.d(f341476e, "deleteInfoByAppId>>>", e16);
                }
                sQLiteDatabase.close();
            } catch (Throwable th5) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th5;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093 A[Catch: all -> 0x0097, TryCatch #2 {all -> 0x0097, blocks: (B:16:0x006f, B:17:0x0072, B:18:0x008f, B:30:0x0093, B:32:0x009b, B:33:0x009e, B:24:0x0089), top: B:4:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b A[Catch: all -> 0x0097, TryCatch #2 {all -> 0x0097, blocks: (B:16:0x006f, B:17:0x0072, B:18:0x008f, B:30:0x0093, B:32:0x009b, B:33:0x009e, B:24:0x0089), top: B:4:0x0011 }] */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.database.sqlite.SQLiteOpenHelper, com.tencent.open.downloadnew.common.b] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteClosable, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, DownloadInfo> d() {
        SQLiteDatabase sQLiteDatabase;
        f.a(f341476e, "getAllDownloadInfos");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        synchronized (f341478h) {
            ?? r26 = 0;
            r26 = 0;
            try {
                try {
                    try {
                        sQLiteDatabase = getReadableDatabase();
                    } catch (Exception e16) {
                        e = e16;
                        sQLiteDatabase = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (0 != 0) {
                        }
                        if (0 != 0) {
                        }
                        throw th;
                    }
                    try {
                        r26 = sQLiteDatabase.query("download_info", f341477f, null, null, null, null, null);
                        if (r26.getCount() > 0) {
                            r26.moveToFirst();
                            do {
                                String string = r26.getString(0);
                                String str = f341476e;
                                f.a(str, "getAllDownloadInfos appId=" + string);
                                DownloadInfo b16 = b(r26);
                                f.a(str, "getAllDownloadInfos info=" + b16.toString());
                                concurrentHashMap.put(string, b16);
                            } while (r26.moveToNext());
                        }
                        r26.close();
                    } catch (Exception e17) {
                        e = e17;
                        f.d(f341476e, "getAllDownloadInfos>>>", e);
                        if (r26 != 0) {
                            r26.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return concurrentHashMap;
                    }
                    sQLiteDatabase.close();
                } catch (Throwable th6) {
                    th = th6;
                    if (0 != 0) {
                        r26.close();
                    }
                    if (0 != 0) {
                        r26.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                throw th7;
            }
        }
        return concurrentHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004e A[Catch: all -> 0x0052, TryCatch #1 {all -> 0x0052, blocks: (B:13:0x0024, B:14:0x0027, B:15:0x0048, B:21:0x0042, B:28:0x004e, B:30:0x0056, B:31:0x0059), top: B:4:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056 A[Catch: all -> 0x0052, TryCatch #1 {all -> 0x0052, blocks: (B:13:0x0024, B:14:0x0027, B:15:0x0048, B:21:0x0042, B:28:0x004e, B:30:0x0056, B:31:0x0059), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected DownloadInfo e(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        DownloadInfo downloadInfo;
        synchronized (f341478h) {
            Cursor cursor2 = null;
            downloadInfo = null;
            downloadInfo = null;
            downloadInfo = null;
            cursor2 = null;
            try {
                try {
                    sQLiteDatabase = getReadableDatabase();
                } catch (Exception e16) {
                    e = e16;
                    cursor = null;
                    sQLiteDatabase = null;
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                }
                try {
                    cursor = sQLiteDatabase.query("download_info", f341477f, str, strArr, null, null, null);
                } catch (Exception e17) {
                    e = e17;
                    cursor = null;
                } catch (Throwable th6) {
                    th = th6;
                    if (cursor2 != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    throw th;
                }
                try {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            downloadInfo = b(cursor);
                        }
                        cursor.close();
                    } catch (Throwable th7) {
                        th = th7;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                    f.d(f341476e, "getDownloadInfo", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return downloadInfo;
                }
                sQLiteDatabase.close();
            } catch (Throwable th8) {
                throw th8;
            }
        }
        return downloadInfo;
    }

    public DownloadInfo f(String str) {
        return e("package = ?", new String[]{str});
    }

    protected String h() {
        if (this.f341480d == 0) {
            long l3 = com.tencent.open.adapter.a.f().l();
            this.f341480d = l3;
            if (l3 == 0) {
                f.c(f341476e, "getUin() is empty!");
            }
        }
        return String.valueOf(this.f341480d);
    }

    protected void i(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != i16) {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE download_info (appid TEXT PRIMARY KEY,download_url TEXT,package TEXT,push_title TEXT,sendtime_col TEXT,uin_col TEXT,triggertime_col INTEGER,via_col TEXT,patch_url TEXT,update_type INTEGER,myappid_col TEXT,apkid_col TEXT,version_col INTEGER,downloadtype_col INTEGER,filepath_col TEXT,source_col TEXT,last_download_size INTEGER,is_apk INTEGER,myapp_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_writecode_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,ext_param_id TEXT,notification_style INTEGER); ");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        f.a(f341476e, "onDowngrade oldVersion=" + i3 + " newVersion=" + i16);
        i(sQLiteDatabase, i3, i16);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        f.a(f341476e, "onUpgrade oldVersion=" + i3 + " newVersion=" + i16);
        i(sQLiteDatabase, i3, i16);
    }
}
