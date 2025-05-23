package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.rmonitor.base.db.d;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.sla.AttaEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b&\u0010'J)\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ5\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0007J\u0014\u0010\u0016\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J}\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\u0016J\"\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020!2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\fH\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/AttaEventTable;", "Lcom/tencent/rmonitor/base/db/b;", "", "", "columns", "Landroid/database/Cursor;", "cursor", "Lcom/tencent/rmonitor/sla/c;", "e", "([Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/rmonitor/sla/c;", "target", "list", "Lkotlin/Function0;", "", "block", "f", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "attaEvent", "", "i", "", "attaEventList", "d", "selection", "selectionArgs", "", "distinct", "groupBy", "having", "orderBy", "limit", "g", "([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "a", "", "b", "<init>", "()V", "c", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class AttaEventTable extends com.tencent.rmonitor.base.db.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f365379b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<AttaEventTable>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AttaEventTable invoke() {
            return new AttaEventTable();
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000bR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u000bR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u000bR\u0014\u0010#\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u000bR\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u000bR\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u000bR\u0014\u0010'\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u000bR\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u000bR\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u000bR\u0014\u0010+\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u000bR\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u000bR\u0014\u0010-\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u000bR\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010\u000bR\u0014\u0010/\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010\u000bR\u0014\u00100\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010\u000b\u00a8\u00063"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/AttaEventTable$a;", "", "", "b", "Lcom/tencent/rmonitor/base/db/table/AttaEventTable;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/rmonitor/base/db/table/AttaEventTable;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "COLUMN_APP_BUNDLE_ID", "Ljava/lang/String;", "COLUMN_APP_KEY", "COLUMN_APP_NAME", "COLUMN_APP_VERSION", "COLUMN_CLIENT_TYPE", "COLUMN_DEBUG", "COLUMN_DEVICE_ID", "COLUMN_ERROR_CODE", "COLUMN_EVENT_CODE", "COLUMN_EVENT_COST", "COLUMN_EVENT_RESULT", "COLUMN_EVENT_TIME", "COLUMN_FULL_OS_VERSION", "COLUMN_ID", "COLUMN_MANUFACTURER", "COLUMN_MODEL", "COLUMN_OS_VERSION", "COLUMN_PARAM_0", "COLUMN_PARAM_1", "COLUMN_PARAM_10", "COLUMN_PARAM_11", "COLUMN_PARAM_12", "COLUMN_PARAM_13", "COLUMN_PARAM_2", "COLUMN_PARAM_3", "COLUMN_PARAM_4", "COLUMN_PARAM_5", "COLUMN_PARAM_6", "COLUMN_PARAM_7", "COLUMN_PARAM_8", "COLUMN_PARAM_9", "COLUMN_PRODUCT_ID", "COLUMN_SDK_VERSION", "COLUMN_UPLOAD_TIME", "COLUMN_USER_ID", "CREATE_ATTA_DATA", "TABLE_ATTA_DATA", "TAG", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.table.AttaEventTable$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f365381a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "getInstance()Lcom/tencent/rmonitor/base/db/table/AttaEventTable;"))};

        Companion() {
        }

        @NotNull
        public final AttaEventTable a() {
            Lazy lazy = AttaEventTable.f365379b;
            KProperty kProperty = f365381a[0];
            return (AttaEventTable) lazy.getValue();
        }

        @NotNull
        public final String b() {
            return "atta_event";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Logger.f365497g.d("RMonitor_base_AttaEventTable", "companion object init");
        new AttaEventTable();
    }

    public AttaEventTable() {
        super("atta_event", "CREATE TABLE IF NOT EXISTS atta_event (_id INTEGER PRIMARY KEY AUTOINCREMENT,app_version TEXT,app_name TEXT,app_bundle_id TEXT,app_key TEXT,client_type TEXT,user_id TEXT,sdk_version TEXT,event_code TEXT,event_result INT,event_time BIGINT,event_cost INT,error_code INT,upload_time BIGINT,device_id TEXT,os_version TEXT,manufacturer TEXT,model TEXT,debug INT,product_id TEXT,full_os_version TEXT,param_0 TEXT,param_1 TEXT,param_2 TEXT,param_3 TEXT,param_4 TEXT,param_5 TEXT,param_6 TEXT,param_7 TEXT,param_8 TEXT,param_9 TEXT,param_10 TEXT,param_11 TEXT,param_12 TEXT,param_13 TEXT);");
    }

    private final AttaEvent e(String[] columns, final Cursor cursor) {
        try {
            final AttaEvent attaEvent = new AttaEvent(null, 1, null);
            f("_id", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    attaEvent2.W(cursor2.getInt(cursor2.getColumnIndex("_id")));
                }
            });
            f("app_version", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("app_version"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026ndex(COLUMN_APP_VERSION))");
                    attaEvent2.N(string);
                }
            });
            f("app_name", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("app_name"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026mnIndex(COLUMN_APP_NAME))");
                    attaEvent2.M(string);
                }
            });
            f("app_bundle_id", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("app_bundle_id"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026ex(COLUMN_APP_BUNDLE_ID))");
                    attaEvent2.K(string);
                }
            });
            f("app_key", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("app_key"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_APP_KEY))");
                    attaEvent2.L(string);
                }
            });
            f("user_id", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("user_id"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_USER_ID))");
                    attaEvent2.s0(string);
                }
            });
            f("sdk_version", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$7
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("sdk_version"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026ndex(COLUMN_SDK_VERSION))");
                    attaEvent2.q0(string);
                }
            });
            f("event_code", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$8
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("event_code"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026Index(COLUMN_EVENT_CODE))");
                    attaEvent2.R(string);
                }
            });
            f("event_result", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$9
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    attaEvent2.T(cursor2.getInt(cursor2.getColumnIndex("event_result")));
                }
            });
            f("event_time", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$10
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    attaEvent2.U(cursor2.getLong(cursor2.getColumnIndex("event_time")));
                }
            });
            f("event_cost", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$11
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    attaEvent2.S(cursor2.getInt(cursor2.getColumnIndex("event_cost")));
                }
            });
            f("error_code", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$12
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    attaEvent2.Q(cursor2.getInt(cursor2.getColumnIndex("error_code")));
                }
            });
            f(s4.c.UPLOAD_TIME, columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$13
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    attaEvent2.r0(cursor2.getLong(cursor2.getColumnIndex(s4.c.UPLOAD_TIME)));
                }
            });
            f("device_id", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$14
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("device_id"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026nIndex(COLUMN_DEVICE_ID))");
                    attaEvent2.P(string);
                }
            });
            f("os_version", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$15
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("os_version"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026Index(COLUMN_OS_VERSION))");
                    attaEvent2.Z(string);
                }
            });
            f("manufacturer", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$16
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("manufacturer"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026dex(COLUMN_MANUFACTURER))");
                    attaEvent2.X(string);
                }
            });
            f("model", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$17
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("model"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026olumnIndex(COLUMN_MODEL))");
                    attaEvent2.Y(string);
                }
            });
            f("debug", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$18
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    attaEvent2.O(cursor2.getInt(cursor2.getColumnIndex("debug")));
                }
            });
            f(ReportDataBuilder.KEY_PRODUCT_ID, columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$19
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex(ReportDataBuilder.KEY_PRODUCT_ID));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026Index(COLUMN_PRODUCT_ID))");
                    attaEvent2.p0(string);
                }
            });
            f(ReportDataBuilder.KEY_FULL_OS_VERSION, columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$20
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex(ReportDataBuilder.KEY_FULL_OS_VERSION));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026(COLUMN_FULL_OS_VERSION))");
                    attaEvent2.V(string);
                }
            });
            f("param_0", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$21
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_0"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_0))");
                    attaEvent2.a0(string);
                }
            });
            f("param_1", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$22
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_1"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_1))");
                    attaEvent2.b0(string);
                }
            });
            f("param_2", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$23
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_2"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_2))");
                    attaEvent2.g0(string);
                }
            });
            f("param_3", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$24
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_3"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_3))");
                    attaEvent2.h0(string);
                }
            });
            f("param_4", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$25
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_4"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_4))");
                    attaEvent2.i0(string);
                }
            });
            f("param_5", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$26
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_5"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_5))");
                    attaEvent2.j0(string);
                }
            });
            f("param_6", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$27
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_6"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_6))");
                    attaEvent2.k0(string);
                }
            });
            f("param_7", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$28
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_7"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_7))");
                    attaEvent2.l0(string);
                }
            });
            f("param_8", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$29
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_8"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_8))");
                    attaEvent2.m0(string);
                }
            });
            f("param_9", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$30
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_9"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026umnIndex(COLUMN_PARAM_9))");
                    attaEvent2.n0(string);
                }
            });
            f("param_10", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$31
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_10"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026mnIndex(COLUMN_PARAM_10))");
                    attaEvent2.c0(string);
                }
            });
            f("param_11", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$32
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_11"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026mnIndex(COLUMN_PARAM_11))");
                    attaEvent2.d0(string);
                }
            });
            f("param_12", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$33
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_12"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026mnIndex(COLUMN_PARAM_12))");
                    attaEvent2.e0(string);
                }
            });
            f("param_13", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.AttaEventTable$cursorToAttaEvent$34
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AttaEvent attaEvent2 = AttaEvent.this;
                    Cursor cursor2 = cursor;
                    String string = cursor2.getString(cursor2.getColumnIndex("param_13"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026mnIndex(COLUMN_PARAM_13))");
                    attaEvent2.f0(string);
                }
            });
            return attaEvent;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void f(String target, String[] list, Function0<Unit> block) {
        boolean z16;
        boolean contains;
        if (list != null) {
            if (list.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                contains = ArraysKt___ArraysKt.contains(list, target);
                if (!contains) {
                    return;
                }
            }
        }
        block.invoke();
    }

    public static /* synthetic */ List h(AttaEventTable attaEventTable, String[] strArr, String str, String[] strArr2, boolean z16, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            strArr = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            strArr2 = null;
        }
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        if ((i3 & 16) != 0) {
            str2 = null;
        }
        if ((i3 & 32) != 0) {
            str3 = null;
        }
        if ((i3 & 64) != 0) {
            str4 = null;
        }
        if ((i3 & 128) != 0) {
            str5 = null;
        }
        return attaEventTable.g(strArr, str, strArr2, z16, str2, str3, str4, str5);
    }

    @Override // com.tencent.rmonitor.base.db.b
    public int a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<Integer> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return 0;
    }

    @Override // com.tencent.rmonitor.base.db.b
    @Nullable
    public Object b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return null;
    }

    public final int d(@NotNull List<AttaEvent> attaEventList) {
        int collectionSizeOrDefault;
        com.tencent.rmonitor.base.db.c dbHandler;
        Intrinsics.checkParameterIsNotNull(attaEventList, "attaEventList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = attaEventList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((AttaEvent) next).getId() <= 0) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Integer.valueOf(((AttaEvent) it5.next()).getId()));
        }
        if (arrayList2.isEmpty()) {
            return 0;
        }
        String str = "_id in ( " + TextUtils.join(",", arrayList2) + " )";
        Logger.f365497g.d("RMonitor_base_AttaEventTable", "delete sql where:" + str);
        d dVar = BaseInfo.dbHelper;
        if (dVar == null || (dbHandler = dVar.getDbHandler()) == null) {
            return 0;
        }
        return dbHandler.f("atta_event", str, null);
    }

    @NotNull
    public final List<AttaEvent> g(@Nullable String[] columns, @Nullable String selection, @Nullable String[] selectionArgs, boolean distinct, @Nullable String groupBy, @Nullable String having, @Nullable String orderBy, @Nullable String limit) {
        Cursor cursor;
        com.tencent.rmonitor.base.db.c dbHandler;
        Logger.f365497g.d("RMonitor_base_AttaEventTable", "columns:" + columns + " selection:" + selection + " selectionArgs:" + selectionArgs + " limit:" + limit);
        d dVar = BaseInfo.dbHelper;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            cursor = dbHandler.j("atta_event", columns, selection, selectionArgs, distinct, groupBy, having, orderBy, limit);
        } else {
            cursor = null;
        }
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            Cursor cursor2 = cursor;
            try {
                Cursor cursor3 = cursor2;
                if (cursor3.getCount() > 0) {
                    while (cursor3.moveToNext()) {
                        try {
                            AttaEvent e16 = e(columns, cursor3);
                            if (e16 != null) {
                                arrayList.add(e16);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            Throwable th6 = th;
                            try {
                                throw th6;
                            } catch (Throwable th7) {
                                CloseableKt.closeFinally(cursor2, th6);
                                throw th7;
                            }
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor2, null);
            } catch (Throwable th8) {
                th = th8;
            }
        }
        return arrayList;
    }

    public final int i(@NotNull AttaEvent attaEvent) {
        int i3;
        com.tencent.rmonitor.base.db.c dbHandler;
        Intrinsics.checkParameterIsNotNull(attaEvent, "attaEvent");
        ContentValues contentValues = new ContentValues();
        if (attaEvent.getId() > 0) {
            contentValues.put("_id", Integer.valueOf(attaEvent.getId()));
        }
        contentValues.put("app_version", attaEvent.getAppVersion());
        contentValues.put("app_name", attaEvent.getAppName());
        contentValues.put("app_bundle_id", attaEvent.getAppBundleId());
        contentValues.put("app_key", attaEvent.getAppKey());
        contentValues.put(AudienceReportConst.CLIENT_TYPE, attaEvent.getClientType());
        contentValues.put("user_id", attaEvent.getUserId());
        contentValues.put("sdk_version", attaEvent.getSdkVersion());
        contentValues.put("event_code", attaEvent.getEventCode());
        contentValues.put("event_result", Integer.valueOf(attaEvent.getEventResult()));
        contentValues.put("event_time", Long.valueOf(attaEvent.getEventTime()));
        contentValues.put("event_cost", Integer.valueOf(attaEvent.getEventCost()));
        contentValues.put("error_code", Integer.valueOf(attaEvent.getErrorCode()));
        contentValues.put(s4.c.UPLOAD_TIME, Long.valueOf(attaEvent.getUploadTime()));
        contentValues.put("device_id", attaEvent.getDeviceId());
        contentValues.put("os_version", attaEvent.getOsVersion());
        contentValues.put("manufacturer", attaEvent.getManufacturer());
        contentValues.put("model", attaEvent.getModel());
        contentValues.put("debug", Integer.valueOf(attaEvent.getDebug()));
        contentValues.put(ReportDataBuilder.KEY_PRODUCT_ID, attaEvent.getProductId());
        contentValues.put(ReportDataBuilder.KEY_FULL_OS_VERSION, attaEvent.getFullOSVersion());
        contentValues.put("param_0", attaEvent.getParam0());
        contentValues.put("param_1", attaEvent.getParam1());
        contentValues.put("param_2", attaEvent.getParam2());
        contentValues.put("param_3", attaEvent.getParam3());
        contentValues.put("param_4", attaEvent.getParam4());
        contentValues.put("param_5", attaEvent.getParam5());
        contentValues.put("param_6", attaEvent.getParam6());
        contentValues.put("param_7", attaEvent.getParam7());
        contentValues.put("param_8", attaEvent.getParam8());
        contentValues.put("param_9", attaEvent.getParam9());
        contentValues.put("param_10", attaEvent.getParam10());
        contentValues.put("param_11", attaEvent.getParam11());
        contentValues.put("param_12", attaEvent.getParam12());
        contentValues.put("param_13", attaEvent.getParam13());
        d dVar = BaseInfo.dbHelper;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            i3 = dbHandler.l("atta_event", "_id", contentValues);
        } else {
            i3 = -1;
        }
        attaEvent.W(i3);
        return i3;
    }
}
