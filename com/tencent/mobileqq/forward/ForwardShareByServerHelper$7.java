package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;

/* compiled from: P */
/* loaded from: classes12.dex */
class ForwardShareByServerHelper$7 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f210877d;
    final /* synthetic */ x this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ForwardStatisticsReporter.k("KEY_STAGE_2_TOTAL", false);
        if (x.b(null) == null) {
            x.d(null, DialogUtil.createCustomDialog(x.a(null), 230));
        }
        x.b(null).setMessage(this.f210877d);
        x.b(null);
        throw null;
    }
}
