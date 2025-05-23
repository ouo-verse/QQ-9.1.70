package com.tencent.mobileqq.zootopia.redpacket.ui;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00040\u000fJ:\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u000fJ\b\u0010\u001a\u001a\u00020\u0004H\u0014R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010#R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketRepository;", "Lcom/tencent/mobileqq/mvvm/a;", "Lcom/tencent/mobileqq/transfile/FileMsg;", "file", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "Lmqq/app/AppRuntime;", "appRuntime", "", "localPath", "uploadName", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "o", "Lkotlin/Function1;", "Ltu4/c;", "callback", "p", "localApngPath", "localPngPath", "", "redPacketId", "", "avatarId", "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/zootopia/service/api/impl/b;", "a", "Lcom/tencent/mobileqq/zootopia/service/api/impl/b;", "service", "b", "Lkotlin/jvm/functions/Function1;", "uploadCallback", "c", "I", "curRedPacketId", "d", "J", "curAvatarId", "e", "uploadCount", "f", "apngSeq", "g", "pngSeq", tl.h.F, "Ljava/lang/String;", "apngMD5", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "i", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "getHandler", "()Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "handler", "<init>", "()V", "j", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RedPacketRepository extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Integer, Unit> uploadCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int curRedPacketId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long curAvatarId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int uploadCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long apngSeq;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long pngSeq;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.service.api.impl.b service = new com.tencent.mobileqq.zootopia.service.api.impl.b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String apngMD5 = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TransProcessorHandler handler = new b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/redpacket/ui/RedPacketRepository$b", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends TransProcessorHandler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Object obj = msg2.obj;
            FileMsg fileMsg = obj instanceof FileMsg ? (FileMsg) obj : null;
            if (fileMsg == null) {
                return;
            }
            int i3 = msg2.what;
            if (i3 == 1003 || i3 == 1008) {
                if (fileMsg.uniseq == RedPacketRepository.this.apngSeq) {
                    RedPacketRepository.this.q(fileMsg);
                    return;
                } else {
                    if (fileMsg.uniseq == RedPacketRepository.this.pngSeq) {
                        RedPacketRepository.this.r();
                        return;
                    }
                    return;
                }
            }
            if (i3 == 1005) {
                Function1 function1 = RedPacketRepository.this.uploadCallback;
                if (function1 != null) {
                    function1.invoke(-1);
                }
                QLog.e("RedPacketRepository", 1, "upload send error");
            }
        }
    }

    private final TransferRequest o(AppRuntime appRuntime, String localPath, String uploadName) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = localPath;
        transferRequest.mCommandId = 92;
        transferRequest.mPeerUin = "0";
        transferRequest.mFileType = 24;
        transferRequest.mSelfUin = appRuntime.getCurrentUin();
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(uploadName));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        return transferRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(FileMsg file) {
        Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
        try {
            byte[] bArr = file.bdhExtendInfo;
            uploadPicExtInfo.mergeFrom(bArr, 0, bArr.length);
            QLog.i("RedPacketRepository", 1, "upload apng success " + uploadPicExtInfo.bytes_download_url.get().toStringUtf8());
            String str = file.fileMd5;
            Intrinsics.checkNotNullExpressionValue(str, "file.fileMd5");
            this.apngMD5 = str;
            this.uploadCount++;
            s();
        } catch (Exception e16) {
            Function1<? super Integer, Unit> function1 = this.uploadCallback;
            if (function1 != null) {
                function1.invoke(-1);
            }
            QLog.e("RedPacketRepository", 2, "upload apng parse failed ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        QLog.i("RedPacketRepository", 1, "upload png success");
        this.uploadCount++;
        s();
    }

    private final void s() {
        if (this.uploadCount != 2) {
            return;
        }
        this.service.b(this.apngMD5, this.curRedPacketId, this.curAvatarId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.RedPacketRepository$tryBind$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    Function1 function1 = RedPacketRepository.this.uploadCallback;
                    if (function1 != null) {
                        function1.invoke(0);
                        return;
                    }
                    return;
                }
                Function1 function12 = RedPacketRepository.this.uploadCallback;
                if (function12 != null) {
                    function12.invoke(-2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.a
    public void onDestroy() {
        super.onDestroy();
        this.uploadCallback = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            QLog.e("RedPacketRepository", 1, "onDestroy but appRunTime is null");
            return;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(ITransFileController.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((ITransFileController) runtimeService).removeHandle(this.handler);
    }

    public final void p(Function1<? super tu4.c, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.a(callback);
    }

    public final void t(String localApngPath, String localPngPath, int redPacketId, long avatarId, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(localApngPath, "localApngPath");
        Intrinsics.checkNotNullParameter(localPngPath, "localPngPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            callback.invoke(-1);
            QLog.e("RedPacketRepository", 1, "uploadPic but appRunTime is null");
            return;
        }
        com.tencent.mobileqq.zootopia.redpacket.j jVar = com.tencent.mobileqq.zootopia.redpacket.j.f329071a;
        String currentUin = appInterface.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "appRuntime.currentUin");
        String d16 = jVar.d(currentUin);
        if (TextUtils.isEmpty(d16)) {
            callback.invoke(-1);
            QLog.e("RedPacketRepository", 1, "usrId is null");
            return;
        }
        this.curAvatarId = avatarId;
        this.curRedPacketId = redPacketId;
        this.uploadCallback = callback;
        this.uploadCount = 0;
        IRuntimeService runtimeService = appInterface.getRuntimeService(ITransFileController.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ITransFileController iTransFileController = (ITransFileController) runtimeService;
        this.handler.addFilter(BDHCommonUploadProcessor.class);
        iTransFileController.addHandle(this.handler);
        Intrinsics.checkNotNull(d16);
        TransferRequest o16 = o(appInterface, localApngPath, jVar.b(d16, redPacketId, avatarId));
        TransferRequest o17 = o(appInterface, localPngPath, jVar.c(d16, redPacketId, avatarId));
        long currentTimeMillis = System.currentTimeMillis();
        this.apngSeq = currentTimeMillis;
        long j3 = 1 + currentTimeMillis;
        this.pngSeq = j3;
        o16.mUniseq = currentTimeMillis;
        o17.mUniseq = j3;
        iTransFileController.transferAsync(o16);
        iTransFileController.transferAsync(o17);
    }
}
