package com.tencent.mobileqq.winkpublish.report;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.mobileqq.winkpublish.config.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/c;", "Lcom/tencent/mobileqq/winkpublish/report/d;", "Lcom/tencent/mobileqq/winkpublish/config/l;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "reportData", "", "a", "", "key", "startKey", "b", "", "c", "I", "samplingRate", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int samplingRate = WinkPublishConfigConstant.INSTANCE.getREPORT_QZONE_SAMPLING_RATE();

    @Override // com.tencent.mobileqq.winkpublish.report.d, com.tencent.mobileqq.winkpublish.report.a
    public void a(l config, WinkPublishQualityReportData reportData) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if (WinkPublishReportQueue.INSTANCE.needSampling(this.samplingRate)) {
            super.a(config, reportData);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.report.d, com.tencent.mobileqq.winkpublish.report.a
    public void b(l config, WinkPublishQualityReportData reportData) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if (WinkPublishReportQueue.INSTANCE.needSampling(this.samplingRate)) {
            super.b(config, reportData);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.report.d, com.tencent.mobileqq.winkpublish.report.a
    public void startKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (WinkPublishReportQueue.INSTANCE.needSampling(this.samplingRate)) {
            super.startKey(key);
        }
    }
}
