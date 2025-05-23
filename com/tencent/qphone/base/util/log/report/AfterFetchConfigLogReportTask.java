package com.tencent.qphone.base.util.log.report;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.heytap.mcssdk.a.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AfterFetchConfigLogReportTask extends BaseLogReportTask {
    public static final String TAG = "MSF.C.AfterFetchConfigLogReportTask";

    /* JADX INFO: Access modifiers changed from: package-private */
    public AfterFetchConfigLogReportTask(@NonNull ReportLogInfoContext reportLogInfoContext) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qphone.base.util.log.report.BaseLogReportTask
    public void uploadLog(File file) throws Exception {
        String str;
        String str2;
        ReportLogInfoContext reportLogInfoContext = this.context;
        String str3 = reportLogInfoContext.uin;
        boolean z16 = reportLogInfoContext.withoutLogin;
        long j3 = reportLogInfoContext.taskId;
        String str4 = reportLogInfoContext.qimei36;
        QLog.d(TAG, 1, "uploadLog withoutLogin=" + z16 + ",taskId=" + j3 + ",qimei36=" + str4);
        if (z16) {
            str2 = "config_report_log";
            str = "";
        } else {
            str = null;
            str2 = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(a.f36094d, j3 + "");
        hashMap.put("qimei36", str4);
        LogManager.doReportLogSelf(BaseApplication.getContext().getAppId(), file.getPath(), "", "", str3, str, "", str2, hashMap);
    }
}
