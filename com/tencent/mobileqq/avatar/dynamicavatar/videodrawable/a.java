package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.VideoOptions;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static Bitmap f200093i;

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f200094a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f200095b;

    /* renamed from: c, reason: collision with root package name */
    Paint f200096c;

    /* renamed from: d, reason: collision with root package name */
    int f200097d;

    /* renamed from: e, reason: collision with root package name */
    int f200098e;

    /* renamed from: f, reason: collision with root package name */
    boolean f200099f;

    /* renamed from: g, reason: collision with root package name */
    private int f200100g;

    /* renamed from: h, reason: collision with root package name */
    private int f200101h;

    public a(Bitmap bitmap, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap, (Object) resources);
            return;
        }
        this.f200095b = new Rect();
        this.f200096c = new Paint(7);
        this.f200097d = 119;
        this.f200098e = 160;
        this.f200099f = false;
        this.f200098e = resources.getDisplayMetrics().densityDpi;
        c(bitmap);
    }

    private void a() {
        Bitmap bitmap = this.f200094a;
        if (bitmap != null) {
            this.f200100g = bitmap.getScaledWidth(this.f200098e);
            this.f200101h = this.f200094a.getScaledHeight(this.f200098e);
        }
    }

    public Bitmap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f200094a;
    }

    public void c(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bitmap);
        } else if (bitmap != this.f200094a) {
            this.f200094a = bitmap;
            a();
            invalidateSelf();
        }
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f200099f = z16;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        if (this.f200094a != null) {
            copyBounds(this.f200095b);
            if (this.f200099f && f200093i == null) {
                try {
                    f200093i = Bitmap.createBitmap(this.f200095b.width(), this.f200095b.height(), Bitmap.Config.ARGB_4444);
                    Canvas canvas2 = new Canvas(f200093i);
                    this.f200096c.setColor(-1);
                    canvas2.drawOval(new RectF(0.0f, 0.0f, this.f200095b.width(), this.f200095b.height()), this.f200096c);
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(VideoOptions.NAME, 2, e16.getMessage(), e16);
                    }
                }
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
            canvas.drawBitmap(this.f200094a, (Rect) null, this.f200095b, this.f200096c);
            if (this.f200099f && f200093i != null) {
                this.f200096c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawBitmap(f200093i, (Rect) null, this.f200095b, this.f200096c);
                this.f200096c.setXfermode(null);
            }
            canvas.restoreToCount(saveLayer);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f200101h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f200100g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f200096c.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorFilter);
        } else {
            this.f200096c.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f200096c.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f200096c.setFilterBitmap(z16);
        }
    }
}
