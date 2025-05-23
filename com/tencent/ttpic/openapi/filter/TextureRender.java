package com.tencent.ttpic.openapi.filter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TextureRender {
    public static final int DISPLAY_FULL = 0;
    public static final int DISPLAY_LEFT_HALF = 1;
    public static final int DISPLAY_RIGHT_HALF = 2;
    private GPUBaseFilter mGPU2DFilter = new GPUBaseFilter();
    private GPUOESBaseFilter mGPUOESFilter = new GPUOESBaseFilter();

    public TextureRender() {
        this.mGPU2DFilter.init();
        this.mGPUOESFilter.init();
    }

    public void drawTexture(int i3, int i16, float[] fArr, float[] fArr2) {
        if (i3 == 36197) {
            this.mGPUOESFilter.drawTexture(i16, fArr, fArr2);
        } else {
            if (i3 == 3553) {
                this.mGPU2DFilter.drawTexture(i16, fArr, fArr2);
                return;
            }
            throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
        }
    }

    public void release() {
        this.mGPU2DFilter.destroy();
        this.mGPUOESFilter.destroy();
    }
}
