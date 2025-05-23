package com.tencent.state.square.exposure;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.map.MapItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/exposure/EmptyExposureManager;", "Lcom/tencent/state/square/exposure/IExposureManager;", "()V", "canExposure", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/map/MapItem;", "doExposure", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EmptyExposureManager implements IExposureManager {
    @Override // com.tencent.state.square.exposure.IExposureManager
    public boolean canExposure(MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return false;
    }

    @Override // com.tencent.state.square.exposure.IExposureManager
    public void doExposure(MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
    }
}
