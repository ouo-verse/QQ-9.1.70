package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDMotionEvent extends HIDInputEvent {
    public static final int AXIS_KEYB_X = 7;
    public static final int AXIS_KEYB_Y = 8;
    public static final int AXIS_KEYX_X = 9;
    public static final int AXIS_KEYX_Y = 10;
    public static final int AXIS_KEYY_X = 11;
    public static final int AXIS_KEYY_Y = 12;
    public static final int AXIS_KEY_X = 5;
    public static final int AXIS_KEY_Y = 6;
    public static final int AXIS_NONE = 0;
    public static final int AXIS_RX = 3;
    public static final int AXIS_RY = 4;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 13;
    private static final float CENTER_AXIS_FLOAT = 128.0f;
    private static final int CENTER_AXIS_INT = 128;
    public static final int MAX_AXES = 16;
    public static final int MOTION_TYPE_JOYSTICKL = 1;
    public static final int MOTION_TYPE_JOYSTICKR = 2;
    public static final int MOTION_TYPE_JOYSTICK_KEY = 3;
    public static final int MOTION_TYPE_JOYSTICK_KEYB = 4;
    public static final int MOTION_TYPE_JOYSTICK_KEYX = 5;
    public static final int MOTION_TYPE_JOYSTICK_KEYY = 6;
    public static final int MOTION_TYPE_TOUCHMAP = 10;
    public static final int MOTION_TYPE_TOUCHMOUSE = 9;
    public static final int MOTION_TYPE_TOUCHPAD = 7;
    public static final int MOTION_TYPE_TOUCHSCREEN = 8;
    private static final float mFlat = 0.12764707f;
    private float[] mArrayAxis;
    private int mId;
    private int mKeyCode;
    private int mPressure;
    private int mX;
    private int mY;

    HIDMotionEvent(int i3) {
        this.mEventType = i3;
        this.mId = 0;
        this.mX = -1;
        this.mY = -1;
        this.mPressure = 0;
        this.mArrayAxis = new float[16];
        this.mKeyCode = -1;
    }

    public final float getAxisValue(int i3) {
        if (i3 >= 0 && i3 < 16) {
            return this.mArrayAxis[i3];
        }
        return 0.0f;
    }

    public int getAxisXIndex() {
        int i3 = this.mId;
        if (3 == i3) {
            return 5;
        }
        if (4 == i3) {
            return 7;
        }
        if (5 == i3) {
            return 9;
        }
        if (6 == i3) {
            return 11;
        }
        if (1 == i3) {
            return 1;
        }
        if (2 != i3 && 10 != i3) {
            return 1;
        }
        return 13;
    }

    public int getAxisYIndex() {
        int i3 = this.mId;
        if (3 == i3) {
            return 6;
        }
        if (4 == i3) {
            return 8;
        }
        if (5 == i3) {
            return 10;
        }
        if (6 == i3) {
            return 12;
        }
        if (1 == i3) {
            return 2;
        }
        if (2 != i3 && 10 != i3) {
            return 2;
        }
        return 14;
    }

    public final float getFlat(int i3) {
        return mFlat;
    }

    public final int getHistorySize() {
        return 0;
    }

    public int getId() {
        return this.mId;
    }

    public int getKeyCode() {
        return this.mKeyCode;
    }

    public int getPressure() {
        return this.mPressure;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public void setAxisValue(int i3, int i16) {
        if (i3 >= 0 && i3 < 16) {
            this.mArrayAxis[i3] = (i16 - 128) / 128.0f;
        }
    }

    public void setId(int i3) {
        this.mId = i3;
    }

    public void setKeyCode(int i3) {
        this.mKeyCode = i3;
    }

    public void setPressure(int i3) {
        this.mPressure = i3;
    }

    public void setX(int i3) {
        this.mX = i3;
    }

    public void setY(int i3) {
        this.mY = i3;
    }
}
