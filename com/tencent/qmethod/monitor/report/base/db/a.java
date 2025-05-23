package com.tencent.qmethod.monitor.report.base.db;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H&J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H&J\"\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/db/a;", "", "Landroid/database/sqlite/SQLiteDatabase;", "dataBase", "Lkotlin/Function0;", "block", "", "b", "c", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public abstract class a {
    @Nullable
    public Object a(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(dataBase, "dataBase");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return new NotImplementedError(null, 1, null);
    }

    public abstract int b(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block);

    @Nullable
    public abstract Object c(@NotNull SQLiteDatabase dataBase, @NotNull Function0<? extends Object> block);
}
