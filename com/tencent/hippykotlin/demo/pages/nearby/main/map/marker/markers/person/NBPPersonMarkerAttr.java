package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPPersonMarkerAttr extends k {
    public NBPPersonMarkerViewModel viewModel;

    public final NBPPersonMarkerViewModel getViewModel() {
        NBPPersonMarkerViewModel nBPPersonMarkerViewModel = this.viewModel;
        if (nBPPersonMarkerViewModel != null) {
            return nBPPersonMarkerViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
