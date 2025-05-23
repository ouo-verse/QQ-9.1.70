package com.tencent.mobileqq.wink.picker.qcircle.monitor;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkPerformanceHelper;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0002\b\rB\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkFirstScreenCostMonitor;", "", "", "scene", "", "e", "c", "", "a", "Z", "isReported", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkFirstScreenCostMonitor$b;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "sceneMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkFirstScreenCostMonitor {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<WinkFirstScreenCostMonitor> f324996d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isReported;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, CostInfo> sceneMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkFirstScreenCostMonitor$a;", "", "Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkFirstScreenCostMonitor;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkFirstScreenCostMonitor;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "ON_BIND_THRESHOLD", "I", "", "TAG", "Ljava/lang/String;", "<init>", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkFirstScreenCostMonitor$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkFirstScreenCostMonitor a() {
            return (WinkFirstScreenCostMonitor) WinkFirstScreenCostMonitor.f324996d.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkFirstScreenCostMonitor$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "startTime", "b", "setEndTime", "(J)V", "endTime", "I", "()I", "setOnBindCount", "(I)V", "onBindCount", "<init>", "(JJI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkFirstScreenCostMonitor$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class CostInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long endTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int onBindCount;

        public CostInfo() {
            this(0L, 0L, 0, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getEndTime() {
            return this.endTime;
        }

        /* renamed from: b, reason: from getter */
        public final int getOnBindCount() {
            return this.onBindCount;
        }

        /* renamed from: c, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CostInfo)) {
                return false;
            }
            CostInfo costInfo = (CostInfo) other;
            if (this.startTime == costInfo.startTime && this.endTime == costInfo.endTime && this.onBindCount == costInfo.onBindCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((androidx.fragment.app.a.a(this.startTime) * 31) + androidx.fragment.app.a.a(this.endTime)) * 31) + this.onBindCount;
        }

        @NotNull
        public String toString() {
            return "CostInfo(startTime=" + this.startTime + ", endTime=" + this.endTime + ", onBindCount=" + this.onBindCount + ")";
        }

        public CostInfo(long j3, long j16, int i3) {
            this.startTime = j3;
            this.endTime = j16;
            this.onBindCount = i3;
        }

        public /* synthetic */ CostInfo(long j3, long j16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? System.currentTimeMillis() : j3, (i16 & 2) != 0 ? 0L : j16, (i16 & 4) != 0 ? 0 : i3);
        }
    }

    static {
        Lazy<WinkFirstScreenCostMonitor> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<WinkFirstScreenCostMonitor>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkFirstScreenCostMonitor$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkFirstScreenCostMonitor invoke() {
                return new WinkFirstScreenCostMonitor(null);
            }
        });
        f324996d = lazy;
    }

    public /* synthetic */ WinkFirstScreenCostMonitor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WinkFirstScreenCostMonitor this$0) {
        String peakAliveStatus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (Map.Entry<String, CostInfo> entry : this$0.sceneMap.entrySet()) {
            if (entry.getValue().getOnBindCount() > 0) {
                long endTime = entry.getValue().getEndTime() - entry.getValue().getStartTime();
                if (endTime > 0) {
                    WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
                    winkPublishQualityReportData.setEventId("P_FIRST_SCREEN_COST");
                    WinkPerformanceHelper.Companion companion = WinkPerformanceHelper.INSTANCE;
                    winkPublishQualityReportData.setTraceId(companion.a().getTraceId());
                    if (this$0.isReported) {
                        peakAliveStatus = "PeakAlive";
                    } else {
                        peakAliveStatus = companion.a().getPeakAliveStatus();
                    }
                    winkPublishQualityReportData.setExt1(peakAliveStatus);
                    winkPublishQualityReportData.setExt2(entry.getKey());
                    winkPublishQualityReportData.setExt3(String.valueOf(endTime));
                    winkPublishQualityReportData.setExt4(String.valueOf(entry.getValue().getOnBindCount()));
                    winkPublishQualityReportData.setExt5(String.valueOf(QQTheme.isNowThemeIsNight()));
                    z93.c f16 = Wink.INSTANCE.f();
                    if (f16 != null) {
                        f16.a(winkPublishQualityReportData, 1);
                    }
                    this$0.isReported = true;
                }
            }
        }
        this$0.sceneMap.clear();
    }

    public final void c() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.monitor.a
            @Override // java.lang.Runnable
            public final void run() {
                WinkFirstScreenCostMonitor.d(WinkFirstScreenCostMonitor.this);
            }
        }, 128, null, false);
    }

    public final void e(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.sceneMap.put(scene, new CostInfo(0L, 0L, 0, 7, null));
    }

    WinkFirstScreenCostMonitor() {
        this.sceneMap = new ConcurrentHashMap<>();
    }
}
