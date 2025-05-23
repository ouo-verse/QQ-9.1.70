package com.tencent.mapsdk.core;

import android.support.annotation.Keep;
import android.view.ViewGroup;
import com.tencent.mapsdk.internal.bw;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public interface MapDelegate<C extends TencentMapContext, M extends TencentMap, V extends bw> extends BaseMapView.MapViewProxy {
    M createMap(C c16);

    V createMapView(C c16, ViewGroup viewGroup);

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    M getMap();

    C getMapContext();

    V getMapRenderView();
}
