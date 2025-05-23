package com.tencent.ams.mosaic.jsengine.component.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p extends ImageSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static int f71343d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58453);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f71343d = 2;
        }
    }

    public p(Drawable drawable, int i3) {
        super(drawable, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable, i3);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        if (canvas != null && paint != null) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (drawable != null && drawable.getBounds() != null && fontMetricsInt != null) {
                canvas.save();
                int i26 = i19 - drawable.getBounds().bottom;
                int i27 = ((ImageSpan) this).mVerticalAlignment;
                if (i27 == 1) {
                    i26 -= fontMetricsInt.descent;
                } else if (i27 == f71343d) {
                    i26 = (((fontMetricsInt.descent + i18) + (i18 + fontMetricsInt.ascent)) / 2) - (drawable.getBounds().bottom / 2);
                }
                canvas.translate(f16, i26);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect rect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rect = drawable.getBounds();
        } else {
            rect = null;
        }
        if (fontMetricsInt != null && rect != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i18 = (rect.bottom - rect.top) / 2;
            int i19 = i17 / 4;
            int i26 = i18 - i19;
            int i27 = -(i18 + i19);
            fontMetricsInt.ascent = i27;
            fontMetricsInt.top = i27;
            fontMetricsInt.bottom = i26;
            fontMetricsInt.descent = i26;
            return rect.right;
        }
        return super.getSize(paint, charSequence, i3, i16, fontMetricsInt);
    }
}
