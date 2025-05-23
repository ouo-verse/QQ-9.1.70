package android.support.v4.view.animation;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;

@TargetApi(9)
/* loaded from: classes.dex */
class PathInterpolatorCompatBase {
    PathInterpolatorCompatBase() {
    }

    public static Interpolator create(Path path) {
        return new PathInterpolatorGingerbread(path);
    }

    public static Interpolator create(float f16, float f17) {
        return new PathInterpolatorGingerbread(f16, f17);
    }

    public static Interpolator create(float f16, float f17, float f18, float f19) {
        return new PathInterpolatorGingerbread(f16, f17, f18, f19);
    }
}
