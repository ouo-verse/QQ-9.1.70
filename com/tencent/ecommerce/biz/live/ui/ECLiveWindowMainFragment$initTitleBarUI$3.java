package com.tencent.ecommerce.biz.live.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.live.TabInfo;
import ei0.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$initTitleBarUI$3", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowMainFragment$initTitleBarUI$3 implements TabLayout.d {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECLiveWindowMainFragment f102729d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECLiveWindowMainFragment$initTitleBarUI$3(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        this.f102729d = eCLiveWindowMainFragment;
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(final TabLayout.g tab) {
        if (tab != null) {
            TabInfo S1 = ECLiveWindowMainFragment.Yh(this.f102729d).S1(tab.g());
            cg0.a.b("ECLiveWindowMainFragment", "OnTabSelectedListener onTabSelected tab position\uff1a" + tab.g() + " text:" + tab.j());
            if (S1 != null) {
                d.f396304b.n(tab.f34288i, S1.id);
            }
            ECThreadUtilKt.b(200L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowMainFragment$initTitleBarUI$3$onTabSelected$$inlined$run$lambda$1
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
                    View childAt = ECLiveWindowMainFragment.Vh(this.f102729d).getChildAt(0);
                    if (childAt == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    View childAt2 = ((ViewGroup) childAt).getChildAt(TabLayout.g.this.g());
                    if (childAt2 != null) {
                        View childAt3 = ((LinearLayout) childAt2).getChildAt(1);
                        if (!(childAt3 instanceof TextView)) {
                            childAt3 = null;
                        }
                        TextView textView = (TextView) childAt3;
                        if (textView != null) {
                            textView.setTypeface(textView.getTypeface(), 1);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
                }
            });
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.g tab) {
        if (tab != null) {
            cg0.a.b("ECLiveWindowMainFragment", "OnTabSelectedListener onTabUnselected tab position\uff1a" + tab.g() + " text:" + tab.j());
            View childAt = ECLiveWindowMainFragment.Vh(this.f102729d).getChildAt(0);
            if (childAt != null) {
                View childAt2 = ((ViewGroup) childAt).getChildAt(tab.g());
                if (childAt2 != null) {
                    View childAt3 = ((LinearLayout) childAt2).getChildAt(1);
                    if (!(childAt3 instanceof TextView)) {
                        childAt3 = null;
                    }
                    TextView textView = (TextView) childAt3;
                    if (textView != null) {
                        textView.setTypeface(null, 0);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.g tab) {
    }
}
