package com.tencent.mobileqq.winkpublish.fs.task;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkExport;
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
import com.tencent.upload.uinterface.data.VideoUploadTask;
import com.tencent.upload.utils.Const;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QCircleVideoUploadTask extends VideoUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private String f327208d;

    /* renamed from: e, reason: collision with root package name */
    private TaskTypeConfig f327209e;

    /* renamed from: f, reason: collision with root package name */
    private l f327210f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.winkpublish.uploader.a f327211h;

    /* renamed from: i, reason: collision with root package name */
    private ServerRouteTable f327212i;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements IRouteIPProvider {
        a() {
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getBakIps() {
            return QCircleVideoUploadTask.this.f327211h.getVideoBakUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getHostUrl() {
            return QCircleVideoUploadTask.this.f327211h.getVideoHostUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getOptIps() {
            return QCircleVideoUploadTask.this.f327211h.getVideoOptUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
            return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6HostUrl() {
            return QCircleVideoUploadTask.this.f327211h.getVideoHostUrlV6();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6OptIps() {
            return QCircleVideoUploadTask.this.f327211h.getVideoOptUrlV6();
        }
    }

    public QCircleVideoUploadTask(String str, String str2, l lVar) {
        super(str);
        this.f327211h = new com.tencent.mobileqq.winkpublish.uploader.a();
        this.f327212i = new ServerRouteTable(Const.FileType.Video, Const.BusinessType.QCircleVideo, Const.ConnectType.Epoll, new a());
        this.mAppid = "circle_video";
        this.f327208d = str2;
        this.f327210f = lVar;
        e();
    }

    private void e() {
        this.f327209e = new VideoTaskTypeConfig(this.f327212i);
    }

    @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        return this.f327209e;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        this.f327210f.getReporter().a(this.f327210f, new WinkPublishQualityReportData.Builder().eventId("P_UPLOAD_COST").traceId(String.valueOf(this.f327208d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("qcircle_video").ext6(String.valueOf(report.recentApnKey)).retCode(String.valueOf(new UploadErrorCode(report.retCode, report.errMsg).transformedCode())).attachInfo(report.toJson()).getReportData());
        ((IWinkExport) QRoute.api(IWinkExport.class)).setUploadSpeed(report.networkType, report.fileSize, report.elapse);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QCircleVideoUploadTask{");
        stringBuffer.append("sTitle='");
        stringBuffer.append(this.sTitle);
        stringBuffer.append('\'');
        stringBuffer.append(", sDesc='");
        stringBuffer.append(this.sDesc);
        stringBuffer.append('\'');
        stringBuffer.append(", sCoverUrl='");
        stringBuffer.append(this.sCoverUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", iIsNew=");
        stringBuffer.append(this.iIsNew);
        stringBuffer.append(", iBusiNessType=");
        stringBuffer.append(this.iBusiNessType);
        stringBuffer.append(", iIsOriginalVideo=");
        stringBuffer.append(this.iIsOriginalVideo);
        stringBuffer.append(", iIsFormatF20=");
        stringBuffer.append(this.iIsFormatF20);
        stringBuffer.append(", isSyncWeishi=");
        stringBuffer.append(this.isSyncWeishi);
        stringBuffer.append(", uploadFilePath='");
        stringBuffer.append(this.uploadFilePath);
        stringBuffer.append('\'');
        stringBuffer.append(", iUploadTime=");
        stringBuffer.append(this.iUploadTime);
        stringBuffer.append(", flowId=");
        stringBuffer.append(this.flowId);
        stringBuffer.append(", sRefer=");
        stringBuffer.append(this.sRefer);
        stringBuffer.append(", uploadEntrance=");
        stringBuffer.append(this.uploadEntrance);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        if (uploadQualityReportBuilder == null) {
            QLog.w("[upload2]QCircleVideoUploadTask", 1, "builder == null");
        } else {
            d.d(this.f327210f, this.f327208d, uploadQualityReportBuilder);
        }
    }
}
