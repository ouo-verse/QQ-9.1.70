package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
/* loaded from: classes22.dex */
public final class ParentBasedSampler implements Sampler {
    static IPatchRedirector $redirector_;
    private final Sampler localParentNotSampled;
    private final Sampler localParentSampled;
    private final Sampler remoteParentNotSampled;
    private final Sampler remoteParentSampled;
    private final Sampler root;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParentBasedSampler(Sampler sampler, @Nullable Sampler sampler2, @Nullable Sampler sampler3, @Nullable Sampler sampler4, @Nullable Sampler sampler5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sampler, sampler2, sampler3, sampler4, sampler5);
            return;
        }
        this.root = sampler;
        this.remoteParentSampled = sampler2 == null ? a.b() : sampler2;
        this.remoteParentNotSampled = sampler3 == null ? a.a() : sampler3;
        this.localParentSampled = sampler4 == null ? a.b() : sampler4;
        this.localParentNotSampled = sampler5 == null ? a.a() : sampler5;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentBasedSampler)) {
            return false;
        }
        ParentBasedSampler parentBasedSampler = (ParentBasedSampler) obj;
        if (this.root.equals(parentBasedSampler.root) && this.remoteParentSampled.equals(parentBasedSampler.remoteParentSampled) && this.remoteParentNotSampled.equals(parentBasedSampler.remoteParentNotSampled) && this.localParentSampled.equals(parentBasedSampler.localParentSampled) && this.localParentNotSampled.equals(parentBasedSampler.localParentNotSampled)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return String.format("ParentBased{root:%s,remoteParentSampled:%s,remoteParentNotSampled:%s,localParentSampled:%s,localParentNotSampled:%s}", this.root.getDescription(), this.remoteParentSampled.getDescription(), this.remoteParentNotSampled.getDescription(), this.localParentSampled.getDescription(), this.localParentNotSampled.getDescription());
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return (((((((this.root.hashCode() * 31) + this.remoteParentSampled.hashCode()) * 31) + this.remoteParentNotSampled.hashCode()) * 31) + this.localParentSampled.hashCode()) * 31) + this.localParentNotSampled.hashCode();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SamplingResult) iPatchRedirector.redirect((short) 2, this, context, str, str2, spanKind, attributes, list);
        }
        SpanContext spanContext = com.tencent.opentelemetry.api.trace.b.q(context).getSpanContext();
        if (!spanContext.isValid()) {
            return this.root.shouldSample(context, str, str2, spanKind, attributes, list);
        }
        if (spanContext.isRemote()) {
            if (spanContext.isSampled()) {
                return this.remoteParentSampled.shouldSample(context, str, str2, spanKind, attributes, list);
            }
            return this.remoteParentNotSampled.shouldSample(context, str, str2, spanKind, attributes, list);
        }
        if (spanContext.isSampled()) {
            return this.localParentSampled.shouldSample(context, str, str2, spanKind, attributes, list);
        }
        return this.localParentNotSampled.shouldSample(context, str, str2, spanKind, attributes, list);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getDescription();
    }
}
