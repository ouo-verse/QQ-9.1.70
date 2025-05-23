package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.gamematrix.gmcg.base.helper.CGBaseHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.sdk.impl.CGTVPlaySessionImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.GameController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapListener;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVPlaySession;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.JoyPadItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.KeyItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.MoveItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDGamepadPerf;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDInputEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDKeyEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDMotionEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.GlobalConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.JoyKeyCancelItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyChooseWindowItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapConfigManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapKeyItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapSceneConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.TVKeyMapMsg;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.InputUtils;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.Misc;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GamepadController implements TVKeyMapMsg.IKeyMapConfigRespListener, IGamepadHidEvent {
    private static final int CLOSE_SOURCE_ID = 513;
    private static final int DIRECTION_CENTER = 5;
    private static final int DIRECTION_DOWN = 4;
    private static final int DIRECTION_LEFT = 1;
    private static final int DIRECTION_NONE = 0;
    private static final int DIRECTION_RIGHT = 3;
    private static final int DIRECTION_UP = 2;
    private static final int GAME_KEY_STATE_KEY_JOY_PRESSED = 3;
    private static final int GAME_KEY_STATE_NONE = 0;
    private static final int GAME_KEY_STATE_ONLY_JOY_PRESSED = 2;
    private static final int GAME_KEY_STATE_ONLY_KEY_PRESSED = 1;
    private static final int GAME_KEY_STATE_R1_CANCEL = 5;
    private static final int GAME_KEY_STATE_TO_KEY_PRESSED = 4;
    private static final int JOYSTICKL_DELAY_MILLILS = 50;
    private static final int JOYSTICKR_DELAY_MILLILS = 100;
    private static final int JOYSTICKR_DRAG_RADIUS = 100;
    private static final int KEYMAP_STATE_DRAG_NONE = 0;
    private static final int KEYMAP_STATE_MOUSE_DRAG = 1;
    public static final int KEY_ID_JOYSTICKL = 1;
    public static final int KEY_ID_JOYSTICKR = 2;
    private static final int KEY_ID_MOUSE = 3;
    private static final int KEY_ID_TOUCHMAP = 4;
    private static final int PRESSURE_STATE_DOWN = 1;
    private static final int PRESSURE_STATE_MOVE = 2;
    private static final int PRESSURE_STATE_UP = 0;
    private static final int STATE_JOYSTICK_DIRECTION_DOWN = 2;
    private static final int STATE_JOYSTICK_DIRECTION_LEFT = 3;
    private static final int STATE_JOYSTICK_DIRECTION_NONE = 0;
    private static final int STATE_JOYSTICK_DIRECTION_RIGHT = 4;
    private static final int STATE_JOYSTICK_DIRECTION_UP = 1;
    private static final String TAG = "GamepadController";
    private static final int TV_CLIENT_CONNECTION = 2;
    private static final int TYPE_JOYSTICK_DPAD = 3;
    private static final int TYPE_JOYSTICK_L = 1;
    private static final int TYPE_JOYSTICK_NONE = 0;
    private static final int TYPE_JOYSTICK_R = 2;
    private static final int TYPE_KEY_BUTTON = 4;
    private static final int TYPE_PUBG_JOYSTICK_L = 6;
    private static final int TYPE_SGAME_JOYSTICK_R = 5;
    public static final int VG_CLIENT_GAMEPAD_CONNECTION = 1;
    private boolean mIsInLoginView;
    private IKeyMapListener mKeyMapListener;
    private float mOffsetx;
    private float mOffsety;
    private SceneCanvas mSceneCanvas;
    private View mSurfaceView;
    private ITVPlaySession mTVPlaySessionListener;
    private boolean mHasLoadConfig = false;
    private volatile boolean mIsJoystickLPress = false;
    private volatile boolean mIsJoystickInterpolation = false;
    private float mStepX = 0.0f;
    private float mStepY = 0.0f;
    private int mJoystickMoveCount = 0;
    private int mMaxJoystickInterpolationTimes = 20;
    private int mMinJoystickInterpolationTimes = 3;
    private int mJoystickInterpolationInterval = 2;
    private boolean mIsJoystickRPress = false;
    private JoyPadItem mJoystickItemL = null;
    private JoyPadItem mJoystickItemR = null;
    private int mItemViewDgree = 0;
    private boolean mJoystickLTouchRunning = false;
    private boolean mJoystickRTouchRunning = false;
    private boolean mJoystickLTouchDrag = false;
    private boolean mPointOfViewReset = false;
    private boolean mIsStartInput = false;
    private String mVirtualGamepadUrl = CGTVPlaySessionImpl.VIRTUAL_GAMEPAD_URL;
    private String mStrServerUrl = null;
    private int valueType = 3;
    private int mCurrentMoveDirection = 0;
    private int mCurrentMoveDirectionX = 0;
    private int mCurrentMoveDirectionY = 0;
    private int mPrevDirection = 0;
    private float mGamepadTouchMapCurrentPosX = 0.0f;
    private float mGamepadTouchMapCurrentPosY = 0.0f;
    private WebRTCSDK mWebRTCSDK = null;
    private int mMouseDragState = 0;
    private int mKeyMapMode = 0;
    private final MultiPointController mMultiPointController = new MultiPointController(this);
    private final KeyHandler mKeyHandler = new KeyHandler(this);
    private final JoystickHandler mJoystickHandler = new JoystickHandler(this);
    private final JoystickTouchHandler mJoystickTouchHandler = new JoystickTouchHandler(this);
    private final JoystickInputHandler mJoystickInputHandler = new JoystickInputHandler(this);
    private final GamepadJoyKeyState mGamepadJoyKeyState = new GamepadJoyKeyState(this);
    private TVInputManager mTVInputManager = TVInputManager.getInstance();
    private PointF mMouseClickPoint = new PointF();
    private PointF mMouseDiffPoint = new PointF();
    private PointF mJoystickDiffPointR = new PointF();
    private PointF mJoystickMovePointR = new PointF();
    private KeyMapConfigManager mKeyMapConfigManager = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class JoystickInputHandler extends Handler {
        private final WeakReference<GamepadController> mWeakGamepadController;

        public JoystickInputHandler(GamepadController gamepadController) {
            this.mWeakGamepadController = new WeakReference<>(gamepadController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GamepadController gamepadController = this.mWeakGamepadController.get();
            if (gamepadController != null && message.what == 1 && gamepadController.mIsJoystickLPress && gamepadController.mIsJoystickInterpolation && message.arg1 < gamepadController.mMaxJoystickInterpolationTimes) {
                gamepadController.mMultiPointController.sendMultiPointEvent(gamepadController.mSurfaceView, 1, 2, gamepadController.mOffsetx + (gamepadController.mStepX * message.arg1), gamepadController.mOffsety + (gamepadController.mStepY * message.arg1));
                Message obtain = Message.obtain(this);
                obtain.what = 1;
                obtain.arg1 = message.arg1 + 1;
                obtain.arg2 = message.arg2;
                sendMessageDelayed(obtain, message.arg2);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class JoystickTouchHandler extends Handler {
        private final WeakReference<GamepadController> mWeakGamepadController;

        public JoystickTouchHandler(GamepadController gamepadController) {
            this.mWeakGamepadController = new WeakReference<>(gamepadController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            float f16;
            float f17;
            GamepadController gamepadController = this.mWeakGamepadController.get();
            if (gamepadController != null) {
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 == 2 && gamepadController.mJoystickRTouchRunning && gamepadController.mJoystickMovePointR != null && gamepadController.mJoystickDiffPointR != null) {
                        float f18 = gamepadController.mJoystickMovePointR.x;
                        float f19 = gamepadController.mJoystickMovePointR.y;
                        float f26 = f18 + gamepadController.mJoystickDiffPointR.x;
                        float f27 = f19 + gamepadController.mJoystickDiffPointR.y;
                        if (f26 < 1.0f) {
                            gamepadController.mPointOfViewReset = true;
                            f16 = 1.0f;
                        } else {
                            if (f26 > gamepadController.mSurfaceView.getWidth() - 1) {
                                f26 = gamepadController.mSurfaceView.getWidth() - 1;
                                gamepadController.mPointOfViewReset = true;
                            }
                            f16 = f26;
                        }
                        if (f27 < 1.0f) {
                            gamepadController.mPointOfViewReset = true;
                            f17 = 1.0f;
                        } else {
                            if (f27 > gamepadController.mSurfaceView.getHeight() - 1) {
                                f27 = gamepadController.mSurfaceView.getHeight() - 1;
                                gamepadController.mPointOfViewReset = true;
                            }
                            f17 = f27;
                        }
                        if (gamepadController.mPointOfViewReset) {
                            gamepadController.mMultiPointController.sendMultiPointEvent(gamepadController.mSurfaceView, 2, 1, f16, f17);
                            f16 = gamepadController.mJoystickItemR.getPercentX() * gamepadController.mSurfaceView.getWidth();
                            f17 = gamepadController.mJoystickItemR.getPercentY() * gamepadController.mSurfaceView.getHeight();
                            gamepadController.mPointOfViewReset = false;
                            gamepadController.mIsJoystickRPress = false;
                        }
                        float f28 = f16;
                        float f29 = f17;
                        gamepadController.mJoystickMovePointR.x = f28;
                        gamepadController.mJoystickMovePointR.y = f29;
                        if (!gamepadController.mIsJoystickRPress) {
                            gamepadController.mIsJoystickRPress = true;
                            gamepadController.mMultiPointController.sendMultiPointEvent(gamepadController.mSurfaceView, 2, 0, f28, f29);
                        } else {
                            gamepadController.mMultiPointController.sendMultiPointEvent(gamepadController.mSurfaceView, 2, 2, f28, f29);
                        }
                        Message obtain = Message.obtain(this);
                        obtain.what = 2;
                        obtain.arg1 = message.arg1;
                        sendMessageDelayed(obtain, message.arg1);
                    }
                } else if (gamepadController.mJoystickLTouchRunning && gamepadController.mMouseDiffPoint != null) {
                    float f36 = gamepadController.mMouseDiffPoint.x;
                    float f37 = gamepadController.mMouseDiffPoint.y;
                    if (gamepadController.mKeyMapListener != null) {
                        gamepadController.onUiMsgMouseViewFollowJoystick(f36, f37, gamepadController.mMouseClickPoint);
                        if (gamepadController.mJoystickLTouchDrag) {
                            gamepadController.mMultiPointController.sendMultiPointEvent(gamepadController.mSurfaceView, 3, 2, gamepadController.mMouseClickPoint.x, gamepadController.mMouseClickPoint.y);
                        }
                    }
                    Message obtain2 = Message.obtain(this);
                    obtain2.what = 1;
                    obtain2.arg1 = message.arg1;
                    sendMessageDelayed(obtain2, message.arg1);
                }
            }
            super.handleMessage(message);
        }
    }

    public GamepadController(Context context, ITVPlaySession iTVPlaySession) {
        this.mTVPlaySessionListener = iTVPlaySession;
    }

    private void clearKeyMapConfigState() {
        KeyHandler keyHandler = this.mKeyHandler;
        if (keyHandler != null) {
            keyHandler.clearKeyMapConfig();
        }
        KeyMapConfigManager.getInstance().clear();
        GlobalConfig.releaseGlobalConfig();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[LOOP:0: B:25:0x00ab->B:27:0x00ae, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doJoystickGameSkillDrag(int i3, float f16, float f17) {
        float f18;
        float f19;
        int i16;
        int i17;
        if (this.mSurfaceView != null && i3 != -1 && this.mJoystickItemR != null) {
            int joyKeyRadius = this.mGamepadJoyKeyState.getJoyKeyRadius();
            if (joyKeyRadius == 0 && (joyKeyRadius = this.mJoystickItemR.getRadius()) == 0) {
                joyKeyRadius = 100;
            }
            float f26 = joyKeyRadius;
            float f27 = f16 * f26;
            float f28 = f26 * f17;
            float joyKeyDownPointX = this.mGamepadJoyKeyState.getJoyKeyDownPointX();
            float joyKeyDownPointY = this.mGamepadJoyKeyState.getJoyKeyDownPointY();
            int i18 = this.mItemViewDgree;
            if (i18 == 0) {
                joyKeyDownPointX += f27;
                joyKeyDownPointY += f28;
            } else if (i18 == 90) {
                joyKeyDownPointX += -f28;
                joyKeyDownPointY += f27;
            }
            if (joyKeyDownPointX < 1.0f) {
                f18 = 1.0f;
            } else {
                if (joyKeyDownPointX >= this.mSurfaceView.getWidth()) {
                    joyKeyDownPointX = this.mSurfaceView.getWidth() - 1;
                }
                f18 = joyKeyDownPointX;
            }
            if (joyKeyDownPointY < 1.0f) {
                f19 = 1.0f;
            } else {
                if (joyKeyDownPointY >= this.mSurfaceView.getHeight()) {
                    joyKeyDownPointY = this.mSurfaceView.getHeight() - 1;
                }
                f19 = joyKeyDownPointY;
            }
            float interpolationPointX = this.mGamepadJoyKeyState.getInterpolationPointX();
            float interpolationPointY = this.mGamepadJoyKeyState.getInterpolationPointY();
            float f29 = f18 - interpolationPointX;
            int abs = ((Math.abs((int) f29) + 16) / 16) - 1;
            float f36 = f19 - interpolationPointY;
            int abs2 = ((Math.abs((int) f36) + 16) / 16) - 1;
            if (abs <= abs2) {
                abs2 = 4;
                if (abs <= 4) {
                    i16 = abs;
                    i17 = 0;
                    while (i17 < i16) {
                        float f37 = i16;
                        float f38 = i17;
                        float f39 = interpolationPointX + ((f29 / f37) * f38);
                        float f46 = interpolationPointY + ((f36 / f37) * f38);
                        this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i3, 2, f39, f46);
                        onUiMsgKeyMapTrackKey(2, i3, f39, f46);
                        i17++;
                        interpolationPointX = interpolationPointX;
                    }
                    this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i3, 2, f18, f19);
                    onUiMsgKeyMapTrackKey(2, i3, f18, f19);
                    this.mGamepadJoyKeyState.setInterpolationPoint(f18, f19);
                }
            }
            i16 = abs2;
            i17 = 0;
            while (i17 < i16) {
            }
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i3, 2, f18, f19);
            onUiMsgKeyMapTrackKey(2, i3, f18, f19);
            this.mGamepadJoyKeyState.setInterpolationPoint(f18, f19);
        }
    }

    private void doJoystickMouseControl(float f16, float f17) {
        if (this.mKeyMapListener != null) {
            PointF pointF = this.mMouseDiffPoint;
            if (pointF != null) {
                pointF.x = f16;
                pointF.y = f17;
            }
            onUiMsgMouseViewFollowJoystick(f16, f17, this.mMouseClickPoint);
            if (!this.mJoystickLTouchRunning) {
                startJoystickTouchRun(1, 50);
            }
        }
    }

    private void doJoystickMoveControl(float f16, float f17) {
        float f18;
        float f19;
        JoyPadItem joyPadItem = this.mJoystickItemL;
        if (joyPadItem != null && this.mSurfaceView != null) {
            float radius = joyPadItem.getRadius();
            int width = this.mSurfaceView.getWidth();
            int height = this.mSurfaceView.getHeight();
            float f26 = width;
            float percentX = this.mJoystickItemL.getPercentX() * f26;
            float f27 = height;
            float percentY = this.mJoystickItemL.getPercentY() * f27;
            float abs = Math.abs(f16);
            float abs2 = Math.abs(f17);
            float f28 = 1.0f;
            if (abs != 1.0f && abs2 != 1.0f) {
                f18 = f16;
                f19 = f17;
            } else {
                double sqrt = 1.0d / Math.sqrt((abs * abs) + (abs2 * abs2));
                f18 = (float) (f16 * sqrt);
                f19 = (float) (f17 * sqrt);
            }
            if (this.mJoystickItemL.getType() == 6) {
                radius *= 1.5f;
            }
            float f29 = f18 * radius;
            float f36 = radius * f19;
            if (this.mItemViewDgree == 90) {
                f29 = -f36;
                f36 = f29;
            }
            float f37 = percentX + f29;
            float f38 = percentY + f36;
            if (this.mJoystickItemL.getType() == 6 && abs < GlobalConfig.PubgSprintMoveAbsValueRangle && f19 < 0.0f) {
                f37 = f26 * GlobalConfig.PubgSprintMovePercentX;
                f38 = f27 * GlobalConfig.PubgSprintMovePercentY;
            }
            if (f37 < 1.0f) {
                f37 = 1.0f;
            } else {
                float f39 = width - 1;
                if (f37 > f39) {
                    f37 = f39;
                }
            }
            if (f38 >= 1.0f) {
                f28 = height - 1;
                if (f38 <= f28) {
                    f28 = f38;
                }
            }
            if (this.mIsJoystickLPress) {
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 1, 2, f37, f28);
                int i3 = this.mJoystickMoveCount + 1;
                this.mJoystickMoveCount = i3;
                if (i3 > this.mMinJoystickInterpolationTimes) {
                    this.mIsJoystickInterpolation = false;
                }
            } else {
                this.mIsJoystickLPress = true;
                this.mOffsetx = this.mJoystickItemL.getPercentX() * f26;
                float percentY2 = this.mJoystickItemL.getPercentY() * f27;
                this.mOffsety = percentY2;
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 1, 0, this.mOffsetx, percentY2);
                float f46 = f37 - this.mOffsetx;
                float f47 = f28 - this.mOffsety;
                float f48 = this.mMaxJoystickInterpolationTimes;
                this.mStepX = f46 / f48;
                this.mStepY = f47 / f48;
                for (int i16 = 0; i16 < 8; i16++) {
                    this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 1, 2, this.mOffsetx + this.mStepX, this.mOffsety + this.mStepY);
                }
                this.mIsJoystickInterpolation = true;
                this.mJoystickMoveCount = 0;
                Message obtain = Message.obtain(this.mJoystickInputHandler);
                obtain.what = 1;
                obtain.arg1 = 0;
                obtain.arg2 = this.mJoystickInterpolationInterval;
                this.mJoystickInputHandler.sendMessage(obtain);
            }
            onUiMsgKeyMapTrackJoy(1, 2, f37, f28);
        }
    }

    private void doJoystickPointOfView(float f16, float f17) {
        float f18;
        float f19;
        float f26;
        float f27;
        if (!this.mIsJoystickRPress) {
            this.mJoystickMovePointR.x = this.mJoystickItemR.getPercentX() * this.mSurfaceView.getWidth();
            this.mJoystickMovePointR.y = this.mJoystickItemR.getPercentY() * this.mSurfaceView.getHeight();
        }
        PointF pointF = this.mJoystickMovePointR;
        float f28 = pointF.x;
        float f29 = pointF.y;
        int i3 = GlobalConfig.JoystickViewRadiusMin;
        if (Math.abs(f16) <= GlobalConfig.AxisSensitivityLevelMax && Math.abs(f17) <= GlobalConfig.AxisSensitivityLevelMax) {
            if (Math.abs(f16) > GlobalConfig.AxisSensitivityLevelMid || Math.abs(f17) > GlobalConfig.AxisSensitivityLevelMid) {
                i3 = GlobalConfig.JoystickViewRadiusMid;
            }
        } else {
            i3 = GlobalConfig.JoystickViewRadiusMax;
        }
        if (this.mJoystickItemR.getSensitivity() != 0.0f) {
            f18 = this.mJoystickItemR.getSensitivity() * f16;
            f19 = this.mJoystickItemR.getSensitivity() * f17;
        } else {
            f18 = f16;
            f19 = f17;
        }
        float f36 = i3;
        float f37 = f18 * f36;
        float f38 = f19 * f36;
        if (this.mItemViewDgree == 90) {
            f37 = -f38;
            f38 = f37;
        }
        float f39 = f28 + f37;
        float f46 = f29 + f38;
        if (f39 < 1.0f) {
            this.mPointOfViewReset = true;
            f26 = 1.0f;
        } else {
            if (f39 > this.mSurfaceView.getWidth() - 1) {
                f39 = this.mSurfaceView.getWidth() - 1;
                this.mPointOfViewReset = true;
            }
            f26 = f39;
        }
        if (f46 < 1.0f) {
            this.mPointOfViewReset = true;
            f27 = 1.0f;
        } else {
            if (f46 > this.mSurfaceView.getHeight() - 1) {
                f46 = this.mSurfaceView.getHeight() - 1;
                this.mPointOfViewReset = true;
            }
            f27 = f46;
        }
        if (this.mPointOfViewReset) {
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 2, 1, f26, f27);
            stopJoystickTouchRun(2);
            f26 = this.mJoystickItemR.getPercentX() * this.mSurfaceView.getWidth();
            f27 = this.mJoystickItemR.getPercentY() * this.mSurfaceView.getHeight();
            this.mPointOfViewReset = false;
            this.mIsJoystickRPress = false;
        }
        PointF pointF2 = this.mJoystickMovePointR;
        pointF2.x = f26;
        pointF2.y = f27;
        PointF pointF3 = this.mJoystickDiffPointR;
        pointF3.x = f37;
        pointF3.y = f38;
        if (this.mIsJoystickRPress) {
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 2, 2, f26, f27);
            return;
        }
        this.mIsJoystickRPress = true;
        this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 2, 0, f26, f27);
        startJoystickTouchRun(2, 100);
    }

    private void doJoystickToDrive(int i3, int i16) {
        MoveItem moveItem;
        KeyMapSceneConfig currentSceneConfig = getCurrentSceneConfig();
        if (currentSceneConfig != null && this.mSurfaceView != null && this.mMultiPointController != null && (moveItem = currentSceneConfig.getMoveItem(i16)) != null) {
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, moveItem.getKeyCode(), i3, moveItem.getPercentX() * this.mSurfaceView.getWidth(), moveItem.getPercentY() * this.mSurfaceView.getHeight());
        }
    }

    private SceneCanvas forceKeyMapMode(int i3, int i16) {
        SceneCanvas createSceneCanvas = createSceneCanvas(1, this.mKeyMapMode, i16);
        if (createSceneCanvas == null) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 9) {
                if (i3 != 11) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    CGLog.i("keymap exception! mode=" + i3);
                                } else {
                                    this.mKeyMapMode = 6;
                                }
                            } else {
                                this.mKeyMapMode = 5;
                            }
                        }
                    } else if (TVInputManager.getInstance().hasMFGamepadConnected()) {
                        this.mKeyMapMode = 6;
                    } else {
                        this.mKeyMapMode = 3;
                    }
                } else {
                    this.mKeyMapMode = 11;
                }
            } else {
                this.mKeyMapMode = 9;
            }
        } else {
            this.mKeyMapMode = 1;
        }
        createSceneCanvas.setKeyMapMode(this.mKeyMapMode);
        createSceneCanvas.setSceneConfig(null);
        return createSceneCanvas;
    }

    private SceneCanvas handleKeyMapGamepadSwitchMode(int i3) {
        SceneCanvas createSceneCanvas = createSceneCanvas(1, this.mKeyMapMode, i3);
        KeyMapSceneConfig keyMapSceneConfig = null;
        if (createSceneCanvas == null) {
            return null;
        }
        if (GlobalConfig.getInstance().isSendNativeEventToGame()) {
            switchNativeGameKeyMapMode();
        } else {
            switchTouchScreenGameKeyMapMode(createSceneCanvas);
        }
        createSceneCanvas.setKeyMapMode(this.mKeyMapMode);
        KeyMapConfigManager keyMapConfigManager = this.mKeyMapConfigManager;
        if (keyMapConfigManager != null) {
            keyMapSceneConfig = keyMapConfigManager.getCurrentSceneConfig();
        }
        createSceneCanvas.setSceneConfig(keyMapSceneConfig);
        return createSceneCanvas;
    }

    private SceneCanvas handleKeyMapSwitchKeyCombinationMode(int i3) {
        SceneCanvas createSceneCanvas = createSceneCanvas(1, this.mKeyMapMode, 12);
        if (createSceneCanvas != null && this.mKeyMapConfigManager != null) {
            if (this.mKeyMapMode != i3) {
                createSceneCanvas.setModeChanged(true);
            }
            if (i3 == 1) {
                this.mKeyMapMode = 1;
                if (this.mKeyMapConfigManager.restoreCombinationRestoreConfig()) {
                    createSceneCanvas.setLayoutChanged(true);
                }
            } else if (i3 == 12) {
                this.mKeyMapMode = 12;
                if (this.mKeyMapConfigManager.loadKeyCombination()) {
                    createSceneCanvas.setLayoutChanged(true);
                }
            }
            CGLog.i("onkeymap KeyCombination mode: " + this.mKeyMapMode);
            createSceneCanvas.setKeyMapMode(this.mKeyMapMode);
            createSceneCanvas.setSceneConfig(this.mKeyMapConfigManager.getCurrentSceneConfig());
            return createSceneCanvas;
        }
        return null;
    }

    private SceneCanvas handleKeyMapTVSwitchMode(int i3) {
        SceneCanvas createSceneCanvas = createSceneCanvas(1, this.mKeyMapMode, i3);
        if (createSceneCanvas == null) {
            return swapSceneCanvas(null);
        }
        int i16 = this.mKeyMapMode;
        if (3 != i16 && 8 != i16) {
            if (1 != i16 && 11 != i16) {
                if (6 == i16 || 9 == i16 || 5 == i16) {
                    this.mKeyMapMode = 8;
                }
            } else {
                KeyMapConfigManager keyMapConfigManager = this.mKeyMapConfigManager;
                if (keyMapConfigManager != null && keyMapConfigManager.loadTVControllerConfig()) {
                    this.mKeyMapMode = 11;
                    createSceneCanvas.setLayoutChanged(true);
                } else {
                    this.mKeyMapMode = 8;
                    CGLog.d("load tv controller config failed!");
                }
            }
        } else {
            this.mKeyMapMode = 11;
            if (!GlobalConfig.getInstance().isGamepadGameType() && !GlobalConfig.getInstance().isTVControllerGameType()) {
                KeyMapConfigManager keyMapConfigManager2 = this.mKeyMapConfigManager;
                if (keyMapConfigManager2 != null && keyMapConfigManager2.loadTVControllerConfig()) {
                    createSceneCanvas.setLayoutChanged(true);
                } else {
                    this.mKeyMapMode = 8;
                }
            } else {
                this.mKeyMapMode = 5;
            }
        }
        createSceneCanvas.setKeyMapMode(this.mKeyMapMode);
        createSceneCanvas.setSceneConfig(KeyMapConfigManager.getInstance().getCurrentSceneConfig());
        return createSceneCanvas;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgChooseItemClicked$0() {
        IKeyMapListener iKeyMapListener = this.mKeyMapListener;
        if (iKeyMapListener != null) {
            iKeyMapListener.onChooseItemClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgKeyMapModeChanged$5(SceneCanvas sceneCanvas) {
        IKeyMapListener iKeyMapListener = this.mKeyMapListener;
        if (iKeyMapListener != null) {
            iKeyMapListener.onKeyMapModeChanged(sceneCanvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgKeyMapTrackJoy$4(int i3, int i16, float f16, float f17) {
        IKeyMapListener iKeyMapListener = this.mKeyMapListener;
        if (iKeyMapListener != null) {
            iKeyMapListener.onKeyMapTrackJoy(i3, i16, f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgKeyMapTrackKey$2(int i3, int i16, float f16, float f17) {
        if (this.mKeyMapListener != null && this.mGamepadJoyKeyState.getJoyKeyID() != -1) {
            this.mKeyMapListener.onKeyMapTrackKey(i3, i16, f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgKeyMapTrackKey$3(int i3, KeyItem keyItem, float f16, float f17) {
        if (this.mKeyMapListener != null && this.mGamepadJoyKeyState.getJoyKeyID() != -1) {
            this.mKeyMapListener.onKeyMapTrackKey(i3, keyItem, f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgKeyMapTrigger$1(int i3, KeyItem keyItem) {
        IKeyMapListener iKeyMapListener = this.mKeyMapListener;
        if (iKeyMapListener != null) {
            iKeyMapListener.onKeyMapTrigger(i3, keyItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgMouseViewFollowJoystick$6(float f16, float f17, PointF pointF) {
        IKeyMapListener iKeyMapListener = this.mKeyMapListener;
        if (iKeyMapListener != null) {
            iKeyMapListener.onMouseViewFollowJoystick(f16, f17, pointF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgVirtualGamepadMessage$7(int i3, int i16, String str) {
        this.mKeyMapListener.onVirtualGamepadMessage(i3, i16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiMsgVirtualGamepadMessage$8(int i3, int i16, int i17, int i18) {
        this.mKeyMapListener.onVirtualGamepadMessage(i3, i16, i17, i18);
    }

    private int nextTouchScreenKeyMap(SceneCanvas sceneCanvas) {
        int i3;
        boolean hasMFGamepadConnected = TVInputManager.getInstance().hasMFGamepadConnected();
        int i16 = this.mKeyMapMode;
        boolean z16 = true;
        if (1 != i16 && 11 != i16) {
            if (TVInputManager.getInstance().hasMFGamepadConnected()) {
                this.mKeyMapMode = 6;
            } else {
                this.mKeyMapMode = 3;
            }
        } else if (isSupportTGPAConfig()) {
            if (hasMFGamepadConnected) {
                this.mKeyMapMode = 6;
            } else {
                this.mKeyMapMode = 3;
            }
        } else {
            if (hasMFGamepadConnected) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            KeyMapConfigManager keyMapConfigManager = this.mKeyMapConfigManager;
            if (keyMapConfigManager == null || !keyMapConfigManager.loadNextSceneConfig(i3)) {
                z16 = false;
            }
            if (!z16) {
                if (hasMFGamepadConnected) {
                    this.mKeyMapMode = 6;
                } else {
                    this.mKeyMapMode = 3;
                }
            }
        }
        return this.mKeyMapMode;
    }

    private void onJoystickMoveToDrive(float f16, float f17) {
        int i3;
        int i16;
        if (f16 >= 0.6f) {
            i3 = 4;
        } else if (f16 <= -0.6f) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        if (f17 >= 0.1f) {
            i16 = 2;
        } else if (f17 <= -0.4f) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int i17 = this.mCurrentMoveDirectionX;
        if (i3 != i17) {
            if (i17 != 0) {
                doJoystickToDrive(1, i17);
            }
            if (i3 != 0) {
                doJoystickToDrive(0, i3);
            }
            this.mCurrentMoveDirectionX = i3;
        }
        int i18 = this.mCurrentMoveDirectionY;
        if (i16 != i18) {
            if (i18 != 0) {
                doJoystickToDrive(1, i18);
            }
            if (i16 != 0) {
                doJoystickToDrive(0, i16);
            }
            this.mCurrentMoveDirectionY = i16;
        }
    }

    private void onJoystickUpToDrive() {
        int i3 = this.mCurrentMoveDirectionX;
        if (i3 != 0) {
            doJoystickToDrive(1, i3);
            this.mCurrentMoveDirectionX = 0;
        }
        int i16 = this.mCurrentMoveDirectionY;
        if (i16 != 0) {
            doJoystickToDrive(1, i16);
            this.mCurrentMoveDirectionY = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onPubgPointOfViewMove(KeyItem keyItem, int i3, float f16, float f17) {
        float f18;
        float f19;
        View view = this.mSurfaceView;
        if (view != null && keyItem != null && i3 != -1) {
            int width = view.getWidth();
            int height = this.mSurfaceView.getHeight();
            float percentX = keyItem.getPercentX() * width;
            float percentY = keyItem.getPercentY() * height;
            if (keyItem.getPressure() == 0) {
                keyItem.setPos(percentX, percentY);
            } else {
                PointF pos = keyItem.getPos();
                if (pos != null) {
                    percentX = pos.x;
                    percentY = pos.y;
                }
            }
            int i16 = GlobalConfig.JoystickViewRadiusMin;
            if (Math.abs(f16) <= GlobalConfig.AxisSensitivityLevelMax && Math.abs(f17) <= GlobalConfig.AxisSensitivityLevelMax) {
                if (Math.abs(f16) > GlobalConfig.AxisSensitivityLevelMid || Math.abs(f17) > GlobalConfig.AxisSensitivityLevelMid) {
                    i16 = GlobalConfig.JoystickViewRadiusMid;
                }
            } else {
                i16 = GlobalConfig.JoystickViewRadiusMax;
            }
            float sensitivity = keyItem.getSensitivity();
            float f26 = i16;
            float f27 = f16 * f26 * sensitivity;
            float f28 = f17 * f26 * sensitivity;
            if (this.mItemViewDgree == 90) {
                f27 = -f28;
                f28 = f27;
            }
            float f29 = percentX + f27;
            float f36 = percentY + f28;
            float f37 = 1.0f;
            if (f29 < 1.0f) {
                f18 = 1.0f;
            } else {
                float f38 = width - 1;
                if (f29 > f38) {
                    f18 = f38;
                } else {
                    f18 = f29;
                }
            }
            if (f36 >= 1.0f) {
                f37 = height - 1;
                if (f36 <= f37) {
                    f19 = f36;
                    keyItem.setPos(f18, f19);
                    if (keyItem.getPressure() == 0) {
                        this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i3, 2, f18, f19);
                        return;
                    } else {
                        keyItem.setPressure(1);
                        this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i3, 0, f18, f19);
                        return;
                    }
                }
            }
            f19 = f37;
            keyItem.setPos(f18, f19);
            if (keyItem.getPressure() == 0) {
            }
        }
    }

    private void onPubgPointOfViewUp(KeyItem keyItem, int i3) {
        float f16;
        float f17;
        if (this.mSurfaceView != null && keyItem != null && i3 != -1 && keyItem.getPressure() != 0) {
            PointF pos = keyItem.getPos();
            if (pos != null) {
                float f18 = pos.x;
                f17 = pos.y;
                f16 = f18;
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
            }
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i3, 1, f16, f17);
            keyItem.setPressure(0);
        }
    }

    private void sgameCancelSpellCasting(boolean z16) {
        View view;
        JoyKeyCancelItem joyKeyCancelItem;
        int i3;
        if (GlobalConfig.kSGameSkillCancelPos != null && (view = this.mSurfaceView) != null) {
            int width = view.getWidth();
            int height = this.mSurfaceView.getHeight();
            int joyKeyID = this.mGamepadJoyKeyState.getJoyKeyID();
            if (!z16) {
                int joyKeyType = this.mGamepadJoyKeyState.getJoyKeyType();
                if (getCurrentSceneConfig() != null && (joyKeyCancelItem = getCurrentSceneConfig().getJoyKeyCancelItem(joyKeyType)) != null) {
                    List<PointF> list = joyKeyCancelItem.mPos;
                    if (list != null && list.size() >= 2) {
                        for (PointF pointF : joyKeyCancelItem.mPos) {
                            float f16 = width * pointF.x;
                            float f17 = height * pointF.y;
                            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, joyKeyID, 2, f16, f17);
                            this.mGamepadJoyKeyState.setJoyKeyUpPoint(f16, f17);
                        }
                        this.mGamepadJoyKeyState.setJoyKeyState(5);
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("exception! config size=");
                    List<PointF> list2 = joyKeyCancelItem.mPos;
                    if (list2 != null) {
                        i3 = list2.size();
                    } else {
                        i3 = -1;
                    }
                    sb5.append(i3);
                    Log.d("joykey", sb5.toString());
                    return;
                }
                PointF pointF2 = GlobalConfig.kSGameSkillCancelPos;
                float f18 = width * pointF2.x;
                float f19 = pointF2.y * height;
                this.mGamepadJoyKeyState.setJoyKeyUpPoint(f18, f19);
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, joyKeyID, 2, f18, f19);
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, joyKeyID, 2, f18 + 5.0f, f19 + 5.0f);
                this.mGamepadJoyKeyState.setJoyKeyState(5);
                return;
            }
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, joyKeyID, 1, this.mGamepadJoyKeyState.getJoyKeyUpPointX(), this.mGamepadJoyKeyState.getJoyKeyUpPointY());
            this.mGamepadJoyKeyState.setJoyKeyState(0);
        }
    }

    private void startJoystickTouchRun(int i3, int i16) {
        if (1 == i3) {
            if (this.mJoystickLTouchRunning) {
                return;
            } else {
                this.mJoystickLTouchRunning = true;
            }
        } else if (2 == i3) {
            if (this.mJoystickRTouchRunning) {
                return;
            } else {
                this.mJoystickRTouchRunning = true;
            }
        }
        Message obtain = Message.obtain(this.mJoystickTouchHandler);
        obtain.what = i3;
        obtain.arg1 = i16;
        this.mJoystickTouchHandler.sendMessage(obtain);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        if (r0 != 8) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int switchNativeGameKeyMapMode() {
        int i3 = this.mKeyMapMode;
        if (i3 != 3) {
            if (i3 == 5) {
                if (TVInputManager.getInstance().hasMFGamepadConnected()) {
                    this.mKeyMapMode = 5;
                } else {
                    this.mKeyMapMode = 3;
                }
            }
            return this.mKeyMapMode;
        }
        this.mKeyMapMode = 5;
        return this.mKeyMapMode;
    }

    private int switchTouchScreenGameKeyMapMode(SceneCanvas sceneCanvas) {
        int i3 = this.mKeyMapMode;
        if (i3 != 1 && i3 != 11) {
            toTouchScreenKeyMap(sceneCanvas);
        } else {
            nextTouchScreenKeyMap(sceneCanvas);
        }
        return this.mKeyMapMode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int toTouchScreenKeyMap(SceneCanvas sceneCanvas) {
        boolean z16;
        if (this.mKeyMapConfigManager == null) {
            return this.mKeyMapMode;
        }
        int i3 = this.mKeyMapMode;
        int i16 = 3;
        if (i3 == 3 || i3 == 5 || i3 == 6 || i3 == 8 || i3 == 9) {
            boolean hasMFGamepadConnected = TVInputManager.getInstance().hasMFGamepadConnected();
            if (GlobalConfig.getInstance().isSupportTGPA()) {
                if (!hasMFGamepadConnected) {
                    i16 = 1;
                }
                z16 = this.mKeyMapConfigManager.loadTGPAPrimaryScene(i16);
            } else {
                z16 = hasMFGamepadConnected ? false : false;
            }
            if (z16) {
                this.mKeyMapMode = 1;
            }
        }
        return this.mKeyMapMode;
    }

    private void updateKeyMapConfigState() {
        KeyMapConfigManager keyMapConfigManager = this.mKeyMapConfigManager;
        if (keyMapConfigManager == null) {
            return;
        }
        KeyMapSceneConfig currentSceneConfig = keyMapConfigManager.getCurrentSceneConfig();
        if (currentSceneConfig != null) {
            for (int i3 = 0; i3 < currentSceneConfig.getConfigSize(1); i3++) {
                JoyPadItem joyPadItem = currentSceneConfig.getJoyPadItem(i3);
                if (joyPadItem != null) {
                    int type = joyPadItem.getType();
                    if (type != 1) {
                        if (type != 2 && type != 5) {
                            if (type != 6) {
                            }
                        } else {
                            this.mJoystickItemR = joyPadItem;
                            PointF pointF = this.mJoystickMovePointR;
                            if (pointF != null) {
                                pointF.x = 0.0f;
                                pointF.y = 0.0f;
                            }
                            PointF pointF2 = this.mJoystickDiffPointR;
                            if (pointF2 != null) {
                                pointF2.x = 0.0f;
                                pointF2.y = 0.0f;
                            }
                        }
                    }
                    this.mJoystickItemL = joyPadItem;
                }
            }
        }
        KeyHandler keyHandler = this.mKeyHandler;
        if (keyHandler != null) {
            keyHandler.updateKeyMapConfigState();
        }
    }

    public void checkAndOpenMFGamepad() {
        TVInputManager tVInputManager;
        if (!GlobalConfig.IsOpenMFGamepad && GlobalConfig.getInstance().isUseGamepadPrivateEvent() && (tVInputManager = this.mTVInputManager) != null) {
            GlobalConfig.IsOpenMFGamepad = true;
            tVInputManager.setGamepadController(this);
            this.mTVInputManager.checkAndOpenMFGamepad();
        }
    }

    public void clearGamepadControllerState() {
        stopJoystickTouchRun(1);
        stopJoystickTouchRun(2);
        this.mMouseDragState = 0;
        this.mHasLoadConfig = false;
        this.mKeyMapMode = 0;
        this.mJoystickItemL = null;
        this.mJoystickItemR = null;
        this.mMouseDiffPoint = null;
        clearKeyMapConfigState();
        this.mSurfaceView = null;
        this.mStrServerUrl = null;
    }

    public void closeMFGamepad() {
        TVInputManager tVInputManager;
        if (GlobalConfig.IsOpenMFGamepad && (tVInputManager = this.mTVInputManager) != null) {
            tVInputManager.setGamepadController(null);
            this.mTVInputManager.closeMFGamepad();
            GlobalConfig.IsOpenMFGamepad = false;
        }
    }

    SceneCanvas createSceneCanvas(int i3, int i16, int i17) {
        SceneCanvas sceneCanvas = new SceneCanvas(i3, i16);
        sceneCanvas.setKeyMapSource(i17);
        sceneCanvas.setKeyMapType(i16);
        int gameType = GlobalConfig.getInstance().getGameType();
        sceneCanvas.setGameType(gameType);
        if (TVInputManager.getInstance().hasMFGamepadConnected()) {
            sceneCanvas.setResourceType(2);
        } else {
            sceneCanvas.setResourceType(1);
        }
        if (gameType == 16 && !GlobalConfig.getInstance().isGameTypeMixedKeyMapEnabled()) {
            sceneCanvas.setKeyMapType(1);
        } else {
            sceneCanvas.setKeyMapType(2);
        }
        return sceneCanvas;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
    
        if (r3 != 2) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getConfigValue(int i3) {
        if (i3 == 1) {
            if (GlobalConfig.getInstance().isGamepadPerfMonitorEnable()) {
                return 1;
            }
        }
        if (GlobalConfig.getInstance().isSupportKeyTrack()) {
            return 1;
        }
        return 0;
    }

    public KeyMapSceneConfig getCurrentSceneConfig() {
        KeyMapConfigManager keyMapConfigManager = this.mKeyMapConfigManager;
        if (keyMapConfigManager != null) {
            return keyMapConfigManager.getCurrentSceneConfig();
        }
        return null;
    }

    public int getGameType() {
        return GlobalConfig.getInstance().getGameType();
    }

    public int getKeyMapMode() {
        return this.mKeyMapMode;
    }

    public int getValueType() {
        return this.valueType;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public int handleHidKeyEvent(HIDKeyEvent hIDKeyEvent) {
        HIDGamepadPerf.nKeyEvent++;
        KeyHandler keyHandler = this.mKeyHandler;
        if (keyHandler != null) {
            return keyHandler.handleHidKeyEvent(hIDKeyEvent);
        }
        return 0;
    }

    public int handleHidMotionEvent(HIDMotionEvent hIDMotionEvent) {
        HIDGamepadPerf.nKeyEvent++;
        JoystickHandler joystickHandler = this.mJoystickHandler;
        if (joystickHandler != null) {
            return joystickHandler.handleHidJoystickEvent(hIDMotionEvent);
        }
        return 0;
    }

    public boolean handleKeyEvent(boolean z16, int i3, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getDeviceId() == -1) {
            return false;
        }
        if (z16 && !KeyHandler.isKeyCodeContinue(i3)) {
            return false;
        }
        int deviceId = keyEvent.getDeviceId();
        int action = keyEvent.getAction();
        CGLog.d("GamepadControllerhandleKeyEvent deviceId: " + deviceId + " keyCode: " + i3 + " action: " + action);
        return handleKeyEvent(deviceId, action, i3) == 1;
    }

    public int handleMotionEvent(MotionEvent motionEvent) {
        if (!JoystickHandler.isJoystickDevice(motionEvent) && !JoystickHandler.isDpadDevice(motionEvent)) {
            return 0;
        }
        return this.mJoystickHandler.handleJoystickEvent(motionEvent);
    }

    public boolean isMouseMode() {
        int i3 = this.mKeyMapMode;
        if (i3 != 3 && i3 != 8) {
            return false;
        }
        return true;
    }

    public boolean isSupportMonitorConfig() {
        return GlobalConfig.getInstance().isSupportMonitor();
    }

    public boolean isSupportTGPAConfig() {
        return GlobalConfig.getInstance().isSupportTGPA();
    }

    public boolean loadGameSceneFromMonitor(int i3, String str, boolean z16) {
        if (this.mKeyMapConfigManager == null) {
            return false;
        }
        SceneCanvas createSceneCanvas = createSceneCanvas(1, 0, 7);
        if (createSceneCanvas != null && this.mKeyMapConfigManager.loadSceneConfigFromMonitor(i3, str, z16)) {
            this.mKeyMapMode = 1;
            createSceneCanvas.setKeyMapMode(1);
        }
        return loadSceneCanvasToFloatView(createSceneCanvas);
    }

    public boolean loadGameSceneFromSDKScene(int i3, boolean z16) {
        SceneCanvas createSceneCanvas = createSceneCanvas(1, 0, 8);
        if (createSceneCanvas != null) {
            createSceneCanvas.setModeChanged(true);
            if (z16) {
                if (!TVInputManager.getInstance().hasMFGamepadConnected()) {
                    this.mKeyMapMode = 3;
                    createSceneCanvas.setKeyMapMode(3);
                } else {
                    this.mKeyMapMode = 6;
                    createSceneCanvas.setKeyMapMode(6);
                }
            } else {
                KeyMapConfigManager keyMapConfigManager = this.mKeyMapConfigManager;
                if (keyMapConfigManager != null && keyMapConfigManager.loadSDKSceneConfig(i3)) {
                    this.mKeyMapMode = 1;
                    createSceneCanvas.setKeyMapMode(1);
                    createSceneCanvas.setSceneConfig(this.mKeyMapConfigManager.getCurrentSceneConfig());
                }
            }
        }
        return loadSceneCanvasToFloatView(createSceneCanvas);
    }

    public boolean loadGameSceneFromTGPA(String str) {
        if (!isSupportTGPAConfig()) {
            return false;
        }
        return loadSceneCanvasToFloatView(loadTGPASceneToCanvas(str));
    }

    public void loadLocalKeyMapConfig(Context context, String str) {
        if (!this.mHasLoadConfig) {
            this.mHasLoadConfig = true;
            KeyMapConfigManager.getInstance().loadLocalKeyMapConfig(context, str);
            updateKeyMapConfigState();
        }
    }

    boolean loadSceneCanvasToFloatView(SceneCanvas sceneCanvas) {
        swapSceneCanvas(sceneCanvas);
        onUiMsgKeyMapModeChanged(sceneCanvas);
        return true;
    }

    SceneCanvas loadTGPASceneToCanvas(String str) {
        KeyMapConfigManager keyMapConfigManager;
        SceneCanvas createSceneCanvas = createSceneCanvas(1, 1, 6);
        if (createSceneCanvas == null || (keyMapConfigManager = this.mKeyMapConfigManager) == null || !keyMapConfigManager.loadSceneConfigFromTGPA(str)) {
            return null;
        }
        this.mKeyMapMode = 1;
        createSceneCanvas.setSceneConfig(this.mKeyMapConfigManager.getCurrentSceneConfig());
        return createSceneCanvas;
    }

    public void onFireKeyEvent(int i3, int i16) {
        PointF pointF = this.mMouseClickPoint;
        if (pointF != null) {
            float f16 = pointF.x;
            float f17 = pointF.y;
            IKeyMapListener iKeyMapListener = this.mKeyMapListener;
            if (iKeyMapListener != null && iKeyMapListener.getMouseViewPos(pointF)) {
                PointF pointF2 = this.mMouseClickPoint;
                f16 = pointF2.x;
                f17 = pointF2.y;
            }
            float f18 = f16;
            float f19 = f17;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        this.mMultiPointController.onUserMouseClick(this.mSurfaceView, i3, f18, f19);
                        return;
                    }
                    return;
                } else {
                    if (3 == this.mKeyMapMode) {
                        this.mMouseDragState = 0;
                        this.mJoystickLTouchDrag = false;
                    }
                    this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 3, 1, f18, f19);
                    return;
                }
            }
            if (!this.mMultiPointController.hasKeyAciton(3, 2) && !this.mMultiPointController.hasKeyAciton(3, 0)) {
                if (3 == this.mKeyMapMode) {
                    this.mMouseDragState = 1;
                    this.mJoystickLTouchDrag = true;
                }
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 3, 0, f18, f19);
            }
        }
    }

    public void onFireKeyEventOnChooseWindow(int i3, int i16) {
        KeyChooseWindowItem selectKeyChooseWindowItem;
        if (getCurrentSceneConfig() == null || getCurrentSceneConfig().getConfigSize(4) <= 0 || (selectKeyChooseWindowItem = getCurrentSceneConfig().getSelectKeyChooseWindowItem()) == null) {
            return;
        }
        float point_x = selectKeyChooseWindowItem.getPoint_x() * this.mSurfaceView.getWidth();
        float point_y = selectKeyChooseWindowItem.getPoint_y() * this.mSurfaceView.getHeight();
        if (i16 != 1) {
            if (i16 == 2) {
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 3, 1, point_x, point_y);
            }
        } else {
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 3, 0, point_x, point_y);
        }
        if (i16 == 2) {
            onUiMsgChooseItemClicked();
        }
    }

    public void onFirstFrameRendered(View view) {
        this.mSurfaceView = view;
        TVInputManager.getInstance().resetGameConfig();
        CGLog.i("onFirstFrameRendered AppBizNo: " + this.mWebRTCSDK.getAppBizNo());
        if ("8".equals(this.mWebRTCSDK.getAppBizNo())) {
            setKeyMapMode(7, 1);
        }
    }

    public void onGamepadTouchMapDirection(int i3, int i16, int i17, int i18) {
        View view;
        PointF pointF;
        float f16;
        float f17;
        int keyMapMode = getKeyMapMode();
        if ((1 == keyMapMode || 11 == keyMapMode) && (view = this.mSurfaceView) != null && (pointF = GlobalConfig.kTouchMapPos) != null && pointF.x != 0.0f && pointF.y != 0.0f) {
            int width = view.getWidth();
            int height = this.mSurfaceView.getHeight();
            PointF pointF2 = GlobalConfig.kTouchMapPos;
            float f18 = pointF2.x * width;
            float f19 = pointF2.y * height;
            float f26 = f18 - 200.0f;
            float f27 = 1.0f;
            if (f26 < 1.0d) {
                f26 = 1.0f;
            }
            float f28 = f18 + 200.0f;
            float f29 = width - 1;
            if (f28 > f29) {
                f28 = f29;
            }
            float f36 = f19 - 200.0f;
            if (f36 >= 1.0f) {
                f27 = f36;
            }
            float f37 = 200.0f + f19;
            float f38 = height - 1;
            if (f37 > f38) {
                f37 = f38;
            }
            if (i3 == 5) {
                this.mGamepadTouchMapCurrentPosX = f18;
                this.mGamepadTouchMapCurrentPosY = f19;
            }
            float f39 = this.mGamepadTouchMapCurrentPosX;
            float f46 = this.mGamepadTouchMapCurrentPosY;
            if (f39 == 0.0f) {
                f16 = (float) Math.random();
            } else {
                f16 = i17 * GlobalConfig.kTouchMapSensitivityX;
            }
            float f47 = f39 + f16;
            if (f46 == 0.0f) {
                f17 = (float) Math.random();
            } else {
                f17 = i18 * GlobalConfig.kTouchMapSensitivityY;
            }
            float f48 = f46 + f17;
            if (f47 < f26) {
                f47 = f26;
            } else if (f47 > f28) {
                f47 = f28;
            }
            if (f48 < f27) {
                f48 = f27;
            } else if (f48 > f37) {
                f48 = f37;
            }
            this.mGamepadTouchMapCurrentPosX = f47;
            this.mGamepadTouchMapCurrentPosY = f48;
            if (i16 == 1) {
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 4, 2, f47, f48);
            }
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 4, i16, f47, f48);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r2 != r4) goto L20;
     */
    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGamepadTouchMapRelDirection(int i3, int i16, int i17) {
        int keyMapMode = getKeyMapMode();
        if (1 == keyMapMode || 11 == keyMapMode) {
            int i18 = i16 - 128;
            int i19 = i17 - 128;
            int i26 = 2;
            if (i18 != 0) {
                if (i18 == 50) {
                    i18 = 2;
                } else if (i18 == -50) {
                    i18 = -2;
                }
            } else if (i19 != 0) {
                if (i19 == 50) {
                    i19 = 2;
                } else if (i19 == -50) {
                    i19 = -2;
                }
            }
            int i27 = 5;
            if (i18 != 0 || i19 != 0) {
                if (i18 > 0) {
                    i26 = 3;
                } else if (i18 < 0) {
                    i26 = 1;
                } else if (i19 > 0) {
                    i26 = 4;
                } else if (i19 >= 0) {
                    i26 = 0;
                }
                int i28 = this.mPrevDirection;
                if (i28 != 5) {
                }
                if (i3 != 0 && i3 != 1) {
                    i27 = i26;
                }
                this.mPrevDirection = i27;
                onGamepadTouchMapDirection(i27, i3, i18, i19);
            }
            i26 = 5;
            if (i3 != 0) {
                i27 = i26;
            }
            this.mPrevDirection = i27;
            onGamepadTouchMapDirection(i27, i3, i18, i19);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public void onGamepadTouchMapRelOffset(int i3, int i16, int i17) {
        View view;
        PointF pointF;
        float f16;
        float f17;
        int keyMapMode = getKeyMapMode();
        if ((1 == keyMapMode || 11 == keyMapMode) && (view = this.mSurfaceView) != null && (pointF = GlobalConfig.kTouchMapPos) != null && pointF.x != 0.0f && pointF.y != 0.0f) {
            int width = view.getWidth();
            int height = this.mSurfaceView.getHeight();
            if (i3 == 0) {
                PointF pointF2 = GlobalConfig.kTouchMapPos;
                this.mGamepadTouchMapCurrentPosX = pointF2.x * width;
                this.mGamepadTouchMapCurrentPosY = pointF2.y * height;
            }
            float f18 = this.mGamepadTouchMapCurrentPosX;
            float f19 = this.mGamepadTouchMapCurrentPosY;
            float f26 = f18 + (i16 * GlobalConfig.kTouchMapSensitivityX);
            float f27 = 1.0f;
            if (f26 < 1.0f) {
                f16 = 1.0f;
            } else {
                float f28 = width - 1;
                if (f26 > f28) {
                    f16 = f28;
                } else {
                    f16 = f26;
                }
            }
            float f29 = f19 + (i17 * GlobalConfig.kTouchMapSensitivityY);
            if (f29 >= 1.0f) {
                f27 = height - 1;
                if (f29 <= f27) {
                    f17 = f29;
                    this.mGamepadTouchMapCurrentPosX = f16;
                    this.mGamepadTouchMapCurrentPosY = f17;
                    this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 4, i3, f16, f17);
                }
            }
            f17 = f27;
            this.mGamepadTouchMapCurrentPosX = f16;
            this.mGamepadTouchMapCurrentPosY = f17;
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 4, i3, f16, f17);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        GameController gameControllerByDeviceId;
        if (motionEvent == null) {
            return false;
        }
        boolean z17 = true;
        HIDGamepadPerf.nGenericJoystickEvent++;
        if (!isMouseMode() && GlobalConfig.getInstance().isSendNativeEventToGame()) {
            if (this.mWebRTCSDK != null) {
                if (GlobalConfig.getInstance().isCreateCloudDevice() && (gameControllerByDeviceId = this.mTVInputManager.getGameControllerByDeviceId(motionEvent.getDeviceId())) != null) {
                    i3 = gameControllerByDeviceId.getDeviceMapIndex();
                } else {
                    i3 = 0;
                }
                this.mWebRTCSDK.sendGamepadMotionEvent(motionEvent, this.valueType, i3);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if ((z16 && !isMouseMode()) || handleMotionEvent(motionEvent) != 1) {
            z17 = z16;
        }
        if (this.mIsStartInput) {
            return false;
        }
        return z17;
    }

    public boolean onHidKeyEvent(HIDKeyEvent hIDKeyEvent) {
        boolean z16;
        int keyCode = hIDKeyEvent.getKeyCode();
        if (GlobalConfig.getInstance().isSendNativeEventToGame()) {
            WebRTCSDK webRTCSDK = this.mWebRTCSDK;
            if (webRTCSDK != null) {
                webRTCSDK.sendGamepadKeyEvent(3, 1, 1281, keyCode, hIDKeyEvent.getAction());
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16 || KeyHandler.isKeyCodeContinue(keyCode)) && handleHidKeyEvent(hIDKeyEvent) == 1) {
            return true;
        }
        return z16;
    }

    public boolean onHidMotionEvent(HIDMotionEvent hIDMotionEvent) {
        boolean z16;
        if (GlobalConfig.getInstance().isSendNativeEventToGame()) {
            if (this.mWebRTCSDK != null) {
                this.mWebRTCSDK.sendGamepadMotionEvent(GamepadEventManage.getMotionEvent(hIDMotionEvent, 3, 1));
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16 || isMouseMode()) && handleHidMotionEvent(hIDMotionEvent) == 1) {
            return true;
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        if (r13 != 5) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onHitKeyMap(int i3, KeyMapKeyItem keyMapKeyItem) {
        int i16;
        int i17;
        if (keyMapKeyItem != null) {
            float percentX = keyMapKeyItem.getPercentX() * this.mSurfaceView.getWidth();
            float percentY = keyMapKeyItem.getPercentY() * this.mSurfaceView.getHeight();
            int i18 = keyMapKeyItem.getKeyCodes()[0];
            if (keyMapKeyItem.getKeyCodes().length == 2) {
                i18 += keyMapKeyItem.getKeyCodes()[1];
            }
            if (i3 == 0) {
                if (!this.mMultiPointController.hasKeyAciton(i18, i3) && !this.mMultiPointController.hasKeyAciton(i18, 2)) {
                    if (keyMapKeyItem.isJoyKeyType()) {
                        int joyKeyState = this.mGamepadJoyKeyState.getJoyKeyState();
                        if (joyKeyState != 0) {
                            if (joyKeyState != 1) {
                                if (joyKeyState != 2) {
                                    if (joyKeyState != 3 && joyKeyState != 4) {
                                    }
                                } else {
                                    if (this.mIsJoystickRPress) {
                                        this.mIsJoystickRPress = false;
                                        PointF pointF = this.mJoystickMovePointR;
                                        float f16 = pointF.x;
                                        float f17 = pointF.y;
                                        stopJoystickTouchRun(2);
                                        this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 2, 1, f16, f17);
                                    }
                                    this.mGamepadJoyKeyState.setJoyKeyID(i18);
                                    this.mGamepadJoyKeyState.setJoyKeyType(keyMapKeyItem.getType());
                                    this.mGamepadJoyKeyState.setJoyKeyRadius(keyMapKeyItem.getRadius());
                                    this.mGamepadJoyKeyState.setJoyKeyDownPoint(percentX, percentY);
                                    this.mGamepadJoyKeyState.setJoyKeyState(3);
                                }
                            }
                            if (this.mGamepadJoyKeyState.getJoyKeyID() == i18) {
                                this.mGamepadJoyKeyState.setJoyKeyDownPoint(percentX, percentY);
                            }
                            i17 = -1;
                            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i17, i3, percentX, percentY);
                            onUiMsgKeyMapTrigger(i3, keyMapKeyItem);
                            return;
                        }
                        this.mGamepadJoyKeyState.setJoyKeyID(i18);
                        this.mGamepadJoyKeyState.setJoyKeyType(keyMapKeyItem.getType());
                        this.mGamepadJoyKeyState.setJoyKeyRadius(keyMapKeyItem.getRadius());
                        this.mGamepadJoyKeyState.setJoyKeyDownPoint(percentX, percentY);
                        this.mGamepadJoyKeyState.setJoyKeyState(1);
                        this.mGamepadJoyKeyState.setInterpolationPoint(percentX, percentY);
                    }
                    i17 = i18;
                    this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i17, i3, percentX, percentY);
                    onUiMsgKeyMapTrigger(i3, keyMapKeyItem);
                    return;
                }
                return;
            }
            if (1 == i3) {
                if (keyMapKeyItem.isJoyKeyType()) {
                    int joyKeyState2 = this.mGamepadJoyKeyState.getJoyKeyState();
                    if (joyKeyState2 != 1) {
                        if (joyKeyState2 != 3) {
                            if (joyKeyState2 != 4) {
                                if (joyKeyState2 == 5) {
                                    onUiMsgKeyMapTrackKey(i3, keyMapKeyItem, percentX, percentY);
                                    i16 = -1;
                                }
                            }
                        } else {
                            if (this.mGamepadJoyKeyState.getJoyKeyID() == i18) {
                                float joyKeyDownPointX = this.mGamepadJoyKeyState.getJoyKeyDownPointX();
                                float joyKeyDownPointY = this.mGamepadJoyKeyState.getJoyKeyDownPointY();
                                this.mGamepadJoyKeyState.setJoyKeyState(0);
                                this.mGamepadJoyKeyState.setJoyKeyID(-1);
                                this.mGamepadJoyKeyState.setJoyKeyType(0);
                                this.mGamepadJoyKeyState.setJoyKeyRadius(0);
                                onUiMsgKeyMapTrackKey(i3, keyMapKeyItem, joyKeyDownPointX, joyKeyDownPointY);
                                percentX = joyKeyDownPointX;
                                percentY = joyKeyDownPointY;
                            }
                            i16 = -1;
                        }
                        this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i16, i3, percentX, percentY);
                        onUiMsgKeyMapTrigger(i3, keyMapKeyItem);
                    }
                    if (this.mGamepadJoyKeyState.getJoyKeyID() == i18) {
                        this.mGamepadJoyKeyState.setJoyKeyState(0);
                        this.mGamepadJoyKeyState.setJoyKeyID(-1);
                        this.mGamepadJoyKeyState.setJoyKeyType(0);
                        this.mGamepadJoyKeyState.setJoyKeyRadius(0);
                        float interpolationPointX = this.mGamepadJoyKeyState.getInterpolationPointX();
                        float interpolationPointY = this.mGamepadJoyKeyState.getInterpolationPointY();
                        onUiMsgKeyMapTrackKey(i3, keyMapKeyItem, interpolationPointX, interpolationPointY);
                        percentX = interpolationPointX;
                        percentY = interpolationPointY;
                    }
                    i16 = -1;
                    this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i16, i3, percentX, percentY);
                    onUiMsgKeyMapTrigger(i3, keyMapKeyItem);
                }
                i16 = i18;
                this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, i16, i3, percentX, percentY);
                onUiMsgKeyMapTrigger(i3, keyMapKeyItem);
            }
        }
    }

    public void onInputEvent(HIDInputEvent hIDInputEvent) {
        if (hIDInputEvent instanceof HIDKeyEvent) {
            onHidKeyEvent((HIDKeyEvent) hIDInputEvent);
        } else if (hIDInputEvent instanceof HIDMotionEvent) {
            onHidMotionEvent((HIDMotionEvent) hIDInputEvent);
        }
    }

    public void onJoystickLState(int i3, float f16, float f17) {
        int keyMapMode = getKeyMapMode();
        if (3 != keyMapMode && 8 != keyMapMode) {
            if (1 == keyMapMode || 12 == keyMapMode || 11 == keyMapMode) {
                if (GlobalConfig.kIsJoystickToMove) {
                    onJoystickMoveToDrive(f16, f17);
                    return;
                }
                JoyPadItem joyPadItem = this.mJoystickItemL;
                if (joyPadItem != null && joyPadItem.isValid()) {
                    doJoystickMoveControl(f16, f17);
                    return;
                }
                return;
            }
            return;
        }
        doJoystickMouseControl(f16, f17);
        if (1 == this.mMouseDragState) {
            PointF pointF = this.mMouseClickPoint;
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 3, 2, pointF.x, pointF.y);
            if (!this.mJoystickLTouchRunning) {
                startJoystickTouchRun(1, 50);
            }
        }
    }

    public void onJoystickLUp() {
        int keyMapMode = getKeyMapMode();
        if (3 != keyMapMode && 8 != keyMapMode) {
            if (1 == keyMapMode || 12 == keyMapMode || 11 == keyMapMode) {
                if (GlobalConfig.kIsJoystickToMove) {
                    onJoystickUpToDrive();
                    return;
                }
                JoyPadItem joyPadItem = this.mJoystickItemL;
                if (joyPadItem != null && joyPadItem.isValid() && this.mIsJoystickLPress) {
                    this.mIsJoystickLPress = false;
                    this.mJoystickMoveCount = 0;
                    float percentX = this.mJoystickItemL.getPercentX() * this.mSurfaceView.getWidth();
                    float percentY = this.mJoystickItemL.getPercentY() * this.mSurfaceView.getHeight();
                    this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 1, 1, percentX, percentY);
                    onUiMsgKeyMapTrackJoy(1, 2, percentX, percentY);
                    return;
                }
                return;
            }
            return;
        }
        stopJoystickTouchRun(1);
    }

    public void onJoystickRState(int i3, float f16, float f17) {
        int keyMapMode = getKeyMapMode();
        if ((1 == keyMapMode || 11 == keyMapMode) && this.mJoystickItemR != null) {
            int joyKeyState = this.mGamepadJoyKeyState.getJoyKeyState();
            if (joyKeyState != 0) {
                if (joyKeyState != 1) {
                    if (joyKeyState != 2) {
                        if (joyKeyState != 3 && joyKeyState != 4) {
                            return;
                        }
                    } else {
                        if (this.mJoystickItemR.isValid() && this.mJoystickMovePointR != null) {
                            doJoystickPointOfView(f16, f17);
                            return;
                        }
                        return;
                    }
                }
                if (this.mJoystickItemR.getType() == 5) {
                    doJoystickGameSkillDrag(this.mGamepadJoyKeyState.getJoyKeyID(), f16, f17);
                }
                this.mGamepadJoyKeyState.setJoyKeyState(3);
                return;
            }
            this.mGamepadJoyKeyState.setJoyKeyID(2);
            this.mGamepadJoyKeyState.setJoyKeyRadius(0);
            this.mGamepadJoyKeyState.setJoyKeyState(2);
            if (this.mJoystickItemR.isValid() && this.mJoystickMovePointR != null) {
                doJoystickPointOfView(f16, f17);
            }
        }
    }

    public void onJoystickRUp() {
        JoyPadItem joyPadItem;
        int joyKeyState = this.mGamepadJoyKeyState.getJoyKeyState();
        if (joyKeyState != 2) {
            if (joyKeyState == 3) {
                JoyPadItem joyPadItem2 = this.mJoystickItemR;
                if (joyPadItem2 != null && joyPadItem2.getType() == 5) {
                    sgameCancelSpellCasting(false);
                }
                this.mGamepadJoyKeyState.setJoyKeyState(4);
                return;
            }
            return;
        }
        if (this.mJoystickMovePointR != null && (joyPadItem = this.mJoystickItemR) != null && joyPadItem.isValid() && this.mIsJoystickRPress) {
            this.mIsJoystickRPress = false;
            PointF pointF = this.mJoystickMovePointR;
            float f16 = pointF.x;
            float f17 = pointF.y;
            stopJoystickTouchRun(2);
            this.mMultiPointController.sendMultiPointEvent(this.mSurfaceView, 2, 1, f16, f17);
        }
        this.mGamepadJoyKeyState.setJoyKeyState(0);
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        int i16;
        GameController gameControllerByDeviceId;
        GameController gameControllerByDeviceId2;
        int i17 = 0;
        if (keyEvent == null) {
            return false;
        }
        boolean z16 = true;
        if (this.mIsInLoginView && (i3 == 4 || i3 == 97)) {
            if (GlobalConfig.getInstance().isCreateCloudDevice() && (gameControllerByDeviceId2 = this.mTVInputManager.getGameControllerByDeviceId(keyEvent.getDeviceId())) != null && gameControllerByDeviceId2.isCreatedCloudDevice()) {
                i17 = gameControllerByDeviceId2.getDeviceMapIndex();
            }
            this.mWebRTCSDK.sendGamepadKeyEvent(this.valueType, i17, 513, 4, 0);
            return true;
        }
        if (!isMouseMode() && GlobalConfig.getInstance().isSendNativeEventToGame()) {
            CGLog.d("GamepadControlleronKeyDown: " + isMouseMode() + " ");
            if (keyEvent.getDeviceId() != -1 && this.mWebRTCSDK != null) {
                int source = keyEvent.getSource();
                if (InputUtils.isTvKeyCode(i3)) {
                    source = 513;
                }
                int i18 = source;
                if (GlobalConfig.getInstance().isCreateCloudDevice() && (gameControllerByDeviceId = this.mTVInputManager.getGameControllerByDeviceId(keyEvent.getDeviceId())) != null && gameControllerByDeviceId.isCreatedCloudDevice()) {
                    i16 = gameControllerByDeviceId.getDeviceMapIndex();
                } else {
                    i16 = 0;
                }
                CGLog.d("GamepadControlleronKeyDown sendGamepadKeyEvent: valueType" + this.valueType + " index:" + i16 + " source: " + i18 + " keyCode: " + i3);
                this.mWebRTCSDK.sendGamepadKeyEvent(this.valueType, i16, i18, i3, 0);
            }
        } else {
            z16 = false;
        }
        boolean handleKeyEvent = handleKeyEvent(z16, i3, keyEvent) | z16;
        if (this.mIsStartInput) {
            return false;
        }
        return handleKeyEvent;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public int onKeyJoyState(int i3, int i16, float f16, float f17) {
        int keyMapMode = getKeyMapMode();
        if (1 == keyMapMode || 11 == keyMapMode || 12 == keyMapMode) {
            if (i16 == this.mGamepadJoyKeyState.getJoyKeyID() && this.mGamepadJoyKeyState.getJoyKeyState() == 1) {
                doJoystickGameSkillDrag(this.mGamepadJoyKeyState.getJoyKeyID(), f16, f17);
                return 0;
            }
            KeyMapSceneConfig currentSceneConfig = getCurrentSceneConfig();
            if (currentSceneConfig != null) {
                onPubgPointOfViewMove(currentSceneConfig.findTouchButtonItem(i16), i16, f16, f17);
                return 0;
            }
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public int onKeyJoyUp(int i3, int i16) {
        KeyMapSceneConfig currentSceneConfig;
        int keyMapMode = getKeyMapMode();
        if ((1 == keyMapMode || 11 == keyMapMode || 12 == keyMapMode) && (currentSceneConfig = getCurrentSceneConfig()) != null) {
            onPubgPointOfViewUp(currentSceneConfig.findTouchButtonItem(i16), i16);
            return 0;
        }
        return 0;
    }

    public void onKeyMapMode(int i3, int i16, SceneCanvas sceneCanvas) {
        CGLog.d("GamepadControlleronKeyMapMode oldMode: " + i3 + " newMode: " + i16);
        if (i3 == 3 && i16 != 3 && (this.mMultiPointController.hasKeyAciton(3, 2) || this.mMultiPointController.hasKeyAciton(3, 0))) {
            onFireKeyEvent(3, 2);
        }
        if (i16 == 3) {
            if (this.mSurfaceView != null) {
                this.mMouseClickPoint.x = r1.getWidth() / 2;
                this.mMouseClickPoint.y = this.mSurfaceView.getHeight() / 2;
            }
        } else {
            stopJoystickTouchRun(1);
        }
        KeyHandler keyHandler = this.mKeyHandler;
        if (keyHandler != null) {
            keyHandler.resetKeyEvent();
        }
        if (i3 != i16) {
            onJoystickLUp();
        }
        stopJoystickTouchRun(2);
        loadSceneCanvasToFloatView(sceneCanvas);
    }

    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        int i16;
        GameController gameControllerByDeviceId;
        GameController gameControllerByDeviceId2;
        int i17 = 0;
        if (keyEvent == null) {
            return false;
        }
        boolean z16 = true;
        if (this.mIsInLoginView && (i3 == 4 || i3 == 97)) {
            if (GlobalConfig.getInstance().isCreateCloudDevice() && (gameControllerByDeviceId2 = this.mTVInputManager.getGameControllerByDeviceId(keyEvent.getDeviceId())) != null) {
                i17 = gameControllerByDeviceId2.getDeviceMapIndex();
            }
            this.mWebRTCSDK.sendGamepadKeyEvent(this.valueType, i17, 513, 4, 1);
            return true;
        }
        if (!isMouseMode() && GlobalConfig.getInstance().isSendNativeEventToGame()) {
            if (keyEvent.getDeviceId() != -1 && this.mWebRTCSDK != null) {
                int source = keyEvent.getSource();
                if (InputUtils.isTvKeyCode(i3)) {
                    source = 513;
                }
                int i18 = source;
                if (GlobalConfig.getInstance().isCreateCloudDevice() && (gameControllerByDeviceId = this.mTVInputManager.getGameControllerByDeviceId(keyEvent.getDeviceId())) != null) {
                    i16 = gameControllerByDeviceId.getDeviceMapIndex();
                } else {
                    i16 = 0;
                }
                this.mWebRTCSDK.sendGamepadKeyEvent(this.valueType, i16, i18, i3, 1);
            }
        } else {
            z16 = false;
        }
        boolean handleKeyEvent = handleKeyEvent(z16, i3, keyEvent) | z16;
        if (this.mIsStartInput) {
            return false;
        }
        return handleKeyEvent;
    }

    public void onMFGampadDeviceChanged(int i3, int i16, int i17) {
        if (i3 == 2 && i16 == 1) {
            setKeyMapMode(6, 10);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.TVKeyMapMsg.IKeyMapConfigRespListener
    public void onRespConfigLoadSuccess(KeyMapConfigManager keyMapConfigManager, boolean z16, int i3) {
        int i16;
        this.mKeyMapConfigManager = keyMapConfigManager;
        TVInputManager.getInstance().createDeviceToCloudForConnected();
        checkAndOpenMFGamepad();
        if (GlobalConfig.getInstance().isSendNativeEventToGame()) {
            i16 = 5;
        } else if (TVInputManager.getInstance().hasMFGamepadConnected()) {
            i16 = 6;
        } else {
            i16 = 3;
        }
        setKeyMapMode(i16, 2);
        IKeyMapListener iKeyMapListener = this.mKeyMapListener;
        if (iKeyMapListener != null) {
            iKeyMapListener.onGameInfo(z16, i3);
        }
    }

    public void onStartInput(boolean z16) {
        this.mIsStartInput = z16;
    }

    void onUiMsgChooseItemClicked() {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onChooseItemClicked();
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgChooseItemClicked$0();
                    }
                });
            }
        }
    }

    void onUiMsgKeyMapModeChanged(final SceneCanvas sceneCanvas) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onKeyMapModeChanged(sceneCanvas);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgKeyMapModeChanged$5(sceneCanvas);
                    }
                });
            }
        }
    }

    void onUiMsgKeyMapTrackJoy(final int i3, final int i16, final float f16, final float f17) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onKeyMapTrackJoy(i3, i16, f16, f17);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgKeyMapTrackJoy$4(i3, i16, f16, f17);
                    }
                });
            }
        }
    }

    void onUiMsgKeyMapTrackKey(final int i3, final int i16, final float f16, final float f17) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onKeyMapTrackKey(i3, i16, f16, f17);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgKeyMapTrackKey$2(i3, i16, f16, f17);
                    }
                });
            }
        }
    }

    public void onUiMsgKeyMapTrigger(final int i3, final KeyItem keyItem) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onKeyMapTrigger(i3, keyItem);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgKeyMapTrigger$1(i3, keyItem);
                    }
                });
            }
        }
    }

    void onUiMsgMouseViewFollowJoystick(final float f16, final float f17, final PointF pointF) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onMouseViewFollowJoystick(f16, f17, pointF);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgMouseViewFollowJoystick$6(f16, f17, pointF);
                    }
                });
            }
        }
    }

    void onUiMsgVirtualGamepadMessage(final int i3, final int i16, final String str) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onVirtualGamepadMessage(i3, i16, str);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgVirtualGamepadMessage$7(i3, i16, str);
                    }
                });
            }
        }
    }

    public void pullAndLoadConfig(Context context, String str, String str2) {
        if (!this.mHasLoadConfig) {
            this.mHasLoadConfig = true;
            KeyMapConfigManager.getInstance().pullAndLoadConfig(context, str2, this);
        }
    }

    public void registerKeyMapListener(IKeyMapListener iKeyMapListener) {
        this.mKeyMapListener = iKeyMapListener;
        TVInputManager.getInstance().setGamepadController(this);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public void reportGamepadStatus(String str, int i3, String str2) {
        ITVPlaySession iTVPlaySession = this.mTVPlaySessionListener;
        if (iTVPlaySession != null) {
            iTVPlaySession.reportTVGamepadStatus(str, i3, str2);
        }
    }

    public void sendClientConnectionMessage(int i3, int i16, String str, String str2, int i17) {
        CGLog.d("client connection: sessionID = " + str + " client_type id = " + str2 + " event = " + i17);
        if (i16 != 1) {
            if (i16 == 2) {
                CGLog.d("TV connection sessionID = " + str + " id = " + str2 + " event = " + i17);
                return;
            }
            return;
        }
        if (i17 == 1) {
            this.mKeyMapListener.onVirtualGamepadMessage(2, i3, 0, 0);
        } else if (i17 == 2) {
            this.mKeyMapListener.onVirtualGamepadMessage(4, i3, 0, 0);
        }
    }

    public boolean sendGameControlCommandToCloud(GameController.CloudCommand cloudCommand) {
        WebRTCSDK webRTCSDK = this.mWebRTCSDK;
        if (webRTCSDK != null && cloudCommand != null) {
            int i3 = cloudCommand.m_cmd;
            if (i3 == 1) {
                return webRTCSDK.sendDeviceCreateEvent(cloudCommand.m_deviceType, cloudCommand.m_deviceId, cloudCommand.m_mapMode);
            }
            if (i3 == 2) {
                return webRTCSDK.sendDeviceDetroyEvent(cloudCommand.m_deviceType, cloudCommand.m_deviceId, cloudCommand.m_mapMode);
            }
        }
        return false;
    }

    public void sendGamepadTouchEvent(MotionEvent motionEvent) {
        WebRTCSDK webRTCSDK = this.mWebRTCSDK;
        if (webRTCSDK != null) {
            webRTCSDK.sendGamepadTouchEvent(motionEvent);
        }
    }

    public void sendVirtualGamepadMessage(int i3, int i16, String str) {
        if (1 != i3 || this.mKeyMapListener == null || Misc.parseVirtualGamepadParams(str) != null || this.mStrServerUrl == null) {
            return;
        }
        String str2 = this.mVirtualGamepadUrl + "?tk=" + Misc.encodeToken(str);
        String extractVirtualGamepadGate = Misc.extractVirtualGamepadGate(this.mStrServerUrl.toLowerCase());
        String str3 = str2 + extractVirtualGamepadGate;
        if (GlobalConfig.getInstance().getVirtualGamePadType() != -1) {
            str3 = str3 + "&htype=" + GlobalConfig.getInstance().getVirtualGamePadType();
        } else if (GlobalConfig.getInstance().isGamepadGameType() || GlobalConfig.getInstance().isTVControllerGameType()) {
            str3 = str3 + "&htype=1";
        }
        CGLog.i("virtual gamepad gate=" + extractVirtualGamepadGate);
        onUiMsgVirtualGamepadMessage(i3, i16, str3);
        this.mStrServerUrl = null;
    }

    public void setInLoginView(boolean z16) {
        this.mIsInLoginView = z16;
    }

    public void setKeyMapMode(int i3, int i16) {
        SceneCanvas forceKeyMapMode;
        String str;
        CGLog.i("onkeymap mode=" + i3 + " source=" + i16);
        int i17 = this.mKeyMapMode;
        if (i16 == 3) {
            forceKeyMapMode = handleKeyMapGamepadSwitchMode(i16);
        } else if (i16 == 4) {
            forceKeyMapMode = handleKeyMapTVSwitchMode(i16);
        } else if (i16 == 12) {
            forceKeyMapMode = handleKeyMapSwitchKeyCombinationMode(i3);
        } else if (i16 != 6 && i16 != 7 && i16 != 8) {
            forceKeyMapMode = forceKeyMapMode(i3, i16);
        } else {
            CGLog.i("onkeymap internal errorCode 0x10000007");
            return;
        }
        int i18 = 0;
        if (forceKeyMapMode != null) {
            int keyMapMode = forceKeyMapMode.getKeyMapMode();
            if (i17 != keyMapMode) {
                forceKeyMapMode.setModeChanged(true);
            }
            KeyMapSceneConfig sceneConfig = forceKeyMapMode.getSceneConfig();
            if (sceneConfig != null) {
                str = String.format(" scene id=%d, name=%s, mapType=%d", Integer.valueOf(sceneConfig.getId()), sceneConfig.getSceneName(), Integer.valueOf(sceneConfig.getMapType()));
            } else {
                str = "sceneConfig is null";
            }
            CGLog.i("onkeymap " + str);
            i18 = keyMapMode;
        }
        CGLog.i("onkeymap oldMode=" + i17 + " newMode=" + i18 + " source=" + i16);
        onKeyMapMode(i17, i18, forceKeyMapMode);
    }

    public void setKeyTracMenukEnabled(boolean z16) {
        GlobalConfig.getInstance().setKeyTracMenukEnabled(z16);
    }

    public void setServerUrl(String str) {
        this.mStrServerUrl = str;
    }

    public void setValueType(int i3) {
        this.valueType = i3;
    }

    public void setVirtualGamepadUrl(String str) {
        this.mVirtualGamepadUrl = str;
    }

    public void setWebRTCSDK(WebRTCSDK webRTCSDK) {
        this.mWebRTCSDK = webRTCSDK;
    }

    public void stopJoystickTouchRun(int i3) {
        if (1 == i3) {
            this.mJoystickLTouchRunning = false;
        } else if (2 == i3) {
            this.mJoystickRTouchRunning = false;
        }
    }

    public SceneCanvas swapSceneCanvas(SceneCanvas sceneCanvas) {
        String str;
        if (sceneCanvas != null) {
            SceneCanvas sceneCanvas2 = this.mSceneCanvas;
            if (sceneCanvas2 != null) {
                if (sceneCanvas2.getKeyMapMode() != sceneCanvas.getKeyMapMode()) {
                    sceneCanvas.setModeChanged(true);
                }
                if (this.mSceneCanvas.getSceneConfig() != sceneCanvas.getSceneConfig()) {
                    sceneCanvas.setLayoutChanged(true);
                }
            } else {
                sceneCanvas.setModeChanged(true);
                sceneCanvas.setLayoutChanged(true);
            }
            boolean isLayoutChanged = sceneCanvas.isLayoutChanged();
            boolean isModeChanged = sceneCanvas.isModeChanged();
            KeyMapSceneConfig sceneConfig = sceneCanvas.getSceneConfig();
            if (sceneConfig != null) {
                str = String.format(" scene id=%d, name=%s, mapType=%d", Integer.valueOf(sceneConfig.getId()), sceneConfig.getSceneName(), Integer.valueOf(sceneConfig.getMapType()));
            } else {
                str = "sceneConfig is null";
            }
            CGLog.i("onkeymap onDcEvent swapSceneCanvas " + str + (" isLayoutChanged=" + isLayoutChanged + " isModeChanged=" + isModeChanged));
        }
        updateKeyMapConfigState();
        this.mSceneCanvas = sceneCanvas;
        return sceneCanvas;
    }

    public void unregisterKeyMapListener() {
        this.mKeyMapListener = null;
        TVInputManager.getInstance().setGamepadController(null);
    }

    void onUiMsgKeyMapTrackKey(final int i3, final KeyItem keyItem, final float f16, final float f17) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onKeyMapTrackKey(i3, keyItem, f16, f17);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgKeyMapTrackKey$3(i3, keyItem, f16, f17);
                    }
                });
            }
        }
    }

    void onUiMsgVirtualGamepadMessage(final int i3, final int i16, final int i17, final int i18) {
        if (this.mKeyMapListener != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mKeyMapListener.onVirtualGamepadMessage(i3, i16, i17, i18);
            } else {
                CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamepadController.this.lambda$onUiMsgVirtualGamepadMessage$8(i3, i16, i17, i18);
                    }
                });
            }
        }
    }

    public int handleKeyEvent(int i3, int i16, int i17) {
        if (i3 == -1) {
            return 0;
        }
        KeyHandler keyHandler = this.mKeyHandler;
        int handleKeyEvent = keyHandler != null ? keyHandler.handleKeyEvent(i3, i16, i17) : 0;
        if (GlobalConfig.IsOpenMFGamepad && i17 == 103) {
            sgameCancelSpellCasting(i16 == 1);
        }
        return handleKeyEvent;
    }

    public void sendVirtualGamepadMessage(int i3, int i16, int i17, int i18) {
        if (this.mKeyMapListener != null) {
            CGLog.i("virtual gamepad type = " + i3 + " value = " + i17 + " param = " + i18);
            if (i18 == 0 && 3 == i3) {
                i17 *= 1000;
            }
            onUiMsgVirtualGamepadMessage(i3, i16, i17, i18);
            if (i3 == 2) {
                setKeyMapMode(9, 9);
            }
        }
    }
}
