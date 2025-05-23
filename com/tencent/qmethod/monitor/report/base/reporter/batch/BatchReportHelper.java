package com.tencent.qmethod.monitor.report.base.reporter.batch;

import android.os.Handler;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import or3.c;
import or3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J(\u0010\t\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/batch/BatchReportHelper;", "", "Lkotlin/Function0;", "", "onEnd", "f", "", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "dataList", "d", "Ljava/util/ArrayDeque;", "a", "Lkotlin/Lazy;", "c", "()Ljava/util/ArrayDeque;", "pendingReportList", "Landroid/os/Handler;", "b", "()Landroid/os/Handler;", "handler", "Lor3/c;", "Lor3/c;", "reporter", "<init>", "(Lor3/c;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class BatchReportHelper {

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy pendingReportList;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy handler;

    /* renamed from: c, reason: from kotlin metadata */
    private final c reporter;

    public BatchReportHelper() {
        this(null, 1, null);
    }

    private final Handler b() {
        return (Handler) this.handler.getValue();
    }

    private final ArrayDeque<ReportData> c() {
        return (ArrayDeque) this.pendingReportList.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(BatchReportHelper batchReportHelper, List list, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        batchReportHelper.d(list, function0);
    }

    public final void f(final Function0<Unit> onEnd) {
        ReportData poll = c().poll();
        if (poll != null) {
            this.reporter.a(poll, null);
            b().postDelayed(new Runnable() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.BatchReportHelper$reportPendingList$$inlined$run$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    BatchReportHelper.this.f(onEnd);
                }
            }, 500L);
        } else if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final void d(@Nullable List<ReportData> dataList, @Nullable Function0<Unit> onEnd) {
        if (dataList != null) {
            ArrayDeque<ReportData> c16 = c();
            c16.clear();
            c16.addAll(dataList);
            if (!c().isEmpty()) {
                f(onEnd);
            }
        }
    }

    public BatchReportHelper(@NotNull c reporter) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkParameterIsNotNull(reporter, "reporter");
        this.reporter = reporter;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayDeque<ReportData>>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.BatchReportHelper$pendingReportList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayDeque<ReportData> invoke() {
                return new ArrayDeque<>();
            }
        });
        this.pendingReportList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.BatchReportHelper$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManager.f343506c.b());
            }
        });
        this.handler = lazy2;
    }

    public /* synthetic */ BatchReportHelper(c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? d.f423470e : cVar);
    }
}
