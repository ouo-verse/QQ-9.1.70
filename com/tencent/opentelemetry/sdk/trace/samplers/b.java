package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.TraceState;
import com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static TraceState a(SamplingResult samplingResult, TraceState traceState) {
        IPatchRedirector iPatchRedirector = SamplingResult.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TraceState) iPatchRedirector.redirect((short) 3, (Object) samplingResult, (Object) traceState);
        }
        return traceState;
    }

    public static SamplingResult b(SamplingDecision samplingDecision) {
        IPatchRedirector iPatchRedirector = SamplingResult.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SamplingResult) iPatchRedirector.redirect((short) 1, (Object) samplingDecision);
        }
        int i3 = SamplingResult.AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$trace$samplers$SamplingDecision[samplingDecision.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return ImmutableSamplingResult.EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT;
                }
                throw new AssertionError("unrecognised samplingResult");
            }
            return ImmutableSamplingResult.EMPTY_RECORDED_SAMPLING_RESULT;
        }
        return ImmutableSamplingResult.EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
    }

    public static SamplingResult c(SamplingDecision samplingDecision, Attributes attributes) {
        IPatchRedirector iPatchRedirector = SamplingResult.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SamplingResult) iPatchRedirector.redirect((short) 2, (Object) samplingDecision, (Object) attributes);
        }
        Objects.requireNonNull(attributes, "attributes");
        if (attributes.isEmpty()) {
            return b(samplingDecision);
        }
        return ImmutableSamplingResult.createSamplingResult(samplingDecision, attributes);
    }
}
