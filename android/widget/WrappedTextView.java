package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class WrappedTextView extends View {
    private TextView mSystemTextView;

    public WrappedTextView(Context context) {
        super(context);
        initWrappedView();
    }

    private TextView createWrapperView(Context context) {
        return new TextView(context);
    }

    private void initWrappedView() {
        if (com.tencent.fastertextview.util.b.a() && this.mSystemTextView == null) {
            TextView createWrapperView = createWrapperView(getContext());
            this.mSystemTextView = createWrapperView;
            createWrapperView.setId(getId());
            this.mSystemTextView.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingBottom(), getPaddingRight());
            this.mSystemTextView.setBackground(getBackground());
            this.mSystemTextView.setVisibility(getVisibility());
            this.mSystemTextView.setContentDescription(getContentDescription());
            this.mSystemTextView.setFocusableInTouchMode(isFocusableInTouchMode());
            this.mSystemTextView.setFocusable(isFocusable());
            this.mSystemTextView.setClickable(isClickable());
            this.mSystemTextView.setDuplicateParentStateEnabled(isDuplicateParentStateEnabled());
            this.mSystemTextView.setFitsSystemWindows(getFitsSystemWindows());
            this.mSystemTextView.setRotation(getRotation());
            this.mSystemTextView.setRotationX(getRotationX());
            this.mSystemTextView.setRotationY(getRotationY());
            this.mSystemTextView.setScrollX(getScrollX());
            this.mSystemTextView.setScrollY(getScrollY());
            this.mSystemTextView.setTranslationX(getTranslationX());
            this.mSystemTextView.setTranslationY(getTranslationY());
            this.mSystemTextView.setTranslationZ(getTranslationZ());
            this.mSystemTextView.setScrollBarSize(getScrollBarSize());
            this.mSystemTextView.setAlpha(getAlpha());
            this.mSystemTextView.setTextAlignment(getTextAlignment());
            this.mSystemTextView.setElevation(getElevation());
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mSystemTextView != null) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int indexOfChild = viewGroup.indexOfChild(this);
            if (viewGroup.indexOfChild(this.mSystemTextView) < 0) {
                viewGroup.addView(this.mSystemTextView, indexOfChild, getLayoutParams());
                viewGroup.removeView(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.draw(canvas);
        }
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        super.setAlpha(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setAlpha(f16);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        super.setBackgroundColor(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setBackgroundColor(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i3) {
        super.setBackgroundResource(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setBackgroundResource(i3);
        }
    }

    public void setBreakStrategy(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setBreakStrategy(i3);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z16) {
        super.setClickable(z16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setClickable(z16);
        }
    }

    public void setCompoundDrawablePadding(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setCompoundDrawablePadding(i3);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        super.setContentDescription(charSequence);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    @Override // android.view.View
    public void setDuplicateParentStateEnabled(boolean z16) {
        super.setDuplicateParentStateEnabled(z16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setDuplicateParentStateEnabled(z16);
        }
    }

    @Override // android.view.View
    public void setElevation(float f16) {
        super.setElevation(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setElevation(f16);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setEllipsize(truncateAt);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setEnabled(z16);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z16) {
        super.setFitsSystemWindows(z16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setFitsSystemWindows(z16);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z16) {
        super.setFocusable(z16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setFocusable(z16);
        }
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z16) {
        super.setFocusableInTouchMode(z16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setFocusableInTouchMode(z16);
        }
    }

    public void setGravity(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setGravity(i3);
        }
    }

    public void setHeight(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setHeight(i3);
        }
    }

    public void setHighlightColor(@ColorInt int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setHighlightColor(i3);
        }
    }

    public void setHint(CharSequence charSequence) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setHint(charSequence);
        }
    }

    public void setHintTextColor(@ColorInt int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setHintTextColor(i3);
        }
    }

    public void setHorizontallyScrolling(boolean z16) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setHorizontallyScrolling(z16);
        }
    }

    @Override // android.view.View
    public void setId(int i3) {
        super.setId(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setId(i3);
        }
    }

    public void setIncludeFontPadding(boolean z16) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setIncludeFontPadding(z16);
        }
    }

    public void setLineSpacing(float f16, float f17) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setLineSpacing(f16, f17);
        }
    }

    public void setLines(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setLines(i3);
        }
    }

    public void setLinkTextColor(@ColorInt int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setLinkTextColor(i3);
        }
    }

    public void setMaxHeight(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setMaxHeight(i3);
        }
    }

    public void setMaxLines(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setMaxLines(i3);
        }
    }

    public void setMaxWidth(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setMaxWidth(i3);
        }
    }

    public void setMinHeight(int i3) {
        super.setMinimumHeight(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setMinHeight(i3);
        }
    }

    public void setMinLines(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setMinLines(i3);
        }
    }

    public void setMinWidth(int i3) {
        super.setMinimumWidth(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setMinWidth(i3);
        }
    }

    public void setMovementMethod(qk0.a aVar) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setPadding(i3, i16, i17, i18);
        }
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i16, int i17, int i18) {
        super.setPaddingRelative(i3, i16, i17, i18);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setPaddingRelative(i3, i16, i17, i18);
        }
    }

    @Override // android.view.View
    public void setRotation(float f16) {
        super.setRotation(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setRotation(f16);
        }
    }

    @Override // android.view.View
    public void setRotationX(float f16) {
        super.setRotationX(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setRotationX(f16);
        }
    }

    @Override // android.view.View
    public void setRotationY(float f16) {
        super.setRotationY(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setRotationY(f16);
        }
    }

    @Override // android.view.View
    public void setScrollBarSize(int i3) {
        super.setScrollBarSize(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setScrollBarSize(i3);
        }
    }

    @Override // android.view.View
    public void setScrollX(int i3) {
        super.setScrollX(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setScrollX(i3);
        }
    }

    @Override // android.view.View
    public void setScrollY(int i3) {
        super.setScrollY(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setScrollY(i3);
        }
    }

    public void setSingleLine(boolean z16) {
        throw new RuntimeException("");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null) {
            charSequence = "";
        }
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setText(charSequence, bufferType);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i3) {
        super.setTextAlignment(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTextAlignment(i3);
        }
    }

    public void setTextColor(@ColorInt int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public void setTextCursorDrawable(Drawable drawable) {
        TextView textView = this.mSystemTextView;
        if (textView == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        textView.setTextCursorDrawable(drawable);
    }

    public void setTextSelectHandle(Drawable drawable) {
        TextView textView = this.mSystemTextView;
        if (textView == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        textView.setTextSelectHandle(drawable);
    }

    public void setTextSelectHandleLeft(Drawable drawable) {
        TextView textView = this.mSystemTextView;
        if (textView == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        textView.setTextSelectHandleLeft(drawable);
    }

    public void setTextSelectHandleRight(Drawable drawable) {
        TextView textView = this.mSystemTextView;
        if (textView == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        textView.setTextSelectHandleRight(drawable);
    }

    public void setTextSize(float f16) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTextSize(f16);
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f16) {
        super.setTranslationX(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTranslationX(f16);
        }
    }

    @Override // android.view.View
    public void setTranslationY(float f16) {
        super.setTranslationY(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTranslationY(f16);
        }
    }

    @Override // android.view.View
    public void setTranslationZ(float f16) {
        super.setTranslationZ(f16);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTranslationZ(f16);
        }
    }

    public void setTypeface(Typeface typeface, int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTypeface(typeface, i3);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    public void setWidth(int i3) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setWidth(i3);
        }
    }

    public WrappedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initWrappedView();
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setHintTextColor(colorStateList);
        }
    }

    public void setLinkTextColor(ColorStateList colorStateList) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setLinkTextColor(colorStateList);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTextSize(int i3, float f16) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTextSize(i3, f16);
        }
    }

    public void setTypeface(Typeface typeface) {
        TextView textView = this.mSystemTextView;
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void setTextCursorDrawable(@DrawableRes int i3) {
        setTextCursorDrawable(i3 != 0 ? getContext().getDrawable(i3) : null);
    }

    public void setTextSelectHandle(@DrawableRes int i3) {
        setTextSelectHandle(getContext().getDrawable(i3));
    }

    public void setTextSelectHandleLeft(@DrawableRes int i3) {
        setTextSelectHandleLeft(getContext().getDrawable(i3));
    }

    public void setTextSelectHandleRight(@DrawableRes int i3) {
        setTextSelectHandleRight(getContext().getDrawable(i3));
    }

    public WrappedTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initWrappedView();
    }
}
