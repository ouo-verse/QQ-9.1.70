package org.light.bean;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DyeColorInfo {
    private float[][] colors;

    public DyeColorInfo(float[][] fArr) {
        this.colors = fArr;
    }

    public float[][] getColors() {
        return this.colors;
    }

    public void setColor(float[] fArr, int i3) {
        this.colors[i3] = fArr;
    }

    public void setColors(float[][] fArr) {
        this.colors = fArr;
    }
}
