package com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.BulletinItemData;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.q;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/c;", "", "o", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "payloads", "r", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleView", "G", "contentView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends q<BulletinItemData> {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView contentView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class ViewOnClickListenerC1076a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BulletinItemData f103673d;

        ViewOnClickListenerC1076a(BulletinItemData bulletinItemData) {
            this.f103673d = bulletinItemData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.ecommerce.biz.bulletin.b bVar = com.tencent.ecommerce.biz.bulletin.b.f101349a;
            BulletinItemData bulletinItemData = this.f103673d;
            String str = bulletinItemData.storeId;
            String spuId = bulletinItemData.getSpuId();
            BulletinScene bulletinScene = BulletinScene.ORDER_SUBMIT_PAGE;
            com.tencent.ecommerce.biz.bulletin.b.c(bVar, str, spuId, bulletinScene, null, 8, null);
            com.tencent.ecommerce.biz.bulletin.a aVar = com.tencent.ecommerce.biz.bulletin.a.f101348a;
            Context context = view.getContext();
            BulletinItemData bulletinItemData2 = this.f103673d;
            aVar.a(context, bulletinItemData2.title, bulletinItemData2.content, bulletinScene);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void o() {
        super.o();
        this.titleView = (TextView) this.itemView.findViewById(R.id.nsm);
        this.contentView = (TextView) this.itemView.findViewById(R.id.nsl);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void m(BulletinItemData data) {
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
        this.itemView.setOnClickListener(new ViewOnClickListenerC1076a(data));
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void n(BulletinItemData data, List<? extends Object> payloads) {
        m(data);
    }

    public a(View view) {
        super(view, null, 2, null);
    }
}
