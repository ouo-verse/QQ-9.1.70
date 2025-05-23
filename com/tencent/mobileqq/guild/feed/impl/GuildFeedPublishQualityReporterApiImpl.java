package com.tencent.mobileqq.guild.feed.impl;

import com.tencent.mobileqq.guild.feed.IGuildFeedPublishQualityReporterApi;
import com.tencent.mobileqq.guild.feed.report.GuildPublishQualityReporter;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;

/* loaded from: classes13.dex */
public class GuildFeedPublishQualityReporterApiImpl implements IGuildFeedPublishQualityReporterApi {
    @Override // com.tencent.mobileqq.guild.feed.IGuildFeedPublishQualityReporterApi
    public void mapReportEndKey(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        GuildPublishQualityReporter.d(qCirclePublishQualityDataBuilder);
    }

    @Override // com.tencent.mobileqq.guild.feed.IGuildFeedPublishQualityReporterApi
    public void mapReportStartKey(String str) {
        GuildPublishQualityReporter.f(str);
    }

    @Override // com.tencent.mobileqq.guild.feed.IGuildFeedPublishQualityReporterApi
    public void uploadQualityReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        GuildPublishQualityReporter.c(qCirclePublishQualityDataBuilder);
    }
}
