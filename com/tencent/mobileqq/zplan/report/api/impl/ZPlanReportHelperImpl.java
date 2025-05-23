package com.tencent.mobileqq.zplan.report.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.mobileqq.tianjige.i;
import com.tencent.mobileqq.tianjige.metric.f;
import com.tencent.mobileqq.tianjige.metric.h;
import com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/api/impl/ZPlanReportHelperImpl;", "Lcom/tencent/mobileqq/zplan/report/api/IZPlanReportHelper;", "Lcom/tencent/mobileqq/tianjige/a;", "openTelemetryConfig", "", "doInitTracer", "doInitMetric", "Lmqq/app/AppRuntime;", "appRuntime", "initZPlanReport", "", "getCurrentUinForReport", "Lqj3/b;", "getZPlanTracer", "Lqj3/a;", "getZPlanMetric", "onCreate", "Lcom/tencent/mobileqq/zplan/report/api/IZPlanReportHelper$a;", "reportConfig", "setConfig", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitTracerConfig", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitMetricConfig", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/zplan/report/api/IZPlanReportHelper$a;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanReportHelperImpl implements IZPlanReportHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ZPlanReportHelperImpl";
    private IZPlanReportHelper.ZPlanReportConfig config;
    private final AtomicBoolean hasInitTracerConfig = new AtomicBoolean(false);
    private final AtomicBoolean hasInitMetricConfig = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/api/impl/ZPlanReportHelperImpl$a;", "", "Lcom/tencent/mobileqq/tianjige/i;", "b", "Lcom/tencent/mobileqq/tianjige/metric/h;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.report.api.impl.ZPlanReportHelperImpl$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final h a() {
            h b16 = f.b(8);
            Intrinsics.checkNotNullExpressionValue(b16, "getMetricRecorder(QQOpen\u2026ants.BusinessId.QQ_ZPLAN)");
            return b16;
        }

        public final i b() {
            i d16 = com.tencent.mobileqq.tianjige.f.d(8);
            Intrinsics.checkNotNullExpressionValue(d16, "getTelemetryTracer(QQOpe\u2026ants.BusinessId.QQ_ZPLAN)");
            return d16;
        }
    }

    private final void doInitMetric(com.tencent.mobileqq.tianjige.a openTelemetryConfig) {
        if (this.hasInitMetricConfig.compareAndSet(false, true)) {
            f.d(8, openTelemetryConfig);
        }
    }

    private final void doInitTracer(com.tencent.mobileqq.tianjige.a openTelemetryConfig) {
        if (this.hasInitTracerConfig.compareAndSet(false, true)) {
            com.tencent.mobileqq.tianjige.f.e(8, openTelemetryConfig);
        }
    }

    private final void initZPlanReport(AppRuntime appRuntime) {
        final IZPlanReportHelper.ZPlanReportConfig zPlanReportConfig = this.config;
        if (zPlanReportConfig == null) {
            zPlanReportConfig = new IZPlanReportHelper.ZPlanReportConfig(null, 0.0d, false, 7, null);
        }
        if (this.hasInitTracerConfig.get() && (!zPlanReportConfig.getUseMetric() || this.hasInitMetricConfig.get())) {
            QLog.i(TAG, 1, "ZPlanReporter has already been initialized.");
            return;
        }
        final com.tencent.mobileqq.tianjige.a k3 = new a.C8649a().o("qq").n(true).m(zPlanReportConfig.getFraction()).p(getCurrentUinForReport(appRuntime)).l(zPlanReportConfig.getAppVersion()).k();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.report.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanReportHelperImpl.initZPlanReport$lambda$0(ZPlanReportHelperImpl.this, k3, zPlanReportConfig);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initZPlanReport$lambda$0(ZPlanReportHelperImpl this$0, com.tencent.mobileqq.tianjige.a openTelemetryConfig, IZPlanReportHelper.ZPlanReportConfig reportConfig) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportConfig, "$reportConfig");
        QLog.i(TAG, 1, "do init ZPlanReporter.");
        Intrinsics.checkNotNullExpressionValue(openTelemetryConfig, "openTelemetryConfig");
        this$0.doInitTracer(openTelemetryConfig);
        if (reportConfig.getUseMetric()) {
            this$0.doInitMetric(openTelemetryConfig);
        }
    }

    @Override // com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper
    public qj3.a getZPlanMetric() {
        return ZPlanReportMetricImpl.f335053a;
    }

    @Override // com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper
    public qj3.b getZPlanTracer() {
        return c.f335062a;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        boolean enableOpenTelemetryReport = ZPlanQQMC.INSTANCE.enableOpenTelemetryReport();
        QLog.i(TAG, 1, "enableReport: " + enableOpenTelemetryReport);
        if (enableOpenTelemetryReport) {
            initZPlanReport(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper
    public void setConfig(IZPlanReportHelper.ZPlanReportConfig reportConfig) {
        Intrinsics.checkNotNullParameter(reportConfig, "reportConfig");
        this.config = reportConfig;
    }

    private final String getCurrentUinForReport(AppRuntime appRuntime) {
        if (appRuntime == null) {
            appRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        }
        if (appRuntime == null) {
            QLog.e(TAG, 1, "initZPlanReport get uin failed, appRuntime null.");
            return "";
        }
        String currentUin = appRuntime.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "{\n            app.currentUin\n        }");
        return currentUin;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
