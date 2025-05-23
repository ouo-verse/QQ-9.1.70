package com.tencent.map.sdk.utilities.visualization.scatterplot;

import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import java.util.List;

/* loaded from: classes9.dex */
public final class BitmapScatterPlotOverlayProvider extends ScatterPlotOverlayProvider {
    private static final BitmapDescriptor[] DEFAULT_BITMAP_ICONS = new BitmapDescriptor[0];
    private int DEFAULT_WIDTH = 30;
    private int DEFAULT_HEIGHT = 30;
    private int mWidth = 30;
    private int mHeight = 30;
    private BitmapDescriptor[] mBitmaps = DEFAULT_BITMAP_ICONS;

    public BitmapScatterPlotOverlayProvider() {
        type(ScatterPlotOverlayProvider.ScatterPlotType.Bitmap);
    }

    public final BitmapScatterPlotOverlayProvider bitmaps(BitmapDescriptor[] bitmapDescriptorArr) {
        BitmapDescriptor[] bitmapDescriptorArr2 = this.mBitmaps;
        if (bitmapDescriptorArr2.length > 0) {
            return this;
        }
        if (bitmapDescriptorArr2.length == 0 && bitmapDescriptorArr != null) {
            this.mBitmaps = bitmapDescriptorArr;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final /* bridge */ /* synthetic */ ScatterPlotOverlayProvider data(List list) {
        return data((List<ScatterLatLng>) list);
    }

    public final BitmapDescriptor[] getBitmaps() {
        return this.mBitmaps;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final List<ScatterLatLng> getData() {
        return super.getData();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    public final int getHeight() {
        return this.mHeight;
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

    public final int getWidth() {
        return this.mWidth;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getZIndex() {
        return super.getZIndex();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final boolean isEnable3D() {
        return super.isEnable3D();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final boolean isVisibility() {
        return super.isVisibility();
    }

    public final BitmapScatterPlotOverlayProvider scale(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            this.mWidth = i3;
            this.mHeight = i16;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final BitmapScatterPlotOverlayProvider data(List<ScatterLatLng> list) {
        super.data(list);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final BitmapScatterPlotOverlayProvider enable3D(boolean z16) {
        super.enable3D(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
    public final BitmapScatterPlotOverlayProvider zoomRange(int i3, int i16) {
        super.zoomRange(i3, i16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final BitmapScatterPlotOverlayProvider displayLevel(int i3) {
        super.displayLevel(i3);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final BitmapScatterPlotOverlayProvider opacity(float f16) {
        super.opacity(f16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final BitmapScatterPlotOverlayProvider visibility(boolean z16) {
        super.visibility(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider, com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final BitmapScatterPlotOverlayProvider zIndex(int i3) {
        super.zIndex(i3);
        return this;
    }
}
