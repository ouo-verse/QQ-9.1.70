package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.NetworkException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.UploadException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature;
import com.tencent.mobileqq.winkpublish.report.UploadErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.Const;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001=B\u001b\u0012\u0006\u0010*\u001a\u00020\u001a\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020 H\u0014J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0005H\u0014J\u0010\u0010%\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0004R\u0014\u0010*\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R\"\u0010\f\u001a\u00020\u000b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b!\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0010\u001a\u00020\u000f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\b\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00105R\u0014\u00108\u001a\u00020\t8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/g;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/CancellableFeature;", "Lcom/tencent/upload/uinterface/IUploadTaskCallback;", "", "u", "Lcom/tencent/upload/uinterface/AbstractUploadTask;", "task", "", "D", "", "w", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "mediaInfo", "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "imageParams", "v", "totalSize", "recvSize", "onUploadProgress", "", "result", "onUploadSucceed", "", "errCode", "errMsg", "onUploadError", "state", "onUploadStateChange", "Lcom/tencent/upload/uinterface/data/ImageUploadResult;", BdhLogUtil.LogTag.Tag_Conn, "uploadTask", "G", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/winkpublish/report/UploadErrorCode;", "errorCode", "B", "I", "mediaIndex", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "y", "()Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", UserInfo.SEX_FEMALE, "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;)V", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "E", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/a;)V", "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/String;", "traceId", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(ILcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class g extends CancellableFeature implements IUploadTaskCallback {

    /* renamed from: C, reason: from kotlin metadata */
    protected TaskContext taskContext;

    /* renamed from: D, reason: from kotlin metadata */
    protected UploadMediaInfo mediaInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageParams imageParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int mediaIndex;

    public /* synthetic */ g(int i3, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003e, code lost:
    
        if ((r0.length == 0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long D(AbstractUploadTask task) {
        if (QLog.isDebugVersion()) {
            QLog.d(w(), 1, "uploadEntrance = " + task.uploadEntrance + ", uiRefer = " + task.uiRefer);
        }
        byte[] bArr = task.vLoginData;
        if (bArr != null) {
            Intrinsics.checkNotNullExpressionValue(bArr, "task.vLoginData");
        }
        byte[] b16 = ua3.a.d().b(true);
        if (b16 != null) {
            if (!(b16.length == 0)) {
                QLog.w(w(), 1, "a2key get again...");
                task.vLoginData = b16;
                String str = task.uploadFilePath;
                if (str == null || str.length() == 0) {
                    QLog.w(w(), 1, "no file path");
                    return UploadErrorCode.ERROR_CODE_FILE_NOT_EXIST;
                }
                File file = new File(task.uploadFilePath);
                if (file.exists() && file.length() != 0 && !file.isDirectory()) {
                    return 0L;
                }
                QLog.w(w(), 1, "invalid file status, exists=" + file.exists() + ", path=" + file.getAbsolutePath() + ", length=" + file.length());
                return UploadErrorCode.ERROR_CODE_FILE_NOT_EXIST;
            }
        }
        QLog.w(w(), 1, "no login, stop upload");
        return UploadErrorCode.ERROR_CODE_NO_LOGIN_DATA;
    }

    private final void u() {
        if (this.mediaInfo != null) {
            boolean cancel = UploadServiceBuilder.getInstance().cancel(x().getUploadTask());
            if (QLog.isColorLevel()) {
                QLog.d(w(), 2, "[upload] cancel, result=" + cancel);
                return;
            }
            return;
        }
        QLog.w(w(), 1, "[upload] cancel, mediaInfo is not Initialized");
    }

    protected boolean A(UploadMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return mediaInfo.getUploadResponse() != null;
    }

    protected void C(UploadMediaInfo mediaInfo, ImageUploadResult result) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(result, "result");
        if (mediaInfo.getTotalSize() == 0) {
            mediaInfo.E(100L);
        }
        mediaInfo.D(mediaInfo.getTotalSize());
        mediaInfo.F(result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E(UploadMediaInfo uploadMediaInfo) {
        Intrinsics.checkNotNullParameter(uploadMediaInfo, "<set-?>");
        this.mediaInfo = uploadMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(TaskContext taskContext) {
        Intrinsics.checkNotNullParameter(taskContext, "<set-?>");
        this.taskContext = taskContext;
    }

    protected void G(UploadMediaInfo mediaInfo, AbstractUploadTask uploadTask) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(uploadTask, "uploadTask");
        mediaInfo.G(uploadTask);
        mediaInfo.F(null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void l(TaskContext taskContext) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        QLog.i(w(), 1, "[upload] suspend cancelled, task id=" + taskContext.getId());
        u();
        UploadErrorCode uploadErrorCode = new UploadErrorCode(UploadErrorCode.ERROR_CODE_UPLOAD_CANCELED, null, 2, null);
        if (this.mediaInfo != null) {
            str = String.valueOf(x().getIndexInMediaList());
        } else {
            str = "";
        }
        String str3 = str;
        String z16 = z();
        String valueOf = String.valueOf(uploadErrorCode.transformedCode());
        String message = uploadErrorCode.getMessage();
        if (taskContext.B()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext, "E_UPLOAD_RESULT", z16, (r33 & 4) != 0 ? "" : valueOf, (r33 & 8) != 0 ? "" : "pic", (r33 & 16) != 0 ? "" : str2, (r33 & 32) != 0 ? "" : str3, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(taskContext.getUploadTaskType()), (r33 & 512) != 0 ? "" : message, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void m(TaskContext taskContext) {
        Object orNull;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        QLog.i(w(), 1, "[onRun] mediaIndex=" + this.mediaIndex + ", media size=" + taskContext.l().size() + ", task id=" + taskContext.getId());
        F(taskContext);
        orNull = CollectionsKt___CollectionsKt.getOrNull(taskContext.l(), this.mediaIndex);
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) orNull;
        ImageParams imageParams = null;
        if ((uploadMediaInfo != null ? uploadMediaInfo.h() : null) == null) {
            B(new UploadErrorCode(UploadErrorCode.ERROR_CODE_INVALID_IMAGE_PARAMS, null, 2, null));
            return;
        }
        E(uploadMediaInfo);
        ImageParams h16 = uploadMediaInfo.h();
        Intrinsics.checkNotNull(h16);
        this.imageParams = h16;
        if (h16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageParams");
        } else {
            imageParams = h16;
        }
        v(uploadMediaInfo, imageParams);
    }

    public void onUploadProgress(AbstractUploadTask task, long totalSize, long recvSize) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (QLog.isColorLevel()) {
            QLog.d(w(), 2, "[onUploadProgress] " + (((float) recvSize) / ((float) totalSize)) + ", task id=" + y().getId());
        }
        x().E(totalSize);
        x().D(recvSize);
        if (y().B()) {
            com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(y().b()).c(y().R());
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadStateChange(AbstractUploadTask task, int state) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (QLog.isColorLevel()) {
            QLog.d(w(), 2, "[onUploadStateChange] file=" + task.uploadFilePath + ", state=" + state);
        }
    }

    public String w() {
        return "WinkPublish-upload2-UploadSingleImageFeat";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UploadMediaInfo x() {
        UploadMediaInfo uploadMediaInfo = this.mediaInfo;
        if (uploadMediaInfo != null) {
            return uploadMediaInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        return null;
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
    public final String z() {
        return y().r();
    }

    public g(int i3, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
        this.mediaIndex = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(UploadErrorCode errorCode) {
        String str;
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskContext y16 = y();
        String z16 = z();
        String valueOf = String.valueOf(errorCode.transformedCode());
        if (y().B()) {
            str = "1";
        } else {
            str = "0";
        }
        com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "E_UPLOAD_RESULT", z16, (r33 & 4) != 0 ? "" : valueOf, (r33 & 8) != 0 ? "" : "pic", (r33 & 16) != 0 ? "" : str, (r33 & 32) != 0 ? "" : String.valueOf(x().getIndexInMediaList()), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(y().getUploadTaskType()), (r33 & 512) != 0 ? "" : errorCode.getMessage(), (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        o(new UploadException(errorCode));
    }

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
        UploadMediaInfo x16 = x();
        String str2 = task.md5;
        Intrinsics.checkNotNullExpressionValue(str2, "task.md5");
        x16.B(str2);
        TaskContext y16 = y();
        String z16 = z();
        if (y().B()) {
            str = "1";
        } else {
            str = "0";
        }
        String str3 = str;
        String valueOf = String.valueOf(x().getIndexInMediaList());
        String str4 = imageUploadResult.sBURL;
        Intrinsics.checkNotNullExpressionValue(str4, "result.sBURL");
        com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "E_UPLOAD_RESULT", z16, (r33 & 4) != 0 ? "" : "0", (r33 & 8) != 0 ? "" : "pic", (r33 & 16) != 0 ? "" : str3, (r33 & 32) != 0 ? "" : valueOf, (r33 & 64) != 0 ? "" : str4, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(y().getUploadTaskType()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        p();
    }

    public void v(UploadMediaInfo mediaInfo, ImageParams imageParams) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(imageParams, "imageParams");
        if (!A(mediaInfo)) {
            com.tencent.mobileqq.winkpublish.outbox.d.d(y(), "E_UPLOAD_START", z(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : "pic", (r33 & 16) != 0 ? "" : String.valueOf(mediaInfo.getIndexInMediaList()), (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(y().getUploadTaskType()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            ImageUploadTask a16 = wa3.d.INSTANCE.a(y().d()).a(y(), imageParams, mediaInfo.getIndexInMediaList(), this);
            G(mediaInfo, a16);
            long D = D(a16);
            if (D == 0) {
                boolean upload = UploadServiceBuilder.getInstance().upload(a16);
                if (QLog.isColorLevel()) {
                    QLog.d(w(), 2, "[upload] result=" + upload);
                    return;
                }
                return;
            }
            B(new UploadErrorCode(D, null, 2, null));
            return;
        }
        QLog.i(w(), 1, "[upload] already upload, file=" + mediaInfo.l());
        p();
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadError(AbstractUploadTask task, int errCode, String errMsg) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i(w(), 1, "[onUploadError] file=" + task.uploadFilePath + ", errorCode=" + errCode + ", errMsg=" + errMsg + ", task id=" + y().getId());
        if (!i()) {
            QLog.w(w(), 1, "[onUploadError] continuation is not active");
            return;
        }
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
        if (errCode == uploadRetCode.getCode()) {
            UploadErrorCode uploadErrorCode = new UploadErrorCode(errCode, uploadRetCode.getDesc());
            com.tencent.mobileqq.winkpublish.outbox.d.d(y(), "P_PUBLISH_NO_NET", z(), (r33 & 4) != 0 ? "" : String.valueOf(uploadErrorCode.transformedCode()), (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : null, (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(y().getUploadTaskType()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            o(new NetworkException(uploadErrorCode));
            return;
        }
        B(new UploadErrorCode(errCode, errMsg));
    }
}
