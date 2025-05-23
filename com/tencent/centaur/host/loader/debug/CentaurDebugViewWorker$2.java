package com.tencent.centaur.host.loader.debug;

import com.tencent.centaur.host.loader.debug.widget.CentaurLoadControlView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
class CentaurDebugViewWorker$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ CentaurLoadControlView f99130d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (com.tencent.centaur.host.loader.a.c().d() > 0) {
            this.f99130d.setText("\u5df2\u52a0\u8f7d\n" + com.tencent.centaur.host.loader.a.c().d());
            return;
        }
        this.f99130d.setText("\u5168\u91cf\n\u7f16\u8bd1");
    }
}
