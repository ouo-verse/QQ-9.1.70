package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.al;
import com.tencent.theme.ISkinTypeface;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SimpleTextView extends View implements ISkinTypeface {
    static IPatchRedirector $redirector_;
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f181593d;

    /* renamed from: e, reason: collision with root package name */
    private final TextPaint f181594e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f181595f;

    /* renamed from: h, reason: collision with root package name */
    private int f181596h;

    /* renamed from: i, reason: collision with root package name */
    private int f181597i;

    /* renamed from: m, reason: collision with root package name */
    private Paint.FontMetrics f181598m;

    public SimpleTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181593d = "";
        this.f181597i = -16777216;
        this.C = -1;
        Resources resources = getResources();
        TextPaint textPaint = new TextPaint(1);
        this.f181594e = textPaint;
        textPaint.density = resources.getDisplayMetrics().density;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.D7);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(jj2.b.E7, (int) al.a(context, 12.0f));
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(jj2.b.F7);
            String string = obtainStyledAttributes.getString(jj2.b.G7);
            textPaint.setTextSize(dimensionPixelSize);
            this.f181598m = textPaint.getFontMetrics();
            this.f181595f = colorStateList;
            int colorForState = this.f181595f.getColorForState(getDrawableState(), this.f181597i);
            this.f181596h = colorForState;
            textPaint.setColor(colorForState);
            textPaint.setTypeface(Typeface.SANS_SERIF);
            setText(string);
            obtainStyledAttributes.recycle();
        }
    }

    private int c(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(size, i16);
        }
        return i16;
    }

    private void d() {
        int colorForState = this.f181595f.getColorForState(getDrawableState(), this.f181597i);
        if (colorForState != this.f181596h) {
            this.f181596h = colorForState;
            this.f181594e.setColor(colorForState);
            invalidate();
        }
    }

    public CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CharSequence) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f181593d;
    }

    public Paint b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Paint) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f181594e;
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.drawableStateChanged();
        ColorStateList colorStateList = this.f181595f;
        if (colorStateList != null && colorStateList.isStateful()) {
            d();
        }
    }

    @Override // com.tencent.theme.ISkinTypeface
    public Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Paint) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f181594e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        int measuredHeight = getMeasuredHeight();
        Paint.FontMetrics fontMetrics = this.f181598m;
        float f16 = fontMetrics.bottom;
        float f17 = measuredHeight;
        float f18 = (f17 - ((f17 - (f16 - fontMetrics.top)) / 2.0f)) - f16;
        CharSequence charSequence = this.f181593d;
        canvas.drawText(charSequence, 0, charSequence.length(), getPaddingLeft(), f18, this.f181594e);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int i17 = this.C;
        if (i17 == -1) {
            TextPaint textPaint = this.f181594e;
            CharSequence charSequence = this.f181593d;
            i17 = (int) textPaint.measureText(charSequence, 0, charSequence.length());
        }
        int c16 = c(i3, i17);
        Paint.FontMetrics fontMetrics = this.f181598m;
        setMeasuredDimension(c16, c(i16, Math.max((int) (fontMetrics.top - fontMetrics.bottom), getSuggestedMinimumWidth())));
    }

    public void setDefaultTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f181597i = i3;
        }
    }

    public void setFixedWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.C = i3;
        }
    }

    public void setText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) charSequence);
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (charSequence != this.f181593d) {
            this.f181593d = charSequence;
            requestLayout();
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) colorStateList);
        } else {
            this.f181595f = colorStateList;
            d();
        }
    }

    public void setTextSize(float f16) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        this.f181594e.setTextSize(TypedValue.applyDimension(1, f16, resources.getDisplayMetrics()));
        this.f181598m = this.f181594e.getFontMetrics();
        requestLayout();
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f181595f = ColorStateList.valueOf(i3);
        d();
        invalidate();
    }

    public SimpleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
