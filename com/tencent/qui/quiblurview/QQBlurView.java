package com.tencent.qui.quiblurview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qui.quiblurview.QQBlur;
import com.tencent.qui.quiblurview.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
public class QQBlurView extends View implements f {
    static IPatchRedirector $redirector_;
    private long C;
    private boolean D;
    private final Runnable E;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f363601d;

    /* renamed from: e, reason: collision with root package name */
    private String f363602e;

    /* renamed from: f, reason: collision with root package name */
    private final QQBlur f363603f;

    /* renamed from: h, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f363604h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f363605i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f363606m;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQBlurView.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (!QQBlurView.this.f363605i || !d.a() || !QQBlurView.this.f363603f.E()) {
                return true;
            }
            if (SystemClock.elapsedRealtime() - QQBlurView.this.C <= QQBlurView.this.f363601d) {
                h.a(QQBlurView.this.E);
                h.b(QQBlurView.this.E, 100L);
                return true;
            }
            h.a(QQBlurView.this.E);
            QQBlurView.this.C = SystemClock.elapsedRealtime();
            return QQBlurView.this.f363603f.M();
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class b implements QQBlur.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.c f363608a;

        b(f.c cVar) {
            this.f363608a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQBlurView.this, (Object) cVar);
            }
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void a(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            } else {
                this.f363608a.a();
            }
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void b(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            } else {
                this.f363608a.onDrawBegin();
            }
        }
    }

    public QQBlurView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f363601d = 100;
        this.f363602e = "";
        this.f363603f = new QQBlur();
        this.f363604h = new a();
        this.f363605i = true;
        this.C = SystemClock.elapsedRealtime();
        this.E = new Runnable() { // from class: com.tencent.qui.quiblurview.QQBlurView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQBlurView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQBlurView.this.f363603f.M();
                }
            }
        };
        u();
    }

    private void u() {
        if (ud0.d.h()) {
            ud0.d.a("QQBlurView", ud0.d.f438810d, "init() called " + Integer.toHexString(System.identityHashCode(this)), new Throwable());
        }
        this.f363603f.r(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        if (this.D) {
            ud0.d.k(getTag(), ud0.d.f438811e, "onDrawBlur fail, disable blur");
            this.f363605i = false;
            Drawable drawable = this.f363606m;
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
        }
    }

    public void A(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
        } else {
            this.f363603f.Z(f16);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void a(@NonNull f.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) aVar);
            return;
        }
        m(this);
        if (aVar.a() != null) {
            j(aVar.a());
        }
        p(aVar.b());
        l((int) (aVar.j() / this.f363603f.C()));
        setEnableBlur(aVar.e());
        z(aVar.i());
        Integer d16 = aVar.d();
        if (d16 != null) {
            setDisableBlurDrawableRes(d16.intValue());
        }
        if (aVar.f()) {
            r();
        }
        if (aVar.h()) {
            y(true);
        }
        x();
    }

    @Override // com.tencent.qui.quiblurview.f
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        return this.f363605i;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) canvas);
        } else if (!v()) {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) canvas);
        } else if (!v()) {
            super.draw(canvas);
        } else {
            this.f363603f.U();
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this)).booleanValue();
        }
        return this.f363603f.G();
    }

    public void j(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            this.f363603f.p(view);
        }
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.f363603f.q(i3);
        }
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.f363603f.T(i3);
        }
    }

    public void m(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            this.f363603f.r(view);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        } else {
            this.f363601d = 0;
        }
    }

    public boolean o(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, (Object) canvas)).booleanValue();
        }
        if (canvas == null) {
            return false;
        }
        return this.f363603f.t(canvas);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (ud0.d.h()) {
            ud0.d.a(getTag(), ud0.d.f438811e, "onAttachedToWindow " + Integer.toHexString(System.identityHashCode(this)));
        }
        getViewTreeObserver().removeOnPreDrawListener(this.f363604h);
        getViewTreeObserver().addOnPreDrawListener(this.f363604h);
        if (this.f363603f != null) {
            onResume();
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (ud0.d.h()) {
            ud0.d.a(getTag(), ud0.d.f438810d, "onDestroy " + Integer.toHexString(System.identityHashCode(this)));
        }
        getViewTreeObserver().removeOnPreDrawListener(this.f363604h);
        this.f363603f.I();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        if (ud0.d.h()) {
            ud0.d.a(getTag(), ud0.d.f438811e, "onDetachedFromWindow " + Integer.toHexString(System.identityHashCode(this)));
        }
        getViewTreeObserver().removeOnPreDrawListener(this.f363604h);
        if (this.f363603f != null) {
            onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (!v()) {
            if (this.f363605i && d.a()) {
                setBackgroundDrawable(null);
                this.f363603f.J(this, canvas, new QQBlur.d() { // from class: com.tencent.qui.quiblurview.e
                    @Override // com.tencent.qui.quiblurview.QQBlur.d
                    public final void a() {
                        QQBlurView.this.w();
                    }
                });
                super.onDraw(canvas);
                return;
            }
            if (ud0.d.i()) {
                String tag = getTag();
                int i3 = ud0.d.f438809c;
                Object[] objArr = new Object[4];
                boolean z16 = false;
                objArr[0] = "mDisableBlurBackgroundDrawable is null : ";
                if (this.f363606m == null) {
                    z16 = true;
                }
                objArr[1] = Boolean.valueOf(z16);
                objArr[2] = " visible : ";
                objArr[3] = Integer.valueOf(getVisibility());
                ud0.d.a(tag, i3, objArr);
            }
            setBackgroundDrawable(this.f363606m);
            super.onDraw(canvas);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (ud0.d.i()) {
            ud0.d.a(getTag(), ud0.d.f438810d, "onPause " + Integer.toHexString(System.identityHashCode(this)));
        }
        this.f363603f.K();
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (ud0.d.i()) {
            ud0.d.a(getTag(), ud0.d.f438810d, "onResume " + Integer.toHexString(System.identityHashCode(this)));
        }
        this.f363603f.N();
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else {
            this.f363603f.u(i3);
        }
    }

    public void q(QQBlur.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) cVar);
        } else {
            this.f363603f.y(cVar);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else {
            ud0.d.a(getTag(), ud0.d.f438811e, "enableFixEmptyBlurBmp");
            this.D = true;
        }
    }

    @Nullable
    public Drawable s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Drawable) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.f363603f.B();
    }

    public void setBlurSource(List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            this.f363603f.a0(list);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
        }
    }

    public void setCalculateLocationListener(QQBlur.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) bVar);
        } else {
            this.f363603f.b0(bVar);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDebugTag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        } else {
            this.f363602e = str;
            this.f363603f.c0(str);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDirectDrawMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        }
    }

    public void setDirtyListener(QQBlur.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) aVar);
        } else {
            this.f363603f.d0(aVar);
        }
    }

    public void setDisableBlurDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) drawable);
        } else {
            this.f363606m = drawable;
        }
    }

    public void setDisableBlurDrawableRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        } else {
            this.f363606m = getResources().getDrawable(i3);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDisableDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) drawable);
        } else {
            this.f363606m = drawable;
            postInvalidate();
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDrawBackgroundListener(f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) cVar);
        } else if (cVar == null) {
            q(null);
        } else {
            q(new b(cVar));
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setEnableBlur(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.f363605i = z16;
        }
    }

    public void setInitBlurColorDrawable(ColorDrawable colorDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) colorDrawable);
        } else {
            this.f363603f.e0(colorDrawable);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setOverlayDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) drawable);
        } else {
            z(drawable);
            postInvalidate();
        }
    }

    public void setPreDrawLimitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            this.f363601d = 100;
        }
    }

    public void setScaleModeOnSizeChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
        } else {
            this.f363603f.f0(i3);
        }
    }

    public void setVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    @Override // android.view.View
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        if (TextUtils.isEmpty(this.f363602e)) {
            return "QQBlurView";
        }
        return "QQBlurView." + this.f363602e;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return this.f363603f.F();
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (ud0.d.h()) {
            ud0.d.a(getTag(), ud0.d.f438811e, "onCreate " + Integer.toHexString(System.identityHashCode(this)));
        }
        getViewTreeObserver().removeOnPreDrawListener(this.f363604h);
        getViewTreeObserver().addOnPreDrawListener(this.f363604h);
        if (!this.f363603f.E()) {
            this.f363603f.H();
        }
    }

    public void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, z16);
        } else {
            this.f363603f.O(z16);
        }
    }

    public void z(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) drawable);
        } else {
            this.f363603f.P(drawable);
        }
    }

    public void setBlurSource(@NonNull View view, @Nullable ArrayList<Object> arrayList, @Nullable f.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            setBlurSource(view, arrayList, dVar, false);
        } else {
            iPatchRedirector.redirect((short) 13, this, view, arrayList, dVar);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setBlurSource(@NonNull View view, @Nullable ArrayList<Object> arrayList, @Nullable f.d dVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, view, arrayList, dVar, Boolean.valueOf(z16));
        } else {
            this.f363603f.p(view);
            this.f363603f.a0(arrayList);
        }
    }

    public QQBlurView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f363601d = 100;
        this.f363602e = "";
        this.f363603f = new QQBlur();
        this.f363604h = new a();
        this.f363605i = true;
        this.C = SystemClock.elapsedRealtime();
        this.E = new Runnable() { // from class: com.tencent.qui.quiblurview.QQBlurView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQBlurView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQBlurView.this.f363603f.M();
                }
            }
        };
        u();
    }

    public QQBlurView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f363601d = 100;
        this.f363602e = "";
        this.f363603f = new QQBlur();
        this.f363604h = new a();
        this.f363605i = true;
        this.C = SystemClock.elapsedRealtime();
        this.E = new Runnable() { // from class: com.tencent.qui.quiblurview.QQBlurView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQBlurView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQBlurView.this.f363603f.M();
                }
            }
        };
        u();
    }
}
