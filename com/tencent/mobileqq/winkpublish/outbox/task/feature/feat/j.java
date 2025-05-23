package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.export.model.ExportCompletedParam;
import com.tencent.mobileqq.wink.export.model.ExportErrorParam;
import com.tencent.mobileqq.wink.export.model.ExportStartParam;
import com.tencent.mobileqq.wink.export.model.ExportWaitingParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkpublish.model.params.ExportParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.ExportException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001MB\u0007\u00a2\u0006\u0004\bK\u0010LJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0018\u0010)\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010(\u001a\u00020'H\u0016J\u001c\u0010,\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\tH\u0016J\b\u0010.\u001a\u00020\tH\u0016R\"\u0010\u0013\u001a\u00020\u00128\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u0004\u001a\u00020\u00038\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u000b\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010>\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b&\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010E\u001a\u0004\u0018\u00010?8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010\u001c\u001a\u00020\f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/j;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/CancellableFeature;", "Lx73/a;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "mediaInfo", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "isExported", "", "I", BdhLogUtil.LogTag.Tag_Conn, "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errCode", "B", "k", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "", ReportConstant.COSTREPORT_PREFIX, "t", DomainData.DOMAIN_NAME, "l", "missionID", "Lcom/tencent/mobileqq/wink/export/model/ExportStartParam;", "exportStartParam", "onExportStart", "Lcom/tencent/mobileqq/wink/export/model/ExportingParam;", "exportingParam", "onExporting", "Lcom/tencent/mobileqq/wink/export/model/ExportCompletedParam;", "exportCompletedParam", "onCompleted", "D", "Lcom/tencent/mobileqq/wink/export/model/ExportErrorParam;", "exportErrorParam", "onExportError", "Lcom/tencent/mobileqq/wink/export/model/ExportWaitingParam;", "exportWaitingParam", "onExportWaiting", "J", "H", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "y", "()Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "G", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;)V", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "u", "()Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "E", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/a;)V", "Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", UserInfo.SEX_FEMALE, "(Z)V", "isReceivedProgress", "Lcom/tencent/mobileqq/wink/export/model/WinkExportTask;", "Lcom/tencent/mobileqq/wink/export/model/WinkExportTask;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/mobileqq/wink/export/model/WinkExportTask;", "setWinkExportTask", "(Lcom/tencent/mobileqq/wink/export/model/WinkExportTask;)V", "winkExportTask", "w", "()I", "resolutionLevel", "v", "()Ljava/lang/String;", "<init>", "()V", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class j extends CancellableFeature implements x73.a {

    /* renamed from: C, reason: from kotlin metadata */
    protected UploadMediaInfo mediaInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean isReceivedProgress;

    /* renamed from: E, reason: from kotlin metadata */
    private WinkExportTask winkExportTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected TaskContext taskContext;

    private final int w() {
        ExportParams exportParams = y().getPublishParams().getExportParams();
        if (exportParams != null) {
            return exportParams.getResolutionLevel();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A, reason: from getter */
    public final boolean getIsReceivedProgress() {
        return this.isReceivedProgress;
    }

    public void B(ExportErrorCode errCode) {
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        QLog.w(x(), 1, "[onExportError] errCode=" + errCode);
        this.winkExportTask = null;
        o(new ExportException(errCode));
    }

    public void C() {
        QLog.w(x(), 1, "[onExportSuccess]");
        this.winkExportTask = null;
        p();
    }

    protected final void E(UploadMediaInfo uploadMediaInfo) {
        Intrinsics.checkNotNullParameter(uploadMediaInfo, "<set-?>");
        this.mediaInfo = uploadMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(boolean z16) {
        this.isReceivedProgress = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G(TaskContext taskContext) {
        Intrinsics.checkNotNullParameter(taskContext, "<set-?>");
        this.taskContext = taskContext;
    }

    public void H() {
        com.tencent.mobileqq.winkpublish.outbox.d.c(y(), "key_wait_export_video_to_upload_cost");
    }

    public void J() {
        QLog.i(x(), 1, "[waitForExport] missionID=" + v() + ", resolutionLevel=" + w());
        H();
        WinkExportParams winkExportParams = new WinkExportParams("QCIRCLE", v(), y().r());
        winkExportParams.q(w());
        this.winkExportTask = new WinkExportTask(v(), "QCIRCLE", winkExportParams, false, 0);
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).addTask(this.winkExportTask, this);
        com.tencent.mobileqq.winkpublish.outbox.d.c(y(), v());
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(j.class))) {
            ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatStart(ITaskSnapshotApi.FEAT_WAIT_VIDEO_EXPORT);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public int j() {
        return 0;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public boolean k() {
        return true;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void m(TaskContext taskContext) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        String x16 = x();
        ExportParams exportParams = taskContext.getPublishParams().getExportParams();
        QLog.i(x16, 1, "[onRun] missionId=" + (exportParams != null ? exportParams.getMissionId() : null));
        G(taskContext);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) taskContext.x());
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) firstOrNull;
        if ((uploadMediaInfo != null ? uploadMediaInfo.r() : null) != null && taskContext.getPublishParams().getExportParams() != null) {
            E(uploadMediaInfo);
            if (v().length() == 0) {
                o(new ExportException(new ExportErrorCode(ExportErrorCode.ERROR_CODE_NO_MISSION_ID, null, 2, null)));
                return;
            } else {
                J();
                return;
            }
        }
        QLog.e("WinkPublish-upload2-WaitVideoExportFeat", 1, "[onRun] no params, " + (uploadMediaInfo != null ? uploadMediaInfo.r() : null));
        o(new ExportException(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_NO_PARAMS, null, 2, null)));
    }

    public void onExportStart(String missionID, ExportStartParam exportStartParam) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportStartParam, "exportStartParam");
        QLog.i(x(), 1, "[onExportStart] missionID=" + missionID + ", type=" + exportStartParam.getExportType());
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onUpdateExportType(exportStartParam.getExportType());
    }

    @Override // x73.a
    public void onExportWaiting(String missionID, ExportWaitingParam exportWaitingParam) {
        if (!Intrinsics.areEqual(v(), missionID)) {
            QLog.i(x(), 1, "[onExportWaiting] not the same id, " + v() + ", " + missionID);
            return;
        }
        if (!i()) {
            QLog.w(x(), 1, "[onExportWaiting] continuation is not active");
        } else {
            QLog.d(x(), 2, "[onExportWaiting] ");
            this.isReceivedProgress = true;
        }
    }

    public void onExporting(String missionID, ExportingParam exportingParam) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportingParam, "exportingParam");
        if (!Intrinsics.areEqual(v(), missionID)) {
            QLog.i(x(), 1, "[onExporting] not the same id, " + v() + ", " + missionID);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(x(), 2, "[onExporting] progress=" + exportingParam.f322842e + ", predictTime=" + exportingParam.f322845i + ", filePath=" + exportingParam.f322846m);
        }
        this.isReceivedProgress = true;
        u().y(exportingParam.f322842e);
        if (y().B() && i()) {
            com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(y().b()).c(y().R());
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public long s() {
        return 42000L;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public long t() {
        return 3000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UploadMediaInfo u() {
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        if (uploadMediaInfo != null) {
            return uploadMediaInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String v() {
        String missionId;
        ExportParams exportParams = y().getPublishParams().getExportParams();
        return (exportParams == null || (missionId = exportParams.getMissionId()) == null) ? "" : missionId;
    }

    public String x() {
        return "WinkPublish-upload2-WaitVideoExportFeat";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TaskContext y() {
        TaskContext taskContext = this.taskContext;
        if (taskContext != null) {
            return taskContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("taskContext");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z, reason: from getter */
    public final WinkExportTask getWinkExportTask() {
        return this.winkExportTask;
    }

    public j() {
        super(null, 1, null);
    }

    public void D(String missionID) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        TaskContext y16 = y();
        com.tencent.mobileqq.winkpublish.outbox.d.a(y16, "P_VIDEO_EXPORT_COST", y16.r(), "0", (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "0", (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(getRetryTimes()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : missionID, (r33 & 8192) != 0 ? "" : null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void l(TaskContext taskContext) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        String c16 = taskContext.c();
        ExportParams exportParams = taskContext.getPublishParams().getExportParams();
        if (exportParams == null || (str = exportParams.getMissionId()) == null) {
            str = "";
        }
        String str4 = str;
        QLog.i(x(), 1, "[onCancel] suspend cancelled, batchId=" + taskContext.getBatchId() + ", fakeKey=" + c16 + ", missionId=" + str4 + " ");
        this.isReceivedProgress = true;
        IWinkMultiExportAPI iWinkMultiExportAPI = (IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class);
        WinkExportTask winkExportTask = this.winkExportTask;
        iWinkMultiExportAPI.cancelTask(winkExportTask != null ? winkExportTask.f322847d : null);
        ExportErrorCode exportErrorCode = new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_CANCEL, null, 2, null);
        String r16 = taskContext.r();
        String valueOf = String.valueOf(exportErrorCode.transformedCode());
        if (taskContext.B()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        com.tencent.mobileqq.winkpublish.outbox.d.a(taskContext, "P_VIDEO_EXPORT_COST", r16, valueOf, (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : str2, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(getRetryTimes()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : str4, (r33 & 8192) != 0 ? "" : null);
        String r17 = taskContext.r();
        String valueOf2 = String.valueOf(exportErrorCode.transformedCode());
        String message = exportErrorCode.getMessage();
        if (taskContext.B()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "E_VIDEO_EXPORT_RESULT", r17, (r33 & 4) != 0 ? "" : valueOf2, (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : str3, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(getRetryTimes()), (r33 & 512) != 0 ? "" : message, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void n() {
        String str;
        String str2;
        QLog.i(x(), 1, "[onTimeoutCheck] isReceivedProgress=" + this.isReceivedProgress + ", retryTimes=" + getRetryTimes());
        if (this.isReceivedProgress) {
            this.isReceivedProgress = false;
            return;
        }
        ExportErrorCode exportErrorCode = new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_TIMEOUT_BY_TASK, null, 2, null);
        TaskContext y16 = y();
        String r16 = y16.r();
        String valueOf = String.valueOf(exportErrorCode.transformedCode());
        String v3 = v();
        if (y16.B()) {
            str = "1";
        } else {
            str = "0";
        }
        com.tencent.mobileqq.winkpublish.outbox.d.a(y16, "P_VIDEO_EXPORT_COST", r16, valueOf, (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : str, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(getRetryTimes()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : v3, (r33 & 8192) != 0 ? "" : null);
        String r17 = y16.r();
        String valueOf2 = String.valueOf(exportErrorCode.transformedCode());
        String message = exportErrorCode.getMessage();
        if (y16.B()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "E_VIDEO_EXPORT_RESULT", r17, (r33 & 4) != 0 ? "" : valueOf2, (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : str2, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(getRetryTimes()), (r33 & 512) != 0 ? "" : message, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        throw new ExportException(exportErrorCode);
    }

    private final void I(UploadMediaInfo mediaInfo, LocalMediaInfo localMediaInfo, boolean isExported) {
        VideoParams copy;
        String str = localMediaInfo.path;
        if (str == null || str.length() == 0) {
            B(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FAIL, null, 2, null));
            return;
        }
        mediaInfo.y(100.0f);
        mediaInfo.H(isExported);
        VideoParams r16 = mediaInfo.r();
        if (r16 != null) {
            String path = localMediaInfo.path;
            int i3 = localMediaInfo.mediaWidth;
            int i16 = localMediaInfo.mediaHeight;
            long j3 = localMediaInfo.fileSize;
            long j16 = localMediaInfo.mediaBitrate;
            long j17 = localMediaInfo.mDuration;
            int i17 = localMediaInfo.rotation;
            boolean z16 = localMediaInfo.isHDRVideo;
            boolean areEqual = Intrinsics.areEqual(localMediaInfo.videoMimeType, "video/hevc");
            String mMimeType = localMediaInfo.mMimeType;
            Intrinsics.checkNotNullExpressionValue(path, "path");
            Intrinsics.checkNotNullExpressionValue(mMimeType, "mMimeType");
            copy = r16.copy((r37 & 1) != 0 ? r16.localPath : path, (r37 & 2) != 0 ? r16.width : i3, (r37 & 4) != 0 ? r16.height : i16, (r37 & 8) != 0 ? r16.fileSize : j3, (r37 & 16) != 0 ? r16.bitrate : j16, (r37 & 32) != 0 ? r16.coverPath : null, (r37 & 64) != 0 ? r16.coverWidth : 0, (r37 & 128) != 0 ? r16.coverHeight : 0, (r37 & 256) != 0 ? r16.duration : j17, (r37 & 512) != 0 ? r16.rotation : i17, (r37 & 1024) != 0 ? r16.mimetype : mMimeType, (r37 & 2048) != 0 ? r16.isHEVC : areEqual, (r37 & 4096) != 0 ? r16.isHDR : z16, (r37 & 8192) != 0 ? r16.originVideoParams : null, (r37 & 16384) != 0 ? r16.md5 : null, (r37 & 32768) != 0 ? r16.materialParamsList : null);
            mediaInfo.C(copy);
        }
    }

    public void onCompleted(String missionID, ExportCompletedParam exportCompletedParam) {
        String str;
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportCompletedParam, "exportCompletedParam");
        QLog.i(x(), 1, "[onCompleted] missionID=" + missionID + ", isExported=" + exportCompletedParam.f322836f + ", localMediaInfo=" + exportCompletedParam.f322835e);
        if (!Intrinsics.areEqual(v(), missionID)) {
            QLog.i(x(), 1, "[onCompleted] not the same id, " + v() + ", " + missionID);
            return;
        }
        this.isReceivedProgress = true;
        if (!i()) {
            QLog.w(x(), 1, "[onCompleted] continuation is not active");
            return;
        }
        if (!exportCompletedParam.f322836f) {
            TaskContext y16 = y();
            String r16 = y16.r();
            if (y16.B()) {
                str = "1";
            } else {
                str = "0";
            }
            com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "T_VIDEO_NO_NEED_EXPORT", r16, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : str, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        } else {
            D(missionID);
        }
        UploadMediaInfo u16 = u();
        LocalMediaInfo localMediaInfo = exportCompletedParam.f322835e;
        Intrinsics.checkNotNullExpressionValue(localMediaInfo, "exportCompletedParam.localMediaInfo");
        I(u16, localMediaInfo, exportCompletedParam.f322836f);
        if (QLog.isColorLevel()) {
            QLog.d(x(), 2, "[onCompleted] updated mediaInfo");
        }
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(j.class))) {
            ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatEnd(ITaskSnapshotApi.FEAT_WAIT_VIDEO_EXPORT);
        }
        C();
    }

    @Override // x73.a
    public void onExportError(String missionID, ExportErrorParam exportErrorParam) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportErrorParam, "exportErrorParam");
        if (!Intrinsics.areEqual(v(), missionID)) {
            QLog.i(x(), 1, "[onExportError] not the same id, " + v() + ", " + missionID + ", errorCode=" + exportErrorParam.f322838e.transformedCode());
            return;
        }
        if (!i()) {
            QLog.w(x(), 1, "[onExportError] continuation is not active");
            return;
        }
        this.isReceivedProgress = true;
        ExportErrorCode winkErrorCode = exportErrorParam.f322838e;
        TaskContext y16 = y();
        com.tencent.mobileqq.winkpublish.outbox.d.a(y16, "P_VIDEO_EXPORT_COST", y16.r(), String.valueOf(winkErrorCode.transformedCode()), (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : null, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(getRetryTimes()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : missionID, (r33 & 8192) != 0 ? "" : null);
        Intrinsics.checkNotNullExpressionValue(winkErrorCode, "winkErrorCode");
        B(winkErrorCode);
    }
}
