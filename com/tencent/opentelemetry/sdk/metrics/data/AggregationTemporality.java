package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AggregationTemporality {
    private static final /* synthetic */ AggregationTemporality[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AggregationTemporality CUMULATIVE;
    public static final AggregationTemporality DELTA;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AggregationTemporality aggregationTemporality = new AggregationTemporality("DELTA", 0);
        DELTA = aggregationTemporality;
        AggregationTemporality aggregationTemporality2 = new AggregationTemporality("CUMULATIVE", 1);
        CUMULATIVE = aggregationTemporality2;
        $VALUES = new AggregationTemporality[]{aggregationTemporality, aggregationTemporality2};
    }

    AggregationTemporality(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AggregationTemporality valueOf(String str) {
        return (AggregationTemporality) Enum.valueOf(AggregationTemporality.class, str);
    }

    public static AggregationTemporality[] values() {
        return (AggregationTemporality[]) $VALUES.clone();
    }
}
