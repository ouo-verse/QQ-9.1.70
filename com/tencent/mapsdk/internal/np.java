package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class np extends ArcLineOverlayInfo implements ni {

    /* renamed from: a, reason: collision with root package name */
    ArcLineOverlayProvider f149468a;

    public np(ArcLineOverlayProvider arcLineOverlayProvider) {
        this.f149468a = arcLineOverlayProvider;
        ArrayList arrayList = new ArrayList();
        arrayList.add(arcLineOverlayProvider.getData());
        setDataList(arrayList);
        this.mType = 0;
        this.mOpacity = arcLineOverlayProvider.getOpacity();
        this.mVisibility = arcLineOverlayProvider.isVisibility();
        this.mMinZoom = arcLineOverlayProvider.getMinZoom();
        this.mMaxZoom = arcLineOverlayProvider.getMaxZoom();
        this.mWidth = arcLineOverlayProvider.getWidth();
        this.mZIndex = arcLineOverlayProvider.getZIndex();
        this.mDraw3D = arcLineOverlayProvider.isEnable3D();
        this.mAnimate = arcLineOverlayProvider.isAnimate();
        this.mAnimateDuration = arcLineOverlayProvider.getAnimateDuration();
        this.mHighLightDuration = arcLineOverlayProvider.getHighLightDuration();
        this.mAnimateColor = arcLineOverlayProvider.getAnimateColor();
        this.mColors = arcLineOverlayProvider.getColors();
        this.mColorPoints = arcLineOverlayProvider.getColorPoints();
        this.mColorMapSize = arcLineOverlayProvider.getColorMapSize();
        this.mDisplayLevel = arcLineOverlayProvider.getDisplayLevel();
        this.outterVectorOverlayLoadListener = arcLineOverlayProvider.getVectorOverlayLoadedListener();
    }

    private ArcLineOverlayProvider a() {
        return this.f149468a;
    }
}
