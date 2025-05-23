package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.TargetApi;
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

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends SQLiteOpenHelper implements Sessional {
    private static boolean D = true;
    public static volatile boolean E = false;
    public static volatile int F = 1;
    private static HashMap<String, a> G = new HashMap<>();
    private wd2.a C;

    /* renamed from: d, reason: collision with root package name */
    private String f261641d;

    /* renamed from: e, reason: collision with root package name */
    private HashSet<Integer> f261642e;

    /* renamed from: f, reason: collision with root package name */
    private Context f261643f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f261644h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f261645i;

    /* renamed from: m, reason: collision with root package name */
    private int f261646m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qcircle.api.db.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8279a implements DatabaseErrorHandler {

        /* renamed from: a, reason: collision with root package name */
        DatabaseErrorHandler f261647a = new DefaultDatabaseErrorHandler();

        C8279a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            this.f261647a.onCorruption(sQLiteDatabase);
            QLog.e("QCircleDbCacheDatabase", 1, 1, "onCorruption:" + sQLiteDatabase);
        }
    }

    @TargetApi(11)
    protected a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3, int i16, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i3, databaseErrorHandler);
        this.f261642e = new HashSet<>();
        this.f261643f = null;
        this.f261644h = false;
        this.f261645i = true;
        this.f261646m = 0;
        this.f261641d = str;
        this.f261643f = context;
        this.C = new wd2.a(f(false));
        E = uq3.c.W0("QZoneSetting", QzoneConfig.SECONDARY_SQL_ENABLE_WAL, Boolean.valueOf(D)).booleanValue();
        F = uq3.c.X0("QZoneSetting", "secondary_sql_set_max_sql_cacle_size", 1).intValue();
    }

    public static synchronized a e(Context context, String str, int i3, int i16) {
        a aVar;
        synchronized (a.class) {
            aVar = G.get(str);
            if (aVar == null) {
                aVar = new a(context, str, null, i3, i16, new C8279a());
                G.put(str, aVar);
            }
        }
        return aVar;
    }

    private void g(Throwable th5) {
        try {
            DbCacheExceptionHandler.b().c(th5, this.f261641d);
        } catch (Throwable th6) {
            QLog.e("QCircleDbCacheDatabase", 1, "handleException error", th6);
        }
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        Method method;
        try {
            Field declaredField = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
            declaredField.setAccessible(true);
            QLog.i("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + " set mConfigurationLocked setAccessible");
            Object obj = declaredField.get(sQLiteDatabase);
            Field declaredField2 = obj.getClass().getDeclaredField("maxSqlCacheSize");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, 150);
            QLog.i("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + " set mConfigurationLocked maxSqlCacheSize success");
            Field declaredField3 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(sQLiteDatabase);
            Method[] declaredMethods = obj2.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    method = declaredMethods[i3];
                    if (TextUtils.equals(method.getName(), "reconfigure")) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    method = null;
                    break;
                }
            }
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj2, obj);
                QLog.i("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + " LRU MAX SIZE = " + obj.getClass().getDeclaredField("maxSqlCacheSize").getInt(obj));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QCircleDbCacheDatabase", 2, "[DB]" + this.f261641d + " not find reconfigure()");
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + "  onOpen" + e16.getMessage());
            }
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + "  onOpen" + e17.getMessage());
            }
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + "  onOpen" + e18.getMessage());
            }
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + "  onOpen" + e19.getMessage());
            }
        }
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.setMaxSqlCacheSize(100);
        } catch (Throwable th5) {
            QLog.i("QCircleDbCacheDatabase", 1, th5.getMessage(), th5);
        }
    }

    public void a() {
        this.f261643f.deleteDatabase(this.f261641d);
        QLog.e("QCircleDbCacheDatabase", 1, 1, "detele db:", this.f261641d);
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.Sessional
    public void attach(int i3) {
        synchronized (this) {
            if (this.f261642e.add(Integer.valueOf(i3))) {
                this.f261646m++;
            }
            QLog.i("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + "  attach sessionId:" + i3 + "mAttachCount:" + this.f261646m);
        }
    }

    public wd2.a d() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.Sessional
    public void detach(int i3) {
        boolean z16;
        synchronized (this) {
            z16 = false;
            if (this.f261642e.remove(Integer.valueOf(i3))) {
                int i16 = this.f261646m - 1;
                this.f261646m = i16;
                if (i16 == 0) {
                    z16 = true;
                }
            }
            QLog.i("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + "  detach sessionId:" + i3 + "mAttachCount:" + this.f261646m);
        }
        if (z16 && this.f261645i) {
            QLog.i("QCircleDbCacheDatabase", 1, "[DB] close " + this.f261641d + ",mAttachCount:" + this.f261646m);
            close();
        }
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
    public SQLiteDatabase f(boolean z16) {
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
                    a();
                    try {
                        if (z16 != 0) {
                            z16 = getWritableDatabase();
                        } else {
                            z16 = getReadableDatabase();
                        }
                    } catch (Throwable th5) {
                        g(th5);
                        z16 = 0;
                        sQLiteDatabase = z16;
                        if (this.f261644h) {
                            this.f261644h = false;
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.enableWriteAheadLogging();
                            } catch (Throwable th6) {
                                E = false;
                                g(th6);
                            }
                        }
                        return sQLiteDatabase;
                    }
                    sQLiteDatabase = z16;
                    if (this.f261644h) {
                    }
                }
                if (this.f261644h) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    a();
                    try {
                        if (z16 != 0) {
                            readableDatabase = getWritableDatabase();
                        } else {
                            readableDatabase = getReadableDatabase();
                        }
                        sQLiteDatabase = readableDatabase;
                    } catch (Throwable th7) {
                        g(th7);
                    }
                    this.f261644h = false;
                }
                if (sQLiteDatabase != null && E) {
                    sQLiteDatabase.enableWriteAheadLogging();
                }
            } catch (Throwable th8) {
                if (this.f261644h) {
                    a();
                    try {
                        if (z16 != 0) {
                            getWritableDatabase();
                        } else {
                            getReadableDatabase();
                        }
                    } catch (Throwable th9) {
                        g(th9);
                    }
                    this.f261644h = false;
                }
                throw th8;
            }
        }
        return sQLiteDatabase;
    }

    protected void finalize() throws Throwable {
        try {
            try {
                close();
            } catch (Exception e16) {
                QLog.e("QCircleDbCacheDatabase", 1, "close error", e16);
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QLog.i("QCircleDbCacheDatabase", 1, "DbCacheDatabase onDowngrade oldVersion:" + i3 + ",newVersion=" + i16);
        this.f261644h = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (QLog.isColorLevel()) {
            QLog.i("QCircleDbCacheDatabase", 2, "[DB]" + this.f261641d + " onOpen");
        }
        QZLog.i("QCircleDbCacheDatabase", 1, "[DB]" + this.f261641d + " sMaxSQLSizeInitStrategy:" + F);
        if (F == 1) {
            i(sQLiteDatabase);
        } else if (F == 2) {
            h(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QLog.i("QCircleDbCacheDatabase", 1, "DbCacheDatabase onUpgrade oldVersion:" + i3 + ",newVersion=" + i16);
        this.f261644h = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }
}
