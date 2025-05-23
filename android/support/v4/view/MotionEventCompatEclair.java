package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes.dex */
class MotionEventCompatEclair {
    MotionEventCompatEclair() {
    }

    public static int findPointerIndex(MotionEvent motionEvent, int i3) {
        return motionEvent.findPointerIndex(i3);
    }

    public static int getPointerCount(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int getPointerId(MotionEvent motionEvent, int i3) {
        return motionEvent.getPointerId(i3);
    }

    public static float getX(MotionEvent motionEvent, int i3) {
        return motionEvent.getX(i3);
    }

    public static float getY(MotionEvent motionEvent, int i3) {
        return motionEvent.getY(i3);
    }
}
