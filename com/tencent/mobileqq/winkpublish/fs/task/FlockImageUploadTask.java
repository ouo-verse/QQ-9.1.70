package com.tencent.mobileqq.winkpublish.fs.task;

import FileUpload.UploadPicInfoReq;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.uploader.a;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\u00020\u0001:\u0001*B7\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/fs/task/FlockImageUploadTask;", "Lcom/tencent/upload/uinterface/data/ImageUploadTask;", "LFileUpload/UploadPicInfoReq;", "createUploadPicInfoReq", "Lcom/tencent/upload/uinterface/TaskTypeConfig;", "getUploadTaskType", "", "isUseNewTaskReport", "Lcom/tencent/upload/report/Report;", "report", "", "taskReport", "Lcom/tencent/upload/report/UploadQualityReportBuilder;", "builder", "onSessionReport", "", "d", "Ljava/lang/String;", "mTraceId", "e", "Lcom/tencent/upload/uinterface/TaskTypeConfig;", "mTaskTypeConfig", "Lcom/tencent/mobileqq/winkpublish/config/l;", "f", "Lcom/tencent/mobileqq/winkpublish/config/l;", "mConfig", "Lcom/tencent/mobileqq/winkpublish/uploader/a;", h.F, "Lcom/tencent/mobileqq/winkpublish/uploader/a;", "aUploadConfig", "Lcom/tencent/upload/network/route/ServerRouteTable;", "i", "Lcom/tencent/upload/network/route/ServerRouteTable;", "mVideoRouteTable", "isHead", "appId", "originalPath", "clientTraceId", DownloadInfo.spKey_Config, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/config/l;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FlockImageUploadTask extends ImageUploadTask {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mTraceId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TaskTypeConfig mTaskTypeConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private l mConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final a aUploadConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ServerRouteTable mVideoRouteTable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/winkpublish/fs/task/FlockImageUploadTask$b", "Lcom/tencent/upload/network/route/IRouteIPProvider;", "", "getOptIps", "getHostUrl", "getBakIps", "getV6HostUrl", "getV6OptIps", "Lcom/tencent/upload/network/route/ServerRouteTable$PriorityPolicy;", "getPriorityPolicy", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IRouteIPProvider {
        b() {
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getBakIps() {
            return null;
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getHostUrl() {
            return "daziphoto.upqzfile.com";
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getOptIps() {
            return null;
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
            return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6HostUrl() {
            return "daziphoto.upqzfile.com";
        }

        @Override // com.tencent.upload.network.route.IRouteIPProvider
        public String getV6OptIps() {
            return null;
        }
    }

    public FlockImageUploadTask(boolean z16, String str, String str2, String str3, l lVar) {
        super(z16, str2);
        this.aUploadConfig = new a();
        ServerRouteTable serverRouteTable = new ServerRouteTable(Const.FileType.Photo, Const.BusinessType.FlockPhoto, Const.ConnectType.Epoll, new b());
        this.mVideoRouteTable = serverRouteTable;
        this.mAppid = str;
        this.mTraceId = str3;
        this.mConfig = lVar;
        this.mTaskTypeConfig = new PhotoTaskTypeConfig(serverRouteTable);
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask
    public UploadPicInfoReq createUploadPicInfoReq() {
        UploadPicInfoReq createUploadPicInfoReq = super.createUploadPicInfoReq();
        createUploadPicInfoReq.iAlbumTypeID = 32;
        return createUploadPicInfoReq;
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask, com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType, reason: from getter */
    public TaskTypeConfig getMTaskTypeConfig() {
        return this.mTaskTypeConfig;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        Intrinsics.checkNotNullParameter(report, "report");
        WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("P_UPLOAD_COST").traceId(String.valueOf(this.mTraceId)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("flock_photo").retCode(String.valueOf(new UploadErrorCode(report.retCode, report.errMsg).transformedCode())).attachInfo(report.toJson()).getReportData();
        l lVar = this.mConfig;
        Intrinsics.checkNotNull(lVar);
        com.tencent.mobileqq.winkpublish.report.a reporter = lVar.getReporter();
        l lVar2 = this.mConfig;
        Intrinsics.checkNotNull(lVar2);
        reporter.a(lVar2, reportData);
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder builder) {
        if (builder == null) {
            QLog.w("FlockImageUploadTask", 1, "builder == null");
        } else {
            d.d(this.mConfig, this.mTraceId, builder);
        }
    }
}
