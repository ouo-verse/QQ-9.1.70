package com.qzone.module.feedcomponent.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.PathInterpolator;
import com.qzone.module.feedcomponent.util.QcircleShareFeedSizeUtil;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AutoVideoCover extends BaseVideoCover {
    public static final int ALPHA_ANIMATION_FIRST_DURATION = 200;
    public static final int ALPHA_ANIMATION_SECOND_DURATION = 120;
    public static final int ANIMATION_TOTAL_DURATION = 960;
    public static final int LOADING_FOREGROUND_COLOR = Color.parseColor("#ffcd00");
    public static final int SCALE_ANIMATION_FIRST_DURATION = 640;
    boolean hideCover;
    boolean isCardTypeView;
    boolean isFeedTypeDetail;
    boolean isForward;
    int loadingAlpha;
    ValueAnimator loadingAlphaAnimatorFirst;
    ValueAnimator loadingAlphaAnimatorSecond;
    ValueAnimator loadingAlphaAnimatorThird;
    AnimatorSet loadingAlphaAnimators;
    AnimatorSet loadingAnimators;
    int loadingDeltaWidth;
    Rect loadingRectBg;
    Rect loadingRectFg;
    ValueAnimator loadingScaleAnimatorFirst;
    ValueAnimator loadingScaleAnimatorSecond;
    AnimatorSet loadingScaleAnimators;
    protected int mAdjustHeight;
    protected int mAdjustWidth;
    protected Matrix mCenterCropMatrix;
    protected Matrix mFitCenterMatrix;
    protected boolean mIsAdjustToHeight;
    protected boolean mIsAdjustWidth;
    protected boolean mIsCenterCrop;
    protected boolean mIsClipCoverCenter;
    protected boolean mIsFitCenter;
    protected boolean mIsForceWH;
    boolean mIsSetPlayIcon;
    Drawable mPlayIconDrawable;
    int oldCoverWidth;
    Paint paint;

    public AutoVideoCover(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
        this.mIsSetPlayIcon = false;
        this.paint = new Paint();
        this.loadingScaleAnimatorFirst = null;
        this.loadingScaleAnimatorSecond = null;
        this.loadingScaleAnimators = null;
        this.loadingAlphaAnimatorFirst = null;
        this.loadingAlphaAnimatorSecond = null;
        this.loadingAlphaAnimatorThird = null;
        this.loadingAlphaAnimators = null;
        this.loadingAnimators = null;
        this.mIsAdjustToHeight = false;
        this.mAdjustHeight = -1;
        this.mIsAdjustWidth = false;
        this.mAdjustWidth = -1;
        this.mIsClipCoverCenter = false;
        this.mIsCenterCrop = false;
        this.mIsFitCenter = false;
        this.mIsForceWH = false;
    }

    private boolean checkLoadingAnimationData() {
        return (this.loadingRectBg == null || this.loadingRectFg == null || this.oldCoverWidth != getWidth()) ? false : true;
    }

    private Matrix getCenterCropMatrix() {
        float f16;
        float f17;
        Matrix matrix = this.mCenterCropMatrix;
        if (matrix != null) {
            return matrix;
        }
        int intrinsicWidth = this.singleDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.singleDrawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        this.singleDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        int i3 = this.mCoverWidth;
        int i16 = this.mCoverHeight;
        float f18 = 0.0f;
        if (intrinsicWidth * i16 > i3 * intrinsicHeight) {
            f17 = i16 / intrinsicHeight;
            float f19 = (i3 - (intrinsicWidth * f17)) * 0.5f;
            f16 = 0.0f;
            f18 = f19;
        } else {
            float f26 = i3 / intrinsicWidth;
            f16 = (i16 - (intrinsicHeight * f26)) * 0.5f;
            f17 = f26;
        }
        Matrix matrix2 = new Matrix();
        this.mCenterCropMatrix = matrix2;
        matrix2.setScale(f17, f17);
        this.mCenterCropMatrix.postTranslate(Math.round(f18), Math.round(f16));
        return this.mCenterCropMatrix;
    }

    private int getCoverCenterBottom() {
        if (this.singleDrawable.getIntrinsicWidth() == 0) {
            return this.mCoverHeight;
        }
        float intrinsicWidth = (this.mCoverWidth / this.singleDrawable.getIntrinsicWidth()) * this.singleDrawable.getIntrinsicHeight();
        int i3 = this.mCoverHeight;
        float f16 = i3;
        return intrinsicWidth > f16 ? (int) ((f16 / 2.0f) + (intrinsicWidth / 2.0f)) : i3;
    }

    private int getCoverCenterTop() {
        if (this.singleDrawable.getIntrinsicWidth() == 0) {
            return 0;
        }
        float intrinsicWidth = (this.mCoverWidth / this.singleDrawable.getIntrinsicWidth()) * this.singleDrawable.getIntrinsicHeight();
        float f16 = this.mCoverHeight;
        if (intrinsicWidth > f16) {
            return (int) ((f16 / 2.0f) - (intrinsicWidth / 2.0f));
        }
        return 0;
    }

    private Matrix getFitCenterMatrix() {
        float f16;
        float f17;
        float f18;
        Matrix matrix = this.mFitCenterMatrix;
        if (matrix != null) {
            return matrix;
        }
        Drawable drawable = this.singleDrawable;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = this.singleDrawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        this.singleDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        int i3 = this.mCoverWidth;
        int i16 = this.mCoverHeight;
        if (intrinsicWidth * i16 > i3 * intrinsicHeight) {
            float f19 = i3;
            float f26 = intrinsicWidth;
            f16 = f19 / f26;
            f17 = (f19 - (f26 * f16)) * 0.5f;
            f18 = (i16 - (intrinsicHeight * f16)) * 0.5f;
        } else {
            float f27 = i16;
            float f28 = intrinsicHeight;
            f16 = f27 / f28;
            f17 = (i3 - (intrinsicWidth * f16)) * 0.5f;
            f18 = (f27 - (f28 * f16)) * 0.5f;
        }
        Matrix matrix2 = new Matrix();
        this.mFitCenterMatrix = matrix2;
        matrix2.setScale(f16, f16);
        this.mFitCenterMatrix.postTranslate(Math.round(f17), Math.round(f18));
        return this.mFitCenterMatrix;
    }

    private void initAlphaAnimation() {
        if (this.loadingAlphaAnimators != null) {
            return;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.455f, 0.03f, 0.515f, 0.955f);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        this.loadingAlphaAnimatorFirst = ofInt;
        ofInt.setInterpolator(pathInterpolator);
        this.loadingAlphaAnimatorFirst.setDuration(200L);
        this.loadingAlphaAnimatorFirst.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.feedcomponent.ui.AutoVideoCover.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AutoVideoCover.this.loadingAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                AutoVideoCover.this.postInvalidate();
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(255, 255);
        this.loadingAlphaAnimatorSecond = ofInt2;
        ofInt2.setDuration(120L);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(255, 0);
        this.loadingAlphaAnimatorThird = ofInt3;
        ofInt3.setInterpolator(pathInterpolator);
        this.loadingAlphaAnimatorThird.setDuration(640L);
        this.loadingAlphaAnimatorThird.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.feedcomponent.ui.AutoVideoCover.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AutoVideoCover.this.loadingAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                AutoVideoCover.this.postInvalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.loadingAlphaAnimators = animatorSet;
        animatorSet.playSequentially(this.loadingAlphaAnimatorFirst, this.loadingAlphaAnimatorSecond, this.loadingAlphaAnimatorThird);
    }

    private void initAnimation() {
        if (this.loadingAnimators != null) {
            return;
        }
        initScaleAnimation();
        initAlphaAnimation();
        if (this.loadingScaleAnimators == null || this.loadingAlphaAnimators == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.loadingAnimators = animatorSet;
        animatorSet.playTogether(this.loadingScaleAnimators, this.loadingAlphaAnimators);
        this.loadingAnimators.addListener(new AnimatorListenerAdapter() { // from class: com.qzone.module.feedcomponent.ui.AutoVideoCover.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (((BaseVideoCover) AutoVideoCover.this).hasDrawingTask) {
                    animator.start();
                }
            }
        });
    }

    private void initScaleAnimation() {
        if (this.loadingScaleAnimators != null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.loadingScaleAnimatorFirst = ofFloat;
        ofFloat.setDuration(640L);
        this.loadingScaleAnimatorFirst.setInterpolator(new PathInterpolator(0.48f, 0.09f, 0.37f, 0.96f));
        this.loadingScaleAnimatorFirst.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.feedcomponent.ui.AutoVideoCover.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AutoVideoCover.this.loadingDeltaWidth = (int) ((floatValue * r0.getWidth()) / 2.0f);
                AutoVideoCover.this.postInvalidate();
            }
        });
        ValueAnimator ofInt = ValueAnimator.ofInt(1, 1);
        this.loadingScaleAnimatorSecond = ofInt;
        ofInt.setDuration(320L);
        this.loadingScaleAnimatorSecond.setInterpolator(null);
        AnimatorSet animatorSet = new AnimatorSet();
        this.loadingScaleAnimators = animatorSet;
        animatorSet.playSequentially(this.loadingScaleAnimatorFirst, this.loadingScaleAnimatorSecond);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    protected void drawComplete(Canvas canvas) {
        if (this.isFeedTypeDetail) {
            this.mHandler.removeMessages(1);
            this.hasDrawingTask = false;
            canvas.drawRect(0.0f, 0.0f, this.mCoverWidth, this.mCoverHeight, FeedVideoEnv.videoFloatCompleteMaskPaint);
            String string = FeedVideoEnv.feedResources.getString(1380);
            int i3 = (this.mCoverWidth - FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH) / 2;
            int i16 = (((this.mCoverHeight - FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) - FeedVideoEnv.dp10) - FeedVideoEnv.floatCharHeigth) / 2;
            FeedVideoEnv.floatReplay.setBounds(i3, i16, FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + i3, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + i16);
            FeedVideoEnv.floatReplay.draw(canvas);
            canvas.drawText(string, i3 + FeedVideoEnv.f279794dp1, i16 + FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + FeedVideoEnv.dp15, FeedVideoEnv.videoFloatCompleteTextPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawCover(Canvas canvas) {
        if (this.mIsClipCoverCenter) {
            synchronized (this) {
                Drawable drawable = this.singleDrawable;
                if (drawable != null && canvas != null) {
                    drawable.setBounds(0, getCoverCenterTop(), this.mCoverWidth, getCoverCenterBottom());
                    this.singleDrawable.draw(canvas);
                }
            }
            return;
        }
        if (this.mIsCenterCrop) {
            if (this.singleDrawable != null && canvas != null && getCenterCropMatrix() != null) {
                synchronized (this) {
                    Matrix centerCropMatrix = getCenterCropMatrix();
                    int saveCount = canvas.getSaveCount();
                    canvas.save();
                    canvas.concat(centerCropMatrix);
                    this.singleDrawable.draw(canvas);
                    canvas.restoreToCount(saveCount);
                }
                return;
            }
            super.drawCover(canvas);
            return;
        }
        if (this.mIsFitCenter) {
            if (this.singleDrawable != null && canvas != null && getFitCenterMatrix() != null) {
                synchronized (this) {
                    Matrix fitCenterMatrix = getFitCenterMatrix();
                    int saveCount2 = canvas.getSaveCount();
                    canvas.save();
                    canvas.concat(fitCenterMatrix);
                    this.singleDrawable.draw(canvas);
                    canvas.restoreToCount(saveCount2);
                }
                return;
            }
            super.drawCover(canvas);
            return;
        }
        super.drawCover(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawPlayIcon(Canvas canvas) {
        Drawable drawable;
        if (this.hideCover) {
            return;
        }
        if (this.mIsSetPlayIcon && (drawable = this.mPlayIconDrawable) != null) {
            drawable.setBounds((this.picWidth - drawable.getIntrinsicWidth()) / 2, (this.picHeight - this.mPlayIconDrawable.getIntrinsicHeight()) / 2, (this.picWidth + this.mPlayIconDrawable.getIntrinsicWidth()) / 2, (this.picHeight + this.mPlayIconDrawable.getIntrinsicHeight()) / 2);
            this.mPlayIconDrawable.draw(canvas);
        } else {
            super.drawPlayIcon(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public int getMaxWidth() {
        return super.getMaxWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getParent() != null && ((FeedAutoVideo) getParent()).getState() == 0) {
            drawPlayIcon(canvas);
        }
        if (getParent() == null || ((FeedAutoVideo) getParent()).getState() != 4) {
            return;
        }
        drawComplete(canvas);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public synchronized void onRecycled() {
        super.onRecycled();
        if (this.loadingAnimators != null) {
            this.hasDrawingTask = false;
            this.oldCoverWidth = 0;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    protected void processLoadingIcon(Canvas canvas) {
        if (!checkLoadingAnimationData()) {
            initAnimation();
            this.loadingRectBg = new Rect(0, getHeight() - 6, getWidth(), getHeight());
            this.loadingRectFg = new Rect(getWidth() / 2, getHeight() - 6, getWidth() / 2, getHeight());
            this.oldCoverWidth = getWidth();
            AnimatorSet animatorSet = this.loadingAnimators;
            if (animatorSet != null) {
                animatorSet.start();
            }
            this.hasDrawingTask = true;
        }
        if (!this.hasDrawingTask) {
            AnimatorSet animatorSet2 = this.loadingAnimators;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                return;
            }
            return;
        }
        this.paint.setColor(-1);
        this.paint.setAlpha(77);
        canvas.drawRect(this.loadingRectBg, this.paint);
        this.paint.setColor(LOADING_FOREGROUND_COLOR);
        this.paint.setAlpha(this.loadingAlpha);
        this.loadingRectFg.left = (getWidth() / 2) - this.loadingDeltaWidth;
        this.loadingRectFg.right = (getWidth() / 2) + this.loadingDeltaWidth;
        canvas.drawRect(this.loadingRectFg, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void reCaculateSize(int i3, int i16) {
        if (this.mIsAdjustToHeight) {
            int i17 = this.mAdjustHeight;
            this.picWidth = (i3 * i17) / i16;
            this.picHeight = i17;
        } else if (this.mIsAdjustWidth) {
            this.picWidth = this.mAdjustWidth;
            this.picHeight = (i16 * r0) / i3;
        } else if (this.mIsForceWH) {
            this.picWidth = this.mAdjustWidth;
            this.picHeight = this.mAdjustHeight;
        } else {
            super.reCaculateSize(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void reset() {
        super.reset();
        this.mIsSetPlayIcon = false;
        this.mPlayIconDrawable = null;
        if (this.loadingAnimators != null) {
            this.hasDrawingTask = false;
        }
    }

    public void setAdjustToHeight(boolean z16, int i3) {
        this.mIsAdjustToHeight = z16;
        this.mAdjustHeight = i3;
    }

    public void setAdjustToWidth(boolean z16, int i3) {
        this.mIsAdjustWidth = z16;
        this.mAdjustWidth = i3;
    }

    public void setCoverHide(boolean z16) {
        this.hideCover = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void setCoverWarnType(Canvas canvas, BaseVideoCover.CoverWarnType coverWarnType) {
        super.setCoverWarnType(canvas, coverWarnType);
    }

    public void setForceToWH(boolean z16, int i3, int i16) {
        this.mIsForceWH = z16;
        this.mAdjustWidth = i3;
        this.mAdjustHeight = i16;
    }

    public void setIsCardTypeView(boolean z16) {
        this.isCardTypeView = z16;
    }

    public void setIsCenterCrop(boolean z16) {
        this.mIsCenterCrop = z16;
        this.mCenterCropMatrix = null;
    }

    public void setIsClipCoverCenter(boolean z16) {
        this.mIsClipCoverCenter = z16;
    }

    public void setIsFeedTypeDetail(boolean z16) {
        this.isFeedTypeDetail = z16;
        setJustShowReplyIcon(true);
    }

    public void setIsFitCenter(boolean z16) {
        this.mIsFitCenter = z16;
        this.mFitCenterMatrix = null;
    }

    public void setIsForward(boolean z16) {
        this.isForward = z16;
    }

    public void setPicHeight(int i3) {
        this.picHeight = i3;
    }

    public void setPicWidth(int i3) {
        this.picWidth = i3;
    }

    public void setPlayIconDrawable(boolean z16, Drawable drawable) {
        this.mIsSetPlayIcon = z16;
        this.mPlayIconDrawable = drawable;
    }

    public void fitQcircleShareFeed() {
        int[] fitQcircleShareFeed = QcircleShareFeedSizeUtil.fitQcircleShareFeed(new int[]{this.picWidth, this.picHeight});
        this.picWidth = fitQcircleShareFeed[0];
        this.picHeight = fitQcircleShareFeed[1];
    }
}
