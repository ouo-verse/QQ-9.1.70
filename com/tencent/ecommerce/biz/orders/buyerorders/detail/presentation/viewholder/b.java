package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsTraceItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u00100\u001a\u00020!\u0012\u0006\u00104\u001a\u000201\u00a2\u0006\u0004\b5\u00106J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0003J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010#R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$m;", "", "enableShowShipping", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/orders/common/e;", "logisticsInfo", "", "p", "enableShowAddress", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "addressInfo", "enableModifyAddress", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "shippingContainer", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "shippingTitleTv", "G", "shippingDescTv", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "shippingDetailIv", "Landroid/view/View;", "I", "Landroid/view/View;", "dividerView", "J", "addressContainer", "K", "addressConsigneeTv", "L", "addressInfoTv", "Landroid/widget/Button;", "M", "Landroid/widget/Button;", "modifyAddressBtn", "N", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "P", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "onOrderDetailListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.ShippingAndLocationData> {

    /* renamed from: E, reason: from kotlin metadata */
    private RelativeLayout shippingContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView shippingTitleTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView shippingDescTv;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView shippingDetailIv;

    /* renamed from: I, reason: from kotlin metadata */
    private View dividerView;

    /* renamed from: J, reason: from kotlin metadata */
    private RelativeLayout addressContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView addressConsigneeTv;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView addressInfoTv;

    /* renamed from: M, reason: from kotlin metadata */
    private Button modifyAddressBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: P, reason: from kotlin metadata */
    private final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a onOrderDetailListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECAddress f103353e;

        a(ECAddress eCAddress) {
            this.f103353e = eCAddress;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.onOrderDetailListener.m(this.f103353e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.b$b, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class ViewOnClickListenerC1070b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f103355e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LogisticsInfo f103356f;

        ViewOnClickListenerC1070b(String str, LogisticsInfo logisticsInfo) {
            this.f103355e = str;
            this.f103356f = logisticsInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.onOrderDetailListener.n(this.f103355e, this.f103356f.code);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(View view, com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar) {
        super(view);
        this.rootView = view;
        this.onOrderDetailListener = aVar;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        View view = this.rootView;
        this.shippingContainer = (RelativeLayout) view.findViewById(R.id.o_z);
        this.shippingTitleTv = (TextView) view.findViewById(R.id.f163099oa3);
        this.shippingDescTv = (TextView) view.findViewById(R.id.f163096oa0);
        this.shippingDetailIv = (ImageView) view.findViewById(R.id.f163097oa1);
        this.dividerView = view.findViewById(R.id.nvo);
        this.addressContainer = (RelativeLayout) view.findViewById(R.id.npo);
        this.addressConsigneeTv = (TextView) view.findViewById(R.id.npn);
        this.addressInfoTv = (TextView) view.findViewById(R.id.npr);
        this.modifyAddressBtn = (Button) view.findViewById(R.id.o4x);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(f.ShippingAndLocationData data) {
        p(data.enableShowLogistics, data.orderId, data.logisticsInfo);
        o(data.enableShowAddress, data.addressInfo, data.enableModifyAddress);
    }

    private final void p(boolean enableShowShipping, String orderId, LogisticsInfo logisticsInfo) {
        boolean isBlank;
        LogisticsTraceItem d16 = logisticsInfo != null ? logisticsInfo.d() : null;
        if (enableShowShipping && d16 != null) {
            RelativeLayout relativeLayout = this.shippingContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shippingContainer");
            }
            relativeLayout.setVisibility(0);
            View view = this.dividerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dividerView");
            }
            view.setVisibility(0);
            TextView textView = this.shippingTitleTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shippingTitleTv");
            }
            textView.setText(this.rootView.getContext().getString(R.string.f169645wt4, d16.statusDesc));
            TextView textView2 = this.shippingDescTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shippingDescTv");
            }
            textView2.setText(this.rootView.getContext().getString(R.string.wsx, d16.acceptTime, d16.acceptStation));
            isBlank = StringsKt__StringsJVMKt.isBlank(logisticsInfo.trailUrl);
            if (!isBlank) {
                ImageView imageView = this.shippingDetailIv;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shippingDetailIv");
                }
                imageView.setVisibility(0);
                RelativeLayout relativeLayout2 = this.shippingContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shippingContainer");
                }
                relativeLayout2.setOnClickListener(new ViewOnClickListenerC1070b(orderId, logisticsInfo));
                return;
            }
            ImageView imageView2 = this.shippingDetailIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shippingDetailIv");
            }
            imageView2.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout3 = this.shippingContainer;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shippingContainer");
        }
        relativeLayout3.setVisibility(8);
        View view2 = this.dividerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dividerView");
        }
        view2.setVisibility(8);
    }

    private final void o(boolean enableShowAddress, ECAddress addressInfo, boolean enableModifyAddress) {
        if (!enableShowAddress) {
            RelativeLayout relativeLayout = this.addressContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressContainer");
            }
            relativeLayout.setVisibility(8);
            return;
        }
        TextView textView = this.addressConsigneeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressConsigneeTv");
        }
        textView.setText(addressInfo.consignee + TokenParser.SP + addressInfo.phoneNumber);
        TextView textView2 = this.addressInfoTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressInfoTv");
        }
        textView2.setText(com.tencent.ecommerce.biz.orders.address.b.a(addressInfo));
        if (enableModifyAddress) {
            Button button = this.modifyAddressBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modifyAddressBtn");
            }
            button.setVisibility(0);
            Button button2 = this.modifyAddressBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modifyAddressBtn");
            }
            button2.setOnClickListener(new a(addressInfo));
            return;
        }
        Button button3 = this.modifyAddressBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modifyAddressBtn");
        }
        button3.setVisibility(8);
        Button button4 = this.modifyAddressBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modifyAddressBtn");
        }
        button4.setOnClickListener(null);
    }
}
