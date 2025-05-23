package com.tencent.rmonitor.metrics.looper;

import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
class LooperMetricReporter implements c {

    /* renamed from: a, reason: collision with root package name */
    private final d f365749a = new d();

    /* renamed from: b, reason: collision with root package name */
    private long f365750b = 3000;

    /* renamed from: c, reason: collision with root package name */
    private ReportTask f365751c = null;

    /* renamed from: d, reason: collision with root package name */
    private a f365752d = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ReportTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<LooperMetricReporter> f365754d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f365755e = false;

        public ReportTask(LooperMetricReporter looperMetricReporter) {
            this.f365754d = new WeakReference<>(looperMetricReporter);
        }

        public void cancel() {
            this.f365755e = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            LooperMetricReporter looperMetricReporter;
            if (!this.f365755e && (looperMetricReporter = this.f365754d.get()) != null) {
                looperMetricReporter.k();
                looperMetricReporter.f365751c = null;
                if (Logger.debug) {
                    Logger.f365497g.d("RMonitor_looper_metric", "try report sample, interval: " + looperMetricReporter.f365750b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final DropFrameResultMeta f365756a;

        /* renamed from: b, reason: collision with root package name */
        private final BlockingDeque<DropFrameResultMeta> f365757b;

        a() {
            this.f365756a = new DropFrameResultMeta();
            this.f365757b = new LinkedBlockingDeque(2000);
        }

        public ArrayList<JSONObject> a() {
            ArrayList<JSONObject> arrayList = new ArrayList<>();
            DropFrameResultMeta pollLast = this.f365757b.pollLast();
            do {
                if (pollLast != null) {
                    arrayList.add(pollLast.toJSONObject());
                }
                pollLast = this.f365757b.pollLast();
            } while (pollLast != null);
            DropFrameResultMeta dropFrameResultMeta = this.f365756a;
            if (dropFrameResultMeta.totalDuration > 0) {
                arrayList.add(dropFrameResultMeta.toJSONObject());
                this.f365756a.reset();
            }
            return arrayList;
        }

        public void b(DropFrameResultMeta dropFrameResultMeta) {
            boolean z16;
            try {
                z16 = this.f365757b.offerFirst(dropFrameResultMeta);
            } catch (Throwable unused) {
                z16 = false;
            }
            if (!z16) {
                this.f365756a.merge(dropFrameResultMeta);
            }
        }
    }

    private void g() {
        ReportTask reportTask = this.f365751c;
        if (reportTask != null) {
            reportTask.cancel();
            ThreadManager.cancelFromMonitorThread(reportTask);
        }
        this.f365751c = null;
    }

    private void j() {
        if (this.f365751c != null) {
            return;
        }
        ReportTask reportTask = new ReportTask(this);
        ThreadManager.runInMonitorThread(reportTask, this.f365750b);
        this.f365751c = reportTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ArrayList<JSONObject> arrayList;
        a aVar = this.f365752d;
        if (aVar != null) {
            arrayList = aVar.a();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Logger.f365497g.d("RMonitor_looper_metric", "report cache data(" + arrayList.size() + ")");
            ReportData c16 = new LooperMetricReportDataBuilder().c(BuglyMonitorName.FLUENCY_METRIC, TraceGenerator.getLaunchId(ContextUtil.getGlobalContext()), TraceGenerator.getProcessLaunchId(), arrayList);
            c16.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_ANY);
            ReporterMachine.f365411g.reportNow(c16, null);
        }
    }

    @Override // com.tencent.rmonitor.metrics.looper.c
    public void a(final DropFrameResultMeta dropFrameResultMeta) {
        ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.rmonitor.metrics.looper.LooperMetricReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (LooperMetricReporter.this.f365749a.b(BuglyMonitorName.FLUENCY_METRIC, dropFrameResultMeta)) {
                    LooperMetricReporter.this.f365749a.c(BuglyMonitorName.FLUENCY_METRIC, dropFrameResultMeta);
                    LooperMetricReporter.this.f365749a.a(dropFrameResultMeta);
                    a aVar = LooperMetricReporter.this.f365752d;
                    if (aVar != null) {
                        aVar.b(dropFrameResultMeta);
                    } else {
                        LooperMetricReporter.this.f365749a.e(BuglyMonitorName.FLUENCY_METRIC, dropFrameResultMeta);
                    }
                }
            }
        }, 0L);
    }

    public void h() {
        Logger.f365497g.i("RMonitor_looper_metric", "onBackground");
        if (this.f365752d != null) {
            j();
        }
    }

    public void i() {
        Logger.f365497g.i("RMonitor_looper_metric", "onForeground");
        g();
    }

    public void l(com.tencent.rmonitor.base.config.data.f fVar) {
        boolean z16;
        if (fVar != null) {
            this.f365750b = fVar.E;
            z16 = fVar.F;
        } else {
            z16 = true;
        }
        if (z16) {
            this.f365752d = new a();
        }
        Logger.f365497g.d("RMonitor_looper_metric", "start, reportBackground: " + z16);
        ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.rmonitor.metrics.looper.LooperMetricReporter.2
            @Override // java.lang.Runnable
            public void run() {
                LooperMetricReportDataBuilder looperMetricReportDataBuilder = new LooperMetricReportDataBuilder();
                looperMetricReportDataBuilder.e();
                List<ReportData> b16 = looperMetricReportDataBuilder.b();
                for (ReportData reportData : b16) {
                    reportData.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_ANY);
                    ReporterMachine.f365411g.reportNow(reportData, null);
                }
                Logger.f365497g.d("RMonitor_looper_metric", "report last launch looper metric data(" + b16.size() + ").");
            }
        }, 0L);
    }

    public void m() {
        Logger.f365497g.d("RMonitor_looper_metric", "stop");
        this.f365752d = null;
        g();
    }
}
