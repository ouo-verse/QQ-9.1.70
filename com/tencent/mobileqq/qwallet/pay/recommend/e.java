package com.tencent.mobileqq.qwallet.pay.recommend;

import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.pay.FinanceAdInfo;
import com.tencent.mobileqq.qwallet.pay.recommend.b;
import com.tencent.mobileqq.util.x;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/e;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/d;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b$a;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "data", "", "H", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e extends d<b.Card> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View view) {
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H(@Nullable QWalletBaseFragment fragment, @NotNull b.Card data) {
        String str;
        boolean z16;
        CharSequence charSequence;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getCardInfo() == null) {
            return;
        }
        PBStringField pBStringField = data.getCardInfo().card_id;
        String str2 = null;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        boolean z17 = true;
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
                PBStringField pBStringField2 = data.getCardInfo().icon;
                if (pBStringField2 != null) {
                    str2 = pBStringField2.get();
                }
                r16.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str2));
                s().setText(data.getCardInfo().title.get());
                TextView p16 = p();
                String str3 = data.getCardInfo().category.get();
                if (str3 != null && str3.length() != 0) {
                    z17 = false;
                }
                if (z17) {
                    charSequence = data.getCardInfo().subtitle.get();
                } else {
                    SpannableString spannableString = new SpannableString(data.getCardInfo().category.get() + data.getCardInfo().subtitle.get());
                    spannableString.setSpan(new com.tencent.mobileqq.qwallet.hb.view.d(Color.parseColor("#19FF8D40"), Color.parseColor("#FF8D40"), x.c(getView().getContext(), 10.0f), x.c(getView().getContext(), 4.0f)), 0, data.getCardInfo().category.get().length(), 17);
                    charSequence = spannableString;
                }
                p16.setText(charSequence);
                new CardBtnController(fragment, q(), data.getCardInfo()).d();
                com.tencent.mobileqq.qwallet.pay.a.d("qqpay.success.adshow", data.getCardInfo().card_id.get(), data.getCardInfo().title.get(), FinanceAdInfo.EnumAdType.OP.ordinal());
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
