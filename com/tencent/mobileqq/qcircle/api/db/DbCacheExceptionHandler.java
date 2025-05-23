package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DbCacheExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private volatile Context f261634a;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static final class DbCacheError extends Error {
        public DbCacheError(Throwable th5) {
            super(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final DbCacheExceptionHandler f261635a = new DbCacheExceptionHandler();
    }

    public static DbCacheExceptionHandler b() {
        return b.f261635a;
    }

    public void a(Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.f261634a = context2;
    }

    @SuppressLint({"InlinedApi"})
    public void c(Throwable th5, String str) {
        if (th5 == null) {
            return;
        }
        if (!(th5 instanceof SQLiteDiskIOException) && !(th5 instanceof SQLiteDatabaseCorruptException) && !(th5 instanceof SQLiteFullException) && !(th5 instanceof SQLiteCantOpenDatabaseException) && !(th5 instanceof SQLiteAccessPermException) && !(th5 instanceof DbCacheSQLiteException) && (!(th5 instanceof SQLiteException) || !th5.getMessage().contains("no such table"))) {
            if (th5 instanceof RuntimeException) {
                throw ((RuntimeException) th5);
            }
            throw new DbCacheError(th5);
        }
        com.tencent.mobileqq.qcircle.api.db.b.g().c(str);
        this.f261634a.deleteDatabase(str);
        QLog.e("QCircleDbCacheDatabase.DbCacheExceptionHandler", 1, "deleteDatabase:" + str);
        d();
    }

    DbCacheExceptionHandler() {
    }

    private void d() {
    }
}
