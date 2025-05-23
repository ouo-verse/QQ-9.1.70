package com.qzone.publish.business.task.upload;

import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.route.IRouteIPProvider;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.UploadSdkConst;
import com.tencent.upload.uinterface.VideoTaskTypeConfig;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import com.tencent.upload.utils.Const;
import eo.d;
import r7.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneVideoUploadTask extends VideoUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private final String f51226d;

    /* renamed from: e, reason: collision with root package name */
    private TaskTypeConfig f51227e;

    /* renamed from: f, reason: collision with root package name */
    private final b f51228f;

    /* renamed from: h, reason: collision with root package name */
    private final ServerRouteTable f51229h;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IRouteIPProvider {
        a() {
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getBakIps() {
            return QZoneVideoUploadTask.this.f51228f.getVideoBakUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getHostUrl() {
            return QZoneVideoUploadTask.this.f51228f.getVideoHostUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getOptIps() {
            return QZoneVideoUploadTask.this.f51228f.getVideoOptUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
            return a9.b.f25722a.c();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6HostUrl() {
            return QZoneVideoUploadTask.this.f51228f.getVideoHostUrlV6();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6OptIps() {
            return QZoneVideoUploadTask.this.f51228f.getVideoOptUrlV6();
        }
    }

    public QZoneVideoUploadTask(String str, String str2) {
        super(str);
        this.f51228f = new b();
        ServerRouteTable serverRouteTable = new ServerRouteTable(Const.FileType.Video, Const.BusinessType.QZoneVideo, Const.ConnectType.Epoll, new a(), UploadSdkConst.DEFAULT_VIDEO_HOST, UploadSdkConst.DEFAULT_VIDEO_BK_HOST);
        this.f51229h = serverRouteTable;
        this.f51226d = str2;
        this.f51227e = new VideoTaskTypeConfig(serverRouteTable);
    }

    @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        return this.f51227e;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        QLog.d("[upload2]QZoneVideoUploadTask", 1, "taskReport:" + report);
        d.b(new WinkPublishQualityReportData.Builder().eventId(d.f396881a).traceId(String.valueOf(this.f51226d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("qzone_video").retCode(String.valueOf(new UploadErrorCode((long) report.retCode, report.errMsg).transformedCode())).desc(report.errMsg).getReportData());
    }

    public String toString() {
        return "QZoneVideoUploadTask{sTitle='" + this.sTitle + "', sDesc='" + this.sDesc + "', sCoverUrl='" + this.sCoverUrl + "', iIsNew=" + this.iIsNew + ", iBusiNessType=" + this.iBusiNessType + ", iIsOriginalVideo=" + this.iIsOriginalVideo + ", iIsFormatF20=" + this.iIsFormatF20 + ", uploadFilePath='" + this.uploadFilePath + "', iUploadTime=" + this.iUploadTime + ", flowId=" + this.flowId + ", sRefer=" + this.sRefer + ", uploadEntrance=" + this.uploadEntrance + ", mTraceId=" + this.f51226d + '}';
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        if (uploadQualityReportBuilder == null) {
            QLog.w("[upload2]QZoneVideoUploadTask", 1, "builder == null");
        } else {
            d.c(this.f51226d, uploadQualityReportBuilder);
        }
    }
}
