package com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat;

import android.content.Context;
import android.os.Handler;
import android.view.InputDevice;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface InputManagerCompat {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Factory {
        static InputManagerCompat sInputManagerCompat;

        public static InputManagerCompat getInputManager(Context context) {
            if (sInputManagerCompat == null) {
                sInputManagerCompat = new InputManagerV16(context);
            }
            return sInputManagerCompat;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface InputDeviceListener {
        void onInputDeviceAdded(int i3);

        void onInputDeviceChanged(int i3);

        void onInputDeviceRemoved(int i3);
    }

    InputDevice getInputDevice(int i3);

    int[] getInputDeviceIds();

    void onGenericMotionEvent(MotionEvent motionEvent);

    void onPause();

    void onResume();

    void registerInputDeviceListener(InputDeviceListener inputDeviceListener, Handler handler);

    void unregisterInputDeviceListener(InputDeviceListener inputDeviceListener);
}
