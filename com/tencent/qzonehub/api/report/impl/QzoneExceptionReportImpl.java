package com.tencent.qzonehub.api.report.impl;

import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import cooperation.qzone.util.QZoneExceptionReport;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneExceptionReportImpl implements IQzoneExceptionReport {
    @Override // com.tencent.qzonehub.api.report.IQzoneExceptionReport
    public void doReport(Throwable th5, String str) {
        QZoneExceptionReport.doReport(th5, str);
    }
}
