package com.tenpay.bank;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.QwLog;
import com.tenpay.bank.input.BankInputVerifyActivity;
import com.tenpay.bank.input.BindBankInputVC;
import com.tenpay.bank.input.BindBankInputViewModel;
import com.tenpay.bank.quick.BindBankQuickVC;
import com.tenpay.marketservice.MarketServiceUtils;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.activity.WithdrawActivity;
import com.tenpay.sdk.util.WalletGateData;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\"\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u001c\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010%\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\u001c\u0010'\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tenpay/bank/BindBankMainFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "bindBankInputVC", "Lcom/tenpay/bank/input/BindBankInputVC;", "bindBankQuickVC", "Lcom/tenpay/bank/quick/BindBankQuickVC;", "inputViewModel", "Lcom/tenpay/bank/input/BindBankInputViewModel;", "getInputViewModel", "()Lcom/tenpay/bank/input/BindBankInputViewModel;", "inputViewModel$delegate", "Lkotlin/Lazy;", "isQuickShow", "", "handleNamedUserNextStep", "", "isStatusBarImmersive", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onBackEvent", "onBlError", BrowserPlugin.KEY_REQUEST_URL, "", "Lorg/json/JSONObject;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onError", "onResume", "onSuccess", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BindBankMainFragment extends NetBaseActivity {
    private BindBankInputVC bindBankInputVC;
    private BindBankQuickVC bindBankQuickVC;

    /* renamed from: inputViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BindBankInputViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.bank.BindBankMainFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.bank.BindBankMainFragment$special$$inlined$activityViewModels$default$2
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
    private boolean isQuickShow = true;

    /* JADX INFO: Access modifiers changed from: private */
    public final BindBankInputViewModel getInputViewModel() {
        return (BindBankInputViewModel) this.inputViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackEvent$lambda$0(BindBankMainFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setResult(0);
        this$0.finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public final void handleNamedUserNextStep() {
        QwLog.i("\u8001\u7528\u6237\u7ed1\u5361-\u8bf7\u6c42\u9a8c\u8bc1\u7801");
        httpRequest(Cgi.URI_CFT_USER_AUTHEN, getInputViewModel().createItgAuthenRequest());
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && requestCode == 202) {
            BindBankInputVC bindBankInputVC = this.bindBankInputVC;
            if (bindBankInputVC == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindBankInputVC");
                bindBankInputVC = null;
            }
            bindBankInputVC.onActivityResult(data);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QUIProxy.createCustomDialog(getContext(), 230, null, "\u662f\u5426\u653e\u5f03\u7ed1\u5b9a\u94f6\u884c\u5361", "\u53d6\u6d88", "\u653e\u5f03\u7ed1\u5361", new DialogInterface.OnClickListener() { // from class: com.tenpay.bank.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindBankMainFragment.onBackEvent$lambda$0(BindBankMainFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.bank.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindBankMainFragment.onBackEvent$lambda$1(dialogInterface, i3);
            }
        }).show();
        return true;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        String str;
        super.onBlError(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CFT_USER_AUTHEN)) {
            BindBankInputViewModel inputViewModel = getInputViewModel();
            String str2 = null;
            if (data != null) {
                str = data.optString("retcode");
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (data != null) {
                str2 = data.optString("retmsg");
            }
            if (str2 != null) {
                str3 = str2;
            }
            inputViewModel.reportTo644("qqwallet.bk_inputcard.bankaddnext.click", "2", str, str3);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hib, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(@Nullable String requestUrl, @Nullable JSONObject data) {
        String str;
        super.onError(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CFT_USER_AUTHEN)) {
            BindBankInputViewModel inputViewModel = getInputViewModel();
            String str2 = null;
            if (data != null) {
                str = data.optString("retcode");
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (data != null) {
                str2 = data.optString("retmsg");
            }
            if (str2 != null) {
                str3 = str2;
            }
            inputViewModel.reportTo644("qqwallet.bk_inputcard.bankaddnext.click", "2", str, str3);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BindBankInputViewModel.reportTo644$default(getInputViewModel(), "qqwallet.bk_noinputcard.bankadd.show", null, null, null, 14, null);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onSuccess(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CFT_USER_AUTHEN)) {
            getInputViewModel().setBindCardPreObj(data);
            com.qwallet.utils.a.b(this, R.id.ve6, new BankInputVerifyActivity(), BankConstants.BANK_INPUT_VERIFY_FRAGMENT_TAG, null, 8, null);
            QLog.d(((NetBaseActivity) this).TAG, 1, "handleNamedUserNextStep click");
            BindBankInputViewModel.reportTo644$default(getInputViewModel(), "qqwallet.bk_inputcard.bankaddnext.click", "1", null, null, 12, null);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.bindBankInputVC = new BindBankInputVC(this, view);
        BindBankQuickVC bindBankQuickVC = new BindBankQuickVC(this, view);
        this.bindBankQuickVC = bindBankQuickVC;
        bindBankQuickVC.setTitleOnClickListener(new Function0<Unit>() { // from class: com.tenpay.bank.BindBankMainFragment$onViewCreated$1
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
                BindBankQuickVC bindBankQuickVC2;
                BindBankInputVC bindBankInputVC;
                z16 = BindBankMainFragment.this.isQuickShow;
                if (z16) {
                    return;
                }
                BindBankMainFragment.this.isQuickShow = true;
                bindBankQuickVC2 = BindBankMainFragment.this.bindBankQuickVC;
                BindBankInputVC bindBankInputVC2 = null;
                if (bindBankQuickVC2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindBankQuickVC");
                    bindBankQuickVC2 = null;
                }
                bindBankQuickVC2.setQuickLayoutShow();
                bindBankInputVC = BindBankMainFragment.this.bindBankInputVC;
                if (bindBankInputVC == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindBankInputVC");
                } else {
                    bindBankInputVC2 = bindBankInputVC;
                }
                bindBankInputVC2.hideInputForm();
            }
        });
        BindBankInputVC bindBankInputVC = this.bindBankInputVC;
        if (bindBankInputVC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindBankInputVC");
            bindBankInputVC = null;
        }
        bindBankInputVC.setBankCardOnClickListener(new Function0<Unit>() { // from class: com.tenpay.bank.BindBankMainFragment$onViewCreated$2
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
                BindBankQuickVC bindBankQuickVC2;
                BindBankInputVC bindBankInputVC2;
                BindBankInputViewModel inputViewModel;
                z16 = BindBankMainFragment.this.isQuickShow;
                if (z16) {
                    BindBankMainFragment.this.isQuickShow = false;
                    bindBankQuickVC2 = BindBankMainFragment.this.bindBankQuickVC;
                    BindBankInputVC bindBankInputVC3 = null;
                    if (bindBankQuickVC2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bindBankQuickVC");
                        bindBankQuickVC2 = null;
                    }
                    bindBankQuickVC2.setQuickLayoutHide();
                    bindBankInputVC2 = BindBankMainFragment.this.bindBankInputVC;
                    if (bindBankInputVC2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bindBankInputVC");
                    } else {
                        bindBankInputVC3 = bindBankInputVC2;
                    }
                    bindBankInputVC3.showInputForm();
                    inputViewModel = BindBankMainFragment.this.getInputViewModel();
                    BindBankInputViewModel.reportTo644$default(inputViewModel, "qqwallet.bk_inputcard.bankaddlist.click", null, null, null, 14, null);
                }
            }
        });
        FragmentKt.setFragmentResultListener(this, BankInputVerifyActivity.PHONE_INPUT_RESULT, new Function2<String, Bundle, Unit>() { // from class: com.tenpay.bank.BindBankMainFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                invoke2(str, bundle);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final String requestKey, @NotNull final Bundle bundle) {
                String str;
                Intrinsics.checkNotNullParameter(requestKey, "requestKey");
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                str = ((NetBaseActivity) ((NetBaseActivity) BindBankMainFragment.this)).TAG;
                QLog.d(str, 1, "setFragmentResult " + requestKey + " bundle = " + bundle);
                final String string = bundle.getString("bind_serial");
                if (string == null) {
                    string = "";
                }
                BindBankFinishFragment bindBankFinishFragment = new BindBankFinishFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("finish_drawable_id", R.drawable.olc);
                bundle2.putString("finish_title_text", "\u6dfb\u52a0\u6210\u529f");
                bindBankFinishFragment.setArguments(bundle2);
                com.qwallet.utils.a.b(BindBankMainFragment.this, R.id.ve6, bindBankFinishFragment, BankConstants.BANK_FINISH_FRAGMENT_INPUT_TAG, null, 8, null);
                final BindBankMainFragment bindBankMainFragment = BindBankMainFragment.this;
                FragmentKt.setFragmentResultListener(bindBankMainFragment, BindBankFinishFragment.FINISH_RESULT, new Function2<String, Bundle, Unit>() { // from class: com.tenpay.bank.BindBankMainFragment$onViewCreated$3.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str2, Bundle bundle3) {
                        invoke2(str2, bundle3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String str2, @NotNull Bundle bundle3) {
                        String str3;
                        BindBankInputViewModel inputViewModel;
                        BindBankInputViewModel inputViewModel2;
                        BindBankInputViewModel inputViewModel3;
                        Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(bundle3, "<anonymous parameter 1>");
                        str3 = ((NetBaseActivity) ((NetBaseActivity) BindBankMainFragment.this)).TAG;
                        QLog.d(str3, 1, "setFragmentResult " + requestKey + " bundle = " + bundle);
                        WalletGateData.getInstance().clear();
                        MarketServiceUtils.sendMarketServiceSwitch();
                        inputViewModel = BindBankMainFragment.this.getInputViewModel();
                        QwLog.i("mIsFromWithdraw = " + inputViewModel.getMIsFromWithdraw());
                        Intent intent = new Intent();
                        inputViewModel2 = BindBankMainFragment.this.getInputViewModel();
                        if (inputViewModel2.getMIsFromWithdraw()) {
                            String str4 = WithdrawActivity.WITHDRAW_COUNT;
                            inputViewModel3 = BindBankMainFragment.this.getInputViewModel();
                            intent.putExtra(str4, inputViewModel3.getMWithdrawCount());
                            intent.putExtra("pass_flag", 2);
                            intent.putExtra("bing_withdraw_flag", true);
                            BindBankMainFragment.this.launchFragment(intent, WithdrawActivity.class);
                        } else {
                            intent.putExtra("bind_serial", string);
                        }
                        BindBankMainFragment.this.setResult(-1, intent);
                        BindBankMainFragment.this.finish();
                    }
                });
            }
        });
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
    public static final void onBackEvent$lambda$1(DialogInterface dialogInterface, int i3) {
    }
}
