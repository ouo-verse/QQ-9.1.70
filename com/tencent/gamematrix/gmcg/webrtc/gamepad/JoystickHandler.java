package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.view.InputDevice;
import android.view.InputEvent;
import android.view.MotionEvent;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDMotionEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapSceneConfig;

/* compiled from: P */
/* loaded from: classes6.dex */
public class JoystickHandler {
    private static final int DPAD_DOWN_INDEX = 3;
    private static final int DPAD_LEFT_INDEX = 0;
    private static final int DPAD_MAX_INDEX = 4;
    private static final int DPAD_RIGHT_INDEX = 2;
    private static final int DPAD_STATE_PRESS = 1;
    private static final int DPAD_STATE_RELEASE = 0;
    private static final int DPAD_UP_INDEX = 1;
    private static final int[] DpadKeyCodes = {21, 19, 22, 20};
    private static final int[] DpadKeyStates = {0, 0, 0, 0};
    private static final int TYPE_AXIS_FLAG_DPAD = 4;
    private static final int TYPE_AXIS_FLAG_L = 1;
    private static final int TYPE_AXIS_FLAG_LT = 8;
    private static final int TYPE_AXIS_FLAG_NONE = 0;
    private static final int TYPE_AXIS_FLAG_R = 2;
    private static final int TYPE_AXIS_FLAG_RT = 16;
    private final GamepadController mGamepadController;
    private JoystickAxesState mJoystickAxesState;
    private int mJoystickType = 0;
    private final float mCenteredAxis = 0.0f;
    private boolean mLTriggerPressed = false;
    private boolean mRTriggerPressed = false;
    private boolean mIsDirectionPressed = false;

    public JoystickHandler(GamepadController gamepadController) {
        this.mGamepadController = gamepadController;
        this.mJoystickAxesState = new JoystickAxesState(gamepadController);
    }

    private static float getCenteredAxis(HIDMotionEvent hIDMotionEvent, int i3) {
        float flat = hIDMotionEvent.getFlat(i3);
        float axisValue = hIDMotionEvent.getAxisValue(i3);
        if (Math.abs(axisValue) > flat) {
            return axisValue;
        }
        return 0.0f;
    }

    private int handleDpadState(int i3, int i16, float f16, float f17) {
        int[] iArr = {0, 0, 0, 0};
        if (Float.compare(f16, -1.0f) == 0) {
            iArr[0] = 1;
        } else if (Float.compare(f16, 1.0f) == 0) {
            iArr[2] = 1;
        }
        if (Float.compare(f17, -1.0f) == 0) {
            iArr[1] = 1;
        } else if (Float.compare(f17, 1.0f) == 0) {
            iArr[3] = 1;
        }
        this.mIsDirectionPressed = false;
        int i17 = 0;
        for (int i18 = 0; i18 < 4; i18++) {
            int[] iArr2 = DpadKeyStates;
            int i19 = iArr2[i18];
            int i26 = DpadKeyCodes[i18];
            int i27 = iArr[i18];
            if (i27 == 1) {
                this.mIsDirectionPressed = true;
            }
            if ((i27 ^ i19) != 0) {
                iArr2[i18] = i27;
                i17 = this.mGamepadController.handleKeyEvent(i3, i19, i26);
            }
        }
        return i17;
    }

    private int handleJoystickLState(int i3, float f16, float f17) {
        this.mGamepadController.onJoystickLState(i3, f16, f17);
        return 1;
    }

    private int handleJoystickLUp() {
        CGLog.i("joystick index=0 state=0");
        this.mGamepadController.onJoystickLUp();
        return 1;
    }

    private int handleJoystickRState(int i3, float f16, float f17) {
        this.mGamepadController.onJoystickRState(i3, f16, f17);
        return 1;
    }

    private int handleJoystickRUp() {
        CGLog.i("joystick index=1 state=0");
        this.mGamepadController.onJoystickRUp();
        return 1;
    }

