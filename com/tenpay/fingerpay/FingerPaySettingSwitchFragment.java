package com.tenpay.fingerpay;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.IFragmentCallbacks;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.ErrorCode;
import com.tenpay.api.QFuncProxy;
import com.tenpay.fingerpay.soter.SoterInitCallback;
import com.tenpay.fingerpay.soter.SoterManager;
import com.tenpay.fingerpay.type.PayTypeAdapter;
import com.tenpay.fingerpay.type.PayTypeInfo;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.util.MD5;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\"\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u001cH\u0002J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020 H\u0016J\b\u00100\u001a\u00020\u000fH\u0016J\u001a\u00101\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020 H\u0016J\u001a\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u000fH\u0002J\b\u00106\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tenpay/fingerpay/FingerPaySettingSwitchFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "fingerPayPrivacyNote", "Landroid/widget/TextView;", "payTypeSwitches", "Landroidx/recyclerview/widget/RecyclerView;", "settingViewModel", "Lcom/tenpay/fingerpay/FingerPaySettingViewModel;", "getSettingViewModel", "()Lcom/tenpay/fingerpay/FingerPaySettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "title", "fingerPayCloseRequest", "", "gotoSoterFragment", "initPayTypeSwitch", "initPrivacyNote", "initSettingsUI", "initSoter", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onBackEvent", "", "onBlError", BrowserPlugin.KEY_REQUEST_URL, "", "Lorg/json/JSONObject;", "onBlHandleFakeurl", "fakeInfo", "Lcooperation/qwallet/plugin/FakeUrl$FakeInfo;", "bntIndex", "onCloseFingerPayFinish", "success", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onNetDlgokClick", "onResume", "onSuccess", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "showCloseFingerPayDialog", "showUnSupportTips", "updateTitle", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FingerPaySettingSwitchFragment extends NetBaseActivity {
    private TextView fingerPayPrivacyNote;
    private RecyclerView payTypeSwitches;

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy settingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FingerPaySettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.fingerpay.FingerPaySettingSwitchFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.fingerpay.FingerPaySettingSwitchFragment$special$$inlined$activityViewModels$default$2
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
    private TextView title;

    private final void fingerPayCloseRequest() {
        HashMap hashMap = new HashMap();
        if (SoterManager.INSTANCE.isSupportSoter()) {
            int intentBusiType = getSettingViewModel().getIntentBusiType();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(intentBusiType);
            hashMap.put(QWSoterConstans.CGI_KEY_BUSI_TYPE, sb5.toString());
            String hexdigest = MD5.hexdigest(QFuncProxy.getDeviceId(getContext()));
            Intrinsics.checkNotNullExpressionValue(hexdigest, "hexdigest(QFuncProxy.getDeviceId(context))");
            hashMap.put("device_id", hexdigest);
            httpRequest(Cgi.URI_Soter_FINGER_PAY_CLOSE, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FingerPaySettingViewModel getSettingViewModel() {
        return (FingerPaySettingViewModel) this.settingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoSoterFragment() {
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "parentFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.ve6, new FingerPaySettingSoterFragment());
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    private final void initPayTypeSwitch() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = this.payTypeSwitches;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payTypeSwitches");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        final PayTypeAdapter payTypeAdapter = new PayTypeAdapter(new Function1<PayTypeInfo, Unit>() { // from class: com.tenpay.fingerpay.FingerPaySettingSwitchFragment$initPayTypeSwitch$onItemClickListener$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayTypeInfo payTypeInfo) {
                invoke2(payTypeInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public void invoke2(@NotNull PayTypeInfo payType) {
                FingerPaySettingViewModel settingViewModel;
                Intrinsics.checkNotNullParameter(payType, "payType");
                if (payType.getIsCloseBtn()) {
                    FingerPaySettingSwitchFragment.this.showCloseFingerPayDialog();
                    return;
                }
                settingViewModel = FingerPaySettingSwitchFragment.this.getSettingViewModel();
                settingViewModel.setIntentBusiType(payType.getBusiType());
                FingerPaySettingSwitchFragment.this.gotoSoterFragment();
            }
        });
        MutableLiveData<List<PayTypeInfo>> payTypeLiveData = getSettingViewModel().getPayTypeLiveData();
        final Function1<List<? extends PayTypeInfo>, Unit> function1 = new Function1<List<? extends PayTypeInfo>, Unit>() { // from class: com.tenpay.fingerpay.FingerPaySettingSwitchFragment$initPayTypeSwitch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PayTypeInfo> list) {
                invoke2((List<PayTypeInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PayTypeInfo> it) {
                PayTypeAdapter payTypeAdapter2 = PayTypeAdapter.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                payTypeAdapter2.updateSwitchList(it);
            }
        };
        payTypeLiveData.observe(this, new Observer() { // from class: com.tenpay.fingerpay.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FingerPaySettingSwitchFragment.initPayTypeSwitch$lambda$3(Function1.this, obj);
            }
        });
        RecyclerView recyclerView3 = this.payTypeSwitches;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payTypeSwitches");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(payTypeAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPayTypeSwitch$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initPrivacyNote() {
        int indexOf$default;
        TextView textView = this.fingerPayPrivacyNote;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fingerPayPrivacyNote");
            textView = null;
        }
        textView.setHighlightColor(0);
        TextView textView3 = this.fingerPayPrivacyNote;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fingerPayPrivacyNote");
            textView3 = null;
        }
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        String string = getString(R.string.f17936396);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_tenpay_fp_open_privacy)");
        String str = "QQ\u94b1\u5305\u672a\u901a\u8fc7\u6307\u7eb9\u652f\u4ed8\u529f\u80fd\u6536\u96c6\u60a8\u7684\u6307\u7eb9\u4fe1\u606f\uff0c\u4ec5\u83b7\u53d6\u7ec8\u7aef\u8bbe\u5907\u5b8c\u6210\u6838\u9a8c\u7684\u7ed3\u679c\uff0c\u5177\u4f53\u89c4\u5219\u53ef\u89c1" + string + "\u4e2d\u6709\u5173\u6307\u7eb9\u652f\u4ed8\u7684\u76f8\u5173\u6761\u6b3e\u3002";
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, string, 0, false, 6, (Object) null);
        int length = string.length() + indexOf$default;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ClickableSpan() { // from class: com.tenpay.fingerpay.FingerPaySettingSwitchFragment$initPrivacyNote$1
            @Override // android.text.style.ClickableSpan
            public void onClick(@NotNull View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                FingerPaySettingSwitchFragment.this.gotoH5("https://posts.tenpay.com/posts/9e7190f16168f956002216fa5a03e90e.html");
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NotNull TextPaint ds5) {
                Intrinsics.checkNotNullParameter(ds5, "ds");
                ds5.setUnderlineText(false);
                ds5.clearShadowLayer();
            }
        }, indexOf$default, length, 17);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF00CAFC")), indexOf$default, length, 17);
        TextView textView4 = this.fingerPayPrivacyNote;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fingerPayPrivacyNote");
            textView4 = null;
        }
        textView4.setText(spannableString);
        TextView textView5 = this.fingerPayPrivacyNote;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fingerPayPrivacyNote");
        } else {
            textView2 = textView5;
        }
        textView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initSettingsUI() {
        updateTitle();
        initPrivacyNote();
        initPayTypeSwitch();
        getSettingViewModel().initFingerPaySetting();
    }

    private final void initSoter() {
        getSettingViewModel().initSoter(new SoterInitCallback() { // from class: com.tenpay.fingerpay.FingerPaySettingSwitchFragment$initSoter$1
            @Override // com.tenpay.fingerpay.soter.SoterInitCallback
            public void onFailed() {
                if (!FingerPaySettingSwitchFragment.this.isFinishing()) {
                    FingerPaySettingSwitchFragment.this.showUnSupportTips();
                }
            }

            @Override // com.tenpay.fingerpay.soter.SoterInitCallback
            public void onSuccess() {
                if (!FingerPaySettingSwitchFragment.this.isFinishing()) {
                    FingerPaySettingSwitchFragment.this.initSettingsUI();
                }
            }
        });
    }

    private final void onCloseFingerPayFinish(boolean success) {
        if (success) {
            showOkTips(QWSoterConstans.getNameByBusiType(getSettingViewModel().getIntentBusiType()) + "\u652f\u4ed8\u5df2\u5173\u95ed", null);
            getSettingViewModel().saveCloseSuccessResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(FingerPaySettingSwitchFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCloseFingerPayDialog() {
        QUIProxy.createCustomDialog(getContext(), 230, null, "\u786e\u5b9a\u5173\u95ed" + QWSoterConstans.getNameByBusiType(getSettingViewModel().getIntentBusiType()) + "\u652f\u4ed8\u5417\uff1f", getString(R.string.e5h), getString(R.string.e5j), new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSwitchFragment.showCloseFingerPayDialog$lambda$1(FingerPaySettingSwitchFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FingerPaySettingSwitchFragment.showCloseFingerPayDialog$lambda$2(dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCloseFingerPayDialog$lambda$1(FingerPaySettingSwitchFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fingerPayCloseRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showUnSupportTips() {
        QQToast.makeText(getContext(), getString(R.string.e37), 0).show();
        finish();
    }

    private final void updateTitle() {
        String str;
        boolean z16;
        GetSupportSoterNet.SoterSupportRes soterSupportRes = GetSupportSoterNet.sSupportResCache;
        TextView textView = null;
        if (soterSupportRes != null) {
            str = soterSupportRes.soter_suggest_title;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            TextView textView2 = this.title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
            } else {
                textView = textView2;
            }
            textView.setText(R.string.e69);
            return;
        }
        TextView textView3 = this.title;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            textView = textView3;
        }
        textView.setText(str);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        QLog.i(((NetBaseActivity) this).TAG, 1, "FingerPayActivity onActivityResult");
        QLog.i(((NetBaseActivity) this).TAG, 1, "requestCode=" + requestCode);
        QLog.i(((NetBaseActivity) this).TAG, 1, "resultCode=" + resultCode);
        if (resultCode == -1 && 1002 == requestCode) {
            getSettingViewModel().setHasBindBank(true);
            httpRequest(Cgi.URL_WALLET_GATE, getSettingViewModel().getWalletGateRequestData());
        }
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
            if (iFragmentCallbacks == null) {
                return false;
            }
            if (iFragmentCallbacks instanceof FingerPaySettingSwitchFragment) {
                String str = ((NetBaseActivity) this).TAG;
                QLog.i(str, 1, "back from " + str);
                return false;
            }
            return iFragmentCallbacks.onBackEvent();
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onBlError(requestUrl, data);
        if (Intrinsics.areEqual(Cgi.URI_Soter_FINGER_PAY_CLOSE, requestUrl)) {
            onCloseFingerPayFinish(false);
            SharedHelper.closeFinger(this.mUin);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(@NotNull FakeUrl.FakeInfo fakeInfo, int bntIndex) {
        Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
        if (bntIndex == 0) {
            return false;
        }
        super.onBlHandleFakeurl(fakeInfo, bntIndex);
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fya, container, false);
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

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.onSuccess(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URL_WALLET_GATE)) {
            getSettingViewModel().loadWalletGateData(data);
            String optString = data.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            initSoter();
            return;
        }
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_Soter_FINGER_PAY_CLOSE)) {
            getSettingViewModel().closeSoterPay();
            onCloseFingerPayFinish(true);
            SoterManager.INSTANCE.removeAuthKeyByScene(Cgi.scene_FingerPay);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.v6e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.finger_pay_privacy_note)");
        this.fingerPayPrivacyNote = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.lpj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.layout_switchs)");
        this.payTypeSwitches = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.ivTitleName);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ivTitleName)");
        this.title = (TextView) findViewById3;
        view.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.fingerpay.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FingerPaySettingSwitchFragment.onViewCreated$lambda$0(FingerPaySettingSwitchFragment.this, view2);
            }
        });
        updateTitle();
        JSONObject data = WalletGateData.getInstance().getData();
        if (data != null) {
            getSettingViewModel().loadWalletGateData(data);
            String optString = data.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            initSoter();
            return;
        }
        httpRequest(Cgi.URL_WALLET_GATE, getSettingViewModel().getWalletGateRequestData());
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
    public static final void showCloseFingerPayDialog$lambda$2(DialogInterface dialogInterface, int i3) {
    }
}
