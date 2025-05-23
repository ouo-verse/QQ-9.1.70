package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class AnimationEngine implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final View f255005d;

    /* renamed from: e, reason: collision with root package name */
    private final a f255006e;

    public AnimationEngine(View view) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.f255005d = view;
        if (a.a()) {
            aVar = new a();
        } else {
            aVar = null;
        }
        this.f255006e = aVar;
    }

    private void f() {
        this.f255005d.removeCallbacks(this);
        this.f255005d.postOnAnimationDelayed(this, 10L);
    }

    public abstract boolean e();

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        a aVar = this.f255006e;
        if (aVar != null) {
            aVar.b(i3);
        }
        f();
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        boolean e16 = e();
        a aVar = this.f255006e;
        if (aVar != null) {
            aVar.c();
            if (!e16) {
                this.f255006e.d();
            }
        }
        if (e16) {
            f();
        }
    }
}
