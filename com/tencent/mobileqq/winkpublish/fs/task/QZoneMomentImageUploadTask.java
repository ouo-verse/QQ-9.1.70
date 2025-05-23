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
import com.tencent.upload.uinterface.UploadSdkConst;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.Const;
import common.config.service.QzoneConfig;
import uq3.c;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QZoneMomentImageUploadTask extends ImageUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private String f327214d;

    /* renamed from: e, reason: collision with root package name */
    private TaskTypeConfig f327215e;

    /* renamed from: f, reason: collision with root package name */
    private l f327216f;

    /* renamed from: h, reason: collision with root package name */
    private ServerRouteTable f327217h;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements IRouteIPProvider {
        a() {
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getBakIps() {
            return c.a1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_BAK_IP);
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getHostUrl() {
            return c.b1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP, UploadSdkConst.DEFAULT_PIC_HOST);
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getOptIps() {
            return c.a1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP);
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
            return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6HostUrl() {
            return c.b1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP_V6, "v6.pic.upqzfile.com");
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6OptIps() {
            return c.a1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP_V6);
        }
    }

    public QZoneMomentImageUploadTask(boolean z16, String str, String str2, l lVar) {
        super(z16, str);
        this.f327217h = new ServerRouteTable(Const.FileType.Photo, Const.BusinessType.QZonePhoto, Const.ConnectType.Epoll, new a());
        this.mAppid = "moment_photo";
        this.f327214d = str2;
        this.f327216f = lVar;
        this.f327215e = new PhotoTaskTypeConfig(this.f327217h);
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask
    public UploadPicInfoReq createUploadPicInfoReq() {
        UploadPicInfoReq createUploadPicInfoReq = super.createUploadPicInfoReq();
        createUploadPicInfoReq.iAlbumTypeID = 22;
        return createUploadPicInfoReq;
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask, com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        return this.f327215e;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        this.f327216f.getReporter().a(this.f327216f, new WinkPublishQualityReportData.Builder().eventId("P_UPLOAD_COST").traceId(String.valueOf(this.f327214d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("qzone_moment_photo").retCode(String.valueOf(new UploadErrorCode(report.retCode, report.errMsg).transformedCode())).attachInfo(report.toJson()).getReportData());
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        if (uploadQualityReportBuilder == null) {
            QLog.w("QZoneMomentImageUploadTask", 1, "builder == null");
        } else {
            d.d(this.f327216f, this.f327214d, uploadQualityReportBuilder);
        }
    }
}
