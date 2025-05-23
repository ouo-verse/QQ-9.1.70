package com.tencent.mobileqq.shortvideo.bighead;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BigHeadInitFilter {
    public static final String BGRA_NO_FILTER_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord).bgra;\n}\n";
    public static final String NO_FILTER_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n";
    private static final String TAG = "BigHeadInitFilter";
    public List<PointF> fullFaceCoords;
    private GPUBaseFilter mGPU2DFilter;
    private GPUBaseFilter mGPU2DFilterClip;
    private float mMaxScaleRatio;
    private RenderBuffer mRenderClip;
    private RenderBuffer mRenderInitFBO;
    private double mScreenScale;
    private int mTextureHeight;
    private int mTextureWidth;
    private boolean mUpdateFaceData;
    private int netInputWidth = 256;
    private int netInputHeight = 256;
    private float[] inMvpMatrix = new float[16];
    public float[] inClipMatrix = new float[16];
    private boolean mInited = false;
    private Rect mClipRegion = new Rect();
    private Rect mExtendRegion = new Rect();
    public Point zhongxin = new Point();
    private RectF mTextureRegion = new RectF();
    private Rect mWindows = new Rect();
    public int mMaxTextureLength = 0;
    public int mMaxConstLength = 0;
    private float mCurrentScaleRatio = 1.3f;
    private Rect mOutputExtendRegion = new Rect();
    public Rect mEnlargeSubRegion = new Rect();
    public float[] mUserTextureCoord = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    public BigHeadInitFilter() {
        Matrix.setIdentityM(this.inMvpMatrix, 0);
        Matrix.setRotateM(this.inMvpMatrix, 0, 270.0f, 0.0f, 0.0f, 1.0f);
    }

    private static float DISTANCE_OF(PointF pointF, PointF pointF2) {
        float f16 = pointF2.x - pointF.x;
        float f17 = pointF2.y - pointF.y;
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    private int getEvenInt(int i3) {
        return i3 - (i3 % 2);
    }

    public static void releaseRenderFBOTexture(RenderBuffer renderBuffer) {
        if (renderBuffer != null) {
            GLES20.glDeleteTextures(1, new int[]{renderBuffer.getTexId()}, 0);
        }
    }

    public void clipAllocateConstTexture(RenderBuffer renderBuffer, float f16) {
        if (renderBuffer.getTexId() == 0) {
            int evenInt = getEvenInt((int) (this.mMaxConstLength * f16));
            this.mMaxTextureLength = evenInt;
            renderBuffer.setUserTextureId(GlUtil.createTextureAllocate(evenInt, evenInt, false));
            int i3 = this.mMaxTextureLength;
            renderBuffer.setSize(i3, i3);
        }
    }

    public void drawTexture(int i3) {
        int i16;
        if (!this.mInited) {
            if (SLog.isEnable()) {
                SLog.d(TAG, "BigHeadInitFilter:drawTexture mInited=false");
                return;
            }
            return;
        }
        int width = this.mExtendRegion.width();
        int i17 = 0;
        if (width != this.mRenderClip.getWidth()) {
            GLES20.glDeleteTextures(1, new int[]{this.mRenderClip.getTexId()}, 0);
            this.mRenderClip.setUserTextureId(GlUtil.createTextureAllocate(width, width, false));
            this.mRenderClip.setSize(width, width);
        }
        this.mRenderClip.bind();
        GLES20.glClear(16384);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Rect rect = this.mExtendRegion;
        int i18 = rect.left;
        if (i18 < 0) {
            i16 = -i18;
        } else {
            i16 = 0;
        }
        int i19 = rect.top;
        if (i19 < 0) {
            i17 = -i19;
        }
        GLES20.glViewport(i16, i17, this.mClipRegion.width(), this.mClipRegion.height());
        this.mGPU2DFilterClip.drawTexture(i3, this.inClipMatrix, null);
        this.mRenderClip.unbind();
        int texId = this.mRenderClip.getTexId();
        this.mRenderInitFBO.bind();
        this.mGPU2DFilter.drawTexture(texId, null, this.inMvpMatrix);
        this.mRenderInitFBO.unbind();
    }

    public void drawTextureOptimize(int i3) {
        int i16;
        int i17;
        if (!this.mInited) {
            if (SLog.isEnable()) {
                SLog.d(TAG, "BigHeadInitFilter:drawTexture mInited=false");
                return;
            }
            return;
        }
        clipAllocateConstTexture(this.mRenderClip, this.mMaxScaleRatio);
        this.mRenderClip.bind();
        GLES20.glClear(16384);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        int width = this.mOutputExtendRegion.width();
        int i18 = (this.mMaxTextureLength - width) / 2;
        int i19 = width + i18;
        this.mEnlargeSubRegion.set(i18, i18, i19, i19);
        Rect rect = this.mExtendRegion;
        int i26 = rect.left;
        if (i26 < 0) {
            i16 = -i26;
        } else {
            i16 = 0;
        }
        int i27 = rect.top;
        if (i27 < 0) {
            i17 = -i27;
        } else {
            i17 = 0;
        }
        float f16 = this.mCurrentScaleRatio;
        int i28 = (int) (i16 * f16);
        int i29 = (int) (i17 * f16);
        int width2 = (int) (this.mClipRegion.width() * this.mCurrentScaleRatio);
        int height = (int) (this.mClipRegion.height() * this.mCurrentScaleRatio);
        Rect rect2 = this.mEnlargeSubRegion;
        GLES20.glViewport(rect2.left + i28, rect2.top + i29, width2, height);
        this.mGPU2DFilterClip.drawTexture(i3, this.inClipMatrix, null);
        this.mRenderClip.unbind();
        int texId = this.mRenderClip.getTexId();
        Rect rect3 = this.mEnlargeSubRegion;
        int i36 = this.mMaxTextureLength;
        float f17 = (rect3.left * 1.0f) / i36;
        float f18 = (rect3.top * 1.0f) / i36;
        Matrix.setIdentityM(this.inClipMatrix, 0);
        Matrix.translateM(this.inClipMatrix, 0, f17, f18, 0.0f);
        Matrix.scaleM(this.inClipMatrix, 0, (rect3.width() * 1.0f) / this.mMaxTextureLength, (this.mEnlargeSubRegion.height() * 1.0f) / this.mMaxTextureLength, 1.0f);
        this.mRenderInitFBO.bind();
        this.mGPU2DFilter.drawTexture(texId, this.inClipMatrix, this.inMvpMatrix);
        this.mRenderInitFBO.unbind();
    }

    public int getClippedTextureId() {
        return this.mRenderClip.getTexId();
    }

    public Rect getExtendEnlargeRegion() {
        return this.mOutputExtendRegion;
    }

    public Rect getExtendRegion() {
        return this.mExtendRegion;
    }

    public int getOutputTexture() {
        return this.mRenderInitFBO.getTexId();
    }

    public boolean getUpdateDataFlag() {
        return this.mUpdateFaceData;
    }

    public void init() {
        if (!this.mInited) {
            this.mRenderInitFBO = new RenderBuffer(this.netInputWidth, this.netInputHeight, 33987, true);
            GPUBaseFilter gPUBaseFilter = new GPUBaseFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", BGRA_NO_FILTER_FRAGMENT_SHADER);
            this.mGPU2DFilter = gPUBaseFilter;
            gPUBaseFilter.init();
            GPUBaseFilter gPUBaseFilter2 = new GPUBaseFilter();
            this.mGPU2DFilterClip = gPUBaseFilter2;
            gPUBaseFilter2.init();
            RenderBuffer renderBuffer = new RenderBuffer(false, 0, 0);
            this.mRenderClip = renderBuffer;
            renderBuffer.setUserTextureId(0);
            this.mInited = true;
        }
        this.mUpdateFaceData = false;
    }

    public void regionScaleCenterInteger(Rect rect, Rect rect2, float f16) {
        int evenInt = getEvenInt(((int) (rect.width() * f16)) / 2);
        Point point = this.zhongxin;
        int i3 = point.x;
        int i16 = point.y;
        rect2.set(i3 - evenInt, i16 - evenInt, i3 + evenInt, i16 + evenInt);
    }

    public void release() {
        if (this.mInited) {
            this.mInited = false;
            this.mGPU2DFilter.destroy();
            this.mRenderInitFBO.destroy();
            releaseRenderFBOTexture(this.mRenderInitFBO);
            this.mRenderClip.destroy();
            this.mGPU2DFilterClip.destroy();
            releaseRenderFBOTexture(this.mRenderClip);
        }
    }

    public void setCurrentScaleRatio(float f16) {
        this.mCurrentScaleRatio = f16;
    }

    public void setMaxScaleRatio(float f16) {
        this.mMaxScaleRatio = f16;
    }

    public void updateNetWorkSize(int i3, int i16) {
        this.netInputWidth = i3;
        this.netInputHeight = i16;
    }

    public void updateParams(List<PointF> list, float[] fArr) {
        this.mUpdateFaceData = true;
        this.fullFaceCoords = list;
        if (list != null && list.size() > 0) {
            for (PointF pointF : this.fullFaceCoords) {
                double d16 = pointF.x;
                double d17 = this.mScreenScale;
                pointF.x = (float) (d16 / d17);
                pointF.y = (float) (pointF.y / d17);
            }
            PointF pointF2 = this.fullFaceCoords.get(9);
            PointF pointF3 = this.fullFaceCoords.get(86);
            PointF pointF4 = this.fullFaceCoords.get(88);
            if (!this.mTextureRegion.contains(pointF2.x, pointF2.y)) {
                this.mUpdateFaceData = false;
                return;
            }
            if (!this.mTextureRegion.contains(pointF3.x, pointF3.y)) {
                this.mUpdateFaceData = false;
                return;
            }
            if (!this.mTextureRegion.contains(pointF4.x, pointF4.y)) {
                this.mUpdateFaceData = false;
                return;
            }
            float DISTANCE_OF = DISTANCE_OF(pointF3, pointF4);
            float max = Math.max(Math.max(DISTANCE_OF(pointF2, pointF3), DISTANCE_OF), DISTANCE_OF(pointF2, pointF4)) * 1.46f;
            int i3 = this.mMaxConstLength;
            if (max > i3) {
                max = i3;
            }
            int evenInt = getEvenInt((int) (max * 0.5f));
            this.zhongxin.set((int) (((pointF2.x + pointF3.x) + pointF4.x) / 3.0f), (int) (((pointF2.y + pointF3.y) + pointF4.y) / 3.0f));
            Point point = this.zhongxin;
            point.x = getEvenInt(point.x);
            Point point2 = this.zhongxin;
            point2.y = getEvenInt(point2.y);
            Point point3 = this.zhongxin;
            int i16 = point3.x - evenInt;
            int i17 = point3.y - evenInt;
            this.mExtendRegion.set(i16, i17, i16 + r1, r1 + i17);
            this.mClipRegion.setIntersect(this.mWindows, this.mExtendRegion);
            Rect rect = this.mClipRegion;
            float f16 = (rect.left * 1.0f) / this.mTextureWidth;
            float f17 = (rect.top * 1.0f) / this.mTextureHeight;
            Matrix.setIdentityM(this.inClipMatrix, 0);
            Matrix.translateM(this.inClipMatrix, 0, f16, f17, 0.0f);
            Matrix.scaleM(this.inClipMatrix, 0, (rect.width() * 1.0f) / this.mTextureWidth, (this.mClipRegion.height() * 1.0f) / this.mTextureHeight, 1.0f);
            regionScaleCenterInteger(this.mExtendRegion, this.mOutputExtendRegion, this.mCurrentScaleRatio);
            return;
        }
        this.mUpdateFaceData = false;
    }

    public void updateVideoSize(int i3, int i16, double d16) {
        this.mTextureWidth = i3;
        this.mTextureHeight = i16;
        this.mScreenScale = d16;
        this.mTextureRegion.set(0.0f, 0.0f, i3, i16);
        this.mWindows.set(0, 0, this.mTextureWidth, this.mTextureHeight);
        this.mMaxConstLength = Math.max(this.mTextureWidth, this.mTextureHeight);
    }
}
