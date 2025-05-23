package com.tencent.android.androidbypass.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends ReplacementSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f72446d;

    /* renamed from: e, reason: collision with root package name */
    private final int f72447e;

    /* renamed from: f, reason: collision with root package name */
    private final int f72448f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint.FontMetricsInt f72449h;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.android.androidbypass.enhance.e f72450i;

    public e(@NonNull com.tencent.android.androidbypass.enhance.e eVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eVar, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f72449h = new Paint.FontMetricsInt();
        Paint paint = new Paint();
        this.f72446d = paint;
        this.f72447e = i3;
        this.f72448f = i16;
        this.f72450i = eVar;
        paint.setColor(eVar.a());
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = this.f72449h;
        float f17 = i18 + ((fontMetricsInt.top + fontMetricsInt.bottom) / 2.0f);
        int i26 = this.f72447e >> 1;
        this.f72446d.setColor(this.f72450i.a());
        float f18 = i26;
        canvas.drawRect(f16, f17 - f18, 2.14748365E9f, f17 + f18, this.f72446d);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        if (fontMetricsInt != null) {
            int i17 = this.f72448f;
            int i18 = (int) ((i17 / 2.0f) - ((-(fontMetricsInt.ascent + fontMetricsInt.descent)) / 2.0f));
            fontMetricsInt.bottom = i18;
            int i19 = i18 - i17;
            fontMetricsInt.top = i19;
            fontMetricsInt.ascent = i19;
            fontMetricsInt.descent = i18;
            Paint.FontMetricsInt fontMetricsInt2 = this.f72449h;
            fontMetricsInt2.top = i19;
            fontMetricsInt2.ascent = i19;
            fontMetricsInt2.descent = i18;
            fontMetricsInt2.bottom = i18;
            return Integer.MAX_VALUE;
        }
        return Integer.MAX_VALUE;
    }
}
