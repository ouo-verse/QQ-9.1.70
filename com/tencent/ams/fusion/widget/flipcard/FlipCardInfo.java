package com.tencent.ams.fusion.widget.flipcard;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_BONUS_PAGE_BOTTOM_TEXT = "\u6b63\u5728\u8df3\u8f6c\u4e2d";
    private static final float DEFAULT_REVERSE_ROTATION_THRESHOLD = 0.0f;
    private static final String DEFAULT_REVERSE_SUB_TITLE_TEXT = "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
    private static final float DEFAULT_ROTATION_THRESHOLD = 45.0f;
    private static final float DEFAULT_SLIDE_THRESHOLD_DP = 55.0f;
    private static final String DEFAULT_SUB_TITLE_TEXT = "\u7ffb\u8f6c\u624b\u673a\u6216\u6ed1\u52a8/\u70b9\u51fb\u5361\u7247\uff0c\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
    private long mBeginTime;
    private Bitmap mBonusCardBitmap;
    private String mBonusPageText;
    private String mCountdownTipsText;
    private Bitmap mDetailBitmap;
    private boolean mEnableBonusPage;
    private boolean mEnableShowStroke;
    private float mHotAreaBottomMargin;
    private float mHotAreaHeight;
    private float mHotAreaLeftMargin;
    private float mHotAreaRightMargin;
    private int[] mInteractiveMode;
    private Bitmap mLogoBitmap;
    private String mNoCountdownTipsText;
    private Bitmap mProductBitmap;
    private String mProductSlogan;
    private float mReverseRotationThreshold;
    private String mReverseSubTitleText;
    private float mRotationThreshold;
    private float mSlideThreshold;
    private int mStorkColor;
    private float mStrokeWidthDp;
    private int mStyleType;
    private String mSubTitleText;
    private String mThemeColor;
    private String mTitleText;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        private final FlipCardInfo mInfo;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mInfo = new FlipCardInfo();
            }
        }

        public FlipCardInfo build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (FlipCardInfo) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return this.mInfo;
        }

        public Builder setBeginTime(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mInfo.setBeginTime(j3);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }

        public Builder setBonusCardBitmap(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
                this.mInfo.setBonusCardBitmap(bitmap);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 24, (Object) this, (Object) bitmap);
        }

        public Builder setBonusPageText(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                this.mInfo.setBonusPageText(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }

        public Builder setCountdownTipsText(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.mInfo.setCountdownTipsText(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }

        public Builder setDetailBitmap(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
                this.mInfo.setDetailBitmap(bitmap);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 23, (Object) this, (Object) bitmap);
        }

        public Builder setEnableBonusPage(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                this.mInfo.setEnableBonusPage(z16);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
        }

        public Builder setEnableShowStroke(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
                this.mInfo.setEnableShowStroke(z16);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, z16);
        }

        public Builder setInteractiveMode(int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                this.mInfo.setInteractiveMode(iArr);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) iArr);
        }

        public Builder setLogoBitmap(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.mInfo.setLogoBitmap(bitmap);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
        }

        public Builder setNoCountdownTipsText(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                this.mInfo.setNoCountdownTipsText(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }

        public Builder setProductBitmap(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                this.mInfo.setProductBitmap(bitmap);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap);
        }

        public Builder setProductSlogan(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                this.mInfo.setProductSlogan(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }

        public Builder setReverseRotationThreshold(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                this.mInfo.setReverseRotationThreshold(f16);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        }

        public Builder setReverseSubTitleText(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                this.mInfo.setReverseSubTitleText(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }

        public Builder setRotationThreshold(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                this.mInfo.setRotationThreshold(f16);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        }

        public Builder setSlideHotAreaDp(float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
                this.mInfo.setSlideHotAreaDp(f16, f17, f18, f19);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }

        public Builder setSlideThresholdDp(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                this.mInfo.setSlideThresholdDp(f16);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
        }

        public Builder setStorkColor(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                this.mInfo.setStorkColor(i3);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }

        public Builder setStrokeWidthDp(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                this.mInfo.setStrokeWidthDp(f16);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
        }

        public Builder setStyleType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.mInfo.setStyleType(i3);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }

        public Builder setSubTitleText(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                this.mInfo.setSubTitleText(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }

        public Builder setThemeColor(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.mInfo.setThemeColor(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }

        public Builder setTitleText(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.mInfo.setTitleText(str);
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface StyleType {
        public static final int CUSTOM = 4;
        public static final int HOT = 2;
        public static final int LIVE = 3;
        public static final int NEW = 1;
    }

    public FlipCardInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mStorkColor = -1;
        this.mEnableShowStroke = true;
        this.mStrokeWidthDp = 8.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeginTime(long j3) {
        this.mBeginTime = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBonusCardBitmap(Bitmap bitmap) {
        this.mBonusCardBitmap = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBonusPageText(String str) {
        this.mBonusPageText = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountdownTipsText(String str) {
        this.mCountdownTipsText = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailBitmap(Bitmap bitmap) {
        this.mDetailBitmap = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnableBonusPage(boolean z16) {
        this.mEnableBonusPage = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnableShowStroke(boolean z16) {
        this.mEnableShowStroke = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInteractiveMode(int[] iArr) {
        this.mInteractiveMode = iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogoBitmap(Bitmap bitmap) {
        this.mLogoBitmap = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoCountdownTipsText(String str) {
        this.mNoCountdownTipsText = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProductBitmap(Bitmap bitmap) {
        this.mProductBitmap = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProductSlogan(String str) {
        this.mProductSlogan = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReverseRotationThreshold(float f16) {
        this.mReverseRotationThreshold = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReverseSubTitleText(String str) {
        this.mReverseSubTitleText = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRotationThreshold(float f16) {
        this.mRotationThreshold = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSlideHotAreaDp(float f16, float f17, float f18, float f19) {
        this.mHotAreaLeftMargin = f16;
        this.mHotAreaRightMargin = f17;
        this.mHotAreaBottomMargin = f18;
        this.mHotAreaHeight = f19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSlideThresholdDp(float f16) {
        this.mSlideThreshold = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStorkColor(int i3) {
        this.mStorkColor = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStrokeWidthDp(float f16) {
        this.mStrokeWidthDp = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyleType(int i3) {
        this.mStyleType = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubTitleText(String str) {
        this.mSubTitleText = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThemeColor(String str) {
        this.mThemeColor = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleText(String str) {
        this.mTitleText = str;
    }

    public long getBeginTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mBeginTime;
    }

    public Bitmap getBonusCardBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mBonusCardBitmap;
    }

    public String getBonusPageText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (TextUtils.isEmpty(this.mBonusPageText)) {
            return DEFAULT_BONUS_PAGE_BOTTOM_TEXT;
        }
        return this.mBonusPageText;
    }

    public String getCountdownTipsText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mCountdownTipsText;
    }

    public Bitmap getDetailBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mDetailBitmap;
    }

    public float getHotAreaBottomMarginDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Float) iPatchRedirector.redirect((short) 22, (Object) this)).floatValue();
        }
        return this.mHotAreaBottomMargin;
    }

    public float getHotAreaHeightDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.mHotAreaHeight;
    }

    public float getHotAreaLeftMarginDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Float) iPatchRedirector.redirect((short) 20, (Object) this)).floatValue();
        }
        return this.mHotAreaLeftMargin;
    }

    public float getHotAreaRightMarginDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Float) iPatchRedirector.redirect((short) 21, (Object) this)).floatValue();
        }
        return this.mHotAreaRightMargin;
    }

    public int[] getInteractiveMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (int[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mInteractiveMode;
    }

    public long[] getLifeTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (long[]) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return FlipCardAnimationHelper.computeLeftTime(getBeginTime());
    }

    public Bitmap getLogoBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mLogoBitmap;
    }

    public String getNoCountdownTipsText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mNoCountdownTipsText;
    }

    public Bitmap getProductBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mProductBitmap;
    }

    public String getProductSlogan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mProductSlogan;
    }

    public float getReverseRotationThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        float f16 = this.mReverseRotationThreshold;
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        return f16;
    }

    public String getReverseSubTitleText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (TextUtils.isEmpty(this.mReverseSubTitleText)) {
            return "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
        }
        return this.mReverseSubTitleText;
    }

    public float getRotationThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this)).floatValue();
        }
        float f16 = this.mRotationThreshold;
        if (f16 <= 0.0f) {
            return 45.0f;
        }
        return f16;
    }

    public float getSlideThresholdDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Float) iPatchRedirector.redirect((short) 24, (Object) this)).floatValue();
        }
        float f16 = this.mSlideThreshold;
        if (f16 <= 0.0f) {
            return DEFAULT_SLIDE_THRESHOLD_DP;
        }
        return f16;
    }

    public int getStorkColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.mStorkColor;
    }

    public float getStrokeWidthDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Float) iPatchRedirector.redirect((short) 27, (Object) this)).floatValue();
        }
        return this.mStrokeWidthDp;
    }

    public int getStyleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mStyleType;
    }

    public String getSubTitleText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (TextUtils.isEmpty(this.mSubTitleText)) {
            return DEFAULT_SUB_TITLE_TEXT;
        }
        return this.mSubTitleText;
    }

    public String getTagText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        boolean hasCountDown = hasCountDown();
        if (getStyleType() == 1) {
            if (hasCountDown) {
                return "\u79bb\u65b0\u54c1\u53d1\u5e03\u8fd8\u6709";
            }
            return "\u65b0\u54c1\u53d1\u5e03";
        }
        if (getStyleType() == 2) {
            if (hasCountDown) {
                return "\u79bb\u6d3b\u52a8\u5f00\u59cb\u8fd8\u6709";
            }
            return "\u6d3b\u52a8\u8fdb\u884c\u4e2d";
        }
        if (getStyleType() == 3) {
            if (hasCountDown) {
                return "\u79bb\u76f4\u64ad\u5f00\u59cb\u8fd8\u6709";
            }
            return "\u76f4\u64ad\u8fdb\u884c\u4e2d";
        }
        if (hasCountDown) {
            return getCountdownTipsText();
        }
        return getNoCountdownTipsText();
    }

    public String getThemeColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mThemeColor;
    }

    public String getTitleText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mTitleText;
    }

    public boolean hasCountDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (getLifeTime() != null) {
            return true;
        }
        return false;
    }

    public boolean isEnableBonusPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.mEnableBonusPage;
    }

    public boolean isEnableShowStroke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.mEnableShowStroke;
    }
}
