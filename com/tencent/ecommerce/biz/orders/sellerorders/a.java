package com.tencent.ecommerce.biz.orders.sellerorders;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/ECAbsSellerOrderFragment;", "newFragments", "", "j0", "", "index", "newFragment", "l0", "i0", "k0", "newFragmentList", "m0", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "fragmentList", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroidx/fragment/app/Fragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends FragmentStateAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ECAbsSellerOrderFragment> fragmentList;

    public a(Fragment fragment) {
        super(fragment);
        this.fragmentList = new ArrayList();
    }

    private final void i0(ECAbsSellerOrderFragment newFragment) {
        int lastIndex;
        this.fragmentList.add(newFragment);
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.fragmentList);
        notifyItemInserted(lastIndex);
    }

    private final void j0(List<? extends ECAbsSellerOrderFragment> newFragments) {
        this.fragmentList.clear();
        this.fragmentList.addAll(newFragments);
        notifyDataSetChanged();
    }

    private final void l0(int index, ECAbsSellerOrderFragment newFragment) {
        this.fragmentList.set(index, newFragment);
        notifyItemChanged(index);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        return this.fragmentList.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.fragmentList.size();
    }

    public final ECAbsSellerOrderFragment k0(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.fragmentList, index);
        return (ECAbsSellerOrderFragment) orNull;
    }

    public final void m0(List<? extends ECAbsSellerOrderFragment> newFragmentList) {
        Object orNull;
        if (!this.fragmentList.isEmpty() && newFragmentList.size() >= this.fragmentList.size()) {
            int i3 = 0;
            for (Object obj : newFragmentList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.fragmentList, i3);
                ECAbsSellerOrderFragment eCAbsSellerOrderFragment = (ECAbsSellerOrderFragment) orNull;
                ECAbsSellerOrderFragment eCAbsSellerOrderFragment2 = newFragmentList.get(i3);
                if (eCAbsSellerOrderFragment == null) {
                    i0(eCAbsSellerOrderFragment2);
                } else if (eCAbsSellerOrderFragment.Mh() != eCAbsSellerOrderFragment2.Mh()) {
                    l0(i3, eCAbsSellerOrderFragment2);
                }
                i3 = i16;
            }
            return;
        }
        j0(newFragmentList);
    }
}
