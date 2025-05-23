package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FBO {
    private int frameBuffer;
    private int frameBufferTexture;

    FBO() {
    }

    public static FBO newInstance() {
        return new FBO();
    }

    public void bind() {
        GLES20.glBindFramebuffer(36160, this.frameBuffer);
    }

    public FBO create(int i3, int i16) {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glGenTextures(1, iArr2, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr2[0]);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, iArr2[0], 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glBindFramebuffer(36160, 0);
        this.frameBuffer = iArr[0];
        this.frameBufferTexture = iArr2[0];
        return this;
    }

    public void destroy() {
        GLES20.glDeleteTextures(1, new int[]{this.frameBufferTexture}, 0);
        GLES20.glDeleteFramebuffers(1, new int[]{this.frameBuffer}, 0);
    }

    public int getFrameBuffer() {
        return this.frameBuffer;
    }

    public int getFrameBufferTextureId() {
        return this.frameBufferTexture;
    }

    public void unbind() {
        GLES20.glBindFramebuffer(36160, 0);
    }
}
