package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ny extends HeatmapInfo implements ni {

    /* renamed from: a, reason: collision with root package name */
    GradientVectorOverlayProvider f149475a;

    public ny(GradientVectorOverlayProvider gradientVectorOverlayProvider) {
        this.f149475a = gradientVectorOverlayProvider;
        ArrayList arrayList = new ArrayList();
        arrayList.add(gradientVectorOverlayProvider.getData());
        setDataList(arrayList);
        this.radius = gradientVectorOverlayProvider.getRadius();
        this.colors = gradientVectorOverlayProvider.getColors();
        this.colorPoints = gradientVectorOverlayProvider.getColorPoints();
        this.colorMapSize = gradientVectorOverlayProvider.getColorMapSize();
        this.visible = gradientVectorOverlayProvider.isVisibility();
        this.opacity = gradientVectorOverlayProvider.getOpacity();
        this.maxZoom = gradientVectorOverlayProvider.getMaxZoom();
        this.minZoom = gradientVectorOverlayProvider.getMinZoom();
        this.maxHeight = gradientVectorOverlayProvider.getMaxHeight();
        this.draw3D = gradientVectorOverlayProvider.isEnable3D();
        this.maxIntensity = gradientVectorOverlayProvider.getMaxIntensity();
        this.minIntensity = gradientVectorOverlayProvider.getMinIntensity();
        this.intensityFlag = gradientVectorOverlayProvider.isIntensityFlag();
        this.mAnimate = gradientVectorOverlayProvider.isAnimate();
        this.mAnimateDuration = gradientVectorOverlayProvider.getAnimateDuration();
        this.level = gradientVectorOverlayProvider.getDisplayLevel();
        this.zIndex = gradientVectorOverlayProvider.getZIndex();
        this.outterVectorOverlayLoadListener = gradientVectorOverlayProvider.getVectorOverlayLoadedListener();
        Log.i("libMapEngine", "java colors : " + this.colors.length);
        for (int i3 = 0; i3 < this.colors.length; i3++) {
            Log.i("libMapEngine", "java colors: " + this.colors[i3]);
        }
        Log.i("libMapEngine", "java opacity : " + this.opacity);
        Log.i("libMapEngine", "java colorPoints : " + this.colorPoints.length);
        Log.i("libMapEngine", "java colorMapSize : " + this.colorMapSize);
        Log.i("libMapEngine", "java notes : " + this.notes.length);
        Log.i("libMapEngine", "java nodeIndexes : " + this.nodeIndexes.length);
    }

    private GradientVectorOverlayProvider a() {
        return this.f149475a;
    }
}
