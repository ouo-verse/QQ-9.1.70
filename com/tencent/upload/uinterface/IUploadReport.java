package com.tencent.upload.uinterface;

import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadReport {
    void batchComplete();

    void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder, TaskTypeConfig taskTypeConfig);

    void onUploadReport(Report report);

    void openSessionReport(int i3, String str, String str2, int i16);
}
