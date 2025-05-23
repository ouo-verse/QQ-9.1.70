package ge2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;
import ee2.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    private static Integer f402009d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f402010e = {"key", "event_time", CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE, "info_name", "info_reason", "event_scene", "info_desc", CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT, "action_type", WadlProxyConsts.CHANNEL};

    /* renamed from: f, reason: collision with root package name */
    private static final Object f402011f = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static HashMap<String, a> f402012h = new HashMap<>();

    a(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, f402009d.intValue());
    }

    public static synchronized a b(Context context, String str) {
        a aVar;
        synchronized (a.class) {
            aVar = f402012h.get(str);
            if (aVar == null) {
                a aVar2 = new a(context, he2.a.c("PandoraEventDB.db" + str));
                f402012h.put(str, aVar2);
                aVar = aVar2;
            }
        }
        return aVar;
    }

    @SuppressLint({"Range"})
    private fe2.a f(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("event_time"));
        String string2 = cursor.getString(cursor.getColumnIndex(CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE));
        String string3 = cursor.getString(cursor.getColumnIndex("info_name"));
        String string4 = cursor.getString(cursor.getColumnIndex("info_reason"));
        String string5 = cursor.getString(cursor.getColumnIndex("event_scene"));
        String string6 = cursor.getString(cursor.getColumnIndex("info_desc"));
        String string7 = cursor.getString(cursor.getColumnIndex(WadlProxyConsts.CHANNEL));
        int i3 = cursor.getInt(cursor.getColumnIndex(CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT));
        int i16 = cursor.getInt(cursor.getColumnIndex("action_type"));
        return new fe2.a(new b.a().i(string2).f(string3).g(string4).h(string5).e(he2.b.a(string6)).d(string).a(i16).c(string7).b(), null, cursor.getString(cursor.getColumnIndex("key")), i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        SQLiteDatabase sQLiteDatabase;
        Exception e16;
        synchronized (f402011f) {
            SQLiteClosable sQLiteClosable = null;
            try {
                try {
                    try {
                        sQLiteDatabase = getReadableDatabase();
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.delete("pandora_event", null, null);
                            } catch (Exception e17) {
                                e16 = e17;
                                QLog.e("Event.EventDBHelper", 1, "Table delete error: ", e16);
                            }
                        }
                    } catch (Exception e18) {
                        sQLiteDatabase = null;
                        e16 = e18;
                    } catch (Throwable th5) {
                        th = th5;
                        if (0 != 0) {
                            sQLiteClosable.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    throw th6;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public void c(fe2.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (f402011f) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    ee2.b bVar = aVar.f398368d;
                    bVar.f396192e = he2.b.b(bVar.f396192e);
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("key", aVar.f398365a);
                        contentValues.put("event_time", aVar.f398368d.f396193f);
                        contentValues.put(CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE, aVar.f398368d.f396188a);
                        contentValues.put("info_name", aVar.f398368d.f396189b);
                        contentValues.put("info_reason", aVar.f398368d.f396190c);
                        contentValues.put("event_scene", aVar.f398368d.f396191d);
                        contentValues.put("info_desc", aVar.f398368d.f396192e);
                        contentValues.put(CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT, Integer.valueOf(aVar.f398367c));
                        contentValues.put("action_type", Integer.valueOf(aVar.f398368d.f396194g));
                        contentValues.put(WadlProxyConsts.CHANNEL, aVar.f398368d.f396195h);
                        writableDatabase.insert("pandora_event", null, contentValues);
                        QLog.i("Event.EventDBHelper", 1, ">>insert event:" + aVar.f398368d.f396189b);
                        writableDatabase.close();
                    } catch (Exception e16) {
                        e = e16;
                        sQLiteDatabase = writableDatabase;
                        QLog.e("Event.EventDBHelper", 1, "insert all PandoraEx event error", e);
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteDatabase = writableDatabase;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0123, code lost:
    
        if (r9 == null) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0120 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:19:0x011b, B:21:0x0120, B:23:0x0125, B:24:0x015a, B:36:0x014f, B:38:0x0154, B:43:0x0162, B:45:0x0167, B:47:0x016c, B:48:0x016f), top: B:8:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0154 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:19:0x011b, B:21:0x0120, B:23:0x0125, B:24:0x015a, B:36:0x014f, B:38:0x0154, B:43:0x0162, B:45:0x0167, B:47:0x016c, B:48:0x016f), top: B:8:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0167 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:19:0x011b, B:21:0x0120, B:23:0x0125, B:24:0x015a, B:36:0x014f, B:38:0x0154, B:43:0x0162, B:45:0x0167, B:47:0x016c, B:48:0x016f), top: B:8:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016c A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:19:0x011b, B:21:0x0120, B:23:0x0125, B:24:0x015a, B:36:0x014f, B:38:0x0154, B:43:0x0162, B:45:0x0167, B:47:0x016c, B:48:0x016f), top: B:8:0x0012 }] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2, types: [long] */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r16v0, types: [android.database.sqlite.SQLiteDatabase] */
    @SuppressLint({"Range"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(fe2.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        ?? r102;
        ?? readableDatabase;
        long j3;
        Cursor query;
        if (aVar == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        synchronized (f402011f) {
            Cursor cursor = null;
            try {
                readableDatabase = getReadableDatabase();
                try {
                    r102 = f402010e;
                    query = readableDatabase.query("pandora_event", r102, "key=?", new String[]{aVar.f398365a}, null, null, null);
                } catch (Exception e16) {
                    e = e16;
                    j3 = 0;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e17) {
                e = e17;
                r102 = 0;
                sQLiteDatabase = null;
            } catch (Throwable th6) {
                th = th6;
                sQLiteDatabase = null;
            }
            try {
                sQLiteDatabase = getWritableDatabase();
                try {
                    if (query != null) {
                        try {
                            try {
                                if (query.getCount() > 0) {
                                    query.moveToFirst();
                                    contentValues.put(CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT, Integer.valueOf(query.getInt(query.getColumnIndex(CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT)) + aVar.f398367c));
                                    long update = sQLiteDatabase.update("pandora_event", contentValues, "key = ?", new String[]{aVar.f398365a});
                                    QLog.i("Event.EventDBHelper", 1, ">>update event:" + aVar.f398368d.f396189b);
                                    r102 = update;
                                    contentValues.clear();
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                cursor = query;
                                contentValues.clear();
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            r102 = 0;
                            cursor = query;
                            r102 = r102;
                            try {
                                QLog.e("Event.EventDBHelper", 1, "insert all PandoraEx event error", e);
                                contentValues.clear();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                if (r102 <= 0) {
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                contentValues.clear();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                    }
                    ee2.b bVar = aVar.f398368d;
                    bVar.f396192e = he2.b.b(bVar.f396192e);
                    contentValues.put("key", aVar.f398365a);
                    contentValues.put("event_time", aVar.f398368d.f396193f);
                    contentValues.put(CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE, aVar.f398368d.f396188a);
                    contentValues.put("info_name", aVar.f398368d.f396189b);
                    contentValues.put("info_reason", aVar.f398368d.f396190c);
                    contentValues.put("event_scene", aVar.f398368d.f396191d);
                    contentValues.put("info_desc", aVar.f398368d.f396192e);
                    contentValues.put("action_type", Integer.valueOf(aVar.f398368d.f396194g));
                    contentValues.put(WadlProxyConsts.CHANNEL, aVar.f398368d.f396195h);
                    contentValues.put(CommonUsedSystemEmojiManagerServiceProxy.INFO_COUNT, Integer.valueOf(aVar.f398367c));
                    long insert = sQLiteDatabase.insert("pandora_event", null, contentValues);
                    QLog.i("Event.EventDBHelper", 1, ">>insert event:" + aVar.f398368d.f396189b);
                    r102 = insert;
                    contentValues.clear();
                    if (query != null) {
                    }
                } catch (Exception e19) {
                    e = e19;
                }
            } catch (Exception e26) {
                e = e26;
                j3 = 0;
                cursor = query;
                sQLiteDatabase = readableDatabase;
                r102 = j3;
                QLog.e("Event.EventDBHelper", 1, "insert all PandoraEx event error", e);
                contentValues.clear();
                if (cursor != null) {
                }
                if (sQLiteDatabase != null) {
                }
                if (r102 <= 0) {
                }
            } catch (Throwable th9) {
                th = th9;
                cursor = query;
                sQLiteDatabase = readableDatabase;
                contentValues.clear();
                if (cursor != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        if (r102 <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061 A[Catch: all -> 0x006a, TryCatch #3 {, blocks: (B:4:0x0003, B:18:0x003c, B:19:0x003f, B:20:0x005d, B:32:0x0061, B:34:0x0066, B:35:0x0069, B:26:0x0057), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066 A[Catch: all -> 0x006a, TryCatch #3 {, blocks: (B:4:0x0003, B:18:0x003c, B:19:0x003f, B:20:0x005d, B:32:0x0061, B:34:0x0066, B:35:0x0069, B:26:0x0057), top: B:3:0x0003 }] */
    /* JADX WARN: Type inference failed for: r13v0, types: [ge2.a] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteClosable, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<fe2.a> e() {
        ArrayList arrayList;
        SQLiteDatabase sQLiteDatabase;
        synchronized (f402011f) {
            arrayList = new ArrayList();
            ?? r36 = 0;
            r36 = 0;
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
                    r36 = sQLiteDatabase.query("pandora_event", f402010e, null, null, null, null, null);
                    if (r36.getCount() > 0) {
                        r36.moveToFirst();
                        do {
                            arrayList.add(f(r36));
                        } while (r36.moveToNext());
                        QLog.d("Event.EventDBHelper", 1, "Table query");
                    }
                    r36.close();
                } catch (Exception e17) {
                    e = e17;
                    QLog.e("Event.EventDBHelper", 1, "Table query error: ", e);
                    if (r36 != 0) {
                        r36.close();
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
                    r36.close();
                }
                if (0 != 0) {
                    r36.close();
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
            QLog.e("Event.EventDBHelper", 1, "[getReadableDatabase] get database failed", e16);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Exception e16) {
            QLog.e("Event.EventDBHelper", 1, "[getWritableDatabase] get database failed", e16);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE pandora_event (key VARCHAR(50),event_time VARCHAR(50),info_type VARCHAR(50),info_name VARCHAR(50),info_reason VARCHAR(50),event_scene VARCHAR(50),info_desc VARCHAR(50),info_count BIGINT,action_type BIGINT,channel VARCHAR(50),PRIMARY KEY(key))");
        } catch (Exception e16) {
            QLog.e("Event.EventDBHelper", 1, "Table delete error: ", e16);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != i16) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS pandora_event");
            onCreate(sQLiteDatabase);
        }
    }
}
