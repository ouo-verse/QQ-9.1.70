package com.tencent.qphone.base.util.log.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportLogInfoContext implements ILogReportCallback {
    public static final int TYPE_ACTIVE_REPORT = 1;
    public static final int TYPE_ACTIVE_REPORT_WITH_TXC_HAD_LOGIN = 4;
    public static final int TYPE_AFTER_FETCH_CONFIG_REPORT = 2;
    public static final int TYPE_PASSIVE_REPORT = 0;
    public static final int TYPE_PASSIVE_REPORT_WITH_CMD_LOG_REPORT = 3;

    @NonNull
    private ILogReportCallback callback;

    @NonNull
    public Object config;
    public UploadLogListener injectUploadFileListener;
    public boolean isReport;
    public long logSize;
    public String reportId;
    public long reqSeq;
    public int stat;
    public long zipLogSize;
    public int type = 0;
    public long failCode = -1;
    public String uin = "";
    public boolean withoutLogin = false;
    public long startTimeMillis = 0;
    public long endTimeMillis = 0;
    public long taskId = 0;
    public String qimei36 = "";
    public String pskey = "";
    public int logMaxSizeLimitFromServer = 0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface UploadLogListener {
        void reportUploadLogState(int i3);

        void uploadLogZipFile(File file);
    }

    public void bind(ILogReportCallback iLogReportCallback) {
        this.callback = iLogReportCallback;
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getDay(boolean z16) {
        return this.callback.getDay(z16);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getHour(boolean z16) {
        return this.callback.getHour(z16);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getMonth(boolean z16) {
        return this.callback.getMonth(z16);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public Pair<Long, Long> getTimePeriod() {
        return this.callback.getTimePeriod();
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public int getYear(boolean z16) {
        return this.callback.getYear(z16);
    }

    @Override // com.tencent.qphone.base.util.log.report.ILogReportCallback
    public void onStateChange(int i3) {
        this.callback.onStateChange(i3);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("logInfoContext, stat:");
        sb5.append(this.stat);
        sb5.append(", reqSeq:");
        sb5.append(this.reqSeq);
        sb5.append(", uin:");
        sb5.append(this.uin);
        sb5.append(", withoutLogin:");
        sb5.append(this.withoutLogin);
        sb5.append(", startTimeMillis:");
        sb5.append(this.startTimeMillis);
        sb5.append(", endTimeMillis:");
        sb5.append(this.endTimeMillis);
        sb5.append(", taskId:");
        sb5.append(this.taskId);
        sb5.append(", qimei36:");
        sb5.append(this.qimei36);
        sb5.append(", pskey:");
        sb5.append(!TextUtils.isEmpty(this.pskey));
        sb5.append(", logMaxSizeLimitFromServer:");
        sb5.append(this.logMaxSizeLimitFromServer);
        sb5.append(", logSize:");
        sb5.append(this.logSize);
        sb5.append(", zipLogSize:");
        sb5.append(this.zipLogSize);
        sb5.append(", failCode:");
        sb5.append(this.failCode);
        return sb5.toString();
    }
}
