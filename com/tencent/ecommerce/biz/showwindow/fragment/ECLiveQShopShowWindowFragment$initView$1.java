package com.tencent.ecommerce.biz.showwindow.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECLiveQShopShowWindowFragment$initView$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveQShopShowWindowFragment$initView$1 extends ViewPager2.OnPageChangeCallback {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ECLiveQShopShowWindowFragment f104509b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECLiveQShopShowWindowFragment$initView$1(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        this.f104509b = eCLiveQShopShowWindowFragment;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(final int position) {
        ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment = this.f104509b;
        FragmentManager childFragmentManager = eCLiveQShopShowWindowFragment.getChildFragmentManager();
        StringBuilder sb5 = new StringBuilder();
        sb5.append('f');
        sb5.append(position);
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(sb5.toString());
        if (!(findFragmentByTag instanceof ECLiveShowWindowListFragment)) {
            findFragmentByTag = null;
        }
        eCLiveQShopShowWindowFragment.currentFragment = (ECLiveShowWindowListFragment) findFragmentByTag;
        if (this.f104509b.currentFragment == null) {
            ECThreadUtilKt.b(200L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$initView$1$onPageSelected$1
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
                    ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment2 = ECLiveQShopShowWindowFragment$initView$1.this.f104509b;
                    FragmentManager childFragmentManager2 = eCLiveQShopShowWindowFragment2.getChildFragmentManager();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append('f');
                    sb6.append(position);
                    Fragment findFragmentByTag2 = childFragmentManager2.findFragmentByTag(sb6.toString());
                    if (!(findFragmentByTag2 instanceof ECLiveShowWindowListFragment)) {
                        findFragmentByTag2 = null;
                    }
                    eCLiveQShopShowWindowFragment2.currentFragment = (ECLiveShowWindowListFragment) findFragmentByTag2;
                    ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment3 = ECLiveQShopShowWindowFragment$initView$1.this.f104509b;
                    eCLiveQShopShowWindowFragment3.gi(position, eCLiveQShopShowWindowFragment3.currentFragment);
                }
            });
        } else {
            ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment2 = this.f104509b;
            eCLiveQShopShowWindowFragment2.gi(position, eCLiveQShopShowWindowFragment2.currentFragment);
        }
    }
}
