package android.support.v4.view;

import android.view.VelocityTracker;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VelocityTrackerCompat {
    static final VelocityTrackerVersionImpl IMPL = new HoneycombVelocityTrackerVersionImpl();

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        BaseVelocityTrackerVersionImpl() {
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i3) {
            return velocityTracker.getXVelocity();
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getYVelocity(VelocityTracker velocityTracker, int i3) {
            return velocityTracker.getYVelocity();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        HoneycombVelocityTrackerVersionImpl() {
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i3) {
            return VelocityTrackerCompatHoneycomb.getXVelocity(velocityTracker, i3);
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getYVelocity(VelocityTracker velocityTracker, int i3) {
            return VelocityTrackerCompatHoneycomb.getYVelocity(velocityTracker, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i3);

        float getYVelocity(VelocityTracker velocityTracker, int i3);
    }

    VelocityTrackerCompat() {
    }

    public static float getXVelocity(VelocityTracker velocityTracker, int i3) {
        return IMPL.getXVelocity(velocityTracker, i3);
    }

    public static float getYVelocity(VelocityTracker velocityTracker, int i3) {
        return IMPL.getYVelocity(velocityTracker, i3);
    }
}
