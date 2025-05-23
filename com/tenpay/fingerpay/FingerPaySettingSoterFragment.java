package com.tenpay.fingerpay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.soter.core.SoterCore;
import com.tenpay.ErrorCode;
import com.tenpay.api.QFuncProxy;
import com.tenpay.bank.BindBankModule;
import com.tenpay.fingerpay.soter.SoterManager;
import com.tenpay.fingerpay.soter.SoterPrepareCallback;
import com.tenpay.impl.ApiFingerImpl;
import com.tenpay.proxy.QQProxyDialog;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.util.QWSoterConstans;
import cooperation.qwallet.plugin.FakeUrl;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 C2\u00020\u0001:\u0001CB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0014J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u001c\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010.\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\u0018\u00102\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020\u0018H\u0002J\u0010\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020\u0018H\u0002J\b\u0010;\u001a\u00020\u0018H\u0002J\b\u0010<\u001a\u00020\u0018H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\b\u0010>\u001a\u00020\u0018H\u0002J\b\u0010?\u001a\u00020\u0018H\u0002J\b\u0010@\u001a\u00020\u0018H\u0002J\u0010\u0010A\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0006H\u0002J\b\u0010B\u001a\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tenpay/fingerpay/FingerPaySettingSoterFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "detectDialog", "Lcom/tenpay/proxy/QQProxyDialog;", "isNeedShowProgressDialog", "", "isPreOpenFailed", "payTypeName", "", "preOpenFailNotice", "settingViewModel", "Lcom/tenpay/fingerpay/FingerPaySettingViewModel;", "getSettingViewModel", "()Lcom/tenpay/fingerpay/FingerPaySettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "soterAuthBtn", "Landroid/widget/Button;", "soterAuthImage", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "dismissDetectDialog", "", "fingerPayPreOpenRequest", "gotoAuthFragment", "isStatusBarImmersive", "onBackEvent", "onBlError", BrowserPlugin.KEY_REQUEST_URL, "data", "Lorg/json/JSONObject;", "onBlHandleFakeurl", "fakeInfo", "Lcooperation/qwallet/plugin/FakeUrl$FakeInfo;", "bntIndex", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onNetDlgokClick", "onOpenFingerPayCancel", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onSuccess", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "performFingerPrintAuthentication", "isRetry", "prepareAuthKey", "setDetectDialogImg", "resId", "showAuthorizeFailed", "showAuthorizeRetry", "showDetectDialog", "showFingerExceedTimes", "showGotoBindCardDialog", "showNoSysFpNoticeDialog", "showPreOpenFailNoticeDialog", "startFingerprintAuthentication", "startToOpenFingerPay", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FingerPaySettingSoterFragment extends NetBaseActivity {

    @NotNull
    public static final String FROM_FINGER_PAY_SETTING = "from_finger_pay_setting";

    @Nullable
    private QQProxyDialog detectDialog;
    private boolean isNeedShowProgressDialog;
    private boolean isPreOpenFailed;

    @Nullable
    private String preOpenFailNotice;
    private Button soterAuthBtn;
    private ImageView soterAuthImage;
    private TextView title;

    @NotNull
    private String payTypeName = "";

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy settingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FingerPaySettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.fingerpay.FingerPaySettingSoterFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.fingerpay.FingerPaySettingSoterFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissDetectDialog() {
        try {
            getSettingViewModel().releaseFp();
            QQProxyDialog qQProxyDialog = this.detectDialog;
            if (qQProxyDialog != null) {
                if (qQProxyDialog != null) {
                    qQProxyDialog.dismiss();
                }
                this.detectDialog = null;
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private final void fingerPayPreOpenRequest() {
        if (SoterManager.INSTANCE.isSupportSoter()) {
            FingerPaySettingViewModel settingViewModel = getSettingViewModel();
            String deviceId = QFuncProxy.getDeviceId(getContext());
            Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(context)");
            httpRequest(Cgi.URI_Soter_FINGER_PAY_PRE_OPEN, settingViewModel.getPreOpenRequestData(deviceId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FingerPaySettingViewModel getSettingViewModel() {
        return (FingerPaySettingViewModel) this.settingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoAuthFragment() {
        if (isFinishing()) {
            return;
        }
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "parentFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.ve6, new FingerPaySettingAuthFragment());
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    private final void onOpenFingerPayCancel() {
        QLog.i(((NetBaseActivity) this).TAG, 1, "onOpenFingerPayFinish success=false");
        dismissDetectDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(FingerPaySettingSoterFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performFingerPrintAuthentication(boolean isRetry) {
        getSettingViewModel().requestSoterAuthorize(new Companion.FingerPaySettingSoterCallback(new WeakReference(this), isRetry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareAuthKey() {
        showQQPayLoading(0);
        getSettingViewModel().prepareAuthKeyAtSubThread(new SoterPrepareCallback() { // from class: com.tenpay.fingerpay.FingerPaySettingSoterFragment$prepareAuthKey$1
            @Override // com.tenpay.fingerpay.soter.SoterPrepareCallback
            public void onFailed(int errCode) {
                FingerPaySettingViewModel settingViewModel;
                FingerPaySettingViewModel settingViewModel2;
                FingerPaySettingSoterFragment.this.dismissQQPayLoading();
                settingViewModel = FingerPaySettingSoterFragment.this.getSettingViewModel();
                if (settingViewModel.getIsClearAuthKeyByNotBindBank()) {
                    settingViewModel2 = FingerPaySettingSoterFragment.this.getSettingViewModel();
                    settingViewModel2.setClearAuthKeyByNotBindBank(false);
                    return;
                }
                QQToast.makeText(FingerPaySettingSoterFragment.this.getContext(), "[" + errCode + "] " + FingerPaySettingSoterFragment.this.getString(R.string.f171343e74), 0).show();
                FingerPaySettingSoterFragment.this.finish();
            }

            @Override // com.tenpay.fingerpay.soter.SoterPrepareCallback
            public void onSuccess() {
                boolean z16;
                FingerPaySettingSoterFragment.this.dismissQQPayLoading();
                z16 = FingerPaySettingSoterFragment.this.isNeedShowProgressDialog;
                if (z16) {
                    FingerPaySettingSoterFragment.this.performFingerPrintAuthentication(false);
                }
            }
        });
    }

    private final void setDetectDialogImg(int resId) {
        QQProxyDialog qQProxyDialog = this.detectDialog;
        if (qQProxyDialog != null && qQProxyDialog.isShowing() && resId != 0) {
            View findViewById = qQProxyDialog.findViewById(R.id.image);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) findViewById).setImageResource(resId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAuthorizeFailed() {
        dismissDetectDialog();
        QUIProxy.createCustomDialog(getContext(), 230, null, this.payTypeName + "\u652f\u4ed8\u5f00\u901a\u5931\u8d25", null, getString(R.string.ead), new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSoterFragment.showAuthorizeFailed$lambda$11(FingerPaySettingSoterFragment.this, dialogInterface, i3);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAuthorizeFailed$lambda$11(FingerPaySettingSoterFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAuthorizeRetry() {
        setDetectDialogImg(QWSoterConstans.getAuthFailResId(getSettingViewModel().getIntentBusiType()));
        QQProxyDialog qQProxyDialog = this.detectDialog;
        if (qQProxyDialog != null) {
            if (qQProxyDialog != null) {
                qQProxyDialog.setMessage(getString(R.string.iwr));
            }
            QQProxyDialog qQProxyDialog2 = this.detectDialog;
            if (qQProxyDialog2 != null) {
                qQProxyDialog2.playShakeAnim(R.anim.f154873en);
            }
            QQProxyDialog qQProxyDialog3 = this.detectDialog;
            if (qQProxyDialog3 != null) {
                qQProxyDialog3.setPositiveButton(R.string.iws, new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.j
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        FingerPaySettingSoterFragment.showAuthorizeRetry$lambda$10(FingerPaySettingSoterFragment.this, dialogInterface, i3);
                    }
                }, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAuthorizeRetry$lambda$10(FingerPaySettingSoterFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQProxyDialog qQProxyDialog = this$0.detectDialog;
        if (qQProxyDialog != null) {
            qQProxyDialog.setMessage("QQ " + this$0.payTypeName + "\u9a8c\u8bc1");
        }
        this$0.setDetectDialogImg(QWSoterConstans.getAuthResIdByBusiType(this$0.getSettingViewModel().getIntentBusiType()));
        QQProxyDialog qQProxyDialog2 = this$0.detectDialog;
        if (qQProxyDialog2 != null) {
            qQProxyDialog2.setPositiveButton((String) null, (DialogInterface.OnClickListener) null);
        }
        this$0.startFingerprintAuthentication(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDetectDialog() {
        QQProxyDialog qQProxyDialog;
        try {
            if (getContext() != null && !isFinishing()) {
                QQProxyDialog qQProxyDialog2 = this.detectDialog;
                if (qQProxyDialog2 == null) {
                    qQProxyDialog2 = QUIProxy.createCustomDialogWithImage(getContext(), R.layout.ado, R.style.qZoneInputDialog, R.id.image, QWSoterConstans.getAuthResIdByBusiType(getSettingViewModel().getIntentBusiType()), null, "QQ " + this.payTypeName + "\u9a8c\u8bc1", R.string.e5h, 0, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.d
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            FingerPaySettingSoterFragment.showDetectDialog$lambda$7$lambda$5(FingerPaySettingSoterFragment.this, dialogInterface, i3);
                        }
                    });
                    this.detectDialog = qQProxyDialog2;
                    Intrinsics.checkNotNullExpressionValue(qQProxyDialog2, "run {\n                QU\u2026          }\n            }");
                }
                if (!qQProxyDialog2.isShowing() && (qQProxyDialog = this.detectDialog) != null) {
                    qQProxyDialog.show();
                }
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDetectDialog$lambda$7$lambda$5(FingerPaySettingSoterFragment this_run, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.onOpenFingerPayCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFingerExceedTimes() {
        dismissDetectDialog();
        QUIProxy.createCustomDialog(getContext(), 230, null, getString(R.string.e5s), null, getString(R.string.ead), new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSoterFragment.showFingerExceedTimes$lambda$9(FingerPaySettingSoterFragment.this, dialogInterface, i3);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFingerExceedTimes$lambda$9(FingerPaySettingSoterFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGotoBindCardDialog() {
        QUIProxy.createCustomDialog(getContext(), 230, null, "\u8bf7\u5148\u6dfb\u52a0\u94f6\u884c\u5361\uff0c\u4ee5\u7ee7\u7eed\u5f00\u542f" + this.payTypeName + "\u652f\u4ed8", getString(R.string.e5h), getString(R.string.e2g), new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSoterFragment.showGotoBindCardDialog$lambda$1(FingerPaySettingSoterFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSoterFragment.showGotoBindCardDialog$lambda$2(dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGotoBindCardDialog$lambda$1(FingerPaySettingSoterFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, new RealNameSource("3"));
        intent.putExtra(FROM_FINGER_PAY_SETTING, true);
        BindBankModule.INSTANCE.startWithSwitchForResult(this$0, intent, 1002, 9);
    }

    private final void showNoSysFpNoticeDialog() {
        String str = this.payTypeName;
        QUIProxy.createCustomDialog(getContext(), 230, null, "\u8bf7\u5148\u5230\u624b\u673a\u7cfb\u7edf\u4e2d\u6dfb\u52a0" + str + "\uff0c\u518d\u5f00\u542f" + str + "\u652f\u4ed8", getString(R.string.e4i), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSoterFragment.showNoSysFpNoticeDialog$lambda$3(FingerPaySettingSoterFragment.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNoSysFpNoticeDialog$lambda$3(FingerPaySettingSoterFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPreOpenFailNoticeDialog() {
        if (this.preOpenFailNotice == null) {
            return;
        }
        QUIProxy.createCustomDialog(getContext(), 230, null, this.preOpenFailNotice, getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSoterFragment.showPreOpenFailNoticeDialog$lambda$4(dialogInterface, i3);
            }
        });
    }

    private final void startFingerprintAuthentication(boolean isRetry) {
        if (getSettingViewModel().getAuthKeyModel() == null) {
            this.isNeedShowProgressDialog = true;
            prepareAuthKey();
        } else {
            this.isNeedShowProgressDialog = false;
            performFingerPrintAuthentication(isRetry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startToOpenFingerPay() {
        if (SoterManager.INSTANCE.isSupportSoter()) {
            QLog.i(((NetBaseActivity) this).TAG, 1, "\u8c03\u7528\u5fae\u4fe1SDK\u5f00\u542f\u6307\u7eb9\u670d\u52a1");
            if (!SoterCore.isSystemHasBiometric(getContext(), QWSoterConstans.getBiometricType(getSettingViewModel().getIntentBusiType()))) {
                onOpenFingerPayCancel();
                showNoSysFpNoticeDialog();
            } else {
                startFingerprintAuthentication(false);
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        String str = ((NetBaseActivity) this).TAG;
        QLog.i(str, 1, "back from " + str);
        return super.onBackEvent();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        String str;
        super.onBlError(requestUrl, data);
        String str2 = null;
        if (data != null) {
            str = data.optString("retcode");
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(Cgi.URI_Soter_FINGER_PAY_PRE_OPEN, requestUrl)) {
            if (str != null) {
                try {
                    Integer.parseInt(str);
                } catch (Exception e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                    return;
                }
            }
            if (data != null) {
                str2 = data.optString("retmsg");
            }
            this.isPreOpenFailed = true;
            this.preOpenFailNotice = str2;
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(@NotNull FakeUrl.FakeInfo fakeInfo, int bntIndex) {
        Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
        if (bntIndex == 0) {
            return false;
        }
        super.onBlHandleFakeurl(fakeInfo, bntIndex);
        if (!Intrinsics.areEqual(fakeInfo.host, QWalletFakeUrl.FAKEURL_REGENERATEASKEY) && !Intrinsics.areEqual(fakeInfo.host, QWalletFakeUrl.FAKEURL_REGENERATEAUTHKEY)) {
            return false;
        }
        doOnBackPressed();
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fyb, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(@NotNull String requestUrl, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        super.onNetDlgokClick(requestUrl, data);
        String optString = data.optString("retmsg");
        if (28027203 == data.optInt("retcode")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Cgi.RETURN_MSG_JSON_ERROR_KEY, optString);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            setRetCodeAndGetBundle(ErrorCode.ERR_ACCOUNT_DONGJIE).putString(Cgi.RETURN_MSG_KEY, jSONObject.toString());
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        onOpenFingerPayCancel();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@NotNull String requestUrl, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        super.onSuccess(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_Soter_FINGER_PAY_PRE_OPEN)) {
            prepareAuthKey();
            FingerPaySettingViewModel settingViewModel = getSettingViewModel();
            boolean z16 = true;
            if (data.optInt("need_bind_card") == 1) {
                z16 = false;
            }
            settingViewModel.setHasBindBank(z16);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Button button;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String nameByBusiType = QWSoterConstans.getNameByBusiType(getSettingViewModel().getIntentBusiType());
        Intrinsics.checkNotNullExpressionValue(nameByBusiType, "getNameByBusiType(settingViewModel.intentBusiType)");
        this.payTypeName = nameByBusiType;
        View findViewById = view.findViewById(R.id.m9b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.soter_auth_img)");
        this.soterAuthImage = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.m9a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.soter_auth_btn)");
        this.soterAuthBtn = (Button) findViewById2;
        View findViewById3 = view.findViewById(R.id.ivTitleName);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ivTitleName)");
        TextView textView = (TextView) findViewById3;
        this.title = textView;
        Button button2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(this.payTypeName + "\u652f\u4ed8");
        view.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.fingerpay.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FingerPaySettingSoterFragment.onViewCreated$lambda$0(FingerPaySettingSoterFragment.this, view2);
            }
        });
        IQWalletApi iQWalletApi = (IQWalletApi) QRoute.api(IQWalletApi.class);
        Button button3 = this.soterAuthBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soterAuthBtn");
            button3 = null;
        }
        iQWalletApi.setAlphaChangeListener(button3, 0.6f);
        Button button4 = this.soterAuthBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soterAuthBtn");
            button = null;
        } else {
            button = button4;
        }
        com.tencent.mobileqq.qwallet.k.d(button, 0L, new Function0<Unit>() { // from class: com.tenpay.fingerpay.FingerPaySettingSoterFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                FingerPaySettingViewModel settingViewModel;
                FingerPaySettingViewModel settingViewModel2;
                z16 = FingerPaySettingSoterFragment.this.isPreOpenFailed;
                if (z16) {
                    FingerPaySettingSoterFragment.this.showPreOpenFailNoticeDialog();
                    new ApiFingerImpl().closeFingerPay(FingerPaySettingSoterFragment.this.getContext(), FingerPaySettingSoterFragment.this.mUin);
                    return;
                }
                settingViewModel = FingerPaySettingSoterFragment.this.getSettingViewModel();
                if (!settingViewModel.getHasBindBank()) {
                    FingerPaySettingSoterFragment.this.showGotoBindCardDialog();
                    new ApiFingerImpl().closeFingerPay(FingerPaySettingSoterFragment.this.getContext(), FingerPaySettingSoterFragment.this.mUin);
                    settingViewModel2 = FingerPaySettingSoterFragment.this.getSettingViewModel();
                    settingViewModel2.setClearAuthKeyByNotBindBank(true);
                    return;
                }
                FingerPaySettingSoterFragment.this.startToOpenFingerPay();
            }
        }, 1, null);
        ImageView imageView = this.soterAuthImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soterAuthImage");
            imageView = null;
        }
        imageView.setImageResource(QWSoterConstans.getAuthResIdByBusiType(getSettingViewModel().getIntentBusiType()));
        Button button5 = this.soterAuthBtn;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soterAuthBtn");
        } else {
            button2 = button5;
        }
        button2.setText("\u9a8c\u8bc1" + this.payTypeName);
        getSettingViewModel().setHasBindBank(false);
        fingerPayPreOpenRequest();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGotoBindCardDialog$lambda$2(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPreOpenFailNoticeDialog$lambda$4(DialogInterface dialogInterface, int i3) {
    }
}
