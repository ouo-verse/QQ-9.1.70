package com.tencent.mobileqq.winkpublish.api.impl;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.winkpublish.api.IReportApi;
import com.tencent.mobileqq.winkpublish.report.WinkDcReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/impl/ReportApiImpl;", "Lcom/tencent/mobileqq/winkpublish/api/IReportApi;", "Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "reportFeedInfo", "", "setDc5507ReportInfo", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "updateTaskId", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ReportApiImpl implements IReportApi {
    @Override // com.tencent.mobileqq.winkpublish.api.IReportApi
    public void setDc5507ReportInfo(IReportApi.ReportFeedInfo reportFeedInfo) {
        Intrinsics.checkNotNullParameter(reportFeedInfo, "reportFeedInfo");
        WinkDcReporter.f327381a.d(reportFeedInfo);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IReportApi
    public void updateTaskId(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        IReportApi.ReportFeedInfo b16 = WinkDcReporter.f327381a.b();
        if (b16 != null) {
            b16.g(taskId);
        }
    }
}
