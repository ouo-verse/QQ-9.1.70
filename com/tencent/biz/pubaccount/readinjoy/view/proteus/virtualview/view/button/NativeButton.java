package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeButton extends ButtonBase {
    private static final String DRAWABLE_LEFT = "l";
    private static final String TAG = "NativeButton";
    private CharSequence mBtnText;
    private NativeButtonImp mNative;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new NativeButton(vafContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class CenterImageSpan extends ImageSpan {
        public CenterImageSpan(@NonNull Drawable drawable) {
            super(drawable);
            if (TextUtils.isEmpty(((TextBase) NativeButton.this).mText)) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding, getDrawableHeight());
            } else {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding, ((TextBase) NativeButton.this).mTextSize);
            }
        }

        private int getDrawableHeight() {
            if (((ViewBase) NativeButton.this).mMeasuredHeight > 0) {
                return ((ViewBase) NativeButton.this).mMeasuredHeight;
            }
            if (NativeButton.this.mNative.getComMeasuredHeight() > 0) {
                return NativeButton.this.mNative.getComMeasuredHeight();
            }
            if (((ViewBase) NativeButton.this).mParams == null || ((ViewBase) NativeButton.this).mParams.mLayoutHeight <= 0) {
                return ((TextBase) NativeButton.this).mTextSize;
            }
            return ((ViewBase) NativeButton.this).mParams.mLayoutHeight;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
            int intrinsicHeight;
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!TextUtils.isEmpty(((TextBase) NativeButton.this).mText)) {
                int i26 = ((TextBase) NativeButton.this).mTextSize;
                if (NativeButton.this.mNative.getMeasuredHeight() > 0 && i26 > NativeButton.this.mNative.getMeasuredHeight()) {
                    i26 = NativeButton.this.mNative.getMeasuredHeight();
                }
                intrinsicHeight = ((i26 - drawable.getIntrinsicHeight()) / 2) + (((((fontMetricsInt.descent + i18) + i18) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                canvas.save();
                canvas.translate(f16, intrinsicHeight);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                drawable.draw(canvas);
                canvas.restore();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                NativeButton nativeButton = NativeButton.this;
                drawable.setBounds(0, 0, intrinsicWidth + nativeButton.mCompoundDrawablePadding, ((TextBase) nativeButton).mTextSize);
            } else {
                canvas.save();
                intrinsicHeight = (NativeButton.this.mNative.getMeasuredHeight() - drawable.getIntrinsicHeight()) / 2;
                Rect bounds = drawable.getBounds();
                if (bounds.bottom != getDrawableHeight()) {
                    intrinsicHeight -= (getDrawableHeight() - bounds.bottom) / 2;
                }
                canvas.translate(f16, intrinsicHeight);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                drawable.draw(canvas);
                canvas.restore();
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding, getDrawableHeight());
            }
            if (LogUtils.shouldLog()) {
                LogUtils.d(NativeButton.TAG, ((ViewBase) NativeButton.this).mName + " : draw:  start:" + i3 + " end:" + i16 + " x:" + f16 + " top:" + i17 + " y:" + i18 + " bottom:" + i19 + " fm:" + fontMetricsInt + " drawable getIntrinsicHeight :" + drawable.getIntrinsicHeight() + " mTextSize :" + ((TextBase) NativeButton.this).mTextSize + "measureHeight: " + NativeButton.this.mNative.getMeasuredHeight() + "transY: " + intrinsicHeight);
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            super.getSize(paint, charSequence, i3, i16, fontMetricsInt);
            return getDrawable().getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding;
        }
    }

    NativeButton(VafContext vafContext) {
        super(vafContext);
        this.mNative = new NativeButtonImp(vafContext.getContext());
    }

    private Drawable radius(Drawable drawable) {
        RoundedDrawable fromDrawable = RoundedDrawable.fromDrawable(drawable);
        if (fromDrawable != null) {
            fromDrawable.setCornerRadius(this.mBorderRadius);
            fromDrawable.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return fromDrawable;
    }

    private void setBackGroundForState(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        if (this.mBorderRadius > 0) {
            drawable = radius(drawable);
            drawable2 = radius(drawable2);
            drawable3 = radius(drawable3);
        }
        this.mNative.setBackgroundDrawable(DrawableUtil.getSelector(drawable, drawable2, drawable3));
    }

    private void setRealText(CharSequence charSequence) {
        if (this.mNative.getLayoutParams() == null) {
            Layout.Params comLayoutParams = getComLayoutParams();
            this.mNative.setLayoutParams(new ViewGroup.LayoutParams(comLayoutParams.mLayoutWidth, comLayoutParams.mLayoutHeight));
        }
        this.mNative.setText(charSequence);
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

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        super.onParseValueFinished();
        int i3 = 1;
        this.mNative.setClickable(true);
        this.mNative.setIncludeFontPadding(false);
        this.mNative.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        this.mNative.setTextSize(0, this.mTextSize);
        this.mNative.setLineSpacing(0.0f, 1.0f);
        this.mNative.setBorderColor(this.mBorderColor);
        this.mNative.setBorderWidth(this.mBorderWidth);
        this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
        this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
        this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
        this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
        this.mNative.setBackgroundColor(this.mBackground);
        Typeface typeface = this.mTypeface;
        if (typeface != null) {
            this.mNative.setTypeface(typeface);
        }
        int i16 = this.mTextStyle;
        if ((i16 & 1) != 0) {
            i3 = 33;
        }
        if ((i16 & 8) != 0) {
            i3 |= 16;
        }
        this.mNative.setPaintFlags(i3);
        if ((this.mTextStyle & 2) != 0) {
            this.mNative.setTypeface(null, 3);
        }
        int i17 = this.mMaxWidth;
        if (i17 > 0) {
            this.mNative.setMaxWidth(i17);
        }
        if (!TextUtils.isEmpty(this.mBtnText)) {
            setRealText(this.mBtnText);
        } else if (!TextUtils.isEmpty(this.mText)) {
            setRealText(this.mText);
        } else {
            setRealText("");
        }
        refresh();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mSupportHtmlStyle = false;
        this.mText = null;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
    protected void setBackgroundColorForStates() {
        setBackGroundForState(DrawableUtil.getDrawable(getStatus(0).backgroundColor), DrawableUtil.getDrawable(getStatus(1).backgroundColor), DrawableUtil.getDrawable(getStatus(4).backgroundColor));
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
    protected void setBackgroundForStates() {
        Context context = this.mNative.getContext();
        setBackGroundForState(DrawableUtil.getDrawable(context, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable(context, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable(context, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
    protected void setCompoundDrawableForStates() {
        Context context = this.mNative.getContext();
        if (this.drawableLeftPath != null && getStatus(0).img != this.drawableLeftPath) {
            getStatus(0).img = this.drawableLeftPath;
        }
        StateListDrawable selector = DrawableUtil.getSelector(DrawableUtil.getDrawable(context, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable(context, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable(context, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
        SpannableString spannableString = new SpannableString("l" + ((Object) this.mText));
        spannableString.setSpan(new CenterImageSpan(selector), 0, 1, 33);
        this.mBtnText = spannableString;
        setText(spannableString);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
    protected void setDrawableLeft(String str) {
        this.drawableLeftPath = str;
        setCompoundDrawableForStates();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
    public void setSelected(boolean z16) {
        super.setSelected(z16);
        this.mNative.setSelected(z16);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
    public void setText(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mBtnText)) {
            this.mBtnText = charSequence;
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

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
    protected void setTextColorForStates() {
        this.mNative.setTextColor(ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor));
    }
}
