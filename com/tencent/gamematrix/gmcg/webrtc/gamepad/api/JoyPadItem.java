package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

/* loaded from: classes6.dex */
public class JoyPadItem {
    protected int type = 0;
    protected boolean isValid = false;
    protected boolean isShowRadius = false;
    protected float percentX = 0.0f;
    protected float percentY = 0.0f;
    protected int radius = 0;
    protected float sensitivity = 0.0f;

    public float getPercentX() {
        return this.percentX;
    }

    public float getPercentY() {
        return this.percentY;
    }

    public int getRadius() {
        return this.radius;
    }

    public float getSensitivity() {
        return this.sensitivity;
    }

    public int getType() {
        return this.type;
    }

    public boolean isShowRadius() {
        return this.isShowRadius;
    }

    public boolean isValid() {
        return this.isValid;
    }
}
