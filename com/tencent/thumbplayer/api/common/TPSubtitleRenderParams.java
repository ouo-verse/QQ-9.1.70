package com.tencent.thumbplayer.api.common;

import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public class TPSubtitleRenderParams {
    public static final int TP_SUBTITLE_FONT_STYLE_BOLD = 1;
    public static final int TP_SUBTITLE_FONT_STYLE_UNKNOWN = 0;
    public static final long TP_SUBTITLE_PARAM_FLAG_CANVAS_HEIGHT = 2;
    public static final long TP_SUBTITLE_PARAM_FLAG_CANVAS_WIDTH = 1;
    public static final long TP_SUBTITLE_PARAM_FLAG_END_MARGIN = 256;
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_COLOR = 8;
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_SCALE = 2048;
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_SIZE = 4;
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_STYLE_BOLD = 1024;
    public static final long TP_SUBTITLE_PARAM_FLAG_LINE_SPACE = 64;
    public static final long TP_SUBTITLE_PARAM_FLAG_OUTLINE_COLOR = 32;
    public static final long TP_SUBTITLE_PARAM_FLAG_OUTLINE_WIDTH = 16;
    public static final long TP_SUBTITLE_PARAM_FLAG_START_MARGIN = 128;
    public static final long TP_SUBTITLE_PARAM_FLAG_UNKNOWN = 0;
    public static final long TP_SUBTITLE_PARAM_FLAG_VERTICAL_MARGIN = 512;
    private TPSubtitleBackgroundParams mBackgroundParams;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private float mEndMargin;
    private String mFamilyName;
    private int mFontColor;
    private float mFontScale;
    private float mFontSize;
    private float mLineSpace;
    private int mOutlineColor;
    private float mOutlineWidth;
    private float mStartMargin;
    private float mVerticalMargin;
    private long mParamFlags = 0;
    private long mParamPriorityFlags = 0;
    private int mFontStyleFlags = 0;

    /* loaded from: classes26.dex */
    public static class TPSubtitleBackgroundParams {
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

    public TPSubtitleBackgroundParams getBackgroundParams() {
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

    public String getFamilyName() {
        return this.mFamilyName;
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

    public int getFontStyleFlags() {
        return this.mFontStyleFlags;
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

    public void setBackgroundParams(TPSubtitleBackgroundParams tPSubtitleBackgroundParams) {
        this.mBackgroundParams = tPSubtitleBackgroundParams;
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

    public void setFamilyName(String str) {
        this.mFamilyName = str;
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

    public void setFontStyleFlags(int i3) {
        this.mFontStyleFlags = i3;
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
        return "TPSubtitleRenderParams, fontScale=" + this.mFontScale + ", fontSize=" + this.mFontSize + ", fontColor=" + this.mFontColor + ", familyName=" + this.mFamilyName + ", canvasWidth=" + this.mCanvasWidth + ", canvasHeight=" + this.mCanvasHeight + ", outlineColor=" + this.mOutlineColor + ", outlineWidth=" + this.mOutlineWidth + ", lineSpace=" + this.mLineSpace + ", startMargin=" + this.mStartMargin + ", endMargin=" + this.mEndMargin + ", verticalMargin=" + this.mVerticalMargin + ", paramFlags=" + this.mParamFlags + ", paramPriorityFlags=" + this.mParamPriorityFlags;
    }
}
