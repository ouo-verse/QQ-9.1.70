package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.trace.data.EventData;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import com.tencent.opentelemetry.sdk.trace.data.StatusData;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_SpanWrapper extends SpanWrapper {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final SdkSpan delegate;
    private final long endEpochNanos;
    private final boolean internalHasEnded;
    private final String name;
    private final List<EventData> resolvedEvents;
    private final List<LinkData> resolvedLinks;
    private final StatusData status;
    private final int totalAttributeCount;
    private final int totalRecordedEvents;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SpanWrapper(SdkSpan sdkSpan, List<LinkData> list, List<EventData> list2, Attributes attributes, int i3, int i16, StatusData statusData, String str, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sdkSpan, list, list2, attributes, Integer.valueOf(i3), Integer.valueOf(i16), statusData, str, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (sdkSpan != null) {
            this.delegate = sdkSpan;
            if (list != null) {
                this.resolvedLinks = list;
                if (list2 != null) {
                    this.resolvedEvents = list2;
                    if (attributes != null) {
                        this.attributes = attributes;
                        this.totalAttributeCount = i3;
                        this.totalRecordedEvents = i16;
                        if (statusData != null) {
                            this.status = statusData;
                            if (str != null) {
                                this.name = str;
                                this.endEpochNanos = j3;
                                this.internalHasEnded = z16;
                                return;
                            }
                            throw new NullPointerException("Null name");
                        }
                        throw new NullPointerException("Null status");
                    }
                    throw new NullPointerException("Null attributes");
                }
                throw new NullPointerException("Null resolvedEvents");
            }
            throw new NullPointerException("Null resolvedLinks");
        }
        throw new NullPointerException("Null delegate");
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    Attributes attributes() {
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    SdkSpan delegate() {
        return this.delegate;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    long endEpochNanos() {
        return this.endEpochNanos;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanWrapper)) {
            return false;
        }
        SpanWrapper spanWrapper = (SpanWrapper) obj;
        if (this.delegate.equals(spanWrapper.delegate()) && this.resolvedLinks.equals(spanWrapper.resolvedLinks()) && this.resolvedEvents.equals(spanWrapper.resolvedEvents()) && this.attributes.equals(spanWrapper.attributes()) && this.totalAttributeCount == spanWrapper.totalAttributeCount() && this.totalRecordedEvents == spanWrapper.totalRecordedEvents() && this.status.equals(spanWrapper.status()) && this.name.equals(spanWrapper.name()) && this.endEpochNanos == spanWrapper.endEpochNanos() && this.internalHasEnded == spanWrapper.internalHasEnded()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int hashCode = (((((((((((((((this.delegate.hashCode() ^ 1000003) * 1000003) ^ this.resolvedLinks.hashCode()) * 1000003) ^ this.resolvedEvents.hashCode()) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.totalAttributeCount) * 1000003) ^ this.totalRecordedEvents) * 1000003) ^ this.status.hashCode()) * 1000003) ^ this.name.hashCode()) * 1000003;
        long j3 = this.endEpochNanos;
        int i16 = (hashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        if (this.internalHasEnded) {
            i3 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        } else {
            i3 = 1237;
        }
        return i16 ^ i3;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    boolean internalHasEnded() {
        return this.internalHasEnded;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    String name() {
        return this.name;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    List<EventData> resolvedEvents() {
        return this.resolvedEvents;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    List<LinkData> resolvedLinks() {
        return this.resolvedLinks;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    StatusData status() {
        return this.status;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    int totalAttributeCount() {
        return this.totalAttributeCount;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanWrapper
    int totalRecordedEvents() {
        return this.totalRecordedEvents;
    }
}
