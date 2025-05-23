package com.tencent.biz.richframework.animation.transition;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionInitData {
    private int mBackgroundColor;
    private Drawable mCoverDrawable;
    private ImageView.ScaleType mEndScaleType;
    private int mEnterAnimFadeCoverTimeMs;
    private int mExitAnimFadeCoverTimeMs;
    private boolean mFadeAniLayoutNotImg;
    private RectF mImageEndRect;
    private RectF mImageStartRect;
    private RectF mLayoutEndRect;
    private RectF mLayoutStartRect;
    private boolean mNeedDoFadeAni;
    private ImageView.ScaleType mStartScaleType;
    private int mTransitionAniDurationMs;
    private int mTransitionDelayTimeMs;

    public TransitionInitData() {
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
        this.mStartScaleType = scaleType;
        this.mEndScaleType = scaleType;
        this.mBackgroundColor = -16777216;
        this.mTransitionDelayTimeMs = 300;
        this.mEnterAnimFadeCoverTimeMs = 500;
        this.mExitAnimFadeCoverTimeMs = 100;
        this.mTransitionAniDurationMs = 300;
        this.mNeedDoFadeAni = true;
    }

    public boolean fadeAniLayout() {
        return this.mFadeAniLayoutNotImg;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public Drawable getCoverDrawable() {
        return this.mCoverDrawable;
    }

    public ImageView.ScaleType getEndScaleType() {
        ImageView.ScaleType scaleType = this.mEndScaleType;
        if (scaleType == null) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        return scaleType;
    }

    public int getEnterAnimFadeCoverTimeMs() {
        return this.mEnterAnimFadeCoverTimeMs;
    }

    public int getExitAnimFadeCoverTimeMs() {
        return this.mExitAnimFadeCoverTimeMs;
    }

    public RectF getImageEndRect() {
        RectF rectF = this.mImageEndRect;
        if (rectF == null) {
            return getLayoutEndRect();
        }
        return rectF;
    }

    public RectF getImageStartRect() {
        RectF rectF = this.mImageStartRect;
        if (rectF == null) {
            return getLayoutStartRect();
        }
        return rectF;
    }

    public RectF getLayoutEndRect() {
        RectF rectF = this.mLayoutEndRect;
        if (rectF == null) {
            return new RectF();
        }
        return rectF;
    }

    public RectF getLayoutStartRect() {
        RectF rectF = this.mLayoutStartRect;
        if (rectF == null) {
            return new RectF();
        }
        return rectF;
    }

    public ImageView.ScaleType getStartScaleType() {
        ImageView.ScaleType scaleType = this.mStartScaleType;
        if (scaleType == null) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        return scaleType;
    }

    public int getTransitionAniDurationMs() {
        return this.mTransitionAniDurationMs;
    }

    public int getTransitionDelayTimeMs() {
        return this.mTransitionDelayTimeMs;
    }

    public boolean needDoFadeAniWhenExit() {
        return this.mNeedDoFadeAni;
    }

    public void setBackgroundColor(int i3) {
        this.mBackgroundColor = i3;
    }

    public void setCoverDrawable(Drawable drawable) {
        this.mCoverDrawable = drawable;
    }

    public void setEndScaleType(ImageView.ScaleType scaleType) {
        this.mEndScaleType = scaleType;
    }

    public void setEnterAnimFadeCoverTimeMs(int i3) {
        this.mEnterAnimFadeCoverTimeMs = i3;
    }

    public void setExitAnimFadeCoverTimeMs(int i3) {
        this.mExitAnimFadeCoverTimeMs = i3;
    }

    public void setFadeAniLayoutNotImg(boolean z16) {
        this.mFadeAniLayoutNotImg = z16;
    }

    public void setImageEndRect(RectF rectF) {
        this.mImageEndRect = rectF;
    }

    public void setImageStartRect(RectF rectF) {
        this.mImageStartRect = rectF;
    }

    public void setLayoutEndRect(RectF rectF) {
        this.mLayoutEndRect = rectF;
    }

    public void setLayoutStartRect(RectF rectF) {
        this.mLayoutStartRect = rectF;
    }

    public void setNeedFadeAniWhenExit(boolean z16) {
        this.mNeedDoFadeAni = z16;
    }

    public void setStartScaleType(ImageView.ScaleType scaleType) {
        this.mStartScaleType = scaleType;
    }

    public void setTransitionAniDurationMs(int i3) {
        this.mTransitionAniDurationMs = i3;
    }

    public void setTransitionDelayTimeMs(int i3) {
        this.mTransitionDelayTimeMs = i3;
    }

    public String toString() {
        return "TransitionInitData{mLayoutStartRect=" + this.mLayoutStartRect + ", mLayoutEndRect=" + this.mLayoutEndRect + ", mImageStartRect=" + this.mImageStartRect + ", mImageEndRect=" + this.mImageEndRect + ", mStartScaleType=" + this.mStartScaleType + ", mEndScaleType=" + this.mEndScaleType + ", mCoverDrawable=" + this.mCoverDrawable + ", mBackgroundColor=" + this.mBackgroundColor + ", mTransitionDelayTimeMs=" + this.mTransitionDelayTimeMs + ", mEnterAnimFadeCoverTimeMs=" + this.mEnterAnimFadeCoverTimeMs + ", mExitAnimFadeCoverTimeMs=" + this.mExitAnimFadeCoverTimeMs + ", mTransitionAniDurationMs=" + this.mTransitionAniDurationMs + ", mFadeAniLayoutNotImg=" + this.mFadeAniLayoutNotImg + ", mNeedDoFadeAni=" + this.mNeedDoFadeAni + '}';
    }
}
