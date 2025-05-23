package com.tencent.mobileqq.perf.thread.proxy;

import android.os.Build;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.perf.thread.proxy.b;
import com.tencent.mobileqq.perf.thread.proxy.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.api.IExecutor;
import com.tencent.thread.monitor.plugin.api.ILog;
import com.tencent.thread.monitor.plugin.api.IReporter;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/thread/proxy/c;", "", "", "a", "", "d", "flag", "c", "b", "e", "f", "com/tencent/mobileqq/perf/thread/proxy/c$a", "Lcom/tencent/mobileqq/perf/thread/proxy/c$a;", "logProxy", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f258155a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a logProxy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/perf/thread/proxy/c$a", "Lcom/tencent/thread/monitor/plugin/api/ILog;", "", "tag", "msg", "", "d", "e", "", ReportConstant.COSTREPORT_TRANS, "i", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements ILog {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.api.ILog
        public void d(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (ProxyController.INSTANCE.getDebugMode()) {
                QLog.d(tag, 1, msg2);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.api.ILog
        public void e(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, 1, msg2);
        }

        @Override // com.tencent.thread.monitor.plugin.api.ILog
        public void i(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(tag, 1, msg2);
        }

        @Override // com.tencent.thread.monitor.plugin.api.ILog
        public void e(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, tag, msg2, tr5);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(tr5, "tr");
            QLog.e(tag, 1, msg2, tr5);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/perf/thread/proxy/c$b", "Lcom/tencent/thread/monitor/plugin/api/IReporter;", "", "reportFixOOM", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements IReporter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.api.IReporter
        public void reportFixOOM() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "thread_oom_optimize", true, 0L, 0L, null, "");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/perf/thread/proxy/c$c", "Lcom/tencent/thread/monitor/plugin/api/IExecutor;", "Ljava/lang/Runnable;", "command", "", "delay", "Ljava/util/concurrent/TimeUnit;", "unit", "", "schedule", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.thread.proxy.c$c, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8213c implements IExecutor {
        static IPatchRedirector $redirector_;

        C8213c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.api.IExecutor
        public void schedule(@NotNull Runnable command, long delay, @NotNull TimeUnit unit) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, command, Long.valueOf(delay), unit);
                return;
            }
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(unit, "unit");
            ThreadManagerV2.executeDelay(command, 16, null, false, delay);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/perf/thread/proxy/c$d", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationBackground", "onApplicationForeground", "", "tick", "onBackgroundTimeTick", "onBackgroundUnguardTimeTick", "onLiteTimeTick", "", "isEnabled", "onScreensStateChanged", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements IGuardInterface {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3) {
            int trimThreads = ProxyController.INSTANCE.trimThreads(false);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("trimSize", String.valueOf(trimThreads));
            hashMap.put("countBefore", String.valueOf(i3));
            hashMap.put("countAfter", String.valueOf(Thread.activeCount()));
            StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "thread_trim_optimize", true, 0L, 0L, hashMap, "");
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
            final int activeCount;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, tick);
            } else if (tick == 1 && (activeCount = Thread.activeCount()) < com.tencent.mobileqq.perf.thread.proxy.b.INSTANCE.b().e().d()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.thread.proxy.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.d.b(activeCount);
                    }
                }, 16, null, false);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, isEnabled);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f258155a = new c();
            logProxy = new a();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        b.Companion companion = com.tencent.mobileqq.perf.thread.proxy.b.INSTANCE;
        if (!companion.b().k()) {
            return false;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = MANUFACTURER.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return com.tencent.mobileqq.perf.process.util.b.f257946a.d(companion.b().e().a(), lowerCase, 0);
    }

    private final boolean b() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.contains("function_no_crash_flag");
        return fromV2.getBoolean("function_no_crash_flag", false);
    }

    private final void c(boolean flag) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean("function_no_crash_flag", flag);
    }

    private final void d() {
        QLog.i("ThreadProxy_manger", 1, "registerToGuardManager");
        ProxyController proxyController = ProxyController.INSTANCE;
        proxyController.setIReporter(new b());
        proxyController.setIExecutor(new C8213c());
        GuardManagerCallbackDispatcher.registerCallBack(new d());
    }

    public final void e() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ProxyController proxyController = ProxyController.INSTANCE;
        proxyController.setLogger(logProxy);
        if (!com.tencent.mobileqq.perf.process.util.b.f257946a.n()) {
            return;
        }
        QLog.i("ThreadProxy_manger", 1, "start monitor, " + proxyController.getEnabled());
        if (!a()) {
            return;
        }
        double random = Math.random();
        b.Companion companion = com.tencent.mobileqq.perf.thread.proxy.b.INSTANCE;
        if (random >= companion.b().l()) {
            QLog.i("ThreadProxy_manger", 1, "start monitor, not match user sample");
            return;
        }
        proxyController.setEnabled(!b());
        if (proxyController.getEnabled()) {
            proxyController.setEnableOptimized(companion.b().h());
            proxyController.setTrimThreadCountOnce(companion.b().e().b());
            proxyController.setTimeThreadWaitTime(companion.b().e().c());
            if ((!AppSetting.isPublicVersion() || AppSetting.isGrayVersion()) && Math.random() < companion.b().d()) {
                z16 = true;
            } else {
                z16 = false;
            }
            proxyController.setNeedRecordStack(z16);
            proxyController.setStackDepth(companion.b().j());
            d();
        }
        proxyController.resetAsyncTask();
        c(true);
        QLog.i("ThreadProxy_manger", 1, "start monitor end, " + proxyController.getEnabled());
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!com.tencent.mobileqq.perf.process.util.b.f257946a.n()) {
            return;
        }
        c(false);
        if (!a()) {
            ProxyController proxyController = ProxyController.INSTANCE;
            proxyController.setEnabled(false);
            proxyController.setEnableOptimized(false);
        }
        QLog.i("ThreadProxy_manger", 1, "receive config, " + ProxyController.INSTANCE.getEnabled());
    }
}
