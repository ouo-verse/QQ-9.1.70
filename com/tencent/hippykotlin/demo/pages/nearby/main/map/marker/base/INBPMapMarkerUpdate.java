package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

/* loaded from: classes31.dex */
public interface INBPMapMarkerUpdate {
    boolean canShowOnSubMode();

    Boolean clickInSide(float f16, float f17, MarkerRect markerRect);

    MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker);

    NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler);

    void onClickMarkerFromMap(float f16, float f17);

    void themeConfigDidLoad();
}
