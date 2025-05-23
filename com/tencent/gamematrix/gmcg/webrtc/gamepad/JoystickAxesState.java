package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.view.MotionEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapSceneConfig;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class JoystickAxesState {
    private static final int STATE_DOWN_OR_RIGHT = 1;
    private static final int STATE_NEUTRAL = 0;
    private static final int STATE_UP_OR_LEFT = -1;
    private static final String TAG = "JoystickAxesState";
    private final GamepadController mGamepadController;
    final int[] mAxisStatesHat = {0, 0};
    final int[] mAxisStatesStick = {0, 0};
    private int mAxisStateIndex = 0;

    public JoystickAxesState(GamepadController gamepadController) {
        this.mGamepadController = gamepadController;
    }

    private boolean isXAxis(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    private boolean isYAxis(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    private int joystickAxisAndStateToKeycode(int i3, int i16) {
        if (isXAxis(i3) && i16 == -1) {
            return 21;
        }
        if (isXAxis(i3) && i16 == 1) {
            return 22;
        }
        if (isYAxis(i3) && i16 == -1) {
            return 19;
        }
        if (isYAxis(i3) && i16 == 1) {
            return 20;
        }
        return 0;
    }

    private int joystickAxisValueToState(float f16) {
        if (f16 >= 0.5f) {
            return 1;
        }
        if (f16 <= -0.5f) {
            return -1;
        }
        return 0;
    }

    public void updateStateForAxisXY(MotionEvent motionEvent) {
        int i3;
        int i16;
        int joystickAxisAndStateToKeycode;
        KeyMapSceneConfig currentSceneConfig;
        int joystickAxisAndStateToKeycode2;
        KeyMapSceneConfig currentSceneConfig2;
        float axisValue = motionEvent.getAxisValue(0);
        float axisValue2 = motionEvent.getAxisValue(1);
        if (Math.abs(axisValue) >= Math.abs(axisValue2)) {
            i16 = 0;
            i3 = 0;
        } else {
            i3 = 1;
            axisValue = axisValue2;
            i16 = 1;
        }
        int joystickAxisValueToState = joystickAxisValueToState(axisValue);
        int i17 = this.mAxisStatesStick[i16];
        if (i17 == joystickAxisValueToState && this.mAxisStateIndex == i16) {
            return;
        }
        if (this.mAxisStateIndex != i16) {
            this.mAxisStateIndex = i16;
            return;
        }
        if ((i17 == 1 || i17 == -1) && (joystickAxisAndStateToKeycode = joystickAxisAndStateToKeycode(i3, i17)) != 0 && (currentSceneConfig = this.mGamepadController.getCurrentSceneConfig()) != null && currentSceneConfig.getConfigSize(4) > 0) {
            this.mGamepadController.handleKeyEvent(motionEvent.getDeviceId(), 1, joystickAxisAndStateToKeycode);
        }
        if ((joystickAxisValueToState == 1 || joystickAxisValueToState == -1) && (joystickAxisAndStateToKeycode2 = joystickAxisAndStateToKeycode(i3, joystickAxisValueToState)) != 0 && (currentSceneConfig2 = this.mGamepadController.getCurrentSceneConfig()) != null && currentSceneConfig2.getConfigSize(4) > 0) {
            this.mGamepadController.handleKeyEvent(motionEvent.getDeviceId(), 0, joystickAxisAndStateToKeycode2);
        }
        this.mAxisStateIndex = i16;
        this.mAxisStatesStick[i16] = joystickAxisValueToState;
    }
}
