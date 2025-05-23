package com.tencent.opentelemetry.sdk.metrics.internal.concurrent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static void a(LongAdder longAdder) {
        IPatchRedirector iPatchRedirector = LongAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) longAdder);
        } else {
            longAdder.add(-1L);
        }
    }

    public static double b(LongAdder longAdder) {
        IPatchRedirector iPatchRedirector = LongAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Double) iPatchRedirector.redirect((short) 6, (Object) longAdder)).doubleValue();
        }
        return longAdder.sum();
    }

    public static float c(LongAdder longAdder) {
        IPatchRedirector iPatchRedirector = LongAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) longAdder)).floatValue();
        }
        return (float) longAdder.sum();
    }

    public static void d(LongAdder longAdder) {
        IPatchRedirector iPatchRedirector = LongAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) longAdder);
        } else {
            longAdder.add(1L);
        }
    }

    public static int e(LongAdder longAdder) {
        IPatchRedirector iPatchRedirector = LongAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) longAdder)).intValue();
        }
        return (int) longAdder.sum();
    }

    public static long f(LongAdder longAdder) {
        IPatchRedirector iPatchRedirector = LongAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) longAdder)).longValue();
        }
        return longAdder.sum();
    }
}
