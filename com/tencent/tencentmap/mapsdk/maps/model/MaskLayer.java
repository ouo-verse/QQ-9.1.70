package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface MaskLayer {
    String getId();

    MaskLayerOptions getOptions();

    int getZIndex();

    boolean isClickable();

    boolean isVisible();

    void remove();

    void remove(long j3);

    void setOptions(MaskLayerOptions maskLayerOptions);

    void setVisible(boolean z16);

    void setZIndex(int i3);
}
