package com.tencent.richframework.widget.matrix;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class CustomGestureDetector {
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;
    private final ScaleGestureDetector mDetector;
    private boolean mIsDragging;
    private float mLastTouchX;
    private float mLastTouchY;
    private final float mMinimumVelocity;
    private OnGestureListener mOnGestureListener;
    private OnScaleBeginListener mOnScaleBeginListener;
    private OnScaleEndListener mOnScaleEndListener;
    private final float mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomGestureDetector(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mOnGestureListener = onGestureListener;
        this.mDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.tencent.richframework.widget.matrix.CustomGestureDetector.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                    if (scaleFactor >= 0.0f) {
                        CustomGestureDetector.this.mOnGestureListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                        return true;
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (CustomGestureDetector.this.mOnScaleBeginListener != null) {
                    CustomGestureDetector.this.mOnScaleBeginListener.onScaleBegin(scaleFactor);
                    return true;
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (CustomGestureDetector.this.mOnScaleEndListener != null) {
                    CustomGestureDetector.this.mOnScaleEndListener.onScaleEnd(scaleFactor);
                }
            }
        }, new Handler(Looper.getMainLooper()));
    }

    private float getActiveX(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float getActiveY(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean processTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        int action = motionEvent.getAction() & 255;
        int i16 = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            int pointerIndex = Util.getPointerIndex(motionEvent.getAction());
                            if (motionEvent.getPointerId(pointerIndex) == this.mActivePointerId) {
                                if (pointerIndex == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                this.mActivePointerId = motionEvent.getPointerId(i3);
                                this.mLastTouchX = motionEvent.getX(i3);
                                this.mLastTouchY = motionEvent.getY(i3);
                            }
                        }
                    } else {
                        this.mActivePointerId = -1;
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.mVelocityTracker = null;
                        }
                    }
                } else {
                    float activeX = getActiveX(motionEvent);
                    float activeY = getActiveY(motionEvent);
                    int pointerCount = motionEvent.getPointerCount();
                    float f16 = activeX - this.mLastTouchX;
                    float f17 = activeY - this.mLastTouchY;
                    if (!this.mIsDragging) {
                        if (Math.sqrt((f16 * f16) + (f17 * f17)) >= this.mTouchSlop) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.mIsDragging = z16;
                    }
                    if (pointerCount > 1) {
                        this.mIsDragging = false;
                    }
                    if (this.mIsDragging) {
                        this.mLastTouchX = activeX;
                        this.mLastTouchY = activeY;
                        VelocityTracker velocityTracker2 = this.mVelocityTracker;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.mActivePointerId = -1;
                if (this.mIsDragging && this.mVelocityTracker != null) {
                    this.mLastTouchX = getActiveX(motionEvent);
                    this.mLastTouchY = getActiveY(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.mMinimumVelocity) {
                        this.mOnGestureListener.onFling(this.mLastTouchX, this.mLastTouchY, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mVelocityTracker = null;
                }
            }
        } else {
            this.mActivePointerId = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.mVelocityTracker = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.mLastTouchX = getActiveX(motionEvent);
            this.mLastTouchY = getActiveY(motionEvent);
            this.mIsDragging = false;
        }
        int i17 = this.mActivePointerId;
        if (i17 != -1) {
            i16 = i17;
        }
        this.mActivePointerIndex = motionEvent.findPointerIndex(i16);
        return true;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public boolean isScaling() {
        return this.mDetector.isInProgress();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            boolean onTouchEvent = this.mDetector.onTouchEvent(motionEvent);
            boolean processTouchEvent = processTouchEvent(motionEvent);
            if (!onTouchEvent || !processTouchEvent) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setOnScaleBeginListener(OnScaleBeginListener onScaleBeginListener) {
        this.mOnScaleBeginListener = onScaleBeginListener;
    }

    public void setOnScaleEndListener(OnScaleEndListener onScaleEndListener) {
        this.mOnScaleEndListener = onScaleEndListener;
    }
}
