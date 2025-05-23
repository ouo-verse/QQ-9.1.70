package com.tencent.qphone.base.util.report;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QLogReportManager {
    public static final String LOG_TAG_OVER_LENGTH_1024 = "log_tag_over_length_1024";
    private IQLogReport qLogReport;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class QLogReportManagerSingletonHolder {
        private static final QLogReportManager instance = new QLogReportManager();

        QLogReportManagerSingletonHolder() {
        }
    }

    public static QLogReportManager getInstance() {
        return QLogReportManagerSingletonHolder.instance;
    }

    public void sendToBeacon(String str, HashMap<String, String> hashMap) {
        IQLogReport iQLogReport = this.qLogReport;
        if (iQLogReport != null) {
            iQLogReport.sendToBeacon(str, hashMap);
        }
    }

    public void setQLogReport(IQLogReport iQLogReport) {
        this.qLogReport = iQLogReport;
    }

    QLogReportManager() {
    }
}
