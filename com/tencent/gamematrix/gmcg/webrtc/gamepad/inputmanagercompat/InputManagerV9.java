package com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.MotionEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes6.dex */
public class InputManagerV9 implements InputManagerCompat {
    private static final long CHECK_ELAPSED_TIME = 3000;
    private static final String LOG_TAG = "InputManagerV9";
    private static final int MESSAGE_TEST_FOR_DISCONNECT = 101;
    private static final int ON_DEVICE_ADDED = 0;
    private static final int ON_DEVICE_CHANGED = 1;
    private static final int ON_DEVICE_REMOVED = 2;
    private final SparseArray<long[]> mDevices = new SparseArray<>();
    private final Map<InputManagerCompat.InputDeviceListener, Handler> mListeners = new HashMap();
    private final Handler mDefaultHandler = new PollingMessageHandler(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class DeviceEvent implements Runnable {
        private static Queue<DeviceEvent> sEventQueue = new ArrayDeque();
        private int mId;
        private InputManagerCompat.InputDeviceListener mListener;
        private int mMessageType;

        DeviceEvent() {
        }

        static DeviceEvent getDeviceEvent(int i3, int i16, InputManagerCompat.InputDeviceListener inputDeviceListener) {
            DeviceEvent poll = sEventQueue.poll();
            if (poll == null) {
                poll = new DeviceEvent();
            }
            poll.mMessageType = i3;
            poll.mId = i16;
            poll.mListener = inputDeviceListener;
            return poll;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = this.mMessageType;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        Log.e(InputManagerV9.LOG_TAG, "Unknown Message Type");
                    } else {
                        this.mListener.onInputDeviceRemoved(this.mId);
                    }
                } else {
                    this.mListener.onInputDeviceChanged(this.mId);
                }
            } else {
                this.mListener.onInputDeviceAdded(this.mId);
            }
            sEventQueue.offer(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class PollingMessageHandler extends Handler {
        private final WeakReference<InputManagerV9> mInputManager;

        PollingMessageHandler(InputManagerV9 inputManagerV9) {
            this.mInputManager = new WeakReference<>(inputManagerV9);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            InputManagerV9 inputManagerV9;
            super.handleMessage(message);
            if (message.what == 101 && (inputManagerV9 = this.mInputManager.get()) != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int size = inputManagerV9.mDevices.size();
                for (int i3 = 0; i3 < size; i3++) {
                    long[] jArr = (long[]) inputManagerV9.mDevices.valueAt(i3);
                    if (jArr != null && elapsedRealtime - jArr[0] > 3000) {
                        int keyAt = inputManagerV9.mDevices.keyAt(i3);
                        if (InputDevice.getDevice(keyAt) == null) {
                            inputManagerV9.notifyListeners(2, keyAt);
                            inputManagerV9.mDevices.remove(keyAt);
                        } else {
                            jArr[0] = elapsedRealtime;
                        }
                    }
                }
                sendEmptyMessageDelayed(101, 3000L);
            }
        }
    }

    public InputManagerV9() {
        getInputDeviceIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(int i3, int i16) {
        if (!this.mListeners.isEmpty()) {
            for (InputManagerCompat.InputDeviceListener inputDeviceListener : this.mListeners.keySet()) {
                this.mListeners.get(inputDeviceListener).post(DeviceEvent.getDeviceEvent(i3, i16, inputDeviceListener));
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public InputDevice getInputDevice(int i3) {
        return InputDevice.getDevice(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public int[] getInputDeviceIds() {
        int[] deviceIds = InputDevice.getDeviceIds();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i3 : deviceIds) {
            if (this.mDevices.get(i3) == null) {
                this.mDevices.put(i3, new long[]{elapsedRealtime});
            }
        }
        return deviceIds;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void onGenericMotionEvent(MotionEvent motionEvent) {
        int deviceId = motionEvent.getDeviceId();
        long[] jArr = this.mDevices.get(deviceId);
        if (jArr == null) {
            notifyListeners(0, deviceId);
            jArr = new long[1];
            this.mDevices.put(deviceId, jArr);
        }
        jArr[0] = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void onPause() {
        this.mDefaultHandler.removeMessages(101);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void onResume() {
        this.mDefaultHandler.sendEmptyMessage(101);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void registerInputDeviceListener(InputManagerCompat.InputDeviceListener inputDeviceListener, Handler handler) {
        this.mListeners.remove(inputDeviceListener);
        if (handler == null) {
            handler = this.mDefaultHandler;
        }
        this.mListeners.put(inputDeviceListener, handler);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat
    public void unregisterInputDeviceListener(InputManagerCompat.InputDeviceListener inputDeviceListener) {
        this.mListeners.remove(inputDeviceListener);
    }
}
