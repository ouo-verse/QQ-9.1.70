package com.tencent.qmethod.monitor.report.base.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mr3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rJ \u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ \u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/db/b;", "", "", "table", "whereClause", "", "whereArgs", "", "d", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I", "", h.F, "Lcom/tencent/qmethod/monitor/report/base/db/a;", "Lkotlin/Function0;", "block", "g", "i", "e", "", "id", "status", "k", "", "overTime", "f", "Landroid/database/sqlite/SQLiteDatabase;", "a", "Landroid/database/sqlite/SQLiteDatabase;", "database", "Lcom/tencent/qmethod/monitor/report/base/db/c;", "b", "Lcom/tencent/qmethod/monitor/report/base/db/c;", "getDbHelper", "()Lcom/tencent/qmethod/monitor/report/base/db/c;", "j", "(Lcom/tencent/qmethod/monitor/report/base/db/c;)V", "dbHelper", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private static final ArrayList<a.Companion> f343820c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f343821d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private SQLiteDatabase database;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c dbHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/db/b$a;", "", "Lcom/tencent/qmethod/monitor/report/base/db/c;", "dbHelper", "Lcom/tencent/qmethod/monitor/report/base/db/b;", "a", "", "DB_ERROR", "I", "DB_NO_OPEN", "Ljava/util/ArrayList;", "Lmr3/a$a;", "Lkotlin/collections/ArrayList;", "TABLES", "Ljava/util/ArrayList;", "", "TAG", "Ljava/lang/String;", "handler", "Lcom/tencent/qmethod/monitor/report/base/db/b;", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.report.base.db.b$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final b a(@NotNull c dbHelper) {
            Intrinsics.checkParameterIsNotNull(dbHelper, "dbHelper");
            b bVar = b.f343821d;
            if (bVar == null) {
                synchronized (this) {
                    bVar = b.f343821d;
                    if (bVar == null) {
                        bVar = new b(null);
                        b.f343821d = bVar;
                        bVar.j(dbHelper);
                        bVar.h();
                    }
                }
            }
            return bVar;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ArrayList<a.Companion> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(mr3.a.INSTANCE);
        f343820c = arrayListOf;
    }

    b() {
    }

    private final int d(String table, String whereClause, String[] whereArgs) {
        SQLiteDatabase sQLiteDatabase;
        if (this.database != null && ((sQLiteDatabase = this.database) == null || sQLiteDatabase.isOpen())) {
            try {
                SQLiteDatabase sQLiteDatabase2 = this.database;
                if (sQLiteDatabase2 != null) {
                    return sQLiteDatabase2.delete(table, whereClause, whereArgs);
                }
                return 0;
            } catch (Exception e16) {
                o.d("DBHandler", "sql", e16);
                return -1;
            }
        }
        return -2;
    }

    @Nullable
    public final Object e(@NotNull a table, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(table, "table");
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (this.database != null) {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase != null && !sQLiteDatabase.isOpen()) {
                return null;
            }
            try {
                SQLiteDatabase sQLiteDatabase2 = this.database;
                if (sQLiteDatabase2 == null) {
                    return null;
                }
                return table.a(sQLiteDatabase2, block);
            } catch (Exception e16) {
                o.d("DBHandler", "sqlSearch", e16);
                return null;
            }
        }
        return null;
    }

    public final int f(@NotNull String table, boolean overTime) {
        Intrinsics.checkParameterIsNotNull(table, "table");
        if (overTime) {
            return d(table, "status=? OR occur_time<?", new String[]{String.valueOf(DBDataStatus.SENT.getValue()), String.valueOf(System.currentTimeMillis() - 259200000)});
        }
        return d(table, "status=?", new String[]{String.valueOf(DBDataStatus.SENT.getValue())});
    }

    public final int g(@NotNull a table, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(table, "table");
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (this.database != null) {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase != null && !sQLiteDatabase.isOpen()) {
                return -2;
            }
            try {
                SQLiteDatabase sQLiteDatabase2 = this.database;
                if (sQLiteDatabase2 == null) {
                    return -2;
                }
                return table.b(sQLiteDatabase2, block);
            } catch (Exception e16) {
                o.d("DBHandler", "sql", e16);
                return -1;
            }
        }
        return -2;
    }

    public final void h() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.database;
        if (sQLiteDatabase2 == null || (sQLiteDatabase2 != null && !sQLiteDatabase2.isOpen())) {
            try {
                c cVar = this.dbHelper;
                if (cVar != null) {
                    sQLiteDatabase = cVar.getWritableDatabase();
                } else {
                    sQLiteDatabase = null;
                }
                this.database = sQLiteDatabase;
            } catch (SQLiteException e16) {
                o.d("DBHandler", "open", e16);
            }
        }
    }

    @Nullable
    public final Object i(@NotNull a table, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(table, "table");
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (this.database != null) {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase != null && !sQLiteDatabase.isOpen()) {
                return null;
            }
            try {
                SQLiteDatabase sQLiteDatabase2 = this.database;
                if (sQLiteDatabase2 == null) {
                    return null;
                }
                return table.c(sQLiteDatabase2, block);
            } catch (Exception e16) {
                o.d("DBHandler", "sqlSearch", e16);
                return null;
            }
        }
        return null;
    }

    public final void j(@Nullable c cVar) {
        this.dbHelper = cVar;
    }

    public final int k(@NotNull String table, long id5, int status) {
        SQLiteDatabase sQLiteDatabase;
        int i3;
        Intrinsics.checkParameterIsNotNull(table, "table");
        if (this.database != null && ((sQLiteDatabase = this.database) == null || sQLiteDatabase.isOpen())) {
            try {
                if (status != DBDataStatus.TO_SEND.getValue() && status != DBDataStatus.SENT.getValue()) {
                    return -1;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(status));
                SQLiteDatabase sQLiteDatabase2 = this.database;
                if (sQLiteDatabase2 != null) {
                    i3 = sQLiteDatabase2.update(table, contentValues, "_id=" + id5, null);
                } else {
                    i3 = 0;
                }
                return i3;
            } catch (Exception e16) {
                o.d("DBHandler", "sql", e16);
                return -1;
            }
        }
        return -2;
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
