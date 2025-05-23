package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThrowableUtil {
    static IPatchRedirector $redirector_;

    ThrowableUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void propagateIfFatal(Throwable th5) {
        if (!(th5 instanceof VirtualMachineError)) {
            if (!(th5 instanceof ThreadDeath)) {
                if (!(th5 instanceof LinkageError)) {
                    return;
                } else {
                    throw ((LinkageError) th5);
                }
            }
            throw ((ThreadDeath) th5);
        }
        throw ((VirtualMachineError) th5);
    }
}
