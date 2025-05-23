package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDKeyEvent extends HIDInputEvent {
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_UP = 1;
    public static final int HID_KEYCODE_A1 = 1000;
    public static final int HID_KEYCODE_A2 = 1001;
    public static final int HID_KEYCODE_K1 = 1031;
    public static final int HID_KEYCODE_K10 = 1040;
    public static final int HID_KEYCODE_K11 = 1041;
    public static final int HID_KEYCODE_K12 = 1042;
    public static final int HID_KEYCODE_K13 = 1043;
    public static final int HID_KEYCODE_K14 = 1044;
    public static final int HID_KEYCODE_K15 = 1045;
    public static final int HID_KEYCODE_K16 = 1046;
    public static final int HID_KEYCODE_K2 = 1032;
    public static final int HID_KEYCODE_K3 = 1033;
    public static final int HID_KEYCODE_K4 = 1034;
    public static final int HID_KEYCODE_K5 = 1035;
    public static final int HID_KEYCODE_K6 = 1036;
    public static final int HID_KEYCODE_K7 = 1037;
    public static final int HID_KEYCODE_K8 = 1038;
    public static final int HID_KEYCODE_K9 = 1039;
    public static final int HID_KEYCODE_ZL = 1015;
    public static final int HID_KEYCODE_ZR = 1016;
    public static final int HID_KEYCODE_b1 = 1002;
    public static final int HID_KEYCODE_fd = 1006;
    public static final int HID_KEYCODE_fi = 1009;
    public static final int HID_KEYCODE_fl = 1012;
    public static final int HID_KEYCODE_fm = 1014;
    public static final int HID_KEYCODE_fn = 1008;
    public static final int HID_KEYCODE_fr = 1013;
    public static final int HID_KEYCODE_fu = 1007;
    public static final int HID_KEYCODE_x1 = 1003;
    public static final int HID_KEYCODE_y1 = 1004;
    public static final int HID_KEYCODE_z1 = 1005;
    public static final int KEY_INDEX_A = 1;
    public static final int KEY_INDEX_A1 = 7;
    public static final int KEY_INDEX_A2 = 8;
    public static final int KEY_INDEX_B = 2;
    public static final int KEY_INDEX_C = 5;
    public static final int KEY_INDEX_K1 = 1;
    public static final int KEY_INDEX_K10 = 10;
    public static final int KEY_INDEX_K11 = 11;
    public static final int KEY_INDEX_K12 = 12;
    public static final int KEY_INDEX_K13 = 13;
    public static final int KEY_INDEX_K14 = 14;
    public static final int KEY_INDEX_K15 = 15;
    public static final int KEY_INDEX_K16 = 16;
    public static final int KEY_INDEX_K2 = 2;
    public static final int KEY_INDEX_K3 = 3;
    public static final int KEY_INDEX_K4 = 4;
    public static final int KEY_INDEX_K5 = 5;
    public static final int KEY_INDEX_K6 = 6;
    public static final int KEY_INDEX_K7 = 7;
    public static final int KEY_INDEX_K8 = 8;
    public static final int KEY_INDEX_K9 = 9;
    public static final int KEY_INDEX_X = 3;
    public static final int KEY_INDEX_Y = 4;
    public static final int KEY_INDEX_Z = 6;
    public static final int KEY_INDEX_ZL = 9;
    public static final int KEY_INDEX_ZR = 10;
    public static final int KEY_INDEX_b1 = 21;
    public static final int KEY_INDEX_fd = 14;
    public static final int KEY_INDEX_fi = 11;
    public static final int KEY_INDEX_fl = 15;
    public static final int KEY_INDEX_fm = 17;
    public static final int KEY_INDEX_fn = 12;
    public static final int KEY_INDEX_fr = 16;
    public static final int KEY_INDEX_fu = 13;
    public static final int KEY_INDEX_x1 = 20;
    public static final int KEY_INDEX_y1 = 19;
    public static final int KEY_INDEX_z1 = 18;
    private int mKeyCode;
    private int mRepeatCount;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Callback {
        boolean onKeyDown(int i3, HIDKeyEvent hIDKeyEvent);

        boolean onKeyUp(int i3, HIDKeyEvent hIDKeyEvent);
    }

    public HIDKeyEvent(int i3, int i16, int i17) {
        this.mAction = i3;
        this.mKeyCode = i16;
        this.mRepeatCount = i17;
    }

    public int getKeyCode() {
        return this.mKeyCode;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }
}
