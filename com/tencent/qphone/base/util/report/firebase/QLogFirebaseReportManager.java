package com.tencent.qphone.base.util.report.firebase;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QLogFirebaseReportManager {
    private IFirebaseLogReport firebaseLogReport;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class QLogFirebaseReportManagerSingletonHolder {
        private static final QLogFirebaseReportManager instance = new QLogFirebaseReportManager();

        QLogFirebaseReportManagerSingletonHolder() {
        }
    }

    public static QLogFirebaseReportManager getInstance() {
        return QLogFirebaseReportManagerSingletonHolder.instance;
    }

    public boolean isFirebaseReportNotNull() {
        if (this.firebaseLogReport != null) {
            return true;
        }
        return false;
    }

    public void sendToGoogleFirebase(String str) {
        IFirebaseLogReport iFirebaseLogReport = this.firebaseLogReport;
        if (iFirebaseLogReport != null) {
            iFirebaseLogReport.sendToGoogleFirebase(str);
        }
    }

    public void setFirebaseLogReport(IFirebaseLogReport iFirebaseLogReport) {
        this.firebaseLogReport = iFirebaseLogReport;
    }

    QLogFirebaseReportManager() {
    }
}
