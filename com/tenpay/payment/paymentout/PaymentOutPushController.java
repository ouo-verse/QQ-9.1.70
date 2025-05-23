package com.tenpay.payment.paymentout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tenpay.payment.PaymentPushData;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.PayActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\"#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u000f\u001a\u00020\fJ\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\fJ\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutPushController;", "Landroid/content/BroadcastReceiver;", "fragment", "Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "qrCodeController", "Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController;", "(Lcom/tenpay/payment/paymentout/PaymentOutFragment;Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController;)V", "fragmentRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "qrCodeControllerRef", "launchPayActivity", "", "pushAction2", "Lcom/tenpay/payment/paymentout/PaymentOutPushController$PushAction2;", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onQueryTransSuccess", "data", "Lorg/json/JSONObject;", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onResume", "onSuccess", BrowserPlugin.KEY_REQUEST_URL, "", "requestQueryTrans", "pushAction1", "Lcom/tenpay/payment/paymentout/PaymentOutPushController$PushAction1;", "showReGenPayCodeDialog", "showRefreshCodeDialog", "showReopenCodeDialog", "PushAction1", "PushAction2", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentOutPushController extends BroadcastReceiver {

    @NotNull
    private final WeakReference<PaymentOutFragment> fragmentRef;

    @NotNull
    private final WeakReference<PaymentOutQrCodeController> qrCodeControllerRef;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutPushController$PushAction1;", "", HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, "", "bankType", "attach", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttach", "()Ljava/lang/String;", "getBankType", "getTransId", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class PushAction1 {

        @SerializedName("attach")
        @Nullable
        private final String attach;

        @SerializedName("bank_type")
        @Nullable
        private final String bankType;

        @SerializedName("trans_id")
        @Nullable
        private final String transId;

        @SerializedName("url")
        @Nullable
        private final String url;

        public PushAction1(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.transId = str;
            this.bankType = str2;
            this.attach = str3;
            this.url = str4;
        }

        public static /* synthetic */ PushAction1 copy$default(PushAction1 pushAction1, String str, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pushAction1.transId;
            }
            if ((i3 & 2) != 0) {
                str2 = pushAction1.bankType;
            }
            if ((i3 & 4) != 0) {
                str3 = pushAction1.attach;
            }
            if ((i3 & 8) != 0) {
                str4 = pushAction1.url;
            }
            return pushAction1.copy(str, str2, str3, str4);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getTransId() {
            return this.transId;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getBankType() {
            return this.bankType;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getAttach() {
            return this.attach;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final PushAction1 copy(@Nullable String transId, @Nullable String bankType, @Nullable String attach, @Nullable String url) {
            return new PushAction1(transId, bankType, attach, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PushAction1)) {
                return false;
            }
            PushAction1 pushAction1 = (PushAction1) other;
            if (Intrinsics.areEqual(this.transId, pushAction1.transId) && Intrinsics.areEqual(this.bankType, pushAction1.bankType) && Intrinsics.areEqual(this.attach, pushAction1.attach) && Intrinsics.areEqual(this.url, pushAction1.url)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getAttach() {
            return this.attach;
        }

        @Nullable
        public final String getBankType() {
            return this.bankType;
        }

        @Nullable
        public final String getTransId() {
            return this.transId;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.transId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.bankType;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.attach;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.url;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "PushAction1(transId=" + this.transId + ", bankType=" + this.bankType + ", attach=" + this.attach + ", url=" + this.url + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutPushController$PushAction2;", "", "tokenId", "", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getTokenId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class PushAction2 {

        @SerializedName("msg")
        @Nullable
        private final String msg;

        @SerializedName("token_id")
        @Nullable
        private final String tokenId;

        public PushAction2(@Nullable String str, @Nullable String str2) {
            this.tokenId = str;
            this.msg = str2;
        }

        public static /* synthetic */ PushAction2 copy$default(PushAction2 pushAction2, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pushAction2.tokenId;
            }
            if ((i3 & 2) != 0) {
                str2 = pushAction2.msg;
            }
            return pushAction2.copy(str, str2);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getTokenId() {
            return this.tokenId;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final PushAction2 copy(@Nullable String tokenId, @Nullable String msg2) {
            return new PushAction2(tokenId, msg2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PushAction2)) {
                return false;
            }
            PushAction2 pushAction2 = (PushAction2) other;
            if (Intrinsics.areEqual(this.tokenId, pushAction2.tokenId) && Intrinsics.areEqual(this.msg, pushAction2.msg)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        public final String getTokenId() {
            return this.tokenId;
        }

        public int hashCode() {
            int hashCode;
            String str = this.tokenId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.msg;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "PushAction2(tokenId=" + this.tokenId + ", msg=" + this.msg + ")";
        }
    }

    public PaymentOutPushController(@NotNull PaymentOutFragment fragment, @NotNull PaymentOutQrCodeController qrCodeController) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(qrCodeController, "qrCodeController");
        this.fragmentRef = new WeakReference<>(fragment);
        this.qrCodeControllerRef = new WeakReference<>(qrCodeController);
    }

    private final void launchPayActivity(PushAction2 pushAction2, PaymentOutFragment fragment) {
        Intent intent = new Intent();
        intent.putExtra("token_id", pushAction2.getTokenId());
        intent.putExtra("isInner", true);
        fragment.launchFragment(intent, PayActivity.class);
    }

    private final void onQueryTransSuccess(JSONObject data) {
        boolean z16;
        Context context;
        if (data == null) {
            return;
        }
        String payDesc = data.optString("pay_type_desc");
        int optInt = data.optInt("bank_type");
        boolean z17 = true;
        if (payDesc != null && payDesc.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        int i3 = 2;
        if (!z16) {
            Intrinsics.checkNotNullExpressionValue(payDesc, "payDesc");
        } else if (optInt == 0) {
            payDesc = "\u8d22\u4ed8\u901a\u4f59\u989d";
            i3 = 1;
        } else {
            payDesc = data.optString("bank_name");
            Intrinsics.checkNotNullExpressionValue(payDesc, "data.optString(\"bank_name\")");
        }
        Intent intent = new Intent();
        intent.setFlags(67108864);
        String optString = data.optString("total_fee_a57");
        if (optString != null && optString.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            intent.putExtra("real_total", optString);
            intent.putExtra("original_total", optString);
        }
        intent.putExtra("success", data.toString());
        intent.putExtra("process_flag", 132);
        intent.putExtra("iPayFrom", 8);
        intent.putExtra("isFriendPay", false);
        intent.putExtra("mSelectedPayType", i3);
        intent.putExtra(DefaultTVKDataProvider.KEY_PAY_TYPE, payDesc);
        PaymentOutFragment paymentOutFragment = this.fragmentRef.get();
        if (paymentOutFragment != null) {
            context = paymentOutFragment.getContext();
        } else {
            context = null;
        }
        com.tencent.mobileqq.qwallet.pay.k.a(context, intent);
    }

    private final void requestQueryTrans(PushAction1 pushAction1, PaymentOutFragment fragment) {
        boolean z16;
        HashMap hashMap = new HashMap();
        hashMap.put("uin", com.tencent.mobileqq.base.a.c());
        String transId = pushAction1.getTransId();
        String str = "";
        if (transId == null) {
            transId = "";
        }
        hashMap.put("trans_id", transId);
        String bankType = pushAction1.getBankType();
        if (bankType == null) {
            bankType = "";
        }
        hashMap.put("bank_type", bankType);
        String attach = pushAction1.getAttach();
        if (attach != null) {
            str = attach;
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            hashMap.put("attach", str);
        }
        fragment.httpRequest(Cgi.URI_QUERY_TRANS, hashMap);
    }

    private final void showReGenPayCodeDialog(final PaymentOutFragment fragment) {
        QUIProxy.createCustomDialog(fragment.getContext(), 230, null, "\u4f60\u7684\u4ed8\u6b3e\u7801\u5df2\u8fc7\u671f", fragment.getString(R.string.e2i), fragment.getString(R.string.f21820633), new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutPushController.showReGenPayCodeDialog$lambda$5(PaymentOutPushController.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutPushController.showReGenPayCodeDialog$lambda$6(PaymentOutFragment.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGenPayCodeDialog$lambda$5(PaymentOutPushController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PaymentOutQrCodeController paymentOutQrCodeController = this$0.qrCodeControllerRef.get();
        if (paymentOutQrCodeController != null) {
            paymentOutQrCodeController.requestPayCodeGen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGenPayCodeDialog$lambda$6(PaymentOutFragment fragment, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        fragment.finish();
    }

    private final void showRefreshCodeDialog(PushAction2 pushAction2, PaymentOutFragment fragment) {
        QUIProxy.createCustomDialog(fragment.getContext(), 230, null, pushAction2.getMsg(), null, fragment.getString(R.string.e5j), new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutPushController.showRefreshCodeDialog$lambda$2(PaymentOutPushController.this, dialogInterface, i3);
            }
        }, null);
        com.tencent.mobileqq.qwallet.c.f("paycode.error.show", null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRefreshCodeDialog$lambda$2(PaymentOutPushController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        PaymentOutQrCodeController paymentOutQrCodeController = this$0.qrCodeControllerRef.get();
        if (paymentOutQrCodeController != null) {
            paymentOutQrCodeController.showCodeView();
        }
    }

    private final void showReopenCodeDialog(final PaymentOutFragment fragment) {
        QUIProxy.createCustomDialog(fragment.getContext(), 230, null, "\u4f60\u9700\u8981\u91cd\u65b0\u5f00\u901a\u4ed8\u6b3e\u7801", fragment.getString(R.string.e2i), fragment.getString(R.string.f21821634), new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutPushController.showReopenCodeDialog$lambda$3(PaymentOutPushController.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutPushController.showReopenCodeDialog$lambda$4(PaymentOutPushController.this, fragment, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReopenCodeDialog$lambda$3(PaymentOutPushController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PaymentOutQrCodeController paymentOutQrCodeController = this$0.qrCodeControllerRef.get();
        if (paymentOutQrCodeController != null) {
            paymentOutQrCodeController.closeQrPay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReopenCodeDialog$lambda$4(PaymentOutPushController this$0, PaymentOutFragment fragment, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        PaymentOutQrCodeController paymentOutQrCodeController = this$0.qrCodeControllerRef.get();
        if (paymentOutQrCodeController != null) {
            paymentOutQrCodeController.closeQrPay();
        }
        fragment.finish();
    }

    public final void onPause() {
        PaymentOutFragment paymentOutFragment = this.fragmentRef.get();
        if (paymentOutFragment != null) {
            paymentOutFragment.unregisterReceiver(this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String stringExtra;
        PaymentPushData paymentPushData;
        boolean z16;
        String action;
        PushAction1 pushAction1;
        PushAction2 pushAction2;
        if (intent != null && (stringExtra = intent.getStringExtra("extra_data")) != null) {
            try {
                paymentPushData = PaymentPushData.INSTANCE.fromJson(stringExtra, Object.class);
            } catch (Exception e16) {
                QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "paymentOutPushReceiver receive error", e16);
                paymentPushData = null;
            }
            if (paymentPushData != null) {
                String extendRow = paymentPushData.getExtendRow();
                if (extendRow != null && extendRow.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    PaymentOutFragment paymentOutFragment = this.fragmentRef.get();
                    if (paymentOutFragment != null && (action = paymentPushData.getAction()) != null) {
                        switch (action.hashCode()) {
                            case 49:
                                if (!action.equals("1") || (pushAction1 = (PushAction1) paymentPushData.parseExtend(PushAction1.class)) == null) {
                                    return;
                                }
                                QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "onReceive: " + pushAction1);
                                if (Intrinsics.areEqual(paymentPushData.getType(), "success")) {
                                    requestQueryTrans(pushAction1, paymentOutFragment);
                                    return;
                                } else {
                                    if (Intrinsics.areEqual(paymentPushData.getType(), "h5")) {
                                        com.tencent.mobileqq.qwallet.utils.k.h(paymentOutFragment.getContext(), pushAction1.getUrl());
                                        return;
                                    }
                                    return;
                                }
                            case 50:
                                if (!action.equals("2") || (pushAction2 = (PushAction2) paymentPushData.parseExtend(PushAction2.class)) == null) {
                                    return;
                                }
                                QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "onReceive: " + pushAction2);
                                if (Intrinsics.areEqual(paymentPushData.getType(), "normal_pay")) {
                                    launchPayActivity(pushAction2, paymentOutFragment);
                                    return;
                                } else {
                                    showRefreshCodeDialog(pushAction2, paymentOutFragment);
                                    return;
                                }
                            case 51:
                                if (action.equals("3")) {
                                    QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "onReceive: " + paymentPushData);
                                    if (Intrinsics.areEqual(paymentPushData.getType(), "update_cert")) {
                                        showReopenCodeDialog(paymentOutFragment);
                                        return;
                                    } else {
                                        if (Intrinsics.areEqual(paymentPushData.getType(), "update_authcode")) {
                                            showReGenPayCodeDialog(paymentOutFragment);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                }
            }
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "paymentOutPushReceiver error, paymentPushData invalid");
        }
    }

    public final void onResume() {
        PaymentOutFragment paymentOutFragment = this.fragmentRef.get();
        if (paymentOutFragment != null) {
            paymentOutFragment.registerReceiver(this, new IntentFilter(Cgi.BROADCAST_INTENT_ACTION_PUSH));
        }
    }

    public final void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        if (Intrinsics.areEqual(Cgi.URI_QUERY_TRANS, requestUrl)) {
            onQueryTransSuccess(data);
        }
    }
}
