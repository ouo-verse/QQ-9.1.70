package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018B!\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\n\u00a2\u0006\u0004\b\u0017\u0010\u001bJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/a;", "Lcom/tencent/rmonitor/base/db/b;", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "Lkotlin/Function0;", "", "block", "a", "", "b", "", "d", "", "c", "()[Ljava/lang/String;", "Lcom/tencent/rmonitor/base/db/a;", "Lcom/tencent/rmonitor/base/db/a;", "baseDBParam", "Ljava/lang/String;", "pluginName", "Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;", "Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;", PublicAccountMessageUtilImpl.META_NAME, "<init>", "()V", "dropFrameResult", "(Lcom/tencent/rmonitor/base/db/a;Ljava/lang/String;Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;)V", "(Lcom/tencent/rmonitor/base/db/a;Ljava/lang/String;)V", "e", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a extends com.tencent.rmonitor.base.db.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.rmonitor.base.db.a baseDBParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String pluginName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private DropFrameResultMeta meta;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/rmonitor/base/db/table/a$a;", "", "", "a", "Lcom/tencent/rmonitor/base/db/a;", "baseDBParam", "b", "key", "Lkotlin/Pair;", "c", "COLUMN_APP_VERSION", "Ljava/lang/String;", "COLUMN_CONTENT", "COLUMN_ID", "COLUMN_LAUNCH_ID", "COLUMN_PLUGIN_NAME", "COLUMN_PROCESS_NAME", "COLUMN_PRODUCT_ID", "COLUMN_SCENE", "COLUMN_UIN", "CONNECTOR", "CREATE_DROP_FRAME", "TABLE_DROP_FRAME", "TAG", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.table.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String a() {
            return "drop_frame";
        }

        @NotNull
        public final String b(@NotNull com.tencent.rmonitor.base.db.a baseDBParam) {
            Intrinsics.checkParameterIsNotNull(baseDBParam, "baseDBParam");
            return baseDBParam.f365362e + "_" + baseDBParam.f365363f;
        }

        @NotNull
        public final Pair<String, String> c(@NotNull String key) {
            List split$default;
            String str;
            Intrinsics.checkParameterIsNotNull(key, "key");
            split$default = StringsKt__StringsKt.split$default((CharSequence) key, new String[]{"_"}, false, 0, 6, (Object) null);
            String str2 = "";
            if (!(!split$default.isEmpty())) {
                str = "";
            } else {
                str = (String) split$default.get(0);
            }
            if (split$default.size() >= 2) {
                str2 = (String) split$default.get(1);
            }
            return new Pair<>(str, str2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        new a();
    }

    public a() {
        super("drop_frame", "CREATE TABLE drop_frame (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,product_id TEXT,app_version TEXT,launch_id TEXT,uin TEXT,plugin_name TEXT,scene TEXT,content TEXT,status TINYINT,occur_time BIGINT);");
        this.baseDBParam = new com.tencent.rmonitor.base.db.a();
        this.pluginName = "";
        this.meta = new DropFrameResultMeta(null, 0L, null, null, 0L, 0L, 0L, null, 255, null);
    }

    @Override // com.tencent.rmonitor.base.db.b
    public int a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<Integer> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ContentValues contentValues = new ContentValues();
        contentValues.put("process_name", this.baseDBParam.f365359b);
        contentValues.put(ReportDataBuilder.KEY_PRODUCT_ID, this.baseDBParam.f365358a);
        contentValues.put("app_version", this.baseDBParam.f365360c);
        contentValues.put(ReportDataBuilder.KEY_LAUNCH_ID, INSTANCE.b(this.baseDBParam));
        contentValues.put("uin", this.baseDBParam.f365364g);
        contentValues.put("scene", this.meta.scene);
        contentValues.put("plugin_name", this.pluginName);
        contentValues.put("content", this.meta.toJSONObject().toString());
        contentValues.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
        contentValues.put("occur_time", Long.valueOf(this.meta.timeStamp));
        return (int) dataBase.insert("drop_frame", "name", contentValues);
    }

    @Override // com.tencent.rmonitor.base.db.b
    @Nullable
    public Object b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        HashMap hashMap = new HashMap();
        try {
            Cursor query = dataBase.query("drop_frame", null, d(), c(), null, null, "occur_time DESC");
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    cursor2.moveToFirst();
                    while (!cursor2.isAfterLast()) {
                        String string = cursor2.getString(cursor2.getColumnIndex(ReportDataBuilder.KEY_LAUNCH_ID));
                        if (string != null) {
                            if (string.length() == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                ArrayList arrayList = (ArrayList) hashMap.get(string);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    hashMap.put(string, arrayList);
                                }
                                arrayList.add(new JSONObject(cursor2.getString(cursor2.getColumnIndex("content"))));
                                cursor2.moveToNext();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
        } catch (Exception e16) {
            Logger.f365497g.c("RMonitor_table_DropFrameTable", e16);
        }
        return hashMap;
    }

    @NotNull
    public final String[] c() {
        String str = this.baseDBParam.f365359b;
        Intrinsics.checkExpressionValueIsNotNull(str, "baseDBParam.processName");
        String str2 = this.baseDBParam.f365358a;
        Intrinsics.checkExpressionValueIsNotNull(str2, "baseDBParam.productID");
        String str3 = this.baseDBParam.f365360c;
        Intrinsics.checkExpressionValueIsNotNull(str3, "baseDBParam.appVersion");
        return new String[]{str, str2, str3, this.pluginName};
    }

    @NotNull
    public final String d() {
        return "process_name=? and product_id=? and app_version=? and plugin_name=?";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.rmonitor.base.db.a baseDBParam, @NotNull String pluginName, @NotNull DropFrameResultMeta dropFrameResult) {
        this();
        Intrinsics.checkParameterIsNotNull(baseDBParam, "baseDBParam");
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        Intrinsics.checkParameterIsNotNull(dropFrameResult, "dropFrameResult");
        this.baseDBParam = baseDBParam;
        this.pluginName = pluginName;
        this.meta = dropFrameResult;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.rmonitor.base.db.a baseDBParam, @NotNull String pluginName) {
        this();
        Intrinsics.checkParameterIsNotNull(baseDBParam, "baseDBParam");
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        this.baseDBParam = baseDBParam;
        this.pluginName = pluginName;
    }
}
