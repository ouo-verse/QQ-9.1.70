package com.tencent.mobileqq.zplan.avatar.api.impl;

import android.os.Looper;
import android.os.Message;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.zplan.avatar.ZPlanEditAvatarEntranceScene;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarUploadService;
import com.tencent.mobileqq.zplan.avatar.b;
import com.tencent.mobileqq.zplan.avatar.report.ZPlanAvatarEditDaTongReport;
import com.tencent.mobileqq.zplan.avatar.upload.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u000201B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JT\u0010\u0018\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010!R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u0016\u0010\u0015\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R*\u0010%\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0017\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanAvatarUploadServiceImpl;", "Lcom/tencent/mobileqq/zplan/avatar/api/IZPlanAvatarUploadService;", "Lcom/tencent/mobileqq/transfile/FileMsg;", "fileMsg", "", "handleUploadFinished", "doHandleUploadFinish", "", "isSuccess", "callback", "", "uin", "updateHistoryHeadNumFlag", "updateUserAvatarType", "notifyCardHandler", "handleUploadError", "staticFilePath", "outboundFilePath", "", "bgId", "bgUrl", "clipPercent", "configId", "Lkotlin/Function1;", "requestUploadAvatar", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "mIsUploading", "Z", "tempSuccessTime", "I", "Ljava/lang/String;", "", "B", "Ljava/lang/ref/SoftReference;", "callbackRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mobileqq/zplan/avatar/report/ZPlanAvatarEditDaTongReport;", "reporter", "Lcom/tencent/mobileqq/zplan/avatar/report/ZPlanAvatarEditDaTongReport;", "Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanAvatarUploadServiceImpl$a;", "mUploadHandler", "Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanAvatarUploadServiceImpl$a;", "<init>", "()V", "Companion", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarUploadServiceImpl implements IZPlanAvatarUploadService {
    private static final String TAG = "ZPlanAvatarUploadServiceImpl";
    private int bgId;
    private String bgUrl;
    private SoftReference<Function1<Boolean, Unit>> callbackRef;
    private String configId;
    private volatile boolean mIsUploading;
    private String outboundFilePath;
    private String staticFilePath;
    private int tempSuccessTime;
    private byte clipPercent = 25;
    private final ZPlanAvatarEditDaTongReport reporter = new ZPlanAvatarEditDaTongReport();
    private final a mUploadHandler = new a(ThreadManagerV2.getQQCommonThreadLooper(), this);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanAvatarUploadServiceImpl$a;", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanAvatarUploadServiceImpl;", "a", "Lmqq/util/WeakReference;", "managerRef", "Landroid/os/Looper;", "looper", "manager", "<init>", "(Landroid/os/Looper;Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanAvatarUploadServiceImpl;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class a extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanAvatarUploadServiceImpl> managerRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, ZPlanAvatarUploadServiceImpl manager) {
            super(looper);
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.managerRef = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ZPlanAvatarUploadServiceImpl zPlanAvatarUploadServiceImpl = this.managerRef.get();
            if (zPlanAvatarUploadServiceImpl != null) {
                if (zPlanAvatarUploadServiceImpl.mIsUploading) {
                    Object obj = msg2.obj;
                    if (!(obj instanceof FileMsg)) {
                        QLog.e(ZPlanAvatarUploadServiceImpl.TAG, 1, "msg.obj type error");
                        return;
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
                    FileMsg fileMsg = (FileMsg) obj;
                    int i3 = msg2.what;
                    if (i3 == 1003) {
                        zPlanAvatarUploadServiceImpl.handleUploadFinished(fileMsg);
                        return;
                    } else {
                        if (i3 != 1005) {
                            return;
                        }
                        zPlanAvatarUploadServiceImpl.handleUploadError(fileMsg);
                        return;
                    }
                }
                return;
            }
            QLog.e(ZPlanAvatarUploadServiceImpl.TAG, 1, "manager is null");
        }
    }

    private final void callback(boolean isSuccess) {
        SoftReference<Function1<Boolean, Unit>> softReference = this.callbackRef;
        Function1<Boolean, Unit> function1 = softReference != null ? softReference.get() : null;
        if (function1 == null) {
            QLog.e(TAG, 1, "doHandleUploadFinish callback is null");
        } else {
            function1.invoke(Boolean.valueOf(isSuccess));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadFinished(FileMsg fileMsg) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("handleUploadFinished, errorCode=%s, filePath= %s", Arrays.copyOf(new Object[]{Integer.valueOf(fileMsg.errorCode), fileMsg}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d(TAG, 1, format);
        int i3 = this.tempSuccessTime + 1;
        this.tempSuccessTime = i3;
        QLog.i(TAG, 1, "handleUploadFinished success Time: " + i3);
        if (this.tempSuccessTime == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface == null) {
                QLog.e(TAG, 1, "handleUploadFinished error " + appInterface + ", " + this.bgId + ", " + ((int) this.clipPercent));
                return;
            }
            com.tencent.mobileqq.zplan.avatar.upload.a aVar = com.tencent.mobileqq.zplan.avatar.upload.a.f331975a;
            ProfileCardUtil.a b16 = aVar.b(appInterface, this.staticFilePath, false);
            if (b16.f306430a == 0 && Intrinsics.areEqual(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, b16.f306431b)) {
                int i16 = this.bgId;
                byte b17 = this.clipPercent;
                QLog.i(TAG, 1, "startUpload: outbounds: [" + i16 + "," + ((int) b17) + "]" + this.staticFilePath);
                if (this.bgId <= 0) {
                    this.bgId = 1;
                }
                byte b18 = this.clipPercent;
                if (b18 > 100 || b18 < 0) {
                    this.clipPercent = (byte) 25;
                }
                aVar.e(appInterface, this.outboundFilePath, 22, false, false, new a.ZplanAvatarInfo((byte) 2, this.bgId, this.clipPercent));
            }
        }
        if (this.tempSuccessTime == 2) {
            doHandleUploadFinish();
        }
    }

    private final void notifyCardHandler(String uin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        BaseBusinessHandler businessHandler = appInterface != null ? appInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER) : null;
        CardHandler cardHandler = businessHandler instanceof CardHandler ? (CardHandler) businessHandler : null;
        if (cardHandler != null) {
            try {
                cardHandler.z5(true, uin, 0);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "notifyCardHandler exception :" + e16);
            }
        }
    }

    private final void updateHistoryHeadNumFlag(String uin) {
        AvatarHistoryNumProcessor avatarHistoryNumProcessor;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (ea.h0(peekAppRuntime.getApp(), uin) == 2 || (avatarHistoryNumProcessor = (AvatarHistoryNumProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(AvatarHistoryNumProcessor.class, peekAppRuntime)) == null) {
            return;
        }
        avatarHistoryNumProcessor.a();
    }

    private final void updateUserAvatarType(String uin) {
        Object value = ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(uin, INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) (-1));
        Integer num = value instanceof Integer ? (Integer) value : null;
        if (num != null && num.intValue() == 1) {
            return;
        }
        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(uin, INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) 1);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        ((ITransFileController) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITransFileController.class, "all")).addHandle(this.mUploadHandler);
        this.mUploadHandler.addFilter(NearbyPeoplePhotoUploadProcessor.class);
    }

    private final void doHandleUploadFinish() {
        this.mIsUploading = false;
        FaceUtil.setUploadZplanFinish(true);
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        notifyCardHandler(currentAccountUin);
        updateUserAvatarType(currentAccountUin);
        updateHistoryHeadNumFlag(currentAccountUin);
        FaceUtil.setTempAvatarFilePath(null);
        this.tempSuccessTime = 0;
        QLog.i(TAG, 1, "upload avatar success");
        callback(true);
        this.reporter.k(new b.AvatarRenewReportParam(this.configId, this.bgUrl, String.valueOf((int) this.clipPercent), ZPlanEditAvatarEntranceScene.REGISTER.getSourceString(), null, null, 48, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadError(FileMsg fileMsg) {
        this.mIsUploading = false;
        FaceUtil.setUploadZplanFinish(false);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("handleUploadError, errorCode=%s", Arrays.copyOf(new Object[]{Integer.valueOf(fileMsg.errorCode)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.e(TAG, 1, format);
        callback(false);
        this.reporter.j(new b.AvatarRenewReportParam(this.configId, this.bgUrl, String.valueOf((int) this.clipPercent), ZPlanEditAvatarEntranceScene.REGISTER.getSourceString(), null, "3", 16, null));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "try remove upload handler.");
        ((ITransFileController) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITransFileController.class, "all")).removeHandle(this.mUploadHandler);
        FaceUtil.setTempAvatarFilePath(null);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarUploadService
    public void requestUploadAvatar(String staticFilePath, String outboundFilePath, int bgId, String bgUrl, int clipPercent, String configId, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "requestUploadAvatar");
        this.mIsUploading = true;
        this.outboundFilePath = outboundFilePath;
        this.staticFilePath = staticFilePath;
        this.bgId = bgId;
        this.bgUrl = bgUrl;
        this.configId = configId;
        this.clipPercent = (byte) clipPercent;
        this.callbackRef = new SoftReference<>(callback);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        com.tencent.mobileqq.zplan.avatar.upload.a.f331975a.e(appInterface, staticFilePath, 22, false, false, new a.ZplanAvatarInfo((byte) 1, bgId, this.clipPercent));
    }
}
