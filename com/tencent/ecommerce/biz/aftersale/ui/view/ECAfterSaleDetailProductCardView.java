package com.tencent.ecommerce.biz.aftersale.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/view/ECAfterSaleDetailProductCardView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "b", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "orderCard", "a", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "productImageView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "productTitleTextView", "f", "productSpecificationTextView", h.F, "productPriceTextView", "i", "productNumberTextView", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAfterSaleDetailProductCardView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView productImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView productTitleTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView productSpecificationTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView productPriceTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView productNumberTextView;

    public ECAfterSaleDetailProductCardView(Context context) {
        this(context, null);
    }

    private final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cow, this);
        if (inflate != null) {
            this.productImageView = (ImageView) inflate.findViewById(R.id.npw);
            this.productTitleTextView = (TextView) inflate.findViewById(R.id.f162990nq0);
            this.productSpecificationTextView = (TextView) inflate.findViewById(R.id.npz);
            this.productPriceTextView = (TextView) inflate.findViewById(R.id.npy);
            this.productNumberTextView = (TextView) inflate.findViewById(R.id.npx);
        }
    }

    public final void a(ECAfterSaleProductCard orderCard) {
        if (orderCard.cover.length() > 0) {
            ImageView imageView = this.productImageView;
            if (imageView != null) {
                ImageViewKt.b(imageView, orderCard.cover, 0, 0, 0, 14, null);
            }
        } else {
            ImageView imageView2 = this.productImageView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(null);
            }
        }
        TextView textView = this.productTitleTextView;
        if (textView != null) {
            textView.setText(orderCard.productTitle);
        }
        TextView textView2 = this.productSpecificationTextView;
        if (textView2 != null) {
            textView2.setText(orderCard.specification);
        }
        TextView textView3 = this.productPriceTextView;
        if (textView3 != null) {
            textView3.setText(getResources().getString(R.string.f169588wg2, orderCard.productPrice));
        }
        TextView textView4 = this.productNumberTextView;
        if (textView4 != null) {
            textView4.setText(getResources().getString(R.string.wfr, Integer.valueOf(orderCard.productNumber)));
        }
    }

    public ECAfterSaleDetailProductCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }
}
