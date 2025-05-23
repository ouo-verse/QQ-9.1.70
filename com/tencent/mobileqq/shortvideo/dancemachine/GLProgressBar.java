package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.animation.Animation;

/* loaded from: classes18.dex */
public class GLProgressBar extends GlView {
    private GLImageView mBackgroundView;
    private ProgressBarListener mListener;
    private int mMaxProgress;
    private long mProgress;
    private boolean mProgressChanged;
    private GLImage mProgressImage;
    private float mProgressMaxSize;
    private String mResProgressPath;
    private boolean mSizeChanged;
    private int mStretchLeft;
    private int mStretchRight;
    private float xLeftCoordinate;
    private float xRightCoordinate;

    /* loaded from: classes18.dex */
    public interface ProgressBarListener {
        void progressMax();
    }

    public GLProgressBar(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mProgressChanged = false;
        this.mSizeChanged = false;
        this.mResProgressPath = "";
        this.mProgressImage = new GLImage();
        this.mProgress = 0L;
        this.mMaxProgress = 1;
        initView(8);
        this.mBackgroundView = new GLImageView(gLViewContext, str);
        resetFlagValue();
    }

    private float computeProgressDistance(float f16, float f17) {
        float width = this.context.getViewPort().width() - (this.mClipRegion.left * 2.0f);
        this.mProgressMaxSize = width;
        return (((width - f16) - f17) * ((float) this.mProgress)) / this.mMaxProgress;
    }

    private void computeVertexTextureCoordinate() {
        float width = this.mSizeRegion.width();
        this.xLeftCoordinate = this.mStretchLeft / width;
        this.xRightCoordinate = this.mStretchRight / width;
    }

    private boolean layoutHasChange() {
        if (!this.mSizeChanged && !this.mProgressChanged && !this.mBackgroundView.updateParam()) {
            return false;
        }
        return true;
    }

    private void reconstructProgressRegionByBackGround() {
        RectF rectF = this.mSizeRegion;
        float f16 = rectF.left;
        GLImageView gLImageView = this.mBackgroundView;
        RectF rectF2 = gLImageView.mSizeRegion;
        float f17 = f16 - rectF2.left;
        float f18 = rectF.top - rectF2.top;
        RectF currentDrawRegionSize = gLImageView.getCurrentDrawRegionSize();
        RectF rectF3 = this.mClipRegion;
        float f19 = currentDrawRegionSize.left + f17;
        rectF3.left = f19;
        rectF3.top = currentDrawRegionSize.top + f18;
        rectF3.right = f19 + this.mSizeRegion.width();
        RectF rectF4 = this.mClipRegion;
        rectF4.bottom = rectF4.top + this.mSizeRegion.height();
        Color4f color4f = this.mBackgroundView.mColor;
        this.mColor.setValue(color4f.getRed(), color4f.getGreen(), color4f.getBlue(), color4f.getAlpha());
    }

