package com.tencent.rmonitor.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\"\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/rmonitor/base/db/f;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "f", "d", "", "e", "onCreate", "", "oldVersion", "newVersion", "onUpgrade", "onDowngrade", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "Ljava/lang/String;", "dbName", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "factory", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)V", h.F, "a", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String dbName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f365375f = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R3\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rmonitor/base/db/f$a;", "", "", "b", "", ReportPlugin.KEY_TABLE_NAME, "createSql", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "tables", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "DB_VERSION", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.f$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final HashMap<String, String> a() {
            return f.f365375f;
        }

        public final int b() {
            return 17;
        }

        public final void c(@NotNull String tableName, @NotNull String createSql) {
            boolean z16;
            Intrinsics.checkParameterIsNotNull(tableName, "tableName");
            Intrinsics.checkParameterIsNotNull(createSql, "createSql");
            boolean z17 = true;
            if (tableName.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (createSql.length() <= 0) {
                    z17 = false;
                }
                if (z17) {
                    a().put(tableName, createSql);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Context context, @NotNull String dbName, @Nullable SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, dbName, cursorFactory, INSTANCE.b());
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dbName, "dbName");
        this.context = context;
        this.dbName = dbName;
    }

    private final void d() {
        try {
            Logger.f365497g.i("RMonitor_DB", "deleteDBFile");
            File databasePath = this.context.getDatabasePath(this.dbName);
            Intrinsics.checkExpressionValueIsNotNull(databasePath, "context.getDatabasePath(dbName)");
            if (databasePath.canWrite()) {
                databasePath.delete();
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_DB", th5);
        }
    }

    private final boolean e(SQLiteDatabase db5) {
        try {
            Logger.f365497g.i("RMonitor_DB", "dropAllTables");
            Iterator<Map.Entry<String, String>> it = f365375f.entrySet().iterator();
            while (it.hasNext()) {
                db5.execSQL("Drop table if exists " + it.next().getKey());
            }
            return true;
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_DB", th5);
            return false;
        }
    }

    private final void f(SQLiteDatabase db5) {
        if (e(db5)) {
            onCreate(db5);
        } else {
            d();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase db5) {
        Intrinsics.checkParameterIsNotNull(db5, "db");
        Iterator<Map.Entry<String, String>> it = f365375f.entrySet().iterator();
        while (it.hasNext()) {
            db5.execSQL(it.next().getValue());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(@Nullable SQLiteDatabase db5, int oldVersion, int newVersion) {
        if (db5 == null) {
            Logger.f365497g.e("RMonitor_DB", "onDowngrade, from " + oldVersion + " to " + newVersion + ", db is null.");
            return;
        }
        Logger.f365497g.i("RMonitor_DB", "onDowngrade, from " + oldVersion + " to " + newVersion);
        f(db5);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase db5, int oldVersion, int newVersion) {
        Intrinsics.checkParameterIsNotNull(db5, "db");
        Logger.f365497g.i("RMonitor_DB", "onUpgrade, from " + oldVersion + " to " + newVersion);
        f(db5);
    }
}
