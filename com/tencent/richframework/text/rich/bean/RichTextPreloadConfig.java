package com.tencent.richframework.text.rich.bean;

import android.os.Build;
import android.text.style.AbsoluteSizeSpan;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import java.util.regex.Pattern;

/* loaded from: classes25.dex */
public class RichTextPreloadConfig {
    private TextImageSpanConfig mImageSpanConfig = new TextImageSpanConfig();
    private TextAtConfig mAtConfig = new TextAtConfig();
    private TextHashTagConfig mTagConfig = new TextHashTagConfig();

    /* loaded from: classes25.dex */
    public static class TextAtConfig {
        private boolean mUseColorInt = false;
        private int mSpecialAreaColorId = R.color.coc;
        private boolean mNeedSpecialAreaBold = false;
        private Pattern mPattern = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");

        public Pattern getPattern() {
            return this.mPattern;
        }

        public int getSpecialAreaColorId() {
            return this.mSpecialAreaColorId;
        }

        public boolean isNeedSpecialAreaBold() {
            return this.mNeedSpecialAreaBold;
        }

        public boolean isUseColorInt() {
            return this.mUseColorInt;
        }

        public TextAtConfig setNeedSpecialAreaBold(boolean z16) {
            this.mNeedSpecialAreaBold = z16;
            return this;
        }

        public TextAtConfig setSpecialAreaColorId(int i3) {
            this.mSpecialAreaColorId = i3;
            return this;
        }

        public TextAtConfig setSpecialAreaColorId(int i3, boolean z16) {
            setSpecialAreaColorId(i3);
            this.mUseColorInt = z16;
            return this;
        }
    }

    /* loaded from: classes25.dex */
    public static class TextHashTagConfig {
        private boolean mUseColorInt = false;
        private int mSpecialAreaColorId = R.color.coc;
        private boolean mNeedSpecialAreaBold = false;
        private int mSpecialAreaHashTagBackgroundColorId = R.color.cvr;
        private boolean mNeedSpecialHashTagAreaBackground = true;
        private int mSpecialAreaHasBackgroundColorId = R.color.cvr;
        private int mTagTextSize = 13;
        private boolean mIsClickable = true;

        public AbsoluteSizeSpan getSpanTextSizeSpan() {
            return new AbsoluteSizeSpan(ImmersiveUtils.dpToPx(this.mTagTextSize));
        }

        public int getSpecialAreaColorId() {
            return this.mSpecialAreaColorId;
        }

        public int getSpecialAreaHasBackgroundColorId() {
            return this.mSpecialAreaHasBackgroundColorId;
        }

        public int getSpecialAreaHashTagBackgroundColorId() {
            return this.mSpecialAreaHashTagBackgroundColorId;
        }

        public int getTagTextSize() {
            return this.mTagTextSize;
        }

        public boolean isClickable() {
            return this.mIsClickable;
        }

        public boolean isNeedSpecialAreaBold() {
            return this.mNeedSpecialAreaBold;
        }

        public boolean isNeedSpecialHashTagAreaBackground() {
            if (Build.VERSION.SDK_INT <= 27) {
                this.mNeedSpecialHashTagAreaBackground = false;
            }
            return this.mNeedSpecialHashTagAreaBackground;
        }

        public boolean isUseColorInt() {
            return this.mUseColorInt;
        }

        public TextHashTagConfig setIsClickable(boolean z16) {
            this.mIsClickable = z16;
            return this;
        }

        public TextHashTagConfig setNeedSpecialAreaBold(boolean z16) {
            this.mNeedSpecialAreaBold = z16;
            return this;
        }

        public TextHashTagConfig setNeedSpecialHashTagAreaBackground(boolean z16) {
            this.mNeedSpecialHashTagAreaBackground = z16;
            return this;
        }

        public TextHashTagConfig setSpecialAreaColorId(int i3) {
            this.mSpecialAreaColorId = i3;
            return this;
        }

        public TextHashTagConfig setSpecialAreaHasBackgroundColorId(int i3) {
            this.mSpecialAreaHasBackgroundColorId = i3;
            return this;
        }

        public TextHashTagConfig setSpecialAreaHashTagBackgroundColorId(int i3) {
            this.mSpecialAreaHashTagBackgroundColorId = i3;
            return this;
        }

        public TextHashTagConfig setTagTextSize(int i3) {
            this.mTagTextSize = i3;
            return this;
        }

        public TextHashTagConfig setSpecialAreaColorId(int i3, boolean z16) {
            setSpecialAreaColorId(i3);
            this.mUseColorInt = z16;
            return this;
        }
    }

    /* loaded from: classes25.dex */
    public static class TextImageSpanConfig {
        private int mIconSize = 14;
        private int mVerticalAlignment = 0;

        public int getIconSize() {
            return this.mIconSize;
        }

        public int getVerticalAlignment() {
            return this.mVerticalAlignment;
        }

        public TextImageSpanConfig setIconSize(int i3) {
            this.mIconSize = i3;
            return this;
        }

        public TextImageSpanConfig setVerticalAlignment(int i3) {
            this.mVerticalAlignment = i3;
            return this;
        }
    }

    public TextAtConfig getAtConfig() {
        return this.mAtConfig;
    }

    public TextImageSpanConfig getImageSpanConfig() {
        return this.mImageSpanConfig;
    }

    public TextHashTagConfig getTagConfig() {
        return this.mTagConfig;
    }

    public RichTextPreloadConfig setAtConfig(TextAtConfig textAtConfig) {
        this.mAtConfig = textAtConfig;
        return this;
    }

    public RichTextPreloadConfig setImageSpanConfig(TextImageSpanConfig textImageSpanConfig) {
        this.mImageSpanConfig = textImageSpanConfig;
        return this;
    }

    public RichTextPreloadConfig setTagConfig(TextHashTagConfig textHashTagConfig) {
        this.mTagConfig = textHashTagConfig;
        return this;
    }
}
