package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.export.model.ExportStartParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.NetworkState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \f2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010!R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010%R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/e;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/j;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "feat", "", "M", "", "fileSize", "K", PhotoCategorySinglePicInfo.UPLOAD_TIME, "exportTime", "", "L", "", HippyTKDListViewAdapter.X, "j", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "missionID", "Lcom/tencent/mobileqq/wink/export/model/ExportStartParam;", "exportStartParam", "onExportStart", "Lcom/tencent/mobileqq/wink/export/model/ExportingParam;", "exportingParam", "onExporting", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errCode", "B", "H", "G", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "exportFeat", "uploadFeat", "I", "J", "predictUploadTime", "predictExportTime", "startTimeMs", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends j {

    /* renamed from: G, reason: from kotlin metadata */
    private final com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b exportFeat;

    /* renamed from: H, reason: from kotlin metadata */
    private final com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b uploadFeat;

    /* renamed from: I, reason: from kotlin metadata */
    private long predictUploadTime;

    /* renamed from: J, reason: from kotlin metadata */
    private long predictExportTime;

    /* renamed from: K, reason: from kotlin metadata */
    private long startTimeMs;

    public e(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b exportFeat, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b uploadFeat) {
        Intrinsics.checkNotNullParameter(exportFeat, "exportFeat");
        Intrinsics.checkNotNullParameter(uploadFeat, "uploadFeat");
        this.exportFeat = exportFeat;
        this.uploadFeat = uploadFeat;
    }

    private final long K(long fileSize) {
        long j3;
        int networkType = NetworkState.getNetworkType();
        if (networkType == 1) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_WIFI", 1536000L);
        } else if (networkType == 2) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_2G", 256000L);
        } else if (networkType == 3) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_3G", 358400L);
        } else if (networkType == 4) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_4G", 512000L);
        } else if (networkType != 5) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_4G", 512000L);
        } else {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_5G", 1126400L);
        }
        return (((float) fileSize) * 1000.0f) / ((float) j3);
    }

    private final int L(long uploadTime, long exportTime) {
        if (uploadTime > 0 && exportTime > 0) {
            if (exportTime > uploadTime) {
                return 1;
            }
            return 0;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void B(ExportErrorCode errCode) {
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        QLog.w(x(), 1, "[onExportError] errCode=" + errCode);
        M(this.exportFeat);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void C() {
        QLog.w(x(), 1, "[onExportSuccess]");
        M(this.uploadFeat);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public int j() {
        return 0;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void n() {
        if (getIsReceivedProgress()) {
            F(false);
            return;
        }
        QLog.i(x(), 1, "[onTimeoutCheck] timeout");
        y().M(2);
        B(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_TIMEOUT_BY_TASK, null, 2, null));
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, x73.a
    public void onExportStart(String missionID, ExportStartParam exportStartParam) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportStartParam, "exportStartParam");
        super.onExportStart(missionID, exportStartParam);
        if (2 == exportStartParam.getExportType() || 3 == exportStartParam.getExportType()) {
            y().H(false);
            M(this.exportFeat);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public String x() {
        return "WinkPublish-upload2-SpeedTestFeat";
    }

    private final void M(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b feat) {
        com.tencent.mobileqq.winkpublish.outbox.d.d(y(), "E_VIDEO_EXPORT_JUGE", y().r(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : v(), (r33 & 16) != 0 ? "" : "hasresult", (r33 & 32) != 0 ? "" : String.valueOf(y().getJudgeResult()), (r33 & 64) != 0 ? "" : String.valueOf(this.predictUploadTime), (r33 & 128) != 0 ? "" : String.valueOf(this.predictExportTime), (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        c(feat);
        p();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void m(TaskContext taskContext) {
        Object first;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        QLog.i("WinkPublish-upload2-SpeedTestFeat", 1, "[onRun] judgeResult:" + taskContext.getJudgeResult());
        G(taskContext);
        int judgeResult = taskContext.getJudgeResult();
        if (judgeResult == 0) {
            M(this.exportFeat);
            return;
        }
        if (judgeResult != 1) {
            super.m(taskContext);
            VideoParams r16 = u().r();
            if (r16 == null) {
                QLog.i("WinkPublish-upload2-SpeedTestFeat", 1, "[onRun] invalid videoParams");
                return;
            }
            List<VideoParams> originVideoParams = r16.getOriginVideoParams();
            boolean z16 = false;
            if (!(originVideoParams == null || originVideoParams.isEmpty())) {
                List<VideoParams> originVideoParams2 = r16.getOriginVideoParams();
                Intrinsics.checkNotNull(originVideoParams2);
                if (originVideoParams2.size() <= 1) {
                    List<VideoParams> originVideoParams3 = r16.getOriginVideoParams();
                    Intrinsics.checkNotNull(originVideoParams3);
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) originVideoParams3);
                    VideoParams videoParams = (VideoParams) first;
                    isBlank = StringsKt__StringsJVMKt.isBlank(videoParams.getLocalPath());
                    if (!isBlank) {
                        int winkPublishMaxUploadFileSize = QzoneConfig.getWinkPublishMaxUploadFileSize();
                        long fileSize = videoParams.getFileSize();
                        if (1 <= fileSize && fileSize <= winkPublishMaxUploadFileSize) {
                            z16 = true;
                        }
                        if (z16) {
                            this.startTimeMs = System.currentTimeMillis();
                            this.predictUploadTime = K(videoParams.getFileSize());
                            com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "E_VIDEO_EXPORT_JUGE", taskContext.r(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : v(), (r33 & 16) != 0 ? "" : BaseConstants.BROADCAST_USERSYNC_ENTER, (r33 & 32) != 0 ? "" : String.valueOf(videoParams.getFileSize()), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
                            return;
                        }
                    }
                    QLog.i("WinkPublish-upload2-SpeedTestFeat", 1, "[onRun] invalid origin video, path=" + videoParams.getLocalPath() + ", fileSize=" + videoParams.getFileSize());
                    M(this.exportFeat);
                    return;
                }
            }
            List<VideoParams> originVideoParams4 = r16.getOriginVideoParams();
            QLog.i("WinkPublish-upload2-SpeedTestFeat", 1, "[onRun] invalid origin video list, list size=" + (originVideoParams4 != null ? Integer.valueOf(originVideoParams4.size()) : null));
            M(this.exportFeat);
            return;
        }
        M(this.uploadFeat);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, x73.a
    public void onExporting(String missionID, ExportingParam exportingParam) {
        Object first;
        VideoParams copy;
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportingParam, "exportingParam");
        super.onExporting(missionID, exportingParam);
        if (!Intrinsics.areEqual(v(), missionID)) {
            QLog.i(x(), 1, "[onAETavSessionExporting] not the same id, " + v() + ", " + missionID);
            return;
        }
        if (!i()) {
            QLog.w(x(), 1, "[onAETavSessionExporting] continuation is not active");
            return;
        }
        this.predictExportTime = exportingParam.f322845i;
        if (System.currentTimeMillis() - this.startTimeMs > 5000) {
            QLog.i("WinkPublish-upload2-SpeedTestFeat", 1, "[onAETavSessionExporting] no judge result timeout");
            y().M(2);
            M(this.exportFeat);
            return;
        }
        y().M(L(this.predictUploadTime, this.predictExportTime));
        QLog.i("WinkPublish-upload2-SpeedTestFeat", 1, "[onAETavSessionExporting] judgeResult=" + y().getJudgeResult() + ", progress=" + exportingParam.f322842e + ", predictExportTime=" + this.predictExportTime + ", predictUploadTime=" + this.predictUploadTime);
        int judgeResult = y().getJudgeResult();
        if (judgeResult == 0) {
            M(this.exportFeat);
            return;
        }
        if (judgeResult != 1) {
            return;
        }
        IWinkMultiExportAPI iWinkMultiExportAPI = (IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class);
        WinkExportTask winkExportTask = getWinkExportTask();
        iWinkMultiExportAPI.cancelTask(winkExportTask != null ? winkExportTask.f322847d : null);
        UploadMediaInfo u16 = u();
        VideoParams r16 = u().r();
        Intrinsics.checkNotNull(r16);
        List<VideoParams> originVideoParams = r16.getOriginVideoParams();
        Intrinsics.checkNotNull(originVideoParams);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) originVideoParams);
        copy = r3.copy((r37 & 1) != 0 ? r3.localPath : null, (r37 & 2) != 0 ? r3.width : 0, (r37 & 4) != 0 ? r3.height : 0, (r37 & 8) != 0 ? r3.fileSize : 0L, (r37 & 16) != 0 ? r3.bitrate : 0L, (r37 & 32) != 0 ? r3.coverPath : u().a(), (r37 & 64) != 0 ? r3.coverWidth : 0, (r37 & 128) != 0 ? r3.coverHeight : 0, (r37 & 256) != 0 ? r3.duration : 0L, (r37 & 512) != 0 ? r3.rotation : 0, (r37 & 1024) != 0 ? r3.mimetype : null, (r37 & 2048) != 0 ? r3.isHEVC : false, (r37 & 4096) != 0 ? r3.isHDR : false, (r37 & 8192) != 0 ? r3.originVideoParams : null, (r37 & 16384) != 0 ? r3.md5 : null, (r37 & 32768) != 0 ? ((VideoParams) first).materialParamsList : null);
        u16.C(copy);
        M(this.uploadFeat);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void H() {
    }
}
