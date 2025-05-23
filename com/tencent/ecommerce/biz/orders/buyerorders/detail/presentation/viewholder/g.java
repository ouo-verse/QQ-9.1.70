package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ktx.CustomTypefaceSpan;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/g;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$g;", "", "titleTextColor", "", "titleStr", "", "o", "descStr", DomainData.DOMAIN_NAME, "data", "p", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleView", UserInfo.SEX_FEMALE, "descView", "Ljava/util/regex/Pattern;", "G", "Ljava/util/regex/Pattern;", "timePattern", "Landroid/view/View;", "H", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.OrderStateData> {

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView titleView;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView descView;

    /* renamed from: G, reason: from kotlin metadata */
    private final Pattern timePattern;

    /* renamed from: H, reason: from kotlin metadata */
    private final View view;

    public g(View view) {
        super(view);
        this.view = view;
        this.titleView = (TextView) view.findViewById(R.id.f163102ob1);
        this.descView = (TextView) view.findViewById(R.id.f163101ob0);
        this.timePattern = Pattern.compile("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
    }

    private final void n(String descStr) {
        if (descStr.length() == 0) {
            this.descView.setVisibility(8);
            return;
        }
        this.descView.setVisibility(0);
        Matcher matcher = this.timePattern.matcher(descStr);
        if (matcher.find()) {
            SpannableString spannableString = new SpannableString(descStr);
            spannableString.setSpan(new CustomTypefaceSpan(this.view.getContext(), "fonts/Qvideo Digit.ttf"), matcher.start(), matcher.end(), 33);
            spannableString.setSpan(new StyleSpan(1), matcher.start(), matcher.end(), 33);
            this.descView.setText(spannableString);
            return;
        }
        this.descView.setText(descStr);
    }

    private final void o(int titleTextColor, String titleStr) {
        this.titleView.setVisibility(0);
        if (titleStr.length() > 0) {
            this.titleView.setText(titleStr);
            this.titleView.setTextColor(titleTextColor);
        }
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(f.OrderStateData data) {
        o(data.titleTextColor, data.stateTitleStr);
        n(data.stateDescStr);
    }
}
