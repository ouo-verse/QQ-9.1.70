package com.tencent.qmethod.monitor.report.base.db;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/db/c;", "Lcom/tencent/qmethod/monitor/report/base/db/d;", "Lcom/tencent/qmethod/monitor/report/base/db/b;", "f", "Lcom/tencent/qmethod/monitor/report/base/db/b;", "d", "()Lcom/tencent/qmethod/monitor/report/base/db/b;", "dbHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c extends d {

    /* renamed from: h, reason: collision with root package name */
    private static volatile c f343825h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b dbHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/db/c$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qmethod/monitor/report/base/db/c;", "a", "", "DATABASE_NAME", "Ljava/lang/String;", "helper", "Lcom/tencent/qmethod/monitor/report/base/db/c;", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.report.base.db.c$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final c a(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            c cVar = c.f343825h;
            if (cVar == null) {
                synchronized (this) {
                    cVar = c.f343825h;
                    if (cVar == null) {
                        cVar = new c(context);
                        c.f343825h = cVar;
                    }
                }
            }
            return cVar;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context, "p_monitor_db", null);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.dbHandler = b.INSTANCE.a(this);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final b getDbHandler() {
        return this.dbHandler;
    }
}
