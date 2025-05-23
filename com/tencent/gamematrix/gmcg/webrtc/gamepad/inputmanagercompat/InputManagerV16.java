package com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Handler;
import android.view.InputDevice;
import android.view.MotionEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes6.dex */
public class InputManagerV16 implements InputManagerCompat {
    private final InputManager mInputManager;
    private final Map<InputManagerCompat.InputDeviceListener, V16InputDeviceListener> mListeners = new HashMap();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class V16InputDeviceListener implements InputManager.InputDeviceListener {
        final InputManagerCompat.InputDeviceListener mInputDeviceListener;

        public V16InputDeviceListener(InputManagerCompat.InputDeviceListener inputDeviceListener) {
            this.mInputDeviceListener = inputDeviceListener;
        }

        @Override // android.hardware.input.InputManager.InputDeviceListener
        public void onInputDeviceAdded(int i3) {
            this.mInputDeviceListener.onInputDeviceAdded(i3);
        }

        @Override // android.hardware.input.InputManager.InputDeviceListener
        public void onInputDeviceChanged(int i3) {
            this.mInputDeviceListener.onInputDeviceChanged(i3);
        }

        @Override // android.hardware.input.InputManager.InputDeviceListener
        public void onInputDeviceRemoved(int i3) {
            this.mInputDeviceListener.onInputDeviceRemoved(i3);
        }
    }

    public InputManagerV16(Context context) {
        this.mInputManager = (InputManager) context.getSystemService("input");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public InputDevice getInputDevice(int i3) {
        return this.mInputManager.getInputDevice(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public int[] getInputDeviceIds() {
        return this.mInputManager.getInputDeviceIds();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void registerInputDeviceListener(InputManagerCompat.InputDeviceListener inputDeviceListener, Handler handler) {
        V16InputDeviceListener v16InputDeviceListener = new V16InputDeviceListener(inputDeviceListener);
        this.mInputManager.registerInputDeviceListener(v16InputDeviceListener, handler);
        this.mListeners.put(inputDeviceListener, v16InputDeviceListener);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void unregisterInputDeviceListener(InputManagerCompat.InputDeviceListener inputDeviceListener) {
        V16InputDeviceListener remove = this.mListeners.remove(inputDeviceListener);
        if (remove != null) {
            this.mInputManager.unregisterInputDeviceListener(remove);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void onPause() {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void onResume() {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void onGenericMotionEvent(MotionEvent motionEvent) {
    }
}
