package com.tencent.mobileqq.gamecenter.qa.api.impl;

import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamAttaReportApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/api/impl/MetaDreamAttaReportApiImpl;", "Lcom/tencent/mobileqq/gamecenter/qa/api/IMetaDreamAttaReportApi;", "()V", "report", "", "operId", "", "operType", "pageId", "moduleId", "pageName", "moduleName", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class MetaDreamAttaReportApiImpl implements IMetaDreamAttaReportApi {
    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamAttaReportApi
    public void report(@NotNull String operId, @NotNull String operType, @NotNull String pageId, @NotNull String moduleId, @NotNull String pageName, @NotNull String moduleName, @NotNull Map<String, ? extends Object> reportParams) {
        Intrinsics.checkNotNullParameter(operId, "operId");
        Intrinsics.checkNotNullParameter(operType, "operType");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        new ee1.b().b(operId, operType, pageId, moduleId, pageName, moduleName, reportParams);
    }
}
