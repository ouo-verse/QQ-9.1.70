package com.tencent.mobileqq.guild.report;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/report/h;", "", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "newReportTask", "", "eventCode", "a", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface h {
    @NotNull
    IPerformanceReportTask a(@NotNull String eventCode);

    @NotNull
    IPerformanceReportTask newReportTask();
}
