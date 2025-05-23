package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class bt extends bp {
    public bt(Context context, TencentMapOptions tencentMapOptions, bq bqVar) {
        super(context, tencentMapOptions, bqVar);
    }

    @Override // com.tencent.mapsdk.internal.bp
    public final String G() {
        return "5.6.3.2.2023";
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IAlphaAnimation createAlphaAnimation(float f16, float f17) {
        return new hv(f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IAnimationSet createAnimationSet(boolean z16) {
        return new hx(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IEmergeAnimation createEmergeAnimation(LatLng latLng) {
        return new hy(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public HeatMapTileProvider createHeatMapTileProvider(HeatMapTileProvider.Builder builder) {
        return new bx(builder);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IRotateAnimation createRotateAnimation(float f16, float f17, float f18, float f19, float f26) {
        return new hz(f16, f17, f18, f19, f26);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IScaleAnimation createScaleAnimation(float f16, float f17, float f18, float f19) {
        return new ia(f16, f17, f18, f19);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public ITranslateAnimation createTranslateAnimation(LatLng latLng) {
        return new ib(latLng);
    }

    @Override // com.tencent.mapsdk.internal.bp
    protected final void v() {
    }
}
