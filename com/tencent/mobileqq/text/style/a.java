package com.tencent.mobileqq.text.style;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends SmallEmojiSpan {
    static IPatchRedirector $redirector_;

    public a(char[] cArr, int i3, boolean z16, boolean z17) {
        super(cArr, i3, z16, z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.text.style.SmallEmojiSpan, com.tencent.mobileqq.text.style.EmoticonSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return this.size;
        }
        Rect bounds = drawable.getBounds();
        float height = bounds.height();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (fontMetricsInt != null) {
            int i17 = (int) (((fontMetrics.descent + fontMetrics.ascent) / 2.0f) - (height / 2.0f));
            fontMetricsInt.top = i17;
            fontMetricsInt.ascent = i17;
            int i18 = (int) (height + i17);
            fontMetricsInt.bottom = i18;
            fontMetricsInt.descent = i18;
        }
        return bounds.right;
    }
}
