package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.HandlerTimer;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ChooseWindowItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDKeyEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.GlobalConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyChooseWindowItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapConfigManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapKeyItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapSceneConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.InputUtils;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes6.dex */
public class KeyHandler {
    public static final int DEFAULT_KEY_COMBINATION = -100;
    public static final int KEY_ACTION_CLICK = 3;
    public static final int KEY_ACTION_DOWN = 1;
    public static final int KEY_ACTION_UP = 2;
    private static final int KEY_STATE_COMBIN_FAIL = 3;
    private static final int KEY_STATE_COMBIN_HIT = 4;
    private static final int KEY_STATE_COMBIN_MAYBE = 2;
    private static final int KEY_STATE_HITKEY = 1;
    private static final int KEY_STATE_NONE = 0;
    private static final int KeyCombinationDelayTimerMillils = 100;
    private static final int KeyCombinationTimerId = 3;
    private static final int MenuTimerDelayMillils = 500;
    private static final int MenuTimerId = 1;
    private static final int TVDpadMouseTimerDelayMillils = 200;
    private static final int TVDpadMouseTimerId = 2;
    public static SparseArray<ButtonKey> mButtonKeyNameArray = null;
    public static int mKeyCode1 = -1;
    public static int mKeyCode2 = -1;
    public static int mKeyCombination = -100;
    private final GamepadController mGamepadController;
    private HandlerTimer mHandlerTimer;
    private SparseArray<KeyMapKeyItem> mKeyEventItems;
    private KeyMapSceneConfig mKeyMapSceneConfig;
    private Set<Integer> mOneKeyCodes;
    private int mKeyState = 0;
    private final Lock mKeyLock = new ReentrantLock();

