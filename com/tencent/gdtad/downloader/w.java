package com.tencent.gdtad.downloader;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010!\u001a\u00020\u0011\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ3\u0010\u0015\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0011H&J\b\u0010\u001c\u001a\u00020\u0011H&R\u001a\u0010 \u001a\u00020\u00118\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/gdtad/downloader/w;", "Landroid/database/sqlite/SQLiteOpenHelper;", "", "a", "Landroid/database/sqlite/SQLiteDatabase;", "getReadableDatabase", "getWritableDatabase", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "onCreate", "", "oldVersion", "newVersion", "onUpgrade", "Landroid/content/ContentValues;", "cv", "", "b", "", "where", "", "whereValue", "c", "(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I", "field", "", "d", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Z", "e", "g", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", ReportPlugin.KEY_TABLE_NAME, "table", "<init>", "(Ljava/lang/String;)V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class w extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tableName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@NotNull String table) {
        super(BaseApplication.context, "AD.download.db", (SQLiteDatabase.CursorFactory) null, 5);
        Intrinsics.checkNotNullParameter(table, "table");
        this.tableName = table;
        a();
    }

    private final void a() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        String str = "CREATE TABLE IF NOT EXISTS " + this.tableName + " (" + e() + " PRIMARY KEY(" + g() + "));";
        QLog.i("BaseDownloadDbHelper", 1, "createTable " + this.tableName);
        try {
            writableDatabase.execSQL(str);
        } finally {
            try {
            } finally {
            }
        }
    }

    public final long b(@NotNull ContentValues cv5) {
        Intrinsics.checkNotNullParameter(cv5, "cv");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long j3 = -1;
        if (writableDatabase == null) {
            return -1L;
        }
        try {
            j3 = writableDatabase.replace(this.tableName, null, cv5);
            QLog.d("BaseDownloadDbHelper", 1, "execReplaceSQL " + this.tableName + " row=" + j3 + ",cv=" + cv5);
        } finally {
            try {
                return j3;
            } finally {
            }
        }
        return j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(@Nullable String where, @Nullable String[] whereValue, @Nullable ContentValues cv5) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        int i3 = -1;
        if (writableDatabase == null || cv5 == null) {
            return -1;
        }
        try {
            i3 = writableDatabase.update(this.tableName, cv5, where, whereValue);
        } finally {
            try {
                if (i3 <= 0) {
                }
                return i3;
            } finally {
            }
        }
        if (i3 <= 0) {
            QLog.w("BaseDownloadDbHelper", 1, "execUpdSQL " + this.tableName + " error whereValue=" + Arrays.toString(whereValue) + ",cv=" + cv5);
        }
        return i3;
    }

    public final boolean d(@Nullable String where, @NotNull String[] whereValue, @NotNull String field) {
        Intrinsics.checkNotNullParameter(whereValue, "whereValue");
        Intrinsics.checkNotNullParameter(field, "field");
        SQLiteDatabase readableDatabase = getReadableDatabase();
        boolean z16 = false;
        if (readableDatabase == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = readableDatabase.query(this.tableName, new String[]{field}, where, whereValue, null, null, null);
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    z16 = true;
                }
            }
        } finally {
            try {
                return z16;
            } finally {
            }
        }
        return z16;
    }

    @NotNull
    public abstract String e();

    @NotNull
    public abstract String g();

    @Override // android.database.sqlite.SQLiteOpenHelper
    @Nullable
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Exception unused) {
            QLog.e("BaseDownloadDbHelper", 1, "getReadableDatabase exception");
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @Nullable
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Exception unused) {
            QLog.e("BaseDownloadDbHelper", 1, "getWritableDatabase exception");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTableName() {
        return this.tableName;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@Nullable SQLiteDatabase db5) {
        QLog.i("BaseDownloadDbHelper", 1, "onCreate " + this.tableName);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase db5, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db5, "db");
        QLog.i("BaseDownloadDbHelper", 1, "onUpgrade oldVersion=" + oldVersion + ",newVersion=" + newVersion);
        try {
            db5.execSQL("DROP TABLE IF EXISTS " + this.tableName);
            a();
        } catch (Throwable unused) {
            QLog.e("BaseDownloadDbHelper", 1, "onUpgrade exception oldVersion=" + oldVersion + ",newVersion=" + newVersion);
        }
    }
}
