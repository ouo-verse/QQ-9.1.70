package com.tencent.qmethod.monitor.report.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B!\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/db/d;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "onCreate", "", "oldVersion", "newVersion", "onUpgrade", "Landroid/content/Context;", "context", "", "dbName", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "factory", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)V", "e", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public class d extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f343828d;

    static {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("report_data", "CREATE TABLE report_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id TEXT,version TEXT,params TEXT,is_real_time TINYINT,uin TEXT,status TINYINT,occur_time BIGINT);"), TuplesKt.to("question_data", "CREATE TABLE question_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,app_version TEXT,sdk_version TEXT,hash TEXT,occur_time BIGINT);"));
        f343828d = hashMapOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, @NotNull String dbName, @Nullable SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, dbName, cursorFactory, 13);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dbName, "dbName");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase db5) {
        Intrinsics.checkParameterIsNotNull(db5, "db");
        Iterator<Map.Entry<String, String>> it = f343828d.entrySet().iterator();
        while (it.hasNext()) {
            db5.execSQL(it.next().getValue());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase db5, int oldVersion, int newVersion) {
        Intrinsics.checkParameterIsNotNull(db5, "db");
        if (13 > oldVersion) {
            db5.execSQL(f343828d.get("question_data"));
        }
    }
}
