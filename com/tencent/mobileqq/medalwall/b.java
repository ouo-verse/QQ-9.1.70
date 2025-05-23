package com.tencent.mobileqq.medalwall;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends Animation {
    static IPatchRedirector $redirector_;
    private Camera C;

    /* renamed from: d, reason: collision with root package name */
    private final float f245761d;

    /* renamed from: e, reason: collision with root package name */
    private final float f245762e;

    /* renamed from: f, reason: collision with root package name */
    private final float f245763f;

    /* renamed from: h, reason: collision with root package name */
    private final float f245764h;

    /* renamed from: i, reason: collision with root package name */
    private final float f245765i;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f245766m;

    public b(float f16, float f17, float f18, float f19, float f26, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Boolean.valueOf(z16));
            return;
        }
        this.f245761d = f16;
        this.f245762e = f17;
        this.f245763f = f18;
        this.f245764h = f19;
        this.f245765i = f26;
        this.f245766m = z16;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), transformation);
            return;
        }
        float f17 = this.f245761d;
        float f18 = f17 + ((this.f245762e - f17) * f16);
        float f19 = this.f245763f;
        float f26 = this.f245764h;
        Camera camera2 = this.C;
        Matrix matrix = transformation.getMatrix();
        camera2.save();
        if (this.f245766m) {
            camera2.translate(0.0f, 0.0f, this.f245765i * f16);
        } else {
            camera2.translate(0.0f, 0.0f, this.f245765i * (1.0f - f16));
        }
        camera2.rotateY(f18);
        camera2.getMatrix(matrix);
        camera2.restore();
        matrix.preTranslate(-f19, -f26);
        matrix.postTranslate(f19, f26);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.initialize(i3, i16, i17, i18);
            this.C = new Camera();
        }
    }
}
