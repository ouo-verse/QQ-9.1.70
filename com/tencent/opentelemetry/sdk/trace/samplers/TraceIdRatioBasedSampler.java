package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.internal.OtelEncodingUtils;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class TraceIdRatioBasedSampler implements Sampler {
    static IPatchRedirector $redirector_;
    private static final SamplingResult NEGATIVE_SAMPLING_RESULT;
    private static final SamplingResult POSITIVE_SAMPLING_RESULT;
    private final String description;
    private final long idUpperBound;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12007);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            POSITIVE_SAMPLING_RESULT = b.b(SamplingDecision.RECORD_AND_SAMPLE);
            NEGATIVE_SAMPLING_RESULT = b.b(SamplingDecision.DROP);
        }
    }

    TraceIdRatioBasedSampler(double d16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16), Long.valueOf(j3));
        } else {
            this.idUpperBound = j3;
            this.description = String.format("TraceIdRatioBased{%.6f}", Double.valueOf(d16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceIdRatioBasedSampler create(double d16) {
        long j3;
        if (d16 >= 0.0d && d16 <= 1.0d) {
            if (d16 == 0.0d) {
                j3 = Long.MIN_VALUE;
            } else if (d16 == 1.0d) {
                j3 = Long.MAX_VALUE;
            } else {
                j3 = (long) (9.223372036854776E18d * d16);
            }
            return new TraceIdRatioBasedSampler(d16, j3);
        }
        throw new IllegalArgumentException("ratio must be in range [0.0, 1.0]");
    }

    private static long getTraceIdRandomPart(String str) {
        return OtelEncodingUtils.longFromBase16String(str, 16);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof TraceIdRatioBasedSampler) || this.idUpperBound != ((TraceIdRatioBasedSampler) obj).idUpperBound) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public final String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.description;
    }

    long getIdUpperBound() {
        return this.idUpperBound;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return androidx.fragment.app.a.a(this.idUpperBound);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public final SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SamplingResult) iPatchRedirector.redirect((short) 2, this, context, str, str2, spanKind, attributes, list);
        }
        if (Math.abs(getTraceIdRandomPart(str)) < this.idUpperBound) {
            return POSITIVE_SAMPLING_RESULT;
        }
        return NEGATIVE_SAMPLING_RESULT;
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getDescription();
    }
}
