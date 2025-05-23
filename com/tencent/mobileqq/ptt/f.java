package com.tencent.mobileqq.ptt;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f extends Animation {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private View f261232d;

    /* renamed from: e, reason: collision with root package name */
    private int f261233e;

    /* renamed from: f, reason: collision with root package name */
    private int f261234f;

    /* renamed from: h, reason: collision with root package name */
    private h f261235h;

    /* renamed from: i, reason: collision with root package name */
    private Animation.AnimationListener f261236i;

    public f(View view, int i3, int i16, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16), hVar);
            return;
        }
        this.f261232d = view;
        this.f261233e = i3;
        this.f261234f = i16;
        this.f261235h = hVar;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f16, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), transformation);
            return;
        }
        super.applyTransformation(f16, transformation);
        Animation.AnimationListener animationListener = this.f261236i;
        if (animationListener != null && (animationListener instanceof g)) {
            ((g) animationListener).a(this, f16);
        }
        View view = this.f261232d;
        if (view == null) {
            return;
        }
        int i3 = this.f261234f;
        if (f16 < 1.0f) {
            i3 = Color.argb((int) (Color.alpha(this.f261233e) + ((Color.alpha(this.f261234f) - Color.alpha(this.f261233e)) * f16)), (int) (Color.red(this.f261233e) + ((Color.red(this.f261234f) - Color.red(this.f261233e)) * f16)), (int) (Color.green(this.f261233e) + ((Color.green(this.f261234f) - Color.green(this.f261233e)) * f16)), (int) (Color.blue(this.f261233e) + ((Color.blue(this.f261234f) - Color.blue(this.f261233e)) * f16)));
            this.f261232d.setBackgroundColor(i3);
        } else {
            view.setBackgroundColor(i3);
            this.f261232d = null;
        }
        h hVar = this.f261235h;
        if (hVar != null) {
            hVar.f261238b = i3;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS applyTransformation: " + f16 + " CLR: " + i3);
        }
    }

    @Override // android.view.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animationListener);
        } else {
            super.setAnimationListener(animationListener);
            this.f261236i = animationListener;
        }
    }
}
