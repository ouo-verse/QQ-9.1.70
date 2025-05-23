package com.tencent.mobileqq.perf.memory.ceiling;

import com.tencent.cache.core.manager.api.c;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.perf.memory.config.a;
import com.tencent.mobileqq.perf.memory.largeobject.b;
import com.tencent.mobileqq.perf.process.util.b;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/ceiling/a;", "", "", "b", "", "heapCeiling", "pssCeiling", "Lcom/tencent/mobileqq/perf/memory/config/a$a;", DownloadInfo.spKey_Config, "c", "Lcom/tencent/mobileqq/perf/memory/collect/a;", "memoryUsage", "a", "", "I", "jHeapReportCount", "pssReportCount", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257668a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int jHeapReportCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int pssReportCount;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30236);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        a aVar = new a();
        f257668a = aVar;
        aVar.b();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("perf_mem_ceiling_yesterday_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - decodeLong > 86400000) {
            from.encodeLong("perf_mem_ceiling_yesterday_time", currentTimeMillis);
            from.encodeInt("jheap_ceiling_report_count", 0);
            from.encodeInt("pss_ceiling_report_count", 0);
            return;
        }
        jHeapReportCount = from.decodeInt("jheap_ceiling_report_count", 0);
        pssReportCount = from.decodeInt("pss_ceiling_report_count", 0);
        QLog.i("CeilingMonitor", 1, "initDailyReportCount jHeapCount:" + jHeapReportCount + ", pssCount" + pssReportCount + ", yesterday:" + decodeLong);
    }

    private final boolean c(boolean heapCeiling, boolean pssCeiling, a.C8201a config) {
        if (Math.random() < config.g()) {
            if (heapCeiling && jHeapReportCount < config.f()) {
                return true;
            }
            if (pssCeiling && pssReportCount < config.f()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void a(@NotNull com.tencent.mobileqq.perf.memory.collect.a memoryUsage) {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) memoryUsage);
            return;
        }
        Intrinsics.checkNotNullParameter(memoryUsage, "memoryUsage");
        a.C8201a n3 = com.tencent.mobileqq.perf.memory.config.a.f257676a.n();
        if (n3 == null) {
            QLog.e("CeilingMonitor", 1, "MemoryConfig is null");
            return;
        }
        int a16 = memoryUsage.a().a();
        int c16 = memoryUsage.a().c();
        int i3 = memoryUsage.c().i();
        boolean z17 = false;
        if (a16 > c16 * n3.d()) {
            QLog.e("CeilingMonitor", 1, "JavaHeap ceiling size:" + a16 + " count:" + jHeapReportCount);
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 > n3.e()) {
            QLog.e("CeilingMonitor", 1, "Pss ceiling size:" + i3 + " count:" + pssReportCount);
            z17 = true;
        }
        if (c(z16, z17, n3)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isJHeapCeiling", String.valueOf(z16));
            hashMap.put("isPssCeiling", String.valueOf(z17));
            hashMap.put("stage", SceneTracker.f());
            hashMap.put("allocMem", String.valueOf(a16));
            hashMap.put("maxMem", String.valueOf(c16));
            hashMap.put(MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, String.valueOf(i3));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (str == null) {
                str = "null";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "MobileQQ.sMobileQQ.peekA\u2026time()?.account ?: \"null\"");
            }
            hashMap.put("account", str);
            b bVar = b.f257946a;
            if (bVar.c()) {
                str2 = "Foreground";
            } else {
                str2 = "Background";
            }
            hashMap.put("appState", str2);
            c cVar = c.f98725d;
            long g16 = cVar.g();
            long c17 = cVar.c();
            hashMap.put("imageCache", String.valueOf(g16));
            hashMap.put("collectionCache", String.valueOf(c17));
            hashMap.put("unitedCache", String.valueOf(g16 + c17));
            b.Companion companion = com.tencent.mobileqq.perf.memory.largeobject.b.INSTANCE;
            hashMap.put("los_hook", String.valueOf(companion.a()));
            hashMap.put("liveTime", String.valueOf(bVar.h()));
            hashMap.put("processName", bVar.i());
            com.tencent.mobileqq.perf.report.a.a(hashMap);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "perfMemCeiling", true, 0L, 0L, hashMap, null);
            QLog.d("CeilingMonitor", 1, "finish report perfMemCeiling");
            if (z16) {
                companion.f();
                jHeapReportCount++;
                QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("jheap_ceiling_report_count", jHeapReportCount);
            }
            if (z17) {
                pssReportCount++;
                QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("pss_ceiling_report_count", pssReportCount);
            }
        }
    }
}
