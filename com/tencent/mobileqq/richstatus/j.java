package com.tencent.mobileqq.richstatus;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.OffsetableImageSpan;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends OffsetableImageSpan {
    static IPatchRedirector $redirector_;
    private Paint C;
    public boolean D;

    /* renamed from: d, reason: collision with root package name */
    private String f282356d;

    /* renamed from: e, reason: collision with root package name */
    private int f282357e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f282358f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f282359h;

    /* renamed from: i, reason: collision with root package name */
    private int f282360i;

    /* renamed from: m, reason: collision with root package name */
    private int f282361m;

    public j(Drawable drawable, int i3, String str, int i16, Drawable drawable2, float f16) {
        super(drawable, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, drawable, Integer.valueOf(i3), str, Integer.valueOf(i16), drawable2, Float.valueOf(f16));
            return;
        }
        this.D = true;
        this.f282356d = str;
        this.f282357e = i16;
        this.f282358f = new float[str.length()];
        this.f282359h = drawable2;
        Paint paint = new Paint(1);
        this.C = paint;
        paint.setTextSize(f16);
        this.C.setColor(i16);
    }

    @Override // com.tencent.mobileqq.text.OffsetableImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        if (this.D) {
            i26 = this.C.getFontMetricsInt().top + i18;
        } else {
            i26 = i18;
        }
        int i28 = this.f282360i;
        if (i28 > 0 && (i27 = this.f282361m) > 0) {
            this.f282359h.setBounds(0, i26, i28, i27 + i26);
            this.f282359h.draw(canvas);
        }
        super.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint);
        float f17 = f16 + getDrawable().getBounds().right;
        int i29 = i18 - this.C.getFontMetricsInt().ascent;
        if (!this.D) {
            i18 = i29;
        }
        canvas.drawText(this.f282356d, f17, i18, this.C);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        Rect bounds = getDrawable().getBounds();
        this.C.getTextWidths(this.f282356d, this.f282358f);
        int i17 = bounds.right;
        for (float f16 : this.f282358f) {
            i17 = (int) (i17 + f16);
        }
        this.f282360i = i17;
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        this.f282361m = Math.max(bounds.bottom, (-fontMetricsInt2.top) + fontMetricsInt2.bottom);
        return i17;
    }
}
