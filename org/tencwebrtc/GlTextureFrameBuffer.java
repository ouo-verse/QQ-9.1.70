package org.tencwebrtc;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GlTextureFrameBuffer {
    private int frameBufferId;
    private int height;
    private final int pixelFormat;
    private int textureId;
    private int width;

    public GlTextureFrameBuffer(int i3) {
        switch (i3) {
            case 6407:
            case 6408:
            case MonetPacketDescriptor.MonetDataFormat.R8 /* 6409 */:
                this.pixelFormat = i3;
                this.width = 0;
                this.height = 0;
                return;
            default:
                throw new IllegalArgumentException("Invalid pixel format: " + i3);
        }
    }

    public int getFrameBufferId() {
        return this.frameBufferId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTextureId() {
        return this.textureId;
    }

    public int getWidth() {
        return this.width;
    }

    public void release() {
        GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
        this.textureId = 0;
        GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
        this.frameBufferId = 0;
        this.width = 0;
        this.height = 0;
    }

    public void setSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            if (i3 == this.width && i16 == this.height) {
                return;
            }
            this.width = i3;
            this.height = i16;
            if (this.textureId == 0) {
                this.textureId = GlUtil.generateTexture(GLSLRender.GL_TEXTURE_2D);
            }
            if (this.frameBufferId == 0) {
                int[] iArr = new int[1];
                GLES20.glGenFramebuffers(1, iArr, 0);
                this.frameBufferId = iArr[0];
            }
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureId);
            int i17 = this.pixelFormat;
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, i17, i3, i16, 0, i17, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
            GLES20.glBindFramebuffer(36160, this.frameBufferId);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.textureId, 0);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus == 36053) {
                GLES20.glBindFramebuffer(36160, 0);
                return;
            }
            throw new IllegalStateException("Framebuffer not complete, status: " + glCheckFramebufferStatus);
        }
        throw new IllegalArgumentException("Invalid size: " + i3 + HippyTKDListViewAdapter.X + i16);
    }
}
