package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.TraceState;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface SamplingResult {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$trace$samplers$SamplingDecision;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12105);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[SamplingDecision.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$trace$samplers$SamplingDecision = iArr;
            try {
                iArr[SamplingDecision.RECORD_AND_SAMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$trace$samplers$SamplingDecision[SamplingDecision.RECORD_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$trace$samplers$SamplingDecision[SamplingDecision.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    Attributes getAttributes();

    SamplingDecision getDecision();

    TraceState getUpdatedTraceState(TraceState traceState);
}
