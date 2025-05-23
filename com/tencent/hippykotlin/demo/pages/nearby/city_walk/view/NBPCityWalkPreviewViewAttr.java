package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPCityWalkPreviewViewAttr extends k {
    public NBPCityWalkViewModel viewModel;

    public final NBPCityWalkViewModel getViewModel() {
        NBPCityWalkViewModel nBPCityWalkViewModel = this.viewModel;
        if (nBPCityWalkViewModel != null) {
            return nBPCityWalkViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
