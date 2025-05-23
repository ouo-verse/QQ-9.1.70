package com.tencent.mobileqq.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GuildEmoticonSpan extends EmoticonSpan {
    static IPatchRedirector $redirector_;

    public GuildEmoticonSpan(int i3, int i16, int i17) {
        super(i3, i16, i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Paint.FontMetrics fontMetrics;
        float f17;
        float f18;
        float f19;
        float f26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float height = drawable.getBounds().height();
        canvas.save();
        float f27 = i18 - this.size;
        if (paint != null) {
            fontMetrics = paint.getFontMetrics();
        } else {
            fontMetrics = null;
        }
        if (fontMetrics != null) {
            f17 = fontMetrics.top;
            f18 = fontMetrics.bottom;
            f19 = fontMetrics.ascent;
            f26 = fontMetrics.descent;
            float f28 = (int) (((f26 + f19) / 2.0f) - (height / 2.0f));
            fontMetrics.top = f28;
            fontMetrics.ascent = f28;
            float f29 = (int) (height + f28);
            fontMetrics.bottom = f29;
            fontMetrics.descent = f29;
            if (i19 > i18) {
                f27 += f29;
            }
        } else {
            f17 = 0.0f;
            f18 = 0.0f;
            f19 = 0.0f;
            f26 = 0.0f;
        }
        canvas.translate(f16, f27);
        drawable.draw(canvas);
        this.eLeft = f16;
        this.eTop = i17;
        this.eRight = f16 + this.size;
        this.eBottom = i19;
        if (fontMetrics != null) {
            fontMetrics.ascent = f19;
            fontMetrics.descent = f26;
            fontMetrics.top = f17;
            fontMetrics.bottom = f18;
        }
        canvas.restore();
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        return this.size;
    }
}
