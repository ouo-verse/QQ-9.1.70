package com.tencent.ecommerce.biz.coupon.myshopping;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import qh0.ECMyShoppingActionSheetItemData;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/coupon/myshopping/ECMyShoppingActionSheetItem;", "Landroid/widget/RelativeLayout;", "Lqh0/a;", "data", "", "setItemData", "d", "Lqh0/a;", "itemData", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "iconImageView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMyShoppingActionSheetItem extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECMyShoppingActionSheetItemData itemData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView iconImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    public ECMyShoppingActionSheetItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.cq9, this);
        this.iconImageView = (ImageView) findViewById(R.id.ny8);
        this.textView = (TextView) findViewById(R.id.ny9);
    }

    public final void setItemData(ECMyShoppingActionSheetItemData data) {
        this.itemData = data;
        this.textView.setText(data.text);
        this.iconImageView.setImageDrawable(ECSkin.INSTANCE.getDrawable(data.iconToken));
    }
}
