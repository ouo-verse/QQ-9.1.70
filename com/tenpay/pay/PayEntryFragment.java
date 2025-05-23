package com.tenpay.pay;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qwallet.WeakFragmentReceiver;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.util.QQToastUtil;
import com.tenpay.bank.BindBankModule;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.helper.WechatPayHelper;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.paynet.Net;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0010\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0017J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0002J)\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u00010\u00182\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00132\u0006\u0010)\u001a\u000204H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u00066"}, d2 = {"Lcom/tenpay/pay/PayEntryFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "()V", "appInfo", "", "comeFrom", "isPayingWechat", "", "newBindBankSerial", "qpayGateJSON", "Lorg/json/JSONObject;", "sourceId", "tokenId", "wechatPayHelper", "Lcom/tenpay/sdk/helper/WechatPayHelper;", "wxPayCallback", "com/tenpay/pay/PayEntryFragment$wxPayCallback$1", "Lcom/tenpay/pay/PayEntryFragment$wxPayCallback$1;", "initData", "", "logBankInfo", "data", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "onStartPayChannel", "sendQPayGateRequest", "startBalanceOrBankPay", "payChannel", "Lcom/tenpay/pay/model/PayChannelBean;", "startBindCard", "payChannelBean", "Lcom/tenpay/pay/model/PayChannelBean$AddMore;", "startPay", "payType", "bankIndex", "bankType", "(ILjava/lang/Integer;Ljava/lang/String;)V", "startWeChatPay", "Lcom/tenpay/pay/model/PayChannelBean$Wx;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayEntryFragment extends QWalletBaseFragment {

    @NotNull
    public static final String IN_KEY_COME_FROM = "IN_KEY_COME_FROM";

    @NotNull
    public static final String IN_KEY_PAY_CHANNEL = "IN_KEY_PAY_CHANNEL";

    @NotNull
    public static final String IN_KEY_SOURCE_ID = "IN_KEY_SOURCE_ID";

    @NotNull
    public static final String IN_KEY_TOKEN_ID = "IN_KEY_TOKEN_ID";
    public static final int REQUEST_CODE_BIND_CARD = 101;
    public static final int REQUEST_CODE_PAY_ACTIVITY = 102;

    @Nullable
    private String appInfo;

    @Nullable
    private String comeFrom;
    private boolean isPayingWechat;

    @Nullable
    private String newBindBankSerial;

    @Nullable
    private JSONObject qpayGateJSON;

    @Nullable
    private String sourceId;

    @Nullable
    private String tokenId;

    @NotNull
    private final WechatPayHelper wechatPayHelper = new WechatPayHelper();

    @NotNull
    private final PayEntryFragment$wxPayCallback$1 wxPayCallback = new WeakFragmentReceiver<PayEntryFragment>() { // from class: com.tenpay.pay.PayEntryFragment$wxPayCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(PayEntryFragment.this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String action;
            String str;
            String str2;
            String str3;
            if (intent != null && (action = intent.getAction()) != null) {
                str = PayEntryFragment.TAG;
                QLog.i(str, 1, "receive wx callback: " + action);
                if (Intrinsics.areEqual("broadcast_wx_pay_callback", action)) {
                    int intExtra = intent.getIntExtra("errCode", -1);
                    str3 = PayEntryFragment.TAG;
                    QLog.i(str3, 1, "wx callback retCode: " + intExtra);
                    if (intExtra == 0) {
                        MobileQQ.sMobileQQ.sendBroadcast(new Intent("HB_PACK_WX_CHANNEL_SUCCESS"));
                    }
                }
                if (context != null) {
                    try {
                        context.unregisterReceiver(this);
                    } catch (Exception e16) {
                        str2 = PayEntryFragment.TAG;
                        QLog.w(str2, 1, "unregisterReceiver error:", e16);
                    }
                }
                PayEntryFragment.this.finish();
            }
        }
    };

    @NotNull
    private static final String TAG = "CFT-sdk-PayEntryFragment";

    private final void initData() {
        String str;
        String str2;
        Bundle arguments = getArguments();
        String str3 = null;
        if (arguments != null) {
            str = arguments.getString(IN_KEY_TOKEN_ID);
        } else {
            str = null;
        }
        this.tokenId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString(IN_KEY_COME_FROM);
        } else {
            str2 = null;
        }
        this.comeFrom = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str3 = arguments3.getString(IN_KEY_SOURCE_ID);
        }
        this.sourceId = str3;
        QLog.i(TAG, 1, "initData: tokenId=" + this.tokenId + " comeFrom=" + this.comeFrom + " sourceId=" + str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logBankInfo(JSONObject data) {
        JSONArray optJSONArray = data.optJSONArray("bind_banks");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            StringBuilder sb5 = new StringBuilder();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                sb5.append(optJSONArray.optJSONObject(i3).optString("card_tail"));
                sb5.append(",");
            }
            QLog.d(TAG, 1, "logBankInfo size=" + optJSONArray.length() + " tail=" + ((Object) sb5));
            return;
        }
        QLog.d(TAG, 1, "logBankInfo banks is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(PayEntryFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, com.tenpay.pay.HbPayChannelFragment] */
    public final void onStartPayChannel(JSONObject data) {
        FragmentManager supportFragmentManager;
        String str;
        String str2;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            ?? findFragmentByTag = supportFragmentManager.findFragmentByTag(HbPayChannelFragment.TAG);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String str3 = null;
            if (findFragmentByTag instanceof HbPayChannelFragment) {
                objectRef.element = findFragmentByTag;
                if (((HbPayChannelFragment) findFragmentByTag).isVisible()) {
                    ((HbPayChannelFragment) objectRef.element).renderQPayGate(data, this.newBindBankSerial);
                } else {
                    ((HbPayChannelFragment) objectRef.element).dismissAllowingStateLoss();
                    objectRef.element = null;
                    QLog.w(TAG, 1, "HbPayChannelFragment is invalid, dismiss it");
                }
            }
            if (objectRef.element == 0) {
                objectRef.element = new HbPayChannelFragment();
                Bundle bundle = new Bundle();
                Bundle arguments = getArguments();
                if (arguments != null) {
                    str = arguments.getString(IN_KEY_PAY_CHANNEL);
                } else {
                    str = null;
                }
                bundle.putString(HbPayChannelFragment.KEY_PAY_CHANNELS, str);
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    str2 = arguments2.getString(IN_KEY_TOKEN_ID);
                } else {
                    str2 = null;
                }
                bundle.putString("token_id", str2);
                Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    str3 = arguments3.getString(IN_KEY_COME_FROM);
                }
                bundle.putString("come_from", str3);
                bundle.putString("qpay_gate", data.toString());
                ((HbPayChannelFragment) objectRef.element).setArguments(bundle);
                HbPayChannelFragment hbPayChannelFragment = (HbPayChannelFragment) objectRef.element;
                FragmentActivity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentManager supportFragmentManager2 = activity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity as FragmentActi\u2026y).supportFragmentManager");
                hbPayChannelFragment.show(supportFragmentManager2, HbPayChannelFragment.TAG);
            }
            FragmentKt.setFragmentResultListener((Fragment) objectRef.element, "select_hb_channel_finish", new Function2<String, Bundle, Unit>() { // from class: com.tenpay.pay.PayEntryFragment$onStartPayChannel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str4, Bundle bundle2) {
                    invoke2(str4, bundle2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String str4, @NotNull Bundle bundle2) {
                    String str5;
                    Intrinsics.checkNotNullParameter(str4, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(bundle2, "bundle");
                    PayChannelBean payChannelBean = (PayChannelBean) bundle2.getParcelable("ret_channel");
                    str5 = PayEntryFragment.TAG;
                    boolean z16 = true;
                    QLog.i(str5, 1, "onReceive result: " + payChannelBean);
                    if (payChannelBean instanceof PayChannelBean.AddMore) {
                        PayEntryFragment.this.startBindCard((PayChannelBean.AddMore) payChannelBean);
                        z16 = false;
                    } else if (payChannelBean instanceof PayChannelBean.Wx) {
                        PayEntryFragment.this.startWeChatPay((PayChannelBean.Wx) payChannelBean);
                    } else {
                        if (payChannelBean instanceof PayChannelBean.Balance ? true : payChannelBean instanceof PayChannelBean.Bank) {
                            PayEntryFragment.this.startBalanceOrBankPay(payChannelBean);
                        } else {
                            PayEntryFragment.this.finish();
                        }
                    }
                    if (z16) {
                        FragmentKt.clearFragmentResultListener(objectRef.element, "select_hb_channel_finish");
                    }
                }
            });
            return;
        }
        QLog.w(TAG, 1, "onStartPayChannel, activity is null");
        finish();
    }

    private final void sendQPayGateRequest() {
        Map mapOf;
        Map mutableMap;
        boolean z16;
        showLoading();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", com.tencent.mobileqq.base.a.c()), TuplesKt.to("token_id", this.tokenId), TuplesKt.to("come_from", this.comeFrom), TuplesKt.to(j.T0, this.appInfo));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        NetSender.with(getContext(), Cgi.URI_PAY_GATE, mutableMap, com.tencent.mobileqq.base.a.c()).request(new Net.NetAdapter() { // from class: com.tenpay.pay.PayEntryFragment$sendQPayGateRequest$1
            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
                String str;
                String string;
                if (PayEntryFragment.this.isFinishing()) {
                    return;
                }
                PayEntryFragment.this.dismissLoading();
                if (PayEntryFragment.this.getContext() == null || data == null) {
                    str = PayEntryFragment.TAG;
                    QLog.w(str, 1, "onBlError: context is nulL, early return");
                    return;
                }
                final PayEntryFragment payEntryFragment = PayEntryFragment.this;
                if (!new QWalletFakeUrlHandler(PayEntryFragment.this.getContext(), null, 2, 0 == true ? 1 : 0).handle(requestUrl, data, new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.pay.PayEntryFragment$sendQPayGateRequest$1$onBlError$callback$1
                    @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
                    public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex index, @Nullable Uri uri) {
                        Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
                        Intrinsics.checkNotNullParameter(index, "index");
                        PayEntryFragment.this.finish();
                        return false;
                    }
                })) {
                    FakeInfo parseFrom = FakeInfo.INSTANCE.parseFrom(requestUrl, data);
                    if (parseFrom == null || (string = parseFrom.getRetMsg()) == null) {
                        string = PayEntryFragment.this.getString(R.string.e_t);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026.qb_tenpay_network_error)");
                    }
                    QQToastUtil.showQQToast(1, string);
                    PayEntryFragment.this.finish();
                }
            }

            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
                if (PayEntryFragment.this.isFinishing()) {
                    return;
                }
                PayEntryFragment.this.dismissLoading();
                if (requestUrl != null && data != null) {
                    PayEntryFragment.this.logBankInfo(data);
                    PayEntryFragment.this.qpayGateJSON = data;
                    PayEntryFragment.this.onStartPayChannel(data);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startBalanceOrBankPay(PayChannelBean payChannel) {
        if (payChannel instanceof PayChannelBean.Balance) {
            startPay(0, null, null);
        } else if (payChannel instanceof PayChannelBean.Bank) {
            PayChannelBean.Bank bank = (PayChannelBean.Bank) payChannel;
            startPay(1, bank.getIndexInJSON(), bank.getBankType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startBindCard(PayChannelBean.AddMore payChannelBean) {
        QLog.i(TAG, 1, "startBindCard");
        Intent intent = new Intent();
        intent.putExtra("token_id", payChannelBean.getTokenId());
        intent.putExtra("pass_flag", payChannelBean.getPassFlag());
        intent.putExtra("sourceId", this.sourceId);
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE_NAME, RealNameSource.INSTANCE.getSourceName(this.sourceId));
        BindBankModule bindBankModule = BindBankModule.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        bindBankModule.startWithSwitchForResult(requireContext, intent, 101, 0, false);
    }

    private final void startPay(int payType, Integer bankIndex, String bankType) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = this.qpayGateJSON;
            if (jSONObject2 != null) {
                str = jSONObject2.toString();
            } else {
                str = null;
            }
            jSONObject.put("pay_gate", str);
            jSONObject.put("tokenId", this.tokenId);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, this.comeFrom);
            jSONObject.put("h5_success", true);
            jSONObject.put("pay_by", payType);
            jSONObject.put("bank_index", bankIndex);
            jSONObject.put("bank_type", bankType);
            jSONObject.put("sourceId", this.sourceId);
            jSONObject.put(RealNameSource.EXTRA_KEY_SOURCE_NAME, RealNameSource.INSTANCE.getSourceName(this.sourceId));
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
            bundle.putString("callbackSn", "0");
            com.tencent.mobileqq.qwallet.utils.f.b(TAG, "startPay: " + jSONObject);
            PayBridgeActivity.tenpay(requireActivity(), 9, bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startPay2 error: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startWeChatPay(PayChannelBean.Wx payChannel) {
        Map mutableMapOf;
        QLog.i(TAG, 1, "startWeChatPay: " + payChannel);
        if (!TextUtils.isEmpty(payChannel.getUrl()) && this.wechatPayHelper.canJumpToWxMiniProgram()) {
            k.h(getActivity(), payChannel.getUrl());
            return;
        }
        this.wechatPayHelper.registerApp(payChannel.getAppId());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("come_from", payChannel.getComeFrom()), TuplesKt.to("token_id", payChannel.getTokenId()), TuplesKt.to("wxpay_auth", payChannel.getInfo()), TuplesKt.to("uin", com.tencent.mobileqq.base.a.c()));
        NetSender.with(getContext(), Cgi.URI_QPAY_HB_WXPACK, mutableMapOf, com.tencent.mobileqq.base.a.c()).request(new Net.NetAdapter() { // from class: com.tenpay.pay.PayEntryFragment$startWeChatPay$1
            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
                String str;
                if (PayEntryFragment.this.getContext() == null || data == null || PayEntryFragment.this.isFinishing()) {
                    str = PayEntryFragment.TAG;
                    QLog.w(str, 1, "onBlError: context is nulL, early return");
                    return;
                }
                final PayEntryFragment payEntryFragment = PayEntryFragment.this;
                if (!new QWalletFakeUrlHandler(PayEntryFragment.this.getContext(), null, 2, 0 == true ? 1 : 0).handle(requestUrl, data, new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.pay.PayEntryFragment$startWeChatPay$1$onBlError$onDialogBtnClick$1
                    @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
                    public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex index, @Nullable Uri uri) {
                        Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
                        Intrinsics.checkNotNullParameter(index, "index");
                        PayEntryFragment.this.finish();
                        return false;
                    }
                })) {
                    QQToastUtil.showQQToast(1, R.string.e_t);
                }
            }

            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
                String str;
                PayEntryFragment$wxPayCallback$1 payEntryFragment$wxPayCallback$1;
                WechatPayHelper wechatPayHelper;
                if (requestUrl != null && data != null && !PayEntryFragment.this.isFinishing()) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("broadcast_wx_pay_callback");
                    try {
                        Context context = PayEntryFragment.this.getContext();
                        if (context != null) {
                            PayEntryFragment payEntryFragment = PayEntryFragment.this;
                            payEntryFragment$wxPayCallback$1 = payEntryFragment.wxPayCallback;
                            context.registerReceiver(payEntryFragment$wxPayCallback$1, intentFilter);
                            wechatPayHelper = payEntryFragment.wechatPayHelper;
                            wechatPayHelper.pay(data, null);
                            payEntryFragment.isPayingWechat = true;
                        }
                    } catch (Exception e16) {
                        str = PayEntryFragment.TAG;
                        QLog.w(str, 1, "registerWxPayCallback error:", e16);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String stringExtra;
        super.onActivityResult(requestCode, resultCode, data);
        String str = TAG;
        QLog.i(str, 1, "onActivityResult: requestCode=" + requestCode + " resultCode=" + resultCode + " data=" + data);
        if (requestCode != 9) {
            if (requestCode != 101) {
                if (requestCode == 102) {
                    setResult(resultCode, data);
                    finish();
                }
            } else if (resultCode == -1) {
                if (data != null && (stringExtra = data.getStringExtra("bind_serial")) != null) {
                    this.newBindBankSerial = stringExtra;
                }
                QLog.i(str, 1, "bind card result: " + this.newBindBankSerial);
                sendQPayGateRequest();
            }
        } else {
            setResult(resultCode, data);
            finish();
        }
        QLog.i(str, 1, "onActivityResult: data=" + data + " requestCode=" + requestCode + " resultCode=" + resultCode);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        View view;
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        if (view != null) {
            view.setSystemUiVisibility(1792);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setNavigationBarColor(0);
        }
        initData();
        sendQPayGateRequest();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fyt, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.wechatPayHelper.release();
        try {
            Context context = getContext();
            if (context != null) {
                context.unregisterReceiver(this.wxPayCallback);
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "unregisterReceiver error:", e16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isPayingWechat) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tenpay.pay.f
                @Override // java.lang.Runnable
                public final void run() {
                    PayEntryFragment.onResume$lambda$0(PayEntryFragment.this);
                }
            }, 100L);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
