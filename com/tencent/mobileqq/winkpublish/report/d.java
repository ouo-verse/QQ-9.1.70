package com.tencent.mobileqq.winkpublish.report;

import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/d;", "Lcom/tencent/mobileqq/winkpublish/report/a;", "", "key", "", "c", "Lcom/tencent/mobileqq/winkpublish/config/l;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "reportData", "", "a", "startKey", "b", "", "Ljava/util/Map;", "keyStartMap", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Long> keyStartMap = new LinkedHashMap();

    private final long c(String key) {
        Long remove;
        if (!this.keyStartMap.containsKey(key) || (remove = this.keyStartMap.remove(key)) == null) {
            return -1L;
        }
        return System.currentTimeMillis() - remove.longValue();
    }

    @Override // com.tencent.mobileqq.winkpublish.report.a
    public void a(l config, WinkPublishQualityReportData reportData) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if (QLog.isColorLevel()) {
            QLog.d("WinkQualityReportImpl", 2, "[qualityReport] attaId=" + config.getAttaId() + ", reportData=" + reportData);
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(reportData.getEventId(), config.getEventIdPrefix(), false, 2, null);
        if (!startsWith$default) {
            reportData.setEventId(config.getEventIdPrefix() + reportData.getEventId());
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(config.getAttaId(), reportData.qcircleReportData());
    }

    @Override // com.tencent.mobileqq.winkpublish.report.a
    public void b(l config, WinkPublishQualityReportData reportData) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        long c16 = c(reportData.getKey());
        QLog.i("WinkQualityReportImpl", 1, "[endKey] key=" + reportData.getKey() + ", cost=" + c16);
        if (c16 > 0) {
            reportData.setExt1(String.valueOf(c16));
            a(config, reportData);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.report.a
    public void startKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.i("WinkQualityReportImpl", 1, "[startKey] key=" + key);
        this.keyStartMap.put(key, Long.valueOf(System.currentTimeMillis()));
    }
}
