package com.tenpay.pay;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.pay.model.SelectedPayChannelBean;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0018\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/pay/PayChannelUtils;", "", "()V", "RECOMMEND_AUTO_PAY", "", "RECOMMEND_BALANCE", "RECOMMEND_BANK", "ROUND_RADIUS", "", "checkAutoPay", "Lcom/tenpay/pay/model/SelectedPayChannelBean;", "qpayGateJSON", "Lorg/json/JSONObject;", "checkBalance", "checkFirstAvailableBank", "checkNewBindBank", "newBindBankSerial", "getRecommendPayChannel", "setContainerOutLine", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "topOffset", "bottomOffset", "radius", "updateBgRound", "bgRadiusEnum", "Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "BgRadiusEnum", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayChannelUtils {

    @NotNull
    public static final PayChannelUtils INSTANCE = new PayChannelUtils();

    @NotNull
    private static final String RECOMMEND_AUTO_PAY = "spfa";

    @NotNull
    private static final String RECOMMEND_BALANCE = "balance";

    @NotNull
    private static final String RECOMMEND_BANK = "bank";
    private static final int ROUND_RADIUS = 25;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "", "(Ljava/lang/String;I)V", "TopRound", "BothRound", "BottomRound", "NONE", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum BgRadiusEnum {
        TopRound,
        BothRound,
        BottomRound,
        NONE
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BgRadiusEnum.values().length];
            try {
                iArr[BgRadiusEnum.TopRound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BgRadiusEnum.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BgRadiusEnum.BottomRound.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BgRadiusEnum.BothRound.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    PayChannelUtils() {
    }

    private final SelectedPayChannelBean checkAutoPay(JSONObject qpayGateJSON) {
        Object obj;
        boolean z16;
        Iterator it = PayChannelBean.AutoPayCard.Companion.createList$default(PayChannelBean.AutoPayCard.INSTANCE, qpayGateJSON, null, 2, null).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Integer disable = ((PayChannelBean.AutoPayCard) obj).getDisable();
                if (disable != null && disable.intValue() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        PayChannelBean.AutoPayCard autoPayCard = (PayChannelBean.AutoPayCard) obj;
        if (autoPayCard == null) {
            return null;
        }
        return SelectedPayChannelBean.INSTANCE.fromAutoPay(autoPayCard);
    }

    private final SelectedPayChannelBean checkBalance(JSONObject qpayGateJSON) {
        if (!PayChannelBean.Balance.Companion.create$default(PayChannelBean.Balance.INSTANCE, qpayGateJSON, null, 2, null).canUse()) {
            return null;
        }
        return new SelectedPayChannelBean(0, null, null, null, 0, 30, null);
    }

    private final SelectedPayChannelBean checkFirstAvailableBank(JSONObject qpayGateJSON) {
        Object obj;
        boolean z16;
        Iterator it = PayChannelBean.Bank.Companion.createList$default(PayChannelBean.Bank.INSTANCE, qpayGateJSON, null, 2, null).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Integer disable = ((PayChannelBean.Bank) obj).getDisable();
                if (disable != null && disable.intValue() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        PayChannelBean.Bank bank = (PayChannelBean.Bank) obj;
        if (bank == null) {
            return null;
        }
        return SelectedPayChannelBean.INSTANCE.fromBank(bank);
    }

    private final SelectedPayChannelBean checkNewBindBank(JSONObject qpayGateJSON, String newBindBankSerial) {
        Object obj;
        boolean z16;
        if (newBindBankSerial == null) {
            return null;
        }
        Iterator it = PayChannelBean.Bank.Companion.createList$default(PayChannelBean.Bank.INSTANCE, qpayGateJSON, null, 2, null).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((PayChannelBean.Bank) obj).getBindSerial(), newBindBankSerial)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        PayChannelBean.Bank bank = (PayChannelBean.Bank) obj;
        if (bank == null) {
            return null;
        }
        Integer disable = bank.getDisable();
        if (disable != null && disable.intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            bank = null;
        }
        if (bank == null) {
            return null;
        }
        return SelectedPayChannelBean.INSTANCE.fromBank(bank);
    }

    static /* synthetic */ SelectedPayChannelBean checkNewBindBank$default(PayChannelUtils payChannelUtils, JSONObject jSONObject, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return payChannelUtils.checkNewBindBank(jSONObject, str);
    }

    public static /* synthetic */ SelectedPayChannelBean getRecommendPayChannel$default(PayChannelUtils payChannelUtils, JSONObject jSONObject, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return payChannelUtils.getRecommendPayChannel(jSONObject, str);
    }

    private final void setContainerOutLine(final View rootView, final int topOffset, final int bottomOffset, final int radius) {
        rootView.post(new Runnable() { // from class: com.tenpay.pay.e
            @Override // java.lang.Runnable
            public final void run() {
                PayChannelUtils.setContainerOutLine$lambda$7(rootView, topOffset, bottomOffset, radius);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setContainerOutLine$lambda$7(final View rootView, final int i3, final int i16, final int i17) {
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        rootView.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tenpay.pay.PayChannelUtils$setContainerOutLine$1$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(@Nullable View view, @Nullable Outline outline) {
                if (view != null && outline != null) {
                    outline.setRoundRect(0, i3, rootView.getWidth(), rootView.getHeight() + i16, i17);
                }
            }
        });
        rootView.setClipToOutline(true);
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateBgRound(@NotNull View rootView, @NotNull BgRadiusEnum bgRadiusEnum) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(bgRadiusEnum, "bgRadiusEnum");
        updateBgRound$default(rootView, bgRadiusEnum, 0, 4, null);
    }

    public static /* synthetic */ void updateBgRound$default(View view, BgRadiusEnum bgRadiusEnum, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 25;
        }
        updateBgRound(view, bgRadiusEnum, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SelectedPayChannelBean getRecommendPayChannel(@NotNull JSONObject qpayGateJSON, @Nullable String newBindBankSerial) {
        SelectedPayChannelBean selectedPayChannelBean;
        Intrinsics.checkNotNullParameter(qpayGateJSON, "qpayGateJSON");
        SelectedPayChannelBean checkNewBindBank = checkNewBindBank(qpayGateJSON, newBindBankSerial);
        if (checkNewBindBank != null) {
            return checkNewBindBank;
        }
        String optString = qpayGateJSON.optString("suggest_pay_type");
        if (optString != null) {
            int hashCode = optString.hashCode();
            if (hashCode != -339185956) {
                if (hashCode != 3016252) {
                    if (hashCode == 3536856 && optString.equals(RECOMMEND_AUTO_PAY)) {
                        selectedPayChannelBean = checkAutoPay(qpayGateJSON);
                    }
                } else if (optString.equals("bank")) {
                    selectedPayChannelBean = checkFirstAvailableBank(qpayGateJSON);
                }
            } else if (optString.equals(RECOMMEND_BALANCE)) {
                selectedPayChannelBean = checkBalance(qpayGateJSON);
            }
            if (selectedPayChannelBean != null) {
                SelectedPayChannelBean checkBalance = checkBalance(qpayGateJSON);
                if (checkBalance == null) {
                    SelectedPayChannelBean checkAutoPay = checkAutoPay(qpayGateJSON);
                    if (checkAutoPay == null) {
                        return checkFirstAvailableBank(qpayGateJSON);
                    }
                    return checkAutoPay;
                }
                return checkBalance;
            }
            return selectedPayChannelBean;
        }
        selectedPayChannelBean = null;
        if (selectedPayChannelBean != null) {
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateBgRound(@NotNull View rootView, @NotNull BgRadiusEnum bgRadiusEnum, int radius) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(bgRadiusEnum, "bgRadiusEnum");
        int i3 = WhenMappings.$EnumSwitchMapping$0[bgRadiusEnum.ordinal()];
        if (i3 == 1) {
            INSTANCE.setContainerOutLine(rootView, 0, radius, radius);
            return;
        }
        if (i3 == 2) {
            INSTANCE.setContainerOutLine(rootView, 0, 0, 0);
        } else if (i3 == 3) {
            INSTANCE.setContainerOutLine(rootView, -radius, 0, radius);
        } else {
            if (i3 != 4) {
                return;
            }
            INSTANCE.setContainerOutLine(rootView, 0, 0, radius);
        }
    }
}
