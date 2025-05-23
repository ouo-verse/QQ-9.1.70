package com.tencent.state.map;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.state.map.BaseMapView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u0003*\u0012\u0010\u0004\"\u0006\u0012\u0002\b\u00030\u00052\u0006\u0012\u0002\b\u00030\u0005\u00a8\u0006\u0006"}, d2 = {"getMapViewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "Landroid/view/View;", "MapView", "Lcom/tencent/state/map/BaseMapView;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapViewKt {
    public static final MapViewHolder<?> getMapViewHolder(View getMapViewHolder) {
        Intrinsics.checkNotNullParameter(getMapViewHolder, "$this$getMapViewHolder");
        ViewGroup.LayoutParams layoutParams = getMapViewHolder.getLayoutParams();
        if (!(layoutParams instanceof BaseMapView.LayoutParams)) {
            layoutParams = null;
        }
        BaseMapView.LayoutParams layoutParams2 = (BaseMapView.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            return layoutParams2.getHolder();
        }
        return null;
    }
}
