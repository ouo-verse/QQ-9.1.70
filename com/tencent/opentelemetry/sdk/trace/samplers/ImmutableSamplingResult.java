package com.tencent.opentelemetry.sdk.trace.samplers;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.api.trace.TraceState;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableSamplingResult implements SamplingResult {
    static IPatchRedirector $redirector_;
    static final SamplingResult EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT;
    static final SamplingResult EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
    static final SamplingResult EMPTY_RECORDED_SAMPLING_RESULT;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT = createWithoutAttributes(SamplingDecision.RECORD_AND_SAMPLE);
        EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT = createWithoutAttributes(SamplingDecision.DROP);
        EMPTY_RECORDED_SAMPLING_RESULT = createWithoutAttributes(SamplingDecision.RECORD_ONLY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSamplingResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SamplingResult createSamplingResult(SamplingDecision samplingDecision, Attributes attributes) {
        return new AutoValue_ImmutableSamplingResult(samplingDecision, attributes);
    }

    private static SamplingResult createWithoutAttributes(SamplingDecision samplingDecision) {
        return new AutoValue_ImmutableSamplingResult(samplingDecision, f.b());
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult
    public abstract Attributes getAttributes();

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult
    public abstract SamplingDecision getDecision();

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult
    public /* synthetic */ TraceState getUpdatedTraceState(TraceState traceState) {
        return b.a(this, traceState);
    }
}
