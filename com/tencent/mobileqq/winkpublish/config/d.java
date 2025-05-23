package com.tencent.mobileqq.winkpublish.config;

import com.tencent.mobileqq.guild.feed.IGuildFeedPublishQualityReporterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/config/d;", "Lcom/tencent/mobileqq/winkpublish/report/a;", "Lcom/tencent/mobileqq/winkpublish/config/l;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "reportData", "", "a", "", "key", "startKey", "b", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d implements com.tencent.mobileqq.winkpublish.report.a {
    @Override // com.tencent.mobileqq.winkpublish.report.a
    public void a(l config, WinkPublishQualityReportData reportData) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        ((IGuildFeedPublishQualityReporterApi) QRoute.api(IGuildFeedPublishQualityReporterApi.class)).uploadQualityReport(reportData.qcircleReportData());
    }

    @Override // com.tencent.mobileqq.winkpublish.report.a
    public void b(l config, WinkPublishQualityReportData reportData) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        ((IGuildFeedPublishQualityReporterApi) QRoute.api(IGuildFeedPublishQualityReporterApi.class)).mapReportEndKey(reportData.qcircleReportData());
    }

    @Override // com.tencent.mobileqq.winkpublish.report.a
    public void startKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ((IGuildFeedPublishQualityReporterApi) QRoute.api(IGuildFeedPublishQualityReporterApi.class)).mapReportStartKey(key);
    }
}
