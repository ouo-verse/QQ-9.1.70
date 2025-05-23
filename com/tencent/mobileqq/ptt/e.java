package com.tencent.mobileqq.ptt;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends ScaleAnimation {
    static IPatchRedirector $redirector_;
    private Animation.AnimationListener C;

    /* renamed from: d, reason: collision with root package name */
    private GradientDrawable f261226d;

    /* renamed from: e, reason: collision with root package name */
    private int f261227e;

    /* renamed from: f, reason: collision with root package name */
    private int f261228f;

    /* renamed from: h, reason: collision with root package name */
    private float f261229h;

    /* renamed from: i, reason: collision with root package name */
    private float f261230i;

    /* renamed from: m, reason: collision with root package name */
    private h f261231m;

    public e(float f16, float f17, float f18, float f19, int i3, float f26, int i16, float f27, h hVar) {
        super(f16, f17, f18, f19, i3, f26, i16, f27);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3), Float.valueOf(f26), Integer.valueOf(i16), Float.valueOf(f27), hVar);
            return;
        }
        this.f261229h = f16;
        this.f261230i = f17 - f16;
        this.f261231m = hVar;
    }

    public void a(GradientDrawable gradientDrawable, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, gradientDrawable, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f261226d = gradientDrawable;
        this.f261227e = i3;
        this.f261228f = i16;
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS setColorChanger: " + i3 + " --> " + i16);
        }
    }

    @Override // android.view.animation.ScaleAnimation, android.view.animation.Animation
    public void applyTransformation(float f16, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), transformation);
            return;
        }
        super.applyTransformation(f16, transformation);
        Animation.AnimationListener animationListener = this.C;
        if (animationListener != null && (animationListener instanceof g)) {
            ((g) animationListener).a(this, f16);
        }
        this.f261231m.f261237a = this.f261229h + (this.f261230i * f16);
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS applyTransformation: " + f16 + " F: " + this.f261231m.f261237a);
        }
        GradientDrawable gradientDrawable = this.f261226d;
        if (gradientDrawable != null) {
            int i3 = this.f261228f;
            if (f16 < 1.0f) {
                i3 = Color.argb((int) (Color.alpha(this.f261227e) + ((Color.alpha(this.f261228f) - Color.alpha(this.f261227e)) * f16)), (int) (Color.red(this.f261227e) + ((Color.red(this.f261228f) - Color.red(this.f261227e)) * f16)), (int) (Color.green(this.f261227e) + ((Color.green(this.f261228f) - Color.green(this.f261227e)) * f16)), (int) (Color.blue(this.f261227e) + ((Color.blue(this.f261228f) - Color.blue(this.f261227e)) * f16)));
                this.f261226d.setColor(i3);
            } else {
                gradientDrawable.setColor(i3);
                this.f261226d = null;
            }
            this.f261231m.f261238b = i3;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS applyTransformation: " + f16 + " CLR: " + this.f261231m.f261238b);
        }
    }

    @Override // android.view.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animationListener);
        } else {
            super.setAnimationListener(animationListener);
            this.C = animationListener;
        }
    }
}
