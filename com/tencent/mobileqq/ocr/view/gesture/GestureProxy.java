package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import com.tencent.mobileqq.ocr.view.gesture.control.b;
import com.tencent.mobileqq.ocr.view.gesture.state.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes16.dex */
public class GestureProxy extends GestureController {
    static IPatchRedirector $redirector_;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface StateSource {
    }

    /* loaded from: classes16.dex */
    public interface a {
        void a(c cVar, c cVar2);

        void b(c cVar);
    }

    public GestureProxy(View view) {
        super(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.GestureController
    public boolean F(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return super.F(view, motionEvent);
    }

    public void M(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f255023e.add(aVar);
        }
    }

    public b N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f255022d;
    }

    public Settings O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Settings) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.D;
    }

    public c P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.E;
    }

    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        J();
        if (this.G.e(this.E)) {
            l();
        } else {
            n();
        }
    }

    public void R(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f255022d = bVar;
        }
    }

    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.G.b(this.E);
        this.G.b(this.F);
        this.G.b(this.A);
        this.G.b(this.B);
        if (this.G.i(this.E)) {
            l();
        } else {
            n();
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.GestureController
    public boolean t(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return super.t(view, motionEvent);
    }
}
