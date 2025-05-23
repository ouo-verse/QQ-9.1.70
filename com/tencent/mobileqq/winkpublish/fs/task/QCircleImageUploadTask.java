package com.tencent.mobileqq.winkpublish.fs.task;

import FileUpload.UploadPicInfoReq;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.uploader.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.route.IRouteIPProvider;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.PhotoTaskTypeConfig;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.Const;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QCircleImageUploadTask extends ImageUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private String f327196d;

    /* renamed from: e, reason: collision with root package name */
    private TaskTypeConfig f327197e;

    /* renamed from: f, reason: collision with root package name */
    private l f327198f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.winkpublish.uploader.a f327199h;

    /* renamed from: i, reason: collision with root package name */
    private ServerRouteTable f327200i;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements IRouteIPProvider {
        a() {
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getBakIps() {
            return QCircleImageUploadTask.this.f327199h.getPhotoBakUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getHostUrl() {
            return QCircleImageUploadTask.this.f327199h.getPhotoHostUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getOptIps() {
            return QCircleImageUploadTask.this.f327199h.getPhotoOptUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
            return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6HostUrl() {
            return QCircleImageUploadTask.this.f327199h.getPhotoHostUrlV6();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6OptIps() {
            return QCircleImageUploadTask.this.f327199h.getPhotoOptUrlV6();
        }
    }

    public QCircleImageUploadTask(boolean z16, String str, String str2, l lVar) {
        super(z16, str);
        this.f327199h = new com.tencent.mobileqq.winkpublish.uploader.a();
        this.f327200i = new ServerRouteTable(Const.FileType.Photo, Const.BusinessType.QCirclePhoto, Const.ConnectType.Epoll, new a());
        this.mAppid = "circle_photo";
        this.f327196d = str2;
        this.f327198f = lVar;
        e();
    }

    private void e() {
        this.f327197e = new PhotoTaskTypeConfig(this.f327200i);
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask
    public UploadPicInfoReq createUploadPicInfoReq() {
        UploadPicInfoReq createUploadPicInfoReq = super.createUploadPicInfoReq();
        createUploadPicInfoReq.iAlbumTypeID = 32;
        return createUploadPicInfoReq;
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask, com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        return this.f327197e;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        this.f327198f.getReporter().a(this.f327198f, new WinkPublishQualityReportData.Builder().eventId("P_UPLOAD_COST").traceId(String.valueOf(this.f327196d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("qcircle_photo").ext6(String.valueOf(report.recentApnKey)).retCode(String.valueOf(new UploadErrorCode(report.retCode, report.errMsg).transformedCode())).attachInfo(report.toJson()).getReportData());
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        if (uploadQualityReportBuilder == null) {
            QLog.w("QCircleImageUploadTask", 1, "builder == null");
        } else {
            d.d(this.f327198f, this.f327196d, uploadQualityReportBuilder);
        }
    }

    public QCircleImageUploadTask(boolean z16, String str, String str2, String str3, l lVar) {
        super(z16, str2);
        this.f327199h = new com.tencent.mobileqq.winkpublish.uploader.a();
        this.f327200i = new ServerRouteTable(Const.FileType.Photo, Const.BusinessType.QCirclePhoto, Const.ConnectType.Epoll, new a());
        this.mAppid = str;
        this.f327196d = str3;
        this.f327198f = lVar;
        e();
    }
}
