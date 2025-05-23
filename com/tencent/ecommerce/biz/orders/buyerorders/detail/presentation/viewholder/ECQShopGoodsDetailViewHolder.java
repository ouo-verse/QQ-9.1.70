package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailGoodsOperateState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuSpec;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010*\u001a\u00020\u0010\u0012\u0006\u0010.\u001a\u00020+\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000eR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\nR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0012R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/ECQShopGoodsDetailViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$i;", "data", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "shopAvatarIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "shopNameTv", "Landroid/view/View;", "G", "Landroid/view/View;", "shopClickArea", "Landroid/view/ViewGroup;", "H", "Landroid/view/ViewGroup;", "goodsContainer", "I", "shopTotalNum", "J", "shopDivider", "K", "showMoreClick", "L", "showMoreText", "M", "showMoreArrow", "", "N", "Z", "isExpand", "P", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$i;", "currentData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "orderDetailListListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;)V", "GoodsItemLogic", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopGoodsDetailViewHolder extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.QShopGoodsDetailData> {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView shopAvatarIv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView shopNameTv;

    /* renamed from: G, reason: from kotlin metadata */
    private View shopClickArea;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewGroup goodsContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView shopTotalNum;

    /* renamed from: J, reason: from kotlin metadata */
    private View shopDivider;

    /* renamed from: K, reason: from kotlin metadata */
    private View showMoreClick;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView showMoreText;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView showMoreArrow;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isExpand;

    /* renamed from: P, reason: from kotlin metadata */
    private f.QShopGoodsDetailData currentData;

    /* renamed from: Q, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: R, reason: from kotlin metadata */
    private final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a orderDetailListListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00105\u001a\u00020+\u0012\u0006\u0010:\u001a\u000206\u00a2\u0006\u0004\b;\u0010<J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0005J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0007R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010!R\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u0016\u0010$\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010&\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u0019R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0017\u00105\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0017\u0010:\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b\u001e\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/ECQShopGoodsDetailViewHolder$GoodsItemLogic;", "", "", "", "logisticsPolicy", "", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;", "state", "c", "", "textResId", "Lkotlin/Function0;", AdCommonMethodHandler.AdCommonEvent.CLICK_ACTION, "e", "g", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$i;", "data", "index", "f", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "goodsCoverIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "goodsNameTv", "Landroidx/constraintlayout/widget/Barrier;", "Landroidx/constraintlayout/widget/Barrier;", "goodsBarrier", "d", "specificationsTv", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "logisticsContainer", "unitPriceTv", "quantityTv", tl.h.F, "deliverMsgTv", "Landroid/widget/Button;", "i", "Landroid/widget/Button;", "operationBtn", "Landroid/view/View;", "j", "Landroid/view/View;", "goodsClickArea", "k", "I", "blindBoxGoodsCoverPadding", "l", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "orderDetailListListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class GoodsItemLogic {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private ImageView goodsCoverIv;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private TextView goodsNameTv;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private Barrier goodsBarrier;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private TextView specificationsTv;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private ConstraintLayout logisticsContainer;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private TextView unitPriceTv;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private TextView quantityTv;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private TextView deliverMsgTv;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private Button operationBtn;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private View goodsClickArea;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final int blindBoxGoodsCoverPadding = com.tencent.ecommerce.biz.util.e.c(4.0f);

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private final View itemView;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a orderDetailListListener;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0 f103336d;

            a(Function0 function0) {
                this.f103336d = function0;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f103336d.invoke();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ f.QShopGoodsDetailData f103338e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f103339f;

            b(f.QShopGoodsDetailData qShopGoodsDetailData, int i3) {
                this.f103338e = qShopGoodsDetailData;
                this.f103339f = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                GoodsItemLogic.this.getOrderDetailListListener().h(this.f103338e.orderSpuInfo.get(this.f103339f).link);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public GoodsItemLogic(View view, com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar) {
            this.itemView = view;
            this.orderDetailListListener = aVar;
        }

        public static final /* synthetic */ ImageView a(GoodsItemLogic goodsItemLogic) {
            ImageView imageView = goodsItemLogic.goodsCoverIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            return imageView;
        }

        private final void b(List<String> logisticsPolicy) {
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

        private final void c(final ECOrderDetailGoodsOperateState state) {
            Button button = this.operationBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
            }
            button.setVisibility(0);
            if (state.enableShowApplyRefund) {
                e(R.string.wg9, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder$GoodsItemLogic$addOperationBtn$$inlined$with$lambda$1
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
                        this.getOrderDetailListListener().b(ECOrderDetailGoodsOperateState.this.applyRefundOrAfterSalesLink);
                    }
                });
                return;
            }
            if (state.enableShowApplyAfterSales) {
                e(R.string.wg8, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder$GoodsItemLogic$addOperationBtn$$inlined$with$lambda$2
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
                        this.getOrderDetailListListener().a(ECOrderDetailGoodsOperateState.this.applyRefundOrAfterSalesLink);
                    }
                });
                return;
            }
            if (state.enableShowRefundDetail) {
                e(R.string.wqw, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder$GoodsItemLogic$addOperationBtn$$inlined$with$lambda$3
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
                        this.getOrderDetailListListener().j(ECOrderDetailGoodsOperateState.this.goToRefundOrAfterSalesDetailLink);
                    }
                });
                return;
            }
            if (state.enableShowAfterSalesDetail) {
                e(R.string.f169590wg4, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder$GoodsItemLogic$addOperationBtn$$inlined$with$lambda$4
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
                        this.getOrderDetailListListener().g(ECOrderDetailGoodsOperateState.this.goToRefundOrAfterSalesDetailLink);
                    }
                });
                return;
            }
            if (state.enableShowPlatformService) {
                e(R.string.wpi, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder$GoodsItemLogic$addOperationBtn$$inlined$with$lambda$5
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        ECQShopGoodsDetailViewHolder.GoodsItemLogic.this.getOrderDetailListListener().d();
                    }
                });
                return;
            }
            Button button2 = this.operationBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
            }
            button2.setVisibility(8);
        }

        private final void e(int textResId, Function0<Unit> clickAction) {
            Button button = this.operationBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
            }
            button.setText(this.itemView.getContext().getString(textResId));
            Button button2 = this.operationBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
            }
            button2.setOnClickListener(new a(clickAction));
        }

        /* renamed from: d, reason: from getter */
        public final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a getOrderDetailListListener() {
            return this.orderDetailListListener;
        }

        public final void f(f.QShopGoodsDetailData data, int index) {
            String joinToString$default;
            if (com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.b(data.orderSkuInfo.get(index).productType)) {
                ImageView imageView = this.goodsCoverIv;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                imageView.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6531t));
                ImageView imageView2 = this.goodsCoverIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                int i3 = this.blindBoxGoodsCoverPadding;
                imageView2.setPadding(i3, i3, i3, i3);
                ImageView imageView3 = this.goodsCoverIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                imageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                IECImageLoader imageLoader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader();
                ImageView imageView4 = this.goodsCoverIv;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                IECImageLoader.a.a(imageLoader, imageView4.getContext(), data.orderSkuInfo.get(index).coverUrl, null, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder$GoodsItemLogic$onBindViewHolder$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                        invoke2(drawable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Drawable drawable) {
                        ECQShopGoodsDetailViewHolder.GoodsItemLogic.a(ECQShopGoodsDetailViewHolder.GoodsItemLogic.this).setImageDrawable(drawable);
                    }
                }, 4, null);
            } else {
                ImageView imageView5 = this.goodsCoverIv;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                imageView5.setBackground(null);
                ImageView imageView6 = this.goodsCoverIv;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                imageView6.setPadding(0, 0, 0, 0);
                ImageView imageView7 = this.goodsCoverIv;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                imageView7.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ImageView imageView8 = this.goodsCoverIv;
                if (imageView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                ImageViewKt.b(imageView8, data.orderSkuInfo.get(index).coverUrl, 0, 0, 0, 14, null);
            }
            if (data.isQQVipCard) {
                ImageView imageView9 = this.goodsCoverIv;
                if (imageView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
                }
                imageView9.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
            }
            gi0.c cVar = gi0.c.f402085a;
            TextView textView = this.goodsNameTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsNameTv");
            }
            cVar.a(textView, data.orderSkuInfo.get(index).name, data.orderSpuInfo.get(index).d());
            TextView textView2 = this.specificationsTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specificationsTv");
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(data.orderSkuInfo.get(index).d(), "; ", null, null, 0, null, new Function1<OrderSkuSpec, CharSequence>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder$GoodsItemLogic$onBindViewHolder$2
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(OrderSkuSpec orderSkuSpec) {
                    return orderSkuSpec.value;
                }
            }, 30, null);
            textView2.setText(joinToString$default);
            ConstraintLayout constraintLayout = this.logisticsContainer;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            constraintLayout.removeAllViews();
            b(data.orderSkuInfo.get(index).c());
            if (data.showPrice) {
                TextView textView3 = this.unitPriceTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("unitPriceTv");
                }
                textView3.setText('\u00a5' + com.tencent.ecommerce.biz.util.j.f104870a.a(data.orderSkuInfo.get(index).unitPrice));
            }
            TextView textView4 = this.unitPriceTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unitPriceTv");
            }
            textView4.setVisibility(data.showPrice ? 0 : 8);
            TextView textView5 = this.quantityTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quantityTv");
            }
            textView5.setText("\u00d7 " + data.orderSkuInfo.get(index).quantity);
            if (data.deliverMessage.length() > 0) {
                TextView textView6 = this.deliverMsgTv;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deliverMsgTv");
                }
                textView6.setVisibility(0);
                TextView textView7 = this.deliverMsgTv;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deliverMsgTv");
                }
                textView7.setText(data.deliverMessage);
            } else {
                TextView textView8 = this.deliverMsgTv;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deliverMsgTv");
                }
                textView8.setVisibility(8);
            }
            ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState = data.refundOrAfterSalesState;
            if (eCOrderDetailGoodsOperateState != null) {
                c(eCOrderDetailGoodsOperateState);
            }
            View view = this.goodsClickArea;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsClickArea");
            }
            view.setOnClickListener(new b(data, index));
        }

        public final void g() {
            View view = this.itemView;
            this.goodsCoverIv = (ImageView) view.findViewById(R.id.o0g);
            this.goodsNameTv = (TextView) view.findViewById(R.id.o0i);
            this.goodsBarrier = (Barrier) view.findViewById(R.id.f163042o02);
            this.specificationsTv = (TextView) view.findViewById(R.id.o0k);
            this.logisticsContainer = (ConstraintLayout) view.findViewById(R.id.o0h);
            this.unitPriceTv = (TextView) view.findViewById(R.id.oey);
            this.quantityTv = (TextView) view.findViewById(R.id.o8h);
            this.deliverMsgTv = (TextView) view.findViewById(R.id.nv5);
            this.operationBtn = (Button) view.findViewById(R.id.o0j);
            this.goodsClickArea = view.findViewById(R.id.o0d);
            Barrier barrier = this.goodsBarrier;
            if (barrier == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsBarrier");
            }
            barrier.setReferencedIds(new int[]{R.id.oey, R.id.o8h});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f.QShopGoodsDetailData f103341e;

        a(f.QShopGoodsDetailData qShopGoodsDetailData) {
            this.f103341e = qShopGoodsDetailData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object first;
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar = ECQShopGoodsDetailViewHolder.this.orderDetailListListener;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.f103341e.orderSkuInfo);
            aVar.k(((OrderSkuDetail) first).shop.link);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECQShopGoodsDetailViewHolder.this.isExpand = !r0.isExpand;
            if (ECQShopGoodsDetailViewHolder.this.currentData != null) {
                ECQShopGoodsDetailViewHolder eCQShopGoodsDetailViewHolder = ECQShopGoodsDetailViewHolder.this;
                f.QShopGoodsDetailData qShopGoodsDetailData = eCQShopGoodsDetailViewHolder.currentData;
                Intrinsics.checkNotNull(qShopGoodsDetailData);
                eCQShopGoodsDetailViewHolder.t(qShopGoodsDetailData);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECQShopGoodsDetailViewHolder(View view, com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar) {
        super(view);
        this.rootView = view;
        this.orderDetailListListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(f.QShopGoodsDetailData data) {
        String str;
        ViewGroup viewGroup = this.goodsContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsContainer");
        }
        viewGroup.removeAllViews();
        int size = data.orderSkuInfo.size();
        for (int i3 = 0; i3 < size && (this.isExpand || i3 <= 2); i3++) {
            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.csj, (ViewGroup) null, false);
            GoodsItemLogic goodsItemLogic = new GoodsItemLogic(inflate, this.orderDetailListListener);
            goodsItemLogic.g();
            goodsItemLogic.f(data, i3);
            ViewGroup viewGroup2 = this.goodsContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsContainer");
            }
            viewGroup2.addView(inflate, -1, -2);
        }
        if (data.orderSkuInfo.size() > 3) {
            View view = this.showMoreClick;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showMoreClick");
            }
            view.setVisibility(0);
            TextView textView = this.showMoreText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showMoreText");
            }
            textView.setVisibility(0);
            ImageView imageView = this.showMoreArrow;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showMoreArrow");
            }
            imageView.setVisibility(0);
            TextView textView2 = this.showMoreText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showMoreText");
            }
            if (this.isExpand) {
                str = "\u6536\u8d77";
            } else {
                str = "\u5c55\u5f00";
            }
            textView2.setText(str);
            ImageView imageView2 = this.showMoreArrow;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showMoreArrow");
            }
            imageView2.setRotation(this.isExpand ? 270.0f : 90.0f);
            return;
        }
        View view2 = this.showMoreClick;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showMoreClick");
        }
        view2.setVisibility(8);
        TextView textView3 = this.showMoreText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showMoreText");
        }
        textView3.setVisibility(8);
        ImageView imageView3 = this.showMoreArrow;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showMoreArrow");
        }
        imageView3.setVisibility(8);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        View view = this.itemView;
        this.shopAvatarIv = (ImageView) view.findViewById(R.id.oa5);
        this.shopNameTv = (TextView) view.findViewById(R.id.oad);
        this.shopClickArea = view.findViewById(R.id.oa6);
        this.goodsContainer = (ViewGroup) view.findViewById(R.id.o0e);
        this.showMoreClick = view.findViewById(R.id.oaf);
        this.showMoreText = (TextView) view.findViewById(R.id.oah);
        this.showMoreArrow = (ImageView) view.findViewById(R.id.oag);
        this.shopTotalNum = (TextView) view.findViewById(R.id.oae);
        this.shopDivider = view.findViewById(R.id.oa_);
        View view2 = this.showMoreClick;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showMoreClick");
        }
        view2.setOnClickListener(new b());
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void l(f.QShopGoodsDetailData data) {
        Object first;
        Object first2;
        ImageView imageView = this.shopAvatarIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopAvatarIv");
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) data.orderSkuInfo);
        ImageViewKt.b(imageView, ((OrderSkuDetail) first).shop.avatarUrl, 0, 0, 0, 14, null);
        TextView textView = this.shopNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopNameTv");
        }
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) data.orderSkuInfo);
        textView.setText(((OrderSkuDetail) first2).shop.name);
        View view = this.shopClickArea;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopClickArea");
        }
        view.setOnClickListener(new a(data));
        this.currentData = data;
        if (data.isQQVipCard) {
            View view2 = this.shopDivider;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopDivider");
            }
            int i3 = 0;
            view2.setVisibility(0);
            TextView textView2 = this.shopTotalNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopTotalNum");
            }
            textView2.setVisibility(0);
            Iterator<T> it = data.orderSkuInfo.iterator();
            while (it.hasNext()) {
                i3 += ((OrderSkuDetail) it.next()).quantity;
            }
            if (i3 > 0) {
                TextView textView3 = this.shopTotalNum;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shopTotalNum");
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                sb5.append('\u4e2a');
                textView3.setText(sb5.toString());
            } else {
                TextView textView4 = this.shopTotalNum;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shopTotalNum");
                }
                textView4.setText("");
            }
        } else {
            View view3 = this.shopDivider;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopDivider");
            }
            view3.setVisibility(4);
            TextView textView5 = this.shopTotalNum;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopTotalNum");
            }
            textView5.setVisibility(4);
        }
        t(data);
    }
}
