package com.tencent.mobileqq.qqecommerce.base.upload;

import android.os.Message;
import androidx.compose.runtime.c;
import com.tencent.ecommerce.base.uploader.ECBaseUploader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.api.IRuntimeService;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0012\u0018\u0000 \u001b2\u00020\u0001:\u0002\u0004\u001cB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/upload/ECImageUploader;", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "", "j", "a", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "e", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mobileqq/qqecommerce/base/upload/ECImageUploader$State;", "Ljava/util/concurrent/atomic/AtomicReference;", "state", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "g", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "transReq", "com/tencent/mobileqq/qqecommerce/base/upload/ECImageUploader$b", h.F, "Lcom/tencent/mobileqq/qqecommerce/base/upload/ECImageUploader$b;", "imageTransProcessorHandler", "", "filePath", "scene", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V", "i", "State", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECImageUploader extends ECBaseUploader {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QQAppInterface app;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicReference<State> state;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TransferRequest transReq;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b imageTransProcessorHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/upload/ECImageUploader$State;", "", "(Ljava/lang/String;I)V", "Ready", "Running", "Paused", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    private enum State {
        Ready,
        Running,
        Paused
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/upload/ECImageUploader$b", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends TransProcessorHandler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            String str;
            String replaceFirst$default;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Object obj = msg2.obj;
            FileMsg fileMsg = obj instanceof FileMsg ? (FileMsg) obj : null;
            if (fileMsg != null && fileMsg.fileType == 24 && fileMsg.commandId == 2006) {
                TransferRequest transferRequest = ECImageUploader.this.transReq;
                if (transferRequest != null && fileMsg.uniseq == transferRequest.mUniseq) {
                    switch (msg2.what) {
                        case 1001:
                            ECBaseUploader.IUploaderListener uploadListener = ECImageUploader.this.getUploadListener();
                            if (uploadListener != null) {
                                uploadListener.onUploadStarted();
                            }
                            TransferRequest transferRequest2 = ECImageUploader.this.transReq;
                            QLog.d("ECImageUploader", 2, "start send image, image path: " + (transferRequest2 != null ? transferRequest2.mLocalPath : null));
                            return;
                        case 1002:
                            if (QLog.isColorLevel()) {
                                TransferRequest transferRequest3 = ECImageUploader.this.transReq;
                                str = transferRequest3 != null ? transferRequest3.mLocalPath : null;
                                QLog.d("ECImageUploader", 2, "is sending image, image path: " + str + ", transfer: " + fileMsg.transferedSize + ", total: " + fileMsg.fileSize);
                            }
                            ECBaseUploader.IUploaderListener uploadListener2 = ECImageUploader.this.getUploadListener();
                            if (uploadListener2 != null) {
                                uploadListener2.onUploadProgress(fileMsg.transferedSize, fileMsg.fileSize);
                                return;
                            }
                            return;
                        case 1003:
                        case 1008:
                            Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                            byte[] bArr = fileMsg.bdhExtendInfo;
                            uploadPicExtInfo.mergeFrom(bArr, 0, bArr.length);
                            String picUrl = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                            String old = new URL(picUrl).getHost();
                            Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
                            Intrinsics.checkNotNullExpressionValue(old, "old");
                            replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(picUrl, old, "cdn.xsj.qq.com", false, 4, (Object) null);
                            ECBaseUploader.IUploaderListener uploadListener3 = ECImageUploader.this.getUploadListener();
                            if (uploadListener3 != null) {
                                uploadListener3.onUploadSucceed(replaceFirst$default);
                            }
                            ECImageUploader.this.j();
                            QLog.d("ECImageUploader", 2, "finish send image,image url=" + fileMsg.fileUrl);
                            ECImageUploader.this.state.getAndSet(State.Ready);
                            return;
                        case 1004:
                            ECBaseUploader.IUploaderListener uploadListener4 = ECImageUploader.this.getUploadListener();
                            if (uploadListener4 != null) {
                                uploadListener4.onUploadCancelled();
                            }
                            TransferRequest transferRequest4 = ECImageUploader.this.transReq;
                            QLog.d("ECImageUploader", 2, "cancel send image, image path: " + (transferRequest4 != null ? transferRequest4.mLocalPath : null));
                            return;
                        case 1005:
                            ECBaseUploader.IUploaderListener uploadListener5 = ECImageUploader.this.getUploadListener();
                            if (uploadListener5 != null) {
                                int i3 = fileMsg.errorCode;
                                TransferRequest transferRequest5 = ECImageUploader.this.transReq;
                                String str2 = transferRequest5 != null ? transferRequest5.mLocalPath : null;
                                uploadListener5.onUploadFailed(i3, "send image error\uff0c image path: " + str2 + ", error: " + fileMsg.errorCode);
                            }
                            ECImageUploader.this.j();
                            TransferRequest transferRequest6 = ECImageUploader.this.transReq;
                            str = transferRequest6 != null ? transferRequest6.mLocalPath : null;
                            QLog.e("ECImageUploader", 2, "send image error\uff0c image path: " + str + ", error: " + fileMsg.errorCode);
                            ECImageUploader.this.state.getAndSet(State.Ready);
                            return;
                        case 1006:
                            TransferRequest transferRequest7 = ECImageUploader.this.transReq;
                            QLog.d("ECImageUploader", 2, "pause send image, image path: " + (transferRequest7 != null ? transferRequest7.mLocalPath : null));
                            ECBaseUploader.IUploaderListener uploadListener6 = ECImageUploader.this.getUploadListener();
                            if (uploadListener6 != null) {
                                uploadListener6.onPauseSucceed();
                                return;
                            }
                            return;
                        case 1007:
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECImageUploader(QQAppInterface app, String filePath, String scene) {
        super(filePath, scene);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.app = app;
        this.state = new AtomicReference<>(State.Ready);
        b bVar = new b();
        bVar.addFilter(BDHCommonUploadProcessor.class);
        this.imageTransProcessorHandler = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        IRuntimeService runtimeService = this.app.getRuntimeService(ITransFileController.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ler::class.java\n        )");
        ((ITransFileController) runtimeService).removeHandle(this.imageTransProcessorHandler);
    }

    @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader
    public void a() {
        AtomicReference<State> atomicReference = this.state;
        State state = State.Ready;
        if (c.a(atomicReference, state, state)) {
            return;
        }
        QLog.d("ECImageUploader", 2, "cancel send image");
        IRuntimeService runtimeService = this.app.getRuntimeService(ITransFileController.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026leController::class.java)");
        ITransFileController iTransFileController = (ITransFileController) runtimeService;
        TransferRequest transferRequest = this.transReq;
        if (transferRequest != null) {
            iTransFileController.stop(transferRequest);
        }
        j();
        this.state.getAndSet(state);
    }

    @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader
    public void f() {
        int lastIndexOf$default;
        String str;
        if (c.a(this.state, State.Ready, State.Running)) {
            IRuntimeService runtimeService = this.app.getRuntimeService(ITransFileController.class);
            ITransFileController iTransFileController = (ITransFileController) runtimeService;
            iTransFileController.addHandle(this.imageTransProcessorHandler);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ocessorHandler)\n        }");
            TransferRequest transferRequest = new TransferRequest();
            transferRequest.mIsUp = true;
            transferRequest.mCommandId = 2006;
            transferRequest.mLocalPath = getFilePath();
            transferRequest.mUniseq = System.currentTimeMillis() + ((long) (Math.random() * 10000));
            transferRequest.mPeerUin = "0";
            transferRequest.mSelfUin = this.app.getCurrentUin();
            transferRequest.mFileType = 24;
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) getFilePath(), ".", 0, false, 6, (Object) null);
            Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
            commFileExtReq.uint32_action_type.set(0);
            if (getScene().length() == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                String substring = getFilePath().substring(lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                str = "app/ecommerce_" + currentTimeMillis + substring;
            } else {
                String scene = getScene();
                long currentTimeMillis2 = System.currentTimeMillis();
                String substring2 = getFilePath().substring(lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                str = "app/" + scene + "/ecommerce_" + currentTimeMillis2 + substring2;
            }
            commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
            transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
            this.transReq = transferRequest;
            iTransFileController.transferAsync(transferRequest);
            String filePath = getFilePath();
            TransferRequest transferRequest2 = this.transReq;
            QLog.i("ECImageUploader", 1, "upload, path=" + filePath + ",uniSeq=" + (transferRequest2 != null ? Long.valueOf(transferRequest2.mUniseq) : null));
        }
    }
}
