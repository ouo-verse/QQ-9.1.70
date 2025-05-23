package androidx.core.view;

import android.view.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {
    ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z16) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z16);
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return scaleGestureDetector.isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z16) {
        scaleGestureDetector.setQuickScaleEnabled(z16);
    }
}
