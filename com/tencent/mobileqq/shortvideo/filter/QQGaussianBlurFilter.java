package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQGaussianBlurFilter extends QQBaseFilter {
    private GaussianBlurFilterCompose compose;
    private int frameIndex;
    private int frameRate;
    private GLImage glImage;
    private int height;
    private int imgSize;
    private RenderBuffer mRenderFBO;
    private List<String> pathList;
    private int picIndex;
    private int picRate;
    private TextureRender textureRender;
    private int width;

    public QQGaussianBlurFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.width = 640;
        this.height = 1280;
        this.frameIndex = 0;
        this.picIndex = 0;
        this.frameRate = 0;
        this.picRate = 0;
        this.imgSize = 0;
    }

    private void initTexture() {
        this.glImage = new GLImage();
        GaussianBlurFilterCompose gaussianBlurFilterCompose = new GaussianBlurFilterCompose();
        this.compose = gaussianBlurFilterCompose;
        gaussianBlurFilterCompose.init(this.width, this.height);
        this.mRenderFBO = new RenderBuffer(this.width, this.height, 33984);
        this.textureRender = new TextureRender();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        int i3 = this.frameIndex;
        int i16 = this.picRate;
        if (i3 % i16 == 0) {
            int i17 = i3 / i16;
            this.picIndex = i17;
            if (i17 < this.imgSize) {
                Log.d("rejectliu", "scale Filter OnDrawFrame frameIndex : " + this.frameIndex + "  picRate : " + this.picRate + " imgSize : " + this.imgSize + "  picIndex : " + this.picIndex);
                this.glImage.loadTextureSync(this.pathList.get(this.picIndex));
            }
        }
        this.compose.drawTexture(this.glImage.getTexture());
        int textureId = this.compose.getTextureId();
        this.mRenderFBO.bind();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, textureId, null, null);
        this.mRenderFBO.unbind();
        this.mOutputTextureID = this.mRenderFBO.getTexId();
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
