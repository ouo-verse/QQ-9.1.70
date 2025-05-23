package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class HIDInputEvent {
    public static final int INPUT_TYPE_JOYSTICK = 1;
    public static final int INPUT_TYPE_JOYSTICK_KEY = 2;
    public static final int INPUT_TYPE_NONE = 0;
    public static final int INPUT_TYPE_TOUCH = 3;
    protected int mAction;
    protected int mEventType;

    public int getAction() {
        return this.mAction;
    }

    public int getType() {
        return this.mEventType;
    }

    public void setAction(int i3) {
        this.mAction = i3;
    }

    public void setType(int i3) {
        this.mEventType = i3;
    }
}
