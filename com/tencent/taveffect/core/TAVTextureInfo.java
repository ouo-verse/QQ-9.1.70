package com.tencent.taveffect.core;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVTextureInfo {
    public long frameTimeUs;
    public int height;
    public int preRotation;
    public int textureID;
    public int textureType;
    public float[] transformMatrix;
    public int width;

    public TAVTextureInfo(int i3, int i16, int i17, int i18, float[] fArr, int i19) {
        this.textureID = i3;
        this.textureType = i16;
        this.width = i17;
        this.height = i18;
        this.transformMatrix = fArr;
        this.preRotation = i19;
    }

    public String formatSize() {
        return this.width + "*" + this.height;
    }

    public long getFrameTimeUs() {
        return this.frameTimeUs;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPreRotation() {
        return this.preRotation;
    }

    public int getTextureID() {
        return this.textureID;
    }

    public int getTextureType() {
        return this.textureType;
    }

    public float[] getTransformMatrix() {
        return this.transformMatrix;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFrameTimeUs(long j3) {
        this.frameTimeUs = j3;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setPreRotation(int i3) {
        this.preRotation = i3;
    }

    public void setTextureID(int i3) {
        this.textureID = i3;
    }

    public void setTextureType(int i3) {
        this.textureType = i3;
    }

    public void setTransformMatrix(float[] fArr) {
        this.transformMatrix = fArr;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public TAVTextureInfo() {
    }
}
