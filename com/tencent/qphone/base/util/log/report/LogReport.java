package com.tencent.qphone.base.util.log.report;

import android.os.Handler;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.msf.service.protocol.serverconfig.a;
import com.tencent.msf.service.protocol.serverconfig.f;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.report.ReportLogInfoContext;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.trpcprotocol.qqlog.qqlog_manage.QqlogManage$MsgBody;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LogReport {
    public static final String TAG = "MSF.C.LogReport";
    private static LogReport sInstance;
    private LinkedBlockingDeque<ReportLogInfoContext> _waitLogUploadQueue = new LinkedBlockingDeque<>(1000);
    private Handler mLogRecvHandler = null;
    private Thread logUploadThread = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class LogUploadThread extends BaseThread {
        public static final String TAG = "LogUploadThread";

        public LogUploadThread() {
            super(TAG);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    try {
                        LogReport.generateLogReportTask((ReportLogInfoContext) LogReport.this._waitLogUploadQueue.take()).run();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 2, "handle report log error " + e16, e16);
                        }
                        if (LogReport.this._waitLogUploadQueue.isEmpty()) {
                            break;
                        }
                    }
                    if (LogReport.this._waitLogUploadQueue.isEmpty()) {
                        break;
                    }
                } catch (Throwable th5) {
                    if (!LogReport.this._waitLogUploadQueue.isEmpty()) {
                        throw th5;
                    }
                }
            }
            LogReport.this.logUploadThread = null;
        }
    }

    LogReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BaseLogReportTask generateLogReportTask(ReportLogInfoContext reportLogInfoContext) {
        BaseLogReportTask activeLogReportTask;
        int i3 = reportLogInfoContext.type;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        activeLogReportTask = new PassiveLogReportTask(reportLogInfoContext);
                    } else {
                        activeLogReportTask = new ActiveLogReportWithTxcLoginV2Task(reportLogInfoContext);
                    }
                } else {
                    activeLogReportTask = new PassiveWithCmdLogReportTask(reportLogInfoContext);
                }
            } else {
                activeLogReportTask = new AfterFetchConfigLogReportTask(reportLogInfoContext);
            }
        } else {
            activeLogReportTask = new ActiveLogReportTask(reportLogInfoContext);
        }
        reportLogInfoContext.bind(activeLogReportTask);
        QLog.d(TAG, 1, "generateLogReportTask type=" + reportLogInfoContext.type);
        return activeLogReportTask;
    }

    public static LogReport getInstance() {
        if (sInstance == null) {
            synchronized (LogReport.class) {
                if (sInstance == null) {
                    sInstance = new LogReport();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLogReportPush(ReportLogInfoContext.UploadLogListener uploadLogListener, QqlogManage$MsgBody qqlogManage$MsgBody, String str) {
        if (qqlogManage$MsgBody == null) {
            QLog.i(TAG, 1, "handleLogPush, repeated push ignored");
            return;
        }
        if (qqlogManage$MsgBody.cmd.get() == 1) {
            long j3 = qqlogManage$MsgBody.seq.get();
            long j16 = qqlogManage$MsgBody.start_time.get();
            long j17 = qqlogManage$MsgBody.end_time.get();
            int i3 = qqlogManage$MsgBody.log_size.get();
            ReportLogInfoContext reportLogInfoContext = new ReportLogInfoContext();
            reportLogInfoContext.type = 3;
            reportLogInfoContext.config = new a();
            reportLogInfoContext.reqSeq = j3;
            reportLogInfoContext.uin = str;
            reportLogInfoContext.startTimeMillis = j16 * 1000;
            reportLogInfoContext.endTimeMillis = j17 * 1000;
            reportLogInfoContext.logMaxSizeLimitFromServer = i3;
            reportLogInfoContext.reportId = j3 + ContainerUtils.FIELD_DELIMITER + System.currentTimeMillis();
            reportLogInfoContext.injectUploadFileListener = uploadLogListener;
            if (LogPushManager.checkPushSeqExists(reportLogInfoContext, j3)) {
                QLog.i(TAG, 1, "handleLogPush, repeated push ignored");
                reportLogInfoContext.isReport = true;
                reportLogInfoContext.failCode = j3;
                return;
            }
            addLogReportContext(reportLogInfoContext);
        }
    }

    public static void reportLog(String str, boolean z16, long j3, long j16, String str2) {
        ReportLogInfoContext reportLogInfoContext = new ReportLogInfoContext();
        reportLogInfoContext.type = 1;
        reportLogInfoContext.config = new Object[]{str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16)};
        reportLogInfoContext.reqSeq = 0L;
        reportLogInfoContext.reportId = "0&" + System.currentTimeMillis();
        reportLogInfoContext.pskey = str2;
        QLog.i(TAG, 1, "reportLog: " + reportLogInfoContext);
        getInstance().addLogReportContext(reportLogInfoContext);
    }

    public static void reportLogAfterFetchConfig(ToServiceMsg toServiceMsg) {
        String uin = toServiceMsg.getUin();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, Boolean.FALSE)).booleanValue();
        Long l3 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, 0L);
        Long l16 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, 0L);
        Long l17 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_TASK_ID, 0L);
        String str = (String) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_QIMEI36, "");
        ReportLogInfoContext reportLogInfoContext = new ReportLogInfoContext();
        reportLogInfoContext.type = 2;
        reportLogInfoContext.config = new Object[]{uin, Boolean.valueOf(booleanValue), l3, l16, l17, str};
        reportLogInfoContext.reqSeq = 0L;
        reportLogInfoContext.reportId = "0&" + System.currentTimeMillis();
        reportLogInfoContext.uin = uin;
        reportLogInfoContext.withoutLogin = booleanValue;
        reportLogInfoContext.startTimeMillis = l3.longValue();
        reportLogInfoContext.endTimeMillis = l16.longValue();
        reportLogInfoContext.taskId = l17.longValue();
        reportLogInfoContext.qimei36 = str;
        QLog.i(TAG, 1, "reportLogAfterFetchConfig: " + reportLogInfoContext);
        getInstance().addLogReportContext(reportLogInfoContext);
    }

    public void addLogReportContext(ReportLogInfoContext reportLogInfoContext) {
        this._waitLogUploadQueue.offer(reportLogInfoContext);
        if (this.logUploadThread == null) {
            LogUploadThread logUploadThread = new LogUploadThread();
            this.logUploadThread = logUploadThread;
            logUploadThread.start();
        }
    }

    public void onLogPush(final FromServiceMsg fromServiceMsg, final f fVar) {
        if (this.mLogRecvHandler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("logUploadHandle");
            baseHandlerThread.start();
            this.mLogRecvHandler = new Handler(baseHandlerThread.getLooper());
        }
        this.mLogRecvHandler.post(new Runnable() { // from class: com.tencent.qphone.base.util.log.report.LogReport.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr = fVar.f336804b;
                if (bArr != null && bArr.length > 0) {
                    JceInputStream jceInputStream = new JceInputStream(bArr);
                    a aVar = new a();
                    aVar.readFrom(jceInputStream);
                    int i3 = aVar.f336743a;
                    if (i3 == 2) {
                        QLog.d(LogReport.TAG, 1, "handleLogPush: _CliLogCfgSetLevel", Byte.valueOf(aVar.f336746d));
                        MsfStore.getNativeConfigStore().setConfig(QLog.logLevelHead, String.valueOf((int) aVar.f336746d));
                        MsfStore.getNativeConfigStore().setConfig(QLog.logLevelTime, String.valueOf(System.currentTimeMillis()));
                        QLog.setUIN_REPORTLOG_LEVEL(aVar.f336746d);
                        MsfCore.initAppProMsg("*", fromServiceMsg.getAppId());
                        return;
                    }
                    if (i3 == 1) {
                        aVar.f336748f = fVar.f336805c;
                        ReportLogInfoContext reportLogInfoContext = new ReportLogInfoContext();
                        reportLogInfoContext.type = 0;
                        reportLogInfoContext.config = aVar;
                        reportLogInfoContext.reqSeq = fVar.f336805c;
                        reportLogInfoContext.uin = MsfService.getCore().getAccountCenter().e();
                        reportLogInfoContext.reportId = fVar.f336805c + ContainerUtils.FIELD_DELIMITER + System.currentTimeMillis();
                        LogEventReporter.newLogEvent(LogEventReporter.EVENT_UPLOAD_LOG, reportLogInfoContext);
                        if (LogPushManager.checkPushSeqExists(reportLogInfoContext, fVar.f336805c)) {
                            QLog.i(LogReport.TAG, 1, "handleLogPush, repeated push ignored");
                            reportLogInfoContext.isReport = true;
                            reportLogInfoContext.failCode = fVar.f336805c;
                            LogEventReporter.changeEventStat(LogEventReporter.EVENT_UPLOAD_LOG, 11, reportLogInfoContext);
                            return;
                        }
                        LogReport.this.addLogReportContext(reportLogInfoContext);
                    }
                }
            }
        });
    }

    public void onLogPushBy0x210_0x14f(final ReportLogInfoContext.UploadLogListener uploadLogListener, final QqlogManage$MsgBody qqlogManage$MsgBody, final String str) {
        if (this.mLogRecvHandler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("logUploadHandle");
            baseHandlerThread.start();
            this.mLogRecvHandler = new Handler(baseHandlerThread.getLooper());
        }
        this.mLogRecvHandler.post(new Runnable() { // from class: com.tencent.qphone.base.util.log.report.LogReport.2
            @Override // java.lang.Runnable
            public void run() {
                if (qqlogManage$MsgBody != null) {
                    QLog.i(LogReport.TAG, 1, "handle log CMD: onLogPushBy0x210_0x14f");
                    LogReport.this.handleLogReportPush(uploadLogListener, qqlogManage$MsgBody, str);
                }
            }
        });
    }

    public void onLogPushColorLevel(ToServiceMsg toServiceMsg) {
        int intValue = ((Integer) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_COLOR_LEVEL, 1)).intValue();
        QLog.d(TAG, 1, "onLogPushColorLevel: _CliLogCfgSetLevel:" + intValue);
        MsfStore.getNativeConfigStore().setConfig(QLog.logLevelHead, String.valueOf(intValue));
        MsfStore.getNativeConfigStore().setConfig(QLog.logLevelTime, String.valueOf(System.currentTimeMillis()));
        QLog.setUIN_REPORTLOG_LEVEL(intValue);
        MsfCore.initAppProMsg("*", toServiceMsg.getAppId());
    }

    public void txcActiveReportLog(final String str, final long j3, final long j16, final long j17, final ReportLogInfoContext.UploadLogListener uploadLogListener) {
        if (this.mLogRecvHandler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("logUploadHandle");
            baseHandlerThread.start();
            this.mLogRecvHandler = new Handler(baseHandlerThread.getLooper());
        }
        this.mLogRecvHandler.post(new Runnable() { // from class: com.tencent.qphone.base.util.log.report.LogReport.3
            @Override // java.lang.Runnable
            public void run() {
                if (uploadLogListener != null) {
                    QLog.i(LogReport.TAG, 1, "handle log : txcActiveReportLog");
                    ReportLogInfoContext reportLogInfoContext = new ReportLogInfoContext();
                    reportLogInfoContext.type = 4;
                    reportLogInfoContext.config = new a();
                    reportLogInfoContext.reqSeq = j3;
                    reportLogInfoContext.uin = str;
                    reportLogInfoContext.startTimeMillis = j16;
                    reportLogInfoContext.endTimeMillis = j17;
                    reportLogInfoContext.reportId = j3 + ContainerUtils.FIELD_DELIMITER + System.currentTimeMillis();
                    reportLogInfoContext.injectUploadFileListener = uploadLogListener;
                    if (LogPushManager.checkPushSeqExists(reportLogInfoContext, j3)) {
                        QLog.i(LogReport.TAG, 1, "txcActiveReportLog, repeated push ignored");
                        reportLogInfoContext.isReport = true;
                        reportLogInfoContext.failCode = j3;
                        return;
                    }
                    LogReport.this.addLogReportContext(reportLogInfoContext);
                }
            }
        });
    }
}
