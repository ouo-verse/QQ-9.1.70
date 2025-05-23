package com.tenpay.payment.paymentin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.google.gson.annotations.SerializedName;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.QWalletAvatarLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tenpay.payment.PaymentPushData;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.payment.paymentin.PaymentInPushController;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.view.QrTransUserCard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000e\u0018\u00002\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/payment/paymentin/PaymentInPushController;", "", "fragment", "Lcom/tenpay/payment/paymentin/PaymentInFragment;", "avatarLoader", "Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;", "(Lcom/tenpay/payment/paymentin/PaymentInFragment;Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;)V", "balanceLine", "Landroid/view/View;", "balanceView", "payingListContainer", "Landroid/view/ViewGroup;", "payingRootView", "payingUserListener", "com/tenpay/payment/paymentin/PaymentInPushController$payingUserListener$1", "Lcom/tenpay/payment/paymentin/PaymentInPushController$payingUserListener$1;", "pushUserMap", "Ljava/util/HashMap;", "", "Lcom/tenpay/sdk/view/QrTransUserCard;", "Lkotlin/collections/HashMap;", "scanTipsView", "initView", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onDestroyView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "updateUserView", "pushData", "Lcom/tenpay/payment/paymentin/PaymentInPushController$UpdateUserPush;", "UpdateUserPush", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentInPushController {

    @NotNull
    private final QWalletAvatarLoader avatarLoader;
    private View balanceLine;
    private View balanceView;

    @NotNull
    private final PaymentInFragment fragment;
    private ViewGroup payingListContainer;
    private ViewGroup payingRootView;

    @NotNull
    private PaymentInPushController$payingUserListener$1 payingUserListener;

    @NotNull
    private final HashMap<String, QrTransUserCard> pushUserMap;
    private View scanTipsView;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tenpay/payment/paymentin/PaymentInPushController$UpdateUserPush;", "", "fromUin", "", "fromName", "payStatus", "", "payMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFromName", "()Ljava/lang/String;", "getFromUin", "getPayMsg", "getPayStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tenpay/payment/paymentin/PaymentInPushController$UpdateUserPush;", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class UpdateUserPush {

        @SerializedName("from_name")
        @Nullable
        private final String fromName;

        @SerializedName(ShortVideoConstants.FROM_UIN)
        @Nullable
        private final String fromUin;

        @SerializedName("pay_msg")
        @Nullable
        private final String payMsg;

        @SerializedName(DefaultTVKDataProvider.KEY_PAY_STATUS)
        @Nullable
        private final Integer payStatus;

        public UpdateUserPush(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3) {
            this.fromUin = str;
            this.fromName = str2;
            this.payStatus = num;
            this.payMsg = str3;
        }

        public static /* synthetic */ UpdateUserPush copy$default(UpdateUserPush updateUserPush, String str, String str2, Integer num, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = updateUserPush.fromUin;
            }
            if ((i3 & 2) != 0) {
                str2 = updateUserPush.fromName;
            }
            if ((i3 & 4) != 0) {
                num = updateUserPush.payStatus;
            }
            if ((i3 & 8) != 0) {
                str3 = updateUserPush.payMsg;
            }
            return updateUserPush.copy(str, str2, num, str3);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getFromUin() {
            return this.fromUin;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getFromName() {
            return this.fromName;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Integer getPayStatus() {
            return this.payStatus;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getPayMsg() {
            return this.payMsg;
        }

        @NotNull
        public final UpdateUserPush copy(@Nullable String fromUin, @Nullable String fromName, @Nullable Integer payStatus, @Nullable String payMsg) {
            return new UpdateUserPush(fromUin, fromName, payStatus, payMsg);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateUserPush)) {
                return false;
            }
            UpdateUserPush updateUserPush = (UpdateUserPush) other;
            if (Intrinsics.areEqual(this.fromUin, updateUserPush.fromUin) && Intrinsics.areEqual(this.fromName, updateUserPush.fromName) && Intrinsics.areEqual(this.payStatus, updateUserPush.payStatus) && Intrinsics.areEqual(this.payMsg, updateUserPush.payMsg)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getFromName() {
            return this.fromName;
        }

        @Nullable
        public final String getFromUin() {
            return this.fromUin;
        }

        @Nullable
        public final String getPayMsg() {
            return this.payMsg;
        }

        @Nullable
        public final Integer getPayStatus() {
            return this.payStatus;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.fromUin;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.fromName;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Integer num = this.payStatus;
            if (num == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = num.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str3 = this.payMsg;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "UpdateUserPush(fromUin=" + this.fromUin + ", fromName=" + this.fromName + ", payStatus=" + this.payStatus + ", payMsg=" + this.payMsg + ")";
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tenpay.payment.paymentin.PaymentInPushController$payingUserListener$1] */
    public PaymentInPushController(@NotNull PaymentInFragment fragment, @NotNull QWalletAvatarLoader avatarLoader) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(avatarLoader, "avatarLoader");
        this.fragment = fragment;
        this.avatarLoader = avatarLoader;
        this.pushUserMap = new HashMap<>();
        this.payingUserListener = new BroadcastReceiver() { // from class: com.tenpay.payment.paymentin.PaymentInPushController$payingUserListener$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String stringExtra;
                PaymentInPushController.UpdateUserPush updateUserPush;
                if (intent != null && (stringExtra = intent.getStringExtra("extra_data")) != null) {
                    try {
                        PaymentPushData fromJson = PaymentPushData.INSTANCE.fromJson(stringExtra, PaymentInPushController.UpdateUserPush.class);
                        if (fromJson != null) {
                            updateUserPush = (PaymentInPushController.UpdateUserPush) fromJson.getExtend();
                        } else {
                            updateUserPush = null;
                        }
                        if (updateUserPush != null && Intrinsics.areEqual(fromJson.getAction(), "1") && Intrinsics.areEqual(fromJson.getType(), "qrcode_trans")) {
                            PaymentInPushController.this.updateUserView((PaymentInPushController.UpdateUserPush) fromJson.getExtend());
                        }
                    } catch (Exception e16) {
                        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "payingUserListener receive error", e16);
                    }
                }
            }
        };
    }

    private final void initView(View rootView) {
        View findViewById = rootView.findViewById(R.id.jvu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.translist_layout)");
        this.payingRootView = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f166492fk1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.paying_list_layout)");
        this.payingListContainer = (ViewGroup) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.igt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.scan_pay_text)");
        this.scanTipsView = findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f231405m);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ent_in_goto_balance_line)");
        this.balanceLine = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f231305l);
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentin.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentInPushController.initView$lambda$1$lambda$0(PaymentInPushController.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<Vi\u2026)\n            }\n        }");
        this.balanceView = findViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(PaymentInPushController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fragment.gotoQWalletActivity(3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserView(UpdateUserPush pushData) {
        int i3;
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "updateUserView: " + pushData);
        String fromUin = pushData.getFromUin();
        if (fromUin == null) {
            fromUin = "";
        }
        Integer payStatus = pushData.getPayStatus();
        if (payStatus != null) {
            i3 = payStatus.intValue();
        } else {
            i3 = 1;
        }
        QrTransUserCard qrTransUserCard = this.pushUserMap.get(fromUin);
        View view = null;
        if (qrTransUserCard == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            QrTransUserCard qrTransUserCard2 = new QrTransUserCard(this.fragment.getContext());
            qrTransUserCard2.setTitle(pushData.getFromName());
            qrTransUserCard2.setAmount(i3, pushData.getPayMsg());
            Drawable drawable = ContextCompat.getDrawable(qrTransUserCard2.getContext(), R.drawable.dxx);
            qrTransUserCard2.setLogoDrawable(new QWalletAvatarLoader.FaceDrawable(fromUin, drawable, drawable, this.avatarLoader));
            ViewGroup viewGroup = this.payingListContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payingListContainer");
                viewGroup = null;
            }
            viewGroup.addView(qrTransUserCard2, 0, layoutParams);
            ViewGroup viewGroup2 = this.payingRootView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payingRootView");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            this.pushUserMap.put(fromUin, qrTransUserCard2);
        } else {
            qrTransUserCard.setAmount(i3, pushData.getPayMsg());
            if (i3 == 3) {
                this.pushUserMap.remove(fromUin);
            }
        }
        if (i3 == 3) {
            View view2 = this.balanceView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("balanceView");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.balanceLine;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("balanceLine");
                view3 = null;
            }
            view3.setVisibility(0);
        }
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            View view4 = this.scanTipsView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTipsView");
            } else {
                view = view4;
            }
            view.setVisibility(0);
            return;
        }
        View view5 = this.scanTipsView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTipsView");
        } else {
            view = view5;
        }
        view.setVisibility(8);
    }

    public final void onDestroyView() {
        this.fragment.unregisterReceiver(this.payingUserListener);
    }

    public final void onViewCreated(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        initView(rootView);
        this.fragment.registerReceiver(this.payingUserListener, new IntentFilter(Cgi.BROADCAST_INTENT_ACTION_PUSH));
    }
}
