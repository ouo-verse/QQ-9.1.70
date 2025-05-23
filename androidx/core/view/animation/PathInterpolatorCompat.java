package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class PathInterpolatorCompat {
    PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return new PathInterpolator(path);
    }

    public static Interpolator create(float f16, float f17) {
        return new PathInterpolator(f16, f17);
    }

    public static Interpolator create(float f16, float f17, float f18, float f19) {
        return new PathInterpolator(f16, f17, f18, f19);
    }
}
