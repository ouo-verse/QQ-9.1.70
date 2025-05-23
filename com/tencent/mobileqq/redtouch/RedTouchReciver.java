package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RedTouchReciver extends ResultReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f280273d;

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
            return;
        }
        super.onReceiveResult(i3, bundle);
        b c16 = b.c(bundle);
        if (c16 != null) {
            c16.d(this.f280273d, bundle);
        }
    }
}
