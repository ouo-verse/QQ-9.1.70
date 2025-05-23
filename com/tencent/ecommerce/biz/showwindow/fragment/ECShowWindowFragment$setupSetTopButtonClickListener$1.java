package com.tencent.ecommerce.biz.showwindow.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ck0.Product;
import com.tencent.ecommerce.biz.common.d;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShowWindowFragment$setupSetTopButtonClickListener$1 implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECShowWindowFragment f104630d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECShowWindowFragment$setupSetTopButtonClickListener$1(ECShowWindowFragment eCShowWindowFragment) {
        this.f104630d = eCShowWindowFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        List<Product> value = ECShowWindowFragment.zi(this.f104630d).C2().getValue();
        int size = value != null ? value.size() : 0;
        if (size <= 1 && size > 0) {
            List<Product> value2 = ECShowWindowFragment.zi(this.f104630d).C2().getValue();
            Product product = value2 != null ? value2.get(0) : null;
            if (product != null) {
                ECShowWindowFragment.zi(this.f104630d).i3(product);
                ECShowWindowFragment.mi(this.f104630d).notifyDataSetChanged();
                d.f101554a.e(this.f104630d.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String, product, "window_goods_card_top", (r18 & 8) != 0 ? "" : null, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? 1 : 0, (r18 & 64) != 0 ? null : null);
            }
            ECShowWindowFragment.ni(this.f104630d).post(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$setupSetTopButtonClickListener$1.2
                @Override // java.lang.Runnable
                public final void run() {
                    ECShowWindowFragment.ni(ECShowWindowFragment$setupSetTopButtonClickListener$1.this.f104630d).postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment.setupSetTopButtonClickListener.1.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ECShowWindowFragment.ni(ECShowWindowFragment$setupSetTopButtonClickListener$1.this.f104630d).scrollToPosition(0);
                            RecyclerView.LayoutManager layoutManager = ECShowWindowFragment.ni(ECShowWindowFragment$setupSetTopButtonClickListener$1.this.f104630d).getLayoutManager();
                            if (layoutManager != null) {
                                layoutManager.scrollToPosition(0);
                            }
                        }
                    }, 300L);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
