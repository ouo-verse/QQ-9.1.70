package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class GlView {
    public static final int BLEND_ADDITIVE = 2;
    public static final int BLEND_ALPHA = 1;
    private static final int BLEND_MASK = 7;
    public static final int BLEND_MULTIPLIED = 4;
    static final int FLOAT_BYTE = 4;
    private static final int PFLAG_ANIMATION_STARTED = 65536;
    static final int POINTS = 3;
    static final int TRIANGLES = 1;
    static final int TRIANGLE_FAN = 2;
    static final int TRIANGLE_STRIP = 0;
    protected GLViewContext context;
    private Transformation mChildTransformation;
    private Animation mCurrentAnimation;
    protected int mCurrentTexture;
    protected boolean mEnableNegativeVertexAdjust;
    protected GLShaderManager.GLProgram mProgramObject;
    private String mShaderKey;
    private boolean mUseAdjustTextureCoord;
    protected FloatBuffer mVertexBuffer;
    protected int mVertexNum;
    protected PointF[] mVertexPointCache;
    protected boolean mVisible;
    private static final float[] TEXTURE_COORD = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public static boolean ENABLE_X_INVERSE = false;
    private int mBlendMode = 1;
    protected RectF mSizeRegion = new RectF();
    protected boolean mEnableClip = false;
    protected RectF mClipRegion = new RectF();
    protected Color4f mColor = new Color4f(1.0f, 1.0f, 1.0f, 1.0f);
    protected int mDrawMode = 2;
    private int[] bufferId = new int[1];
    private int mPrivateFlags = 0;
    private Matrix matrix = new Matrix();
    private RectF mCurrentDrawRegion = new RectF();
    protected int mVertexPointCount = 4;
    protected float mZOrderValue = -0.5f;
    private float[] adjustTextureCoord = new float[8];
    protected boolean mHaveMappedSize = false;
    protected boolean mHaveMappedClipSize = false;
    private float[] srcPoint = new float[2];
    private float[] dstPoint = new float[2];
    protected boolean mRequestUpdate = false;

    public GlView(GLViewContext gLViewContext, String str) {
        this.mEnableNegativeVertexAdjust = false;
        this.mUseAdjustTextureCoord = false;
        this.context = gLViewContext;
        this.mShaderKey = str;
        this.mProgramObject = GLShaderManager.createProgram(str);
        this.mEnableNegativeVertexAdjust = false;
        this.mUseAdjustTextureCoord = false;
    }

    private void allocateFloatBuffer(int i3) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(i3 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mVertexBuffer = asFloatBuffer;
        asFloatBuffer.position(0);
    }

    private boolean animationHasTranslateAnimation() {
        Animation animation = this.mCurrentAnimation;
        if (animation != null) {
            if (animation instanceof TranslateAnimation) {
                return true;
            }
            if (animation instanceof AnimationSet) {
                Iterator<Animation> it = ((AnimationSet) animation).getAnimations().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof TranslateAnimation) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void disableBlend() {
        GLES20.glDisable(3042);
    }

    private void drawRegion() {
        int i3 = this.mDrawMode;
        if (i3 == 0) {
            GLES20.glDrawArrays(5, 0, this.mVertexNum);
            return;
        }
        if (i3 == 1) {
            GLES20.glDrawArrays(4, 0, this.mVertexNum);
        } else if (i3 == 2) {
            GLES20.glDrawArrays(6, 0, this.mVertexNum);
        } else if (i3 == 3) {
            GLES20.glDrawArrays(0, 0, this.mVertexNum);
        }
    }

    private void enableBlend() {
        int i3 = this.mBlendMode;
        if ((i3 & 2) == 2) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, 1);
        } else if ((i3 & 4) == 4) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(0, 768);
        } else {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        }
    }

    private boolean isAnimationStarted() {
        if ((this.mPrivateFlags & 65536) == 65536) {
            return true;
        }
        return false;
    }

    private void mapPointData(int i3, int i16) {
        for (int i17 = 0; i17 < i16; i17++) {
            float[] fArr = this.srcPoint;
            int i18 = i3 + i17;
            PointF pointF = this.mVertexPointCache[i18];
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            this.matrix.mapPoints(this.dstPoint, fArr);
            PointF pointF2 = this.mVertexPointCache[i18];
            float[] fArr2 = this.dstPoint;
            pointF2.x = fArr2[0];
            pointF2.y = fArr2[1];
        }
    }

    private void negativeVertexAdjust() {
        PointF[] pointFArr = this.mVertexPointCache;
        float f16 = pointFArr[1].y;
        if (f16 <= 0.0f) {
            pointFArr[0].set(0.0f, 0.0f);
            this.mVertexPointCache[1].set(0.0f, 0.0f);
            this.mVertexPointCache[2].set(0.0f, 0.0f);
            this.mVertexPointCache[3].set(0.0f, 0.0f);
            int i3 = 0;
            while (true) {
                float[] fArr = this.adjustTextureCoord;
                if (i3 < fArr.length) {
                    fArr[0] = 0.0f;
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            PointF pointF = pointFArr[0];
            float f17 = pointF.y;
            if (f17 < 0.0f) {
                float f18 = f16 - f17;
                float f19 = (f18 - f16) / f18;
                float[] fArr2 = this.adjustTextureCoord;
                fArr2[0] = 0.0f;
                fArr2[1] = f19;
                fArr2[2] = 0.0f;
                fArr2[3] = 1.0f;
                fArr2[4] = 1.0f;
                fArr2[5] = 1.0f;
                fArr2[6] = 1.0f;
                fArr2[7] = f19;
                pointF.y = 0.0f;
                pointFArr[3].y = 0.0f;
            }
        }
    }

    private void setAnimation(Animation animation) {
        this.mCurrentAnimation = animation;
        if (animation != null) {
            if (animation.getStartTime() == -1) {
                animation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            }
            animation.reset();
        }
    }

    private void setMapDataToRegion(RectF rectF) {
        PointF[] pointFArr = this.mVertexPointCache;
        PointF pointF = pointFArr[0];
        rectF.left = pointF.x;
        rectF.top = pointF.y;
        PointF pointF2 = pointFArr[2];
        rectF.right = pointF2.x;
        rectF.bottom = pointF2.y;
    }

    public void clearAnimation() {
        this.mCurrentAnimation = null;
        setAlpha(1.0f);
    }

    public void draw() {
        if (this.mVisible) {
            drawInternal();
        }
    }

    public final void drawInternal() {
        if (this.mProgramObject == null) {
            DanceLog.print("GlView", "GlView: drawInternal mProgramObject=null");
            return;
        }
        enableBlend();
        GLES20.glViewport(this.context.getViewPort().left, this.context.getViewPort().top, this.context.getViewPort().width(), this.context.getViewPort().height());
        GLES20.glUseProgram(this.mProgramObject.programId);
        GLES20.glUniformMatrix4fv(this.mProgramObject.uniform.get("u_projectionMatrix").intValue(), 1, false, this.context.getProjectMatrix(), 0);
        GLES20.glBindBuffer(34962, this.bufferId[0]);
        GlUtil.checkGlError("glBindBuffer");
        if (updateParam()) {
            transferVertexData();
            this.mVertexBuffer.position(0);
            GLES20.glBufferData(34962, this.mVertexBuffer.capacity() * 4, this.mVertexBuffer, 35044);
        }
        updateAttribute();
        drawRegion();
        GLES20.glBindBuffer(34962, 0);
        disableBlend();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void generateAnimationVertexData() {
        boolean z16;
        boolean z17;
        Rect viewPort = this.context.getViewPort();
        Animation animation = getAnimation();
        if (animation != null) {
            if (!animation.isInitialized()) {
                animation.initialize((int) this.mClipRegion.width(), (int) this.mClipRegion.height(), viewPort.width(), viewPort.height());
                onAnimationStart();
            }
            if (this.mChildTransformation == null) {
                this.mChildTransformation = new Transformation();
            }
            this.mChildTransformation.getMatrix().reset();
            this.mChildTransformation.setAlpha(1.0f);
            boolean transformation = animation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.mChildTransformation);
            if (isAnimationStarted() && animation.hasEnded()) {
                onAnimationEnd();
            }
            if (!transformation && animation.getFillAfter()) {
                transformation = true;
            }
            if (transformation) {
                setAlpha(this.mChildTransformation.getAlpha());
                if (!this.mChildTransformation.getMatrix().isIdentity()) {
                    this.matrix.reset();
                    this.matrix.set(this.mChildTransformation.getMatrix());
                    if (!animationHasTranslateAnimation()) {
                        Matrix matrix = this.matrix;
                        RectF rectF = this.mClipRegion;
                        matrix.postTranslate(rectF.left, rectF.top);
                    }
                    this.mVertexPointCache[0].set(0.0f, 0.0f);
                    this.mVertexPointCache[1].set(0.0f, this.mClipRegion.height());
                    this.mVertexPointCache[2].set(this.mClipRegion.width(), this.mClipRegion.height());
                    this.mVertexPointCache[3].set(this.mClipRegion.width(), 0.0f);
                    mapPointData(0, 4);
                    setMapDataToRegion(this.mCurrentDrawRegion);
                    z16 = true;
                    z17 = z16;
                    if (!z16) {
                        setAlpha(1.0f);
                    }
                    if (!z17) {
                        PointF pointF = this.mVertexPointCache[0];
                        RectF rectF2 = this.mClipRegion;
                        pointF.set(rectF2.left, rectF2.top);
                        PointF pointF2 = this.mVertexPointCache[1];
                        RectF rectF3 = this.mClipRegion;
                        pointF2.set(rectF3.left, rectF3.bottom);
                        PointF pointF3 = this.mVertexPointCache[2];
                        RectF rectF4 = this.mClipRegion;
                        pointF3.set(rectF4.right, rectF4.bottom);
                        PointF pointF4 = this.mVertexPointCache[3];
                        RectF rectF5 = this.mClipRegion;
                        pointF4.set(rectF5.right, rectF5.top);
                        this.mCurrentDrawRegion.set(this.mClipRegion);
                    }
                    if (this.mEnableNegativeVertexAdjust) {
                        negativeVertexAdjust();
                        this.mUseAdjustTextureCoord = true;
                        return;
                    }
                    return;
                }
                z16 = true;
                z17 = false;
                if (!z16) {
                }
                if (!z17) {
                }
                if (this.mEnableNegativeVertexAdjust) {
                }
            }
        }
        z16 = false;
        z17 = z16;
        if (!z16) {
        }
        if (!z17) {
        }
        if (this.mEnableNegativeVertexAdjust) {
        }
    }

    public Animation getAnimation() {
        return this.mCurrentAnimation;
    }

    public RectF getCurrentDrawRegionSize() {
        return this.mCurrentDrawRegion;
    }

    public void initView(int i3) {
        GLShaderManager.GLProgram gLProgram = this.mProgramObject;
        if (gLProgram == null) {
            DanceLog.print("GlView", "GlView: initView mProgramObject=null");
            return;
        }
        this.mVertexPointCount = i3;
        allocateFloatBuffer(gLProgram.getVertexAttributeSize() * this.mVertexPointCount);
        this.mVertexPointCache = new PointF[this.mVertexPointCount];
        int i16 = 0;
        GLES20.glGenBuffers(1, this.bufferId, 0);
        while (true) {
            PointF[] pointFArr = this.mVertexPointCache;
            if (i16 < pointFArr.length) {
                pointFArr[i16] = new PointF();
                i16++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void mapClipRegion() {
        if (!this.mHaveMappedClipSize) {
            this.context.mapNormalRegion(this.mClipRegion);
            this.mHaveMappedClipSize = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void mapSizeRegion() {
        if (!this.mHaveMappedSize) {
            this.context.mapNormalRegion(this.mSizeRegion);
            this.mHaveMappedSize = true;
        }
    }

    protected void onAnimationEnd() {
        this.mPrivateFlags &= -65537;
    }

    protected void onAnimationStart() {
        this.mPrivateFlags |= 65536;
    }

    public void release() {
        clearStatus();
    }

    public void setAlpha(float f16) {
        this.mColor.setValue(1.0f, 1.0f, 1.0f, f16);
        this.mRequestUpdate = true;
    }

    public final void setBlendMode(int i3) {
        this.mBlendMode = i3 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setColorAttributeValue() {
        for (int i3 = 0; i3 < this.mVertexPointCount; i3++) {
            this.mColor.putValue(this.mVertexBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setVertexCoordinateData(float f16) {
        boolean equals = this.context.getSurfaceViewSize().equals(this.context.getViewPort());
        for (int i3 = 0; i3 < this.mVertexPointCount; i3++) {
            if (equals) {
                this.mVertexBuffer.put(this.mVertexPointCache[i3].x);
            } else if (ENABLE_X_INVERSE) {
                this.mVertexBuffer.put(this.context.getViewPort().width() - this.mVertexPointCache[i3].x);
            } else {
                this.mVertexBuffer.put(this.mVertexPointCache[i3].x);
            }
            this.mVertexBuffer.put(this.mVertexPointCache[i3].y);
            this.mVertexBuffer.put(f16);
        }
    }

    public void setVisibility(boolean z16) {
        this.mVisible = z16;
    }

    protected void setZOrderValue(float f16) {
        this.mZOrderValue = f16;
    }

    public void startAnimation(Animation animation) {
        if (this.mCurrentAnimation == null) {
            animation.setStartTime(-1L);
            setAnimation(animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void surfaceCoordinateMapToViewPortSize() {
        mapSizeRegion();
        mapClipRegion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void transferVertexData() {
        surfaceCoordinateMapToViewPortSize();
        generateAnimationVertexData();
        this.mVertexBuffer.position(0);
        setVertexCoordinateData(this.mZOrderValue);
        if (this.mEnableClip && this.mSizeRegion.contains(this.mClipRegion)) {
            float f16 = this.mClipRegion.left;
            RectF rectF = this.mSizeRegion;
            float width = (f16 - rectF.left) / rectF.width();
            RectF rectF2 = this.mSizeRegion;
            float width2 = (rectF2.right - this.mClipRegion.right) / rectF2.width();
            float f17 = this.mClipRegion.top;
            RectF rectF3 = this.mSizeRegion;
            float height = (f17 - rectF3.top) / rectF3.height();
            RectF rectF4 = this.mSizeRegion;
            float height2 = (rectF4.bottom - this.mClipRegion.bottom) / rectF4.height();
            this.mVertexBuffer.put(width);
            this.mVertexBuffer.put(height);
            this.mVertexBuffer.put(width);
            float f18 = 1.0f - height2;
            this.mVertexBuffer.put(f18);
            float f19 = 1.0f - width2;
            this.mVertexBuffer.put(f19);
            this.mVertexBuffer.put(f18);
            this.mVertexBuffer.put(f19);
            this.mVertexBuffer.put(height);
        } else if (this.mUseAdjustTextureCoord) {
            this.mVertexBuffer.put(this.adjustTextureCoord);
            this.mUseAdjustTextureCoord = false;
        } else {
            this.mVertexBuffer.put(TEXTURE_COORD);
        }
        setColorAttributeValue();
        this.mVertexNum = 4;
        this.mDrawMode = 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateAttribute() {
        int intValue = this.mProgramObject.attribute.get("a_position").intValue();
        GLES20.glVertexAttribPointer(intValue, 3, 5126, false, 0, 0);
        GLES20.glEnableVertexAttribArray(intValue);
        int intValue2 = this.mProgramObject.attribute.get("a_texCoord").intValue();
        GLES20.glVertexAttribPointer(intValue2, 2, 5126, false, 0, this.mProgramObject.getTextureOffset() * this.mVertexPointCount * 4);
        GLES20.glEnableVertexAttribArray(intValue2);
        int intValue3 = this.mProgramObject.attribute.get("a_color").intValue();
        GLES20.glVertexAttribPointer(intValue3, 4, 5126, false, 0, this.mProgramObject.getColorOffset() * this.mVertexPointCount * 4);
        GLES20.glEnableVertexAttribArray(intValue3);
        int intValue4 = this.mProgramObject.uniform.get("u_texture").intValue();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mCurrentTexture);
        GLES20.glUniform1i(intValue4, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean updateParam() {
        boolean z16 = this.mRequestUpdate;
        this.mRequestUpdate = false;
        if (this.mCurrentAnimation == null && !z16) {
            return false;
        }
        return true;
    }

    public void clearStatus() {
    }
}
