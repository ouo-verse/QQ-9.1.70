package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.db.d;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.TrafficInfo;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b'\u0010(J)\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ5\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0007J\u0014\u0010\u0017\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015J}\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b \u0010!J\u001e\u0010$\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\u0016J\"\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010#\u001a\u00020\"2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\fH\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/TrafficInfoTable;", "Lcom/tencent/rmonitor/base/db/b;", "", "", "columns", "Landroid/database/Cursor;", "cursor", "Lcom/tencent/rmonitor/base/meta/TrafficInfo;", "e", "([Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/rmonitor/base/meta/TrafficInfo;", "target", "list", "Lkotlin/Function0;", "", "block", h.F, "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "trafficInfo", "", "j", "f", "", "trafficInfoList", "d", "selection", "selectionArgs", "", "distinct", "groupBy", "having", "orderBy", "limit", "i", "([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "a", "", "b", "<init>", "()V", "c", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class TrafficInfoTable extends com.tencent.rmonitor.base.db.b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f365382b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R!\u0010\u000b\u001a\u00020\u00048FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/TrafficInfoTable$a;", "", "", "b", "Lcom/tencent/rmonitor/base/db/table/TrafficInfoTable;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/rmonitor/base/db/table/TrafficInfoTable;", "instance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "COLUMN_APP_VERSION", "Ljava/lang/String;", "COLUMN_FRONT_STATE", "COLUMN_HOST", "COLUMN_HOT_PATCH_NUM", "COLUMN_ID", "COLUMN_LAUNCH_ID", "COLUMN_NET_STATE", "COLUMN_PROCESS_LAUNCH_ID", "COLUMN_PROCESS_NAME", "COLUMN_RX", "COLUMN_TX", "COLUMN_TYPE", "COLUMN_USERDATA", "CREATE_TRAFFIC_INFO", "TABLE_TRAFFIC_INFO", "TAG", "<init>", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.table.TrafficInfoTable$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f365384a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "getInstance()Lcom/tencent/rmonitor/base/db/table/TrafficInfoTable;"))};

        Companion() {
        }

        @NotNull
        public final TrafficInfoTable a() {
            Lazy lazy = TrafficInfoTable.f365382b;
            KProperty kProperty = f365384a[0];
            return (TrafficInfoTable) lazy.getValue();
        }

        @JvmStatic
        @NotNull
        public final String b() {
            return "traffic_info";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<TrafficInfoTable>() { // from class: com.tencent.rmonitor.base.db.table.TrafficInfoTable$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TrafficInfoTable invoke() {
                return new TrafficInfoTable();
            }
        });
        f365382b = lazy;
        new TrafficInfoTable();
    }

    public TrafficInfoTable() {
        super("traffic_info", "CREATE TABLE IF NOT EXISTS traffic_info (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,process_launch_id TEXT,launch_id TEXT,type TEXT,host TEXT,front_state TEXT,net_state TEXT,rx BIGINT,tx BIGINT,app_version TEXT,hot_patch_num TEXT,occur_time BIGINT,status TEXT,user_data TEXT);");
    }

    private final TrafficInfo e(String[] columns, final Cursor cursor) {
        try {
            final TrafficInfo trafficInfo = new TrafficInfo();
            h("_id", columns, new Function0<Unit>() { // from class: com.tencent.rmonitor.base.db.table.TrafficInfoTable$cursorToTrafficInfo$1
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
                    TrafficInfo trafficInfo2 = TrafficInfo.this;
                    Cursor cursor2 = cursor;
                    trafficInfo2.setId(cursor2.getInt(cursor2.getColumnIndex("_id")));
                    TrafficInfo trafficInfo3 = TrafficInfo.this;
                    Cursor cursor3 = cursor;
                    String string = cursor3.getString(cursor3.getColumnIndex("process_name"));
                    Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(cursor.\u2026dex(COLUMN_PROCESS_NAME))");
                    trafficInfo3.setProcessName(string);
                    TrafficInfo trafficInfo4 = TrafficInfo.this;
                    Cursor cursor4 = cursor;
                    String string2 = cursor4.getString(cursor4.getColumnIndex(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID));
                    Intrinsics.checkExpressionValueIsNotNull(string2, "cursor.getString(cursor.\u2026OLUMN_PROCESS_LAUNCH_ID))");
                    trafficInfo4.setProcessLaunchID(string2);
                    TrafficInfo trafficInfo5 = TrafficInfo.this;
                    Cursor cursor5 = cursor;
                    String string3 = cursor5.getString(cursor5.getColumnIndex(ReportDataBuilder.KEY_LAUNCH_ID));
                    Intrinsics.checkExpressionValueIsNotNull(string3, "cursor.getString(cursor.\u2026       COLUMN_LAUNCH_ID))");
                    trafficInfo5.setLaunchID(string3);
                    TrafficInfo trafficInfo6 = TrafficInfo.this;
                    Cursor cursor6 = cursor;
                    String string4 = cursor6.getString(cursor6.getColumnIndex("type"));
                    Intrinsics.checkExpressionValueIsNotNull(string4, "cursor.getString(cursor.\u2026            COLUMN_TYPE))");
                    trafficInfo6.setType(string4);
                    TrafficInfo trafficInfo7 = TrafficInfo.this;
                    Cursor cursor7 = cursor;
                    String string5 = cursor7.getString(cursor7.getColumnIndex("host"));
                    Intrinsics.checkExpressionValueIsNotNull(string5, "cursor.getString(cursor.\u2026ColumnIndex(COLUMN_HOST))");
                    trafficInfo7.setHost(string5);
                    TrafficInfo trafficInfo8 = TrafficInfo.this;
                    Cursor cursor8 = cursor;
                    String string6 = cursor8.getString(cursor8.getColumnIndex("front_state"));
                    Intrinsics.checkExpressionValueIsNotNull(string6, "cursor.getString(cursor.\u2026ndex(COLUMN_FRONT_STATE))");
                    trafficInfo8.setFrontState(string6);
                    TrafficInfo trafficInfo9 = TrafficInfo.this;
                    Cursor cursor9 = cursor;
                    String string7 = cursor9.getString(cursor9.getColumnIndex("net_state"));
                    Intrinsics.checkExpressionValueIsNotNull(string7, "cursor.getString(cursor.\u2026nIndex(COLUMN_NET_STATE))");
                    trafficInfo9.setNetState(string7);
                    TrafficInfo trafficInfo10 = TrafficInfo.this;
                    Cursor cursor10 = cursor;
                    trafficInfo10.setRx(cursor10.getInt(cursor10.getColumnIndex("rx")));
                    TrafficInfo trafficInfo11 = TrafficInfo.this;
                    Cursor cursor11 = cursor;
                    trafficInfo11.setTx(cursor11.getInt(cursor11.getColumnIndex("tx")));
                    TrafficInfo trafficInfo12 = TrafficInfo.this;
                    Cursor cursor12 = cursor;
                    String string8 = cursor12.getString(cursor12.getColumnIndex("app_version"));
                    Intrinsics.checkExpressionValueIsNotNull(string8, "cursor.getString(cursor.\u2026ndex(COLUMN_APP_VERSION))");
                    trafficInfo12.setAppVersion(string8);
                    TrafficInfo trafficInfo13 = TrafficInfo.this;
                    Cursor cursor13 = cursor;
                    String string9 = cursor13.getString(cursor13.getColumnIndex("hot_patch_num"));
                    Intrinsics.checkExpressionValueIsNotNull(string9, "cursor.getString(cursor.\u2026ex(COLUMN_HOT_PATCH_NUM))");
                    trafficInfo13.setHotPatchNum(string9);
                    TrafficInfo trafficInfo14 = TrafficInfo.this;
                    Cursor cursor14 = cursor;
                    trafficInfo14.setUserData(new JSONObject(cursor14.getString(cursor14.getColumnIndex(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA))));
                }
            });
            return trafficInfo;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NotNull
    public static final TrafficInfoTable g() {
        return INSTANCE.a();
    }

    private final void h(String target, String[] list, Function0<Unit> block) {
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

    @Override // com.tencent.rmonitor.base.db.b
    public int a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<Integer> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return 1;
    }

    @Override // com.tencent.rmonitor.base.db.b
    @Nullable
    public Object b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return null;
    }

    public final int d(@NotNull List<TrafficInfo> trafficInfoList) {
        int collectionSizeOrDefault;
        com.tencent.rmonitor.base.db.c dbHandler;
        Intrinsics.checkParameterIsNotNull(trafficInfoList, "trafficInfoList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = trafficInfoList.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((TrafficInfo) next).getId() > 0) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Integer.valueOf(((TrafficInfo) it5.next()).getId()));
        }
        if (arrayList2.isEmpty()) {
            return 0;
        }
        String str = "_id in ( " + TextUtils.join(",", arrayList2) + " )";
        d dVar = BaseInfo.dbHelper;
        if (dVar == null || (dbHandler = dVar.getDbHandler()) == null) {
            return 0;
        }
        return dbHandler.f("traffic_info", str, null);
    }

    public final int f(@NotNull TrafficInfo trafficInfo) {
        com.tencent.rmonitor.base.db.c dbHandler;
        Intrinsics.checkParameterIsNotNull(trafficInfo, "trafficInfo");
        if (trafficInfo.getId() < 0) {
            return 0;
        }
        String str = "_id= " + trafficInfo.getId();
        Logger.f365497g.d("TrafficInfoTable", "delete sql where:" + str);
        d dVar = BaseInfo.dbHelper;
        if (dVar == null || (dbHandler = dVar.getDbHandler()) == null) {
            return 0;
        }
        return dbHandler.f("traffic_info", str, null);
    }

    @NotNull
    public final List<TrafficInfo> i(@Nullable String[] columns, @Nullable String selection, @Nullable String[] selectionArgs, boolean distinct, @Nullable String groupBy, @Nullable String having, @Nullable String orderBy, @Nullable String limit) {
        Cursor cursor;
        com.tencent.rmonitor.base.db.c dbHandler;
        d dVar = BaseInfo.dbHelper;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            cursor = dbHandler.j("traffic_info", columns, selection, selectionArgs, distinct, groupBy, having, orderBy, limit);
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
                            TrafficInfo e16 = e(columns, cursor3);
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

    public final int j(@NotNull TrafficInfo trafficInfo) {
        int i3;
        com.tencent.rmonitor.base.db.c dbHandler;
        Intrinsics.checkParameterIsNotNull(trafficInfo, "trafficInfo");
        ContentValues contentValues = new ContentValues();
        if (trafficInfo.getId() > 0) {
            contentValues.put("_id", Integer.valueOf(trafficInfo.getId()));
        }
        contentValues.put("process_name", trafficInfo.getProcessName());
        contentValues.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, trafficInfo.getProcessLaunchID());
        contentValues.put(ReportDataBuilder.KEY_LAUNCH_ID, trafficInfo.getLaunchID());
        contentValues.put("type", trafficInfo.getType());
        contentValues.put("host", trafficInfo.getHost());
        contentValues.put("front_state", trafficInfo.getFrontState());
        contentValues.put("net_state", trafficInfo.getNetState());
        contentValues.put("rx", Integer.valueOf(trafficInfo.getRx()));
        contentValues.put("tx", Integer.valueOf(trafficInfo.getTx()));
        contentValues.put("app_version", trafficInfo.getAppVersion());
        contentValues.put("hot_patch_num", trafficInfo.getHotPatchNum());
        contentValues.put(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, trafficInfo.getUserData().toString());
        contentValues.put("occur_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
        d dVar = BaseInfo.dbHelper;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            i3 = dbHandler.l("traffic_info", "_id", contentValues);
        } else {
            i3 = -1;
        }
        trafficInfo.setId(i3);
        return i3;
    }
}
