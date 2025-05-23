package com.tencent.mobileqq.perf.process.backgroud.counter;

import android.app.Activity;
import android.app.ActivityManager;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.process.backgroud.counter.a;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.perf.process.state.exit.n;
import com.tencent.mobileqq.perf.process.util.b;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MemoryInjectUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J(\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/counter/ProcessRebootCounter;", "", "Lkotlin/Pair;", "", "", "a", "e", "c", "", "threshold", "Lcom/tencent/mobileqq/perf/process/backgroud/counter/ProcessRebootCounter$BackgroundCheck;", "from", "Lkotlin/Triple;", "", "b", "d", "result", "", "g", "f", "<init>", "()V", "BackgroundCheck", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProcessRebootCounter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ProcessRebootCounter f257837a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/counter/ProcessRebootCounter$BackgroundCheck;", "", "(Ljava/lang/String;I)V", "MAIN_KILL", "MAIN_KILL_SECOND", "MAIN_KILL_NO_LOGIN", "MAIN_GC", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class BackgroundCheck {
        private static final /* synthetic */ BackgroundCheck[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BackgroundCheck MAIN_GC;
        public static final BackgroundCheck MAIN_KILL;
        public static final BackgroundCheck MAIN_KILL_NO_LOGIN;
        public static final BackgroundCheck MAIN_KILL_SECOND;

        private static final /* synthetic */ BackgroundCheck[] $values() {
            return new BackgroundCheck[]{MAIN_KILL, MAIN_KILL_SECOND, MAIN_KILL_NO_LOGIN, MAIN_GC};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31803);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            MAIN_KILL = new BackgroundCheck("MAIN_KILL", 0);
            MAIN_KILL_SECOND = new BackgroundCheck("MAIN_KILL_SECOND", 1);
            MAIN_KILL_NO_LOGIN = new BackgroundCheck("MAIN_KILL_NO_LOGIN", 2);
            MAIN_GC = new BackgroundCheck("MAIN_GC", 3);
            $VALUES = $values();
        }

        BackgroundCheck(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static BackgroundCheck valueOf(String str) {
            return (BackgroundCheck) Enum.valueOf(BackgroundCheck.class, str);
        }

        public static BackgroundCheck[] values() {
            return (BackgroundCheck[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f257837a = new ProcessRebootCounter();
        }
    }

    ProcessRebootCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Pair<Boolean, String> a() {
        Set<String> set;
        Object obj;
        Object elementAt;
        n nVar = n.f257929a;
        if (nVar.c()) {
            QLog.i("ProcessGuard", 1, "don't exit main process, frequently reboot");
            return TuplesKt.to(Boolean.TRUE, "FrequentlyReboot");
        }
        MainProcConfig.Companion companion = MainProcConfig.INSTANCE;
        if (companion.e().h()) {
            long j3 = nVar.j();
            if (j3 > 1000) {
                QLog.i("ProcessGuard", 1, "don't exit main process, cold start cost: " + j3);
                return TuplesKt.to(Boolean.TRUE, "ColdStartLong");
            }
        }
        if (com.tencent.mobileqq.perf.process.state.screen.a.f257944a.c()) {
            QLog.i("ProcessGuard", 1, "don't exit main process, by screen lock");
            return TuplesKt.to(Boolean.TRUE, "ByScreenLock");
        }
        if (!c()) {
            QLog.i("ProcessGuard", 1, "don't exit main process, not in allowed time period");
            return TuplesKt.to(Boolean.TRUE, "NotInTimePeriod");
        }
        com.tencent.mobileqq.perf.process.state.notification.a aVar = com.tencent.mobileqq.perf.process.state.notification.a.f257942a;
        if (!aVar.b()) {
            set = CollectionsKt___CollectionsKt.toSet(companion.e().o());
            com.tencent.mobileqq.perf.process.state.floating.a aVar2 = com.tencent.mobileqq.perf.process.state.floating.a.f257938a;
            if (aVar2.a(set)) {
                QLog.d("ProcessGuard", 1, "current float window state, floating: " + aVar2.c());
                Boolean bool = Boolean.TRUE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("FloatWindow_");
                elementAt = CollectionsKt___CollectionsKt.elementAt(aVar2.c(), 0);
                sb5.append((String) elementAt);
                return TuplesKt.to(bool, sb5.toString());
            }
            List<String> j16 = b.f257946a.j();
            if (j16 != null) {
                Iterator<T> it = j16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (!Intrinsics.areEqual((String) obj, CoreService.KernelService.class.getName())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                String str = (String) obj;
                if (str != null) {
                    return TuplesKt.to(Boolean.TRUE, "ForegroundService_" + str);
                }
            }
            return null;
        }
        String a16 = aVar.a();
        QLog.i("ProcessGuard", 1, "don't exit main process, has " + a16 + " notification");
        return TuplesKt.to(Boolean.TRUE, "HasNotification_" + a16);
    }

    private final boolean c() {
        boolean z16;
        int i3 = Calendar.getInstance().get(11);
        List<Pair<Integer, Integer>> s16 = MainProcConfig.INSTANCE.e().s();
        if ((s16 instanceof Collection) && s16.isEmpty()) {
            return false;
        }
        Iterator<T> it = s16.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (i3 >= ((Number) pair.getFirst()).intValue() && i3 <= ((Number) pair.getSecond()).intValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final String e() {
        String str;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            str = topActivity.getClass().getName();
        } else {
            str = null;
        }
        if (str != null && !Intrinsics.areEqual(str, "com.tencent.mobileqq.activity.SplashActivity") && !Intrinsics.areEqual(str, "com.tencent.mobileqq.activity.QPublicFragmentActivity")) {
            return str;
        }
        return SceneTracker.f();
    }

    @NotNull
    public final Triple<Boolean, Long, Long> b(double threshold, @NotNull BackgroundCheck from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Triple) iPatchRedirector.redirect((short) 2, this, Double.valueOf(threshold), from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        MemoryUtil memoryUtil = MemoryUtil.f258173a;
        long j3 = 1048576;
        long f16 = memoryUtil.f() / j3;
        long h16 = memoryUtil.h() / j3;
        float f17 = ((float) f16) / ((float) h16);
        QLog.d("ProcessGuard", 1, "checkMainProcess, allMemory:" + f16 + ", maxMemory:" + h16 + ", memoryRatio:" + f17 + ", threshold:" + threshold + ", from:" + from);
        if (f17 >= threshold) {
            z16 = true;
        }
        return new Triple<>(Boolean.valueOf(z16), Long.valueOf(f16), Long.valueOf(h16));
    }

    @NotNull
    public final Pair<Boolean, String> d() {
        Object obj;
        Set set;
        Object firstOrNull;
        int collectionSizeOrDefault;
        Set set2;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Pair<Boolean, String> a16 = a();
        if (a16 != null) {
            return a16;
        }
        boolean z16 = true;
        if (MemoryInjectUtil.INSTANCE.getZPlanDownloadModState()) {
            QLog.i("ProcessGuard", 1, "don't exit main process, ZPlan download mod");
            return TuplesKt.to(Boolean.TRUE, "ZPlanDownload");
        }
        Set<Map.Entry<String, a.C8206a>> entrySet = a.f257838a.a().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "processToMemInfo.entries");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((a.C8206a) ((Map.Entry) obj).getValue()).b()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            QLog.i("ProcessGuard", 1, "don't exit main process, high priority process:" + ((String) entry.getKey()));
            return TuplesKt.to(Boolean.TRUE, "HighPriority_" + ((String) entry.getKey()));
        }
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses != null) {
            List<ActivityManager.RunningAppProcessInfo> list = runningAppProcesses;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList.add(((ActivityManager.RunningAppProcessInfo) it5.next()).processName);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                String it6 = (String) obj2;
                Intrinsics.checkNotNullExpressionValue(it6, "it");
                String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
                Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it6, PACKAGE_NAME, false, 2, null);
                if (startsWith$default) {
                    arrayList2.add(obj2);
                }
            }
            set2 = CollectionsKt___CollectionsKt.toSet(MainProcConfig.INSTANCE.e().d());
            set = CollectionsKt___CollectionsKt.intersect(arrayList2, set2);
        } else {
            set = null;
        }
        if (set == null || !(!set.isEmpty())) {
            z16 = false;
        }
        if (z16) {
            Boolean bool = Boolean.TRUE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("SubProcess_");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(set);
            sb5.append((String) firstOrNull);
            return TuplesKt.to(bool, sb5.toString());
        }
        String e16 = e();
        if (MainProcConfig.INSTANCE.e().C().contains(e16)) {
            return TuplesKt.to(Boolean.TRUE, "BlackScene_" + e16);
        }
        return TuplesKt.to(Boolean.FALSE, null);
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        boolean z16 = fromV2.getBoolean("key_main_process_do_reboot", false);
        QLog.i("ProcessGuard", 1, "getRebootStateToMMKV, result: " + z16);
        return z16;
    }

    public final void g(boolean result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, result);
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean("key_main_process_do_reboot", result);
        QLog.i("ProcessGuard", 1, "saveRebootStateToMMKV, result: " + result);
    }
}
