package com.tencent.mobileqq.profile.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ShimmerLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    private Bitmap E;
    private Paint F;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f260429d;

    /* renamed from: e, reason: collision with root package name */
    private int f260430e;

    /* renamed from: f, reason: collision with root package name */
    private int f260431f;

    /* renamed from: h, reason: collision with root package name */
    private int f260432h;

    /* renamed from: i, reason: collision with root package name */
    public Bitmap f260433i;

    /* renamed from: m, reason: collision with root package name */
    private int f260434m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final int f260435d;

        /* renamed from: e, reason: collision with root package name */
        final int f260436e;

        /* renamed from: f, reason: collision with root package name */
        final int f260437f;

        /* renamed from: h, reason: collision with root package name */
        final int f260438h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<ShimmerLinearLayout> f260439i;

        a(ShimmerLinearLayout shimmerLinearLayout, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, shimmerLinearLayout, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.f260439i = new WeakReference<>(shimmerLinearLayout);
            this.f260435d = i3;
            this.f260436e = i16;
            this.f260437f = i17;
            this.f260438h = i18;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            ShimmerLinearLayout shimmerLinearLayout = this.f260439i.get();
            if (shimmerLinearLayout != null) {
                float f16 = 1.0f - max;
                shimmerLinearLayout.g((int) ((this.f260435d * f16) + (this.f260437f * max)), (int) ((this.f260436e * f16) + (this.f260438h * max)));
            }
        }
    }

    public ShimmerLinearLayout(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private boolean a(Canvas canvas) {
        Bitmap j3 = j();
        if (j3 != null && this.f260433i != null) {
            super.dispatchDraw(canvas);
            b(new Canvas(j3));
            canvas.drawBitmap(j3, 0.0f, 0.0f, (Paint) null);
            return true;
        }
        return false;
    }

    private void b(Canvas canvas) {
        Bitmap bitmap = this.f260433i;
        if (bitmap == null) {
            return;
        }
        if (bitmap.getWidth() != getWidth()) {
            bitmap = c();
        }
        int i3 = this.f260434m;
        canvas.clipRect(i3, this.C, bitmap.getWidth() + i3, this.C + bitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(bitmap, this.f260434m, this.C, this.F);
    }

    private Bitmap c() {
        int width = this.f260433i.getWidth();
        int height = this.f260433i.getHeight();
        int width2 = (getWidth() * height) / width;
        Bitmap f16 = f(getWidth(), width2, true);
        if (f16 != null) {
            new Canvas(f16).drawBitmap(this.f260433i, new Rect(0, 0, width, height), new Rect(0, 0, getWidth(), width2), (Paint) null);
            this.f260433i = f16;
            ValueAnimator d16 = d(true);
            this.f260429d = d16;
            d16.start();
        }
        return this.f260433i;
    }

    private synchronized ValueAnimator d(boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        ValueAnimator valueAnimator = this.f260429d;
        if (valueAnimator != null) {
            if (!z16) {
                return valueAnimator;
            }
            QLog.i("ShimmerLinearLayout", 1, "getShimmerAnimation animator remove");
            this.f260429d.removeAllUpdateListeners();
            this.f260429d.cancel();
            this.f260429d = null;
        }
        QLog.i("ShimmerLinearLayout", 1, "getShimmerAnimation recreate = " + z16 + "call stack = " + Log.getStackTraceString(new Throwable()));
        int width = getWidth();
        int height = getHeight();
        int i19 = this.f260430e;
        if (i19 != 0) {
            if (i19 != 1) {
                i16 = 0;
                i17 = 0;
                i3 = 0;
                i18 = 0;
            } else {
                i17 = -this.f260433i.getHeight();
                i18 = height;
                i16 = 0;
                i3 = 0;
            }
        } else {
            i3 = width;
            i16 = -this.f260433i.getWidth();
            i17 = 0;
            i18 = 0;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.f260431f / this.f260432h) + 1.0f);
        this.f260429d = ofFloat;
        ofFloat.setDuration(this.f260432h + this.f260431f);
        this.f260429d.setRepeatMode(1);
        this.f260429d.setRepeatCount(-1);
        this.f260429d.addUpdateListener(new a(this, i16, i17, i3, i18));
        return this.f260429d;
    }

    public static Bitmap f(int i3, int i16, boolean z16) {
        try {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (Exception e16) {
            QLog.d("ShimmerLinearLayout", 1, e16.getMessage());
            return null;
        } catch (OutOfMemoryError unused) {
            if (!z16) {
                return null;
            }
            System.gc();
            return f(i3, i16, false);
        }
    }

    private Bitmap j() {
        if (this.E == null) {
            this.E = f(getWidth(), getHeight(), true);
        }
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else if (this.D && getWidth() > 0 && getHeight() > 0) {
            a(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f260429d != null) {
            QLog.i("ShimmerLinearLayout", 1, "ShimmerLinearLayout.onDestroy");
            this.f260429d.removeAllUpdateListeners();
            this.f260429d.cancel();
        }
        this.f260429d = null;
        this.D = false;
    }

    void g(int i3, int i16) {
        if (this.f260434m == i3 && this.C == i16) {
            return;
        }
        this.f260434m = i3;
        this.C = i16;
        invalidate();
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f260433i == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ShimmerLinearLayout", 2, "startShimmer mMaskBitmap = null");
            }
        } else {
            ValueAnimator d16 = d(false);
            this.f260429d = d16;
            if (!d16.isRunning()) {
                this.f260429d.start();
            }
            this.D = true;
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f260433i == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ShimmerLinearLayout", 2, "stopShimmer mMaskBitmap = null");
            }
        } else {
            Bitmap j3 = j();
            if (j3 != null) {
                new Canvas(j3).drawColor(0, PorterDuff.Mode.CLEAR);
            }
            ValueAnimator d16 = d(false);
            this.f260429d = d16;
            d16.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        QLog.i("ShimmerLinearLayout", 1, "ShimmerLinearLayout.onDetachedFromWindow()");
        e();
    }

    public void setMask(Bitmap bitmap, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f260433i = bitmap;
        this.f260430e = i3;
        this.f260431f = i16;
        this.f260432h = i17;
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = false;
        Paint paint = new Paint();
        this.F = paint;
        paint.setAntiAlias(true);
        this.F.setDither(true);
        this.F.setFilterBitmap(true);
        this.F.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }
}
