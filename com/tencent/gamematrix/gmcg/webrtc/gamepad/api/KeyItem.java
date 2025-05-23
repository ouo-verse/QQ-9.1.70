package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import android.graphics.PointF;

/* compiled from: P */
/* loaded from: classes6.dex */
public class KeyItem {
    protected String path = null;
    protected int[] keyCodes = null;
    protected String keyName = null;
    protected float percentX = 0.0f;
    protected float percentY = 0.0f;
    protected boolean isValid = false;
    protected int keyType = 0;
    protected int radius = 0;
    protected int pressure = 0;
    protected PointF pos = null;
    protected float sensitivity = 1.0f;

    public int[] getKeyCodes() {
        return this.keyCodes;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public String getPath() {
        return this.path;
    }

    public float getPercentX() {
        return this.percentX;
    }

    public float getPercentY() {
        return this.percentY;
    }

    public PointF getPos() {
        return this.pos;
    }

    public int getPressure() {
        return this.pressure;
    }

    public int getRadius() {
        return this.radius;
    }

    public float getSensitivity() {
        return this.sensitivity;
    }

    public int getType() {
        return this.keyType;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setPos(float f16, float f17) {
        PointF pointF = this.pos;
        if (pointF == null) {
            this.pos = new PointF(f16, f17);
        } else {
            pointF.x = f16;
            pointF.y = f17;
        }
    }

    public void setPressure(int i3) {
        this.pressure = i3;
    }
}
