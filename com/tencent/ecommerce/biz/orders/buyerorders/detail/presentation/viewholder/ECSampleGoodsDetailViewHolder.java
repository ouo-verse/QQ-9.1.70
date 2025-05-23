package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuSpec;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u00102\u001a\u00020\u0015\u0012\u0006\u00106\u001a\u000203\u00a2\u0006\u0004\b7\u00108J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0017R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u0013R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010\u0013R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010\u0017R\u0014\u00102\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u0017R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/ECSampleGoodsDetailViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$l;", "", "", "logisticsPolicy", "", "o", "phoneNum", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "shopAvatarIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "shopNameTv", "Landroid/view/View;", "G", "Landroid/view/View;", "shopClickArea", "H", "goodsCoverIv", "I", "goodsNameTv", "Landroidx/constraintlayout/widget/Barrier;", "J", "Landroidx/constraintlayout/widget/Barrier;", "goodsBarrier", "K", "specificationsTv", "Landroidx/constraintlayout/widget/ConstraintLayout;", "L", "Landroidx/constraintlayout/widget/ConstraintLayout;", "logisticsContainer", "M", "unitPriceTv", "N", "quantityTv", "Landroid/widget/Button;", "P", "Landroid/widget/Button;", "operationBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "goodsClickArea", BdhLogUtil.LogTag.Tag_Req, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "orderDetailListListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSampleGoodsDetailViewHolder extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.SampleGoodsDetailData> {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView shopAvatarIv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView shopNameTv;

    /* renamed from: G, reason: from kotlin metadata */
    private View shopClickArea;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView goodsCoverIv;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView goodsNameTv;

    /* renamed from: J, reason: from kotlin metadata */
    private Barrier goodsBarrier;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView specificationsTv;

    /* renamed from: L, reason: from kotlin metadata */
    private ConstraintLayout logisticsContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView unitPriceTv;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView quantityTv;

    /* renamed from: P, reason: from kotlin metadata */
    private Button operationBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    private View goodsClickArea;

    /* renamed from: R, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: S, reason: from kotlin metadata */
    private final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a orderDetailListListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f103344e;

        a(String str) {
            this.f103344e = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSampleGoodsDetailViewHolder.this.orderDetailListListener.e(this.f103344e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f.SampleGoodsDetailData f103346e;

        b(f.SampleGoodsDetailData sampleGoodsDetailData) {
            this.f103346e = sampleGoodsDetailData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSampleGoodsDetailViewHolder.this.orderDetailListListener.k(this.f103346e.orderSkuInfo.shop.link);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f.SampleGoodsDetailData f103348e;

        c(f.SampleGoodsDetailData sampleGoodsDetailData) {
            this.f103348e = sampleGoodsDetailData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSampleGoodsDetailViewHolder.this.orderDetailListListener.h(this.f103348e.orderSpuInfo.link);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECSampleGoodsDetailViewHolder(View view, com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar) {
        super(view);
        this.rootView = view;
        this.orderDetailListListener = aVar;
    }

    private final void o(List<String> logisticsPolicy) {
        Flow flow = new Flow(this.itemView.getContext());
        flow.setLayoutParams(new ConstraintLayout.LayoutParams(0, -2));
        flow.setOrientation(0);
        flow.setHorizontalGap(com.tencent.ecommerce.biz.util.e.c(8.0f));
        flow.setVerticalGap(com.tencent.ecommerce.biz.util.e.c(4.0f));
        flow.setWrapMode(1);
        flow.setHorizontalStyle(2);
        flow.setHorizontalBias(0.0f);
        ConstraintLayout constraintLayout = this.logisticsContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
        }
        constraintLayout.addView(flow);
        for (String str : logisticsPolicy) {
            j jVar = j.f103370a;
            ConstraintLayout constraintLayout2 = this.logisticsContainer;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            View a16 = jVar.a(constraintLayout2.getContext(), str);
            ConstraintLayout constraintLayout3 = this.logisticsContainer;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            constraintLayout3.addView(a16);
            flow.addView(a16);
        }
    }

    private final void p(String phoneNum) {
        if (phoneNum.length() > 0) {
            Button button = this.operationBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
            }
            button.setVisibility(0);
            Button button2 = this.operationBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
            }
            button2.setText(this.rootView.getContext().getString(R.string.wip));
            Button button3 = this.operationBtn;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
            }
            button3.setOnClickListener(new a(phoneNum));
            return;
        }
        Button button4 = this.operationBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
        }
        button4.setVisibility(8);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        View view = this.itemView;
        this.shopAvatarIv = (ImageView) view.findViewById(R.id.oa5);
        this.shopNameTv = (TextView) view.findViewById(R.id.oad);
        this.goodsCoverIv = (ImageView) view.findViewById(R.id.o0g);
        this.goodsNameTv = (TextView) view.findViewById(R.id.o0i);
        this.goodsBarrier = (Barrier) view.findViewById(R.id.f163042o02);
        this.specificationsTv = (TextView) view.findViewById(R.id.o0k);
        this.logisticsContainer = (ConstraintLayout) view.findViewById(R.id.o0h);
        this.unitPriceTv = (TextView) view.findViewById(R.id.oey);
        this.quantityTv = (TextView) view.findViewById(R.id.o8h);
        this.operationBtn = (Button) view.findViewById(R.id.o0j);
        this.shopClickArea = view.findViewById(R.id.oa6);
        this.goodsClickArea = view.findViewById(R.id.o0d);
        Barrier barrier = this.goodsBarrier;
        if (barrier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsBarrier");
        }
        barrier.setReferencedIds(new int[]{R.id.oey, R.id.o8h});
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(f.SampleGoodsDetailData data) {
        String joinToString$default;
        ImageView imageView = this.shopAvatarIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopAvatarIv");
        }
        ImageViewKt.b(imageView, data.orderSkuInfo.shop.avatarUrl, 0, 0, 0, 14, null);
        TextView textView = this.shopNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopNameTv");
        }
        textView.setText(data.orderSkuInfo.shop.name);
        View view = this.shopClickArea;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopClickArea");
        }
        view.setOnClickListener(new b(data));
        ImageView imageView2 = this.goodsCoverIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
        }
        ImageViewKt.b(imageView2, data.orderSkuInfo.coverUrl, 0, 0, 0, 14, null);
        TextView textView2 = this.goodsNameTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsNameTv");
        }
        textView2.setText(data.orderSkuInfo.name);
        TextView textView3 = this.specificationsTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("specificationsTv");
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(data.orderSkuInfo.d(), "; ", null, null, 0, null, new Function1<OrderSkuSpec, CharSequence>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECSampleGoodsDetailViewHolder$onBindViewHolder$2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(OrderSkuSpec orderSkuSpec) {
                return orderSkuSpec.value;
            }
        }, 30, null);
        textView3.setText(joinToString$default);
        ConstraintLayout constraintLayout = this.logisticsContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
        }
        constraintLayout.removeAllViews();
        o(data.orderSkuInfo.c());
        TextView textView4 = this.unitPriceTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unitPriceTv");
        }
        textView4.setText('\u00a5' + com.tencent.ecommerce.biz.util.j.f104870a.a(data.orderSkuInfo.unitPrice));
        TextView textView5 = this.quantityTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityTv");
        }
        textView5.setText("\u00d7 " + data.orderSkuInfo.quantity);
        p(data.sellerPhoneNum);
        View view2 = this.goodsClickArea;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsClickArea");
        }
        view2.setOnClickListener(new c(data));
    }
}
