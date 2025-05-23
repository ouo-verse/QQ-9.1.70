package com.tencent.mobileqq.wink.picker.qcircle.monitor;

import android.content.Context;
import com.tencent.biz.richframework.monitor.RFWMonitorManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.qqperf.monitor.dropframe.api.IDropFrameMonitor;
import common.config.service.QzoneConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \f2\u00020\u0001:\u0001\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u0018\u0010\u001cR$\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u0016\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkPerformanceHelper;", "", "", "isPeakAliveWhenEntry", "", "traceId", "", h.F, "d", "Landroid/content/Context;", "context", "g", "f", "scene", "e", "", "pageId", "hasStoragePermission", "i", "a", "Z", "isFPSMonitorEnable", "b", "isMemoryMonitorEnable", "c", "isFirstScreenCostMonitorEnable", "<set-?>", "Ljava/lang/String;", "()Ljava/lang/String;", "peakAliveStatus", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkPerformanceHelper {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy<WinkPerformanceHelper> f325014g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isFPSMonitorEnable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isMemoryMonitorEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstScreenCostMonitorEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String peakAliveStatus;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R!\u0010\r\u001a\u00020\u00068FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkPerformanceHelper$a;", "", "", "pageId", "", "b", "Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkPerformanceHelper;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/WinkPerformanceHelper;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "PEAK_ALIVE", "Ljava/lang/String;", "PEAK_NO_ALIVE", "TAG", "<init>", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkPerformanceHelper$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkPerformanceHelper a() {
            return (WinkPerformanceHelper) WinkPerformanceHelper.f325014g.getValue();
        }

        @Nullable
        public final String b(int pageId) {
            if (pageId == MediaType.LOCAL_ALL.ordinal()) {
                return IDropFrameMonitor.QQWINK_PHOTO_LIST_ALL_PAGE;
            }
            if (pageId == MediaType.LOCAL_IMAGE.ordinal()) {
                return IDropFrameMonitor.QQWINK_PHOTO_LIST_PHOTO_PAGE;
            }
            if (pageId == MediaType.LOCAL_VIDEO.ordinal()) {
                return IDropFrameMonitor.QQWINK_PHOTO_LIST_VIDEO_PAGE;
            }
            if (pageId == MediaType.QZONE_ALL.ordinal()) {
                return IDropFrameMonitor.QQWINK_PHOTO_LIST_QZONE_PAGE;
            }
            return null;
        }

        Companion() {
        }
    }

    static {
        Lazy<WinkPerformanceHelper> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<WinkPerformanceHelper>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkPerformanceHelper$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkPerformanceHelper invoke() {
                return new WinkPerformanceHelper(null);
            }
        });
        f325014g = lazy;
    }

    public /* synthetic */ WinkPerformanceHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPeakAliveStatus() {
        return this.peakAliveStatus;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final void d() {
        if (this.isFPSMonitorEnable) {
            RFWMonitorManager.instance().injectProxyImpl(b.INSTANCE.a(this.isFPSMonitorEnable));
        }
    }

    public final void e(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.isMemoryMonitorEnable) {
            WinkMemoryMonitor.INSTANCE.a().f(scene);
        }
        if (this.isFirstScreenCostMonitorEnable) {
            WinkFirstScreenCostMonitor.INSTANCE.a().c();
        }
    }

    public final void f() {
        if (this.isFPSMonitorEnable) {
            RFWMonitorManager.instance().stop();
        }
    }

    public final void g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isFPSMonitorEnable) {
            RFWMonitorManager.instance().start(context);
        }
    }

    public final void h(boolean isPeakAliveWhenEntry, @Nullable String traceId) {
        String str;
        if (traceId == null) {
            traceId = "";
        }
        this.traceId = traceId;
        if (isPeakAliveWhenEntry) {
            str = "PeakAlive";
        } else {
            str = "PeakNoAlive";
        }
        this.peakAliveStatus = str;
    }

    public final void i(int pageId, boolean hasStoragePermission) {
        String b16;
        if (!this.isFirstScreenCostMonitorEnable || !hasStoragePermission || (b16 = INSTANCE.b(pageId)) == null) {
            return;
        }
        WinkFirstScreenCostMonitor.INSTANCE.a().e(b16);
    }

    WinkPerformanceHelper() {
        this.traceId = "";
        this.peakAliveStatus = "";
        this.isFPSMonitorEnable = QzoneConfig.isFPSMonitorEnable();
        this.isMemoryMonitorEnable = QzoneConfig.isMemoryMonitorEnable();
        boolean isFirstScreenCostMonitorEnable = QzoneConfig.isFirstScreenCostMonitorEnable();
        this.isFirstScreenCostMonitorEnable = isFirstScreenCostMonitorEnable;
        w53.b.f("WinkPerformanceHelper", "isFPSMonitorEnable=" + this.isFPSMonitorEnable + ", isMemoryMonitorEnable=" + this.isMemoryMonitorEnable + ", isFirstScreenCostMonitorEnable=" + isFirstScreenCostMonitorEnable);
    }
}
