package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class f {
    public static TraceFlags a(byte b16) {
        IPatchRedirector iPatchRedirector = TraceFlags.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TraceFlags) iPatchRedirector.redirect((short) 5, Byte.valueOf(b16));
        }
        return ImmutableTraceFlags.fromByte(b16);
    }

    public static TraceFlags b(CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = TraceFlags.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TraceFlags) iPatchRedirector.redirect((short) 4, (Object) charSequence, i3);
        }
        return ImmutableTraceFlags.fromHex(charSequence, i3);
    }

    public static TraceFlags c() {
        IPatchRedirector iPatchRedirector = TraceFlags.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TraceFlags) iPatchRedirector.redirect((short) 2);
        }
        return ImmutableTraceFlags.DEFAULT;
    }

    public static int d() {
        IPatchRedirector iPatchRedirector = TraceFlags.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1)).intValue();
        }
        return 2;
    }

    public static TraceFlags e() {
        IPatchRedirector iPatchRedirector = TraceFlags.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TraceFlags) iPatchRedirector.redirect((short) 3);
        }
        return ImmutableTraceFlags.SAMPLED;
    }
}
