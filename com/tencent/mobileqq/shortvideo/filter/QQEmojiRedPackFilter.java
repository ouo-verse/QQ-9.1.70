package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* loaded from: classes18.dex */
public class QQEmojiRedPackFilter extends QQBaseFilter {
    public static final String TAG = "QQEmojiRedPackFilter";
    private RenderBuffer mRenderFBO;
    private GPUAlphaBlendFilter mWatermarkFilter;
    private int mWatermarkHeight;
    private String mWatermarkPath;
    private int mWatermarkTextureIdForEncode;
    private int mWatermarkWidth;

    public QQEmojiRedPackFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(185, qQFilterRenderManager);
        this.mWatermarkTextureIdForEncode = -1;
    }

    private void initWatermark(String str, int i3, int i16) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                Matrix matrix = new Matrix();
                matrix.postScale(i3 / decodeFile.getWidth(), i16 / decodeFile.getHeight());
                Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                this.mWatermarkTextureIdForEncode = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, createBitmap);
                this.mWatermarkWidth = createBitmap.getWidth();
                this.mWatermarkHeight = createBitmap.getHeight();
                createBitmap.recycle();
            } catch (Throwable unused) {
            }
            GPUAlphaBlendFilter gPUAlphaBlendFilter = new GPUAlphaBlendFilter();
            this.mWatermarkFilter = gPUAlphaBlendFilter;
            gPUAlphaBlendFilter.onOutputSizeChanged(this.mWatermarkWidth, this.mWatermarkHeight);
            this.mWatermarkFilter.init();
            this.mRenderFBO = new RenderBuffer(this.mWatermarkWidth, this.mWatermarkHeight, 33984);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        super.onDrawFrame();
        if (TextUtils.isEmpty(this.mWatermarkPath)) {
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        int filterWidth = getQQFilterRenderManager().getFilterWidth();
        int filterHeight = getQQFilterRenderManager().getFilterHeight();
        if (this.mWatermarkFilter == null) {
            initWatermark(this.mWatermarkPath, filterWidth, filterHeight);
        }
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.recoverInitialTexId();
            renderBuffer.setTexId(this.mInputTextureID);
            renderBuffer.bind();
            if (this.mWatermarkFilter != null) {
                int i3 = this.mWatermarkWidth;
                int i16 = this.mWatermarkHeight;
                float[] caculateCenterCropMvpMatrix = GPUBaseFilter.caculateCenterCropMvpMatrix(i3, i16, i3, i16);
                android.opengl.Matrix.setIdentityM(caculateCenterCropMvpMatrix, 0);
                android.opengl.Matrix.scaleM(caculateCenterCropMvpMatrix, 0, 1.0f, -1.0f, 1.0f);
                this.mWatermarkFilter.drawTexture(this.mWatermarkTextureIdForEncode, null, caculateCenterCropMvpMatrix);
            }
            renderBuffer.unbind();
        }
        this.mOutputTextureID = this.mInputTextureID;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        GPUAlphaBlendFilter gPUAlphaBlendFilter = this.mWatermarkFilter;
        if (gPUAlphaBlendFilter != null) {
            gPUAlphaBlendFilter.destroy();
        }
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
    }

    public void setWatermarkPath(String str) {
        this.mWatermarkPath = str;
    }
}
