package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TimeDownTextView extends View {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private Rect J;
    private CharSequence K;
    private TextPaint L;
    boolean M;
    private int N;

    /* renamed from: d, reason: collision with root package name */
    protected TextPaint f259353d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f259354e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f259355f;

    /* renamed from: h, reason: collision with root package name */
    private int f259356h;

    /* renamed from: i, reason: collision with root package name */
    private int f259357i;

    /* renamed from: m, reason: collision with root package name */
    private int f259358m;

    public TimeDownTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.M) {
            CharSequence charSequence = this.K;
            canvas.drawText(charSequence, 0, charSequence.length(), this.F, this.G, this.L);
        }
        CharSequence charSequence2 = this.f259354e;
        canvas.drawText(charSequence2, 0, charSequence2.length(), this.D, this.E, this.f259353d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f259356h = i3;
        this.f259357i = i16;
        if (!this.M) {
            this.D = (i3 / 2) - (this.f259358m / 2);
            this.E = (i16 / 2) + (this.C / 2);
        } else {
            this.F = (i3 / 2) - (((this.H + this.N) + this.f259358m) / 2);
            this.G = (i16 / 2) + ((this.I + this.C) / 2);
        }
    }

    public void setBoldTextStyle() {
        Typeface create;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Typeface typeface = this.f259353d.getTypeface();
        if (typeface == null) {
            create = Typeface.defaultFromStyle(1);
        } else {
            create = Typeface.create(typeface, 1);
        }
        this.f259353d.setTypeface(create);
        this.f259353d.setFakeBoldText(true);
    }

    public void setText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) charSequence);
            return;
        }
        if (charSequence.length() != this.f259354e.length()) {
            this.f259353d.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.f259355f);
            this.f259358m = this.f259355f.width();
            int height = this.f259355f.height();
            this.C = height;
            this.D = (this.f259356h / 2) - (this.f259358m / 2);
            this.E = (this.f259357i / 2) + (height / 2);
            Paint.FontMetricsInt fontMetricsInt = this.f259353d.getFontMetricsInt();
            int i3 = this.f259357i - fontMetricsInt.bottom;
            int i16 = fontMetricsInt.top;
            this.E = ((i3 + i16) / 2) - i16;
        }
        this.f259354e = charSequence;
        this.M = false;
        invalidate();
    }

    public void setText2(CharSequence charSequence, CharSequence charSequence2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) charSequence, (Object) charSequence2);
            return;
        }
        if (charSequence2.length() != this.K.length() || charSequence.length() != this.f259354e.length()) {
            this.L.getTextBounds(charSequence2.toString(), 0, charSequence2.length(), this.J);
            this.H = this.J.width();
            this.I = this.J.height();
            this.f259353d.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.f259355f);
            this.f259358m = this.f259355f.width();
            this.C = this.f259355f.height();
            this.F = (this.f259356h / 2) - ((this.H + this.f259358m) / 2);
            Paint.FontMetricsInt fontMetricsInt = this.L.getFontMetricsInt();
            int i3 = this.f259357i - fontMetricsInt.bottom;
            int i16 = fontMetricsInt.top;
            this.G = ((i3 + i16) / 2) - i16;
            this.D = this.F + this.H + this.N;
            Paint.FontMetricsInt fontMetricsInt2 = this.f259353d.getFontMetricsInt();
            int i17 = this.f259357i - fontMetricsInt2.bottom;
            int i18 = fontMetricsInt2.top;
            this.E = ((i17 + i18) / 2) - i18;
        }
        this.M = true;
        this.f259354e = charSequence;
        this.K = charSequence2;
        invalidate();
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f259353d.setColor(i3);
        }
    }

    public void setTextSize(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Float.valueOf(f16));
        } else {
            this.f259353d.setTextSize(TypedValue.applyDimension(i3, f16, getResources().getDisplayMetrics()));
        }
    }

    public TimeDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f259354e = "";
        this.K = "";
        this.M = false;
        this.f259353d = new TextPaint(1);
        this.f259353d.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/DS-DIGIB.TTF"));
        this.f259353d.setColor(Color.parseColor("#FCD383"));
        setTextSize(1, 18.0f);
        this.f259355f = new Rect();
        TextPaint textPaint = new TextPaint(1);
        this.L = textPaint;
        textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.L.setTextSize(BaseAIOUtils.f(16.0f, getResources()));
        this.J = new Rect();
        this.N = BaseAIOUtils.f(5.0f, getResources());
    }
}
