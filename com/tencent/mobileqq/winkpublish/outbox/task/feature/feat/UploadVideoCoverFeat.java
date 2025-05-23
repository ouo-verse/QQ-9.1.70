package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import FileUpload.PicExtendInfo;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.UploadException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.upload.uinterface.AbstractUploadResult;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001\rB\u001b\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b,\u0010-B\u001f\b\u0016\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\"\u00a2\u0006\u0004\b,\u0010/J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001b\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001dH\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#R$\u0010)\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010&\"\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/UploadVideoCoverFeat;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/g;", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "videoParams", "", "H", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "mediaInfo", "J", "w", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/upload/uinterface/AbstractUploadTask;", "task", "", "totalSize", "recvSize", "onUploadProgress", "uploadTask", "G", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/upload/uinterface/data/ImageUploadResult;", "result", BdhLogUtil.LogTag.Tag_Conn, "", "onUploadSucceed", "", "I", "videoIndex", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "value", "()Z", "K", "(Z)V", "hasNewCover", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(ILcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "coverChannel", "(ILkotlinx/coroutines/channels/Channel;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UploadVideoCoverFeat extends g {

    /* renamed from: G, reason: from kotlin metadata */
    private final int videoIndex;

    /* renamed from: H, reason: from kotlin metadata */
    private Channel<Integer> channel;

    public /* synthetic */ UploadVideoCoverFeat(int i3, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : bVar);
    }

    private final String J(UploadMediaInfo mediaInfo) {
        try {
            long lastModified = new File(mediaInfo.l()).lastModified();
            if (lastModified > 0) {
                return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(lastModified));
            }
            return null;
        } catch (Exception e16) {
            QLog.w(w(), 1, "getVideoCaptureTime", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g
    protected boolean A(UploadMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return (I() || mediaInfo.getCoverUploadResponse() == null) ? false : true;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g
    protected void C(UploadMediaInfo mediaInfo, ImageUploadResult result) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(result, "result");
        if (mediaInfo.getCoverTotalSize() == 0) {
            mediaInfo.v(100L);
        }
        mediaInfo.u(mediaInfo.getCoverTotalSize());
        mediaInfo.w(result);
        K(false);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g
    protected void G(UploadMediaInfo mediaInfo, AbstractUploadTask uploadTask) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(uploadTask, "uploadTask");
        ImageUploadTask imageUploadTask = (ImageUploadTask) uploadTask;
        imageUploadTask.isCover = true;
        imageUploadTask.srcVideoPath = mediaInfo.l();
        AbstractUploadTask uploadTask2 = mediaInfo.getUploadTask();
        Intrinsics.checkNotNull(uploadTask2);
        imageUploadTask.iUploadTime = uploadTask2.iUploadTime;
        PicExtendInfo picExtendInfo = imageUploadTask.stExtendInfo;
        if (picExtendInfo == null) {
            picExtendInfo = new PicExtendInfo();
        }
        imageUploadTask.stExtendInfo = picExtendInfo;
        Map<String, String> map = picExtendInfo.mapParams;
        if (map == null) {
            map = new HashMap<>();
        }
        picExtendInfo.mapParams = map;
        AbstractUploadResult uploadResponse = mediaInfo.getUploadResponse();
        Intrinsics.checkNotNull(uploadResponse, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.VideoUploadResult");
        VideoUploadResult videoUploadResult = (VideoUploadResult) uploadResponse;
        Map<String, String> map2 = imageUploadTask.stExtendInfo.mapParams;
        Intrinsics.checkNotNullExpressionValue(map2, "stExtendInfo.mapParams");
        map2.put("vid", videoUploadResult.sVid);
        Map<String, String> map3 = imageUploadTask.stExtendInfo.mapParams;
        Intrinsics.checkNotNullExpressionValue(map3, "stExtendInfo.mapParams");
        String str = "0";
        map3.put(FSUploadConst.KEY_COVER_SEQ, "0");
        String J = J(mediaInfo);
        if (J != null) {
            Map<String, String> map4 = imageUploadTask.stExtendInfo.mapParams;
            Intrinsics.checkNotNullExpressionValue(map4, "stExtendInfo.mapParams");
            map4.put("Exif_Time", J);
        }
        QLog.i("WinkPublish-upload2-UploadVideoCoverFeat", 1, "[updateUploadTask] hasNewCover=" + I() + ", vid=" + videoUploadResult.sVid + " task id=" + y().getId());
        Map<String, String> map5 = imageUploadTask.stExtendInfo.mapParams;
        Intrinsics.checkNotNullExpressionValue(map5, "stExtendInfo.mapParams");
        if (I()) {
            str = "1";
        }
        map5.put(FSUploadConst.KEY_UPLOAD_HAS_SELECT_COVER, str);
        HashMap<String, String> stExternalMapExt = imageUploadTask.stExternalMapExt;
        if (stExternalMapExt == null) {
            stExternalMapExt = new HashMap<>();
        }
        imageUploadTask.stExternalMapExt = stExternalMapExt;
        Intrinsics.checkNotNullExpressionValue(stExternalMapExt, "stExternalMapExt");
        stExternalMapExt.put(FSUploadConst.KEY_CLIENT_UPLOOAD_COVER, "1");
        HashMap<String, String> stExternalMapExt2 = imageUploadTask.stExternalMapExt;
        Intrinsics.checkNotNullExpressionValue(stExternalMapExt2, "stExternalMapExt");
        stExternalMapExt2.put(FSUploadConst.KEY_MIX_FEED, "1");
        VideoParams r16 = mediaInfo.r();
        if (r16 != null) {
            HashMap<String, String> stExternalMapExt3 = imageUploadTask.stExternalMapExt;
            Intrinsics.checkNotNullExpressionValue(stExternalMapExt3, "stExternalMapExt");
            stExternalMapExt3.put(FSUploadConst.KEY_MIX_VIDEO_SIZE, String.valueOf(r16.getFileSize()));
            HashMap<String, String> stExternalMapExt4 = imageUploadTask.stExternalMapExt;
            Intrinsics.checkNotNullExpressionValue(stExternalMapExt4, "stExternalMapExt");
            stExternalMapExt4.put(FSUploadConst.KEY_MIX_ORIGIN_VIDEO, "1");
            HashMap<String, String> stExternalMapExt5 = imageUploadTask.stExternalMapExt;
            Intrinsics.checkNotNullExpressionValue(stExternalMapExt5, "stExternalMapExt");
            stExternalMapExt5.put(FSUploadConst.KEY_MIX_TIME, String.valueOf(r16.getDuration()));
            imageUploadTask.sPicDesc = "";
        }
        mediaInfo.x(imageUploadTask);
        mediaInfo.w(null);
    }

    public final boolean I() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(y().x(), this.videoIndex);
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) orNull;
        if (uploadMediaInfo != null) {
            return uploadMediaInfo.getHasChangedCover();
        }
        return false;
    }

    public final void K(boolean z16) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(y().x(), this.videoIndex);
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) orNull;
        if (uploadMediaInfo == null) {
            return;
        }
        uploadMediaInfo.A(z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        UploadVideoCoverFeat$run$1 uploadVideoCoverFeat$run$1;
        Object coroutine_suspended;
        int i3;
        UploadVideoCoverFeat uploadVideoCoverFeat;
        TaskContext taskContext2;
        Channel<Integer> channel;
        int intValue;
        if (continuation instanceof UploadVideoCoverFeat$run$1) {
            uploadVideoCoverFeat$run$1 = (UploadVideoCoverFeat$run$1) continuation;
            int i16 = uploadVideoCoverFeat$run$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                uploadVideoCoverFeat$run$1.label = i16 - Integer.MIN_VALUE;
                Object obj = uploadVideoCoverFeat$run$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = uploadVideoCoverFeat$run$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Channel<Integer> channel2 = this.channel;
                    if (channel2 != null) {
                        uploadVideoCoverFeat$run$1.L$0 = this;
                        uploadVideoCoverFeat$run$1.L$1 = taskContext;
                        uploadVideoCoverFeat$run$1.L$2 = channel2;
                        uploadVideoCoverFeat$run$1.label = 1;
                        Object receive = channel2.receive(uploadVideoCoverFeat$run$1);
                        if (receive == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        uploadVideoCoverFeat = this;
                        taskContext2 = taskContext;
                        channel = channel2;
                        obj = receive;
                    } else {
                        uploadVideoCoverFeat = this;
                        uploadVideoCoverFeat$run$1.L$0 = null;
                        uploadVideoCoverFeat$run$1.L$1 = null;
                        uploadVideoCoverFeat$run$1.L$2 = null;
                        uploadVideoCoverFeat$run$1.label = 2;
                        if (super.a(taskContext, uploadVideoCoverFeat$run$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    channel = (Channel) uploadVideoCoverFeat$run$1.L$2;
                    taskContext2 = (TaskContext) uploadVideoCoverFeat$run$1.L$1;
                    uploadVideoCoverFeat = (UploadVideoCoverFeat) uploadVideoCoverFeat$run$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                intValue = ((Number) obj).intValue();
                SendChannel.DefaultImpls.close$default(channel, null, 1, null);
                if (intValue != 3) {
                    taskContext2.P(intValue);
                }
                taskContext = taskContext2;
                uploadVideoCoverFeat$run$1.L$0 = null;
                uploadVideoCoverFeat$run$1.L$1 = null;
                uploadVideoCoverFeat$run$1.L$2 = null;
                uploadVideoCoverFeat$run$1.label = 2;
                if (super.a(taskContext, uploadVideoCoverFeat$run$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        uploadVideoCoverFeat$run$1 = new UploadVideoCoverFeat$run$1(this, continuation);
        Object obj2 = uploadVideoCoverFeat$run$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = uploadVideoCoverFeat$run$1.label;
        if (i3 != 0) {
        }
        intValue = ((Number) obj2).intValue();
        SendChannel.DefaultImpls.close$default(channel, null, 1, null);
        if (intValue != 3) {
        }
        taskContext = taskContext2;
        uploadVideoCoverFeat$run$1.L$0 = null;
        uploadVideoCoverFeat$run$1.L$1 = null;
        uploadVideoCoverFeat$run$1.L$2 = null;
        uploadVideoCoverFeat$run$1.label = 2;
        if (super.a(taskContext, uploadVideoCoverFeat$run$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g, com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadProgress(AbstractUploadTask task, long totalSize, long recvSize) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (QLog.isColorLevel()) {
            QLog.d(w(), 2, "[onUploadProgress] " + (((float) recvSize) / ((float) totalSize)) + ", task id=" + y().getId());
        }
        x().v(totalSize);
        x().u(recvSize);
        if (y().B()) {
            com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(y().b()).c(y().R());
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g
    public String w() {
        return "WinkPublish-upload2-UploadVideoCoverFeat";
    }

    public UploadVideoCoverFeat(int i3, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(i3, bVar);
        this.videoIndex = i3;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void m(TaskContext taskContext) {
        Object orNull;
        String str;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        QLog.i(w(), 1, "[onRun] videoIndex=" + this.videoIndex + ", media size=" + taskContext.x().size() + ", task id=" + taskContext.getId());
        F(taskContext);
        orNull = CollectionsKt___CollectionsKt.getOrNull(taskContext.x(), this.videoIndex);
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) orNull;
        if ((uploadMediaInfo != null ? uploadMediaInfo.r() : null) == null) {
            B(new UploadErrorCode(UploadErrorCode.ERROR_CODE_INVALID_VIDEO_PARAMS, null, 2, null));
            return;
        }
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatStart(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO_COVER);
        E(uploadMediaInfo);
        VideoParams r16 = uploadMediaInfo.r();
        Intrinsics.checkNotNull(r16);
        String H = H(r16);
        if (H == null || H.length() == 0) {
            QLog.w(w(), 1, "[onRun] invalid coverPath");
            UploadErrorCode uploadErrorCode = new UploadErrorCode(UploadErrorCode.ERROR_CODE_VIDEO_COVER_NOT_FOUND, null, 2, null);
            String z16 = z();
            String valueOf = String.valueOf(uploadErrorCode.transformedCode());
            String message = uploadErrorCode.getMessage();
            if (taskContext.B()) {
                str = "1";
            } else {
                str = "0";
            }
            com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "E_UPLOAD_RESULT", z16, (r33 & 4) != 0 ? "" : valueOf, (r33 & 8) != 0 ? "" : "video", (r33 & 16) != 0 ? "" : str, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : message, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            throw new UploadException(uploadErrorCode);
        }
        if (!Intrinsics.areEqual(r16.getCoverPath(), H)) {
            r16.setCoverPath(H);
        }
        QLog.d(w(), 1, "[onRun] coverPath=" + H);
        v(uploadMediaInfo, new ImageParams(r16.getCoverPath(), 0, 0, 0, 0L, 0, 0, 0L, null, null, MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UploadVideoCoverFeat(int i3, Channel<Integer> coverChannel) {
        this(i3, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(coverChannel, "coverChannel");
        this.channel = coverChannel;
    }

    private final String H(VideoParams videoParams) {
        String coverPath = videoParams != null ? videoParams.getCoverPath() : null;
        boolean z16 = false;
        if (coverPath != null) {
            if (coverPath.length() > 0) {
                z16 = true;
            }
        }
        if (z16 && new File(coverPath).exists() && !new File(coverPath).isDirectory()) {
            return coverPath;
        }
        return PublishVideoUtils.getVideoCover(videoParams != null ? videoParams.getLocalPath() : null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g, com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadSucceed(AbstractUploadTask task, Object result) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i(w(), 1, "[onUploadSucceed] file=" + task.uploadFilePath + ", result=" + result + ", task id=" + y().getId());
        if (!i()) {
            QLog.w(w(), 1, "[onUploadSucceed] continuation is not active");
            return;
        }
        ImageUploadResult imageUploadResult = (ImageUploadResult) result;
        C(x(), imageUploadResult);
        TaskContext y16 = y();
        String z16 = z();
        if (y().B()) {
            str = "1";
        } else {
            str = "0";
        }
        String str2 = str;
        String valueOf = String.valueOf(x().getIndexInMediaList());
        String str3 = imageUploadResult.sBURL;
        Intrinsics.checkNotNullExpressionValue(str3, "result.sBURL");
        com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "E_UPLOAD_RESULT", z16, (r33 & 4) != 0 ? "" : "0", (r33 & 8) != 0 ? "" : "pic", (r33 & 16) != 0 ? "" : str2, (r33 & 32) != 0 ? "" : valueOf, (r33 & 64) != 0 ? "" : str3, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(y().getUploadTaskType()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).onFeatEnd(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO_COVER);
        p();
    }
}
