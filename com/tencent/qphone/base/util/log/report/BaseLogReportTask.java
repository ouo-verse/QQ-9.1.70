package com.tencent.qphone.base.util.log.report;

import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseLogReportTask implements Runnable, ILogReportCallback {
    public static final String TAG = "MSF.C.BaseLogReportTask";

    @NonNull
    protected ReportLogInfoContext context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLogReportTask(@NonNull ReportLogInfoContext reportLogInfoContext) {
        this.context = reportLogInfoContext;
    }

    public void onStateChange(int i3) {
        QLog.d(TAG, 1, "onStateChange stat=" + i3);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "zip file start");
        }
        String zipLog = zipLog();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "zip file finish");
        }
        File file = new File(zipLog);
        if (file.exists()) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "report file start");
                }
                uploadLog(file);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "report file finish");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "report log error " + e16, e16);
                }
            }
            file.deleteOnExit();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "zip file not existed.");
        }
    }

    protected String zipLog() {
        return LogManager.zipLog(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadLog(File file) throws Exception {
    }
}
