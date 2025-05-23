package com.tenpay.payment.paymentout;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.activity.patternlock.QWalletPatternLockGuardianFragment;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tenpay.payment.PaymentUtils;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.payment.paymentout.PaymentOutFullScreenController;
import com.tenpay.payment.paymentout.PaymentOutQrCodeController;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.WalletGateData;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qk2.QrcodeConfig;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0014J\"\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020#H\u0016J\u001c\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u00172\b\u0010(\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u00010\u001b2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020#H\u0016J\b\u00106\u001a\u00020\u0014H\u0016J\b\u00107\u001a\u00020\u0014H\u0016J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020#H\u0016J\u001c\u0010:\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u00172\b\u0010(\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010;\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010<\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "Lcom/qwallet/activity/patternlock/QWalletPatternLockGuardianFragment;", "Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$IQrCodeStateChangeCallback;", "Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController$IFullScreenChangeCallback;", "()V", "enableHintRoot", "Landroid/view/ViewGroup;", "fullScreenController", "Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController;", "mainContentRoot", "otherEntryController", "Lcom/tenpay/payment/paymentout/PaymentOutOtherEntryController;", "protocolCB", "Landroid/widget/CheckBox;", "protocolRoot", "pushController", "Lcom/tenpay/payment/paymentout/PaymentOutPushController;", "qrcodeController", "Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController;", "checkQWalletGate", "", "getSpecialErrorCode", "", "", "initData", "initEnableHint", "view", "Landroid/view/View;", "initMainContent", "initProtocol", "initTitleBar", "initWalletGateData", "walletGateData", "Lorg/json/JSONObject;", "isSDKActivity", "", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onBackEvent", "onBlError", BrowserPlugin.KEY_REQUEST_URL, "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "onFullScreenCodeChange", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onStateChange", "isQrCodeShow", "onSuccess", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onWalletGateSuccess", "operateWindow", "window", "Landroid/view/Window;", "startShakeProtocol", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentOutFragment extends QWalletPatternLockGuardianFragment implements PaymentOutQrCodeController.IQrCodeStateChangeCallback, PaymentOutFullScreenController.IFullScreenChangeCallback {
    public static final int REQUEST_CODE_ID_VERIFY = 1002;
    public static final int REQUEST_CODE_PWD_VERIFY = 1001;
    private ViewGroup enableHintRoot;

    @NotNull
    private final PaymentOutFullScreenController fullScreenController;
    private ViewGroup mainContentRoot;

    @NotNull
    private final PaymentOutOtherEntryController otherEntryController = new PaymentOutOtherEntryController(this);
    private CheckBox protocolCB;
    private ViewGroup protocolRoot;

    @NotNull
    private final PaymentOutPushController pushController;

    @NotNull
    private final PaymentOutQrCodeController qrcodeController;

    public PaymentOutFragment() {
        PaymentOutFullScreenController paymentOutFullScreenController = new PaymentOutFullScreenController(this, this);
        this.fullScreenController = paymentOutFullScreenController;
        PaymentOutQrCodeController paymentOutQrCodeController = new PaymentOutQrCodeController(this, this, paymentOutFullScreenController);
        this.qrcodeController = paymentOutQrCodeController;
        this.pushController = new PaymentOutPushController(this, paymentOutQrCodeController);
    }

    private final void checkQWalletGate() {
        JSONObject data = WalletGateData.getInstance().getData();
        if (data == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
            if (PaymentUtils.INSTANCE.isQrCodeOpen()) {
                httpRequestNoLoading(Cgi.URL_WALLET_GATE, linkedHashMap);
                return;
            } else {
                httpRequest(Cgi.URL_WALLET_GATE, linkedHashMap);
                return;
            }
        }
        initWalletGateData(data);
    }

    private final void initData() {
        checkQWalletGate();
    }

    private final void initEnableHint(View view) {
        String string;
        View findViewById = view.findViewById(R.id.f2300059);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.setVisibility(0);
        viewGroup.setBackgroundColor(-1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ViewGr\u2026or(Color.WHITE)\n        }");
        this.enableHintRoot = viewGroup;
        ImageView imageView = (ImageView) view.findViewById(R.id.f2296055);
        ViewGroup viewGroup2 = this.enableHintRoot;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enableHintRoot");
            viewGroup2 = null;
        }
        imageView.setBackground(ContextCompat.getDrawable(viewGroup2.getContext(), R.drawable.n9d));
        TextView textView = (TextView) view.findViewById(R.id.f230205a);
        if (ol2.a.c()) {
            string = getString(R.string.f21817630);
        } else {
            string = getString(R.string.f2181662z);
        }
        textView.setText(string);
        ol2.b.f(textView, 0, false, 6, null);
        ((TextView) view.findViewById(R.id.f230105_)).setVisibility(8);
        TextView initEnableHint$lambda$6 = (TextView) view.findViewById(R.id.f2294053);
        initEnableHint$lambda$6.setText(getString(R.string.f2181562y));
        initEnableHint$lambda$6.setBackground(ContextCompat.getDrawable(initEnableHint$lambda$6.getContext(), R.drawable.kcb));
        Intrinsics.checkNotNullExpressionValue(initEnableHint$lambda$6, "initEnableHint$lambda$6");
        com.tencent.mobileqq.qwallet.k.d(initEnableHint$lambda$6, 0L, new Function0<Unit>() { // from class: com.tenpay.payment.paymentout.PaymentOutFragment$initEnableHint$3$1
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
                CheckBox checkBox;
                PaymentOutQrCodeController paymentOutQrCodeController;
                checkBox = PaymentOutFragment.this.protocolCB;
                if (checkBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("protocolCB");
                    checkBox = null;
                }
                if (!checkBox.isChecked()) {
                    PaymentOutFragment.this.startShakeProtocol();
                } else {
                    paymentOutQrCodeController = PaymentOutFragment.this.qrcodeController;
                    paymentOutQrCodeController.openQrCode();
                }
            }
        }, 1, null);
        ol2.b.f(initEnableHint$lambda$6, 0, false, 6, null);
    }

    private final void initMainContent(View view) {
        QWalletUtils.v(view.findViewById(R.id.f2333065), 8.0f);
        View findViewById = view.findViewById(R.id.f2334066);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ViewGr\u2026ity = View.GONE\n        }");
        this.mainContentRoot = viewGroup;
    }

    private final void initProtocol(View view) {
        final QrcodeConfig.PaycodeProtocol a16;
        View findViewById = view.findViewById(R.id.f2297056);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        boolean z16 = false;
        viewGroup.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ViewGr\u2026 = View.VISIBLE\n        }");
        this.protocolRoot = viewGroup;
        CheckBox checkBox = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolRoot");
            viewGroup = null;
        }
        ol2.b.b(viewGroup, 0, false, 6, null);
        View findViewById2 = view.findViewById(R.id.f2298057);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.p\u2026ntent_protocol_check_box)");
        CheckBox checkBox2 = (CheckBox) findViewById2;
        this.protocolCB = checkBox2;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolCB");
        } else {
            checkBox = checkBox2;
        }
        BaseAIOUtils.g(checkBox, ViewUtils.dip2px(10.0f));
        final TextView textView = (TextView) view.findViewById(R.id.f2299058);
        QrcodeConfig qrcodeConfig = (QrcodeConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig("qwallet_qrcode_config", new QrcodeConfig(null, null, null, null, null, 31, null));
        if (qrcodeConfig.getPaycodeProtocol() != null) {
            String protocolUrl = qrcodeConfig.getPaycodeProtocol().getProtocolUrl();
            if (protocolUrl == null || protocolUrl.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                a16 = qrcodeConfig.getPaycodeProtocol();
                String string = getString(R.string.f21818631);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qwall\u2026ment_out_protocol_prefix)");
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + a16.getProtocolName());
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.tenpay.payment.paymentout.PaymentOutFragment$initProtocol$2$spanText$1$1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NotNull View widget) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        com.tencent.mobileqq.qwallet.utils.k.c(PaymentOutFragment.this.getActivity(), a16.getProtocolUrl(), false, false, null, 28, null);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NotNull TextPaint ds5) {
                        Intrinsics.checkNotNullParameter(ds5, "ds");
                        ds5.setUnderlineText(false);
                        ds5.setColor(textView.getResources().getColor(R.color.f157893cn4));
                    }
                }, string.length(), spannableStringBuilder.length(), 33);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setText(spannableStringBuilder);
            }
        }
        a16 = QrcodeConfig.PaycodeProtocol.INSTANCE.a();
        String string2 = getString(R.string.f21818631);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.qwall\u2026ment_out_protocol_prefix)");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string2 + a16.getProtocolName());
        spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.tenpay.payment.paymentout.PaymentOutFragment$initProtocol$2$spanText$1$1
            @Override // android.text.style.ClickableSpan
            public void onClick(@NotNull View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                com.tencent.mobileqq.qwallet.utils.k.c(PaymentOutFragment.this.getActivity(), a16.getProtocolUrl(), false, false, null, 28, null);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NotNull TextPaint ds5) {
                Intrinsics.checkNotNullParameter(ds5, "ds");
                ds5.setUnderlineText(false);
                ds5.setColor(textView.getResources().getColor(R.color.f157893cn4));
            }
        }, string2.length(), spannableStringBuilder2.length(), 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder2);
    }

    private final void initTitleBar(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        textView.setText(getString(R.string.f21824637));
        textView.setTextColor(-1);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap5, 0, 0, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentOutFragment.initTitleBar$lambda$2$lambda$1(PaymentOutFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$2$lambda$1(PaymentOutFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initWalletGateData(JSONObject walletGateData) {
        this.qrcodeController.onWalletGateInited(walletGateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFullScreenCodeChange$lambda$12(PaymentOutFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIImmersiveHelper.s(this$0.requireActivity(), true, true);
    }

    private final void onWalletGateSuccess(JSONObject data) {
        if (data == null) {
            return;
        }
        WalletGateData.getInstance().setData(com.tencent.mobileqq.base.a.c(), data, System.currentTimeMillis());
        initWalletGateData(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startShakeProtocol() {
        float c16 = com.tencent.mobileqq.util.x.c(getContext(), 2.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(c16, -c16, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new CycleInterpolator(3.0f));
        ViewGroup viewGroup = this.protocolRoot;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolRoot");
            viewGroup = null;
        }
        viewGroup.startAnimation(translateAnimation);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    @NotNull
    protected List<String> getSpecialErrorCode() {
        return this.qrcodeController.getSpecialErrorCode();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    protected boolean isSDKActivity() {
        return false;
    }

    @Override // com.qwallet.activity.patternlock.QWalletPatternLockGuardianFragment, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.qrcodeController.onActivityResult(requestCode, resultCode, data);
        com.tencent.mobileqq.qwallet.c.f("paycode.showpaycode.go", null, null, null, null, 30, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.fullScreenController.isFullScreenState()) {
            this.fullScreenController.exitFullScreen();
            return true;
        }
        if (this.qrcodeController.getPayTypeController().isShowingDialog()) {
            this.qrcodeController.getPayTypeController().changePayTypeDialogState(false);
            return true;
        }
        com.tencent.mobileqq.qwallet.c.f("paycode.showpaycode.keyback", null, null, null, null, 30, null);
        return super.onBackEvent();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onBlError(requestUrl, data);
        this.qrcodeController.onBlError(requestUrl, data);
    }

    @Override // com.qwallet.activity.patternlock.QWalletPatternLockGuardianFragment, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.qwallet.c.f("paycode.showpaycode.show", null, null, null, null, 30, null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168586fz2, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.payment.paymentout.PaymentOutFullScreenController.IFullScreenChangeCallback
    public void onFullScreenCodeChange(boolean isFullScreen) {
        if (isFullScreen) {
            View view = getView();
            if (view != null) {
                view.setBackgroundColor(-1);
            }
        } else {
            View view2 = getView();
            if (view2 != null) {
                view2.setBackgroundColor(requireActivity().getColor(R.color.ca8));
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tenpay.payment.paymentout.b
            @Override // java.lang.Runnable
            public final void run() {
                PaymentOutFragment.onFullScreenCodeChange$lambda$12(PaymentOutFragment.this);
            }
        });
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PaymentUtils.INSTANCE.setScreenBrightness(this, false);
        this.pushController.onPause();
        this.qrcodeController.onPause();
    }

    @Override // com.qwallet.activity.patternlock.QWalletPatternLockGuardianFragment, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PaymentUtils.INSTANCE.setScreenBrightness(this, true);
        this.pushController.onResume();
        this.qrcodeController.onResume();
    }

    @Override // com.tenpay.payment.paymentout.PaymentOutQrCodeController.IQrCodeStateChangeCallback
    public void onStateChange(boolean isQrCodeShow) {
        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "onStateChange isQrCodeShow:" + isQrCodeShow);
        ViewGroup viewGroup = null;
        if (isQrCodeShow) {
            ViewGroup viewGroup2 = this.enableHintRoot;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("enableHintRoot");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup3 = this.enableHintRoot;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enableHintRoot");
        } else {
            viewGroup = viewGroup3;
        }
        viewGroup.setVisibility(0);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onSuccess(requestUrl, data);
        if (isFinishing()) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "onSuccess but finish: " + requestUrl);
            return;
        }
        if (Intrinsics.areEqual(requestUrl, Cgi.URL_WALLET_GATE)) {
            onWalletGateSuccess(data);
        }
        this.qrcodeController.onSuccess(requestUrl, data);
        this.pushController.onSuccess(requestUrl, data);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initTitleBar(view);
        initMainContent(view);
        initEnableHint(view);
        initProtocol(view);
        this.fullScreenController.initView(view);
        this.qrcodeController.init(view);
        this.otherEntryController.init(view);
        initData();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void operateWindow(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        super.operateWindow(window);
        window.addFlags(8192);
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
