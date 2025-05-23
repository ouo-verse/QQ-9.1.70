package com.tencent.ecommerce.biz.productcenter.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECSalesRankTabItemView;", "Landroid/widget/LinearLayout;", "", "setSelected", "setUnselected", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tabTv", "Landroid/view/View;", "e", "Landroid/view/View;", "underView", "f", "Landroid/widget/LinearLayout;", "leftMarginView", "Landroid/content/Context;", "context", "", "tabString", "", "tabIndex", "<init>", "(Landroid/content/Context;Ljava/lang/String;I)V", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSalesRankTabItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tabTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View underView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout leftMarginView;

    public ECSalesRankTabItemView(Context context, String str, int i3) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.crm, this);
        this.tabTv = (TextView) findViewById(R.id.obz);
        this.underView = findViewById(R.id.f163106oc0);
        this.leftMarginView = (LinearLayout) findViewById(R.id.o2k);
        this.tabTv.setText(str);
        this.leftMarginView.setVisibility(i3 == 0 ? 4 : 0);
    }

    public final void setSelected() {
        this.tabTv.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
        this.tabTv.setTypeface(null, 1);
        this.underView.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = e.c(0.0f);
        setLayoutParams(layoutParams);
    }

    public final void setUnselected() {
        this.tabTv.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
        this.tabTv.setTypeface(null, 0);
        this.underView.setVisibility(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = e.c(0.7f);
        setLayoutParams(layoutParams);
    }

    public ECSalesRankTabItemView(Context context) {
        this(context, "", 0);
    }
}
