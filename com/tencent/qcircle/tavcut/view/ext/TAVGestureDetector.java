package com.tencent.qcircle.tavcut.view.ext;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.tencent.qcircle.tavcut.view.TAVCutImageViewKt;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TAVGestureDetector {
    private static final int INVALID_POINTER_ID = -1;
    private boolean isRotating;
    private boolean mIsDragging;
    private float mLastTouchX;
    private float mLastTouchY;
    private OnGestureListener mListener;
    private final float mMinimumVelocity;
    private final ScaleGestureDetector mScaleDetector;
    private final float mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;
    private PointF center = null;
    private float maxDis = 0.0f;
    private float fX = 0.0f;
    private float fY = 0.0f;
    private float sX = 0.0f;
    private float sY = 0.0f;
    private float focalX = 0.0f;
    private float focalY = 0.0f;
    private int ptrID1 = -1;
    private int ptrID2 = -1;
    private float angle = 0.0f;
    private boolean firstTouch = false;
    private boolean isZoomButtonOperating = false;

    public TAVGestureDetector(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mListener = onGestureListener;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.tencent.qcircle.tavcut.view.ext.TAVGestureDetector.1
            private float lastFocusX;
            private float lastFocusY = 0.0f;

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                    if (scaleFactor >= 0.0f) {
                        TAVGestureDetector.this.mListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.lastFocusX, scaleGestureDetector.getFocusY() - this.lastFocusY);
                        this.lastFocusX = scaleGestureDetector.getFocusX();
                        this.lastFocusY = scaleGestureDetector.getFocusY();
                        return true;
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                this.lastFocusX = scaleGestureDetector.getFocusX();
                this.lastFocusY = scaleGestureDetector.getFocusY();
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    private float angleBetweenLines(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29) {
        return findAngleDelta(Math.toDegrees((float) Math.atan2(f27 - f29, f26 - f28)), Math.toDegrees((float) Math.atan2(f17 - f19, f16 - f18)));
    }

    private float findAngleDelta(double d16, double d17) {
        float f16 = ((float) (d16 % 360.0d)) - ((float) (d17 % 360.0d));
        if (f16 < -180.0f) {
            return f16 + 360.0f;
        }
        if (f16 > 180.0f) {
            return f16 - 360.0f;
        }
        return f16;
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

    private boolean processTouchEvent(MotionEvent motionEvent, boolean z16) {
        float f16;
        boolean z17;
        float f17;
        float f18;
        float f19;
        boolean z18;
        boolean z19;
        int i3;
        int action = motionEvent.getAction() & 255;
        int i16 = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                this.ptrID2 = -1;
                                if (!this.isZoomButtonOperating) {
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
                            }
                        } else if (!this.isZoomButtonOperating) {
                            this.fX = motionEvent.getX();
                            float y16 = motionEvent.getY();
                            this.fY = y16;
                            this.focalX = (this.fX + this.sX) / 2.0f;
                            this.focalY = (y16 + this.sY) / 2.0f;
                            this.ptrID2 = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.angle = 0.0f;
                        }
                    } else {
                        this.ptrID1 = -1;
                        this.ptrID2 = -1;
                        this.mActivePointerId = -1;
                        this.isZoomButtonOperating = false;
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.mVelocityTracker = null;
                        }
                    }
                } else {
                    float activeX = getActiveX(motionEvent);
                    float activeY = getActiveY(motionEvent);
                    float f26 = activeX - this.mLastTouchX;
                    float f27 = activeY - this.mLastTouchY;
                    if (!this.mIsDragging) {
                        if (Math.sqrt((f26 * f26) + (f27 * f27)) >= this.mTouchSlop) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        this.mIsDragging = z19;
                    }
                    int i17 = this.ptrID1;
                    if (i17 != -1 && this.ptrID2 != -1) {
                        float x16 = motionEvent.getX(motionEvent.findPointerIndex(i17));
                        float y17 = motionEvent.getY(motionEvent.findPointerIndex(this.ptrID1));
                        float x17 = motionEvent.getX(motionEvent.findPointerIndex(this.ptrID2));
                        float y18 = motionEvent.getY(motionEvent.findPointerIndex(this.ptrID2));
                        if (this.firstTouch) {
                            this.angle = 0.0f;
                            this.firstTouch = false;
                            this.isRotating = true;
                            f17 = y18;
                            f18 = x17;
                            f19 = y17;
                        } else {
                            f17 = y18;
                            f18 = x17;
                            f19 = y17;
                            float angleBetweenLines = angleBetweenLines(this.fX, this.fY, this.sX, this.sY, x17, y18, x16, y17);
                            this.angle = angleBetweenLines;
                            if (Float.compare(angleBetweenLines, 0.0f) != 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            this.isRotating = z18;
                        }
                        if (Math.abs(this.angle) <= 10.0f) {
                            this.mListener.onRotation(this.sX, this.sY, this.angle);
                        }
                        this.fX = f18;
                        this.fY = f17;
                        this.sX = x16;
                        this.sY = f19;
                    } else if (this.isZoomButtonOperating) {
                        if (this.firstTouch) {
                            this.angle = 0.0f;
                            this.firstTouch = false;
                            this.isRotating = true;
                            f16 = activeY;
                        } else {
                            PointF pointF = this.center;
                            float f28 = pointF.x;
                            float f29 = pointF.y;
                            f16 = activeY;
                            float angleBetweenLines2 = angleBetweenLines(f28, f29, this.mLastTouchX, this.mLastTouchY, f28, f29, activeX, activeY);
                            this.angle = angleBetweenLines2;
                            if (Float.compare(angleBetweenLines2, 0.0f) != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            this.isRotating = z17;
                            if (TAVCutImageViewKt.calcDistance(this.center, new PointF(activeX, f16)) >= this.maxDis * 0.25d) {
                                float calcDistance = TAVCutImageViewKt.calcDistance(this.center, new PointF(activeX, f16)) / TAVCutImageViewKt.calcDistance(this.center, new PointF(this.mLastTouchX, this.mLastTouchY));
                                OnGestureListener onGestureListener = this.mListener;
                                PointF pointF2 = this.center;
                                onGestureListener.onScale(calcDistance, pointF2.x, pointF2.y);
                            }
                            OnGestureListener onGestureListener2 = this.mListener;
                            PointF pointF3 = this.center;
                            onGestureListener2.onRotation(pointF3.x, pointF3.y, this.angle);
                        }
                        this.mLastTouchX = activeX;
                        this.mLastTouchY = f16;
                    } else if (this.mIsDragging) {
                        if (Math.abs(f26) < this.mTouchSlop * 5.0f && Math.abs(f27) < this.mTouchSlop * 5.0f) {
                            this.mListener.onDrag(f26, f27);
                        }
                        this.mLastTouchX = activeX;
                        this.mLastTouchY = activeY;
                        VelocityTracker velocityTracker2 = this.mVelocityTracker;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.ptrID1 = -1;
                this.mActivePointerId = -1;
                this.isZoomButtonOperating = false;
                if (this.mIsDragging && this.mVelocityTracker != null) {
                    this.mLastTouchX = getActiveX(motionEvent);
                    this.mLastTouchY = getActiveY(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.mMinimumVelocity) {
                        this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mVelocityTracker = null;
                }
            }
        } else {
            this.isZoomButtonOperating = z16;
            this.ptrID1 = motionEvent.getPointerId(0);
            this.sX = motionEvent.getX();
            this.sY = motionEvent.getY();
            this.angle = 0.0f;
            this.firstTouch = true;
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
        int i18 = this.mActivePointerId;
        if (i18 != -1) {
            i16 = i18;
        }
        this.mActivePointerIndex = motionEvent.findPointerIndex(i16);
        return true;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public boolean isRotating() {
        return this.isRotating;
    }

    public boolean isScaling() {
        return this.mScaleDetector.isInProgress();
    }

    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        try {
            this.mScaleDetector.onTouchEvent(motionEvent);
            return processTouchEvent(motionEvent, z16);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public void setCenter(PointF pointF, float f16) {
        this.center = pointF;
        this.maxDis = f16;
    }
}
