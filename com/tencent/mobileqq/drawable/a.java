package com.tencent.mobileqq.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends BitmapDrawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f203601a;

    /* renamed from: b, reason: collision with root package name */
    private int f203602b;

    /* renamed from: c, reason: collision with root package name */
    private int f203603c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f203604d;

    /* renamed from: e, reason: collision with root package name */
    private float f203605e;

    public a(Resources resources, Bitmap bitmap, int i3, int i16, int i17) {
        super(resources, bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resources, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f203603c = 0;
        this.f203604d = new Paint();
        this.f203605e = URLDrawableHelper.getRoundCorner() * 160.0f;
        this.f203601a = i3;
        this.f203602b = i16;
        this.f203603c = i17;
        this.f203605e = URLDrawableHelper.getRoundCorner() * (resources.getDisplayMetrics().densityDpi / 160.0f);
        super.setGravity(17);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        int i3 = this.f203603c;
        if ((i3 >>> 24) != 0) {
            this.f203604d.setColor(i3);
            RectF rectF = new RectF(getBounds());
            float f16 = this.f203605e;
            canvas.drawRoundRect(rectF, f16, f16, this.f203604d);
        }
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.f203602b;
        if (i3 > 0) {
            return i3;
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int i3 = this.f203601a;
        if (i3 > 0) {
            return i3;
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 != this.f203604d.getAlpha()) {
            this.f203604d.setAlpha(i3);
        }
        super.setAlpha(i3);
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f203605e = URLDrawableHelper.getRoundCorner() * (i3 / 160.0f);
            super.setTargetDensity(i3);
        }
    }
}
