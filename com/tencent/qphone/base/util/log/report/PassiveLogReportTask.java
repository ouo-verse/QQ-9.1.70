package com.tencent.qphone.base.util.log.report;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.msf.service.protocol.serverconfig.a;
import com.tencent.msf.service.protocol.serverconfig.l;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* loaded from: classes22.dex */
public class PassiveLogReportTask extends BaseLogReportTask {
    public static final String TAG = "MSF.C.PassiveLogReportTask";

    /* JADX INFO: Access modifiers changed from: package-private */
    public PassiveLogReportTask(@NonNull ReportLogInfoContext reportLogInfoContext) {
        super(reportLogInfoContext);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getDay(boolean z16) {
        l lVar;
        a aVar = (a) this.context.config;
        if (z16) {
            lVar = aVar.f336744b;
        } else {
            lVar = aVar.f336745c;
        }
        return lVar.f336868c;
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getHour(boolean z16) {
        l lVar;
        a aVar = (a) this.context.config;
        if (z16) {
            lVar = aVar.f336744b;
        } else {
            lVar = aVar.f336745c;
        }
        return lVar.f336869d;
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getMonth(boolean z16) {
        l lVar;
        a aVar = (a) this.context.config;
        if (z16) {
            lVar = aVar.f336744b;
        } else {
            lVar = aVar.f336745c;
        }
        return lVar.f336867b;
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public Pair<Long, Long> getTimePeriod() {
        a aVar = (a) this.context.config;
        l lVar = aVar.f336744b;
        int i3 = lVar.f336866a;
        byte b16 = lVar.f336867b;
        byte b17 = lVar.f336868c;
        byte b18 = lVar.f336869d;
        byte b19 = lVar.f336870e;
        l lVar2 = aVar.f336745c;
        return LogManager.getTimePeriod(i3, b16, b17, b18, b19, lVar2.f336866a, lVar2.f336867b, lVar2.f336868c, lVar2.f336869d, lVar2.f336870e);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getYear(boolean z16) {
        l lVar;
        a aVar = (a) this.context.config;
        if (z16) {
            lVar = aVar.f336744b;
        } else {
            lVar = aVar.f336745c;
        }
        return lVar.f336866a;
    }

    @Override // com.tencent.qphone.base.util.log.report.BaseLogReportTask, com.tencent.qphone.base.util.log.report.ILogReportCallback
    public void onStateChange(int i3) {
        super.onStateChange(i3);
        LogEventReporter.changeEventStat(LogEventReporter.EVENT_UPLOAD_LOG, i3, this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qphone.base.util.log.report.BaseLogReportTask
    public void uploadLog(File file) throws Exception {
        LogManager.reportLog(BaseApplication.getContext().getAppId(), file, this.context);
    }
}
