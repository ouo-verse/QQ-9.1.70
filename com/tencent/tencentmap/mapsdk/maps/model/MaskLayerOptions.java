package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MaskLayerOptions {
    private int mColor = 0;
    private long mAnimationDuration = 0;
    private int mZIndex = 0;

    public MaskLayerOptions animationDuration(long j3) {
        this.mAnimationDuration = j3;
        return this;
    }

    public MaskLayerOptions color(int i3) {
        this.mColor = i3;
        return this;
    }

    public long getAnimationDuration() {
        return this.mAnimationDuration;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public MaskLayerOptions zIndex(int i3) {
        this.mZIndex = i3;
        return this;
    }
}
