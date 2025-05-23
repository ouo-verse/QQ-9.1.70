package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class OtlpHttpConnectionPool {
    static IPatchRedirector $redirector_ = null;
    public static final int CONNECTION_TIME_OUT = 30000;
    public static final long KEEP_ALLIVE_TIME = 60000;
    public static final int MAX_IDLE_CONNECTIONS = 30;
    public static final int SOCKET_TIME_OUT = 30000;

    public OtlpHttpConnectionPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
