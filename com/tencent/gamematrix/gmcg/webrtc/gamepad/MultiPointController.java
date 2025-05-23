package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class MultiPointController {
    private GamepadController mGamepadController;
    private final ReentrantLock mLock = new ReentrantLock();
    private Map<Integer, KeyPointer> mKeyPointers = new HashMap();

    /* loaded from: classes6.dex */
    public class KeyPointer {
        public int action;

        /* renamed from: fx, reason: collision with root package name */
        public float f108108fx;

        /* renamed from: fy, reason: collision with root package name */
        public float f108109fy;

        /* renamed from: id, reason: collision with root package name */
        public int f108110id;
        public int key;

        public KeyPointer() {
        }
    }

    public MultiPointController(GamepadController gamepadController) {
        this.mGamepadController = gamepadController;
    }

    private MotionEvent getMultiPointerEvent(KeyPointer keyPointer) {
        int i3;
        if (this.mKeyPointers.size() == 0) {
            return null;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int i16 = keyPointer.action;
        int i17 = 0;
        int i18 = 2;
        if (i16 == 0) {
            if (this.mKeyPointers.size() > 1) {
                i3 = 5;
            } else {
                i3 = 0;
            }
        } else if (i16 == 1) {
            if (this.mKeyPointers.size() > 1) {
                i3 = 6;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 2;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[this.mKeyPointers.size()];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[this.mKeyPointers.size()];
        Iterator<Map.Entry<Integer, KeyPointer>> it = this.mKeyPointers.entrySet().iterator();
        int i19 = 0;
        while (it.hasNext()) {
            KeyPointer value = it.next().getValue();
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.pressure = 1.0f;
            pointerCoords.x = value.f108108fx;
            pointerCoords.y = value.f108109fy;
            pointerCoordsArr[i17] = pointerCoords;
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = value.f108110id;
            pointerProperties.toolType = 1;
            pointerPropertiesArr[i17] = pointerProperties;
            if (value.key == keyPointer.key) {
                i19 = i17;
            }
            i17++;
        }
        if (i3 != 2) {
            i18 = i3 + (i19 << 8);
        }
        return MotionEvent.obtain(uptimeMillis, uptimeMillis, i18, this.mKeyPointers.size(), pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0);
    }

    private int getPointerID(int i3) {
        int i16;
        boolean z16;
        boolean z17;
        if (this.mKeyPointers.size() <= 0) {
            return 1;
        }
        Iterator<Map.Entry<Integer, KeyPointer>> it = this.mKeyPointers.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                KeyPointer value = it.next().getValue();
                if (value.key == i3) {
                    i16 = value.f108110id;
                    z16 = true;
                    break;
                }
            } else {
                i16 = 1;
                z16 = false;
                break;
            }
        }
        if (!z16) {
            i16 = 1;
            while (i16 < 10) {
                Iterator<Map.Entry<Integer, KeyPointer>> it5 = this.mKeyPointers.entrySet().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (it5.next().getValue().f108110id == i16) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (!z17) {
                    break;
                }
                i16++;
            }
        }
        return i16;
    }

    public boolean hasKeyAciton(int i3, int i16) {
        Iterator<Map.Entry<Integer, KeyPointer>> it = this.mKeyPointers.entrySet().iterator();
        while (it.hasNext()) {
            KeyPointer value = it.next().getValue();
            if (value != null && value.key == i3 && value.action == i16) {
                return true;
            }
        }
        return false;
    }

    public void onUserMouseClick(View view, int i3, float f16, float f17) {
        sendMultiPointEvent(view, i3, 0, f16, f17);
        sendMultiPointEvent(view, i3, 1, f16, f17);
    }

    public void sendMultiPointEvent(View view, int i3, int i16, float f16, float f17) {
        this.mLock.lock();
        if (i3 != -1) {
            try {
                KeyPointer keyPointer = new KeyPointer();
                keyPointer.key = i3;
                keyPointer.f108108fx = f16;
                keyPointer.f108109fy = f17;
                keyPointer.action = i16;
                int pointerID = getPointerID(i3);
                keyPointer.f108110id = pointerID;
                this.mKeyPointers.put(Integer.valueOf(pointerID), keyPointer);
                MotionEvent multiPointerEvent = getMultiPointerEvent(keyPointer);
                GamepadController gamepadController = this.mGamepadController;
                if (gamepadController != null) {
                    gamepadController.sendGamepadTouchEvent(multiPointerEvent);
                } else if (view != null && multiPointerEvent != null) {
                    view.dispatchTouchEvent(multiPointerEvent);
                    multiPointerEvent.recycle();
                }
                if (i16 == 1) {
                    this.mKeyPointers.remove(Integer.valueOf(pointerID));
                }
            } catch (NullPointerException unused) {
            } catch (Throwable th5) {
                this.mLock.unlock();
                throw th5;
            }
        }
        this.mLock.unlock();
    }
}
