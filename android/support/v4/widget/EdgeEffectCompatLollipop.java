package android.support.v4.widget;

import android.widget.EdgeEffect;

/* compiled from: P */
/* loaded from: classes.dex */
class EdgeEffectCompatLollipop {
    EdgeEffectCompatLollipop() {
    }

    public static boolean onPull(Object obj, float f16, float f17) {
        ((EdgeEffect) obj).onPull(f16, f17);
        return true;
    }
}