    private int handleKeyJoyState(int i3, int i16, float f16, float f17) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onKeyJoyState(i3, i16, f16, f17);
            return 1;
        }
        return 1;
    }

    private int handleKeyJoyUp(int i3, int i16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onKeyJoyUp(i3, i16);
            return 1;
        }
        return 1;
    }

    public static boolean isDpadDevice(InputEvent inputEvent) {
        if ((inputEvent.getSource() & 513) != 513) {
            return true;
        }
        return false;
    }

    public static boolean isJoystickDevice(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 16777232) == 16777232 && motionEvent.getAction() == 2) {
            return true;
        }
        return false;
    }

    private int processDpadInput(MotionEvent motionEvent) {
        int i3;
        float axisValue = motionEvent.getAxisValue(15);
        float axisValue2 = motionEvent.getAxisValue(16);
        if (axisValue != 0.0f) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (axisValue2 != 0.0f) {
            i3 += 2;
        }
        if (i3 == 0 && !this.mIsDirectionPressed) {
            return 0;
        }
        this.mJoystickType |= 4;
        return handleDpadState(motionEvent.getDeviceId(), i3, axisValue, axisValue2);
    }

    private int processHidGamepadInput(HIDMotionEvent hIDMotionEvent) {
        int i3;
        float axisValue = hIDMotionEvent.getAxisValue(hIDMotionEvent.getAxisXIndex());
        float axisValue2 = hIDMotionEvent.getAxisValue(hIDMotionEvent.getAxisYIndex());
        if (axisValue != 0.0f) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (axisValue2 != 0.0f) {
            i3 += 2;
        }
        if (i3 != 0) {
            return handleKeyJoyState(hIDMotionEvent.getId(), hIDMotionEvent.getKeyCode(), axisValue, axisValue2);
        }
        return handleKeyJoyUp(hIDMotionEvent.getId(), hIDMotionEvent.getKeyCode());
    }

    private int processTrigger(MotionEvent motionEvent) {
        int i3;
        float axisValue = motionEvent.getAxisValue(17);
        float axisValue2 = motionEvent.getAxisValue(18);
        if (axisValue == 1.0f) {
            this.mLTriggerPressed = true;
            i3 = this.mGamepadController.handleKeyEvent(motionEvent.getDeviceId(), 0, 104);
        } else if (this.mLTriggerPressed) {
            this.mLTriggerPressed = false;
            i3 = this.mGamepadController.handleKeyEvent(motionEvent.getDeviceId(), 1, 104);
        } else {
            i3 = 0;
        }
        if (axisValue2 == 1.0f) {
            this.mRTriggerPressed = true;
            return this.mGamepadController.handleKeyEvent(motionEvent.getDeviceId(), 0, 105);
        }
        if (this.mRTriggerPressed) {
            this.mRTriggerPressed = false;
            return this.mGamepadController.handleKeyEvent(motionEvent.getDeviceId(), 1, 105);
        }
        return i3;
    }

    public int handleHidJoystickEvent(HIDMotionEvent hIDMotionEvent) {
        int type = hIDMotionEvent.getType();
        if (type != 2 && type != 1) {
            if (3 == hIDMotionEvent.getType()) {
                if (hIDMotionEvent.getId() == 8) {
                    return processHidGamepadInput(hIDMotionEvent);
                }
                if (hIDMotionEvent.getId() == 9) {
                    if (this.mGamepadController != null) {
                        this.mGamepadController.onGamepadTouchMapRelOffset(hIDMotionEvent.getAction(), hIDMotionEvent.getX(), hIDMotionEvent.getY());
                    }
                } else if (hIDMotionEvent.getId() == 10 && this.mGamepadController != null) {
                    this.mGamepadController.onGamepadTouchMapRelDirection(hIDMotionEvent.getAction(), hIDMotionEvent.getX(), hIDMotionEvent.getY());
                }
            }
            return 0;
        }
        return processHidGamepadInput(hIDMotionEvent);
    }

    public int handleJoystickEvent(MotionEvent motionEvent) {
        int i3 = 0;
        if (motionEvent != null) {
            if (isDpadDevice(motionEvent)) {
                i3 = processDpadInput(motionEvent);
            }
            if (isJoystickDevice(motionEvent)) {
                KeyMapSceneConfig currentSceneConfig = this.mGamepadController.getCurrentSceneConfig();
                if (currentSceneConfig != null && currentSceneConfig.getSelectKeyChooseWindowItem() != null) {
                    this.mJoystickAxesState.updateStateForAxisXY(motionEvent);
                } else {
                    i3 = processJoystickInput(motionEvent);
                }
            }
            processTrigger(motionEvent);
        }
        return i3;
    }

    public int processJoystickInput(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i3 = 0; i3 < historySize; i3++) {
            processJoystickInput(motionEvent, i3);
        }
        processJoystickInput(motionEvent, -1);
        return 1;
    }

    private static float getCenteredAxis(MotionEvent motionEvent, InputDevice inputDevice, int i3, int i16) {
        InputDevice.MotionRange motionRange;
        float historicalAxisValue;
        if (inputDevice != null && (motionRange = inputDevice.getMotionRange(i3, motionEvent.getSource())) != null) {
            float flat = motionRange.getFlat();
            if ((i3 == 0 || i3 == 1) && flat < 0.125f) {
                flat = 0.125f;
            }
            if (i16 < 0) {
                historicalAxisValue = motionEvent.getAxisValue(i3);
            } else {
                historicalAxisValue = motionEvent.getHistoricalAxisValue(i3, i16);
            }
            if (Math.abs(historicalAxisValue) > flat) {
                return historicalAxisValue;
            }
        }
        return 0.0f;
    }

    private int processJoystickInput(MotionEvent motionEvent, int i3) {
        InputDevice device = motionEvent.getDevice();
        int i16 = 0;
        float centeredAxis = getCenteredAxis(motionEvent, device, 0, i3);
        float centeredAxis2 = getCenteredAxis(motionEvent, device, 1, i3);
        int i17 = centeredAxis != 0.0f ? 1 : 0;
        if (centeredAxis2 != 0.0f) {
            i17 += 2;
        }
        float centeredAxis3 = getCenteredAxis(motionEvent, device, 11, i3);
        float centeredAxis4 = getCenteredAxis(motionEvent, device, 14, i3);
        int i18 = centeredAxis3 != 0.0f ? 1 : 0;
        if (centeredAxis4 != 0.0f) {
            i18 += 2;
        }
        getCenteredAxis(motionEvent, device, 17, i3);
        getCenteredAxis(motionEvent, device, 18, i3);
        int i19 = this.mJoystickType;
        if ((i19 & 1) == 1 && i17 == 0) {
            this.mJoystickType = i19 ^ 1;
            handleJoystickLUp();
        }
        int i26 = this.mJoystickType;
        if ((i26 & 2) == 2 && i18 == 0) {
            this.mJoystickType = i26 ^ 2;
            handleJoystickRUp();
        }
        if (i17 != 0) {
            this.mJoystickType |= 1;
            i16 = handleJoystickLState(i17, centeredAxis, centeredAxis2);
        }
        if (i18 == 0) {
            return i16;
        }
        this.mJoystickType |= 2;
        return handleJoystickRState(i18, centeredAxis3, centeredAxis4);
    }
}
