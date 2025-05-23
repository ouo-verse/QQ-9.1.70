package com.tencent.opentelemetry.sdk.metrics.internal.concurrent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static double a(DoubleAdder doubleAdder) {
        IPatchRedirector iPatchRedirector = DoubleAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, (Object) doubleAdder)).doubleValue();
        }
        return doubleAdder.sum();
    }

    public static float b(DoubleAdder doubleAdder) {
        IPatchRedirector iPatchRedirector = DoubleAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) doubleAdder)).floatValue();
        }
        return (float) doubleAdder.sum();
    }

    public static int c(DoubleAdder doubleAdder) {
        IPatchRedirector iPatchRedirector = DoubleAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) doubleAdder)).intValue();
        }
        return (int) doubleAdder.sum();
    }

    public static long d(DoubleAdder doubleAdder) {
        IPatchRedirector iPatchRedirector = DoubleAdder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) doubleAdder)).longValue();
        }
        return (long) doubleAdder.sum();
    }
}
