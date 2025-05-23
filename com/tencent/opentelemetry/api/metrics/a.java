package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static Meter a(MeterProvider meterProvider, String str) {
        IPatchRedirector iPatchRedirector = MeterProvider.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Meter) iPatchRedirector.redirect((short) 1, (Object) meterProvider, (Object) str);
        }
        return meterProvider.meterBuilder(str).build();
    }

    public static Meter b(MeterProvider meterProvider, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = MeterProvider.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Meter) iPatchRedirector.redirect((short) 2, meterProvider, str, str2, str3);
        }
        return meterProvider.meterBuilder(str).setInstrumentationVersion(str2).setSchemaUrl(str3).build();
    }

    public static MeterProvider c() {
        IPatchRedirector iPatchRedirector = MeterProvider.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MeterProvider) iPatchRedirector.redirect((short) 3);
        }
        return DefaultMeterProvider.getInstance();
    }
}
