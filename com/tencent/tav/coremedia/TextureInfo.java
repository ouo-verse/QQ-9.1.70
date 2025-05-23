package com.tencent.tav.coremedia;

import android.graphics.Matrix;
import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TextureInfo {
    private int format;
    private int frameBuffer;
    public final int height;
    private boolean mixAlpha;
    private boolean needRelease;
    public final int preferRotation;
    private boolean released;
    public final int textureID;
    private Matrix textureMatrix;
    public final int textureType;
    public final int width;

    public TextureInfo(int i3, int i16, int i17, int i18, int i19) {
        this.frameBuffer = -1;
        this.needRelease = false;
        this.mixAlpha = true;
        this.format = 6407;
        this.textureMatrix = null;
        this.textureID = i3;
        this.textureType = i16;
        this.width = i17;
        this.height = i18;
        this.preferRotation = i19;
    }

    public int getFormat() {
        return this.format;
    }

    public int getFrameBuffer() {
        return this.frameBuffer;
    }

    public Matrix getTextureMatrix() {
        return this.textureMatrix;
    }

    public boolean isMixAlpha() {
        return this.mixAlpha;
    }

    public boolean isNeedRelease() {
        return this.needRelease;
    }

    public boolean isReleased() {
        return this.released;
    }

    public void release() {
        this.released = true;
        int i3 = this.frameBuffer;
        if (i3 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
            this.frameBuffer = -1;
        }
        GLES20.glDeleteTextures(1, new int[]{this.textureID}, 0);
    }

    public void setFormat(int i3) {
        this.format = i3;
    }

    public void setFrameBuffer(int i3) {
        this.frameBuffer = i3;
    }

    public void setMixAlpha(boolean z16) {
        this.mixAlpha = z16;
    }

    public void setTextureMatrix(Matrix matrix) {
        this.textureMatrix = matrix;
    }

    public String toString() {
        return "TextureInfo{textureID=" + this.textureID + ", textureType=" + this.textureType + ", width=" + this.width + ", height=" + this.height + ", preferRotation=" + this.preferRotation + ", textureMatrix=" + this.textureMatrix + ", frameBuffer=" + this.frameBuffer + ", needRelease=" + this.needRelease + ", mixAlpha=" + this.mixAlpha + ", format=" + this.format + '}';
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TextureInfo m261clone() {
        TextureInfo textureInfo = new TextureInfo(this.textureID, this.textureType, this.width, this.height, this.textureMatrix, this.preferRotation);
        textureInfo.needRelease = true;
        return textureInfo;
    }

    public TextureInfo(int i3, int i16, int i17, int i18, Matrix matrix, int i19) {
        this.frameBuffer = -1;
        this.needRelease = false;
        this.mixAlpha = true;
        this.format = 6407;
        this.textureMatrix = matrix;
        this.textureID = i3;
        this.textureType = i16;
        this.width = i17;
        this.height = i18;
        this.preferRotation = i19;
    }
}
