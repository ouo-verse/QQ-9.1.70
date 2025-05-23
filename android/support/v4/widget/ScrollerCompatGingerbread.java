package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: P */
/* loaded from: classes.dex */
class ScrollerCompatGingerbread {
    ScrollerCompatGingerbread() {
    }

    public static void abortAnimation(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static boolean computeScrollOffset(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static Object createScroller(Context context, Interpolator interpolator) {
        if (interpolator != null) {
            return new OverScroller(context, interpolator);
        }
        return new OverScroller(context);
    }

    public static void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        ((OverScroller) obj).fling(i3, i16, i17, i18, i19, i26, i27, i28);
    }

    public static int getCurrX(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int getCurrY(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static int getFinalX(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int getFinalY(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }

    public static boolean isFinished(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static boolean isOverScrolled(Object obj) {
        return ((OverScroller) obj).isOverScrolled();
    }

    public static void notifyHorizontalEdgeReached(Object obj, int i3, int i16, int i17) {
        ((OverScroller) obj).notifyHorizontalEdgeReached(i3, i16, i17);
    }

    public static void notifyVerticalEdgeReached(Object obj, int i3, int i16, int i17) {
        ((OverScroller) obj).notifyVerticalEdgeReached(i3, i16, i17);
    }

    public static void startScroll(Object obj, int i3, int i16, int i17, int i18) {
        ((OverScroller) obj).startScroll(i3, i16, i17, i18);
    }

    public static void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        ((OverScroller) obj).fling(i3, i16, i17, i18, i19, i26, i27, i28, i29, i36);
    }

    public static void startScroll(Object obj, int i3, int i16, int i17, int i18, int i19) {
        ((OverScroller) obj).startScroll(i3, i16, i17, i18, i19);
    }
}
