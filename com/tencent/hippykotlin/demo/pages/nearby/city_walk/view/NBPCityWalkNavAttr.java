package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPCityWalkNavAttr extends k {
    public CityWalkNavFrom from;
    public NBPCityWalkViewModel viewModel;

    public final CityWalkNavFrom getFrom() {
        CityWalkNavFrom cityWalkNavFrom = this.from;
        if (cityWalkNavFrom != null) {
            return cityWalkNavFrom;
        }
        Intrinsics.throwUninitializedPropertyAccessException("from");
        return null;
    }

    public final NBPCityWalkViewModel getViewModel() {
        NBPCityWalkViewModel nBPCityWalkViewModel = this.viewModel;
        if (nBPCityWalkViewModel != null) {
            return nBPCityWalkViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
