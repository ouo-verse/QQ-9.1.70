package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 \u000f2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b*\u0010+B)\b\u0016\u0012\u0006\u0010,\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u0013\u0012\u0006\u0010\"\u001a\u00020\u0013\u0012\u0006\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010-B!\b\u0016\u0012\u0006\u0010,\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u0013\u0012\u0006\u0010\"\u001a\u00020\u0013\u00a2\u0006\u0004\b*\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u001c\u0010\u0015\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00140\u0012J,\u0010\u0019\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00140\u00122\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016J\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0016J\"\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016R\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/c;", "Lcom/tencent/rmonitor/base/db/b;", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "data", "", "d", "Landroid/database/Cursor;", "cursor", "c", "Lcom/tencent/rmonitor/base/db/DBDataStatus;", "status", "", h.F, "start", "end", "i", "Landroid/content/ContentValues;", "g", "Lkotlin/Pair;", "", "", "f", "Lkotlin/Function0;", "", "block", "e", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "", "a", "b", "Ljava/lang/String;", "processName", "productId", "version", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "Lcom/tencent/rmonitor/base/db/DBDataStatus;", "insertStatus", "J", "startTime", "endTime", "<init>", "()V", "pId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/common/reporter/data/ReportData;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c extends com.tencent.rmonitor.base.db.b {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String processName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String productId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String version;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ReportData reportData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private DBDataStatus insertStatus;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0005\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/c$a;", "", "", "a", "COLUMN_ID", "Ljava/lang/String;", "COLUMN_IS_REAL_TIME", "COLUMN_PARAMS", "COLUMN_PROCESS_NAME", "COLUMN_PRODUCT_ID", "COLUMN_REPORT_TYPE", "COLUMN_UIN", "COLUMN_VERSION", "CREATE_REPORT_DATA_TABLE", "", "SEARCH_TYPE_ALL", "I", "SEARCH_TYPE_NONE_SEND_VALID", "SEARCH_TYPE_RANGE", "TABLE_REPORT_DATA", "TAG", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.table.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    static {
        new c();
    }

    public c() {
        super("report_data", "CREATE TABLE report_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id TEXT,version TEXT,report_type TINYINT,params TEXT,is_real_time TINYINT,uin TEXT,status TINYINT,occur_time BIGINT);");
        this.processName = "";
        this.productId = "";
        this.version = "";
        this.insertStatus = DBDataStatus.TO_SEND;
    }

    private final ReportData c(Cursor cursor) throws JSONException {
        boolean z16;
        if (cursor != null) {
            ReportData reportData = new ReportData(BaseInfo.userMeta.uin, 0, null, null, 14, null);
            reportData.setDbId(cursor.getInt(cursor.getColumnIndex("_id")));
            reportData.setReportType(cursor.getInt(cursor.getColumnIndex(TVKDataBinder.KEY_REPORT_TYPE)));
            String string = cursor.getString(cursor.getColumnIndex("uin"));
            Intrinsics.checkExpressionValueIsNotNull(string, "it.getString(it.getColumnIndex(COLUMN_UIN))");
            reportData.setUin(string);
            String string2 = cursor.getString(cursor.getColumnIndex("params"));
            if (string2 != null) {
                if (string2.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    try {
                        reportData.setParams(new JSONObject(string2));
                    } catch (Throwable unused) {
                    }
                }
            }
            return reportData;
        }
        return null;
    }

    private final long d(ReportData data) {
        long j3;
        if (data.getParams().has(ReportDataBuilder.KEY_EVENT_TIME_IN_MS)) {
            j3 = data.getParams().optLong(ReportDataBuilder.KEY_EVENT_TIME_IN_MS);
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            return System.currentTimeMillis();
        }
        return j3;
    }

    @Override // com.tencent.rmonitor.base.db.b
    public int a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<Integer> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ContentValues g16 = g();
        if (g16 != null) {
            return (int) dataBase.insert("report_data", "name", g16);
        }
        return -1;
    }

    @Override // com.tencent.rmonitor.base.db.b
    @Nullable
    public Object b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ArrayList arrayList = new ArrayList();
        try {
            Pair<String, String[]> e16 = e(block);
            Cursor query = dataBase.query("report_data", null, e16.getFirst(), e16.getSecond(), null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    cursor2.moveToFirst();
                    while (!cursor2.isAfterLast()) {
                        ReportData c16 = c(cursor2);
                        if (c16 != null) {
                            arrayList.add(c16);
                        }
                        cursor2.moveToNext();
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
        } catch (Exception e17) {
            Logger.f365497g.c("RMonitor_base_ReportDataTable", e17);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0044  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<String, String[]> e(@NotNull Function0<? extends Object> block) {
        char c16;
        String[] strArr;
        String str;
        String[] strArr2;
        String str2;
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object invoke = block.invoke();
        if (!Intrinsics.areEqual(invoke, Boolean.TRUE)) {
            if (!Intrinsics.areEqual(invoke, Boolean.FALSE)) {
                if (!Intrinsics.areEqual(invoke, (Object) 1)) {
                    if (!Intrinsics.areEqual(invoke, (Object) 0) && Intrinsics.areEqual(invoke, (Object) 2)) {
                        c16 = 2;
                        if (c16 != 0) {
                            if (c16 != 1) {
                                if (c16 != 2) {
                                    str2 = null;
                                    strArr2 = null;
                                    return new Pair<>(str2, strArr2);
                                }
                                strArr = new String[]{this.processName, this.productId, String.valueOf(this.startTime), String.valueOf(this.endTime)};
                                str = "process_name=? and p_id=? and occur_time>=? and occur_time<=?";
                            } else {
                                strArr = new String[]{this.processName, this.productId, String.valueOf(DBDataStatus.SENT.getValue()), String.valueOf(System.currentTimeMillis() - 259200000)};
                                str = "process_name=? and p_id=? and status!=? and occur_time>=?";
                            }
                        } else {
                            strArr = new String[]{this.processName, this.productId};
                            str = "process_name=? and p_id=?";
                        }
                        String str3 = str;
                        strArr2 = strArr;
                        str2 = str3;
                        return new Pair<>(str2, strArr2);
                    }
                }
            }
            c16 = 0;
            if (c16 != 0) {
            }
            String str32 = str;
            strArr2 = strArr;
            str2 = str32;
            return new Pair<>(str2, strArr2);
        }
        c16 = 1;
        if (c16 != 0) {
        }
        String str322 = str;
        strArr2 = strArr;
        str2 = str322;
        return new Pair<>(str2, strArr2);
    }

    @NotNull
    public final Pair<String, String[]> f() {
        String[] strArr;
        String str;
        ReportData reportData = this.reportData;
        if (reportData != null) {
            strArr = new String[]{String.valueOf(reportData.getDbId())};
            str = "_id = ?";
        } else {
            strArr = null;
            str = null;
        }
        return new Pair<>(str, strArr);
    }

    @Nullable
    public final ContentValues g() {
        ReportData reportData = this.reportData;
        if (reportData != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("process_name", this.processName);
            contentValues.put("p_id", this.productId);
            contentValues.put("version", this.version);
            contentValues.put(TVKDataBinder.KEY_REPORT_TYPE, Integer.valueOf(reportData.getReportType()));
            contentValues.put("params", reportData.getParams().toString());
            contentValues.put("is_real_time", Boolean.FALSE);
            contentValues.put("uin", reportData.getUin());
            contentValues.put("status", Integer.valueOf(this.insertStatus.getValue()));
            contentValues.put("occur_time", Long.valueOf(d(reportData)));
            return contentValues;
        }
        return null;
    }

    public final void h(@NotNull DBDataStatus status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        this.insertStatus = status;
    }

    public final void i(long start, long end) {
        this.startTime = start;
        this.endTime = end;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String pId, @NotNull String processName, @NotNull String version, @NotNull ReportData reportData) {
        this();
        Intrinsics.checkParameterIsNotNull(pId, "pId");
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(version, "version");
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        this.processName = processName;
        this.productId = pId;
        this.version = version;
        this.reportData = reportData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String pId, @NotNull String processName, @NotNull String version) {
        this();
        Intrinsics.checkParameterIsNotNull(pId, "pId");
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(version, "version");
        this.processName = processName;
        this.productId = pId;
        this.version = version;
    }
}
