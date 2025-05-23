package com.tencent.qphone.base.util.log.report;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.qphone.base.util.log.report.ReportLogInfoContext;
import java.io.File;
import java.util.Calendar;

/* loaded from: classes22.dex */
public class PassiveWithCmdLogReportTask extends BaseLogReportTask {
    public static final String TAG = "MSF.C.PassiveWithCmdLogReportTask";

    /* JADX INFO: Access modifiers changed from: package-private */
    public PassiveWithCmdLogReportTask(@NonNull ReportLogInfoContext reportLogInfoContext) {
        super(reportLogInfoContext);
    }

    private Calendar getCalendar(boolean z16) {
        long j3;
        if (z16) {
            j3 = this.context.startTimeMillis;
        } else {
            j3 = this.context.endTimeMillis;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar;
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getDay(boolean z16) {
        return getCalendar(z16).get(5);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getHour(boolean z16) {
        return getCalendar(z16).get(11);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getMonth(boolean z16) {
        return getCalendar(z16).get(2) + 1;
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public Pair<Long, Long> getTimePeriod() {
        return new Pair<>(Long.valueOf(this.context.startTimeMillis), Long.valueOf(this.context.endTimeMillis));
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getYear(boolean z16) {
        return getCalendar(z16).get(1);
    }

    @Override // com.tencent.qphone.base.util.log.report.BaseLogReportTask, com.tencent.qphone.base.util.log.report.ILogReportCallback
    public void onStateChange(int i3) {
        ReportLogInfoContext.UploadLogListener uploadLogListener = this.context.injectUploadFileListener;
        if (uploadLogListener != null) {
            uploadLogListener.reportUploadLogState(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qphone.base.util.log.report.BaseLogReportTask
    public void uploadLog(File file) throws Exception {
        ReportLogInfoContext.UploadLogListener uploadLogListener = this.context.injectUploadFileListener;
        if (uploadLogListener != null) {
            uploadLogListener.uploadLogZipFile(file);
        }
    }
}