    public KeyHandler(GamepadController gamepadController) {
        this.mGamepadController = gamepadController;
        mButtonKeyNameArray = new SparseArray<>();
        this.mOneKeyCodes = new HashSet();
        this.mKeyEventItems = new SparseArray<>();
        this.mKeyMapSceneConfig = KeyMapConfigManager.getInstance().getCurrentSceneConfig();
        this.mHandlerTimer = new HandlerTimer(new HandlerTimer.OnTimerListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.j
            @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.HandlerTimer.OnTimerListener
            public final boolean onTime(int i3) {
                boolean lambda$new$0;
                lambda$new$0 = KeyHandler.this.lambda$new$0(i3);
                return lambda$new$0;
            }
        });
    }

    private void cancelCheckKeyCombinationLongDown() {
        CGLog.i("KeyCombination cancelCheckKeyCombinationLongDown");
        HandlerTimer handlerTimer = this.mHandlerTimer;
        if (handlerTimer != null) {
            handlerTimer.stopTimer(3);
        }
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null && gamepadController.getKeyMapMode() == 12) {
            this.mGamepadController.setKeyMapMode(1, 12);
        }
    }

    private void cancelCheckKeyMenuLongDown() {
        HandlerTimer handlerTimer = this.mHandlerTimer;
        if (handlerTimer != null) {
            handlerTimer.stopTimer(1);
        }
    }

    private void checkKeyCombinationLongDown() {
        CGLog.i("KeyCombination checkKeyCombinationLongDown");
        HandlerTimer handlerTimer = this.mHandlerTimer;
        if (handlerTimer != null) {
            handlerTimer.startTimer(3, 100);
        }
    }

    private void checkKeyMenuLongDown() {
        HandlerTimer handlerTimer = this.mHandlerTimer;
        if (handlerTimer != null) {
            handlerTimer.startTimer(1, 500);
        }
    }

    public static int getKeyCode1() {
        return mKeyCode1;
    }

    public static int getKeyCode2() {
        return mKeyCode2;
    }

    private boolean handleChooseWindow(int i3) {
        int up5;
        ChooseWindowItem chooseWindowItem;
        KeyChooseWindowItem selectKeyChooseWindowItem = this.mKeyMapSceneConfig.getSelectKeyChooseWindowItem();
        boolean z16 = false;
        if (selectKeyChooseWindowItem != null) {
            switch (i3) {
                case 19:
                    up5 = selectKeyChooseWindowItem.getUp();
                    z16 = true;
                    break;
                case 20:
                    up5 = selectKeyChooseWindowItem.getDown();
                    z16 = true;
                    break;
                case 21:
                    up5 = selectKeyChooseWindowItem.getLeft();
                    z16 = true;
                    break;
                case 22:
                    up5 = selectKeyChooseWindowItem.getRight();
                    z16 = true;
                    break;
                default:
                    up5 = -1;
                    break;
            }
            if (up5 != -1 && (chooseWindowItem = this.mKeyMapSceneConfig.getChooseWindowItem(up5)) != null && !chooseWindowItem.getIsHide()) {
                this.mKeyMapSceneConfig.updateSelectKeyChooseWindowItem(up5);
            }
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        if (r0 != 12) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int handleKeyDownEvent(int i3, int i16) {
        int i17;
        KeyMapSceneConfig keyMapSceneConfig = this.mKeyMapSceneConfig;
        if (keyMapSceneConfig != null && keyMapSceneConfig.getConfigSize(4) > 0) {
            if (isFireKey(i16)) {
                this.mGamepadController.onFireKeyEventOnChooseWindow(i16, 1);
                return 1;
            }
            if (handleChooseWindow(i16)) {
                return 1;
            }
        }
        boolean z16 = false;
        if (isFunctionKeyCode(i16)) {
            i17 = handleFunctionKeyDown(i3, i16);
            if (i16 == 25) {
                return 0;
            }
        } else {
            i17 = 0;
        }
        int keyMapMode = this.mGamepadController.getKeyMapMode();
        if (keyMapMode != 1) {
            if (keyMapMode != 2) {
                if (keyMapMode != 3 && keyMapMode != 8) {
                    if (keyMapMode == 11) {
                        KeyMapSceneConfig keyMapSceneConfig2 = this.mKeyMapSceneConfig;
                        if (keyMapSceneConfig2 != null && keyMapSceneConfig2.getMapType() == 2 && InputUtils.isDpadKeyCode(i16) && (!this.mKeyMapSceneConfig.hasJoystickLConfig() ? !(!this.mKeyMapSceneConfig.hasJoystickRConfig() || !handleTVDpadToJoystickR(i16, 1)) : handleTVDpadToJoystickL(i16, 1))) {
                            i17 = 1;
                            z16 = true;
                        }
                        if (!z16 && handleMapModeKeyDown(i16) == 1) {
                            return 1;
                        }
                    }
                } else {
                    if (isFireKey(i16)) {
                        this.mGamepadController.onFireKeyEvent(i16, 1);
                        return 1;
                    }
                    if (InputUtils.isDpadKeyCode(i16) && handleTVDpadToJoystickL(i16, 1)) {
                        return 1;
                    }
                }
            } else {
                CGLog.i("not support edit mode!");
            }
            return i17;
        }
        if (handleMapModeKeyDown(i16) == 1) {
            return 1;
        }
        return i17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r3 != 12) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int handleKeyUpEvent(int i3, int i16) {
        int i17;
        KeyMapSceneConfig keyMapSceneConfig = this.mKeyMapSceneConfig;
        if (keyMapSceneConfig != null && keyMapSceneConfig.getConfigSize(4) > 0 && isFireKey(i16)) {
            this.mGamepadController.onFireKeyEventOnChooseWindow(i16, 2);
            return 1;
        }
        boolean z16 = false;
        if (isFunctionKeyCode(i16)) {
            i17 = handleFunctionKeyUp(i16);
        } else {
            i17 = 0;
        }
        int keyMapMode = this.mGamepadController.getKeyMapMode();
        if (keyMapMode != 1) {
            if (keyMapMode != 3 && keyMapMode != 8) {
                if (keyMapMode == 11) {
                    KeyMapSceneConfig keyMapSceneConfig2 = this.mKeyMapSceneConfig;
                    if (keyMapSceneConfig2 != null && keyMapSceneConfig2.getMapType() == 2 && InputUtils.isDpadKeyCode(i16) && (!this.mKeyMapSceneConfig.hasJoystickLConfig() ? !(!this.mKeyMapSceneConfig.hasJoystickRConfig() || !handleTVDpadToJoystickR(i16, 2)) : handleTVDpadToJoystickL(i16, 2))) {
                        i17 = 1;
                        z16 = true;
                    }
                    if (!z16 && handleMapModeKeyUp(i16) == 1) {
                        return 1;
                    }
                }
            } else {
                if (isFireKey(i16)) {
                    this.mGamepadController.onFireKeyEvent(i16, 2);
                    return 1;
                }
                if (InputUtils.isDpadKeyCode(i16) && handleTVDpadToJoystickL(i16, 2)) {
                    return 1;
                }
            }
            return i17;
        }
        if (handleMapModeKeyUp(i16) == 1) {
            return 1;
        }
        return i17;
    }

    private int handleMapModeKeyDown(int i3) {
        KeyMapSceneConfig currentSceneConfig = KeyMapConfigManager.getInstance().getCurrentSceneConfig();
        this.mKeyMapSceneConfig = currentSceneConfig;
        if (currentSceneConfig == null) {
            return 0;
        }
        int i16 = this.mKeyState;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    return 0;
                }
                if (currentSceneConfig.isCombinKey(getKeyCode1(), i3)) {
                    this.mKeyState = 4;
                    setKeyCode2(i3);
                    onHitKeyMap(getKeyCode1() + i3, 0, this.mKeyMapSceneConfig.getKeyItem(2, getKeyCode1(), i3));
                } else {
                    this.mKeyState = 3;
                    setKeyCode2(i3);
                    return 0;
                }
            } else {
                if (!currentSceneConfig.isOneKey(i3)) {
                    return 0;
                }
                this.mKeyState = 1;
                Set<Integer> set = this.mOneKeyCodes;
                if (set != null) {
                    set.add(Integer.valueOf(i3));
                }
                onHitKeyMap(i3, 0, this.mKeyMapSceneConfig.getKeyItem(1, i3, 0));
            }
        } else {
            if (currentSceneConfig.hasCombinKey(i3)) {
                this.mKeyState = 2;
                setKeyCode1(i3);
                return 0;
            }
            if (!this.mKeyMapSceneConfig.isOneKey(i3)) {
                return 0;
            }
            setKeyCode1(i3);
            this.mKeyState = 1;
            Set<Integer> set2 = this.mOneKeyCodes;
            if (set2 != null) {
                set2.add(Integer.valueOf(i3));
            }
            onHitKeyMap(i3, 0, this.mKeyMapSceneConfig.getKeyItem(1, i3, 0));
        }
        return 1;
    }

    private int handleMapModeKeyUp(int i3) {
        boolean z16;
        boolean z17;
        if (this.mKeyMapSceneConfig == null) {
            return 0;
        }
        int i16 = this.mKeyState;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            return 0;
                        }
                        if (getKeyCode2() == i3) {
                            onHitKeyMap(getKeyCode1() + i3, 1, this.mKeyMapSceneConfig.getKeyItem(2, getKeyCode1(), i3));
                            setKeyCode2(0);
                            this.mKeyState = 2;
                            return 0;
                        }
                        resetKeyCode();
                        this.mKeyState = 0;
                        return 0;
                    }
                    if (getKeyCode1() == i3) {
                        resetKeyCode();
                        this.mKeyState = 0;
                        return 0;
                    }
                    if (getKeyCode2() != i3) {
                        return 0;
                    }
                    setKeyCode2(0);
                    this.mKeyState = 2;
                    return 0;
                }
                if (getKeyCode1() == i3) {
                    onHitKeyMap(i3, 1, this.mKeyMapSceneConfig.getKeyItem(1, i3, 0));
                    resetKeyCode();
                    this.mKeyState = 0;
                } else {
                    if (getKeyCode2() == i3) {
                        setKeyCode2(0);
                        this.mKeyState = 2;
                        return 0;
                    }
                    resetKeyCode();
                    this.mKeyState = 0;
                    return 0;
                }
            } else {
                if (getKeyCode1() == i3) {
                    resetKeyCode();
                    z16 = true;
                } else {
                    z16 = false;
                }
                Set<Integer> set = this.mOneKeyCodes;
                if (set != null && set.contains(Integer.valueOf(i3))) {
                    this.mOneKeyCodes.remove(Integer.valueOf(i3));
                    if (!this.mOneKeyCodes.isEmpty()) {
                        z17 = false;
                        z16 = true;
                    } else {
                        z16 = true;
                        z17 = true;
                    }
                } else {
                    z17 = true;
                }
                if (!z16) {
                    return 0;
                }
                onHitKeyMap(i3, 1, this.mKeyMapSceneConfig.getKeyItem(1, i3, 0));
                if (z17) {
                    this.mKeyState = 0;
                }
            }
            return 1;
        }
        resetKeyCode();
        this.mKeyState = 0;
        return 0;
    }

    private boolean handleTVDpadToJoystickL(int i3, int i16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController == null) {
            return false;
        }
        if (i16 == 1) {
            switch (i3) {
                case 19:
                    gamepadController.onJoystickLState(2, GlobalConfig.TVJoystickAxisCenter, -GlobalConfig.TVJoystickAxis);
                    break;
                case 20:
                    gamepadController.onJoystickLState(2, GlobalConfig.TVJoystickAxisCenter, GlobalConfig.TVJoystickAxis);
                    break;
                case 21:
                    gamepadController.onJoystickLState(1, -GlobalConfig.TVJoystickAxis, GlobalConfig.TVJoystickAxisCenter);
                    break;
                case 22:
                    gamepadController.onJoystickLState(1, GlobalConfig.TVJoystickAxis, GlobalConfig.TVJoystickAxisCenter);
                    break;
                default:
                    switch (i3) {
                        case 268:
                            float f16 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickLState(3, -f16, -f16);
                            break;
                        case 269:
                            float f17 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickLState(3, -f17, f17);
                            break;
                        case 270:
                            float f18 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickLState(3, f18, -f18);
                            break;
                        case 271:
                            float f19 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickLState(3, f19, f19);
                            break;
                    }
            }
            HandlerTimer handlerTimer = this.mHandlerTimer;
            if (handlerTimer != null) {
                handlerTimer.startTimer(2, 200);
            }
        } else {
            if (gamepadController != null) {
                gamepadController.onJoystickLUp();
            }
            HandlerTimer handlerTimer2 = this.mHandlerTimer;
            if (handlerTimer2 != null) {
                handlerTimer2.stopTimer(2);
            }
            GlobalConfig.TVJoystickAxis = 0.5f;
        }
        return true;
    }

    private boolean handleTVDpadToJoystickR(int i3, int i16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController == null) {
            return false;
        }
        if (i16 == 1) {
            switch (i3) {
                case 19:
                    gamepadController.onJoystickRState(2, GlobalConfig.TVJoystickAxisCenter, -GlobalConfig.TVJoystickAxis);
                    break;
                case 20:
                    gamepadController.onJoystickRState(2, GlobalConfig.TVJoystickAxisCenter, GlobalConfig.TVJoystickAxis);
                    break;
                case 21:
                    gamepadController.onJoystickRState(1, -GlobalConfig.TVJoystickAxis, GlobalConfig.TVJoystickAxisCenter);
                    break;
                case 22:
                    gamepadController.onJoystickRState(1, GlobalConfig.TVJoystickAxis, GlobalConfig.TVJoystickAxisCenter);
                    break;
                default:
                    switch (i3) {
                        case 268:
                            float f16 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickRState(3, -f16, -f16);
                            break;
                        case 269:
                            float f17 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickRState(3, -f17, f17);
                            break;
                        case 270:
                            float f18 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickRState(3, f18, -f18);
                            break;
                        case 271:
                            float f19 = GlobalConfig.TVJoystickAxis;
                            gamepadController.onJoystickRState(3, f19, f19);
                            break;
                    }
            }
        } else if (gamepadController != null) {
            gamepadController.onJoystickRUp();
        }
        return true;
    }

    private static boolean isFireKey(int i3) {
        if (i3 != 23 && i3 != 96) {
            return false;
        }
        return true;
    }

    private boolean isFunctionKeyCode(int i3) {
        if (i3 != 4 && i3 != 7 && i3 != 23 && i3 != 25 && i3 != 97) {
            switch (i3) {
                case 106:
                case 107:
                case 108:
                    break;
                default:
                    if (mKeyCombination == i3) {
                        return true;
                    }
                    return false;
            }
        }
        return true;
    }

    public static boolean isKeyCodeContinue(int i3) {
        if (i3 == 7 || i3 == 23 || i3 == 82 || i3 == 96 || i3 == 97) {
            return true;
        }
        switch (i3) {
            case 106:
            case 107:
            case 108:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(int i3) {
        CGLog.i("timer id = " + i3);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    onKeyCombination();
                }
            } else {
                GlobalConfig.TVJoystickAxis = 1.0f;
            }
        } else {
            onKeyMapMenu();
        }
        return true;
    }

    private void onKeyCombination() {
        CGLog.i("KeyCombination onKeyCombination");
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null && gamepadController.getKeyMapMode() == 1) {
            this.mGamepadController.setKeyMapMode(12, 12);
        }
    }

    private void onKeyMapMenu() {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.setKeyMapMode(4, 11);
        }
    }

    public static void resetKeyCode() {
        mKeyCode1 = -1;
        mKeyCode2 = -1;
    }

    public static void setKeyCode1(int i3) {
        mKeyCode1 = i3;
    }

    public static void setKeyCode2(int i3) {
        mKeyCode2 = i3;
    }

    public void clearKeyMapConfig() {
        this.mKeyMapSceneConfig = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int handleFunctionKeyDown(int i3, int i16) {
        int i17;
        if (i16 != 4) {
            if (i16 != 23) {
                if (i16 != 25) {
                    if (i16 != 97) {
                        switch (i16) {
                            case 106:
                                break;
                            case 107:
                                CGLog.i("switch key mapping mode");
                                if (this.mGamepadController != null) {
                                    if (InputUtils.isMFGamepadDevice(InputUtils.getDeviceVendorId(i3), InputUtils.getDeviceProductId(i3))) {
                                        this.mGamepadController.setKeyMapMode(7, 3);
                                        break;
                                    } else {
                                        this.mGamepadController.setKeyMapMode(7, 3);
                                        break;
                                    }
                                }
                                break;
                            case 108:
                                checkKeyMenuLongDown();
                                break;
                            default:
                                i17 = 0;
                                break;
                        }
                        if (i16 != mKeyCombination) {
                            checkKeyCombinationLongDown();
                            return 1;
                        }
                        return i17;
                    }
                } else {
                    this.mGamepadController.setKeyMapMode(10, 4);
                }
            } else {
                checkKeyMenuLongDown();
            }
        }
        i17 = 1;
        if (i16 != mKeyCombination) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int handleFunctionKeyUp(int i3) {
        int i16;
        if (i3 != 4) {
            if (i3 != 7) {
                if (i3 != 23) {
                    if (i3 != 97) {
                        if (i3 != 108) {
                            i16 = 0;
                            if (i3 != mKeyCombination) {
                                cancelCheckKeyCombinationLongDown();
                                return 1;
                            }
                            return i16;
                        }
                    }
                }
                cancelCheckKeyMenuLongDown();
            } else {
                onKeyMapMenu();
            }
        }
        i16 = 1;
        if (i3 != mKeyCombination) {
        }
    }

    public int handleHidKeyEvent(HIDKeyEvent hIDKeyEvent) {
        int action = hIDKeyEvent.getAction();
        int keyCode = hIDKeyEvent.getKeyCode();
        if (action == 0) {
            return handleKeyDownEvent(-1, keyCode);
        }
        if (1 == action) {
            return handleKeyUpEvent(-1, keyCode);
        }
        return 0;
    }

    public int handleKeyEvent(int i3, int i16, int i17) {
        if (i16 == 0) {
            return handleKeyDownEvent(i3, i17);
        }
        if (i16 == 1) {
            return handleKeyUpEvent(i3, i17);
        }
        return 0;
    }

    public void initKeyNameArray() {
        SparseArray<ButtonKey> sparseArray = mButtonKeyNameArray;
        if (sparseArray == null) {
            return;
        }
        sparseArray.put(96, new ButtonKey(96, "KEY_A", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS));
        mButtonKeyNameArray.put(97, new ButtonKey(97, "KEY_B", "B"));
        mButtonKeyNameArray.put(99, new ButtonKey(99, "KEY_X", "X"));
        mButtonKeyNameArray.put(100, new ButtonKey(100, "KEY_Y", "Y"));
        mButtonKeyNameArray.put(102, new ButtonKey(102, "KEY_L1", "LB"));
        mButtonKeyNameArray.put(104, new ButtonKey(104, "KEY_L2", "LT"));
        mButtonKeyNameArray.put(103, new ButtonKey(103, "KEY_R1", "RB"));
        mButtonKeyNameArray.put(105, new ButtonKey(105, "KEY_R2", "RT"));
        mButtonKeyNameArray.put(21, new ButtonKey(21, "DPAD_LEFT", "LEFT"));
        mButtonKeyNameArray.put(22, new ButtonKey(22, "DPAD_RIGHT", "RIGHT"));
        mButtonKeyNameArray.put(20, new ButtonKey(20, "DPAD_DOWN", "DOWN"));
        mButtonKeyNameArray.put(19, new ButtonKey(19, "DPAD_UP", "UP"));
        mButtonKeyNameArray.put(269, new ButtonKey(269, "DPAD_DOWN_LEFT", "DOWN_LEFT"));
        mButtonKeyNameArray.put(271, new ButtonKey(271, "DPAD_DOWN_RIGHT", "DOWN_RIGHT"));
        mButtonKeyNameArray.put(268, new ButtonKey(268, "DPAD_UP_LEFT", "UP_LEFT"));
        mButtonKeyNameArray.put(270, new ButtonKey(270, "DPAD_UP_RIGHT", "UP_RIGHT"));
        mButtonKeyNameArray.put(4, new ButtonKey(4, "KEY_BACK", "BACK"));
        mButtonKeyNameArray.put(108, new ButtonKey(108, "KEY_START", "START"));
        mButtonKeyNameArray.put(109, new ButtonKey(109, "KEY_SELECT", "SELECT"));
    }

    public void onHitKeyMap(int i3, int i16, KeyMapKeyItem keyMapKeyItem) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onHitKeyMap(i16, keyMapKeyItem);
            SparseArray<KeyMapKeyItem> sparseArray = this.mKeyEventItems;
            if (sparseArray != null) {
                if (i16 == 0) {
                    sparseArray.put(i3, keyMapKeyItem);
                } else if (i16 == 1) {
                    sparseArray.remove(i3);
                }
            }
        }
    }

    public void resetKeyEvent() {
        try {
            try {
                this.mKeyLock.lock();
                SparseArray<KeyMapKeyItem> sparseArray = this.mKeyEventItems;
                if (sparseArray != null) {
                    int size = sparseArray.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        onHitKeyMap(this.mKeyEventItems.keyAt(i3), 1, this.mKeyEventItems.valueAt(i3));
                    }
                    this.mKeyEventItems.clear();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.mKeyLock.unlock();
        }
    }

    public void updateKeyMapConfigState() {
        this.mKeyMapSceneConfig = KeyMapConfigManager.getInstance().getCurrentSceneConfig();
    }
}
