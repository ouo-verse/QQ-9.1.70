package com.tencent.mobileqq.flashtransfer.jump;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.flashtransfer.jump.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.q;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.FileSet;
import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleStatus;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/jump/d;", "Lcom/tencent/mobileqq/utils/ax;", "", "J", "", "errCode", "", "N", "L", "", "filesetId", "clickPos", "M", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/jump/d$a;", "", "", "ACTION_AIO_BUBBLE", "Ljava/lang/String;", "ACTION_OPEN_FILESET", "ATTR_FILESET_ID", "ATTR_SCENE_TYPE", "ATTR_STATUS", "TAG", "<init>", "()V", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flashtransfer.jump.d$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/flashtransfer/jump/d$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetCallback;", "", "seq", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSet;", "fileSet", "", QAdRewardDefine$VideoParams.ISCACHE, "", "onGetFileSet", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IFlashTransferServiceGetFileSetCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f209978a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f209979b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f209980c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f209981d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/flashtransfer/jump/d$b$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDeviceStatusCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusRsp;", "rsp", "", "onCheckDeviceStatus", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class a implements IFlashTransferCheckDeviceStatusCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f209982a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f209983b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f209984c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f209985d;

            a(q qVar, String str, int i3, d dVar) {
                this.f209982a = qVar;
                this.f209983b = str;
                this.f209984c = i3;
                this.f209985d = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, qVar, str, Integer.valueOf(i3), dVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(d this$0, int i3, String str) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                QLog.i("FlashTransferJumpAction", 1, "doAIOBubbleAction end. code: " + i3 + " msg: " + str);
                if (i3 != 0) {
                    this$0.N(i3);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback
            public void onCheckDeviceStatus(@NotNull CheckDeviceStatusRsp rsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                    return;
                }
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                if (rsp.invalidStatus.isEmpty()) {
                    q qVar = this.f209982a;
                    String str = this.f209983b;
                    int i3 = this.f209984c;
                    final d dVar = this.f209985d;
                    qVar.doAIOFlashTransferBubbleActionWithStatus(str, i3, new IOperateCallback() { // from class: com.tencent.mobileqq.flashtransfer.jump.e
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i16, String str2) {
                            d.b.a.b(d.this, i16, str2);
                        }
                    });
                    return;
                }
                QLog.e("FlashTransferJumpAction", 1, "doAIOBubbleAction failed.");
            }
        }

        b(q qVar, String str, int i3, d dVar) {
            this.f209978a = qVar;
            this.f209979b = str;
            this.f209980c = i3;
            this.f209981d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qVar, str, Integer.valueOf(i3), dVar);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback
        public void onGetFileSet(int seq, int result, @Nullable String errMsg, @Nullable FileSet fileSet, boolean isCache) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(seq), Integer.valueOf(result), errMsg, fileSet, Boolean.valueOf(isCache));
                return;
            }
            QLog.i("FlashTransferJumpAction", 1, "doAIOBubbleAction. onGetFileSet. result: " + result + ", errMsg: " + errMsg + ", isCache: " + isCache + '.');
            if (result == 0 && fileSet != null && isCache) {
                CheckDeviceStatusReq checkDeviceStatusReq = new CheckDeviceStatusReq();
                checkDeviceStatusReq.seq = 0;
                checkDeviceStatusReq.isDownload = true;
                checkDeviceStatusReq.totalDownloadSize = fileSet.totalFileSize;
                ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).checkDeviceStatus(checkDeviceStatusReq, new a(this.f209978a, this.f209979b, this.f209980c, this.f209981d));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean J() {
        Integer intOrNull;
        AppRuntime peekAppRuntime;
        String str = this.f307441f.get("status");
        if (str == null || intOrNull == null) {
            return false;
        }
        int intValue = intOrNull.intValue();
        String str2 = this.f307441f.get("fileset_id");
        if (str2 == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026ava, ProcessConstant.ALL)");
        q flashTransferService = ((IKernelService) runtimeService).getFlashTransferService();
        if (flashTransferService == null) {
            return false;
        }
        M(str2, 2);
        QLog.i("FlashTransferJumpAction", 1, "doAIOBubbleAction start. id: " + str2 + " status: " + intValue);
        if (intValue == FileSetSimpleStatus.KDOWNLOADING.ordinal()) {
            flashTransferService.doAIOFlashTransferBubbleActionWithStatus(str2, intValue, new IOperateCallback() { // from class: com.tencent.mobileqq.flashtransfer.jump.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str3) {
                    d.K(i3, str3);
                }
            });
        } else {
            flashTransferService.f(0, str2, true, true, new b(flashTransferService, str2, intValue, this));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(int i3, String str) {
        QLog.i("FlashTransferJumpAction", 1, "doAIOBubbleAction end. code: " + i3 + " msg: " + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean L() {
        String substringAfter$default;
        Integer intOrNull;
        int i3 = 0;
        if (((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).isDisabledAioMsgOpen()) {
            QQToast.makeText(this.f307437b, R.string.f1350500e, 0).show();
            return true;
        }
        String str = this.f307441f.get("fileset_id");
        if (str == null) {
            return false;
        }
        String str2 = this.f307441f.get(VRReportDefine$ReportParam.SCENE_TYPE);
        if (str2 != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        }
        String source = this.f307438c;
        Intrinsics.checkNotNullExpressionValue(source, "source");
        substringAfter$default = StringsKt__StringsKt.substringAfter$default(source, "open_fileset?", (String) null, 2, (Object) null);
        if (!TextUtils.isEmpty(substringAfter$default)) {
            substringAfter$default = Typography.amp + substringAfter$default;
        }
        String downloadActivityScheme = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getDownloadActivityScheme(str, i3, 2, substringAfter$default);
        IQQKuiklyRouter iQQKuiklyRouter = (IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class);
        Context context = this.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iQQKuiklyRouter.jump(context, downloadActivityScheme);
        M(str, 1);
        return true;
    }

    private final void M(String filesetId, int clickPos) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_pgid", "pg_aio");
        hashMap.put("qq_eid", "em_bas_flash_card_message");
        hashMap.put("file_set_id", filesetId);
        hashMap.put("click_pos", Integer.valueOf(clickPos));
        VideoReport.reportEvent("qq_clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(int errCode) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = R.string.f1350900i;
        if (errCode == 1001000) {
            intRef.element = R.string.f1351100k;
        } else if (errCode != 1001001 && errCode != 1001003) {
            if (errCode == 1001002) {
                intRef.element = R.string.f1351200l;
            }
        } else {
            intRef.element = R.string.f1351000j;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.jump.b
            @Override // java.lang.Runnable
            public final void run() {
                d.O(Ref.IntRef.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Ref.IntRef resId) {
        Intrinsics.checkNotNullParameter(resId, "$resId");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, HardCodeUtil.qqStr(resId.element), (String) null, HardCodeUtil.qqStr(R.string.f1351400n), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.jump.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    d.P(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026\n                }, null)");
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (Intrinsics.areEqual("aio_bubble_action", this.f307440e)) {
            return J();
        }
        if (Intrinsics.areEqual("open_fileset", this.f307440e)) {
            return L();
        }
        return false;
    }
}
