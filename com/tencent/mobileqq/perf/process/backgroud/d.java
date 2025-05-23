package com.tencent.mobileqq.perf.process.backgroud;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.perf.memory.cache.AppStateMonitor;
import com.tencent.mobileqq.perf.process.backgroud.counter.ProcessPriorityCounter;
import com.tencent.mobileqq.perf.process.backgroud.counter.ProcessRebootCounter;
import com.tencent.mobileqq.perf.process.backgroud.counter.a;
import com.tencent.mobileqq.perf.process.broadcast.ProcessBroadcastReceiver;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.perf.process.config.b;
import com.tencent.mobileqq.perf.process.startup.BootMonitor;
import com.tencent.mobileqq.perf.process.state.exit.n;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.cq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J,\u0010\u000f\u001a\u00020\u000e2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J \u0010\u0014\u001a\u00020\u00022\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0011j\b\u0012\u0004\u0012\u00020\n`\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/d;", "Landroid/os/Handler$Callback;", "", "k", "", "tick", "l", "i", "w", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/perf/process/backgroud/counter/a$a;", "Lkotlin/collections/HashMap;", "processToMemInfo", "", "p", "u", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "exitProcessList", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "threshold", "o", ReportConstant.COSTREPORT_PREFIX, "r", "Landroid/os/Message;", "msg", "handleMessage", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/perf/process/broadcast/ProcessBroadcastReceiver;", "f", "Lcom/tencent/mobileqq/perf/process/broadcast/ProcessBroadcastReceiver;", "processBroadcastReceiver", "<set-?>", h.F, "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "appBackground", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final d f257845d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ProcessBroadcastReceiver processBroadcastReceiver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean appBackground;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/perf/process/backgroud/d$a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "tick", "onBackgroundTimeTick", "onBackgroundUnguardTimeTick", "onLiteTimeTick", "", "isEnabled", "onScreensStateChanged", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("ProcessGuard", 1, "application Background");
            d.appBackground = true;
            d.f257845d.k();
            com.tencent.mobileqq.perf.process.state.screen.a.f257944a.a();
            n.f257929a.d();
            com.tencent.cache.core.manager.api.c.f98725d.a().onAppBackground();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("ProcessGuard", 1, "application Foreground");
            d.appBackground = false;
            d.f257845d.w();
            com.tencent.mobileqq.perf.process.state.screen.a.f257944a.b();
            n.f257929a.e();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, tick);
                return;
            }
            d dVar = d.f257845d;
            dVar.l(tick);
            dVar.i(tick);
            n.f257929a.f();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, tick);
            } else {
                n.f257929a.f();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31564);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        d dVar = new d();
        f257845d = dVar;
        handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), dVar);
        processBroadcastReceiver = new ProcessBroadcastReceiver();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(long tick) {
        boolean z16;
        boolean z17;
        long j3 = 12000;
        long j16 = j3 * tick;
        long j17 = j16 - j3;
        MainProcConfig.Companion companion = MainProcConfig.INSTANCE;
        int y16 = companion.e().y();
        double A = companion.e().A();
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        boolean z18 = false;
        if (!bVar.m() && companion.e().E()) {
            long j18 = y16;
            if (j17 <= j18 && j18 <= j16) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && !n.f257929a.c()) {
                Triple<Boolean, Long, Long> b16 = ProcessRebootCounter.f257837a.b(A, ProcessRebootCounter.BackgroundCheck.MAIN_KILL_NO_LOGIN);
                if (b16.getFirst().booleanValue()) {
                    QLog.d("ProcessGuard", 1, "kill main process when no login and in background");
                    com.tencent.mobileqq.perf.process.backgroud.report.b.f257873a.f(b16.getSecond().longValue(), b16.getThird().longValue());
                    ThreadManagerV2.getUIHandlerV2().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.perf.process.backgroud.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.j();
                        }
                    });
                    return;
                }
                return;
            }
        }
        int x16 = companion.e().x();
        double z19 = companion.e().z();
        if (bVar.m() && companion.e().D()) {
            long j19 = x16;
            if (j17 <= j19 && j19 <= j16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && ProcessRebootCounter.f257837a.b(z19, ProcessRebootCounter.BackgroundCheck.MAIN_KILL).getFirst().booleanValue()) {
                f257845d.u();
                handler.sendEmptyMessageDelayed(3, com.tencent.mobileqq.perf.process.config.b.INSTANCE.b().c());
                return;
            }
        }
        int t16 = companion.e().t();
        double u16 = companion.e().u();
        if (companion.e().w()) {
            long j26 = t16;
            if (j17 <= j26 && j26 <= j16) {
                z18 = true;
            }
            if (z18) {
                Triple<Boolean, Long, Long> b17 = ProcessRebootCounter.f257837a.b(u16, ProcessRebootCounter.BackgroundCheck.MAIN_GC);
                if (b17.getFirst().booleanValue()) {
                    com.tencent.mobileqq.perf.process.backgroud.report.b.f257873a.d(b17.getSecond().longValue(), b17.getThird().longValue());
                    if (!bVar.c()) {
                        com.tencent.mobileqq.perf.memory.util.a.f257790a.b();
                    }
                }
            }
        }
        if (!companion.e().D() && tick == 1) {
            QLog.d("ProcessGuard", 1, "checkMainProcess disabled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        if (!bVar.c()) {
            QLog.i("ProcessGuard", 1, "exitSelf when no login");
            ProcessRebootCounter.f257837a.g(true);
            bVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        if (q()) {
            b.Companion companion = com.tencent.mobileqq.perf.process.config.b.INSTANCE;
            if (companion.b().e()) {
                u();
                handler.sendEmptyMessageDelayed(1, companion.b().c());
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProcessGuard", 2, "checkProcessInstantly disabled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(long tick) {
        if (q()) {
            b.Companion companion = com.tencent.mobileqq.perf.process.config.b.INSTANCE;
            if (companion.b().g()) {
                if (o(tick, (int) companion.b().h())) {
                    u();
                    handler.sendEmptyMessageDelayed(2, companion.b().c());
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel() && tick == 1) {
            QLog.d("ProcessGuard", 2, "checkProcessLater disabled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(HashMap processToMemInfo, ArrayList ceilingKillProcess) {
        Intrinsics.checkNotNullParameter(processToMemInfo, "$processToMemInfo");
        Intrinsics.checkNotNullParameter(ceilingKillProcess, "$ceilingKillProcess");
        com.tencent.mobileqq.perf.process.backgroud.report.b.f257873a.g(processToMemInfo, ceilingKillProcess);
    }

    private final boolean o(long tick, int threshold) {
        long j3 = 12000;
        long j16 = threshold;
        if (j3 * tick > j16 && j3 * (tick - 1) <= j16) {
            return true;
        }
        return false;
    }

    private final boolean p(HashMap<String, a.C8206a> processToMemInfo) {
        Collection<a.C8206a> values = processToMemInfo.values();
        Intrinsics.checkNotNullExpressionValue(values, "processToMemInfo.values");
        Iterator<T> it = values.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((a.C8206a) it.next()).d();
        }
        int i16 = i3 / 1024;
        b.Companion companion = com.tencent.mobileqq.perf.process.config.b.INSTANCE;
        if (i16 > companion.b().d()) {
            z16 = true;
        }
        QLog.i("ProcessGuard", 1, "needCeilingKillProcess, PssSum:" + i16 + ",  threshold:" + companion.b().d());
        return z16;
    }

    private final boolean q() {
        if (com.tencent.mobileqq.perf.process.util.b.f257946a.m() && com.tencent.mobileqq.perf.process.config.b.INSTANCE.b().i()) {
            return true;
        }
        return false;
    }

    private final void s() {
        boolean z16;
        QLog.i("ProcessGuard", 1, "schedule to kill main process");
        MainProcConfig.Companion companion = MainProcConfig.INSTANCE;
        double z17 = companion.e().z();
        ProcessRebootCounter processRebootCounter = ProcessRebootCounter.f257837a;
        Triple<Boolean, Long, Long> b16 = processRebootCounter.b(z17, ProcessRebootCounter.BackgroundCheck.MAIN_KILL_SECOND);
        if (!b16.getFirst().booleanValue()) {
            return;
        }
        Pair<Boolean, String> d16 = processRebootCounter.d();
        boolean booleanValue = d16.component1().booleanValue();
        String component2 = d16.component2();
        if (!booleanValue && com.tencent.mobileqq.perf.process.util.b.f257946a.c()) {
            QLog.i("ProcessGuard", 1, "don't exit main process, app is foreground");
            component2 = "AppIsForeground";
            z16 = true;
        } else {
            z16 = booleanValue;
        }
        com.tencent.mobileqq.perf.process.backgroud.report.b.f257873a.e(z16, component2, b16.getSecond().longValue(), b16.getThird().longValue());
        if (z16) {
            QLog.i("ProcessGuard", 1, "don't exit main process, reason: " + component2);
            return;
        }
        QLog.i("ProcessGuard", 1, "ready to kill main process");
        if (!companion.e().B()) {
            QLog.i("ProcessGuard", 1, "kill main process indeed");
            ThreadManagerV2.getUIHandlerV2().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.perf.process.backgroud.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.t();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        if (!bVar.c()) {
            ProcessRebootCounter.f257837a.g(true);
            bVar.e();
        }
    }

    private final void u() {
        Intent intent = new Intent("com.tencent.process.memory.count");
        intent.putExtra("process_verify", cq.c(null, false));
        BaseApplication.context.sendBroadcast(intent);
    }

    private final void v(ArrayList<String> exitProcessList) {
        if (exitProcessList.isEmpty()) {
            return;
        }
        Intent intent = new Intent("com.tencent.process.memory.exit");
        intent.putStringArrayListExtra("proc_nameList", exitProcessList);
        intent.putExtra("process_verify", cq.c(exitProcessList, false));
        BaseApplication.context.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Handler handler2 = handler;
        handler2.removeMessages(1);
        handler2.removeMessages(2);
        handler2.removeMessages(3);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (com.tencent.mobileqq.perf.process.util.b.f257946a.c()) {
            QLog.i("ProcessGuard", 1, "handleMessage, app activity is foreground");
            return true;
        }
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    s();
                }
            } else {
                QLog.i("ProcessGuard", 1, "kill no important process");
                HashMap<String, a.C8206a> a16 = com.tencent.mobileqq.perf.process.backgroud.counter.a.f257838a.a();
                ArrayList<String> h16 = ProcessPriorityCounter.f257834a.h(a16);
                v(h16);
                com.tencent.mobileqq.perf.process.backgroud.report.b.f257873a.c(a16, h16);
            }
        } else {
            final HashMap<String, a.C8206a> a17 = com.tencent.mobileqq.perf.process.backgroud.counter.a.f257838a.a();
            if (p(a17)) {
                QLog.i("ProcessGuard", 1, "ceiling kill process indeed");
                final ArrayList<String> f16 = ProcessPriorityCounter.f257834a.f(a17);
                v(f16);
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.perf.process.backgroud.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.n(a17, f16);
                    }
                }, 16, null, false, 1000L);
            }
        }
        return true;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return appBackground;
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        processBroadcastReceiver.d();
        n.f257929a.o();
        SceneTracker sceneTracker = SceneTracker.f258213d;
        sceneTracker.l(AppStateMonitor.f257658a.g());
        sceneTracker.l(BootMonitor.f257924a.c());
        GuardManagerCallbackDispatcher.registerCallBack(new a());
    }
}
