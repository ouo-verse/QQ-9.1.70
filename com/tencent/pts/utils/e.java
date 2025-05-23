package com.tencent.pts.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends ReplacementSpan {
    static IPatchRedirector $redirector_;
    private final float C;
    private final float D;

    /* renamed from: d, reason: collision with root package name */
    private final int f342268d;

    /* renamed from: e, reason: collision with root package name */
    private final int f342269e;

    /* renamed from: f, reason: collision with root package name */
    private final float f342270f;

    /* renamed from: h, reason: collision with root package name */
    private final float f342271h;

    /* renamed from: i, reason: collision with root package name */
    private final float f342272i;

    /* renamed from: m, reason: collision with root package name */
    private final float f342273m;

    public e(int i3, int i16, float f16, float f17, float f18, float f19, float f26, float f27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27));
            return;
        }
        this.f342268d = i3;
        this.f342269e = i16;
        this.f342270f = f16;
        this.f342271h = f17;
        this.f342272i = f18;
        this.f342273m = f19;
        this.C = f26;
        this.D = f27;
    }

    private TextPaint a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize(this.D);
        return textPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        paint.setTextSize(this.D);
        TextPaint a16 = a(paint);
        Paint.FontMetricsInt fontMetricsInt = a16.getFontMetricsInt();
        float f17 = fontMetricsInt.top;
        float f18 = fontMetricsInt.bottom;
        float measureText = this.f342270f + f16 + paint.measureText(charSequence, i3, i16);
        paint.getTextBounds(charSequence.toString(), i3, i16, new Rect());
        RectF rectF = new RectF();
        rectF.set(f16, i17, measureText + this.f342271h, i19 + this.f342272i + this.f342273m);
        paint.setColor(this.f342268d);
        float f19 = this.C;
        canvas.drawRoundRect(rectF, f19, f19, paint);
        int round = Math.round(f16 + this.f342270f);
        int centerY = (int) (rectF.centerY() - ((f17 + f18) / 2.0f));
        a16.setColor(this.f342269e);
        canvas.drawText(charSequence, i3, i16, round, centerY, a16);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        return (int) (a(paint).measureText(charSequence.subSequence(i3, i16).toString()) + this.f342270f + this.f342271h);
    }
}
