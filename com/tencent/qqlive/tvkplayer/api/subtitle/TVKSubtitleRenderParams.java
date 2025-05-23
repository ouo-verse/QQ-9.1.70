package com.tencent.qqlive.tvkplayer.api.subtitle;

import androidx.annotation.NonNull;

/* loaded from: classes23.dex */
public class TVKSubtitleRenderParams {
    public static final int DEFAULT_CANVAS_HEIGHT = 720;
    public static final int DEFAULT_CANVAS_WIDTH = 1280;
    public static final float DEFAULT_END_MARGIN = 0.05f;
    public static final int DEFAULT_FONT_COLOR = -1;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final float DEFAULT_FONT_SIZE = 36.0f;
    public static final float DEFAULT_LINE_SPACE = 1.0f;
    public static final int DEFAULT_OUTLINE_COLOR = -16777216;
    public static final float DEFAULT_OUTLINE_WIDTH = 1.0f;
    public static final float DEFAULT_START_MARGIN = 0.05f;
    public static final float DEFAULT_VERTICAL_MARGIN = 0.05f;
    public static final long SUBTITLE_PARAM_FLAG_CANVAS_HEIGHT = 2;
    public static final long SUBTITLE_PARAM_FLAG_CANVAS_WIDTH = 1;
    public static final long SUBTITLE_PARAM_FLAG_END_MARGIN = 256;
    public static final long SUBTITLE_PARAM_FLAG_FONT_COLOR = 8;
    public static final long SUBTITLE_PARAM_FLAG_FONT_SCALE = 2048;
    public static final long SUBTITLE_PARAM_FLAG_FONT_SIZE = 4;
    public static final long SUBTITLE_PARAM_FLAG_FONT_STYLE_BOLD = 1024;
    public static final long SUBTITLE_PARAM_FLAG_LINE_SPACE = 64;
    public static final long SUBTITLE_PARAM_FLAG_OUTLINE_COLOR = 32;
    public static final long SUBTITLE_PARAM_FLAG_OUTLINE_WIDTH = 16;
    public static final long SUBTITLE_PARAM_FLAG_START_MARGIN = 128;
    public static final long SUBTITLE_PARAM_FLAG_UNKNOWN = 0;
    public static final long SUBTITLE_PARAM_FLAG_VERTICAL_MARGIN = 512;
    private TVKSubtitleBackgroundParams mBackgroundParams;
    private int mCanvasWidth = 1280;
    private int mCanvasHeight = 720;
    private float mFontScale = 1.0f;
    private float mFontSize = 36.0f;
    private int mFontColor = -1;
    private float mOutlineWidth = 1.0f;
    private int mOutlineColor = -16777216;
    private float mLineSpace = 1.0f;
    private float mStartMargin = 0.05f;
    private float mEndMargin = 0.05f;
    private float mVerticalMargin = 0.05f;
    private long mParamFlags = 0;
    private long mParamPriorityFlags = 0;

    /* loaded from: classes23.dex */
    public static class TVKSubtitleBackgroundParams {
        private int mBackgroundBorderColor;
        private float mBackgroundBorderWidth;
        private int mBackgroundColor;
        private float mBackgroundHorizontalMargin;
        private float mBackgroundVerticalMargin;
        private float mCornerRadiusToHeightRatio;

        public int getBackgroundBorderColor() {
            return this.mBackgroundBorderColor;
        }

        public float getBackgroundBorderWidth() {
            return this.mBackgroundBorderWidth;
        }

        public int getBackgroundColor() {
            return this.mBackgroundColor;
        }

        public float getBackgroundHorizontalMargin() {
            return this.mBackgroundHorizontalMargin;
        }

        public float getBackgroundVerticalMargin() {
            return this.mBackgroundVerticalMargin;
        }

        public float getCornerRadiusToHeightRatio() {
            return this.mCornerRadiusToHeightRatio;
        }

        public void setBackgroundBorderColor(int i3) {
            this.mBackgroundBorderColor = i3;
        }

        public void setBackgroundBorderWidth(float f16) {
            this.mBackgroundBorderWidth = f16;
        }

        public void setBackgroundColor(int i3) {
            this.mBackgroundColor = i3;
        }

        public void setBackgroundHorizontalMargin(float f16) {
            this.mBackgroundHorizontalMargin = f16;
        }

        public void setBackgroundVerticalMargin(float f16) {
            this.mBackgroundVerticalMargin = f16;
        }

        public void setCornerRadiusToHeightRatio(float f16) {
            this.mCornerRadiusToHeightRatio = f16;
        }
    }

    public TVKSubtitleBackgroundParams getBackgroundParams() {
        return this.mBackgroundParams;
    }

    public int getCanvasHeight() {
        return this.mCanvasHeight;
    }

    public int getCanvasWidth() {
        return this.mCanvasWidth;
    }

    public float getEndMargin() {
        return this.mEndMargin;
    }

    public int getFontColor() {
        return this.mFontColor;
    }

    public float getFontScale() {
        return this.mFontScale;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public float getLineSpace() {
        return this.mLineSpace;
    }

    public int getOutlineColor() {
        return this.mOutlineColor;
    }

    public float getOutlineWidth() {
        return this.mOutlineWidth;
    }

    public long getParamFlags() {
        return this.mParamFlags;
    }

    public long getParamPriorityFlags() {
        return this.mParamPriorityFlags;
    }

    public float getStartMargin() {
        return this.mStartMargin;
    }

    public float getVerticalMargin() {
        return this.mVerticalMargin;
    }

    public void setBackgroundParams(TVKSubtitleBackgroundParams tVKSubtitleBackgroundParams) {
        this.mBackgroundParams = tVKSubtitleBackgroundParams;
    }

    public void setCanvasHeight(int i3) {
        this.mCanvasHeight = i3;
    }

    public void setCanvasWidth(int i3) {
        this.mCanvasWidth = i3;
    }

    public void setEndMargin(float f16) {
        this.mEndMargin = f16;
    }

    public void setFontColor(int i3) {
        this.mFontColor = i3;
    }

    public void setFontScale(float f16) {
        this.mFontScale = f16;
    }

    public void setFontSize(float f16) {
        this.mFontSize = f16;
    }

    public void setLineSpace(float f16) {
        this.mLineSpace = f16;
    }

    public void setOutlineColor(int i3) {
        this.mOutlineColor = i3;
    }

    public void setOutlineWidth(float f16) {
        this.mOutlineWidth = f16;
    }

    public void setParamFlags(long j3) {
        this.mParamFlags = j3;
    }

    public void setParamPriorityFlags(long j3) {
        this.mParamPriorityFlags = j3;
    }

    public void setStartMargin(float f16) {
        this.mStartMargin = f16;
    }

    public void setVerticalMargin(float f16) {
        this.mVerticalMargin = f16;
    }

    @NonNull
    public String toString() {
        return "TVKSubtitleRenderParams, fontScale=" + this.mFontScale + ", fontSize=" + this.mFontSize + ", fontColor=" + this.mFontColor + ", canvasWidth=" + this.mCanvasWidth + ", canvasHeight=" + this.mCanvasHeight + ", outlineColor=" + this.mOutlineColor + ", outlineWidth=" + this.mOutlineWidth + ", lineSpace=" + this.mLineSpace + ", startMargin=" + this.mStartMargin + ", endMargin=" + this.mEndMargin + ", verticalMargin=" + this.mVerticalMargin + ", paramFlags=" + this.mParamFlags + ", paramPriorityFlags=" + this.mParamPriorityFlags;
    }
}
