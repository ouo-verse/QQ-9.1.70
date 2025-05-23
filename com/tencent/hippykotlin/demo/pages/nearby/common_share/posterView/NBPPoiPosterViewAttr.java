package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPPoiPosterViewAttr extends k {

    /* renamed from: vm, reason: collision with root package name */
    public NBPBaseShareVM<NearbyMiddlePosterData> f114217vm;

    public final NBPBaseShareVM<NearbyMiddlePosterData> getVm() {
        NBPBaseShareVM<NearbyMiddlePosterData> nBPBaseShareVM = this.f114217vm;
        if (nBPBaseShareVM != null) {
            return nBPBaseShareVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }
}
