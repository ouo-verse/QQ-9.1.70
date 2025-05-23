package com.tencent.android.androidbypass.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h implements LeadingMarginSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final int f72457d;

    /* renamed from: e, reason: collision with root package name */
    private final int f72458e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final com.tencent.android.androidbypass.enhance.e f72459f;

    /* renamed from: h, reason: collision with root package name */
    private int f72460h;

    public h(@NonNull com.tencent.android.androidbypass.enhance.e eVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eVar, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f72460h = -1;
        this.f72459f = eVar;
        this.f72457d = i3;
        this.f72458e = i16;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18, int i19, CharSequence charSequence, int i26, int i27, boolean z16, Layout layout) {
        int i28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, paint, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), charSequence, Integer.valueOf(i26), Integer.valueOf(i27), Boolean.valueOf(z16), layout);
            return;
        }
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f72459f.c());
        if (z16) {
            if (this.f72460h == -1) {
                this.f72460h = i26;
            }
            if (this.f72460h == i26) {
                i28 = (i19 - ((int) paint.getTextSize())) - 2;
                canvas.drawRect(i3, i28, i3 + (this.f72457d * i16), i19, paint);
                paint.setStyle(style);
                paint.setColor(color);
            }
        }
        i28 = i17;
        canvas.drawRect(i3, i28, i3 + (this.f72457d * i16), i19, paint);
        paint.setStyle(style);
        paint.setColor(color);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, z16)).intValue();
        }
        return this.f72457d + this.f72458e;
    }
}
