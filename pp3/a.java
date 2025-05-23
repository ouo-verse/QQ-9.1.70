package pp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f426957f = {"ticket", "open_appid", "download_url", "package_name", "push_title", "send_time", "uin", StatisticCollector.KEY_TRIGGER_TIME, "via", "patch_url", "update_type", "appid", "apkid", "version", VRReportDefine$ReportParam.DOWNLOAD_TYPE, "filepath", "source", "last_download_size", "is_apk", "yyb_download_from", "icon_url", "is_show_notification", "apk_write_code_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "download_state", "download_progress", "total_length", "recommend_id", "source_from_server", "channel_id", "page_id", "module_id", QCircleLpReportDc05507.KEY_POSITION_ID, "process_flag_id", "unique_id", "ext_param_id", "notification_style"};

    /* renamed from: h, reason: collision with root package name */
    private static volatile a f426958h = null;

    /* renamed from: d, reason: collision with root package name */
    private final Object f426959d;

    /* renamed from: e, reason: collision with root package name */
    private long f426960e;

    a(Context context) {
        super(context, "open_appstore_db_DownloadInfoDB.db", (SQLiteDatabase.CursorFactory) null, 6);
        this.f426959d = new Object();
        this.f426960e = 0L;
    }

    private DownloadInfo b(Cursor cursor) {
        boolean z16;
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f341182d = cursor.getString(l(cursor, "ticket"));
        downloadInfo.f341184e = cursor.getString(l(cursor, "open_appid"));
        downloadInfo.f341186f = cursor.getString(l(cursor, "download_url"));
        downloadInfo.f341189h = cursor.getString(l(cursor, "package_name"));
        downloadInfo.f341191i = cursor.getString(l(cursor, "push_title"));
        downloadInfo.f341196m = cursor.getString(l(cursor, "send_time"));
        downloadInfo.D = cursor.getLong(l(cursor, StatisticCollector.KEY_TRIGGER_TIME));
        downloadInfo.C = cursor.getString(l(cursor, "via"));
        downloadInfo.F = cursor.getString(l(cursor, "patch_url"));
        downloadInfo.E = cursor.getInt(l(cursor, "update_type"));
        downloadInfo.G = cursor.getString(l(cursor, "appid"));
        downloadInfo.H = cursor.getString(l(cursor, "apkid"));
        downloadInfo.I = cursor.getInt(l(cursor, "version"));
        downloadInfo.J = cursor.getInt(l(cursor, VRReportDefine$ReportParam.DOWNLOAD_TYPE));
        downloadInfo.L = cursor.getString(l(cursor, "filepath"));
        downloadInfo.M = cursor.getString(l(cursor, "source"));
        downloadInfo.V = cursor.getLong(l(cursor, "last_download_size"));
        boolean z17 = false;
        if (cursor.getInt(l(cursor, "is_apk")) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        downloadInfo.X = z16;
        downloadInfo.W = cursor.getInt(l(cursor, "yyb_download_from"));
        downloadInfo.Y = cursor.getString(l(cursor, "icon_url"));
        downloadInfo.Z = cursor.getInt(l(cursor, "is_show_notification"));
        int i3 = cursor.getInt(l(cursor, "apk_write_code_state"));
        downloadInfo.f341179a0 = i3;
        if (i3 == 1) {
            downloadInfo.f341179a0 = 0;
        }
        downloadInfo.f341181c0 = cursor.getString(l(cursor, "extra_info"));
        if (cursor.getInt(l(cursor, "is_autoInstall_by_sdk")) == 1) {
            z17 = true;
        }
        downloadInfo.f341183d0 = z17;
        downloadInfo.f341185e0 = cursor.getString(l(cursor, "download_file_md5"));
        downloadInfo.f341187f0 = cursor.getLong(l(cursor, "download_file_size"));
        downloadInfo.k(cursor.getInt(l(cursor, "download_state")));
        downloadInfo.Q = cursor.getInt(l(cursor, "download_progress"));
        downloadInfo.f341180b0 = cursor.getLong(l(cursor, "total_length"));
        downloadInfo.f341188g0 = cursor.getString(l(cursor, "recommend_id"));
        downloadInfo.f341190h0 = cursor.getString(l(cursor, "source_from_server"));
        downloadInfo.f341192i0 = cursor.getString(l(cursor, "channel_id"));
        downloadInfo.f341193j0 = cursor.getString(l(cursor, "page_id"));
        downloadInfo.f341194k0 = cursor.getString(l(cursor, "module_id"));
        downloadInfo.f341195l0 = cursor.getString(l(cursor, QCircleLpReportDc05507.KEY_POSITION_ID));
        downloadInfo.f341199o0 = cursor.getString(l(cursor, "process_flag_id"));
        downloadInfo.f341200p0 = cursor.getString(l(cursor, "unique_id"));
        downloadInfo.f341201q0 = cursor.getString(l(cursor, "ext_param_id"));
        downloadInfo.N = cursor.getInt(l(cursor, "notification_style"));
        return downloadInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004f A[Catch: all -> 0x0053, TryCatch #2 {all -> 0x0053, blocks: (B:13:0x0024, B:14:0x0027, B:15:0x0049, B:21:0x0043, B:28:0x004f, B:30:0x0057, B:31:0x005a), top: B:4:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057 A[Catch: all -> 0x0053, TryCatch #2 {all -> 0x0053, blocks: (B:13:0x0024, B:14:0x0027, B:15:0x0049, B:21:0x0043, B:28:0x004f, B:30:0x0057, B:31:0x005a), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DownloadInfo f(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        DownloadInfo downloadInfo;
        synchronized (this.f426959d) {
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
                    cursor = sQLiteDatabase.query("download_info", f426957f, str, strArr, null, null, null);
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
                    f.d("DownloadInfoDB", "[getDownloadInfo]", e);
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

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073 A[Catch: all -> 0x0077, TRY_ENTER, TryCatch #2 {all -> 0x0077, blocks: (B:15:0x0032, B:16:0x0035, B:17:0x0053, B:30:0x0073, B:32:0x007b, B:33:0x007e, B:24:0x004d), top: B:4:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[Catch: all -> 0x0077, TryCatch #2 {all -> 0x0077, blocks: (B:15:0x0032, B:16:0x0035, B:17:0x0053, B:30:0x0073, B:32:0x007b, B:33:0x007e, B:24:0x004d), top: B:4:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<DownloadInfo> h(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f426959d) {
            Cursor cursor = null;
            try {
                try {
                    sQLiteDatabase = getReadableDatabase();
                } catch (Exception e16) {
                    e = e16;
                    sQLiteDatabase = null;
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                    if (cursor != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    throw th;
                }
                try {
                    try {
                        cursor = sQLiteDatabase.query("download_info", f426957f, str, strArr, null, null, null);
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            do {
                                arrayList.add(b(cursor));
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    } catch (Throwable th6) {
                        th = th6;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    f.d("DownloadInfoDB", "[getDownloadInfoList]", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    f.e("DownloadInfoDB", ">getDownloadInfoList  size:" + arrayList.size());
                    return arrayList;
                }
                sQLiteDatabase.close();
            } catch (Throwable th7) {
                throw th7;
            }
        }
        f.e("DownloadInfoDB", ">getDownloadInfoList  size:" + arrayList.size());
        return arrayList;
    }

    public static a j() {
        if (f426958h == null) {
            synchronized (a.class) {
                if (f426958h == null) {
                    f426958h = new a(com.tencent.open.adapter.a.f().e());
                    f426958h.m();
                }
            }
        }
        return f426958h;
    }

    private String k() {
        if (this.f426960e == 0) {
            long l3 = com.tencent.open.adapter.a.f().l();
            this.f426960e = l3;
            if (l3 == 0) {
                f.c("DownloadInfoDB", "getUin() is empty!");
            }
        }
        return String.valueOf(this.f426960e);
    }

    private static int l(Cursor cursor, String str) {
        if (cursor != null && !TextUtils.isEmpty(str)) {
            return cursor.getColumnIndex(str);
        }
        return -1;
    }

    private void m() {
        if (this.f426960e == 0) {
            long l3 = com.tencent.open.adapter.a.f().l();
            this.f426960e = l3;
            if (l3 == 0) {
                this.f426960e = com.tencent.open.adapter.a.f().m();
            }
        }
    }

    private void n(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != i16) {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            onCreate(sQLiteDatabase);
        }
    }

    public void a(DownloadInfo downloadInfo, boolean z16) {
        String str;
        String str2;
        int i3;
        int i16;
        synchronized (this.f426959d) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ticket", downloadInfo.f341182d);
                        contentValues.put("open_appid", downloadInfo.f341184e);
                        contentValues.put("download_url", downloadInfo.f341186f);
                        contentValues.put("package_name", downloadInfo.f341189h);
                        contentValues.put("push_title", downloadInfo.f341191i);
                        contentValues.put("send_time", downloadInfo.f341196m);
                        contentValues.put("uin", k());
                        contentValues.put(StatisticCollector.KEY_TRIGGER_TIME, Long.valueOf(downloadInfo.D));
                        contentValues.put("via", downloadInfo.C);
                        contentValues.put("patch_url", downloadInfo.F);
                        contentValues.put("update_type", Integer.valueOf(downloadInfo.E));
                        contentValues.put("appid", downloadInfo.G);
                        contentValues.put("apkid", downloadInfo.H);
                        contentValues.put("version", Integer.valueOf(downloadInfo.I));
                        contentValues.put(VRReportDefine$ReportParam.DOWNLOAD_TYPE, Integer.valueOf(downloadInfo.J));
                        contentValues.put("filepath", downloadInfo.L);
                        contentValues.put("source", downloadInfo.M);
                        contentValues.put("last_download_size", Long.valueOf(downloadInfo.V));
                        if (downloadInfo.X) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        contentValues.put("is_apk", Integer.valueOf(i3));
                        contentValues.put("yyb_download_from", Integer.valueOf(downloadInfo.W));
                        contentValues.put("icon_url", downloadInfo.Y);
                        contentValues.put("is_show_notification", Integer.valueOf(downloadInfo.Z));
                        int i17 = downloadInfo.f341179a0;
                        if (i17 == 0) {
                            i17 = 1;
                        }
                        contentValues.put("apk_write_code_state", Integer.valueOf(i17));
                        contentValues.put("extra_info", downloadInfo.f341181c0);
                        if (downloadInfo.f341183d0) {
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        contentValues.put("is_autoInstall_by_sdk", Integer.valueOf(i16));
                        contentValues.put("download_file_md5", downloadInfo.f341185e0);
                        contentValues.put("download_file_size", Long.valueOf(downloadInfo.f341187f0));
                        contentValues.put("download_state", Integer.valueOf(downloadInfo.f()));
                        contentValues.put("download_progress", Integer.valueOf(downloadInfo.Q));
                        contentValues.put("total_length", Long.valueOf(downloadInfo.f341180b0));
                        contentValues.put("recommend_id", downloadInfo.f341188g0);
                        contentValues.put("source_from_server", downloadInfo.f341190h0);
                        contentValues.put("channel_id", downloadInfo.f341192i0);
                        contentValues.put("page_id", downloadInfo.f341193j0);
                        contentValues.put("module_id", downloadInfo.f341194k0);
                        contentValues.put(QCircleLpReportDc05507.KEY_POSITION_ID, downloadInfo.f341195l0);
                        contentValues.put("notification_style", Integer.valueOf(downloadInfo.N));
                        if (z16) {
                            contentValues.put("process_flag_id", downloadInfo.f341199o0);
                        }
                        contentValues.put("unique_id", downloadInfo.f341200p0);
                        contentValues.put("ext_param_id", downloadInfo.f341201q0);
                        int update = writableDatabase.update("download_info", contentValues, "ticket = ?", new String[]{downloadInfo.f341182d});
                        f.h("DownloadInfoDB", "addDownloadInfo>>>update affected rowNum=" + update);
                        if (update == 0) {
                            contentValues.put("process_flag_id", downloadInfo.f341199o0);
                            f.h("DownloadInfoDB", "addDownloadInfo>>>insert rowID = " + writableDatabase.insert("download_info", null, contentValues));
                        }
                        writableDatabase.setTransactionSuccessful();
                    } catch (Exception e16) {
                        e = e16;
                        sQLiteDatabase = writableDatabase;
                        f.d("DownloadInfoDB", "addDownloadExceptionInfo>>>", e);
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                                sQLiteDatabase.close();
                            } catch (Exception e17) {
                                e = e17;
                                str = "DownloadInfoDB";
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
                                f.d("DownloadInfoDB", "addDownloadExceptionInfo>>>", e18);
                            }
                        }
                        throw th;
                    }
                    try {
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                    } catch (Exception e19) {
                        e = e19;
                        str = "DownloadInfoDB";
                        str2 = "addDownloadExceptionInfo>>>";
                        f.d(str, str2, e);
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e26) {
                e = e26;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            f.c("DownloadInfoDB", "[deleteInfoByTicket] ticket is empty");
            return;
        }
        synchronized (this.f426959d) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    f.a("DownloadInfoDB", "[deleteInfoByTicket]ticket = ?" + Arrays.toString(new String[]{str}));
                    sQLiteDatabase.delete("download_info", "ticket = ?", new String[]{str});
                } catch (Exception e16) {
                    f.d("DownloadInfoDB", "[deleteInfoByTicket]>>>", e16);
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

    public List<DownloadInfo> d(String str) {
        return h("package_name = ?", new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f A[Catch: all -> 0x00a3, TryCatch #1 {all -> 0x00a3, blocks: (B:16:0x007a, B:17:0x007d, B:18:0x009b, B:30:0x009f, B:32:0x00a7, B:33:0x00aa, B:24:0x0095), top: B:4:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[Catch: all -> 0x00a3, TryCatch #1 {all -> 0x00a3, blocks: (B:16:0x007a, B:17:0x007d, B:18:0x009b, B:30:0x009f, B:32:0x00a7, B:33:0x00aa, B:24:0x0095), top: B:4:0x0012 }] */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.database.sqlite.SQLiteOpenHelper, pp3.a] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteClosable, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, DownloadInfo> e() {
        SQLiteDatabase sQLiteDatabase;
        f.a("DownloadInfoDB", "[getAllDownloadInfos]");
        ConcurrentHashMap<String, DownloadInfo> concurrentHashMap = new ConcurrentHashMap<>();
        synchronized (this.f426959d) {
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
                        r26 = sQLiteDatabase.query("download_info", f426957f, null, null, null, null, null);
                        if (r26.getCount() > 0) {
                            r26.moveToFirst();
                            do {
                                String string = r26.getString(l(r26, "ticket"));
                                f.a("DownloadInfoDB", "[getAllDownloadInfos] ticket=" + string);
                                DownloadInfo b16 = b(r26);
                                f.a("DownloadInfoDB", "[getAllDownloadInfos] info=" + b16.toString());
                                concurrentHashMap.put(string, b16);
                            } while (r26.moveToNext());
                        }
                        r26.close();
                    } catch (Exception e17) {
                        e = e17;
                        f.d("DownloadInfoDB", "[getAllDownloadInfos] >>>", e);
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

    public DownloadInfo g(String str) {
        return f("ticket = ?", new String[]{str});
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE download_info (ticket TEXT PRIMARY KEY,open_appid TEXT,download_url TEXT,package_name TEXT,push_title TEXT,send_time TEXT,uin TEXT,trigger_time INTEGER,via TEXT,patch_url TEXT,update_type INTEGER,appid TEXT,apkid TEXT,version INTEGER,download_type INTEGER,filepath TEXT,source TEXT,last_download_size INTEGER,is_apk INTEGER,yyb_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_write_code_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,download_state INTEGER,download_progress INTEGER,total_length INTEGER,recommend_id TEXT,source_from_server TEXT,channel_id TEXT,page_id TEXT,module_id TEXT,position_id TEXT,process_flag_id TEXT,unique_id TEXT,ext_param_id TEXT,notification_style INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        f.e("DownloadInfoDB", "onDowngrade oldVersion=" + i3 + " newVersion=" + i16);
        n(sQLiteDatabase, i3, i16);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        f.e("DownloadInfoDB", "onUpgrade oldVersion=" + i3 + " newVersion=" + i16);
        n(sQLiteDatabase, i3, i16);
    }
}
