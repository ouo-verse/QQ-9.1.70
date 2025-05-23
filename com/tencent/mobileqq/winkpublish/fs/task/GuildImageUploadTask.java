package com.tencent.mobileqq.winkpublish.fs.task;

import FileUpload.UploadPicInfoReq;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.uploader.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.data.ImageUploadTask;

/* compiled from: P */
/* loaded from: classes35.dex */
public class GuildImageUploadTask extends ImageUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private String f327192d;

    /* renamed from: e, reason: collision with root package name */
    private l f327193e;

    public GuildImageUploadTask(boolean z16, String str, String str2, l lVar) {
        super(z16, str);
        this.mAppid = "qchannel_photo";
        this.f327193e = lVar;
        this.f327192d = str2;
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask
    public UploadPicInfoReq createUploadPicInfoReq() {
        UploadPicInfoReq createUploadPicInfoReq = super.createUploadPicInfoReq();
        createUploadPicInfoReq.iAlbumTypeID = 32;
        return createUploadPicInfoReq;
    }

    @Override // com.tencent.upload.uinterface.data.ImageUploadTask, com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        return TaskTypeConfig.GuildImageUploadTaskType;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        this.f327193e.getReporter().a(this.f327193e, new WinkPublishQualityReportData.Builder().eventId("P_UPLOAD_COST").traceId(String.valueOf(this.f327192d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("guild_photo").retCode(String.valueOf(new UploadErrorCode(report.retCode, report.errMsg).transformedCode())).getReportData());
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder) {
        if (uploadQualityReportBuilder == null) {
            QLog.w("[upload2]GuildImageUploadTask", 1, "builder == null");
        } else {
            d.d(this.f327193e, this.f327192d, uploadQualityReportBuilder);
        }
    }
}
