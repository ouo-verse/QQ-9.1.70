package com.tencent.tencentmap.mapsdk.maps;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface UiSettings {
    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScaleViewEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z16);

    void setCompassEnabled(boolean z16);

    void setCompassExtraPadding(int i3);

    void setCompassExtraPadding(int i3, int i16);

    void setFlingGestureEnabled(boolean z16);

    void setGestureRotateByMapCenter(boolean z16);

    void setGestureScaleByMapCenter(boolean z16);

    void setIndoorLevelPickerEnabled(boolean z16);

    void setLogoPosition(int i3);

    void setLogoPosition(int i3, int[] iArr);

    void setLogoPositionWithMargin(int i3, int i16, int i17, int i18, int i19);

    void setLogoScale(float f16);

    void setLogoSize(int i3);

    void setMyLocationButtonEnabled(boolean z16);

    void setRotateGesturesEnabled(boolean z16);

    void setScaleViewEnabled(boolean z16);

    void setScaleViewFadeEnable(boolean z16);

    void setScaleViewPosition(int i3);

    void setScaleViewPositionWithMargin(int i3, int i16, int i17, int i18, int i19);

    void setScrollGesturesEnabled(boolean z16);

    void setTiltGesturesEnabled(boolean z16);

    void setZoomControlsEnabled(boolean z16);

    void setZoomGesturesEnabled(boolean z16);

    void setZoomPosition(int i3);
}
