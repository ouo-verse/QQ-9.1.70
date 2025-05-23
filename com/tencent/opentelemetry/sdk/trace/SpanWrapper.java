package com.tencent.opentelemetry.sdk.trace;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.sdk.trace.data.EventData;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import com.tencent.opentelemetry.sdk.trace.data.StatusData;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class SpanWrapper implements SpanData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanWrapper create(SdkSpan sdkSpan, List<LinkData> list, List<EventData> list2, Attributes attributes, int i3, int i16, StatusData statusData, String str, long j3, boolean z16) {
        return new AutoValue_SpanWrapper(sdkSpan, list, list2, attributes, i3, i16, statusData, str, j3, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Attributes attributes();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract SdkSpan delegate();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long endEpochNanos();

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Attributes) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return attributes();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public long getEndEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return endEpochNanos();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public List<EventData> getEvents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return resolvedEvents();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public InstrumentationLibraryInfo getInstrumentationLibraryInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InstrumentationLibraryInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return delegate().getInstrumentationLibraryInfo();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (InstrumentationScopeInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return delegate().getInstrumentationScopeInfo();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public SpanKind getKind() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SpanKind) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return delegate().getKind();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public List<LinkData> getLinks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return resolvedLinks();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return name();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getParentSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpanContext) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return delegate().getParentSpanContext();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public /* synthetic */ String getParentSpanId() {
        return com.tencent.opentelemetry.sdk.trace.data.c.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public Resource getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Resource) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return delegate().getResource();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanContext) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return delegate().getSpanContext();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public /* synthetic */ String getSpanId() {
        return com.tencent.opentelemetry.sdk.trace.data.c.b(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public long getStartEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return delegate().getStartEpochNanos();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public StatusData getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (StatusData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return status();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public int getTotalAttributeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return totalAttributeCount();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedEvents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return totalRecordedEvents();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedLinks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return delegate().getTotalRecordedLinks();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public /* synthetic */ String getTraceId() {
        return com.tencent.opentelemetry.sdk.trace.data.c.c(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.SpanData
    public boolean hasEnded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return internalHasEnded();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean internalHasEnded();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String name();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<EventData> resolvedEvents();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<LinkData> resolvedLinks();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract StatusData status();

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "SpanData{spanContext=" + getSpanContext() + ", parentSpanContext=" + getParentSpanContext() + ", resource=" + getResource() + ", instrumentationLibraryInfo=" + getInstrumentationLibraryInfo() + ", name=" + getName() + ", kind=" + getKind() + ", startEpochNanos=" + getStartEpochNanos() + ", endEpochNanos=" + getEndEpochNanos() + ", attributes=" + getAttributes() + ", totalAttributeCount=" + getTotalAttributeCount() + ", events=" + getEvents() + ", totalRecordedEvents=" + getTotalRecordedEvents() + ", links=" + getLinks() + ", totalRecordedLinks=" + getTotalRecordedLinks() + ", status=" + getStatus() + ", hasEnded=" + hasEnded() + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int totalAttributeCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int totalRecordedEvents();
}
