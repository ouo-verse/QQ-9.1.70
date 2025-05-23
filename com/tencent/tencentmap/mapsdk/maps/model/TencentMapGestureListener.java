package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TencentMapGestureListener {
    boolean onDoubleTap(float f16, float f17);

    boolean onDown(float f16, float f17);

    boolean onFling(float f16, float f17);

    boolean onLongPress(float f16, float f17);

    void onMapStable();

    boolean onScroll(float f16, float f17);

    boolean onSingleTap(float f16, float f17);

    boolean onUp(float f16, float f17);
}
