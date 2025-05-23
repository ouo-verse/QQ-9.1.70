package com.qzone.publish.business.task.intimate;

import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
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
import eo.d;
import r7.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneImageUploadTask extends ImageUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private final String f51207d;

    /* renamed from: e, reason: collision with root package name */
    private TaskTypeConfig f51208e;

    /* renamed from: f, reason: collision with root package name */
    private final b f51209f;

    /* renamed from: h, reason: collision with root package name */
    private final ServerRouteTable f51210h;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IRouteIPProvider {
        a() {
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getBakIps() {
            return QZoneImageUploadTask.this.f51209f.getPhotoBakUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getHostUrl() {
            return QZoneImageUploadTask.this.f51209f.getPhotoHostUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getOptIps() {
            return QZoneImageUploadTask.this.f51209f.getPhotoOptUrl();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
            return a9.b.f25722a.c();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6HostUrl() {
            return QZoneImageUploadTask.this.f51209f.getPhotoHostUrlV6();
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6OptIps() {
            return QZoneImageUploadTask.this.f51209f.getPhotoOptUrlV6();
        }
    }

    public QZoneImageUploadTask(boolean z16, String str, String str2) {
        super(z16, str);
        this.f51209f = new b();
        ServerRouteTable serverRouteTable = new ServerRouteTable(Const.FileType.Photo, Const.BusinessType.QZonePhoto, Const.ConnectType.Epoll, new a(), UploadSdkConst.DEFAULT_PIC_HOST, UploadSdkConst.DEFAULT_PIC_BK_HOST);
        this.f51210h = serverRouteTable;
        this.f51207d = str2;
        this.f51208e = new PhotoTaskTypeConfig(serverRouteTable);
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask, com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        return this.f51208e;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        QLog.d("QZoneImageUploadTask", 1, "taskReport:" + report);
        d.b(new WinkPublishQualityReportData.Builder().eventId(d.f396881a).traceId(String.valueOf(this.f51207d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("qzone_photo").retCode(String.valueOf(new UploadErrorCode((long) report.retCode, report.errMsg).transformedCode())).desc(report.errMsg).getReportData());
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        if (uploadQualityReportBuilder == null) {
            QLog.w("QZoneImageUploadTask", 1, "builder == null");
        } else {
            d.c(this.f51207d, uploadQualityReportBuilder);
        }
    }
}
