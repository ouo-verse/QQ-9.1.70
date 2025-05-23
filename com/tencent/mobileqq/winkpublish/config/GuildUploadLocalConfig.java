package com.tencent.mobileqq.winkpublish.config;

import android.os.Parcel;
import com.tencent.mobileqq.guild.feed.IGuildFeedPublishQualityReporterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes21.dex */
public class GuildUploadLocalConfig extends UploadLocalConfig {
    public GuildUploadLocalConfig(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public int getUniqueType() {
        return 2;
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public void mapReportEndKey(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        ((IGuildFeedPublishQualityReporterApi) QRoute.api(IGuildFeedPublishQualityReporterApi.class)).mapReportEndKey(qCirclePublishQualityDataBuilder);
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public void mapReportStartKey(String str) {
        ((IGuildFeedPublishQualityReporterApi) QRoute.api(IGuildFeedPublishQualityReporterApi.class)).mapReportStartKey(str);
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public void uploadQualityReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        ((IGuildFeedPublishQualityReporterApi) QRoute.api(IGuildFeedPublishQualityReporterApi.class)).uploadQualityReport(qCirclePublishQualityDataBuilder);
    }

    public GuildUploadLocalConfig() {
        super("[GuildUpload]", "CH", "Guild_publish_queue");
    }
}
