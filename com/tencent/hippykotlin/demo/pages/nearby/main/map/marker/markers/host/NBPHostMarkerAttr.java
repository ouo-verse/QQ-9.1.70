package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPHostMarkerAttr extends k {
    public NBPHostMarkerViewModel viewModel;

    public final NBPHostMarkerViewModel getViewModel() {
        NBPHostMarkerViewModel nBPHostMarkerViewModel = this.viewModel;
        if (nBPHostMarkerViewModel != null) {
            return nBPHostMarkerViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
