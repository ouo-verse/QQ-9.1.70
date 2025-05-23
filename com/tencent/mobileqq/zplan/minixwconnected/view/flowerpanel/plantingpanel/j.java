package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/j;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends DiffUtil.ItemCallback<MiniHomeFlowerPlantingPanelViewModel.FlowerData> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(MiniHomeFlowerPlantingPanelViewModel.FlowerData oldItem, MiniHomeFlowerPlantingPanelViewModel.FlowerData newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(MiniHomeFlowerPlantingPanelViewModel.FlowerData oldItem, MiniHomeFlowerPlantingPanelViewModel.FlowerData newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.getId() == newItem.getId();
    }
}
