package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

/* compiled from: P */
/* loaded from: classes.dex */
public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] fArr, int[] iArr) {
        this.positions = fArr;
        this.colors = iArr;
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f16) {
        if (gradientColor.colors.length == gradientColor2.colors.length) {
            for (int i3 = 0; i3 < gradientColor.colors.length; i3++) {
                this.positions[i3] = MiscUtils.lerp(gradientColor.positions[i3], gradientColor2.positions[i3], f16);
                this.colors[i3] = GammaEvaluator.evaluate(f16, gradientColor.colors[i3], gradientColor2.colors[i3]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.colors.length + " vs " + gradientColor2.colors.length + ")");
    }
}
