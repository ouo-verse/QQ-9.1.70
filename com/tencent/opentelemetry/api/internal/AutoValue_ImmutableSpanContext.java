package com.tencent.opentelemetry.api.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.TraceFlags;
import com.tencent.opentelemetry.api.trace.TraceState;
import com.tencent.thumbplayer.api.common.TPErrorType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_ImmutableSpanContext extends ImmutableSpanContext {
    static IPatchRedirector $redirector_;
    private final boolean remote;
    private final String spanId;
    private final TraceFlags traceFlags;
    private final String traceId;
    private final TraceState traceState;
    private final boolean valid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSpanContext(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, traceFlags, traceState, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (str != null) {
            this.traceId = str;
            if (str2 != null) {
                this.spanId = str2;
                if (traceFlags != null) {
                    this.traceFlags = traceFlags;
                    if (traceState != null) {
                        this.traceState = traceState;
                        this.remote = z16;
                        this.valid = z17;
                        return;
                    }
                    throw new NullPointerException("Null traceState");
                }
                throw new NullPointerException("Null traceFlags");
            }
            throw new NullPointerException("Null spanId");
        }
        throw new NullPointerException("Null traceId");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSpanContext)) {
            return false;
        }
        ImmutableSpanContext immutableSpanContext = (ImmutableSpanContext) obj;
        if (this.traceId.equals(immutableSpanContext.getTraceId()) && this.spanId.equals(immutableSpanContext.getSpanId()) && this.traceFlags.equals(immutableSpanContext.getTraceFlags()) && this.traceState.equals(immutableSpanContext.getTraceState()) && this.remote == immutableSpanContext.isRemote() && this.valid == immutableSpanContext.isValid()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public String getSpanId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.spanId;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public TraceFlags getTraceFlags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TraceFlags) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.traceFlags;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public String getTraceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.traceId;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public TraceState getTraceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TraceState) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.traceState;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int hashCode = (((((((this.traceId.hashCode() ^ 1000003) * 1000003) ^ this.spanId.hashCode()) * 1000003) ^ this.traceFlags.hashCode()) * 1000003) ^ this.traceState.hashCode()) * 1000003;
        boolean z16 = this.remote;
        int i16 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        if (z16) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        int i17 = (hashCode ^ i3) * 1000003;
        if (!this.valid) {
            i16 = 1237;
        }
        return i17 ^ i16;
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public boolean isRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.remote;
    }

    @Override // com.tencent.opentelemetry.api.internal.ImmutableSpanContext, com.tencent.opentelemetry.api.trace.SpanContext
    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.valid;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "ImmutableSpanContext{traceId=" + this.traceId + ", spanId=" + this.spanId + ", traceFlags=" + this.traceFlags + ", traceState=" + this.traceState + ", remote=" + this.remote + ", valid=" + this.valid + "}";
    }
}
