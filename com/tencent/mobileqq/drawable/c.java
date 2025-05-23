package com.tencent.mobileqq.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends ColorDrawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private float f203608a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f203609b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f203610c;

    /* renamed from: d, reason: collision with root package name */
    private final int f203611d;

    /* renamed from: e, reason: collision with root package name */
    private final int f203612e;

    public c(int i3, float f16, int i16, int i17) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        RectF rectF = new RectF();
        this.f203609b = rectF;
        this.f203608a = f16;
        Paint paint = new Paint();
        this.f203610c = paint;
        paint.setAntiAlias(true);
        paint.setColor(i3);
        rectF.set(0.0f, 0.0f, i16, i17);
        this.f203611d = i16;
        this.f203612e = i17;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        RectF rectF = this.f203609b;
        float f16 = this.f203608a;
        canvas.drawRoundRect(rectF, f16, f16, this.f203610c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f203612e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f203611d;
    }
}
