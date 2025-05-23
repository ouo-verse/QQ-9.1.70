package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel;

import com.tencent.filament.zplan.scene.xwconnect.data.CoinType;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {
    public static final boolean a(MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData) {
        Intrinsics.checkNotNullParameter(flowerData, "<this>");
        return (flowerData.getFlowerCoinType() == CoinType.SILVER || flowerData.getFlowerCoinType() == CoinType.GOLD) && flowerData.getFlowerCost() > 0 && flowerData.getFlowerOwnStatus() == 2;
    }
}
