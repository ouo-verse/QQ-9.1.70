package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPLandMarkerAttr extends k {

    /* renamed from: vm, reason: collision with root package name */
    public NBPLandMarkerViewModel f114226vm;

    public final NBPLandMarkerViewModel getVm() {
        NBPLandMarkerViewModel nBPLandMarkerViewModel = this.f114226vm;
        if (nBPLandMarkerViewModel != null) {
            return nBPLandMarkerViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }
}
