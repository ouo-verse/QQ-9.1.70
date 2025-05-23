package com.tencent.tavkit.tavffmpeg;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;

/* compiled from: P */
/* loaded from: classes26.dex */
public class YUVConvert {
    private int[] mFbo;
    private TextureInfo mRGBATextureInfo;
    private byte[] mYUV;
    private byte[] mYUVA;
    private YUVAFilter mYUVAFilter = new YUVAFilter();
    private TextureInfo mYUVATextureInfo;

    public byte[] covertToYUV420P(int i3, int i16, int i17) {
        int i18 = i16 * i17;
        int i19 = i18 * 4;
        int i26 = (i18 * 3) / 2;
        byte[] bArr = this.mYUVA;
        if (bArr == null || bArr.length != i19) {
            this.mYUVA = new byte[i19];
        }
        byte[] bArr2 = this.mYUV;
        if (bArr2 == null || bArr2.length != i19) {
            this.mYUV = new byte[i26];
        }
        getYUVATextureInfo(i3, i16, i17);
        GLES20.glBindFramebuffer(36160, 0);
        return this.mYUV;
    }

    public TextureInfo getYUVATextureInfo(int i3, int i16, int i17) {
        TextureInfo textureInfo = this.mRGBATextureInfo;
        if (textureInfo == null || textureInfo.textureID != i3) {
            this.mRGBATextureInfo = new TextureInfo(i3, GLSLRender.GL_TEXTURE_2D, i16, i17, 0);
        }
        if (this.mYUVATextureInfo == null) {
            this.mYUVATextureInfo = RenderContext.newTextureInfo(i16, i17);
        }
        this.mYUVAFilter.setRenderForScreen(false);
        this.mYUVAFilter.setRendererWidth(i16);
        this.mYUVAFilter.setRendererHeight(i17);
        this.mYUVAFilter.setDesTextureInfo(this.mYUVATextureInfo);
        this.mYUVAFilter.clearBufferBuffer(-16777216);
        this.mYUVAFilter.applyFilter(this.mRGBATextureInfo);
        return this.mYUVATextureInfo;
    }

    public void release() {
        int[] iArr = this.mFbo;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(1, iArr, 0);
        }
        this.mYUVAFilter.release();
    }
}
