package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDKeyEvent;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IGamepadHidEvent {
    int handleHidKeyEvent(HIDKeyEvent hIDKeyEvent);

    void onGamepadTouchMapRelDirection(int i3, int i16, int i17);

    void onGamepadTouchMapRelOffset(int i3, int i16, int i17);

    int onKeyJoyState(int i3, int i16, float f16, float f17);

    int onKeyJoyUp(int i3, int i16);

    void reportGamepadStatus(String str, int i3, String str2);
}