    private void resetFlagValue() {
        this.mSizeChanged = false;
        this.mProgressChanged = false;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void clearAnimation() {
        this.mBackgroundView.clearAnimation();
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void clearStatus() {
        super.clearStatus();
        this.mProgress = 0L;
        this.mBackgroundView.clearStatus();
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void draw() {
        if (this.mVisible) {
            this.mBackgroundView.draw();
            if (this.mProgress > 0) {
                drawInternal();
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public Animation getAnimation() {
        return this.mBackgroundView.getAnimation();
    }

    public RectF getBackgroundRegion() {
        return this.mBackgroundView.mSizeRegion;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public RectF getCurrentDrawRegionSize() {
        return this.mBackgroundView.getCurrentDrawRegionSize();
    }

    public GLImage getProgressImage() {
        return this.mProgressImage;
    }

    public RectF gettBackgroundClipRegion() {
        return this.mBackgroundView.mClipRegion;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void release() {
        clearStatus();
        super.release();
        this.mProgressImage.release();
        this.mResProgressPath = "";
        this.mBackgroundView.release();
    }

    public void setBackgroundClipRegion(RectF rectF) {
        this.mBackgroundView.setImageClipDrawRegion(rectF);
    }

    public void setBackgroundImageBitmap(Bitmap bitmap) {
        this.mBackgroundView.setImageBitmap(bitmap);
    }

    public void setBackgroundImageRes(String str) {
        this.mBackgroundView.setImageRes(str);
    }

    public void setBackgroundRegion(RectF rectF) {
        this.mBackgroundView.setImageRegion(rectF);
    }

    public void setMaxProgress(int i3) {
        this.mMaxProgress = i3;
    }

    public void setProgress(long j3) {
        ProgressBarListener progressBarListener;
        long j16 = this.mProgress;
        int i3 = this.mMaxProgress;
        if (j16 < i3) {
            this.mProgress = j3;
            if (j3 > i3) {
                this.mProgress = i3;
            }
            this.mProgressChanged = true;
            return;
        }
        if (j16 >= i3 && (progressBarListener = this.mListener) != null) {
            progressBarListener.progressMax();
        }
    }

    public void setProgressBarListener(ProgressBarListener progressBarListener) {
        this.mListener = progressBarListener;
    }

    public void setProgressImageBitmap(Bitmap bitmap) {
        this.mProgressImage.loadTextureSync(bitmap);
    }

    public void setProgressImageRes(String str) {
        if (!this.mResProgressPath.equals(str)) {
            this.mProgressImage.loadTextureSync(str);
            this.mResProgressPath = str;
        }
    }

    public void setProgressRegion(RectF rectF) {
        if (!this.mSizeRegion.equals(rectF)) {
            this.mSizeRegion.set(rectF);
            mapSizeRegion();
            this.mClipRegion.set(rectF);
            mapClipRegion();
            this.mSizeChanged = true;
        }
    }

    public void setProgressStretchRelativeRegion(int i3, int i16) {
        if (this.mSizeChanged) {
            this.mStretchLeft = (int) (i3 * this.context.getViewPortRatio());
            this.mStretchRight = (int) (i16 * this.context.getViewPortRatio());
            computeVertexTextureCoordinate();
            return;
        }
        throw new RuntimeException("Must called after setProgressRegion");
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void setVisibility(boolean z16) {
        this.mVisible = z16;
        this.mBackgroundView.setVisibility(z16);
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void startAnimation(Animation animation) {
        this.mBackgroundView.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void transferVertexData() {
        this.mCurrentTexture = this.mProgressImage.getTexture();
        surfaceCoordinateMapToViewPortSize();
        this.context.getViewPort();
        reconstructProgressRegionByBackGround();
        float width = this.mClipRegion.width() - this.mStretchRight;
        float computeProgressDistance = computeProgressDistance(this.mStretchLeft, width);
        PointF pointF = this.mVertexPointCache[0];
        RectF rectF = this.mClipRegion;
        pointF.set(rectF.left, rectF.top);
        PointF pointF2 = this.mVertexPointCache[1];
        RectF rectF2 = this.mClipRegion;
        pointF2.set(rectF2.left, rectF2.bottom);
        PointF pointF3 = this.mVertexPointCache[2];
        RectF rectF3 = this.mClipRegion;
        pointF3.set(rectF3.left + this.mStretchLeft, rectF3.top);
        PointF pointF4 = this.mVertexPointCache[3];
        RectF rectF4 = this.mClipRegion;
        pointF4.set(rectF4.left + this.mStretchLeft, rectF4.bottom);
        RectF rectF5 = this.mClipRegion;
        float f16 = rectF5.left + this.mStretchLeft + computeProgressDistance;
        this.mVertexPointCache[4].set(f16, rectF5.top);
        this.mVertexPointCache[5].set(f16, this.mClipRegion.bottom);
        float f17 = f16 + width;
        this.mVertexPointCache[6].set(f17, this.mClipRegion.top);
        this.mVertexPointCache[7].set(f17, this.mClipRegion.bottom);
        this.mVertexBuffer.position(0);
        setVertexCoordinateData(this.mZOrderValue);
        this.mVertexBuffer.put(0.0f);
        this.mVertexBuffer.put(0.0f);
        this.mVertexBuffer.put(0.0f);
        this.mVertexBuffer.put(1.0f);
        this.mVertexBuffer.put(this.xLeftCoordinate);
        this.mVertexBuffer.put(0.0f);
        this.mVertexBuffer.put(this.xLeftCoordinate);
        this.mVertexBuffer.put(1.0f);
        this.mVertexBuffer.put(this.xRightCoordinate);
        this.mVertexBuffer.put(0.0f);
        this.mVertexBuffer.put(this.xRightCoordinate);
        this.mVertexBuffer.put(1.0f);
        this.mVertexBuffer.put(1.0f);
        this.mVertexBuffer.put(0.0f);
        this.mVertexBuffer.put(1.0f);
        this.mVertexBuffer.put(1.0f);
        setColorAttributeValue();
        this.mVertexBuffer.position(0);
        this.mVertexNum = 8;
        this.mDrawMode = 0;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public boolean updateParam() {
        boolean updateParam = super.updateParam();
        if (!updateParam) {
            boolean layoutHasChange = layoutHasChange();
            resetFlagValue();
            return layoutHasChange;
        }
        return updateParam;
    }
}
