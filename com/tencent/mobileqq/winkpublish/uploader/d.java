package com.tencent.mobileqq.winkpublish.uploader;

import SLICE_UPLOAD.cnst.appid_mobilelog;
import SLICE_UPLOAD.cnst.appid_qun;
import SLICE_UPLOAD.cnst.appid_upp;
import SLICE_UPLOAD.cnst.appid_ups;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheFlowerData;
import com.tencent.component.network.module.report.ReportObj;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.uploader.report.AUploadBusinessReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d implements IUploadReport {

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a extends c {
        @Override // com.tencent.mobileqq.winkpublish.uploader.report.a
        protected String a() {
            if (this.f327437k) {
                return WidgetCacheFlowerData.WATER;
            }
            return ReportObj.REPORT_REFER_QQ_QUN;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class b extends com.tencent.mobileqq.winkpublish.uploader.report.a {

        /* renamed from: p, reason: collision with root package name */
        public int f327407p;

        /* renamed from: q, reason: collision with root package name */
        public int f327408q;

        /* renamed from: v, reason: collision with root package name */
        public int f327413v;

        /* renamed from: r, reason: collision with root package name */
        public String f327409r = "";

        /* renamed from: s, reason: collision with root package name */
        public long f327410s = 0;

        /* renamed from: t, reason: collision with root package name */
        public long f327411t = 0;

        /* renamed from: u, reason: collision with root package name */
        public long f327412u = 0;

        /* renamed from: w, reason: collision with root package name */
        public boolean f327414w = false;

        @Override // com.tencent.mobileqq.winkpublish.uploader.report.a
        public boolean b() {
            return this.f327413v != 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class c extends b {

        /* renamed from: x, reason: collision with root package name */
        public String f327415x = "";
    }

    public static int b(TaskTypeConfig taskTypeConfig) {
        if (TaskTypeConfig.NewQunUploadTaskType.equals(taskTypeConfig)) {
            return 10;
        }
        if (TaskTypeConfig.ImageUploadTaskType.equals(taskTypeConfig)) {
            return 0;
        }
        if (TaskTypeConfig.UppUploadTaskType.equals(taskTypeConfig)) {
            return 8;
        }
        if (TaskTypeConfig.UpsUploadTaskType.equals(taskTypeConfig)) {
            return 12;
        }
        if (TaskTypeConfig.PhotoWallUploadTaskType.equals(taskTypeConfig)) {
            return 14;
        }
        if (TaskTypeConfig.MobileLogUploadTaskType.equals(taskTypeConfig)) {
            return 16;
        }
        if (TaskTypeConfig.VideoUploadTaskType.equals(taskTypeConfig)) {
            return 2;
        }
        if (TaskTypeConfig.QcircleVideoUploadTaskType.equals(taskTypeConfig)) {
            return 20;
        }
        if (TaskTypeConfig.QcircleImageUploadTaskType.equals(taskTypeConfig)) {
            return 18;
        }
        if (TaskTypeConfig.GuildVideoUploadTaskType.equals(taskTypeConfig)) {
            return 24;
        }
        if (TaskTypeConfig.GuildImageUploadTaskType.equals(taskTypeConfig)) {
            return 22;
        }
        return TaskTypeConfig.QcircleVideoExportUploadTaskType.equals(taskTypeConfig) ? 26 : -1;
    }

    public static void d(l lVar, String str, UploadQualityReportBuilder uploadQualityReportBuilder) {
        lVar.getReporter().a(lVar, new WinkPublishQualityReportData.Builder().eventId(lVar.getEventIdPrefix() + "T_UPLOAD_SESSION_REPORT").traceId(String.valueOf(str)).retCode(uploadQualityReportBuilder.getKeyRetCode()).desc(uploadQualityReportBuilder.getDesc()).ext1(uploadQualityReportBuilder.getExt1()).ext2(uploadQualityReportBuilder.getExt2()).ext3(uploadQualityReportBuilder.getExt3()).ext4(uploadQualityReportBuilder.getExt4()).ext5(uploadQualityReportBuilder.getExt5()).ext6(uploadQualityReportBuilder.getExt6()).attachInfo(uploadQualityReportBuilder.getAttachInfo()).getReportData());
    }

    public static void e(String str, String str2, UploadQualityReportBuilder uploadQualityReportBuilder) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(str + "T_UPLOAD_SESSION_REPORT").setTraceId(str2).setKeyRetCode(uploadQualityReportBuilder.getKeyRetCode()).setDesc(uploadQualityReportBuilder.getDesc()).setExt1(uploadQualityReportBuilder.getExt1()).setExt2(uploadQualityReportBuilder.getExt2()).setExt3(uploadQualityReportBuilder.getExt3()).setExt4(uploadQualityReportBuilder.getExt4()).setExt5(uploadQualityReportBuilder.getExt5()).setExt6(uploadQualityReportBuilder.getExt6()).setAttachInfo(uploadQualityReportBuilder.getAttachInfo()));
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void onUploadReport(Report report) {
        AUploadBusinessReport.h(a(report), b(report.uploadType), 0);
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void batchComplete() {
        AUploadBusinessReport.i(18, 0);
        AUploadBusinessReport.i(20, 0);
        AUploadBusinessReport.i(26, 0);
        AUploadBusinessReport.i(22, 0);
        AUploadBusinessReport.i(24, 0);
        AUploadBusinessReport.i(0, 0);
        AUploadBusinessReport.i(2, 0);
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder, TaskTypeConfig taskTypeConfig) {
        String str;
        if (uploadQualityReportBuilder == null) {
            QLog.w("[upload2]AUploadReport", 1, "sessionReportBuilder == null");
            return;
        }
        if (taskTypeConfig != null) {
            if (taskTypeConfig != TaskTypeConfig.GuildImageUploadTaskType && taskTypeConfig != TaskTypeConfig.GuildVideoUploadTaskType) {
                if (taskTypeConfig == TaskTypeConfig.QcircleImageUploadTaskType || taskTypeConfig == TaskTypeConfig.QcircleVideoUploadTaskType || taskTypeConfig == TaskTypeConfig.QcircleVideoExportUploadTaskType) {
                    str = WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE;
                }
            } else {
                str = WinkPublishConfigConstant.EVENTID_PREFIX_GUILD;
            }
            e(str, "", uploadQualityReportBuilder);
        }
        str = "";
        e(str, "", uploadQualityReportBuilder);
    }

    public static b a(Report report) {
        if (report == null) {
            return null;
        }
        b bVar = new b();
        int b16 = b(report.uploadType);
        b c16 = c(bVar, b16);
        c16.f327438l = b16;
        c16.f327429c = report.serverIp;
        c16.f327407p = report.retry;
        c16.f327408q = report.ipsrctype;
        c16.f327432f = report.flowId;
        c16.f327427a = report.networkType;
        c16.f327428b = report.retCode;
        c16.f327430d = report.fileSize;
        long j3 = report.startTime;
        c16.f327434h = j3;
        long j16 = report.endTime;
        c16.f327435i = j16;
        c16.f327431e = j16 - j3;
        StringBuilder sb5 = c16.f327433g;
        String str = report.errMsg;
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        c16.f327409r = report.entry;
        c16.f327410s = report.ctrlEnd - report.ctrlStart;
        c16.f327411t = report.dataEnd - report.dataStart;
        c16.f327413v = report.reportType;
        c16.f327414w = report.isIPV6;
        return c16;
    }

    private static b c(b bVar, int i3) {
        switch (i3) {
            case 0:
                b bVar2 = new b();
                bVar2.f327436j = "photo";
                return bVar2;
            case 2:
                b bVar3 = new b();
                bVar3.f327436j = "video";
                return bVar3;
            case 8:
                c cVar = new c();
                cVar.f327436j = appid_upp.value;
                return cVar;
            case 10:
                a aVar = new a();
                aVar.f327436j = appid_qun.value;
                return aVar;
            case 12:
                b bVar4 = new b();
                bVar4.f327436j = appid_ups.value;
                return bVar4;
            case 14:
                b bVar5 = new b();
                bVar5.f327436j = "photowall";
                return bVar5;
            case 16:
                b bVar6 = new b();
                bVar6.f327436j = appid_mobilelog.value;
                return bVar6;
            case 18:
                b bVar7 = new b();
                bVar7.f327436j = "qcircle_photo";
                return bVar7;
            case 20:
                b bVar8 = new b();
                bVar8.f327436j = "qcircle_video";
                return bVar8;
            case 22:
                b bVar9 = new b();
                bVar9.f327436j = "guild_photo";
                return bVar9;
            case 24:
                b bVar10 = new b();
                bVar10.f327436j = "guild_video";
                return bVar10;
            case 26:
                b bVar11 = new b();
                bVar11.f327436j = "qcircle_export_video";
                return bVar11;
            default:
                return bVar;
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void openSessionReport(int i3, String str, String str2, int i16) {
    }
}
