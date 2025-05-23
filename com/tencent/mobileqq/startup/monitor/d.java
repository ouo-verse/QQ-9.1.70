package com.tencent.mobileqq.startup.monitor;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.process.backgroud.counter.ProcessRebootCounter;
import com.tencent.mobileqq.perf.startup.SpeedUpUtil;
import com.tencent.mobileqq.perf.startup.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqperf.monitor.crash.tools.g;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\rR0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001dj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010(\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R\u0016\u0010*\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010.R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010.R\"\u00104\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b)\u00101\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/startup/monitor/d;", "", "", "p", "", "next", "i", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "j", "k", "", "isBgCreate", "w", "l", "r", "needReset", "reason", "c", "u", ReportConstant.COSTREPORT_PREFIX, "f", "e", "d", "hasBizSplash", "v", h.F, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mCostParams", "Ljava/lang/String;", "mCurState", "", "J", "mStateStartTime", "mStartupTime", "mColdStartTime", "g", "mWarmStartTime", "mActLoginA", "mMainCreateTime", "mMainShowTime", "Z", "mBackgroundStart", "mHasFirstSync", "()Z", "y", "(Z)V", "showGuildTab", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f289708a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> mCostParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long mStateStartTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long mStartupTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long mColdStartTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long mWarmStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long mActLoginA;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static long mMainCreateTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static long mMainShowTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean mBackgroundStart;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static boolean mHasFirstSync;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean showGuildTab;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        f289708a = new d();
        mCostParams = new HashMap<>();
        mCurState = "";
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void i(String next) {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Intrinsics.areEqual("ApplicationAttach", next)) {
            com.tencent.qqnt.startup.utils.d.f362285a.a("STATE_" + next, Process.myTid());
        } else {
            long j3 = mStateStartTime;
            long j16 = 0;
            if (j3 > 0) {
                j16 = uptimeMillis - j3;
            }
            QLog.d("NtStartupMonitor", 1, "curState: " + mCurState + " cost:" + j16 + ", nextState: " + next);
            com.tencent.qqnt.startup.utils.d dVar = com.tencent.qqnt.startup.utils.d.f362285a;
            String str = mCurState;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("STATE_");
            sb5.append(str);
            dVar.c(sb5.toString(), Process.myTid());
            if (!Intrinsics.areEqual("MainPageShow", next)) {
                dVar.a("STATE_" + next, Process.myTid());
            }
        }
        mCurState = next;
        mStateStartTime = uptimeMillis;
    }

    private final void p() {
        long j3 = mMainCreateTime;
        if (j3 > 0) {
            mCostParams.put("state2", String.valueOf(mMainShowTime - j3));
            QLog.d("NtStartupMonitor", 1, "Step2 MainCreate cost:" + (mMainShowTime - mMainCreateTime) + ", activeThread:" + Thread.activeCount());
        }
        final long j16 = com.tencent.mobileqq.startup.a.f289663d;
        long j17 = mMainShowTime;
        final long j18 = j17 - j16;
        final long j19 = j17 - mColdStartTime;
        if (j16 > 0 && NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            com.tencent.mobileqq.startup.a.f289663d = -mMainShowTime;
        } else {
            com.tencent.mobileqq.startup.a.f289663d = 0L;
        }
        final long j26 = mActLoginA;
        if (j16 > 0 && j18 < 30000) {
            com.tencent.mobileqq.startup.a.f289665f = j18;
            mCostParams.put("actLoginS", String.valueOf(j18));
            com.tencent.mobileqq.perf.replay.util.a.f258003a.a(j18);
            QLog.d("AutoMonitor", 1, "ActionLoginS, cost=" + j18);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.startup.monitor.b
            @Override // java.lang.Runnable
            public final void run() {
                d.q(j26, j16, j18, j19);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(long j3, long j16, long j17, long j18) {
        String str;
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        if (j3 > 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLoginA", true, j3, 0L, null, null);
        }
        if (j16 > 0 && j17 < 30000) {
            QLog.d("NtStartupMonitor", 1, "ActionLoginS, cost=" + j17);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j17));
            if (j18 > 0) {
                hashMap.put("coldCost", String.valueOf(j18));
            }
            long j19 = com.tencent.mobileqq.startup.a.f289673n;
            if (j19 > 0) {
                hashMap.put("sysLaunch", String.valueOf(j19));
            }
            if (showGuildTab) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("whichTab", str);
            HashMap<String, String> hashMap2 = mCostParams;
            String str2 = hashMap2.get("hitSnapshot");
            if (str2 != null) {
                hashMap.put("hitSnapshot", str2);
            }
            String str3 = hashMap2.get("isSyncEndBiz");
            if (str3 != null) {
                hashMap.put("isSyncEndBiz", str3);
            }
            hashMap.put("deviceLevel", String.valueOf(com.tencent.qqperf.tools.d.f363413a.a()));
            hashMap.put("isOpenThreadPoolMonitor", String.valueOf(f289708a.h()));
            f.a(hashMap);
            if (QLog.isColorLevel()) {
                for (String str4 : hashMap.keySet()) {
                    QLog.d("NtStartupMonitor", 2, "Report param: key=", str4, " value=", hashMap.get(str4));
                }
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLoginS", true, j17, 0L, hashMap, null);
            e.f289721a.c(mCostParams);
        }
        ProcessRebootCounter processRebootCounter = ProcessRebootCounter.f257837a;
        boolean f16 = processRebootCounter.f();
        HashMap<String, String> hashMap3 = mCostParams;
        hashMap3.put("isSelfReboot", String.valueOf(f16));
        if (f16) {
            processRebootCounter.g(false);
        }
        hashMap3.put("isLastCrash", String.valueOf(g.h()));
        hashMap3.put("deviceLevel", String.valueOf(com.tencent.qqperf.tools.d.f363413a.a()));
        d dVar = f289708a;
        hashMap3.put("isOpenThreadPoolMonitor", String.valueOf(dVar.h()));
        e.f289721a.a(hashMap3);
        if (com.tencent.mobileqq.startup.a.f289669j) {
            dVar.x();
        }
        SpeedUpUtil.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(long j3) {
        QLog.d("NtStartupMonitor", 1, "Real do msgSync report :" + com.tencent.mobileqq.startup.a.f289665f);
        e.f289721a.b(j3, mCostParams);
    }

    private final void x() {
        mStartupTime = 0L;
        mColdStartTime = 0L;
        mWarmStartTime = 0L;
        mMainCreateTime = 0L;
        mMainShowTime = 0L;
        mCurState = "";
    }

    public final void c(boolean needReset, @NotNull String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(needReset), reason);
            return;
        }
        Intrinsics.checkNotNullParameter(reason, "reason");
        QLog.d("NtStartupMonitor", 1, "clearIndicator " + reason);
        com.tencent.mobileqq.startup.a.f289662c = 0L;
        com.tencent.mobileqq.startup.a.f289663d = 0L;
        if (needReset) {
            x();
        }
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102617", false);
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102699", false);
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100658", false);
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return showGuildTab;
    }

    public final boolean h() {
        Map<Integer, JSONObject> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        try {
            com.tencent.mobileqq.perf.thread.config.e eVar = (com.tencent.mobileqq.perf.thread.config.e) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105477");
            if (eVar != null && (map = eVar.f258140d) != null && map.containsKey(16)) {
                return com.tencent.mobileqq.app.monitor.e.b(eVar.f258140d.get(16)).f196311a;
            }
            return false;
        } catch (Throwable th5) {
            QLog.e("NtStartupMonitor", 1, th5, new Object[0]);
            return false;
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        mWarmStartTime = SystemClock.uptimeMillis();
        i("ActivityAfterBgCreate");
        mBackgroundStart = true;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        mWarmStartTime = SystemClock.uptimeMillis();
        i("ActivityFirstCreate");
        mBackgroundStart = false;
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.startup.a.f289662c > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = uptimeMillis - com.tencent.mobileqq.startup.a.f289662c;
            mActLoginA = j3;
            Log.d("AutoMonitor", "ActionLoginA, cost=" + j3);
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                com.tencent.mobileqq.startup.a.f289662c = -uptimeMillis;
            } else {
                com.tencent.mobileqq.startup.a.f289662c = 0L;
            }
        }
        if (mColdStartTime > 0) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            mMainCreateTime = uptimeMillis2;
            mCostParams.put(QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_AD_FINGER_STATE_1, String.valueOf(uptimeMillis2 - mColdStartTime));
            QLog.d("NtStartupMonitor", 1, "Step1 NtTasks execute cost:" + (mMainCreateTime - mColdStartTime) + ", activeThread:" + Thread.activeCount());
        }
        i("ActivityRealCreate");
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            i("ApplicationCreate");
        }
    }

    public final void n() {
        long j3;
        long startUptimeMillis;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.startup.a.f289661b = SystemClock.elapsedRealtime();
        mColdStartTime = SystemClock.uptimeMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            startUptimeMillis = Process.getStartUptimeMillis();
            mStartupTime = startUptimeMillis;
        }
        long j16 = mStartupTime;
        if (j16 > 0) {
            j3 = mColdStartTime - j16;
        } else {
            j3 = -1;
        }
        com.tencent.mobileqq.startup.a.f289673n = j3;
        mCostParams.put("sysLaunch", String.valueOf(j3));
        Log.i("NtStartupMonitor", "curState: ProcessStart cost:" + j3 + ", nextState: ApplicationAttach, process:" + MobileQQ.processName);
        i("ApplicationAttach");
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.startup.a.f289662c = 0L;
        com.tencent.mobileqq.startup.a.f289663d = 0L;
        com.tencent.mobileqq.startup.a.f289670k = true;
        i("BackgroundCreate");
    }

    public final void r() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        i("MainPageShow");
        mMainShowTime = SystemClock.uptimeMillis();
        boolean startupHitSnapshot = ((IChatsUtil) QRoute.api(IChatsUtil.class)).startupHitSnapshot();
        long j16 = mColdStartTime;
        long j17 = 0;
        if (j16 > 0) {
            j3 = mMainShowTime - j16;
        } else {
            j3 = 0;
        }
        long j18 = mWarmStartTime;
        if (j18 > 0) {
            j17 = mMainShowTime - j18;
        }
        QLog.d("NtStartupMonitor", 1, "NtStartupEnd coldStartCost:" + j3 + ", warmStartCost:" + j17 + ", appSysLaunchCost:" + com.tencent.mobileqq.startup.a.f289673n + ", isBackgroundStart:" + mBackgroundStart + ", hitSnapshot:" + startupHitSnapshot);
        HashMap<String, String> hashMap = mCostParams;
        hashMap.put("coldCost", String.valueOf(j3));
        hashMap.put("warmCost", String.valueOf(j17));
        hashMap.put("isBackgroundStart", String.valueOf(mBackgroundStart));
        hashMap.put("hitSnapshot", String.valueOf(startupHitSnapshot));
        p();
        com.tencent.mobileqq.startup.a.f289671l = mMainShowTime;
        com.tencent.mobileqq.startup.a.f289668i = true;
        com.tencent.mobileqq.startup.a.f289674o = j3;
        com.tencent.mobileqq.startup.a.f289675p = j17;
    }

    public final void s() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (mColdStartTime > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = uptimeMillis - mColdStartTime;
            HashMap<String, String> hashMap = mCostParams;
            hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, String.valueOf(j3));
            long j16 = mMainShowTime;
            if (j16 > 0) {
                final long j17 = uptimeMillis - j16;
                com.tencent.mobileqq.startup.a.f289666g = j17;
                hashMap.put(QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_BUTTON, String.valueOf(j17));
                QLog.d("NtStartupMonitor", 1, "Step3 MsgSync cost:" + j17 + ", activeThread:" + Thread.activeCount());
                if (com.tencent.mobileqq.startup.a.f289663d < 0) {
                    long j18 = com.tencent.mobileqq.startup.a.f289665f;
                    if (1 <= j18 && j18 < 30001) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.startup.monitor.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.t(j17);
                            }
                        }, 16, null, false);
                    }
                }
            }
            if (mMainShowTime <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("NtStartupMonitor", 1, "onNtMsgSyncAllEnd, total cost:" + j3 + ", bgCreate:" + z16);
        }
        com.tencent.mobileqq.startup.a.f289669j = true;
        c(false, "MsgSyncEnd");
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (mColdStartTime > 0) {
            mHasFirstSync = true;
            long uptimeMillis = SystemClock.uptimeMillis() - mColdStartTime;
            mCostParams.put("firstSync", String.valueOf(uptimeMillis));
            QLog.d("NtStartupMonitor", 1, "onNtMsgSyncFirstEnd cost:" + uptimeMillis);
        }
    }

    public final void v(boolean hasBizSplash) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, hasBizSplash);
            return;
        }
        HashMap<String, String> hashMap = mCostParams;
        hashMap.put("hasBizSplash", String.valueOf(hasBizSplash));
        hashMap.put("isSyncEndBiz", String.valueOf(mHasFirstSync));
    }

    public final void w(boolean isBgCreate) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isBgCreate);
            return;
        }
        if (isBgCreate) {
            str = "SplashShowBgCreate";
        } else {
            str = "SplashShow";
        }
        i(str);
    }

    public final void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            showGuildTab = z16;
        }
    }
}
