package com.airbnb.lottie.value;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f16, float f17) {
        this.scaleX = f16;
        this.scaleY = f17;
    }

    public boolean equals(float f16, float f17) {
        if (this.scaleX == f16 && this.scaleY == f17) {
            return true;
        }
        return false;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f16, float f17) {
        this.scaleX = f16;
        this.scaleY = f17;
    }

    public String toString() {
        return getScaleX() + HippyTKDListViewAdapter.X + getScaleY();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
