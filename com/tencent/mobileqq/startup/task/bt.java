package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.MSFCrashHandleListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.crashdefend.report.ReportSaveInfoHelper;
import com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper;
import com.tencent.qqperf.monitor.crash.QQCrashHandleListener;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.qqperf.monitor.crash.ReportLog;
import com.tencent.qqperf.monitor.logcathook.LogcatHook;
import cooperation.qzone.QZoneCrashHandler;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import mqq.app.lifecycle.ActivityLifeCycleMonitor;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bt;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "b", "Landroid/content/Context;", "context", "", "uin", "d", TencentLocation.RUN_MODE, "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bt extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicInteger f289820e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bt$a;", "", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", "sRdmState", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.bt$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f289820e = new AtomicInteger(0);
        }
    }

    public bt() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        com.tencent.mobileqq.bridge.a.f(new com.tencent.mobileqq.statistics.provider.report.a());
        com.tencent.mobileqq.bridge.a.i(new com.tencent.mobileqq.statistics.provider.report.c());
        com.tencent.mobileqq.bridge.a.g(new com.tencent.mobileqq.statistics.provider.report.b());
        com.tencent.mobileqq.bridge.a.h(new com.tencent.mobileqq.statistics.provider.statistic.b());
        com.tencent.mobileqq.bridge.a.e(new com.tencent.mobileqq.statistics.provider.statistic.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String uin) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact(uin);
    }

    private final void d(Context context, String uin) {
        try {
            ReportSaveInfoHelper.k(context, kd2.e.f412062a.e(), com.tencent.mobileqq.statistics.o.c(), uin);
        } catch (Throwable th5) {
            QLog.e("RdmInit", 1, "saveCrashDefendReportInfo failed!", th5);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:15|16|(13:(1:22)|23|(1:25)(1:53)|26|(1:28)|30|(1:32)|33|34|(1:38)|40|41|(3:43|(1:45)|47))|54|(1:58)|23|(0)(0)|26|(0)|30|(0)|33|34|(2:36|38)|40|41|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0103, code lost:
    
        if (r11.booleanValue() != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d7, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d8, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.qqperf.monitor.logcathook.LogcatHook.TAG, 1, "LogcatHook start failed !!", r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c A[Catch: Exception -> 0x00b8, TryCatch #1 {Exception -> 0x00b8, blocks: (B:16:0x004a, B:22:0x0058, B:23:0x0077, B:25:0x007c, B:26:0x009d, B:28:0x00ad, B:53:0x0091, B:54:0x0061, B:56:0x006b, B:58:0x006f), top: B:15:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ad A[Catch: Exception -> 0x00b8, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b8, blocks: (B:16:0x004a, B:22:0x0058, B:23:0x0077, B:25:0x007c, B:26:0x009d, B:28:0x00ad, B:53:0x0091, B:54:0x0061, B:56:0x006b, B:58:0x006f), top: B:15:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1 A[Catch: all -> 0x010d, TryCatch #2 {all -> 0x010d, blocks: (B:41:0x00e1, B:43:0x00f1, B:45:0x00f7, B:47:0x0105), top: B:40:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0091 A[Catch: Exception -> 0x00b8, TryCatch #1 {Exception -> 0x00b8, blocks: (B:16:0x004a, B:22:0x0058, B:23:0x0077, B:25:0x007c, B:26:0x009d, B:28:0x00ad, B:53:0x0091, B:54:0x0061, B:56:0x006b, B:58:0x006f), top: B:15:0x004a }] */
    @Override // com.tencent.qqnt.startup.task.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run(@NotNull Context context) {
        boolean a16;
        final String g16;
        int i3;
        boolean endsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        long nanoTime = System.nanoTime();
        String processName = MobileQQ.processName;
        b();
        StringBuilder sb5 = new StringBuilder("doStep process=");
        sb5.append(processName);
        sb5.append(", sRdmState=");
        AtomicInteger atomicInteger = f289820e;
        sb5.append(atomicInteger.get());
        QLog.d("RdmInit", 1, sb5.toString());
        if (atomicInteger.compareAndSet(0, 1)) {
            try {
                g16 = kd2.e.g();
                i3 = MobileQQ.sProcessId;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            try {
                if (i3 != 1 && i3 != 7) {
                    if (i3 == 2) {
                        Thread.setDefaultUncaughtExceptionHandler(new QZoneCrashHandler());
                    }
                    if (MobileQQ.sProcessId == 4) {
                        QQCrashReportManager.a().c(g16, new QQCrashHandleListener());
                        ActivityLifeCycleMonitor.setActivityLifeCycleMonitorHandle(new ny3.c());
                    } else {
                        QQCrashReportManager.a().c(g16, new MSFCrashHandleListener());
                    }
                    Intrinsics.checkNotNullExpressionValue(processName, "processName");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(processName, ":openSdk", false, 2, null);
                    if (!endsWith$default) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.startup.task.bs
                            @Override // java.lang.Runnable
                            public final void run() {
                                bt.c(g16);
                            }
                        }, 16, null, false);
                    }
                    if (MobileQQ.sProcessId == 1) {
                        d(context, kd2.e.g());
                    }
                    if (!LogcatHook.sLogcatHooked.get() && LogcatHook.ENABEL_SYSLOG_IN_RDM) {
                        LogcatHook.startHookLogcat();
                    }
                    a16 = com.tencent.mobileqq.utils.ck.f307533a.a();
                    my3.a a17 = my3.b.b().a();
                    if (!a16) {
                        if (!a17.f()) {
                            Boolean IS_DEBUG = ly3.a.f415786a;
                            Intrinsics.checkNotNullExpressionValue(IS_DEBUG, "IS_DEBUG");
                        }
                        ny3.a.a().e();
                    }
                }
                a16 = com.tencent.mobileqq.utils.ck.f307533a.a();
                my3.a a172 = my3.b.b().a();
                if (!a16) {
                }
            } catch (Throwable th5) {
                QLog.e("ActivityRecordIssueHelper", 1, "initActivityRecordIssueSafeHook failed !!", th5);
            }
            if (!CrashDefendManager.i().c() && MobileQQ.sProcessId == 1) {
                Thread.setDefaultUncaughtExceptionHandler(new ReportLog());
            }
            if (MobileQQ.sProcessId == 4) {
            }
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(processName, ":openSdk", false, 2, null);
            if (!endsWith$default) {
            }
            if (MobileQQ.sProcessId == 1) {
            }
            if (!LogcatHook.sLogcatHooked.get()) {
                LogcatHook.startHookLogcat();
            }
        }
        QLog.d("RdmInit", 1, "QQCrash Time Test Rdm doStep when init complete Cost:" + (System.nanoTime() - nanoTime));
        if (MobileQQ.sProcessId == 1) {
            StartUpCrashDefendDebugHelper.b(BaseApplicationImpl.sApplication, "testSecondCrashTest");
        }
    }
}
