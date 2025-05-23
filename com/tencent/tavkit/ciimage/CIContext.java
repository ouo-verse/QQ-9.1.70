package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.video.Releasable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CIContext implements Releasable {
    private RendererWrapper canvasRenderer;
    private TextureInfo canvasTexture;
    private RendererWrapper imageRenderer;
    private final String mTAG = "CIContext@" + Integer.toHexString(hashCode());
    private final RenderContext renderContext;

    public CIContext(@NonNull RenderContext renderContext) {
        this.renderContext = renderContext;
    }

    private void createCanvasTexture(RenderContext renderContext) {
        if (isRenderInfoChanged(renderContext)) {
            this.canvasTexture.release();
            this.canvasTexture = null;
        }
        if (this.canvasTexture == null) {
            this.canvasTexture = newTextureInfo(renderContext.width(), renderContext.height());
        }
    }

    private void createFilter() {
        if (this.canvasRenderer == null) {
            RendererWrapper rendererWrapper = new RendererWrapper();
            this.canvasRenderer = rendererWrapper;
            rendererWrapper.setOutputTextureInfo(this.canvasTexture);
        }
    }

    private boolean isRenderInfoChanged(RenderContext renderContext) {
        TextureInfo textureInfo = this.canvasTexture;
        if (textureInfo == null) {
            return false;
        }
        if (textureInfo.width == renderContext.width() && this.canvasTexture.height == renderContext.height()) {
            return false;
        }
        return true;
    }

    public static TextureInfo newTextureInfo(CGSize cGSize) {
        return newTextureInfo(cGSize.width, cGSize.height);
    }

    @Nullable
    public TextureInfo convertImageToTexture(CIImage cIImage, TextureInfo textureInfo) {
        if (cIImage != null && textureInfo != null) {
            if (this.imageRenderer == null) {
                this.imageRenderer = new RendererWrapper();
            }
            this.imageRenderer.setOutputTextureInfo(textureInfo);
            this.imageRenderer.clearBufferBuffer(-16777216);
            cIImage.drawTo(this.imageRenderer);
            return textureInfo;
        }
        return null;
    }

    @NonNull
    public CMSampleBuffer convertToSampleBuffer(@NonNull CIImage cIImage, @NonNull CMTime cMTime, @NonNull RenderContext renderContext) {
        renderContext.makeCurrent();
        createCanvasTexture(renderContext);
        createFilter();
        this.canvasRenderer.clearBufferBuffer(-16777216);
        cIImage.drawTo(this.canvasRenderer);
        return new CMSampleBuffer(cMTime, this.canvasTexture, false);
    }

    @NonNull
    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    @Override // com.tencent.tavkit.composition.video.Releasable
    public void release() {
        Logger.d(this.mTAG, "release: begin, currentThread = " + Thread.currentThread().getName());
        RendererWrapper rendererWrapper = this.canvasRenderer;
        if (rendererWrapper != null) {
            rendererWrapper.release();
        }
        TextureInfo textureInfo = this.canvasTexture;
        if (textureInfo != null) {
            textureInfo.release();
        }
        RendererWrapper rendererWrapper2 = this.imageRenderer;
        if (rendererWrapper2 != null) {
            rendererWrapper2.release();
        }
        Logger.d(this.mTAG, "release: end, currentThread = " + Thread.currentThread().getName());
    }

    @NonNull
    public static TextureInfo newTextureInfo(float f16, float f17) {
        return newTextureInfo((int) f16, (int) f17);
    }

    public static TextureInfo newTextureInfo(int i3, int i16) {
        return newTextureInfo(i3, i16, false);
    }

    @NonNull
    public static TextureInfo newTextureInfo(int i3, int i16, boolean z16) {
        TextureInfo textureInfo = new TextureInfo(RenderContext.createTexture(GLSLRender.GL_TEXTURE_2D), GLSLRender.GL_TEXTURE_2D, i3, i16, null, 0);
        textureInfo.setFormat(6408);
        if (z16) {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, textureInfo.textureID);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, textureInfo.getFormat(), textureInfo.width, textureInfo.height, 0, textureInfo.getFormat(), NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        return textureInfo;
    }
}
