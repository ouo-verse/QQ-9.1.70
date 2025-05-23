package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GamepadKeyEvent extends GamepadInputEvent {
    private static final Map<Integer, Integer> mGamepadMapA;
    private static final Map<Integer, Integer> mGamepadMapB;
    private static final int mGamepadModeA = 1;
    private static final int mGamepadModeB = 2;
    public int mAction;
    public int mCmdType;
    public int mDeviceId;
    public int mKeyCode;
    public int mSource;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface KeyCode {
        public static final int BUTTON_A = 96;
        public static final int BUTTON_B = 97;
        public static final int BUTTON_L1 = 102;
        public static final int BUTTON_L2 = 104;
        public static final int BUTTON_MODE = 110;
        public static final int BUTTON_R1 = 103;
        public static final int BUTTON_R2 = 105;
        public static final int BUTTON_SELECT = 109;
        public static final int BUTTON_START = 108;
        public static final int BUTTON_THUMBL = 106;
        public static final int BUTTON_THUMBR = 107;
        public static final int BUTTON_X = 99;
        public static final int BUTTON_Y = 100;
        public static final int DPAD_CENTER = 23;
        public static final int DPAD_DOWN = 20;
        public static final int DPAD_LEFT = 21;
        public static final int DPAD_RIGHT = 22;
        public static final int DPAD_UP = 19;
        public static final int KEY_BACK = 4;
        public static final int KEY_ENTER = 66;
        public static final int KEY_MENU = 82;
        public static final int TOKEY_A = 29;
        public static final int TOKEY_B = 30;
        public static final int TOKEY_C = 31;
        public static final int TOKEY_D = 32;
        public static final int TOKEY_E = 33;
        public static final int TOKEY_F = 34;
        public static final int TOKEY_G = 35;
        public static final int TOKEY_H = 36;
        public static final int TOKEY_I = 37;
        public static final int TOKEY_J = 38;
        public static final int TOKEY_K = 39;
        public static final int TOKEY_L = 40;
        public static final int TOKEY_M = 41;
        public static final int TOKEY_N = 42;
        public static final int TOKEY_O = 43;
        public static final int TOKEY_P = 44;
        public static final int TOKEY_Q = 45;
        public static final int TOKEY_R = 46;
        public static final int TOKEY_S = 47;
        public static final int TOKEY_T = 48;
        public static final int TOKEY_U = 49;
        public static final int TOKEY_V = 50;
        public static final int TOKEY_W = 51;
        public static final int TOKEY_X = 52;
        public static final int TOKEY_Y = 53;
        public static final int TOKEY_Z = 54;
    }

    static {
        HashMap hashMap = new HashMap();
        mGamepadMapA = hashMap;
        hashMap.put(19, 19);
        hashMap.put(20, 20);
        hashMap.put(21, 21);
        hashMap.put(22, 22);
        hashMap.put(23, 23);
        hashMap.put(66, 23);
        hashMap.put(96, 96);
        hashMap.put(97, 97);
        hashMap.put(99, 99);
        hashMap.put(100, 100);
        hashMap.put(102, 102);
        hashMap.put(103, 103);
        hashMap.put(104, 104);
        hashMap.put(105, 105);
        hashMap.put(106, 106);
        hashMap.put(107, 107);
        hashMap.put(108, 108);
        hashMap.put(109, 109);
        hashMap.put(110, 110);
        hashMap.put(4, 4);
        hashMap.put(111, 4);
        hashMap.put(82, 82);
        HashMap hashMap2 = new HashMap();
        mGamepadMapB = hashMap2;
        hashMap2.put(19, 42);
        hashMap2.put(20, 47);
        hashMap2.put(21, 51);
        hashMap2.put(22, 33);
        hashMap2.put(23, 23);
        hashMap2.put(66, 23);
        hashMap2.put(96, 29);
        hashMap2.put(97, 30);
        hashMap2.put(99, 52);
        hashMap2.put(100, 53);
        hashMap2.put(102, 40);
        hashMap2.put(103, 46);
        hashMap2.put(104, 44);
        hashMap2.put(105, 45);
        hashMap2.put(106, 34);
        hashMap2.put(107, 48);
        hashMap2.put(108, 32);
        hashMap2.put(109, 39);
        hashMap2.put(110, 41);
        hashMap2.put(4, 4);
        hashMap2.put(111, 4);
        hashMap2.put(82, 82);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamepadKeyEvent() {
        this.mInputEventType = 1;
    }

    public void msg(int i3, int i16, int i17, int i18, int i19) {
        this.mCmdType = i3;
        this.mDeviceId = i16;
        this.mAction = i19;
        this.mKeyCode = i18;
        this.mSource = 0;
        Map<Integer, Integer> map = mGamepadMapA;
        if (map.get(Integer.valueOf(i18)) != null) {
            this.mKeyCode = map.get(Integer.valueOf(i18)).intValue();
        }
        int i26 = this.mKeyCode;
        if (i26 != -1) {
            this.mSource = i17;
            if (i26 == 82) {
                this.mSource = i17 | 769;
            }
        }
    }
}
