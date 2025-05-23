package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Box {
    private final float[] mCenter;
    private final float[] mHalfExtent;

    public Box() {
        this.mCenter = new float[3];
        this.mHalfExtent = new float[3];
    }

    @NonNull
    @Size(min = 3)
    public float[] getCenter() {
        return this.mCenter;
    }

    @NonNull
    @Size(min = 3)
    public float[] getHalfExtent() {
        return this.mHalfExtent;
    }

    public void setCenter(float f16, float f17, float f18) {
        float[] fArr = this.mCenter;
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
    }

    public void setHalfExtent(float f16, float f17, float f18) {
        float[] fArr = this.mHalfExtent;
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
    }

    public Box(float f16, float f17, float f18, float f19, float f26, float f27) {
        this.mCenter = r1;
        this.mHalfExtent = r0;
        float[] fArr = {f16, f17, f18};
        float[] fArr2 = {f19, f26, f27};
    }

    public Box(@NonNull @Size(min = 3) float[] fArr, @NonNull @Size(min = 3) float[] fArr2) {
        this.mCenter = r1;
        this.mHalfExtent = r0;
        float[] fArr3 = {fArr[0], fArr[1], fArr[2]};
        float[] fArr4 = {fArr2[0], fArr2[1], fArr2[2]};
    }
}
