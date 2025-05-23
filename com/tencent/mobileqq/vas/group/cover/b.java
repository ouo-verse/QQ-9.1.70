package com.tencent.mobileqq.vas.group.cover;

import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u0010\u0018\u0000 \f2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014JF\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000226\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004J\u0006\u0010\r\u001a\u00020\nRH\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/group/cover/b;", "", "", "localPath", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "url", "", "callback", "c", "b", "a", "Lkotlin/jvm/functions/Function2;", "com/tencent/mobileqq/vas/group/cover/b$b", "Lcom/tencent/mobileqq/vas/group/cover/b$b;", "handler", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function2<? super Integer, ? super String, Unit> callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HandlerC8909b handler = new HandlerC8909b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/group/cover/b$b", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.group.cover.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class HandlerC8909b extends TransProcessorHandler {
        HandlerC8909b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            String replaceFirst$default;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Object obj = msg2.obj;
            FileMsg fileMsg = obj instanceof FileMsg ? (FileMsg) obj : null;
            if (fileMsg == null) {
                Function2 function2 = b.this.callback;
                if (function2 != null) {
                    function2.invoke(-1, "");
                }
                QLog.e("CoverUploadUtil", 1, "upload file == null");
                return;
            }
            int i3 = msg2.what;
            if (i3 != 1003 && i3 != 1008) {
                if (i3 == 1005) {
                    Function2 function22 = b.this.callback;
                    if (function22 != null) {
                        function22.invoke(-1, "");
                    }
                    QLog.e("CoverUploadUtil", 1, "upload send error");
                    return;
                }
                return;
            }
            Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
            byte[] bArr = fileMsg.bdhExtendInfo;
            uploadPicExtInfo.mergeFrom(bArr, 0, bArr.length);
            String picUrl = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
            String old = new URL(picUrl).getHost();
            Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
            Intrinsics.checkNotNullExpressionValue(old, "old");
            replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(picUrl, old, "img.meta.qq.com", false, 4, (Object) null);
            Function2 function23 = b.this.callback;
            if (function23 != null) {
                function23.invoke(0, replaceFirst$default);
            }
        }
    }

    public final void b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITransFileController.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ssConstant.MAIN\n        )");
        ((ITransFileController) runtimeService).removeHandle(this.handler);
    }

    public final void c(String localPath, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("CoverUploadUtil", 1, "upload appRuntime is null");
            callback.invoke(-1, "");
            return;
        }
        this.callback = callback;
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITransFileController.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ssConstant.MAIN\n        )");
        ITransFileController iTransFileController = (ITransFileController) runtimeService;
        this.handler.addFilter(BDHCommonUploadProcessor.class);
        iTransFileController.addHandle(this.handler);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = localPath;
        transferRequest.mCommandId = 2001;
        transferRequest.mPeerUin = "0";
        transferRequest.mFileType = 24;
        transferRequest.mSelfUin = peekAppRuntime.getCurrentUin();
        transferRequest.mUniseq = System.currentTimeMillis();
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8("smallHomeBg/" + peekAppRuntime.getAccount() + "/" + System.currentTimeMillis()));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        iTransFileController.transferAsync(transferRequest);
    }
}
