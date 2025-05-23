package com.qzone.component.cache.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends SQLiteOpenHelper {
    public static volatile boolean E = false;
    public static volatile int F = 1;
    private static final HashMap<String, b> G = new HashMap<>();
    private final int C;
    private final e D;

    /* renamed from: d, reason: collision with root package name */
    private final String f46660d;

    /* renamed from: e, reason: collision with root package name */
    private final HashSet<Integer> f46661e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f46662f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f46663h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f46664i;

    /* renamed from: m, reason: collision with root package name */
    private int f46665m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements DatabaseErrorHandler {

        /* renamed from: a, reason: collision with root package name */
        DatabaseErrorHandler f46666a = new DefaultDatabaseErrorHandler();

        a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            this.f46666a.onCorruption(sQLiteDatabase);
            QLog.e("DbCacheDatabase", 1, "onCorruption:" + sQLiteDatabase);
        }
    }

    public static synchronized b h(Context context, String str, int i3, int i16) {
        b bVar;
        synchronized (b.class) {
            HashMap<String, b> hashMap = G;
            bVar = hashMap.get(str);
            if (bVar == null) {
                bVar = new b(context, str, null, i3, i16, new a());
                hashMap.put(str, bVar);
            }
        }
        return bVar;
    }

    private void j(Throwable th5) {
        try {
            DbCacheExceptionHandler.b().c(th5, this.f46660d);
        } catch (Throwable th6) {
            QZLog.e("DbCacheDatabase", "handleException error", th6);
        }
    }

    private void k(SQLiteDatabase sQLiteDatabase) {
        Method method;
        try {
            Field declaredField = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
            declaredField.setAccessible(true);
            QZLog.i("DbCacheDatabase", 1, "[DB]" + this.f46660d + " set mConfigurationLocked setAccessible");
            Object obj = declaredField.get(sQLiteDatabase);
            Field declaredField2 = obj.getClass().getDeclaredField("maxSqlCacheSize");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, 150);
            QZLog.i("DbCacheDatabase", 1, "[DB]" + this.f46660d + " set mConfigurationLocked maxSqlCacheSize success");
            Field declaredField3 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(sQLiteDatabase);
            Method[] declaredMethods = obj2.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i3];
                if (TextUtils.equals(method.getName(), "reconfigure")) {
                    break;
                } else {
                    i3++;
                }
            }
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj2, obj);
                QZLog.i("DbCacheDatabase", 1, "[DB]" + this.f46660d + " LRU MAX SIZE = " + obj.getClass().getDeclaredField("maxSqlCacheSize").getInt(obj));
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("DbCacheDatabase", 2, "[DB]" + this.f46660d + " not find reconfigure()");
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | InvocationTargetException e16) {
            e16.printStackTrace();
            if (QZLog.isColorLevel()) {
                QZLog.w("DbCacheDatabase", "[DB]" + this.f46660d + "  onOpen", e16);
            }
        }
    }

    public void a(int i3) {
        synchronized (this) {
            if (this.f46661e.add(Integer.valueOf(i3))) {
                this.f46665m++;
            }
            QZLog.i("DbCacheDatabase", "[DB]" + this.f46660d + "  attach sessionId:" + i3 + "mAttachCount:" + this.f46665m);
        }
    }

    public void d() {
        this.f46662f.deleteDatabase(this.f46660d);
        QZLog.e("DbCacheDatabase", 1, "detele db:", this.f46660d);
    }

    public void e(int i3) {
        boolean z16;
        synchronized (this) {
            z16 = false;
            if (this.f46661e.remove(Integer.valueOf(i3))) {
                int i16 = this.f46665m - 1;
                this.f46665m = i16;
                if (i16 == 0) {
                    z16 = true;
                }
            }
            QZLog.i("DbCacheDatabase", "[DB]" + this.f46660d + "  detach sessionId:" + i3 + "mAttachCount:" + this.f46665m);
        }
        if (z16 && this.f46664i) {
            QZLog.i("DbCacheDatabase", "[DB] close " + this.f46660d + ",mAttachCount:" + this.f46665m);
            close();
        }
    }

    protected void finalize() throws Throwable {
        try {
            try {
                close();
            } catch (Exception e16) {
                QZLog.e("DbCacheDatabase", "close error", e16);
            }
        } finally {
            super.finalize();
        }
    }

    public e g() {
        return this.D;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0048  */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SQLiteDatabase i(boolean z16) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase readableDatabase;
        synchronized (this) {
            try {
                try {
                    if (z16 != 0) {
                        sQLiteDatabase = getWritableDatabase();
                    } else {
                        sQLiteDatabase = getReadableDatabase();
                    }
                } catch (Throwable unused) {
                    d();
                    try {
                        if (z16 != 0) {
                            z16 = getWritableDatabase();
                        } else {
                            z16 = getReadableDatabase();
                        }
                    } catch (Throwable th5) {
                        j(th5);
                        z16 = 0;
                        sQLiteDatabase = z16;
                        if (this.f46663h) {
                            this.f46663h = false;
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.enableWriteAheadLogging();
                            } catch (Throwable th6) {
                                E = false;
                                j(th6);
                            }
                        }
                        return sQLiteDatabase;
                    }
                    sQLiteDatabase = z16;
                    if (this.f46663h) {
                    }
                }
                if (this.f46663h) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    d();
                    try {
                        if (z16 != 0) {
                            readableDatabase = getWritableDatabase();
                        } else {
                            readableDatabase = getReadableDatabase();
                        }
                        sQLiteDatabase = readableDatabase;
                    } catch (Throwable th7) {
                        j(th7);
                    }
                    this.f46663h = false;
                }
                if (sQLiteDatabase != null && E) {
                    sQLiteDatabase.enableWriteAheadLogging();
                }
            } catch (Throwable th8) {
                if (this.f46663h) {
                    d();
                    try {
                        if (z16 != 0) {
                            getWritableDatabase();
                        } else {
                            getReadableDatabase();
                        }
                    } catch (Throwable th9) {
                        j(th9);
                    }
                    this.f46663h = false;
                }
                throw th8;
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        if (MobileQQ.sProcessId == 2) {
            super.onConfigure(sQLiteDatabase);
            if (this.C == 1) {
                QZLog.e(QZLog.TO_DEVICE_TAG, "PRAGMA synchronous=OFF executed");
                sQLiteDatabase.execSQL("PRAGMA synchronous=OFF");
                if (sQLiteDatabase.getPageSize() < 8192) {
                    sQLiteDatabase.execSQL("PRAGMA page_size=8192");
                    sQLiteDatabase.execSQL("VACUUM");
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "DbCacheDatabase onDowngrade oldVersion:" + i3 + ",newVersion=" + i16);
        this.f46663h = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (QZLog.isColorLevel()) {
            QZLog.i("DbCacheDatabase", 2, "[DB]" + this.f46660d + " onOpen");
        }
        QZLog.i("DbCacheDatabase", 1, "[DB]" + this.f46660d + " sMaxSQLSizeInitStrategy:" + F);
        if (F == 1) {
            l(sQLiteDatabase);
        } else if (F == 2) {
            k(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "DbCacheDatabase onUpgrade oldVersion:" + i3 + ",newVersion=" + i16);
        this.f46663h = true;
    }

    private void l(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.setMaxSqlCacheSize(100);
        } catch (Throwable th5) {
            QZLog.i("DbCacheDatabase", 1, th5.getMessage(), th5);
        }
    }

    protected b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3, int i16, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i3, databaseErrorHandler);
        this.f46661e = new HashSet<>();
        this.f46663h = false;
        this.f46664i = true;
        this.f46665m = 0;
        this.f46660d = str;
        this.f46662f = context;
        this.C = i16;
        this.D = new e(i(false));
        E = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SQL_ENABLE_WAL, true);
        F = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SQL_ENABLE_WAL, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }
}
