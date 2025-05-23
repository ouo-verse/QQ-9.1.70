package com.tencent.widget;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ScaleGestureDetector {
    static IPatchRedirector $redirector_ = null;
    private static final float PRESSURE_THRESHOLD = 0.67f;
    private static final String TAG = "ScaleGestureDetector";
    private boolean mActive0MostRecent;
    private int mActiveId0;
    private int mActiveId1;
    private final Context mContext;
    private MotionEvent mCurrEvent;
    private float mCurrFingerDiffX;
    private float mCurrFingerDiffY;
    private float mCurrLen;
    private float mCurrPressure;
    private float mFocusX;
    private float mFocusY;
    private boolean mGestureInProgress;
    private boolean mInvalidGesture;
    private final OnScaleGestureListener mListener;
    private MotionEvent mPrevEvent;
    private float mPrevFingerDiffX;
    private float mPrevFingerDiffY;
    private float mPrevLen;
    private float mPrevPressure;
    private float mScaleFactor;
    private long mTimeDelta;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);

        boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

        void onScaleEnd(ScaleGestureDetector scaleGestureDetector);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        static IPatchRedirector $redirector_;

        public SimpleOnScaleGestureListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) scaleGestureDetector)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) scaleGestureDetector)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) scaleGestureDetector);
            }
        }
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) onScaleGestureListener);
        } else {
            this.mContext = context;
            this.mListener = onScaleGestureListener;
        }
    }

    private int findNewActiveIndex(MotionEvent motionEvent, int i3, int i16) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        for (int i17 = 0; i17 < pointerCount; i17++) {
            if (i17 != i16 && i17 != findPointerIndex) {
                return i17;
            }
        }
        return -1;
    }

    private int getActionIndex(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    private void reset() {
        MotionEvent motionEvent = this.mPrevEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.mPrevEvent = null;
        }
        MotionEvent motionEvent2 = this.mCurrEvent;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.mCurrEvent = null;
        }
        this.mGestureInProgress = false;
        this.mActiveId0 = -1;
        this.mActiveId1 = -1;
        this.mInvalidGesture = false;
    }

    private void setContext(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.mCurrEvent;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.mCurrEvent = MotionEvent.obtain(motionEvent);
        this.mCurrLen = -1.0f;
        this.mPrevLen = -1.0f;
        this.mScaleFactor = -1.0f;
        MotionEvent motionEvent3 = this.mPrevEvent;
        int findPointerIndex = motionEvent3.findPointerIndex(this.mActiveId0);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.mActiveId1);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.mActiveId0);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.mActiveId1);
        if (findPointerIndex >= 0 && findPointerIndex2 >= 0 && findPointerIndex3 >= 0 && findPointerIndex4 >= 0) {
            float x16 = motionEvent3.getX(findPointerIndex);
            float y16 = motionEvent3.getY(findPointerIndex);
            float x17 = motionEvent3.getX(findPointerIndex2);
            float y17 = motionEvent3.getY(findPointerIndex2);
            float x18 = motionEvent.getX(findPointerIndex3);
            float y18 = motionEvent.getY(findPointerIndex3);
            float x19 = motionEvent.getX(findPointerIndex4) - x18;
            float y19 = motionEvent.getY(findPointerIndex4) - y18;
            this.mPrevFingerDiffX = x17 - x16;
            this.mPrevFingerDiffY = y17 - y16;
            this.mCurrFingerDiffX = x19;
            this.mCurrFingerDiffY = y19;
            this.mFocusX = x18 + (x19 * 0.5f);
            this.mFocusY = y18 + (y19 * 0.5f);
            this.mTimeDelta = motionEvent.getEventTime() - motionEvent3.getEventTime();
            this.mCurrPressure = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
            this.mPrevPressure = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
            return;
        }
        this.mInvalidGesture = true;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "Invalid MotionEvent stream detected.", new Throwable());
        }
        if (this.mGestureInProgress) {
            this.mListener.onScaleEnd(this);
        }
    }

    public float getCurrentSpan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        if (this.mCurrLen == -1.0f) {
            float f16 = this.mCurrFingerDiffX;
            float f17 = this.mCurrFingerDiffY;
            this.mCurrLen = (float) Math.sqrt((f16 * f16) + (f17 * f17));
        }
        return this.mCurrLen;
    }

    public float getCurrentSpanX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.mCurrFingerDiffX;
    }

    public float getCurrentSpanY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.mCurrFingerDiffY;
    }

    public long getEventTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.mCurrEvent.getEventTime();
    }

    public float getFocusX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.mFocusX;
    }

    public float getFocusY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.mFocusY;
    }

    public float getPreviousSpan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        if (this.mPrevLen == -1.0f) {
            float f16 = this.mPrevFingerDiffX;
            float f17 = this.mPrevFingerDiffY;
            this.mPrevLen = (float) Math.sqrt((f16 * f16) + (f17 * f17));
        }
        return this.mPrevLen;
    }

    public float getPreviousSpanX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.mPrevFingerDiffX;
    }

    public float getPreviousSpanY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        return this.mPrevFingerDiffY;
    }

    public float getScaleFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        if (this.mScaleFactor == -1.0f) {
            this.mScaleFactor = getCurrentSpan() / getPreviousSpan();
        }
        return this.mScaleFactor;
    }

    public long getTimeDelta() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.mTimeDelta;
    }

    public boolean isInProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mGestureInProgress;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            reset();
        }
        boolean z16 = false;
        if (this.mInvalidGesture) {
            return false;
        }
        if (!this.mGestureInProgress) {
            if (action != 0) {
                if (action != 1) {
                    if (action == 5) {
                        MotionEvent motionEvent2 = this.mPrevEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.mPrevEvent = MotionEvent.obtain(motionEvent);
                        this.mTimeDelta = 0L;
                        int actionIndex = getActionIndex(motionEvent);
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActiveId0);
                        int pointerId = motionEvent.getPointerId(actionIndex);
                        this.mActiveId1 = pointerId;
                        if (findPointerIndex < 0 || findPointerIndex == actionIndex) {
                            this.mActiveId0 = motionEvent.getPointerId(findNewActiveIndex(motionEvent, pointerId, -1));
                        }
                        this.mActive0MostRecent = false;
                        setContext(motionEvent);
                        this.mGestureInProgress = this.mListener.onScaleBegin(this);
                    }
                } else {
                    reset();
                }
            } else {
                this.mActiveId0 = motionEvent.getPointerId(0);
                this.mActive0MostRecent = true;
            }
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action != 5) {
                        if (action == 6) {
                            int pointerCount = motionEvent.getPointerCount();
                            int actionIndex2 = getActionIndex(motionEvent);
                            int pointerId2 = motionEvent.getPointerId(actionIndex2);
                            if (pointerCount > 2) {
                                int i3 = this.mActiveId0;
                                if (pointerId2 == i3) {
                                    int findNewActiveIndex = findNewActiveIndex(motionEvent, this.mActiveId1, actionIndex2);
                                    if (findNewActiveIndex >= 0) {
                                        this.mListener.onScaleEnd(this);
                                        this.mActiveId0 = motionEvent.getPointerId(findNewActiveIndex);
                                        this.mActive0MostRecent = true;
                                        this.mPrevEvent = MotionEvent.obtain(motionEvent);
                                        setContext(motionEvent);
                                        this.mGestureInProgress = this.mListener.onScaleBegin(this);
                                        this.mPrevEvent.recycle();
                                        this.mPrevEvent = MotionEvent.obtain(motionEvent);
                                        setContext(motionEvent);
                                    }
                                    z16 = true;
                                    this.mPrevEvent.recycle();
                                    this.mPrevEvent = MotionEvent.obtain(motionEvent);
                                    setContext(motionEvent);
                                } else {
                                    if (pointerId2 == this.mActiveId1) {
                                        int findNewActiveIndex2 = findNewActiveIndex(motionEvent, i3, actionIndex2);
                                        if (findNewActiveIndex2 >= 0) {
                                            this.mListener.onScaleEnd(this);
                                            this.mActiveId1 = motionEvent.getPointerId(findNewActiveIndex2);
                                            this.mActive0MostRecent = false;
                                            this.mPrevEvent = MotionEvent.obtain(motionEvent);
                                            setContext(motionEvent);
                                            this.mGestureInProgress = this.mListener.onScaleBegin(this);
                                        }
                                        z16 = true;
                                    }
                                    this.mPrevEvent.recycle();
                                    this.mPrevEvent = MotionEvent.obtain(motionEvent);
                                    setContext(motionEvent);
                                }
                            } else {
                                z16 = true;
                            }
                            if (z16) {
                                setContext(motionEvent);
                                int i16 = this.mActiveId0;
                                if (pointerId2 == i16) {
                                    i16 = this.mActiveId1;
                                }
                                int findPointerIndex2 = motionEvent.findPointerIndex(i16);
                                this.mFocusX = motionEvent.getX(findPointerIndex2);
                                this.mFocusY = motionEvent.getY(findPointerIndex2);
                                this.mListener.onScaleEnd(this);
                                reset();
                                this.mActiveId0 = i16;
                                this.mActive0MostRecent = true;
                            }
                        }
                    } else {
                        this.mListener.onScaleEnd(this);
                        int i17 = this.mActiveId0;
                        int i18 = this.mActiveId1;
                        reset();
                        this.mPrevEvent = MotionEvent.obtain(motionEvent);
                        if (!this.mActive0MostRecent) {
                            i17 = i18;
                        }
                        this.mActiveId0 = i17;
                        this.mActiveId1 = motionEvent.getPointerId(getActionIndex(motionEvent));
                        this.mActive0MostRecent = false;
                        if (motionEvent.findPointerIndex(this.mActiveId0) < 0 || this.mActiveId0 == this.mActiveId1) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "Got " + motionEvent.toString() + " with bad state while a gesture was in progress. Did you forget to pass an event to ScaleGestureDetector#onTouchEvent?");
                            }
                            this.mActiveId0 = motionEvent.getPointerId(findNewActiveIndex(motionEvent, this.mActiveId1, -1));
                        }
                        setContext(motionEvent);
                        this.mGestureInProgress = this.mListener.onScaleBegin(this);
                    }
                } else {
                    this.mListener.onScaleEnd(this);
                    reset();
                }
            } else {
                setContext(motionEvent);
                if (this.mCurrPressure / this.mPrevPressure > PRESSURE_THRESHOLD && this.mListener.onScale(this)) {
                    this.mPrevEvent.recycle();
                    this.mPrevEvent = MotionEvent.obtain(motionEvent);
                }
            }
        } else {
            reset();
        }
        return true;
    }
}
