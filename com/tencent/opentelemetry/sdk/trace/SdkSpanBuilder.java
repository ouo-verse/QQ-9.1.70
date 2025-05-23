package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.internal.ImmutableSpanContext;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.trace.ExternalSpanData;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanBuilder;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanId;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.TraceId;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import com.tencent.opentelemetry.sdk.trace.samplers.SamplingDecision;
import com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkSpanBuilder implements SpanBuilder {
    static IPatchRedirector $redirector_;

    @Nullable
    private AttributesMap attributes;
    private final InstrumentationScopeInfo instrumentationScopeInfo;

    @Nullable
    private List<LinkData> links;

    @Nullable
    private Context parent;
    private SpanKind spanKind;
    private final SpanLimits spanLimits;
    private final String spanName;
    private long startEpochNanos;
    private int totalNumberOfLinksAdded;
    private final TracerSharedState tracerSharedState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkSpanBuilder(String str, InstrumentationScopeInfo instrumentationScopeInfo, TracerSharedState tracerSharedState, SpanLimits spanLimits) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, instrumentationScopeInfo, tracerSharedState, spanLimits);
            return;
        }
        this.spanKind = SpanKind.INTERNAL;
        this.totalNumberOfLinksAdded = 0;
        this.startEpochNanos = 0L;
        this.spanName = str;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.tracerSharedState = tracerSharedState;
        this.spanLimits = spanLimits;
    }

    private AttributesMap attributes() {
        AttributesMap attributesMap = this.attributes;
        if (attributesMap == null) {
            AttributesMap attributesMap2 = new AttributesMap(this.spanLimits.getMaxNumberOfAttributes(), this.spanLimits.getMaxAttributeValueLength());
            this.attributes = attributesMap2;
            return attributesMap2;
        }
        return attributesMap;
    }

    static boolean isRecording(SamplingDecision samplingDecision) {
        if (!SamplingDecision.RECORD_ONLY.equals(samplingDecision) && !SamplingDecision.RECORD_AND_SAMPLE.equals(samplingDecision)) {
            return false;
        }
        return true;
    }

    static boolean isSampled(SamplingDecision samplingDecision) {
        return SamplingDecision.RECORD_AND_SAMPLE.equals(samplingDecision);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSpan$0(AttributeKey attributeKey, Object obj) {
        attributes().put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSpan$1(AttributeKey attributeKey, Object obj) {
        attributes().put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder addLink(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) spanContext);
        }
        if (spanContext != null && spanContext.isValid()) {
            addLink(com.tencent.opentelemetry.sdk.trace.data.b.a(spanContext));
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public /* synthetic */ SpanBuilder setAllAttributes(Attributes attributes) {
        return com.tencent.opentelemetry.api.trace.d.a(this, attributes);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setAttribute(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? setAttribute((AttributeKey<AttributeKey<String>>) com.tencent.opentelemetry.api.common.e.h(str), (AttributeKey<String>) str2) : (SpanBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setNoParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        this.parent = com.tencent.opentelemetry.context.e.m();
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setParent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        if (context == null) {
            return this;
        }
        this.parent = context;
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setSpanKind(SpanKind spanKind) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) spanKind);
        }
        if (spanKind == null) {
            return this;
        }
        this.spanKind = spanKind;
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public /* synthetic */ SpanBuilder setStartTimestamp(Instant instant) {
        return com.tencent.opentelemetry.api.trace.d.b(this, instant);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public Span startSpan() {
        String traceId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Span) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        Context context = this.parent;
        if (context == null) {
            context = com.tencent.opentelemetry.context.e.k();
        }
        Span q16 = com.tencent.opentelemetry.api.trace.b.q(context);
        SpanContext spanContext = q16.getSpanContext();
        IdGenerator idGenerator = this.tracerSharedState.getIdGenerator();
        String generateSpanId = idGenerator.generateSpanId();
        if (!spanContext.isValid()) {
            traceId = idGenerator.generateTraceId();
        } else {
            traceId = spanContext.getTraceId();
        }
        String str = traceId;
        if (DefaultPrintLogger.isDebug()) {
            DefaultPrintLogger.d("SdkSpanBuilder", "generate traceId = " + str + "; spanId = " + generateSpanId);
        }
        List<LinkData> list = this.links;
        List<LinkData> emptyList = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.links = null;
        Attributes attributes = this.attributes;
        if (attributes == null) {
            attributes = com.tencent.opentelemetry.api.common.f.b();
        }
        SamplingResult shouldSample = this.tracerSharedState.getSampler().shouldSample(context, str, this.spanName, this.spanKind, attributes, emptyList);
        SamplingDecision decision = shouldSample.getDecision();
        SpanContext create = ImmutableSpanContext.create(str, generateSpanId, isSampled(decision) ? com.tencent.opentelemetry.api.trace.f.e() : com.tencent.opentelemetry.api.trace.f.c(), shouldSample.getUpdatedTraceState(spanContext.getTraceState()), false, this.tracerSharedState.isIdGeneratorSafeToSkipIdValidation());
        if (!isRecording(decision)) {
            return com.tencent.opentelemetry.api.trace.b.t(create);
        }
        Attributes attributes2 = shouldSample.getAttributes();
        if (!attributes2.isEmpty()) {
            attributes2.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.trace.d
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    SdkSpanBuilder.this.lambda$startSpan$0((AttributeKey) obj, obj2);
                }
            });
        }
        AttributesMap attributesMap = this.attributes;
        this.attributes = null;
        return SdkSpan.startSpan(create, this.spanName, this.instrumentationScopeInfo, this.spanKind, q16, context, this.spanLimits, this.tracerSharedState.getActiveSpanProcessor(), this.tracerSharedState.getClock(), this.tracerSharedState.getResource(), attributesMap, emptyList, this.totalNumberOfLinksAdded, this.startEpochNanos);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setAttribute(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? setAttribute((AttributeKey<AttributeKey<Long>>) com.tencent.opentelemetry.api.common.e.f(str), (AttributeKey<Long>) Long.valueOf(j3)) : (SpanBuilder) iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3));
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setStartTimestamp(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), timeUnit);
        }
        if (j3 >= 0 && timeUnit != null) {
            this.startEpochNanos = timeUnit.toNanos(j3);
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder addLink(SpanContext spanContext, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) spanContext, (Object) attributes);
        }
        if (spanContext != null && spanContext.isValid()) {
            if (attributes == null) {
                attributes = com.tencent.opentelemetry.api.common.f.b();
            }
            addLink(com.tencent.opentelemetry.sdk.trace.data.b.c(spanContext, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerLink(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setAttribute(String str, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? setAttribute((AttributeKey<AttributeKey<Double>>) com.tencent.opentelemetry.api.common.e.d(str), (AttributeKey<Double>) Double.valueOf(d16)) : (SpanBuilder) iPatchRedirector.redirect((short) 9, this, str, Double.valueOf(d16));
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public SpanBuilder setAttribute(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? setAttribute((AttributeKey<AttributeKey<Boolean>>) com.tencent.opentelemetry.api.common.e.b(str), (AttributeKey<Boolean>) Boolean.valueOf(z16)) : (SpanBuilder) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public <T> SpanBuilder setAttribute(AttributeKey<T> attributeKey, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) attributeKey, (Object) t16);
        }
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t16 != null) {
            attributes().put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t16);
        }
        return this;
    }

    private void addLink(LinkData linkData) {
        this.totalNumberOfLinksAdded++;
        if (this.links == null) {
            this.links = new ArrayList(this.spanLimits.getMaxNumberOfLinks());
        }
        if (this.links.size() == this.spanLimits.getMaxNumberOfLinks()) {
            return;
        }
        this.links.add(linkData);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
    public Span startSpan(ExternalSpanData externalSpanData) {
        String traceId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Span) iPatchRedirector.redirect((short) 14, (Object) this, (Object) externalSpanData);
        }
        Context context = this.parent;
        if (context == null) {
            context = com.tencent.opentelemetry.context.e.k();
        }
        Span q16 = com.tencent.opentelemetry.api.trace.b.q(context);
        SpanContext spanContext = q16.getSpanContext();
        IdGenerator idGenerator = this.tracerSharedState.getIdGenerator();
        String spanId = externalSpanData.getSpanId() != null ? externalSpanData.getSpanId() : idGenerator.generateSpanId();
        if (!spanContext.isValid()) {
            traceId = externalSpanData.getTraceId() != null ? externalSpanData.getTraceId() : idGenerator.generateTraceId();
        } else {
            traceId = spanContext.getTraceId();
        }
        String str = traceId;
        if (str.length() == TraceId.getLength() && spanId.length() == SpanId.getLength()) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.d("SdkSpanBuilder", "generate with external span data, traceId = " + str + "; spanId = " + spanId);
            }
            List<LinkData> list = this.links;
            List<LinkData> emptyList = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.links = null;
            Attributes attributes = this.attributes;
            if (attributes == null) {
                attributes = com.tencent.opentelemetry.api.common.f.b();
            }
            SamplingResult shouldSample = this.tracerSharedState.getSampler().shouldSample(context, str, this.spanName, this.spanKind, attributes, emptyList);
            SamplingDecision decision = shouldSample.getDecision();
            SpanContext create = ImmutableSpanContext.create(str, spanId, isSampled(decision) ? com.tencent.opentelemetry.api.trace.f.e() : com.tencent.opentelemetry.api.trace.f.c(), shouldSample.getUpdatedTraceState(spanContext.getTraceState()), false, this.tracerSharedState.isIdGeneratorSafeToSkipIdValidation());
            if (!isRecording(decision)) {
                return com.tencent.opentelemetry.api.trace.b.t(create);
            }
            Attributes attributes2 = shouldSample.getAttributes();
            if (!attributes2.isEmpty()) {
                attributes2.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.trace.e
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        SdkSpanBuilder.this.lambda$startSpan$1((AttributeKey) obj, obj2);
                    }
                });
            }
            AttributesMap attributesMap = this.attributes;
            this.attributes = null;
            return SdkSpan.startSpan(create, this.spanName, this.instrumentationScopeInfo, this.spanKind, q16, context, this.spanLimits, this.tracerSharedState.getActiveSpanProcessor(), this.tracerSharedState.getClock(), this.tracerSharedState.getResource(), attributesMap, emptyList, this.totalNumberOfLinksAdded, this.startEpochNanos);
        }
        return com.tencent.opentelemetry.api.trace.b.s();
    }
}
