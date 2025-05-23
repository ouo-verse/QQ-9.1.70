package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeText extends TextBase {
    private static final String TAG = "NativeText_TMTEST";
    protected NativeTextImp mNative;
    protected boolean mSupportHtmlStyle;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new NativeText(vafContext);
        }
    }

    public NativeText(VafContext vafContext) {
        super(vafContext);
        this.mSupportHtmlStyle = false;
        this.mNative = new NativeTextImp(vafContext.getContext());
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        return this.mNative.getComMeasuredHeight();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        return this.mNative.getComMeasuredWidth();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.mNative.comLayout(i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        this.mNative.measureComponent(i3, i16);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        int i3;
        super.onParseValueFinished();
        int i16 = 0;
        this.mNative.setIncludeFontPadding(false);
        this.mNative.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        this.mNative.setTextSize(0, this.mTextSize);
        this.mNative.setBorderColor(this.mBorderColor);
        this.mNative.setBorderWidth(this.mBorderWidth);
        this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
        this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
        this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
        this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
        this.mNative.setBackgroundColor(this.mBackground);
        this.mNative.setTextColor(this.mTextColor);
        int i17 = this.mTextStyle;
        if ((i17 & 1) != 0) {
            i3 = 33;
        } else {
            i3 = 1;
        }
        if ((i17 & 8) != 0) {
            i3 |= 16;
        }
        this.mNative.setPaintFlags(i3);
        if ((this.mTextStyle & 2) != 0) {
            this.mNative.setTypeface(null, 3);
        }
        int i18 = this.mLines;
        if (i18 > 0) {
            this.mNative.setLines(i18);
        }
        int i19 = this.mMaxLines;
        if (i19 > 0) {
            this.mNative.setMaxLines(i19);
        }
        if (this.mEllipsize >= 0) {
            this.mNative.setEllipsize(TextUtils.TruncateAt.values()[this.mEllipsize]);
        }
        Typeface typeface = this.mTypeface;
        if (typeface != null) {
            this.mNative.setTypeface(typeface);
        }
        int i26 = this.mGravity;
        if ((i26 & 4) != 0) {
            i16 = 1;
        } else if ((i26 & 1) != 0) {
            i16 = 3;
        } else if ((i26 & 2) != 0) {
            i16 = 5;
        }
        if ((i26 & 32) != 0) {
            i16 |= 16;
        } else if ((i26 & 8) != 0) {
            i16 |= 48;
        } else if ((i26 & 16) != 0) {
            i16 |= 80;
        }
        this.mNative.setGravity(i16);
        this.mNative.setLineSpacing(this.mLineSpaceExtra, this.mLineSpaceMultipiler);
        int i27 = this.mMaxWidth;
        if (i27 > 0) {
            this.mNative.setMaxWidth(i27);
        }
        Boolean bool = this.mEnableMarquee;
        if (bool != null) {
            this.mNative.setEnableMarquee(bool.booleanValue());
        }
        Boolean bool2 = this.mEnableClickSpan;
        if (bool2 != null && bool2.booleanValue()) {
            this.mNative.setMovementMethod(a.getInstance());
        } else {
            this.mNative.setMovementMethod(null);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            setRealText(this.mText);
        } else {
            setRealText("");
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mSupportHtmlStyle = false;
        this.mLineSpaceMultipiler = 1.0f;
        this.mLineSpaceExtra = 0.0f;
        this.mText = null;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
    protected void setDrawableLeft(String str) {
        if (this.drawableLeftPath != null) {
            NativeTextImp nativeTextImp = this.mNative;
            nativeTextImp.setCompoundDrawablesWithIntrinsicBounds(DrawableUtil.getDrawable(nativeTextImp.getContext(), this.drawableLeftPath, null, null), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRealText(CharSequence charSequence) {
        this.mText = charSequence;
        if (this.mNative.getLayoutParams() == null) {
            Layout.Params comLayoutParams = getComLayoutParams();
            this.mNative.setLayoutParams(new ViewGroup.LayoutParams(comLayoutParams.mLayoutWidth, comLayoutParams.mLayoutHeight));
        }
        this.mNative.setText(charSequence);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
    public void setText(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mText)) {
            setRealText(charSequence);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
    public void setTextColor(int i3) {
        if (this.mTextColor != i3) {
            this.mTextColor = i3;
            this.mNative.setTextColor(i3);
        }
    }
}
