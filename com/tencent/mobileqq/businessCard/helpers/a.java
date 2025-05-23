package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class a extends Animation {
    static IPatchRedirector $redirector_;
    public static final boolean M;
    static final WeakHashMap<View, a> N;
    float C;
    float D;
    float E;
    float F;
    float G;
    float H;
    float I;
    final RectF J;
    final RectF K;
    final Matrix L;

    /* renamed from: d, reason: collision with root package name */
    final WeakReference<View> f200901d;

    /* renamed from: e, reason: collision with root package name */
    final Camera f200902e;

    /* renamed from: f, reason: collision with root package name */
    boolean f200903f;

    /* renamed from: h, reason: collision with root package name */
    float f200904h;

    /* renamed from: i, reason: collision with root package name */
    float f200905i;

    /* renamed from: m, reason: collision with root package name */
    float f200906m;

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) {
            z16 = true;
        } else {
            z16 = false;
        }
        M = z16;
        N = new WeakHashMap<>();
    }

    a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.f200902e = new Camera();
        this.f200904h = 1.0f;
        this.F = 1.0f;
        this.G = 1.0f;
        this.J = new RectF();
        this.K = new RectF();
        this.L = new Matrix();
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f200901d = new WeakReference<>(view);
    }

    private void b() {
        View view = this.f200901d.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.K;
            a(rectF, view);
            rectF.union(this.J);
            ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
    }

    private void c() {
        View view = this.f200901d.get();
        if (view != null) {
            a(this.J, view);
        }
    }

    private void m(Matrix matrix, View view) {
        float f16;
        float f17;
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z16 = this.f200903f;
        if (z16) {
            f16 = this.f200905i;
        } else {
            f16 = width / 2.0f;
        }
        if (z16) {
            f17 = this.f200906m;
        } else {
            f17 = height / 2.0f;
        }
        float f18 = this.C;
        float f19 = this.D;
        float f26 = this.E;
        if (f18 != 0.0f || f19 != 0.0f || f26 != 0.0f) {
            Camera camera2 = this.f200902e;
            camera2.save();
            camera2.rotateX(f18);
            camera2.rotateY(f19);
            camera2.rotateZ(-f26);
            camera2.getMatrix(matrix);
            camera2.restore();
            matrix.preTranslate(-f16, -f17);
            matrix.postTranslate(f16, f17);
        }
        float f27 = this.F;
        float f28 = this.G;
        if (f27 != 1.0f || f28 != 1.0f) {
            matrix.postScale(f27, f28);
            matrix.postTranslate((-(f16 / width)) * ((f27 * width) - width), (-(f17 / height)) * ((f28 * height) - height));
        }
        matrix.postTranslate(this.H, this.I);
    }

    public static a n(View view) {
        WeakHashMap<View, a> weakHashMap = N;
        a aVar = weakHashMap.get(view);
        if (aVar == null || aVar != view.getAnimation()) {
            a aVar2 = new a(view);
            weakHashMap.put(view, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public void a(RectF rectF, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) rectF, (Object) view);
            return;
        }
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.L;
        matrix.reset();
        m(matrix, view);
        this.L.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f16 = rectF.right;
        float f17 = rectF.left;
        if (f16 < f17) {
            rectF.right = f17;
            rectF.left = f16;
        }
        float f18 = rectF.bottom;
        float f19 = rectF.top;
        if (f18 < f19) {
            rectF.top = f18;
            rectF.bottom = f19;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Float.valueOf(f16), transformation);
            return;
        }
        View view = this.f200901d.get();
        if (view != null) {
            transformation.setAlpha(this.f200904h);
            m(transformation.getMatrix(), view);
        }
    }

    public void d(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        if (this.f200904h != f16) {
            this.f200904h = f16;
            View view = this.f200901d.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void e(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        if (!this.f200903f || this.f200905i != f16) {
            c();
            this.f200903f = true;
            this.f200905i = f16;
            b();
        }
    }

    public void f(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        if (!this.f200903f || this.f200906m != f16) {
            c();
            this.f200903f = true;
            this.f200906m = f16;
            b();
        }
    }

    public void h(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else if (this.F != f16) {
            c();
            this.F = f16;
            b();
        }
    }

    public void i(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        } else if (this.G != f16) {
            c();
            this.G = f16;
            b();
        }
    }

    public void j(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
        } else if (this.H != f16) {
            c();
            this.H = f16;
            b();
        }
    }

    public void k(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
        } else if (this.I != f16) {
            c();
            this.I = f16;
            b();
        }
    }

    public void l(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
            return;
        }
        if (this.f200901d.get() != null) {
            j(f16 - r0.getLeft());
        }
    }
}
