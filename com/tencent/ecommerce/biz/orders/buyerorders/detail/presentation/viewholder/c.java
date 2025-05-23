package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleView", UserInfo.SEX_FEMALE, "contentView", "Landroid/view/View;", "G", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.BulletinInfoData> {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView contentView;

    /* renamed from: G, reason: from kotlin metadata */
    public final View itemView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f.BulletinInfoData f103357d;

        a(f.BulletinInfoData bulletinInfoData) {
            this.f103357d = bulletinInfoData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.ecommerce.biz.bulletin.b bVar = com.tencent.ecommerce.biz.bulletin.b.f101349a;
            f.BulletinInfoData bulletinInfoData = this.f103357d;
            String str = bulletinInfoData.storeId;
            String str2 = bulletinInfoData.spuId;
            String orderId = bulletinInfoData.getOrderId();
            BulletinScene bulletinScene = BulletinScene.ORDER_DETAIL_PAGE;
            bVar.b(str, str2, bulletinScene, orderId);
            com.tencent.ecommerce.biz.bulletin.a aVar = com.tencent.ecommerce.biz.bulletin.a.f101348a;
            Context context = view.getContext();
            f.BulletinInfoData bulletinInfoData2 = this.f103357d;
            aVar.a(context, bulletinInfoData2.title, bulletinInfoData2.content, bulletinScene);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(View view) {
        super(view);
        this.itemView = view;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        super.m();
        this.titleView = (TextView) this.itemView.findViewById(R.id.nsm);
        this.contentView = (TextView) this.itemView.findViewById(R.id.nsl);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void l(f.BulletinInfoData data) {
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        textView.setText(data.title);
        TextView textView2 = this.contentView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        textView2.setText(data.content);
        this.itemView.setOnClickListener(new a(data));
    }
}
