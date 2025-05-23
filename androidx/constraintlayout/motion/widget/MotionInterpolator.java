package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f16);

    public abstract float getVelocity();
}
