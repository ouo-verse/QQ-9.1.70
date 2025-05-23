package com.tencent.biz.richframework.animation.drawable;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AnimationDrawableCreateOption {
    private final int mAllDuration;

    @NonNull
    private final RFWAnimationStrategy mAnimationStrategy;
    private final long mCreateTimeOut;
    private final int mFrameDuration;
    private final int mRequestHeight;
    private final int mRequestWidth;

    @NonNull
    private String mUrl;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Builder {
        private int mAllDuration;

        @NonNull
        private final RFWAnimationStrategy mAnimationStrategy;
        private long mCreateTimeOut;
        private int mFrameDuration;
        private int mRequestHeight;
        private int mRequestWidth;

        @NonNull
        private final String mUrl;

        public Builder(@NonNull String str, @NonNull RFWAnimationStrategy rFWAnimationStrategy) {
            this.mUrl = str;
            this.mAnimationStrategy = rFWAnimationStrategy;
        }

        public AnimationDrawableCreateOption build() {
            return new AnimationDrawableCreateOption(this);
        }

        public Builder setAllDuration(int i3) {
            this.mAllDuration = i3;
            return this;
        }

        public Builder setCreateTimeOut(long j3) {
            this.mCreateTimeOut = j3;
            return this;
        }

        public Builder setFrameDuration(int i3) {
            this.mFrameDuration = i3;
            return this;
        }

        public Builder setRequestHeight(int i3) {
            this.mRequestHeight = i3;
            return this;
        }

        public Builder setRequestWidth(int i3) {
            this.mRequestWidth = i3;
            return this;
        }
    }

    public int getAllDuration() {
        return this.mAllDuration;
    }

    @NonNull
    public RFWAnimationStrategy getAnimationStrategy() {
        return this.mAnimationStrategy;
    }

    public long getCreateTimeOut() {
        return this.mCreateTimeOut;
    }

    public int getFrameDuration() {
        return this.mFrameDuration;
    }

    public int getRequestHeight() {
        return this.mRequestHeight;
    }

    public int getRequestWidth() {
        return this.mRequestWidth;
    }

    public String getUrl() {
        return this.mUrl;
    }

    AnimationDrawableCreateOption(Builder builder) {
        if (!TextUtils.isEmpty(builder.mUrl)) {
            this.mUrl = builder.mUrl;
        }
        this.mCreateTimeOut = builder.mCreateTimeOut > 0 ? builder.mCreateTimeOut : 1000L;
        this.mAllDuration = builder.mAllDuration;
        this.mFrameDuration = builder.mFrameDuration > 0 ? builder.mFrameDuration : 50;
        this.mAnimationStrategy = builder.mAnimationStrategy;
        this.mRequestWidth = builder.mRequestWidth;
        this.mRequestHeight = builder.mRequestHeight;
    }
}
