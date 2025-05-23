package com.tencent.rmonitor.launch;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AppLaunchReporter implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private static AppLaunchReporter f365610f;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.rmonitor.launch.a> f365611d = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f365612e = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f365613a;

        /* renamed from: b, reason: collision with root package name */
        public String f365614b;

        public a(String str, String str2) {
            this.f365613a = str;
            this.f365614b = str2;
        }
    }

    protected AppLaunchReporter() {
    }

    public static AppLaunchReporter getInstance() {
        if (f365610f == null) {
            synchronized (AppLaunchReporter.class) {
                if (f365610f == null) {
                    f365610f = new AppLaunchReporter();
                }
            }
        }
        return f365610f;
    }

    protected void a(com.tencent.rmonitor.launch.a aVar) {
        aVar.a();
        ReportData reportData = new ReportData(BaseInfo.userMeta.uin, 1, BuglyMonitorName.LAUNCH, aVar.f());
        s04.b.j().a(true, reportData);
        ReporterMachine.f365411g.reportNow(reportData, null);
    }

    public void checkReport() {
        ReporterMachine.f365411g.k(this);
    }

    public void report(com.tencent.rmonitor.launch.a aVar) {
        this.f365611d.add(aVar);
        checkReport();
    }

    public void reportError(String str, String str2) {
        this.f365612e.add(new a(str, str2));
        checkReport();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!g.a()) {
            Logger.f365497g.e("RMonitor_launch_report", "launch report fail for ", g.c());
            return;
        }
        PluginController pluginController = PluginController.f365404b;
        if (!pluginController.b(BuglyMonitorName.LAUNCH)) {
            Logger.f365497g.i("RMonitor_launch_report", "launch report fail for reach limit.");
            return;
        }
        if (!pluginController.f(BuglyMonitorName.LAUNCH)) {
            Logger.f365497g.i("RMonitor_launch_report", "launch report fail for disabled. ");
            return;
        }
        Iterator<com.tencent.rmonitor.launch.a> it = this.f365611d.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.f365611d.clear();
        Iterator<a> it5 = this.f365612e.iterator();
        while (it5.hasNext()) {
            a next = it5.next();
            com.tencent.rmonitor.sla.g.a("launch", BuglyMonitorName.LAUNCH, next.f365613a, ReportDataBuilder.getClientIdentify(BaseInfo.userMeta), next.f365614b);
        }
        this.f365612e.clear();
    }
}
