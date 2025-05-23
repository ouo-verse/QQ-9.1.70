package com.tenpay.bank;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.tencent.biz.richframework.compat.IFragmentCallbacks;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.util.QQToastUtil;
import com.tenpay.QwLog;
import com.tenpay.bank.input.BindBankInputViewModel;
import com.tenpay.bank.quick.BindBankQuickViewModel;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.face.FaceVerifyErr;
import com.tenpay.face.QWalletFaceProxyFragment;
import com.tenpay.marketservice.MarketServiceUtils;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.activity.VerifyPasswordActivity;
import com.tenpay.sdk.activity.WithdrawActivity;
import com.tenpay.sdk.net.core.actions.RefreshPaymentOutAction;
import com.tenpay.sdk.util.JSONConstant;
import com.tenpay.sdk.util.WalletGateData;
import cooperation.qzone.QzoneIPCModule;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\"\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020+H\u0016J\u001c\u0010,\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u000fH\u0002J\b\u00101\u001a\u00020\u000fH\u0002J(\u00102\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u000fH\u0002J\u0010\u00107\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020+H\u0002J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020+H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u00069"}, d2 = {"Lcom/tenpay/bank/BindBankEntryFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "inputViewModel", "Lcom/tenpay/bank/input/BindBankInputViewModel;", "getInputViewModel", "()Lcom/tenpay/bank/input/BindBankInputViewModel;", "inputViewModel$delegate", "Lkotlin/Lazy;", "quickViewModel", "Lcom/tenpay/bank/quick/BindBankQuickViewModel;", "getQuickViewModel", "()Lcom/tenpay/bank/quick/BindBankQuickViewModel;", "quickViewModel$delegate", "afterInitWalletGate", "", "getFragmentAnimation", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "gotoBindBankActivity", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onBackEvent", "", "onBindBankFinish", "isSuccess", "bindStatus", "resInfo", "", "bindBankSerial", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onNetDlgokClick", BrowserPlugin.KEY_REQUEST_URL, "Lorg/json/JSONObject;", "onSuccess", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "sendQueryBinRequest", "sendWalBankQueryRequest", "sendWallGateRequest", "startQuickBankUrl", "url", "method", "body", "startVerifyPassword", "walBankQuerySuccess", "walletGateSuccess", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BindBankEntryFragment extends NetBaseActivity {

    /* renamed from: quickViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy quickViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BindBankQuickViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.bank.BindBankEntryFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.bank.BindBankEntryFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: inputViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BindBankInputViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.bank.BindBankEntryFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.bank.BindBankEntryFragment$special$$inlined$activityViewModels$default$4
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

    private final void afterInitWalletGate() {
        if (getInputViewModel().getMUserAttr() == 2 && !Intrinsics.areEqual(getInputViewModel().getPrefillUserInfo(), "0")) {
            getQuickViewModel().requestBankInfo();
            sendWalBankQueryRequest();
            sendQueryBinRequest();
            return;
        }
        gotoBindBankActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BindBankInputViewModel getInputViewModel() {
        return (BindBankInputViewModel) this.inputViewModel.getValue();
    }

    private final BindBankQuickViewModel getQuickViewModel() {
        return (BindBankQuickViewModel) this.quickViewModel.getValue();
    }

    private final void gotoBindBankActivity() {
        Bundle extras;
        Intent intent = new Intent();
        Intent intent2 = getIntent();
        if (intent2 != null && (extras = intent2.getExtras()) != null) {
            intent.putExtras(extras);
        }
        BindBankModule.INSTANCE.startVerifyForResult(this, intent, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBindBankFinish(boolean isSuccess, int bindStatus, String resInfo, final String bindBankSerial) {
        String str;
        dismissLoading();
        if (!isSuccess) {
            return;
        }
        BindBankQuickViewModel quickViewModel = getQuickViewModel();
        if (bindStatus == 2) {
            str = "1";
        } else {
            str = "2";
        }
        quickViewModel.reportTo644("qqwallet.bk_noinputcard.result.show", str, String.valueOf(bindStatus), resInfo);
        BindBankFinishFragment bindBankFinishFragment = new BindBankFinishFragment();
        Bundle bundle = new Bundle();
        boolean z16 = true;
        if (bindStatus == 2) {
            bundle.putInt("finish_drawable_id", R.drawable.olc);
            if (resInfo.length() != 0) {
                z16 = false;
            }
            if (z16) {
                resInfo = "\u6dfb\u52a0\u6210\u529f";
            }
            bundle.putString("finish_title_text", resInfo);
        } else {
            bundle.putInt("finish_drawable_id", R.drawable.ol9);
            if (resInfo.length() != 0) {
                z16 = false;
            }
            if (z16) {
                resInfo = "\u6dfb\u52a0\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            }
            bundle.putString("finish_title_text", resInfo);
        }
        bindBankFinishFragment.setArguments(bundle);
        com.qwallet.utils.a.b(this, R.id.ve6, bindBankFinishFragment, BankConstants.BANK_FINISH_FRAGMENT_QUICK_TAG, null, 8, null);
        FragmentKt.setFragmentResultListener(this, BindBankFinishFragment.FINISH_RESULT, new Function2<String, Bundle, Unit>() { // from class: com.tenpay.bank.BindBankEntryFragment$onBindBankFinish$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str2, Bundle bundle2) {
                invoke2(str2, bundle2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String requestKey, @NotNull Bundle bundle2) {
                String str2;
                BindBankInputViewModel inputViewModel;
                BindBankInputViewModel inputViewModel2;
                BindBankInputViewModel inputViewModel3;
                Intrinsics.checkNotNullParameter(requestKey, "requestKey");
                Intrinsics.checkNotNullParameter(bundle2, "bundle");
                str2 = ((NetBaseActivity) ((NetBaseActivity) BindBankEntryFragment.this)).TAG;
                QLog.d(str2, 1, "setFragmentResult " + requestKey + " bundle = " + bundle2);
                WalletGateData.getInstance().clear();
                MarketServiceUtils.sendMarketServiceSwitch();
                inputViewModel = BindBankEntryFragment.this.getInputViewModel();
                QwLog.i("mIsFromWithdraw = " + inputViewModel.getMIsFromWithdraw());
                Intent intent = new Intent();
                inputViewModel2 = BindBankEntryFragment.this.getInputViewModel();
                if (inputViewModel2.getMIsFromWithdraw()) {
                    String str3 = WithdrawActivity.WITHDRAW_COUNT;
                    inputViewModel3 = BindBankEntryFragment.this.getInputViewModel();
                    intent.putExtra(str3, inputViewModel3.getMWithdrawCount());
                    intent.putExtra("pass_flag", 2);
                    intent.putExtra("bing_withdraw_flag", true);
                    BindBankEntryFragment.this.launchFragment(intent, WithdrawActivity.class);
                } else {
                    intent.putExtra("bind_serial", bindBankSerial);
                }
                BindBankEntryFragment.this.setResult(-1, intent);
                BindBankEntryFragment.this.finish();
            }
        });
        RefreshPaymentOutAction.INSTANCE.clearCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BindBankEntryFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void sendQueryBinRequest() {
        getInputViewModel().setBankBinJson(new JSONConstant().mBinData);
        httpRequestNoEncript(Cgi.QUERY_CARD_BIN_CONF_URI, new HashMap());
    }

    private final void sendWalBankQueryRequest() {
        httpRequestNoEncript(Cgi.URI_YDTBANK_QUERY, getInputViewModel().createWalBankQueryRequest());
    }

    private final void sendWallGateRequest() {
        boolean z16;
        String str;
        HashMap hashMap = new HashMap();
        String str2 = this.mUin;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = com.tencent.mobileqq.base.a.c();
        } else {
            str = this.mUin;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (mUin.isNullOrEmpty()\u2026ls.currentUin() else mUin");
        hashMap.put("uin", str);
        httpRequest(Cgi.URL_WALLET_GATE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startQuickBankUrl(boolean isSuccess, String url, String method, String body) {
        dismissLoading();
        if (!isSuccess) {
            return;
        }
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        if (Intrinsics.areEqual(method, "POST")) {
            intent.putExtra("BSafeReportPost", true);
            Charset forName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = body.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            intent.putExtra("SafeReportData", bytes);
        }
        intent.putExtra("hide_more_button", true);
        intent.putExtra("ishiderefresh", true);
        intent.putExtra("ishidebackforward", true);
        startActivityForResult(intent.putExtra("url", url), 102);
        BindBankQuickViewModel.reportTo644$default(getQuickViewModel(), "qqwallet.bk_noinputcard.bank.show", null, null, null, 14, null);
    }

    private final void startVerifyPassword() {
        Intent intent = new Intent();
        intent.putExtra("pass_flag", getInputViewModel().getPassFlagInt());
        launchFragmentForResult(intent, VerifyPasswordActivity.class, 201);
    }

    private final void walBankQuerySuccess(JSONObject data) {
        getInputViewModel().onWalBankQuerySuccess(data);
        startVerifyPassword();
    }

    private final void walletGateSuccess(JSONObject data) {
        boolean z16;
        String optString = data.optString("time_stamp");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"time_stamp\")");
        this.mTimestamp = Long.parseLong(optString) - (System.currentTimeMillis() / 1000);
        getInputViewModel().setQwalletData(data);
        String server = data.optString("domain_name");
        Intrinsics.checkNotNullExpressionValue(server, "server");
        if (server.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            setServerAddr(server);
        }
        afterInitWalletGate();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.PULL_UP;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        Integer num;
        String str2;
        boolean z16;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 201) {
            switch (requestCode) {
                case 100:
                    setResult(resultCode, data);
                    finish();
                    return;
                case 101:
                    if (resultCode == -1) {
                        FaceVerifyBean faceVerifyBean = null;
                        if (data != null) {
                            num = Integer.valueOf(data.getIntExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_CODE, FaceVerifyErr.ERROR_CANCEL.getRetCode()));
                        } else {
                            num = null;
                        }
                        if (data != null) {
                            str2 = data.getStringExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_MSG);
                        } else {
                            str2 = null;
                        }
                        if (data != null) {
                            faceVerifyBean = (FaceVerifyBean) data.getParcelableExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_FACE_BEAN);
                        }
                        int retCode = FaceVerifyErr.OK.getRetCode();
                        if (num != null && num.intValue() == retCode && faceVerifyBean != null) {
                            showLoading();
                            getQuickViewModel().requestBindUrl(faceVerifyBean, new BindBankEntryFragment$onActivityResult$1(this));
                            return;
                        }
                        boolean z17 = false;
                        if (str2 != null) {
                            if (str2.length() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                z17 = true;
                            }
                        }
                        if (z17) {
                            QQToastUtil.showQQToast(1, str2);
                        }
                    }
                    QLog.w(((NetBaseActivity) this).TAG, 1, "face proxy fail");
                    return;
                case 102:
                    if (resultCode == -1) {
                        showLoading();
                        getQuickViewModel().requestQueryBind(new BindBankEntryFragment$onActivityResult$2(this));
                    }
                    QLog.d(((NetBaseActivity) this).TAG, 1, "REQUEST_CODE_BIND_WEB");
                    return;
                default:
                    List<Fragment> fragments = getParentFragmentManager().getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
                    for (Fragment fragment : fragments) {
                        if (!Intrinsics.areEqual(fragment, this)) {
                            fragment.onActivityResult(requestCode, resultCode, data);
                        }
                    }
                    return;
            }
        }
        if (resultCode != -1) {
            finish();
            return;
        }
        if (data == null || (str = data.getStringExtra("verify_success_password")) == null) {
            str = "";
        }
        getInputViewModel().setPassword(str);
        com.qwallet.utils.a.b(this, R.id.cks, new BindBankMainFragment(), BankConstants.BIND_BANK_MAIN_FRAGMENT_TAG, null, 8, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Object last;
        IFragmentCallbacks iFragmentCallbacks;
        List<Fragment> fragments = getParentFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
        if (fragments.size() > 1) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) fragments);
            if (last instanceof IFragmentCallbacks) {
                iFragmentCallbacks = (IFragmentCallbacks) last;
            } else {
                iFragmentCallbacks = null;
            }
            if (iFragmentCallbacks == null || (iFragmentCallbacks instanceof BindBankEntryFragment)) {
                return false;
            }
            return iFragmentCallbacks.onBackEvent();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hi9, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(@NotNull String requestUrl, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        super.onNetDlgokClick(requestUrl, data);
        if (!TextUtils.isEmpty(data.optString("returl"))) {
            if (this.mEnterType == 1) {
                setRetCodeAndGetBundle(-1).putInt("time_out", 1);
            }
            finish();
        }
        if (Intrinsics.areEqual(Cgi.URI_YDTBANK_QUERY, requestUrl) && !QWalletFakeUrl.hasQWalletFakeProtocal(data)) {
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onSuccess(requestUrl, data);
        if (requestUrl == null || data == null) {
            return;
        }
        QLog.d(((NetBaseActivity) this).TAG, 1, "onSuccess requestUrl = " + requestUrl);
        if (Intrinsics.areEqual(requestUrl, Cgi.URL_WALLET_GATE)) {
            walletGateSuccess(data);
        } else if (Intrinsics.areEqual(requestUrl, Cgi.URI_YDTBANK_QUERY)) {
            walBankQuerySuccess(data);
        } else if (Intrinsics.areEqual(requestUrl, Cgi.QUERY_CARD_BIN_CONF_URI)) {
            getInputViewModel().setBankBinJson(data.optJSONArray("detail"));
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
        ((TextView) view.findViewById(R.id.ivTitleName)).setText("\u6dfb\u52a0\u94f6\u884c\u5361");
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BindBankEntryFragment.onViewCreated$lambda$0(BindBankEntryFragment.this, view2);
            }
        });
        sendWallGateRequest();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
