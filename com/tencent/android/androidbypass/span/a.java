package com.tencent.android.androidbypass.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends DynamicDrawableSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f72435d;

    /* renamed from: e, reason: collision with root package name */
    private int f72436e;

    /* renamed from: f, reason: collision with root package name */
    private int f72437f;

    public a(Drawable drawable) {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
            return;
        }
        this.f72436e = 0;
        this.f72437f = 0;
        this.f72435d = drawable;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f72437f;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f72436e;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        Drawable drawable = this.f72435d;
        if (drawable instanceof h.b) {
            return ((h.b) drawable).i();
        }
        return true;
    }

    public void d(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
        } else {
            this.f72435d = drawable;
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = this.f72435d;
        canvas.save();
        Rect bounds = drawable.getBounds();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.translate(f16, (i18 + ((fontMetrics.descent + fontMetrics.ascent) / 2.0f)) - (bounds.height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f72435d;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        int width = this.f72435d.getBounds().width();
        int height = this.f72435d.getBounds().height();
        if (fontMetricsInt != null) {
            int i17 = (int) ((height / 2.0f) - ((-(fontMetricsInt.ascent + fontMetricsInt.descent)) / 2.0f));
            fontMetricsInt.bottom = i17;
            int i18 = i17 - height;
            fontMetricsInt.top = i18;
            fontMetricsInt.ascent = i18;
            fontMetricsInt.descent = i17;
        }
        return width;
    }

    public a(Drawable drawable, int i3, int i16) {
        this(drawable);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, drawable, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f72436e = i3;
            this.f72437f = i16;
        }
    }
}
