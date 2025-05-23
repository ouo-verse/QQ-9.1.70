package com.tencent.ams.fusion.widget.slideinteractive;

import android.gesture.Gesture;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ISlideGestureView {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnGestureListener {
        void onGesture(View view, MotionEvent motionEvent);

        void onGestureCancelled(View view, MotionEvent motionEvent);

        void onGestureEnded(View view, MotionEvent motionEvent);

        void onGestureStarted(View view, MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnGesturePerformedListener {
        void onGesturePerformed(View view, Gesture gesture);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnGesturingListener {
        void onGesturingEnded(View view);

        void onGesturingStarted(View view);
    }

    void addOnGestureListener(OnGestureListener onGestureListener);

    void addOnGesturePerformedListener(OnGesturePerformedListener onGesturePerformedListener);

    void addOnGesturingListener(OnGesturingListener onGesturingListener);

    void cancelGestureEvent(MotionEvent motionEvent);

    void clear(boolean z16);

    int getLeft();

    int getTop();

    boolean isGesturing();

    void removeAllOnGestureListeners();

    void removeAllOnGesturePerformedListeners();

    void removeAllOnGesturingListeners();

    void removeOnGestureListener(OnGestureListener onGestureListener);

    void removeOnGesturePerformedListener(OnGesturePerformedListener onGesturePerformedListener);

    void removeOnGesturingListener(OnGesturingListener onGesturingListener);

    void setDrawRect(Rect rect);

    void setEnabled(boolean z16);

    void setFadeOffset(long j3);

    void setGestureColor(@ColorInt int i3);

    void setGestureStrokeType(int i3);

    void setGestureStrokeWidth(float f16);

    void setGestureVisible(boolean z16);

    void setUncertainGestureColor(@ColorInt int i3);

    void stop();
}
