package com.tencent.halley.common.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f113399a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f113400b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, f> f113401c;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f113402a;

        /* renamed from: b, reason: collision with root package name */
        public String f113403b;

        /* renamed from: c, reason: collision with root package name */
        public String f113404c;

        public a(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str);
                return;
            }
            this.f113404c = "add";
            this.f113402a = j3;
            this.f113403b = str;
        }

        public a(long j3, String str, String str2) {
            this(j3, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f113404c = str2;
            } else {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11678);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f113399a = new Object();
        f113400b = null;
        f113401c = new ConcurrentHashMap();
    }

    f(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    private int a(boolean z16, boolean z17) {
        StringBuilder sb5;
        Cursor query;
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (z16 && z17) {
                query = writableDatabase.query("halley_action_tbl", new String[]{"key"}, null, null, null, null, null);
            } else {
                query = z16 ? writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"add"}, null, null, null) : writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"remove"}, null, null, null);
            }
            cursor = query;
            r7 = cursor != null ? cursor.getCount() : 0;
            if (cursor != null) {
                cursor.close();
            }
            sb5 = new StringBuilder("queryRecordCount add:");
            sb5.append(z16);
            sb5.append(", remove:");
            sb5.append(z17);
            sb5.append(",count:");
            sb5.append(r7);
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                sb5 = new StringBuilder("queryRecordCount add:");
                sb5.append(z16);
                sb5.append(", remove:");
                sb5.append(z17);
                sb5.append(",count:0");
            } catch (Throwable th6) {
                if (cursor != null) {
                    cursor.close();
                }
                com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "queryRecordCount add:" + z16 + ", remove:" + z17 + ",count:0");
                throw th6;
            }
        }
        com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", sb5.toString());
        return r7;
    }

    private static void c(String str) {
        com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "print msg db on:".concat(String.valueOf(str)));
    }

    public final long b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).longValue();
        }
        com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "insertRecord:".concat(String.valueOf(str)));
        c("insertRecord start");
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", str);
            contentValues.put("state", "add");
            return writableDatabase.insert("halley_action_tbl", null, contentValues);
        } catch (Exception e16) {
            com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "insertRecord failed.", e16);
            return -1L;
        } finally {
            c("insertRecord end");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
        } else {
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sQLiteDatabase);
            return;
        }
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            com.tencent.halley.common.utils.d.c("halley-cloud-HalleyActionDB", "onOpen, old version:" + version + ", cur version:2");
            if (version < 2) {
                onUpgrade(sQLiteDatabase, version, 2);
            } else if (version > 2) {
                onDowngrade(sQLiteDatabase, version, 2);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static f a(String str) {
        if (f113400b == null) {
            synchronized (f.class) {
                if (f113400b == null) {
                    f113400b = new f(com.tencent.halley.common.a.a(), "HalleyAction_" + com.tencent.halley.common.a.c() + (com.tencent.halley.common.a.b() ? "_test_" : "_") + com.tencent.halley.common.a.g() + "_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX);
                }
            }
        }
        return f113400b;
    }

    public final List<a> b(int i3) {
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().query("halley_action_tbl", null, "state=?", new String[]{"add"}, null, null, null);
            if (cursor != null) {
                int count = cursor.getCount();
                com.tencent.halley.common.utils.d.a("halley-cloud-HalleyActionDB", "current new record num in db:" + count + ",maxNum:" + i3);
                int min = Math.min(count, i3);
                if (cursor.moveToFirst()) {
                    int i16 = 0;
                    do {
                        arrayList.add(new a(cursor.getLong(cursor.getColumnIndex("key")), cursor.getString(cursor.getColumnIndex("data")), cursor.getString(cursor.getColumnIndex("state"))));
                        i16++;
                        if (i16 >= min) {
                            break;
                        }
                    } while (cursor.moveToNext());
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            sb5 = new StringBuilder("queryRecords maxNum:");
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                sb5 = new StringBuilder("queryRecords maxNum:");
            } catch (Throwable th6) {
                if (cursor != null) {
                    cursor.close();
                }
                com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "queryRecords maxNum:" + i3 + ",ret Count:" + arrayList.size());
                throw th6;
            }
        }
        sb5.append(i3);
        sb5.append(",ret Count:");
        sb5.append(arrayList.size());
        com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", sb5.toString());
        return arrayList;
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        com.tencent.halley.common.utils.d.c("halley-cloud-HalleyActionDB", "dropTable");
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
        } catch (SQLException unused) {
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            com.tencent.halley.common.utils.d.c("halley-cloud-HalleyActionDB", "db created.");
        } catch (SQLException e16) {
            throw e16;
        }
    }

    public final void a(List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        if (list.size() <= 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "remove");
            c("deleteRecords update start");
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                writableDatabase.update("halley_action_tbl", contentValues, "key=?", new String[]{String.valueOf(longValue)});
                com.tencent.halley.common.utils.d.a("halley-cloud-HalleyActionDB", "update record key:" + longValue + " state to remove");
            }
            c("deleteRecords update end");
            Iterator<Long> it5 = list.iterator();
            while (it5.hasNext()) {
                long longValue2 = it5.next().longValue();
                com.tencent.halley.common.utils.d.a("halley-cloud-HalleyActionDB", "delete record num:" + writableDatabase.delete("halley_action_tbl", "key=?", new String[]{String.valueOf(longValue2)}) + ",id:" + longValue2);
            }
            c("deleteRecords delete end");
            int a16 = a(false, true);
            if (a16 > 0) {
                com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "remove fail, removeNum:".concat(String.valueOf(a16)));
                if (a(true, false) <= 0) {
                    a(writableDatabase);
                    b(writableDatabase);
                }
            }
        } catch (Exception e16) {
            com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "deleteRecords failed.", e16);
        }
    }

    public final boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (a(true, true) <= i3) {
            return false;
        }
        try {
            getWritableDatabase().delete("halley_action_tbl", null, null);
            return true;
        } catch (Exception e16) {
            com.tencent.halley.common.utils.d.b("halley-cloud-HalleyActionDB", "clearOverCount failed.", e16);
            if (a(true, true) <= i3) {
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                a(writableDatabase);
                b(writableDatabase);
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
