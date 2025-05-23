package com.tencent.mobileqq.wink.picker.qcircle.monitor;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/b;", "Lcom/tencent/biz/richframework/monitor/local/RFWAbsMonitorProxy;", "", "scene", "", "reportToDcTable", "reportFrameRateInfo", "", "c", "", "frameTimeArray", "", "getCurrentDropFrameCount", "pageId", "onParseSceneForPageId", "", "isEnabledPerformanceUI", "isEnabledTracePrint", "isWnsEnabledCollect", "onBeginFPSFrameMonitor", "onEndFPSFrameMonitor", "Lcom/tencent/biz/richframework/monitor/local/fps/RFWDropFrameCollector$DropFrameInfo;", "info", "isReportInfo", "onFrameInfo", "a", "Z", "isEnable", "b", "Ljava/lang/String;", "preScene", "isReportCalculateFlow", "", "d", UserInfo.SEX_FEMALE, "currentFPSVal", "e", "currentSMVal", "<init>", "(Z)V", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends RFWAbsMonitorProxy {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private static volatile b f325022g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String preScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isReportCalculateFlow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float currentFPSVal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float currentSMVal;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/b$a;", "", "", "isEnable", "Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/b;", "a", "(Z)Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/b;", "", "DEF_DROP_FIRST_INDEX", "I", "", "DEF_DROP_FRAME_NUM_ZERO", "J", "MAX_FPS_VAL", "MAX_SM_VAL", "", "TAG", "Ljava/lang/String;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/wink/picker/qcircle/monitor/b;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.monitor.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a(boolean isEnable) {
            if (b.f325022g == null) {
                synchronized (Reflection.getOrCreateKotlinClass(b.class)) {
                    if (b.f325022g == null) {
                        b.f325022g = new b(isEnable, null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            b bVar = b.f325022g;
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16);
    }

    private final int c() {
        Integer X0 = uq3.c.X0("qqcircle", QzoneConfig.SECONDARY_KEY_REPORT_CALCULATE_FRAME_COUNT, 20);
        Intrinsics.checkNotNullExpressionValue(X0, "getConfigValue(QzoneConf\u2026RT_CALCULATE_FRAME_COUNT)");
        return X0.intValue();
    }

    private final long getCurrentDropFrameCount(long[] frameTimeArray) {
        boolean z16;
        if (frameTimeArray == null) {
            return 0L;
        }
        if (frameTimeArray.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0L;
        }
        return frameTimeArray[0];
    }

    private final void reportFrameRateInfo(String scene) {
        float coerceAtMost;
        float coerceAtMost2;
        boolean z16;
        if (!TextUtils.isEmpty(scene)) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.currentSMVal, 100.0f);
            this.currentSMVal = coerceAtMost;
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.currentFPSVal, 60.0f);
            this.currentFPSVal = coerceAtMost2;
            boolean z17 = true;
            if (this.currentSMVal == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (coerceAtMost2 != 0.0f) {
                    z17 = false;
                }
                if (!z17) {
                    if (QLog.isColorLevel()) {
                        w53.b.f("WinkPickMonitorProxyImpl", "[reportFrameRateInfo] current sm: " + this.currentSMVal + " | fps: " + this.currentFPSVal);
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                w53.b.f("WinkPickMonitorProxyImpl", "[reportFrameRateInfo] current sm(" + this.currentSMVal + ") is zero or pfs(" + this.currentFPSVal + ")");
            }
        }
    }

    private final void reportToDcTable(String scene) {
        if (!getIsEnable()) {
            w53.b.f("WinkPickMonitorProxyImpl", "[reportToDcTable] current wns enabled collect close.");
        } else {
            reportFrameRateInfo(scene);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledPerformanceUI() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledTracePrint() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    /* renamed from: isWnsEnabledCollect, reason: from getter */
    public boolean getIsEnable() {
        return this.isEnable;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onFrameInfo(@Nullable RFWDropFrameCollector.DropFrameInfo info, boolean isReportInfo) {
        boolean z16;
        if (info == null) {
            return;
        }
        String str = this.preScene;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.currentFPSVal = info.getFps();
        this.currentSMVal = info.getSmoothRate();
        if (!isReportInfo) {
            return;
        }
        long currentDropFrameCount = getCurrentDropFrameCount(info.getFrameTimeArray());
        if (currentDropFrameCount == 0) {
            return;
        }
        if (currentDropFrameCount >= c()) {
            reportToDcTable(this.preScene);
            this.preScene = "";
            this.isReportCalculateFlow = true;
            return;
        }
        this.isReportCalculateFlow = false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    @Nullable
    public String onParseSceneForPageId(int pageId) {
        return WinkPerformanceHelper.INSTANCE.b(pageId);
    }

    b(boolean z16) {
        this.isEnable = z16;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onBeginFPSFrameMonitor(@Nullable String scene) {
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onEndFPSFrameMonitor(@Nullable String scene) {
    }
}
