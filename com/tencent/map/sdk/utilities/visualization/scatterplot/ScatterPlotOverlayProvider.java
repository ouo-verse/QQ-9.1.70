package com.tencent.map.sdk.utilities.visualization.scatterplot;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class ScatterPlotOverlayProvider extends BaseOverlayProvider {
    private List<ScatterLatLng> dataList = new ArrayList();
    private int mType = 0;
    private boolean mDraw3D = false;

    /* loaded from: classes9.dex */
    public enum ScatterPlotType {
        Dot,
        Bitmap
    }

    public ScatterPlotOverlayProvider data(List<ScatterLatLng> list) {
        if (list != null) {
            this.dataList = list;
        }
        return this;
    }

    public ScatterPlotOverlayProvider enable3D(boolean z16) {
        this.mDraw3D = z16;
        return this;
    }

    public List<ScatterLatLng> getData() {
        return this.dataList;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMaxZoom() {
        return super.getMaxZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return super.getMinZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return super.getOpacity();
    }

    public int getType() {
        return ScatterPlotType.values()[this.mType].ordinal();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getZIndex() {
        return super.getZIndex();
    }

    public boolean isEnable3D() {
        return this.mDraw3D;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return super.isVisibility();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ScatterPlotOverlayProvider type(ScatterPlotType scatterPlotType) {
        this.mType = scatterPlotType.ordinal();
        return this;
    }

    public ScatterPlotOverlayProvider zoomRange(int i3, int i16) {
        if (i3 <= i16) {
            super.minZoom(i3);
            super.maxZoom(i16);
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public ScatterPlotOverlayProvider displayLevel(int i3) {
        super.displayLevel(i3);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public ScatterPlotOverlayProvider opacity(float f16) {
        super.opacity(f16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public ScatterPlotOverlayProvider visibility(boolean z16) {
        super.visibility(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public ScatterPlotOverlayProvider zIndex(int i3) {
        super.zIndex(i3);
        return this;
    }
}
