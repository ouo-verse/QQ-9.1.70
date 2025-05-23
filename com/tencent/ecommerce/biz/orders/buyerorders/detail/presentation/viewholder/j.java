package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/j;", "", "Landroid/content/Context;", "context", "", "policyText", "Landroid/view/View;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f103370a = new j();

    j() {
    }

    public final View a(Context context, String policyText) {
        TextView textView = new TextView(context);
        textView.setId(View.generateViewId());
        textView.setLayoutParams(new ConstraintLayout.LayoutParams(-2, com.tencent.ecommerce.biz.util.e.c(18.0f)));
        textView.setBackground(AppCompatResources.getDrawable(context, R.drawable.bua));
        textView.setGravity(17);
        textView.setPadding(com.tencent.ecommerce.biz.util.e.c(5.0f), 0, com.tencent.ecommerce.biz.util.e.c(5.0f), 0);
        textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
        textView.setTextSize(10.0f);
        textView.setText(policyText);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }
}
