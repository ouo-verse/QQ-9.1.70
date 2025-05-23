package com.tencent.sonic.sdk;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sonic.sdk.SonicSessionConnection;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SonicSessionConnectionInterceptor {
    static IPatchRedirector $redirector_;

    public SonicSessionConnectionInterceptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SonicSessionConnection getSonicSessionConnection(SonicSession sonicSession, Intent intent) {
        SonicSessionConnectionInterceptor sonicSessionConnectionInterceptor = sonicSession.config.connectionInterceptor;
        if (sonicSessionConnectionInterceptor != null) {
            return sonicSessionConnectionInterceptor.getConnection(sonicSession, intent);
        }
        return new SonicSessionConnection.SessionConnectionDefaultImpl(sonicSession, intent);
    }

    public abstract SonicSessionConnection getConnection(SonicSession sonicSession, Intent intent);
}
