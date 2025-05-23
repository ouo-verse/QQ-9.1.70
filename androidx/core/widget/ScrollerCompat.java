package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public final class ScrollerCompat {
    OverScroller mScroller;

    ScrollerCompat(Context context, Interpolator interpolator) {
        OverScroller overScroller;
        if (interpolator != null) {
            overScroller = new OverScroller(context, interpolator);
        } else {
            overScroller = new OverScroller(context);
        }
        this.mScroller = overScroller;
    }

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.mScroller.fling(i3, i16, i17, i18, i19, i26, i27, i28);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i3, int i16, int i17) {
        this.mScroller.notifyHorizontalEdgeReached(i3, i16, i17);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i3, int i16, int i17) {
        this.mScroller.notifyVerticalEdgeReached(i3, i16, i17);
    }

    @Deprecated
    public boolean springBack(int i3, int i16, int i17, int i18, int i19, int i26) {
        return this.mScroller.springBack(i3, i16, i17, i18, i19, i26);
    }

    @Deprecated
    public void startScroll(int i3, int i16, int i17, int i18) {
        this.mScroller.startScroll(i3, i16, i17, i18);
    }

    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        this.mScroller.fling(i3, i16, i17, i18, i19, i26, i27, i28, i29, i36);
    }

    @Deprecated
    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        this.mScroller.startScroll(i3, i16, i17, i18, i19);
    }
}
