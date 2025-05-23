package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class RendererWrapper extends Renderer {
    private int clearColor;
    private TextureInfo destTextureInfo;
    private final Renderer oesRenderer = new Renderer();
    private final Renderer rgbRenderer = new Renderer();

    @Override // com.tencent.tavkit.ciimage.Renderer
    public void clearBufferBuffer(int i3) {
        this.clearColor = i3;
        this.oesRenderer.clearBufferBuffer(i3);
        this.rgbRenderer.clearBufferBuffer(i3);
    }

    @Override // com.tencent.tavkit.ciimage.Renderer
    public void release() {
        this.oesRenderer.release();
        this.rgbRenderer.release();
    }

    @Override // com.tencent.tavkit.ciimage.Renderer
    public TextureInfo render(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f16, CGRect cGRect) {
        if (textureInfo == null) {
            return null;
        }
        if (textureInfo.textureType == 36197) {
            return this.oesRenderer.render(textureInfo, matrix, matrix2, f16, cGRect);
        }
        return this.rgbRenderer.render(textureInfo, matrix, matrix2, f16, cGRect);
    }

    @Override // com.tencent.tavkit.ciimage.Renderer
    public void setOutputTextureInfo(TextureInfo textureInfo) {
        this.destTextureInfo = textureInfo;
        this.oesRenderer.setOutputTextureInfo(textureInfo);
        this.rgbRenderer.setOutputTextureInfo(textureInfo);
    }

    @Override // com.tencent.tavkit.ciimage.Renderer
    public String toString() {
        return "CIImageFilter{program=" + this.program + ", clearColor=" + this.clearColor + ", destTextureInfo=" + this.destTextureInfo + '}';
    }
}
