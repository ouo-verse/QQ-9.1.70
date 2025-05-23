package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ProductParamDescriptionView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "title", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/d;", "paramList", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ProductParamDescriptionView extends LinearLayout {
    public ProductParamDescriptionView(Context context, String str, List<d> list) {
        super(context);
        setOrientation(1);
        TextView textView = new TextView(context);
        textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
        textView.setTextSize(17.0f);
        textView.setText(str);
        textView.setPadding(0, e.c(16.0f), 0, e.c(16.0f));
        Unit unit = Unit.INSTANCE;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(textView, layoutParams);
        for (d dVar : list) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ct_, (ViewGroup) this, false);
            ((TextView) inflate.findViewById(R.id.o65)).setText(dVar.paramName);
            ((TextView) inflate.findViewById(R.id.o66)).setText(dVar.getParamValue());
            addView(inflate);
        }
        addView(new View(context), new LinearLayout.LayoutParams(-1, e.c(16.0f)));
    }
}
