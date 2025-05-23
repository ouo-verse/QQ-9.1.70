package com.tencent.tav.core.compositing;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoCompositionRenderContext {
    RectF edgeWidths;
    private RenderContext renderContext;
    private float renderScale;
    private Matrix renderTransform;
    private CGSize size;
    private VideoComposition videoComposition;
    private TextureInfo videoTexture;

    public VideoCompositionRenderContext(@NonNull RenderContext renderContext) {
        this.renderContext = renderContext;
        this.size = new CGSize(renderContext.width(), renderContext.height());
    }

    public RectF getEdgeWidths() {
        return this.edgeWidths;
    }

    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    public float getRenderScale() {
        return this.renderScale;
    }

    public Matrix getRenderTransform() {
        return this.renderTransform;
    }

    public CGSize getSize() {
        return this.size;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    @Nullable
    public TextureInfo newTextureInfo() {
        if (this.videoTexture == null) {
            RenderContext.checkEglError("newSampleBuffer");
            int createTexture = RenderContext.createTexture(GLSLRender.GL_TEXTURE_2D);
            CGSize cGSize = this.size;
            this.videoTexture = new TextureInfo(createTexture, GLSLRender.GL_TEXTURE_2D, (int) cGSize.width, (int) cGSize.height, 0);
        }
        return this.videoTexture;
    }

    public void setVideoComposition(VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
    }

    public String toString() {
        return "VideoCompositionRenderContext{size=" + this.size + ", renderContext=" + this.renderContext + '}';
    }
}
