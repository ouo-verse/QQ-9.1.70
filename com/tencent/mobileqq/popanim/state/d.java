package com.tencent.mobileqq.popanim.state;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(ViewGroup viewGroup, f fVar) {
        super(viewGroup, fVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup, (Object) fVar);
        }
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f259124f.c();
        this.f259124f.f259138c.stopShakeAnimation();
        PopOutAnimViewHolder.d().g();
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.b(aVar);
        }
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return super.c(motionEvent);
    }
}
