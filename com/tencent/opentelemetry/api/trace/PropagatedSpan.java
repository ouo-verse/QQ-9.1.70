package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.Scope;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
/* loaded from: classes22.dex */
public final class PropagatedSpan implements Span {
    static IPatchRedirector $redirector_;
    static final PropagatedSpan INVALID;
    private final SpanContext spanContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INVALID = new PropagatedSpan(e.g());
        }
    }

    PropagatedSpan(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spanContext);
        } else {
            this.spanContext = spanContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Span create(SpanContext spanContext) {
        return new PropagatedSpan(spanContext);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span addEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this : (Span) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public void end() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public SpanContext getSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (SpanContext) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.spanContext;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public boolean isRecording() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.context.ImplicitContextKeyed
    public /* synthetic */ Scope makeCurrent() {
        return com.tencent.opentelemetry.context.h.a(this);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span recordException(Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this : (Span) iPatchRedirector.redirect((short) 14, (Object) this, (Object) th5);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span setAllAttributes(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Span) iPatchRedirector.redirect((short) 7, (Object) this, (Object) attributes);
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span setAttribute(AttributeKey attributeKey, int i3) {
        return b.h(this, attributeKey, i3);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span setStatus(StatusCode statusCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this : (Span) iPatchRedirector.redirect((short) 12, (Object) this, (Object) statusCode);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span, com.tencent.opentelemetry.context.ImplicitContextKeyed
    public /* synthetic */ Context storeInContext(Context context) {
        return b.n(this, context);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "PropagatedSpan{" + this.spanContext + '}';
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span updateName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Span) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span addEvent(String str, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this : (Span) iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3), timeUnit);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public void end(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), timeUnit);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span recordException(Throwable th5, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? this : (Span) iPatchRedirector.redirect((short) 15, (Object) this, (Object) th5, (Object) attributes);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public <T> Span setAttribute(AttributeKey<T> attributeKey, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this : (Span) iPatchRedirector.redirect((short) 6, (Object) this, (Object) attributeKey, (Object) t16);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span setStatus(StatusCode statusCode, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this : (Span) iPatchRedirector.redirect((short) 13, (Object) this, (Object) statusCode, (Object) str);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span addEvent(String str, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this : (Span) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) attributes);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ void end(Instant instant) {
        b.e(this, instant);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span setAttribute(String str, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this : (Span) iPatchRedirector.redirect((short) 4, this, str, Double.valueOf(d16));
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span addEvent(String str, Attributes attributes, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? this : (Span) iPatchRedirector.redirect((short) 11, this, str, attributes, Long.valueOf(j3), timeUnit);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span setAttribute(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this : (Span) iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3));
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span addEvent(String str, Attributes attributes, Instant instant) {
        return b.c(this, str, attributes, instant);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span setAttribute(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this : (Span) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public /* synthetic */ Span addEvent(String str, Instant instant) {
        return b.d(this, str, instant);
    }

    @Override // com.tencent.opentelemetry.api.trace.Span
    public Span setAttribute(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this : (Span) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
    }
}
