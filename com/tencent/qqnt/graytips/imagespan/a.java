package com.tencent.qqnt.graytips.imagespan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a extends ImageSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f356871d;

    public a(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f356871d = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i26 = this.f356871d;
        if (i26 > 0) {
            drawable.setBounds(0, 0, i26, i26);
        } else if (i26 == 0) {
            int dip2px = ViewUtils.dip2px(16.0f);
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight == 0) {
                intrinsicHeight = dip2px;
            }
            drawable.setBounds(0, 0, (drawable.getIntrinsicWidth() * dip2px) / intrinsicHeight, dip2px);
        }
        canvas.save();
        canvas.translate(f16, ((((fontMetricsInt.descent + i18) + i18) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        Drawable drawable = getDrawable();
        drawable.getBounds();
        int i17 = this.f356871d;
        if (i17 > 0) {
            drawable.setBounds(0, 0, i17, i17);
        } else if (i17 == 0) {
            int dip2px = ViewUtils.dip2px(16.0f);
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight == 0) {
                intrinsicHeight = dip2px;
            }
            drawable.setBounds(0, 0, (drawable.getIntrinsicWidth() * dip2px) / intrinsicHeight, dip2px);
        }
        Rect bounds = drawable.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i18 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i19 = (bounds.bottom - bounds.top) / 2;
            int i26 = i18 / 4;
            int i27 = i19 - i26;
            int i28 = -(i19 + i26);
            fontMetricsInt.ascent = i28;
            fontMetricsInt.top = i28;
            fontMetricsInt.bottom = i27;
            fontMetricsInt.descent = i27;
        }
        return bounds.right;
    }

    public a(Context context, int i3, int i16) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f356871d = i16;
        } else {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
