package com.tencent.mobileqq.localizeddb;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_;
    private boolean C;
    private final DatabaseErrorHandler D;

    /* renamed from: d, reason: collision with root package name */
    private final Context f241185d;

    /* renamed from: e, reason: collision with root package name */
    private final String f241186e;

    /* renamed from: f, reason: collision with root package name */
    private final SQLiteDatabase.CursorFactory f241187f;

    /* renamed from: h, reason: collision with root package name */
    private final int f241188h;

    /* renamed from: i, reason: collision with root package name */
    private SQLiteDatabase f241189i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f241190m;

    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i3, databaseErrorHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, cursorFactory, Integer.valueOf(i3), databaseErrorHandler);
            return;
        }
        this.f241185d = context;
        this.f241186e = str;
        this.f241187f = cursorFactory;
        this.f241188h = i3;
        this.D = databaseErrorHandler;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00fe A[Catch: all -> 0x018d, TryCatch #2 {all -> 0x018d, blocks: (B:16:0x0023, B:19:0x002d, B:21:0x0033, B:23:0x0054, B:26:0x005a, B:29:0x0063, B:30:0x00f3, B:32:0x00fe, B:34:0x0104, B:39:0x0120, B:46:0x0125, B:47:0x0128, B:48:0x0129, B:49:0x015a, B:50:0x015b, B:52:0x0164, B:54:0x016a, B:55:0x0187, B:58:0x006a, B:60:0x006e, B:62:0x0074, B:63:0x007a, B:66:0x0086, B:68:0x008c, B:69:0x00a5, B:72:0x00ad, B:77:0x00bf, B:78:0x018c, B:37:0x0109, B:38:0x0118, B:41:0x010d, B:43:0x0111, B:44:0x0115), top: B:15:0x0023, inners: #0, #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private SQLiteDatabase a(boolean z16) {
        SQLiteDatabase openDatabase;
        int i3;
        int version;
        SQLiteDatabase sQLiteDatabase = this.f241189i;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.f241189i = null;
            } else if (!z16 || !this.f241189i.isReadOnly()) {
                return this.f241189i;
            }
        }
        if (!this.f241190m) {
            SQLiteDatabase sQLiteDatabase2 = this.f241189i;
            try {
                this.f241190m = true;
                if (sQLiteDatabase2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LocalizedSQLiteOpenHelper", 2, "getDatabaseLocked db not null, writable: ", Boolean.valueOf(z16), ", isReadOnly: ", Boolean.valueOf(sQLiteDatabase2.isReadOnly()));
                    }
                    if (z16 && sQLiteDatabase2.isReadOnly()) {
                        try {
                            b(sQLiteDatabase2, "reopenReadWrite");
                        } catch (Exception e16) {
                            QLog.d("LocalizedSQLiteOpenHelper", 1, e16, new Object[0]);
                        }
                    }
                    onConfigure(sQLiteDatabase2);
                    version = sQLiteDatabase2.getVersion();
                    if (version != this.f241188h) {
                        if (!sQLiteDatabase2.isReadOnly()) {
                            sQLiteDatabase2.beginTransaction();
                            try {
                                if (version == 0) {
                                    onCreate(sQLiteDatabase2);
                                } else {
                                    int i16 = this.f241188h;
                                    if (version > i16) {
                                        onDowngrade(sQLiteDatabase2, version, i16);
                                    } else {
                                        onUpgrade(sQLiteDatabase2, version, i16);
                                    }
                                }
                                sQLiteDatabase2.setVersion(this.f241188h);
                                sQLiteDatabase2.setTransactionSuccessful();
                                sQLiteDatabase2.endTransaction();
                            } catch (Throwable th5) {
                                sQLiteDatabase2.endTransaction();
                                throw th5;
                            }
                        } else {
                            throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase2.getVersion() + " to " + this.f241188h + MsgSummary.STR_COLON + this.f241186e);
                        }
                    }
                    onOpen(sQLiteDatabase2);
                    if (sQLiteDatabase2.isReadOnly() && QLog.isColorLevel()) {
                        QLog.d("LocalizedSQLiteOpenHelper", 2, "Opened " + this.f241186e + " in read-only mode");
                    }
                    this.f241189i = sQLiteDatabase2;
                    this.f241190m = false;
                    return sQLiteDatabase2;
                }
                if (this.f241186e == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LocalizedSQLiteOpenHelper", 2, "getDatabaseLocked mName null");
                    }
                    openDatabase = SQLiteDatabase.openDatabase(":memory:", null, 268435472);
                } else {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("LocalizedSQLiteOpenHelper", 2, "getDatabaseLocked DEBUG_STRICT_READONLY: ", Boolean.FALSE, ", writable: ", Boolean.valueOf(z16));
                        }
                        if (this.C) {
                            i3 = 8;
                        } else {
                            i3 = 0;
                        }
                        openDatabase = this.f241185d.openOrCreateDatabase(this.f241186e, i3 | 16, this.f241187f, this.D);
                    } catch (SQLiteException e17) {
                        if (!z16) {
                            QLog.d("LocalizedSQLiteOpenHelper", 1, "Couldn't open " + this.f241186e + " for writing (will try read-only):", e17);
                            openDatabase = SQLiteDatabase.openDatabase(this.f241185d.getDatabasePath(this.f241186e).getPath(), this.f241187f, 17, this.D);
                        } else {
                            throw e17;
                        }
                    }
                }
                sQLiteDatabase2 = openDatabase;
                onConfigure(sQLiteDatabase2);
                version = sQLiteDatabase2.getVersion();
                if (version != this.f241188h) {
                }
                onOpen(sQLiteDatabase2);
                if (sQLiteDatabase2.isReadOnly()) {
                    QLog.d("LocalizedSQLiteOpenHelper", 2, "Opened " + this.f241186e + " in read-only mode");
                }
                this.f241189i = sQLiteDatabase2;
                this.f241190m = false;
                return sQLiteDatabase2;
            } catch (Throwable th6) {
                this.f241190m = false;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                throw th6;
            }
            this.f241190m = false;
            if (sQLiteDatabase2 != null && sQLiteDatabase2 != this.f241189i) {
                sQLiteDatabase2.close();
            }
            throw th6;
        }
        throw new IllegalStateException("getDatabase called recursively");
    }

    private static Object b(Object obj, String str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getMethod(str, new Class[0]);
        method.setAccessible(true);
        return method.invoke(obj, new Object[0]);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public String getDatabaseName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f241186e;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        synchronized (this) {
            a16 = a(false);
        }
        return a16;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        synchronized (this) {
            a16 = a(true);
        }
        return a16;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public abstract void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        synchronized (this) {
            if (this.C != z16) {
                SQLiteDatabase sQLiteDatabase = this.f241189i;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.f241189i.isReadOnly()) {
                    if (z16) {
                        this.f241189i.enableWriteAheadLogging();
                    } else {
                        try {
                            b(this.f241189i, "disableWriteAheadLogging");
                        } catch (Exception e16) {
                            QLog.d("LocalizedSQLiteOpenHelper", 1, e16, new Object[0]);
                        }
                    }
                }
                this.C = z16;
            }
        }
    }
}
