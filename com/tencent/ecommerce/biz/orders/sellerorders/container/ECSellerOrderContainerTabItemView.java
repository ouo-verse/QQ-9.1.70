package com.tencent.ecommerce.biz.orders.sellerorders.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerTabItemView;", "Landroid/widget/LinearLayout;", "", "a", "b", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "e", "Landroid/view/View;", "divideLine", "", "f", "Z", "enableIndicator", "Landroid/content/Context;", "context", "", "text", "isSelected", "<init>", "(Landroid/content/Context;Ljava/lang/String;ZZ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSellerOrderContainerTabItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View divideLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean enableIndicator;

    public ECSellerOrderContainerTabItemView(Context context, String str, boolean z16, boolean z17) {
        super(context);
        this.enableIndicator = z17;
        LayoutInflater.from(context).inflate(R.layout.ctz, this);
        TextView textView = (TextView) findViewById(R.id.oer);
        this.textView = textView;
        this.divideLine = findViewById(R.id.f163047o11);
        textView.setText(str);
        if (z16) {
            a();
        } else {
            b();
        }
    }

    public final void a() {
        if (this.enableIndicator) {
            this.divideLine.setVisibility(0);
        }
        this.textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
        this.textView.setTypeface(null, 1);
    }

    public final void b() {
        this.divideLine.setVisibility(4);
        this.textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
        this.textView.setTypeface(null, 0);
    }
}
