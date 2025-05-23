package com.tencent.qqperf.monitor.crash;

import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.i;
import com.tencent.hippy.qq.exception.QQHippyException;
import com.tencent.mobileqq.activity.aio.o;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.app.message.k;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.bgprobe.BackgroundException;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.ConversationInfoErrorReporter;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.nearby.n;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.perf.thread.proxy.ThreadProxyMonitor;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.splashad.l;
import com.tencent.mobileqq.statistics.r;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.theme.ThemeService;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.mobileqq.wink.api.IWinkReport;
import com.tencent.open.base.MD5Utils;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import com.tencent.qmethod.pandoraex.core.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtQZonePluginException;
import com.tencent.qqperf.monitor.crash.catchedexception.a;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.SingleLineTextView;
import cooperation.plugin.PluginCrashException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements a.InterfaceC9710a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f363188a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f363189b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final Set<Class> f363190c = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    private final my3.a f363191d = my3.b.b().a();

    private void d(Class cls) {
        if (cls == null) {
            QLog.e("CaughtExceptionReport.Checker", 1, "addQRouteClass qRouteClassInterfaceClass is null");
            return;
        }
        if (!IRuntimeService.class.isAssignableFrom(cls) && !QRouteApi.class.isAssignableFrom(cls)) {
            QLog.e("CaughtExceptionReport.Checker", 1, "addQRouteClass qRouteClassName is not QRouteClass, qRouteClassInterfaceClass is " + cls.getName());
            return;
        }
        String a16 = com.tencent.mobileqq.qroute.utils.e.a(cls);
        if (TextUtils.isEmpty(a16)) {
            QLog.e("CaughtExceptionReport.Checker", 1, "addQRouteClass qRouteClassName is null, qRouteClassInterfaceClass is " + cls.getName());
            return;
        }
        this.f363189b.add(a16);
    }

    private void e() {
        this.f363189b.add(BaseActivity.class.getName());
        this.f363189b.add(m.class.getName());
        this.f363189b.add(i.class.getName());
        this.f363189b.add(im2.b.class.getName());
        this.f363189b.add(SingleLineTextView.class.getName());
        this.f363189b.add(o.class.getName());
        this.f363189b.add(SecurityUtile.class.getName());
        this.f363189b.add(k.class.getName());
        this.f363189b.add(ConversationInfo.class.getName());
        this.f363189b.add(n.d());
        this.f363189b.add(n.c());
        this.f363189b.add(ReportLog.class.getName());
        this.f363189b.add(com.tencent.mobileqq.statistics.e.class.getName());
        this.f363189b.add(ThreadManagerInitialler.class.getName());
        this.f363189b.add(r.class.getName());
        this.f363189b.add(MD5Utils.class.getName());
        this.f363189b.add(RecentUserProxy.class.getName());
        this.f363189b.add(((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getBGLocateMonitorClassName());
        this.f363189b.add(com.tencent.mobileqq.mutualmark.a.class.getName());
        this.f363189b.add(ConversationInfoErrorReporter.class.getName());
        this.f363189b.add(com.tencent.imcore.message.msgproxy.b.class.getName());
        this.f363189b.add(py3.b.class.getName());
        this.f363189b.add(MonitorReporter.class.getName());
        this.f363189b.add(x.class.getName());
        this.f363189b.add(FitSystemWindowsRelativeLayout.class.getName());
        this.f363189b.add(ConversationContainer.class.getName());
        this.f363189b.add(NativeMemoryMonitor.class.getName());
        this.f363189b.add(NativeMonitorConfigHelper.class.getName());
        this.f363189b.add(com.tencent.mobileqq.perf.thread.block.d.class.getName());
        this.f363189b.add(com.tencent.mobileqq.activity.contacts.topentry.e.class.getName());
        this.f363189b.add(id3.c.class.getName());
        this.f363189b.add(ThemeService.class.getName());
        this.f363189b.add(((IQQKuiklyReport) QRoute.api(IQQKuiklyReport.class)).getReportClassName());
        this.f363189b.add(l.class.getName());
    }

    private void f() {
        this.f363190c.add(CaughtQZonePluginException.class);
        this.f363190c.add(PluginCrashException.class);
        this.f363190c.add(BackgroundException.class);
        this.f363190c.add(QConfigureException.class);
        this.f363190c.add(QQHippyException.class);
        this.f363190c.add(ThreadProxyMonitor.ThreadProxyException.class);
    }

    private void g() {
        d(IColorNoteHelper.class);
        d(IOnlineStatusManagerService.class);
        d(IWinkReport.class);
    }

    private void h() {
        this.f363189b.add("com.tencent.mobileqq.fts.operator.FTSMsgOperator");
        this.f363189b.add("com.tencent.msf.boot.config");
        this.f363189b.add("com.tencent.mobileqq.msf.service");
        this.f363189b.add("com.tencent.mobileqq.msf.core");
        this.f363189b.add("com.tencent.mobileqq.msf.sdk.report");
        this.f363189b.add("com.tencent.mobileqq.msf.core.report");
    }

    @Override // com.tencent.qqperf.monitor.crash.catchedexception.a.InterfaceC9710a
    public boolean a(Throwable th5) {
        boolean j3 = this.f363191d.j();
        if (this.f363191d.c().size() == 0) {
            return j3;
        }
        StackTraceElement[] stackTrace = th5.getStackTrace();
        if (stackTrace != null && stackTrace.length >= 1) {
            String className = stackTrace[0].getClassName();
            for (String str : this.f363191d.c()) {
                if (str != null && className.contains(str)) {
                    return true;
                }
            }
        }
        return j3;
    }

    @Override // com.tencent.qqperf.monitor.crash.catchedexception.a.InterfaceC9710a
    public boolean b() {
        if (new Random().nextInt(100) <= this.f363191d.e()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqperf.monitor.crash.catchedexception.a.InterfaceC9710a
    public boolean c(Throwable th5) {
        if (this.f363190c.contains(th5.getClass())) {
            return true;
        }
        StackTraceElement[] stackTrace = th5.getStackTrace();
        if (stackTrace != null && stackTrace.length >= 1) {
            String className = stackTrace[0].getClassName();
            for (String str : this.f363189b) {
                if (str != null && className.startsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized void i() {
        if (!this.f363188a) {
            e();
            f();
            g();
            h();
            this.f363188a = true;
        }
    }
}
