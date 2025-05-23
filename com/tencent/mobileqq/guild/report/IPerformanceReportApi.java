package com.tencent.mobileqq.guild.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/report/IPerformanceReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "name", "Lcom/tencent/mobileqq/guild/report/j;", "option", "Lcom/tencent/mobileqq/guild/report/h;", "newReportClient", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "newForceReportTask", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IPerformanceReportApi extends QRouteApi {
    @NotNull
    IPerformanceReportTask newForceReportTask(@NotNull String name, @NotNull ReportOption option);

    @NotNull
    h newReportClient(@NotNull String name, @NotNull ReportOption option);
}
