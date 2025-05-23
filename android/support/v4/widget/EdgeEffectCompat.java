package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    private static final EdgeEffectImpl IMPL = new EdgeEffectLollipopImpl();
    private Object mEdgeEffect;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BaseEdgeEffectImpl implements EdgeEffectImpl {
        BaseEdgeEffectImpl() {
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean draw(Object obj, Canvas canvas) {
            return false;
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean isFinished(Object obj) {
            return true;
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public Object newEdgeEffect(Context context) {
            return null;
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onAbsorb(Object obj, int i3) {
            return false;
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onPull(Object obj, float f16) {
            return false;
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onRelease(Object obj) {
            return false;
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onPull(Object obj, float f16, float f17) {
            return false;
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public void finish(Object obj) {
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public void setSize(Object obj, int i3, int i16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class EdgeEffectIcsImpl implements EdgeEffectImpl {
        EdgeEffectIcsImpl() {
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean draw(Object obj, Canvas canvas) {
            return EdgeEffectCompatIcs.draw(obj, canvas);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public void finish(Object obj) {
            EdgeEffectCompatIcs.finish(obj);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean isFinished(Object obj) {
            return EdgeEffectCompatIcs.isFinished(obj);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public Object newEdgeEffect(Context context) {
            return EdgeEffectCompatIcs.newEdgeEffect(context);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onAbsorb(Object obj, int i3) {
            return EdgeEffectCompatIcs.onAbsorb(obj, i3);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onPull(Object obj, float f16) {
            return EdgeEffectCompatIcs.onPull(obj, f16);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onRelease(Object obj) {
            return EdgeEffectCompatIcs.onRelease(obj);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public void setSize(Object obj, int i3, int i16) {
            EdgeEffectCompatIcs.setSize(obj, i3, i16);
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onPull(Object obj, float f16, float f17) {
            return EdgeEffectCompatIcs.onPull(obj, f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface EdgeEffectImpl {
        boolean draw(Object obj, Canvas canvas);

        void finish(Object obj);

        boolean isFinished(Object obj);

        Object newEdgeEffect(Context context);

        boolean onAbsorb(Object obj, int i3);

        boolean onPull(Object obj, float f16);

        boolean onPull(Object obj, float f16, float f17);

        boolean onRelease(Object obj);

        void setSize(Object obj, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class EdgeEffectLollipopImpl extends EdgeEffectIcsImpl {
        EdgeEffectLollipopImpl() {
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectIcsImpl, android.support.v4.widget.EdgeEffectCompat.EdgeEffectImpl
        public boolean onPull(Object obj, float f16, float f17) {
            return EdgeEffectCompatLollipop.onPull(obj, f16, f17);
        }
    }

    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = IMPL.newEdgeEffect(context);
    }

    public boolean draw(Canvas canvas) {
        return IMPL.draw(this.mEdgeEffect, canvas);
    }

    public void finish() {
        IMPL.finish(this.mEdgeEffect);
    }

    public boolean isFinished() {
        return IMPL.isFinished(this.mEdgeEffect);
    }

    public boolean onAbsorb(int i3) {
        return IMPL.onAbsorb(this.mEdgeEffect, i3);
    }

    public boolean onPull(float f16) {
        return IMPL.onPull(this.mEdgeEffect, f16);
    }

    public boolean onRelease() {
        return IMPL.onRelease(this.mEdgeEffect);
    }

    public void setSize(int i3, int i16) {
        IMPL.setSize(this.mEdgeEffect, i3, i16);
    }

    public boolean onPull(float f16, float f17) {
        return IMPL.onPull(this.mEdgeEffect, f16, f17);
    }
}
