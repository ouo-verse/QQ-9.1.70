package com.tencent.rmonitor.base.reporter.batch;

import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.db.c;
import com.tencent.rmonitor.base.db.d;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.a;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rmonitor/base/reporter/batch/ReportCacheImpl;", "Lcom/tencent/rmonitor/base/reporter/a;", "", "delay", "", "g", "f", "e", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "a", "b", "", "dbId", "Lcom/tencent/rmonitor/base/db/DBDataStatus;", "status", "c", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "reportTask", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ReportCacheImpl implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Runnable reportTask = new Runnable() { // from class: com.tencent.rmonitor.base.reporter.batch.ReportCacheImpl$reportTask$1
        @Override // java.lang.Runnable
        public final void run() {
            Logger.f365497g.d("RMonitor_report_ReportCacheImpl", "report cache data");
            new CollectRecordDataRunnable().run();
            ReportCacheImpl.this.g(7200000L);
        }
    };

    private final long e() {
        if (b.f365535j.a(BaseInfo.app)) {
            return 1000L;
        }
        return MiniBoxNoticeInfo.MIN_5;
    }

    private final void f(long delay) {
        ReporterMachine.f365411g.l(new Runnable() { // from class: com.tencent.rmonitor.base.reporter.batch.ReportCacheImpl$reportAttaData$1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.rmonitor.sla.b.f365843b.c();
            }
        }, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(long delay) {
        ReporterMachine.f365411g.l(this.reportTask, delay);
    }

    @Override // com.tencent.rmonitor.base.reporter.a
    public void a(@NotNull ReportData reportData) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        if (reportData.getDbId() <= 0) {
            PluginController.f365404b.a(reportData.getPluginName());
        }
        new StoreRecordDataRunnable(reportData).run();
    }

    @Override // com.tencent.rmonitor.base.reporter.a
    public void b() {
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_report_ReporterMachine", "reportCacheData");
        }
        long e16 = e();
        g(e16);
        f(e16);
    }

    @Override // com.tencent.rmonitor.base.reporter.a
    public void c(int dbId, @NotNull DBDataStatus status) {
        d dVar;
        c dbHandler;
        Intrinsics.checkParameterIsNotNull(status, "status");
        if (dbId > 0 && (dVar = BaseInfo.dbHelper) != null && (dbHandler = dVar.getDbHandler()) != null) {
            dbHandler.o(com.tencent.rmonitor.base.db.table.c.INSTANCE.a(), dbId, status.getValue());
        }
    }
}
