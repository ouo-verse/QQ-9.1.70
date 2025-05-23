package com.tencent.qqnt.qwallet.bigdata;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001\u0017\u0018\u0000 \t2\u00020\u0001:\u0002\f\nB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader;", "", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "c", "", "filePath", "", "reqExtendInfo", "", "e", "b", "Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader$a;", "a", "Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader$a;", "callback", "", "Z", "isHandlerAdded", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "transController", "com/tencent/qqnt/qwallet/bigdata/BigDataUploader$c", "Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader$c;", "handler", "<init>", "(Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader$a;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class BigDataUploader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isHandlerAdded;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy transController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"HandlerLeak"})
    @NotNull
    private c handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader$a;", "", "", "rspExtendInfo", "", "a", "", "errCode", "", "errMsg", "onError", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a(@NotNull byte[] rspExtendInfo);

        void onError(int errCode, @Nullable String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qwallet/bigdata/BigDataUploader$c", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends TransProcessorHandler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            FileMsg fileMsg;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            Object obj = msg2.obj;
            if (obj instanceof FileMsg) {
                fileMsg = (FileMsg) obj;
            } else {
                fileMsg = null;
            }
            if (fileMsg == null || fileMsg.commandId != 3001) {
                return;
            }
            int i3 = msg2.what;
            if (i3 != 1001) {
                if (i3 == 1003) {
                    a aVar = BigDataUploader.this.callback;
                    byte[] bArr = fileMsg.bdhExtendInfo;
                    Intrinsics.checkNotNullExpressionValue(bArr, "fileMsg.bdhExtendInfo");
                    aVar.a(bArr);
                    return;
                }
                if (i3 != 1005) {
                    QLog.d("BigDataUploader", 1, "handleMessage: msg not support " + i3);
                    return;
                }
                BigDataUploader.this.callback.onError(fileMsg.errorCode, fileMsg.errorMessage);
                return;
            }
            QLog.d("BigDataUploader", 1, "handleMessage: start upload");
        }
    }

    public BigDataUploader(@NotNull a callback) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ITransFileController>() { // from class: com.tencent.qqnt.qwallet.bigdata.BigDataUploader$transController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ITransFileController invoke() {
                return (ITransFileController) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITransFileController.class, "");
            }
        });
        this.transController = lazy;
        this.handler = new c(Looper.getMainLooper());
    }

    private final TransferRequest c() {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 3001;
        transferRequest.mRichTag = StatisticCollector.QWALLET_VOICE_HB_REPORT_TAG;
        transferRequest.mIsUp = true;
        transferRequest.mUniseq = System.currentTimeMillis();
        return transferRequest;
    }

    private final ITransFileController d() {
        return (ITransFileController) this.transController.getValue();
    }

    public final void b() {
        QLog.d("BigDataUploader", 1, "clear: ");
        if (this.isHandlerAdded) {
            d().removeHandle(this.handler);
            this.isHandlerAdded = false;
        }
    }

    public final void e(@NotNull String filePath, @NotNull byte[] reqExtendInfo) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(reqExtendInfo, "reqExtendInfo");
        if (!this.isHandlerAdded) {
            this.handler.addFilter(BDHCommonUploadProcessor.class);
            d().addHandle(this.handler);
            this.isHandlerAdded = true;
        }
        TransferRequest c16 = c();
        c16.mLocalPath = filePath;
        c16.mExtentionInfo = reqExtendInfo;
        d().transferAsync(c16);
    }
}
