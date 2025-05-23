package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a`\u001bH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/f;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendVerifyDlgEvent;", "", "contentText", "leftBtnText", "rightBtnText", "h5Url", "miniAppUrl", "", "la", "errorStr", "oa", "msg", "ia", "ha", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/app/Dialog;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/app/Dialog;", "mTipsDlg", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f;", "mAddFriendSendViewModel", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends v implements SimpleEventReceiver<AddFriendVerifyDlgEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Dialog mTipsDlg;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f mAddFriendSendViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.f$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22597);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ha() {
        Window window;
        Dialog dialog = this.mTipsDlg;
        boolean z16 = false;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        }
        if (z16) {
            Dialog dialog2 = this.mTipsDlg;
            if (dialog2 != null) {
                window = dialog2.getWindow();
            } else {
                window = null;
            }
            if (window != null) {
                try {
                    Dialog dialog3 = this.mTipsDlg;
                    if (dialog3 != null) {
                        dialog3.dismiss();
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendDialogPart", 2, "closeExistingTipsDlgIfNeeded, tips dialog show failed", th5);
                    }
                }
            }
        }
    }

    private final void ia(final String msg2) {
        if (W9()) {
            return;
        }
        ha();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, msg2, (String) null, HardCodeUtil.qqStr(R.string.cdn), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.ja(f.this, msg2, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        this.mTipsDlg = createCustomDialog;
        if (createCustomDialog != null) {
            try {
                createCustomDialog.show();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendDialogPart", 2, "showErrorTipsDlg, tips dialog show failed", th5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(f this$0, String msg2, DialogInterface dialogInterface, int i3) {
        Window window;
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Dialog dialog = this$0.mTipsDlg;
        boolean z16 = false;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        }
        if (z16) {
            Dialog dialog2 = this$0.mTipsDlg;
            if (dialog2 != null) {
                window = dialog2.getWindow();
            } else {
                window = null;
            }
            if (window != null) {
                try {
                    Dialog dialog3 = this$0.mTipsDlg;
                    if (dialog3 != null) {
                        dialog3.dismiss();
                    }
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar2 = this$0.mAddFriendSendViewModel;
                    if (fVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                        fVar = null;
                    } else {
                        fVar = fVar2;
                    }
                    fVar.R1(this$0.L9(), this$0.getIntent(), this$0.getActivity(), -1, msg2);
                } catch (Throwable unused) {
                }
                this$0.mTipsDlg = null;
            }
        }
    }

    private final void la(String contentText, String leftBtnText, String rightBtnText, final String h5Url, final String miniAppUrl) {
        DialogInterface.OnClickListener onClickListener;
        if (W9()) {
            return;
        }
        ha();
        Activity activity = getActivity();
        if (TextUtils.isEmpty(rightBtnText)) {
            onClickListener = null;
        } else {
            onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    f.ma(miniAppUrl, this, h5Url, dialogInterface, i3);
                }
            };
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, contentText, leftBtnText, rightBtnText, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.na(dialogInterface, i3);
            }
        });
        this.mTipsDlg = createCustomDialog;
        if (createCustomDialog != null) {
            try {
                createCustomDialog.show();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendDialogPart", 2, "showErrorTipsDialogWithHandleAbility, tips dialog show failed", th5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(String miniAppUrl, f this$0, String h5Url, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(miniAppUrl, "$miniAppUrl");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(h5Url, "$h5Url");
        try {
            if (!TextUtils.isEmpty(miniAppUrl)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this$0.getContext(), miniAppUrl, 4018, null);
            } else if (!TextUtils.isEmpty(h5Url)) {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(h5Url));
                intent.putExtra("url", h5Url);
                RouteUtils.startActivity(this$0.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
            } else {
                QLog.e("AddFriendDialogPart", 1, "showErrorTipsDialogWithHandleAbility, error: url is empty");
            }
        } catch (Exception e16) {
            QLog.e("AddFriendDialogPart", 1, "showErrorTipsDialogWithHandleAbility, jump H5/MiniApp error: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void oa(String errorStr) {
        ReportController.o(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendDialogPart", 2, "showSecurityTipsDialog errorStr = " + errorStr);
        }
        ha();
        Activity activity = getActivity();
        String string = getActivity().getString(R.string.f224826jz);
        if (TextUtils.isEmpty(errorStr)) {
            errorStr = getString(R.string.f224796jw);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, string, errorStr, R.string.f224806jx, R.string.f224816jy, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.pa(f.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.qa(f.this, dialogInterface, i3);
            }
        });
        this.mTipsDlg = createCustomDialog;
        if (createCustomDialog != null) {
            try {
                createCustomDialog.show();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendDialogPart", 2, "showSecurityTipsDialog, tips dialog show failed", th5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(f this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.o(null, "dc00898", "", "", "0X800B993", "0X800B993", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("jumpUrl: mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("&uin=%s", Arrays.copyOf(new Object[]{this$0.D9()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb5.append(format);
            QLog.i("AddFriendDialogPart", 2, sb5.toString());
        }
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        Activity activity = this$0.getActivity();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("&uin=%s", Arrays.copyOf(new Object[]{this$0.D9()}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        sb6.append(format2);
        iMiniAppService.startMiniApp(activity, sb6.toString(), 2017, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(f this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.o(null, "dc00898", "", "", "0X800B992", "0X800B992", 0, 0, "", "", "", "");
        Dialog dialog = this$0.mTipsDlg;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<AddFriendVerifyDlgEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<Class<AddFriendVerifyDlgEvent>> arrayList = new ArrayList<>();
        arrayList.add(AddFriendVerifyDlgEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(AddFriendSendViewModel::class.java)");
        this.mAddFriendSendViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f) viewModel;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof AddFriendVerifyDlgEvent) {
            AddFriendVerifyDlgEvent addFriendVerifyDlgEvent = (AddFriendVerifyDlgEvent) event;
            int eventId = addFriendVerifyDlgEvent.getEventId();
            if (eventId != 1) {
                if (eventId != 2) {
                    if (eventId != 3) {
                        if (eventId == 4) {
                            QLog.i("AddFriendDialogPart", 1, "receive CLOSE_DLG");
                            ha();
                            return;
                        }
                        return;
                    }
                    String errorTips = addFriendVerifyDlgEvent.getErrorTips();
                    if (errorTips != null) {
                        QLog.i("AddFriendDialogPart", 1, "receive SHOW_ERROR_TIPS params: " + errorTips);
                        ia(errorTips);
                        return;
                    }
                    return;
                }
                String securityTips = addFriendVerifyDlgEvent.getSecurityTips();
                if (securityTips != null) {
                    QLog.i("AddFriendDialogPart", 1, "receive SHOW_SEC_TIPS params: " + securityTips);
                    oa(securityTips);
                    return;
                }
                return;
            }
            x showErrorTipsParamsWithHandleAbility = addFriendVerifyDlgEvent.getShowErrorTipsParamsWithHandleAbility();
            if (showErrorTipsParamsWithHandleAbility != null) {
                QLog.i("AddFriendDialogPart", 1, "receive SHOW_ERROR_TIPS_WITH_HANDLER_ABILITY params: " + showErrorTipsParamsWithHandleAbility);
                la(showErrorTipsParamsWithHandleAbility.a(), showErrorTipsParamsWithHandleAbility.c(), showErrorTipsParamsWithHandleAbility.e(), showErrorTipsParamsWithHandleAbility.b(), showErrorTipsParamsWithHandleAbility.d());
                return;
            }
            return;
        }
        QLog.i("AddFriendDialogPart", 1, "receive error type event");
    }
}
