package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPMarkersAttr extends k {
    public NBPMarkersViewModel viewModel;

    public final NBPMarkersViewModel getViewModel() {
        NBPMarkersViewModel nBPMarkersViewModel = this.viewModel;
        if (nBPMarkersViewModel != null) {
            return nBPMarkersViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
