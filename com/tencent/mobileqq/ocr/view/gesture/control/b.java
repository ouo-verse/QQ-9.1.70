package com.tencent.mobileqq.ocr.view.gesture.control;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface b {
    void a(Matrix matrix);

    void b(MotionEvent motionEvent);

    boolean onDoubleTap(MotionEvent motionEvent);

    void onDown(MotionEvent motionEvent);

    boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17);

    void onLongPress(MotionEvent motionEvent);

    boolean onScale(ScaleGestureDetector scaleGestureDetector);

    boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

    void onScaleEnd(ScaleGestureDetector scaleGestureDetector);

    boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17);

    boolean onSingleTapConfirmed(MotionEvent motionEvent);

    boolean onSingleTapUp(MotionEvent motionEvent);
}
