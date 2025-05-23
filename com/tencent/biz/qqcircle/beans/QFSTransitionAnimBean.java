package com.tencent.biz.qqcircle.beans;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTransitionAnimBean implements Serializable {
    private boolean mBackUseVideoFrame;
    private Drawable mCoverDrawable;
    private SourceRect mImageRect;
    private String mImageUrl;
    private SourceRect mLayoutRect;
    private ImageView.ScaleType mScaleType;
    private boolean mIsBackTransition = true;
    private boolean mDisableBackTransitionWhenPosChanged = false;
    private int mTransitionDelayTimeMs = 300;
    private int mEnterAnimFadeCoverTimeMs = 500;
    private int mExitAnimFadeCoverTimeMs = 100;
    private int mTransitionDurationMs = 300;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class SourceRect implements Serializable {
        int bottom;
        int left;
        int right;
        int top;

        public SourceRect(int i3, int i16, int i17, int i18) {
            this.left = i3;
            this.top = i16;
            this.right = i17;
            this.bottom = i18;
        }

        public int getBottom() {
            return this.bottom;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getTop() {
            return this.top;
        }

        public void setBottom(int i3) {
            this.bottom = i3;
        }

        public void setLeft(int i3) {
            this.left = i3;
        }

        public void setRight(int i3) {
            this.right = i3;
        }

        public void setTop(int i3) {
            this.top = i3;
        }

        public String toString() {
            return "SourceRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
    }

    public Drawable getCoverDrawable() {
        return this.mCoverDrawable;
    }

    public int getEnterAnimFadeCoverTimeMs() {
        return this.mEnterAnimFadeCoverTimeMs;
    }

    public int getExitAnimFadeCoverTimeMs() {
        return this.mExitAnimFadeCoverTimeMs;
    }

    public SourceRect getImageRect() {
        return this.mImageRect;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public SourceRect getLayoutRect() {
        return this.mLayoutRect;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public int getTransitionDelayTimeMs() {
        return this.mTransitionDelayTimeMs;
    }

    public int getTransitionDurationMs() {
        return this.mTransitionDurationMs;
    }

    public boolean isBackTransition() {
        return this.mIsBackTransition;
    }

    public boolean isBackUseVideoFrame() {
        return this.mBackUseVideoFrame;
    }

    public boolean isDisableBackTransitionWhenPosChanged() {
        return this.mDisableBackTransitionWhenPosChanged;
    }

    public QFSTransitionAnimBean setBackTransition(boolean z16) {
        this.mIsBackTransition = z16;
        return this;
    }

    public QFSTransitionAnimBean setBackTransitionUseVideoFrame(boolean z16) {
        this.mBackUseVideoFrame = z16;
        return this;
    }

    public void setCoverDrawable(Drawable drawable) {
        this.mCoverDrawable = drawable;
    }

    public void setDisableBackTransitionWhenPosChanged(boolean z16) {
        this.mDisableBackTransitionWhenPosChanged = z16;
    }

    public QFSTransitionAnimBean setEnterAnimFadeCoverTimeMs(int i3) {
        this.mEnterAnimFadeCoverTimeMs = i3;
        return this;
    }

    public QFSTransitionAnimBean setExitAnimFadeCoverTimeMs(int i3) {
        this.mExitAnimFadeCoverTimeMs = i3;
        return this;
    }

    public QFSTransitionAnimBean setImageRect(SourceRect sourceRect) {
        this.mImageRect = sourceRect;
        return this;
    }

    public QFSTransitionAnimBean setImageUrl(String str) {
        this.mImageUrl = str;
        return this;
    }

    public QFSTransitionAnimBean setLayoutRect(SourceRect sourceRect) {
        this.mLayoutRect = sourceRect;
        return this;
    }

    public QFSTransitionAnimBean setScaleType(ImageView.ScaleType scaleType) {
        this.mScaleType = scaleType;
        return this;
    }

    public QFSTransitionAnimBean setTransitionDelayTimeMs(int i3) {
        this.mTransitionDelayTimeMs = i3;
        return this;
    }

    public QFSTransitionAnimBean setTransitionDurationMs(int i3) {
        this.mTransitionDurationMs = i3;
        return this;
    }

    public String toString() {
        return "QFSTransitionAnimBean{mLayoutRect=" + this.mLayoutRect + ", mImageRect=" + this.mImageRect + ", mScaleType=" + this.mScaleType + '}';
    }
}
