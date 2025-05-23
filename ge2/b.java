package ge2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;
import ee2.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes16.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    private static Integer f402013d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f402014e = {"key", "event_time", CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE, "info_name", "info_reason", "event_scene", "info_desc", CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT, "action_type", "privacy_channel"};

    /* renamed from: f, reason: collision with root package name */
    private static final Object f402015f = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static HashMap<String, b> f402016h = new HashMap<>();

    b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, f402013d.intValue());
    }

    public static synchronized b a(Context context, String str) {
        b bVar;
        synchronized (b.class) {
            bVar = f402016h.get(str);
            if (bVar == null) {
                b bVar2 = new b(context, he2.a.c("PrivacyEventDB.db" + str));
                f402016h.put(str, bVar2);
                bVar = bVar2;
            }
        }
        return bVar;
    }

    private fe2.a e(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("event_time"));
        String string2 = cursor.getString(cursor.getColumnIndex(CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE));
        String string3 = cursor.getString(cursor.getColumnIndex("info_name"));
        String string4 = cursor.getString(cursor.getColumnIndex("info_reason"));
        String string5 = cursor.getString(cursor.getColumnIndex("event_scene"));
        String string6 = cursor.getString(cursor.getColumnIndex("info_desc"));
        String string7 = cursor.getString(cursor.getColumnIndex("privacy_channel"));
        int i3 = cursor.getInt(cursor.getColumnIndex(CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT));
        int i16 = cursor.getInt(cursor.getColumnIndex("action_type"));
        return new fe2.a(new b.a().i(string2).f(string3).g(string4).h(string5).e(string6).d(string).a(i16).c(string7).b(), cursor.getString(cursor.getColumnIndex("key")), i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[Catch: all -> 0x0076, TryCatch #2 {, blocks: (B:4:0x0003, B:18:0x004b, B:19:0x004e, B:20:0x0069, B:33:0x006d, B:35:0x0072, B:36:0x0075, B:27:0x0063), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072 A[Catch: all -> 0x0076, TryCatch #2 {, blocks: (B:4:0x0003, B:18:0x004b, B:19:0x004e, B:20:0x0069, B:33:0x006d, B:35:0x0072, B:36:0x0075, B:27:0x0063), top: B:3:0x0003 }] */
    /* JADX WARN: Type inference failed for: r13v0, types: [ge2.b] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteClosable, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<fe2.a> d() {
        ArrayList arrayList;
        SQLiteDatabase sQLiteDatabase;
        synchronized (f402015f) {
            arrayList = new ArrayList();
            ?? r26 = 0;
            r26 = 0;
            try {
                try {
                    sQLiteDatabase = getReadableDatabase();
                } catch (Exception unused) {
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
                    r26 = sQLiteDatabase.query("privacy_event", f402014e, null, null, null, null, null);
                    if (r26.getCount() > 0) {
                        r26.moveToFirst();
                        do {
                            arrayList.add(e(r26));
                        } while (r26.moveToNext());
                        QLog.e("Event.OldEventDBHelper", 1, "Old Table query");
                    }
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS privacy_event");
                    QLog.e("Event.OldEventDBHelper", 1, "Old Table clear");
                    r26.close();
                } catch (Exception unused2) {
                    QLog.e("Event.OldEventDBHelper", 1, "Old Table query error Old Table is NULL");
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
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Exception e16) {
            QLog.e("Event.OldEventDBHelper", 1, "[getReadableDatabase] get database failed", e16);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != i16) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS privacy_event");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }
}
