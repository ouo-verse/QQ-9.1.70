package com.tenpay.payment.paymentout;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.api.BankImageUtil;
import com.tenpay.payment.PaymentUtils;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.payment.paymentout.PaymentOutQrCodeController;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.MaxHeightScrollView;
import com.tenpay.sdk.view.PayTypeCard;
import com.tenpay.util.Utils;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001.B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\nJ\b\u0010\u001d\u001a\u00020\fH\u0002J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010 \u001a\u00020\u001aJ\u0012\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0014J\u0006\u0010&\u001a\u00020\nJ\u0010\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutPayTypeController;", "", "fragment", "Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "callback", "Lcom/tenpay/payment/paymentout/PaymentOutPayTypeController$IPayTypeChangeCallback;", "qrCodePayBean", "Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$QrCodePayBean;", "(Lcom/tenpay/payment/paymentout/PaymentOutFragment;Lcom/tenpay/payment/paymentout/PaymentOutPayTypeController$IPayTypeChangeCallback;Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$QrCodePayBean;)V", "bBindCard", "", "balance", "", "bankListContainer", "Landroid/widget/LinearLayout;", "bankListScrollView", "Lcom/tenpay/sdk/view/MaxHeightScrollView;", "getFragment", "()Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "selectBankDialogRoot", "Landroid/view/View;", "selectedBankLogo", "Landroid/widget/ImageView;", "selectedBankName", "Landroid/widget/TextView;", "adjustListLayout", "", "changePayTypeDialogState", ViewStickEventHelper.IS_SHOW, "getBalanceText", "initBalanceItem", "text", "initPayBank", "initSelectView", "payTypeJSONArray", "Lorg/json/JSONArray;", "initView", "view", "isShowingDialog", "onWalletGateInited", "walletGateData", "Lorg/json/JSONObject;", "parsePayTypes", "selectPayType", "index", "", "IPayTypeChangeCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentOutPayTypeController {
    private boolean bBindCard;

    @Nullable
    private String balance;
    private LinearLayout bankListContainer;
    private MaxHeightScrollView bankListScrollView;

    @NotNull
    private final IPayTypeChangeCallback callback;

    @NotNull
    private final PaymentOutFragment fragment;

    @NotNull
    private final PaymentOutQrCodeController.QrCodePayBean qrCodePayBean;
    private View selectBankDialogRoot;
    private ImageView selectedBankLogo;
    private TextView selectedBankName;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutPayTypeController$IPayTypeChangeCallback;", "", "onPayTypeChange", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IPayTypeChangeCallback {
        void onPayTypeChange();
    }

    public PaymentOutPayTypeController(@NotNull PaymentOutFragment fragment, @NotNull IPayTypeChangeCallback callback, @NotNull PaymentOutQrCodeController.QrCodePayBean qrCodePayBean) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(qrCodePayBean, "qrCodePayBean");
        this.fragment = fragment;
        this.callback = callback;
        this.qrCodePayBean = qrCodePayBean;
    }

    private final void adjustListLayout() {
        LinearLayout linearLayout = this.bankListContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankListContainer");
            linearLayout = null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout2 = this.bankListContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bankListContainer");
                linearLayout2 = null;
            }
            View childAt = linearLayout2.getChildAt(i3);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.tenpay.sdk.view.PayTypeCard");
            ((PayTypeCard) childAt).updateBgRound(i3, childCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changePayTypeDialogState$lambda$11(PaymentOutPayTypeController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIImmersiveHelper.s(this$0.fragment.getActivity(), true, true);
    }

    private final String getBalanceText() {
        StringBuilder sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.f2180562o));
        if (!TextUtils.isEmpty(this.balance)) {
            sb5.append("(");
            sb5.append(Utils.fen2Yuan(this.balance));
            sb5.append("\u5143)");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    private final void initBalanceItem(String text) {
        boolean z16;
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        LinearLayout linearLayout = this.bankListContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankListContainer");
            linearLayout = null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout2 = this.bankListContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bankListContainer");
                linearLayout2 = null;
            }
            View childAt = linearLayout2.getChildAt(i3);
            if (childAt != null && (childAt instanceof PayTypeCard)) {
                ((PayTypeCard) childAt).setTitle(text);
                return;
            }
        }
    }

    private final void initSelectView(JSONArray payTypeJSONArray) {
        boolean z16;
        String str;
        boolean z17;
        boolean z18;
        LinearLayout linearLayout = this.bankListContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankListContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        if (payTypeJSONArray != null) {
            int length = payTypeJSONArray.length();
            this.bBindCard = true;
            final int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject = payTypeJSONArray.optJSONObject(i3);
                PayTypeCard payTypeCard = new PayTypeCard(this.fragment.getContext());
                String optString = optJSONObject.optString("name");
                if (Intrinsics.areEqual("D", optJSONObject.optString("card_type"))) {
                    str = "\u50a8\u84c4\u5361";
                } else {
                    str = "\u4fe1\u7528\u5361";
                }
                String str2 = optString + str;
                String optString2 = optJSONObject.optString("card_tail");
                if (!TextUtils.isEmpty(optString2)) {
                    str2 = str2 + "(" + optString2 + ")";
                }
                payTypeCard.setTitle(str2);
                i3++;
                if (i3 == this.qrCodePayBean.getPayTypeIndex()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                payTypeCard.setSelected(z17);
                String optString3 = optJSONObject.optString("disable");
                if (!TextUtils.isEmpty(optString3) && Intrinsics.areEqual(optString3, "6")) {
                    String optString4 = optJSONObject.optString("disable_comment");
                    payTypeCard.setSubTitle(true, optString4, optString4, null);
                    z18 = true;
                } else {
                    z18 = false;
                }
                payTypeCard.setLogoId(optJSONObject.optString("image_id"), z18);
                payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PaymentOutPayTypeController.initSelectView$lambda$6(PaymentOutPayTypeController.this, i3, view);
                    }
                });
                LinearLayout linearLayout3 = this.bankListContainer;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bankListContainer");
                    linearLayout3 = null;
                }
                linearLayout3.addView(payTypeCard, layoutParams);
            }
        }
        PayTypeCard payTypeCard2 = new PayTypeCard(this.fragment.getContext());
        payTypeCard2.setLogoId(R.drawable.dvp);
        payTypeCard2.setTitle(getBalanceText());
        if (this.qrCodePayBean.getPayTypeIndex() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        payTypeCard2.setSelected(z16);
        payTypeCard2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentOutPayTypeController.initSelectView$lambda$7(PaymentOutPayTypeController.this, view);
            }
        });
        LinearLayout linearLayout4 = this.bankListContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankListContainer");
        } else {
            linearLayout2 = linearLayout4;
        }
        linearLayout2.addView(payTypeCard2, 0, layoutParams);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "initSelectView, END");
        adjustListLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSelectView$lambda$6(PaymentOutPayTypeController this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectPayType(i3);
        this$0.changePayTypeDialogState(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSelectView$lambda$7(PaymentOutPayTypeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectPayType(0);
        this$0.changePayTypeDialogState(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(PaymentOutPayTypeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.changePayTypeDialogState(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(PaymentOutPayTypeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.changePayTypeDialogState(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$4(PaymentOutPayTypeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.changePayTypeDialogState(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final JSONArray parsePayTypes() {
        boolean z16;
        List emptyList;
        List emptyList2;
        List emptyList3;
        int i3;
        int i16;
        int i17;
        boolean z17;
        int i18 = 2;
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 2, "parsePayTypes, payTypes=" + this.qrCodePayBean.getPayTypes());
        JSONArray jSONArray = new JSONArray();
        int i19 = 1;
        try {
            int i26 = 0;
            if (this.qrCodePayBean.getPayTypes().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                List<String> split = new Regex("\\|").split(this.qrCodePayBean.getPayTypes(), 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                int length = strArr.length;
                int i27 = 0;
                while (i27 < length) {
                    JSONObject jSONObject = new JSONObject();
                    List<String> split2 = new Regex(ContainerUtils.FIELD_DELIMITER).split(strArr[i27], i26);
                    if (!split2.isEmpty()) {
                        ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() == 0) {
                                i17 = i19;
                            } else {
                                i17 = i26;
                            }
                            if (i17 == 0) {
                                emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + i19);
                                break;
                            }
                        }
                    }
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    Object[] array2 = emptyList2.toArray(new String[i26]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr2 = (String[]) array2;
                    int length2 = strArr2.length;
                    int i28 = i26;
                    while (i28 < length2) {
                        List<String> split3 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(strArr2[i28], i26);
                        if (!split3.isEmpty()) {
                            ListIterator<String> listIterator3 = split3.listIterator(split3.size());
                            while (listIterator3.hasPrevious()) {
                                if (listIterator3.previous().length() == 0) {
                                    i16 = i19;
                                } else {
                                    i16 = i26;
                                }
                                if (i16 == 0) {
                                    emptyList3 = CollectionsKt___CollectionsKt.take(split3, listIterator3.nextIndex() + i19);
                                    break;
                                }
                            }
                        }
                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                        Object[] array3 = emptyList3.toArray(new String[i26]);
                        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String[] strArr3 = (String[]) array3;
                        if (strArr3.length > i18) {
                            StringBuffer stringBuffer = new StringBuffer();
                            int length3 = strArr3.length;
                            int i29 = i19;
                            while (i29 < length3) {
                                if (i29 > i19) {
                                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                }
                                stringBuffer.append(strArr3[i29]);
                                i29++;
                                i19 = 1;
                            }
                            jSONObject.put(strArr3[0], stringBuffer.toString());
                            i3 = 0;
                            i18 = 2;
                        } else {
                            i18 = 2;
                            if (strArr3.length == 2) {
                                jSONObject.put(strArr3[0], strArr3[1]);
                            } else if (strArr3.length == 1) {
                                i3 = 0;
                                jSONObject.put(strArr3[0], "");
                            }
                            i3 = 0;
                        }
                        i28++;
                        i26 = i3;
                        i19 = 1;
                    }
                    int i36 = i26;
                    if (!TextUtils.isEmpty(jSONObject.optString("name"))) {
                        jSONArray.mo162put(jSONObject);
                    }
                    i27++;
                    i26 = i36;
                    i19 = 1;
                }
            }
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "parsePayTypes fail:", e16);
        }
        return jSONArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v18, types: [android.widget.ImageView] */
    private final void selectPayType(int index) {
        List split$default;
        String str;
        String str2;
        String str3;
        String str4;
        this.qrCodePayBean.setPayTypeIndex(index);
        if (this.qrCodePayBean.getPayTypeIndex() != 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) this.qrCodePayBean.getPayTypes(), new String[]{"\\|"}, false, 0, 6, (Object) null);
            if (split$default.size() >= this.qrCodePayBean.getPayTypeIndex()) {
                PaymentUtils.INSTANCE.saveQrcodeLastPayType((String) split$default.get(this.qrCodePayBean.getPayTypeIndex() - 1));
                this.qrCodePayBean.setQrPayType((String) split$default.get(r0.getPayTypeIndex() - 1));
            }
        } else {
            PaymentUtils.INSTANCE.saveQrcodeLastPayType("0");
            this.qrCodePayBean.setQrPayType("0");
        }
        JSONArray parsePayTypes = parsePayTypes();
        initSelectView(parsePayTypes);
        TextView textView = null;
        if (this.qrCodePayBean.getPayTypeIndex() == 0) {
            TextView textView2 = this.selectedBankName;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
                textView2 = null;
            }
            textView2.setText(this.fragment.getString(R.string.f2180562o));
            ?? r75 = this.selectedBankLogo;
            if (r75 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankLogo");
            } else {
                textView = r75;
            }
            textView.setBackgroundResource(R.drawable.dvp);
        } else {
            JSONObject optJSONObject = parsePayTypes.optJSONObject(this.qrCodePayBean.getPayTypeIndex() - 1);
            if (optJSONObject != null) {
                str = optJSONObject.optString("name");
            } else {
                str = null;
            }
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("card_type");
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual("D", str2)) {
                str3 = "\u50a8\u84c4\u5361";
            } else {
                str3 = "\u4fe1\u7528\u5361";
            }
            String str5 = str + str3;
            if (optJSONObject != null) {
                str4 = optJSONObject.optString("card_tail");
            } else {
                str4 = null;
            }
            if (!TextUtils.isEmpty(str4)) {
                str5 = str5 + "(" + str4 + ")";
            }
            TextView textView3 = this.selectedBankName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
                textView3 = null;
            }
            textView3.setText(str5);
            BankImageUtil bankImageUtil = BankImageUtil.getInstance(this.fragment.getContext());
            String optString = optJSONObject.optString("image_id");
            ImageView imageView = this.selectedBankLogo;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankLogo");
                imageView = null;
            }
            bankImageUtil.setBankImage(optString, imageView);
            TextView textView4 = this.selectedBankName;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
            } else {
                textView = textView4;
            }
            textView.setTextColor(this.fragment.getResources().getColor(R.color.f156931fl));
        }
        this.callback.onPayTypeChange();
    }

    public final void changePayTypeDialogState(boolean isShow) {
        boolean z16;
        View view = null;
        if (isShow) {
            String str = this.balance;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                initBalanceItem(getBalanceText());
            }
            View view2 = this.selectBankDialogRoot;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBankDialogRoot");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.selectBankDialogRoot;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBankDialogRoot");
            } else {
                view = view3;
            }
            view.findViewById(R.id.adk).startAnimation(AnimationUtils.loadAnimation(this.fragment.getContext(), R.anim.f154875ep));
            com.tencent.mobileqq.qwallet.c.f("paycode.showpaycode.exchange", null, null, null, null, 30, null);
        } else {
            View view4 = this.selectBankDialogRoot;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBankDialogRoot");
                view4 = null;
            }
            view4.setVisibility(8);
            View view5 = this.selectBankDialogRoot;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBankDialogRoot");
            } else {
                view = view5;
            }
            view.findViewById(R.id.adk).startAnimation(AnimationUtils.loadAnimation(this.fragment.getContext(), R.anim.f154878es));
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tenpay.payment.paymentout.k
            @Override // java.lang.Runnable
            public final void run() {
                PaymentOutPayTypeController.changePayTypeDialogState$lambda$11(PaymentOutPayTypeController.this);
            }
        });
    }

    @NotNull
    public final PaymentOutFragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [android.widget.ImageView] */
    public final void initPayBank() {
        boolean z16;
        List split$default;
        boolean z17;
        int indexOf;
        String str;
        onWalletGateInited(WalletGateData.getInstance().getData());
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "qrCodePayBean=" + this.qrCodePayBean);
        String payTypes = this.qrCodePayBean.getPayTypes();
        if (payTypes.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            split$default = CollectionsKt__CollectionsKt.emptyList();
        } else {
            split$default = StringsKt__StringsKt.split$default((CharSequence) payTypes, new String[]{"\\|"}, false, 0, 6, (Object) null);
        }
        JSONArray parsePayTypes = parsePayTypes();
        if (Intrinsics.areEqual(this.qrCodePayBean.getQrPayType(), "0")) {
            this.qrCodePayBean.setPayTypeIndex(0);
        } else {
            if (this.qrCodePayBean.getQrPayType().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && (indexOf = split$default.indexOf(this.qrCodePayBean.getQrPayType())) != -1) {
                this.qrCodePayBean.setPayTypeIndex(indexOf + 1);
            }
        }
        if (this.qrCodePayBean.getPayTypeIndex() == -1) {
            if (parsePayTypes.length() > 0) {
                this.qrCodePayBean.setPayTypeIndex(1);
                PaymentUtils.INSTANCE.saveQrcodeLastPayType((String) split$default.get(0));
            } else {
                this.qrCodePayBean.setPayTypeIndex(0);
            }
        }
        initSelectView(parsePayTypes);
        TextView textView = null;
        if (this.qrCodePayBean.getPayTypeIndex() != 0 && parsePayTypes.length() >= this.qrCodePayBean.getPayTypeIndex()) {
            QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "payTypeJSONArray = " + parsePayTypes);
            JSONObject optJSONObject = parsePayTypes.optJSONObject(this.qrCodePayBean.getPayTypeIndex() - 1);
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "payTypeJSONArray.optJSON\u2026ayBean.payTypeIndex - 1))");
            String optString = optJSONObject.optString("name");
            if (Intrinsics.areEqual("D", optJSONObject.optString("card_type"))) {
                str = "\u50a8\u84c4\u5361";
            } else {
                str = "\u4fe1\u7528\u5361";
            }
            String str2 = optString + str;
            String optString2 = optJSONObject.optString("card_tail");
            if (!TextUtils.isEmpty(optString2)) {
                str2 = str2 + "(" + optString2 + ")";
            }
            TextView textView2 = this.selectedBankName;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
                textView2 = null;
            }
            textView2.setText(str2);
            String optString3 = optJSONObject.optString("disable");
            if (!TextUtils.isEmpty(optString3) && Intrinsics.areEqual(optString3, "6")) {
                BankImageUtil bankImageUtil = BankImageUtil.getInstance(this.fragment.getContext());
                String optString4 = optJSONObject.optString("image_id");
                ImageView imageView = this.selectedBankLogo;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedBankLogo");
                    imageView = null;
                }
                bankImageUtil.setBankCardDisableLogo(optString4, imageView);
                TextView textView3 = this.selectedBankName;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
                } else {
                    textView = textView3;
                }
                textView.setTextColor(this.fragment.getResources().getColor(R.color.common_text_gray));
                return;
            }
            BankImageUtil bankImageUtil2 = BankImageUtil.getInstance(this.fragment.getContext());
            String optString5 = optJSONObject.optString("image_id");
            ImageView imageView2 = this.selectedBankLogo;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankLogo");
                imageView2 = null;
            }
            bankImageUtil2.setBankImage(optString5, imageView2);
            TextView textView4 = this.selectedBankName;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
            } else {
                textView = textView4;
            }
            textView.setTextColor(this.fragment.getResources().getColor(R.color.f156931fl));
            return;
        }
        TextView textView5 = this.selectedBankName;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
            textView5 = null;
        }
        textView5.setText(this.fragment.getString(R.string.f2180562o));
        ?? r06 = this.selectedBankLogo;
        if (r06 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedBankLogo");
        } else {
            textView = r06;
        }
        textView.setBackgroundResource(R.drawable.dvp);
    }

    public final void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.findViewById(R.id.f232205u).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentOutPayTypeController.initView$lambda$1$lambda$0(PaymentOutPayTypeController.this, view2);
            }
        });
        View findViewById = view.findViewById(R.id.f232305v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.payment_out_bank_logo)");
        this.selectedBankLogo = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.f232405w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.payment_out_bank_name)");
        TextView textView = (TextView) findViewById2;
        this.selectedBankName = textView;
        View view2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedBankName");
            textView = null;
        }
        ol2.b.f(textView, 0, false, 6, null);
        View findViewById3 = view.findViewById(R.id.jel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.tenpay_paytype_layout)");
        this.bankListContainer = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.h1n);
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PaymentOutPayTypeController.initView$lambda$3$lambda$2(PaymentOutPayTypeController.this, view3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById<View?>\u2026gState(false) }\n        }");
        this.selectBankDialogRoot = findViewById4;
        View findViewById5 = findViewById4.findViewById(R.id.iig);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "selectBankDialogRoot.fin\u2026iewById(R.id.scroll_view)");
        MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) findViewById5;
        this.bankListScrollView = maxHeightScrollView;
        if (maxHeightScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankListScrollView");
            maxHeightScrollView = null;
        }
        maxHeightScrollView.setMaxHeight((int) (com.tencent.mobileqq.util.x.f(this.fragment.getContext()).a() * 0.9d));
        View view3 = this.selectBankDialogRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectBankDialogRoot");
        } else {
            view2 = view3;
        }
        view2.findViewById(R.id.az7).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                PaymentOutPayTypeController.initView$lambda$5$lambda$4(PaymentOutPayTypeController.this, view4);
            }
        });
    }

    public final boolean isShowingDialog() {
        View view = this.selectBankDialogRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectBankDialogRoot");
            view = null;
        }
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void onWalletGateInited(@Nullable JSONObject walletGateData) {
        if (walletGateData == null) {
            return;
        }
        this.balance = walletGateData.optString("balance");
    }
}
