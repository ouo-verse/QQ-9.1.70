package com.tencent.ecommerce.biz.detail.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailCustomViewModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$initListeners$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailPageFragment$initListeners$2 extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECShopProductDetailPageFragment f102212d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECShopProductDetailPageFragment$initListeners$2(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        this.f102212d = eCShopProductDetailPageFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            ECShopProductDetailPageFragment.Uh(this.f102212d).post(new Runnable() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$initListeners$2$onScrollStateChanged$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECShopProductDetailPageFragment$initListeners$2.this.f102212d.isScrollingByTabClick = false;
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
        int i3;
        int i16;
        super.onScrolled(recyclerView, dx5, dy5);
        ECShopProductDetailPageFragment eCShopProductDetailPageFragment = this.f102212d;
        i3 = eCShopProductDetailPageFragment.scrollY;
        eCShopProductDetailPageFragment.scrollY = i3 + dy5;
        ECShopProductDetailCustomViewModel ui5 = ECShopProductDetailPageFragment.ui(this.f102212d);
        i16 = this.f102212d.scrollY;
        ui5.o2(i16);
    }
}
