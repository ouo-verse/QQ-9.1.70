package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class AlwaysOnSampler implements Sampler {
    private static final /* synthetic */ AlwaysOnSampler[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AlwaysOnSampler INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12072);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        AlwaysOnSampler alwaysOnSampler = new AlwaysOnSampler("INSTANCE", 0);
        INSTANCE = alwaysOnSampler;
        $VALUES = new AlwaysOnSampler[]{alwaysOnSampler};
    }

    AlwaysOnSampler(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AlwaysOnSampler valueOf(String str) {
        return (AlwaysOnSampler) Enum.valueOf(AlwaysOnSampler.class, str);
    }

    public static AlwaysOnSampler[] values() {
        return (AlwaysOnSampler[]) $VALUES.clone();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AlwaysOnSampler";
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SamplingResult) iPatchRedirector.redirect((short) 2, this, context, str, str2, spanKind, attributes, list);
        }
        return ImmutableSamplingResult.EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
    }

    @Override // java.lang.Enum
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getDescription();
    }
}
