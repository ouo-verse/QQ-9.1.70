package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;

/* loaded from: classes27.dex */
public class PtvFilterOpenglFrameBuffer {
    public static final boolean DEBUG_ON = true;
    private boolean mNeedDepth;
    private boolean mNeedStencil;
    private int mVideoHeight;
    private int mVideoWidth;
    private int[] mStatusCheck = new int[1];
    private int[] mFrameBufferId = new int[1];
    private int[] mRenderBufferDepth = new int[1];
    private int[] mRenderBufferStencil = new int[1];

    public static void checkErrorCode(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            GLLogMsg("checkErrorCode: errFunc =" + str + "err=" + glGetError);
        }
    }

    private void initReanderBuffer() {
        if (this.mNeedDepth) {
            GLES20.glGenRenderbuffers(1, this.mRenderBufferDepth, 0);
            checkErrorCode("glGenRenderbuffers");
            GLES20.glBindRenderbuffer(36161, this.mRenderBufferDepth[0]);
            checkErrorCode("glBindRenderbuffer:0");
            GLES20.glRenderbufferStorage(36161, 33189, this.mVideoWidth, this.mVideoHeight);
            checkErrorCode("glRenderbufferStorage:0");
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mRenderBufferDepth[0]);
            checkErrorCode("glFramebufferRenderbuffer:0");
        }
        if (this.mNeedStencil) {
            GLES20.glGenRenderbuffers(1, this.mRenderBufferStencil, 0);
            checkErrorCode("glGenRenderbuffers");
            GLES20.glBindRenderbuffer(36161, this.mRenderBufferStencil[0]);
            checkErrorCode("glBindRenderbuffer:0");
            GLES20.glRenderbufferStorage(36161, 36168, this.mVideoWidth, this.mVideoHeight);
            GLES20.glFramebufferRenderbuffer(36160, 36128, 36161, this.mRenderBufferStencil[0]);
        }
    }

    public boolean initFrameBuffer(boolean z16, boolean z17, int i3) {
        this.mNeedDepth = z16;
        this.mNeedStencil = z17;
        checkErrorCode("glIsTexture");
        GLES20.glGenFramebuffers(1, this.mFrameBufferId, 0);
        checkErrorCode("glGenFramebuffers");
        GLES20.glBindFramebuffer(36160, this.mFrameBufferId[0]);
        checkErrorCode("glBindFramebuffer");
        initReanderBuffer();
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        checkErrorCode("glFramebufferTexture2D");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            checkErrorCode("glCheckFramebufferStatus: status=" + glCheckFramebufferStatus);
            return false;
        }
        makeCurrentFrameBuffer();
        return true;
    }

    public void initSharedTextureMemory(int i3, int i16, int i17) {
        this.mVideoWidth = i16;
        this.mVideoHeight = i17;
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        checkErrorCode("glBindTexture");
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
        checkErrorCode("glTexParameteri");
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
        checkErrorCode("glTexParameteri");
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        checkErrorCode("glTexParameteri");
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        checkErrorCode("glTexParameteri");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.mVideoWidth, this.mVideoHeight, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        checkErrorCode("glTexImage2D");
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        checkErrorCode("glBindTexture");
    }

    public void makeCurrentFrameBuffer() {
        GLES20.glBindFramebuffer(36160, this.mFrameBufferId[0]);
        GLES20.glGetIntegerv(36006, this.mStatusCheck, 0);
        GLLogMsg("[makeCurrentFrameBuffer]GL_FRAMEBUFFER_BINDING: mStatusCheck=" + this.mStatusCheck[0] + " mFrameBufferId[0]=" + this.mFrameBufferId[0]);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("glBindFramebuffer: [makeCurrentFrameBuffer]mFrameBufferId=");
        sb5.append(this.mFrameBufferId[0]);
        checkErrorCode(sb5.toString());
    }

    public void release() {
        restoreToWindFrameBuffer();
        if (this.mNeedDepth) {
            GLES20.glDeleteRenderbuffers(1, this.mRenderBufferDepth, 0);
        }
        if (this.mNeedStencil) {
            GLES20.glDeleteRenderbuffers(1, this.mRenderBufferStencil, 0);
        }
        GLES20.glDeleteFramebuffers(1, this.mFrameBufferId, 0);
        this.mFrameBufferId[0] = 0;
        this.mRenderBufferDepth[0] = 0;
        this.mRenderBufferStencil[0] = 0;
    }

    public void restoreToWindFrameBuffer() {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glGetIntegerv(36006, this.mStatusCheck, 0);
        GLLogMsg("[restoreToWindFrameBuffer]GL_FRAMEBUFFER_BINDING: mStatusCheck=" + this.mStatusCheck[0]);
        checkErrorCode("glBindFramebuffer: [restoreToWindFrameBuffer]mFrameBufferId=0");
    }

    public static void GLLogMsg(String str) {
    }
}
