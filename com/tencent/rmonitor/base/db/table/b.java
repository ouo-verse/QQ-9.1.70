package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.link.LinkData;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0014J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004H\u0016R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/b;", "Lcom/tencent/rmonitor/base/db/b;", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "Lkotlin/Function0;", "", "block", "a", "", "b", "Lcom/tencent/rmonitor/base/db/a;", "Lcom/tencent/rmonitor/base/db/a;", "baseDBParam", "Lcom/tencent/bugly/common/reporter/link/LinkData;", "c", "Lcom/tencent/bugly/common/reporter/link/LinkData;", "linkData", "<init>", "()V", "(Lcom/tencent/rmonitor/base/db/a;Lcom/tencent/bugly/common/reporter/link/LinkData;)V", "(Lcom/tencent/rmonitor/base/db/a;)V", "d", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b extends com.tencent.rmonitor.base.db.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.rmonitor.base.db.a baseDBParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private LinkData linkData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0005R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0005\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/b$a;", "", "", "a", "COLUMN_APP_VERSION", "Ljava/lang/String;", "COLUMN_BASE_TYPE", "COLUMN_CLIENT_IDENTIFY", "COLUMN_EVENT_TIME", "COLUMN_ID", "COLUMN_LAUNCH_ID", "COLUMN_PROCESS_LAUNCH_ID", "COLUMN_PROCESS_NAME", "COLUMN_PRODUCT_ID", "COLUMN_RESERVED", "COLUMN_SDK_VERSION", "COLUMN_SUB_TYPE", "COLUMN_UIN", "CREATE_LINK_DATA", "TABLE_LINK_DATA", "TAG", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.table.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String a() {
            return "link_data";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        new b();
    }

    public b() {
        super("link_data", "CREATE TABLE link_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,product_id TEXT,process_name TEXT,app_version TEXT,sdk_version TEXT,launch_id TEXT,process_launch_id TEXT,uin TEXT,base_type TEXT,sub_type TEXT,client_identify TEXT,reserved TEXT,status TINYINT,event_time BIGINT,occur_time BIGINT);");
        this.baseDBParam = new com.tencent.rmonitor.base.db.a();
        this.linkData = new LinkData();
    }

    @Override // com.tencent.rmonitor.base.db.b
    public int a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<Integer> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ContentValues contentValues = new ContentValues();
        contentValues.put("process_name", this.baseDBParam.f365359b);
        contentValues.put(ReportDataBuilder.KEY_PRODUCT_ID, this.baseDBParam.f365358a);
        contentValues.put("app_version", this.baseDBParam.f365360c);
        contentValues.put("sdk_version", this.baseDBParam.f365361d);
        contentValues.put("uin", this.baseDBParam.f365364g);
        contentValues.put(ReportDataBuilder.KEY_LAUNCH_ID, this.linkData.launchID);
        contentValues.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, this.linkData.processLaunchID);
        contentValues.put(ReportDataBuilder.KEY_BASE_TYPE, this.linkData.baseType);
        contentValues.put("sub_type", this.linkData.subType);
        contentValues.put(ReportDataBuilder.KEY_CLIENT_IDENTIFY, this.linkData.clientIdentify);
        contentValues.put("reserved", "");
        contentValues.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
        contentValues.put("event_time", Long.valueOf(this.linkData.eventTime));
        contentValues.put("occur_time", Long.valueOf(this.linkData.eventTimeInMS));
        return (int) dataBase.insert("link_data", null, contentValues);
    }

    @Override // com.tencent.rmonitor.base.db.b
    @Nullable
    public Object b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Object invoke;
        String str;
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ArrayList arrayList = new ArrayList();
        try {
            invoke = block.invoke();
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_table_LinkDataTable", th5);
        }
        if (invoke != null) {
            int intValue = ((Integer) invoke).intValue();
            com.tencent.rmonitor.base.db.a aVar = this.baseDBParam;
            String[] strArr = {aVar.f365359b, aVar.f365358a, aVar.f365363f};
            if (intValue > 0) {
                str = String.valueOf(intValue);
            } else {
                str = null;
            }
            Cursor query = dataBase.query("link_data", null, "process_name=? and product_id=? and process_launch_id=?", strArr, null, null, "occur_time DESC", str);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    cursor2.moveToFirst();
                    while (!cursor2.isAfterLast()) {
                        LinkData linkData = new LinkData();
                        linkData.launchID = cursor2.getString(cursor2.getColumnIndex(ReportDataBuilder.KEY_LAUNCH_ID));
                        linkData.processLaunchID = cursor2.getString(cursor2.getColumnIndex(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID));
                        linkData.baseType = cursor2.getString(cursor2.getColumnIndex(ReportDataBuilder.KEY_BASE_TYPE));
                        linkData.subType = cursor2.getString(cursor2.getColumnIndex("sub_type"));
                        linkData.clientIdentify = cursor2.getString(cursor2.getColumnIndex(ReportDataBuilder.KEY_CLIENT_IDENTIFY));
                        linkData.eventTime = cursor2.getLong(cursor2.getColumnIndex("event_time"));
                        linkData.eventTimeInMS = cursor2.getLong(cursor2.getColumnIndex("occur_time"));
                        arrayList.add(linkData);
                        cursor2.moveToNext();
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
            return arrayList;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.rmonitor.base.db.a baseDBParam, @NotNull LinkData linkData) {
        this();
        Intrinsics.checkParameterIsNotNull(baseDBParam, "baseDBParam");
        Intrinsics.checkParameterIsNotNull(linkData, "linkData");
        this.baseDBParam = baseDBParam;
        this.linkData = linkData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.rmonitor.base.db.a baseDBParam) {
        this();
        Intrinsics.checkParameterIsNotNull(baseDBParam, "baseDBParam");
        this.baseDBParam = baseDBParam;
    }
}
