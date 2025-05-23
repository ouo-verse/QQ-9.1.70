package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQTextEjectaFilter extends QQBaseFilter {
    private int blurTex;
    private GaussianBlurFilterCompose compose;
    private GLImage glImage;
    private int imageBgTextureId;
    EjectaTextureCallBack mEjectaTextureCallBack;
    private String mImagePath;
    boolean mIsNeedCameraTexture;
    int[] mIsNeedReverseTexture;
    private RenderBuffer mRenderFBO;
    float[] mvpMatrix;
    private int[] tex;
    float[] textureMatrix;
    TextureRender textureRender;
    private int videoHeight;
    private int videoWidth;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface EjectaTextureCallBack {
        int[] onDrawFrame();
    }

    public QQTextEjectaFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.tex = new int[]{-1};
        this.videoWidth = 720;
        this.videoHeight = 1280;
        this.mIsNeedCameraTexture = true;
        this.mIsNeedReverseTexture = new int[]{0, 0};
        this.textureMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.mvpMatrix = new float[16];
        this.imageBgTextureId = 0;
        this.blurTex = 0;
        initTexture();
    }

    private int getBgImageTextrueId() {
        if (TextUtils.isEmpty(this.mImagePath)) {
            this.imageBgTextureId = 0;
            return 0;
        }
        if (this.imageBgTextureId == 0) {
            this.glImage.loadTextureSync(this.mImagePath);
            this.imageBgTextureId = this.glImage.getTexture();
        }
        return this.imageBgTextureId;
    }

    private void initTexture() {
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        TextureRender textureRender = this.textureRender;
        if (textureRender != null) {
            textureRender.release();
        }
        this.glImage = new GLImage();
        this.mRenderFBO = new RenderBuffer(this.videoWidth, this.videoHeight, 33986);
        this.textureRender = new TextureRender();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        int[] iArr = this.tex;
        if (iArr != null && iArr.length > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        boolean z16;
        float[] fArr;
        EjectaTextureCallBack ejectaTextureCallBack = this.mEjectaTextureCallBack;
        if (ejectaTextureCallBack != null) {
            this.tex = ejectaTextureCallBack.onDrawFrame();
        }
        int[] iArr = this.tex;
        if (iArr != null && iArr.length != 0) {
            try {
                int bgImageTextrueId = getBgImageTextrueId();
                if (bgImageTextrueId != 0 && this.blurTex == 0) {
                    if (this.compose == null) {
                        GaussianBlurFilterCompose gaussianBlurFilterCompose = new GaussianBlurFilterCompose();
                        this.compose = gaussianBlurFilterCompose;
                        gaussianBlurFilterCompose.init(this.videoWidth, this.videoHeight);
                    }
                    this.compose.drawTexture(bgImageTextrueId);
                    this.blurTex = this.compose.getTextureId();
                }
                this.mRenderFBO.bind();
                if (this.mIsNeedCameraTexture) {
                    this.textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, this.mInputTextureID, null, null);
                } else {
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                }
                if (bgImageTextrueId != 0) {
                    int i3 = this.blurTex;
                    if (i3 != 0) {
                        this.textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, this.textureMatrix, null);
                    }
                    Matrix.setIdentityM(this.mvpMatrix, 0);
                    Matrix.scaleM(this.mvpMatrix, 0, 1.0f, ((this.videoWidth / this.glImage.getWidth()) * this.glImage.getHeight()) / this.videoHeight, 1.0f);
                    this.textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, bgImageTextrueId, this.textureMatrix, this.mvpMatrix);
                }
                int i16 = 0;
                while (true) {
                    int[] iArr2 = this.tex;
                    if (i16 < iArr2.length) {
                        if (iArr2[i16] > 0) {
                            int[] iArr3 = this.mIsNeedReverseTexture;
                            if (i16 < iArr3.length && iArr3[i16] == 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            GLES20.glEnable(3042);
                            GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
                            TextureRender textureRender = this.textureRender;
                            int i17 = this.tex[i16];
                            if (z16) {
                                fArr = this.textureMatrix;
                            } else {
                                fArr = null;
                            }
                            textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i17, fArr, null);
                            GLES20.glDisable(3042);
                        }
                        i16++;
                    } else {
                        GLES20.glGetError();
                        this.mRenderFBO.unbind();
                        this.mOutputTextureID = this.mRenderFBO.getTexId();
                        return;
                    }
                }
            } catch (Throwable unused) {
                this.mRenderFBO.unbind();
                this.mOutputTextureID = this.mRenderFBO.getTexId();
            }
        } else {
            this.mOutputTextureID = this.mInputTextureID;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        GaussianBlurFilterCompose gaussianBlurFilterCompose = this.compose;
        if (gaussianBlurFilterCompose != null) {
            gaussianBlurFilterCompose.destroy();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    protected void parseSpecificParam() {
        Object obj = this.mSpecificParam;
        if (obj != null && (obj instanceof EjectaTextureCallBack)) {
            this.mEjectaTextureCallBack = (EjectaTextureCallBack) obj;
        }
    }

    public void setImagePath(String str) {
        this.imageBgTextureId = 0;
        this.blurTex = 0;
        this.mImagePath = str;
    }

    public void setIsNeedCameraTexture(boolean z16) {
        this.mIsNeedCameraTexture = z16;
    }

    public void setIsNeedReverseTexture(int[] iArr) {
        this.mIsNeedReverseTexture = iArr;
    }
}
