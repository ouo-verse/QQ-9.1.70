package g05;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.timi.game.utils.l;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
class c extends a {

    /* renamed from: d, reason: collision with root package name */
    private final Object f401053d;

    public c(Context context) {
        super(context, "timi_game_download_db", null, 1);
        this.f401053d = new Object();
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE download_table (download_ticket TEXT PRIMARY KEY,download_url TEXT,file_size INTEGER,file_md5 TEXT,file_name TEXT,file_abs_path TEXT,file_root_dir TEXT,create_time INTEGER,cost_time INTEGER,received_length INTEGER,total_length INTEGER,error_code INTEGER,error_msg TEXT,priority INTEGER,scene TEXT,pause_on_mobile INTEGER,download_state INTEGER,extra_info TEXT,unique_id TEXT,file_type TEXT);");
            l.i("DownloadInfoDBHelper_", "createTable succ");
        } catch (Exception e16) {
            l.f("DownloadInfoDBHelper_", "createTable failed", e16);
        }
    }

    @Override // g05.a
    protected void a(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        l.b("DownloadInfoDBHelper_", ">upgradeStepByStep " + i3 + "|" + i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            l.e("DownloadInfoDBHelper_", "[deleteInfoByTicket] ticket is empty");
            return;
        }
        synchronized (this.f401053d) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    l.b("DownloadInfoDBHelper_", "[deleteInfoByTicket]download_ticket = ?" + Arrays.toString(new String[]{str}));
                    sQLiteDatabase.delete("download_table", "download_ticket = ?", new String[]{str});
                } catch (Exception e16) {
                    l.f("DownloadInfoDBHelper_", "[deleteInfoByTicket]>>>", e16);
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
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f A[Catch: all -> 0x00a3, TryCatch #1 {all -> 0x00a3, blocks: (B:16:0x007a, B:17:0x007d, B:18:0x009b, B:30:0x009f, B:32:0x00a7, B:33:0x00aa, B:24:0x0095), top: B:4:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[Catch: all -> 0x00a3, TryCatch #1 {all -> 0x00a3, blocks: (B:16:0x007a, B:17:0x007d, B:18:0x009b, B:30:0x009f, B:32:0x00a7, B:33:0x00aa, B:24:0x0095), top: B:4:0x0012 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteClosable, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<DownloadInfo> d() {
        SQLiteDatabase sQLiteDatabase;
        l.b("DownloadInfoDBHelper_", "[getAllDownloadInfos]");
        ArrayList arrayList = new ArrayList();
        synchronized (this.f401053d) {
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
                        r26 = sQLiteDatabase.query("download_table", b.f401052a, null, null, null, null, null);
                        if (r26.getCount() > 0) {
                            r26.moveToFirst();
                            do {
                                l.b("DownloadInfoDBHelper_", "[getAllDownloadInfos] ticket=" + r26.getString(b.c(r26, "download_ticket")));
                                DownloadInfo b16 = b.b(r26);
                                l.b("DownloadInfoDBHelper_", "[getAllDownloadInfos] info=" + b16.toString());
                                arrayList.add(b16);
                            } while (r26.moveToNext());
                        }
                        r26.close();
                    } catch (Exception e17) {
                        e = e17;
                        l.f("DownloadInfoDBHelper_", "[getAllDownloadInfos] >>>", e);
                        if (r26 != 0) {
                            r26.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return arrayList;
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
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    public boolean e(DownloadInfo downloadInfo) {
        String s16 = downloadInfo.s();
        boolean z16 = false;
        if (TextUtils.isEmpty(s16)) {
            return false;
        }
        synchronized (this.f401053d) {
            SQLiteDatabase sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                try {
                    ContentValues a16 = b.a(downloadInfo);
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        writableDatabase.delete("download_table", "download_ticket = ?", new String[]{s16});
                        long insert = writableDatabase.insert("download_table", null, a16);
                        StringBuilder sb5 = new StringBuilder();
                        ?? r36 = "[save] insert rowID = ";
                        sb5.append("[save] insert rowID = ");
                        sb5.append(insert);
                        l.b("DownloadInfoDBHelper_", sb5.toString());
                        writableDatabase.setTransactionSuccessful();
                        try {
                            writableDatabase.endTransaction();
                            writableDatabase.close();
                        } catch (Exception e16) {
                            l.f("DownloadInfoDBHelper_", "addDownloadExceptionInfo>>>", e16);
                        }
                        z16 = true;
                        sQLiteDatabase = r36;
                    } catch (Exception e17) {
                        e = e17;
                        sQLiteDatabase2 = writableDatabase;
                        l.f("DownloadInfoDBHelper_", "[save] ExceptionInfo>>>", e);
                        sQLiteDatabase = sQLiteDatabase2;
                        if (sQLiteDatabase2 != null) {
                            try {
                                sQLiteDatabase2.endTransaction();
                                sQLiteDatabase2.close();
                                sQLiteDatabase = sQLiteDatabase2;
                            } catch (Exception e18) {
                                l.f("DownloadInfoDBHelper_", "addDownloadExceptionInfo>>>", e18);
                                sQLiteDatabase = "addDownloadExceptionInfo>>>";
                            }
                        }
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteDatabase = writableDatabase;
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                                sQLiteDatabase.close();
                            } catch (Exception e19) {
                                l.f("DownloadInfoDBHelper_", "addDownloadExceptionInfo>>>", e19);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return z16;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        l.b("DownloadInfoDBHelper_", ">onDowngrade " + i3 + "|" + i16);
    }
}
