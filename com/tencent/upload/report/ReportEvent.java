package com.tencent.upload.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReportEvent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ReportEvent";
    public long endTime;
    private boolean isPhotoType;
    public List<Report> reports;
    public long startTime;

    public ReportEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.startTime = 0L;
        this.endTime = 0L;
        this.reports = new ArrayList();
        this.isPhotoType = z16;
    }

    private void calculateAvgSpeed() {
        if (this.reports.size() == 0) {
            return;
        }
        long j3 = this.endTime - this.startTime;
        long size = j3 / this.reports.size();
        long j16 = 0;
        for (Report report : this.reports) {
            report.endTime = report.startTime + size;
            j16 += report.fileSize;
        }
        UploadLog.d(TAG, "[speed]" + (((((float) j16) * 1.0f) * 1000.0f) / ((float) (j3 * 1024))) + "kb/s");
    }

    public boolean add(Report report) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) report)).booleanValue();
        }
        if (report.uploadType.serverRouteTable.supportFileType == Const.FileType.Photo) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != this.isPhotoType) {
            return false;
        }
        long j3 = report.startTime;
        if (j3 > 0) {
            long j16 = report.endTime;
            if (j16 >= j3 && j16 - j3 <= 900000) {
                long j17 = this.startTime;
                if (j17 == 0 && this.endTime == 0) {
                    this.startTime = j3;
                    this.endTime = j16;
                    this.reports.add(report);
                    return true;
                }
                if (j17 <= j3) {
                    long j18 = this.endTime;
                    if (j18 >= j3) {
                        this.endTime = Math.max(j18, j16);
                        this.reports.add(report);
                        return true;
                    }
                }
                if (j17 < j16 && this.endTime >= j16) {
                    this.startTime = Math.min(j17, j3);
                    this.reports.add(report);
                    return true;
                }
            }
        }
        return false;
    }

    public void report() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        calculateAvgSpeed();
        for (Report report : this.reports) {
            UploadGlobalConfig.getUploadReport().onUploadReport(report);
            UploadLog.d(TAG, "report id :" + report.flowId);
        }
    }
}
