package com.tencent.mobileqq.perf.tracker;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.tencent.cache.api.memory.MemoryFlag;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.memory.collect.a;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@RequiresApi(29)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0006*\u0002\u001e\"\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/g;", "", "", "i", "", "", "Landroid/os/Debug$MemoryInfo;", "memoryInfoMap", "l", "g", "", "j", tl.h.F, "k", "processName", "Lcom/tencent/mobileqq/perf/memory/collect/a;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "b", "I", "procReportCount", "c", "backGroundReportCount", "d", "dailyReportCount", "Lcom/tencent/mobileqq/perf/config/plugin/f;", "e", "Lcom/tencent/mobileqq/perf/config/plugin/f;", "regularMemConfig", "com/tencent/mobileqq/perf/tracker/g$b", "f", "Lcom/tencent/mobileqq/perf/tracker/g$b;", "sceneChangedCallback", "com/tencent/mobileqq/perf/tracker/g$a", "Lcom/tencent/mobileqq/perf/tracker/g$a;", "handler", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f258254a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int procReportCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int backGroundReportCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int dailyReportCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.mobileqq.perf.config.plugin.f regularMemConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b sceneChangedCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/perf/tracker/g$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!Intrinsics.areEqual(SceneTracker.e(), MobileQQ.processName)) {
                return;
            }
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.encodeLong("regMem_last_get_time", SystemClock.uptimeMillis());
            if (!SceneTracker.j()) {
                com.tencent.mobileqq.perf.log.a.a("ME", "get background, backCount is " + g.backGroundReportCount);
                if (g.backGroundReportCount < g.regularMemConfig.a()) {
                    g.backGroundReportCount++;
                    sendEmptyMessageDelayed(0, MemoryUtil.f258173a.o());
                }
            } else {
                sendEmptyMessageDelayed(0, MemoryUtil.f258173a.o());
            }
            if (g.f258254a.j()) {
                Map<String, Debug.MemoryInfo> s16 = MemoryUtil.f258173a.s();
                for (Map.Entry<String, Debug.MemoryInfo> entry : s16.entrySet()) {
                    com.tencent.mobileqq.perf.log.a.a("ME", "processName: " + entry.getKey() + ", totalPss: " + entry.getValue().getTotalPss());
                }
                g.f258254a.l(s16);
                for (Map.Entry<String, Debug.MemoryInfo> entry2 : s16.entrySet()) {
                    g.f258254a.m(entry2.getKey(), a.Companion.c(com.tencent.mobileqq.perf.memory.collect.a.INSTANCE, entry2.getValue(), false, 2, null));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/perf/tracker/g$b", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "onProcessForeground", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                g.backGroundReportCount = 0;
                g.handler.removeMessages(0);
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                long decodeLong = from.decodeLong("regMem_last_get_time", 0L);
                long uptimeMillis = SystemClock.uptimeMillis() - decodeLong;
                MemoryUtil memoryUtil = MemoryUtil.f258173a;
                if (uptimeMillis >= memoryUtil.o()) {
                    g.handler.sendEmptyMessageDelayed(0, 10000L);
                    return;
                } else {
                    g.handler.sendEmptyMessageAtTime(0, decodeLong + memoryUtil.o());
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        g gVar = new g();
        f258254a = gVar;
        regularMemConfig = QQPerfConfigLoader.f257603a.b().g();
        b bVar = new b();
        sceneChangedCallback = bVar;
        a aVar = new a(QQPerfHandlerThreadManager.INSTANCE.d().getLooper());
        handler = aVar;
        if (gVar.k()) {
            if (QLog.isColorLevel()) {
                QLog.d("ME", 2, "RegularMemoryTracker is init");
            }
            procReportCount = 0;
            aVar.sendEmptyMessageDelayed(0, 10000L);
            SceneTracker.f258213d.l(bVar);
            gVar.i();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ME", 2, "RegularMemoryTracker not init");
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String g() {
        if (com.tencent.mobileqq.perf.memory.config.a.f257676a.p()) {
            return "actSceneMem_Vip";
        }
        return "actSceneMem";
    }

    private final void i() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("perf_regMem_report_yesterday_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeLong - currentTimeMillis > 86400000) {
            from.encodeLong("perf_regMem_report_yesterday_time", currentTimeMillis);
            from.encodeInt("perf_regMem_report_count", 0);
        } else {
            dailyReportCount = from.decodeInt("perf_regMem_report_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        if (com.tencent.mobileqq.perf.memory.config.a.f257676a.p()) {
            return true;
        }
        double random = Math.random();
        com.tencent.mobileqq.perf.config.plugin.f fVar = regularMemConfig;
        if (random < fVar.eventSampleRatio && (dailyReportCount < fVar.dailyReportLimit || procReportCount < fVar.procOnceReportLimit)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Map<String, ? extends Debug.MemoryInfo> memoryInfoMap) {
        Iterator<T> it = memoryInfoMap.values().iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            i16 += ((Debug.MemoryInfo) it.next()).getTotalPss();
        }
        Iterator<T> it5 = memoryInfoMap.values().iterator();
        int i17 = 0;
        while (it5.hasNext()) {
            i17 += ((Debug.MemoryInfo) it5.next()).nativePss;
        }
        Iterator<T> it6 = memoryInfoMap.values().iterator();
        int i18 = 0;
        while (it6.hasNext()) {
            i18 += ((Debug.MemoryInfo) it6.next()).dalvikPss;
        }
        Iterator<T> it7 = memoryInfoMap.values().iterator();
        while (it7.hasNext()) {
            i3 += com.tencent.cache.api.memory.a.f98606b.g((Debug.MemoryInfo) it7.next());
        }
        HashMap hashMap = new HashMap(30);
        hashMap.put("stage", SceneTracker.f());
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, String.valueOf(i16 / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, String.valueOf(i17 / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.DALVIKPSS, String.valueOf(i18 / 1024));
        hashMap.put("dexMmapPss", String.valueOf(i3));
        hashMap.put("isBackground", String.valueOf(!SceneTracker.j()));
        hashMap.put("isAppMemory", "true");
        hashMap.put("processName", SceneTracker.e());
        hashMap.put("processNum", String.valueOf(memoryInfoMap.size()));
        hashMap.put("account", com.tencent.mobileqq.perf.process.util.b.f257946a.k());
        hashMap.put("throttleTime", String.valueOf(MemoryUtil.f258173a.o()));
        hashMap.put("msgReceived", String.valueOf(com.tencent.mobileqq.startup.a.f289676q));
        PerfReportUtil.h(g(), hashMap);
        procReportCount++;
        dailyReportCount++;
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("perf_regMem_report_count", dailyReportCount);
        com.tencent.mobileqq.perf.log.a.a("ME", "now appTotalPss is " + i16 + ", appNativePss is " + i17 + ", appDalvikPss is " + i18 + "\uff0c isBack:" + ((String) hashMap.get("isBackground")) + ", msgReceived:" + ((String) hashMap.get("msgReceived")));
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (Math.random() >= regularMemConfig.sampleRatio && !com.tencent.mobileqq.perf.memory.config.a.f257676a.p()) {
            return false;
        }
        return true;
    }

    public final void m(@NotNull String processName, @NotNull com.tencent.mobileqq.perf.memory.collect.a data) {
        List<MemoryFlag> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) processName, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        Intrinsics.checkNotNullParameter(data, "data");
        HashMap hashMap = new HashMap(20);
        hashMap.put("processName", processName);
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        hashMap.put("account", bVar.k());
        hashMap.put("processLiveTime", String.valueOf(bVar.h()));
        hashMap.put("allocJavaHeap", String.valueOf(data.a().a() / 1024));
        hashMap.put("maxJavaHeap", String.valueOf(data.a().c() / 1024));
        hashMap.put("usedJavaRatio", String.valueOf(data.a().e()));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, String.valueOf(data.c().i() / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, String.valueOf(data.c().e() / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.DALVIKPSS, String.valueOf(data.c().b() / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.OTHERPSS, String.valueOf(data.c().f() / 1024));
        hashMap.put("swapPss", String.valueOf(data.c().h() / 1024));
        hashMap.put("codePss", String.valueOf(data.c().a() / 1024));
        hashMap.put("graphicsPss", String.valueOf(data.c().c() / 1024));
        hashMap.put("dexMmapPss", String.valueOf(data.c().g().get("dexMmap")));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MemoryFlag[]{MemoryFlag.OTHER_SO, MemoryFlag.OTHER_ART, MemoryFlag.OTHER_APK, MemoryFlag.OTHER_JAR, MemoryFlag.OTHER_OAT, MemoryFlag.OTHER_TTF, MemoryFlag.OTHER_DALVIK_OTHER});
        for (MemoryFlag memoryFlag : listOf) {
            hashMap.put(memoryFlag.getReportKey(), String.valueOf(data.c().g().get(memoryFlag.getReportKey())));
        }
        if (data.d() != null) {
            com.tencent.cache.api.memory.e d16 = data.d();
            Intrinsics.checkNotNull(d16);
            hashMap.put("totalMem", String.valueOf(d16.g()));
            com.tencent.cache.api.memory.e d17 = data.d();
            Intrinsics.checkNotNull(d17);
            hashMap.put("availMem", String.valueOf(d17.b()));
            com.tencent.cache.api.memory.e d18 = data.d();
            Intrinsics.checkNotNull(d18);
            hashMap.put("threshold", String.valueOf(d18.e()));
            com.tencent.cache.api.memory.e d19 = data.d();
            Intrinsics.checkNotNull(d19);
            hashMap.put("largeMemoryLimit", String.valueOf(d19.c()));
        }
        if (data.b() != null) {
            com.tencent.cache.api.memory.c b16 = data.b();
            Intrinsics.checkNotNull(b16);
            hashMap.put("nativeMallocAllocated", String.valueOf(b16.b()));
            com.tencent.cache.api.memory.c b17 = data.b();
            Intrinsics.checkNotNull(b17);
            hashMap.put("imageCache", String.valueOf(b17.a()));
        }
        if (Intrinsics.areEqual(processName, MobileQQ.PACKAGE_NAME) && Intrinsics.areEqual(MobileQQ.processName, MobileQQ.PACKAGE_NAME)) {
            hashMap.put("coldStartStage", String.valueOf(com.tencent.mobileqq.startup.b.f289681a.a()));
        }
        if (Intrinsics.areEqual(processName, SceneTracker.e())) {
            hashMap.put("stage", SceneTracker.f());
            hashMap.put("isBackground", String.valueOf(!SceneTracker.j()));
        }
        PerfReportUtil.h(g(), hashMap);
    }
}
