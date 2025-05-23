package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/ECOrderDetailAccountInfoViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "p", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "accountIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleTv", "Landroid/widget/HorizontalScrollView;", "G", "Landroid/widget/HorizontalScrollView;", "scrollView", "H", "accountIdTv", "Landroid/view/View;", "I", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderDetailAccountInfoViewHolder extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.AccountInfoData> {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView accountIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: G, reason: from kotlin metadata */
    private HorizontalScrollView scrollView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView accountIdTv;

    /* renamed from: I, reason: from kotlin metadata */
    public final View rootView;

    public ECOrderDetailAccountInfoViewHolder(View view) {
        super(view);
        this.rootView = view;
    }

    public static final /* synthetic */ TextView n(ECOrderDetailAccountInfoViewHolder eCOrderDetailAccountInfoViewHolder) {
        TextView textView = eCOrderDetailAccountInfoViewHolder.accountIdTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountIdTv");
        }
        return textView;
    }

    public static final /* synthetic */ HorizontalScrollView o(ECOrderDetailAccountInfoViewHolder eCOrderDetailAccountInfoViewHolder) {
        HorizontalScrollView horizontalScrollView = eCOrderDetailAccountInfoViewHolder.scrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        }
        return horizontalScrollView;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        View view = this.rootView;
        this.accountIcon = (ImageView) view.findViewById(R.id.f163051o15);
        this.titleTv = (TextView) view.findViewById(R.id.f163115od4);
        this.scrollView = (HorizontalScrollView) view.findViewById(R.id.np_);
        this.accountIdTv = (TextView) view.findViewById(R.id.f163114od3);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(f.AccountInfoData data) {
        Drawable drawable;
        if (data.type == 1) {
            drawable = ECSkin.INSTANCE.getDrawable("qecommerce_skin_icon_general_phone_primary");
        } else {
            drawable = ECSkin.INSTANCE.getDrawable("qecommerce_skin_icon_general_person_primary");
        }
        ImageView imageView = this.accountIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountIcon");
        }
        imageView.setImageDrawable(drawable);
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        }
        textView.setText(data.title);
        TextView textView2 = this.accountIdTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountIdTv");
        }
        textView2.setText(data.accountId);
        HorizontalScrollView horizontalScrollView = this.scrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        }
        horizontalScrollView.post(new Runnable() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECOrderDetailAccountInfoViewHolder$onBindViewHolder$1
            @Override // java.lang.Runnable
            public final void run() {
                if (ECOrderDetailAccountInfoViewHolder.this.rootView.isAttachedToWindow()) {
                    ECOrderDetailAccountInfoViewHolder.n(ECOrderDetailAccountInfoViewHolder.this).setMinWidth(ECOrderDetailAccountInfoViewHolder.o(ECOrderDetailAccountInfoViewHolder.this).getWidth());
                }
            }
        });
    }
}
