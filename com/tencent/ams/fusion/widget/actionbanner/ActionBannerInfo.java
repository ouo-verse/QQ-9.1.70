package com.tencent.ams.fusion.widget.actionbanner;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ActionBannerInfo {
    static IPatchRedirector $redirector_ = null;
    private static final float DEFAULT_BOTTOM_MARGIN;
    private static final float DEFAULT_SINGLE_LINE_BG_HEIGHT;
    private static final float DEFAULT_SUB_TITLE_SIZE;
    private static final float DEFAULT_TITLE_SIZE;
    private static final float DEFAULT_TOUCH_AREA_HEIGHT_FACTOR = 1.0f;
    private static final float DEFAULT_TOUCH_AREA_WIDTH_FACTOR = 1.0f;
    private static final float DEFAULT_TWO_LINE_BG_HEIGHT;
    private int mActionType;
    private int mBackgroundAnimationType;
    private String mBackgroundColor;
    private float mBackgroundHeight;
    private String mHighlightBackgroundColor;
    private long mHighlightDelayTime;
    private Bitmap[] mIconBitmapArray;
    private boolean mIconVisible;
    private float mMarginBottom;
    private View.OnClickListener mOnClickListener;
    private View.OnTouchListener mOnTouchListener;
    private int mSlideIconShape;
    private String mSubTitle;
    private String mSubTitleColor;
    private float mSubTitleFontSize;
    private String mTitle;
    private String mTitleColor;
    private float mTitleFontSize;
    private float mTouchAreaHeightFactor;
    private float mTouchAreaWidthFactor;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 43)) {
            redirector.redirect((short) 43);
            return;
        }
        DEFAULT_TITLE_SIZE = Utils.dp2px(20.0f);
        DEFAULT_SUB_TITLE_SIZE = Utils.dp2px(16.0f);
        DEFAULT_BOTTOM_MARGIN = Utils.dp2px(153.0f);
        DEFAULT_TWO_LINE_BG_HEIGHT = Utils.dp2px(74.0f);
        DEFAULT_SINGLE_LINE_BG_HEIGHT = Utils.dp2px(60.0f);
    }

    public ActionBannerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIconVisible = true;
            this.mActionType = 1;
        }
    }

    public int getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.mActionType;
    }

    public int getBackgroundAnimationType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        int i3 = this.mBackgroundAnimationType;
        if (i3 == 0) {
            return 2;
        }
        return i3;
    }

    public String getBackgroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.mBackgroundColor;
    }

    public float getBackgroundHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Float) iPatchRedirector.redirect((short) 33, (Object) this)).floatValue();
        }
        float f16 = this.mBackgroundHeight;
        if (f16 == 0.0f) {
            if (isSingleLine()) {
                return DEFAULT_SINGLE_LINE_BG_HEIGHT;
            }
            return DEFAULT_TWO_LINE_BG_HEIGHT;
        }
        return f16;
    }

    public String getHighlightBackgroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.mHighlightBackgroundColor;
    }

    public long getHighlightDelayTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
        }
        return this.mHighlightDelayTime;
    }

    public Bitmap[] getIconBitmapArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.mIconBitmapArray;
    }

    public float getMarginBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Float) iPatchRedirector.redirect((short) 31, (Object) this)).floatValue();
        }
        float f16 = this.mMarginBottom;
        if (f16 == 0.0f) {
            return DEFAULT_BOTTOM_MARGIN;
        }
        return f16;
    }

    public View.OnClickListener getOnClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.mOnClickListener;
    }

    public View.OnTouchListener getOnTouchListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (View.OnTouchListener) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.mOnTouchListener;
    }

    public int getSlideIconShape() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        return this.mSlideIconShape;
    }

    public String getSubTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.mSubTitle;
    }

    public String getSubTitleColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.mSubTitleColor;
    }

    public float getSubTitleFontSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Float) iPatchRedirector.redirect((short) 26, (Object) this)).floatValue();
        }
        float f16 = this.mSubTitleFontSize;
        if (f16 <= 0.0f) {
            return DEFAULT_SUB_TITLE_SIZE;
        }
        return f16;
    }

    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mTitle;
    }

    public String getTitleColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mTitleColor;
    }

    public float getTitleFontSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        float f16 = this.mTitleFontSize;
        if (f16 <= 0.0f) {
            return DEFAULT_TITLE_SIZE;
        }
        return f16;
    }

    public float getTouchAreaHeightFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Float) iPatchRedirector.redirect((short) 40, (Object) this)).floatValue();
        }
        float f16 = this.mTouchAreaHeightFactor;
        if (f16 < 1.0f) {
            return 1.0f;
        }
        return f16;
    }

    public float getTouchAreaWidthFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, (Object) this)).floatValue();
        }
        float f16 = this.mTouchAreaWidthFactor;
        if (f16 < 1.0f) {
            return 1.0f;
        }
        return f16;
    }

    public boolean isIconVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return this.mIconVisible;
    }

    public boolean isSingleLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return TextUtils.isEmpty(this.mSubTitle);
    }

    public void setActionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mActionType = i3;
        }
    }

    public void setBackgroundAnimationType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mBackgroundAnimationType = i3;
        }
    }

    public void setBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mBackgroundColor = str;
        }
    }

    public void setBackgroundHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        } else {
            this.mBackgroundHeight = f16;
        }
    }

    public void setHighlightBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mHighlightBackgroundColor = str;
        }
    }

    public void setHighlightDelayTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.mHighlightDelayTime = j3;
        }
    }

    public void setIconBitmapArray(Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bitmapArr);
        } else {
            this.mIconBitmapArray = bitmapArr;
        }
    }

    public void setIconVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mIconVisible = z16;
        }
    }

    public void setMarginBottom(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.mMarginBottom = f16;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onClickListener);
        } else {
            this.mOnClickListener = onClickListener;
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onTouchListener);
        } else {
            this.mOnTouchListener = onTouchListener;
        }
    }

    public void setSlideIconShape(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mSlideIconShape = i3;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mSubTitle = str;
        }
    }

    public void setSubTitleColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mSubTitleColor = str;
        }
    }

    public void setSubTitleFontSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mSubTitleFontSize = f16;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.mTitle = str;
        }
    }

    public void setTitleColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mTitleColor = str;
        }
    }

    public void setTitleFontSizeDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mTitleFontSize = f16;
        }
    }

    public void setTouchAreaHeightFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
        } else {
            this.mTouchAreaHeightFactor = f16;
        }
    }

    public void setTouchAreaWidthFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.mTouchAreaWidthFactor = f16;
        }
    }
}
