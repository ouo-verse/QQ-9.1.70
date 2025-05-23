package com.tencent.mobileqq.perf.memory;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.perf.memory.config.a;
import com.tencent.mobileqq.perf.memory.dump.MemoryFile;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.perf.upload.cos.PerfCosUploader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.soso.location.SosoInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002#$B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0016\u0010 \u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/FaultMonitor;", "", "Lcom/tencent/mobileqq/perf/memory/config/a$a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/perf/memory/collect/a;", "memoryUsage", "", "e", "", "nowScene", "Lcom/tencent/mobileqq/perf/memory/FaultMonitor$a;", "c", "context", "Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", "d", "checkContext", "Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$a;", "g", "i", h.F, "b", "", "I", "reportCount", "reportCountInProcess", "", "J", "lastReportTime", "", "Z", "isDumping", "f", "dropBackToNormal", "<init>", "()V", "a", "TriggerType", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class FaultMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FaultMonitor f257645a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile int reportCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile int reportCountInProcess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile long lastReportTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isDumping;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean dropBackToNormal;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", "", "(Ljava/lang/String;I)V", "TOTAL_PSS", "JAVA_HEAP", "BOTH", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class TriggerType {
        private static final /* synthetic */ TriggerType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TriggerType BOTH;
        public static final TriggerType JAVA_HEAP;
        public static final TriggerType TOTAL_PSS;

        private static final /* synthetic */ TriggerType[] $values() {
            return new TriggerType[]{TOTAL_PSS, JAVA_HEAP, BOTH};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28866);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TOTAL_PSS = new TriggerType("TOTAL_PSS", 0);
            JAVA_HEAP = new TriggerType("JAVA_HEAP", 1);
            BOTH = new TriggerType("BOTH", 2);
            $VALUES = $values();
        }

        TriggerType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TriggerType valueOf(String str) {
            return (TriggerType) Enum.valueOf(TriggerType.class, str);
        }

        public static TriggerType[] values() {
            return (TriggerType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u000e\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/FaultMonitor$a;", "", "", "a", "I", "d", "()I", "i", "(I)V", MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, "b", "f", "javaAllocMemory", "", "c", UserInfo.SEX_FEMALE, "()F", "g", "(F)V", "javaUsedRatio", "Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", "Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", "e", "()Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", "j", "(Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;)V", "triggerType", "", "Ljava/lang/String;", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", "scene", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int totalPss;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int javaAllocMemory;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float javaUsedRatio;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TriggerType triggerType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String scene;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.javaAllocMemory;
        }

        public final float b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.javaUsedRatio;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.scene;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.totalPss;
        }

        @Nullable
        public final TriggerType e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (TriggerType) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.triggerType;
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.javaAllocMemory = i3;
            }
        }

        public final void g(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            } else {
                this.javaUsedRatio = f16;
            }
        }

        public final void h(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            } else {
                this.scene = str;
            }
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.totalPss = i3;
            }
        }

        public final void j(@Nullable TriggerType triggerType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) triggerType);
            } else {
                this.triggerType = triggerType;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        FaultMonitor faultMonitor = new FaultMonitor();
        f257645a = faultMonitor;
        dropBackToNormal = true;
        faultMonitor.h();
    }

    FaultMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a c(a.C8201a config, com.tencent.mobileqq.perf.memory.collect.a memoryUsage, String nowScene) {
        boolean z16;
        a aVar = new a();
        aVar.i(memoryUsage.c().i());
        aVar.f(memoryUsage.a().a());
        aVar.g(memoryUsage.a().e());
        aVar.h(nowScene);
        aVar.j(f257645a.d(aVar, config));
        if (!dropBackToNormal && aVar.e() == null) {
            dropBackToNormal = true;
        }
        if (aVar.e() != null && !isDumping && dropBackToNormal) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "checkMemory, maxPss:" + config.i(reportCountInProcess) + ", totalPss:" + aVar.d() + " usedRatio:" + aVar.b() + ",  maxUsedRatio:" + config.l() + ", reportCount:" + reportCount + ", reportCountInProcess:" + reportCountInProcess + ", trigger type is " + aVar.e() + ", isDumping:" + isDumping + ", dropBackToNormal:" + dropBackToNormal, z16, null, 8, null);
        if (!isDumping && dropBackToNormal) {
            if (aVar.e() != null) {
                isDumping = true;
                dropBackToNormal = false;
            }
        } else {
            aVar.j(null);
        }
        return aVar;
    }

    private final TriggerType d(a context, a.C8201a config) {
        float l3 = config.l();
        if (context.d() > config.i(reportCountInProcess) && context.b() > l3) {
            return TriggerType.BOTH;
        }
        if (context.d() > config.i(reportCountInProcess)) {
            return TriggerType.TOTAL_PSS;
        }
        if (context.b() > l3) {
            return TriggerType.JAVA_HEAP;
        }
        return null;
    }

    private final void e(final a.C8201a config, final com.tencent.mobileqq.perf.memory.collect.a memoryUsage) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.memory.a
            @Override // java.lang.Runnable
            public final void run() {
                FaultMonitor.f(a.C8201a.this, memoryUsage);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a.C8201a config, com.tencent.mobileqq.perf.memory.collect.a aVar) {
        Intrinsics.checkNotNullParameter(config, "$config");
        String f16 = SceneTracker.f();
        if ((!config.q().isEmpty()) && !config.q().contains(f16)) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "checkMemory end, scene not match, scene: " + f16, false, null, 12, null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar == null) {
            aVar = com.tencent.mobileqq.perf.memory.collect.a.INSTANCE.a();
        }
        FaultMonitor faultMonitor = f257645a;
        a c16 = faultMonitor.c(config, aVar, f16);
        if (c16.e() == null) {
            return;
        }
        MemoryFile.a g16 = faultMonitor.g(c16);
        if (g16.b()) {
            faultMonitor.i(g16, c16);
        }
        isDumping = false;
        QLog.d("MemoryFaultMonitor", 1, "checkMemory end, cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms, nowScene is " + c16.c());
    }

    private final MemoryFile.a g(a checkContext) {
        String format = com.tencent.mobileqq.perf.memory.dump.a.f257721a.b().format(new Date());
        MemoryFile.a aVar = new MemoryFile.a();
        aVar.r(MemoryFile.FromTag.FaultMonitor);
        aVar.C("memoryTestZip_" + AppSetting.getBuildNum() + util.base64_pad_url + format);
        aVar.v(true);
        aVar.u(false);
        aVar.w(false);
        aVar.p(true);
        aVar.x(checkContext.e());
        MemoryFile.f(aVar);
        if (aVar.b()) {
            new File(aVar.m()).delete();
            QLog.d("MemoryFaultMonitor", 1, "dumpMemory completed, download url is " + PerfCosUploader.f258269a.b(PerfCosUploader.BucketType.MEM, SosoInterface.PRE + aVar.o()));
        }
        return aVar;
    }

    private final void h() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("memory_fault_report_yesterday_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        if (currentTimeMillis - decodeLong > 86400000) {
            from.encodeLong("memory_fault_report_yesterday_time", currentTimeMillis);
            from.encodeInt("memory_fault_report_count", 0);
        } else {
            i3 = from.decodeInt("memory_fault_report_count", 0);
        }
        reportCount = i3;
    }

    private final void i(MemoryFile.a context, a checkContext) {
        int mapCapacity;
        Map mutableMap;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        reportCount++;
        from.encodeInt("memory_fault_report_count", reportCount);
        reportCountInProcess++;
        lastReportTime = System.currentTimeMillis();
        Map<String, Integer> i3 = context.i();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(i3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = i3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), String.valueOf(((Number) entry.getValue()).intValue()));
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        mutableMap.put("zipFileName", context.o());
        String c16 = checkContext.c();
        Intrinsics.checkNotNull(c16);
        mutableMap.put("nowScene", c16);
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "sMobileQQ.peekAppRuntime().account");
        mutableMap.put("account", account);
        TriggerType e16 = checkContext.e();
        Intrinsics.checkNotNull(e16);
        mutableMap.put("triggerType", e16.name());
        mutableMap.put("javaHeapUsedRatio", String.valueOf(checkContext.b()));
        mutableMap.put("javaHeapAllocMem", String.valueOf(checkContext.a()));
        mutableMap.put("uploadSucceed", String.valueOf(context.l()));
        mutableMap.put("uploadFailedReason", String.valueOf(context.k()));
        mutableMap.put("hprofSize", String.valueOf(context.d()));
        mutableMap.put("logSize", String.valueOf(context.e()));
        mutableMap.put("zipSize", String.valueOf(context.n()));
        mutableMap.put("branchName", AppSetting.getBranchName());
        mutableMap.put("buildNum", AppSetting.getBuildNum());
        mutableMap.put("revision", AppSetting.getRevision());
        mutableMap.put("processLiveTime", String.valueOf(com.tencent.mobileqq.perf.process.util.b.f257946a.h()));
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "memory_fault_monitor", context.l(), 0L, 0L, new HashMap<>(mutableMap), "");
    }

    public final void b(@Nullable com.tencent.mobileqq.perf.memory.collect.a memoryUsage) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) memoryUsage);
            return;
        }
        a.C8201a n3 = com.tencent.mobileqq.perf.memory.config.a.f257676a.n();
        if (n3 == null) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "toggle config is null!", false, null, 12, null);
            return;
        }
        if (!n3.a()) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "current account is not in white list or miss sampling", false, null, 12, null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (lastReportTime != 0 && currentTimeMillis - lastReportTime < 600000) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "less then 10min since the last report time", false, null, 12, null);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            str = "null";
        }
        boolean contains = n3.o().contains(str);
        boolean z17 = true;
        if (contains && currentTimeMillis - lastReportTime > n3.n()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (reportCount < n3.h() && reportCountInProcess < n3.p()) {
            z17 = false;
        }
        if (!z16 && z17) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "checkMemory return, dailyLimit:" + n3.h() + ", processLimit:" + n3.p() + ", reportCount:" + reportCount + ", reportCountInProcess:" + reportCountInProcess + ", isNoLimitUser:" + contains + ", dropBackToNormal:" + dropBackToNormal, false, null, 12, null);
            return;
        }
        e(n3, memoryUsage);
    }
}
