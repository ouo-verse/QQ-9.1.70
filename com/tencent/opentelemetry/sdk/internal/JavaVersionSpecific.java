package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JavaVersionSpecific {
    static IPatchRedirector $redirector_;
    private static final JavaVersionSpecific CURRENT;
    private static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        String name = JavaVersionSpecific.class.getName();
        TAG = name;
        JavaVersionSpecific javaVersionSpecific = CurrentJavaVersionSpecific.get();
        CURRENT = javaVersionSpecific;
        if (javaVersionSpecific.getClass() != JavaVersionSpecific.class && DefaultPrintLogger.isDebug()) {
            DefaultPrintLogger.d(name, "Using the APIs optimized for: " + javaVersionSpecific.name());
        }
    }

    public JavaVersionSpecific() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JavaVersionSpecific get() {
        return CURRENT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long currentTimeNanos() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    String name() {
        return "Java 8";
    }
}
