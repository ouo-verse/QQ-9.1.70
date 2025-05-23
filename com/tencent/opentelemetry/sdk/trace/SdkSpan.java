package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.Scope;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.internal.InstrumentationScopeUtil;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.sdk.trace.data.EventData;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import com.tencent.opentelemetry.sdk.trace.data.StatusData;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public final class SdkSpan implements ReadWriteSpan {
    static IPatchRedirector $redirector_;
    private static final String TAG;

    @Nullable
    private AttributesMap attributes;
    private final AnchoredClock clock;
    private final SpanContext context;
    private long endEpochNanos;
    private final List<EventData> events;
    private boolean hasEnded;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final SpanKind kind;
    private final List<LinkData> links;
    private final Object lock;
    private String name;
    private final SpanContext parentSpanContext;
    private final Resource resource;
    private final SpanLimits spanLimits;
    private final SpanProcessor spanProcessor;
    private final long startEpochNanos;

    @Nullable
    private StatusData status;
    private int totalRecordedEvents;
    private final int totalRecordedLinks;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            TAG = SdkSpan.class.getName();
        }
    }

    SdkSpan(SpanContext spanContext, String str, InstrumentationScopeInfo instrumentationScopeInfo, SpanKind spanKind, SpanContext spanContext2, SpanLimits spanLimits, SpanProcessor spanProcessor, AnchoredClock anchoredClock, Resource resource, @Nullable AttributesMap attributesMap, List<LinkData> list, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spanContext, str, instrumentationScopeInfo, spanKind, spanContext2, spanLimits, spanProcessor, anchoredClock, resource, attributesMap, list, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.lock = new Object();
        this.totalRecordedEvents = 0;
        this.status = com.tencent.opentelemetry.sdk.trace.data.d.d();
        this.context = spanContext;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.parentSpanContext = spanContext2;
        this.links = list;
        this.totalRecordedLinks = i3;
        this.name = str;
        this.kind = spanKind;
        this.spanProcessor = spanProcessor;
        this.resource = resource;
        this.hasEnded = false;
        this.clock = anchoredClock;
        this.startEpochNanos = j3;
        this.attributes = attributesMap;
        this.events = new ArrayList();
        this.spanLimits = spanLimits;
    }

    private void addTimedEvent(EventData eventData) {
        synchronized (this.lock) {
            if (this.hasEnded) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.d(TAG, "Calling addEvent() on an ended Span.");
                }
            } else {
                if (this.events.size() < this.spanLimits.getMaxNumberOfEvents()) {
                    this.events.add(eventData);
                }
                this.totalRecordedEvents++;
            }
        }
    }

    private void endInternal(long j3) {
        synchronized (this.lock) {
            if (this.hasEnded) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.d(TAG, "Calling end() on an ended Span.");
                }
            } else {
                this.endEpochNanos = j3;
                this.hasEnded = true;
                this.spanProcessor.onEnd(this);
            }
        }
    }

    private Attributes getImmutableAttributes() {
        AttributesMap attributesMap = this.attributes;
        if (attributesMap != null && !attributesMap.isEmpty()) {
            if (this.hasEnded) {
                return this.attributes;
            }
            return this.attributes.immutableCopy();
        }
        return com.tencent.opentelemetry.api.common.f.b();
    }

    private List<EventData> getImmutableTimedEvents() {
        if (this.events.isEmpty()) {
            return Collections.emptyList();
        }
        if (this.hasEnded) {
            return Collections.unmodifiableList(this.events);
        }
        return Collections.unmodifiableList(new ArrayList(this.events));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SdkSpan startSpan(SpanContext spanContext, String str, InstrumentationScopeInfo instrumentationScopeInfo, SpanKind spanKind, Span span, Context context, SpanLimits spanLimits, SpanProcessor spanProcessor, Clock clock, Resource resource, @Nullable AttributesMap attributesMap, List<LinkData> list, int i3, long j3) {
        AnchoredClock create;
        boolean z16;
        long now;
        long j16;
        if (span instanceof SdkSpan) {
            create = ((SdkSpan) span).clock;
            z16 = false;
        } else {
            create = AnchoredClock.create(clock);
            z16 = true;
        }
        AnchoredClock anchoredClock = create;
        if (j3 != 0) {
            j16 = j3;
        } else {
            if (z16) {
                now = anchoredClock.startTime();
            } else {
                now = anchoredClock.now();
            }
            j16 = now;
        }
        SdkSpan sdkSpan = new SdkSpan(spanContext, str, instrumentationScopeInfo, spanKind, span.getSpanContext(), spanLimits, spanProcessor, anchoredClock, resource, attributesMap, list, i3, j16);
        spanProcessor.onStart(context, sdkSpan);
        return sdkSpan;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span addEvent(String str, Attributes attributes, Instant instant) {
        return com.tencent.opentelemetry.api.trace.b.c(this, str, attributes, instant);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ void end(Instant instant) {
        com.tencent.opentelemetry.api.trace.b.e(this, instant);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    @Nullable
    public <T> T getAttribute(AttributeKey<T> attributeKey) {
        T t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) attributeKey);
        }
        synchronized (this.lock) {
            AttributesMap attributesMap = this.attributes;
            if (attributesMap == null) {
                t16 = null;
            } else {
                t16 = (T) attributesMap.get((AttributeKey) attributeKey);
            }
        }
        return t16;
    }

    AnchoredClock getClock() {
        return this.clock;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public InstrumentationLibraryInfo getInstrumentationLibraryInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (InstrumentationLibraryInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return InstrumentationScopeUtil.toInstrumentationLibraryInfo(getInstrumentationScopeInfo());
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (InstrumentationScopeInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.instrumentationScopeInfo;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public SpanKind getKind() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (SpanKind) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.kind;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public long getLatencyNanos() {
        long now;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                now = this.endEpochNanos;
            } else {
                now = this.clock.now();
            }
            j3 = now - this.startEpochNanos;
        }
        return j3;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public String getName() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        synchronized (this.lock) {
            str = this.name;
        }
        return str;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public SpanContext getParentSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SpanContext) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.parentSpanContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource getResource() {
        return this.resource;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public SpanContext getSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SpanContext) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getStartEpochNanos() {
        return this.startEpochNanos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTotalRecordedLinks() {
        return this.totalRecordedLinks;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public boolean hasEnded() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        synchronized (this.lock) {
            z16 = this.hasEnded;
        }
        return z16;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public boolean isRecording() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        synchronized (this.lock) {
            if (!this.hasEnded) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.tencent.opentelemetry.context.ImplicitContextKeyed
    public /* synthetic */ Scope makeCurrent() {
        return com.tencent.opentelemetry.context.h.a(this);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setAllAttributes(Attributes attributes) {
        return com.tencent.opentelemetry.api.trace.b.g(this, attributes);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setAttribute(AttributeKey attributeKey, int i3) {
        return com.tencent.opentelemetry.api.trace.b.h(this, attributeKey, i3);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setStatus(StatusCode statusCode) {
        return com.tencent.opentelemetry.api.trace.b.m(this, statusCode);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span, com.tencent.opentelemetry.context.ImplicitContextKeyed
    public /* synthetic */ Context storeInContext(Context context) {
        return com.tencent.opentelemetry.api.trace.b.n(this, context);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.ReadableSpan
    public SpanData toSpanData() {
        int totalAddedValues;
        SpanWrapper create;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (this.lock) {
            List<LinkData> list = this.links;
            List<EventData> immutableTimedEvents = getImmutableTimedEvents();
            Attributes immutableAttributes = getImmutableAttributes();
            AttributesMap attributesMap = this.attributes;
            if (attributesMap == null) {
                totalAddedValues = 0;
            } else {
                totalAddedValues = attributesMap.getTotalAddedValues();
            }
            create = SpanWrapper.create(this, list, immutableTimedEvents, immutableAttributes, totalAddedValues, this.totalRecordedEvents, this.status, this.name, this.endEpochNanos, this.hasEnded);
        }
        return create;
    }

    public String toString() {
        String str;
        String valueOf;
        String valueOf2;
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        synchronized (this.lock) {
            str = this.name;
            valueOf = String.valueOf(this.attributes);
            valueOf2 = String.valueOf(this.status);
            j3 = this.totalRecordedEvents;
            j16 = this.endEpochNanos;
        }
        return "SdkSpan{traceId=" + this.context.getTraceId() + ", spanId=" + this.context.getSpanId() + ", parentSpanContext=" + this.parentSpanContext + ", name=" + str + ", kind=" + this.kind + ", attributes=" + valueOf + ", status=" + valueOf2 + ", totalRecordedEvents=" + j3 + ", totalRecordedLinks=" + this.totalRecordedLinks + ", startEpochNanos=" + this.startEpochNanos + ", endEpochNanos=" + j16 + "}";
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span addEvent(String str, Instant instant) {
        return com.tencent.opentelemetry.api.trace.b.d(this, str, instant);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public void end() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            endInternal(this.clock.now());
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setAttribute(String str, double d16) {
        return com.tencent.opentelemetry.api.trace.b.i(this, str, d16);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan updateName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        if (str == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.d(TAG, "Calling updateName() on an ended Span.");
                }
                return this;
            }
            this.name = str;
            return this;
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public void end(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Long.valueOf(j3), timeUnit);
            return;
        }
        if (timeUnit == null) {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        endInternal(j3 == 0 ? this.clock.now() : timeUnit.toNanos(j3));
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan recordException(Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 17, (Object) this, (Object) th5);
        }
        recordException(th5, (Attributes) null);
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setAttribute(String str, long j3) {
        return com.tencent.opentelemetry.api.trace.b.j(this, str, j3);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan setStatus(StatusCode statusCode, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 16, (Object) this, (Object) statusCode, (Object) str);
        }
        if (statusCode == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.d(TAG, "Calling setStatus() on an ended Span.");
                }
                return this;
            }
            this.status = com.tencent.opentelemetry.sdk.trace.data.d.a(statusCode, str);
            return this;
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan recordException(Throwable th5, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 18, (Object) this, (Object) th5, (Object) attributes);
        }
        if (th5 == null) {
            return this;
        }
        if (attributes == null) {
            attributes = com.tencent.opentelemetry.api.common.f.b();
        }
        addTimedEvent(com.tencent.opentelemetry.sdk.trace.internal.data.a.a(this.clock.now(), th5, attributes));
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setAttribute(String str, String str2) {
        return com.tencent.opentelemetry.api.trace.b.k(this, str, str2);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setAttribute(String str, boolean z16) {
        return com.tencent.opentelemetry.api.trace.b.l(this, str, z16);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* bridge */ /* synthetic */ Span setAttribute(AttributeKey attributeKey, Object obj) {
        return setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        if (str == null) {
            return this;
        }
        addTimedEvent(com.tencent.opentelemetry.sdk.trace.data.a.c(this.clock.now(), str, com.tencent.opentelemetry.api.common.f.b(), 0));
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public <T> ReadWriteSpan setAttribute(AttributeKey<T> attributeKey, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 11, (Object) this, (Object) attributeKey, (Object) t16);
        }
        if (attributeKey == null || attributeKey.getKey().isEmpty() || t16 == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.d(TAG, "Calling setAttribute() on an ended Span.");
                }
                return this;
            }
            if (this.attributes == null) {
                this.attributes = new AttributesMap(this.spanLimits.getMaxNumberOfAttributes(), this.spanLimits.getMaxAttributeValueLength());
            }
            this.attributes.put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t16);
            return this;
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 13, this, str, Long.valueOf(j3), timeUnit);
        }
        if (str != null && timeUnit != null) {
            addTimedEvent(com.tencent.opentelemetry.sdk.trace.data.a.c(timeUnit.toNanos(j3), str, com.tencent.opentelemetry.api.common.f.b(), 0));
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) attributes);
        }
        if (str == null) {
            return this;
        }
        if (attributes == null) {
            attributes = com.tencent.opentelemetry.api.common.f.b();
        }
        addTimedEvent(com.tencent.opentelemetry.sdk.trace.data.a.c(this.clock.now(), str, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerEvent(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str, Attributes attributes, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ReadWriteSpan) iPatchRedirector.redirect((short) 15, this, str, attributes, Long.valueOf(j3), timeUnit);
        }
        if (str != null && timeUnit != null) {
            if (attributes == null) {
                attributes = com.tencent.opentelemetry.api.common.f.b();
            }
            addTimedEvent(com.tencent.opentelemetry.sdk.trace.data.a.c(timeUnit.toNanos(j3), str, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerEvent(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        }
        return this;
    }
}
