package com.tencent.mobileqq.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OffsetableImageSpan extends ImageSpan {
    static IPatchRedirector $redirector_;
    private float mVerticalOffsetPercent;
    private int mVerticalOffsetValue;

    public OffsetableImageSpan(Drawable drawable, int i3) {
        super(drawable, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable, i3);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = getDrawable();
        canvas.save();
        int i26 = i19 - drawable.getBounds().bottom;
        if (((ImageSpan) this).mVerticalAlignment == 1) {
            i26 -= paint.getFontMetricsInt().descent;
        }
        if (this.mVerticalOffsetValue == 0) {
            float f17 = this.mVerticalOffsetPercent;
            if (f17 != 0.0f) {
                this.mVerticalOffsetValue = (int) ((i19 - i17) * f17);
            }
        }
        canvas.translate(f16, i26 + this.mVerticalOffsetValue);
        drawable.draw(canvas);
        canvas.restore();
    }

    public OffsetableImageSpan setOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OffsetableImageSpan) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        }
        this.mVerticalOffsetPercent = f16;
        return this;
    }
}
