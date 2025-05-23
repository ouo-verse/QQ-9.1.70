package com.tencent.wstt.SSCM;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes27.dex */
class SSCMTimer$1 extends TimerTask {
    static IPatchRedirector $redirector_;
    final /* synthetic */ b this$0;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    @Override // java.util.TimerTask, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (b.a(null)) {
            long parseLong = Long.parseLong(c.c());
            if (parseLong == -1) {
                b.f(null, false);
            } else {
                i3 = (int) (parseLong - b.b(null));
                b.g(null, parseLong);
                if (i3 <= 0) {
                    b.i(null, 0);
                    return;
                }
                b.i(null, b.e(null) + b.d(null));
                if (b.e(null) >= 120000) {
                    b.h(null, 1);
                    cancel();
                    b.c(null);
                    return;
                }
                return;
            }
        }
        i3 = 0;
        if (i3 <= 0) {
        }
    }
}
