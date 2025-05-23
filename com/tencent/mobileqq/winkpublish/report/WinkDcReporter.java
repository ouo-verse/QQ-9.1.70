package com.tencent.mobileqq.winkpublish.report;

import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IReportApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkDcReporter;", "", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "data", "", "a", "Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "b", "Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "()Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "d", "(Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;)V", "reportFeedInfo", "Lcom/tencent/mobileqq/qcircle/api/IQCircleReportApi;", "c", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qcircle/api/IQCircleReportApi;", "reporter", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WinkDcReporter {

    /* renamed from: a, reason: collision with root package name */
    public static final WinkDcReporter f327381a = new WinkDcReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static IReportApi.ReportFeedInfo reportFeedInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy reporter;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQCircleReportApi>() { // from class: com.tencent.mobileqq.winkpublish.report.WinkDcReporter$reporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IQCircleReportApi invoke() {
                return (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
            }
        });
        reporter = lazy;
    }

    WinkDcReporter() {
    }

    private final IQCircleReportApi c() {
        return (IQCircleReportApi) reporter.getValue();
    }

    public final void a(WinkDc5507ReportData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getFeedId().length() == 0) {
            QLog.d("WinkDcReporter", 4, "data.feedId is null, actionType:" + data.getActionType() + ", subActionType:" + data.getSubActionType());
            return;
        }
        IReportApi.ReportFeedInfo reportFeedInfo2 = reportFeedInfo;
        if (reportFeedInfo2 != null) {
            if (data.getPosition() == -1 && Intrinsics.areEqual(data.getFeedId(), reportFeedInfo2.getFeedId())) {
                data.t(reportFeedInfo2.getFeedIndex());
                data.u(reportFeedInfo2.getSealTransfer());
                data.o(reportFeedInfo2.getFeedAuthorUin());
                data.q(reportFeedInfo2.getMaterialInfos());
            }
            data.r(reportFeedInfo2.getTaskId());
        }
        com.tencent.mobileqq.qcircle.api.constant.b i06 = new com.tencent.mobileqq.qcircle.api.constant.b().f0(data.getActionType()).m0(data.getSubActionType()).j0(data.getFeedId()).k0(data.getPosition()).l0(data.getSealTransfer()).e0(data.getActTime()).g0(data.getExt4()).h0(data.getExt5()).i0(data.getExt6());
        if (QLog.isColorLevel()) {
            QLog.d("WinkDcReporter", 1, "dc5507Report, dataBuilder:" + i06);
        }
        c().report5507(i06);
    }

    public final IReportApi.ReportFeedInfo b() {
        return reportFeedInfo;
    }

    public final void d(IReportApi.ReportFeedInfo reportFeedInfo2) {
        reportFeedInfo = reportFeedInfo2;
    }
}
