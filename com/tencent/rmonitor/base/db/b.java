package com.tencent.rmonitor.base.db;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rmonitor/base/db/b;", "", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "Lkotlin/Function0;", "", "block", "a", "b", "", ReportPlugin.KEY_TABLE_NAME, "createTableSql", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class b {
    public b(@NotNull String tableName, @NotNull String createTableSql) {
        Intrinsics.checkParameterIsNotNull(tableName, "tableName");
        Intrinsics.checkParameterIsNotNull(createTableSql, "createTableSql");
        d.INSTANCE.b(tableName, createTableSql);
    }

    public abstract int a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<Integer> block);

    @Nullable
    public abstract Object b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block);
}
