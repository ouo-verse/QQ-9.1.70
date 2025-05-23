package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleAttaReporter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCircleAttaReporterImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCircleAttaReporter;", "()V", "report", "", "eventId", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCircleAttaReporterImpl implements IQCircleAttaReporter {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleAttaReporter
    public void report(@NotNull String eventId, @NotNull Map<String, ? extends Object> reportParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        new xq3.b().b(eventId, reportParams);
    }
}
