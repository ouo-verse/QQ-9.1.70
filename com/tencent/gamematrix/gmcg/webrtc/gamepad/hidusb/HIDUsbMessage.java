package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import com.tencent.gamematrix.gmcg.webrtc.gamepad.TVInputManager;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDUsbMessage {
    private static final byte BIT_FLAG_SENSOR_ACC_RANGE = 14;
    private static final byte BIT_FLAG_SENSOR_GYRO_RANGE = 112;
    private static final byte BIT_FLAG_SENSOR_STATUS = 1;
    private static final byte BIT_FLAG_SENSOR_VALID = 1;
    private static final int BIT_INDEX_TB0 = 0;
    private static final int BIT_INDEX_TB1 = 1;
    private static final int BIT_INDEX_TB2 = 2;
    private static final int BIT_INDEX_TB3 = 3;
    private static final int BIT_INDEX_TB4 = 4;
    private static final int BIT_INDEX_TOUCH_MAP_STATUS = 0;
    private static final int BIT_INDEX_TOUCH_MAP_VALID = 3;
    private static final int BIT_INDEX_TOUCH_MOUSE_STATUS = 7;
    private static final int BIT_INDEX_TOUCH_MOUSE_VALID = 1;
    private static final int BOARD_ID_PUBG = 3;
    private static final int BOARD_ID_SGAME = 1;
    private static final int BOARD_ID_STD = 2;
    private static final int BYTE_INDEX_ONLINE_STATE_REPORT = 5;
    private static final int BYTE_INDEX_ONLINE_STATE_RESPONSE = 8;
    private static final int BYTE_INDEX_SENSOR_ACC_X_HIBYTE = 7;
    private static final int BYTE_INDEX_SENSOR_ACC_X_LOBYTE = 6;
    private static final int BYTE_INDEX_SENSOR_ACC_Y_HIBYTE = 9;
    private static final int BYTE_INDEX_SENSOR_ACC_Y_LOBYTE = 8;
    private static final int BYTE_INDEX_SENSOR_ACC_Z_HIBYTE = 11;
    private static final int BYTE_INDEX_SENSOR_ACC_Z_LOBYTE = 10;
    private static final int BYTE_INDEX_SENSOR_GYRO_X_HIBYTE = 13;
    private static final int BYTE_INDEX_SENSOR_GYRO_X_LOBYTE = 12;
    private static final int BYTE_INDEX_SENSOR_GYRO_Y_HIBYTE = 15;
    private static final int BYTE_INDEX_SENSOR_GYRO_Y_LOBYTE = 14;
    private static final int BYTE_INDEX_SENSOR_GYRO_Z_HIBYTE = 17;
    private static final int BYTE_INDEX_SENSOR_GYRO_Z_LOBYTE = 16;
    private static final int BYTE_INDEX_SENSOR_STATUS = 18;
    private static final int BYTE_INDEX_SENSOR_VALID = 5;
    private static final int BYTE_INDEX_TOUCH_BOARD_ID = 6;
    private static final int BYTE_INDEX_TOUCH_BUTTON_STATUS = 7;
    private static final int BYTE_INDEX_TOUCH_BUTTON_VALID = 5;
    private static final int BYTE_INDEX_TOUCH_MAP_INDEX = 27;
    private static final int BYTE_INDEX_TOUCH_MAP_STATUS = 26;
    private static final int BYTE_INDEX_TOUCH_MAP_X = 28;
    private static final int BYTE_INDEX_TOUCH_MAP_Y = 29;
    private static final int BYTE_INDEX_TOUCH_MOUSE_STATUS = 21;
    private static final int BYTE_INDEX_TOUCH_MOUSE_X = 19;
    private static final int BYTE_INDEX_TOUCH_MOUSE_Y = 20;
    private static float mSensitivity = 1.6f;
    private HIDDeviceManage mHIDDeviceManage;
    private final String TAG = "hidusbmsg";
    private final int MotionCenterPos = 128;
    private final float mCenteredAxis = 0.0f;
    private int mJoystickKeyX = 128;
    private int mJoystickKeyY = 128;
    private boolean mIsMouseTouched = false;
    private boolean mIsMapTouched = false;
    private int[] mTBValidArray = new int[5];
    private int[] mTBStatusArray = new int[5];
    private boolean[] mTBIsPressed = new boolean[5];
    private int[] mTBIndexs = new int[5];
    private int[] mTBXs = new int[5];
    private int[] mTBYs = new int[5];

    public HIDUsbMessage(HIDDeviceManage hIDDeviceManage) {
        this.mHIDDeviceManage = hIDDeviceManage;
    }

    public static String composeString(byte[] bArr, int i3) {
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append(String.format("%02x", Byte.valueOf(bArr[i16])).toUpperCase());
            sb5.append(" ");
        }
        return sb5.toString();
    }

    int dispatchKeyMessage(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i3 == 1) {
            return dispatchSGameKeyMessage(i16, i17, i18, i19, i26);
        }
        if (i3 == 3) {
            return dispatchPubgKeyMessage(i16, i17, i18, i19, i26);
        }
        return -1;
    }

    int dispatchPubgKeyMessage(int i3, int i16, int i17, int i18, int i19) {
        int i26;
        char c16;
        int[] iArr = HIDGamepadPerf.nPubgMessage;
        iArr[i3] = iArr[i3] + 1;
        switch (i16) {
            case 1:
                i26 = 1031;
                c16 = 1;
                break;
            case 2:
                i26 = 1032;
                c16 = 1;
                break;
            case 3:
                i26 = 1033;
                c16 = 1;
                break;
            case 4:
                i26 = 1034;
                c16 = 1;
                break;
            case 5:
                i26 = 1035;
                c16 = 1;
                break;
            case 6:
                i26 = 1036;
                c16 = 1;
                break;
            case 7:
                i26 = 1037;
                c16 = 1;
                break;
            case 8:
                i26 = 1038;
                c16 = 2;
                break;
            case 9:
                i26 = 1039;
                c16 = 1;
                break;
            case 10:
                i26 = 1040;
                c16 = 1;
                break;
            case 11:
                i26 = 1041;
                c16 = 1;
                break;
            case 12:
                i26 = 1042;
                c16 = 1;
                break;
            case 13:
                i26 = 1043;
                c16 = 1;
                break;
            case 14:
                i26 = 1044;
                c16 = 1;
                break;
            case 15:
                i26 = 1045;
                c16 = 1;
                break;
            case 16:
                i26 = 1046;
                c16 = 1;
                break;
            default:
                c16 = 0;
                i26 = -1;
                break;
        }
        if (c16 == 1) {
            handleHidKeyEvent(i17, i26, 1);
            HIDGamepadPerf.nHidKeyEvent++;
        } else if (c16 == 2 && i26 != -1) {
            if (i17 == 1) {
                i18 = 128;
                i19 = 128;
            } else if (i18 != this.mJoystickKeyX || i19 != this.mJoystickKeyY) {
                this.mJoystickKeyX = i18;
                this.mJoystickKeyY = i19;
            }
            handleJoyKeyEvent(3, i26, i18, i19);
            HIDGamepadPerf.nHidKeyEvent++;
        }
        return 0;
    }

    int dispatchSGameKeyMessage(int i3, int i16, int i17, int i18, int i19) {
        int i26;
        char c16;
        int[] iArr = HIDGamepadPerf.nSgameMessage;
        iArr[i3] = iArr[i3] + 1;
        switch (i16) {
            case 1:
                i26 = 96;
                c16 = 2;
                break;
            case 2:
                i26 = 97;
                c16 = 2;
                break;
            case 3:
                i26 = 99;
                c16 = 2;
                break;
            case 4:
                i26 = 100;
                c16 = 2;
                break;
            case 5:
                i26 = 98;
                c16 = 2;
                break;
            case 6:
                i26 = 101;
                c16 = 2;
                break;
            case 7:
                i26 = 1000;
                c16 = 1;
                break;
            case 8:
                i26 = 1001;
                c16 = 1;
                break;
            case 9:
                i26 = 1015;
                c16 = 1;
                break;
            case 10:
                i26 = 1016;
                c16 = 1;
                break;
            case 11:
                i26 = 1009;
                c16 = 1;
                break;
            case 12:
                i26 = 1008;
                c16 = 1;
                break;
            case 13:
                i26 = 1007;
                c16 = 1;
                break;
            case 14:
                i26 = 1006;
                c16 = 1;
                break;
            case 15:
                i26 = 1012;
                c16 = 1;
                break;
            case 16:
                i26 = 1013;
                c16 = 1;
                break;
            case 17:
                i26 = 1014;
                c16 = 1;
                break;
            case 18:
                i26 = 1005;
                c16 = 1;
                break;
            case 19:
                i26 = 1004;
                c16 = 1;
                break;
            case 20:
                i26 = 1003;
                c16 = 1;
                break;
            case 21:
                i26 = 1002;
                c16 = 1;
                break;
            default:
                c16 = 0;
                i26 = -1;
                break;
        }
        if (c16 == 1) {
            handleHidKeyEvent(i17, i26, 1);
            HIDGamepadPerf.nHidKeyEvent++;
        } else if (c16 == 2 && i26 != -1) {
            if (i17 == 1) {
                i18 = 128;
                i19 = 128;
            } else if (i18 != this.mJoystickKeyX || i19 != this.mJoystickKeyY) {
                this.mJoystickKeyX = i18;
                this.mJoystickKeyY = i19;
            }
            handleJoyKeyEvent(3, i26, i18, i19);
            HIDGamepadPerf.nHidKeyEvent++;
        }
        return 0;
    }

    void handGamepadOnlineMessage(byte[] bArr, int i3) {
        short s16 = (short) (((short) (bArr[1] & 255)) | ((((short) (bArr[2] & 255)) << 8) & 65280));
        int i16 = bArr[5] & 255;
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            tVInputManager.onGamepadOnlineNotification(s16, i16);
        }
    }

    void handleHidKeyEvent(int i3, int i16, int i17) {
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            tVInputManager.handleHidKeyEvent(new HIDKeyEvent(i3, i16, i17));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleHidUsbData(byte[] bArr, int i3) {
        HIDGamepadPerf.nProcessMessage++;
        byte b16 = bArr[0];
        byte b17 = bArr[4];
        if (b16 == 11) {
            if (b17 == 5) {
                handleKeyMessage(bArr, i3);
                return;
            }
            if (b17 == 4) {
                handleSensorMessage(bArr, i3);
                return;
            } else if (b17 == 11) {
                handGamepadOnlineMessage(bArr, i3);
                return;
            } else {
                HIDGamepadPerf.nUnknownTypeMessage++;
                return;
            }
        }
        if (b16 == 6) {
            if (b17 == 0) {
                onGamepadOnlineMessage(bArr, i3);
                return;
            }
            return;
        }
        HIDGamepadPerf.nUnknownTypeMessage++;
    }

    void handleJoyKeyEvent(int i3, int i16, int i17, int i18) {
        int i19;
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            float f16 = (i17 - 128) / 128.0f;
            float f17 = (i18 - 128) / 128.0f;
            if (f16 != 0.0f) {
                i19 = 1;
            } else {
                i19 = 0;
            }
            if (f17 != 0.0f) {
                i19 += 2;
            }
            if (i19 != 0) {
                tVInputManager.onKeyJoyState(i3, i16, f16, f17);
            } else {
                tVInputManager.onKeyJoyUp(i3, i16);
            }
        }
    }

    void handleKeyMessage(byte[] bArr, int i3) {
        HIDGamepadPerf.nProcessKeyMessage++;
        int[] iArr = this.mTBStatusArray;
        byte b16 = bArr[7];
        iArr[0] = (b16 >> 0) & 1;
        iArr[1] = (b16 >> 1) & 1;
        iArr[2] = (b16 >> 2) & 1;
        iArr[3] = (b16 >> 3) & 1;
        iArr[4] = (b16 >> 4) & 1;
        int[] iArr2 = this.mTBValidArray;
        byte b17 = bArr[5];
        iArr2[0] = (b17 >> 0) & 1;
        iArr2[1] = (b17 >> 1) & 1;
        iArr2[2] = (b17 >> 2) & 1;
        iArr2[3] = (b17 >> 3) & 1;
        iArr2[4] = (b17 >> 4) & 1;
        int i16 = bArr[6] & 255;
        for (int i17 = 0; i17 < 5; i17++) {
            if (this.mTBValidArray[i17] != 0) {
                int i18 = i17 * 3;
                int i19 = bArr[i18 + 8] & 255;
                int i26 = bArr[i18 + 9] & 255;
                int i27 = bArr[i18 + 10] & 255;
                if (this.mTBStatusArray[i17] != 0) {
                    boolean[] zArr = this.mTBIsPressed;
                    if (zArr[i17]) {
                        int[] iArr3 = this.mTBIndexs;
                        int i28 = iArr3[i17];
                        if (i19 != i28) {
                            int i29 = i17;
                            dispatchKeyMessage(i16, i29, i28, 1, this.mTBXs[i17], this.mTBYs[i17]);
                            this.mTBIsPressed[i17] = true;
                            int[] iArr4 = this.mTBIndexs;
                            iArr4[i17] = i19;
                            this.mTBXs[i17] = i26;
                            this.mTBYs[i17] = i27;
                            dispatchKeyMessage(i16, i29, iArr4[i17], 0, i26, i27);
                        } else {
                            int[] iArr5 = this.mTBXs;
                            if (iArr5[i17] == i26 && this.mTBYs[i17] == i27) {
                                int[] iArr6 = HIDGamepadPerf.nInvalidMessage;
                                iArr6[i17] = iArr6[i17] + 1;
                            } else {
                                iArr5[i17] = i26;
                                this.mTBYs[i17] = i27;
                                dispatchKeyMessage(i16, i17, iArr3[i17], 0, i26, i27);
                            }
                        }
                    } else {
                        zArr[i17] = true;
                        int[] iArr7 = this.mTBIndexs;
                        iArr7[i17] = i19;
                        this.mTBXs[i17] = i26;
                        this.mTBYs[i17] = i27;
                        dispatchKeyMessage(i16, i17, iArr7[i17], 0, i26, i27);
                    }
                } else {
                    boolean[] zArr2 = this.mTBIsPressed;
                    if (zArr2[i17]) {
                        zArr2[i17] = false;
                        dispatchKeyMessage(i16, i17, this.mTBIndexs[i17], 1, this.mTBXs[i17], this.mTBYs[i17]);
                    } else {
                        int[] iArr8 = HIDGamepadPerf.nInvalidMessage;
                        iArr8[i17] = iArr8[i17] + 1;
                    }
                }
            } else {
                boolean[] zArr3 = this.mTBIsPressed;
                if (zArr3[i17]) {
                    zArr3[i17] = false;
                    dispatchKeyMessage(i16, i17, this.mTBIndexs[i17], 1, this.mTBXs[i17], this.mTBYs[i17]);
                } else {
                    int[] iArr9 = HIDGamepadPerf.nInvalidMessage;
                    iArr9[i17] = iArr9[i17] + 1;
                }
            }
        }
    }

    void handlePubgTouchMapMessage(int i3, int i16, int i17) {
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            tVInputManager.onGamepadTouchMapRelOffset(i3, i16, i17);
        }
    }

    void handleSGameTouchMapMessage(int i3, int i16, int i17) {
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            tVInputManager.onGamepadTouchMapRelDirection(i3, i16, i17);
        }
    }

    void handleSensorAxisMessage(byte[] bArr, int i3) {
        int i16 = bArr[5] & 1;
        byte b16 = bArr[18];
        if (i16 != 0) {
            short s16 = (short) (((short) (bArr[6] & 255)) | ((((short) (bArr[7] & 255)) << 8) & 65280));
            short s17 = (short) (((short) (bArr[8] & 255)) | ((((short) (bArr[9] & 255)) << 8) & 65280));
            short s18 = (short) (((short) (bArr[10] & 255)) | ((((short) (bArr[11] & 255)) << 8) & 65280));
            short s19 = (short) (((short) (bArr[12] & 255)) | ((((short) (bArr[13] & 255)) << 8) & 65280));
            short s26 = (short) (((short) (bArr[14] & 255)) | ((((short) (bArr[15] & 255)) << 8) & 65280));
            short s27 = (short) (((((short) (bArr[17] & 255)) << 8) & 65280) | ((short) (bArr[16] & 255)));
            float f16 = (((mSensitivity * 0.061035156f) * 2.0f) * 3.14159f) / 360.0f;
            float[] fArr = {-(s17 * 0.0023925782f), s16 * 0.0023925782f, s18 * 0.0023925782f};
            IHIDSensorManager.getSensorManager().sendSensorEvent(1, fArr);
            fArr[0] = -(s26 * f16);
            fArr[1] = s19 * f16;
            fArr[2] = s27 * f16;
            IHIDSensorManager.getSensorManager().sendSensorEvent(4, fArr);
        }
    }

    void handleSensorMessage(byte[] bArr, int i3) {
        HIDGamepadPerf.nProcessSensorMessage++;
        if (((bArr[5] >> 1) & 1) != 0) {
            byte b16 = (byte) (bArr[19] & 255);
            byte b17 = (byte) (bArr[20] & 255);
            if (((bArr[21] >> 7) & 1) != 0) {
                if (!this.mIsMouseTouched) {
                    this.mIsMouseTouched = true;
                    handlePubgTouchMapMessage(0, b16, b17);
                } else {
                    handlePubgTouchMapMessage(2, b16, b17);
                }
            } else if (this.mIsMouseTouched) {
                this.mIsMouseTouched = false;
                handlePubgTouchMapMessage(1, b16, b17);
            }
        }
        if (((bArr[5] >> 3) & 1) != 0) {
            int i16 = bArr[28] & 255;
            int i17 = bArr[29] & 255;
            if (((bArr[26] >> 0) & 1) != 0) {
                if (!this.mIsMapTouched) {
                    this.mIsMapTouched = true;
                    handleSGameTouchMapMessage(0, i16, i17);
                } else {
                    handleSGameTouchMapMessage(2, i16, i17);
                }
            } else if (this.mIsMapTouched) {
                this.mIsMapTouched = false;
                handleSGameTouchMapMessage(1, i16, i17);
            }
        }
        HIDDeviceManage hIDDeviceManage = this.mHIDDeviceManage;
        if (hIDDeviceManage != null && hIDDeviceManage.isSensorEnabled()) {
            handleSensorAxisMessage(bArr, i3);
        }
    }

    void onGamepadOnlineMessage(byte[] bArr, int i3) {
        short s16 = (short) (((short) (bArr[1] & 255)) | ((((short) (bArr[2] & 255)) << 8) & 65280));
        int i16 = bArr[8] & 255;
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            tVInputManager.onGamepadOnlineNotification(s16, i16);
        }
    }
}
