package com.tencent.rmonitor.base.db;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rmonitor/base/db/d;", "Lcom/tencent/rmonitor/base/db/f;", "Lcom/tencent/rmonitor/base/db/c;", "i", "Lcom/tencent/rmonitor/base/db/c;", "j", "()Lcom/tencent/rmonitor/base/db/c;", "dbHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d extends f {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static volatile d f365371m;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c dbHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/rmonitor/base/db/d$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/rmonitor/base/db/d;", "a", "", ReportPlugin.KEY_TABLE_NAME, "createSql", "", "b", "DATABASE_NAME", "Ljava/lang/String;", "helper", "Lcom/tencent/rmonitor/base/db/d;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.db.d$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final d a(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            d dVar = d.f365371m;
            if (dVar == null) {
                synchronized (this) {
                    dVar = d.f365371m;
                    if (dVar == null) {
                        dVar = new d(context);
                        d.f365371m = dVar;
                    }
                }
            }
            return dVar;
        }

        @JvmStatic
        public final void b(@NotNull String tableName, @NotNull String createSql) {
            Intrinsics.checkParameterIsNotNull(tableName, "tableName");
            Intrinsics.checkParameterIsNotNull(createSql, "createSql");
            f.INSTANCE.c(tableName, createSql);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context) {
        super(context, "rmonitor_db", null);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.dbHandler = c.INSTANCE.a(this);
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final c getDbHandler() {
        return this.dbHandler;
    }
}
