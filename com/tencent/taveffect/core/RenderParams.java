package com.tencent.taveffect.core;

import android.graphics.Matrix;

/* loaded from: classes26.dex */
public class RenderParams {
    private float opacity = 1.0f;
    private TAVRectangle rectangle;
    private int renderHeight;
    private int renderWidth;
    private Matrix textureMatrix;
    private Matrix vertexMatrix;

    public float getOpacity() {
        return this.opacity;
    }

    public TAVRectangle getRectangle() {
        return this.rectangle;
    }

    public int getRenderHeight() {
        return this.renderHeight;
    }

    public int getRenderWidth() {
        return this.renderWidth;
    }

    public Matrix getTextureMatrix() {
        return this.textureMatrix;
    }

    public Matrix getVertexMatrix() {
        return this.vertexMatrix;
    }

    public void setOpacity(float f16) {
        this.opacity = f16;
    }

    public void setRectangle(TAVRectangle tAVRectangle) {
        this.rectangle = tAVRectangle;
    }

    public void setRenderHeight(int i3) {
        this.renderHeight = i3;
    }

    public void setRenderWidth(int i3) {
        this.renderWidth = i3;
    }

    public void setTextureMatrix(Matrix matrix) {
        this.textureMatrix = matrix;
    }

    public void setVertexMatrix(Matrix matrix) {
        this.vertexMatrix = matrix;
    }

    public String toString() {
        return "RenderParams{renderWidth=" + this.renderWidth + ", renderHeight=" + this.renderHeight + ", vertexMatrix=" + this.vertexMatrix + ", textureMatrix=" + this.textureMatrix + ", rectangle=" + this.rectangle + ", opacity=" + this.opacity + '}';
    }
}
