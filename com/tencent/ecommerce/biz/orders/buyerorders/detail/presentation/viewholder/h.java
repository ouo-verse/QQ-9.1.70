package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.shophome.ui.view.ECShopCardView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B+\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/h;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$j;", "data", "", "o", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECShopCardView;", "E", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECShopCardView;", "ecShopCardView", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsCache", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "G", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "orderDetailListListener", "<init>", "(Lcom/tencent/ecommerce/biz/shophome/ui/view/ECShopCardView;Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;)V", "H", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.RecommendGoodsData> {

    /* renamed from: E, reason: from kotlin metadata */
    private final ECShopCardView ecShopCardView;

    /* renamed from: F, reason: from kotlin metadata */
    private final PtsComposerCache<f.RecommendGoodsData, String> ptsCache;

    /* renamed from: G, reason: from kotlin metadata */
    private final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a orderDetailListListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f103368e;

        b(String str) {
            this.f103368e = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.orderDetailListListener.i(this.f103368e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public h(ECShopCardView eCShopCardView, PtsComposerCache<f.RecommendGoodsData, String> ptsComposerCache, com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar) {
        super(eCShopCardView);
        this.ecShopCardView = eCShopCardView;
        this.ptsCache = ptsComposerCache;
        this.orderDetailListListener = aVar;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(f.RecommendGoodsData data) {
        String str;
        PTSComposer g16 = this.ptsCache.g(data);
        if (g16 != null) {
            ECShopCardView.h(this.ecShopCardView, g16, null, 2, null);
        }
        try {
            str = new JSONObject(data.data).optString("url");
        } catch (JSONException e16) {
            cg0.a.a("ECRecommendProductItemViewHolder", "onBindViewHolder", "e=" + e16.getMessage());
            str = "";
        }
        this.ecShopCardView.setOnClickListener(new b(str));
    }
}
