package android.widget;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes.dex */
public class AIOScrollerInterpolator implements Interpolator {
    private static final float VISCOUS_FLUID_NORMALIZE;
    private static final float VISCOUS_FLUID_OFFSET;
    private static final float VISCOUS_FLUID_SCALE = 8.0f;

    static {
        float viscousFluid = 1.0f / viscousFluid(1.0f);
        VISCOUS_FLUID_NORMALIZE = viscousFluid;
        VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * viscousFluid(1.0f));
    }

    private static float viscousFluid(float f16) {
        float f17 = f16 * 8.0f;
        if (f17 < 1.0f) {
            return f17 - (1.0f - ((float) Math.exp(-f17)));
        }
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        float viscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f16);
        if (viscousFluid > 0.0f) {
            return viscousFluid + VISCOUS_FLUID_OFFSET;
        }
        return viscousFluid;
    }
}
