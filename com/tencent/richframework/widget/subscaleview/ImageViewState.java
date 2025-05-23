package com.tencent.richframework.widget.subscaleview;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ImageViewState implements Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public ImageViewState(float f16, @NonNull PointF pointF, int i3) {
        this.scale = f16;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i3;
    }

    @NonNull
    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
