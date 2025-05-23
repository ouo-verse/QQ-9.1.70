package com.etrump.mixlayout;

import android.graphics.Typeface;
import com.etrump.mixlayout.api.IETFont;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ETFont implements IETFont {
    public static final int ET_COLOR_BLACK = -16777216;
    public static final int ET_FONT_STYLE_BOLD = 1;
    public static final int ET_FONT_STYLE_CROCHET = 8;
    public static final int ET_FONT_STYLE_SHADOW = 128;
    public long mAnimationId;
    public int mBackgroundId;
    public int mComboIndex;
    public String mContactId;
    public String mContactName;
    private int mCrochetColor;
    private int mCrochetWidth;
    private String mDIYConfigString;
    private boolean mDisableBackground;
    private boolean mDisableCrochet;
    private boolean mDisableShadow;
    public String mDiyFontImageId;
    public long mDiyHandle;
    public int mFontColor;
    public int mFontId;
    public String mFontPath;
    public int mFontSize;
    public final int mFontSizeMin;
    private int mFontStyle;
    public int mFontType;
    public int mHeightGap;
    private int mShadowBlurRadius;
    private int mShadowColor;
    private int mShadowOffsetX;
    private int mShadowOffsetY;
    public boolean mShouldDisplayAnimation;
    public long mSubstitution;
    public CharSequence mText;
    public Typeface mTypeface;
    public int mWidthGap;

    public ETFont() {
        this.mFontSizeMin = 8;
        this.mDisableBackground = false;
        this.mDisableShadow = true;
        this.mDisableCrochet = true;
        this.mSubstitution = 0L;
        this.mComboIndex = 0;
        this.mDiyFontImageId = "";
        this.mFontId = 0;
        this.mFontPath = "";
        setSize(48.0f);
    }

    public static ETFont createFont(ETFont eTFont) {
        if (eTFont == null) {
            return null;
        }
        ETFont eTFont2 = new ETFont();
        eTFont2.copy(eTFont);
        return eTFont2;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void copy(IETFont iETFont) {
        ETFont eTFont = (ETFont) iETFont;
        if (eTFont != null) {
            this.mFontId = eTFont.mFontId;
            this.mFontPath = eTFont.mFontPath;
            this.mFontSize = eTFont.mFontSize;
            this.mFontColor = eTFont.mFontColor;
            this.mFontStyle = eTFont.mFontStyle;
            this.mShadowColor = eTFont.mShadowColor;
            this.mShadowOffsetX = eTFont.mShadowOffsetX;
            this.mShadowOffsetY = eTFont.mShadowOffsetY;
            this.mShadowBlurRadius = eTFont.mShadowBlurRadius;
            this.mCrochetColor = eTFont.mCrochetColor;
            this.mCrochetWidth = eTFont.mCrochetWidth;
            this.mDisableBackground = eTFont.mDisableBackground;
            this.mDisableShadow = eTFont.mDisableShadow;
            this.mDisableCrochet = eTFont.mDisableCrochet;
            this.mBackgroundId = eTFont.mBackgroundId;
            this.mFontType = eTFont.mFontType;
            this.mText = eTFont.mText;
            this.mAnimationId = eTFont.mAnimationId;
            this.mContactId = eTFont.mContactId;
            this.mContactName = eTFont.mContactName;
            setDIYConfigHandle(eTFont.getDIYConfigHandle());
            this.mComboIndex = eTFont.mComboIndex;
            this.mWidthGap = eTFont.mWidthGap;
            this.mHeightGap = eTFont.mHeightGap;
            this.mSubstitution = g.b(eTFont.mSubstitution);
        }
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void disableEffects(boolean z16, boolean z17, boolean z18) {
        this.mDisableBackground = z16;
        this.mDisableShadow = z17;
        this.mDisableCrochet = z18;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ETFont eTFont = (ETFont) obj;
        if (this.mFontId != eTFont.mFontId || this.mFontSize != eTFont.mFontSize || this.mFontStyle != eTFont.mFontStyle || this.mDiyHandle != eTFont.mDiyHandle) {
            return false;
        }
        return true;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public int getColor() {
        return this.mFontColor;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public long getDIYConfigHandle() {
        return this.mDiyHandle;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public int getFontType() {
        return this.mFontType;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public int getId() {
        return this.mFontId;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public String getPath() {
        return this.mFontPath;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public int getSize() {
        return this.mFontSize;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public long get_substitution() {
        return this.mSubstitution;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public boolean isBold() {
        if ((this.mFontStyle & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void onDestroy() {
        long j3 = this.mDiyHandle;
        if (0 != j3) {
            ETDIYConfig.d(j3);
        }
        long j16 = this.mSubstitution;
        if (j16 != 0) {
            g.d(j16);
            this.mDiyFontImageId = "";
        }
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void parseDIYJsonString(String str) {
        if (str.length() == 0) {
            return;
        }
        this.mDIYConfigString = str;
        this.mDiyHandle = ETDIYConfig.c(this, str);
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setBold(boolean z16) {
        if (z16) {
            this.mFontStyle |= 1;
        } else {
            this.mFontStyle &= -2;
        }
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setColor(int i3) {
        this.mFontColor = i3;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setCrochet(boolean z16, int i3, int i16) {
        if (z16) {
            this.mCrochetColor = i3;
            this.mCrochetWidth = i16;
            this.mFontStyle |= 8;
            return;
        }
        this.mFontStyle &= -9;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setDIYConfigHandle(long j3) {
        this.mDiyHandle = j3;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setFontType(int i3) {
        this.mFontType = i3;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setId(int i3) {
        this.mFontId = i3;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setPath(String str) {
        this.mFontPath = str;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setShadow(boolean z16, int i3, int i16, int i17, int i18) {
        if (z16) {
            this.mShadowColor = i3;
            this.mShadowOffsetX = i16;
            this.mShadowOffsetY = i17;
            this.mShadowBlurRadius = i18;
            this.mFontStyle |= 128;
            return;
        }
        this.mFontStyle &= -129;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void setSize(float f16) {
        int i3 = (int) f16;
        if (i3 < 8) {
            i3 = 8;
        }
        this.mFontSize = i3;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public void set_substitution(long j3) {
        long j16 = this.mSubstitution;
        if (j16 != 0) {
            g.d(j16);
            this.mSubstitution = 0L;
        }
        this.mSubstitution = j3;
    }

    @Override // com.etrump.mixlayout.api.IETFont
    public String toString() {
        return "ETFont{mFontId=" + this.mFontId + ", mFontPath='" + this.mFontPath + "', mText=" + ((Object) this.mText) + ", color = " + this.mFontColor + ", style = " + this.mFontStyle + ", size = " + this.mFontSize + ", diyHandle = " + this.mDiyHandle + '}';
    }

    public ETFont(int i3, String str, float f16) {
        this.mFontSizeMin = 8;
        this.mDisableBackground = false;
        this.mDisableShadow = true;
        this.mDisableCrochet = true;
        this.mSubstitution = 0L;
        this.mComboIndex = 0;
        this.mDiyFontImageId = "";
        this.mFontId = i3;
        this.mFontPath = str;
        setSize(f16);
        this.mFontColor = -16777216;
        this.mFontStyle = 0;
        this.mDiyHandle = 0L;
        this.mWidthGap = 0;
        this.mHeightGap = 0;
        this.mSubstitution = 0L;
    }

    public ETFont(int i3, String str, float f16, int i16, Typeface typeface) {
        this.mFontSizeMin = 8;
        this.mDisableBackground = false;
        this.mDisableShadow = true;
        this.mDisableCrochet = true;
        this.mSubstitution = 0L;
        this.mComboIndex = 0;
        this.mDiyFontImageId = "";
        this.mFontId = i3;
        this.mFontPath = str;
        setSize(f16);
        this.mFontColor = -16777216;
        this.mFontStyle = 0;
        this.mFontType = i16;
        this.mTypeface = typeface;
        this.mDiyHandle = 0L;
        this.mWidthGap = 0;
        this.mHeightGap = 0;
        this.mSubstitution = 0L;
    }
}
