package com.qzone.component.cache.database;

import android.content.Context;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DbCacheExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private volatile Context f46653a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class DbCacheError extends Error {
        public DbCacheError(Throwable th5) {
            super(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final DbCacheExceptionHandler f46654a = new DbCacheExceptionHandler();
    }

    public static DbCacheExceptionHandler b() {
        return b.f46654a;
    }

    DbCacheExceptionHandler() {
    }

    public void a(Context context) {
        this.f46653a = context != null ? context.getApplicationContext() : null;
    }

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
        c.g().c(str);
        this.f46653a.deleteDatabase(str);
        QZLog.e("DbCacheDatabase.DbCacheExceptionHandler", "deleteDatabase:" + str);
        d();
    }

    private void d() {
    }
}
