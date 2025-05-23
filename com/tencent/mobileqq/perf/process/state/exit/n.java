package com.tencent.mobileqq.perf.process.state.exit;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.process.backgroud.counter.ProcessRebootCounter;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0017\u001a\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u0014H\u0002J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004R\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010!R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010!R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/perf/process/state/exit/n;", "", "", "curTickRealTime", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curTickTime", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "updateResult", "r", ReportConstant.COSTREPORT_PREFIX, "l", "k", "", "g", "()Ljava/lang/Double;", "", tl.h.F, "()Ljava/lang/Integer;", "", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "kotlin.jvm.PlatformType", "i", "c", "j", "e", "d", "f", "o", "b", "I", "tickCount", "J", "goBackTimestamp", "lastTickTimestamp", "lastTickRealTimestamp", "lastTickWriteRealTimestamp", "deathGapHitTimes", "", "[Z", "reportDeepState", "", "[I", "reportDeepStateTime", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f257929a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int tickCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long goBackTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long lastTickTimestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long lastTickRealTimestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastTickWriteRealTimestamp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int deathGapHitTimes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static boolean[] reportDeepState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static int[] reportDeepStateTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f257929a = new n();
        deathGapHitTimes = -1;
        reportDeepState = new boolean[]{false, false, false};
        reportDeepStateTime = new int[]{60000, 180000, 300000};
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @WorkerThread
    private final Double g() {
        List<ActivityManager.RunningAppProcessInfo> i3 = i();
        if (i3 != null) {
            double d16 = 0.0d;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : i3) {
                double g16 = CpuUtil.f258160a.g(runningAppProcessInfo.pid);
                LockMethodProxy.sleep(10L);
                boolean z16 = true;
                QLog.i("SurvivalState", 1, "getAppCpu, " + runningAppProcessInfo.processName + ", " + g16);
                if (((float) g16) != -1.0f) {
                    z16 = false;
                }
                if (z16) {
                    g16 = 0.0d;
                }
                d16 += g16;
            }
            return Double.valueOf(d16);
        }
        return null;
    }

    @WorkerThread
    private final Integer h() {
        List<ActivityManager.RunningAppProcessInfo> i3 = i();
        if (i3 != null) {
            int i16 = 0;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : i3) {
                int totalPss = MemoryUtil.f258173a.p(runningAppProcessInfo.pid).getTotalPss();
                QLog.i("SurvivalState", 1, "getAppMemory, " + runningAppProcessInfo.processName + ", " + totalPss);
                i16 += totalPss;
            }
            return Integer.valueOf(i16);
        }
        return null;
    }

    private final List<ActivityManager.RunningAppProcessInfo> i() {
        boolean startsWith$default;
        Object systemService = BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(runningAppProcesses, "runningAppProcesses");
        ArrayList arrayList = new ArrayList();
        for (Object obj : runningAppProcesses) {
            String str = ((ActivityManager.RunningAppProcessInfo) obj).processName;
            Intrinsics.checkNotNullExpressionValue(str, "it.processName");
            String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
            Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
            if (startsWith$default) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long k() {
        long j3;
        ArrayList arrayList;
        long timestamp;
        int pid;
        boolean z16;
        if (Build.VERSION.SDK_INT >= 30) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            int i3 = fromV2.getInt("MemProcId", 0);
            List<ApplicationExitInfo> a16 = k.f257927a.a(10);
            boolean z17 = true;
            if (a16 != null) {
                arrayList = new ArrayList();
                for (Object obj : a16) {
                    pid = ((ApplicationExitInfo) obj).getPid();
                    if (pid == i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || !(!arrayList.isEmpty())) {
                z17 = false;
            }
            if (z17) {
                long currentTimeMillis = System.currentTimeMillis();
                timestamp = ((ApplicationExitInfo) arrayList.get(0)).getTimestamp();
                j3 = currentTimeMillis - timestamp;
                if (j3 > 0) {
                    MMKVOptionEntityV2 fromV22 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                    Intrinsics.checkNotNullExpressionValue(fromV22, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                    return com.tencent.mobileqq.startup.a.f289661b - fromV22.getLong("MemProcTickTime", 0L);
                }
                return j3;
            }
        }
        j3 = 0;
        if (j3 > 0) {
        }
    }

    private final void l() {
        if (deathGapHitTimes == -1) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            deathGapHitTimes = fromV2.getInt("MemProcDeathGapHitTimes", 0);
        }
    }

    private final void m(long curTickRealTime) {
        if (Math.random() > MainProcConfig.INSTANCE.e().H()[0].floatValue()) {
            return;
        }
        for (final int i3 = 2; -1 < i3; i3--) {
            boolean[] zArr = reportDeepState;
            if (!zArr[i3] && curTickRealTime - goBackTimestamp > reportDeepStateTime[i3]) {
                zArr[i3] = true;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.process.state.exit.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.n(i3);
                    }
                }, 16, null, false);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3) {
        if (com.tencent.mobileqq.perf.process.util.b.f257946a.b()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("backTime", String.valueOf(reportDeepStateTime[i3] / 1000));
            hashMap.put("mainPss", String.valueOf(SystemMethodProxy.getPss()));
            hashMap.put("mainCpu", String.valueOf(CpuUtil.h(CpuUtil.f258160a, 0, 1, null)));
            hashMap.put("mainJavaRatio", String.valueOf(com.tencent.cache.api.memory.a.f98606b.a().e()));
            n nVar = f257929a;
            Integer h16 = nVar.h();
            if (h16 != null) {
                hashMap.put("appPss", String.valueOf(h16.intValue()));
            }
            Double g16 = nVar.g();
            if (g16 != null) {
                hashMap.put("appCpu", String.valueOf(g16.doubleValue()));
            }
            com.tencent.mobileqq.perf.process.util.c.f257947a.a("MemoryDeepBackInfo", hashMap);
            QLog.d("SurvivalState", 1, "processDeepBackState, " + hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        n nVar = f257929a;
        nVar.r(nVar.s());
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putInt("MemProcId", Process.myPid());
        fromV2.putLong("MemProcAttachTime", com.tencent.mobileqq.startup.a.f289661b);
    }

    private final void q(long curTickTime) {
        if (Math.random() > MainProcConfig.INSTANCE.e().H()[1].floatValue()) {
            return;
        }
        long j3 = lastTickTimestamp;
        if (j3 != 0 && curTickTime - j3 > 120000) {
            long j16 = curTickTime - j3;
            long j17 = 1000;
            long j18 = j16 / j17;
            long j19 = (lastTickRealTimestamp - goBackTimestamp) / j17;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("backToSleepTime", String.valueOf(j19));
            hashMap.put("sleepTime", String.valueOf(j18));
            com.tencent.mobileqq.perf.process.util.c.f257947a.a("MemorySleepInfo", hashMap);
            QLog.d("SurvivalState", 1, "processSleepTime, " + hashMap);
        }
    }

    private final void r(boolean updateResult) {
        if (Math.random() > MainProcConfig.INSTANCE.e().H()[2].floatValue()) {
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long j3 = fromV2.getLong("MemProcTickTime", 0L);
        long j16 = fromV2.getLong("MemProcGotoBackTime", 0L);
        long j17 = fromV2.getLong("MemProcAttachTime", 0L);
        if (j3 > j16) {
            long j18 = j3 - j16;
            long j19 = 1000;
            long j26 = (j3 - j17) / j19;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("backToDeadTime", String.valueOf(j18 / j19));
            hashMap.put("aliveTime", String.valueOf(j26));
            if (updateResult) {
                hashMap.put("deathGapHitTimes", String.valueOf(deathGapHitTimes));
            }
            com.tencent.mobileqq.perf.process.util.c.f257947a.a("MemoryAliveInfo", hashMap);
            QLog.d("SurvivalState", 1, "processAliveTime, " + hashMap);
        }
    }

    private final boolean s() {
        int i3 = 0;
        if (!ProcessRebootCounter.f257837a.f()) {
            QLog.d("SurvivalState", 1, "checkFrequentlyReboot, exit type not match");
            return false;
        }
        if (k() < 120000) {
            i3 = deathGapHitTimes + 1;
        }
        deathGapHitTimes = i3;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putInt("MemProcDeathGapHitTimes", deathGapHitTimes);
        QLog.d("SurvivalState", 1, "checkFrequentlyReboot, " + deathGapHitTimes);
        return true;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        l();
        if (deathGapHitTimes >= 3) {
            return true;
        }
        return false;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (!MainProcConfig.INSTANCE.e().I()) {
                return;
            }
            goBackTimestamp = SystemClock.elapsedRealtime();
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            fromV2.putLong("MemProcGotoBackTime", goBackTimestamp);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            tickCount = 0;
            reportDeepState = new boolean[]{false, false, false};
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!MainProcConfig.INSTANCE.e().I()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        q(currentTimeMillis);
        m(elapsedRealtime);
        lastTickTimestamp = currentTimeMillis;
        lastTickRealTimestamp = elapsedRealtime;
        if (elapsedRealtime - lastTickWriteRealTimestamp >= 60000) {
            lastTickWriteRealTimestamp = elapsedRealtime;
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            fromV2.putLong("MemProcTickTime", elapsedRealtime);
        }
    }

    public final long j() {
        long coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        if (com.tencent.mobileqq.startup.a.f289663d > 0) {
            long j3 = com.tencent.mobileqq.startup.a.f289665f;
            boolean z16 = false;
            if (1 <= j3 && j3 < 30001) {
                z16 = true;
            }
            if (z16) {
                return j3;
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(com.tencent.mobileqq.startup.a.f289667h - com.tencent.mobileqq.startup.a.f289661b, 0L);
        return coerceAtLeast;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (!MainProcConfig.INSTANCE.e().I() || !Intrinsics.areEqual(MobileQQ.processName, MobileQQ.PACKAGE_NAME)) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.process.state.exit.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.p();
                }
            }, 16, null, false);
        }
    }
}
