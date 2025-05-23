package org.light.lightAssetKit.components;

/* loaded from: classes29.dex */
public class PointItem {
    public boolean fixed;
    public float positionX;
    public float positionY;

    public PointItem() {
        this.positionX = 0.0f;
        this.positionY = 0.0f;
        this.fixed = false;
    }

    public PointItem(float f16, float f17, boolean z16) {
        this.positionX = f16;
        this.positionY = f17;
        this.fixed = z16;
    }
}
