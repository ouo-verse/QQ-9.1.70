package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.export.model.ExportCompletedParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.mobileqq.winkpublish.fs.task.QCircleVideoExportingUploadTask;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.NetworkException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.UWEIllegalStateException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.UploadException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.UploadFileSizeUnMatchException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadResult;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskExtendCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.VideoExportingUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.utils.Const;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001FB\u0007\u00a2\u0006\u0004\bB\u0010CB\u0017\b\u0016\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020+0?\u00a2\u0006\u0004\bB\u0010EJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010'\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(H\u0016J\"\u0010-\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020+H\u0016J\u001a\u00100\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\bH\u0016R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00105R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/i;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/j;", "Lcom/tencent/upload/uinterface/IUploadTaskExtendCallback;", "", "filePath", "", "newProgress", "progress", "", "K", "O", "", "reCreate", "L", "Lcom/tencent/upload/uinterface/AbstractUploadTask;", "task", "", "N", "Lcom/tencent/mobileqq/winkpublish/report/UploadErrorCode;", "errorCode", "M", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "missionID", "Lcom/tencent/mobileqq/wink/export/model/ExportingParam;", "exportingParam", "onExporting", "Lcom/tencent/mobileqq/wink/export/model/ExportCompletedParam;", "exportCompletedParam", "onCompleted", "D", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errCode", "B", "l", "totalSize", "recvSize", "onUploadProgress", "", "result", "onUploadSucceed", "", "errMsg", "onUploadError", "state", "onUploadStateChange", "onBatchControlRsp", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "H", "G", "Z", "hasRunExportingUpload", UserInfo.SEX_FEMALE, "curProgress", "Lcom/tencent/mobileqq/winkpublish/fs/task/QCircleVideoExportingUploadTask;", "I", "Lcom/tencent/mobileqq/winkpublish/fs/task/QCircleVideoExportingUploadTask;", "videoUploadTask", "J", "isExportCompleted", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "<init>", "()V", "coverChannel", "(Lkotlinx/coroutines/channels/Channel;)V", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class i extends j implements IUploadTaskExtendCallback {

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasRunExportingUpload;

    /* renamed from: H, reason: from kotlin metadata */
    private float curProgress;

    /* renamed from: I, reason: from kotlin metadata */
    private QCircleVideoExportingUploadTask videoUploadTask;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile boolean isExportCompleted;

    /* renamed from: K, reason: from kotlin metadata */
    private Channel<Integer> channel;

    public i() {
    }

    private final void K(String filePath, float newProgress, float progress) {
        if (this.curProgress >= progress || newProgress <= progress) {
            return;
        }
        float length = ((float) new File(filePath).length()) / newProgress;
        QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask = this.videoUploadTask;
        if (qCircleVideoExportingUploadTask != null) {
            qCircleVideoExportingUploadTask.mDataLength = length;
        }
        UploadMediaInfo u16 = u();
        if (u16 != null) {
            u16.z(length);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[checkSize] update fake size:");
        sb5.append(length);
        QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 1, sb5.toString());
    }

    private final void M(UploadErrorCode errorCode) {
        com.tencent.mobileqq.winkpublish.outbox.d.d(y(), "E_UPLOAD_RESULT", y().r(), (r33 & 4) != 0 ? "" : String.valueOf(errorCode.transformedCode()), (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : String.valueOf(u().getIndexInMediaList()), (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : "1", (r33 & 512) != 0 ? "" : errorCode.getMessage(), (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        O();
        o(new UploadException(errorCode));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        if ((r0.length == 0) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long N(AbstractUploadTask task) {
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 1, "uploadEntrance = " + (task != null ? Integer.valueOf(task.uploadEntrance) : null) + ", uiRefer = " + (task != null ? task.uiRefer : null));
        }
        if ((task != null ? task.vLoginData : null) != null) {
            byte[] bArr = task.vLoginData;
            Intrinsics.checkNotNullExpressionValue(bArr, "task.vLoginData");
        }
        byte[] b16 = ua3.a.d().b(true);
        if (b16 != null) {
            if (!(b16.length == 0)) {
                QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "a2key get again...");
                if (task != null) {
                    task.vLoginData = b16;
                }
                String str = task != null ? task.uploadFilePath : null;
                if (str == null || str.length() == 0) {
                    QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "no file path");
                    return UploadErrorCode.ERROR_CODE_FILE_NOT_EXIST;
                }
                File file = new File(task != null ? task.uploadFilePath : null);
                if (file.exists() && file.length() != 0 && !file.isDirectory()) {
                    return 0L;
                }
                QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "invalid file status, exists=" + file.exists() + ", path=" + file.getAbsolutePath() + ", length=" + file.length());
                return UploadErrorCode.ERROR_CODE_FILE_NOT_EXIST;
            }
        }
        QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "no login, stop upload");
        return UploadErrorCode.ERROR_CODE_NO_LOGIN_DATA;
    }

    private final void O() {
        QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask = this.videoUploadTask;
        QLog.i("WinkPublish-upload2-VideoExportUploadFeat", 1, "[resetUploadTask] task=" + (qCircleVideoExportingUploadTask != null ? Integer.valueOf(qCircleVideoExportingUploadTask.hashCode()) : null));
        QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask2 = this.videoUploadTask;
        if (qCircleVideoExportingUploadTask2 != null) {
            qCircleVideoExportingUploadTask2.cancel();
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void B(ExportErrorCode errCode) {
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        super.B(errCode);
        O();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void C() {
        if (this.videoUploadTask == null) {
            y().H(false);
            o(new UWEIllegalStateException(new UploadErrorCode(UploadErrorCode.ERROR_CODE_UWE_NO_TASK, null, 2, null)));
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void H() {
        com.tencent.mobileqq.winkpublish.outbox.d.c(y(), "key_wait_export_video_upload_finish_cost");
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void l(TaskContext taskContext) {
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        super.l(taskContext);
        O();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void m(TaskContext taskContext) {
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        super.m(taskContext);
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatStart(ITaskSnapshotApi.FEAT_VIDEO_EXPORT_UPLOAD);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void n() {
        if (this.isExportCompleted) {
            QLog.i("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onTimeoutCheck] video is ready");
            F(true);
        } else {
            super.n();
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskExtendCallback
    public void onBatchControlRsp(AbstractUploadTask task, Object result) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.VideoUploadResult");
        QLog.i("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onBatchControlRsp] file=" + task.uploadFilePath + ", vid=" + ((VideoUploadResult) result).sVid + ", md5=" + task.md5 + ", task id=" + y().getId());
        if (!i()) {
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onBatchControlRsp] continuation is not active");
            return;
        }
        UploadMediaInfo u16 = u();
        if (u16.getUploadResponse() == null) {
            u16.F((AbstractUploadResult) result);
        } else {
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onBatchControlRsp] response is not the same");
        }
        Channel<Integer> channel = this.channel;
        if (channel == null || channel.isClosedForSend()) {
            return;
        }
        channel.mo2003trySendJP2dKIU(2);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, x73.a
    public void onCompleted(String missionID, ExportCompletedParam exportCompletedParam) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportCompletedParam, "exportCompletedParam");
        super.onCompleted(missionID, exportCompletedParam);
        if (!i()) {
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onCompleted] continuation is not active");
            return;
        }
        if (!exportCompletedParam.f322836f) {
            QLog.i("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onCompleted] illegal export state");
            O();
            y().H(false);
            o(new UWEIllegalStateException(new UploadErrorCode(UploadErrorCode.ERROR_CODE_UWE_MEET_ORIGINAL_EXPORT, null, 2, null)));
            return;
        }
        this.isExportCompleted = true;
        LocalMediaInfo localMediaInfo = exportCompletedParam.f322835e;
        HashMap<String, String> hashMap = new HashMap<>();
        if (Intrinsics.areEqual("video/hevc", localMediaInfo.videoMimeType)) {
            hashMap.put(FSUploadConst.KEY_VIDEO_FORMAT, UploadVideoObject.VODEO_FORMAT_H265);
        } else {
            hashMap.put(FSUploadConst.KEY_VIDEO_FORMAT, "h264");
        }
        if (localMediaInfo.isHDRVideo) {
            hashMap.put(FSUploadConst.KEY_VIDEO_IS_HDR, "1");
        } else {
            hashMap.put(FSUploadConst.KEY_VIDEO_IS_HDR, "0");
        }
        QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask = this.videoUploadTask;
        if (qCircleVideoExportingUploadTask != null) {
            qCircleVideoExportingUploadTask.wakeFinishFile(hashMap);
        }
        com.tencent.mobileqq.winkpublish.outbox.d.c(y(), "key_complete_export_video_upload_cost");
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadProgress(AbstractUploadTask task, long totalSize, long recvSize) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 2, "[onUploadProgress] " + (((float) recvSize) / ((float) totalSize)));
        }
        u().E(totalSize);
        u().D(recvSize);
        F(true);
        if (y().B()) {
            com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(y().b()).c(y().R());
            ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onUpdateUploadInfo(recvSize, totalSize);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadStateChange(AbstractUploadTask task, int state) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onUploadStateChange] file=" + task.uploadFilePath + ", state=" + state);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public String x() {
        return "WinkPublish-upload2-VideoExportUploadFeat";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Channel<Integer> coverChannel) {
        this();
        Intrinsics.checkNotNullParameter(coverChannel, "coverChannel");
        this.channel = coverChannel;
    }

    private final void L(boolean reCreate) {
        String str;
        com.tencent.mobileqq.winkpublish.outbox.d.d(y(), "E_UPLOAD_START", y().r(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : String.valueOf(u().getIndexInMediaList()), (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : "1", (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        wa3.j a16 = wa3.j.INSTANCE.a(y().d());
        TaskContext y16 = y();
        VideoParams r16 = u().r();
        Intrinsics.checkNotNull(r16);
        VideoExportingUploadTask c16 = a16.c(y16, r16, u().getIndexInMediaList(), this);
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.fs.task.QCircleVideoExportingUploadTask");
        QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask = (QCircleVideoExportingUploadTask) c16;
        this.videoUploadTask = qCircleVideoExportingUploadTask;
        if (qCircleVideoExportingUploadTask != null) {
            qCircleVideoExportingUploadTask.mDataLength = u().getFakeTotalSize();
        }
        QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask2 = this.videoUploadTask;
        QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 2, "[createExportingTask] mDataLength=" + (qCircleVideoExportingUploadTask2 != null ? Long.valueOf(qCircleVideoExportingUploadTask2.mDataLength) : null));
        u().G(this.videoUploadTask);
        y().Q(1);
        long N = N(this.videoUploadTask);
        if (N == 0) {
            boolean upload = UploadServiceBuilder.getInstance().upload(this.videoUploadTask);
            if (QLog.isColorLevel()) {
                QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 2, "[upload] result=" + upload);
            }
        } else {
            o(new UploadException(new UploadErrorCode(N, null, 2, null)));
        }
        TaskContext y17 = y();
        if (reCreate) {
            str = "E_VIDEO_EXPORT_UPLOAD_RECREATE_START";
        } else {
            str = "E_VIDEO_EXPORT_UPLOAD_START";
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(y17, str, y().r(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : String.valueOf(u().getFakeTotalSize()), (r33 & 16) != 0 ? "" : null, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void D(String missionID) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        TaskContext y16 = y();
        com.tencent.mobileqq.winkpublish.outbox.d.a(y16, "P_VIDEO_EXPORT_COST", y16.r(), "0", (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "1", (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(getRetryTimes()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : missionID, (r33 & 8192) != 0 ? "" : null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, x73.a
    public void onExporting(String missionID, ExportingParam exportingParam) {
        boolean z16;
        String str;
        VideoParams copy;
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportingParam, "exportingParam");
        super.onExporting(missionID, exportingParam);
        if (!i()) {
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onAETavSessionExporting] continuation is not active");
            return;
        }
        float f16 = exportingParam.f322842e;
        if (f16 < 0.1f) {
            return;
        }
        VideoParams r16 = u().r();
        if (r16 == null || Intrinsics.areEqual(r16.getLocalPath(), exportingParam.f322846m)) {
            z16 = true;
            str = "exportingParam.filePath";
        } else {
            UploadMediaInfo u16 = u();
            String str2 = exportingParam.f322846m;
            Intrinsics.checkNotNullExpressionValue(str2, "exportingParam.filePath");
            str = "exportingParam.filePath";
            copy = r16.copy((r37 & 1) != 0 ? r16.localPath : str2, (r37 & 2) != 0 ? r16.width : 0, (r37 & 4) != 0 ? r16.height : 0, (r37 & 8) != 0 ? r16.fileSize : 0L, (r37 & 16) != 0 ? r16.bitrate : 0L, (r37 & 32) != 0 ? r16.coverPath : null, (r37 & 64) != 0 ? r16.coverWidth : 0, (r37 & 128) != 0 ? r16.coverHeight : 0, (r37 & 256) != 0 ? r16.duration : 0L, (r37 & 512) != 0 ? r16.rotation : 0, (r37 & 1024) != 0 ? r16.mimetype : null, (r37 & 2048) != 0 ? r16.isHEVC : false, (r37 & 4096) != 0 ? r16.isHDR : false, (r37 & 8192) != 0 ? r16.originVideoParams : null, (r37 & 16384) != 0 ? r16.md5 : null, (r37 & 32768) != 0 ? r16.materialParamsList : null);
            u16.C(copy);
            z16 = true;
            QLog.i("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onExporting] change path, oldPath=" + r16.getLocalPath() + ", newPath=" + exportingParam.f322846m);
        }
        if (!this.hasRunExportingUpload) {
            this.hasRunExportingUpload = z16;
            this.curProgress = f16;
            L(false);
            return;
        }
        float f17 = this.curProgress;
        if (f16 >= f17) {
            String str3 = exportingParam.f322846m;
            String str4 = str;
            Intrinsics.checkNotNullExpressionValue(str3, str4);
            K(str3, f16, 0.5f);
            String str5 = exportingParam.f322846m;
            Intrinsics.checkNotNullExpressionValue(str5, str4);
            K(str5, f16, 0.9f);
            QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask = this.videoUploadTask;
            if (qCircleVideoExportingUploadTask != null) {
                qCircleVideoExportingUploadTask.wakeReadFile();
            }
        } else {
            QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onExporting] cancel videoUploadTask progress:" + f16 + " curProgress:" + f17);
            QCircleVideoExportingUploadTask qCircleVideoExportingUploadTask2 = this.videoUploadTask;
            if (qCircleVideoExportingUploadTask2 != null) {
                qCircleVideoExportingUploadTask2.cancel();
            }
            L(true);
        }
        this.curProgress = f16;
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadSucceed(AbstractUploadTask task, Object result) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        VideoUploadResult videoUploadResult = (VideoUploadResult) result;
        QLog.d("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onUploadSucceed] file=" + task.uploadFilePath + ", vid=" + videoUploadResult.sVid + ", md5=" + task.md5);
        if (!i()) {
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onUploadSucceed] continuation is not active");
            return;
        }
        UploadMediaInfo u16 = u();
        if (u16.getUploadResponse() != null) {
            AbstractUploadResult uploadResponse = u16.getUploadResponse();
            Intrinsics.checkNotNull(uploadResponse, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.VideoUploadResult");
            VideoUploadResult videoUploadResult2 = (VideoUploadResult) uploadResponse;
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onUploadSucceed] videoRspCover.sVid:" + videoUploadResult.sVid + " batchRspCover.sVid:" + videoUploadResult2.sVid);
            if (!Intrinsics.areEqual(videoUploadResult.sVid, videoUploadResult2.sVid)) {
                u().w(null);
            }
        }
        u16.F(videoUploadResult);
        u16.D(u16.getTotalSize());
        String str = task.md5;
        Intrinsics.checkNotNullExpressionValue(str, "task.md5");
        u16.B(str);
        TaskContext y16 = y();
        String r16 = y16.r();
        String valueOf = String.valueOf(u().getIndexInMediaList());
        String str2 = videoUploadResult.sVid;
        Intrinsics.checkNotNullExpressionValue(str2, "videoUploadResult.sVid");
        com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "E_UPLOAD_RESULT", r16, (r33 & 4) != 0 ? "" : "0", (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : valueOf, (r33 & 32) != 0 ? "" : str2, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : "1", (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        com.tencent.mobileqq.winkpublish.outbox.d.a(y16, WinkPublishServiceReporter.P_PUBLISH_ALL_COST, y16.r(), "0", (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "key_complete_export_video_upload_cost", (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : "key_complete_export_video_upload_cost", (r33 & 8192) != 0 ? "" : null);
        com.tencent.mobileqq.winkpublish.outbox.d.a(y16, WinkPublishServiceReporter.P_PUBLISH_ALL_COST, y16.r(), "0", (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "key_wait_export_video_upload_finish_cost", (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : "key_wait_export_video_upload_finish_cost", (r33 & 8192) != 0 ? "" : null);
        Channel<Integer> channel = this.channel;
        if (channel != null && !channel.isClosedForSend()) {
            channel.mo2003trySendJP2dKIU(1);
        }
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatEnd(ITaskSnapshotApi.FEAT_VIDEO_EXPORT_UPLOAD);
        p();
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadError(AbstractUploadTask task, int errCode, String errMsg) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.e("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onUploadError] file=" + task.uploadFilePath + ", errorCode=" + errCode + ", errMsg=" + errMsg);
        if (!i()) {
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onUploadError] continuation is not active");
            return;
        }
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
        if (errCode == uploadRetCode.getCode()) {
            UploadErrorCode uploadErrorCode = new UploadErrorCode(errCode, uploadRetCode.getDesc());
            com.tencent.mobileqq.winkpublish.outbox.d.d(y(), "P_PUBLISH_NO_NET", y().r(), (r33 & 4) != 0 ? "" : String.valueOf(uploadErrorCode.transformedCode()), (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : null, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : "1", (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            O();
            o(new NetworkException(uploadErrorCode));
            return;
        }
        Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.UNMATCH_SIZE_EXCEPTION;
        if (errCode == uploadRetCode2.getCode()) {
            UploadErrorCode uploadErrorCode2 = new UploadErrorCode(errCode, uploadRetCode2.getDesc());
            O();
            y().H(false);
            IWinkMultiExportAPI iWinkMultiExportAPI = (IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class);
            WinkExportTask winkExportTask = getWinkExportTask();
            iWinkMultiExportAPI.cancelTask(winkExportTask != null ? winkExportTask.f322847d : null);
            o(new UploadFileSizeUnMatchException(uploadErrorCode2));
            return;
        }
        M(new UploadErrorCode(errCode, errMsg));
    }
}
