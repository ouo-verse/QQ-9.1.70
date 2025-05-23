package com.tencent.rmonitor.sla;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.RMonitor;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MetricAndSlaHelper implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    private boolean f365821e = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f365820d = false;

    /* renamed from: f, reason: collision with root package name */
    private final SLAReporter f365822f = new SLAReporter();

    /* renamed from: h, reason: collision with root package name */
    private final Handler f365823h = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final MetricAndSlaHelper f365824a = new MetricAndSlaHelper();
    }

    protected MetricAndSlaHelper() {
    }

    private void g() {
        if (!com.tencent.rmonitor.common.util.g.a()) {
            Logger.f365497g.i("RMonitor_metric_sla_Helper", "checkMetricReportInner, not match base info.");
        } else if (!this.f365821e) {
            com.tencent.rmonitor.common.util.g.d(new Runnable() { // from class: com.tencent.rmonitor.sla.MetricAndSlaHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!MetricAndSlaHelper.this.f365821e) {
                        MetricAndSlaHelper.this.f365821e = true;
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(BuglyMonitorName.FLUENCY_METRIC);
                        if (ProcessUtil.isMainProcess(BaseInfo.app)) {
                            arrayList.add(BuglyMonitorName.MEMORY_METRIC);
                        } else {
                            arrayList.add(BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS);
                        }
                        RMonitor.startMonitors(arrayList);
                    }
                }
            });
        }
    }

    private void i() {
        if (!com.tencent.rmonitor.common.util.g.a()) {
            Logger.f365497g.i("RMonitor_metric_sla_Helper", "checkSLAReportInner, not match base info limit.");
        } else if (!this.f365820d) {
            com.tencent.rmonitor.common.util.g.d(new Runnable() { // from class: com.tencent.rmonitor.sla.MetricAndSlaHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger logger = Logger.f365497g;
                    logger.i("RMonitor_metric_sla_Helper", "checkSLAReportInner, begin, isSLAReported: " + MetricAndSlaHelper.this.f365820d);
                    if (!MetricAndSlaHelper.this.f365820d) {
                        MetricAndSlaHelper.this.d();
                        MetricAndSlaHelper.this.k();
                    }
                    logger.i("RMonitor_metric_sla_Helper", "checkSLAReportInner, end, isSLAReported: " + MetricAndSlaHelper.this.f365820d);
                }
            });
        }
    }

    public static MetricAndSlaHelper l() {
        return a.f365824a;
    }

    public void d() {
        SLAReporter sLAReporter = this.f365822f;
        if (sLAReporter != null && !this.f365820d) {
            sLAReporter.b();
            Logger.f365497g.i("RMonitor_metric_sla_Helper", "beginStartRMonitor");
        }
    }

    public void e() {
        f();
        h();
    }

    public void f() {
        if (this.f365821e) {
            return;
        }
        this.f365823h.removeMessages(2);
        this.f365823h.sendEmptyMessageDelayed(2, 1000L);
    }

    public void h() {
        if (this.f365820d) {
            return;
        }
        this.f365823h.removeMessages(1);
        this.f365823h.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            i();
        } else if (i3 == 2) {
            g();
        }
        return true;
    }

    public void j() {
        this.f365821e = true;
        this.f365820d = true;
        this.f365823h.removeMessages(1);
        this.f365823h.removeMessages(2);
        Logger.f365497g.i("RMonitor_metric_sla_Helper", "disable metric and sla.");
    }

    public void k() {
        SLAReporter sLAReporter = this.f365822f;
        if (sLAReporter != null && !this.f365820d) {
            this.f365820d = sLAReporter.c(1);
            Logger.f365497g.i("RMonitor_metric_sla_Helper", "endStartRMonitor, isSLAReported: " + this.f365820d);
        }
    }
}
