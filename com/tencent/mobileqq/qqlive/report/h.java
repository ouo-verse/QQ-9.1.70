package com.tencent.mobileqq.qqlive.report;

import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u001a\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n\u00a8\u0006\r"}, d2 = {"", "appId", "event", "ext6", "retCode", "", "c", "Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData$Builder;", "builder", "a", "Lkotlin/Function0;", "build", "b", "qq-live-sdk-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h {
    public static final void a(@NotNull QQLiveQualityReportData.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(builder);
    }

    public static final void b(@NotNull Function0<QQLiveQualityReportData.Builder> build) {
        Intrinsics.checkNotNullParameter(build, "build");
        QQLiveQualityReportData.Builder invoke = build.invoke();
        if (invoke != null) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(invoke);
        }
    }

    public static final void c(@NotNull String appId, @NotNull String event, @Nullable String str, @Nullable String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(event, "event");
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder retCode = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).eventId(event).retCode(str2);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(appId);
        if (c16 != null) {
            str3 = c16.n();
        } else {
            str3 = null;
        }
        iQQLiveReportApi.qualityReport(retCode.traceId(str3).ext6(str));
    }

    public static /* synthetic */ void d(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        if ((i3 & 8) != 0) {
            str4 = null;
        }
        c(str, str2, str3, str4);
    }
}
