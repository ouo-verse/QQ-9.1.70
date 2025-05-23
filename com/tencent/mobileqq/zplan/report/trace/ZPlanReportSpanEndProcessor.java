package com.tencent.mobileqq.zplan.report.trace;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.zplan.zplantracing.ZPlanSpanData;
import com.tencent.zplan.zplantracing.ZPlanSpanStatusCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/trace/ZPlanReportSpanEndProcessor;", "Lcom/tencent/zplan/zplantracing/a;", "Lcom/tencent/zplan/zplantracing/ZPlanSpanData;", "Lcom/tencent/mobileqq/tianjige/external/b;", "toExternalSpanData", "spanData", "", "handleSpanData", "Lqj3/b;", "tracer", "Lqj3/b;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanReportSpanEndProcessor implements com.tencent.zplan.zplantracing.a {
    public static final String TAG = "ZPlanReportSpanEndProcessor";
    private final qj3.b tracer;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335072a;

        static {
            int[] iArr = new int[ZPlanSpanStatusCode.values().length];
            try {
                iArr[ZPlanSpanStatusCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZPlanSpanStatusCode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f335072a = iArr;
        }
    }

    public ZPlanReportSpanEndProcessor() {
        IZPlanReportHelper iZPlanReportHelper;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.tracer = (peekAppRuntime == null || (iZPlanReportHelper = (IZPlanReportHelper) peekAppRuntime.getRuntimeService(IZPlanReportHelper.class, "all")) == null) ? null : iZPlanReportHelper.getZPlanTracer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSpanData$lambda$0(ZPlanReportSpanEndProcessor this$0, ZPlanSpanData spanData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(spanData, "$spanData");
        qj3.b bVar = this$0.tracer;
        if (bVar != null) {
            bVar.b(this$0.toExternalSpanData(spanData));
        }
    }

    private final com.tencent.mobileqq.tianjige.external.b toExternalSpanData(ZPlanSpanData zPlanSpanData) {
        StatusCode statusCode;
        com.tencent.mobileqq.tianjige.external.b bVar = new com.tencent.mobileqq.tianjige.external.b(zPlanSpanData.getSpanId(), zPlanSpanData.getTraceId());
        bVar.e(zPlanSpanData.getName());
        bVar.f(zPlanSpanData.getParentId());
        bVar.g(zPlanSpanData.getStartTime());
        bVar.c(zPlanSpanData.getEndTime());
        int i3 = b.f335072a[zPlanSpanData.getStatus().ordinal()];
        if (i3 == 1) {
            statusCode = StatusCode.OK;
        } else if (i3 != 2) {
            statusCode = StatusCode.UNSET;
        } else {
            statusCode = StatusCode.ERROR;
        }
        bVar.h(statusCode);
        bVar.d(zPlanSpanData.getErrorMessage());
        bVar.b().putAll(zPlanSpanData.getAttribute());
        return bVar;
    }

    @Override // com.tencent.zplan.zplantracing.a
    public void handleSpanData(final ZPlanSpanData spanData) {
        Intrinsics.checkNotNullParameter(spanData, "spanData");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.report.trace.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanReportSpanEndProcessor.handleSpanData$lambda$0(ZPlanReportSpanEndProcessor.this, spanData);
            }
        }, 16, null, false);
    }
}
