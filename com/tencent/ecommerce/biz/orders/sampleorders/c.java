package com.tencent.ecommerce.biz.orders.sampleorders;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/c;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "index", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListFragment;", "i0", "", "newFragmentList", "", "j0", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "fragmentList", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroidx/fragment/app/Fragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c extends FragmentStateAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ECApplySampleOrderListFragment> fragmentList;

    public c(Fragment fragment) {
        super(fragment);
        this.fragmentList = new ArrayList();
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

    public final ECApplySampleOrderListFragment i0(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.fragmentList, index);
        return (ECApplySampleOrderListFragment) orNull;
    }

    public final void j0(List<ECApplySampleOrderListFragment> newFragmentList) {
        List<ECApplySampleOrderListFragment> list = this.fragmentList;
        list.clear();
        list.addAll(newFragmentList);
        notifyDataSetChanged();
    }
}
