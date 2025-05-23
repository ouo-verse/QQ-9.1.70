package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.ktx.TextViewKt;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoType;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020)\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\n2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/ECPayDetailViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$h;", "data", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/ecommerce/biz/orders/common/j;", "promos", "", "showWarningInCoupon", ReportConstant.COSTREPORT_PREFIX, "info", "showTipsIcon", "Lkotlin/Function0;", "tipsIconClickAction", "o", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "payStatusTitleTv", UserInfo.SEX_FEMALE, "orderPriceTv", "G", "totalQuantityTv", "H", "originalPriceTv", "I", "freightTv", "Landroidx/constraintlayout/widget/Group;", "J", "Landroidx/constraintlayout/widget/Group;", "freightGroup", "Landroid/widget/LinearLayout;", "K", "Landroid/widget/LinearLayout;", "promosContainer", "Landroid/view/View;", "L", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECPayDetailViewHolder extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.PriceDetailData> {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView payStatusTitleTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView orderPriceTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView totalQuantityTv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView originalPriceTv;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView freightTv;

    /* renamed from: J, reason: from kotlin metadata */
    private Group freightGroup;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout promosContainer;

    /* renamed from: L, reason: from kotlin metadata */
    public final View rootView;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/ECPayDetailViewHolder$addPromoItemToContainer$itemView$1$2$2", "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/ECPayDetailViewHolder$$special$$inlined$also$lambda$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QShopOrderPromoInfo f103320e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f103321f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0 f103322h;

        a(QShopOrderPromoInfo qShopOrderPromoInfo, boolean z16, Function0 function0) {
            this.f103320e = qShopOrderPromoInfo;
            this.f103321f = z16;
            this.f103322h = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function0 function0 = this.f103322h;
            if (function0 != null) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECPayDetailViewHolder(View view) {
        super(view);
        this.rootView = view;
    }

    private final void o(QShopOrderPromoInfo info, boolean showTipsIcon, Function0<Unit> tipsIconClickAction) {
        LinearLayout linearLayout = new LinearLayout(this.rootView.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, com.tencent.ecommerce.biz.util.e.c(16.0f), 0, 0);
        TextView textView = new TextView(this.rootView.getContext());
        textView.setText(info.message);
        textView.setTextSize(14.0f);
        ECSkin eCSkin = ECSkin.INSTANCE;
        textView.setTextColor(eCSkin.getColor(R.color.f6962z));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView);
        if (showTipsIcon) {
            ImageView imageView = new ImageView(this.rootView.getContext());
            imageView.setImageDrawable(eCSkin.getDrawable(R.drawable.eqj));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.ecommerce.biz.util.e.c(15.0f), com.tencent.ecommerce.biz.util.e.c(15.0f));
            layoutParams.setMarginStart(com.tencent.ecommerce.biz.util.e.c(6.5f));
            imageView.setLayoutParams(layoutParams);
            imageView.setOnClickListener(new a(info, showTipsIcon, tipsIconClickAction));
            linearLayout.addView(imageView);
        }
        View view = new View(this.rootView.getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        TextView textView2 = new TextView(this.rootView.getContext());
        textView2.setText("-\u00a5" + com.tencent.ecommerce.biz.util.j.f104870a.a(info.price));
        textView2.setTextSize(14.0f);
        textView2.setTextColor(eCSkin.getColor(R.color.f6942x));
        linearLayout.addView(textView2);
        LinearLayout linearLayout2 = this.promosContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promosContainer");
        }
        linearLayout2.addView(linearLayout);
    }

    private final void q(f.PriceDetailData data) {
        if (data.showFreight) {
            Group group = this.freightGroup;
            if (group == null) {
                Intrinsics.throwUninitializedPropertyAccessException("freightGroup");
            }
            group.setVisibility(0);
            TextView textView = this.freightTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("freightTv");
            }
            textView.setText(data.freight);
            return;
        }
        Group group2 = this.freightGroup;
        if (group2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("freightGroup");
        }
        group2.setVisibility(8);
    }

    private final void r(f.PriceDetailData data) {
        TextView textView = this.payStatusTitleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payStatusTitleTv");
        }
        textView.setText(data.payStateStr);
        TextView textView2 = this.orderPriceTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderPriceTv");
        }
        TextViewKt.c(textView2, data.orderPrice, R.dimen.f10010x, R.dimen.f10000w, R.dimen.f9990v);
        TextView textView3 = this.totalQuantityTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("totalQuantityTv");
        }
        textView3.setText(this.rootView.getContext().getString(R.string.wu8, Integer.valueOf(data.totalQuantity)));
        TextView textView4 = this.originalPriceTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originalPriceTv");
        }
        textView4.setText('\u00a5' + com.tencent.ecommerce.biz.util.j.f104870a.a(data.originalPrice));
    }

    private final void s(List<QShopOrderPromoInfo> promos, final boolean showWarningInCoupon) {
        LinearLayout linearLayout = this.promosContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promosContainer");
        }
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this.promosContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promosContainer");
        }
        linearLayout2.setVisibility(8);
        List<QShopOrderPromoInfo> list = promos;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((QShopOrderPromoInfo) next).type == QShopOrderPromoType.DISCOUNT) {
                arrayList.add(next);
            }
        }
        LinearLayout linearLayout3 = this.promosContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promosContainer");
        }
        linearLayout3.setVisibility(0);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            p(this, (QShopOrderPromoInfo) it5.next(), false, null, 6, null);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((QShopOrderPromoInfo) obj).type == QShopOrderPromoType.COUPON) {
                arrayList2.add(obj);
            }
        }
        LinearLayout linearLayout4 = this.promosContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promosContainer");
        }
        linearLayout4.setVisibility(0);
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            o((QShopOrderPromoInfo) it6.next(), showWarningInCoupon, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECPayDetailViewHolder$bindPromosInfo$$inlined$run$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ECPayDetailViewHolder.this.u();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(this.rootView.getContext());
        gVar.Y(this.rootView.getContext().getString(R.string.wiw));
        gVar.b0("");
        gVar.f0(this.rootView.getContext().getString(R.string.wpm));
        gVar.show();
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        View view = this.rootView;
        this.payStatusTitleTv = (TextView) view.findViewById(R.id.o6f);
        this.orderPriceTv = (TextView) view.findViewById(R.id.o5o);
        this.totalQuantityTv = (TextView) view.findViewById(R.id.ocv);
        this.originalPriceTv = (TextView) view.findViewById(R.id.o5x);
        this.freightTv = (TextView) view.findViewById(R.id.nzz);
        this.freightGroup = (Group) view.findViewById(R.id.nzw);
        this.promosContainer = (LinearLayout) view.findViewById(R.id.o7p);
        Group group = this.freightGroup;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("freightGroup");
        }
        ECViewUtilKt.b(group, R.id.nzy, R.id.nzz);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void l(f.PriceDetailData data) {
        r(data);
        q(data);
        s(data.a(), data.showWarningInCoupon);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void p(ECPayDetailViewHolder eCPayDetailViewHolder, QShopOrderPromoInfo qShopOrderPromoInfo, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        eCPayDetailViewHolder.o(qShopOrderPromoInfo, z16, function0);
    }
}
