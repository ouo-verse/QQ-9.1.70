package com.tencent.mobileqq.winkpublish.fs.task;

import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.uploader.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.data.VideoUploadTask;

/* compiled from: P */
/* loaded from: classes35.dex */
public class GuildVideoUploadTask extends VideoUploadTask {

    /* renamed from: d, reason: collision with root package name */
    private String f327194d;

    /* renamed from: e, reason: collision with root package name */
    private l f327195e;

    public GuildVideoUploadTask(String str, String str2, l lVar) {
        super(str);
        this.f327194d = "";
        this.mAppid = "qchannel_video";
        setIsNew(113);
        this.f327194d = str2;
        this.f327195e = lVar;
    }

    @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        return TaskTypeConfig.GuildVideoUploadTaskType;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean isUseNewTaskReport() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void taskReport(Report report) {
        this.f327195e.getReporter().a(this.f327195e, new WinkPublishQualityReportData.Builder().eventId("P_UPLOAD_COST").traceId(String.valueOf(this.f327194d)).ext1(String.valueOf(report.elapse)).ext2(String.valueOf(report.fileSize)).ext3(String.valueOf(report.networkType)).ext4("guild_video").retCode(String.valueOf(new UploadErrorCode(report.retCode, report.errMsg).transformedCode())).getReportData());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GuildVideoUploadTask{");
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
            QLog.w("[upload2]GuildVideoUploadTask", 1, "builder == null");
        } else {
            d.d(this.f327195e, this.f327194d, uploadQualityReportBuilder);
        }
    }
}
