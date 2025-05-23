package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MotionEventCompat {
    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_GENERIC_1 = 32;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 47;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SIZE = 3;
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    static final MotionEventVersionImpl IMPL = new HoneycombMr1MotionEventVersionImpl();

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BaseMotionEventVersionImpl implements MotionEventVersionImpl {
        BaseMotionEventVersionImpl() {
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int findPointerIndex(MotionEvent motionEvent, int i3) {
            if (i3 == 0) {
                return 0;
            }
            return -1;
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(MotionEvent motionEvent, int i3) {
            return 0.0f;
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerCount(MotionEvent motionEvent) {
            return 1;
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerId(MotionEvent motionEvent, int i3) {
            if (i3 == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getSource(MotionEvent motionEvent) {
            return 0;
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getX(MotionEvent motionEvent, int i3) {
            if (i3 == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getY(MotionEvent motionEvent, int i3) {
            if (i3 == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(MotionEvent motionEvent, int i3, int i16) {
            return 0.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class EclairMotionEventVersionImpl extends BaseMotionEventVersionImpl {
        EclairMotionEventVersionImpl() {
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int findPointerIndex(MotionEvent motionEvent, int i3) {
            return MotionEventCompatEclair.findPointerIndex(motionEvent, i3);
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerCount(MotionEvent motionEvent) {
            return MotionEventCompatEclair.getPointerCount(motionEvent);
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerId(MotionEvent motionEvent, int i3) {
            return MotionEventCompatEclair.getPointerId(motionEvent, i3);
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getX(MotionEvent motionEvent, int i3) {
            return MotionEventCompatEclair.getX(motionEvent, i3);
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getY(MotionEvent motionEvent, int i3) {
            return MotionEventCompatEclair.getY(motionEvent, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class GingerbreadMotionEventVersionImpl extends EclairMotionEventVersionImpl {
        GingerbreadMotionEventVersionImpl() {
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getSource(MotionEvent motionEvent) {
            return MotionEventCompatGingerbread.getSource(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class HoneycombMr1MotionEventVersionImpl extends GingerbreadMotionEventVersionImpl {
        HoneycombMr1MotionEventVersionImpl() {
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(MotionEvent motionEvent, int i3) {
            return MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, i3);
        }

        @Override // android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(MotionEvent motionEvent, int i3, int i16) {
            return MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface MotionEventVersionImpl {
        int findPointerIndex(MotionEvent motionEvent, int i3);

        float getAxisValue(MotionEvent motionEvent, int i3);

        float getAxisValue(MotionEvent motionEvent, int i3, int i16);

        int getPointerCount(MotionEvent motionEvent);

        int getPointerId(MotionEvent motionEvent, int i3);

        int getSource(MotionEvent motionEvent);

        float getX(MotionEvent motionEvent, int i3);

        float getY(MotionEvent motionEvent, int i3);
    }

    MotionEventCompat() {
    }

    public static int findPointerIndex(MotionEvent motionEvent, int i3) {
        return IMPL.findPointerIndex(motionEvent, i3);
    }

    public static int getActionIndex(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int getActionMasked(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static float getAxisValue(MotionEvent motionEvent, int i3) {
        return IMPL.getAxisValue(motionEvent, i3);
    }

    public static int getPointerCount(MotionEvent motionEvent) {
        return IMPL.getPointerCount(motionEvent);
    }

    public static int getPointerId(MotionEvent motionEvent, int i3) {
        return IMPL.getPointerId(motionEvent, i3);
    }

    public static int getSource(MotionEvent motionEvent) {
        return IMPL.getSource(motionEvent);
    }

    public static float getX(MotionEvent motionEvent, int i3) {
        return IMPL.getX(motionEvent, i3);
    }

    public static float getY(MotionEvent motionEvent, int i3) {
        return IMPL.getY(motionEvent, i3);
    }

    public static float getAxisValue(MotionEvent motionEvent, int i3, int i16) {
        return IMPL.getAxisValue(motionEvent, i3, i16);
    }
}
