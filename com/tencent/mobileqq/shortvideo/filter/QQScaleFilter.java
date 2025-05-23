package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQScaleFilter extends QQBaseFilter {
    private float[] ALPHA_BUFFER;
    private GPUAlphaFilter alphaRender;
    private GaussianBlurFilterCompose compose;
    private int frameIndex;
    private int frameRate;
    private GLImage glImage;
    private int height;
    private int imgSize;
    private RenderBuffer mRenderFBO;
    private float[] mvpMatrix;
    private GLImage nextGlImage;
    private List<String> pathList;
    private int picIndex;
    private int picRate;
    private FloatBuffer rgbaBuffer;
    private RenderBuffer scaleFBO;
    private TextureRender textureRender;
    private int width;

    public QQScaleFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.width = 640;
        this.height = 1280;
        this.frameIndex = 0;
        this.picIndex = 0;
        this.frameRate = 0;
        this.picRate = 0;
        this.imgSize = 0;
        this.ALPHA_BUFFER = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    }

    private void initTexture() {
        this.mRenderFBO = new RenderBuffer(this.width, this.height, 33984);
        this.scaleFBO = new RenderBuffer(this.width, this.height, 33984);
        this.textureRender = new TextureRender();
        GPUAlphaFilter gPUAlphaFilter = new GPUAlphaFilter();
        this.alphaRender = gPUAlphaFilter;
        gPUAlphaFilter.init();
        GaussianBlurFilterCompose gaussianBlurFilterCompose = new GaussianBlurFilterCompose();
        this.compose = gaussianBlurFilterCompose;
        gaussianBlurFilterCompose.init(this.width, this.height);
        this.glImage = new GLImage();
        this.nextGlImage = new GLImage();
        this.mvpMatrix = new float[16];
        this.rgbaBuffer = GlUtil.createFloatBuffer(this.ALPHA_BUFFER);
    }

    private void setArrayAlpha(float f16) {
        float[] fArr = this.ALPHA_BUFFER;
        fArr[3] = f16;
        fArr[7] = f16;
        fArr[11] = f16;
        fArr[15] = f16;
    }

    private void updateAlphaByteBuffer(float[] fArr) {
        FloatBuffer floatBuffer = this.rgbaBuffer;
        if (floatBuffer != null) {
            floatBuffer.put(fArr);
            this.rgbaBuffer.position(0);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        float f16;
        float f17;
        super.onDrawFrame();
        int i3 = this.frameIndex;
        int i16 = this.picRate;
        if (i3 % i16 == 0) {
            int i17 = i3 / i16;
            this.picIndex = i17;
            if (i17 < this.imgSize) {
                Log.d("rejectliu", "scale Filter OnDrawFrame frameIndex : " + this.frameIndex + "  picRate : " + this.picRate + " imgSize : " + this.imgSize + "  picIndex : " + this.picIndex);
                this.glImage.loadTextureSync(this.pathList.get(this.picIndex));
                int i18 = this.picIndex;
                if (i18 + 1 < this.imgSize) {
                    this.nextGlImage.loadTextureSync(this.pathList.get(i18 + 1));
                }
            }
        }
        int i19 = this.picIndex;
        int i26 = this.picRate;
        int i27 = i19 * i26;
        if (this.frameIndex >= i27) {
            f16 = (r2 - i27) / i26;
            f17 = (f16 * 0.1f) + 1.0f;
        } else {
            f16 = 0.0f;
            f17 = 1.0f;
        }
        Log.d("rejectliu", "frameIndex : " + this.frameIndex + " animRatio : " + f17 + " startIndex : " + i27 + " picRate : " + this.picRate + " animRatio : " + f17);
        this.mRenderFBO.bind();
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        GLES20.glClear(16384);
        this.mRenderFBO.unbind();
        float f18 = 1.0f - f16;
        float f19 = (f16 * 0.9f) + 0.1f;
        float f26 = (f18 * 0.9f) + 0.1f;
        if (this.picIndex + 1 < this.imgSize) {
            int texture = this.nextGlImage.getTexture();
            setArrayAlpha(f19);
            updateAlphaByteBuffer(this.ALPHA_BUFFER);
            this.compose.drawTexture(texture);
            int textureId = this.compose.getTextureId();
            this.mRenderFBO.bind();
            this.alphaRender.drawTexture(textureId, null, null, this.rgbaBuffer);
            setArrayAlpha(f19);
            updateAlphaByteBuffer(this.ALPHA_BUFFER);
            Matrix.setIdentityM(this.mvpMatrix, 0);
            Matrix.scaleM(this.mvpMatrix, 0, 1.0f, ((this.width / this.nextGlImage.getWidth()) * this.nextGlImage.getHeight()) / this.height, 1.0f);
            this.alphaRender.drawTexture(texture, null, this.mvpMatrix, this.rgbaBuffer);
            this.mRenderFBO.unbind();
        }
        this.mRenderFBO.bind();
        setArrayAlpha(f26);
        updateAlphaByteBuffer(this.ALPHA_BUFFER);
        this.alphaRender.drawTexture(this.mInputTextureID, null, null, this.rgbaBuffer);
        float width = ((this.width / this.glImage.getWidth()) * this.glImage.getHeight()) / this.height;
        int texture2 = this.glImage.getTexture();
        Matrix.setIdentityM(this.mvpMatrix, 0);
        Matrix.scaleM(this.mvpMatrix, 0, f17, f17, 1.0f);
        setArrayAlpha(f26);
        updateAlphaByteBuffer(this.ALPHA_BUFFER);
        int i28 = this.height;
        GLES20.glViewport(0, ((int) (i28 * (1.0f - width))) / 2, this.width, (int) (i28 * width));
        this.alphaRender.drawTexture(texture2, null, this.mvpMatrix, this.rgbaBuffer);
        GLES20.glViewport(0, 0, this.width, this.height);
        this.mRenderFBO.unbind();
        this.mOutputTextureID = this.mRenderFBO.getTexId();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
        this.width = i3;
        this.height = i16;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        super.onSurfaceCreate();
        initTexture();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    protected void parseSpecificParam() {
        Object obj = this.mSpecificParam;
        if (obj != null) {
            try {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.size() >= 2) {
                    this.width = ((Integer) arrayList.get(0)).intValue();
                    this.height = ((Integer) arrayList.get(1)).intValue();
                }
            } catch (ClassCastException unused) {
            }
        }
    }

    public void setFrameIndex(int i3) {
        this.frameIndex = i3;
    }

    public void setFrameRate(int i3) {
        this.frameRate = i3;
        this.picRate = i3 * 2;
    }

    public void setImageList(List<String> list) {
        this.pathList = list;
        this.imgSize = list.size();
    }
}
