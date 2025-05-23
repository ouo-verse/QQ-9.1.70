package com.tencent.ttpic.openapi.filter;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLES30;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RenderBuffer {
    private int activeTexUnit;
    private int frameBufferId;
    private int height;
    private int initialTexId;
    private boolean mTextureOutside;
    private int renderBufferId;
    private int texId;
    private boolean useRenderBuffer;
    private int width;

    @TargetApi(18)
    public RenderBuffer(int i3, int i16, int i17, boolean z16) {
        this(true, i3, i16, i17, z16);
    }

    public void bind() {
        GLES20.glViewport(0, 0, this.width, this.height);
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.texId, 0);
        if (this.useRenderBuffer) {
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.renderBufferId);
        }
    }

    public void destroy() {
        int[] iArr = {this.frameBufferId};
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        if (this.useRenderBuffer) {
            iArr[0] = this.renderBufferId;
            GLES20.glDeleteRenderbuffers(1, iArr, 0);
        }
        int i3 = this.texId;
        if (i3 > 0) {
            GlUtil.deleteTexture(i3);
        }
    }

    public int getActiveTexUnit() {
        return this.activeTexUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTexId() {
        return this.texId;
    }

    public int getWidth() {
        return this.width;
    }

    public void recoverInitialTexId() {
        this.texId = this.initialTexId;
    }

    public void setSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public void setTexId(int i3) {
        this.texId = i3;
    }

    public void setUserTextureId(int i3) {
        this.mTextureOutside = true;
        this.texId = i3;
    }

    public void unbind() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    @TargetApi(18)
    public RenderBuffer(boolean z16, int i3, int i16, int i17, boolean z17) {
        int i18;
        this.texId = 0;
        this.initialTexId = 0;
        this.renderBufferId = 0;
        this.frameBufferId = 0;
        this.mTextureOutside = false;
        this.width = i3;
        this.height = i16;
        this.activeTexUnit = i17;
        this.useRenderBuffer = z16;
        int[] iArr = new int[1];
        GLES20.glActiveTexture(i17);
        this.texId = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D);
        if (z17) {
            GLES30.glTexStorage2D(GLSLRender.GL_TEXTURE_2D, 1, 32856, i3, i16);
            i18 = 3553;
        } else {
            i18 = 3553;
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        GLES20.glTexParameterf(i18, 10241, 9729.0f);
        GLES20.glTexParameterf(i18, 10240, 9729.0f);
        GLES20.glTexParameteri(i18, 10242, 33071);
        GLES20.glTexParameteri(i18, 10243, 33071);
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i19 = iArr[0];
        this.frameBufferId = i19;
        GLES20.glBindFramebuffer(36160, i19);
        if (z16) {
            GLES20.glGenRenderbuffers(1, iArr, 0);
            int i26 = iArr[0];
            this.renderBufferId = i26;
            GLES20.glBindRenderbuffer(36161, i26);
            GLES20.glRenderbufferStorage(36161, 33189, i3, i16);
        }
        unbind();
    }

    public RenderBuffer(int i3, int i16, int i17) {
        this(true, i3, i16, i17);
    }

    public RenderBuffer(boolean z16, int i3, int i16, int i17) {
        this.texId = 0;
        this.initialTexId = 0;
        this.renderBufferId = 0;
        this.frameBufferId = 0;
        this.mTextureOutside = false;
        this.width = i3;
        this.height = i16;
        this.activeTexUnit = i17;
        this.useRenderBuffer = z16;
        int[] iArr = new int[1];
        GLES20.glActiveTexture(i17);
        int createTexture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D);
        this.texId = createTexture;
        this.initialTexId = createTexture;
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i18 = iArr[0];
        this.frameBufferId = i18;
        GLES20.glBindFramebuffer(36160, i18);
        if (z16) {
            GLES20.glGenRenderbuffers(1, iArr, 0);
            int i19 = iArr[0];
            this.renderBufferId = i19;
            GLES20.glBindRenderbuffer(36161, i19);
            GLES20.glRenderbufferStorage(36161, 33189, i3, i16);
        }
        unbind();
    }

    public RenderBuffer(boolean z16, int i3, int i16) {
        this.texId = 0;
        this.initialTexId = 0;
        this.activeTexUnit = 0;
        this.renderBufferId = 0;
        this.frameBufferId = 0;
        this.mTextureOutside = false;
        int[] iArr = new int[1];
        this.width = i3;
        this.height = i16;
        this.useRenderBuffer = z16;
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i17 = iArr[0];
        this.frameBufferId = i17;
        GLES20.glBindFramebuffer(36160, i17);
        if (z16) {
            GLES20.glGenRenderbuffers(1, iArr, 0);
            int i18 = iArr[0];
            this.renderBufferId = i18;
            GLES20.glBindRenderbuffer(36161, i18);
            GLES20.glRenderbufferStorage(36161, 33189, i3, i16);
        }
        unbind();
    }

    public RenderBuffer(int i3, int i16) {
        this.texId = 0;
        this.initialTexId = 0;
        this.activeTexUnit = 0;
        this.renderBufferId = 0;
        this.frameBufferId = 0;
        this.useRenderBuffer = true;
        this.mTextureOutside = false;
        this.width = i3;
        this.height = i16;
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i17 = iArr[0];
        this.frameBufferId = i17;
        GLES20.glBindFramebuffer(36160, i17);
        this.useRenderBuffer = true;
        GLES20.glGenRenderbuffers(1, iArr, 0);
        int i18 = iArr[0];
        this.renderBufferId = i18;
        GLES20.glBindRenderbuffer(36161, i18);
        GLES20.glRenderbufferStorage(36161, 33189, i3, i16);
        unbind();
    }
}
