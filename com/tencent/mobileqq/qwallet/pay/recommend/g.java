package com.tencent.mobileqq.qwallet.pay.recommend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.pay.FinanceAdInfo;
import com.tencent.mobileqq.qwallet.pay.recommend.b;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqwallet.PaySuccessAd$QpayAd;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/g;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/d;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b$b;", "Ltencent/im/qqwallet/PaySuccessAd$QpayAd;", "qpayAd", "", "actionId", "", "I", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "data", "J", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g extends d<b.OpAd> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.scd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.ad_top_title)");
        C((TextView) findViewById);
        View findViewById2 = view.findViewById(R.id.f163981fi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.ad_logo)");
        A((ImageView) findViewById2);
        View findViewById3 = view.findViewById(R.id.f163993fz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ad_title)");
        B((TextView) findViewById3);
        View findViewById4 = view.findViewById(R.id.sbm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.ad_description)");
        y((TextView) findViewById4);
        View findViewById5 = view.findViewById(R.id.sbv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.ad_jump_btn)");
        z((TextView) findViewById5);
        View findViewById6 = view.findViewById(R.id.sbt);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.ad_item_bottom_line)");
        v(findViewById6);
        View findViewById7 = view.findViewById(R.id.sbu);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.ad_item_container)");
        u((ViewGroup) findViewById7);
    }

    private final void I(PaySuccessAd$QpayAd qpayAd, int actionId) {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str2 = null;
        if (qpayAd != null && (pBStringField2 = qpayAd.f436043id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (qpayAd != null && (pBStringField = qpayAd.trace_info) != null) {
            str2 = pBStringField.get();
        }
        com.tencent.mobileqq.qwallet.pay.a.c(str, str2, actionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(b.OpAd data, g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.pay.a.d("qqpay.success.adclick", data.getQpayAd().f436043id.get(), data.getQpayAd().title.get(), FinanceAdInfo.EnumAdType.OP.ordinal());
        this$0.I(data.getQpayAd(), 102);
        k.h(this$0.getView().getContext(), data.getQpayAd().button_url.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void J(@Nullable QWalletBaseFragment fragment, @NotNull final b.OpAd data) {
        String str;
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getQpayAd() == null) {
            return;
        }
        PBStringField pBStringField = data.getQpayAd().f436043id;
        String str2 = null;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return;
                }
                D(data);
                E(data);
                ImageView r16 = r();
                PBStringField pBStringField2 = data.getQpayAd().icon;
                if (pBStringField2 != null) {
                    str2 = pBStringField2.get();
                }
                r16.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str2));
                s().setText(data.getQpayAd().title.get());
                p().setText(data.getQpayAd().sub_title.get());
                TextView q16 = q();
                q16.setText(data.getQpayAd().button_text.get());
                q16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.pay.recommend.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.K(b.OpAd.this, this, view);
                    }
                });
                com.tencent.mobileqq.qwallet.pay.a.d("qqpay.success.adshow", data.getQpayAd().f436043id.get(), data.getQpayAd().title.get(), FinanceAdInfo.EnumAdType.OP.ordinal());
                I(data.getQpayAd(), 101);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
