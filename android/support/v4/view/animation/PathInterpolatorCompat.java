package android.support.v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class PathInterpolatorCompat {
    PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return PathInterpolatorCompatBase.create(path);
    }

    public static Interpolator create(float f16, float f17) {
        return PathInterpolatorCompatBase.create(f16, f17);
    }

    public static Interpolator create(float f16, float f17, float f18, float f19) {
        return PathInterpolatorCompatBase.create(f16, f17, f18, f19);
    }
}
