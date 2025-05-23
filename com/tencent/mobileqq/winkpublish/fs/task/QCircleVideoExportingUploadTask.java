package com.tencent.mobileqq.winkpublish.fs.task;

import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.uploader.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.route.IRouteIPProvider;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.VideoTaskTypeConfig;
import com.tencent.upload.uinterface.data.VideoExportingUploadTask;
import com.tencent.upload.utils.Const;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QCircleVideoExportingUploadTask extends VideoExportingUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private String f327202d;

    /* renamed from: e, reason: collision with root package name */
    private TaskTypeConfig f327203e;

    /* renamed from: f, reason: collision with root package name */
    private l f327204f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.winkpublish.uploader.a f327205h;

    /* renamed from: i, reason: collision with root package name */
    private ServerRouteTable f327206i;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements IRouteIPProvider {
        a() {
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getBakIps() {
            return QCircleVideoExportingUploadTask.this.f327205h.getVideoBakUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getHostUrl() {
            return QCircleVideoExportingUploadTask.this.f327205h.getVideoHostUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getOptIps() {
            return QCircleVideoExportingUploadTask.this.f327205h.getVideoOptUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
            return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6HostUrl() {
            return QCircleVideoExportingUploadTask.this.f327205h.getVideoHostUrlV6();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6OptIps() {
            return QCircleVideoExportingUploadTask.this.f327205h.getVideoOptUrlV6();
        }
    }

    public QCircleVideoExportingUploadTask(String str, String str2, l lVar) {
        super(str);
        this.f327205h = new com.tencent.mobileqq.winkpublish.uploader.a();
        this.f327206i = new ServerRouteTable(Const.FileType.Video, Const.BusinessType.QCircleVideo, Const.ConnectType.Epoll, new a());
        this.mAppid = "circle_video";
        this.f327202d = str2;
        this.f327204f = lVar;
        e();
    }

    private void e() {
        this.f327203e = new VideoTaskTypeConfig(this.f327206i);
    }

    @Override // com.tencent.upload.uinterface.data.VideoExportingUploadTask
    public long getDelayWaitExportTimeout() {
        return 45000L;
    }

    @Override // com.tencent.upload.uinterface.data.VideoExportingUploadTask, com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        return this.f327203e;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        this.f327204f.getReporter().a(this.f327204f, new WinkPublishQualityReportData.Builder().eventId("P_UPLOAD_COST").traceId(String.valueOf(this.f327202d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("qcircle_export_video").ext5(String.valueOf(report.leaveSize)).ext6(String.valueOf(report.recentApnKey)).retCode(String.valueOf(new UploadErrorCode(report.retCode, report.errMsg).transformedCode())).attachInfo(report.toJson()).getReportData());
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        if (uploadQualityReportBuilder == null) {
            QLog.w(VideoExportingUploadTask.TAG, 1, "builder == null");
        } else {
            d.d(this.f327204f, this.f327202d, uploadQualityReportBuilder);
        }
    }
}
