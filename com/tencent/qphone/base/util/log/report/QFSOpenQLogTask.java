package com.tencent.qphone.base.util.log.report;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QFSOpenQLogTask extends BaseLogReportTask {
    public QFSOpenQLogTask(ReportLogInfoContext reportLogInfoContext) {
        super(reportLogInfoContext);
    }

    private Calendar getCalendar(boolean z16) {
        Object obj;
        Object[] objArr = (Object[]) this.context.config;
        if (z16) {
            obj = objArr[2];
        } else {
            obj = objArr[3];
        }
        long longValue = ((Long) obj).longValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(longValue);
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
        Object[] objArr = (Object[]) this.context.config;
        return new Pair<>((Long) objArr[2], (Long) objArr[3]);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getYear(boolean z16) {
        return getCalendar(z16).get(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qphone.base.util.log.report.BaseLogReportTask
    public void uploadLog(File file) throws Exception {
        super.uploadLog(file);
        QLog.d(BaseLogReportTask.TAG, 1, "uploadLog:" + file);
    }
}
