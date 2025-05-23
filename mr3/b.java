package mr3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qmethod.monitor.base.PMonitorInitParam;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0016J\"\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lmr3/b;", "Lcom/tencent/qmethod/monitor/report/base/db/a;", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "Lkotlin/Function0;", "", "block", "", "b", "c", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b extends com.tencent.qmethod.monitor.report.base.db.a {
    @Override // com.tencent.qmethod.monitor.report.base.db.a
    @Nullable
    public Object a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        try {
            return Integer.valueOf(dataBase.delete("question_data", "occur_time<? OR sdk_version!=?", new String[]{String.valueOf(System.currentTimeMillis() - 2592000000L), "0.9.15-rc2+build.1"}));
        } catch (Exception e16) {
            o.d("ReportQuestionTable", "delete", e16);
            return -1;
        }
    }

    @Override // com.tencent.qmethod.monitor.report.base.db.a
    public int b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object invoke = block.invoke();
        if (invoke != null && (invoke instanceof String)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_version", com.tencent.qmethod.monitor.a.f343451h.d(PMonitorInitParam.Property.APP_VERSION));
            contentValues.put("sdk_version", "0.9.15-rc2+build.1");
            contentValues.put("hash", (String) invoke);
            contentValues.put("occur_time", Long.valueOf(System.currentTimeMillis()));
            return (int) dataBase.insert("question_data", null, contentValues);
        }
        return 0;
    }

    @Override // com.tencent.qmethod.monitor.report.base.db.a
    @Nullable
    public Object c(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object invoke = block.invoke();
        if (invoke != null && (invoke instanceof String)) {
            try {
                boolean z16 = false;
                Cursor query = dataBase.query("question_data", new String[]{"_id"}, "app_version=? and hash=?", new String[]{com.tencent.qmethod.monitor.a.f343451h.d(PMonitorInitParam.Property.APP_VERSION), (String) invoke}, null, null, null);
                if (query != null) {
                    Cursor cursor = query;
                    try {
                        if (cursor.getCount() > 0) {
                            z16 = true;
                        }
                        Boolean valueOf = Boolean.valueOf(z16);
                        CloseableKt.closeFinally(cursor, null);
                        return valueOf;
                    } finally {
                    }
                }
            } catch (Exception e16) {
                o.d("ReportQuestionTable", "search", e16);
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
}
