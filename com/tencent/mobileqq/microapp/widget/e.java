package com.tencent.mobileqq.microapp.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class e extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final RectF f246123c;

    /* renamed from: a, reason: collision with root package name */
    private Paint f246124a;

    /* renamed from: b, reason: collision with root package name */
    private float f246125b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f246123c = new RectF();
        }
    }

    public e(int i3, Paint.Style style, float f16, int i16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), style, Float.valueOf(f16), Integer.valueOf(i16), Float.valueOf(f17));
            return;
        }
        this.f246125b = f17;
        Paint paint = new Paint(1);
        this.f246124a = paint;
        paint.setColor(i3);
        this.f246124a.setAlpha(i16);
        this.f246124a.setStyle(style);
        this.f246124a.setStrokeWidth(f16);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width > 0 && height > 0) {
            canvas.save();
            RectF rectF = f246123c;
            rectF.set(bounds);
            float f16 = this.f246125b;
            canvas.drawRoundRect(rectF, f16, f16, this.f246124a);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorFilter);
        }
    }
}
