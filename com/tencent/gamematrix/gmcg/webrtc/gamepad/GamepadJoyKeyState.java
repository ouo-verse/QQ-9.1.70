package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.graphics.PointF;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GamepadJoyKeyState {
    public static final int JOY_KEY_STATE_KEY_JOY_PRESSED = 3;
    public static final int JOY_KEY_STATE_NONE = 0;
    public static final int JOY_KEY_STATE_ONLY_JOY_PRESSED = 2;
    public static final int JOY_KEY_STATE_ONLY_KEY_PRESSED = 1;
    public static final int JOY_KEY_STATE_R1_CANCEL = 5;
    public static final int JOY_KEY_STATE_TO_KEY_PRESSED = 4;
    private GamepadController mGamepadController;
    private int mJoyKeyRadius;
    private int mJoyKeyType;
    private int mJoyKeyID = -1;
    private int mJoyKeyState = 0;
    private PointF mJoyKeyPoint = new PointF();
    private PointF mInterpolationPoint = new PointF();
    private PointF mJoyKeyUpPoint = new PointF();

    public GamepadJoyKeyState(GamepadController gamepadController) {
        this.mGamepadController = gamepadController;
    }

    public float getInterpolationPointX() {
        PointF pointF = this.mInterpolationPoint;
        if (pointF != null) {
            return pointF.x;
        }
        return 0.0f;
    }

    public float getInterpolationPointY() {
        PointF pointF = this.mInterpolationPoint;
        if (pointF != null) {
            return pointF.y;
        }
        return 0.0f;
    }

    public float getJoyKeyDownPointX() {
        PointF pointF = this.mJoyKeyPoint;
        if (pointF != null) {
            return pointF.x;
        }
        return 0.0f;
    }

    public float getJoyKeyDownPointY() {
        PointF pointF = this.mJoyKeyPoint;
        if (pointF != null) {
            return pointF.y;
        }
        return 0.0f;
    }

    public int getJoyKeyID() {
        return this.mJoyKeyID;
    }

    public int getJoyKeyRadius() {
        return this.mJoyKeyRadius;
    }

    public int getJoyKeyState() {
        return this.mJoyKeyState;
    }

    public int getJoyKeyType() {
        return this.mJoyKeyType;
    }

    public float getJoyKeyUpPointX() {
        PointF pointF = this.mJoyKeyUpPoint;
        if (pointF != null) {
            return pointF.x;
        }
        return 0.0f;
    }

    public float getJoyKeyUpPointY() {
        PointF pointF = this.mJoyKeyUpPoint;
        if (pointF != null) {
            return pointF.y;
        }
        return 0.0f;
    }

    public void setInterpolationPoint(float f16, float f17) {
        PointF pointF = this.mInterpolationPoint;
        if (pointF != null) {
            pointF.x = f16;
            pointF.y = f17;
        }
    }

    public void setJoyKeyDownPoint(float f16, float f17) {
        PointF pointF = this.mJoyKeyPoint;
        if (pointF != null) {
            pointF.x = f16;
            pointF.y = f17;
        }
    }

    public void setJoyKeyID(int i3) {
        this.mJoyKeyID = i3;
    }

    public void setJoyKeyRadius(int i3) {
        this.mJoyKeyRadius = i3;
    }

    public void setJoyKeyState(int i3) {
        this.mJoyKeyState = i3;
    }

    public void setJoyKeyType(int i3) {
        this.mJoyKeyType = i3;
    }

    public void setJoyKeyUpPoint(float f16, float f17) {
        PointF pointF = this.mJoyKeyUpPoint;
        if (pointF != null) {
            pointF.x = f16;
            pointF.y = f17;
        }
    }

    public void onJoyREvent() {
    }

    public void onKeyEvent() {
    }

    public void onKeyJoyEvent() {
    }
}
