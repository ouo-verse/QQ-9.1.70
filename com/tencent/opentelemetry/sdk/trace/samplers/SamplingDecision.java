package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class SamplingDecision {
    private static final /* synthetic */ SamplingDecision[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final SamplingDecision DROP;
    public static final SamplingDecision RECORD_AND_SAMPLE;
    public static final SamplingDecision RECORD_ONLY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12133);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SamplingDecision samplingDecision = new SamplingDecision("DROP", 0);
        DROP = samplingDecision;
        SamplingDecision samplingDecision2 = new SamplingDecision("RECORD_ONLY", 1);
        RECORD_ONLY = samplingDecision2;
        SamplingDecision samplingDecision3 = new SamplingDecision("RECORD_AND_SAMPLE", 2);
        RECORD_AND_SAMPLE = samplingDecision3;
        $VALUES = new SamplingDecision[]{samplingDecision, samplingDecision2, samplingDecision3};
    }

    SamplingDecision(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static SamplingDecision valueOf(String str) {
        return (SamplingDecision) Enum.valueOf(SamplingDecision.class, str);
    }

    public static SamplingDecision[] values() {
        return (SamplingDecision[]) $VALUES.clone();
    }
}
