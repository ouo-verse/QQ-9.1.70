package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e implements com.tencent.tmassistant.common.a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f380751a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, byte[]> f380752b;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.b();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380754a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f380755b;

        b(String str, int i3) {
            this.f380754a = str;
            this.f380755b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, str, Integer.valueOf(i3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.a(this.f380754a, String.valueOf(this.f380755b), new byte[0]);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380757a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f380758b;

        c(String str, long j3) {
            this.f380757a = str;
            this.f380758b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, str, Long.valueOf(j3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.a(this.f380757a, String.valueOf(this.f380758b), new byte[0]);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380760a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f380761b;

        d(String str, String str2) {
            this.f380760a = str;
            this.f380761b = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, str, str2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.a(this.f380760a, String.valueOf(this.f380761b), new byte[0]);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.internal.storage.table.e$e, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class RunnableC10007e implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380763a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f380764b;

        RunnableC10007e(String str, byte[] bArr) {
            this.f380763a = str;
            this.f380764b = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, str, bArr);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.a(this.f380763a, "", this.f380764b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class f implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380766a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f380767b;

        f(String str, boolean z16) {
            this.f380766a = str;
            this.f380767b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, str, Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.a(this.f380766a, String.valueOf(this.f380767b), new byte[0]);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380751a = new ConcurrentHashMap();
            this.f380752b = new ConcurrentHashMap();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        if (r3 != null) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized byte[] b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (byte[]) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        l.a();
        byte[] bArr = new byte[0];
        if (this.f380752b.containsKey(str)) {
            return this.f380752b.get(str);
        }
        if (!TextUtils.isEmpty(str)) {
            com.tencent.tmassistant.common.a.c c16 = com.tencent.tmdownloader.f.b.d.a.c();
            Cursor cursor = null;
            if (c16 == null) {
                r.a("SettingTable", "<getBlob> sqliteHelper is null");
                return null;
            }
            SQLiteDatabase writableDatabase = c16.getWritableDatabase();
            if (writableDatabase == null) {
                r.a("SettingTable", "<getBlob> db is null");
                return null;
            }
            try {
                try {
                    cursor = writableDatabase.rawQuery("select * from setting_table where key = ?", new String[]{str});
                    if (cursor != null && cursor.moveToFirst()) {
                        byte[] blob = cursor.getBlob(cursor.getColumnIndexOrThrow("data"));
                        if (blob != null) {
                            try {
                                if (blob.length > 0) {
                                    this.f380752b.put(str, blob);
                                }
                            } catch (Exception unused) {
                                bArr = blob;
                            }
                        }
                        bArr = blob;
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return bArr;
    }

    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        l.a();
        try {
            return Boolean.valueOf(a(str)).booleanValue();
        } catch (Exception e16) {
            r.a("SettingTable", "<getBoolean> error, e = " + e16.getMessage() + ",process:" + l.a());
            return false;
        }
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String createTableSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "CREATE TABLE if not exists setting_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,value TEXT,data BLOB);";
    }

    public int d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).intValue();
        }
        l.a();
        try {
            return Integer.valueOf(a(str)).intValue();
        } catch (Exception e16) {
            r.a("SettingTable", "<getInt> error, e = " + e16.getMessage() + ",process:" + l.a());
            return 0;
        }
    }

    public long e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).longValue();
        }
        l.a();
        try {
            return Long.valueOf(a(str)).longValue();
        } catch (Exception e16) {
            r.a("SettingTable", "<getLong> error, e = " + e16.getMessage() + ",process:" + l.a());
            return 0L;
        }
    }

    public String f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        l.a();
        try {
            return a(str);
        } catch (Exception e16) {
            r.a("SettingTable", "<getString> error, e = " + e16.getMessage() + ",process:" + l.a());
            return "";
        }
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String[] getAlterSQL(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String[]) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return new String[0];
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String tableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "setting_table";
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (l.e()) {
            l.a();
            com.tencent.tmassistantbase.util.e.a().postDelayed(new a(), 1000L);
        }
    }

    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
            return;
        }
        String.valueOf(i3);
        l.a();
        com.tencent.tmassistantbase.util.e.a().post(new b(str, i3));
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3));
            return;
        }
        String.valueOf(j3);
        l.a();
        com.tencent.tmassistantbase.util.e.a().post(new c(str, j3));
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            l.a();
            com.tencent.tmassistantbase.util.e.a().post(new d(str, str2));
        }
    }

    public void a(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        int length = bArr.length;
        l.a();
        com.tencent.tmassistantbase.util.e.a().post(new RunnableC10007e(str, bArr));
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            return;
        }
        String.valueOf(z16);
        l.a();
        com.tencent.tmassistantbase.util.e.a().post(new f(str, z16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        if (r4 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
    
        if (r4 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        String str2 = "";
        if (this.f380751a.containsKey(str)) {
            return this.f380751a.get(str);
        }
        System.currentTimeMillis();
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                com.tencent.tmassistant.common.a.c c16 = com.tencent.tmdownloader.f.b.d.a.c();
                if (c16 == null) {
                    r.a("SettingTable", "<get> sqliteHelper is null");
                    return "";
                }
                SQLiteDatabase writableDatabase = c16.getWritableDatabase();
                if (writableDatabase == null) {
                    r.a("SettingTable", "<get> db is null");
                    return "";
                }
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.rawQuery("select * from setting_table where key = ?", new String[]{str});
                    if (cursor != null && cursor.moveToFirst() && (str2 = cursor.getString(cursor.getColumnIndexOrThrow("value"))) != null) {
                        this.f380751a.put(str, str2);
                    }
                } catch (Exception unused) {
                } catch (Throwable th5) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th5;
                }
            }
            System.currentTimeMillis();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        if (r1.moveToFirst() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r0 = r1.getString(r1.getColumnIndexOrThrow("key"));
        r2 = r1.getString(r1.getColumnIndexOrThrow("value"));
        r3 = r1.getBlob(r1.getColumnIndexOrThrow("data"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        r4 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        if (r1 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0087, code lost:
    
        if (r1 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b() {
        Cursor cursor;
        String string;
        String string2;
        byte[] blob;
        com.tencent.tmassistant.common.a.c c16 = com.tencent.tmdownloader.f.b.d.a.c();
        if (c16 == null) {
            r.a("SettingTable", "<initCache> sqliteHelper is null");
            return;
        }
        SQLiteDatabase writableDatabase = c16.getWritableDatabase();
        if (writableDatabase == null) {
            r.a("SettingTable", "<initCache> db is null");
            return;
        }
        cursor = null;
        try {
            try {
                cursor = writableDatabase.rawQuery("select * from setting_table", null);
                if (cursor != null) {
                }
            } catch (Exception e16) {
                r.a("SettingTable", "initCache exception: ", e16);
                e16.printStackTrace();
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
        if (!TextUtils.isEmpty(string2)) {
            this.f380751a.put(string, string2);
        }
        if (blob != null && blob.length > 0) {
            this.f380752b.put(string, blob);
        }
        if (!cursor.moveToNext()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            r.a("SettingTable", "key should not be empty!!");
            return;
        }
        System.currentTimeMillis();
        this.f380751a.put(str, str2);
        if (bArr != null && bArr.length > 0) {
            this.f380752b.put(str, bArr);
        }
        com.tencent.tmassistant.common.a.c c16 = com.tencent.tmdownloader.f.b.d.a.c();
        if (c16 == null) {
            r.a("SettingTable", "<commonInsert> sqliteHelper is null");
            return;
        }
        SQLiteDatabase writableDatabase = c16.getWritableDatabase();
        try {
        } catch (Exception unused) {
            r.a("SettingTable", "<commonInsert> end transaction error");
        }
        if (writableDatabase == null) {
            r.a("SettingTable", "<commonInsert> db is null");
            return;
        }
        try {
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", str);
                contentValues.put("value", str2);
                contentValues.put("data", bArr);
                writableDatabase.delete("setting_table", "key=?", new String[]{str});
                writableDatabase.insert("setting_table", null, contentValues);
                contentValues.clear();
                writableDatabase.setTransactionSuccessful();
            } finally {
            }
        } catch (Exception e16) {
            e16.getMessage();
            if (writableDatabase.isOpen() && writableDatabase.inTransaction()) {
                writableDatabase.endTransaction();
            }
        }
        if (writableDatabase.isOpen() && writableDatabase.inTransaction()) {
            writableDatabase.endTransaction();
        }
        System.currentTimeMillis();
    }
}
