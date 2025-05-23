package com.tencent.mobileqq.winkpublish.config;

import android.os.Parcel;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QFSUploadLocalConfig extends UploadLocalConfig {
    public QFSUploadLocalConfig(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public int getUniqueType() {
        return 1;
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public void mapReportEndKey(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        qCirclePublishQualityDataBuilder.setKeyEventId(getSpKey() + "_" + qCirclePublishQualityDataBuilder.getKeyEventId());
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).mapReport(qCirclePublishQualityDataBuilder);
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public void mapReportStartKey(String str) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).startKey(str);
    }

    @Override // com.tencent.mobileqq.winkpublish.config.UploadLocalConfig
    public void uploadQualityReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        qCirclePublishQualityDataBuilder.setKeyEventId(getSpKey() + "_" + qCirclePublishQualityDataBuilder.getKeyEventId());
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(qCirclePublishQualityDataBuilder);
    }

    public QFSUploadLocalConfig() {
        super("[QFSUpload]", "QFS", "QFS_publish_queue");
    }
}
