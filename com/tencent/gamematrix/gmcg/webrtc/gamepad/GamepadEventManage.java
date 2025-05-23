package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.view.MotionEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDMotionEvent;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GamepadEventManage {
    private static GamepadKeyEvent mGamepadKeyEvent = new GamepadKeyEvent();
    private static GamepadMotionEvent mGamepadMotionEvent = new GamepadMotionEvent();

    public static GamepadKeyEvent getKeyEvent(int i3, int i16, int i17, int i18, int i19) {
        mGamepadKeyEvent.msg(i3, i16, i17, i18, i19);
        return mGamepadKeyEvent;
    }

    public static GamepadMotionEvent getMotionEvent(MotionEvent motionEvent, int i3, int i16) {
        mGamepadMotionEvent.processJoystickInput(motionEvent, i3, i16);
        return mGamepadMotionEvent;
    }

    public static GamepadMotionEvent getMotionEvent(HIDMotionEvent hIDMotionEvent, int i3, int i16) {
        mGamepadMotionEvent.processHidJoystickInput(hIDMotionEvent, i3, i16);
        return mGamepadMotionEvent;
    }
}
