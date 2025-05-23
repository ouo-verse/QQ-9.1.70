package com.tencent.upload.report;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReportManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ReportManager";
    private static volatile ReportManager sInstance;
    private final int TIME_REPORT_DELAY;
    private final int WHAT_ADD_TO_CACHE;
    private final int WHAT_REPORT_DELAY;
    private final List<ReportEvent> mReportEvents;
    private Handler mReportHandler;

    ReportManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.WHAT_ADD_TO_CACHE = 1001;
        this.WHAT_REPORT_DELAY = 1002;
        this.TIME_REPORT_DELAY = 5000;
        this.mReportEvents = new ArrayList();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("upload-report");
        baseHandlerThread.start();
        this.mReportHandler = new Handler(baseHandlerThread.getLooper()) { // from class: com.tencent.upload.report.ReportManager.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReportManager.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i3 = message.what;
                if (i3 != 1001) {
                    if (i3 == 1002) {
                        UploadLog.d(ReportManager.TAG, "start group report");
                        Iterator it = ReportManager.this.mReportEvents.iterator();
                        while (it.hasNext()) {
                            ((ReportEvent) it.next()).report();
                        }
                        ReportManager.this.mReportEvents.clear();
                        return;
                    }
                    return;
                }
                Report report = (Report) message.obj;
                Iterator it5 = ReportManager.this.mReportEvents.iterator();
                while (true) {
                    z16 = true;
                    if (it5.hasNext()) {
                        if (((ReportEvent) it5.next()).add(report)) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (!z17) {
                    if (report.uploadType.serverRouteTable.supportFileType != Const.FileType.Photo) {
                        z16 = false;
                    }
                    ReportEvent reportEvent = new ReportEvent(z16);
                    reportEvent.add(report);
                    ReportManager.this.mReportEvents.add(reportEvent);
                }
            }
        };
    }

    public static ReportManager getInstance() {
        if (sInstance == null) {
            synchronized (ReportManager.class) {
                if (sInstance == null) {
                    sInstance = new ReportManager();
                }
            }
        }
        return sInstance;
    }

    public void report(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) abstractUploadTask);
            return;
        }
        Report reportObj = abstractUploadTask.getReportObj();
        if (reportObj.retCode != 0) {
            report(reportObj);
            return;
        }
        this.mReportHandler.removeMessages(1002);
        Message obtain = Message.obtain(this.mReportHandler, 1001);
        obtain.obj = reportObj;
        this.mReportHandler.sendMessage(obtain);
        this.mReportHandler.sendMessageDelayed(Message.obtain(this.mReportHandler, 1002), 5000L);
    }

    public void reportTaskStart(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractUploadTask);
            return;
        }
        Report report = new Report();
        report.reportType = 1;
        report.uploadType = abstractUploadTask.getUploadTaskType();
        report.entry = abstractUploadTask.entry;
        report.refer = abstractUploadTask.reportRefer;
        UploadGlobalConfig.getUploadReport().onUploadReport(report);
    }

    public static void report(Report report) {
        UploadLog.d(TAG, "[speed]" + (((((float) report.fileSize) * 1.0f) * 1000.0f) / ((float) ((report.endTime - report.startTime) * 1024))) + "kb/s");
        UploadGlobalConfig.getUploadReport().onUploadReport(report);
    }
}
