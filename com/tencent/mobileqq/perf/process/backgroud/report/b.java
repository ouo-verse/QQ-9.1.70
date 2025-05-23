package com.tencent.mobileqq.perf.process.backgroud.report;

import android.app.ActivityManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.process.backgroud.counter.a;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J4\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H\u0002J \u0010\u000e\u001a\u00020\r2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0002H\u0002JB\u0010\u0014\u001a\u00020\u00072\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u00052\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\b\u0012\u0004\u0012\u00020\u0002`\u0012JB\u0010\u0016\u001a\u00020\u00072\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u00052\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\b\u0012\u0004\u0012\u00020\u0002`\u0012J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J(\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/report/b;", "", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "b", "", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "appProcess", "targetProcess", "", "a", "Lcom/tencent/mobileqq/perf/process/backgroud/counter/a$a;", "processToMemInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ceilingKillProcess", "g", "noImportProcess", "c", "", "allocJava", "maxJava", "d", "f", "result", "blockReason", "e", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f257873a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f257873a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(List<? extends ActivityManager.RunningAppProcessInfo> appProcess, String targetProcess) {
        if (appProcess == null) {
            return true;
        }
        List<? extends ActivityManager.RunningAppProcessInfo> list = appProcess;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ActivityManager.RunningAppProcessInfo) it.next()).processName.equals(targetProcess)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void b(String eventName, HashMap<String, String> params) {
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, eventName, true, 0L, 0L, params, "");
    }

    public final void c(@NotNull HashMap<String, a.C8206a> processToMemInfo, @NotNull ArrayList<String> noImportProcess) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) processToMemInfo, (Object) noImportProcess);
            return;
        }
        Intrinsics.checkNotNullParameter(processToMemInfo, "processToMemInfo");
        Intrinsics.checkNotNullParameter(noImportProcess, "noImportProcess");
        Collection<a.C8206a> values = processToMemInfo.values();
        Intrinsics.checkNotNullExpressionValue(values, "processToMemInfo.values");
        Iterator<T> it = values.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            i16 += ((a.C8206a) it.next()).d();
        }
        int i17 = i16 / 1024;
        Iterator<T> it5 = noImportProcess.iterator();
        int i18 = 0;
        while (it5.hasNext()) {
            a.C8206a c8206a = processToMemInfo.get((String) it5.next());
            if (c8206a != null) {
                i3 = c8206a.d();
            } else {
                i3 = 0;
            }
            i18 += i3;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("totalMemory", String.valueOf(i17));
        hashMap.put("killMemory", String.valueOf(i18));
        f257873a.b("report_5min_memory", hashMap);
    }

    public final void d(long allocJava, long maxJava) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(allocJava), Long.valueOf(maxJava));
            return;
        }
        if (!com.tencent.mobileqq.perf.memory.config.a.f257676a.p() && Math.random() > MainProcConfig.INSTANCE.e().v()) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("allocMemory", String.valueOf(allocJava));
        hashMap.put("maxMemory", String.valueOf(maxJava));
        hashMap.put("allocMemoryAfterGc", String.valueOf(MemoryUtil.f258173a.f() / 1048576));
        hashMap.put("memThreshold", String.valueOf(MainProcConfig.INSTANCE.e().A()));
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        hashMap.put("account", bVar.l());
        hashMap.put(QAdLoginDefine$LoginStatus.IS_LOGIN, String.valueOf(bVar.m()));
        f257873a.b("report_main_process_gc", hashMap);
    }

    public final void e(boolean result, @Nullable String blockReason, long allocJava, long maxJava) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(result), blockReason, Long.valueOf(allocJava), Long.valueOf(maxJava));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("allocMemory", String.valueOf(allocJava));
        hashMap.put("maxMemory", String.valueOf(maxJava));
        MainProcConfig.Companion companion = MainProcConfig.INSTANCE;
        hashMap.put("memThreshold", String.valueOf(companion.e().z()));
        hashMap.put("onlyReport", String.valueOf(companion.e().B()));
        hashMap.put("inBlackScene", String.valueOf(result));
        if (blockReason == null) {
            blockReason = "null";
        }
        hashMap.put("ignoreRebootReason", blockReason);
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        hashMap.put("account", bVar.k());
        hashMap.put(QAdLoginDefine$LoginStatus.IS_LOGIN, "true");
        hashMap.put("curHour", bVar.g());
        f257873a.b("report_main_process_kill", hashMap);
    }

    public final void f(long allocJava, long maxJava) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(allocJava), Long.valueOf(maxJava));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("allocMemory", String.valueOf(allocJava));
        hashMap.put("maxMemory", String.valueOf(maxJava));
        hashMap.put("memThreshold", String.valueOf(MainProcConfig.INSTANCE.e().A()));
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        hashMap.put("account", bVar.l());
        hashMap.put(QAdLoginDefine$LoginStatus.IS_LOGIN, "false");
        hashMap.put("curHour", bVar.g());
        f257873a.b("report_main_process_kill", hashMap);
    }

    public final void g(@NotNull HashMap<String, a.C8206a> processToMemInfo, @NotNull ArrayList<String> ceilingKillProcess) {
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) processToMemInfo, (Object) ceilingKillProcess);
            return;
        }
        Intrinsics.checkNotNullParameter(processToMemInfo, "processToMemInfo");
        Intrinsics.checkNotNullParameter(ceilingKillProcess, "ceilingKillProcess");
        for (String str : ceilingKillProcess) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("processName", str);
            a.C8206a c8206a = processToMemInfo.get(str);
            Boolean bool = null;
            if (c8206a != null) {
                num = Integer.valueOf(c8206a.d());
            } else {
                num = null;
            }
            hashMap.put(MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, String.valueOf(num));
            a.C8206a c8206a2 = processToMemInfo.get(str);
            if (c8206a2 != null) {
                bool = Boolean.valueOf(c8206a2.b());
            }
            hashMap.put("highPriority", String.valueOf(bool));
            f257873a.b("report_2s_process_kill", hashMap);
        }
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : ceilingKillProcess) {
            if (f257873a.a(runningAppProcesses, (String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : ceilingKillProcess) {
            if (!f257873a.a(runningAppProcesses, (String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        Set<String> keySet = processToMemInfo.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "processToMemInfo.keys");
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : keySet) {
            if (!arrayList2.contains((String) obj3)) {
                arrayList3.add(obj3);
            }
        }
        if (!com.tencent.mobileqq.perf.process.util.b.f257946a.c()) {
            for (String str2 : arrayList) {
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("processName", str2);
                a.C8206a c8206a3 = processToMemInfo.get(str2);
                if (c8206a3 != null) {
                    i18 = c8206a3.d();
                } else {
                    i18 = 0;
                }
                hashMap2.put(MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, String.valueOf(i18));
                a.C8206a c8206a4 = processToMemInfo.get(str2);
                if (c8206a4 != null) {
                    z16 = c8206a4.b();
                } else {
                    z16 = false;
                }
                hashMap2.put("highPriority", String.valueOf(z16));
                f257873a.b("report_2s_process_reboot", hashMap2);
            }
        }
        Iterator it = arrayList2.iterator();
        int i19 = 0;
        while (it.hasNext()) {
            a.C8206a c8206a5 = processToMemInfo.get((String) it.next());
            if (c8206a5 != null) {
                i17 = c8206a5.d();
            } else {
                i17 = 0;
            }
            i19 += i17;
        }
        int i26 = i19 / 1024;
        Iterator it5 = arrayList.iterator();
        int i27 = 0;
        while (it5.hasNext()) {
            a.C8206a c8206a6 = processToMemInfo.get((String) it5.next());
            if (c8206a6 != null) {
                i16 = c8206a6.d();
            } else {
                i16 = 0;
            }
            i27 += i16;
        }
        int i28 = i27 / 1024;
        Collection<a.C8206a> values = processToMemInfo.values();
        Intrinsics.checkNotNullExpressionValue(values, "processToMemInfo.values");
        Iterator<T> it6 = values.iterator();
        int i29 = 0;
        while (it6.hasNext()) {
            i29 += ((a.C8206a) it6.next()).d();
        }
        int i36 = i29 / 1024;
        Iterator it7 = arrayList3.iterator();
        int i37 = 0;
        while (it7.hasNext()) {
            a.C8206a c8206a7 = processToMemInfo.get((String) it7.next());
            if (c8206a7 != null) {
                i3 = c8206a7.d();
            } else {
                i3 = 0;
            }
            i37 += i3;
        }
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("killSuccessMemory", String.valueOf(i26));
        hashMap3.put("killFailMemory", String.valueOf(i28));
        hashMap3.put("totalMemory", String.valueOf(i36));
        hashMap3.put("remainMemory", String.valueOf(i37 / 1024));
        hashMap3.put("thresholdMemory", String.valueOf(com.tencent.mobileqq.perf.process.config.b.INSTANCE.b().d()));
        f257873a.b("report_2s_memory", hashMap3);
    }
}
