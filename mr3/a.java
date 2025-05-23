package mr3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qmethod.monitor.report.base.db.DBDataStatus;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\u001f\u0010 BA\b\u0016\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010\"B!\b\u0016\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010#J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006&"}, d2 = {"Lmr3/a;", "Lcom/tencent/qmethod/monitor/report/base/db/a;", "Landroid/database/Cursor;", "cursor", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "d", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "Lkotlin/Function0;", "", "block", "", "b", "c", "", "Ljava/lang/String;", "processName", "productId", "version", "e", "params", "", "f", "Z", "isRealTime", "g", "uin", "", h.F, "J", "occurTime", "<init>", "()V", "pId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "i", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a extends com.tencent.qmethod.monitor.report.base.db.a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String processName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String productId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String version;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String params;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isRealTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long occurTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0005\u00a8\u0006\u0011"}, d2 = {"Lmr3/a$a;", "", "", "a", "COLUMN_ID", "Ljava/lang/String;", "COLUMN_IS_REAL_TIME", "COLUMN_PARAMS", "COLUMN_PROCESS_NAME", "COLUMN_PRODUCT_ID", "COLUMN_UIN", "COLUMN_VERSION", "CREATE_REPORT_DATA_TABLE", "TABLE_REPORT_DATA", "TAG", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: mr3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String a() {
            return "report_data";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        this.processName = "";
        this.productId = "";
        this.version = "";
        this.params = "";
        this.uin = "";
    }

    private final ReportData d(Cursor cursor) throws JSONException {
        if (cursor == null) {
            return null;
        }
        boolean z16 = false;
        ReportData reportData = new ReportData(null, false, 3, null);
        reportData.g(cursor.getInt(cursor.getColumnIndex("_id")));
        reportData.h(new JSONObject(cursor.getString(cursor.getColumnIndex("params"))));
        if (cursor.getInt(cursor.getColumnIndex("is_real_time")) > 0) {
            z16 = true;
        }
        reportData.i(z16);
        String string = cursor.getString(cursor.getColumnIndex("uin"));
        Intrinsics.checkExpressionValueIsNotNull(string, "it.getString(it.getColumnIndex(COLUMN_UIN))");
        reportData.j(string);
        return reportData;
    }

    @Override // com.tencent.qmethod.monitor.report.base.db.a
    public int b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ContentValues contentValues = new ContentValues();
        contentValues.put("process_name", this.processName);
        contentValues.put("p_id", this.productId);
        contentValues.put("version", this.version);
        contentValues.put("params", this.params);
        contentValues.put("is_real_time", Boolean.valueOf(this.isRealTime));
        contentValues.put("uin", this.uin);
        contentValues.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
        if (this.occurTime == 0) {
            this.occurTime = System.currentTimeMillis();
        }
        contentValues.put("occur_time", Long.valueOf(this.occurTime));
        return (int) dataBase.insert("report_data", "name", contentValues);
    }

    @Override // com.tencent.qmethod.monitor.report.base.db.a
    @Nullable
    public Object c(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        String str;
        String[] strArr;
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ArrayList arrayList = new ArrayList();
        try {
            Object invoke = block.invoke();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(invoke, bool)) {
                str = "p_id=? and version=? and status=? and occur_time>=?";
            } else {
                str = "p_id=? and version=?";
            }
            String str2 = str;
            if (Intrinsics.areEqual(block.invoke(), bool)) {
                strArr = new String[]{this.productId, this.version, String.valueOf(DBDataStatus.TO_SEND.getValue()), String.valueOf(System.currentTimeMillis() - 259200000)};
            } else {
                strArr = new String[]{this.productId, this.version};
            }
            Cursor query = dataBase.query("report_data", null, str2, strArr, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    cursor2.moveToFirst();
                    while (!cursor2.isAfterLast()) {
                        ReportData d16 = d(cursor2);
                        if (d16 != null) {
                            arrayList.add(d16);
                        }
                        cursor2.moveToNext();
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
        } catch (Exception e16) {
            o.d("ReportDataTable", "search", e16);
        }
        return arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String pId, @NotNull String processName, @NotNull String version, @NotNull String uin, @NotNull String params, boolean z16, long j3) {
        this();
        Intrinsics.checkParameterIsNotNull(pId, "pId");
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(version, "version");
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        Intrinsics.checkParameterIsNotNull(params, "params");
        this.processName = processName;
        this.productId = pId;
        this.version = version;
        this.params = params;
        this.isRealTime = z16;
        this.uin = uin;
        this.occurTime = j3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String pId, @NotNull String processName, @NotNull String version) {
        this();
        Intrinsics.checkParameterIsNotNull(pId, "pId");
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(version, "version");
        this.processName = processName;
        this.productId = pId;
        this.version = version;
    }
}
