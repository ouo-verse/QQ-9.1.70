package com.tencent.bugly.common.reporter.data;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ReportDataCacheMng {
    boolean deleteReportDataFromCache(ReportData reportData);

    boolean insertReportDataToCache(ReportData reportData);

    boolean insertReportDataToCacheAsSend(ReportData reportData);

    boolean updateReportDataToCache(ReportData reportData);
}
