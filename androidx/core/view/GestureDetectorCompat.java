package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z16);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void init(Context context) {
            if (context != null) {
                if (this.mListener != null) {
                    this.mIsLongpressEnabled = true;
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                    int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                    int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                    this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                    this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                    this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                    this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
                    return;
                }
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            throw new IllegalArgumentException("Context must not be null");
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT) {
                return false;
            }
            int x16 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y16 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x16 * x16) + (y16 * y16) >= this.mDoubleTapSlopSquare) {
                return false;
            }
            return true;
        }

        void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x0204  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x021b  */
        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z16;
            int i3;
            boolean z17;
            MotionEvent motionEvent2;
            MotionEvent motionEvent3;
            boolean onFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int i16 = action & 255;
            if (i16 == 6) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = motionEvent.getActionIndex();
            } else {
                i3 = -1;
            }
            int pointerCount = motionEvent.getPointerCount();
            float f16 = 0.0f;
            float f17 = 0.0f;
            for (int i17 = 0; i17 < pointerCount; i17++) {
                if (i3 != i17) {
                    f16 += motionEvent.getX(i17);
                    f17 += motionEvent.getY(i17);
                }
            }
            float f18 = z16 ? pointerCount - 1 : pointerCount;
            float f19 = f16 / f18;
            float f26 = f17 / f18;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 5) {
                                if (i16 != 6) {
                                    return false;
                                }
                                this.mLastFocusX = f19;
                                this.mDownFocusX = f19;
                                this.mLastFocusY = f26;
                                this.mDownFocusY = f26;
                                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                float xVelocity = this.mVelocityTracker.getXVelocity(pointerId);
                                float yVelocity = this.mVelocityTracker.getYVelocity(pointerId);
                                for (int i18 = 0; i18 < pointerCount; i18++) {
                                    if (i18 != actionIndex) {
                                        int pointerId2 = motionEvent.getPointerId(i18);
                                        if ((this.mVelocityTracker.getXVelocity(pointerId2) * xVelocity) + (this.mVelocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                                            this.mVelocityTracker.clear();
                                            return false;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.mLastFocusX = f19;
                            this.mDownFocusX = f19;
                            this.mLastFocusY = f26;
                            this.mDownFocusY = f26;
                            cancelTaps();
                            return false;
                        }
                        cancel();
                        return false;
                    }
                    if (this.mInLongPress) {
                        return false;
                    }
                    float f27 = this.mLastFocusX - f19;
                    float f28 = this.mLastFocusY - f26;
                    if (this.mIsDoubleTapping) {
                        return false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                    }
                    if (this.mAlwaysInTapRegion) {
                        int i19 = (int) (f19 - this.mDownFocusX);
                        int i26 = (int) (f26 - this.mDownFocusY);
                        int i27 = (i19 * i19) + (i26 * i26);
                        if (i27 > this.mTouchSlopSquare) {
                            onFling = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f27, f28);
                            this.mLastFocusX = f19;
                            this.mLastFocusY = f26;
                            this.mAlwaysInTapRegion = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            onFling = false;
                        }
                        if (i27 > this.mTouchSlopSquare) {
                            this.mAlwaysInBiggerTapRegion = false;
                        }
                    } else {
                        if (Math.abs(f27) < 1.0f && Math.abs(f28) < 1.0f) {
                            return false;
                        }
                        boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f27, f28);
                        this.mLastFocusX = f19;
                        this.mLastFocusY = f26;
                        return onScroll;
                    }
                } else {
                    this.mStillDown = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        onFling = this.mDoubleTapListener.onDoubleTapEvent(motionEvent) | false;
                    } else {
                        if (this.mInLongPress) {
                            this.mHandler.removeMessages(3);
                            this.mInLongPress = false;
                        } else if (this.mAlwaysInTapRegion) {
                            boolean onSingleTapUp = this.mListener.onSingleTapUp(motionEvent);
                            if (this.mDeferConfirmSingleTap && (onDoubleTapListener = this.mDoubleTapListener) != null) {
                                onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            }
                            onFling = onSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            int pointerId3 = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                            float yVelocity2 = velocityTracker.getYVelocity(pointerId3);
                            float xVelocity2 = velocityTracker.getXVelocity(pointerId3);
                            if (Math.abs(yVelocity2) > this.mMinimumFlingVelocity || Math.abs(xVelocity2) > this.mMinimumFlingVelocity) {
                                onFling = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity2, yVelocity2);
                            }
                        }
                        onFling = false;
                    }
                    MotionEvent motionEvent4 = this.mPreviousUpEvent;
                    if (motionEvent4 != null) {
                        motionEvent4.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                }
                return onFling;
            }
            if (this.mDoubleTapListener != null) {
                boolean hasMessages = this.mHandler.hasMessages(3);
                if (hasMessages) {
                    this.mHandler.removeMessages(3);
                }
                MotionEvent motionEvent5 = this.mCurrentDownEvent;
                if (motionEvent5 != null && (motionEvent3 = this.mPreviousUpEvent) != null && hasMessages && isConsideredDoubleTap(motionEvent5, motionEvent3, motionEvent)) {
                    this.mIsDoubleTapping = true;
                    z17 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                    this.mLastFocusX = f19;
                    this.mDownFocusX = f19;
                    this.mLastFocusY = f26;
                    this.mDownFocusY = f26;
                    motionEvent2 = this.mCurrentDownEvent;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    this.mAlwaysInTapRegion = true;
                    this.mAlwaysInBiggerTapRegion = true;
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    this.mDeferConfirmSingleTap = false;
                    if (this.mIsLongpressEnabled) {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + ViewConfiguration.getLongPressTimeout());
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                    return z17 | this.mListener.onDown(motionEvent);
                }
                this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
            }
            z17 = false;
            this.mLastFocusX = f19;
            this.mDownFocusX = f19;
            this.mLastFocusY = f26;
            this.mDownFocusY = f26;
            motionEvent2 = this.mCurrentDownEvent;
            if (motionEvent2 != null) {
            }
            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mIsLongpressEnabled) {
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
            return z17 | this.mListener.onDown(motionEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z16) {
            this.mIsLongpressEnabled = z16;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            GestureDetectorCompatImplBase gestureDetectorCompatImplBase = GestureDetectorCompatImplBase.this;
                            GestureDetector.OnDoubleTapListener onDoubleTapListener = gestureDetectorCompatImplBase.mDoubleTapListener;
                            if (onDoubleTapListener != null) {
                                if (!gestureDetectorCompatImplBase.mStillDown) {
                                    onDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompatImplBase.mCurrentDownEvent);
                                    return;
                                } else {
                                    gestureDetectorCompatImplBase.mDeferConfirmSingleTap = true;
                                    return;
                                }
                            }
                            return;
                        }
                        throw new RuntimeException("Unknown message " + message);
                    }
                    GestureDetectorCompatImplBase.this.dispatchLongPress();
                    return;
                }
                GestureDetectorCompatImplBase gestureDetectorCompatImplBase2 = GestureDetectorCompatImplBase.this;
                gestureDetectorCompatImplBase2.mListener.onShowPress(gestureDetectorCompatImplBase2.mCurrentDownEvent);
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z16) {
            this.mDetector.setIsLongpressEnabled(z16);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z16) {
        this.mImpl.setIsLongpressEnabled(z16);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
    }
}
