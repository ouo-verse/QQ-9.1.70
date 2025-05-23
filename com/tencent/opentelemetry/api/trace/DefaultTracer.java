package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
final class DefaultTracer implements Tracer {
    static IPatchRedirector $redirector_;
    private static final Tracer INSTANCE;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static final class NoopSpanBuilder implements SpanBuilder {
        static IPatchRedirector $redirector_;

        @Nullable
        private SpanContext spanContext;

        NoopSpanBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
            }
        }

        static NoopSpanBuilder create() {
            return new NoopSpanBuilder();
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder addLink(SpanContext spanContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) spanContext);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAllAttributes(Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) attributes);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public <T> NoopSpanBuilder setAttribute(AttributeKey<T> attributeKey, T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) attributeKey, (Object) t16);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setSpanKind(SpanKind spanKind) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) spanKind);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setStartTimestamp(long j3, TimeUnit timeUnit) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), timeUnit);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public Span startSpan() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (Span) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            if (this.spanContext == null) {
                this.spanContext = b.p().getSpanContext();
            }
            return b.t(this.spanContext);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder addLink(SpanContext spanContext, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) spanContext, (Object) attributes);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 9, this, str, Double.valueOf(d16));
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setNoParent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (NoopSpanBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            this.spanContext = e.g();
            return this;
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setParent(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (NoopSpanBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
            if (context == null) {
                return this;
            }
            this.spanContext = b.q(context).getSpanContext();
            return this;
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public /* synthetic */ SpanBuilder setStartTimestamp(Instant instant) {
            return d.b(this, instant);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3));
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public Span startSpan(ExternalSpanData externalSpanData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Span) iPatchRedirector.redirect((short) 2, (Object) this, (Object) externalSpanData);
            }
            if (this.spanContext == null) {
                this.spanContext = b.p().getSpanContext();
            }
            return b.t(this.spanContext);
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this : (NoopSpanBuilder) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
        }

        @Override // com.tencent.opentelemetry.api.trace.SpanBuilder
        public /* bridge */ /* synthetic */ SpanBuilder setAttribute(AttributeKey attributeKey, Object obj) {
            return setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new DefaultTracer();
        }
    }

    DefaultTracer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Tracer getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.api.trace.Tracer
    public SpanBuilder spanBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        return NoopSpanBuilder.create();
    }
}
