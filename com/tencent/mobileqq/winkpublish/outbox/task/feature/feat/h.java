package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.NetworkException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.UploadException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadResult;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadTaskExtendCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import com.tencent.upload.utils.Const;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00016B\u0013\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b1\u00102B\u0017\b\u0016\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180(\u00a2\u0006\u0004\b1\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\"\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/h;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/CancellableFeature;", "Lcom/tencent/upload/uinterface/IUploadTaskExtendCallback;", "", "v", "Lcom/tencent/upload/uinterface/AbstractUploadTask;", "task", "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/winkpublish/report/UploadErrorCode;", "errCode", "", "w", "k", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "totalSize", "recvSize", "onUploadProgress", "", "result", "onUploadSucceed", "", "", "errMsg", "onUploadError", "state", "onUploadStateChange", "onBatchControlRsp", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "mediaInfo", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "D", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "videoParams", "Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "u", "()Ljava/lang/String;", "traceId", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "coverChannel", "(Lkotlinx/coroutines/channels/Channel;)V", UserInfo.SEX_FEMALE, "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends CancellableFeature implements IUploadTaskExtendCallback {

    /* renamed from: C, reason: from kotlin metadata */
    private UploadMediaInfo mediaInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private VideoParams videoParams;

    /* renamed from: E, reason: from kotlin metadata */
    private Channel<Integer> channel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TaskContext taskContext;

    public /* synthetic */ h(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }

    private final String u() {
        TaskContext taskContext = this.taskContext;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        return taskContext.r();
    }

    private final boolean v() {
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        if (uploadMediaInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo = null;
        }
        AbstractUploadResult uploadResponse = uploadMediaInfo.getUploadResponse();
        VideoUploadResult videoUploadResult = uploadResponse instanceof VideoUploadResult ? (VideoUploadResult) uploadResponse : null;
        if (videoUploadResult == null) {
            QLog.d("WinkPublish-upload2-UploadVideoFeat", 1, "response == null");
            return false;
        }
        QLog.d("WinkPublish-upload2-UploadVideoFeat", 1, "isControlPkg:" + videoUploadResult.isControlPkg);
        return !videoUploadResult.isControlPkg;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
    
        if ((r0.length == 0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long x(AbstractUploadTask task) {
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-upload2-UploadVideoFeat", 1, "uploadEntrance = " + task.uploadEntrance + ", uiRefer = " + task.uiRefer);
        }
        byte[] bArr = task.vLoginData;
        if (bArr != null) {
            Intrinsics.checkNotNullExpressionValue(bArr, "task.vLoginData");
        }
        byte[] b16 = ua3.a.d().b(true);
        if (b16 != null) {
            if (!(b16.length == 0)) {
                QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "a2key get again...");
                task.vLoginData = b16;
                String str = task.uploadFilePath;
                if (str == null || str.length() == 0) {
                    QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "no file path");
                    return UploadErrorCode.ERROR_CODE_FILE_NOT_EXIST;
                }
                File file = new File(task.uploadFilePath);
                if (file.exists() && file.length() != 0 && !file.isDirectory()) {
                    return 0L;
                }
                QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "invalid file status, exists=" + file.exists() + ", path=" + file.getAbsolutePath() + ", length=" + file.length());
                return UploadErrorCode.ERROR_CODE_FILE_NOT_EXIST;
            }
        }
        QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "no login, stop upload");
        return UploadErrorCode.ERROR_CODE_NO_LOGIN_DATA;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public boolean k() {
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskExtendCallback
    public void onBatchControlRsp(AbstractUploadTask task, Object result) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        VideoUploadResult videoUploadResult = (VideoUploadResult) result;
        String str = task.uploadFilePath;
        String str2 = videoUploadResult.sVid;
        String str3 = task.md5;
        TaskContext taskContext = this.taskContext;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        QLog.i("WinkPublish-upload2-UploadVideoFeat", 1, "[onBatchControlRsp] file=" + str + ", vid=" + str2 + ", md5=" + str3 + ", task id=" + taskContext.getId());
        if (!i()) {
            QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "[onBatchControlRsp] continuation is not active");
            return;
        }
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        if (uploadMediaInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo = null;
        }
        if (uploadMediaInfo.getUploadResponse() == null) {
            uploadMediaInfo.F((AbstractUploadResult) result);
        } else {
            QLog.w("WinkPublish-upload2-VideoExportUploadFeat", 1, "[onBatchControlRsp] response is not the same");
            AbstractUploadResult uploadResponse = uploadMediaInfo.getUploadResponse();
            if (uploadResponse != null) {
                Intrinsics.checkNotNull(uploadResponse, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.VideoUploadResult");
                VideoUploadResult videoUploadResult2 = (VideoUploadResult) uploadResponse;
                QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "[onBatchControlRsp] videoRspCover.sVid:" + videoUploadResult.sVid + " batchRspCover.sVid:" + videoUploadResult2.sVid);
                if (!Intrinsics.areEqual(videoUploadResult.sVid, videoUploadResult2.sVid)) {
                    uploadMediaInfo.w(null);
                }
            }
            uploadMediaInfo.F((AbstractUploadResult) result);
        }
        Channel<Integer> channel = this.channel;
        if (channel == null || channel.isClosedForSend()) {
            return;
        }
        channel.mo2003trySendJP2dKIU(2);
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadProgress(AbstractUploadTask task, long totalSize, long recvSize) {
        Intrinsics.checkNotNullParameter(task, "task");
        TaskContext taskContext = null;
        if (QLog.isColorLevel()) {
            float f16 = ((float) recvSize) / ((float) totalSize);
            TaskContext taskContext2 = this.taskContext;
            if (taskContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskContext");
                taskContext2 = null;
            }
            QLog.d("WinkPublish-upload2-UploadVideoFeat", 2, "[onUploadProgress] " + f16 + ", task id=" + taskContext2.getId());
        }
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        if (uploadMediaInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo = null;
        }
        uploadMediaInfo.E(totalSize);
        UploadMediaInfo uploadMediaInfo2 = this.mediaInfo;
        if (uploadMediaInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo2 = null;
        }
        uploadMediaInfo2.D(recvSize);
        TaskContext taskContext3 = this.taskContext;
        if (taskContext3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext3 = null;
        }
        if (taskContext3.B() && i()) {
            com.tencent.mobileqq.winkpublish.outbox.e eVar = com.tencent.mobileqq.winkpublish.outbox.e.f327257a;
            TaskContext taskContext4 = this.taskContext;
            if (taskContext4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskContext");
                taskContext4 = null;
            }
            com.tencent.mobileqq.winkpublish.outbox.b a16 = eVar.a(taskContext4.b());
            TaskContext taskContext5 = this.taskContext;
            if (taskContext5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            } else {
                taskContext = taskContext5;
            }
            a16.c(taskContext.R());
            ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onUpdateUploadInfo(recvSize, totalSize);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadStateChange(AbstractUploadTask task, int state) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-upload2-UploadVideoFeat", 2, "[onUploadStateChange] file=" + task.uploadFilePath + ", state=" + state);
        }
    }

    public h(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Channel<Integer> coverChannel) {
        this(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(coverChannel, "coverChannel");
        this.channel = coverChannel;
    }

    private final void w(UploadErrorCode errCode) {
        TaskContext taskContext;
        String str;
        TaskContext taskContext2 = this.taskContext;
        TaskContext taskContext3 = null;
        if (taskContext2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        } else {
            taskContext = taskContext2;
        }
        String u16 = u();
        String valueOf = String.valueOf(errCode.transformedCode());
        TaskContext taskContext4 = this.taskContext;
        if (taskContext4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext4 = null;
        }
        if (taskContext4.B()) {
            str = "1";
        } else {
            str = "0";
        }
        String str2 = str;
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        if (uploadMediaInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo = null;
        }
        String valueOf2 = String.valueOf(uploadMediaInfo.getIndexInMediaList());
        TaskContext taskContext5 = this.taskContext;
        if (taskContext5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
        } else {
            taskContext3 = taskContext5;
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "E_UPLOAD_RESULT", u16, (r33 & 4) != 0 ? "" : valueOf, (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : str2, (r33 & 32) != 0 ? "" : valueOf2, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(taskContext3.getUploadTaskType()), (r33 & 512) != 0 ? "" : errCode.getMessage(), (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        o(new UploadException(errCode));
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void l(TaskContext taskContext) {
        String str;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        IUploadService uploadServiceBuilder = UploadServiceBuilder.getInstance();
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        UploadMediaInfo uploadMediaInfo2 = null;
        if (uploadMediaInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo = null;
        }
        boolean cancel = uploadServiceBuilder.cancel(uploadMediaInfo.getUploadTask());
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-upload2-UploadVideoFeat", 2, "[upload] cancel, result=" + cancel);
        }
        UploadErrorCode uploadErrorCode = new UploadErrorCode(UploadErrorCode.ERROR_CODE_UPLOAD_CANCELED, null, 2, null);
        String u16 = u();
        String valueOf = String.valueOf(uploadErrorCode.transformedCode());
        String message = uploadErrorCode.getMessage();
        if (taskContext.B()) {
            str = "1";
        } else {
            str = "0";
        }
        String str2 = str;
        UploadMediaInfo uploadMediaInfo3 = this.mediaInfo;
        if (uploadMediaInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        } else {
            uploadMediaInfo2 = uploadMediaInfo3;
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "E_UPLOAD_RESULT", u16, (r33 & 4) != 0 ? "" : valueOf, (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : str2, (r33 & 32) != 0 ? "" : String.valueOf(uploadMediaInfo2.getIndexInMediaList()), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(taskContext.getUploadTaskType()), (r33 & 512) != 0 ? "" : message, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void m(TaskContext taskContext) {
        Object orNull;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        this.taskContext = taskContext;
        orNull = CollectionsKt___CollectionsKt.getOrNull(taskContext.x(), 0);
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) orNull;
        UploadMediaInfo uploadMediaInfo2 = null;
        if ((uploadMediaInfo != null ? uploadMediaInfo.r() : null) == null) {
            w(new UploadErrorCode(UploadErrorCode.ERROR_CODE_INVALID_VIDEO_PARAMS, null, 2, null));
            return;
        }
        this.mediaInfo = uploadMediaInfo;
        VideoParams r16 = uploadMediaInfo.r();
        Intrinsics.checkNotNull(r16);
        this.videoParams = r16;
        if (v()) {
            UploadMediaInfo uploadMediaInfo3 = this.mediaInfo;
            if (uploadMediaInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            } else {
                uploadMediaInfo2 = uploadMediaInfo3;
            }
            QLog.i("WinkPublish-upload2-UploadVideoFeat", 1, "[onRun] already upload, file=" + uploadMediaInfo2.l());
            Channel<Integer> channel = this.channel;
            if (channel != null) {
                ChannelResult.m2008boximpl(channel.mo2003trySendJP2dKIU(3));
            }
            p();
            return;
        }
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatStart(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO);
        String u16 = u();
        UploadMediaInfo uploadMediaInfo4 = this.mediaInfo;
        if (uploadMediaInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo4 = null;
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "E_UPLOAD_START", u16, (r33 & 4) != 0 ? "" : "0", (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : String.valueOf(uploadMediaInfo4.getIndexInMediaList()), (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(taskContext.getUploadTaskType()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        wa3.j a16 = wa3.j.INSTANCE.a(taskContext.d());
        VideoParams videoParams = this.videoParams;
        if (videoParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoParams");
            videoParams = null;
        }
        UploadMediaInfo uploadMediaInfo5 = this.mediaInfo;
        if (uploadMediaInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo5 = null;
        }
        VideoUploadTask b16 = a16.b(taskContext, videoParams, uploadMediaInfo5.getIndexInMediaList(), this);
        UploadMediaInfo uploadMediaInfo6 = this.mediaInfo;
        if (uploadMediaInfo6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo6 = null;
        }
        uploadMediaInfo6.G(b16);
        UploadMediaInfo uploadMediaInfo7 = this.mediaInfo;
        if (uploadMediaInfo7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        } else {
            uploadMediaInfo2 = uploadMediaInfo7;
        }
        if (uploadMediaInfo2.getIsVideoExported()) {
            taskContext.Q(0);
        } else {
            taskContext.Q(2);
        }
        long x16 = x(b16);
        if (x16 == 0) {
            boolean upload = UploadServiceBuilder.getInstance().upload(b16);
            if (QLog.isColorLevel()) {
                QLog.d("WinkPublish-upload2-UploadVideoFeat", 2, "[upload] result=" + upload);
                return;
            }
            return;
        }
        w(new UploadErrorCode(x16, null, 2, null));
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadSucceed(AbstractUploadTask task, Object result) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        VideoUploadResult videoUploadResult = (VideoUploadResult) result;
        String str2 = task.uploadFilePath;
        String str3 = videoUploadResult.sVid;
        String str4 = task.md5;
        TaskContext taskContext = this.taskContext;
        TaskContext taskContext2 = null;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        QLog.i("WinkPublish-upload2-UploadVideoFeat", 1, "[onUploadSucceed] file=" + str2 + ", vid=" + str3 + ", md5=" + str4 + ", task id=" + taskContext.getId());
        if (!i()) {
            QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "[onUploadSucceed] continuation is not active");
            return;
        }
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        if (uploadMediaInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo = null;
        }
        AbstractUploadResult uploadResponse = uploadMediaInfo.getUploadResponse();
        if (uploadResponse != null) {
            Intrinsics.checkNotNull(uploadResponse, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.VideoUploadResult");
            VideoUploadResult videoUploadResult2 = (VideoUploadResult) uploadResponse;
            QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "[onUploadSucceed] videoRspCover.sVid:" + videoUploadResult.sVid + " batchRspCover.sVid:" + videoUploadResult2.sVid);
            if (!Intrinsics.areEqual(videoUploadResult.sVid, videoUploadResult2.sVid)) {
                UploadMediaInfo uploadMediaInfo2 = this.mediaInfo;
                if (uploadMediaInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
                    uploadMediaInfo2 = null;
                }
                uploadMediaInfo2.w(null);
            }
        }
        uploadMediaInfo.F((AbstractUploadResult) result);
        String str5 = task.md5;
        Intrinsics.checkNotNullExpressionValue(str5, "task.md5");
        uploadMediaInfo.B(str5);
        uploadMediaInfo.D(uploadMediaInfo.getTotalSize());
        TaskContext taskContext3 = this.taskContext;
        if (taskContext3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext3 = null;
        }
        String r16 = taskContext3.r();
        TaskContext taskContext4 = this.taskContext;
        if (taskContext4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext4 = null;
        }
        if (taskContext4.B()) {
            str = "1";
        } else {
            str = "0";
        }
        String str6 = str;
        String str7 = videoUploadResult.sVid;
        Intrinsics.checkNotNullExpressionValue(str7, "result.sVid");
        UploadMediaInfo uploadMediaInfo3 = this.mediaInfo;
        if (uploadMediaInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
            uploadMediaInfo3 = null;
        }
        String valueOf = String.valueOf(uploadMediaInfo3.getIndexInMediaList());
        TaskContext taskContext5 = this.taskContext;
        if (taskContext5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
        } else {
            taskContext2 = taskContext5;
        }
        TaskContext taskContext6 = taskContext3;
        com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext6, "E_UPLOAD_RESULT", r16, (r33 & 4) != 0 ? "" : "0", (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : str6, (r33 & 32) != 0 ? "" : str7, (r33 & 64) != 0 ? "" : valueOf, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(taskContext2.getUploadTaskType()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        com.tencent.mobileqq.winkpublish.outbox.d.a(taskContext6, WinkPublishServiceReporter.P_PUBLISH_ALL_COST, taskContext3.r(), "0", (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "key_wait_export_video_to_upload_cost", (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : "key_wait_export_video_to_upload_cost", (r33 & 8192) != 0 ? "" : null);
        Channel<Integer> channel = this.channel;
        if (channel != null && !channel.isClosedForSend()) {
            channel.mo2003trySendJP2dKIU(1);
        }
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatEnd(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO);
        p();
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadError(AbstractUploadTask task, int errCode, String errMsg) {
        TaskContext taskContext;
        Intrinsics.checkNotNullParameter(task, "task");
        String str = task.uploadFilePath;
        TaskContext taskContext2 = this.taskContext;
        if (taskContext2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext2 = null;
        }
        QLog.i("WinkPublish-upload2-UploadVideoFeat", 1, "[onUploadError] file=" + str + ", errorCode=" + errCode + ", errMsg=" + errMsg + ", taks id=" + taskContext2.getId());
        if (!i()) {
            QLog.w("WinkPublish-upload2-UploadVideoFeat", 1, "[onUploadError] continuation is not active");
            return;
        }
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
        if (errCode == uploadRetCode.getCode()) {
            UploadErrorCode uploadErrorCode = new UploadErrorCode(errCode, uploadRetCode.getDesc());
            TaskContext taskContext3 = this.taskContext;
            if (taskContext3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskContext");
                taskContext = null;
            } else {
                taskContext = taskContext3;
            }
            com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "P_PUBLISH_NO_NET", u(), (r33 & 4) != 0 ? "" : String.valueOf(uploadErrorCode.transformedCode()), (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : null, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            o(new NetworkException(uploadErrorCode));
            return;
        }
        w(new UploadErrorCode(errCode, errMsg));
    }
}
