package com.tencent.ecommerce.biz.live.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.live.TabInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$initUI$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowMainFragment$initUI$1 extends ViewPager2.OnPageChangeCallback {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ECLiveWindowMainFragment f102730b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECLiveWindowMainFragment$initUI$1(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        this.f102730b = eCLiveWindowMainFragment;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(final int position) {
        ECLiveWindowSubFragment eCLiveWindowSubFragment;
        Map map;
        final TabInfo S1 = ECLiveWindowMainFragment.Yh(this.f102730b).S1(position);
        if (S1 != null) {
            ECLiveWindowMainFragment.Yh(this.f102730b).a2(S1);
        }
        eCLiveWindowSubFragment = this.f102730b.currentFragment;
        if (eCLiveWindowSubFragment != null) {
            map = this.f102730b.schemeCallbackParams;
            map.putAll(eCLiveWindowSubFragment.Ii());
        }
        ECThreadUtilKt.b(200L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowMainFragment$initUI$1$onPageSelected$3
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
                Fragment fragment;
                ECLiveWindowSubFragment eCLiveWindowSubFragment2;
                ECLiveWindowMainFragment eCLiveWindowMainFragment = ECLiveWindowMainFragment$initUI$1.this.f102730b;
                FragmentManager childFragmentManager = eCLiveWindowMainFragment.getChildFragmentManager();
                if (childFragmentManager != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append('f');
                    sb5.append(position);
                    fragment = childFragmentManager.findFragmentByTag(sb5.toString());
                } else {
                    fragment = null;
                }
                eCLiveWindowMainFragment.currentFragment = (ECLiveWindowSubFragment) (fragment instanceof ECLiveWindowSubFragment ? fragment : null);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("onPageSelected position\uff1a");
                sb6.append(position);
                sb6.append(" tabInfo :");
                sb6.append(S1);
                sb6.append(", currentFragment=");
                eCLiveWindowSubFragment2 = ECLiveWindowMainFragment$initUI$1.this.f102730b.currentFragment;
                sb6.append(eCLiveWindowSubFragment2);
                cg0.a.b("ECLiveWindowMainFragment", sb6.toString());
            }
        });
    }
}
