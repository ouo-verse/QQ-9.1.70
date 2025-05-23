package com.tencent.mobileqq.ecshop;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes5.dex */
class EcshopNewServlet$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ BusinessObserver f203929d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f203930e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f203931f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Bundle f203932h;
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f203929d.onReceive(this.f203930e, this.f203931f, this.f203932h);
        }
    }
}
