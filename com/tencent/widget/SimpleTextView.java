package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.theme.ISkinTypeface;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SimpleTextView extends View implements ISkinTypeface {
    static IPatchRedirector $redirector_;
    private int mCurTextColor;
    private int mGravity;
    private boolean mNeedCompute;
    private CharSequence mText;
    private Rect mTextBounds;
    private ColorStateList mTextColor;
    private final TextPaint mTextPaint;
    private float mX;
    private float mY;

    public SimpleTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void setRawTextSize(float f16) {
        if (f16 != this.mTextPaint.getTextSize()) {
            this.mTextPaint.setTextSize(f16);
            this.mNeedCompute = true;
            invalidate();
        }
    }

    private void updateTextColors() {
        int colorForState = this.mTextColor.getColorForState(getDrawableState(), 0);
        if (colorForState != this.mCurTextColor) {
            this.mCurTextColor = colorForState;
            invalidate();
        }
    }

    @Override // com.tencent.theme.ISkinTypeface
    public Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Paint) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mTextPaint;
    }

    public final CharSequence getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        String charSequence = this.mText.toString();
        this.mTextPaint.setColor(this.mCurTextColor);
        this.mTextPaint.drawableState = getDrawableState();
        canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.mNeedCompute) {
            this.mTextPaint.getTextBounds(charSequence, 0, charSequence.length(), this.mTextBounds);
            float desiredWidth = Layout.getDesiredWidth(charSequence, this.mTextPaint);
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = getWidth();
            int height = getHeight();
            int i3 = this.mGravity;
            int i16 = i3 & 7;
            float f16 = paddingLeft;
            this.mX = f16;
            if (i16 == 1) {
                this.mX = f16 + ((((width - paddingLeft) - paddingRight) - desiredWidth) / 2.0f);
            } else if (i16 == 5) {
                this.mX = f16 + (((width - paddingLeft) - paddingRight) - desiredWidth);
            }
            int i17 = i3 & 112;
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            int i18 = fontMetricsInt.descent;
            float f17 = ((i18 - fontMetricsInt.ascent) - i18) + paddingTop;
            this.mY = f17;
            if (i17 == 16) {
                this.mY = f17 + ((((height - paddingBottom) - paddingTop) - r2) / 2);
            } else if (i17 == 80) {
                this.mY = f17 + (((height - paddingBottom) - paddingTop) - r2);
            }
            this.mNeedCompute = false;
        }
        canvas.drawText(charSequence, this.mX, this.mY, this.mTextPaint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != 1073741824) {
            int ceil = ((int) Math.ceil(Layout.getDesiredWidth(this.mText, this.mTextPaint))) + getPaddingLeft() + getPaddingRight();
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, ceil);
            } else {
                size = ceil;
            }
        }
        if (mode2 != 1073741824) {
            int fontMetricsInt = this.mTextPaint.getFontMetricsInt(null) + getPaddingTop() + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(size2, fontMetricsInt);
            } else {
                size2 = fontMetricsInt;
            }
        }
        setMeasuredDimension(size, size2);
        if (measuredHeight != size2 || measuredWidth != size) {
            this.mNeedCompute = true;
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else if (this.mGravity != i3) {
            this.mGravity = i3;
            this.mNeedCompute = true;
            invalidate();
        }
    }

    public final void setText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence);
            return;
        }
        CharSequence charSequence2 = this.mText;
        if (charSequence2 != charSequence) {
            if (charSequence != null || !"".equals(charSequence2)) {
                this.mText = charSequence;
                if (charSequence == null) {
                    this.mText = "";
                }
                requestLayout();
                invalidate();
            }
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mTextColor = ColorStateList.valueOf(i3);
            updateTextColors();
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            setTextSize(2, f16);
        } else {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        }
    }

    public SimpleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void setTextSize(int i3, float f16) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics()));
    }

    public SimpleTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mGravity = 17;
        this.mText = "";
        Resources resources = getResources();
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = resources.getDisplayMetrics().density;
        this.mTextBounds = new Rect();
        this.mNeedCompute = true;
        textPaint.setTypeface(Typeface.SANS_SERIF);
    }
}
