package com.tencent.mobileqq.loginregister.sms;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final /* synthetic */ class a {
    public static void a(b bVar, QBaseActivity qBaseActivity, long j3, com.tencent.mobileqq.loginregister.callback.a aVar) {
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, bVar, qBaseActivity, Long.valueOf(j3), aVar);
        } else if (aVar != null) {
            aVar.onResult(null);
        }
    }
}
