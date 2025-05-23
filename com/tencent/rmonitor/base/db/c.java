package com.tencent.rmonitor.base.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rmonitor.base.db.table.AttaEventTable;
import com.tencent.rmonitor.base.db.table.TrafficInfoTable;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00042\u00020\u0001:\u0001)B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J \u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J/\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013J{\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0006\u001a\u00020\f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b \u0010!J\u001e\u0010%\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\bJ\u0016\u0010'\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0019R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/rmonitor/base/db/c;", "", "", "i", "e", "Lcom/tencent/rmonitor/base/db/b;", "table", "Lkotlin/Function0;", "", "block", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "whereClause", "", "whereArgs", "f", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I", "nullColumnHack", "Landroid/content/ContentValues;", "contentValues", "l", "columns", "selection", "selectionArgs", "", "distinct", "groupBy", "having", "orderBy", "limit", "Landroid/database/Cursor;", "j", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "", "id", "status", "o", "overTime", "g", "Landroid/database/sqlite/SQLiteDatabase;", "a", "Landroid/database/sqlite/SQLiteDatabase;", "database", "Lcom/tencent/rmonitor/base/db/d;", "b", "Lcom/tencent/rmonitor/base/db/d;", "getDbHelper", "()Lcom/tencent/rmonitor/base/db/d;", DomainData.DOMAIN_NAME, "(Lcom/tencent/rmonitor/base/db/d;)V", "dbHelper", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ArrayList<String> f365366c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile c f365367d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private SQLiteDatabase database;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d dbHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rmonitor/base/db/c$a;", "", "Lcom/tencent/rmonitor/base/db/d;", "dbHelper", "Lcom/tencent/rmonitor/base/db/c;", "a", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "TABLES", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "", "DB_ERROR", "I", "DB_NO_OPEN", "TAG", "Ljava/lang/String;", "handler", "Lcom/tencent/rmonitor/base/db/c;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final c a(@NotNull d dbHelper) {
            Intrinsics.checkParameterIsNotNull(dbHelper, "dbHelper");
            c cVar = c.f365367d;
            if (cVar == null) {
                synchronized (this) {
                    cVar = c.f365367d;
                    if (cVar == null) {
                        cVar = new c(null);
                        c.f365367d = cVar;
                        cVar.n(dbHelper);
                        cVar.i();
                    }
                }
            }
            return cVar;
        }

        @NotNull
        public final ArrayList<String> b() {
            return c.f365366c;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.rmonitor.base.db.table.a.INSTANCE.a(), com.tencent.rmonitor.base.db.table.c.INSTANCE.a(), AttaEventTable.INSTANCE.b(), TrafficInfoTable.INSTANCE.b(), com.tencent.rmonitor.base.db.table.b.INSTANCE.a());
        f365366c = arrayListOf;
    }

    c() {
    }

    public static /* synthetic */ Cursor k(c cVar, String str, String[] strArr, String str2, String[] strArr2, boolean z16, String str3, String str4, String str5, String str6, int i3, Object obj) {
        boolean z17;
        String str7;
        String str8;
        String str9;
        String str10;
        if ((i3 & 16) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        if ((i3 & 32) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i3 & 64) != 0) {
            str8 = null;
        } else {
            str8 = str4;
        }
        if ((i3 & 128) != 0) {
            str9 = null;
        } else {
            str9 = str5;
        }
        if ((i3 & 256) != 0) {
            str10 = null;
        } else {
            str10 = str6;
        }
        return cVar.j(str, strArr, str2, strArr2, z17, str7, str8, str9, str10);
    }

    public final void e() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            sQLiteDatabase.close();
            f365367d = null;
        }
    }

    public final int f(@NotNull String table, @Nullable String whereClause, @Nullable String[] whereArgs) {
        SQLiteDatabase sQLiteDatabase;
        Intrinsics.checkParameterIsNotNull(table, "table");
        if (this.database != null && ((sQLiteDatabase = this.database) == null || sQLiteDatabase.isOpen())) {
            try {
                SQLiteDatabase sQLiteDatabase2 = this.database;
                if (sQLiteDatabase2 != null) {
                    return sQLiteDatabase2.delete(table, whereClause, whereArgs);
                }
                return 0;
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_db_persist_DBHandler", e16);
                return -1;
            }
        }
        return -2;
    }

    public final int g(@NotNull String table, boolean overTime) {
        Intrinsics.checkParameterIsNotNull(table, "table");
        if (overTime) {
            return f(table, "status=? OR occur_time<?", new String[]{String.valueOf(DBDataStatus.SENT.getValue()), String.valueOf(System.currentTimeMillis() - 259200000)});
        }
        return f(table, "status=?", new String[]{String.valueOf(DBDataStatus.SENT.getValue())});
    }

    public final int h(@NotNull b table, @NotNull Function0<Integer> block) {
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
                return table.a(sQLiteDatabase2, block);
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_db_persist_DBHandler", e16);
                return -1;
            }
        }
        return -2;
    }

    public final void i() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.database;
        if (sQLiteDatabase2 == null || (sQLiteDatabase2 != null && !sQLiteDatabase2.isOpen())) {
            try {
                d dVar = this.dbHelper;
                if (dVar != null) {
                    sQLiteDatabase = dVar.getWritableDatabase();
                } else {
                    sQLiteDatabase = null;
                }
                this.database = sQLiteDatabase;
            } catch (SQLiteException e16) {
                Logger.f365497g.c("RMonitor_db_persist_DBHandler", e16);
            }
        }
    }

    @Nullable
    public final Cursor j(@NotNull String table, @Nullable String[] columns, @Nullable String selection, @Nullable String[] selectionArgs, boolean distinct, @Nullable String groupBy, @Nullable String having, @Nullable String orderBy, @Nullable String limit) {
        SQLiteDatabase sQLiteDatabase;
        Intrinsics.checkParameterIsNotNull(table, "table");
        if (this.database == null || ((sQLiteDatabase = this.database) != null && !sQLiteDatabase.isOpen())) {
            return null;
        }
        try {
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (sQLiteDatabase2 == null) {
                return null;
            }
            return sQLiteDatabase2.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        } catch (Exception e16) {
            Logger.f365497g.c("RMonitor_db_persist_DBHandler", e16);
            return null;
        }
    }

    public final int l(@NotNull String table, @NotNull String nullColumnHack, @NotNull ContentValues contentValues) {
        Intrinsics.checkParameterIsNotNull(table, "table");
        Intrinsics.checkParameterIsNotNull(nullColumnHack, "nullColumnHack");
        Intrinsics.checkParameterIsNotNull(contentValues, "contentValues");
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
                return (int) sQLiteDatabase2.replace(table, nullColumnHack, contentValues);
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_db_persist_DBHandler", e16);
                return -1;
            }
        }
        return -2;
    }

    @Nullable
    public final Object m(@NotNull b table, @NotNull Function0<? extends Object> block) {
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
                return table.b(sQLiteDatabase2, block);
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_db_persist_DBHandler", e16);
                return null;
            }
        }
        return null;
    }

    public final void n(@Nullable d dVar) {
        this.dbHelper = dVar;
    }

    public final int o(@NotNull String table, long id5, int status) {
        SQLiteDatabase sQLiteDatabase;
        Intrinsics.checkParameterIsNotNull(table, "table");
        if (this.database != null && ((sQLiteDatabase = this.database) == null || sQLiteDatabase.isOpen())) {
            try {
                if (status != DBDataStatus.TO_SEND.getValue() && status != DBDataStatus.SENT.getValue() && status != DBDataStatus.SENT_FAIL.getValue()) {
                    return -1;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(status));
                SQLiteDatabase sQLiteDatabase2 = this.database;
                if (sQLiteDatabase2 == null) {
                    return 0;
                }
                return sQLiteDatabase2.update(table, contentValues, "_id=?", new String[]{String.valueOf(id5)});
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_db_persist_DBHandler", e16);
                return -1;
            }
        }
        return -2;
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
