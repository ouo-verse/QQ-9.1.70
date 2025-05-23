package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScrollerCompat {
    static final int CHASE_FRAME_TIME = 16;
    private static final String TAG = "ScrollerCompat";
    ScrollerCompatImpl mImpl;
    Object mScroller;

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface ScrollerCompatImpl {
        void abortAnimation(Object obj);

        boolean computeScrollOffset(Object obj);

        Object createScroller(Context context, Interpolator interpolator);

        void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

        void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36);

        float getCurrVelocity(Object obj);

        int getCurrX(Object obj);

        int getCurrY(Object obj);

        int getFinalX(Object obj);

        int getFinalY(Object obj);

        boolean isFinished(Object obj);

        boolean isOverScrolled(Object obj);

        void notifyHorizontalEdgeReached(Object obj, int i3, int i16, int i17);

        void notifyVerticalEdgeReached(Object obj, int i3, int i16, int i17);

        void startScroll(Object obj, int i3, int i16, int i17, int i18);

        void startScroll(Object obj, int i3, int i16, int i17, int i18, int i19);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ScrollerCompatImplBase implements ScrollerCompatImpl {
        ScrollerCompatImplBase() {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void abortAnimation(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean computeScrollOffset(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public Object createScroller(Context context, Interpolator interpolator) {
            if (interpolator != null) {
                return new Scroller(context, interpolator);
            }
            return new Scroller(context);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            ((Scroller) obj).fling(i3, i16, i17, i18, i19, i26, i27, i28);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(Object obj) {
            return 0.0f;
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrX(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrY(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalX(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalY(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isFinished(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isOverScrolled(Object obj) {
            return false;
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object obj, int i3, int i16, int i17, int i18) {
            ((Scroller) obj).startScroll(i3, i16, i17, i18);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
            ((Scroller) obj).fling(i3, i16, i17, i18, i19, i26, i27, i28);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object obj, int i3, int i16, int i17, int i18, int i19) {
            ((Scroller) obj).startScroll(i3, i16, i17, i18, i19);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyHorizontalEdgeReached(Object obj, int i3, int i16, int i17) {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyVerticalEdgeReached(Object obj, int i3, int i16, int i17) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ScrollerCompatImplGingerbread implements ScrollerCompatImpl {
        ScrollerCompatImplGingerbread() {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void abortAnimation(Object obj) {
            ScrollerCompatGingerbread.abortAnimation(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean computeScrollOffset(Object obj) {
            return ScrollerCompatGingerbread.computeScrollOffset(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public Object createScroller(Context context, Interpolator interpolator) {
            return ScrollerCompatGingerbread.createScroller(context, interpolator);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            ScrollerCompatGingerbread.fling(obj, i3, i16, i17, i18, i19, i26, i27, i28);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(Object obj) {
            return 0.0f;
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrX(Object obj) {
            return ScrollerCompatGingerbread.getCurrX(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrY(Object obj) {
            return ScrollerCompatGingerbread.getCurrY(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalX(Object obj) {
            return ScrollerCompatGingerbread.getFinalX(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalY(Object obj) {
            return ScrollerCompatGingerbread.getFinalY(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isFinished(Object obj) {
            return ScrollerCompatGingerbread.isFinished(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isOverScrolled(Object obj) {
            return ScrollerCompatGingerbread.isOverScrolled(obj);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyHorizontalEdgeReached(Object obj, int i3, int i16, int i17) {
            ScrollerCompatGingerbread.notifyHorizontalEdgeReached(obj, i3, i16, i17);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyVerticalEdgeReached(Object obj, int i3, int i16, int i17) {
            ScrollerCompatGingerbread.notifyVerticalEdgeReached(obj, i3, i16, i17);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object obj, int i3, int i16, int i17, int i18) {
            ScrollerCompatGingerbread.startScroll(obj, i3, i16, i17, i18);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object obj, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
            ScrollerCompatGingerbread.fling(obj, i3, i16, i17, i18, i19, i26, i27, i28, i29, i36);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object obj, int i3, int i16, int i17, int i18, int i19) {
            ScrollerCompatGingerbread.startScroll(obj, i3, i16, i17, i18, i19);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread {
        ScrollerCompatImplIcs() {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImplGingerbread, android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(Object obj) {
            return ScrollerCompatIcs.getCurrVelocity(obj);
        }
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        this(Build.VERSION.SDK_INT, context, interpolator);
    }

    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    public void abortAnimation() {
        this.mImpl.abortAnimation(this.mScroller);
    }

    public boolean computeScrollOffset() {
        return this.mImpl.computeScrollOffset(this.mScroller);
    }

    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.mImpl.fling(this.mScroller, i3, i16, i17, i18, i19, i26, i27, i28);
    }

    public float getCurrVelocity() {
        return this.mImpl.getCurrVelocity(this.mScroller);
    }

    public int getCurrX() {
        return this.mImpl.getCurrX(this.mScroller);
    }

    public int getCurrY() {
        return this.mImpl.getCurrY(this.mScroller);
    }

    public int getFinalX() {
        return this.mImpl.getFinalX(this.mScroller);
    }

    public int getFinalY() {
        return this.mImpl.getFinalY(this.mScroller);
    }

    public boolean isFinished() {
        return this.mImpl.isFinished(this.mScroller);
    }

    public boolean isOverScrolled() {
        return this.mImpl.isOverScrolled(this.mScroller);
    }

    public void notifyHorizontalEdgeReached(int i3, int i16, int i17) {
        this.mImpl.notifyHorizontalEdgeReached(this.mScroller, i3, i16, i17);
    }

    public void notifyVerticalEdgeReached(int i3, int i16, int i17) {
        this.mImpl.notifyVerticalEdgeReached(this.mScroller, i3, i16, i17);
    }

    public void startScroll(int i3, int i16, int i17, int i18) {
        this.mImpl.startScroll(this.mScroller, i3, i16, i17, i18);
    }

    ScrollerCompat(int i3, Context context, Interpolator interpolator) {
        if (i3 >= 14) {
            this.mImpl = new ScrollerCompatImplIcs();
        } else if (i3 >= 9) {
            this.mImpl = new ScrollerCompatImplGingerbread();
        } else {
            this.mImpl = new ScrollerCompatImplBase();
        }
        this.mScroller = this.mImpl.createScroller(context, interpolator);
    }

    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        this.mImpl.fling(this.mScroller, i3, i16, i17, i18, i19, i26, i27, i28, i29, i36);
    }

    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        this.mImpl.startScroll(this.mScroller, i3, i16, i17, i18, i19);
    }
}
