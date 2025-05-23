package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static Sampler a() {
        IPatchRedirector iPatchRedirector = Sampler.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Sampler) iPatchRedirector.redirect((short) 2);
        }
        return AlwaysOffSampler.INSTANCE;
    }

    public static Sampler b() {
        IPatchRedirector iPatchRedirector = Sampler.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Sampler) iPatchRedirector.redirect((short) 1);
        }
        return AlwaysOnSampler.INSTANCE;
    }

    public static Sampler c(Sampler sampler) {
        IPatchRedirector iPatchRedirector = Sampler.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Sampler) iPatchRedirector.redirect((short) 3, (Object) sampler);
        }
        return d(sampler).build();
    }

    public static ParentBasedSamplerBuilder d(Sampler sampler) {
        IPatchRedirector iPatchRedirector = Sampler.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ParentBasedSamplerBuilder) iPatchRedirector.redirect((short) 4, (Object) sampler);
        }
        return new ParentBasedSamplerBuilder(sampler);
    }

    public static Sampler e(double d16) {
        IPatchRedirector iPatchRedirector = Sampler.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Sampler) iPatchRedirector.redirect((short) 5, Double.valueOf(d16));
        }
        return TraceIdRatioBasedSampler.create(d16);
    }
}
