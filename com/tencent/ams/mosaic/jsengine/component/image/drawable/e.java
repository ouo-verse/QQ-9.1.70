package com.tencent.ams.mosaic.jsengine.component.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class e extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final Bitmap f71178a;

    /* renamed from: b, reason: collision with root package name */
    private int f71179b;

    /* renamed from: c, reason: collision with root package name */
    private int f71180c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f71181d;

    /* renamed from: e, reason: collision with root package name */
    private final BitmapShader f71182e;

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f71183f;

    /* renamed from: g, reason: collision with root package name */
    private float f71184g;

    /* renamed from: h, reason: collision with root package name */
    final Rect f71185h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f71186i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f71187j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f71188k;

    /* renamed from: l, reason: collision with root package name */
    private int f71189l;

    /* renamed from: m, reason: collision with root package name */
    private int f71190m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Resources resources, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) resources, (Object) bitmap);
            return;
        }
        this.f71179b = 160;
        this.f71180c = 119;
        this.f71181d = new Paint(3);
        this.f71183f = new Matrix();
        this.f71185h = new Rect();
        this.f71186i = new RectF();
        this.f71187j = true;
        if (resources != null) {
            this.f71179b = resources.getDisplayMetrics().densityDpi;
        }
        this.f71178a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f71182e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f71190m = -1;
            this.f71189l = -1;
            this.f71182e = null;
        }
    }

    private void a() {
        this.f71189l = this.f71178a.getScaledWidth(this.f71179b);
        this.f71190m = this.f71178a.getScaledHeight(this.f71179b);
    }

    private static boolean d(float f16) {
        if (f16 > 0.05f) {
            return true;
        }
        return false;
    }

    private void f() {
        this.f71184g = Math.min(this.f71190m, this.f71189l) / 2;
    }

    public float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.f71184g;
    }

    void c(int i3, int i16, int i17, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) canvas);
            return;
        }
        Bitmap bitmap = this.f71178a;
        if (bitmap == null) {
            return;
        }
        g();
        if (this.f71181d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f71185h, this.f71181d);
            return;
        }
        RectF rectF = this.f71186i;
        float f16 = this.f71184g;
        canvas.drawRoundRect(rectF, f16, f16, this.f71181d);
    }

    public void e(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
            return;
        }
        if (this.f71184g == f16) {
            return;
        }
        this.f71188k = false;
        if (d(f16)) {
            this.f71181d.setShader(this.f71182e);
        } else {
            this.f71181d.setShader(null);
        }
        this.f71184g = f16;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f71187j) {
            if (this.f71188k) {
                int min = Math.min(this.f71189l, this.f71190m);
                c(this.f71180c, min, min, getBounds(), this.f71185h);
                int min2 = Math.min(this.f71185h.width(), this.f71185h.height());
                this.f71185h.inset(Math.max(0, (this.f71185h.width() - min2) / 2), Math.max(0, (this.f71185h.height() - min2) / 2));
                this.f71184g = min2 * 0.5f;
            } else {
                c(this.f71180c, this.f71189l, this.f71190m, getBounds(), this.f71185h);
            }
            this.f71186i.set(this.f71185h);
            if (this.f71182e != null) {
                Matrix matrix = this.f71183f;
                RectF rectF = this.f71186i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f71183f.preScale(this.f71186i.width() / this.f71178a.getWidth(), this.f71186i.height() / this.f71178a.getHeight());
                this.f71182e.setLocalMatrix(this.f71183f);
                this.f71181d.setShader(this.f71182e);
            }
            this.f71187j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.f71181d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ColorFilter) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f71181d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.f71190m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.f71189l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        if (this.f71180c != 119 || this.f71188k || (bitmap = this.f71178a) == null || bitmap.hasAlpha() || this.f71181d.getAlpha() < 255 || d(this.f71184g)) {
            return -3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) rect);
            return;
        }
        super.onBoundsChange(rect);
        if (this.f71188k) {
            f();
        }
        this.f71187j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else if (i3 != this.f71181d.getAlpha()) {
            this.f71181d.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) colorFilter);
        } else {
            this.f71181d.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f71181d.setDither(z16);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f71181d.setFilterBitmap(z16);
            invalidateSelf();
        }
    }
}
