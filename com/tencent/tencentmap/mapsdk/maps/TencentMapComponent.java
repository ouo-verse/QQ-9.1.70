package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TencentMapComponent {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface Component {
        TencentMapContext getMapContext();
    }

    IAlphaAnimation createAlphaAnimation(float f16, float f17);

    IAnimationSet createAnimationSet(boolean z16);

    IEmergeAnimation createEmergeAnimation(LatLng latLng);

    HeatMapTileProvider createHeatMapTileProvider(HeatMapTileProvider.Builder builder);

    IRotateAnimation createRotateAnimation(float f16, float f17, float f18, float f19, float f26);

    IScaleAnimation createScaleAnimation(float f16, float f17, float f18, float f19);

    ITranslateAnimation createTranslateAnimation(LatLng latLng);

    <T extends Component> T getMapComponent(Class<T> cls);

    TencentMapServiceProtocol getMapServiceProtocol();
}
