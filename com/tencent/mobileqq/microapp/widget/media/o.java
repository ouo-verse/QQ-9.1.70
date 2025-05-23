package com.tencent.mobileqq.microapp.widget.media;

import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class o implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f246238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.f246238a = mVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            frameLayout = this.f246238a.f246236a.f246213y;
            frameLayout.setVisibility(0);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
