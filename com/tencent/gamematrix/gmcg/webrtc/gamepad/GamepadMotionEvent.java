package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.view.InputDevice;
import android.view.MotionEvent;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDMotionEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GamepadMotionEvent extends GamepadInputEvent {
    public static final int AXIS_HAT_X_INDEX = 6;
    public static final int AXIS_HAT_Y_INDEX = 7;
    public static final int AXIS_KEY_LENGTH = 2;
    public static final int AXIS_LT_INDEX = 4;
    public static final int AXIS_MAX_INDEX = 8;
    public static final int AXIS_RT_INDEX = 5;
    public static final int AXIS_RZ_INDEX = 3;
    public static final int AXIS_VALUE_LENGTH = 4;
    public static final int AXIS_X_INDEX = 0;
    public static final int AXIS_Y_INDEX = 1;
    public static final int AXIS_Z_INDEX = 2;
    public static final int KEY_VALUE_LENGTH = 6;
    public final int[] mAxisTypes;
    public final float[] mAxisValues;
    public int mCmdType;
    public int mDataLength;
    public int mDeviceId;
    public boolean mHasKeyEvent;
    private boolean mIsPressedDpadDown;
    private boolean mIsPressedDpadLeft;
    private boolean mIsPressedDpadRight;
    private boolean mIsPressedDpadUp;
    public GamepadKeyEvent mKeyEvent;
    public int mSource;
    public boolean mUseDpadKeyEvent;
    private boolean mAxisXChanged = false;
    private boolean mAxisYChanged = false;
    private boolean mAxisZChanged = false;
    private boolean mAxisRZChanged = false;
    private boolean mAxisLTChanged = false;
    private boolean mAxisRTChanged = false;
    private boolean mAxisHatXChanged = false;
    private boolean mAxisHatYChanged = false;
    final float mOrigin = 0.0f;
    final float mDefaultFlat = 0.0f;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface AxisType {
        public static final int ABS_BRAKE = 10;
        public static final int ABS_GAS = 9;
        public static final int ABS_HAT_X = 16;
        public static final int ABS_HAT_Y = 17;
        public static final int ABS_NONE = -1;
        public static final int ABS_RUDDER = 7;
        public static final int ABS_RX = 3;
        public static final int ABS_RY = 4;
        public static final int ABS_RZ = 5;
        public static final int ABS_THROTTLE = 6;
        public static final int ABS_WHEEL = 8;
        public static final int ABS_X = 0;
        public static final int ABS_Y = 1;
        public static final int ABS_Z = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamepadMotionEvent() {
        this.mInputEventType = 2;
        this.mAxisTypes = new int[8];
        this.mAxisValues = new float[8];
        this.mUseDpadKeyEvent = true;
        this.mKeyEvent = new GamepadKeyEvent();
        this.mHasKeyEvent = false;
        this.mIsPressedDpadLeft = false;
        this.mIsPressedDpadRight = false;
        this.mIsPressedDpadUp = false;
        this.mIsPressedDpadDown = false;
    }

    private void handleDpadKeyEvent(int i3, int i16, float f16, float f17) {
        if (this.mIsPressedDpadLeft) {
            this.mKeyEvent.msg(i3, i16, 1025, 21, 1);
            this.mIsPressedDpadLeft = false;
            return;
        }
        if (this.mIsPressedDpadRight) {
            this.mKeyEvent.msg(i3, i16, 1025, 22, 1);
            this.mIsPressedDpadRight = false;
            return;
        }
        if (this.mIsPressedDpadUp) {
            this.mKeyEvent.msg(i3, i16, 1025, 19, 1);
            this.mIsPressedDpadUp = false;
            return;
        }
        if (this.mIsPressedDpadDown) {
            this.mKeyEvent.msg(i3, i16, 1025, 20, 1);
            this.mIsPressedDpadDown = false;
            return;
        }
        if (f16 == -1.0f) {
            this.mKeyEvent.msg(i3, i16, 1025, 21, 0);
            this.mIsPressedDpadLeft = true;
            return;
        }
        if (f16 == 1.0f) {
            this.mKeyEvent.msg(i3, i16, 1025, 22, 0);
            this.mIsPressedDpadRight = true;
        } else if (f17 == -1.0f) {
            this.mKeyEvent.msg(i3, i16, 1025, 19, 0);
            this.mIsPressedDpadUp = true;
        } else if (f17 == 1.0f) {
            this.mKeyEvent.msg(i3, i16, 1025, 20, 0);
            this.mIsPressedDpadDown = true;
        } else {
            this.mHasKeyEvent = false;
        }
    }

    private void handleDpadMotionEvent(InputDevice inputDevice, float f16, float f17) {
        float f18;
        float f19;
        InputDevice.MotionRange motionRange = inputDevice.getMotionRange(15, this.mSource);
        if (motionRange != null) {
            f18 = motionRange.getFlat();
        } else {
            f18 = 0.0f;
        }
        if (Math.abs(f16) > f18) {
            this.mAxisHatXChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[6] = 16;
            this.mAxisValues[6] = f16;
        } else if (this.mAxisHatXChanged) {
            this.mAxisHatXChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[6] = 16;
            this.mAxisValues[6] = 0.0f;
        }
        InputDevice.MotionRange motionRange2 = inputDevice.getMotionRange(16, this.mSource);
        if (motionRange2 != null) {
            f19 = motionRange2.getFlat();
        } else {
            f19 = 0.0f;
        }
        if (Math.abs(f17) > f19) {
            this.mAxisHatYChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[7] = 17;
            this.mAxisValues[7] = f17;
            return;
        }
        if (this.mAxisHatYChanged) {
            this.mAxisHatYChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[7] = 17;
            this.mAxisValues[7] = 0.0f;
        }
    }

    public void processHidJoystickInput(HIDMotionEvent hIDMotionEvent, int i3, int i16) {
        this.mDeviceId = i16;
        this.mCmdType = i3;
        this.mSource = 16777232;
        int[] iArr = this.mAxisTypes;
        iArr[0] = -1;
        iArr[1] = -1;
        iArr[2] = -1;
        iArr[3] = -1;
        iArr[4] = -1;
        iArr[5] = -1;
        iArr[6] = -1;
        iArr[7] = -1;
        this.mDataLength = 0;
        float axisValue = hIDMotionEvent.getAxisValue(1);
        float axisValue2 = hIDMotionEvent.getAxisValue(2);
        float axisValue3 = hIDMotionEvent.getAxisValue(13);
        float axisValue4 = hIDMotionEvent.getAxisValue(14);
        if (Math.abs(axisValue) > hIDMotionEvent.getFlat(1)) {
            this.mAxisXChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[0] = 0;
            this.mAxisValues[0] = axisValue;
        } else if (this.mAxisXChanged) {
            this.mAxisXChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[0] = 0;
            this.mAxisValues[0] = 0.0f;
        }
        if (Math.abs(axisValue2) > hIDMotionEvent.getFlat(2)) {
            this.mAxisYChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[1] = 1;
            this.mAxisValues[1] = axisValue2;
        } else if (this.mAxisYChanged) {
            this.mAxisYChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[1] = 1;
            this.mAxisValues[1] = 0.0f;
        }
        if (Math.abs(axisValue3) > hIDMotionEvent.getFlat(13)) {
            this.mAxisZChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[2] = 2;
            this.mAxisValues[2] = axisValue3;
        } else if (this.mAxisZChanged) {
            this.mAxisZChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[2] = 2;
            this.mAxisValues[2] = 0.0f;
        }
        if (Math.abs(axisValue4) > hIDMotionEvent.getFlat(14)) {
            this.mAxisRZChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[3] = 5;
            this.mAxisValues[3] = axisValue4;
            return;
        }
        if (this.mAxisRZChanged) {
            this.mAxisRZChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[3] = 5;
            this.mAxisValues[3] = 0.0f;
        }
    }

    public void processJoystickInput(MotionEvent motionEvent, int i3, int i16) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        InputDevice device = motionEvent.getDevice();
        if (device == null) {
            CGLog.e("Gamepad MotionEvent device is null object");
            return;
        }
        this.mDeviceId = i16;
        this.mCmdType = i3;
        this.mSource = motionEvent.getSource();
        int[] iArr = this.mAxisTypes;
        iArr[0] = -1;
        iArr[1] = -1;
        iArr[2] = -1;
        iArr[3] = -1;
        iArr[4] = -1;
        iArr[5] = -1;
        iArr[6] = -1;
        iArr[7] = -1;
        this.mDataLength = 0;
        float axisValue = motionEvent.getAxisValue(0);
        float axisValue2 = motionEvent.getAxisValue(1);
        float axisValue3 = motionEvent.getAxisValue(11);
        float axisValue4 = motionEvent.getAxisValue(14);
        float axisValue5 = motionEvent.getAxisValue(23);
        float axisValue6 = motionEvent.getAxisValue(22);
        float axisValue7 = motionEvent.getAxisValue(15);
        float axisValue8 = motionEvent.getAxisValue(16);
        InputDevice.MotionRange motionRange = device.getMotionRange(0, this.mSource);
        if (motionRange != null) {
            f16 = motionRange.getFlat();
        } else {
            f16 = 0.0f;
        }
        if (Math.abs(axisValue) > f16) {
            this.mAxisXChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[0] = 0;
            this.mAxisValues[0] = axisValue;
        } else if (this.mAxisXChanged) {
            this.mAxisXChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[0] = 0;
            this.mAxisValues[0] = 0.0f;
        }
        InputDevice.MotionRange motionRange2 = device.getMotionRange(1, this.mSource);
        if (motionRange2 != null) {
            f17 = motionRange2.getFlat();
        } else {
            f17 = 0.0f;
        }
        if (Math.abs(axisValue2) > f17) {
            this.mAxisYChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[1] = 1;
            this.mAxisValues[1] = axisValue2;
        } else if (this.mAxisYChanged) {
            this.mAxisYChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[1] = 1;
            this.mAxisValues[1] = 0.0f;
        }
        InputDevice.MotionRange motionRange3 = device.getMotionRange(11, this.mSource);
        if (motionRange3 != null) {
            f18 = motionRange3.getFlat();
        } else {
            f18 = 0.0f;
        }
        if (Math.abs(axisValue3) > f18) {
            this.mAxisZChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[2] = 2;
            this.mAxisValues[2] = axisValue3;
        } else if (this.mAxisZChanged) {
            this.mAxisZChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[2] = 2;
            this.mAxisValues[2] = 0.0f;
        }
        InputDevice.MotionRange motionRange4 = device.getMotionRange(14, this.mSource);
        if (motionRange4 != null) {
            f19 = motionRange4.getFlat();
        } else {
            f19 = 0.0f;
        }
        if (Math.abs(axisValue4) > f19) {
            this.mAxisRZChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[3] = 5;
            this.mAxisValues[3] = axisValue4;
        } else if (this.mAxisRZChanged) {
            this.mAxisRZChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[3] = 5;
            this.mAxisValues[3] = 0.0f;
        }
        InputDevice.MotionRange motionRange5 = device.getMotionRange(17, this.mSource);
        if (motionRange5 != null) {
            f26 = motionRange5.getFlat();
        } else {
            f26 = 0.0f;
        }
        if (Math.abs(axisValue5) > f26) {
            this.mAxisLTChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[4] = 10;
            this.mAxisValues[4] = axisValue5;
        } else if (this.mAxisLTChanged) {
            this.mAxisLTChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[4] = 10;
            this.mAxisValues[4] = 0.0f;
        }
        InputDevice.MotionRange motionRange6 = device.getMotionRange(18, this.mSource);
        if (motionRange6 != null) {
            f27 = motionRange6.getFlat();
        } else {
            f27 = 0.0f;
        }
        if (Math.abs(axisValue6) > f27) {
            this.mAxisRTChanged = true;
            this.mDataLength += 6;
            this.mAxisTypes[5] = 9;
            this.mAxisValues[5] = axisValue6;
        } else if (this.mAxisRTChanged) {
            this.mAxisRTChanged = false;
            this.mDataLength += 6;
            this.mAxisTypes[5] = 9;
            this.mAxisValues[5] = 0.0f;
        }
        this.mHasKeyEvent = false;
        if (this.mUseDpadKeyEvent) {
            this.mHasKeyEvent = true;
            handleDpadKeyEvent(this.mCmdType, this.mDeviceId, axisValue7, axisValue8);
        } else {
            handleDpadMotionEvent(device, axisValue7, axisValue8);
        }
    }
}
