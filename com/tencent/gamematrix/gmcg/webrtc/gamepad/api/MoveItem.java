package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MoveItem {
    private int mType = 0;
    private int mKeyCode = 0;
    private String mKeyName = null;
    private float mPercentX = 0.0f;
    private float mPercentY = 0.0f;
    private boolean mIsValid = false;
    private int mMoveDirection = 0;

    public int getKeyCode() {
        return this.mKeyCode;
    }

    public String getKeyName() {
        return this.mKeyName;
    }

    public int getMoveDirection() {
        return this.mMoveDirection;
    }

    public float getPercentX() {
        return this.mPercentX;
    }

    public float getPercentY() {
        return this.mPercentY;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setKeyCode(int i3) {
        this.mKeyCode = i3;
    }

    public void setKeyName(String str) {
        this.mKeyName = str;
    }

    public void setMoveDirection(int i3) {
        this.mMoveDirection = i3;
    }

    public void setPercentX(float f16) {
        this.mPercentX = f16;
    }

    public void setPercentY(float f16) {
        this.mPercentY = f16;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setValid(boolean z16) {
        this.mIsValid = z16;
    }
}
