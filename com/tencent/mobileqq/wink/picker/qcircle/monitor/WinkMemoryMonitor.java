package com.tencent.mobileqq.wink.picker.qcircle.monitor;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkPerformanceHelper;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.util.Arrays;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sy3.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0002\u000b\u0010B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkMemoryMonitor;", "", "", "", "c", "e", "d", "scene", "", "f", "", "a", "Z", "isReported", "Ljava/util/Stack;", "Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkMemoryMonitor$b;", "b", "Ljava/util/Stack;", "memoryStatInfo", "Lsy3/b$a;", "Lsy3/b$a;", "memInfo", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemoryMonitor {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<WinkMemoryMonitor> f325003e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isReported;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Stack<MemoryStatInfo> memoryStatInfo = new Stack<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b.a memInfo = new b.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkMemoryMonitor$a;", "", "Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkMemoryMonitor;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkMemoryMonitor;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkMemoryMonitor$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkMemoryMonitor a() {
            return (WinkMemoryMonitor) WinkMemoryMonitor.f325003e.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\u001f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u001e\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkMemoryMonitor$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "scene", "", "b", "J", "()J", h.F, "(J)V", "free", "c", "i", "imageCache", "d", "g", "alloc", "f", "k", MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, "j", MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkMemoryMonitor$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class MemoryStatInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String scene;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long free;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private long imageCache;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private long alloc;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private long totalPss;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private long nativePss;

        /* renamed from: a, reason: from getter */
        public final long getAlloc() {
            return this.alloc;
        }

        /* renamed from: b, reason: from getter */
        public final long getFree() {
            return this.free;
        }

        /* renamed from: c, reason: from getter */
        public final long getImageCache() {
            return this.imageCache;
        }

        /* renamed from: d, reason: from getter */
        public final long getNativePss() {
            return this.nativePss;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemoryStatInfo)) {
                return false;
            }
            MemoryStatInfo memoryStatInfo = (MemoryStatInfo) other;
            if (Intrinsics.areEqual(this.scene, memoryStatInfo.scene) && this.free == memoryStatInfo.free && this.imageCache == memoryStatInfo.imageCache && this.alloc == memoryStatInfo.alloc && this.totalPss == memoryStatInfo.totalPss && this.nativePss == memoryStatInfo.nativePss) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final long getTotalPss() {
            return this.totalPss;
        }

        public final void g(long j3) {
            this.alloc = j3;
        }

        public final void h(long j3) {
            this.free = j3;
        }

        public int hashCode() {
            return (((((((((this.scene.hashCode() * 31) + androidx.fragment.app.a.a(this.free)) * 31) + androidx.fragment.app.a.a(this.imageCache)) * 31) + androidx.fragment.app.a.a(this.alloc)) * 31) + androidx.fragment.app.a.a(this.totalPss)) * 31) + androidx.fragment.app.a.a(this.nativePss);
        }

        public final void i(long j3) {
            this.imageCache = j3;
        }

        public final void j(long j3) {
            this.nativePss = j3;
        }

        public final void k(long j3) {
            this.totalPss = j3;
        }

        @NotNull
        public String toString() {
            return "MemoryStatInfo(scene=" + this.scene + ", free=" + this.free + ", imageCache=" + this.imageCache + ", alloc=" + this.alloc + ", totalPss=" + this.totalPss + ", nativePss=" + this.nativePss + ")";
        }
    }

    static {
        Lazy<WinkMemoryMonitor> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<WinkMemoryMonitor>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkMemoryMonitor$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMemoryMonitor invoke() {
                return new WinkMemoryMonitor();
            }
        });
        f325003e = lazy;
    }

    private final String c(long j3) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf((((float) j3) / 1024.0f) / 1024)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final long d() {
        return Runtime.getRuntime().freeMemory();
    }

    private final long e() {
        return Runtime.getRuntime().totalMemory() - d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WinkMemoryMonitor this$0, String scene) {
        String peakAliveStatus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scene, "$scene");
        if ((!this$0.memoryStatInfo.isEmpty()) && Intrinsics.areEqual(this$0.memoryStatInfo.peek().getScene(), scene)) {
            MemoryStatInfo pop = this$0.memoryStatInfo.pop();
            pop.h(this$0.d());
            pop.i(com.tencent.cache.core.manager.api.c.f98725d.g());
            pop.g(this$0.e() - pop.getAlloc());
            pop.k(this$0.memInfo.f434975a - pop.getTotalPss());
            pop.j(this$0.memInfo.f434976b - pop.getNativePss());
            WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
            winkPublishQualityReportData.setEventId("T_MEMORY_USAGE");
            WinkPerformanceHelper.Companion companion = WinkPerformanceHelper.INSTANCE;
            winkPublishQualityReportData.setTraceId(companion.a().getTraceId());
            if (this$0.isReported) {
                peakAliveStatus = "PeakAlive";
            } else {
                peakAliveStatus = companion.a().getPeakAliveStatus();
            }
            winkPublishQualityReportData.setExt1(peakAliveStatus);
            winkPublishQualityReportData.setExt2(this$0.c(pop.getFree()));
            winkPublishQualityReportData.setExt3(this$0.c(pop.getImageCache()));
            winkPublishQualityReportData.setExt4(this$0.c(pop.getAlloc()));
            winkPublishQualityReportData.setExt5(this$0.c(pop.getTotalPss()));
            winkPublishQualityReportData.setExt6(this$0.c(pop.getNativePss()));
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(winkPublishQualityReportData, 1);
            }
            this$0.isReported = true;
        }
    }

    public final void f(@NotNull final String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.monitor.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkMemoryMonitor.g(WinkMemoryMonitor.this, scene);
            }
        }, 128, null, false);
    }
}
