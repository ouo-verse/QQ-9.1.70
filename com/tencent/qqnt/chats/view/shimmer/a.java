package com.tencent.qqnt.chats.view.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class a extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f355633a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f355634b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f355635c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f355636d;

    /* renamed from: e, reason: collision with root package name */
    private final Matrix f355637e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private ValueAnimator f355638f;

    /* renamed from: g, reason: collision with root package name */
    private float f355639g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private Shimmer f355640h;

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.chats.view.shimmer.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    class C9602a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        C9602a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                a.this.invalidateSelf();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f355633a = new C9602a();
        Paint paint = new Paint();
        this.f355634b = paint;
        Paint paint2 = new Paint();
        this.f355635c = paint2;
        this.f355636d = new Rect();
        this.f355637e = new Matrix();
        this.f355639g = -1.0f;
        paint.setAntiAlias(true);
        paint2.setAntiAlias(true);
    }

    private float c(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    private void h() {
        Shimmer shimmer;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width != 0 && height != 0 && (shimmer = this.f355640h) != null) {
            int d16 = shimmer.d(width);
            int a16 = this.f355640h.a(height);
            Shimmer shimmer2 = this.f355640h;
            boolean z16 = true;
            if (shimmer2.f355612g != 1) {
                int i3 = shimmer2.f355609d;
                if (i3 != 1 && i3 != 3) {
                    z16 = false;
                }
                if (z16) {
                    d16 = 0;
                }
                if (!z16) {
                    a16 = 0;
                }
                float f16 = a16;
                Shimmer shimmer3 = this.f355640h;
                radialGradient = new LinearGradient(0.0f, 0.0f, d16, f16, shimmer3.f355607b, shimmer3.f355606a, Shader.TileMode.CLAMP);
            } else {
                float f17 = a16 / 2.0f;
                float max = (float) (Math.max(d16, a16) / Math.sqrt(2.0d));
                Shimmer shimmer4 = this.f355640h;
                radialGradient = new RadialGradient(d16 / 2.0f, f17, max, shimmer4.f355607b, shimmer4.f355606a, Shader.TileMode.CLAMP);
            }
            this.f355634b.setShader(radialGradient);
        }
    }

    private void i() {
        boolean z16;
        if (this.f355640h == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f355638f;
        if (valueAnimator != null) {
            z16 = valueAnimator.isStarted();
            this.f355638f.cancel();
            this.f355638f.removeAllUpdateListeners();
        } else {
            z16 = false;
        }
        Shimmer shimmer = this.f355640h;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (shimmer.f355626u / shimmer.f355625t)) + 1.0f);
        this.f355638f = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f355638f.setRepeatMode(this.f355640h.f355624s);
        this.f355638f.setStartDelay(this.f355640h.f355627v);
        this.f355638f.setRepeatCount(this.f355640h.f355623r);
        ValueAnimator valueAnimator2 = this.f355638f;
        Shimmer shimmer2 = this.f355640h;
        valueAnimator2.setDuration(shimmer2.f355625t + shimmer2.f355626u);
        this.f355638f.addUpdateListener(this.f355633a);
        if (z16) {
            this.f355638f.start();
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        ValueAnimator valueAnimator = this.f355638f;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Shimmer shimmer;
        ValueAnimator valueAnimator = this.f355638f;
        if (valueAnimator != null && !valueAnimator.isStarted() && (shimmer = this.f355640h) != null && shimmer.f355621p && getCallback() != null) {
            this.f355638f.start();
        }
    }

    public void d(@Nullable Shimmer shimmer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) shimmer);
            return;
        }
        this.f355640h = shimmer;
        if (shimmer != null) {
            this.f355634b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        h();
        i();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float c16;
        float c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        if (this.f355640h != null && this.f355634b.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians(this.f355640h.f355619n));
            float height = this.f355636d.height() + (this.f355636d.width() * tan);
            float width = this.f355636d.width() + (tan * this.f355636d.height());
            float f16 = this.f355639g;
            float f17 = 0.0f;
            if (f16 < 0.0f) {
                ValueAnimator valueAnimator = this.f355638f;
                if (valueAnimator != null) {
                    f16 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else {
                    f16 = 0.0f;
                }
            }
            int i3 = this.f355640h.f355609d;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        c17 = c(-width, width, f16);
                    } else {
                        c16 = c(height, -height, f16);
                    }
                } else {
                    c17 = c(width, -width, f16);
                }
                f17 = c17;
                c16 = 0.0f;
            } else {
                c16 = c(-height, height, f16);
            }
            this.f355637e.reset();
            this.f355637e.setRotate(this.f355640h.f355619n, this.f355636d.width() / 2.0f, this.f355636d.height() / 2.0f);
            this.f355637e.preTranslate(f17, c16);
            this.f355634b.getShader().setLocalMatrix(this.f355637e);
            canvas.drawRect(this.f355636d, this.f355634b);
        }
    }

    public void e(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        if (Float.compare(f16, this.f355639g) != 0) {
            if (f16 >= 0.0f || this.f355639g >= 0.0f) {
                this.f355639g = Math.min(f16, 1.0f);
                invalidateSelf();
            }
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.f355638f != null && !a() && getCallback() != null) {
            this.f355638f.start();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.f355638f != null && a()) {
            this.f355638f.cancel();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        Shimmer shimmer = this.f355640h;
        if (shimmer != null && (shimmer.f355620o || shimmer.f355622q)) {
            return -3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rect);
            return;
        }
        super.onBoundsChange(rect);
        this.f355636d.set(rect);
        h();
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) colorFilter);
        }
    }
}
