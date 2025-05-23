package com.tencent.opentelemetry.sdk.trace.internal.data;

import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
abstract class ImmutableExceptionEventData implements ExceptionEventData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableExceptionEventData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExceptionEventData create(long j3, Throwable th5, Attributes attributes) {
        return new AutoValue_ImmutableExceptionEventData(j3, th5, attributes);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    @Memoized
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Attributes) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Throwable exception = getException();
        Attributes additionalAttributes = getAdditionalAttributes();
        AttributesBuilder a16 = f.a();
        a16.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_TYPE, (AttributeKey<String>) exception.getClass().getCanonicalName());
        String message = exception.getMessage();
        if (message != null) {
            a16.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_MESSAGE, (AttributeKey<String>) message);
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            exception.printStackTrace(printWriter);
            printWriter.close();
            a16.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_STACKTRACE, (AttributeKey<String>) stringWriter.toString());
            a16.putAll(additionalAttributes);
            return a16.build();
        } catch (Throwable th5) {
            try {
                printWriter.close();
            } catch (Throwable th6) {
                th5.addSuppressed(th6);
            }
            throw th5;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public /* synthetic */ int getDroppedAttributesCount() {
        return com.tencent.opentelemetry.sdk.trace.data.a.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public final String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "exception";
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public final int getTotalAttributeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return getAttributes().size();
    }
}
