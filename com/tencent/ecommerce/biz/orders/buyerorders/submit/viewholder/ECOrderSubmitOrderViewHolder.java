package com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ktx.ISoftKeyBoardStateListenerRegistry;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.ktx.TextViewKt;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.ktx.h;
import com.tencent.ecommerce.base.ktx.i;
import com.tencent.ecommerce.base.ui.ClickOnDisabledObservableButton;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderItemData;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuSpec;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.q;
import com.tencent.ecommerce.biz.util.j;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001WB\u0017\u0012\u0006\u0010Q\u001a\u00020\u0019\u0012\u0006\u0010S\u001a\u00020R\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002J\u0014\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\f\u0010\u001b\u001a\u00020\u0019*\u00020\u0012H\u0002J\f\u0010\u001c\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u001d\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0014\u0010\u001f\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0014\u0010!\u001a\u00020\u0003*\u00020\u00022\u0006\u0010 \u001a\u00020\u000fH\u0002J\f\u0010#\u001a\u00020\u0017*\u00020\"H\u0002R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010*R\u0016\u00100\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010-R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010-R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u00103R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010-R\u0016\u00106\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010-R\u0016\u00107\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010-R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u00109R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u00109R\u0016\u0010>\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010@R\u0016\u0010C\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010=R\u0016\u0010E\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010*R\u0016\u0010G\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010-R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010!\u00a8\u0006X"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitOrderViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/o;", "", "o", "data", "O", "", "", "payloads", "P", "l", "p", "M", "N", "", "logisticsPolicy", "E", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "couponInfo", "H", "title", "msg", "", "msgTextColor", "Landroid/view/View;", "K", "T", "L", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "quantity", "J", "note", "I", "Landroid/widget/EditText;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/constraintlayout/widget/Group;", UserInfo.SEX_FEMALE, "Landroidx/constraintlayout/widget/Group;", "shopInfo", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "shopAvatarIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "shopNameTv", "goodsCoverIv", "goodsNameTv", "specificationsTv", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "logisticsContainer", "deliveryMsgTv", "unitPriceTv", "priceDesc", "Lcom/tencent/ecommerce/base/ui/ClickOnDisabledObservableButton;", "Lcom/tencent/ecommerce/base/ui/ClickOnDisabledObservableButton;", "quantityMinusBtn", "quantityPlusBtn", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/EditText;", "quantityEditView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "promosContainer", "U", "orderGoodsNote", "V", "orderGoodsNoteClearBtn", "W", "orderGoodsFreight", "Lcom/tencent/ecommerce/base/ktx/ISoftKeyBoardStateListenerRegistry;", "X", "Lcom/tencent/ecommerce/base/ktx/ISoftKeyBoardStateListenerRegistry;", "softKeyBoardStateListenerRegistry", "Y", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/o;", "orderGoodsData", "Z", "blindBoxGoodsCoverPadding", "view", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "itemOperationListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;)V", "a0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitOrderViewHolder extends q<OrderItemData> {

    /* renamed from: F, reason: from kotlin metadata */
    private Group shopInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView shopAvatarIv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView shopNameTv;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView goodsCoverIv;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView goodsNameTv;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView specificationsTv;

    /* renamed from: L, reason: from kotlin metadata */
    private ConstraintLayout logisticsContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView deliveryMsgTv;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView unitPriceTv;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView priceDesc;

    /* renamed from: Q, reason: from kotlin metadata */
    private ClickOnDisabledObservableButton quantityMinusBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private ClickOnDisabledObservableButton quantityPlusBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private EditText quantityEditView;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout promosContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private EditText orderGoodsNote;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView orderGoodsNoteClearBtn;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView orderGoodsFreight;

    /* renamed from: X, reason: from kotlin metadata */
    private ISoftKeyBoardStateListenerRegistry softKeyBoardStateListenerRegistry;

    /* renamed from: Y, reason: from kotlin metadata */
    private OrderItemData orderGoodsData;

    /* renamed from: Z, reason: from kotlin metadata */
    private final int blindBoxGoodsCoverPadding;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e implements View.OnFocusChangeListener {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
        
            if ((r4.length() > 0) == true) goto L13;
         */
        @Override // android.view.View.OnFocusChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onFocusChange(View view, boolean z16) {
            boolean z17;
            ImageView u16 = ECOrderSubmitOrderViewHolder.u(ECOrderSubmitOrderViewHolder.this);
            if (z16 && (r4 = ECOrderSubmitOrderViewHolder.t(ECOrderSubmitOrderViewHolder.this).getText()) != null) {
                z17 = true;
            }
            z17 = false;
            u16.setVisibility(z17 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitOrderViewHolder$toCouponItemView$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OrderSubmitListItemOperationListener orderSubmitListItemOperationListener = ((q) ECOrderSubmitOrderViewHolder.this).itemOperationListener;
            if (orderSubmitListItemOperationListener != null) {
                orderSubmitListItemOperationListener.onCouponClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECOrderSubmitOrderViewHolder(View view, OrderSubmitListItemOperationListener orderSubmitListItemOperationListener) {
        super(view, orderSubmitListItemOperationListener);
        this.blindBoxGoodsCoverPadding = com.tencent.ecommerce.biz.util.e.c(4.0f);
    }

    private final void E(List<String> logisticsPolicy) {
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
            ConstraintLayout constraintLayout2 = this.logisticsContainer;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            TextView textView = new TextView(constraintLayout2.getContext());
            textView.setId(View.generateViewId());
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(-2, com.tencent.ecommerce.biz.util.e.c(16.0f)));
            ConstraintLayout constraintLayout3 = this.logisticsContainer;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            textView.setBackground(AppCompatResources.getDrawable(constraintLayout3.getContext(), R.drawable.bua));
            textView.setGravity(17);
            textView.setPadding(com.tencent.ecommerce.biz.util.e.c(5.0f), 0, com.tencent.ecommerce.biz.util.e.c(5.0f), 0);
            textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
            textView.setTextSize(10.0f);
            textView.setText(str);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            ConstraintLayout constraintLayout4 = this.logisticsContainer;
            if (constraintLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            constraintLayout4.addView(textView);
            flow.addView(textView);
        }
    }

    private final void H(ECQshopOrderQuerySvr$CouponInfo couponInfo) {
        View T;
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
        if (couponInfo == null || (T = T(couponInfo)) == null) {
            return;
        }
        LinearLayout linearLayout3 = this.promosContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promosContainer");
        }
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = this.promosContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promosContainer");
        }
        linearLayout4.addView(T);
    }

    private final void I(OrderItemData orderItemData, String str) {
        OrderSubmitListItemOperationListener orderSubmitListItemOperationListener = this.itemOperationListener;
        if (orderSubmitListItemOperationListener != null) {
            orderSubmitListItemOperationListener.onChangedOrderNote(orderItemData.orderGoodInfo.skuId, str);
        }
    }

    private final void J(OrderItemData orderItemData, int i3) {
        OrderSubmitListItemOperationListener orderSubmitListItemOperationListener = this.itemOperationListener;
        if (orderSubmitListItemOperationListener != null) {
            orderSubmitListItemOperationListener.onChangedOrderGoodsQuantity(orderItemData.orderGoodInfo.skuId, i3);
        }
    }

    private final View K(String title, String msg2, int msgTextColor) {
        LinearLayout linearLayout = new LinearLayout(this.itemView.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setPadding(0, com.tencent.ecommerce.biz.util.e.c(14.0f), 0, com.tencent.ecommerce.biz.util.e.c(2.0f));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setText(title);
        textView.setTextSize(14.0f);
        textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
        TextView textView2 = new TextView(linearLayout.getContext());
        textView2.setText(msg2);
        textView2.setTextSize(14.0f);
        textView2.setGravity(8388613);
        textView2.setTextColor(msgTextColor);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        Unit unit = Unit.INSTANCE;
        textView2.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        ImageView imageView = new ImageView(linearLayout.getContext());
        imageView.setImageResource(R.drawable.e8_);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.tencent.ecommerce.biz.util.e.c(14.0f), com.tencent.ecommerce.biz.util.e.c(14.0f));
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = com.tencent.ecommerce.biz.util.e.c(4.0f);
        imageView.setLayoutParams(layoutParams2);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(OrderItemData orderItemData) {
        OrderSkuDetail orderSkuDetail = orderItemData.orderGoodInfo;
        int i3 = orderSkuDetail.quantity;
        OrderSubmitListItemOperationListener orderSubmitListItemOperationListener = this.itemOperationListener;
        if (orderSubmitListItemOperationListener != null) {
            orderSubmitListItemOperationListener.onChangedOrderGoodsQuantity(orderSkuDetail.skuId, i3 - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        String str;
        OrderItemData orderItemData;
        OrderSkuDetail orderSkuDetail;
        OrderItemData orderItemData2 = this.orderGoodsData;
        if (orderItemData2 == null || (orderSkuDetail = orderItemData2.orderGoodInfo) == null || (str = orderSkuDetail.note) == null) {
            str = "";
        }
        EditText editText = this.orderGoodsNote;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNote");
        }
        String obj = editText.getText().toString();
        if (!(!Intrinsics.areEqual(str, obj)) || (orderItemData = this.orderGoodsData) == null) {
            return;
        }
        I(orderItemData, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        OrderItemData orderItemData;
        OrderSkuDetail orderSkuDetail;
        OrderItemData orderItemData2 = this.orderGoodsData;
        int i3 = (orderItemData2 == null || (orderSkuDetail = orderItemData2.orderGoodInfo) == null) ? 0 : orderSkuDetail.quantity;
        EditText editText = this.quantityEditView;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityEditView");
        }
        int R = R(editText);
        if (i3 != R && (orderItemData = this.orderGoodsData) != null) {
            J(orderItemData, R);
        }
        cg0.a.b("ECOrderSubmitOrderViewHolder", "notifyQuantityChanged lastQuantity=" + i3 + " currentQuantity=" + R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(OrderItemData orderItemData) {
        OrderSkuDetail orderSkuDetail = orderItemData.orderGoodInfo;
        int i3 = orderSkuDetail.quantity;
        OrderSubmitListItemOperationListener orderSubmitListItemOperationListener = this.itemOperationListener;
        if (orderSubmitListItemOperationListener != null) {
            orderSubmitListItemOperationListener.onChangedOrderGoodsQuantity(orderSkuDetail.skuId, i3 + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R(EditText editText) {
        Integer intOrNull;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(editText.getText().toString());
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    private final View T(ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo) {
        int color;
        String str;
        if (eCQshopOrderQuerySvr$CouponInfo.discount_price.get() > 0) {
            str = "-\u00a5" + j.f104870a.a(eCQshopOrderQuerySvr$CouponInfo.discount_price.get());
            color = ECSkin.INSTANCE.getColor(R.color.f6952y);
        } else if (eCQshopOrderQuerySvr$CouponInfo.can_use_coupon_num.get() > 0) {
            str = eCQshopOrderQuerySvr$CouponInfo.can_use_coupon_num.get() + "\u5f20\u4f18\u60e0\u5238\u53ef\u7528";
            color = ECSkin.INSTANCE.getColor(R.color.f6942x);
        } else {
            color = ECSkin.INSTANCE.getColor(R.color.f6962z);
            str = "\u6682\u65e0\u53ef\u7528\u4f18\u60e0\u5238";
        }
        View K = K("\u4f18\u60e0\u5238", str, color);
        K.setOnClickListener(new f());
        return K;
    }

    public static final /* synthetic */ ImageView q(ECOrderSubmitOrderViewHolder eCOrderSubmitOrderViewHolder) {
        ImageView imageView = eCOrderSubmitOrderViewHolder.goodsCoverIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
        }
        return imageView;
    }

    public static final /* synthetic */ EditText t(ECOrderSubmitOrderViewHolder eCOrderSubmitOrderViewHolder) {
        EditText editText = eCOrderSubmitOrderViewHolder.orderGoodsNote;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNote");
        }
        return editText;
    }

    public static final /* synthetic */ ImageView u(ECOrderSubmitOrderViewHolder eCOrderSubmitOrderViewHolder) {
        ImageView imageView = eCOrderSubmitOrderViewHolder.orderGoodsNoteClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNoteClearBtn");
        }
        return imageView;
    }

    public static final /* synthetic */ EditText v(ECOrderSubmitOrderViewHolder eCOrderSubmitOrderViewHolder) {
        EditText editText = eCOrderSubmitOrderViewHolder.quantityEditView;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityEditView");
        }
        return editText;
    }

    public static final /* synthetic */ ClickOnDisabledObservableButton w(ECOrderSubmitOrderViewHolder eCOrderSubmitOrderViewHolder) {
        ClickOnDisabledObservableButton clickOnDisabledObservableButton = eCOrderSubmitOrderViewHolder.quantityMinusBtn;
        if (clickOnDisabledObservableButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityMinusBtn");
        }
        return clickOnDisabledObservableButton;
    }

    public static final /* synthetic */ ClickOnDisabledObservableButton x(ECOrderSubmitOrderViewHolder eCOrderSubmitOrderViewHolder) {
        ClickOnDisabledObservableButton clickOnDisabledObservableButton = eCOrderSubmitOrderViewHolder.quantityPlusBtn;
        if (clickOnDisabledObservableButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityPlusBtn");
        }
        return clickOnDisabledObservableButton;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void m(OrderItemData data) {
        String joinToString$default;
        String str;
        this.orderGoodsData = data;
        ImageView imageView = this.shopAvatarIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopAvatarIv");
        }
        ImageViewKt.b(imageView, data.orderGoodInfo.shop.avatarUrl, 0, 0, 0, 14, null);
        TextView textView = this.shopNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopNameTv");
        }
        textView.setText(data.orderGoodInfo.shop.name);
        boolean b16 = com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.b(data.orderGoodInfo.productType);
        Group group = this.shopInfo;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopInfo");
        }
        group.setVisibility(b16 ^ true ? 0 : 8);
        if (b16) {
            ImageView imageView2 = this.goodsCoverIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            imageView2.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6531t));
            ImageView imageView3 = this.goodsCoverIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            imageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageView imageView4 = this.goodsCoverIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            int i3 = this.blindBoxGoodsCoverPadding;
            imageView4.setPadding(i3, i3, i3, i3);
            IECImageLoader imageLoader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader();
            ImageView imageView5 = this.goodsCoverIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            IECImageLoader.a.a(imageLoader, imageView5.getContext(), data.orderGoodInfo.coverUrl, null, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onBindData$1
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
                    ECOrderSubmitOrderViewHolder.q(ECOrderSubmitOrderViewHolder.this).setImageDrawable(drawable);
                }
            }, 4, null);
        } else {
            ImageView imageView6 = this.goodsCoverIv;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            imageView6.setBackground(null);
            ImageView imageView7 = this.goodsCoverIv;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            imageView7.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageView imageView8 = this.goodsCoverIv;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            imageView8.setPadding(0, 0, 0, 0);
            ImageView imageView9 = this.goodsCoverIv;
            if (imageView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsCoverIv");
            }
            ImageViewKt.b(imageView9, data.orderGoodInfo.coverUrl, 0, 0, 0, 14, null);
        }
        gi0.c cVar = gi0.c.f402085a;
        TextView textView2 = this.goodsNameTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsNameTv");
        }
        cVar.a(textView2, data.orderGoodInfo.name, data.a());
        TextView textView3 = this.specificationsTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("specificationsTv");
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(data.orderGoodInfo.d(), "; ", null, null, 0, null, new Function1<OrderSkuSpec, CharSequence>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onBindData$2
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
        E(data.orderGoodInfo.c());
        if (data.deliveryMessage.length() > 0) {
            TextView textView4 = this.deliveryMsgTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryMsgTv");
            }
            textView4.setVisibility(0);
            TextView textView5 = this.deliveryMsgTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryMsgTv");
            }
            textView5.setText(data.deliveryMessage);
        } else {
            TextView textView6 = this.deliveryMsgTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryMsgTv");
            }
            textView6.setVisibility(8);
        }
        EditText editText = this.quantityEditView;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityEditView");
        }
        com.tencent.ecommerce.base.ktx.d.a(editText, String.valueOf(data.orderGoodInfo.quantity));
        EditText editText2 = this.quantityEditView;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityEditView");
        }
        editText2.setEnabled(true ^ com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.b(data.orderGoodInfo.productType));
        TextView textView7 = this.unitPriceTv;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unitPriceTv");
        }
        TextViewKt.c(textView7, data.orderGoodInfo.unitPrice, R.dimen.f10010x, R.dimen.f10000w, R.dimen.f9990v);
        TextView textView8 = this.orderGoodsFreight;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsFreight");
        }
        textView8.setText(data.orderGoodInfo.freight);
        H(data.couponInfo);
        EditText editText3 = this.orderGoodsNote;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNote");
        }
        com.tencent.ecommerce.base.ktx.d.a(editText3, data.orderGoodInfo.note);
        if (com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.b(data.orderGoodInfo.productType)) {
            TextView textView9 = this.priceDesc;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("priceDesc");
            }
            if (data.isBuyAll) {
                str = "\uff08\u5168\u6536\uff09";
            } else {
                str = '\uff08' + data.orderGoodInfo.quantity + "\u62bd\uff09";
            }
            textView9.setText(str);
            ClickOnDisabledObservableButton clickOnDisabledObservableButton = this.quantityMinusBtn;
            if (clickOnDisabledObservableButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quantityMinusBtn");
            }
            clickOnDisabledObservableButton.setOnClickWhenDisabledListener(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onBindData$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }
            });
            ClickOnDisabledObservableButton clickOnDisabledObservableButton2 = this.quantityPlusBtn;
            if (clickOnDisabledObservableButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quantityPlusBtn");
            }
            clickOnDisabledObservableButton2.setOnClickWhenDisabledListener(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onBindData$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void n(OrderItemData data, List<? extends Object> payloads) {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(payloads);
        if (!(firstOrNull instanceof String)) {
            firstOrNull = null;
        }
        String str = (String) firstOrNull;
        if (str != null) {
            this.orderGoodsData = data;
            int hashCode = str.hashCode();
            if (hashCode != -1285004149) {
                if (hashCode == 3387378 && str.equals("note")) {
                    EditText editText = this.orderGoodsNote;
                    if (editText == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNote");
                    }
                    com.tencent.ecommerce.base.ktx.d.a(editText, data.orderGoodInfo.note);
                    return;
                }
                return;
            }
            if (str.equals("quantity")) {
                EditText editText2 = this.quantityEditView;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("quantityEditView");
                }
                com.tencent.ecommerce.base.ktx.d.a(editText2, String.valueOf(data.orderGoodInfo.quantity));
                return;
            }
            return;
        }
        m(data);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void l() {
        super.l();
        Context context = this.itemView.getContext();
        i iVar = null;
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity != null) {
            SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(activity.findViewById(android.R.id.content), false, 2, null);
            b bVar = new b();
            softKeyboardStateHelper.a(bVar);
            iVar = new i(softKeyboardStateHelper, bVar);
        }
        this.softKeyBoardStateListenerRegistry = iVar;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void o() {
        Object[] plus;
        View view = this.itemView;
        this.shopInfo = (Group) view.findViewById(R.id.oac);
        this.shopAvatarIv = (ImageView) view.findViewById(R.id.oa5);
        this.shopNameTv = (TextView) view.findViewById(R.id.oad);
        this.goodsCoverIv = (ImageView) view.findViewById(R.id.o0g);
        this.goodsNameTv = (TextView) view.findViewById(R.id.o0i);
        this.specificationsTv = (TextView) view.findViewById(R.id.o0k);
        this.logisticsContainer = (ConstraintLayout) view.findViewById(R.id.o0h);
        this.deliveryMsgTv = (TextView) view.findViewById(R.id.nv5);
        this.unitPriceTv = (TextView) view.findViewById(R.id.oey);
        this.priceDesc = (TextView) view.findViewById(R.id.o6s);
        this.quantityMinusBtn = (ClickOnDisabledObservableButton) view.findViewById(R.id.o8f);
        this.quantityPlusBtn = (ClickOnDisabledObservableButton) view.findViewById(R.id.o8g);
        this.quantityEditView = (EditText) view.findViewById(R.id.o8e);
        this.orderGoodsFreight = (TextView) view.findViewById(R.id.f163040o00);
        this.promosContainer = (LinearLayout) view.findViewById(R.id.o7p);
        this.orderGoodsNote = (EditText) view.findViewById(R.id.o59);
        this.orderGoodsNoteClearBtn = (ImageView) view.findViewById(R.id.o57);
        ClickOnDisabledObservableButton clickOnDisabledObservableButton = this.quantityMinusBtn;
        if (clickOnDisabledObservableButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityMinusBtn");
        }
        ViewExtKt.c(clickOnDisabledObservableButton, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                OrderItemData orderItemData = ECOrderSubmitOrderViewHolder.this.orderGoodsData;
                if (orderItemData != null) {
                    ECOrderSubmitOrderViewHolder.this.L(orderItemData);
                }
            }
        }, 1, null);
        ClickOnDisabledObservableButton clickOnDisabledObservableButton2 = this.quantityPlusBtn;
        if (clickOnDisabledObservableButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityPlusBtn");
        }
        ViewExtKt.c(clickOnDisabledObservableButton2, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                OrderItemData orderItemData = ECOrderSubmitOrderViewHolder.this.orderGoodsData;
                if (orderItemData != null) {
                    ECOrderSubmitOrderViewHolder.this.Q(orderItemData);
                }
            }
        }, 1, null);
        ClickOnDisabledObservableButton clickOnDisabledObservableButton3 = this.quantityMinusBtn;
        if (clickOnDisabledObservableButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityMinusBtn");
        }
        clickOnDisabledObservableButton3.setOnClickWhenDisabledListener(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onCreate$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wvh, ECToastIcon.ICON_ERROR, 0);
            }
        });
        ClickOnDisabledObservableButton clickOnDisabledObservableButton4 = this.quantityPlusBtn;
        if (clickOnDisabledObservableButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityPlusBtn");
        }
        clickOnDisabledObservableButton4.setOnClickWhenDisabledListener(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onCreate$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wvf, ECToastIcon.ICON_ERROR, 0);
            }
        });
        EditText editText = this.quantityEditView;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityEditView");
        }
        editText.addTextChangedListener(new c());
        EditText editText2 = this.orderGoodsNote;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNote");
        }
        editText2.setOnFocusChangeListener(new e());
        EditText editText3 = this.orderGoodsNote;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNote");
        }
        plus = ArraysKt___ArraysJvmKt.plus((h[]) editText3.getFilters(), new h(100, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onCreate$$inlined$doOnReachMaxLength$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wve, ECToastIcon.ICON_ERROR, 0);
            }
        }));
        editText3.setFilters((InputFilter[]) plus);
        EditText editText4 = this.orderGoodsNote;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNote");
        }
        editText4.addTextChangedListener(new d());
        ImageView imageView = this.orderGoodsNoteClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderGoodsNoteClearBtn");
        }
        ViewExtKt.c(imageView, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder$onCreate$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                ECOrderSubmitOrderViewHolder.t(ECOrderSubmitOrderViewHolder.this).setText("");
            }
        }, 1, null);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void p() {
        super.p();
        ISoftKeyBoardStateListenerRegistry iSoftKeyBoardStateListenerRegistry = this.softKeyBoardStateListenerRegistry;
        if (iSoftKeyBoardStateListenerRegistry != null) {
            iSoftKeyBoardStateListenerRegistry.unregister();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/base/ktx/ActivityKt$setOnSoftKeyboardStateListener$listener$1", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public b() {
        }

        @Override // com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            ECOrderSubmitOrderViewHolder.this.N();
        }

        @Override // com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "L;", "text", "", "start", "count", "kotlin/Int", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            OrderSkuDetail orderSkuDetail;
            OrderSkuDetail orderSkuDetail2;
            ECOrderSubmitOrderViewHolder eCOrderSubmitOrderViewHolder = ECOrderSubmitOrderViewHolder.this;
            int R = eCOrderSubmitOrderViewHolder.R(ECOrderSubmitOrderViewHolder.v(eCOrderSubmitOrderViewHolder));
            ClickOnDisabledObservableButton w3 = ECOrderSubmitOrderViewHolder.w(ECOrderSubmitOrderViewHolder.this);
            OrderItemData orderItemData = ECOrderSubmitOrderViewHolder.this.orderGoodsData;
            w3.setEnabled(R > ((orderItemData == null || (orderSkuDetail2 = orderItemData.orderGoodInfo) == null) ? 1 : orderSkuDetail2.minQuantity));
            ClickOnDisabledObservableButton x16 = ECOrderSubmitOrderViewHolder.x(ECOrderSubmitOrderViewHolder.this);
            OrderItemData orderItemData2 = ECOrderSubmitOrderViewHolder.this.orderGoodsData;
            x16.setEnabled(R < ((orderItemData2 == null || (orderSkuDetail = orderItemData2.orderGoodInfo) == null) ? Integer.MAX_VALUE : orderSkuDetail.maxQuantity));
            ISoftKeyBoardStateListenerRegistry iSoftKeyBoardStateListenerRegistry = ECOrderSubmitOrderViewHolder.this.softKeyBoardStateListenerRegistry;
            if (iSoftKeyBoardStateListenerRegistry == null || !iSoftKeyBoardStateListenerRegistry.isKeyboardOpened()) {
                ECOrderSubmitOrderViewHolder.this.N();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "L;", "text", "", "start", "count", "kotlin/Int", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements TextWatcher {
        public d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
        
            if (com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder.t(r3.f103664d).hasFocus() != false) goto L13;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable s16) {
            boolean z16;
            ECOrderSubmitOrderViewHolder.this.M();
            ImageView u16 = ECOrderSubmitOrderViewHolder.u(ECOrderSubmitOrderViewHolder.this);
            if (s16 != null) {
                z16 = true;
                if (s16.length() > 0) {
                }
            }
            z16 = false;
            u16.setVisibility(z16 ? 0 : 8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
