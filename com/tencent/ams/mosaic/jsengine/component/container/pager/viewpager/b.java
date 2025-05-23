package com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b implements ViewPager.PageTransformer {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    protected void c(View view, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Float.valueOf(f16));
        }
    }

    protected void d(View view, float f16) {
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Float.valueOf(f16));
            return;
        }
        view.getWidth();
        float height = view.getHeight();
        float f18 = 0.0f;
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(0.0f);
        if (b()) {
            f17 = 0.0f;
        } else {
            f17 = (-height) * f16;
        }
        view.setTranslationY(f17);
        if (a()) {
            if (f16 > -1.0f && f16 < 1.0f) {
                f18 = 1.0f;
            }
            view.setAlpha(f18);
            return;
        }
        view.setAlpha(1.0f);
    }

    protected abstract void e(View view, float f16);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Float.valueOf(f16));
            return;
        }
        d(view, f16);
        e(view, f16);
        c(view, f16);
    }
}
