package com.tencent.qmethod.monitor.report.base.reporter.batch;

import android.os.Handler;
import com.tencent.qmethod.monitor.base.util.AppInfo;
import com.tencent.qmethod.monitor.report.base.db.DBDataStatus;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.monitor.report.base.reporter.uvreport.a;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or3.b;
import or3.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/batch/ReportCacheImpl;", "Lor3/b;", "", "d", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "reportData", "", "b", "Lor3/c;", "reporter", "a", "", "dbId", "c", "Landroid/os/Handler;", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Handler;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class ReportCacheImpl implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: b, reason: collision with root package name */
    private static long f343840b = 60000;

    public ReportCacheImpl(@NotNull Handler handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        this.handler = handler;
    }

    private final long d() {
        return f343840b;
    }

    @Override // or3.b
    public void a(@NotNull c reporter) {
        Intrinsics.checkParameterIsNotNull(reporter, "reporter");
        this.handler.post(new Runnable() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.ReportCacheImpl$reportCacheData$1
            @Override // java.lang.Runnable
            public final void run() {
                a.f343854b.c();
            }
        });
        if (com.tencent.qmethod.pandoraex.core.collector.utils.a.j(AppInfo.INSTANCE.a())) {
            this.handler.postDelayed(new CollectRecordDataRunnable(this.handler, reporter), d());
            o.a("PMonitorReporterMachine", "reportCacheData mainProcess");
        }
    }

    @Override // or3.b
    public void b(@NotNull ReportData reportData) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        this.handler.post(new StoreRecordDataRunnable(reportData));
    }

    @Override // or3.b
    public void c(int dbId) {
        com.tencent.qmethod.monitor.report.base.db.c cVar;
        com.tencent.qmethod.monitor.report.base.db.b dbHandler;
        if (dbId > 0 && (cVar = nr3.a.f421181c) != null && (dbHandler = cVar.getDbHandler()) != null) {
            dbHandler.k(mr3.a.INSTANCE.a(), dbId, DBDataStatus.SENT.getValue());
        }
    }
}
