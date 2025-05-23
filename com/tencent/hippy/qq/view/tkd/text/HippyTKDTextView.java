package com.tencent.hippy.qq.view.tkd.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ImageSpan;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.views.text.HippyTextView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDTextView extends HippyTextView implements HippyTKDCommonBorderHandler.HippyQBCommonBorder, HippyTKDSkinHandler.HippyQBCommonSkin {
    HippyArray mColors;
    String mContentDescription;
    boolean mEmojiEnable;
    HippyTKDSkinHandler mHippyTKDSkinHandler;
    Typeface mSpecTypeface;

    public HippyTKDTextView(Context context) {
        super(context);
        this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
        setFocusable(true);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin
    public void hippySwitchSkin() {
        Layout layout;
        int i3;
        HippyArray hippyArray = this.mColors;
        if (hippyArray != null) {
            setColors(hippyArray);
        }
        if (this.mEmojiEnable && (layout = this.mLayout) != null) {
            Spanned spanned = (Spanned) layout.getText();
            for (ImageSpan imageSpan : (ImageSpan[]) spanned.getSpans(0, spanned.length(), ImageSpan.class)) {
                Drawable drawable = imageSpan.getDrawable();
                if (!ThemeUtil.isNowThemeIsNight(null, false, "")) {
                    i3 = 255;
                } else {
                    i3 = 100;
                }
                drawable.setAlpha(i3);
            }
        }
        this.mHippyTKDSkinHandler.switchSkin(this);
    }

    @Override // com.tencent.mtt.hippy.views.text.HippyTextView, com.tencent.mtt.hippy.views.list.HippyRecycler
    public void resetProps() {
        super.resetProps();
        this.mColors = null;
        this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
        this.mEmojiEnable = false;
        this.mContentDescription = null;
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBackgroundColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBackgroundColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderBottomColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderBottomColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderLeftColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderLeftColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderRightColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderRightColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderTopColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderTopColors(this, hippyArray);
    }

    public void setColors(HippyArray hippyArray) {
        this.mColors = hippyArray;
        super.setTextColor(HippyTKDSkinHandler.getColor(hippyArray));
        postInvalidate();
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        this.mContentDescription = (String) charSequence;
        super.setContentDescription(charSequence);
    }

    public void setEmojiEnable(boolean z16) {
        this.mEmojiEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.views.text.HippyTextView
    public void setLayout(Layout layout) {
        super.setLayout(layout);
        HippyArray hippyArray = this.mColors;
        if (hippyArray != null) {
            setColors(hippyArray);
        }
    }

    @Override // android.view.View
    @SuppressLint({"GetContentDescriptionOverride"})
    public String getContentDescription() {
        String str = this.mContentDescription;
        if (str != null) {
            return str;
        }
        Layout layout = this.mLayout;
        if (layout == null || layout.getText() == null) {
            return null;
        }
        return this.mLayout.getText().toString();
    }
}
