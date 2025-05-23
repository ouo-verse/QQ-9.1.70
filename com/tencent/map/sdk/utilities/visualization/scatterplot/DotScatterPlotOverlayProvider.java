package com.tencent.map.sdk.utilities.visualization.scatterplot;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider;
import java.util.List;

/* loaded from: classes9.dex */
public final class DotScatterPlotOverlayProvider extends ScatterPlotOverlayProvider {
    private static final int[] DEFAULT_SCATTER_COLORS = {Color.argb(255, 255, 202, 31), Color.argb(229, 204, 24, 93), Color.argb(127, 148, 28, 230)};
    private final int DEFAULT_RADIUS = 6;
    private int mRadius = 6;
    private int[] mColors = DEFAULT_SCATTER_COLORS;
    private boolean mAnimate = false;

    public DotScatterPlotOverlayProvider() {
        type(ScatterPlotOverlayProvider.ScatterPlotType.Dot);
    }

    public final DotScatterPlotOverlayProvider animate(boolean z16) {
        this.mAnimate = z16;
        return this;
    }

    public final DotScatterPlotOverlayProvider colors(int[] iArr) {
        if (iArr != null) {
            this.mColors = iArr;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final /* bridge */ /* synthetic */ ScatterPlotOverlayProvider data(List list) {
        return data((List<ScatterLatLng>) list);
    }

    public final int[] getColors() {
        return this.mColors;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final List<ScatterLatLng> getData() {
        return super.getData();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMaxZoom() {
        return super.getMaxZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMinZoom() {
        return super.getMinZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final float getOpacity() {
        return super.getOpacity();
    }

    public final int getRadius() {
        return this.mRadius;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getZIndex() {
        return super.getZIndex();
    }

    public final boolean isAnimate() {
        return this.mAnimate;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final boolean isEnable3D() {
        return super.isEnable3D();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final boolean isVisibility() {
        return super.isVisibility();
    }

    public final DotScatterPlotOverlayProvider radius(int i3) {
        if (i3 > 0) {
            this.mRadius = i3;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final DotScatterPlotOverlayProvider data(List<ScatterLatLng> list) {
        super.data(list);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final DotScatterPlotOverlayProvider enable3D(boolean z16) {
        super.enable3D(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final DotScatterPlotOverlayProvider zoomRange(int i3, int i16) {
        super.zoomRange(i3, i16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final DotScatterPlotOverlayProvider displayLevel(int i3) {
        super.displayLevel(i3);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final DotScatterPlotOverlayProvider opacity(float f16) {
        super.opacity(f16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final DotScatterPlotOverlayProvider visibility(boolean z16) {
        super.visibility(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final DotScatterPlotOverlayProvider zIndex(int i3) {
        super.zIndex(i3);
        return this;
    }
}
